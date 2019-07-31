package com.lexieluv.homeworkeighth;

public class Food {
	//成员属性：姓名，口味（辣，海鲜，酸），价格，图片
	private String name;
	private boolean spicy;
	private boolean seafood;
	private boolean sour;
	private int price;
	private int pic;

	//属性的getter/setter方法
	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public boolean isSpicy() {

		return spicy;
	}

	public void setSpicy(boolean spicy) {

		this.spicy = spicy;
	}

	public boolean isSeafood() {

		return seafood;
	}

	public void setSeafood(boolean seafood) {

		this.seafood = seafood;
	}

	public boolean isSour() {

		return sour;
	}

	public void setSour(boolean sour) {

		this.sour = sour;
	}

	public int getPrice() {

		return price;
	}

	public void setPrice(int price) {

		this.price = price;
	}

	public int getPic() {

		return pic;
	}

	public void setPic(int pic) {

		this.pic = pic;
	}

	//重写toString方法
	@Override
	public String toString() {
		return "Food [name=" + getName() + ", spicy=" + isSpicy() + ", seafood=" + isSeafood()
				+ ", sour=" + isSour() + ", price=" + getPrice() + ", pic=" + getPic() + "]";
	}
	//无参构造方法
	public Food(){ }

	//所有属性的带参构造方法
	public Food(String name, int price, int pic, boolean spicy, boolean seafood, boolean sour
			) {
		super();
		this.name = name;
		this.spicy = spicy;
		this.seafood = seafood;
		this.sour = sour;
		this.price = price;
		this.pic = pic;
	}



}
