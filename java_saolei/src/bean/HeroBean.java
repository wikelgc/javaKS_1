package bean;

//����Ӣ�۰���
public class HeroBean implements Comparable<HeroBean> {
	private int time;//����Ӣ�۽���ʱ��
	private String name;//����Ӣ�۵�����

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
	public int compareTo(HeroBean o) {//����Ӣ�۵�ʵ����Ϸʱ��

		return this.time - o.time;

	}

	@Override
	public String toString() {//������toString�࣬ɨ�����а��ַ���

		return time + "��\t" + name;//time        name
	}

}
