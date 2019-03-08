package com.wowowo.model;

import java.awt.Toolkit;

import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Enemy001 extends Enemy{
	
	public Enemy001(MyPanel myPanel)
	{
		super(myPanel);
		
		this.width=50;
		
		this.height=50;
		
		this.x=(int)(Math.random()*(BaseFrame.frameWidth-this.width));
		
		this.y=-40;
		
		this.speed=2;
		
		this.hp=1;

		this.image=Toolkit.getDefaultToolkit().getImage(Enemy001.class.getResource("/Image/enemy01.png"));
		
		this.items=new Item[] {
				new Item001(myPanel)
		};
		
	}

}
