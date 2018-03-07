package btp_lab3;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Test;

public class Tests {
	RSSFeedHandler handler = mock(RSSFeedHandler.class);
	RSSFeedParser parser = mock(RSSFeedParser.class);
	RSSFeedWriter writer = mock(RSSFeedWriter.class);
	
	@Test
	public void ifAReaderIsARssFeedReader() {
	    assertTrue(parser instanceof RSSFeedParser);
	}
	
	@Test
	public void ifAHandlerIsARssFeedHandler() {
	    assertTrue(handler instanceof RSSFeedHandler);
	}
	
	@Test
	public void compareTwoArraysOfFeeds_nothing_true() {
		ArrayList<Feed> feeds1 = handler.getRssThroughUrlList();
		handler.writeRssFeedsToFile(feeds1);
		ArrayList<Feed> feeds2 = handler.readRssNewsFromThePc();
		assertEquals(feeds1, feeds2);
	}
	
	@Test
	public void test() throws Exception{
		handler.deleteOldEntries(0, null);
		handler.getRssThroughUrlList();
		handler.displayArrayOfFeedMessages(null);
		handler.displayArrayOfFeeds(null);
		handler.writeRssFeedsToFile(null);
		handler.readRssNewsFromThePc();
		handler.getFeedsByCriterion(null);
		
		verify(handler).deleteOldEntries(0, null);
		verify(handler).getRssThroughUrlList();
		verify(handler).displayArrayOfFeedMessages(null);
		verify(handler).displayArrayOfFeeds(null);
		verify(handler).writeRssFeedsToFile(null);
		verify(handler).readRssNewsFromThePc();
		verify(handler).getFeedsByCriterion(null);
	}
}
