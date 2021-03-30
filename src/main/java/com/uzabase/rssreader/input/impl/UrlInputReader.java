package com.uzabase.rssreader.input.impl;

import com.uzabase.rssreader.input.InputReader;
import com.uzabase.rssreader.model.InputType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Slf4j
@Service
public class UrlInputReader implements InputReader {
    @Override
    public InputType getType() {
        return InputType.URL;
    }

    @Override
    public InputStream read(String url) {
        try {
            return new URL(url).openStream();
        } catch (IOException e) {
            log.warn("Not able to find the rss feed by current url {}", url);
            throw new RuntimeException(e);
        }
    }
}
