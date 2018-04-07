import java.lang.Math ;

class LeastCommonSubSequence {

    private String test, corpora;
    private StringBuilder sequence ;

    LeastCommonSubSequence(String test, String corpora){
        this.test = test ;
        this.corpora = corpora ;
        this.sequence = new StringBuilder() ;

    }
    int getSequenceLength(){
        return getSequenceLength(test, corpora) ;
    }

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

    String getSequence(){
        return sequence.toString() ;
    }
}
