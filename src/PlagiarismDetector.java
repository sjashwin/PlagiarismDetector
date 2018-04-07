public class PlagiarismDetector {
    private static LeastCommonSubSequence LCSS = new LeastCommonSubSequence("AGGTAB", "GXTXAYB") ;
    public static void main(String args[]){

        System.out.println(LCSS.getSequenceLength()) ;
        System.out.println(LCSS.getSequence()) ;
    }
}
