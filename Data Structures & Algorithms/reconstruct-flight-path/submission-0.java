class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // greedy: dfs +post order
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> t: tickets) {
            graph.putIfAbsent(t.get(0), new PriorityQueue<>());
            graph.get(t.get(0)).offer(t.get(1));
        }

        LinkedList<String> route = new LinkedList<>();
        dfs("JFK", graph, route);
        return route;
    }

    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, LinkedList<String> route) {
        PriorityQueue<String> destinations = graph.get(airport);
        while(destinations != null && !destinations.isEmpty()) {
            String next = destinations.poll(); // consumes ticket
            dfs(next, graph, route);
        }
        // no more outgoing edges -> this airport is where we got stick -> prepend
        route.addFirst(airport);
    }
}
