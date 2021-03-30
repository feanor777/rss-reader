package com.uzabase.rssreader.rss;

import com.rometools.rome.feed.synd.SyndFeed;

public interface RssFetcher {
    SyndFeed fetch(String rssInput);
}
