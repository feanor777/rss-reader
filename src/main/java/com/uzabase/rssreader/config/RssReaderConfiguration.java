package com.uzabase.rssreader.config;

import com.uzabase.rssreader.converter.Converter;
import com.uzabase.rssreader.converter.Pipeline;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RssReaderConfiguration {
    public static final String TRIM_CONVERTER = "cut";
    public static final String REPLACE_CONVERTER = "convert";

    private final Converter replaceConverter;
    private final Converter trimConverter;

    public RssReaderConfiguration(
            @Qualifier("replaceConverter") Converter replaceConverter,
            @Qualifier("trimConverter") Converter trimConverter
    ) {
        this.replaceConverter = replaceConverter;
        this.trimConverter = trimConverter;
    }

    @Bean
    Pipeline converterPipeline(
            @Value("${convert}") String[] convertArguments,
            @Qualifier("dummyConverter") Converter dummyConverter
    ) {
        Pipeline converterPipeline = new Pipeline(dummyConverter);
        for (String convertArgument : convertArguments) {
            if (TRIM_CONVERTER.equalsIgnoreCase(convertArgument)) {
                converterPipeline = converterPipeline.addConverter(trimConverter);
            }
            if(REPLACE_CONVERTER.equalsIgnoreCase(convertArgument)) {
                converterPipeline = converterPipeline.addConverter(replaceConverter);
            }
        }

        return converterPipeline;
    }
}
