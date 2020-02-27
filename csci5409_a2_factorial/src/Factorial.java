import java.io.*;
import java.util.Random;

public class Factorial {

    Random rand = new Random();

    public void fileCreate() throws IOException {
        File createFile = new File("input.txt");
        createFile.createNewFile();

    }

    public void numberGenerator() throws IOException {

        FileWriter fWrite = new FileWriter("input.txt");

        for(int i=0;i<100;i++)
        {
            int rNumber = rand.nextInt(10);
            fWrite.write(String.valueOf(rNumber));
            fWrite.write("\n");
        }

        fWrite.close();
    }

    public int randomNumber() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int number = 0;

        for(int i=0;i<rand.nextInt(100);i++) {
            number=Integer.parseInt(br.readLine()); }

        return number;
    }

    public int factorial(int number) {
        int fact = 1;
        if(number == 0 || number ==1) {
            return fact;
        }
        else {
            for(int i=1;i<=number;i++) {
                fact = fact*i;
            }
            return fact;
        }
    }

    public static void main(String[] args) throws IOException {

        Factorial obj = new Factorial();

        obj.fileCreate();
        obj.numberGenerator();

        int number = obj.randomNumber();
        int result = obj.factorial(number);

        System.out.println("Number: "+number);
        System.out.println("Factorial Result: "+result);

    }
}
