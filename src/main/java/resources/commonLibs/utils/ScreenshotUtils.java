package resources.commonLibs.utils;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class ScreenshotUtils {
	
	private TakesScreenshot screenshot;
	
	public ScreenshotUtils(WebDriver driver) {
		
		screenshot = (TakesScreenshot)driver;
	}
	
	public void captureAndSaveScreenshot(String filename) throws Exception {
		
		filename = filename.trim();
		
		File imageFile;
		File tempFile;
		
		imageFile = new File(filename);
		
		if (imageFile.exists()) {
			throw new Exception("File already exist.");
		}
		
		tempFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tempFile, imageFile);
	}

}
