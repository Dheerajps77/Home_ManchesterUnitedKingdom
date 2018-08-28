package WesternUnion_NZsitePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage 
{
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	@FindBy(how=How.XPATH, using="//div[contains(@class,'row header-top-container')]//li[8]//a")
	WebElement SignUpButton;
	
	@FindBy(how=How.XPATH, using="//input[@aria-describedby='txtFNameSuccess' and @id='txtFName']")
	WebElement FirstName;
	
	@FindBy(how=How.XPATH, using="//input[@aria-describedby='txtFNameSuccess' and @id='txtMName']")
	WebElement MiddleName;
	
	@FindBy(how=How.XPATH, using="//input[@id='chkMiddleNameOptional']//following::label[1]")
	WebElement MiddleNameOptional;
	
	@FindBy(how=How.XPATH, using="//input[@id='txtLName']")
	WebElement LastName;
	
	@FindBy(how=How.XPATH, using="//input[@id='mergeDob']")
	WebElement DOBName;
	
	@FindBy(how=How.XPATH, using="//input[@id='txtEmailAddr']")
	WebElement EmailAddress;
	
	@FindBy(how=How.XPATH, using="//input[@id='txtKey']")
	WebElement Password;
	
	@FindBy(how=How.XPATH, using="//input[@id='txtAddr']")
	WebElement StreetAddress;
	
	@FindBy(how=How.XPATH, using="//translate[@class='checkTarget ng-scope']")
	WebElement SecondStreetAddressButton;
	
	@FindBy(how=How.XPATH, using="//input[@id='txtAddrLine2']")
	WebElement SecondStreetAddress;
	
	@FindBy(how=How.XPATH, using="//input[@id='txtCity']")
	WebElement CityName;
	
	@FindBy(how=How.XPATH, using="//input[@id='cboState']")
	WebElement StateName;
	
	@FindBy(how=How.XPATH, using="//input[@id='txtZipCode']")
	WebElement Zipcode;
	
	@FindBy(how=How.XPATH, using="//select[@id='cboPrimaryPhoneTypes']")
	WebElement PrimaryPhoneTypes;
	
	@FindBy(how=How.XPATH, using="//select[@id='txtCountryCode']")
	WebElement txtCountryCode;
	
	@FindBy(how=How.XPATH, using="//input[@id='txtPhoneNum1']")
	WebElement PhoneNumber;
	
	@FindBy(how=How.XPATH, using="//input[@amplitude-id='radio-gender-male']")
	WebElement RadioButton;
	
	@FindBy(how=How.XPATH, using="//select[@id='occupationField']")
	WebElement OccupationField;
	
	@FindBy(how=How.XPATH, using="//select[@id='countryOfBirthField']")
	WebElement CountryOfBirthField;
	
	@FindBy(how=How.XPATH, using="//select[@id='cboSecurityQues']")
	WebElement SecurityQuestion;
	
	@FindBy(how=How.XPATH, using="//input[@id='txtAns']")
	WebElement SecurityAns;

	@FindBy(how=How.CSS, using="#smonewuser > div > div > section > div > div > div > div.wu-responsive-columns.col-lg-12.col-md-12.col-sm-12.col-xs-12.colctrl > div.register-step2.section > div > div > div > form > div.row.terms-conditions-align > div.form-group.ng-scope > div > div:nth-child(1) > p > label")
	WebElement CheckBoxTermsAndConditions;
	
	@FindBy(how=How.XPATH, using="//input[@id='chkMarketingOptions']//following::label[1]")
	WebElement CheckBoxMarketingOptions;
	
	@FindBy(how=How.XPATH, using="//button[@id='button-continue']")
	WebElement ContinueButton;
	
	
	public void Registration() throws InterruptedException
	{
		SignUpButton.click();
		FirstName.sendKeys("Dheeraj");
		MiddleName.sendKeys("Pratap");
		Thread.sleep(3000);
		MiddleNameOptional.click();
		LastName.sendKeys("Singh");
		DOBName.sendKeys("26/12/1992");
		EmailAddress.sendKeys("arwuprous1@yopmail.com");
		Password.sendKeys("Password1");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		StreetAddress.sendKeys("12 Hudson Bay Road Extension");
		SecondStreetAddressButton.click();
		SecondStreetAddress.sendKeys("12-Greateer Kailash");
		CityName.sendKeys("Auckland");
		StateName.sendKeys("Auckland");
		Zipcode.sendKeys("0618");
		
		
		Select Phone_Numer=new Select(PrimaryPhoneTypes);
		//PNumber.click();
		Thread.sleep(2000);
		Phone_Numer.selectByVisibleText("Home");
		//PNumber.submit();
		
		Select CountryISD=new Select(txtCountryCode);
		//CountryISD_selction.click();
		Thread.sleep(2000);
		CountryISD.selectByVisibleText("91 (IN)");
		//CountryISD_selction.submit();
		
		/*List<WebElement> getSizeOfPhoneCode=CountryISD.getOptions();
		int total_size=getSizeOfPhoneCode.size();
		System.out.println(total_size);
		for(int i=0;i<total_size;i++)
		{
			String text=getSizeOfPhoneCode.get(i).getText();
			System.out.println(text);
		}*/
		
		PhoneNumber.sendKeys("9090000099");
		Thread.sleep(2000);
		RadioButton.click();
		
		Select O_occupation=new Select(OccupationField);
		//Occupation.click();
		O_occupation.selectByVisibleText("Unemployed");
		Thread.sleep(2000);
		//Occupation.submit();
		
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,300)");
		
		Select Select_CountryOfBirth=new Select(CountryOfBirthField);
		Select_CountryOfBirth.selectByVisibleText("India");
		//CountryOfBirth.click();
		Thread.sleep(2000);
		//CountryOfBirth.submit();
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("window.scrollBy(0,300)");
		Thread.sleep(3000);
		
		Select select_SecurityQ=new Select(SecurityQuestion);
		//SecurityQ.click();
		select_SecurityQ.selectByVisibleText("What is your pet's name?");
		Thread.sleep(2000);
		//SecurityQ.submit();
		
		SecurityAns.sendKeys("White mouse");
		Thread.sleep(2000);
		
		//Actions check1=new Actions(driver);
		//check1.moveToElement(CheckBoxTermsAndConditions).build().perform();
		CheckBoxTermsAndConditions.click();
		
		//Actions check2=new Actions(driver);
		//check2.moveToElement(CheckBoxMarketingOptions).build().perform();
		CheckBoxMarketingOptions.click();
		
		ContinueButton.click();
		
	}
}
