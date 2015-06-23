package dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import tools.StaticTool;

import main.MainFrame;

//设置 - 帮助 - 关于扫雷  
//对话框(JDialog)与框架（JFrame）有一些相似，但它一般是一个临时的窗口，主要用于显示提示信息或接受用户输入
public class AboutSweeping extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//JLabel 对象可以显示文本、图像或同时显示二者
	private JLabel labelIcon;//图片标签

	private JLabel labelOne;//标签1

	private JLabel labelTwo;//标签2

	private JLabel labelThree;//标签3

	private JLabel labelFour;//标签4

	private JLabel labelFive;//标签5

	private Box boxOne;

	private Box boxTwo;

	private Box boxThree;

	private Box boxFour;

	private Box boxFive;

	private JPanel panelT;

	AboutSweeping sweeping = null;

	//构造方法
	public AboutSweeping(MainFrame mainFrame) {

		super(mainFrame);//调用父类的构造方法，一定要放在方法的首个语句
		sweeping = this;
		this.setTitle("关于扫雷");//设置AboutSweeping的标题
		this.add(getPanel());//
		this.setSize(new Dimension(300, 200));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);

	}

	//创建“关于扫雷”文本框
	//定义JPanel中间容器 
	private JPanel getPanel() {
		JPanel panel = new JPanel();
		labelIcon = new JLabel(StaticTool.imageIcon);//图片标签
		labelOne = new JLabel("扫雷游戏！");//JLabel 对象可以显示文本、图像
		
		boxOne = Box.createHorizontalBox();//创建一个从左到右显示其组件的 Box。定义：Box boxOne;
		boxOne.add(labelIcon);
		boxOne.add(Box.createHorizontalStrut(20));//创建一个不可见的、固定宽度的组件.
		boxOne.add(labelOne);
		
		labelTwo   = new JLabel(" *作品说明：java面向对象的课程设计   ");
		boxTwo = Box.createHorizontalBox();
		boxTwo.add(labelTwo);
		
		labelThree = new JLabel("    *指导老师：彭炎                                           ");
		boxThree = Box.createHorizontalBox();
		boxThree.add(labelThree);
		
		labelFour  = new JLabel("    *版权所有：                                                      ");
		boxFour = Box.createHorizontalBox();
		boxFour.add(labelFour);
		
		labelFive  = new JLabel("*制作时间：2015.6.16               ");
		boxFive = Box.createHorizontalBox();
		boxFive.add(labelFive);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); //panel.setLayout 设置布局 ,BoxLayout.Y_AXIS是指定从上到下垂直布置组件
		panel.add(boxOne);
		panel.add(boxTwo);
		panel.add(boxThree);
		panel.add(boxFour);
		panel.add(boxFive);
		
		
		JButton button = new JButton("确定");
		//设置确定按钮的监听器
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//dispose()释放由此 Window、其子组件及其拥有的所有子组件所使用的所有本机屏幕资源
				//释放sweeping的本机屏幕资源
				sweeping.dispose();

			}
		});
		
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel1.add(button);
		panel.add(panel1);
		
		
		//borderfactory是一个产生创建边框的的工厂类
		/*LineBorder是围绕组件周围用户义定宽度的单色行边框。他可以具有方角或是圆角。
		/*LineBorder有三个构造函数，两个工厂方法以及两个BorderFactory工厂方法
		 *
		 *两个工厂构造方法
		 * public static Border createLineBorder(Color color)
           Border lineBorder = BorderFactory.createLineBorder(Color.RED);
 
           public static Border createLineBorder(Color color, int thickness)
           Border lineBorder = BorderFactory.createLineBorder(Color.RED, 5);
		 */
		Border border = BorderFactory.createEtchedBorder();
		panel.setBorder(border);
		panelT = new JPanel(new BorderLayout());
		Border border2 = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		panelT.add(panel);
		panelT.setBorder(border2);

		return panelT;

	}

}
