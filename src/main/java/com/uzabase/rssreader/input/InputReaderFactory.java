package com.uzabase.rssreader.input;

import com.uzabase.rssreader.exception.InputReaderNotFoundException;
import com.uzabase.rssreader.meta.InputTypeDetector;
import com.uzabase.rssreader.model.InputType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class InputReaderFactory {
    private static final Map<InputType, InputReader> INPUT_TYPE_TO_INPUT_READER = new EnumMap<>(InputType.class);

    public InputReaderFactory(List<InputReader> inputReaders) {
        inputReaders.forEach(inputReader -> INPUT_TYPE_TO_INPUT_READER.put(inputReader.getType(), inputReader));
    }

    public static InputReader getInputReader(String textInputType) {
        InputType inputType = InputTypeDetector.getInputType(textInputType);
        InputReader inputReader = INPUT_TYPE_TO_INPUT_READER.get(inputType);
        if(inputReader == null) {
            throw new InputReaderNotFoundException("Input reader for the input " + inputType + " does not exist!");
        }

        return inputReader;
    }
}
