package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import tools.StaticTool;

import listenner.UserDefinedListener;
import main.MainFrame;

//自定义雷区
public class UserDefinedJDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel jLabelHigh = new JLabel("高度： ");//高度
	private JLabel jLabelWide = new JLabel("宽度： ");//宽度
	private JLabel jLabelBomb = new JLabel("雷数： ");//雷数
	private JLabel jLabelMessage = new JLabel("    ");//message？？

	private JTextField jTextFieldHigh;//自定义雷区的高度
	private JTextField jTextFieldWide;//自定义雷区的宽度
	private JTextField jTextFieldBomb;//自定义雷区的雷数

	private JPanel panel;

	private JButton buttonSure;//确认按钮

	private JButton buttonCancer;//取消按钮

	MainFrame mainFrame;//容器
    
	//自定义雷区的构造函数
	public UserDefinedJDialog(final MainFrame mainFrame) {

		super(mainFrame);;//调用父类的构造方法
		this.mainFrame = mainFrame;
		jLabelMessage.setFont(new Font("楷书", Font.PLAIN, 12)); //设置
		jLabelMessage.setForeground(Color.black);
		this.setTitle("自定义雷区");
		this.add(getPanel());
		this.add(jLabelMessage, BorderLayout.NORTH);
		this.setSize(new Dimension(200, 150));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//设置默认的关闭按钮
		
		//Sets the location of the window relative to the specified component according to the following scenarios. 
		this.setLocationRelativeTo(null);
		
		this.setResizable(false);//禁止窗口任意变化
		
		//添加window监听器
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowDeactivated(WindowEvent e) {

				mainFrame.reStartGame();
			}

		});
		this.setModal(true);
		this.setVisible(true);

	}

	public JPanel getPanel() {
		JPanel jPanel = new JPanel();

		Border border1 = BorderFactory.createEmptyBorder(5, 20, 5, 5);
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		
		//-----------------------自定义雷区-----------------------------------
		//-----------------------高度-----------------------------------
		Box boxHigh = Box.createHorizontalBox();
		jTextFieldHigh = new JTextField(StaticTool.allrow + "");
		jTextFieldHigh.setPreferredSize(new Dimension(30, 20));
		
		
		jTextFieldHigh.addKeyListener(new KeyListener() {
			@Override
			//按键释放监听器
			public void keyReleased(KeyEvent e) {
				String text = jTextFieldHigh.getText();

				Pattern pattern = Pattern.compile("^[0-9]{1,3}$");//输入 0~999的任意的数字
				Matcher matcher = pattern.matcher(text);
				if (!matcher.matches()) {
					//输入的数字和pattern的正则要求不符时
					jLabelMessage.setText("请输入数字，不能超过三位");
					if (text.length() > 3) {
						jTextFieldHigh.setText(text.substring(0, 3));
					}

				}

			}
			@Override
			public void keyTyped(KeyEvent e) {

				char ch = e.getKeyChar();
				//输入合法数字
				if ((ch < '0') || (ch > '9')) {
					jLabelMessage.setText("请输入数字，不能超过三位");
					e.setKeyChar((char) 8);
				}
				//非法数字，文本框清零
				else {
					jLabelMessage.setText("    ");

				}

			}
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		
		boxHigh.add(jLabelHigh);
		boxHigh.add(jTextFieldHigh);
		
		
		//------------------------ 宽度---------------------------------
		Box boxWide = Box.createHorizontalBox();
		jTextFieldWide = new JTextField(StaticTool.allcol + "");
		jTextFieldWide.setPreferredSize(new Dimension(30, 20));
		
		jTextFieldWide.addKeyListener(new KeyListener() {
			@Override
			public void keyReleased(KeyEvent e) {
				String text = jTextFieldWide.getText();

				Pattern pattern = Pattern.compile("^[0-9]{1,3}$");
				Matcher matcher = pattern.matcher(text);
				if (!matcher.matches()) {
					jLabelMessage.setText("请输入数字，不能超过三位");
					if (text.length() > 3) {
						jTextFieldWide.setText(text.substring(0, 3));
					}

				}

			}
			@Override
			public void keyTyped(KeyEvent e) {

				char ch = e.getKeyChar();
				if ((ch < '0') || (ch > '9')) {
					jLabelMessage.setText("请输入数字，不能超过三位");
					e.setKeyChar((char) 8);
				} else {
					jLabelMessage.setText("    ");

				}

			}
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		
	
		boxWide.add(jLabelWide);//把自定义雷区宽度的标签添加到boxWide中
		boxWide.add(jTextFieldWide);//把自定义雷区宽度输入框添加的boxWide

		
		//-----------------------地雷数目----------------------------
		Box boxBomb = Box.createHorizontalBox();
		jTextFieldBomb = new JTextField(StaticTool.bombCount + "");
		jTextFieldBomb.setPreferredSize(new Dimension(30, 20));
		
		jTextFieldBomb.addKeyListener(new KeyListener() {
			
			@Override
			public void keyReleased(KeyEvent e) {
				String text = jTextFieldBomb.getText();
				Pattern pattern = Pattern.compile("^[0-9]{1,3}$");
				Matcher matcher = pattern.matcher(text);
				if (!matcher.matches()) {
					jLabelMessage.setText("请输入数字，不能超过三位");
					if (text.length() > 3) {
						jTextFieldBomb.setText(text.substring(0, 3));
					}
				}
			}
			
			@Override
			public void keyTyped(KeyEvent e) {

				char ch = e.getKeyChar();
				if ((ch < '0') || (ch > '9')) {
					jLabelMessage.setText("请输入数字，不能超过三位");
					e.setKeyChar((char) 8);
				} else {
					jLabelMessage.setText("    ");

				}

			}
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		boxBomb.add(jLabelBomb);
		boxBomb.add(jTextFieldBomb);
		
		//定义一个大BOx，布局方式:Y-AXIS
		Box boxS = new Box(BoxLayout.Y_AXIS);//列型盒式布局
		boxS.add(boxHigh);
		boxS.add(Box.createVerticalStrut(8));//垂直支撑  
		boxS.add(boxWide);
		boxS.add(Box.createVerticalStrut(8));
		boxS.add(boxBomb);
		boxS.add(Box.createVerticalStrut(8));
		boxS.setBorder(border1);
		Box boxT = new Box(BoxLayout.Y_AXIS);
		buttonSure = new JButton("确定");//创建确定按钮

		UserDefinedListener definedListener = new UserDefinedListener(this,mainFrame);
		buttonSure.setPreferredSize(new Dimension(70, 30));//setPreferredSize设置此组件的首选大小 
		buttonSure.setMargin(new Insets(0, 2, 0, 2));//设置组件与标签之际之间的空白
		buttonSure.addActionListener(definedListener);//添加监听器

		buttonCancer = new JButton("取消");//创建取消按钮
		buttonCancer.setMargin(new Insets(0, 2, 0, 2));//设置组件与标签之际之间的空白
		buttonCancer.setSize(new Dimension(70, 30));//设置大小
		buttonCancer.addActionListener(definedListener);//添加监听器
		
		boxT.add(buttonSure);//把确定按钮添加的boxT容器中
		boxT.add(Box.createVerticalStrut(25));//createVerticalStruct创建一个不可见的，固定高度的组件
		boxT.add(buttonCancer);//把取消按钮添加的boxT容器中
		boxT.setBorder(border1);//设置组件的边框
		panel.add(boxS);
		panel.add(boxT);

		Border border = BorderFactory.createEmptyBorder(3, 15, 5, 15);
		jPanel.setBorder(border);
		jPanel.add(panel);
		return jPanel;
	}

	public JLabel getjLabelMessage() {
		return jLabelMessage;
	}

	public JTextField getjTextFieldHigh() {
		return jTextFieldHigh;
	}

	public JTextField getjTextFieldWide() {
		return jTextFieldWide;
	}

	public JTextField getjTextFieldBomb() {
		return jTextFieldBomb;
	}

	public JButton getButtonSure() {
		return buttonSure;
	}

	public JButton getButtonCancer() {
		return buttonCancer;
	}

}
