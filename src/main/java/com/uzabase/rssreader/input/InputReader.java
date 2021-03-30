package com.uzabase.rssreader.input;

import com.uzabase.rssreader.model.InputType;

import java.io.InputStream;

public interface InputReader {
    InputType getType();
    InputStream read(String rssInput);
}
