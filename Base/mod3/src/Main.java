import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите имя: ");
            String name = scanner.nextLine();

            System.out.print("Введите логин: ");
            String login = scanner.nextLine();

            System.out.print("Введите возраст: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите хобби через запятую");
            String hobby = scanner.nextLine();
            List<String> hobbies = new ArrayList<>(Arrays.asList(hobby.split(",")));

            User newUser = new User(name, login, age, hobbies);

            FileOutputStream fos = new FileOutputStream("user.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(newUser);

            FileInputStream fis = new FileInputStream("user.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            User user = (User) ois.readObject();
            ois.close();
            fis.close();

            System.out.println(user);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}