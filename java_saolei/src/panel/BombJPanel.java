package panel;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import listenner.Listener;
import main.MainFrame;

import tools.StaticTool;

import bean.MineLable;
//JPanel 为javax.swing包中的，为面板容器，可以加入到JFrame中 , 它自身是个容器，
//可以把其他compont加入到JPanel中,如JButton,JTextArea,JTextFiled
public class BombJPanel extends JPanel {
	/**
	 * 
	 */
	//serialVersionUID:相当于java类的身份证
	private static final long serialVersionUID = 1L;
	
	//地雷的位置
	MineLable[][] labels = new MineLable[StaticTool.allrow][StaticTool.allcol];
	private Listener listener;
	private MainFrame mainFrame;

	public BombJPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setLayout(new GridLayout(StaticTool.allrow, StaticTool.allcol));//设置布局方式为网格布局
		init();//初始化

	}

	private void init() {

		listener = new Listener(labels, mainFrame);

		for (int i = 0; i < labels.length; i++) {
			for (int j = 0; j < labels[i].length; j++) {
				labels[i][j] = new MineLable(i, j);
				labels[i][j].setIcon(StaticTool.iconBlank);
				labels[i][j].addMouseListener(listener);
				this.add(labels[i][j]);
			}
		}
		Border borderLow = BorderFactory.createLoweredBevelBorder();

		Border borderEmpty = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border borderCom1 = BorderFactory.createCompoundBorder(borderEmpty,
				borderLow);

		this.setBorder(borderCom1);
		this.setBackground(Color.LIGHT_GRAY);

	}

}
