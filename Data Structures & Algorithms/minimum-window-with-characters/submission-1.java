class Solution {
  // optimal
  public String minWindow(String s, String t) {
    if (t.length() > s.length())
      return "";

    HashMap<Character, Integer> need = new HashMap<>();
    for (char c : t.toCharArray()) {
      need.put(c, need.getOrDefault(c, 0) + 1);
    }

    HashMap<Character, Integer> window = new HashMap<>();
    int required = need.size();
    int formed = 0;

    int L = 0, R = 0;
    int minLen = Integer.MAX_VALUE;
    int start = 0;

    for (R = 0; R < s.length(); R ++) {
      char c = s.charAt(R);
      window.put(c, window.getOrDefault(c, 0) + 1);

      if (need.containsKey(c) && need.get(c).intValue() == window.get(c).intValue())
        formed ++;
      
      // try shrinking
      while (L <= R && formed == required) {
        if (R-L+1 < minLen) {
          minLen = R-L+1;
          start = L;
        }

        char left = s.charAt(L);
        window.put(left, window.get(left)-1);

        if (need.containsKey(left) && window.get(left) < need.get(left))
          formed --;
        
        L ++;
      }
    }

    return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
  }
}