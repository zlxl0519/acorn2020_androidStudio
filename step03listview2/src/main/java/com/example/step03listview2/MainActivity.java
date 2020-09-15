package com.example.step03listview2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //AppCompatActivity 의 상속 관계가 있어서 이 메소드를 사용할수 있다.
        //res/layout/activity_main.xml 문서를 전개해서 화면 구성하기
        setContentView(R.layout.activity_main);
        //ListView 에 출력할 데이터(모델)
        List<String> names=new ArrayList<>();
        for(int i=0; i<100; i++){
            names.add("김구라"+i);
        }

        //ListView 의 참조값 얻어오기
        ListView listView=findViewById(R.id.listView);
        //ListView 에 연결할 아답타 객체
        ArrayAdapter<String> adapter=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                names);
        //아답타를 listView 에 연결하기
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //position 은 클릭한 셀의 인덱스 값이다.
        //Toast.makeText(this,"클릭한 셀 인덱스:"+position, Toast.LENGTH_SHORT).show();

        //AlertDialog.Builder builder=new AlertDialog.Builder(this);
        //builder.setMessage("선택한 셀 인덱스:"+position);
        //builder.setNeutralButton("확인", null);

        //AlertDialog dialog=builder.create();
        //dialog.show();

        //전체적인건 AlertDialog type
        //안에 setMessage, setNeutraButton 은 AlertDialog.Builder type
        //create, show 는 alertDialog type
        new AlertDialog.Builder(this)
                .setMessage("선택한 셀 인덱스:"+position)
                .setNeutralButton("확인", null)
                .create()
                .show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        new AlertDialog.Builder(this)
                .setMessage("오랫동안 클릭했네")
                .setNeutralButton("확인", null)
                .create()
                .show();
        return false;
    }
}
