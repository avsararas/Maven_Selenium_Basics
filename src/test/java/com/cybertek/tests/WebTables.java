package com.cybertek.tests;

import com.cybertek.utils.TestBase;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class WebTables extends TestBase {

    // login method
    public void login(){

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);
    }

    @Test(enabled=false) // useful to prevent errors for not used tests
    public void test(){

        // call login method
        login();
        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());
    }

    @Test
    public void printAllHeaders(){
        login();

        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));

        for (WebElement header: headers) {
            System.out.println(header.getText());
        }
    }

    @Test
    public void printRow(){

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));

        for (WebElement header: allRows) {
            System.out.println(header.getText());
            System.out.println("Number of Rows: "+allRows.size());
        }

        System.out.println("Printing Row "+ 4);
        System.out.println(allRows.get(3).getText());
    }

    @Test
    public void numOfCells(){ // there is no tag for column in HTML

        List<WebElement> allRows = driver.findElements
                (By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));

        System.out.println("No of rows: "+allRows.size());

        List<WebElement> allHeaders = driver.findElements

                // HTML starts wit one
                (By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[1]/th"));
        System.out.println("Number of Cols: " + allHeaders.size() );
    }

    @Test
    public void printRows(){ // there is no tag for column in HTML

        List<WebElement> rows = driver.findElements
                (By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[5]"));

        System.out.println(rows.size());
    }

    @Test
    public void printCells(){ // Note the change in the xpath suffix

        List<WebElement> cells = driver.findElements
                (By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[6]/td[11]"));

        for (WebElement header: cells)
             {
                 System.out.println("Cell Print "+header.getText());
        }
    }

    @Test
    public void printByCoords(){ // Coordinates on the page

        WebElement cell = driver.findElement
                (By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[4]/td"));

        System.out.println("At coords "+cell.getText());

        System.out.println("Coords "+getCell(6,11).getText()); // calls getCell method below

    }

    @Test
    public WebElement getCell(int row, int col){ // Coordinates on the page

        String xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+row+"]/td["+col+"]";

        return driver.findElement(By.xpath(xpath));
    }

    @Test
    public void printCol(){ // Prints rows aligned as a column

        List<WebElement> allNames = driver.findElements
                // list col 2
                        (By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));

        for (WebElement header: allNames) {
            System.out.println(header.getText());
        }
    }

    @Test
    public void selectCheckBox(){

        WebElement cb = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[1]/input"));

        cb.click();
    }

    public int getColidx(String col){ // method to get column index no
        List<WebElement> allHeader = driver.findElements
                (By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));

        for (int i = 0; i <  allHeader.size() ; i++) {
            if (allHeader.get(i).getText().equals(col)){
                return  i+1;
            }
        }
        return 0;
    }

    @Test
    public void nameExists(){

        int nIdx = getColidx("Name");
        System.out.println("Name Exist Result: "+nIdx);

        List <WebElement> allNames  = driver.findElements
                (By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+nIdx+"]"));

        boolean found = true;

        for (int i = 0; i < allNames.size() ; i++) {
            if (allNames.get(i).getText().equals("Mark Smith")){

                //pass or // break
                found = true;
                break;

            }
        }

        Assert.assertTrue(found);

        int cityIdx = getColidx("City");

        List<WebElement> allCities = driver.findElements
                (By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td["+cityIdx+"]"));

        found=false;

        for (int i = 0; i < allCities.size() ; i++) {
            if (allCities.get(i).getText().equals("Whitestone, British"))
            {
                found=true;
                break;
            }
        }
        Assert.assertTrue(found);
    }
}