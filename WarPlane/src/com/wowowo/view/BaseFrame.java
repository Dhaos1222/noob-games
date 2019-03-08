package com.wowowo.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.wowowo.listener.FrameKeyListener;
import com.wowowo.listener.FrameMouseListener;
import com.wowowo.model.Enemy001;
import com.wowowo.thread.MusicThread;

public class BaseFrame extends JFrame{
	
	public static int frameWidth=800;
	
	public static int frameHeight=900;
	
	public MyPanel myPanel;
	
	//��������
	public FrameMouseListener frameMouseListener;
	
	//���̼�����
	public FrameKeyListener frameKeyListener;
	
	public static boolean hasPlayer;
	
	public static boolean hasItem;
	
	public static boolean hasCount;
	//���ü�����
	public void setTouchListener()
	{
		this.frameMouseListener=new FrameMouseListener();
		this.frameMouseListener.baseFrame=this;
		//ע�����������
		this.addMouseListener(this.frameMouseListener);
	}
	
	public void setKeyListener()
	{
		this.frameKeyListener=new FrameKeyListener();
		this.frameKeyListener.baseFrame=this;
		this.addKeyListener(this.frameKeyListener);
	}
	
	public void createPlayer()
	{
		hasPlayer=true;
	}
	
	public void setPlayerPowerLevel(int attackMode)
	{
		this.myPanel.player.attackMode=attackMode;
	}
	
	public void setEnemyHasItem()
	{
		hasItem=true;
	}
	
	public void setCount()
	{
		hasCount=true;
	}
	
	public void addEnemyType(Class c)
	{
		this.myPanel.enemyType.add(c);
	}
	
	public BaseFrame()
	{
		super("�ɻ�С��Ϸ");
		//�����Ļ�ķֱ���
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//���ô��ڵĴ�С��λ��
		setBounds(((int)screenSize.getWidth()-frameWidth)/2,0,frameWidth,frameHeight);
		
		//��ֹ�ı䴰�ڴ�С
		setResizable(false);
		
		//���ַ�ʽ
		setLayout(null);
		
		//����MyPanel����
		this.myPanel = new MyPanel();
		
		//����MyPanel�����λ�úʹ�С
		this.myPanel.setBounds(0,0,frameWidth,frameHeight);
		
		//�������ӵ�������
		this.add(this.myPanel);
			
		//��ʾ����
		setVisible(true);
		
		//���ô��ڵĹر���Ϊ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}
	
}
