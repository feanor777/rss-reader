package com.uzabase.rssreader.config;

import com.uzabase.rssreader.converter.Converter;
import com.uzabase.rssreader.converter.Pipeline;
import com.uzabase.rssreader.meta.ConverterConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RssReaderConfiguration {
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
            if (ConverterConstant.TRIM_CONVERTER_KEYWORD.equalsIgnoreCase(convertArgument)) {
                converterPipeline = converterPipeline.addConverter(trimConverter);
            }
            if(StringUtils.startsWith(convertArgument, ConverterConstant.REPLACE_CONVERTER_KEYWORD)) {
                converterPipeline = converterPipeline.addConverter(replaceConverter);
            }
        }

        return converterPipeline;
    }
}
