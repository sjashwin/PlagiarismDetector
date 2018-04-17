import java.lang.Math ;

class LeastCommonSubSequence {

    private String test, corpora;
    private StringBuilder sequence ;

    /**
     *
     * @param s1 Text 1 which is to be matched for the sequence.
     * @param s2 Text 2 which is to be matched for the sequence.
     */
    LeastCommonSubSequence(String s1, String s2){
        this.test = s1 ;
        this.corpora = s2;
        this.sequence = new StringBuilder() ;

    }

    /**
     *
     * @return length of the smallest sequence.
     */
    int getSequenceLength(){
        return getSequenceLength(test, corpora) ;
    }

    /**
     *
     * @param test the sequence that is to be found.
     * @param corpora the text in which the sequence is to be found.
     * @return the length of the sequence.
     */
    private int getSequenceLength(String test, String corpora){

        if ( test.length() == 0 || corpora.length() == 0)
            return 0 ;

        if (test.charAt(0) == corpora.charAt(0)) {
            if (!sequence.toString().contains(Character.toString(test.charAt(0))))
                sequence.append(test.charAt(0)) ;
            return 1 + getSequenceLength(
                    (new StringBuilder(test).deleteCharAt(0).toString()),
                    (new StringBuilder(corpora).deleteCharAt(0).toString()));
        }

        else
            return Math.max(
                    getSequenceLength(test, (new StringBuilder(corpora).deleteCharAt(0).toString())),
                    getSequenceLength(new StringBuilder(test).deleteCharAt(0).toString(), corpora)) ;
    }

    /**
     *
     * @return the smallest sequence as a String.
     */
    String getSequence(){
        return sequence.toString() ;
    }
}
