package ru.synergy.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et;

    private static final int REQ_C = 1;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        et = (EditText) findViewById(R.id.et);
        tv = (TextView) findViewById(R.id.tv);

        Button btn = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);

        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

//        TextView textView = (TextView) findViewById(R.id.normal);
//
//        textView.setText("Text from Java code");
//        textView.setTextColor(Color.GREEN);


//        TextView textView = (TextView) findViewById(R.id.header);
//        textView.setText("Hello from Java");

//        ConstraintLayout constraintLayout = new ConstraintLayout(this);
//        TextView textView = new TextView(this);
//        textView.setText("Hello Android!");
//        textView.setTextSize(26);
//
//        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
//                ConstraintLayout.LayoutParams.WRAP_CONTENT,
//                ConstraintLayout.LayoutParams.WRAP_CONTENT);
//
//        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
//        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
//        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID;
//
//        textView.setLayoutParams(layoutParams);
//
//        constraintLayout.addView(textView);
//
//        setContentView(constraintLayout);
    }
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.button:
                i = new Intent(this, MainActivity2.class);
                startActivity(i);
                break;
            case R.id.button2:
                i = new Intent(this, ToInfActivity.class);
                String  eText = et.getText().toString();
                i.putExtra("et", eText);
                startActivity(i);
                break;
            case R.id.button3:
                i = new Intent(this, ComeBackActivity.class);
                startActivityForResult(i, REQ_C);


        }
    }

//    @Override
//    public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
//        return false;
//    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        switch (requestCode) {
//            case RESULT_OK:
//                tv.setText(data.getStringExtra("et"));
//        }
//        return false;
//    }
}