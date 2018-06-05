package com.wowowo.thread;

import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

/**
 * 
 * ʵ����Ϸ�еı�������
 * 
 */
public class GameSound {
	BgSoundThread bst = null;
	//���ű������ֵĴ���
	@SuppressWarnings("deprecation")
	public void playBgSound(String mp3){
		
		//1. ������Ҫ��ԭ���ı�������ֹͣ		
		if(bst!=null){
			bst.stop();
		}
		
		bst = new BgSoundThread(mp3);
		bst.start();
	}
	
	//ʹ�ö��߳������ű�ը�ͷ����ӵ�������
	public void playSound(String mp3){
		SoundThread st = new SoundThread(mp3);
		st.start();
	}
	
	//ѭ�����ű�������
	class BgSoundThread extends Thread{
		
		public String mp3Url;
		
		public BgSoundThread(String mp3Url) {
			this.mp3Url = mp3Url;
		}

		public void run(){
			for(;;){			
				//���������Ĳ���
				//1. ����MP3�ļ�
				InputStream in = GameSound.class.getClassLoader().getResourceAsStream(mp3Url);
				
				//2. �����ļ���������������Ķ���
				AdvancedPlayer ad;
				try {
					ad = new AdvancedPlayer(in);
					
					//3. ����
					ad.play();
				} catch (JavaLayerException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	//ֻ����һ��
	class SoundThread extends Thread{
		
		public String mp3Url;
		
		public SoundThread(String mp3Url) {
			this.mp3Url = mp3Url;
		}

		public void run(){
			//���������Ĳ���
			//1. ����MP3�ļ�
			InputStream in = GameSound.class.getClassLoader().getResourceAsStream(mp3Url);
			
			//2. �����ļ���������������Ķ���
			AdvancedPlayer ad;
			try {
				ad = new AdvancedPlayer(in);
				
				//3. ����
				ad.play();
			} catch (JavaLayerException e) {
				e.printStackTrace();
			}
		}
	}
	
}
