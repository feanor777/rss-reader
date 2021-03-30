package com.uzabase.rssreader.converter.impl;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.uzabase.rssreader.converter.Converter;
import org.apache.commons.collections4.ListUtils;
import org.springframework.stereotype.Service;

@Service
public class ReplaceConverter implements Converter {
    @Override
    public SyndFeed convert(SyndFeed feed, String parameters) {
        ListUtils.emptyIfNull(feed.getEntries())
                .forEach(this::replaceEntryContent);

        String description = replaceIfMatchConditions(feed.getDescription());
        String title = replaceIfMatchConditions(feed.getTitle());
        feed.setDescription(description);
        feed.setTitle(title);

        return feed;
    }

    private String replaceIfMatchConditions(String description) {
        return null;
    }

    private void replaceEntryContent(SyndEntry syndEntry) {
    }
}
