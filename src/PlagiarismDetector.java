public class PlagiarismDetector {
    private static LeastCommonSubSequence LCSS = new LeastCommonSubSequence("Gautam", "Gutman") ;
    public static void main(String args[]){

        System.out.println(LCSS.getSequenceLength()) ;
        System.out.println(LCSS.getSequence()) ;
    }
}
