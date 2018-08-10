package cs.inhatc.khac.khac_where_is_leisure;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

/* Develop By Jinuk-Ha */
public class MainActivity extends AppCompatActivity {

    TMapPoint tMapPointStart = new TMapPoint(37.570841, 126.985302); // SKT타워(출발지)
    TMapPoint tMapPointEnd = new TMapPoint(37.551135, 126.988205); // N서울타워(목적지)

    private TMapView tMapView ;
    private TMapData tMapData;
    private PermissionCall PC;
    private boolean m_bTrackingMode;

    //뒤로가기 버튼 Delay
    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayoutTmap = findViewById(R.id.linearLayoutTmap);

        // TMap 지도 생성 관련 변수
        tMapView = new TMapView(this);
        // TMap에서 사용되는 데이터 관련 변수
        tMapData = new TMapData();

        // 취소버튼 관련 변수
        m_bTrackingMode = true;

        // Permission 확인
        //PC = new PermissionCall(this);

        // 지도 생성
        tMapView.setSKTMapApiKey(getString(R.string.tmap_api_key));
        linearLayoutTmap.addView(tMapView);

        // 경로 검색 이벤트
        findPath();
    }

    // 이전버튼 이벤트
    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime) {
            super.onBackPressed();
        } else {
            backPressedTime = tempTime;
            Toast.makeText(this, "이전 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }

    // 경로찾기 메서드
    public void findPath() {
        try {
            tMapData.findPathData(tMapPointStart, tMapPointEnd, new TMapData.FindPathDataListenerCallback() {
                @Override
                public void onFindPathData(TMapPolyLine tMapPolyLine) {
                    tMapPolyLine.setLineColor(Color.BLUE);
                    tMapPolyLine.setLineWidth(2);
                    tMapView.addTMapPolyLine("Line", tMapPolyLine);
                }
            });

        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
