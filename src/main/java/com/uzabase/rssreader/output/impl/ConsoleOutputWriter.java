package com.uzabase.rssreader.output.impl;

import com.uzabase.rssreader.model.OutputType;
import com.uzabase.rssreader.output.OutputWriter;
import org.springframework.stereotype.Service;

@Service
public class ConsoleOutputWriter implements OutputWriter {
    @Override
    public OutputType getType() {
        return OutputType.CONSOLE;
    }

    @Override
    public void write() {

    }
}
