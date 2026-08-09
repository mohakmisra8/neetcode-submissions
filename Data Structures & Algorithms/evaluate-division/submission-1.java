class Solution {
    public double[] calcEquation(
        List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double v = values[i];

            // get a's neighbour map (make an empty one if it doesn't exist yet)
            // then put b into it and weight v
            map.computeIfAbsent(a, k -> new HashMap<>()).put(b, v);
            map.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / v);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);
            res[i] = dfs(c, d, new HashSet<>(), map);
        }
        return res;
    }

    private double dfs(
        String curr, String target, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if (!graph.containsKey(curr)) {
            return -1.0;
        }
        if (curr.equals(target)) {
            return 1.0;
        }
        visited.add(curr);

        for (Map.Entry<String, Double> nb : graph.get(curr).entrySet()) {
            if (visited.contains(nb.getKey())) {
                continue;
            }

            double sub = dfs(nb.getKey(), target, visited, graph);

            if (sub != -1) {
                return sub * nb.getValue();
            }
        }

        return -1;
    }
}