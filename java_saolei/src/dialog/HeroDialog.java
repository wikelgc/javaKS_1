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
//ɨ��Ӣ�۰�
//����Ӣ�۰�Ի��򣨼̳жԻ����ࣩ
public class HeroDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel panel = null;
	JTextArea textArea = new JTextArea();
	private int level = 0;

	public HeroDialog(int level, MainFrame mainFrame) {//Ӣ�۰�
		super(mainFrame);//���ø���Ĺ��췽��
		this.level = level;
		this.setTitle("ɨ��Ӣ�۰�");
		this.add(getPanel());
		this.setSize(new Dimension(220, 150));//���öԻ���Ĵ�С
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//����Ĭ�Ϲر�ѡ��
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setModal(true);
		this.setVisible(true);
	}

	public JPanel getPanel() {
		textArea.setEditable(false);//ʹ������������Ŀؼ����ܱ��༭
		textArea.setLineWrap(true);//TextArea����Ϊ�Զ�����

		JScrollPane scrollPane = new JScrollPane(textArea);//��textArea�й�����
		addMessage();
		panel = new JPanel(new BorderLayout());//BorderLayout�߽粼�ֹ�����
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
