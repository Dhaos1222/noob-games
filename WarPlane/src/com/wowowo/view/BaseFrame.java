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
	
	//鼠标监听器
	public FrameMouseListener frameMouseListener;
	
	//键盘监听器
	public FrameKeyListener frameKeyListener;
	
	public static boolean hasPlayer;
	
	public static boolean hasItem;
	
	public static boolean hasCount;
	//设置监听器
	public void setTouchListener()
	{
		this.frameMouseListener=new FrameMouseListener();
		this.frameMouseListener.baseFrame=this;
		//注册监听器对象
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
		super("飞机小游戏");
		//获得屏幕的分辨率
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		//设置窗口的大小和位置
		setBounds(((int)screenSize.getWidth()-frameWidth)/2,0,frameWidth,frameHeight);
		
		//禁止改变窗口大小
		setResizable(false);
		
		//布局方式
		setLayout(null);
		
		//创建MyPanel对象
		this.myPanel = new MyPanel();
		
		//设置MyPanel对象的位置和大小
		this.myPanel.setBounds(0,0,frameWidth,frameHeight);
		
		//将组件添加到窗口中
		this.add(this.myPanel);
			
		//显示窗口
		setVisible(true);
		
		//设置窗口的关闭行为
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
	}
	
}
