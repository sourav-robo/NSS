package www.inturnship.com.nss;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class AashaActivity extends AppCompatActivity {

    TextView header,txt_regn;
    ImageView img_nav,art_mela,diya_deco,rang_manch,quizotika,school_hope,war_thought;
    LinearLayout lin_nav;
    DrawerLayout drawer_layout;
    ListView menu_list;
    ArrayList<ListModel> arrayList;
    CustomAdaptr side_menu;
    NavigationView nav_view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aasha);

        art_mela=findViewById(R.id.art_mela);
        lin_nav=findViewById(R.id.lin_nav);
        lin_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                }
                else
                    drawer_layout.openDrawer(GravityCompat.START);

            }
        });

        art_mela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AashaActivity.this,ArtMelaActivity.class);
                startActivity(intent);
                finish();

            }
        });
        diya_deco=findViewById(R.id.diya_deco);

        diya_deco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AashaActivity.this,DiyaActivity.class);
                startActivity(intent);
                finish();

            }
        });
        rang_manch=findViewById(R.id.rang_manch);

        rang_manch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AashaActivity.this,RangManchActivity.class);
                startActivity(intent);
                finish();

            }
        });
        quizotika=findViewById(R.id.quizotika);

        quizotika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AashaActivity.this,QuizotikaActivity.class);
                startActivity(intent);
                finish();

            }
        });
        school_hope=findViewById(R.id.school_hope);

        school_hope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AashaActivity.this,SchoolHopeActivity.class);
                startActivity(intent);
                finish();

            }
        });
        war_thought=findViewById(R.id.war_thought);

        war_thought.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AashaActivity.this,WarActivity.class);
                startActivity(intent);
                finish();

            }
        });

        if(Build.VERSION.SDK_INT>=21){
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.header));
        }
        header=findViewById(R.id.header);
        header.setText("Aasha");
        img_nav=findViewById(R.id.img_nav);
        txt_regn=findViewById(R.id.txt_regn);

        txt_regn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isConnectionPossible()== true){
                Intent intent=new Intent(AashaActivity.this,FormActivity.class);
                startActivity(intent);
                finish();}
                else {
                    Toast.makeText(AashaActivity.this,"Please Check Network Connection",Toast.LENGTH_LONG).show();
                }


            }
        });

        prepareSideMenu();


        img_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                }
                else
                    drawer_layout.openDrawer(GravityCompat.START);

            }
        });



    }
    private boolean isConnectionPossible() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void prepareSideMenu() {

        menu_list=(ListView)findViewById(R.id.menu_list);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);

        arrayList= Constant.prepareSideMenu(this);

        nav_view =findViewById(R.id.nav_view);
        //txt_nav_name.setText(prefs.getString(Constants.strShPrefUserName, ""));
        side_menu = new CustomAdaptr(arrayList,this);

        menu_list.setAdapter(side_menu);

        menu_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                }

                new Constant(AashaActivity.this,AashaActivity.this).openActivity(arrayList.get(position).getName());
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer_layout =findViewById(R.id.drawer_layout);
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

}
