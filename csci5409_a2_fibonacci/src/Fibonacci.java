import java.io.*;
import java.util.Random;

// https://beginnersbook.com/2017/09/java-program-to-display-fibonacci-series-using-loops/

public class Fibonacci {

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

    public String fibonacci(int number) {
        int first = 0;
        int second = 1;
        int sum = 0;
        String result = "";

        if (number == 0 || number == 1) {
            result = Integer.toString(first);
        }
        else {
            for (int i = 1; i <= number; i++) {
                if(i!=number)
                    result = result.concat(Integer.toString(first)+",");
                else
                    result = result.concat(Integer.toString(first));

                sum = first+second;
                first = second;
                second = sum;
            }
        }
       return result;
    }

    public static void main(String[] args) throws IOException {
        Fibonacci obj = new Fibonacci();

        obj.fileCreate();
        obj.numberGenerator();

        int number = obj.randomNumber();
        String result = obj.fibonacci(number);

        System.out.println("Number: "+number);
        System.out.println("Fibonacci Series Result: "+result);
    }
}
