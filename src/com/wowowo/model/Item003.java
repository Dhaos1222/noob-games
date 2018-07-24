package com.wowowo.model;

import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Item003 extends Item {
	public Item003(MyPanel myPanel)
	{
		super(myPanel);
		
		this.x=(int)(Math.random()*(BaseFrame.frameWidth-this.width));
		
		this.width=30;
		
		this.height=50;
		
		this.count=1000;
		
		this.images=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Item003.class.getResource("/Image/addbullet.png"))
		};
		
		this.imageSpeed=(int)(Math.random()*200+5);
		
		this.speed=3;
		
	}
	public void eated()
	{
		//当道具被吃掉将其分数累加到玩家的总分中
		this.myPanel.player.count+=this.count;
		if(this.myPanel.player.attackMode<3)
		    this.myPanel.player.attackMode+=1;
		this.myPanel.gso.playSound("./music/getitem.mp3");
		this.myPanel.items.remove(this);
	}
}
