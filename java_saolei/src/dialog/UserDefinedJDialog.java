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

//�Զ�������
public class UserDefinedJDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel jLabelHigh = new JLabel("�߶ȣ� ");//�߶�
	private JLabel jLabelWide = new JLabel("��ȣ� ");//���
	private JLabel jLabelBomb = new JLabel("������ ");//����
	private JLabel jLabelMessage = new JLabel("    ");//message����

	private JTextField jTextFieldHigh;//�Զ��������ĸ߶�
	private JTextField jTextFieldWide;//�Զ��������Ŀ��
	private JTextField jTextFieldBomb;//�Զ�������������

	private JPanel panel;

	private JButton buttonSure;//ȷ�ϰ�ť

	private JButton buttonCancer;//ȡ����ť

	MainFrame mainFrame;//����
    
	//�Զ��������Ĺ��캯��
	public UserDefinedJDialog(final MainFrame mainFrame) {

		super(mainFrame);;//���ø���Ĺ��췽��
		this.mainFrame = mainFrame;
		jLabelMessage.setFont(new Font("����", Font.PLAIN, 12)); //����
		jLabelMessage.setForeground(Color.black);
		this.setTitle("�Զ�������");
		this.add(getPanel());
		this.add(jLabelMessage, BorderLayout.NORTH);
		this.setSize(new Dimension(200, 150));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);//����Ĭ�ϵĹرհ�ť
		
		//Sets the location of the window relative to the specified component according to the following scenarios. 
		this.setLocationRelativeTo(null);
		
		this.setResizable(false);//��ֹ��������仯
		
		//���window������
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
		
		//-----------------------�Զ�������-----------------------------------
		//-----------------------�߶�-----------------------------------
		Box boxHigh = Box.createHorizontalBox();
		jTextFieldHigh = new JTextField(StaticTool.allrow + "");
		jTextFieldHigh.setPreferredSize(new Dimension(30, 20));
		
		
		jTextFieldHigh.addKeyListener(new KeyListener() {
			@Override
			//�����ͷż�����
			public void keyReleased(KeyEvent e) {
				String text = jTextFieldHigh.getText();

				Pattern pattern = Pattern.compile("^[0-9]{1,3}$");//���� 0~999�����������
				Matcher matcher = pattern.matcher(text);
				if (!matcher.matches()) {
					//��������ֺ�pattern������Ҫ�󲻷�ʱ
					jLabelMessage.setText("���������֣����ܳ�����λ");
					if (text.length() > 3) {
						jTextFieldHigh.setText(text.substring(0, 3));
					}

				}

			}
			@Override
			public void keyTyped(KeyEvent e) {

				char ch = e.getKeyChar();
				//����Ϸ�����
				if ((ch < '0') || (ch > '9')) {
					jLabelMessage.setText("���������֣����ܳ�����λ");
					e.setKeyChar((char) 8);
				}
				//�Ƿ����֣��ı�������
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
		
		
		//------------------------ ���---------------------------------
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
					jLabelMessage.setText("���������֣����ܳ�����λ");
					if (text.length() > 3) {
						jTextFieldWide.setText(text.substring(0, 3));
					}

				}

			}
			@Override
			public void keyTyped(KeyEvent e) {

				char ch = e.getKeyChar();
				if ((ch < '0') || (ch > '9')) {
					jLabelMessage.setText("���������֣����ܳ�����λ");
					e.setKeyChar((char) 8);
				} else {
					jLabelMessage.setText("    ");

				}

			}
			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		
	
		boxWide.add(jLabelWide);//���Զ���������ȵı�ǩ��ӵ�boxWide��
		boxWide.add(jTextFieldWide);//���Զ�����������������ӵ�boxWide

		
		//-----------------------������Ŀ----------------------------
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
					jLabelMessage.setText("���������֣����ܳ�����λ");
					if (text.length() > 3) {
						jTextFieldBomb.setText(text.substring(0, 3));
					}
				}
			}
			
			@Override
			public void keyTyped(KeyEvent e) {

				char ch = e.getKeyChar();
				if ((ch < '0') || (ch > '9')) {
					jLabelMessage.setText("���������֣����ܳ�����λ");
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
		
		//����һ����BOx�����ַ�ʽ:Y-AXIS
		Box boxS = new Box(BoxLayout.Y_AXIS);//���ͺ�ʽ����
		boxS.add(boxHigh);
		boxS.add(Box.createVerticalStrut(8));//��ֱ֧��  
		boxS.add(boxWide);
		boxS.add(Box.createVerticalStrut(8));
		boxS.add(boxBomb);
		boxS.add(Box.createVerticalStrut(8));
		boxS.setBorder(border1);
		Box boxT = new Box(BoxLayout.Y_AXIS);
		buttonSure = new JButton("ȷ��");//����ȷ����ť

		UserDefinedListener definedListener = new UserDefinedListener(this,mainFrame);
		buttonSure.setPreferredSize(new Dimension(70, 30));//setPreferredSize���ô��������ѡ��С 
		buttonSure.setMargin(new Insets(0, 2, 0, 2));//����������ǩ֮��֮��Ŀհ�
		buttonSure.addActionListener(definedListener);//��Ӽ�����

		buttonCancer = new JButton("ȡ��");//����ȡ����ť
		buttonCancer.setMargin(new Insets(0, 2, 0, 2));//����������ǩ֮��֮��Ŀհ�
		buttonCancer.setSize(new Dimension(70, 30));//���ô�С
		buttonCancer.addActionListener(definedListener);//��Ӽ�����
		
		boxT.add(buttonSure);//��ȷ����ť��ӵ�boxT������
		boxT.add(Box.createVerticalStrut(25));//createVerticalStruct����һ�����ɼ��ģ��̶��߶ȵ����
		boxT.add(buttonCancer);//��ȡ����ť��ӵ�boxT������
		boxT.setBorder(border1);//��������ı߿�
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
