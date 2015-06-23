package bean;

//定义英雄榜类
public class HeroBean implements Comparable<HeroBean> {
	private int time;//定义英雄结束时间
	private String name;//定义英雄的名字

	public HeroBean(int time, String name) {
		super();
		this.time = time;
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(HeroBean o) {//计算英雄的实际游戏时间

		return this.time - o.time;

	}

	@Override
	public String toString() {//重载听toString类，扫雷排行榜字符串

		return time + "秒\t" + name;//time        name
	}

}
