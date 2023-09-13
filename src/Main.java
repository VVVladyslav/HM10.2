import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException  {

        BufferedReader read = new BufferedReader(new FileReader("d:/1/file.txt"));

        String c;

        BufferedWriter write = new BufferedWriter(new FileWriter("d:/1/user.json"));
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

