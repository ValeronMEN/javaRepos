package btp_lab3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.XMLEvent;

public class RSSFeedParser {
    static final String TITLE = "title";
    static final String DESCRIPTION = "description";
    static final String CHANNEL = "channel";
    static final String LANGUAGE = "language";
    static final String COPYRIGHT = "copyright";
    static final String LINK = "link";
    static final String AUTHOR = "author";
    static final String ITEM = "item";
    static final String PUB_DATE = "pubDate";
    static final String GUID = "guid";

    URL url;

    public RSSFeedParser() {}
    
    public void setUrl(String feedUrl) throws RuntimeException {
    	try {
            this.url = new URL(feedUrl);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Feed readFeedThroughURL(){
    	return readFeed(readUrl());
    }
    
    public ArrayList<Feed> readAll(ArrayList<String> names) throws RuntimeException {
    	ArrayList<Feed> listOfFeeds = new ArrayList<Feed>();
    	for (int i=0; i<names.size(); i++){
    		String path = "C:\\Users\\DrLove\\workspace\\btp_lab3\\tech\\"+names.get(i);
    		try{
    			InputStream in = new FileInputStream(new File(path));
    			listOfFeeds.add(readFeed(in));
    		} catch (FileNotFoundException e) {
                throw new RuntimeException("File Not Found!\n"+e);
            }
    	}
    	return listOfFeeds;
    }

    public Feed readFeed(InputStream in) throws RuntimeException {
        Feed feed = null;
        try {
            boolean isFeedHeader = true;
            
            String description = "";
            String title = "";
            String link = "";
            String language = "";
            String author = "";
            String pubdate = "";
            String guid = "";

            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    String localPart = event.asStartElement().getName()
                            .getLocalPart();
                    switch (localPart) {
                    case ITEM:
                        if (isFeedHeader) {
                            isFeedHeader = false;
                            feed = new Feed(title, link, description, language, pubdate);
                        }
                        event = eventReader.nextEvent();
                        break;
                    case TITLE:
                        title = getCharacterData(event, eventReader);
                        break;
                    case DESCRIPTION:
                        description = getCharacterData(event, eventReader);
                        break;
                    case LINK:
                        link = getCharacterData(event, eventReader);
                        break;
                    case GUID:
                        guid = getCharacterData(event, eventReader);
                        break;
                    case LANGUAGE:
                        language = getCharacterData(event, eventReader);
                        break;
                    case AUTHOR:
                        author = getCharacterData(event, eventReader);
                        break;
                    case PUB_DATE:
                        pubdate = getCharacterData(event, eventReader);
                        break;
                    }
                } else if (event.isEndElement()) {
                    if (event.asEndElement().getName().getLocalPart() == (ITEM)) {
                        FeedMessage message = new FeedMessage();
                        message.setAuthor(author);
                        message.setDescription(description);
                        message.setGuid(guid);
                        message.setLink(link);
                        message.setTitle(title);
                        message.setPubDate(pubdate);
                        feed.getMessages().add(message);
                        event = eventReader.nextEvent();
                        continue;
                    }
                }
            }
        } catch (XMLStreamException e) {
            throw new RuntimeException();
        } 
        return feed;
    }

    private String getCharacterData(XMLEvent event, XMLEventReader eventReader) throws XMLStreamException {
        String result = "";
        event = eventReader.nextEvent();
        if (event instanceof Characters) {
            result = event.asCharacters().getData();
        }
        return result;
    }

    private InputStream readUrl() throws RuntimeException {
        try {
            return url.openStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}