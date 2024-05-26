package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.Assert;

import org.testng.annotations.Test;
import utils.TestData;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static utils.TestData.BASE_URL;

public final class NavigationTest extends BaseTest {

    @Test
    public void testBaseUrlLanding(){
        getPage().navigate(BASE_URL);

        assertThat(getPage()).hasURL(BASE_URL + TestData.HOME_END_POINT);
    }

    @Test
    public void testWomenMenuNavigatesForWomenPage(){
        if (getIsOnHomePage()) {
            getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(TestData.WOMEN).setExact(true)).click();

            assertThat(getPage()).hasURL(BASE_URL + TestData.WOMEN_END_POINT);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void testMenMenuNavigatesForMenPage(){
        if (getIsOnHomePage()) {
            getPage().getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName(TestData.MEN).setExact(true)).click();

            assertThat(getPage()).hasURL(BASE_URL + TestData.MEN_END_POINT);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void testAccessoriesMenuNavigatesForAccessoriesPage(){
        if (getIsOnHomePage()) {
            getPage().getByRole(AriaRole.NAVIGATION).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(TestData.ACCESSORIES)).click();

            assertThat(getPage()).hasURL(BASE_URL + TestData.ACCESSORIES_END_POINT);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void testShoesMenuNavigatesForKidsPage(){
        if (getIsOnHomePage()) {
            getPage().getByRole(AriaRole.NAVIGATION).getByRole(AriaRole.LINK, new Locator.GetByRoleOptions().setName(TestData.KIDS)).click();

            assertThat(getPage()).hasURL(BASE_URL + TestData.KIDS_END_POINT);
        } else {
            Assert.fail();
        }
    }
}
