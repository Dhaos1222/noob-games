package com.wowowo.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.thread.GameSound;
import com.wowowo.thread.MusicThread;
import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Enemy {
	
	public MyPanel myPanel;
	
	public int width;
	
	public int height;
	
	public int x;
	
	public int y;
	
	public Image image;
	
	public int hp;
	
	public int speed;//�л��˶��ٶ�
	
	//��ŵ�ǰ�л�Я���ĵ���
	public Item[] items;
	
	public Image[] dieImages=new Image[] {
			
			Toolkit.getDefaultToolkit().getImage("Image/boom1.png"),
			Toolkit.getDefaultToolkit().getImage("Image/boom2.png"),
			Toolkit.getDefaultToolkit().getImage("Image/boom3.png")
	};
	
	public int imageindex=0;
	
	public Enemy(MyPanel myPanel)
	{
		this.myPanel=myPanel;
		
		
	}
	
	//���л�
	public void drawSelf(Graphics g)
	{
		//�жϵ����Ƿ񱻻���
		Player e=this.myPanel.player;
		if(hp>0)
			{
			g.drawImage(image,x,y,width,height,null);
			}
		if(hp<=0||((this.x>=e.x-this.width+30 && this.x<=e.x+e.width-30)&&(this.y>=e.y-this.height+10 && this.y<=e.y+e.height-10)))
		{
			if(((this.x>=e.x-this.width+30 && this.x<=e.x+e.width-30)&&(this.y>=e.y-this.height+10 && this.y<=e.y+e.height-10)))
				e.underattack();
			//������
			g.drawImage(dieImages[imageindex], x, y, 45,45,null);
			
			if(myPanel.timer%10==0)
			{
				imageindex++;
				
				if(imageindex>=this.dieImages.length)
				{
					//�л�����
					killed();
					myPanel.gso.playSound("./music/boom.mp3");
				}
			}
		}
		
		//�л������ƶ�
		if(this.myPanel.timer% speed==0)
		{
			y++;
			
			if(y>BaseFrame.frameHeight)
				this.myPanel.enemies.remove(this);
		}
		
	}
	
	public void killed()
	{
		//���Я������ �ͷŵ���
		if(items!=null && items.length>0)
		{
			for(int i=0;i<items.length;i++)
			{
				Item item=items[i];
				
				item.y=this.y;
				
				item.x=this.x+20*i;
				
				//���ͷų�����item��ӵ�panel��
				this.myPanel.items.add(item);
			}
		}
		
		
		this.myPanel.enemies.remove(this);
	}
	
	//��������״̬
	public void underAttack()
	{
		if(hp>0)
			hp--;
	}
}
