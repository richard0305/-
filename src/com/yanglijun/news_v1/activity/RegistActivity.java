package com.yanglijun.news_v1.activity;

import com.yanglijun.news_v1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegistActivity extends Activity {
	private EditText etName, etPwd, etPwdAgaer;
	private Button btnRegist;

	private void initViews() {
		etName = (EditText) findViewById(R.id.editText1);
		etPwd = (EditText) findViewById(R.id.editText2);
		etPwdAgaer = (EditText) findViewById(R.id.editText3);
		btnRegist = (Button) findViewById(R.id.button1);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		initViews();
		initListeners();
	}

	private void initListeners() {
		// TODO Auto-generated method stub
		btnRegist.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				// 实现注册功能
				BmobUser user = new BmobUser();
				// 获得用户名密码
				String name = etName.getText().toString();
				String pwd = etPwd.getText().toString();
				String pwdAgaer = etPwdAgaer.getText().toString();
				if (name.equals("")) {
					etName.setError("帐号不能空");
					return;
				}
				if (pwd.equals("")) {
					etPwd.setError("密码不能空");
					return;
				}
				if (pwdAgaer.equals("")) {
					etPwdAgaer.setError("确认密码不能空");
					return;
				}
				if (!pwd.equals(pwdAgaer)) {
					etPwdAgaer.setError("两次密码不一致");
					etPwd.setError("两次密码不一致");
					etPwd.setText("");
					etPwdAgaer.setText("");
					return;
				}
				// 将获得的帐号密码封装到user对象
				user.setUsername(name);
				user.setPassword(pwdAgaer);
				// 连接服务器注册。
				user.signUp(new SaveListener<BmobUser>() {
					public void done(BmobUser arg0, BmobException arg1) {
						// TODO Auto-generated method stub
						if (arg1 == null) {
							// 注册成功跳转到登录界面
							Toast.makeText(getApplicationContext(), "注册成功", 0)
									.show();
							startActivity(new Intent(RegistActivity.this,
									LoginActivity.class));
							finish();
						} else {
							Toast.makeText(getApplicationContext(),
									"注册失败" + arg1.getMessage(), 0).show();

						}
					}
				});

			}
		});
	}

}
