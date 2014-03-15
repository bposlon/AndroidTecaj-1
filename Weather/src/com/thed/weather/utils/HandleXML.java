package com.thed.weather.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class HandleXML {

	private String datetime = "datetime";
	private String s1 = "s1";
	private String s2 = "s2";
	private String s3 = "s3";
	private String s4 = "s4";
	private String urlString = null;
	private XmlPullParserFactory xmlFactoryObject;
	public volatile boolean parsingComplete = true;
	public HandleXML(String url){
		this.urlString = url;
	}
	public String getDatetime(){
		return datetime;
	}
	public String getS1(){
		return s1;
	}
	public String getS2(){
		return s2;
	}
	public String getS3(){
		return s3;
	}
	public String getS4(){
		return s4;
	}

	public void parseXMLAndStoreIt(XmlPullParser myParser) {
		int event;
		String text=null;
		try {
			event = myParser.getEventType();
			while (event != XmlPullParser.END_DOCUMENT) {
				String name=myParser.getName();
				switch (event){
				case XmlPullParser.START_TAG:
					break;
				case XmlPullParser.TEXT:
					text = myParser.getText();
					break;

				case XmlPullParser.END_TAG:
					if(name.equals("s1")){
						s1 = text;
					}
					else if(name.equals("s2")){ 	
						s2 = text;
					}
					else if(name.equals("s3")){
						s3 = text;
					}
					else if(name.equals("s4")){
						s4 = text;
					}
					else if(name.equals("datetime")){
						datetime = text;
					}
					else{
					}
					break;
				}		 
				event = myParser.next(); 

			}
			parsingComplete = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void fetchXML(){
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					URL url = new URL(urlString);
					HttpURLConnection conn = (HttpURLConnection) 
							url.openConnection();
					conn.setReadTimeout(10000);
					conn.setConnectTimeout(15000);
					conn.setRequestMethod("GET");
					conn.setDoInput(true);
					conn.connect();
					InputStream stream = conn.getInputStream();

					xmlFactoryObject = XmlPullParserFactory.newInstance();
					XmlPullParser myParser = xmlFactoryObject.newPullParser();

					myParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES
							, false);
					myParser.setInput(stream, null);
					parseXMLAndStoreIt(myParser);
					stream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		thread.start(); 


	}

}