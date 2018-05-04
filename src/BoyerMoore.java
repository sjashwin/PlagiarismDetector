import java.util.Arrays;

class BoyerMoore{

    private String text, pattern ;

    BoyerMoore(String text, String pattern){
        long start = System.currentTimeMillis() ;
        this.text = text ;
        this.pattern = pattern ;
        search() ;
        System.out.println("Time Elapsed :" + String.valueOf(System.currentTimeMillis()-start)) ;
    }

    private int[] badCharacterHeuristic(String pattern){
        int badChar[] = new int[256] ;
        Arrays.fill(badChar, -1);
        for( int i=0; i< pattern.length(); i++){
            int index = Character.getNumericValue( pattern.charAt(i)) ;
            badChar[index] = i ;
        }
        return badChar ;
    }

    void search(){
        int[] badChar = badCharacterHeuristic(pattern) ;
        int s = 0, j ;
        while( s<= text.length()-pattern.length()){
            j = pattern.length()-1 ;
            while(j >= 0 && pattern.charAt(j) == text.charAt(s+j)){
                j -- ;
            }
            if(j < 0){
                System.out.println(String.format("Pattern occured at shift={%d}", s)) ;
                if (s+pattern.length()<text.length())
                    s+=(pattern.length()-badChar[Character.getNumericValue(text.charAt(s+pattern.length()))]) ;
                else
                    s+=1 ;
            }
            else{
                s+=Math.max(1, j-badChar[Character.getNumericValue(text.charAt(s+j))]) ;
            }
        }
    }
}
