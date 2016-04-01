package com.example.sdcard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
public class MainActivity extends AppCompatActivity implements View.OnClickListener
        , ViewSwitcher.ViewFactory {
    private Button button;
    private int i=0;
    private ImageButton mImageButton;
    private TextSwitcher mTextSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        mTextSwitcher = (TextSwitcher) findViewById(R.id.mTextSwitcher);
        mTextSwitcher.setFactory(this);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        i++;
        mTextSwitcher.setText(i+"");
    }

    @Override
    public View makeView() {
        TextView textView=new TextView(this);
        textView.setText(i+"");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }


}