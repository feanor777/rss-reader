package com.uzabase.rssreader.converter.impl;

import com.rometools.rome.feed.synd.SyndFeed;
import com.uzabase.rssreader.converter.Converter;
import com.uzabase.rssreader.model.ConverterParameters;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Dummy converter which isn't doing any operations with the feed
 */
@Service
@Qualifier("dummyConverter")
public class DummyConverter implements Converter {
    @Override
    public SyndFeed convert(SyndFeed feed, ConverterParameters parameters) {
        return feed;
    }
}
