package com.example.luweicheng.xmlserizable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.Button;

import org.xmlpull.v1.XmlSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private Button but_send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but_send= (Button) findViewById(R.id.button);
        but_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> list=new ArrayList<Student>();
                for(int i=0;i<10;i++){
                    Student stu=new Student("芦苇"+i,"17","nan");
                    list.add(stu);
                }
                File file=new File(getFilesDir(),"info.xml");
                try {

                    FileOutputStream os=new FileOutputStream(file);
                    XmlSerializer xs= Xml.newSerializer();
                    xs.setOutput(os,"utf-8");
                    //开始生成xml文件
                    xs.startDocument("utf-8",true);
                    xs.startTag(null,"students");
                    for(Student s :list){
                        xs.startTag(null,"student");
                        xs.startTag(null,"name");
                        xs.text(s.getName());
                        xs.endTag(null,"name");
                        xs.startTag(null,"age");
                        xs.text(s.getAge());
                        xs.endTag(null,"age");
                        xs.startTag(null,"gender");
                        xs.text(s.getGender());
                        xs.endTag(null,"gender");
                        xs.endTag(null,"student");
                      }
                    xs.endTag(null,"students");
                    xs.endDocument();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
