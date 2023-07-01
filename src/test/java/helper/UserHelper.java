package helper;

import com.google.gson.Gson;
import model.User;
import org.openqa.selenium.json.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class UserHelper {
    public static User getUserByEmail(String email){
        User userData = null;
        Gson gson = new Gson();
        ArrayList<User> listUsers = new ArrayList<>();
        try {
            FileReader reader = new FileReader("src\\test\\resources\\data\\User.json");
            Type type = new TypeToken<ArrayList<User>>() {
            }.getType();
            listUsers = gson.fromJson(reader, type);

            for (int i = 0; i < listUsers.size(); i++) {

                User temp = listUsers.get(i);

                if (temp.email.equalsIgnoreCase(email)) {
                    userData = temp;
                    break;
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return userData;
    }

}
