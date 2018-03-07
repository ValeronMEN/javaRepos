package btp_lab3;

import java.util.ArrayList;
import java.util.List;

public class Feed {

    final String title;
    final String link;
    final String description;
    final String language;
    final String pubDate;

    List<FeedMessage> entries = new ArrayList<FeedMessage>();

    public Feed(String title, String link, String description, String language, String pubDate) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.language = language;
        this.pubDate = pubDate;
    }

    public List<FeedMessage> getMessages() {
        return entries;
    }
    
    public boolean delete(FeedMessage fm){
    	return entries.remove(fm);
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getPubDate() {
        return pubDate;
    }
    
    public int getSize(){
    	return entries.size();
    }

    @Override
    public String toString() {
        return "Feed [description=" + description
                + ", language=" + language + ", link=" + link + ", pubDate="
                + pubDate + ", title=" + title + "]";
    }
}