package main;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import panel.BombJMenuBar;
import panel.BombJPanel;
import panel.FaceJPanel;
import timer.TimerListener;
import tools.StaticTool;

//JFrame是java中的一个类，它是一个容器，允许程序员把其他组件（Swing 的三个基本构造块：标签、按钮和文本字段）
//添加到它里面，把它们组织起来，并把它们呈现给用户。
public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	//
	private BombJMenuBar menuBar = new BombJMenuBar(this);

	private FaceJPanel faceJPanel = new FaceJPanel(this);

	private BombJPanel bombJPanel = new BombJPanel(this);

	private TimerListener timerListener = new TimerListener(this);

	private Timer timer = new Timer(1000, timerListener);

	//构造函数
	public MainFrame() {
		//初始化
		init();

		this.setIconImage(StaticTool.imageIcon.getImage());
		this.setTitle("扫雷");//设置标题
		this.setSize(new Dimension(220, 300));//设置框架的大小
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭按钮
		this.setResizable(false);//设置窗口，拖动边框不能改变大小
		this.setLocationRelativeTo(null);//设置窗口相对于指定组件的位置
		this.pack();//调整此窗口的大小，以适合其子组件的首选大小和布局
		this.setVisible(true);//设置窗口可见

	}

	private void init() {
		this.setJMenuBar(menuBar);//用setJMenuBar再JFrame中添加菜单栏
		this.add(faceJPanel, BorderLayout.NORTH);
		this.add(bombJPanel);

	}

	public void reStartGame() {

		this.remove(faceJPanel);
		this.remove(bombJPanel);

		StaticTool.bombCount = StaticTool.allcount;
		StaticTool.timecount = 0;
		StaticTool.isStart = false;

		faceJPanel = new FaceJPanel(this);
		bombJPanel = new BombJPanel(this);
		this.add(faceJPanel, BorderLayout.NORTH);
		this.add(bombJPanel);
		this.pack();
		this.validate();

		getTimer().stop();

	}

	public FaceJPanel getFaceJPanel() {
		return faceJPanel;
	}

	public BombJPanel getBombJPanel() {
		return bombJPanel;
	}

	public Timer getTimer() {
		return timer;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//这是设置图形界面外观的.java的图形界面外观有3种,默认是java的金属外观,还有就是windows系统,motif系统外观.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			
		} catch (ClassNotFoundException e) {//无法找到指定的类异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {//实例化异常。当试图通过newInstance()方法创建某个类的实例，而该类是一个抽象类或接口时，抛出该异常。
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {//当应用程序试图创建一个实例（而不是数组）、设置或获取一个字段，或者调用一个方法，但当前正在执行的方法无法访问指定类、字段、方法或构造方法的定义时，抛出 IllegalAccessException
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {//指示在用户系统上不存在请求的外观管理类的异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new MainFrame();//

	}

}
