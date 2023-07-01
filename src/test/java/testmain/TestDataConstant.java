package testmain;

import helper.CategoryHelper;
import helper.ProcessDataHelper;
import helper.ProductHelper;
import helper.UserHelper;
import model.Category;
import model.Product;
import model.User;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TestDataConstant {
    public static final String EXTENSION = "png";
    public static final String LOCATOR = "src\\test\\java\\htmlreport\\";

    List<Category> expectedCategories = new ArrayList<Category>(){
        {
            add(CategoryHelper.getCategoryByName("MOTORCYCLE"));
            add(CategoryHelper.getCategoryByName("ATV"));
            add(CategoryHelper.getCategoryByName("SIDE X SIDE"));
            add(CategoryHelper.getCategoryByName("WATERCRAFT"));
            add(CategoryHelper.getCategoryByName("ELECTRIC BALANCE BIKE"));
        }
    };

    User userData = UserHelper.getUserByEmail("NiNy34@gmail.com");

    public static final String PRODUCT_TYPE = "Motorcycle";

    public static final String EXPECTED_SELECT_VEHICLE_MESSAGE= "Customize your vehicle with Kawasaki Genuine Accessories";

    public static Product product = ProductHelper.getProductByName("Rear Carrier");

    public static String quantity ="3";

    static List<String>price = new ArrayList<String>(){
        {
            add(ProductHelper.getProductByName("Rear Carrier").getPrice().substring(6));     //lastIndexOf("$")
        }
    };


    public static Float expectedTotalPrice = Float.parseFloat(new DecimalFormat("##.##").format(ProcessDataHelper.getTotalPrice(price))) * Float.parseFloat(quantity);

}
