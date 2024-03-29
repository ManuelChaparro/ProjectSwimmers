package managerProperties;

import java.io.IOException;
import java.util.Properties;

public class HandlerLanguage {
	public String fileName;
	public static String language = "undefined";
	public static Properties languageProperties;
	
	public HandlerLanguage(String fileName){
		this.fileName = fileName;
	}
	
	public void loadLanguage() throws IOException{		
		HandlerProperties handlerproperties = new HandlerProperties(fileName);
		handlerproperties.load();
		language = handlerproperties.getProperty("Language");
		
		HandlerProperties handlerLanguageProperties = new HandlerProperties(language);
		handlerLanguageProperties.load();
		languageProperties = handlerLanguageProperties;
	}
	
	public void saveLanguage() throws IOException{
		HandlerProperties handlerproperties = new HandlerProperties(fileName);
		handlerproperties.load();
		handlerproperties.setProperty("Language", language);
		handlerproperties.save();
	}	
}