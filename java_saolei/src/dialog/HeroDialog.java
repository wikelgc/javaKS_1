package dialog;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import main.MainFrame;

import tools.StaticTool;

import bean.HeroBean;
//扫雷英雄榜
//创建英雄榜对话框（继承对话框类）
public class HeroDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel panel = null;
	JTextArea textArea = new JTextArea();
	private int level = 0;

	public HeroDialog(int level, MainFrame mainFrame) {//英雄榜
		super(mainFrame);//调用父类的构造方法
		this.level = level;
		this.setTitle("扫雷英雄榜");
		this.add(getPanel());
		this.setSize(new Dimension(220, 150));//设置对话框的大小
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//设置默认关闭选项
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
	}

	public JPanel getPanel() {
		textArea.setEditable(false);//使调用这个函数的控件不能被编辑
		textArea.setLineWrap(true);//TextArea设置为自动换行

		JScrollPane scrollPane = new JScrollPane(textArea);//让textArea有滚动条
		addMessage();
		panel = new JPanel(new BorderLayout());//BorderLayout边界布局管理器
		panel.add(scrollPane);
		return panel;
	}

	private void addMessage() {
		if (level == 1) {
			for (HeroBean heroBean : StaticTool.treeSetC) {
				textArea.append(heroBean.toString() + "\n");
			}

		} 
		else if (level == 2) {
			for (HeroBean heroBean : StaticTool.treeSetZ) {
				textArea.append(heroBean.toString() + "\n");
			}
		} 
		else {
			for (HeroBean heroBean : StaticTool.treeSetG) {
				textArea.append(heroBean.toString() + "\n");
			}
		}
	}

}
