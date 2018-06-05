package com.wowowo.thread;

import com.wowowo.view.MyPanel;

public class DrawableThread extends Thread{
	
	public MyPanel myPanel;
	
	public DrawableThread(MyPanel myPanel)
	{
		this.myPanel=myPanel;
	}
	
	public void run()
	{
		while(true)
		{
			if(myPanel.flagPause==true)
			{
				try {
					this.currentThread().sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else 
			{
				this.myPanel.repaint();//重新绘制 调用paintComponent方法
				
				try {
					this.currentThread().sleep(1);
				}
				catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
			}

			}
		}
	}

}
