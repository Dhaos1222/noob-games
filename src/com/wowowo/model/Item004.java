package com.wowowo.model;

import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Item004 extends Item {
	public Item004(MyPanel myPanel)
	{
		super(myPanel);
		
		this.x=(int)(Math.random()*(BaseFrame.frameWidth-this.width));
		
		this.width=50;
		
		this.height=50;
		
		this.count=1000;
		
		this.images=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Item004.class.getResource("/Image/blood.png"))
		};
		
		this.imageSpeed=(int)(Math.random()*200+5);
		
		this.speed=3;
		
	}
	public void eated()
	{
		//当道具被吃掉将其分数累加到玩家的总分中
		this.myPanel.player.count+=this.count;
		if(this.myPanel.player.hp<=80&&this.myPanel.player.hp>0)
		    this.myPanel.player.hp+=20;
		else if(this.myPanel.player.hp>80&&this.myPanel.player.hp<=100)
			this.myPanel.player.hp=100;
		this.myPanel.gso.playSound("./music/getitem.mp3");
		this.myPanel.items.remove(this);
	}
}
