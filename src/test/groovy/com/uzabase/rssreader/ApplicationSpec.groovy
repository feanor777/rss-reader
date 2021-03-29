package com.uzabase.rssreader

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [Application]
)
class ApplicationSpec extends Specification {

    def "context is started"() {
        given:
        def a = 1

        expect:
        1 == 1
    }
}
