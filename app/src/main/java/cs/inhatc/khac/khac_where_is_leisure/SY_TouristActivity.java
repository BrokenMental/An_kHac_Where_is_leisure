package cs.inhatc.khac.khac_where_is_leisure;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/* Develop By Jeon Se Yeon */
public class SY_TouristActivity extends JU_TotalActivity {
    final Context context = this;
    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    CheckBox checkBox4;
    CheckBox checkBox5;
    CheckBox checkBox6;
    CheckBox checkBox7;
    CheckBox checkBox8;
    Button btnBack;

    /*앱이 실행됬을 때*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sy_tourist);
        actList.add(this);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        checkBox1 = (CheckBox) findViewById(R.id.chkBtn1);
        checkBox2 = (CheckBox) findViewById(R.id.chkBtn2);
        checkBox3 = (CheckBox) findViewById(R.id.chkBtn3);
        checkBox4 = (CheckBox) findViewById(R.id.chkBtn4);
        checkBox5 = (CheckBox) findViewById(R.id.chkBtn5);
        checkBox6 = (CheckBox) findViewById(R.id.chkBtn6);
        checkBox7 = (CheckBox) findViewById(R.id.chkBtn7);
        checkBox8 = (CheckBox) findViewById(R.id.chkBtn8);
    }

    /* 이미지 버튼을 클릭했을 때 -> 팝업*/
    public void Popup1(View v) {
        String tourName = "사라오름";

        Integer imgTour = R.drawable.sara;
        String tourExplain = "노루떼가 뛰어노는 모습이 한 폭의 그림 같은 곳";
        Integer imgOther1 = R.drawable.seoyeon;
        String txtOther = "서연의 집: \n" +
                "넓은 창 밖으로 바다가 보이는 카페. 건축학개론 촬영지로 더 유명한 카페. 납뜩이 머핀, 스토리텔링 떡 등 독특한 이름의 메뉴들이 인기 메뉴";
        Integer imgOther2 = R.drawable.suguk;
        String txtOther2 = "휴애리 여름 수국 축제: \n" +
                "먹거리 - 솜사탕, 흑돼지빵, 소시지 \n" +
                "상철체험프로그램 - 동물먹이주기체험(산토끼, 흑염소, 산양, 염소, 말 등), 흑돼지야놀자(흑돼지쇼), 승마체험, 야생화 자연 학습체험, 전통놀이체험(돌탑쌓기, 투호던지기, 굴렁쇠 체험 등)";
        if (checkBox1.isChecked()) {
            Popups(tourName, imgTour, tourExplain, imgOther1, txtOther, imgOther2, txtOther2);
        }
    }

    public void Popup2(View v) {
        String tourName = "넥슨 컴퓨터 박물관";

        Integer imgTour = R.drawable.nexon;
        String tourExplain = "디지털과 교육, 예술을 결합하여 새로운 문화를 창출하고 이를 바탕으로 지역사회와 교류하고 상생하는 사회교육기관";
        Integer imgOther1 = R.drawable.noodle;
        String txtOther = "자매국수: \n" +
                "육지와 차별화 된 제주도의 향토 음식인 고기국수가 인기 메뉴 \n" +
                "2013년 제주대학교 축제 때 한 코너를 맡게 되며 시작 된 인연으로 제주대학교에는 자매국수 장학금이 있음";
        Integer imgOther2 = R.drawable.seongeub;
        String txtOther2 = "제주성읍마을 전통민속재연축제 2018: \n" +
                "출베기(꼴베기)공연 및 체험, 달구질(달궈질)공연 및 체험, 조밭볼리기(조밭다지기)공연 및 체험, 검질메기(김메기)공연 및 체험" +
                "마당질(도리깨질)공연 및 체험, 남방애(절구)찧기 공연 및 체험, 고래골기(맷돌갈기)공연 및 체험\n";
        if (checkBox2.isChecked()) {
            Popups(tourName, imgTour, tourExplain, imgOther1, txtOther, imgOther2, txtOther2);
        }
    }

