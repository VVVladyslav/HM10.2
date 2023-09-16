import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException  {

        BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));

        String line1 = "name age\n";
        String line2 = "alice 21\n";
        String line3 = "ryan 30\n";

        writer.write(line1);
        writer.write(line2);
        writer.write(line3);
        writer.close();

        BufferedReader read = new BufferedReader(new FileReader("file.txt"));

        String c;

        BufferedWriter write = new BufferedWriter(new FileWriter("user.json"));
        write.write("[\n");

        boolean flag = false;
        boolean gg = true;

        while ((c = read.readLine()) != null){

            if (gg){
                gg = false;
                continue;
            }

            if(flag){
                write.write(",");
            }
            flag = true;
            String[] resulttt = c.split(" ");

            Person person = new Person(resulttt[0], resulttt[1]);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(person);

            write.write(json);
        }
        write.write("\n]");
        write.close();
    }
}
class Person {
    private String name;
    private String age;


    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}

