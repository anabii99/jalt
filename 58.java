class Solution {
    public int lengthOfLastWord(String s) {
        int p = s.length() - 1;
        while (p >= 0 && s.charAt(p) == ' ')
            p--;
        int end = p;
        while (p >= 0 && s.charAt(p) != ' ')
            p--;
        return end - p;
    }

}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("word "));
        System.out.println(solution.lengthOfLastWord("hello world"));
    }
}