class Solution {
    public int solution(String rawStr) {
        int answer = rawStr.length();
        for(int len=1; len<=rawStr.length()/2; len++) {
            int count = 0;
            String s = new String(rawStr);
            while(s.length() >= 2*len) {
                int compressCount = 1;
                String prev = s.substring(0,len);
                s = s.substring(len, s.length());            
                while(s.length() >= len) {
                    if(s.substring(0, len).equals(prev)) {
                        compressCount++;
                        s = s.substring(len, s.length()); 
                    }
                    else {
                        break;
                    }
                }
                if(compressCount == 1) count += len;
                else count += String.valueOf(compressCount).length()+len;
            }
            count += s.length();
            answer = Math.min(answer, count);
        }
        
        return answer;
        
    }
}