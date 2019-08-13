package com.wdl.myapplication.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wdl.myapplication.R;
import com.wdl.myapplication.myview.FlowLayout;

import java.util.ArrayList;
import java.util.List;

public class ShouSuoActivity extends AppCompatActivity {

    private FlowLayout flowLayout,flowLayoute;
    TextView shou_suo_go ;
    EditText shou_suo_edtext ;

    private List<String> list=new ArrayList<>();
    private List<String> liste=new ArrayList<>();
    private LinearLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CQS();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shou_suo);
        flowLayout = findViewById(R.id.flow);
        flowLayoute = findViewById(R.id.flowe);
        shou_suo_go = findViewById(R.id.shou_suo_go);
        shou_suo_edtext = findViewById(R.id.shou_suo_edtext);
        shou_suo_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shou_suo_edtext != null){
                    String s = shou_suo_edtext.getText().toString();
                    liste.add(s);
                    shou_suo_edtext.setText("");
                }

                if (flowLayoute != null) {
                    flowLayoute.removeAllViews();
                }
                for (int i = 0; i < liste.size(); i++) {
                    TextView tv = new TextView(ShouSuoActivity.this);
                    tv.setPadding(40, 30, 40, 30);
                    tv.setText(liste.get(i));
                    tv.setMaxEms(10);
                    tv.setSingleLine();
                    tv.setBackgroundResource(R.drawable.selector_playsearch);
                    tv.setLayoutParams(layoutParams);
                    flowLayoute.addView(tv, layoutParams);
                }

            }
        });

        for (int i = 0; i <3; i++) {
            list.add("Android");
            list.add("Java");
            list.add("IOS");
            list.add("python");
        }


//往容器内添加TextView数据
        layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(30, 20, 30, 5);
        if (flowLayout != null) {
            flowLayout.removeAllViews();
        }
        for (int i = 0; i < list.size(); i++) {
            TextView tv = new TextView(this);
            tv.setPadding(40, 30, 40, 30);
            tv.setText(list.get(i));
            tv.setMaxEms(10);
            tv.setSingleLine();
            tv.setBackgroundResource(R.drawable.selector_playsearch);
            tv.setLayoutParams(layoutParams);
            flowLayout.addView(tv, layoutParams);
        }


    }
    private void CQS() {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    //为避免底部导航栏覆盖注释掉这一行
//                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    |View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
}
