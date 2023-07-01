package helper;

import com.google.gson.Gson;
import model.Product;
import org.openqa.selenium.json.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ProductHelper {
    public static Product getProductByName(String name){
        Product product = null;
        Gson gson = new Gson();
        ArrayList<Product> listProducts = new ArrayList<>();
        try {
            FileReader reader = new FileReader("src\\test\\resources\\data\\Product.json");
            Type type = new TypeToken<ArrayList<Product>>() {
            }.getType();
            listProducts = gson.fromJson(reader, type);

            for (int i = 0; i < listProducts.size(); i++) {

                Product temp = listProducts.get(i);

                if (temp.name.equalsIgnoreCase(name)) {
                    product = temp;
                    break;
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return product;
    }
}
