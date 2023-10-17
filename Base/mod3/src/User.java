import java.io.Serializable;
import java.util.List;

class User implements Serializable {
    private String name;
    private String login;
    private int age;
    private List<String> hobbies;

    public User(String name, String login, int age, List<String> hobbies) {
        this.name = name;
        this.login = login;
        this.age = age;
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        StringBuilder stringHobbies = new StringBuilder();
        for (String hobby : hobbies) {
            stringHobbies.append(hobby).append("\n");
        }

        return "Пользователь: " + name + " с логином: " + login + ". Его возраст: " + age + ". Все хобби:\n" + stringHobbies;
    }
}