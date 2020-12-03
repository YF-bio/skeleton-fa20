public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> result = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            result.addLast(word.charAt(i));
        }
        return result;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> list = wordToDeque(word);
        return isPalindromeHelper(list);
    }

    public boolean isPalindromeHelper(Deque<Character> list) {
        if (list.size() <= 1) {
            return true;
        } else if (list.removeLast() == list.removeFirst()) {
            return isPalindromeHelper(list);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int n = word.length() / 2;
        Deque<Character> result = wordToDeque(word);
        for (int i = 0; i < n; i++) {
            char first = result.removeFirst();
            char last = result.removeLast();
            if (!cc.equalChars(first, last)) {
                return false;
            }
        }
        return true;
    }
}
