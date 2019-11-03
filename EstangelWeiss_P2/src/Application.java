public class Application {

    public static void main(String[] args) {
        DuplicateCounter duplicateCounter = new DuplicateCounter();
        duplicateCounter.count("PATH TO problem2.txt");
        duplicateCounter.write("PATH TO unique_word_counts.txt");
    }
}
