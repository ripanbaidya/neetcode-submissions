class Solution {
  public List<String> findItinerary(List<List<String>> tickets) {
    Map<String, List<String>> map = new HashMap<>();
    
    for (List<String> ticket : tickets) {
      map.putIfAbsent(ticket.get(0), new ArrayList<>());
      map.get(ticket.get(0)).add(ticket.get(1));
    }

    // sort each destination list lexographically
    for (List<String> dest : map.values()) {
      Collections.sort(dest);
    }

    List<String> result = new ArrayList<>();
    result.add("JFK");

    dfs("JFK", map, result, tickets.size());
    return result;
  }

  private boolean dfs(String src, Map<String, List<String>> map, List<String> result, int totalTickets) {

    if (result.size() == totalTickets+1)
      return true;

    if (!map.containsKey(src))
      return false;

    List<String> dest = map.get(src);
    for (int i = 0; i < dest.size(); i ++) {
      String temp = dest.get(i);

      dest.remove(i);
      result.add(temp);

      if (dfs(temp, map, result, totalTickets))
        return true;
      
      result.remove(result.size()-1);
      dest.add(i, temp);
    }
    
    return false;
  }
}