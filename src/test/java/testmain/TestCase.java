package testmain;

import base.BasePage;
import helper.HTMLReportHelper;
import org.testng.annotations.Test;
import page.*;

/*
https://www.kawasaki.com

1. Verify 5 category menu: motorcycle, atv, side x side, watercraft, electric balance bike

2. Click "My KaWaSaKi" button

3. Register a account

4. Click "Shop" combobox

5. Select Motorcycle

6. Verify message: "Customize your vehicle with Kawasaki Genuine Accessories"

7. Select a vehicle: Motorcycle, year: 2023,vehicle: KLX300

8. Sort Price (High to low)

9. Verify product total is displayed

10. Verify a product's information

11. Add the above product to cart

12. Click view card button

13. Update quantity is 3

14. Verify total

15. Click "My KaWaSaKi" button

16. Log out
 */

public class TestCase extends BasePage {

    @Test
    public void TestCase001() {
        HTMLReportHelper htmlReportHelper = new HTMLReportHelper();
        TestDataConstant dataTest = new TestDataConstant();
        HomePage homePage = new HomePage(getDriver());
        MyKawasaki myKawasaki = new MyKawasaki(getDriver());
        LoginRegisterPage loginRegisterPage = new LoginRegisterPage(getDriver());
        MotorcyclePage motorcyclePage = new MotorcyclePage(getDriver());
        ShopVehicleAccessoriesPage shop = new ShopVehicleAccessoriesPage(getDriver());
        ViewCartPage viewCartPage = new ViewCartPage(getDriver());



        htmlReportHelper.stepLog("Verify 5 category menu: motorcycle, atv, side x side, watercraft, electric balance bike:");
        homePage.verifyCategoryMenu(dataTest.expectedCategories, "Category");


        htmlReportHelper.stepLog("Click \"My KaWaSaKi\" button");
        homePage.clickMyKawasakiBtn();


        htmlReportHelper.stepLog("Register a account");
        loginRegisterPage.registerAccount(dataTest.userData);



        htmlReportHelper.stepLog("Click \"Shop\" combobox");
        myKawasaki.clickShopCbb();


        htmlReportHelper.stepLog("Select Motorcycle");
        myKawasaki.selectProductType(dataTest.PRODUCT_TYPE);


        htmlReportHelper.stepLog("Verify \"Customize your vehicle with Kawasaki Genuine Accessories\" message");
        motorcyclePage.verifyMessage(dataTest.EXPECTED_SELECT_VEHICLE_MESSAGE, "Message");


        htmlReportHelper.stepLog("Select a vehicle");
        motorcyclePage.selectVehicleItem();


        htmlReportHelper.stepLog("Sort Price (High to low)");
        shop.sortPrice();


        htmlReportHelper.stepLog("Verify product total is displayed:");
        shop.verifyDisplayedProductTotal(8,"Product total");


        htmlReportHelper.stepLog("Verify a product's information:");
        shop.verifyProduct(dataTest.product);

        htmlReportHelper.stepLog("Add the above product to cart");
        shop.clickAddToCart();

        htmlReportHelper.stepLog("Click view card button");
        shop.clickViewCart();

        htmlReportHelper.stepLog("Update quantity is 3");
        viewCartPage.updateQuantity(dataTest.quantity);

        htmlReportHelper.stepLog("Verify total price:");
        viewCartPage.verifyTotalPrice(dataTest.expectedTotalPrice, "Total price");

        htmlReportHelper.stepLog("Click \"My KaWaSaKi\" button");
        viewCartPage.clickMyKawasaki();

        htmlReportHelper.stepLog("Log out");
        myKawasaki.logout();


















    }
}












