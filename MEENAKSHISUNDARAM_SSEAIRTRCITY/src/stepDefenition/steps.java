package stepDefenition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

	

public class steps {				

	WebDriver driver;
     
    @Given("^I am a resident from UK and enter my postcode on the intial page and click Next button$")				
    public void i_am_a_resident_from_UK_and_enter_my_postcode_on_the_intial_page_and_click_Next_button() throws Throwable							
    {	
    	
    	System.setProperty("webdriver.gecko.driver", "C:\\Users\\35389\\Downloads\\geckodriver-v0.32.1-win-aarch64\\geckodriver.exe");
    	driver= new FirefoxDriver();					
        driver.manage().window().maximize();			
        driver.get("https://www.pvfitcalculator.energysavingtrust.org.uk/");	
    	
        System.out.println("This Step open the Firefox browser,launch the URL,enters the user post code and clicks on the Next button");
        
    }		

    @When("^I enter my property details into the Solar energy calculator and click Next button$")					
    public void i_enter_my_property_details_into_the_Solar_energy_calculator_and_click_Next_button() throws Throwable 							
    {		
    	driver.findElement(By.xpath("//*[@id=\"cphMainContent_cphPageWithSidebar_strPostcode_Start\"]")).sendKeys("PL7 1RF");							
        driver.findElement(By.xpath("//*[@id=\"cphMainContent_cphPageWithSidebar_btnNext_Start\"]")).click();
        //sets roof slope to 25 degrees
    	driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div[2]/div/div[3]/div/div[2]/div/section[2]/div/table/tbody/tr/td[2]/div/div/a[1]/span")).click();
    	//sets shading to 20
    	driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div[2]/div/div[3]/div/div[2]/div/section[3]/div/table/tbody/tr/td[2]/div/div/a[1]/span")).click();
    	//installation size is at default value of 4kw
    	//select next button
    	driver.findElement(By.xpath("//*[@id=\"cphMainContent_cphPageWithSidebar_btnNext_Quote\"]")).click();
    	
    	System.out.println("This step enters the user property details and clicks on the next button");	
      
    }		

    @Then("^I should get the results page with Potential annual benefit$")					
    public void i_should_get_the_results_page_with_Potential_annual_benefit() throws Throwable 							
    {    
    	
    	 boolean t = driver.findElement(By.xpath("/html/body/form/div[3]/div/div[2]/div[2]/div/div[3]/div/div[3]/div/div[1]/div[1]/div/p[1]")).isDisplayed();
         if (t) {
            System.out.println("Element is dispalyed");
         } else {
            System.out.println("Element is not dispalyed");
         }
    	
    	
        System.out.println("This step validates that the results page is displayed with the potential annual benefit.");	
      
    }		

}