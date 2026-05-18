public class StringToInteger {

    public static int convert(String s){
        int length = s.length();
        if(length==0) return 0;

        int i=0;
        boolean isNegative = false;
        int result =0;
        while(i<length && s.charAt(i)==' '){
            i++;
        }
        if(i<length){
            if (s.charAt(i)=='+')
                i++;
            else if(s.charAt(i)=='-'){
                isNegative = true;
                i++;
            }
        }

        while(i<length && isDigit(s.charAt(i))){
            int digit = s.charAt(i) - '0';
            if(result > ((Integer.MAX_VALUE - digit) / 10))
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            result = result * 10 + digit;
            i++;
        }
        return isNegative? -result : result;
    }
    private static boolean isDigit(char ch){
        return ch >= '0' && ch <= '9';
    }
    
    public static void main(String[] args){
        System.out.println(StringToInteger.convert("123abc12"));
    }
}
