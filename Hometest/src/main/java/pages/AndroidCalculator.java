package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AndroidCalculator extends BaseTest {

	// Page Factory to load MobileElements

	@FindBy(id = "com.vbanthia.androidsampleapp:id/inputFieldLeft")
	private MobileElement inputFieldLeft;
	@FindBy(id = "com.vbanthia.androidsampleapp:id/inputFieldRight")
	private MobileElement inputFieldRight;
	@FindBy(id = "com.vbanthia.androidsampleapp:id/additionButton")
	private MobileElement additionButton;
	@FindBy(id = "com.vbanthia.androidsampleapp:id/subtractButton")
	private MobileElement subtractButton;
	@FindBy(id = "com.vbanthia.androidsampleapp:id/multiplicationButton")
	private MobileElement multiplicationButton;
	@FindBy(id = "com.vbanthia.androidsampleapp:id/divisionButton")
	private MobileElement divisionButton;
	@FindBy(id = "com.vbanthia.androidsampleapp:id/resultTextView")
	private MobileElement resultTextView;

	public AndroidCalculator(AppiumDriver<MobileElement> driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	// To enter input data in text fields
	public void inputLeftAndRightFields(String string1, String string2) {

		inputFieldLeft.isDisplayed();
		inputFieldLeft.clear();

		inputFieldRight.isDisplayed();
		inputFieldRight.clear();

		inputFieldLeft.sendKeys(string1);
		inputFieldRight.sendKeys(string2);
	}

	// To perform Addition operation
	public void addition() {

		additionButton.click();

	}

	// To perform Subtraction operation
	public void subtraction() {

		subtractButton.click();

	}

	// To perform Multiplication operation
	public void multiplication() {

		multiplicationButton.click();

	}

	// To perform Division operation
	public void division() {

		divisionButton.click();

	}

	// To verify the result
	public int verifyResult() {

		String result1 = resultTextView.getAttribute("text");

		String result[] = result1.split("=", 2);

		Double d = Double.parseDouble(result[1]);

		return d.intValue();

	}

}