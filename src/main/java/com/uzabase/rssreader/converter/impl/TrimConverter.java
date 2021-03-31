package com.uzabase.rssreader.converter.impl;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.uzabase.rssreader.converter.Converter;
import com.uzabase.rssreader.model.ConverterParameters;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("trimConverter")
public class TrimConverter implements Converter {

    public static final int TRIM_LENGTH_LIMIT = 10;

    @Override
    public SyndFeed convert(SyndFeed feed, ConverterParameters parameters) {
        ListUtils.emptyIfNull(feed.getEntries())
                .forEach(this::trimEntryContent);

        String description = trimIfExceedLimit(feed.getDescription());
        String title = trimIfExceedLimit(feed.getTitle());
        feed.setDescription(description);
        feed.setTitle(title);

        return feed;
    }

    private SyndEntry trimEntryContent(SyndEntry syndEntry) {
        String title = trimIfExceedLimit(syndEntry.getTitle());
        String description = trimIfExceedLimit(syndEntry.getDescription().getValue());
        syndEntry.setTitle(title);
        syndEntry.getDescription().setValue(description);

        return syndEntry;
    }

    private String trimIfExceedLimit(String text) {
        if (StringUtils.length(text) > TRIM_LENGTH_LIMIT) {
            return StringUtils.trim(text);
        }

        return text;
    }
}
