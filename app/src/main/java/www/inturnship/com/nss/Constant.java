package www.inturnship.com.nss;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.widget.Toast;

import java.util.ArrayList;

public class Constant {
    static Context con;
    Activity a;



    public Constant(Context con, Activity a)
    {
        this.con=con;
        this.a=a;
    }

    public void openActivity(String name)
    {
        if(name.equalsIgnoreCase("Home"))
        {

            if(!(con instanceof HomeActivity))
            {
                Intent intent =new Intent(con,HomeActivity.class);
                con.startActivity(intent);
                //a.overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
               a.finish();
            }

        }


        else if(name.equalsIgnoreCase("Aasha"))
        {

            if(!(con instanceof AashaActivity))
            {
                Intent intent =new Intent(con,AashaActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                con.startActivity(intent);

                //a.overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
                if(!(con instanceof HomeActivity))
                a.finish();
            }

        }

        else if(name.equalsIgnoreCase("Contact Us"))
        {

            if(!(con instanceof ContactActivity))
            {
                Intent intent =new Intent(con,ContactActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                con.startActivity(intent);

                //a.overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
                if(!(con instanceof HomeActivity))
                    a.finish();
            }

        }

        else if(name.equalsIgnoreCase("Feedback"))
        {

                if(isConnectionPossible()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("https://goo.gl/forms/hmiUbP4eBvLJ6eYq1"));
                    con.startActivity(intent);

                    //a.overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left);
                    if (!(con instanceof HomeActivity)) {
                        a.finish();

                    }
                }
                else{
                    Toast.makeText(con,"Please Check Network Connection",Toast.LENGTH_LONG).show();
                }



        }

    }
    private boolean isConnectionPossible() {
        ConnectivityManager connectivityManager = (ConnectivityManager) con.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    public static ArrayList<ListModel> prepareSideMenu(Activity act)
    {

        ArrayList<ListModel> al_menu_item;
        ListModel side_menu;
        al_menu_item=new ArrayList<>();


        side_menu=new ListModel();
        side_menu.setName("Home");
        al_menu_item.add(side_menu);

        side_menu=new ListModel();
        side_menu.setName("Aasha");
        al_menu_item.add(side_menu);

        side_menu=new ListModel();
        side_menu.setName("Contact Us");
        al_menu_item.add(side_menu);

        side_menu=new ListModel();
        side_menu.setName("Feedback");
        al_menu_item.add(side_menu);





        return al_menu_item;

    }




}

