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

//JFrame��java�е�һ���࣬����һ���������������Ա�����������Swing ��������������飺��ǩ����ť���ı��ֶΣ�
//��ӵ������棬��������֯�������������ǳ��ָ��û���
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

	//���캯��
	public MainFrame() {
		//��ʼ��
		init();

		this.setIconImage(StaticTool.imageIcon.getImage());
		this.setTitle("ɨ��");//���ñ���
		this.setSize(new Dimension(220, 300));//���ÿ�ܵĴ�С
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ�Ϲرհ�ť
		this.setResizable(false);//���ô��ڣ��϶��߿��ܸı��С
		this.setLocationRelativeTo(null);//���ô��������ָ�������λ��
		this.pack();//�����˴��ڵĴ�С�����ʺ������������ѡ��С�Ͳ���
		this.setVisible(true);//���ô��ڿɼ�

	}

	private void init() {
		this.setJMenuBar(menuBar);//��setJMenuBar��JFrame����Ӳ˵���
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
		//��������ͼ�ν�����۵�.java��ͼ�ν��������3��,Ĭ����java�Ľ������,���о���windowsϵͳ,motifϵͳ���.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			
		} catch (ClassNotFoundException e) {//�޷��ҵ�ָ�������쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {//ʵ�����쳣������ͼͨ��newInstance()��������ĳ�����ʵ������������һ���������ӿ�ʱ���׳����쳣��
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {//��Ӧ�ó�����ͼ����һ��ʵ�������������飩�����û��ȡһ���ֶΣ����ߵ���һ������������ǰ����ִ�еķ����޷�����ָ���ࡢ�ֶΡ��������췽���Ķ���ʱ���׳� IllegalAccessException
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {//ָʾ���û�ϵͳ�ϲ������������۹�������쳣
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		new MainFrame();//

	}

}
