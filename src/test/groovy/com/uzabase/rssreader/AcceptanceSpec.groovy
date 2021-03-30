package com.uzabase.rssreader

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class AcceptanceSpec extends Specification {

    def "context is started"() {
        given:
        println "started"

        expect:
        1 == 1
    }
}
