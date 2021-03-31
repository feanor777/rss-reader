## Installation
Please install lombock plugin to be able to work in your IDE. (https://plugins.jetbrains.com/plugin/6317-lombok)

## Guide
Application is able to read the RSS feed from the URL or file, apply specific modifications to the Title and Description
of the feed and after that write the result to the specified output (file or console).

#### Input parameters:  
Input parameters parsed automatically according to the Spring ApplicationArguments standard (https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/ApplicationArguments.html)  
 
- `--input`  
 It should be a valid RSS feed URL (https://tech.uzabase.com/rss) or path to the File with valid RSS (test.txt)

- `--convert`  
Specify the list of converters to apply. For now support only 2 - `cut` & `replace`.
The syntax of `replace` reminds the SED replace.  
`replace(/uzabase/Max Test Uzabase/)` where `uzabase` - word to find and `Max Test Uzabase`  the word which will be replaced by.

- `--output`  
Specify where will we output our RSS feed, after it'll be processed.
There are 2 available params (`console`, or path to the file, for example `test.xml`).
By default, if nothing specified it outputs to the console.

## How to run
`./gradlew bootRun --args='--input=https://tech.uzabase.com/rss --convert=cut,replace(/tes/Uzabase/) --output=console'`  
  
This command will read the RSS from the https://tech.uzabase.com/rss, after that will apply 
2 converters in the order cut -> replace. Which will trim all titles and descriptions of 
the feed in case if it has more than 10 characters and after that will replace all `tes` 
with `Uzabase`. In the end the result will be printed to the console.

To run tests, please execute:
`./gradlew test`

## Design Schema
![rss-reader-design-schema](./rss-reader-design-schema.png)


## Example
You can see an example in the [Acceptance test](./src/test/groovy/com/uzabase/rssreader/AcceptanceSpec.groovy)

The specified arguments are: 
- --input=classpath:input/rss-test.xml
- --convert=cut,replace(/uzabase/Uzabase Inc./)
- --output=output.xml"

Based on the input params, our RSS reader is reading the [rss feed](./src/test/resources/input/rss-test.xml).  
Trimming all white spaces around the words which has the length more than 10 chars and after that replacing `uzabase` with `Uzabase Inc.` for title and description.  
After that result in printed to the file output.xml