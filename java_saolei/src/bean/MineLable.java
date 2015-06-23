package bean;

import javax.swing.JLabel;

//定义 扫雷的标识
public class MineLable extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean mineTag;//扫雷标准
	private boolean expendTag;//
	private boolean flagTag;//
	private int rowx;
	private int coly;
	private int counAround;
	private int rightClickCount;

	public MineLable(int x, int y) {
		this.rowx = x;
		this.coly = y;

	}

	public boolean isMineTag() { //判断是否是雷
		return mineTag;
	}

	public void setMineTag(boolean mineTag) {//设置雷的标识
		this.mineTag = mineTag;
	}

	public boolean isExpendTag() {
		return expendTag;
	}

	public void setExpendTag(boolean expendTag) {
		this.expendTag = expendTag;
	}

	public boolean isFlagTag() {//判断是否是红旗标志
		return flagTag;
	}

	public void setFlagTag(boolean flagTag) {//判断是否是红旗标志
		this.flagTag = flagTag;
	}

	public int getRowx() {//获得棋盘的x轴
		return rowx;
	}

	public void setRowx(int rowx) {
		this.rowx = rowx;
	}

	public int getColy() {//获得棋盘的y轴
		return coly;
	}

	public void setColy(int coly) {
		this.coly = coly;
	}

	public int getCounAround() {
		return counAround;
	}

	public void setCounAround(int counAround) {
		this.counAround = counAround;
	}

	public int getRightClickCount() {
		return rightClickCount;
	}

	public void setRightClickCount(int rightClickCount) {
		this.rightClickCount = rightClickCount;
	}

}
