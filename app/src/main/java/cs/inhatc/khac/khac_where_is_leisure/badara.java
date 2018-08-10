package cs.inhatc.khac.khac_where_is_leisure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class badara extends AppCompatActivity {

    private Intent intent;
    private TextView text;
    private String content;
    private boolean check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_badara);

        text=(TextView)findViewById(R.id.textView);
        intent=getIntent();
        content=intent.getStringExtra("throw");
        check=intent.getBooleanExtra("check",false);
        text.setText(content+"\n"+check);

    }
}
