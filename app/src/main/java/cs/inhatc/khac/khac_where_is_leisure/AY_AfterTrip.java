package cs.inhatc.khac.khac_where_is_leisure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/*Dvelop By KimAYoung*/
public class AY_AfterTrip extends AppCompatActivity implements View.OnClickListener{

    ListView listview = null ;

    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ay_aftertrip);

        btnBack=(Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        AY_ListViewAdapter adapter;

        // Adapter 생성
        adapter = new AY_ListViewAdapter();

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.beachload),
                "경상도 / 울릉군 / 2박3일", "죽도 해안 산책로 \r\n경치가 예뻤던 코스였어요\r\n");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.ecoland),
                "제주도 / 조천읍 / 3박4일", "에코랜드 \r\n제주도 여행 정말 재밌었어요~");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.hanrasumok),
                "인천 / 남동구 / 1박 2일", "인천 수목원 \r\n데이트 장소로도 딱이에요");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.loveland),
                "제주도 / 제주시 / 2박 3일", "러브랜드 \r\n알찼던 제주도 여행!!");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.oramemil),
                "강원도 / 춘천시 / 3박 4일", "메밀꽃밭 \r\n친구들끼리 신나게 다녀왔습니다");

        adapter.addItem(ContextCompat.getDrawable(this, R.drawable.swiss),
                "제주도 / 조천읍 / 4박 5일", "스위스 마을 \r\n~느긋한 힐링 여행 추천~");


        EditText editTextFilter = (EditText)findViewById(R.id.editTextFilter) ;
        editTextFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable edit) {
                String filterText = edit.toString() ;
                /*
                if (filterText.length() > 0) {
                    listview.setFilterText(filterText) ;
                }
                else {
                    listview.clearTextFilter() ;
                }
                */
                ((AY_ListViewAdapter)listview.getAdapter()).getFilter().filter(filterText) ;

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        }) ;

    }
    public void onClick(View v) {
        if (v == btnBack) {
            Intent intent = new Intent(AY_AfterTrip.this, AY_MainPage.class);
            startActivity(intent);
        }
    }
}


