package btp_lab3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class RSSFeedWriter {
    private String outputFile;
    private Feed rssfeed;

    public RSSFeedWriter(Feed rssfeed, String outputFile) {
        this.rssfeed = rssfeed;
        this.outputFile = outputFile;
    }

    public void write(ArrayList<String> namesOfFilesToDelete) throws Exception {
    	for(int i=0; i<namesOfFilesToDelete.size(); i++){
    		Path path = FileSystems.getDefault().getPath("tech", namesOfFilesToDelete.get(i));
            deleteFile(path);
    	}
    	
        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(outputFile));
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        
        StartDocument startDocument = eventFactory.createStartDocument("Windows-1251", "1.0");
        
        eventWriter.add(startDocument);
        eventWriter.add(end);
        
        StartElement rssStart = eventFactory.createStartElement("", "", "rss");
        
        eventWriter.add(rssStart);
        eventWriter.add(eventFactory.createAttribute("version", "2.0"));
        eventWriter.add(end);
        
        eventWriter.add(eventFactory.createStartElement("", "", "channel"));
        eventWriter.add(end);

        createNode(eventWriter, "title", rssfeed.getTitle());
        createNode(eventWriter, "link", rssfeed.getLink());
        createNode(eventWriter, "description", rssfeed.getDescription());
        createNode(eventWriter, "language", rssfeed.getLanguage());
        createNode(eventWriter, "pubdate", rssfeed.getPubDate());

        for (FeedMessage entry : rssfeed.getMessages()) {
            eventWriter.add(eventFactory.createStartElement("", "", "item"));
            eventWriter.add(end);
            createNode(eventWriter, "title", entry.getTitle());
            createNode(eventWriter, "description", entry.getDescription());
            createNode(eventWriter, "link", entry.getLink());
            createNode(eventWriter, "author", entry.getAuthor());
            createNode(eventWriter, "guid", entry.getGuid());
            createNode(eventWriter, "pubDate", entry.getPubDate());
            eventWriter.add(end);
            eventWriter.add(eventFactory.createEndElement("", "", "item"));
            eventWriter.add(end);
        }

        eventWriter.add(end);
        eventWriter.add(eventFactory.createEndElement("", "", "channel"));
        eventWriter.add(end);
        eventWriter.add(eventFactory.createEndElement("", "", "rss"));
        eventWriter.add(end);
        eventWriter.add(eventFactory.createEndDocument());
        eventWriter.close();
    }
    
    // this function delete file using the path in Path format
 	public static void deleteFile(Path path){
 		try {
 		    Files.delete(path);
 		} catch (NoSuchFileException x) {
 		    System.err.format("%s: no such" + " file or directory%n", path);
 		} catch (DirectoryNotEmptyException x) {
 		    System.err.format("%s not empty%n", path);
 		} catch (IOException x) {
 			// if that file already exists program will catch exception but it'll do nothing
 		}
 	}

    private void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");
        
        StartElement sElement = eventFactory.createStartElement("", "", name);
        eventWriter.add(tab);
        eventWriter.add(sElement);
        
        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);
        
        EndElement eElement = eventFactory.createEndElement("", "", name);
        eventWriter.add(eElement);
        eventWriter.add(end);
    }
}