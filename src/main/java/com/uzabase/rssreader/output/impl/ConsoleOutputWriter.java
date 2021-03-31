package com.uzabase.rssreader.output.impl;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedOutput;
import com.uzabase.rssreader.exception.RssFetchException;
import com.uzabase.rssreader.model.OutputType;
import com.uzabase.rssreader.output.OutputWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@Service
public class ConsoleOutputWriter implements OutputWriter {
    @Override
    public OutputType getType() {
        return OutputType.CONSOLE;
    }

    @Override
    public void write(SyndFeed syndFeed, String output) {
        try (PrintWriter writer = new PrintWriter(System.out)) {
            SyndFeedOutput syndFeedOutput = new SyndFeedOutput();
            syndFeedOutput.output(syndFeed, writer);
        } catch (IOException | FeedException e) {
            log.warn("There was an issue with writing feed to the console");
            throw new RssFetchException(e);
        }
    }
}
