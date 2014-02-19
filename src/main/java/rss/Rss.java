package rss;


public class Rss { 
        private String version;
		private Channel channel;
        public Channel getChannel() {
			return channel;
		}
		public String getVersion() {
			return version;
		}
		public Rss setVersion(final String version) {
			this.version = version;
			return this;
		}
		public Rss setChannel(final Channel channel) {
			this.channel = channel;
			return this;
		} 
} 