package cn.hongye.animate;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn;
    private TextView tv;
    private Button btnToBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initData() {
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(tv, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(tv, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(tv, "alpha", 1f, 0f, 1f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(moveIn).with(rotate).after(fadeInOut);
        animatorSet.setDuration(5000);
        animatorSet.start();
    }

    private void initView() {
        btn = (Button) findViewById(R.id.btn);
        btnToBlue = (Button) findViewById(R.id.btn_to_blueCircle);
        tv = (TextView) findViewById(R.id.tv);
        btn.setOnClickListener(this);
        btnToBlue.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                initData();
                break;
            case R.id.btn_to_blueCircle:
                Intent intent=new Intent(this,BLueCircleActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
