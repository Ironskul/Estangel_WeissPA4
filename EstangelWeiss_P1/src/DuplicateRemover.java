import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DuplicateRemover {

    private Set<String> uniqueWords;

    DuplicateRemover(){
        uniqueWords = new HashSet<String>();
    }

    void remove(String dataFile){
        // read the file with by giving the file name
        try (BufferedReader br = new BufferedReader(new FileReader(new File(dataFile)))) {
            // read lines from the file until line is null
            for (String line; (line = br.readLine()) != null; ) {
                // process the line.
                Collections.addAll(uniqueWords, line.split(" "));
            }
        } catch (IOException ex) {
            // print the exception
            System.out.println(ex.getLocalizedMessage());
        }
    }

    void write(String outputFile){
        StringBuilder buffer = new StringBuilder();
        for(String word:uniqueWords){
            buffer.append(word).append(" ");
        }

        try {
            Files.write(Paths.get(outputFile), buffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
