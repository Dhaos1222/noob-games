package com.wowowo.listener;

import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
        default:  
            break;  
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
