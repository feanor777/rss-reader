package com.uzabase.rssreader.config;

import com.rometools.rome.feed.synd.SyndFeed;
import com.uzabase.rssreader.converter.Pipeline;
import com.uzabase.rssreader.meta.ConverterUtils;
import com.uzabase.rssreader.output.OutputWriterFactory;
import com.uzabase.rssreader.rss.RssFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RssReaderApplicationRunner implements ApplicationRunner {
    @Value("${input}")
    private String input;
    @Value("${convert}")
    private String[] convert;
    @Value("${output}")
    private String output;

    private final RssFetcher rssFetcher;
    private final Pipeline pipeline;

    @Override
    public void run(ApplicationArguments args) {
        SyndFeed fetch = rssFetcher.fetch(input);
        SyndFeed syndFeed = pipeline.execute(fetch, ConverterUtils.getConverterParameters(convert));
        OutputWriterFactory.getOutputWriter(output).write(syndFeed, output);
    }
}
