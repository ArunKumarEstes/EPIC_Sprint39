package Sprint_39;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import dev.failsafe.internal.util.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class EPIC_1738 extends UtilClass {

	public static String sendkeys = "";
	public static String BOL_Order = "";

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

	@FindBy(xpath = "(//span[contains(@class, 'search')])[1]")
	public static WebElement OrderSearch1;

	@FindBy(xpath = "(//span[contains(@class, 'search')])[1]")
	public static WebElement OrderSearch2;

	@FindBy(xpath = "//input[@placeholder='Search by Case ID/Order Reference Numbers']")
	public static WebElement Order_Search_by_Case_ID;

	@FindBy(xpath = "(//button[contains(text(), 'Search')])[1]")
	public static WebElement Click_on_Search_1;

	@FindBy(xpath = "//a[contains(text(), 'PAR')]")
	public static WebElement Search_results_PAR_Case_ID;

	@FindBy(xpath = "//tbody//tr[2]//td[@data-attribute-name='Order BOL']//span")
	public static WebElement Search_results_Order_BOL;

	@FindBy(xpath = "//h2[text()='Resolved Case Search']//ancestor::div[@id='EXPAND-OUTERFRAME']//select[@name='$PpyDisplayHarness$pRequestingTradingPartnerID']")
	public static WebElement shipper_Dropdown_Resolved_case_Search;

	@FindBy(xpath = "//input[@name='$PpyDisplayHarness$pBOL']")
	public static WebElement BOL_Resolved_case_Search;

	@FindBy(xpath = "//h2[text()='Resolved Case Search']//ancestor::div[@id='EXPAND-OUTERFRAME']//select[@name='$PpyDisplayHarness$pDateRange']")
	public static WebElement Choose_Delivery_Date_Dropdown_Resolved_case_Search;

	@FindBy(xpath = "(//button[contains(text(), 'Search')])[3]")
	public static WebElement Click_on_Search_3;

	public EPIC_1738(WebDriver driver) {
		PageFactory.initElements(driver, this);
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
		Await();
	//	waits(LaunchPortal);
		LaunchPortal.click();
	//	waits(warehouse);
		Await();
		warehouse.click();
		Await();
		Windows();

	}

	public void Order_Search_Case_ID() throws InterruptedException {
		Await();
		OrderSearch1.click();
		frameswitch2();
		Order_Search_by_Case_ID.sendKeys(sendkeys);
		Await();
		Click_on_Search_1.click();
		Await();
		Thread.sleep(9000);
		String PAR_Case_Order_Search = Search_results_PAR_Case_ID.getText();
		System.out.println(PAR_Case_Order_Search);
		assertTrue(PAR_Case_Order_Search.equals(sendkeys));
		System.out.println("PAR_Case_ID:" + PAR_Case_Order_Search);

	}

	public void Order_Search_Reference_Number() throws InterruptedException {

		Order_Search_by_Case_ID.clear();
		Await();
		Order_Search_by_Case_ID.sendKeys(BOL_Order);
		Await();
		Click_on_Search_1.click();
		Await();
		String Order_BOL_Order_Search = Search_results_Order_BOL.getText();
		assertTrue(Order_BOL_Order_Search.equals(BOL_Order));
		System.out.println("Order_BOL:" + Order_BOL_Order_Search);
	}

	public void Resolved_Case_Search() throws InterruptedException {

		String[] Shipper = { "THD - Unbundled", "Starbucks", "Crowley", "VA ABC", "Paccar",
				"AMAT - Howard Lane - BLDG47", "EFM", "THD-Pompano", "KBX-GP", "THD-2681-Norwood", "KBX GP",
				"THD-4708-Olympia", "EL2-Franklin", "EL2-Rancho Cucamonga", "THD-6152-Starrett City", "EL2-Medley",
				"EL2-Farmers Branch" };
		SelectClass(shipper_Dropdown_Resolved_case_Search, Shipper[6]);
		Await();
		
		String[] Delivery_Date = { "Last 60 Days", "Last 30 Days", "Last 7 Days", "Yesterday", "Today" };
		SelectClass(Choose_Delivery_Date_Dropdown_Resolved_case_Search, Delivery_Date[0]);
		Await();

		String[] BOL_Num = { "EPTEST1", "{{randomNumberBOL}}" };
		BOL_Resolved_case_Search.sendKeys(BOL_Num[0]);
		System.out.println("Test Result:" + BOL_Num[0]);
		Await();

		Click_on_Search_3.click();
		Await();
		List<WebElement> Resolved_Search_BOL = driver
				.findElements(By.xpath("(//table[@id='gridLayoutTable'])[2]//tr//td[3]/div/span"));
		for (int i = 0; i < Resolved_Search_BOL.size(); i++) {
			String stringBOL = Resolved_Search_BOL.get(i).getText();
			System.out.println(stringBOL);
			if (stringBOL.equals(BOL_Num[0])) {
				System.out.println("BOL PASS");
			}
		}
		Await();
		List<WebElement> Resolved_Search_Shipper = driver
				.findElements(By.xpath("(//table[@id='gridLayoutTable'])[2]//tr//td[6]/div/span"));
		for (int i = 0; i < Resolved_Search_Shipper.size(); i++) {
			String stringShipper = Resolved_Search_Shipper.get(i).getText();
			System.out.println(stringShipper);
			if (stringShipper.equals(Shipper[6])) {
				System.out.println("BOL PASS");
			}
		}

	}

}
