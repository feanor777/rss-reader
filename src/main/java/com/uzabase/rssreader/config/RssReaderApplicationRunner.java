package com.uzabase.rssreader.config;

import com.rometools.rome.feed.synd.SyndFeed;
import com.uzabase.rssreader.converter.Pipeline;
import com.uzabase.rssreader.converter.PipelineBuilder;
import com.uzabase.rssreader.rss.RssFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class RssReaderApplicationRunner implements ApplicationRunner {
    @Value("${input}")
    private String input;
    @Value("${convert}")
    private String[] convert;
    @Value("${output:console}")
    private String output;

    private final RssFetcher rssFetcher;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        SyndFeed fetch = rssFetcher.fetch(input);
        Pipeline pipeline = new PipelineBuilder().buildPipeline(convert);
//        Pipeline pipeline = new Pipeline(null);
        pipeline.execute(fetch, Arrays.toString(convert));
    }
}
