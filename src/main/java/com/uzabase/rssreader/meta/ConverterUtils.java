package com.uzabase.rssreader.meta;

import com.uzabase.rssreader.model.ConverterParameters;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;

@UtilityClass
public class ConverterUtils {

    public static ConverterParameters getConverterParameters(String[] convert) {
        Pair<String, String> replaceFromTo = Arrays.stream(convert)
                .filter(convertArgument -> convertArgument.contains(ConverterConstant.REPLACE_CONVERTER_KEYWORD))
                .findFirst()
                .map(ConverterUtils::mapSedToPair)
                .orElse(ConverterConstant.DUMMY_REPLACER);

        return new ConverterParameters(replaceFromTo);
    }

    /**
     * Map SED pattern replace(/abc/def/) to Pair of [abc] to [def]
     */
    private static Pair<String, String> mapSedToPair(String sedPattern) {
        String[] sedPatternArr = sedPattern.split(ConverterConstant.SED_PATTERN_SEPARATER);
        return Pair.of(sedPatternArr[1], sedPatternArr[2]);
    }
}
