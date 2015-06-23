package panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import dialog.AboutSweeping;
import dialog.HeroDialog;
import dialog.UserDefinedJDialog;

import tools.StaticTool;

import main.MainFrame;
//JMenuBar是用来创建一个水平菜单栏
//BombJmenuBar继承JMenuBar

public class BombJMenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    //在一个窗口中，我们经常需要给窗口添加菜单条。在 Java 中这一部分是由三个类实现的，
	//它们是JMenuBar、JMenu和JMenuItem，分别对应菜单条、菜单和菜单项
	
	//菜单
	JMenu menuGame = new JMenu("游戏(G)");//菜单栏  -- 游戏
	//菜单
	JMenu menuHelp = new JMenu("帮助(H)");//菜单栏  -- 帮助（H）
    
	//菜单项
	JMenuItem menuItemStart = new JMenuItem("开局");//游戏 - 开局
	//菜单项
	JMenuItem menuItemC = new JMenuItem("初级");//游戏 - 初级
	//菜单项
	JMenuItem menuItemZ = new JMenuItem("中级");//游戏 - 中级
	//菜单项
	JMenuItem menuItemG = new JMenuItem("高级");//游戏 - 高级
	//菜单
	JMenu menuHero = new JMenu("英雄榜");//菜单栏 - 英雄榜
	//菜单项
	JMenuItem menuHeroC = new JMenuItem("初级英雄榜");//菜单栏 -游戏- 英雄榜 -初级英雄榜
	JMenuItem menuHeroZ = new JMenuItem("中级英雄榜");//菜单栏 -游戏- 英雄榜 - 中级英雄榜
	JMenuItem menuHeroG = new JMenuItem("高级英雄榜");//菜单栏 -游戏- 英雄榜 - 高级英雄榜
	JMenuItem menuItemCustom = new JMenuItem("自定义");//菜单栏- 游戏- 自定义
	JMenuItem menuItemExit = new JMenuItem("退出");//菜单 - 退出

	JMenuItem menuItemAbout = new JMenuItem("关于扫雷");//菜单栏 - 帮助 - 关于扫雷
	JMenuItem menuItemHole = new JMenuItem("后门进入");//菜单栏 - 帮助 - 外挂

	MainFrame mainFrame;

	//构造函数
	public BombJMenuBar(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		//初始化
		init();
	}

	private void init() {
		menuGame.setMnemonic('G');// 设置快捷键  -- alt+ G 才会有效果
		menuHelp.setMnemonic('H');// 设置快捷键  -- alt+ H 才会有效果
		// 菜单项加入到菜单
		menuGame.add(menuItemStart);

		//开局按钮设置监听器
		menuItemStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//重新开始游戏
				mainFrame.reStartGame();
			}
		});

		menuGame.addSeparator();// 菜单加入分割线

		menuGame.add(menuItemC);//把游戏-初级加入菜单栏中
		menuItemC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StaticTool.allrow = 9;
				StaticTool.allcol = 9;
				StaticTool.allcount = 10;
				mainFrame.reStartGame();
			}
		});

		menuGame.add(menuItemZ);
		menuItemZ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StaticTool.allrow = 16;
				StaticTool.allcol = 16;
				StaticTool.allcount = 40;
				mainFrame.reStartGame();
			}
		});

		menuGame.add(menuItemG);
		menuItemG.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StaticTool.allrow = 16;
				StaticTool.allcol = 30;
				StaticTool.allcount = 99;
				mainFrame.reStartGame();
			}
		});
		menuGame.addSeparator();// 菜单加入分割线
		menuGame.add(menuItemCustom);
		menuItemCustom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new UserDefinedJDialog(mainFrame);

			}
		});

		menuGame.addSeparator();// 菜单加入分割线
		menuGame.add(menuHero);
		menuHero.add(menuHeroC);
		menuHeroC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new HeroDialog(1, mainFrame);

			}
		});
		menuHero.add(menuHeroZ);
		menuHeroZ.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new HeroDialog(2, mainFrame);

			}
		});
		menuHero.add(menuHeroG);
		menuHeroG.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new HeroDialog(3, mainFrame);

			}
		});

		menuGame.addSeparator();// 菜单加入分割线
		menuGame.add(menuItemExit);
		menuItemExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);

			}
		});

		menuHelp.add(menuItemAbout);
		menuItemAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AboutSweeping(mainFrame);

			}
		});
		menuHelp.add(menuItemHole);
		menuItemHole.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				StaticTool.isHole = true;

			}
		});
		// 菜单加入到菜单条
		this.add(menuGame);
		this.add(menuHelp);

	}

}
