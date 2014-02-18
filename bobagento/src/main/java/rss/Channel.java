package rss;

import java.util.ArrayList;
import java.util.List;

public class Channel { 
        private String title; 
        private String description; 
        private String link; 
        private String lastBuildDate;
        private String pubDate;
        private String ttl;
        private String language; 
        private String generator; 
        private final List<Item> item; 
        
        public Channel() {
			item = new ArrayList<Item>();
		}
        
        public String getTitle() {
			return title;
		}
		public Channel setTitle(final String title) {
			this.title = title;
			return this;
		}
		public String getLink() {
			return link;
		}
		public Channel setLink(final String link) {
			this.link = link;
			return this;
		}
		public String getDescription() {
			return description;
		}
		public Channel setDescription(final String description) {
			this.description = description;
			return this;
		}
		public String getLanguage() {
			return language;
		}
		public Channel setLanguage(final String language) {
			this.language = language;
			return this;
		}
		public String getLastBuildDate() {
			return lastBuildDate;
		}
		public Channel setLastBuildDate(final String lastBuildDate) {
			this.lastBuildDate = lastBuildDate;
			return this;
		}
		public String getGenerator() {
			return generator;
		}
		public Channel setGenerator(final String generator) {
			this.generator = generator;
			return this;
		}
		
		public void addItem(final Item item) {
			this.item.add(item);
		}

		public String getPubDate() {
			return pubDate;
		}

		public Channel setPubDate(final String pubDate) {
			this.pubDate = pubDate;
			return this;
		}

		public String getTtl() {
			return ttl;
		}

		public Channel setTtl(final String ttl) {
			this.ttl = ttl;
			return this;
		}
} 