import org.apache.commons.lang3.RandomStringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class WordGenerator {

    //COMMAND$ java -classpath /home/uriel/www/csvStringGenerator/target/classes:/home/uriel/.m2/repository/org/apache/commons/commons-lang3/3.14.0/commons-lang3-3.14.0.jar WordGenerator
    public static void main (String[] args) throws IOException {
        String filePath = "employeesDBfileInput.csv";
        Integer quantity = 100;

        if (args.length > 0){
            filePath = args[0];
            quantity = parseInt(args[1]);
        }

        String initialTime = new Date().toString();
        FileWriter fos = new FileWriter(filePath);


        for (int i = 0; i < quantity; i ++) {
            String file = "";

            String name = newGeneration((short) 2, (short) 10);
            String last = newGeneration((short) 4, (short) 16);
            int year = (int) (Math.random() * (2006 - 1960)) + 1960;
            int month = (int) (Math.random() * (12 - 1)) + 1;
            int day = (int) (Math.random() * (28 - 1)) + 1;
            int department = (int) (Math.random() * (5 - 1)) + 1;

            file = name + "," + last + "," + year + "-" + month + "-" + day + "," + department + "\n";
            fos.write(file);
        }


        String finishTime = new Date().toString();
        System.out.println("started: " + initialTime + "\nfinished: " + finishTime);
    }

    public static String newGeneration(short min, short max){

        boolean useLetters = true;
        boolean useNumbers = false;
        int rand = (int) (Math.random() * max) + 1;
        rand = rand < min ? min : rand;
        return RandomStringUtils.random(rand, useLetters, useNumbers);
    }
}
