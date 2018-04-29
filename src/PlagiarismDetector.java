import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PlagiarismDetector {
    private static LeastCommonSubSequence LCSS = new LeastCommonSubSequence("Gautam", "Gutman") ;
    public static void main(String args[]){
        if (args.length > 1){
            new KMP(readFile(args[0]), readFile(args[1])) ;
        }
        System.out.println(LCSS.getSequenceLength()) ;
        System.out.println(LCSS.getSequence()) ;
        new KMP("AABAACAADAABAABA", "AABA") ;
        new KMP("Gautam", "ut") ;
        new NaiveSearch("AABAACAADAABAABA", "AABA") ;
    }
    private static String readFile(String filePath){
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        }catch(IOException ex){
            System.err.println(ex.getMessage()) ;
        }
        return null ;
    }
}
