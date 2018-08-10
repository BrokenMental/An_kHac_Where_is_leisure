package cs.inhatc.khac.khac_where_is_leisure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/*Dvelop By KimAYoung*/
public class MainPage extends AppCompatActivity implements View.OnClickListener{

    private Button btnTrip, btnMypage, btnAfterTrip;
    private PermissionCall PC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);

         btnTrip=(Button)findViewById(R.id.btnTrip);
         btnMypage=(Button)findViewById(R.id.btnMypage);
         btnAfterTrip=(Button)findViewById(R.id.btnAfterTrip);

        btnTrip.setOnClickListener(this);
        btnMypage.setOnClickListener(this);
        btnAfterTrip.setOnClickListener(this);

        //PC = new PermissionCall(this);
    }
    public void onClick(View v){
        if(v==btnTrip){   //연결이 안되어있어서 오류납니다.. 합쳤을 때 주석 풀어주세요..
            Intent intent0 = new Intent(MainPage.this, Choiceloc.class );
            startActivity(intent0);
        }
        else if(v==btnMypage){
            Intent intent1 = new Intent(MainPage.this, Mypage.class );
            startActivity(intent1);
        }

        else if(v==btnAfterTrip){
            Intent intent2 = new Intent(MainPage.this, AfterTrip.class );
            startActivity(intent2);
        }
    }
}
