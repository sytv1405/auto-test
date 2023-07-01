package helper;

import com.google.gson.Gson;
import model.Category;
import org.openqa.selenium.json.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class CategoryHelper {
    public static Category getCategoryByName(String name){
        Category category = null;
        Gson gson = new Gson();
        ArrayList<Category> listCategories = new ArrayList<>();
        try {
            FileReader reader = new FileReader("src\\test\\resources\\data\\Category.json");
            Type type = new TypeToken<ArrayList<Category>>() {
            }.getType();
            listCategories = gson.fromJson(reader, type);

            for (int i = 0; i < listCategories.size(); i++) {

                Category temp = listCategories.get(i);

                if (temp.getName().equalsIgnoreCase(name)) {
                    category = temp;
                    break;
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return category;
    }
}
