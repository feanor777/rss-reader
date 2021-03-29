package com.uzabase.rssreader.output;

import com.uzabase.rssreader.model.OutputType;

public interface OutputWriter {
    OutputType getType();
    void write();
}
