package net.qyjohn.KinesisTutorials;

import java.io.*;
import java.util.*;
import java.nio.charset.Charset;
import java.nio.ByteBuffer;
import com.amazonaws.*;
import com.amazonaws.auth.*;
import com.amazonaws.auth.profile.*;
import com.amazonaws.regions.*;
import com.amazonaws.services.kinesis.*;
import com.amazonaws.services.kinesis.model.*;


public class KinesisWriteExample extends Thread
{
	AmazonKinesisClient client;
	String regionName, streamName;

	public KinesisWriteExample()
	{
		try
		{
			Properties prop = new Properties();
			InputStream input = new FileInputStream("kinesis.properties");
			prop.load(input);
			streamName = prop.getProperty("streamName");
			regionName = prop.getProperty("regionName");

			client = new AmazonKinesisClient();
			client.configureRegion(Regions.fromName(regionName));
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void run()
	{
		while (true)
		{
			try
			{
				String uuid = UUID.randomUUID().toString();
				ByteBuffer data = ByteBuffer.wrap(uuid.getBytes());
				// Use UUID for both the data and partition key
				client.putRecord(streamName, data, uuid);
				// Sleep for 2 seconds
				sleep(2000);
			} catch (Exception e) 
			{
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args)
	{
		KinesisWriteExample example = new KinesisWriteExample();
		example.start();
	}
}
