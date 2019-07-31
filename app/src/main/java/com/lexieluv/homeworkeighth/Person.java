package com.lexieluv.homeworkeighth;

public class Person {
	//成员属性：姓名，性别，食物
	private String name;
	private String sex;
	Food food;

	//无参构造方法
	public Person(){ }

	//所有属性的带参构造方法
	public Person(String name, String sex, Food food) {
		this.name = name;
		this.sex = sex;
		this.food = food;
	}

	//属性的getter/setter方法
	public String getName() {

		return name;
	}
	public void setName(String name) {

		this.name = name;
	}
	public String getSex() {

		return sex;
	}
	public void setSex(String sex) {

		this.sex = sex;
	}
	public Food getFood() {

		return food;
	}
	public void setFood(Food food) {

		this.food = food;
	}

	//重写toString方法
	@Override
	public String toString() {
		return "Person [name=" + getName() + ", sex=" + getSex() + ", food=" + food + "]";
	}

}
