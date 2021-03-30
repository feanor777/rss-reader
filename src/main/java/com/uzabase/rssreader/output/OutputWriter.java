package com.uzabase.rssreader.output;

import com.rometools.rome.feed.synd.SyndFeed;
import com.uzabase.rssreader.model.OutputType;

public interface OutputWriter {
    OutputType getType();
    void write(SyndFeed syndFeed, String output);
}
