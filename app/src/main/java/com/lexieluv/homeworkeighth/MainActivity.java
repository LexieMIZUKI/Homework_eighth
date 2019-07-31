package com.lexieluv.homeworkeighth;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;

/*
 * 步骤
 * 1、初始化控件
 * 2、初始化数据
 * 3、为控件添加监听器
 */
public class MainActivity extends Activity {
	private EditText name;
	private RadioGroup sex;
	private CheckBox spicy, seafood, sour;
	private SeekBar seekBar;
	private Button find;
	private ImageView iv_pic;
	private ToggleButton toggleButton;
	private List<Food> lists_food;
	Iterator<Food> it;
	Food food = new Food();
	private List<Food> lists_get;
	private Person person;
	private RadioGroupListener radioGroupListener;
	private boolean isSeafood;
	private boolean isSpicy;
	private boolean isSour;
	private CheckBoxListener checkBoxListener;
	private int price = 0;
	private SeekBarListener seekBarListener;
	private ButtonListener buttonListener;
	int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_food);
		// 初始化控件
		initView();
		// 初始化数据
		initData();
		// 为控件添加监听器
		setListener();
	}

	private void setListener() {


		radioGroupListener = new RadioGroupListener();
		sex.setOnCheckedChangeListener(radioGroupListener);

		checkBoxListener = new CheckBoxListener();
		seafood.setOnCheckedChangeListener(checkBoxListener);
		spicy.setOnCheckedChangeListener(checkBoxListener);
		sour.setOnCheckedChangeListener(checkBoxListener);

		seekBarListener = new SeekBarListener();
		seekBar.setOnSeekBarChangeListener(seekBarListener);

		buttonListener = new ButtonListener();
		find.setOnClickListener(buttonListener);
		toggleButton.setOnClickListener(buttonListener);
	}

	//lists_get方法就是一旦找到满足条件的食物，将会存到一个list里，然后一个个输出
	private void initData() {
		person = new Person();
		lists_get = new ArrayList<Food>();
		lists_food = new ArrayList<Food>();
		lists_food.add(new Food("麻辣香锅", 55, R.drawable.malaxiangguo, true, false, false));

		lists_food.add(new Food("水煮鱼", 48, R.drawable.shuizhuyu, true, true, false));
		lists_food.add(new Food("麻辣火锅", 80, R.drawable.malahuoguo, true, true, false));

		lists_food.add(new Food("清蒸鲈鱼", 68, R.drawable.qingzhengluyu, false, true, false));

		lists_food.add(new Food("桂林米粉", 15, R.drawable.guilin, false, false, false));
		lists_food.add(new Food("上汤娃娃菜", 28, R.drawable.wawacai, false, false, false));
		lists_food.add(new Food("红烧肉", 60, R.drawable.hongshaorou, false, false, false));
		lists_food.add(new Food("木须肉", 40, R.drawable.muxurou, false, false, false));
		lists_food.add(new Food("酸菜牛肉面", 35, R.drawable.suncainiuroumian, false, false, true));
		lists_food.add(new Food("西芹炒百合", 38, R.drawable.xiqin, false, false, false));

		lists_food.add(new Food("酸辣汤", 40, R.drawable.suanlatang, true, false,
				true));

	}

	private void initView() {
		name = (EditText) findViewById(R.id.et_name);

		sex = (RadioGroup) findViewById(R.id.rg_sex);
		spicy = (CheckBox) findViewById(R.id.cb_spicy);
		seafood = (CheckBox) findViewById(R.id.cb_seafood);
		sour = (CheckBox) findViewById(R.id.cb_sour);
		seekBar = (SeekBar) findViewById(R.id.sb_price);
		seekBar.setProgress(30);
		find = (Button) findViewById(R.id.btn_find);
		toggleButton = (ToggleButton) findViewById(R.id.tb_click);
		toggleButton.setChecked(true);
		iv_pic = (ImageView) findViewById(R.id.iv_pic);
	}

	class RadioGroupListener implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// 当用户选择当前RadioGroup组的Button时被触发
			switch (checkedId) {
				case R.id.rb_man:
					person.setSex("男");
					break;
				case R.id.rb_woman:
					person.setSex("女");
					break;
			}
			System.out.println("性别：" + person.getSex());
		}

	}

	class CheckBoxListener implements
			CompoundButton.OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(CompoundButton buttonView,
									 boolean isChecked) {
			// 当控件状态改变时被触发
			CheckBox cbBox = (CheckBox) buttonView;
			switch (cbBox.getId()) {
				case R.id.cb_seafood:
					if (isChecked) {
						isSeafood = true;
					} else {
						isSeafood = false;
					}

					break;
				case R.id.cb_sour:
					if (isChecked) {
						isSour = true;
					} else {
						isSour = false;
					}
					break;
				case R.id.cb_spicy:
					if (isChecked) {
						isSpicy = true;
					} else {
						isSpicy = false;
					}
					break;

			}
			System.out.println("当前喜好：" + "辣：" + isSpicy + " 海鲜：" + isSeafood + " 酸"
					+ isSour);

		}

	}

	class SeekBarListener implements OnSeekBarChangeListener {

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
									  boolean fromUser) {
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			price = seekBar.getProgress();
			Toast.makeText(MainActivity.this, "价格：" + price, Toast.LENGTH_SHORT).show();
		}

	}

	class ButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.btn_find:
					lists_get.clear();
					count = 0;
					//点击时，将会把数据都放在lists_get集合中，并显示一定的找到信息，并显示第一张图片。
					checkData();
