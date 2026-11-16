package constant;

public class Constant {
	
	public static final String CONFIGFILE= System.getProperty("user.dir")+"\\src\\main\\resources\\Config.property";
	public static final String TESTDATA=System.getProperty("user.dir")+"\\src\\test\\resources\\groceryData.xlsx";
	public static final String VALIDCREDENTIALERROR="User is unable to login with valid credentials";
	public static final String VALIDANDINVALIDERROR="User is able to login with correct username and incorrect password";
	public static final String INVALIDANDVALIDERROR="User is able to login with incorrect username and correct password";
	public static final String INVALIDCREDENTIALSERROR="User is able to login with invalid credentials";
	public static final String LOGOUTERROR="User is unable to logout";
	public static final String NEWCATEGORYERROR="User is not created";
	public static final String SEARCHCATEGORYERROR="Category not found";
	public static final String NEWDELIVERYBOYERROR="User is not created";
	
	
}
