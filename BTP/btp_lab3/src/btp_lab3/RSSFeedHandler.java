package btp_lab3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RSSFeedHandler {
	public static final String stopWordsPath = "C:\\Users\\DrLove\\workspace\\btp_lab3\\stop-words.txt";
	public static final String listOfRssSourses = "C:\\Users\\DrLove\\workspace\\btp_lab3\\listOfNewsOfRSS.txt";
	
	public RSSFeedHandler(){}
	
	public ArrayList<Feed> getRssThroughUrlList(){
		ArrayList<String> listOfUrls = readFileLines(listOfRssSourses);
		ArrayList<Feed> listOfFeeds = new ArrayList<Feed>();
        for(int i=0; i<listOfUrls.size(); i++){
        	RSSFeedParser parser = new RSSFeedParser();
        	parser.setUrl(listOfUrls.get(i));
            Feed feed = parser.readFeedThroughURL();
            listOfFeeds.add(feed);
        }
        return listOfFeeds;
	}
	
	public ArrayList<Feed> readRssNewsFromThePc(){
		RSSFeedParser reader = new RSSFeedParser();
		return reader.readAll(getRssFeedNamesFromFolder());
	}
	
	public void displayArrayOfFeeds(ArrayList<Feed> feeds){
		for(int i=0; i<feeds.size(); i++){
			Feed feed = feeds.get(i);
			List<FeedMessage> messages = feed.getMessages();
			System.out.println(feed.toString());
			for(int j=0; j<messages.size(); j++){
				System.out.println("----" + messages.get(j).toString());
			}
		}
	}
	
	public void displayArrayOfFeedMessages(ArrayList<FeedMessage> list) throws Exception{
		if (list == null){
			throw new Exception("PRINTING LIST: FeedMessage list is null");
		}
		System.out.println("Feed Messeges: ");
		for(FeedMessage mess : list){
			System.out.println(mess.toString());
		}
	}
	
	public ArrayList<Feed> deleteOldEntries(long amountOfMiliseconds, ArrayList<Feed> allfeeds) throws Exception{
		if (amountOfMiliseconds < 0 || allfeeds == null){
			throw new Exception("Invalid entry!");
		}
		for (Feed feed : allfeeds){
			List<FeedMessage> listOfFeedMess = feed.getMessages();
			ArrayList<FeedMessage> listOfFeedMessToRemove = new ArrayList<FeedMessage>();
			for (FeedMessage feedmess : listOfFeedMess){
				String pubDate = feedmess.getPubDate();
				SimpleDateFormat date_format = new SimpleDateFormat("EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z", Locale.US);
				Date date = date_format.parse(pubDate, new ParsePosition(0));
				if (date == null){
					throw new Exception("There's a date that has incorrect format");
				}
				Date dateNow = new Date();
				long difference = dateNow.getTime() - date.getTime();
				if (difference < amountOfMiliseconds){
					listOfFeedMessToRemove.add(feedmess);
				}
			}
			for (FeedMessage fm : listOfFeedMessToRemove){
				feed.delete(fm);
			}
		}
		return allfeeds;
	}
	
	public ArrayList<FeedMessage> getFeedsByCriterion(ArrayList<Feed> allFeeds){
		ArrayList<String> stopwords = readFileLines(stopWordsPath);
		Scanner in = null;
		String word;
		try {
		    in = new Scanner(System.in);
		    while(true){
		    	boolean toExit = true;
				System.out.println("Type a word to index feeds");
				word = in.nextLine();
				for (String stopword : stopwords){
					if (word.equals(stopword)){
						System.out.println("There's the same word in the stopwords list");
						toExit = false;
					}
				}
				if (toExit)
					break;
			}
		}
		finally {
		    if (in != null)
		        in.close();
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (Feed feed : allFeeds){
			for (FeedMessage feedMess : feed.getMessages()){
				String str = feedMess.getFullInfo();
		        Pattern p = Pattern.compile(word);
		        Matcher m = p.matcher(str);
		        int counter = 0;
		        while(m.find()) {
	                counter++;
	            }
		        if (counter != 0){
		        	map.put(feedMess.getTitle(), counter);
		        }
			}
		}
		if (map.size() == 0){
			System.out.println("This word is absent in feed messages");
			return null;
		}
		map = sortMapByValue(map);
		return getFeedMessagesFromTheTopOfMap(map, allFeeds, 10);
	}
	
	// this method writes RSS Feeds from list to the PC
	public void writeRssFeedsToFile(ArrayList<Feed> listOfFeeds){
        for(int i=0; i<listOfFeeds.size(); i++){
        	String nameOfRssFile = "tech\\source"+(i)+".rss";
        	RSSFeedWriter writer = new RSSFeedWriter(listOfFeeds.get(i), nameOfRssFile);
            try {
                writer.write(getRssFeedNamesFromFolder());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
	}
		
	// sorts Map <String, Integer> by integer value
	private Map<String, Integer> sortMapByValue(Map<String, Integer> unsortMap) {
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
	
	// this method returns given number of FeedMessages based on map (it starts to count from the top of map)
	private ArrayList<FeedMessage> getFeedMessagesFromTheTopOfMap(Map<String, Integer> map, ArrayList<Feed> allFeeds, int maxSizeOfFeedMessages) {
		ArrayList<FeedMessage> list = new ArrayList<FeedMessage>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
        	String name = entry.getKey();
        	for (Feed feed : allFeeds){
    			for (FeedMessage feedMess : feed.getMessages()){
    				if (name == feedMess.getTitle()){
    					list.add(feedMess);
    					if (list.size() == maxSizeOfFeedMessages){
    						return list;
    					}
    				}
    			}
        	}
        }
        return list;
    }
	
	// this method gets names of RSS files from the 'tech' folder
	private ArrayList<String> getRssFeedNamesFromFolder(){    
		File F = new File("C:\\Users\\DrLove\\workspace\\btp_lab3\\tech");
		File [] fList = F.listFiles();
		ArrayList<String> listOfRssFiles = new ArrayList<String>();
		
		for(int i=0; i<fList.length; i++)           
		{
		   if(fList[i].isFile()){
			   String name = fList[i].getName();
			   // Uncomment this string if u want check list of file names in the folder
			   // System.out.println(String.valueOf(i) + " - " + name);
			   listOfRssFiles.add(name);
		   }  
		}
		return listOfRssFiles;
	}
	
	// this method reads file from the PC and returns array of strings from that
	private ArrayList<String> readFileLines(String file_path){
		ArrayList<String> list = new ArrayList<String>();
		try(FileReader reader = new FileReader(file_path))
	    {
			BufferedReader buff = new BufferedReader(reader);
			String str = buff.readLine();
	        while(str != null){
	        	list.add(str);
	        	str = buff.readLine();
	        }
	        buff.close();
	    }
	    catch(IOException ex){       
	        System.out.println(ex.getMessage());
	    }
		return list;
	}
}
