package com.example.step03listview3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemLongClickListener, DialogInterface.OnClickListener {
    //화면에 전개된 view 의 참조값을 담을 필드 선언
    ListView listView;
    EditText editText;
    ArrayAdapter<String> adapter;
    List<String> msgs;
    //선택한 인덱스를 저장할 필드
    int selectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //view 의 참조값을 얻어내서 필드에 저장하기
        listView=findViewById(R.id.listView);
        editText=findViewById(R.id.editText);
        //아답타에 연결할 모델 객체 생성
        msgs=new ArrayList<>();
        //sample 데이터
        msgs.add("하나");
        msgs.add("두울");
        msgs.add("세엣");
        //ListView 에 연결할 아답타 객체 생성
        adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                msgs);
        //listView 에 아답타 연결하기
        listView.setAdapter(adapter);
        //listView 에 아이템 롱클릭 리스너 등록하기
        listView.setOnItemLongClickListener(this);

    }
    //추가 버튼을 눌렀을때 호출되는 메소드
    public void btnClicked(View v){
        //1. EditText 에 입력한 문자열을 읽어온다.
        String msg=editText.getText().toString();
        //2. Adapter 에 연결된 모델에 추가한다.
        msgs.add(msg);
        //3. 모델의 데이터가 수정되었다고 Adapter 에 알린다.(ListView 업데이트)
        adapter.notifyDataSetChanged();
        //4. 입력창 초기화
        editText.setText("");
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        //롱클릭한 셀의 인덱스를 필드에 저장
        selectedIndex=position;

        new AlertDialog.Builder(this)
                .setMessage(msgs.get(position)+"을 삭제 하시겠습니까?")
                .setPositiveButton("네", this)
                .setNegativeButton("아니오", this)
                .create()
                .show();
        return false;
    }

    //AlertDialog 의 버튼을 누르면 호출되는 메소드
    @Override
    public void onClick(DialogInterface dialog, int which) {//뭘눌렀는지는 which 로 숫자값으로 온다.
        switch(which){
            case DialogInterface.BUTTON_POSITIVE://긍정 버튼을 눌렀을때
                //모델에서 선택된 인덱스 삭제하고
                msgs.remove(selectedIndex);
                //모델의 데이터가 바뀌었다고 아답타에 알린다.
                adapter.notifyDataSetChanged();
                break;
            case DialogInterface.BUTTON_NEGATIVE://부정 버튼을 눌렀을때

                break;
        }
    }
}
