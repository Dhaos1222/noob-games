package com.wowowo.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Enemy004 extends Enemy{
	
	public Enemy004(MyPanel myPanel)
	{
		super(myPanel);
		
		this.width=256;
		
		this.height=256;
		
		this.x=(int)(Math.random()*(BaseFrame.frameWidth-this.width));
		
		this.y=-40;
		
		this.speed=3;
		
		this.hp=300;

		this.image=Toolkit.getDefaultToolkit().getImage(Enemy002.class.getResource("/Image/enemy04.png"));
		
		this.items=new Item[] {
				new Item001(myPanel),
				new Item001(myPanel),
				new Item003(myPanel),
				new Item001(myPanel),
				new Item001(myPanel)
		};
		
		this.dieImages=new Image[] {
				
				Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("/Image/boom1.png")),
				Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("/Image/boom2.png")),
				Toolkit.getDefaultToolkit().getImage(Enemy.class.getResource("/Image/boom3.png"))
		};
	}
	
	public int direction=(int)Math.random();
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
			g.drawImage(dieImages[imageindex], x, y, 256,256,null);
			
			if(myPanel.timer%30==0)
			{
				imageindex++;
				
				if(imageindex>=this.dieImages.length)
				{
					//敌机挂了
					killed();
					myPanel.gso.playSound("./music/boom.mp3");
				}
			}
			this.myPanel.boss=0;
		}
		
		//敌机向下移动
		if(this.myPanel.timer% speed==0)
		{
			if(this.y<10)
			    y++;
			else if(direction==1)
			{
				x++;
				if(x==BaseFrame.frameWidth-256)
					direction=0;
			}
			else if(direction==0)
			{
				x--;
				if(x==0)
					direction=1;
			}
			if(y>BaseFrame.frameHeight)
				this.myPanel.enemies.remove(this);
		}
		
		if(this.myPanel.timer%600==0)
		{
			Enemy003Bullet eBullet = new Enemy003Bullet(this.myPanel);
			eBullet.x=this.x+this.width/2;
			eBullet.y=this.y+this.height;
			this.myPanel.ebullets.add(eBullet);
			
			Enemy003Bullet eBullet02 = new Enemy003Bullet(this.myPanel);
			eBullet02.x=this.x+this.width/2-30;
			eBullet02.y=this.y+this.height;
			this.myPanel.ebullets.add(eBullet02);
			Enemy003Bullet eBullet03 = new Enemy003Bullet(this.myPanel);
			eBullet03.x=this.x+this.width/2-60;
			eBullet03.y=this.y+this.height;
			this.myPanel.ebullets.add(eBullet03);
			Enemy003Bullet eBullet04 = new Enemy003Bullet(this.myPanel);
			eBullet04.x=this.x+this.width/2+30;
			eBullet04.y=this.y+this.height;
			this.myPanel.ebullets.add(eBullet04);
			Enemy003Bullet eBullet05 = new Enemy003Bullet(this.myPanel);
			eBullet05.x=this.x+this.width/2+60;
			eBullet05.y=this.y+this.height;
			this.myPanel.ebullets.add(eBullet05);
		}
		if(this.myPanel.timer%800==0)
		{
			Enemy002Bullet eBullet06 = new Enemy002Bullet(this.myPanel);
			eBullet06.x=this.x+this.width/2-100;
			eBullet06.y=this.y+this.height;
			this.myPanel.ebullets.add(eBullet06);
			Enemy002Bullet eBullet07 = new Enemy002Bullet(this.myPanel);
			eBullet07.x=this.x+this.width/2+100;
			eBullet07.y=this.y+this.height;
			this.myPanel.ebullets.add(eBullet07);
		}

		
		
	}
	

}
