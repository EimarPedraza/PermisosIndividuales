package androlite.requestpermissions;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
/*
* Create by Ardhitya Wiedha Irawan
* 2016
* aiueo.web.id
* gulangguling.com
* */
public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_GET_ACCOUNTS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPermissions();
    }

    public void getPermissions() {
        /* Check and Request permission */
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.GET_ACCOUNTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.GET_ACCOUNTS},
                    MY_PERMISSIONS_REQUEST_GET_ACCOUNTS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_GET_ACCOUNTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission..
                    Toast.makeText(MainActivity.this, "Permission denied to get Account", Toast.LENGTH_SHORT).show();

                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


}
