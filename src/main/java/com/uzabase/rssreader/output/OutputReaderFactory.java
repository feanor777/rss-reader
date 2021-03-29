package com.uzabase.rssreader.output;

import com.uzabase.rssreader.exception.OutputWriterNotFoundException;
import com.uzabase.rssreader.model.OutputType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class OutputReaderFactory {
    private static final Map<OutputType, OutputWriter> OUTPUT_TYPE_TO_OUTPUT_WRITER = new EnumMap<>(OutputType.class);

    public OutputReaderFactory(List<OutputWriter> outputWriters) {
        outputWriters.forEach(outputWriter -> OUTPUT_TYPE_TO_OUTPUT_WRITER.put(outputWriter.getType(), outputWriter));
    }

    public static OutputWriter getOutputWriter(OutputType outputType) {
        OutputWriter outputWriter = OUTPUT_TYPE_TO_OUTPUT_WRITER.get(outputType);
        if(outputWriter == null) {
            throw new OutputWriterNotFoundException("Output write for the output " + outputType + " does not exist!");
        }

        return outputWriter;
    }
}
