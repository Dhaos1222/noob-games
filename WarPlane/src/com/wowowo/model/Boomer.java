package com.wowowo.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.view.MyPanel;

public class Boomer {

	public MyPanel myPanel;

	public int width=50;
	
	public int height=80;
	
	public int x;
	
	public int y;
	
	public int temp=400;//Õ¨µ¯·ÉÐÐ¾àÀë
	
	public Image[] images=new Image[] {
			Toolkit.getDefaultToolkit().getImage(Boomer.class.getResource("/Image/boomer1.png")),
			Toolkit.getDefaultToolkit().getImage(Boomer.class.getResource("/Image/boomer2.png"))
			//Toolkit.getDefaultToolkit().getImage("Image/bullet02.png")
	};
	
	public Image[] boomers=new Image[] {
			Toolkit.getDefaultToolkit().getImage(Boomer.class.getResource("/Image/boom1.png")),
			Toolkit.getDefaultToolkit().getImage(Boomer.class.getResource("/Image/boom2.png")),
			Toolkit.getDefaultToolkit().getImage(Boomer.class.getResource("/Image/boom3.png"))
	};
	
	public int imageindex=0;
	public int imageindex2=0;
	public Boomer(MyPanel myPanel)
	{
		this.myPanel=myPanel;
	}
	
	//»­Õ¨µ¯
	public void drawSelf(Graphics g)
	{
		if(myPanel.player.isLife==true)
		{
			if(temp>100)
			    g.drawImage(this.images[imageindex],x,y,width,height,null);
			else
				g.drawImage(this.boomers[imageindex2],x-125,y-190,250,380,null);
			
			if(this.myPanel.timer%100==0)
			{
				imageindex2++;
				if(imageindex2==this.boomers.length)
					imageindex2=0;
			}
			
			
			if(this.myPanel.timer%1==0)
			{
				imageindex++;
				
				if(imageindex==this.images.length)
					imageindex=0;
				if(temp>=0)
				y--;
				temp--;
			}
			
			for(int i=0;i<this.myPanel.enemies.size();i++)
			{
				Enemy e=this.myPanel.enemies.get(i);
				
				//±»×Óµ¯»÷ÖÐ
				if(temp<=0)
				{
					//×Óµ¯Ïú»Ù
					this.myPanel.boomers.remove(this);
				    this.myPanel.ebullets.clear();
					//±»¹¥»÷µ½
					e.hp-=30;
				}
			}	
		}
	}
}
