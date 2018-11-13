#Kinesis 100

This is a demo project that is used for troubleshooting possible AWS SDK for Java issues. There are only two package dependencies: aws-java-sdk and log4j. 

To get started, use the following commands:

~~~~
cd ~
git clone https://github.com/qyjohn/Kinesis_100
cd Kinesis_100
mvn package
~~~~

To run a quick test, create a test Kinesis stream, then modify kinesis.properties with the proper *regionName* and *streamName*. Use the following command to write some random data into the stream.

~~~~
java -cp target/kinesis-tutorials-jar-with-dependencies.jar:. net.qyjohn.KinesisTutorials.KinesisWriteExample
~~~~
