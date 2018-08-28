package WesternUnion_NZsitePage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TrackTransferPage {
	
	protected WebDriver driver;

	public TrackTransferPage(WebDriver driver)
	{
		
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH, using="//li[@id='nav_tab2']//a")
	WebElement TrackTransfer_link;
	
	@FindBy(how=How.XPATH, using="//input[@id='trackingNumber']")
	WebElement TrackTransferTextBox;
	
	@FindBy(how=How.XPATH, using="//button[@id='button-track-transfer']")
	WebElement TrackTransferSubmitButton;
	
	@FindBy(how=How.XPATH, using="//div[@id='notification-container']//a[@aria-label='close']//following::span[1]")
	WebElement ErrorMessage;
	
	@FindBy(how=How.XPATH, using="//div[@class='pull-right']//small[@id='notification-code']")
	WebElement ErrorMessageNumber;
	
	@FindBy(how=How.XPATH, using="//input[@id='trackingNumber']")
	WebElement CorrectMTCNNumber;
	
	@FindBy(how=How.XPATH, using="//div[@class='progress-status-text new-hidden-large-ds']/translate[text()='Status']//following::div[1]")
	WebElement StatusOfCorrectMTCNnumber;
	
	@FindBy(how=How.XPATH, using="//div[@class='hide-desktop-view ani ng-scope']//div[@class='tat-button-wrapper']//div//div//div//following::div[1]//a//translate[text()='Track transfer']")
	WebElement TrackNewTransfer;
	
	@FindBy(how=How.XPATH, using="//a[@id='link-find-mtcn']")
	WebElement Dont_Have_MTCN;
	
	@FindBy(how=How.XPATH, using="//label[@for='senrcvname']")
	WebElement SenderAndRecievernameLink;
	
	@FindBy(how=How.XPATH, using="//label[@for='senphone']")
	WebElement SenderphoneNumberLink;
	
	@FindBy(how=How.XPATH, using="//input[@id='txtReceiveAmount']")
	WebElement ReceiverAmounttextbox;
	
	@FindBy(how=How.XPATH, using="//input[@id='country']")
	WebElement ReceiverCountrySelection;
	
	@FindBy(how=How.XPATH, using="//input[@id='txtPhoneNum1']")
	WebElement RecieverPhonenumber;
	
	
	@FindBy(how=How.XPATH, using="//ul[@move-in-progress='moveInProgress']//li")
	List<WebElement> TotalReceiverCountryName;
	public void TrackTransferModule()
	{
		//driver.navigate().to("https://www.westernunion.com/nz/en/send-money/app/start");
		TrackTransfer_link.click();
	}
	
	public void EnterwrongMTCNnumber(String WrongMTCN_number)
	{
		TrackTransferTextBox.sendKeys(WrongMTCN_number);
		TrackTransferSubmitButton.click();
	}
	
	public String ErrorMessageInStringForm()
	{
		String ErrorMessageCapturing=ErrorMessage.getText();
		return ErrorMessageCapturing;
	}
	
	public String ErrorMessageInNumberForm()
	{
		String ErrorMessageIn=ErrorMessageNumber.getText();
		return ErrorMessageIn;
	}
	
	public void EnterCorrectMTCNnumber(String CorrectMTCN_number) throws InterruptedException
	{
		
		Thread.sleep(3000);
		TrackTransferTextBox.clear();
		TrackTransferTextBox.sendKeys(CorrectMTCN_number);
		TrackTransferSubmitButton.click();
		Thread.sleep(3000);
	}
	
	public String StatusOfCorrectMTCNnumber()
	{
		String StatusofValidMTCN=StatusOfCorrectMTCNnumber.getText();
		return StatusofValidMTCN;
	}
	
	public void TrackNewtransfer() throws InterruptedException
	{
		TrackNewTransfer.click();
		Thread.sleep(2000);
	}
	
	public void WhenWeDontHaveMTCNNnumber() throws InterruptedException
	{
		Thread.sleep(2000);
		Dont_Have_MTCN.click();
		Thread.sleep(2000);
		SenderAndRecievernameLink.click();
		Thread.sleep(1000);
		SenderphoneNumberLink.click();
	}
	
	public void SenderPhoneNumber(String ReciverPhonumber, String EnterRecieverAmount, String EnterRecieverCountryName) throws InterruptedException
	{
	
		Thread.sleep(2000);
		RecieverPhonenumber.sendKeys(ReciverPhonumber);
		ReceiverAmounttextbox.sendKeys(EnterRecieverAmount);
		ReceiverCountrySelection.clear();
		Thread.sleep(2000);
		ReceiverCountrySelection.sendKeys(EnterRecieverCountryName);
		Thread.sleep(2000);
		int total_size=TotalReceiverCountryName.size();
		
		System.out.println("=====================================");
		System.out.println("Total number of Receiver Country are present : ===> " + total_size);
		System.out.println("Total countries are present at below : ");
		
		
		for(int i=0;i<total_size;i++)
		{
			String str=TotalReceiverCountryName.get(i).getText();
			System.out.println(str);
			
		}
		for(int i=0;i<total_size;i++)
		{
			String str=TotalReceiverCountryName.get(i).getText();
			System.out.println(str);
			
			if(TotalReceiverCountryName.get(i).getText().contains("India"))
			{
				Thread.sleep(2000);
				TotalReceiverCountryName.get(i).click();
				break;
			}
		}
		
	}
	
}
