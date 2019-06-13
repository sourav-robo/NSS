package www.inturnship.com.nss;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DiyaActivity extends AppCompatActivity {
    TextView header;
    ImageView back;
    LinearLayout lin_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diya);
        if(Build.VERSION.SDK_INT>=21){
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.header));
        }
        lin_nav=findViewById(R.id.lin_nav);
        header=findViewById(R.id.header);
        header.setText("Diya Decoration");
        back=findViewById(R.id.img_nav);
        back.setImageResource(R.drawable.img_arrowleft);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DiyaActivity.this,AashaActivity.class);
                startActivity(intent);
                finish();

            }
        });
        lin_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DiyaActivity.this,AashaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(DiyaActivity.this,AashaActivity.class);
        startActivity(intent);
        finish();
    }
}
