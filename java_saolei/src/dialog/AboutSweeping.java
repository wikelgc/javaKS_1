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

//���� - ���� - ����ɨ��  
//�Ի���(JDialog)���ܣ�JFrame����һЩ���ƣ�����һ����һ����ʱ�Ĵ��ڣ���Ҫ������ʾ��ʾ��Ϣ������û�����
public class AboutSweeping extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//JLabel ���������ʾ�ı���ͼ���ͬʱ��ʾ����
	private JLabel labelIcon;//ͼƬ��ǩ

	private JLabel labelOne;//��ǩ1

	private JLabel labelTwo;//��ǩ2

	private JLabel labelThree;//��ǩ3

	private JLabel labelFour;//��ǩ4

	private JLabel labelFive;//��ǩ5

	private Box boxOne;

	private Box boxTwo;

	private Box boxThree;

	private Box boxFour;

	private Box boxFive;

	private JPanel panelT;

	AboutSweeping sweeping = null;

	//���췽��
	public AboutSweeping(MainFrame mainFrame) {

		super(mainFrame);//���ø���Ĺ��췽����һ��Ҫ���ڷ������׸����
		sweeping = this;
		this.setTitle("����ɨ��");//����AboutSweeping�ı���
		this.add(getPanel());//
		this.setSize(new Dimension(300, 200));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);

	}

	//����������ɨ�ס��ı���
	//����JPanel�м����� 
	private JPanel getPanel() {
		JPanel panel = new JPanel();
		labelIcon = new JLabel(StaticTool.imageIcon);//ͼƬ��ǩ
		labelOne = new JLabel("ɨ����Ϸ��");//JLabel ���������ʾ�ı���ͼ��
		
		boxOne = Box.createHorizontalBox();//����һ����������ʾ������� Box�����壺Box boxOne;
		boxOne.add(labelIcon);
		boxOne.add(Box.createHorizontalStrut(20));//����һ�����ɼ��ġ��̶���ȵ����.
		boxOne.add(labelOne);
		
		labelTwo   = new JLabel(" *��Ʒ˵����java�������Ŀγ����   ");
		boxTwo = Box.createHorizontalBox();
		boxTwo.add(labelTwo);
		
		labelThree = new JLabel("    *ָ����ʦ������                                           ");
		boxThree = Box.createHorizontalBox();
		boxThree.add(labelThree);
		
		labelFour  = new JLabel("    *��Ȩ���У�                                                      ");
		boxFour = Box.createHorizontalBox();
		boxFour.add(labelFour);
		
		labelFive  = new JLabel("*����ʱ�䣺2015.6.16               ");
		boxFive = Box.createHorizontalBox();
		boxFive.add(labelFive);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); //panel.setLayout ���ò��� ,BoxLayout.Y_AXIS��ָ�����ϵ��´�ֱ�������
		panel.add(boxOne);
		panel.add(boxTwo);
		panel.add(boxThree);
		panel.add(boxFour);
		panel.add(boxFive);
		
		
		JButton button = new JButton("ȷ��");
		//����ȷ����ť�ļ�����
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//dispose()�ͷ��ɴ� Window�������������ӵ�е������������ʹ�õ����б�����Ļ��Դ
				//�ͷ�sweeping�ı�����Ļ��Դ
				sweeping.dispose();

			}
		});
		
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel1.add(button);
		panel.add(panel1);
		
		
		//borderfactory��һ�����������߿�ĵĹ�����
		/*LineBorder��Χ�������Χ�û��嶨��ȵĵ�ɫ�б߿������Ծ��з��ǻ���Բ�ǡ�
		/*LineBorder���������캯�����������������Լ�����BorderFactory��������
		 *
		 *�����������췽��
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
