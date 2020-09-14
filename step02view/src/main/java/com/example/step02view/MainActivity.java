package com.example.step02view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText inputText;
    TextView result;
    //MainActivity 가 활성화 될때 호출되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // activity_main.xml 문서를 전개 해서 화면 구성하기
        setContentView(R.layout.activity_main);
        //필요한 view 의 참조값을 얻어와서 필드에 저장하기
        inputText=findViewById(R.id.inputText);
        result=findViewById(R.id.result);
    }

    public void btnClicked(View v){

        //View 는 눌러진 버튼의 참조값이 부모 type 으로 전달된다.
        switch(v.getId()){//눌러진 버튼의 아이디값을 읽어온다 (정수값)
            case R.id.sendBtn://전송 버튼을 눌렀을때
                String msg=inputText.getText().toString();
                result.setText(msg);
                inputText.setText("");
                break;
            case R.id.clearBtn://Clear 버튼을 눌렀을때
                inputText.setText("");
                result.setText("");
                break;
        }

    }
}