    public void Popup3(View v) {
        String tourName = "성산일출봉";

        Integer imgTour = R.drawable.seongsan;
        String tourExplain = "바다위에 우뚝 솟아난 수성화산·유네스코 세계자연유산";
        Integer imgOther1 = R.drawable.seoyeon;
        String txtOther = "서연의 집: \n" +
                "넓은 창 밖으로 바다가 보이는 카페. 건축학개론 촬영지로 더 유명한 카페. 납뜩이 머핀, 스토리텔링 떡 등 독특한 이름의 메뉴들이 인기 메뉴";
        Integer imgOther2 = R.drawable.suguk;
        String txtOther2 = "휴애리 여름 수국 축제: \n" +
                "먹거리 - 솜사탕, 흑돼지빵, 소시지 \n" +
                "상철체험프로그램 - 동물먹이주기체험(산토끼, 흑염소, 산양, 염소, 말 등), 흑돼지야놀자(흑돼지쇼), 승마체험, 야생화 자연 학습체험, 전통놀이체험(돌탑쌓기, 투호던지기, 굴렁쇠 체험 등)";
        if (checkBox3.isChecked()) {
            Popups(tourName, imgTour, tourExplain, imgOther1, txtOther, imgOther2, txtOther2);
        }
    }

    public void Popup4(View v) {
        String tourName = "정방폭포";

        Integer imgTour = R.drawable.jeongbang;
        String tourExplain = "높은곳에서 바다로 떨어지는 물줄기의 시원함 · 명승 제43호 · 올레6코스";
        Integer imgOther1 = R.drawable.seoyeon;
        String txtOther = "서연의 집: \n" +
                "넓은 창 밖으로 바다가 보이는 카페. 건축학개론 촬영지로 더 유명한 카페. 납뜩이 머핀, 스토리텔링 떡 등 독특한 이름의 메뉴들이 인기 메뉴";
        Integer imgOther2 = R.drawable.suguk;
        String txtOther2 = "휴애리 여름 수국 축제: \n" +
                "먹거리 - 솜사탕, 흑돼지빵, 소시지 \n" +
                "상철체험프로그램 - 동물먹이주기체험(산토끼, 흑염소, 산양, 염소, 말 등), 흑돼지야놀자(흑돼지쇼), 승마체험, 야생화 자연 학습체험, 전통놀이체험(돌탑쌓기, 투호던지기, 굴렁쇠 체험 등)";
        if (checkBox4.isChecked()) {
            Popups(tourName, imgTour, tourExplain, imgOther1, txtOther, imgOther2, txtOther2);
        }
    }

    public void Popup5(View v) {
        String tourName = "러브랜드";

        Integer imgTour = R.drawable.love;
        String tourExplain = "19금 박물관 야경이 좋음";
        Integer imgOther1 = R.drawable.seoyeon;
        String txtOther = "서연의 집: \n" +
                "넓은 창 밖으로 바다가 보이는 카페. 건축학개론 촬영지로 더 유명한 카페. 납뜩이 머핀, 스토리텔링 떡 등 독특한 이름의 메뉴들이 인기 메뉴";
        Integer imgOther2 = R.drawable.suguk;
        String txtOther2 = "휴애리 여름 수국 축제: \n" +
                "먹거리 - 솜사탕, 흑돼지빵, 소시지 \n" +
                "상철체험프로그램 - 동물먹이주기체험(산토끼, 흑염소, 산양, 염소, 말 등), 흑돼지야놀자(흑돼지쇼), 승마체험, 야생화 자연 학습체험, 전통놀이체험(돌탑쌓기, 투호던지기, 굴렁쇠 체험 등)";
        if (checkBox5.isChecked()) {
            Popups(tourName, imgTour, tourExplain, imgOther1, txtOther, imgOther2, txtOther2);
        }
    }

