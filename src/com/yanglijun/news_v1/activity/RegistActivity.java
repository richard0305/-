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
				// ʵ��ע�Ṧ��
				BmobUser user = new BmobUser();
				// ����û�������
				String name = etName.getText().toString();
				String pwd = etPwd.getText().toString();
				String pwdAgaer = etPwdAgaer.getText().toString();
				if (name.equals("")) {
					etName.setError("�ʺŲ��ܿ�");
					return;
				}
				if (pwd.equals("")) {
					etPwd.setError("���벻�ܿ�");
					return;
				}
				if (pwdAgaer.equals("")) {
					etPwdAgaer.setError("ȷ�����벻�ܿ�");
					return;
				}
				if (!pwd.equals(pwdAgaer)) {
					etPwdAgaer.setError("�������벻һ��");
					etPwd.setError("�������벻һ��");
					etPwd.setText("");
					etPwdAgaer.setText("");
					return;
				}
				// ����õ��ʺ������װ��user����
				user.setUsername(name);
				user.setPassword(pwdAgaer);
				// ���ӷ�����ע�ᡣ
				user.signUp(new SaveListener<BmobUser>() {
					public void done(BmobUser arg0, BmobException arg1) {
						// TODO Auto-generated method stub
						if (arg1 == null) {
							// ע��ɹ���ת����¼����
							Toast.makeText(getApplicationContext(), "ע��ɹ�", 0)
									.show();
							startActivity(new Intent(RegistActivity.this,
									LoginActivity.class));
							finish();
						} else {
							Toast.makeText(getApplicationContext(),
									"ע��ʧ��" + arg1.getMessage(), 0).show();

						}
					}
				});

			}
		});
	}

}
