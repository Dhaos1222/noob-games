package com.wowowo.model;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.view.BaseFrame;
import com.wowowo.view.MyPanel;

public class Player extends Thread{
	
	public MyPanel myPanel;
	
	public int width = 100;
	
	public int height = 150;

	public int x;
	
	public int y;
	
	public int attackMode=0;
	
	public int count=0;//玩家的分数
	
	public int hp=100;
	
	public boolean isLife = true;
	
	//判断角色是否移动
	static int step = 4;
	
    public boolean up = false;  
    public boolean down = false;  
    public boolean left = false;  
    public boolean right = false; 
    
    public void run() {  
        while(true){
        	if(myPanel.flagPause==true)
        	{
        		try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	else
        	{
                move();  
                try {  
                    Thread.sleep(10);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                }  
        	}
        }  
    } 
    
    //角色移动的方法
    public void move(){  
        if(up){  
            //改变角色在地图中的位置  
        	if(y>=0)
            y=y-step;  
            //改变角色移动相对于固定元素点的偏移量   
        }  
        if(down){  
        	if(y<myPanel.getHeight()-153)
            y=y+step;  
        }  
        if(left){
        	if(x>0)
            x=x-step;  
        }  
        if(right){
        	if(x<myPanel.getWidth()-100)
            x=x+step;  
        }  
    }  
    
	//存放所有飞机图像
	public Image[] images=new Image[] {
			Toolkit.getDefaultToolkit().getImage(Player.class.getResource("/Image/GodPlane.png"))
			//Toolkit.getDefaultToolkit().getImage("src/Image/GodPlane.png")
			//Toolkit.getDefaultToolkit().getImage("Image/GodPlane02.png"),
			//Toolkit.getDefaultToolkit().getImage("Image/GodPlane.png"),
			//Toolkit.getDefaultToolkit().getImage("Image/GodPlane03.png")
	};

	public Image[] died=new Image[] {
			/*Toolkit.getDefaultToolkit().getImage("src/Image/boom1.png"),
			Toolkit.getDefaultToolkit().getImage("src/Image/boom2.png"),
			Toolkit.getDefaultToolkit().getImage("src/Image/boom3.png")*/
	};
	//存放当前图片下标
	public int imageindex=0;
	public int i = 0;
	public Player(MyPanel myPanel)
	{
		this.myPanel=myPanel;
		
		this.x=(BaseFrame.frameWidth-this.width)/2;
		
		this.y=BaseFrame.frameHeight-this.height*2;
	}
	
	//绘制飞机
	public void drawSelf(Graphics g)
	{
		if(isLife)
		{
			g.drawImage(this.images[imageindex],x,y,width,height,null);
			
			if(this.myPanel.timer%150==0)
			{
				imageindex++;
				
				if(this.imageindex==this.images.length)
					this.imageindex=0;
			}

			//判断玩家是否吃到道具
			for(int i=0;i<this.myPanel.items.size();i++)
			{
				Item item=this.myPanel.items.get(i);
				
				if((this.x>=item.x-this.width && this.x<=item.x+item.width)&&(this.y>=item.y-this.height && this.y<=item.y+item.height))
						item.eated();
			}
		}
		else
		{
			g.drawImage(this.died[i], x, y, width,height,null);
			if(this.myPanel.timer%150==0)
			{
				i++;
				
				if(this.i==this.died.length)
				{
					myPanel.flagPause=true;
				}

			}
		}
	}
	public void underattack()
	{
		if(hp>0)
			hp--;
		else
			isLife=false;
	}
}
