package com.uzabase.rssreader.model;

import lombok.Data;
import org.apache.commons.lang3.tuple.Pair;

@Data
public class ConverterParameters {
    private final Pair<String, String> replaceFromTo;
}
