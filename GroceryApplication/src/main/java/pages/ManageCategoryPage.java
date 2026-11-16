package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategoryPage {
	
		public WebDriver driver;
		
		public ManageCategoryPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newCategory;
		@FindBy(xpath="//input[@id='category']")WebElement enterCategory;
		@FindBy(xpath="//li[@id='3-selectable']")WebElement dragGroup3;
		@FindBy(xpath="//input[@id='main_img']")WebElement chooseFile;
		@FindBy(xpath="//button[@type='submit']")WebElement saveButton;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successText;
		@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement blueSearchButton;
		@FindBy(xpath="//input[@placeholder='Category']")WebElement enterSearchCategory;
		@FindBy(xpath="//button[@name='Search']")WebElement redSearchButton;
		@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")WebElement searchedCategory;
		
		public ManageCategoryPage clickNewCategoryButton() {
			
			newCategory.click();
			return this;
		}
		public ManageCategoryPage enterCategoryOnAddCategory(String categoryName) {
			
			enterCategory.sendKeys(categoryName);
			return this;
		}
		public ManageCategoryPage selectGroupNameOnAddCategory() {
			
			dragGroup3.click();
			return this;
		}
		public ManageCategoryPage chooseFileOnAddCategory() {
			
			chooseFile.sendKeys("C:\\Users\\steph\\Downloads\\images.jpg");
			return this;
			
		}
		public ManageCategoryPage clickSaveButtonOnAddCategory() {
			Actions action=new Actions(driver);
			action.click(saveButton).perform();
			return this;
		}
		public String verifyAddUserAlertIsDisplayed() {
			
			return successText.getText();
			
		}
		public ManageCategoryPage clickBlueSearchButton() {
			
			blueSearchButton.click();
			return this;
			
		}
		public ManageCategoryPage enterCategoryInSearchCategory(String category) {
			
			enterSearchCategory.sendKeys(category);
			return this;
		}
		public ManageCategoryPage clickRedSearchButton() {
			
			redSearchButton.click();
			return this;
			
		}
		public String verifySearchedCategoryIsAvailable() {
			
			return searchedCategory.getText();
		}

}
