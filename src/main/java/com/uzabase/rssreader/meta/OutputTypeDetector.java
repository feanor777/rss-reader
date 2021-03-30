package com.uzabase.rssreader.meta;

import com.uzabase.rssreader.model.OutputType;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class OutputTypeDetector {

    public static OutputType getOutputType(String outputType) {
        if(StringUtils.isEmpty(outputType)) {
            return OutputType.CONSOLE;
        }

        return OutputType.FILE;
    }
}
