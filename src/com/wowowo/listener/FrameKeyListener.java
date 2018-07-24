package com.wowowo.listener;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.wowowo.model.Boomer;
import com.wowowo.model.Bullet;
import com.wowowo.view.BaseFrame;

public class FrameKeyListener implements KeyListener{

	public BaseFrame baseFrame;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:  
        	this.baseFrame.myPanel.player.up = true;  
            break;  
        case KeyEvent.VK_DOWN:  
        	this.baseFrame.myPanel.player.down = true;  
            break;  
        case KeyEvent.VK_LEFT:  
        	this.baseFrame.myPanel.player.left = true;  
            break;  
        case KeyEvent.VK_RIGHT:  
        	this.baseFrame.myPanel.player.right = true;  
            break;
        case KeyEvent.VK_SPACE:
        	if(this.baseFrame.myPanel.player.attackMode==1)
			{
				Bullet bullet=new Bullet(this.baseFrame.myPanel);
				//ÉèÖÃ×ø±ê
				bullet.x=this.baseFrame.myPanel.player.x+this.baseFrame.myPanel.player.width/2-bullet.width/2;
				bullet.y=this.baseFrame.myPanel.player.y;
				//´æÈëarraylist
				this.baseFrame.myPanel.bullets.add(bullet);
				
				if(this.baseFrame.myPanel.player.hp>0)
					this.baseFrame.myPanel.gso.playSound("./music/bullet.mp3");
			}
			
			else if(this.baseFrame.myPanel.player.attackMode==2)
			{
				Bullet bullet1=new Bullet(this.baseFrame.myPanel);
				bullet1.x=this.baseFrame.myPanel.player.x+this.baseFrame.myPanel.player.width/2-bullet1.width/2;
				bullet1.y=this.baseFrame.myPanel.player.y-30;
				this.baseFrame.myPanel.bullets.add(bullet1);
				
				Bullet bullet2=new Bullet(this.baseFrame.myPanel);
				bullet2.x=this.baseFrame.myPanel.player.x+this.baseFrame.myPanel.player.width/2-bullet2.width/2-18;
				bullet2.y=this.baseFrame.myPanel.player.y-15;
				this.baseFrame.myPanel.bullets.add(bullet2);
				
				Bullet bullet3=new Bullet(this.baseFrame.myPanel);
				bullet3.x=this.baseFrame.myPanel.player.x+this.baseFrame.myPanel.player.width/2-bullet3.width/2+18;
				bullet3.y=this.baseFrame.myPanel.player.y-15;
				this.baseFrame.myPanel.bullets.add(bullet3);
				if(this.baseFrame.myPanel.player.hp>0)
					this.baseFrame.myPanel.gso.playSound("./music/bullet.mp3");
			}
			
			else if(this.baseFrame.myPanel.player.attackMode==3)
			{
				Bullet bullet1=new Bullet(this.baseFrame.myPanel);
				bullet1.x=this.baseFrame.myPanel.player.x+this.baseFrame.myPanel.player.width/2-bullet1.width/2;
				bullet1.y=this.baseFrame.myPanel.player.y-30;
				this.baseFrame.myPanel.bullets.add(bullet1);
				
				Bullet bullet2=new Bullet(this.baseFrame.myPanel);
				bullet2.x=this.baseFrame.myPanel.player.x+this.baseFrame.myPanel.player.width/2-bullet2.width/2-18;
				bullet2.y=this.baseFrame.myPanel.player.y-15;
				this.baseFrame.myPanel.bullets.add(bullet2);
				
				Bullet bullet3=new Bullet(this.baseFrame.myPanel);
				bullet3.x=this.baseFrame.myPanel.player.x+this.baseFrame.myPanel.player.width/2-bullet3.width/2+18;
				bullet3.y=this.baseFrame.myPanel.player.y-15;
				this.baseFrame.myPanel.bullets.add(bullet3);
				
				Bullet bullet4=new Bullet(this.baseFrame.myPanel);
				bullet4.x=this.baseFrame.myPanel.player.x+this.baseFrame.myPanel.player.width/2-bullet4.width/2-38;
				bullet4.y=this.baseFrame.myPanel.player.y;
				this.baseFrame.myPanel.bullets.add(bullet4);
				
				Bullet bullet5=new Bullet(this.baseFrame.myPanel);
				bullet5.x=this.baseFrame.myPanel.player.x+this.baseFrame.myPanel.player.width/2-bullet5.width/2+38;
				bullet5.y=this.baseFrame.myPanel.player.y;
				this.baseFrame.myPanel.bullets.add(bullet5);
				if(this.baseFrame.myPanel.player.hp>0)
					this.baseFrame.myPanel.gso.playSound("./music/bullet.mp3");

			}
        	break;
        case KeyEvent.VK_A:
        	if(this.baseFrame.myPanel.player.boom>0)
        	{
            	this.baseFrame.myPanel.player.boom--;
    			Boomer boomer=new Boomer(this.baseFrame.myPanel);
    			boomer.x=this.baseFrame.myPanel.player.x+this.baseFrame.myPanel.player.width/2-boomer.width/2;
    			boomer.y=this.baseFrame.myPanel.player.y;
    			this.baseFrame.myPanel.boomers.add(boomer);
        	}
        	break;	
        default:  
            break;  
		}
		int num = e.getKeyCode();
		if(this.baseFrame.myPanel.flag==0 && num == KeyEvent.VK_ENTER){
				this.baseFrame.myPanel.flag++;
			}
		else if(this.baseFrame.myPanel.flag==2 && num == KeyEvent.VK_ESCAPE)
		{
				this.baseFrame.myPanel.flag=0;
				this.baseFrame.myPanel.player.count=0;
				this.baseFrame.myPanel.player.isLife=true;
				this.baseFrame.myPanel.player.hp=100;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
        case KeyEvent.VK_UP:  
        	this.baseFrame.myPanel.player.up = false;  
            break;  
        case KeyEvent.VK_DOWN:  
        	this.baseFrame.myPanel.player.down = false;  
            break;  
        case KeyEvent.VK_LEFT:  
        	this.baseFrame.myPanel.player.left = false;  
            break;  
        case KeyEvent.VK_RIGHT:  
        	this.baseFrame.myPanel.player.right = false;  
            break;  
        default:  
            break;
		}
	}

}
