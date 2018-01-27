import java.io.*;

public class Main {
    private String inputOLD;
    private String inputNEW;
    private String result = "YES";

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        readFile();
        searchSequence();
        writeFile();
    }

    private void readFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            inputOLD = bufferedReader.readLine().toLowerCase();
            inputNEW = bufferedReader.readLine().toLowerCase();
        } catch (FileNotFoundException e) {
            System.out.println("file or lines not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchSequence(){
        int currentPositionInNEW = 0;

        for (int i = 0; i < inputOLD.length(); i++) {
            char currentLetter = inputOLD.charAt(i);
            currentPositionInNEW = inputNEW.indexOf(currentLetter, currentPositionInNEW);

            if (currentPositionInNEW == -1) {
                result = "NO";
                break;
            } else currentPositionInNEW++;
        }
    }

    private void writeFile(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"))){
            bufferedWriter.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}