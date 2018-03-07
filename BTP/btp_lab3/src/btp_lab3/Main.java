package btp_lab3;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		RSSFeedHandler handler = new RSSFeedHandler();
		ArrayList<Feed> feeds;
		
		// get RSS news from the Internet
		feeds = handler.getRssThroughUrlList();
		
		// write gotten RSS news to files on the PC
		handler.writeRssFeedsToFile(feeds);
		
		// read RSS news from the PC
		feeds = handler.readRssNewsFromThePc();
		
		// display the array of feeds
		handler.displayArrayOfFeeds(feeds);

		//System.in.read();
		
		// delete the RSS news that are saved more than given number
		long time = 1 * 24 * 60 * 60 * 1000;
		feeds = handler.deleteOldEntries(time, feeds);
		
		// write results to files
		handler.writeRssFeedsToFile(feeds);
		
		System.out.println(" ");
		
		// get 10 RSS news by criterion
		ArrayList<FeedMessage> feedMessByCriterion = handler.getFeedsByCriterion(feeds);
		
		// display the array of FeedMessages
		try{
			handler.displayArrayOfFeedMessages(feedMessByCriterion);
		}catch(Exception e){
			System.out.println("There's error: "+ e);
		}
		
        System.out.println("Program has finished");
	}
}
