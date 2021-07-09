package Object_Repository_Xpath;

public class OneMap_FrontPage {

	
		//Used XPATH's
		public static String Frontpopup 				= "//span[contains(text(),'Got it, do not show again')]//following-sibling::img";
		public static String Location 				= "//body[1]/div[1]/screenshot[1]/div[1]/div[8]/div[7]";
		public static String smiley 			= "return document.querySelector('wog-sentiments').shadowRoot.querySelector('div').querySelector('wog-floating-action-button').shadowRoot.querySelector('div')";
		public static String search 						= "//input[@id='search-text']";	
		public static String lists 						= "(//div[@id='search-scroller'])[1]//descendant::div[@class='item ng-scope']";
		public static String SchoolQuery 						= "(//span[@class='topView_text' and contains(text(),'SchoolQuery')])[1]";
		public static String sec 						="//button[contains(text(),'Find Secondary School Information')]";
		public static String Agreebutton 						= "//label[contains(text(),'I Agree')]";
		public static String multipleoptions                                      ="//a[@class=\"wb collapsed\"]";
		public static String PopulationQuery              = "(//span[@class=\"topView_text\" and contains(text(),'PopulationQuery')])[2]";
		public static String element                 = "//a[contains(text(),'Get Started')]";
		
	}


