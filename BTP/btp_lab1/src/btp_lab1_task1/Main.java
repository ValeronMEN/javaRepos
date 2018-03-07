package btp_lab1_task1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) {
		String text;
		String path_newline = "E:\\Program Files\\materials\\btp_lab1\\regexp1.txt";
		String path_conttext = "E:\\Program Files\\materials\\btp_lab1\\regexp2.txt";
		String pattern = "%[0-9]+#(#|%)[A-Z]*%/.";
		Pattern p = Pattern.compile(pattern);
		
		System.out.println("--------File ¹1--------");
		text = readFile(path_newline);
		System.out.println("Source text: \n" + text + "\n");
        System.out.print("Words: \n");
        ArrayList<String> list = readFileLines(path_newline);
        for (int i = 0; i < list.size(); i++){
        	Matcher m = p.matcher(list.get(i));
        	if(m.matches()){
        		System.out.println(list.get(i));
            }
        }
        
        System.out.println("--------File ¹2--------");
        text = readFileLine(path_conttext);
        System.out.println("Source text: " + text);
        System.out.print("Index:       ");
        for (int i=0; i<text.length(); i++){
        	System.out.print(i % 10);
        }
        System.out.print("\nDecade:      ");
        for (int i=0; i<text.length(); i++){
        	if (i % 10 == 0)
        	    System.out.print((i / 10) % 10);
        	else
        		System.out.print(" ");
        }
        System.out.println("");
        Matcher m = p.matcher(text);
        m = p.matcher(text);
        while(m.find()){
            System.out.println("In position [" + m.start() + ";" + (m.end()-1) + "] the word is " + text.substring(m.start(), m.end()));
        }
	}
	
	private static String readFile(String file_path){
		String content = "";
		try(FileReader reader = new FileReader(file_path))
	    {
	        int c;
	        while((c=reader.read()) != -1){
	        	content  += (char)c;
	        }
	    }
	    catch(IOException ex){       
	        System.out.println(ex.getMessage());
	    }
		return content;
	}
	
	private static ArrayList<String> readFileLines(String file_path){
		ArrayList<String> list = new ArrayList<String>();
		try(FileReader reader = new FileReader(file_path))
	    {
			BufferedReader buff = new BufferedReader(reader);
	        while(buff.readLine() != null){
	        	list.add(buff.readLine());
	        }
	        buff.close();
	    }
	    catch(IOException ex){       
	        System.out.println(ex.getMessage());
	    }
		return list;
	}
	
	private static String readFileLine(String file_path){
		String textToReturn = null;
		try(FileReader reader = new FileReader(file_path))
	    {
			BufferedReader buff = new BufferedReader(reader);
			textToReturn = buff.readLine();
	        buff.close();
	    }
	    catch(IOException ex){       
	        System.out.println(ex.getMessage());
	    }
		return textToReturn;
	}
}
