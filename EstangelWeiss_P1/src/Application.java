public class Application {

    public static void main(String[] args) {
        DuplicateRemover remover = new DuplicateRemover();

        remover.remove("PATH TO problem1.txt");
        remover.write("PATH TO unique_words.txt");
    }
}