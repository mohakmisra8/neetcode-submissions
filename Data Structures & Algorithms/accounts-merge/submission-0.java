class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();
        Map<String, String> owner = new HashMap<>(); // email -> account name

        // register every email and union all emails within each amount
        for(List<String> acc: accounts) {
            String name = acc.get(0);
            String first = acc.get(1);
            uf.add(first);
            owner.put(first, name);
            for(int i = 2; i< acc.size();i++) {
                String email = acc.get(i);
                uf.add(email);
                owner.put(email, name);
                uf.union(first, email); // link every email to the account's first
            }
        }

        Map<String, TreeSet<String>> groups = new HashMap<>();
        for(String email: owner.keySet()) {
            String root = uf.find(email);
            groups.computeIfAbsent(root, x -> new TreeSet<>()).add(email);
        }

        List<List<String>> res = new ArrayList<>();
        for(String root: groups.keySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(owner.get(root));
            merged.addAll(groups.get(root));
            res.add(merged);
        }

        return res;

        
    }

    class UnionFind {
        private Map<String, String> parent = new HashMap<>();
        
        private void add(String x) {
            parent.putIfAbsent(x, x);
        }

        private String find(String x) {
            if(!parent.get(x).equals(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        private void union(String a, String b) {
            String rootA = find(a);
            String rootB = find(b);
            if(!rootA.equals(rootB)) {
                parent.put(rootA, rootB);
            }
        }
    }
}