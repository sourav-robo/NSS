package www.inturnship.com.nss;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    TextView header;
    ImageView img_nav,tree_plantation,food_cloth,blood_donation,health_camp,paper_drive,diwali_celebration;


    DrawerLayout drawer_layout;
    LinearLayout lin_nav;
    ListView menu_list;
    ArrayList<ListModel> arrayList;
    CustomAdaptr adaptr;
    NavigationView nav_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tree_plantation=findViewById(R.id.tree_plantation);
        lin_nav=findViewById(R.id.lin_nav);

        tree_plantation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,TreeActivity.class);
                startActivity(intent);
                finish();

            }
        });
        food_cloth=findViewById(R.id.food_cloth);

        food_cloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,FoodClothActivity.class);
                startActivity(intent);
                finish();

            }
        });
        blood_donation=findViewById(R.id.blood_donation);

        blood_donation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(HomeActivity.this,BloodActivity.class);
                startActivity(intent);
                finish();

            }
        });
        health_camp=findViewById(R.id.health_camp);

        health_camp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,HealthActivity.class);
                startActivity(intent);
                finish();

            }
        });
        paper_drive=findViewById(R.id.paper_drive);



        paper_drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,PaperDriveActivity.class);
                startActivity(intent);
                finish();

            }
        });
        diwali_celebration=findViewById(R.id.diwali_celebration);

        diwali_celebration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomeActivity.this,DiwaliActivity.class);
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
        img_nav=findViewById(R.id.img_nav);
        header=findViewById(R.id.header);
        header.setText("HOME");

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


    }



    private void prepareSideMenu() {
        menu_list=(ListView)findViewById(R.id.menu_list);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);

        arrayList= Constant.prepareSideMenu(this);

        nav_view =findViewById(R.id.nav_view);
        //txt_nav_name.setText(prefs.getString(Constants.strShPrefUserName, ""));

        adaptr = new CustomAdaptr(arrayList,this);

        menu_list.setAdapter(adaptr);

        menu_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
                    drawer_layout.closeDrawer(GravityCompat.START);
                }

                new Constant(HomeActivity.this,HomeActivity.this).openActivity(arrayList.get(position).getName());
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
