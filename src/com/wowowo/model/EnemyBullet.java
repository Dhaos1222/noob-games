package com.wowowo.model;

import java.awt.Graphics;
import java.awt.Image;

import com.wowowo.view.MyPanel;

public class EnemyBullet {

	public MyPanel myPanel;

	public int width;
	
	public int height;
	
	public int x;
	
	public int y;
	
	public boolean flag;
	
	public double offx;
	
	public double offy;
	
	public Image[] images;
	
	public int imageindex;
	
	public EnemyBullet(MyPanel myPanel)
	{
		this.myPanel=myPanel;
	}
	public void drawSelf(Graphics g)
	{
		if(myPanel.player.isLife==true)
		{
			g.drawImage(this.images[imageindex],x,y,width,height,null);
			Player e=this.myPanel.player;
			
			if(this.myPanel.timer%2==0)
			{
				imageindex++;

				if(imageindex==this.images.length)
					imageindex=0;
				
				//x-=10*(Math.sin((double)(System.currentTimeMillis()/80.0))+0.05);
				//x+=10*(Math.sin((double)(y/7.0))+0.05);
				//x+=10*(Math.sin((double)(y/7.0-System.currentTimeMillis()/70.0))+0.05);
				//x+=2*(Math.sin((double)(System.currentTimeMillis()/3.0+y/2.0)/20)+0.25);
				
				y++;
				if(y>900)
				{
					//��������Ƴ��ӵ�
					this.myPanel.ebullets.remove(this);//�ӵ��˶�����Ļ�⣬�Ƴ�
				}
			}
			
			//�ж��ӵ��Ƿ���е���
			for(int i=0;i<this.myPanel.enemies.size();i++)
			{
				
				//���ӵ�����
				if((this.x>=e.x-this.width && this.x<=e.x+e.width) && (this.y>=e.y-this.height && this.y<=e.y+e.height))
				{
					//�ӵ�����
					this.myPanel.ebullets.remove(this);
					//��������
					e.underattack();
				}
			}	
		}
	}
}
