package com.uzabase.rssreader.output;

import com.uzabase.rssreader.exception.OutputWriterNotFoundException;
import com.uzabase.rssreader.meta.OutputTypeDetector;
import com.uzabase.rssreader.model.OutputType;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class OutputWriterFactory {
    private static final Map<OutputType, OutputWriter> OUTPUT_TYPE_TO_OUTPUT_WRITER = new EnumMap<>(OutputType.class);

    public OutputWriterFactory(List<OutputWriter> outputWriters) {
        outputWriters.forEach(outputWriter -> OUTPUT_TYPE_TO_OUTPUT_WRITER.put(outputWriter.getType(), outputWriter));
    }

    public static OutputWriter getOutputWriter(String outputType) {
        OutputWriter outputWriter = OUTPUT_TYPE_TO_OUTPUT_WRITER.get(OutputTypeDetector.getOutputType(outputType));
        if(outputWriter == null) {
            throw new OutputWriterNotFoundException("Output write for the output " + outputType + " does not exist!");
        }

        return outputWriter;
    }
}
