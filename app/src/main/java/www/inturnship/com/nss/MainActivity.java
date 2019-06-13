package www.inturnship.com.nss;


import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import static android.Manifest.permission.CALL_PHONE;

public class MainActivity extends AppCompatActivity {
    public static final int timer=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if(Build.VERSION.SDK_INT>=21){
            Window window=this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.black));
        }

       // makecallPermission();

        checkselfPermission();

        if(checkselfPermission()){
            splashScreen();
        }
        else{
            ActivityCompat.requestPermissions(this, new String[]{CALL_PHONE}, 100);
        }

    }

    private boolean checkselfPermission() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE);

        return result == PackageManager.PERMISSION_GRANTED;


    }

    public void splashScreen(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },timer);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 100:
                if (grantResults.length > 0) {

                    boolean callAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    //boolean cameraAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (callAccepted) {
                        Toast.makeText(MainActivity.this, "Permission Granted, Now you can access call", Toast.LENGTH_LONG).show();
                        splashScreen();
                    }
                    else {

                        Toast.makeText(MainActivity.this, "Permission Denied, You cannot access call.", Toast.LENGTH_LONG).show();

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            if (shouldShowRequestPermissionRationale(CALL_PHONE)) {
                                showMessageOKCancel("You need to allow access to call permissions",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                    requestPermissions(new String[]{CALL_PHONE},
                                                            100);
                                                }
                                            }
                                        });
                                return;
                            }
                        }

                    }
                }


                break;
        }
    }









    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(MainActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }


}
