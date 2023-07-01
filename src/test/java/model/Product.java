package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import report.SoftAssertion;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    public String name;
    public String id;
    public String price;

    public Product() {
    }

    public void verifyProduct(Product expectedProduct){
        SoftAssertion.assertEquals(this.getName(), expectedProduct.getName(),"Product name");
        SoftAssertion.assertEquals(this.getId(), expectedProduct.getId(),"Product id");
        SoftAssertion.assertEquals(this.getPrice(), expectedProduct.getPrice(),"Product price");
    }

    public float getPriceAsNumber(String price){
        return Float.parseFloat(price);
    }
}
