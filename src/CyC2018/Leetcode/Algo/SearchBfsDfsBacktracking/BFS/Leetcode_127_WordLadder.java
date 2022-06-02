package CyC2018.Leetcode.Algo.SearchBfsDfsBacktracking.BFS;

import java.util.*;

/**
 * 先读题，把题目读明白，读懂了以后，其实我们就可以建模了
 *
 * 最短路径 + 无权图 -> BFS
 *
 * 思路：
 * 首先建图，这个无权图的各个点是各个单词，然后单词直接如果只差一个字母就可以连一条线
 * 建好图之后，从 beginWord 开始搜索，找到 endWord 即可
 *
 * 关于怎么存这个图，我的想法是一个 hashmap ，key 是 word，value 是一个 List<String> 即与之连通的 word
 *
 * 思路完全正确，虽然用时极长，但是轻松过了一道 hard ！！！！！
 *
 * （一个小坑，建图那里不要用 List 的 clear 函数，要每次都重新 new List，这样保证每次弄出来的都是新的）
 * */
public class Leetcode_127_WordLadder {
    HashMap<String, List<String>> graph = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        buildGraph(beginWord, wordList);
        int ans = 0;
        Deque<String> myQueue = new LinkedList<>();
        Set<String> flagSet = new HashSet<>();
        myQueue.add(beginWord);
        while (!myQueue.isEmpty()) {
            ans++;
            int size = myQueue.size();
            while (size-- > 0) {
                String curr = myQueue.poll();
                if (flagSet.contains(curr)) continue;
                if (differentChars(curr, endWord) == 0) return ans;
                List<String> nextLevel = graph.get(curr);
                for (String s:nextLevel) myQueue.add(s);
                flagSet.add(curr);
            }
        }
        return 0;
    }
    private void buildGraph (String beginWord, List<String> wordList) {
        List<String> firstLevel = new LinkedList<>();
        for (String s: wordList) {
            if (differentChars(beginWord, s) == 1) firstLevel.add(s);
        }
        graph.put(beginWord, firstLevel);
        int size = wordList.size();
        for (int i = 0; i < size; i++) {
            List<String> otherLevel = new LinkedList<>();
            String curr = wordList.get(i);
            if (graph.containsKey(curr)) continue;
            for (String s: wordList) {
                if (differentChars(curr, s) == 1) otherLevel.add(s);
            }
            graph.put(curr, otherLevel);
        }
    }
    private int differentChars (String firstWord, String secondWord) {
        int ans = 0;
        int length = firstWord.length();
        for (int i = 0; i < length; i++) {
            if (firstWord.charAt(i) != secondWord.charAt(i)) ans++;
        }
        return ans;
    }

    /**
     * 一些优化思路，如果标记从 hashset 换成 boolean array 应该会变快
     * 哈希的东西变成确定的数组能让算法快一些些
     * */

    /**
     * Cyc 也是这个思路，只是写法不同，比我快一些，但仍然处于比较慢的水平
     * */

    /**
     * 一个 Leetcode 大神的优化方式是：
     *      双向 BFS + 标记优化 + 单词转换判断的优化（降低重复工作，尽量不要有重复工作，最好只做一遍，把结果保存下来，随时查用）
     *
     *
     *      判断当前单词可以转换成哪些候选单词（未访问的单词），有两种思路：
     *
     *      思路1：遍历所有候选单词，判断当前单词是否可以转换成这个候选单词。判断的过程也就是前面的canConvert方法，逐个对比单词的字符。
     *
     *      思路2：因为单词是由 a~z 这有限数量的字符组成的，可以遍历当前单词能转换成的所有单词，判断其是否包含在候选单词中。候选单词用 HashSet 保存，可以大大提高判断包含关系的性能。
     *
     *      最大的优化的点就在于这个单词转换判断的优化，没有复杂的数据结构了，最多用到一个 hashSet.contains
     *
     * */

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int end = wordList.indexOf(endWord);
        if (end == -1) return 0; // 如果 endWord 不在 wordList 里，直接返回 0
        wordList.add(beginWord); // beginWord 直接加到 wordList 里即可

        // 从两端 BFS 遍历要用的队列
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        // 两端已经遍历过的节点
        Set<String> visited1 = new HashSet<>();
        Set<String> visited2 = new HashSet<>();
        queue1.offer(beginWord);
        queue2.offer(endWord);
        visited1.add(beginWord);
        visited2.add(endWord);

        int count = 0;
        Set<String> allWordSet = new HashSet<>(wordList); // 所有的单词

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            count++;
            if (queue1.size() > queue2.size()) { // 如果从起点开始 BFS 的 queue1 长，就两个队列交换，BFS 永远都是 queue1，但有时是向下有时是向上
                Queue<String> tmp = queue1;
                queue1 = queue2;
                queue2 = tmp;
                Set<String> t = visited1;
                visited1 = visited2;
                visited2 = t;
            }
            int size1 = queue1.size(); // 开始正常从起点 BFS
            while (size1-- > 0) {
                String s = queue1.poll();
                char[] chars = s.toCharArray();
                for (int j = 0; j < s.length(); ++j) {
                    // 保存第j位的原始字符
                    char c0 = chars[j];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[j] = c;
                        String newString = new String(chars);
                        // 已经访问过了，跳过
                        if (visited1.contains(newString)) {
                            continue;
                        }
                        // 两端遍历相遇，结束遍历，返回 count
                        if (visited2.contains(newString)) {
                            return count + 1;
                        }
                        // 如果单词在列表中存在，将其添加到队列，并标记为已访问
                        if (allWordSet.contains(newString)) {
                            queue1.offer(newString);
                            visited1.add(newString);
                        }
                    }
                    // 恢复第j位的原始字符
                    chars[j] = c0;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Leetcode_127_WordLadder solu  = new Leetcode_127_WordLadder();
        List<String> myList = new LinkedList<>();
        myList.add("hot");
        myList.add("dot");
        myList.add("dog");
        myList.add("lot");
        myList.add("log");
        myList.add("cog");
        solu.ladderLength("hit", "cog", myList);
    }
}
