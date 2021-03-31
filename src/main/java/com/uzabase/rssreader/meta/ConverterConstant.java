package com.uzabase.rssreader.meta;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.tuple.Pair;

@UtilityClass
public class ConverterConstant {
    public static final String REPLACE_CONVERTER_KEYWORD = "replace";
    public static final String TRIM_CONVERTER_KEYWORD = "cut";

    public static final Pair<String, String> DUMMY_REPLACER = Pair.of("", "");

    public static final String SED_PATTERN_SEPARATER = "/";
}
