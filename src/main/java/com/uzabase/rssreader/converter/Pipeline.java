package com.uzabase.rssreader.converter;

import com.rometools.rome.feed.synd.SyndFeed;
import com.uzabase.rssreader.model.ConverterParameters;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Pipeline {
    private final Converter currentConverter;

    public Pipeline addConverter(Converter newConverter) {
        return new Pipeline((feed, parameters) -> newConverter.convert(currentConverter.convert(feed, parameters), parameters));
    }

    public SyndFeed execute(SyndFeed feed, ConverterParameters parameters) {
        return currentConverter.convert(feed, parameters);
    }
}
