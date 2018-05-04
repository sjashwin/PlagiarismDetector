import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;


public class PlagiarismDetector {
    public static void main(String[] args) throws IOException{

        if (args.length < 2) System.exit(0) ;

        Files.walk(Paths.get(args[1]))
                .filter(Files::isRegularFile)
                .forEach( p -> simulate( args[0], p.toString() ) );

    }

    private static void simulate(String subject, String predicate){
        new KMP(readFile(subject), readFile(predicate)) ;
        new BoyerMoore(readFile(subject), readFile(predicate)) ;
        new NaiveSearch(readFile(subject), readFile(predicate)) ;
        new LeastCommonSubSequence(readFile(subject), readFile(predicate)) ;
    }

    private static String readFile(String filePath){
        try {
            System.out.println("File: "+filePath+" Length: "+Files.readAllBytes(Paths.get(filePath)).length) ;
            return new String(Files.readAllBytes(Paths.get(filePath)));
        }catch(IOException ex){
            System.err.println(ex.getMessage()) ;
        }
        return null ;
    }
}
