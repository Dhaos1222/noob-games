package com.wowowo.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.view.MyPanel;

public class Enemy003Bullet extends EnemyBullet{
	
	public Enemy003Bullet(MyPanel myPanel)
	{
		super(myPanel);
		this.width = 10;
		this.height = 10;
		this.flag = false;
		this.images=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Enemy002Bullet.class.getResource("/Image/enemybullet02.png"))
				//Toolkit.getDefaultToolkit().getImage("src/Image/bullet.png"),
				//Toolkit.getDefaultToolkit().getImage("Image/bullet02.png")
		};
		this.imageindex = 0;
	}
	
	//画子弹
	public void drawSelf(Graphics g)
	{
		if(myPanel.player.isLife==true)
		{
			g.drawImage(this.images[imageindex],x,y,width,height,null);
			Player e=this.myPanel.player;

			if(!flag)
			{
				double deltax = e.x-this.x+e.width;
				double deltay = e.y-this.y+e.height;
				double distance = Math.sqrt(Math.abs(deltax*deltax)+Math.abs(deltay*deltay));
				offx = 2*deltax/distance;
				offy = 2*deltay/distance;
				flag=true;
			}
			
			if(this.myPanel.timer%3==0)
			{
				imageindex++;

				if(imageindex==this.images.length)
					imageindex=0;
				
				//x-=10*(Math.sin((double)(System.currentTimeMillis()/80.0))+0.05);
				//x+=10*(Math.sin((double)(y/7.0))+0.05);
				//x+=10*(Math.sin((double)(y/7.0-System.currentTimeMillis()/70.0))+0.05);
				x+=2*(Math.sin((double)(System.currentTimeMillis()/3.0+y/2.0)/20)+0.25);
				
				y+=2;
				if(y>900)
				{
					//从面板中移除子弹
					this.myPanel.ebullets.remove(this);//子弹运动到屏幕外，移出
				}
			}
			
			//判断子弹是否打中敌人
			for(int i=0;i<this.myPanel.enemies.size();i++)
			{
				
				//被子弹击中
				if((this.x>=e.x-this.width && this.x<=e.x+e.width) && (this.y>=e.y-this.height && this.y<=e.y+e.height))
				{
					//子弹销毁
					this.myPanel.ebullets.remove(this);
					//被攻击到
					e.underattack();
				}
			}	
		}
	}
}
