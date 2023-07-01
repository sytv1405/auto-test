package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import report.SoftAssertion;

@Getter
@Setter
@AllArgsConstructor
public class Category {

    public String name;


    public void verifyCategory(Category expectedCategory, String description){
        SoftAssertion.assertEquals(this.getName(), expectedCategory.getName(),description);
    }
}
