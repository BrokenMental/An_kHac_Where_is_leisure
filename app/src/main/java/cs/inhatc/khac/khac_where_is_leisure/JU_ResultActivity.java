package cs.inhatc.khac.khac_where_is_leisure;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.skt.Tmap.TMapData;
import com.skt.Tmap.TMapPoint;
import com.skt.Tmap.TMapPolyLine;
import com.skt.Tmap.TMapView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/* Develop By Jinuk-Ha */
public class JU_ResultActivity extends JU_TotalActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    private TMapPoint MapStart, MapEnd;
    private TMapPoint tMapPoint1 = new TMapPoint(37.4588197, 126.63411719999999); // 인하대병원
    private TMapPoint tMapPoint2 = new TMapPoint(37.4500221, 126.65348799999992); // 인하대
    private TMapPoint tMapPoint3 = new TMapPoint(37.4480158, 126.65750409999998); // 인하공전
    private TMapPoint tMapPoint4 = new TMapPoint(37.441546, 126.70149600000002); // 인천시외버스터미널
    private TMapPoint tMapPoint5 = new TMapPoint(37.4565562, 126.68458069999997); // 주안역
    private TMapPoint tMapPoint6 = new TMapPoint(37.5116833, 127.05910799999992); // 코엑스
    private TMapPoint tMapPoint7 = new TMapPoint(37.5384272, 126.96544419999998); // 용산역
    private TMapPoint tMapPoint8 = new TMapPoint(37.5318046, 126.91415469999993); // 국회의사당
    private TMapPoint tMapPoint9 = new TMapPoint(37.557527, 126.92446689999997); // 홍대 입구역
    private TMapPoint tMapPoint0 = new TMapPoint(37.55998, 126.98582959999999); // 명동

    private Button btnFinish, btnPreMap;
    private LinearLayout ResultTmap;
    private TMapView tMapView ;
    private TMapData tMapData;
    private ArrayList passList;
    private Spinner spday;
    private TextView txtChoStay, txtChoLoca, txtChoDay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ju_resultview);
        actList.add(this);

        btnPreMap = findViewById(R.id.btn_premap);
        btnPreMap.setOnClickListener(this);

        btnFinish = findViewById(R.id.btn_home);
        btnFinish.setOnClickListener(this);

        txtChoStay = findViewById(R.id.txtView_chostay);
        txtChoLoca = findViewById(R.id.txtView_choloca);
        txtChoDay = findViewById(R.id.txtView_choday);

        // TMap에서 사용되는 데이터 관련 변수
        tMapData = new TMapData();

        // TMap API 입력
        tMapView = new TMapView(this);
        tMapView.setSKTMapApiKey(getString(R.string.tmap_api_key));

        // 지도 생성
        ResultTmap = findViewById(R.id.ResultTmap);
        ResultTmap.addView(tMapView);

        tMapView.setZoomLevel(12);

        // 스피너
        spday = findViewById(R.id.sp_daycho);
        spday.setOnItemSelectedListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_premap:
                finish();
                break;
            case R.id.btn_home:
                FinishAction();
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
                tMapView.setCenterPoint(126.63411719999999,37.4588197);

                // 시작 종료 경로 설정
                MapStart = tMapPoint1;
                MapEnd = tMapPoint5;

                // 경유지 추가를 위한 ArrayList
                passList = new ArrayList<>();
                passList.add(tMapPoint2);
                passList.add(tMapPoint3);
                passList.add(tMapPoint4);

                // 경로 검색 이벤트
                findPathDataWithType();
                txtChoStay.setText(spday.getSelectedItem().toString()+"숙박 : ");
                break;
            case 1 :
                // 시작위치 변경
                tMapView.setCenterPoint(127.05910799999992, 37.5116833, true);
                tMapView.setZoomLevel(11);

                // 시작 종료 경로 설정
                MapStart = tMapPoint6;
                MapEnd = tMapPoint0;

                // 경유지 추가를 위한 ArrayList
                passList = new ArrayList<>();
                passList.add(tMapPoint7);
                passList.add(tMapPoint8);
                passList.add(tMapPoint9);

                // 경로 검색
                findPathDataWithType();
                txtChoStay.setText(spday.getSelectedItem().toString()+"숙박 : ");
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
        tMapData.findPathDataWithType(TMapData.TMapPathType.CAR_PATH, MapStart, MapEnd, passList, 0,
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
        tMapData.findPathDataAllType(TMapData.TMapPathType.CAR_PATH, tMapPoint1, tMapPoint5, new TMapData.FindPathDataAllListenerCallback() {
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
