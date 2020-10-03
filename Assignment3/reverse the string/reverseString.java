public class reverseString {
    public String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder res = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ')
                i--;
            res.append(s.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ')
                i--;
            j = i;
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String str = "I am a student of NEU";
        reverseString solution = new reverseString();
        String reverseWords = solution.reverseWords(str);
        System.out.println(reverseWords);
    }
}
