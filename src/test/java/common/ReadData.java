package common;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//this file will read username & password from the text file 

public class ReadData 

{
	public static  String MyUser = null;
	public static  String pass = null;
	static String file = "D:/Dhan-Selenium/MySelCode/FrameworkFirstcry/FirstCryCredentials.txt";
	private static String ItemFile = "D:/Dhan-Selenium/MySelCode/FrameworkFirstcry/SearchItem.txt";
	public static  String Item1 = null;
	public static  String Item2 = null;
	public static void readCredentials()
	{
		try
		{
			Path path = Paths.get(file);
			/*byte b [] = Files.readAllBytes(path);
			for (int i =0; i< b.length ;i ++)
			{
				System.out.println(b[i]);
			}*/
			List <String> list = Files.readAllLines(path,StandardCharsets.UTF_8);
			//			for (String line : list)  //line is string class object which hold value from list refernce
			//			{
			MyUser = list.get(0);
			System.out.println(MyUser);
			pass = list.get(1);
			System.out.println(pass);
			//}
		}

		catch (IOException e)
		{
			System.out.println(e);
		}
	}

	//below method will read items from your text file
	public static void readItem()
	{
		try
		{
			Path ItemPath = Paths.get(ItemFile);
			List <String> listItem = Files.readAllLines(ItemPath,StandardCharsets.UTF_8);
			/*while(listItem!=null)
			{
				String Item = listItem.get(0);
				
			}*/
			Item1 = listItem.get(0);
			Item2 = listItem.get(1);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}


}
