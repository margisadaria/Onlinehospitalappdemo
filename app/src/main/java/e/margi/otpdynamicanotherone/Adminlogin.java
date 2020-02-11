package e.margi.otpdynamicanotherone;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Adminlogin extends AppCompatActivity
{
    EditText ad_email, ad_pass;
    Button btn_adminlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        ad_email = findViewById(R.id.et_adminemail1);
        ad_pass = findViewById(R.id.et_adminpass1);
        btn_adminlogin = findViewById(R.id.btn_admin_login);

        btn_adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(ad_email.getText().toString().equals("admin@gmail.com") && ad_pass.getText().toString().equals("123456")){
                    Toast.makeText(Adminlogin.this, "Login successfully", Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(Adminlogin.this, Doctorpatientlist.class));


                }else{
                    //wrong password
                    Toast.makeText(Adminlogin.this, "Login failed", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

 /*   @Override
    public void onBackPressed() {
       // super.onBackPressed();
    }*/
}
