package com.uzabase.rssreader.meta;

import com.uzabase.rssreader.model.InputType;
import lombok.experimental.UtilityClass;
import org.apache.commons.validator.routines.UrlValidator;

@UtilityClass
public class InputTypeDetector {

    public static InputType getInputType(String inputType) {
        if (UrlValidator.getInstance().isValid(inputType)) {
            return InputType.URL;
        }

        return InputType.FILE;
    }
}
