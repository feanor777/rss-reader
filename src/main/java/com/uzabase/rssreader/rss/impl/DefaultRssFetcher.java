package com.uzabase.rssreader.rss.impl;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.uzabase.rssreader.input.InputReaderFactory;
import com.uzabase.rssreader.rss.RssFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@Service
public class DefaultRssFetcher implements RssFetcher {

    @Override
    public SyndFeed fetch(String rssInput) {
        InputStream rssInputStream = InputReaderFactory.getInputReader(rssInput).read(rssInput);

        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed;
        try {
            feed = input.build(new XmlReader(rssInputStream));
        } catch (FeedException | IOException e) {
            log.warn("There is a problem to read the feed from the input stream");
            throw new RuntimeException("asdfa");
        }

        return feed;
    }
}
