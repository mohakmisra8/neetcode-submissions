class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind uf = new UnionFind();

        for(int i=0; i< equations.size();i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            uf.add(a);
            uf.add(b);
            uf.union(a,b,values[i]);
        }

        double[] res = new double[queries.size()];
        for(int i =0; i< queries.size();i++) {
            String p = queries.get(i).get(0);
            String q = queries.get(i).get(1);

            // unseen variable or not connect -> -1.0
            if(!uf.contains(p) || !uf.contains(q) || uf.find(p) != uf.find(q)) {
                res[i] = -1.0;
            } else {
                res[i] = uf.weight.get(p)/uf.weight.get(q);
            }
        }
        return res;
        
    }
    class UnionFind {
        Map<String, String> parent = new HashMap<>();
        Map<String, Double> weight = new HashMap<>(); // weight = value(x)/value(parent[x])

        public void add(String x) {
            if(!parent.containsKey(x)) {
                parent.put(x,x);
                weight.put(x,1.0);
            }
        }

        public boolean contains(String x) {
            return parent.containsKey(x);
        }

        public String find(String x) {
            if(!parent.get(x).equals(x)) {
                String origParent = parent.get(x);
                String root = find(origParent);
                // [path compression with weight update
                // x/root = (x/origParent)*(origParent/root)
                weight.put(x, weight.get(x)*weight.get(origParent));
                parent.put(x, root);
            }
            return parent.get(x);
        }

        public void union(String a, String b, double value) {
            String rootA = find(a);
            String rootB = find(b);
            if(rootA.equals(rootB)) {
                return;
            }

            // link rootA under rootB, set is weight so a/b value holds
            // a/b = value, weight[a] = a/rootA, weight[b] = b/rootB
            // want weight[rootA] = rootA/rootB
            // = value * weight[b]/weight[a]

            weight.put(rootA, value * weight.get(b)/ weight.get(a));
            parent.put(rootA, rootB);

        }


    }
}