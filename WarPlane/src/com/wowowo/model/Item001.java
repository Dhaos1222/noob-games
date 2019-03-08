package com.wowowo.model;

import java.awt.Image;
import java.awt.Toolkit;

import com.wowowo.view.MyPanel;

public class Item001 extends Item{
	
	public Item001(MyPanel myPanel)
	{
		super(myPanel);
		
		this.width=15;
		
		this.height=15;
		
		this.count=100;
		
		this.images=new Image[] {
				Toolkit.getDefaultToolkit().getImage(Item001.class.getResource("/Image/star.png"))
				//Toolkit.getDefaultToolkit().getImage("src/Image/star.png")
				//Toolkit.getDefaultToolkit().getImage("Image/star01.png"),
				//Toolkit.getDefaultToolkit().getImage("Image/star02.png"),
				//Toolkit.getDefaultToolkit().getImage("Image/star03.png"),
				//Toolkit.getDefaultToolkit().getImage("Image/star04.png"),
				//Toolkit.getDefaultToolkit().getImage("Image/star05.png")
		};
		
		this.imageSpeed=(int)(Math.random()*200+5);
		
		this.speed=3;
	}

}
