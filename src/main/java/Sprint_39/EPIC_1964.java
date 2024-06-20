package Sprint_39;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EPIC_1964 extends UtilClass {
	public static String sendkeys = "";
	public static String DateTime = "";

	public EPIC_1964(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//iframe[@name='PegaGadget0Ifr']")
	public static WebElement frameName;

	@FindBy(xpath = "//iframe[@name='PegaGadget1Ifr']")
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

	@FindBy(xpath = "//th[@aria-label='Order ID']//a[@class='filter highlight-ele']")
	public static WebElement OrderFilter;

	@FindBy(xpath = "//div[@class='content-inner ']/div/span/input[@type='text']")
	public static WebElement OrderSearch_Filter;

	@FindBy(xpath = "(//input[@type='checkbox' and contains(@name,'Inbound')])[21]")
	public static WebElement FilterCheckBox;

	@FindBy(xpath = "(//button[@class='pzhc pzbutton'])[1]")
	public static WebElement OrderFilterApply;

	@FindBy(xpath = "//a[contains(text(), 'PAR')]")
	public static WebElement ClickPARCaseID;

	@FindBy(xpath = "//*[contains(@name, '$PpyWorkPage$pStatusEvent')]")
	public static WebElement Inbound_trailer_outboundLoads_Status;

	@FindBy(xpath = "//*[contains(@alt, 'Choose from calendar')]")
	public static WebElement ClickonCalendar;

	@FindBy(xpath = "//a[@id='applyLink']")
	public static WebElement ClickOnApply;

	@FindBy(xpath = "//input[@name='$PpyWorkPage$pEventDate']")
	public static WebElement GetDateandTime;

	@FindBy(xpath = "//button[contains(text(), 'Submit')]")
	public static WebElement Submit;

	@FindBy(xpath = "(//button[contains(text(), 'Go')])")
	public static WebElement ClickonGo;

	@FindBy(xpath = "(//*[contains(@alt, 'Choose from calendar')])[1]")
	public static WebElement ClickonCalendar_POD_review;

	@FindBy(xpath = "(//*[contains(@alt, 'Choose from calendar')])[2]")
	public static WebElement ClickonCalendar_POD_review2;

	@FindBy(xpath = "//select[@name='$PpyWorkPage$pAssignedTradingPartnerName']")
	public static WebElement Release__Carrier;

	@FindBy(xpath = "//span[contains(text(), 'POD Received')]")
	public static WebElement POD_Received_Validation;

	@FindBy(xpath = "(//span[contains(text(), 'Orders PAR')])[2]")
	public static WebElement ClickonOrdersPAR;

	@FindBy(xpath = "(//h3[@class='layout-group-item-title'])[4]")
	public static WebElement ClickonPOD_Review;

	@FindBy(xpath = "//div[@class='oflowDivM ']/span[contains(text(),'POD Received')]   ")
	public static WebElement status_PODReceived;

	@FindBy(xpath = "(//div//span[contains(text(), 'Released')])[1]")
	public static WebElement status_released_in_Order_flow;

	@FindBy(xpath = "//button[contains(text(), 'Approve POD')]//ancestor::div[@id='PEGA_GRID_SKIN']//td[@data-attribute-name='Status']//div//span")
	public static WebElement status_released;

	@FindBy(xpath = "//td[@data-attribute-name='Attached?']/div/span[contains(text(),'N')]")
	public static WebElement Attachment_No;

	@FindBy(xpath = "//div[@class='oflowDivM ']/span/a/i[@class='pi pi-paper-clip']")
	public static WebElement Attachment_Clip;

	@FindBy(xpath = "//input[@name='$PAddRecentContent$ppyLabel']")
	public static WebElement RichText_Name;

	@FindBy(xpath = "//button[@title='Submit']")
	public static WebElement Attachment_Submit;

	@FindBy(xpath = "//td[@data-attribute-name='Attached?']/div/span[contains(text(),'Y')]")
	public static WebElement Attachment_Yes;

	@FindBy(xpath = "//td[@data-attribute-name='Req Status']/div/span[contains(text(),'Y')]")
	public static WebElement Req_Status_Yes;

	@FindBy(xpath = "(//input[@class='checkbox chkBxCtl'])[2]")
	public static WebElement Order_Check_box_POD_Review;

	@FindBy(xpath = "//button[contains(text(), 'Approve POD')]")
	public static WebElement Click_Approve_POD;

	@FindBy(xpath = "//button[@title='Submit']")
	public static WebElement Click_Submit_POD_Approve_POD;

	@FindBy(xpath = "//div[@title='Add URL']")
	public static WebElement AddURL;

	@FindBy(xpath = "//input[@name='$PpyAttachmentPage$ppyNote']")
	public static WebElement AddURL_Name;

	@FindBy(xpath = "//input[@name='$PpyAttachmentPage$ppyURL']")
	public static WebElement AddURL_tag;

	@FindBy(xpath = "(//button[@name='CaseActionHeader_pyWorkPage_4'])[2]")
	public static WebElement Actions_Button;

	@FindBy(xpath = "//span[contains(text(), 'Refresh')]")
	public static WebElement Actions_Refresh;

	@FindBy(xpath = "//span[contains(text(),'Resolved-Completed')]")
	public static WebElement Resolved_Completed;

	public static void frameSwitch() {
		driver.switchTo().frame(frameName);

	}

	public static void frameswitch2() {
		driver.switchTo().frame(frameName2);
	}

	public static void getAttribute() {
		DateTime = GetDateandTime.getAttribute("data-value");
	}

	public void api() throws Exception {

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
			orderRefs.put("BOL", Math.ceil(Math.random() * 100000000));
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

	public void PEGALogin() throws InterruptedException {
		ssoLogin.click();
		waits(code);
		code.click();

		// ****Scanner class to handle OTP****
		String scanner = scanner();
		send.sendKeys(scanner);
		waits(click);
		click.click();
		extentTest.log(Status.PASS, "Logged into PEGA Successfully");
	}

	public void LaunchWarehousePortal() throws InterruptedException {
		Await();
		LaunchPortal.click();
		Await();
		warehouse.click();
		Await();
		Windows();
		extentTest.log(Status.PASS, "Enetered into Warehouse Portal");
	}

	public void OrdersPAR() throws Exception {
		Await();
		OrdersPAR.click();
		extentTest.log(Status.PASS, "Entering into Orders PAR");
		Await();
		frameSwitch();
		waits(OSD);
		OSD.click();
		waits(InboundTrailer);

	}

	public void InboundTrailer_WorkQueue() throws InterruptedException {
		InboundTrailer.click();
		Await();
		OrderFilter.click();
		waits(OrderSearch_Filter);
		OrderSearch_Filter.sendKeys(sendkeys);
//		waits(FilterCheckBox);
//		FilterCheckBox.click();
		waits(OrderFilterApply);
		OrderFilterApply.click();
		Await();

		ClickPARCaseID.click();
		Await();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(frameName2);

		Await();

		// Inbound_trailer_outboundLoads_Status.click();
		// driver.switchTo().defaultContent();
	}

	public void SwitchtoOrderPage() {

		WebElement switchtoOrder = driver
				.findElement(By.xpath("//table[@id='RULE_KEY']/tbody/tr/td/span[contains(text(),'" + sendkeys + "')]"));
		switchtoOrder.click();

	}

	public void Received_Status() {
		SelectClass(Inbound_trailer_outboundLoads_Status, "Received");
		extentTest.log(Status.PASS, "Order is Moved into Received Status");

	}

	public void Released_Status() {
		SelectClass(Inbound_trailer_outboundLoads_Status, "Released");
		extentTest.log(Status.PASS, "Order is Moved into Released Status");

	}

	public void Release_Carrier() {
		SelectClass(Release__Carrier, "Radiant");
	}

	public void POD_Exception() throws InterruptedException {
		EPIC_1964.ClickonCalendar_POD_review.click();
		EPIC_1964.Calendarss();
		Await();
		EPIC_1964.ClickonCalendar_POD_review2.click();
		EPIC_1964.Calendarss();
		Await();
		Release_Carrier();
		EPIC_1964.Submit.click();
		extentTest.log(Status.PASS, "Enterng into POD Exception Screen");
	}

	public void POD_Received_Validation() {
		String text = EPIC_1964.status_released_in_Order_flow.getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("RELEASED"));
		System.out.println("Successfully Validated Status:" + text);
		extentTest.log(Status.PASS, "Successfully validated status: POD Received");
	}

	public void OrderSearchandFilter() throws Exception {
		// Await();
		Thread.sleep(9000);
		OrderFilter.click();
		Await();
		// waits(OrderSearch_Filter);
		Await();
		OrderSearch_Filter.sendKeys(sendkeys);
		waits(OrderFilterApply);
		OrderFilterApply.click();
		Await();
		extentTest.log(Status.PASS, "Filter the Order");

	}

	public static void Validate_Status_Released() {
		String text = status_released.getText();
		assertEquals("Released", text);
		System.out.println("Successfully validated Status Released");
		extentTest.log(Status.PASS, "Successfully validated Status: POD Received");
	}

	public static void Validate_Status_PODReceived() {
		String text = status_PODReceived.getText().trim();
		assertEquals("POD Received", text);
		System.out.println("Successfully validated Status POD Received");
		extentTest.log(Status.PASS, "Successfully validated Status: POD Received");
	}

	public static void Validate_Attachment_No() {
		String text = Attachment_No.getText().trim();
		assertEquals("N", text);
		System.out.println("Successfully Validated Attachment");
		extentTest.log(Status.PASS, "Successfully Validated Attachment");

	}

	public static void Attachment_Clip() throws InterruptedException {
		Attachment_Clip.click();
//		Await();
//		Add_Existing_Attachment.click();

	}

	public void Rich_Text() throws Exception {
		Await();
		RichText_Name.sendKeys("Test");
	}

	public void Attachment_Submit() throws Exception {
		Await();
		Attachment_Submit.click();
		extentTest.log(Status.PASS, "Attachment Submitted Succesfully");

	}

	public static void Validate_Attachment_Yes() {
		String text = Attachment_Yes.getText().trim();
		assertEquals("Y", text);
		System.out.println("Successfully Validated Attachment");
		extentTest.log(Status.PASS, "Successfully Validated Attachment");

	}

	public void AddURL() throws Exception {
		Await();
		AddURL.click();
		Await();
		AddURL_Name.sendKeys("Test");
		AddURL_tag.sendKeys("www.testing.com");
		Await();
	}

	public void ActionsButton() throws Exception {
		Await();
		Actions_Button.click();
		Await();
		Actions_Refresh.click();
		Await();
		extentTest.log(Status.PASS, "Refreshing the Order Status");
	}

	public static void Validate_Req_Status_Yes() {
		String text = Req_Status_Yes.getText().trim();
		assertEquals("Y", text);
		System.out.println("Successfully Validated Req Status");
		extentTest.log(Status.PASS, "Successfully Validated Attachment");

	}

	public void Approve_POD() throws InterruptedException {
		Await();
		Order_Check_box_POD_Review.click();
		Await();
		Click_Approve_POD.click();
		// driver.switchTo().defaultContent();
		Await();
		Click_Submit_POD_Approve_POD.click();

	}

	public static void Resolved_Completed() {
		String completedStatus = Resolved_Completed.getText().trim();
		assertEquals(completedStatus, "RESOLVED-COMPLETED");
		System.out.println("Successfully validated Resolved-Completed");
		extentTest.log(Status.PASS, "Successfully validated the status: Resolved- Completed ");
	}
}
