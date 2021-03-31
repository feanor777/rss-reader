package com.uzabase.rssreader.input.impl;

import com.uzabase.rssreader.exception.RssFetchException;
import com.uzabase.rssreader.input.InputReader;
import com.uzabase.rssreader.model.InputType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@Slf4j
@Service
public class FileInputReader implements InputReader {
    @Override
    public InputType getType() {
        return InputType.FILE;
    }

    @Override
    public InputStream read(String filePath) {
        try {
            return new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            log.warn("Not able to find the file with the provided location {}", filePath);
            throw new RssFetchException(e);
        }
    }
}
