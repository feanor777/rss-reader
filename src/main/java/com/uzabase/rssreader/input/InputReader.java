package com.uzabase.rssreader.input;

import com.uzabase.rssreader.model.InputType;

public interface InputReader {
    InputType getType();
    String read();
}
