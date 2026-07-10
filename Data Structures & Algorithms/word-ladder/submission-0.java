class Pair {
  String word;
  int cnt;

  Pair(String word, int cnt) {
    this.word = word;
    this.cnt = cnt;
  }
}

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    HashSet<String> set = new HashSet<>(wordList);
    set.remove(beginWord);

    if (!set.contains(endWord))
      return 0;

    Queue<Pair> que = new ArrayDeque<>();
    que.offer(new Pair(beginWord, 1));

    while (!que.isEmpty()) {
      Pair pair = que.poll();
      String currWord = pair.word;
      int currCnt = pair.cnt;

      // The first match is gurranteed to be the shortest
      if (currWord.equals(endWord)) {
        return currCnt;
      }

      for (int i = 0; i < currWord.length(); i++) {
        char[] charArr = currWord.toCharArray();

        for (int j = 0; j < 26; j++) {
          charArr[i] = (char) ('a' + j);
          String newWord = String.valueOf(charArr);

          if (set.contains(newWord)) {
            que.offer(new Pair(newWord, currCnt + 1));
            set.remove(newWord);
          }
        }
      }
    }
    return 0;
  }
}