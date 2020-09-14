package com.example.step01hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //버튼을 누른 횟수를 지정할 필드
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //res/layout/activity_main.xml 문서를 전개해서 화면 구성하기
        setContentView(R.layout.activity_main);
    }

    public void add(View v){
        //카운트를 1 증가 시킨다.
        count++;

        if(count==10){
            //ImageActivity 로 이동하겠다는 의도(Intent) 객체 생성하고
            // this는 MainActivity 클래스를 나타낸다.
            Intent i=new Intent(this, ImageActivity.class);
            //startActivity() 메소드를 호출하면서 전달하기
            startActivity(i);
        }

        //카운트값을 TextView 에 출력하기 //TextView 의 참조값이 필요하다

        //id 가 textView 인 TextView 의 참조값 얻어오기
        TextView a=findViewById(R.id.textView);
        //count 값을 문자열로 바꿔서 TextView 에 출력한다.// 정수를 문자열로 바꿔서 전달을 한다.
        a.setText(Integer.toString(count));
    }

    public void minus(View v){
        count--;
        TextView a=findViewById(R.id.textView);
        a.setText(Integer.toString(count));
    }

    public void reset(View v){
        count=0;
        TextView a=findViewById(R.id.textView);
        a.setText(Integer.toString(count));
    }
}
