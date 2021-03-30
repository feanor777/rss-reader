package com.uzabase.rssreader.converter;

import com.rometools.rome.feed.synd.SyndFeed;

public interface Converter {
    SyndFeed convert(SyndFeed feed, String parameters);
}
