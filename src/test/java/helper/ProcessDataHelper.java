package helper;

import model.Product;

import java.util.List;

public class ProcessDataHelper {
    static Product product = new Product();
    public static float getTotalPrice(List<String> products) {

        float ret = 0;
        for(String p: products){
            ret += product.getPriceAsNumber(p);
        }
        return ret;
    }
}
