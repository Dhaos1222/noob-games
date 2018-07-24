package com.wowowo.model;

import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Item002 extends Item {
	public Item002(MyPanel myPanel)
	{
		super(myPanel);
		
		this.x=(int)(Math.random()*(BaseFrame.frameWidth-this.width));
		
		this.width=50;
		
		this.height=80;
		
		this.count=1000;
		
		this.images=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Item002.class.getResource("/Image/boomer.png"))
		};
		
		this.imageSpeed=(int)(Math.random()*200+5);
		
		this.speed=4;
		
	}
	public void eated()
	{
		//当道具被吃掉将其分数累加到玩家的总分中
		this.myPanel.player.count+=this.count;
		this.myPanel.player.boom+=1;
		this.myPanel.gso.playSound("./music/getitem.mp3");
		this.myPanel.items.remove(this);
	}
}
