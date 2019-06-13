package www.inturnship.com.nss;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    TextView header,map_bcet;
    ImageView img_nav,call_s,call_p,call_pr,amar_fb,amar_insta,amar_link,sour_fb,sour_insta,sour_link;

    DrawerLayout drawer_layout;
    ListView menu_list;
    ArrayList<ListModel> arrayList;
    CustomAdaptr side_menu;
    NavigationView nav_view;
    LinearLayout lin_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        if(Build.VERSION.SDK_INT>=21){
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.header));
        }
        header=findViewById(R.id.header);
        header.setText("Contact Us");
        img_nav=findViewById(R.id.img_nav);
        lin_nav=findViewById(R.id.lin_nav);
        prepareSideMenu();
        call_s=findViewById(R.id.call_s);
        call_p=findViewById(R.id.call_p);
        call_pr=findViewById(R.id.call_pr);
        amar_fb=findViewById(R.id.amar_fb);
        amar_insta=findViewById(R.id.amar_insta);
        amar_link=findViewById(R.id.amar_link);
        sour_fb=findViewById(R.id.sour_fb);
        sour_insta=findViewById(R.id.sour_insta);
        sour_link=findViewById(R.id.sour_link);
        map_bcet=findViewById(R.id.map_bcet);
        call_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { dial("8145303074"); }});
        call_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dial("9647138747");

            }
        });
        call_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { dial("7908040958"); }});
        map_bcet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map("https://maps.app.goo.gl/hEK5m");
            }
        });


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
        amar_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click("https://www.facebook.com/amar.kumar.5895834/");
            }});
        amar_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click("https://www.instagram.com/ask_amar01/");
                }});
        amar_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click("https://www.linkedin.com/in/amar-jyoti-a80945150/");
                }});
        sour_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                click("https://www.facebook.com/sour132/");
                }});
        sour_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    click("https://www.instagram.com/sour132/");

                }});
        sour_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click("https://www.linkedin.com/in/sourav-kumar-3384a0156/"); }});



    }

    private void map(String url) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);


    }

    private boolean isConnectionPossible() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void click(String url) {
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }


    private void dial(String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)));

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

                new Constant(ContactActivity.this,ContactActivity.this).openActivity(arrayList.get(position).getName());
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
