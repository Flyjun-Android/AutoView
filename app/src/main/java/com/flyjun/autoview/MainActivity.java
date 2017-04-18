package com.flyjun.autoview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.flyjun.view.AutoLinearLayout;
import com.flyjun.view.AutoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AutoView.init(this);

        setContentView(R.layout.activity_main);

        AutoLinearLayout linearLayout= (AutoLinearLayout) findViewById(R.id.layout);

        Button button=new Button(this);
        button.setText("button");

        AutoView.autoBuilder(button).setWidth(320).setHeight(120).setMarginTop(50).builder();

        linearLayout.addView(button);

        System.out.println("autoSize:"+AutoView.getAutoSize(this,120));

    }
}
