package com.yanglijun.news_v1.activity;

import com.yanglijun.news_v1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends Activity {
	private EditText etName, etPwd;
	private Button btnLogin;
	private TextView tvRegist;
	private TextView tvTurnOn;

	private void initViews() {
		etName = (EditText) findViewById(R.id.editText4);
		etPwd = (EditText) findViewById(R.id.editText5);
		btnLogin = (Button) findViewById(R.id.button1);
		tvRegist = (TextView) findViewById(R.id.textView3);
		tvTurnOn=(TextView) findViewById(R.id.tv_turnon);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initViews();
		
	
		initListeners();
	}

	private void initListeners() {
		tvTurnOn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this, MainActivity.class));
				finish();
				
			}
		});
		
		tvRegist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(LoginActivity.this,
						RegistActivity.class));
			}
		});
		// TODO Auto-generated method stub
		btnLogin.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 登录功能实现
				String name = etName.getText().toString();
				String pwd = etPwd.getText().toString();
				
				// 创建登录对象
				BmobUser user = new BmobUser();
				user.setUsername(name);
				user.setPassword(pwd);
				//登录服务器
				user.login(new SaveListener<BmobUser>() {
					public void done(BmobUser arg0, BmobException arg1) {
						if (arg1 == null) {
							Toast.makeText(getApplicationContext(), "登录成功", 0)
									.show();
							startActivity(new Intent(LoginActivity.this,
									MainActivity.class));
							finish();

						} else {
							Toast.makeText(getApplicationContext(),
									"登录失败" + arg1.getMessage(), 0).show();
						}

					}
				});

			}
		});
	}

}
