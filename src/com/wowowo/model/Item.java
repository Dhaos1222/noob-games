package com.wowowo.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;

import javax.annotation.Generated;

import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Item {

	public MyPanel myPanel;
	
	public int width;
	
	public int height;
	
	public int x;
	
	public int y;
	
	public Image[] images;
	
	public int imageSpeed;
	
	public int speed;
	
	public int imageindex=0;
	
	public int count;
	
	public Item(MyPanel myPanel)
	{
		this.myPanel=myPanel;
	}
	
	public void drawSelf(Graphics g)
	{
		g.drawImage(this.images[imageindex], x,y,width,height,null);
		
		if(this.myPanel.timer%imageSpeed==0)
		{
			imageindex++;
			
			if(imageindex==this.images.length)
				imageindex=0;
		}
		
		//道具往下运动
		if(this.myPanel.timer%speed==0)
		{
			y++;
			
			if(this.y>=BaseFrame.frameHeight)
				this.myPanel.items.remove(this);
		}
	}
	
	//道具如果被吃掉
	public void eated()
	{
		//当道具被吃掉将其分数累加到玩家的总分中
		this.myPanel.player.count+=this.count;
		this.myPanel.items.remove(this);
	}
}
