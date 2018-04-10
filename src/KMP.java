import java.util.HashMap ;

class KMP {
    private String text, pattern ;
    private HashMap<Integer, Integer> auxiliary;

    /**
     *
     * Default Constructor. Builds the pre-processed table.
     *
     * @param text Corpora in which the pattern is to be found.
     * @param pattern Pattern which is to be found in the corpora.
     */
    KMP(String text, String pattern){
        this.text = text ;
        this.pattern = pattern ;
        auxiliary = pre_processing(pattern) ;
        search();
    }

    /**
     *
     * Search for the given pattern in the given corpora.
     * If pattern is found. It will return its index.
     *
     */
    private void search(){
        int index = 0, pointer = 0, found = 0 ;
        while ( index < text.length()) {
            if( pattern.charAt(pointer) == text.charAt(index)) {
                /*
                If the current character matches a character in the pattern.
                 */
                index++;
                pointer++;
            }
            if( pointer == pattern.length()){
                /*
                If a pattern has been found.
                 */
                found++ ;
                System.out.println("Found Pattern at index: "+(index-pointer)) ;
                pointer = auxiliary.get(pointer-1) ;
            }
            else if( index < text.length() && (pattern.charAt(pointer) != text.charAt(index))){
                /*
                 * Sliding the window.
                 */
                if( pointer != 0)
                    pointer = auxiliary.get(pointer-1) ;
                else
                    index++ ;
            }
        }
        if ( found ==0 )
            System.out.println("Pattern cannot be found.");
    }

    /**
     *
     * The failure function in Knuth-Morris-Pratt algorithm. To not match a single character more than once.
     *
     * @param pattern Given pattern to be matched.
     * @return preprocessed table (array).
     */
    private HashMap<Integer, Integer> pre_processing(String pattern){
        int value = 0 , key = 1;
        HashMap<Integer, Integer> auxiliary = new HashMap<>();

        auxiliary.put(0, 0) ;

        while(key < pattern.length()){
           if( pattern.charAt(key) == pattern.charAt(value) ){
               value++;
               auxiliary.put(key, value) ;
               key++;
           }
           else{
               if(value != 0)
                   value = auxiliary.get((value - 1)) ;
               else{
                   auxiliary.put(key, value) ;
                   key++ ;
               }
           }
        }
        return auxiliary ;
    }
}
