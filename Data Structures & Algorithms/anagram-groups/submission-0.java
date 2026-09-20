class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String key = helper(strs[i]);
            if(!hm.containsKey(key)){
                hm.put(key, new ArrayList<>());
            }
            hm.get(key).add(strs[i]);
        }
        List<List<String>> res = new ArrayList<>();
        for(HashMap.Entry<String, List<String>> entry : hm.entrySet()){
            String key = entry.getKey();
            List<String> value = entry.getValue();
            res.add(value);
        }
        return res;
    }
    private String helper(String s){
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
