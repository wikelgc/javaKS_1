package listenner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tools.StaticTool;

import main.MainFrame;

import dialog.UserDefinedJDialog;

public class UserDefinedListener implements ActionListener {
	
	UserDefinedJDialog userDefinedJDialog;

	MainFrame mainFrame;

	public UserDefinedListener(UserDefinedJDialog userDefinedJDialog,
			MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.userDefinedJDialog = userDefinedJDialog;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//取消按钮
		if (e.getSource() == userDefinedJDialog.getButtonCancer()) {
			userDefinedJDialog.dispose();
			mainFrame.reStartGame();
		} 
		//确定按钮
		else if (e.getSource() == userDefinedJDialog.getButtonSure()) {
			//获取自定义雷区的高度文本框的的值
			String highT = userDefinedJDialog.getjTextFieldHigh().getText();
			//定义高度值得正则表达式
			Pattern pattern = Pattern.compile("^[0-9]{1,3}$");
			//判断highT是否符合正则表达式
			Matcher matcher = pattern.matcher(highT);
			int row = 0;
			//不符合正则表达式
			if (!matcher.matches()) {
				userDefinedJDialog.getjLabelMessage()
						.setText("输入的行数范围应在9-30之间");
				return;
			}
			else {
				row = Integer.parseInt(highT);
				//输入的行数的判断
				if (row < 9 || row > 30) {
					userDefinedJDialog.getjLabelMessage().setText(
							"输入的行数范围应在9-30之间");
					return;
				}

			}
			
			//获取自定义雷区的列文本框的值
			String colT = userDefinedJDialog.getjTextFieldWide().getText();
			int col = 0;
			try {
				col = Integer.parseInt(colT);
				if (col < 9 || col > 30) {
					userDefinedJDialog.getjLabelMessage().setText(
							"输入的列数范围应在9-30之间");
					return;
				}
			} catch (Exception e2) {
				userDefinedJDialog.getjLabelMessage().setText(
						"列数应该为数字且范围应在9-30之间");
				return;
			}
			
			
			//获取自定义雷区的地雷的数量
			String mineT = userDefinedJDialog.getjTextFieldBomb().getText();
			int mine = 0;
			try {
				//如果雷的数量少于10，则设置雷的数量为5个
				mine = Integer.parseInt(mineT);
				if (mine < 10) {
					mine = 10;
				} else {
					mine = Math.min(mine, StaticTool.allrow * StaticTool.allcol* 4 / 5);//比较a，b的大小，返回值为小的那个数
				}
			} catch (Exception e3) {
				userDefinedJDialog.getjLabelMessage().setText("雷数应该为数字");
				return;
			}
			userDefinedJDialog.dispose();
			StaticTool.allrow = row;
			StaticTool.allcol = col;
			StaticTool.allcount = mine;

			mainFrame.reStartGame();
		}

	}

}
