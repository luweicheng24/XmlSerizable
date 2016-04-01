package com.example.imageswitcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,ViewSwitcher.ViewFactory{
    private int[] image={R.mipmap.baxianhua,R.mipmap.dengta,R.mipmap.juhua,R.mipmap.shuimu,R.mipmap.yujinxiang,R.mipmap.shamo};
    private Button button;
    private int i=0;
    private ImageSwitcher mImageSwitcher;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button1);
        mImageSwitcher= (ImageSwitcher) findViewById(R.id.is);
        button.setOnClickListener(this);
        mImageSwitcher.setFactory(this);
    }

    @Override
    public void onClick(View v) {
     i++;
        if(i==6){
            i=0;
        }
        mImageSwitcher.setImageResource(image[i]);
    }

    @Override
    public View makeView() {
        ImageView iv=new ImageView(this);
        iv.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.WRAP_CONTENT));
        iv.setImageResource(image[i]);
        return iv;

    }
}