    public void Popup6(View v) {
        String tourName = "최남단 체험 감귤농장";

        Integer imgTour = R.drawable.choenamdan;
        String tourExplain = "살아있는 제주농촌을 체험할 수 있는 농장";
        Integer imgOther1 = R.drawable.sushi;
        String txtOther = "초밥군 커피씨: \n" +
                "떠오르는 제주도 여행시 꼭 먹어야 할 음식인 용초밥이 주 메뉴이자 인기 메뉴. \n" +
                "용초밥은 일반 작은 스시와 다르게 물고기 한마리가 통째로 올라가 있음 거품 위에 도미를 그려주는 생선라떼 또한 인기 메뉴";
        Integer imgOther2 = R.drawable.heobeu;
        String txtOther2 = "제주 허브동산 “별빛놀이: \n" +
                "허브와 개구쟁이들, 3D 멀티미디어쇼, 황금족욕 체험, 비누만들기 체험, 그 외 각종 체험";
        if (checkBox6.isChecked()) {
            Popups(tourName, imgTour, tourExplain, imgOther1, txtOther, imgOther2, txtOther2);
        }
    }


    public void Popup7(View v) {
        String tourName = "휴애리 생활자연 공원";

        Integer imgTour = R.drawable.hyuaeli;
        String tourExplain = "자연속 동·식물들과 교감이 있는 체험형 자연생활공원";
        Integer imgOther1 = R.drawable.seoyeon;
        String txtOther = "서연의 집: \n" +
                "넓은 창 밖으로 바다가 보이는 카페. 건축학개론 촬영지로 더 유명한 카페. 납뜩이 머핀, 스토리텔링 떡 등 독특한 이름의 메뉴들이 인기 메뉴";
        Integer imgOther2 = R.drawable.suguk;
        String txtOther2 = "휴애리 여름 수국 축제: \n" +
                "먹거리 - 솜사탕, 흑돼지빵, 소시지 \n" +
                "상철체험프로그램 - 동물먹이주기체험(산토끼, 흑염소, 산양, 염소, 말 등), 흑돼지야놀자(흑돼지쇼), 승마체험, 야생화 자연 학습체험, 전통놀이체험(돌탑쌓기, 투호던지기, 굴렁쇠 체험 등)";
        if (checkBox7.isChecked()) {
            Popups(tourName, imgTour, tourExplain, imgOther1, txtOther, imgOther2, txtOther2);
        }
    }

    public void Popup8(View v) {
        String tourName = "소인국 테마파크";

        Integer imgTour = R.drawable.soingug;
        String tourExplain = "세계 각국의 유명건축물을 한번에 볼 수 있는 테마공원";
        Integer imgOther1 = R.drawable.seoyeon;
        String txtOther = "서연의 집: \n" +
                "넓은 창 밖으로 바다가 보이는 카페. 건축학개론 촬영지로 더 유명한 카페. 납뜩이 머핀, 스토리텔링 떡 등 독특한 이름의 메뉴들이 인기 메뉴";
        Integer imgOther2 = R.drawable.suguk;
        String txtOther2 = "휴애리 여름 수국 축제: \n" +
                "먹거리 - 솜사탕, 흑돼지빵, 소시지 \n" +
                "상철체험프로그램 - 동물먹이주기체험(산토끼, 흑염소, 산양, 염소, 말 등), 흑돼지야놀자(흑돼지쇼), 승마체험, 야생화 자연 학습체험, 전통놀이체험(돌탑쌓기, 투호던지기, 굴렁쇠 체험 등)";
        if (checkBox8.isChecked()) {
            Popups(tourName, imgTour, tourExplain, imgOther1, txtOther, imgOther2, txtOther2);
        }
    }



    public void Popups(String tourName, Integer imgTour, String tourExplain, Integer imgOther1, String txtOther, Integer imgOther2, String txtOther2) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

