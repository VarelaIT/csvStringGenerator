import org.apache.commons.lang3.RandomStringUtils;

public class WrodGerenrator {
    public static void main (String[] argas){

        final int quantity = 100;
        String file = "";

        for (int i = 0; i < quantity; i ++) {
            String name = newGeneration((short) 2, (short) 10);
            String last = newGeneration((short) 4, (short) 16);
            int age = (int) (Math.random() * 60) + 1;
            age = age < 18 ? 18 : age;
            file = file + name + "," + last + "," + age + "\n";
        }

        System.out.println(file);
    }

    public static String newGeneration(short min, short max){

        boolean useLetters = true;
        boolean useNumbers = false;
        int rand = (int) (Math.random() * max) + 1;
        rand = rand < min ? min : rand;
        return RandomStringUtils.random(rand, useLetters, useNumbers);
    }
}
