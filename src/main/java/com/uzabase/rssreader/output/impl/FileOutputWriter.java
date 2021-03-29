package com.uzabase.rssreader.output.impl;

import com.uzabase.rssreader.model.OutputType;
import com.uzabase.rssreader.output.OutputWriter;
import org.springframework.stereotype.Service;

@Service
public class FileOutputWriter implements OutputWriter {
    @Override
    public OutputType getType() {
        return OutputType.FILE;
    }

    @Override
    public void write() {

    }
}
