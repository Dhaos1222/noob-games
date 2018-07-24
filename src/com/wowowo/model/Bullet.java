package com.wowowo.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.security.auth.login.FailedLoginException;

import com.wowowo.view.MyPanel;

public class Bullet {

	public MyPanel myPanel;

	public int width=20;
	
	public int height=30;
	
	public int x;
	
	public int y;
	
	
	public Image[] images=new Image[] {
			Toolkit.getDefaultToolkit().getImage(Bullet.class.getResource("/Image/bullet.png"))
			//Toolkit.getDefaultToolkit().getImage("src/Image/bullet.png"),
			//Toolkit.getDefaultToolkit().getImage("Image/bullet02.png")
	};
	
	public int imageindex=0;
	
	public Bullet(MyPanel myPanel)
	{
		this.myPanel=myPanel;
	}
	
	//画子弹
	public void drawSelf(Graphics g)
	{
		if(myPanel.player.isLife==true)
		{
			g.drawImage(this.images[imageindex],x,y,width,height,null);
			
			if(this.myPanel.timer%1==0)
			{
				imageindex++;
				
				if(imageindex==this.images.length)
					imageindex=0;
				y--;
				if(y<0)
				{
					//从面板中移除子弹
					this.myPanel.bullets.remove(this);//子弹运动到屏幕外，移出
				}
			}
			
			//判断子弹是否打中敌人
			for(int i=0;i<this.myPanel.enemies.size();i++)
			{
				Enemy e=this.myPanel.enemies.get(i);
				
				//被子弹击中
				if((this.x>=e.x-this.width && this.x<=e.x+e.width) && (this.y>=e.y-this.height && this.y<=e.y+e.height))
				{
					//子弹销毁
					this.myPanel.bullets.remove(this);
					//被攻击到
					this.myPanel.player.count+=100;
					e.underAttack();
				}
			}	
		}
	}
}
