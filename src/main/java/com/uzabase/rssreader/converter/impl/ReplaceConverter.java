package com.uzabase.rssreader.converter.impl;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.uzabase.rssreader.converter.Converter;
import com.uzabase.rssreader.model.ConverterParameters;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("trimConverter")
public class ReplaceConverter implements Converter {
    @Override
    public SyndFeed convert(SyndFeed feed, ConverterParameters parameters) {
        ListUtils.emptyIfNull(feed.getEntries())
                .forEach(syndEntry -> replaceEntryContent(syndEntry, parameters.getReplaceFromTo()));

        String description = replaceIfMatchConditions(feed.getDescription(), parameters.getReplaceFromTo());
        String title = replaceIfMatchConditions(feed.getTitle(), parameters.getReplaceFromTo());
        feed.setDescription(description);
        feed.setTitle(title);

        return feed;
    }

    private String replaceIfMatchConditions(String description, Pair<String, String> replaceFromTo) {
        return StringUtils.replace(description, replaceFromTo.getLeft(), replaceFromTo.getRight());
    }

    private SyndEntry replaceEntryContent(SyndEntry syndEntry, Pair<String, String> replaceFromTo) {
        String description = replaceIfMatchConditions(syndEntry.getDescription().getValue(), replaceFromTo);
        String title = replaceIfMatchConditions(syndEntry.getTitle(), replaceFromTo);
        syndEntry.getDescription().setValue(description);
        syndEntry.setTitle(title);

        return syndEntry;
    }
}
