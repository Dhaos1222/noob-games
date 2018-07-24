package com.wowowo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.JPanel;


import com.wowowo.model.Bullet;
import com.wowowo.model.Enemy;
import com.wowowo.model.Enemy001;
import com.wowowo.model.Enemy002;
import com.wowowo.model.Enemy002Bullet;
import com.wowowo.model.Enemy003;
import com.wowowo.model.Enemy004;
import com.wowowo.model.EnemyBullet;
import com.wowowo.model.Item;
import com.wowowo.model.Item002;
import com.wowowo.model.Item003;
import com.wowowo.model.Item004;
import com.wowowo.model.Player;
import com.wowowo.listener.FrameKeyListener;
import com.wowowo.model.Boomer;
import com.wowowo.thread.DrawableThread;
import com.wowowo.thread.GameSound;

public class MyPanel extends JPanel{
	
	//��ű���ͼƬ
	public Image bgImage;
	//��Ϸ����ͼƬ
	public Image endImage;
	//tipsͼƬ
	public Image startImage;
	public Image overImgae;
	
	public int timer=0;
	
	public int top=0;
	
	public DrawableThread drawableThread;
	
	public Player player;
	
	public boolean flagPause = false;
	//��ͣ��־
	public int flag = 0;
	//BOSS��־
	public int boss = 0;
	//����ӵ�����
	public ArrayList<Bullet> bullets=new ArrayList<Bullet>();
	public ArrayList<EnemyBullet> ebullets=new ArrayList<EnemyBullet>();
	//���ը������
	public ArrayList<Boomer> boomers=new ArrayList<Boomer>();
	
	//������еĵл�
	public ArrayList<Enemy> enemies=new ArrayList<Enemy>();
	
	//������еĵл�����
	public ArrayList<Class> enemyType= new ArrayList<Class>();
	
	//������е������
	public ArrayList<Item> items=new ArrayList<Item>();
	public GameSound gso = new GameSound();
	public MyPanel()
	{
		bgImage = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Image/map.jpg"));
		//this.bgImage=Toolkit.getDefaultToolkit().getImage("src/Image/map.jpg");
		endImage = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Image/end.png"));
		startImage = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Image/gamestart.png"));
		overImgae = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/Image/gameover.png"));
		//�������
		this.player=new Player(this);
		player.start();
		
		//�����߳�
		this.drawableThread=new DrawableThread(this);
		
		//�����߳�
		this.drawableThread.start();	

		//����BGM
		gso.playBgSound("./music/bgm.mp3");
	
	}
	
