package cs.inhatc.khac.khac_where_is_leisure;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/* Develop By Jinuk-Ha */
public class JU_TotalActivity extends AppCompatActivity {
    public static ArrayList<Activity> actList = new ArrayList<Activity>();

    public void FinishAction(){
        for(int i = 0; i < actList.size(); i++)
            actList.get(i).finish();
    }

}
