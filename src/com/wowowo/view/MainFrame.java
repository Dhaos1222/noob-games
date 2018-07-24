package com.wowowo.view;

import com.wowowo.model.Enemy001;

public class MainFrame extends BaseFrame{
	
	public MainFrame() 
	{
		createPlayer();
		
		setKeyListener();
		
		setTouchListener();
		
		setPlayerPowerLevel(1);
		
		addEnemyType(Enemy001.class);
		
		setEnemyHasItem();
		
		setCount();
	}

}