	//�������
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//���Ʊ���ͼ
		g.drawImage(this.bgImage, 0, top-this.bgImage.getHeight(this),this.bgImage.getWidth(this) , this.bgImage.getHeight(this), null);
		g.drawImage(this.bgImage, 0,top,this.bgImage.getWidth(this) , this.bgImage.getHeight(this), null);
		if(flag==1)
		{	
			if(player.isLife==true)
			{
				timer++;
				
				if(timer==60000)
					timer = 0;
				
				//ʵ��ͼƬ���¹���
				if(timer%10==0)
				{
					top++;
					
					if(top>=this.bgImage.getHeight(this))
						top=0;
				}
				
				//�������
				if(BaseFrame.hasPlayer)
				   this.player.drawSelf(g);
				//�����ӵ�
				/*
				if(timer%300==0)
				{
					//������ҵĻ����ȼ�
					if(this.player.attackMode==1)
					{
						Bullet bullet=new Bullet(this);
						//��������
						bullet.x=this.player.x+this.player.width/2-bullet.width/2;
						bullet.y=this.player.y;
						//����arraylist
						this.bullets.add(bullet);
						
						if(player.hp>0)
							gso.playSound("./music/bullet.mp3");
					}
					
					else if(this.player.attackMode==2)
					{
						Bullet bullet1=new Bullet(this);
						bullet1.x=this.player.x+this.player.width/2-bullet1.width/2;
						bullet1.y=this.player.y-30;
						this.bullets.add(bullet1);
						
						Bullet bullet2=new Bullet(this);
						bullet2.x=this.player.x+this.player.width/2-bullet2.width/2-18;
						bullet2.y=this.player.y-15;
						this.bullets.add(bullet2);
						
						Bullet bullet3=new Bullet(this);
						bullet3.x=this.player.x+this.player.width/2-bullet3.width/2+18;
						bullet3.y=this.player.y-15;
						this.bullets.add(bullet3);
						if(player.hp>0)
							gso.playSound("./music/bullet.mp3");
					}
					
					else if(this.player.attackMode==3)
					{
						Bullet bullet1=new Bullet(this);
						bullet1.x=this.player.x+this.player.width/2-bullet1.width/2;
						bullet1.y=this.player.y-30;
						this.bullets.add(bullet1);
						
						Bullet bullet2=new Bullet(this);
						bullet2.x=this.player.x+this.player.width/2-bullet2.width/2-18;
						bullet2.y=this.player.y-15;
						this.bullets.add(bullet2);
						
						Bullet bullet3=new Bullet(this);
						bullet3.x=this.player.x+this.player.width/2-bullet3.width/2+18;
						bullet3.y=this.player.y-15;
						this.bullets.add(bullet3);
						
						Bullet bullet4=new Bullet(this);
						bullet4.x=this.player.x+this.player.width/2-bullet4.width/2-38;
						bullet4.y=this.player.y;
						this.bullets.add(bullet4);
						
						Bullet bullet5=new Bullet(this);
						bullet5.x=this.player.x+this.player.width/2-bullet5.width/2+38;
						bullet5.y=this.player.y;
						this.bullets.add(bullet5);
						if(player.hp>0)
							gso.playSound("./music/bullet.mp3");

					}
				}
				*/
				//���������ӵ�
				for(int i=0;i<bullets.size();i++)
				{
					this.bullets.get(i).drawSelf(g);
				}
				//���������ӵ�
				for(int i=0;i<ebullets.size();i++)
				{
					this.ebullets.get(i).drawSelf(g);
				}
				//����ը��
				for(int i=0;i<boomers.size();i++)
				{
					this.boomers.get(i).drawSelf(g);
				}
				
				
				//�����л�
				if(boss==0)
				{
					if(this.timer%800==0)
					{
						
						Enemy enemy=null;
						enemy = new Enemy001(this);
						this.enemies.add(enemy);
						/*
						if(this.enemyType.size()>0)
						{
							//���һ�ֵл����Ͷ�Ӧ�±�
							int index=(int)(Math.random()*this.enemyType.size());
							
							Enemy enemy=null;
							
							//ͨ�����䴴�����󣨸���������
							try {
								enemy=(Enemy)(this.enemyType.get(index).getConstructors()[0].newInstance(new Object[]{this}));
							} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
									| InvocationTargetException | SecurityException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							//�����������ĵл��������arraylist��
							this.enemies.add(enemy);
						}
						*/
					}
					if(this.timer%4500==0)
					{
						Enemy enemy=null;
						enemy = new Enemy002(this);
						this.enemies.add(enemy);
					}
					
					if(this.timer%2500==0)
					{
						Enemy enemy=null;
						enemy = new Enemy003(this);
						this.enemies.add(enemy);
					}
					
					if(this.timer%50000==0)
						this.boss = 1;
				}
				else if(boss==1)
				{
					Enemy enemy=null;
					enemy = new Enemy004(this);
					this.enemies.add(enemy);
					this.boss=2;
				}

				//��������
				if(this.timer%8000==0)
				{
					Item item = null;
					item = new Item002(this);
					this.items.add(item);
				}
				
				if(this.timer%18000==0)
				{
					Item item = null;
					item = new Item003(this);
					this.items.add(item);
				}
				
				if(this.timer%14000==0)
				{
					Item item = null;
					item = new Item004(this);
					this.items.add(item);
				}
				//�������ел�
				for(int i=0;i<this.enemies.size();i++)
				{
					this.enemies.get(i).drawSelf(g);
				}
				
				//�������е���
				if(BaseFrame.hasItem)
				{
					for(int i=0;i<this.items.size();i++)
					{
						this.items.get(i).drawSelf(g);
					}
				}
				//������
				if(BaseFrame.hasCount)
				{
					//g.setColor(Color.white);	
					//g.drawString(this.player.count+"", BaseFrame.frameWidth-100, 15);
					//���Ʒ�����Ӱ
					g.setColor(Color.black);
					g.setFont(new Font("����",Font.PLAIN,24));
					g.drawString("������"+this.player.count,32,62);
					g.drawString("����ֵ��",182,62);
					g.setFont(new Font("����",Font.PLAIN,24));
					g.drawString("ը������"+this.player.boom,422,62);
					//���Ʒ���
					g.setColor(Color.white);
					g.setFont(new Font("����",Font.PLAIN,24));
					g.drawString("������"+this.player.count,30,60);
					g.drawString("����ֵ��",180,60);
					g.setFont(new Font("����",Font.PLAIN,24));
					g.drawString("ը������"+this.player.boom,420,60);
					//���ƿ���Ѫ������
					g.setColor(new Color(190,195,199));
					g.drawRect(275,42,101,18);
					//����ʵ��Ѫ������
					g.setColor(new Color(234,75,53));
					g.fillRect(276,43,player.hp,17);
					//����Ѫ����ֵ��Ӱ
					g.setColor(Color.black);
					g.setFont(new Font("����",Font.PLAIN,16));
					g.drawString(""+player.hp,317, 59);
					//����Ѫ����ֵ
					g.setColor(Color.white);
					g.setFont(new Font("����",Font.PLAIN,16));
					g.drawString(""+player.hp, 315, 57);

				}
			}
			else
			{
				flag=2;
			}
		}
		else if(flag==2)
		{
			//������е�λ
			bullets.removeAll(bullets);
			ebullets.removeAll(ebullets);
			enemies.removeAll(enemies);
			items.removeAll(items);
			boomers.removeAll(boomers);

			//GameOverͼƬ
			g.drawImage(this.endImage, 0,0,this.endImage.getWidth(this) , this.endImage.getHeight(this), null);
			g.drawImage(this.overImgae, 140,650,this.overImgae.getWidth(this) , this.overImgae.getHeight(this), null);
			//���ƽ���ʱ������ʾ��Ӱ
			g.setColor(Color.black);
			g.setFont(new Font("����",Font.PLAIN,36));
			g.drawString("�÷֣�"+this.player.count+"��",297,627);
			//���ƽ���ʱ������ʾ
			g.setColor(Color.white);
			g.setFont(new Font("����",Font.PLAIN,36));
			g.drawString("�÷֣�"+this.player.count+"��",297,625);
			//GameOver��ʾ����
			//g.drawImage(end_tips_image,30,470,340,80,this);

		}
		else {
			g.drawImage(this.startImage, 140,380,this.startImage.getWidth(this) , this.startImage.getHeight(this), null);
			
			player = new Player(this);
			player.start();
		}
	}
}
