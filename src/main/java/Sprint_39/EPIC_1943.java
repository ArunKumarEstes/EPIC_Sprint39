package Sprint_39;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EPIC_1943 extends UtilClass {

	public static String sendkeys = "";
	public static String BOL_Order = "";

	@FindBy(xpath = "//iframe[@name='PegaGadget0Ifr']")
	public static WebElement frameName;

	@FindBy(xpath = "//iframe[contains(@name, 'PegaGadget')]")
	public static WebElement frameName2;

	@FindBy(id = "loginText2")
	public static WebElement ssoLogin;

	@FindBy(className = "table-row")
	public static WebElement code;

	@FindBy(id = "idTxtBx_SAOTCC_OTC")
	public static WebElement send;

	@FindBy(id = "idSubmit_SAOTCC_Continue")
	public static WebElement click;

	@FindBy(xpath = "//div[contains(@class,'launch-portals')]/descendant::a")
	public static WebElement LaunchPortal;

	@FindBy(xpath = "//span[contains(text(),'WareHouse UserPortal')]")
	public static WebElement warehouse;

	@FindBy(xpath = "//li[@title='Orders PAR']")
	public static WebElement OrdersPAR;

	@FindBy(xpath = "//h3[contains(text(),'OS&D')]")
	public static WebElement OSD;

	@FindBy(xpath = "//h3[contains(text(),'Inbound Trailer')]")
	public static WebElement InboundTrailer;

	@FindBy(xpath = "//input[@CLASS='leftJustifyStyle']")
	public static WebElement OrderSearch_Filer;

	@FindBy(xpath = "(//input[@type='checkbox' and contains(@name,'Inbound')])[21]")
	public static WebElement FilterCheckBox;

	@FindBy(xpath = "//th[@aria-label='Order ID']//a[@class='filter highlight-ele']")
	public static WebElement OrderFilter;

	@FindBy(xpath = "(//button[@class='pzhc pzbutton'])[1]")
	public static WebElement OrderFilterApply;

	@FindBy(xpath = "//a[contains(text(), 'PAR')]")
	public static WebElement ClickPARCaseID;

	// ****Trailer Number****

	@FindBy(xpath = "//div[@class='container-multiselect']//input[@data-primary-value='.PickupNumber']")
	public static WebElement Enter_Trailer_Number;

	@FindBy(xpath = "//span[@class='ms-primary-option']//span")
	public static WebElement Suggested_Trailer_number;

	@FindBy(xpath = "//th[@data-attribute-name='Trailer Number']//a[@aria-label='Click to filter']")
	public static WebElement Click_Trailer_Number_Filter;

	@FindBy(xpath = "//input[contains(@name, 'SearchText')]")
	public static WebElement Search_text_Trailer_Number;

	@FindBy(xpath = "(//button[@class='pzhc pzbutton'])[1]")
	public static WebElement Apply_PAR_Filter_Filter;

	@FindBy(xpath = "(//input[@data-ctl='Checkbox'])[2]")
	public static WebElement Select_PAR_order;

	@FindBy(xpath = "//div[@id='PEGA_GRID_SKIN']//button[contains(text(), 'Receive Order')]")
	public static WebElement Click_Receive_Order;

	@FindBy(xpath = "//td[@data-attribute-name='Case ID']//div//span")
	public static WebElement Received_order_PAR_Case;

	@FindBy(xpath = "//*[contains(@alt, 'Choose from calendar')]")
	public static WebElement Calendar_Recived_order;

	@FindBy(xpath = "//button[@title='Receive']")
	public static WebElement Receive_Received_Order;

	// **** Assign Trailer****

	@FindBy(xpath = "//button[contains(text(), 'Assign Trailer')]")
	public static WebElement Click_Assign_Trailer;

	@FindBy(xpath = "//input[@validationtype='required']")
	public static WebElement Inbound_Trailer_Assign_Trailer;

	@FindBy(xpath = "//td[@data-attribute-name='Case ID']//div//span")
	public static WebElement Get_Case_ID_Assign_Trailer;

	@FindBy(xpath = "//table[@class='buttonMainTable Strong']//tbody//tr//td[2]//button[contains(text(), '  Assign Trailer ')]")
	public static WebElement Assign_Trailer_inside;

	@FindBy(xpath = "//button[contains(text(), 'Refresh ')]")
	public static WebElement Click_Refresh;

	@FindBy(xpath = "(//a[@title='Click to filter'])[2]")
	public static WebElement Click_Order_ID_Filter;

	@FindBy(xpath = "//input[contains(@name, 'SearchText')]")
	public static WebElement Search_Text_Order_ID_Filter;

	@FindBy(xpath = "//td[contains(@data-ui-meta, 'PickupNumber')]")
	public static WebElement Trailer_number_Order_Grid;

	public EPIC_1943(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public static void frameSwitch() {
		driver.switchTo().frame(frameName);

	}

	public void PAR_Order_Creation() throws Exception {

		String prettyString = null;
		File file = new File(System.getProperty("user.dir") + "\\PAR.json");
		ObjectMapper objectMapper = new ObjectMapper();
		// Read JSON from file into a JsonNode
		JsonNode rootNode = objectMapper.readTree(file);
		// Ensure that the root node is an ObjectNode
		if (rootNode instanceof ObjectNode) {
			ObjectNode objectNode = (ObjectNode) rootNode;
			// Retrieve the "OrderRefs" object and add "InvoiceNumber" with a random value
			ObjectNode orderRefs = (ObjectNode) objectNode.get("OrderRefs");
			double ceil = Math.ceil(Math.random() * 100000000);
			BOL_Order = Double.toString(ceil);
			orderRefs.put("BOL", BOL_Order);
			orderRefs.put("TrackingNumber", Math.ceil(Math.random() * 100000000));
			orderRefs.put("InvoiceNumber", Math.ceil(Math.random() * 100000000));
			// Convert the modified JsonNode back to a pretty-printed string
			prettyString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode);

			RestAssured.baseURI = "https://epicuatlb.estes-express.com";
			Response response = RestAssured.given().auth().basic("EpicSevicesTest1", "Rules@1234")
					.contentType("application/json").body(prettyString)
					.post("/prweb/api/OrderServicePackage/V1/CreateOrUpdateOrder");
			String responseBody = response.getBody().asString();
			String[] split = responseBody.split("Reference is ");

			sendkeys = split[1];
			System.out.println(sendkeys);
			System.out.println("<------Result of PAR Json------>");
			System.out.println("Response Body: " + responseBody);
			int statusCode = response.getStatusCode();
			System.out.println("Status Code: " + statusCode);
			extentTest.log(Status.PASS, "Order Created");

		}

	}

	public static void frameswitch2() {
		driver.switchTo().frame(frameName2);
	}

	public void PEGALogin() throws InterruptedException {
		ssoLogin.click();
		waits(code);
		code.click();

		// Scanner class to handle OTP
		String scanner = scanner();
		send.sendKeys(scanner);
		waits(click);
		click.click();
	}

	public void LaunchWarehousePortal() throws InterruptedException {
		waits(LaunchPortal);
		LaunchPortal.click();
		waits(warehouse);
		warehouse.click();
		Await();
		Windows();

	}

	public void OrdersPAR() throws Exception {
		Await();
		OrdersPAR.click();
		extentTest.log(Status.PASS, "Entering into Orders PAR");
		Await();
		frameSwitch();
		waits(OSD);
		OSD.click();
		Thread.sleep(9000);

	}

	public void Trailer_Number() throws InterruptedException {
		InboundTrailer.click();
		Await();
		String Send_Trailer_Number_ = "1234";
		Enter_Trailer_Number.sendKeys(Send_Trailer_Number_);
		Await();
		Suggested_Trailer_number.click();
		Await();
		Click_Trailer_Number_Filter.click();
		Await();
		Search_text_Trailer_Number.sendKeys(Send_Trailer_Number_);
		Await();
		Apply_PAR_Filter_Filter.click();
		Await();
		Select_PAR_order.click();
		Await();
		Click_Receive_Order.click();
		Await();
		String Received_Case_ID = Received_order_PAR_Case.getText();
		System.out.println(Received_Case_ID);
		extentTest.log(Status.PASS, "Resolved Case ID");


		Calendar_Recived_order.click();
		Calendarss();
		Await();
		Receive_Received_Order.click();
		extentTest.log(Status.PASS, "Order Moved to Received Status");
		Await();
		Click_Order_ID_Filter.click();
		Await();
		Search_Text_Order_ID_Filter.sendKeys(Received_Case_ID);
		Await();
		Apply_PAR_Filter_Filter.click();
		Await();
		Click_Refresh.click();
		Await();
		driver.switchTo().defaultContent();
		frameSwitch();
		Await();
		Enter_Trailer_Number.sendKeys(Send_Trailer_Number_);
		Await();
		Suggested_Trailer_number.click();
		Await();
		Click_Trailer_Number_Filter.click();
		Await();
		Search_text_Trailer_Number.sendKeys(Send_Trailer_Number_);
		Await();
		Apply_PAR_Filter_Filter.click();
		Await();

	}

	public void Assign_trailer_Part() throws InterruptedException {

		Select_PAR_order.click();
		Await();
		Click_Assign_Trailer.click();
		Await();

		String Assign_trailer_number = "6789";
		Inbound_Trailer_Assign_Trailer.sendKeys(Assign_trailer_number);
		Await();
		String Assign_Trailer_Case_ID = Get_Case_ID_Assign_Trailer.getText();
		System.out.println(Assign_Trailer_Case_ID);
		Await();
		Assign_Trailer_inside.click();
		Await();
		Assign_Trailer_inside.click();
		extentTest.log(Status.PASS, "Entered Trailer Number");
		Await();
		Click_Refresh.click();
		Await();
		driver.switchTo().defaultContent();
		frameSwitch();
		Await();
		Click_Order_ID_Filter.click();
		Await();
		Search_Text_Order_ID_Filter.sendKeys(Assign_Trailer_Case_ID);
		Await();
		Apply_PAR_Filter_Filter.click();
		Await();

		String Pickup_trailer_Number = Trailer_number_Order_Grid.getText();
		assertTrue(Pickup_trailer_Number.contains(Assign_trailer_number));
		System.out.println("Successfully validated Trailer Number:" + Pickup_trailer_Number);
		extentTest.log(Status.PASS, "Successfully validated Trailer Number");

	}

}