        LayoutInflater inflater
                = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.activity_sy_popup, null);

        /*관광지명, 사진, 설명*/
        TextView tourNames = (TextView) layout.findViewById(R.id.txtTourName);
        tourNames.setText(tourName);
        ImageView imgTours = (ImageView) layout.findViewById(R.id.imgTour);
        imgTours.setImageResource(imgTour);
        TextView tourExplains = (TextView) layout.findViewById(R.id.txtExplain);
        tourExplains.setText(tourExplain);

        /*먹거리사진, 설명*/
        ImageView imgOther1s = (ImageView) layout.findViewById(R.id.imgOther1);
        imgOther1s.setImageResource(imgOther1);
        TextView txtOther1s = (TextView) layout.findViewById(R.id.txtOther1);
        txtOther1s.setText(txtOther);

        /*축제사진, 설명*/
        ImageView imgOther2s = (ImageView) layout.findViewById(R.id.imgOther2);
        imgOther2s.setImageResource(imgOther2);
        TextView txtOther2s = (TextView) layout.findViewById(R.id.txtOther2);
        txtOther2s.setText(txtOther2);

        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialog, int id) {

                                // 프로그램 종료

                            }
                        });
        alertDialogBuilder.setView(layout);
        // 다이얼로그 생성
        AlertDialog alertDialog = alertDialogBuilder.create();
        // 다이얼로그 보여주기
        alertDialog.show();
    }

   /*[다음]버튼을 눌렀을 때*/
    public void btnOk(View v) {
        int count = 0;

        ArrayList<String> ReceiveArr = new ArrayList<>();


        if (checkBox1.isChecked()) {
            count++;
            /*Toast toast1 = Toast.makeText(getApplicationContext(), "선택한 관광지: " + checkBox1.getText(), Toast.LENGTH_SHORT);
            toast1.show();*/
            ReceiveArr.add(checkBox1.getText().toString());
        } else if (checkBox2.isChecked()) {
            count++;
            /*Toast toast2 = Toast.makeText(getApplicationContext(), "선택한 관광지: " + checkBox2.getText(), Toast.LENGTH_SHORT);
            toast2.show();*/
            ReceiveArr.add(checkBox2.getText().toString());
        } else if (checkBox3.isChecked()) {
            count++;
            /*Toast toast3 = Toast.makeText(getApplicationContext(), "선택한 관광지: " + checkBox3.getText(), Toast.LENGTH_SHORT);
            toast3.show();*/
            ReceiveArr.add(checkBox3.getText().toString());
        } else if (checkBox4.isChecked()) {
            count++;
            /*Toast toast4 = Toast.makeText(getApplicationContext(), "선택한 관광지: " + checkBox4.getText(), Toast.LENGTH_SHORT);
            toast4.show();*/
            ReceiveArr.add(checkBox4.getText().toString());
        } else if (checkBox5.isChecked()) {
            count++;
            /*Toast toast5 = Toast.makeText(getApplicationContext(), "선택한 관광지: " + checkBox5.getText(), Toast.LENGTH_SHORT);
            toast5.show()*/;
            ReceiveArr.add(checkBox5.getText().toString());
        } else if (checkBox6.isChecked()) {
            count++;
            /*Toast toast6 = Toast.makeText(getApplicationContext(), "선택한 관광지: " + checkBox6.getText(), Toast.LENGTH_SHORT);
            toast6.show();*/
            ReceiveArr.add(checkBox6.getText().toString());
        } else if (checkBox7.isChecked()) {
            count++;
            /*Toast toast7 = Toast.makeText(getApplicationContext(), "선택한 관광지: " + checkBox7.getText(), Toast.LENGTH_SHORT);
            toast7.show();*/
            ReceiveArr.add(checkBox7.getText().toString());
        } else if (checkBox8.isChecked()) {
            count++;
            /*Toast toast8 = Toast.makeText(getApplicationContext(), "선택한 관광지: " + checkBox8.getText(), Toast.LENGTH_SHORT);
            toast8.show();*/
            ReceiveArr.add(checkBox8.getText().toString());

        }


        if (count == 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "관광지를 1개의 항목 이상 선택해주세요.", Toast.LENGTH_SHORT);
            toast.show();
        }

        else {
            Intent intent = new Intent(this, JU_MapActivity.class);
            intent.putStringArrayListExtra("ArrayList", ReceiveArr);

            startActivity(intent);
        }
    }
}









