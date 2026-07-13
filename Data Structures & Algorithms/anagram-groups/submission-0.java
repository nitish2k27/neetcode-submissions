

class Solution {

    public static boolean compare(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();
        boolean[] visited = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {

            if (visited[i]) {
                continue;
            }

            List<String> listName = new ArrayList<>();
            listName.add(strs[i]);
            visited[i] = true;

            for (int j = i + 1; j < strs.length; j++) {

                if (!visited[j] && strs[i].length() == strs[j].length()) {

                    boolean res = compare(strs[i], strs[j]);

                    if (res) {
                        listName.add(strs[j]);
                        visited[j] = true;
                    }
                }
            }

            result.add(listName);
        }

        return result;
    }
}