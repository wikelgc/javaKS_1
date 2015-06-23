package timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import tools.StaticTool;

import main.MainFrame;

//ʱ��ļ�����
public class TimerListener implements ActionListener {
	MainFrame mainFrame;

	public TimerListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StaticTool.timecount++;
		//ʱ���ʱ ���ʱ�����999����Ĭ��Ϊ999
		if (StaticTool.timecount > 999) {
			StaticTool.timecount = 999;

		}
		mainFrame.getFaceJPanel().setTime(StaticTool.timecount);

	}

}
