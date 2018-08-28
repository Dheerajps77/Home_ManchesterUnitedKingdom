package WesternUnion_NZsitePageClass;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import TestBaseClass.TestBase;
import WesternUnion_NZsitePage.RegisterPage;

public class RegisterPageClass extends TestBase{
	
	RegisterPage ObjRegisterPage;
	
	@Test
	public void Register() throws InterruptedException
	{
		ObjRegisterPage=PageFactory.initElements(driver, RegisterPage.class);
		ObjRegisterPage.Registration();
	}

}
