package cs.inhatc.khac.khac_where_is_leisure;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/* Develop By Jinuk-Ha */
public class JU_MapActivity extends JU_TotalActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private TMapPoint MapStart, MapEnd;
    private TMapPoint tMapPoint01 = new TMapPoint(33.51041350000001, 126.49135339999998); // 제주공항
    private TMapPoint tMapPoint02 = new TMapPoint(33.2815873, 126.27175950000003); // 제주곶자왈 도립공원
    private TMapPoint tMapPoint03 = new TMapPoint(33.2052113, 126.27711550000004); // 알뜨르 비행장
    private TMapPoint tMapPoint04 = new TMapPoint(33.2005211, 126.27703580000002); // 섯알오름
    private TMapPoint tMapPoint05 = new TMapPoint(33.2383516, 126.22960379999995); // 숙소1

    private TMapPoint tMapPoint06 = new TMapPoint(33.4363892, 126.92235900000003); // 신양섭지해수욕장
    private TMapPoint tMapPoint07 = new TMapPoint(33.4235416, 126.92932659999997); // 섭지코지
    private TMapPoint tMapPoint08 = new TMapPoint(33.4305782, 126.92776879999997); // 제주아쿠아플라넷
    private TMapPoint tMapPoint09 = new TMapPoint(33.462389, 126.93671560000007); // 성산일출봉
    private TMapPoint tMapPoint10 = new TMapPoint(33.4386194, 126.91651660000002); // 숙소2

    private TMapPoint tMapPoint11 = new TMapPoint(33.451638, 126.49000000000001); // 러브랜드
    private TMapPoint tMapPoint12 = new TMapPoint(33.4718397, 126.48494589999996); // 넥슨컴퓨터박물관

    private LinearLayout linearLayoutTmap;
    private TMapView tMapView ;
    private TMapData tMapData;
    private ArrayList passList;
    private Button btnPre, btnNext;
    private Spinner spday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ju_map);
        actList.add(this);

        // 이전, 다음버튼
        btnPre = findViewById(R.id.map_pre);
        btnPre.setOnClickListener(this);
        btnNext = findViewById(R.id.map_next);
        btnNext.setOnClickListener(this);

        // TMap에서 사용되는 데이터 관련 변수
        tMapData = new TMapData();

        // TMap API 입력
        tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey(getString(R.string.tmap_api_key));

        // 지도 생성
        linearLayoutTmap = findViewById(R.id.linearLayoutTmap);
        linearLayoutTmap.addView(tMapView);

        tMapView.setZoomLevel(10);

        // 스피너
        spday = findViewById(R.id.sp_day);
        spday.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.map_next :
                Intent mn = new Intent(JU_MapActivity.this, JU_ResultActivity.class);
                mn.putExtra("throw","abc");
                startActivity(mn);
                break;
            case R.id.map_pre :
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // 표시되었던 폴리라인과 마커 삭제
        tMapView.removeAllTMapPolyLine();
        tMapView.removeAllMarkerItem();

        // Permission 확인
        //PC = new JU_PermissionCall(this);
        switch (position){
            case 0 :
                // 시작위치 설정
                tMapView.setCenterPoint(126.49135339999998,33.51041350000001, true);

                // 시작 종료 경로 설정
                MapStart = tMapPoint01;
                MapEnd = tMapPoint05;

                // 경유지 추가를 위한 ArrayList
                passList = new ArrayList<>();
                passList.add(tMapPoint02);
                passList.add(tMapPoint03);
                passList.add(tMapPoint04);

                // 경로 검색 이벤트
                findPathDataWithType();
                break;
            case 1 :
                // 시작위치 변경
                tMapView.setCenterPoint(126.22960379999995, 33.2383516, true);

                // 시작 종료 경로 설정
                MapStart = tMapPoint05;
                MapEnd = tMapPoint10;

                // 경유지 추가를 위한 ArrayList
                passList = new ArrayList<>();
                passList.add(tMapPoint06);
                passList.add(tMapPoint07);
                passList.add(tMapPoint08);
                passList.add(tMapPoint09);

                // 경로 검색
                findPathDataWithType();
                break;
            case 2 :
                // 시작위치 변경
                tMapView.setCenterPoint(126.91651660000002, 33.4386194, true);

                // 시작 종료 경로 설정
                MapStart = tMapPoint10;
                MapEnd = tMapPoint01;

                // 경유지 추가를 위한 ArrayList
                passList = new ArrayList<>();
                passList.add(tMapPoint11);
                passList.add(tMapPoint12);

                // 경로 검색
                findPathDataWithType();
                break;
            default :
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    // 경로찾기 메서드
    public void findPathDataWithType() {
        tMapData.findPathDataWithType(TMapData.TMapPathType.CAR_PATH, MapStart, MapEnd, passList, 2,
                new TMapData.FindPathDataListenerCallback() {
                    @Override
                    public void onFindPathData(TMapPolyLine polyLine) {
                        polyLine.setLineColor(Color.GREEN);
                        polyLine.setLineWidth(10);
                        tMapView.addTMapPath(polyLine);
                    }
                });
        findPathAllType();
    }

    // Type별 경로 거리
    public void findPathAllType() {
        tMapData.findPathDataAllType(TMapData.TMapPathType.CAR_PATH, MapStart, MapEnd, new TMapData.FindPathDataAllListenerCallback() {
            @Override
            public void onFindPathDataAll(Document document) {
                Element root = document.getDocumentElement();
                NodeList nodeListPlacemark = root.getElementsByTagName("Document");
                for (int i = 0; i < nodeListPlacemark.getLength(); i++) {
                    NodeList nodeListPlacemarkItem = nodeListPlacemark.item(i).getChildNodes();
                    for (int j = 0; j < nodeListPlacemarkItem.getLength(); j++) {
                        if (nodeListPlacemarkItem.item(j).getNodeName().equals("tmap:totalDistance")) {
                            Log.d("Distance", nodeListPlacemarkItem.item(j).getTextContent().trim()+"M"); // 총 거리 표시(M)
                        }else if (nodeListPlacemarkItem.item(j).getNodeName().equals("tmap:totalTime")) {
                            int TM = Integer.parseInt(nodeListPlacemarkItem.item(j).getTextContent().trim())/60;
                            int TS = Integer.parseInt(nodeListPlacemarkItem.item(j).getTextContent().trim())%60;
                            Log.d("Time", TM+" min"+TS+" sec"); // 총 시간 표시(초)
                        }else if (nodeListPlacemarkItem.item(j).getNodeName().equals("tmap:totalFare")) {
                            Log.d("Money", nodeListPlacemarkItem.item(j).getTextContent().trim()+" Won"); // 총 요금 표시
                        }
                    }
                }
            }
        });
    }
}
