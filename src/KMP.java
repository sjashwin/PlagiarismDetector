import java.util.HashMap ;

public class KMP {
    private String text, pattern ;
    private HashMap<Integer, Integer> auxillary ;
    KMP(String text, String pattern){
        this.text = text ;
        this.pattern = pattern ;
        System.out.println(pattern.length());
        auxillary = pre_processing(pattern) ;
        search();
    }

    void search(){
        int index = 0, pointer = 0 ;
        while ( index < text.length()) {
            if( pattern.charAt(pointer) == text.charAt(index)) {
                index++;
                pointer++;
            }
            if( pointer == pattern.length()){
                System.out.println("Found Pattern at index"+(index-pointer)) ;
                pointer = auxillary.get(pointer-1) ;
            }
            else if(index < text.length() && pattern.charAt(pointer) != text.charAt(index)){
                /*
                 * Sliding the window.
                 */
                if( pointer != 0)
                    pointer = auxillary.get(pointer-1) ;
                else
                    index++ ;
            }
        }

    }
    private HashMap<Integer, Integer> pre_processing(String pattern){
        int value = 0 , key = 1;
        HashMap<Integer, Integer> auxillary = new HashMap<>();
        auxillary.put(0, 0) ;
        while(key < pattern.length()){
           if( pattern.charAt(key) == pattern.charAt(value) ){
               value++;
               auxillary.put(key, value) ;
               key++;
           }
           else{
               if(value != 0)
                   value = auxillary.get((value - 1)) ;
               else{
                   auxillary.put(key, value) ;
                   key++ ;
               }
           }
        }

        return auxillary ;
    }

}
