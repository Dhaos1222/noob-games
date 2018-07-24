package com.wowowo.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Enemy003 extends Enemy{
	
	public Enemy003(MyPanel myPanel)
	{
		super(myPanel);
		
		this.width=60;
		
		this.height=70;
		
		this.x=(int)(Math.random()*(BaseFrame.frameWidth-this.width));
		
		this.y=-40;
		
		this.speed=3;
		
		this.hp=2;

		this.image=Toolkit.getDefaultToolkit().getImage(Enemy002.class.getResource("/Image/enemy03.png"));
		
		this.items=new Item[] {
				new Item001(myPanel),
				new Item001(myPanel),
				new Item001(myPanel)
		};
		
	}
	public void drawSelf(Graphics g)
	{
		//判断敌人是否被击落
		Player e=this.myPanel.player;
		if(hp>0)
			{
			g.drawImage(image,x,y,width,height,null);
			}
		if(hp<=0||((this.x>=e.x-this.width+30 && this.x<=e.x+e.width-30)&&(this.y>=e.y-this.height+10 && this.y<=e.y+e.height-10)))
		{
			if(((this.x>=e.x-this.width+30 && this.x<=e.x+e.width-30)&&(this.y>=e.y-this.height+10 && this.y<=e.y+e.height-10)))
				e.underattack();
			//被击落
			g.drawImage(dieImages[imageindex], x, y, 45,45,null);
			
			if(myPanel.timer%10==0)
			{
				imageindex++;
				
				if(imageindex>=this.dieImages.length)
				{
					//敌机挂了
					killed();
					myPanel.gso.playSound("./music/boom.mp3");
				}
			}
		}
		
		//敌机向下移动
		if(this.myPanel.timer% speed==0)
		{
			y++;
			
			if(y>BaseFrame.frameHeight)
				this.myPanel.enemies.remove(this);
		}
		
		if(this.myPanel.timer%400==0)
		{
			Enemy003Bullet eBullet = new Enemy003Bullet(this.myPanel);
			eBullet.x=this.x+this.width/2-5;
			eBullet.y=this.y+this.height;
			this.myPanel.ebullets.add(eBullet);
		}

		
		
	}
	

}
