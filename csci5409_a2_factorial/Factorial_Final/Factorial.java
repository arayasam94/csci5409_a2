
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

    public int[] randomNumber() throws IOException {
        int count=0;
        int number = 0;
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int[] id_number = new int[2];

        for(int i=0;i<rand.nextInt(100);i++) {
            count++;
            number=Integer.parseInt(br.readLine()); }

        id_number[0] = count;
        id_number[1] = number;
        return id_number;
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

        long startTime = System.nanoTime();
        Factorial obj = new Factorial();

        obj.fileCreate();
        obj.numberGenerator();

        int[] arr = obj.randomNumber();
        int result = obj.factorial(arr[1]);

        File outputFile = new File("fact_output.txt");
        outputFile.createNewFile();

        FileWriter oWrite = new FileWriter("fact_output.txt");

        long endTime = System.nanoTime();

        long finalTime = endTime-startTime;

        oWrite.write("RequestID: "+(arr[0]+100));
        oWrite.write("\nTime (in nanoseconds): "+finalTime);
        oWrite.write("\nNumber N: "+arr[1]);
        oWrite.write("\nFactorial Result: "+result);

        oWrite.close();
    }
}
