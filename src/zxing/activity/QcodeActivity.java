package zxing.activity;

import com.yanglijun.news_v1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class QcodeActivity extends Activity{
	private TextView tv;
	private Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_code);
		tv=(TextView) findViewById(R.id.tv);
		btn=(Button) findViewById(R.id.button1);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivityForResult(new Intent(QcodeActivity.this
						,CaptureActivity.class), 0);
			}
		});
	}

	
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			Bundle bundle=data.getExtras();
			String result=bundle.getString("result");
			tv.setText(result);
		}
	}
}
