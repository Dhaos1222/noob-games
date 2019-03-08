package com.wowowo.thread;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;


public class MusicThread extends Thread{

	private String fileName;
	
	private AudioFormat format;//音频格式
	
	private byte[] samples;//存放音频文件的内容
	
	public MusicThread(String fileName) {
		this.fileName = fileName;
		reverseMusic();
	}
	
	public void reverseMusic() {
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(fileName));
			format = stream.getFormat();
			samples = getSamples(stream);
		}
		catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public byte[] getSamples(AudioInputStream audioSteam) {
		int length = (int)(audioSteam.getFrameLength()*format.getFrameSize());
		
		byte[] samples = new byte[length];
		
		DataInputStream iStream = new DataInputStream(audioSteam);
				
		try {
			iStream.readFully(samples);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return samples;
	}
	
	public void play(InputStream source) {
		//获得每秒钟播放的文件的大小
		int bufferSize = format.getFrameSize()*Math.round(format.getFrameRate());//具有此格式的声音每秒播放或录制的样本数量
		byte[] buffer = new byte[bufferSize];
		
		SourceDataLine line;
		

		try {
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			line = (SourceDataLine)AudioSystem.getLine(info);
			line.open(format,bufferSize);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		line.start();
		
		try {
			int numBytesRead = 0;
			while (numBytesRead!=-1) {
				numBytesRead = source.read(buffer,0,buffer.length);
				if(numBytesRead!=-1) {
					line.write(buffer, 0, numBytesRead);
				}
			}
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		line.drain();
		line.close();
	}
	
	public void run() {

		InputStream stream = new ByteArrayInputStream(samples);
		
		play(stream);
	}

}
