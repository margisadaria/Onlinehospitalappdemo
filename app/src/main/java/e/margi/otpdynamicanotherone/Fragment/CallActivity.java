package e.margi.otpdynamicanotherone.Fragment;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import e.margi.otpdynamicanotherone.MessageActivity;
import e.margi.otpdynamicanotherone.R;
public class CallActivity  extends AppCompatActivity implements View.OnClickListener
{
    private static int CALL = 1;
    private static String[] Permissions = {Manifest.permission.CALL_PHONE};

 /*   public static void verifythatwecancallsomeone(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE);
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, Permissions, CALL);
        }
    }*/

   // Button udemy;
    //Button google;
    Button calltosomeone;
    Button dialpad;
    Button chatwithdoctor;
    //Button camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.callingactivity);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //  verifythatwecancallsomeone(MainActivity.this);
      //  udemy = (Button) findViewById(R.id.udemy);
        //google = (Button) findViewById(R.id.google);
        calltosomeone = (Button) findViewById(R.id.callsomeone);
        dialpad = (Button) findViewById(R.id.dialpad);
        chatwithdoctor = (Button)findViewById(R.id.chatwithdoctor);
        //camera = (Button) findViewById(R.id.camera);

        //udemy.setOnClickListener(CallActivity.this);
        //google.setOnClickListener(CallActivity.this);
        calltosomeone.setOnClickListener(CallActivity.this);
        dialpad.setOnClickListener(CallActivity.this);
        chatwithdoctor.setOnClickListener(CallActivity.this);
        //camera.setOnClickListener(CallActivity.this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           /* case R.id.udemy:
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("http://www.udemy.com"));
                startActivity(intent1);
                break;

            case R.id.google:
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                intent2.setData(Uri.parse("http://www.google.com"));
                startActivity(intent2);
                break;*/

            case R.id.callsomeone:
                if (ContextCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, CALL);


                } else {
                    Intent intent3 = new Intent(Intent.ACTION_VIEW);
                    intent3.setData(Uri.parse("tel:7622909830"));
                    startActivity(intent3);
                }
                break;

            case R.id.dialpad:
                Intent intent4 = new Intent(Intent.ACTION_DIAL);
                //intent4.setData(Uri.parse("tel:7622909830"));
                startActivity(intent4);
                break;
            case R.id.chatwithdoctor:
               // Intent intent = new Intent(Intent.ACTION_DIAL);
                //intent4.setData(Uri.parse("tel:7622909830"));
                startActivity(new Intent(CallActivity.this,MessageActivity.class));
                break;
        }
    }
}
