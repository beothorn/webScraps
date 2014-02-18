package rss;
public class Item { 
        private String title; 
        private String description; 
        private String link; 
        private String guid;
        private String pubDate;
        
		public String getTitle() {
			return title;
		}
		public Item setTitle(final String title) {
			this.title = title;
			return this;
		}
		public String getLink() {
			return link;
		}
		public Item setLink(final String link) {
			this.link = link;
			return this;
		}
		public String getDescription() {
			return description;
		}
		public Item setDescription(final String description) {
			this.description = description;
			return this;
		}
		public String getPubDate() {
			return pubDate;
		}
		public Item setPubDate(final String pubDate) {
			this.pubDate = pubDate;
			return this;
		}
		public String getGuid() {
			return guid;
		}
		public Item setGuid(final String guid) {
			this.guid = guid;
			return this;
		}
} 