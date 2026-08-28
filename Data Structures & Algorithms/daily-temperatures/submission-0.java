class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            for(int j = i + 1; j < temperatures.length; j++){
                if(temperatures[i] < temperatures[j]){
                    int day = j - i;
                res[i] = day;
                // as soon as u got it break stop
                break;
                }else{
                    res[i] = 0;
                }
            }
        }
        return res;
    }
}
