package Runner_Sprint_39;

import org.testng.annotations.Test;

import Sprint_39.EPIC_1738;
import Sprint_39.EPIC_1943;
import Sprint_39.EPIC_1964;
import Sprint_39.UtilClass;

public class Runner extends UtilClass {

	@Test(priority = 1)
	public void EPICPLTFRM_1738() throws Exception {
		EPIC_1738 login = new EPIC_1738(driver);
		login.PAR_Order_Creation();
		login.PEGALogin();
		login.LaunchWarehousePortal();
		login.Order_Search_Case_ID();
		login.Order_Search_Reference_Number();
		login.Resolved_Case_Search();

	}

	@Test

	public void EPICPLTFRM_1964() throws Exception {

		EPIC_1964 login = new EPIC_1964(driver);
		login.api();
		Await();
		login.PEGALogin();
		login.LaunchWarehousePortal();
		login.OrdersPAR();
		login.InboundTrailer_WorkQueue();
		Thread.sleep(7000);

		login.Received_Status();
		Await();
		EPIC_1964.ClickonCalendar.click();
		EPIC_1964.Calendarss();
		Await();
//			login.ClickOnApply.click();
//			Await();
		EPIC_1964.getAttribute();
		EPIC_1964.Submit.click();
		Await();
		EPIC_1964.ClickonGo.click();
		EPIC_1964.driver.switchTo().defaultContent();
		Await();
		EPIC_1964.frameswitch2();
		Await();
		login.Released_Status();
		Await();
		EPIC_1964.ClickonCalendar.click();
		EPIC_1964.Calendarss();
		Await();
//			login.ClickOnApply.click();
//			Await();
//			Pom.getAttribute();
		EPIC_1964.Submit.click();
		Await();
		EPIC_1964.ClickonGo.click();
		EPIC_1964.driver.switchTo().defaultContent();
		Await();
		EPIC_1964.frameswitch2();
		Await();
		login.POD_Exception();
		Await();
		EPIC_1964.ClickonGo.click();
		EPIC_1964.driver.switchTo().defaultContent();
		Await();
		EPIC_1964.frameswitch2();
		Await();

		login.POD_Received_Validation();
		Await();
		EPIC_1964.driver.switchTo().defaultContent();
		EPIC_1964.ClickonOrdersPAR.click();
		EPIC_1964.frameSwitch();
		EPIC_1964.ClickonPOD_Review.click();
		driver.switchTo().defaultContent();
		EPIC_1964.frameSwitch();
		// Await();
		Thread.sleep(9000);

		// ---------------

		login.OrderSearchandFilter();
		Await();
		EPIC_1964.Validate_Status_Released();
		EPIC_1964.Validate_Attachment_No();
		Await();
		EPIC_1964.Attachment_Clip();
		login.Rich_Text();
		login.Attachment_Submit();
		Await();
		login.OrderSearchandFilter();
		Await();
		EPIC_1964.Validate_Status_PODReceived();
		Await();
		EPIC_1964.Validate_Attachment_Yes();
//					Await();
//					pom.OrderSearchandFilter();
		Await();
//		EPIC_1964.Attachment_Clip();
//		login.AddURL();
//		login.Attachment_Submit();
		EPIC_1964.driver.switchTo().defaultContent();
		login.SwitchtoOrderPage();
		EPIC_1964.frameswitch2();
		Await();
		login.ActionsButton();
		Await();
		EPIC_1964.driver.switchTo().defaultContent();
		EPIC_1964.frameswitch2();
		Await();
		EPIC_1964.ClickonGo.click();
		Await();
		EPIC_1964.Submit.click();
		Await();

		Await();
		EPIC_1964.driver.switchTo().defaultContent();
		EPIC_1964.ClickonOrdersPAR.click();
		EPIC_1964.frameSwitch();
		EPIC_1964.ClickonPOD_Review.click();
		driver.switchTo().defaultContent();
		EPIC_1964.frameSwitch();

		// Await();
		Thread.sleep(9000);

		// ---------------

		login.OrderSearchandFilter();
		Await();
		EPIC_1964.Validate_Attachment_Yes();
		Await();
		EPIC_1964.Validate_Req_Status_Yes();
		Await();
		login.Approve_POD();

		EPIC_1964.driver.switchTo().defaultContent();
		login.SwitchtoOrderPage();
		EPIC_1964.frameswitch2();
		Await();
		login.ActionsButton();
		Await();
		EPIC_1964.driver.switchTo().defaultContent();
		EPIC_1964.frameswitch2();

		EPIC_1964.Resolved_Completed();

	}

	@Test
	public void EPICPLTFRM_1943() throws Exception {
		EPIC_1943 login = new EPIC_1943(driver);
		login.PAR_Order_Creation();
		login.PEGALogin();
		login.LaunchWarehousePortal();
		login.OrdersPAR();
		login.Trailer_Number();
		login.Assign_trailer_Part();
	}
}
