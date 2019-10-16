package com.example;

import javax.media.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;

public class Audio {
	
	private Player audioplayer=null;
	
	public Audio(URL url) throws NoPlayerException, CannotRealizeException, IOException 
	{
		audioplayer=Manager.createRealizedPlayer(url);
	}
	
	@SuppressWarnings("deprecation")
	public Audio(File file) throws NoPlayerException, CannotRealizeException, MalformedURLException, IOException
	{
		this(file.toURL());
	}
	
	public void play()
	{
		audioplayer.start();
	}
	
	public void stop()
	{
		audioplayer.stop();
		audioplayer.close();
	}
	
	public static void main(String...args) {
		
		File f=new File("F:\\Downloads\\1.mp3");
		try {
			
			Audio a=new Audio(f);
			a.play();
			a.stop();
		} catch (NoPlayerException | CannotRealizeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
