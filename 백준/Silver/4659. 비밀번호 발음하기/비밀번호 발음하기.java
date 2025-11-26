import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while(!(input= br.readLine()).equals("end")) {
            if(!validate(input)) {
                System.out.println("<"+input+"> is not acceptable.");
            }
            else {
                System.out.println("<"+input+"> is acceptable.");
            }
        }
    }

    private static boolean validate(String input) {
        boolean step1 = false;
        boolean step2 = true;
        boolean step3 = true;
        int vowelCount = 0;
        int consonantCount = 0;
        char prev = '#';
        for(char c : input.toCharArray()) {
            boolean isVowel = false;
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') isVowel = true;

            if(isVowel) step1 = true;

            if(isVowel) {
                vowelCount++;
                consonantCount = 0;
            }
            else {
                vowelCount = 0;
                consonantCount++;
            }

            if(vowelCount >= 3 || consonantCount >= 3) {
                step2 = false;
            }

            if(prev == c) {
                if(c != 'e' && c != 'o') {
                    step3 = false;
                }
            }
            prev = c;
        }
        return step1 && step2 && step3;
    }
}
