public class NeedleHaystack {

    public int strStr(String haystack, String needle) {

        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();

        if(n.length ==0) return 0;

        for(int i=0; i < h.length-n.length; i++){

            int j=0;
            while(j<n.length && h[i+j]==n[j])
                j++;
            if(j==n.length)
                return i;
        }
        return -1;
    }

    public static int strStr1(String haystack, String needle){
        return haystack.indexOf(needle);
    }

    public static int strStr2(String haystack, String needle){

        if(needle.length()==0) return 0;

        int nlen = needle.length();
        int hlen = haystack.length();
        for(int i=0; i<hlen - nlen; i++){
            if(haystack.substring(i, i+nlen).equals(needle))
                return i;
        }

        return -1;
    }
    
}
