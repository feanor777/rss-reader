package com.uzabase.rssreader.converter;

import com.rometools.rome.feed.synd.SyndFeed;
import com.uzabase.rssreader.model.ConverterParameters;

public interface Converter {
    SyndFeed convert(SyndFeed feed, ConverterParameters parameters);
}