//					it = lists_get.iterator();
					if (lists_get.size()  != 0) {
						showPic(count);

						Toast.makeText(MainActivity.this, "一共找到了" + lists_get.size() + "个菜品！", Toast.LENGTH_SHORT).show();
					} else
						Toast.makeText(MainActivity.this, "未找到任何菜品！请重新选择！", Toast.LENGTH_SHORT).show();
					toggleButton.setChecked(true);
					break;
				case R.id.tb_click:
					//当用户点击显示信息时，先是将第一张图片信息输出，接着菜品信息将会打印出来第一个；
					//当点击下一个时，图片会更换，点击显示信息打印该图片信息；
					// 若是最后一个菜品，那么点击下一个时，图片不会更换，而是只显示一条：这是最后一个菜品的信息。
//					it = lists_get.iterator();
					//这个为点击下一个，此时显示为显示信息，因此为texton
					if (toggleButton.isChecked()) {
						if(count < lists_get.size()) {
							showPic(count);
						}
						else {
							Toast.makeText(MainActivity.this, "由于已经是最后一个菜品，从头显示！", Toast.LENGTH_SHORT).show();
//							lists_get.clear();
//							checkData();
//							count = 0;
							showPic(count);
						}
					}
						//这个为点击显示信息时，此时显示为下一个，因此为textoff
						else{
						String n = name.getText().toString();
						person.setName(n);
						if(count >= lists_get.size())
							count = 0;
						person.setFood(lists_get.get(count));
						Toast.makeText(MainActivity.this, "个人信息为："+person+",菜品信息为：" + lists_get.get(count), Toast.LENGTH_SHORT).show();
						count ++;
						System.out.println("********************  "+count);
					}
						break;
					}

			}
		}

		private void checkData() {
			// 找出菜品
			for (int i = 0; i < lists_food.size(); i++) {
				Food food = lists_food.get(i);
				if ((food.getPrice() <= price)
						&& (food.isSeafood() == isSeafood && food.isSpicy() == isSpicy && food
						.isSour() == isSour)) {
					lists_get.add(food);
				}
			}
			System.out.println("*********   " + lists_get.size());
		}

		public void showPic(int count) {
//			it = lists_get.iterator();
			if(count >= lists_get.size() ){
				count = 0;
			}
			iv_pic.setImageResource(lists_get.get(count).getPic());
		}
	}

