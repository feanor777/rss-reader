package com.uzabase.rssreader.output.impl;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedOutput;
import com.uzabase.rssreader.exception.RssFetchException;
import com.uzabase.rssreader.model.OutputType;
import com.uzabase.rssreader.output.OutputWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Slf4j
@Service
public class FileOutputWriter implements OutputWriter {
    @Override
    public OutputType getType() {
        return OutputType.FILE;
    }

    @Override
    public void write(SyndFeed syndFeed, String outputFilePath) {
        try (FileWriter writer = new FileWriter(outputFilePath)) {
            SyndFeedOutput syndFeedOutput = new SyndFeedOutput();
            syndFeedOutput.output(syndFeed, writer);
        } catch (IOException | FeedException e) {
            log.warn("There was an issue with writing feed to the file {}", outputFilePath);
            throw new RssFetchException(e);
        }
    }
}
