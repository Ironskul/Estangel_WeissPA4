import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DuplicateCounter {

    Map<String, Integer> wordCounter;

    DuplicateCounter(){
        wordCounter = new HashMap<>();
    }

    void count(String dataFile){
        // read the file with by giving the file name
        try (BufferedReader br = new BufferedReader(new FileReader(new File(dataFile)))) {
            // read lines from the file until line is null
            for (String line; (line = br.readLine()) != null; ) {
                // process the line.
                for(String word : line.split(" ")){
                    int count = 0;
                    if(wordCounter.containsKey(word)){
                        count = wordCounter.get(word);
                    }
                    wordCounter.put(word,count+1);
                }
            }
        } catch (IOException ex) {
            // print the exception
            System.out.println(ex.getLocalizedMessage());
        }
    }

    void write(String outputFile){
        StringBuilder builder = new StringBuilder();
        for(String key : wordCounter.keySet()){
            builder.append(key).append(" : ").append(wordCounter.get(key)).append("\n");
        }

        try {
            Files.write(Paths.get(outputFile), builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}