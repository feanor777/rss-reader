package com.uzabase.rssreader.input.impl;

import com.uzabase.rssreader.input.InputReader;
import com.uzabase.rssreader.model.InputType;
import org.springframework.stereotype.Service;

@Service
public class FileInputReader implements InputReader {
    @Override
    public InputType getType() {
        return InputType.FILE;
    }

    @Override
    public String read() {
        return null;
    }
}
