package com.uzabase.rssreader

import groovy.xml.XmlSlurper
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.util.ResourceUtils
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest(args = ["--input=classpath:input/rss-test.xml", "--convert=cut,replace(/uzabase/Uzabase Inc./)", "--output=output.xml"])
class AcceptanceSpec extends Specification {

    @Shared
    def outputFilePath = "output.xml"

    def setupSpec() {
        ResourceUtils.getFile(outputFilePath).delete()
    }

    def "when providing correct application arguments, then perform requested action with rss feed and write it to the specified output"() {
        given:
        def rss = new XmlSlurper().parseText(ResourceUtils.getFile(outputFilePath).text)

        expect:
        "Uzabase Inc. tech" == rss.channel.title.text()
        "Uzabase Inc. tech description" == rss.channel.description.text()
        "Item title Uzabase Inc." == rss.channel.item.title.text()
        "Item description to trim" == rss.channel.item.description.text()
    }
}
