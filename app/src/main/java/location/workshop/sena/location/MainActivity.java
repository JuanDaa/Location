package location.workshop.sena.location;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Double l1, l2;
    EditText EtxLat, EtxLong;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Hey",EtxLat.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EtxLat = (EditText) findViewById(R.id.EtxLat);
        EtxLong = (EditText) findViewById(R.id.EtxLong);


        LocationManager administrador = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener ubica = new Ubicar();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        administrador.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ubica);

    }

    public class Ubicar implements LocationListener{

        public void onLocationChanged(Location location) {
        l1=location.getLatitude();
        l2=location.getLongitude();


            EtxLat.setText(String.valueOf(l1));
            EtxLong.setText(String.valueOf(l2));

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
     }
    }
