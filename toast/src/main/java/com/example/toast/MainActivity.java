package com.example.toast;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.text.Layout;
        import android.view.Gravity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
            private Button button;
             private Button button2;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
               button= (Button) findViewById(R.id.button);
                button2= (Button) findViewById(R.id.button2);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast toast=Toast.makeText(MainActivity.this,"点击了按钮",Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER,10,10);
                        LinearLayout toastView= (LinearLayout) toast.getView();
                        ImageView iv=new ImageView(MainActivity.this);
                        iv.setImageResource(R.mipmap.meinv);
                        toastView.addView(iv,1);
                        toast.show();


                    }

                });
                button2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //获取布局填充器
                        LayoutInflater flater=getLayoutInflater();
                        //从R.layout布局中获取该视图
                        View view=flater.inflate(R.layout.custom,null);
                        //从该视图中获取image
                        ImageView image= (ImageView)view.findViewById(R.id.imageView);
                        image.setImageResource(R.mipmap.meinv);
                        //从该视图中获取TextView
                        TextView title=(TextView) view.findViewById(R.id.tv_toast);
                        title.setText("完全自定义Toast");
                        //创建一个Toast对象从当前上下文中
                        Toast toast=new Toast(getApplicationContext());
                        //设置显示的位置
                        toast.setGravity(Gravity.BOTTOM,10,10);
                        //设置持续的时间
                        toast.setDuration(Toast.LENGTH_LONG);
                        //将view视图设置到该Toast对象中
                        toast.setView(view);
                        //可视化
                        toast.show();

                    }
                });

            }
}
