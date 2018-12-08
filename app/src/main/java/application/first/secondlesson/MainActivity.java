package application.first.secondlesson;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static int GET_TEXT = 1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button   = findViewById(R.id.btnSend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

//                Uri number = Uri.parse("http://www.google.kg");
//                Intent callIntent = new Intent(Intent.ACTION_VIEW,number);
//
////                PackageManager packageManager = getPackageManager();
////                List applications = packageManager.queryIntentActivities(callIntent,PackageManager.MATCH_DEFAULT_ONLY);
////                boolean flag = applications.size()>0;
////                if(flag)
////                    startActivity(callIntent);
//                Intent chooser = Intent.createChooser(callIntent,"Выберите приложение");
//                startActivity(chooser);
                startActivityForResult(intent,GET_TEXT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if( requestCode == GET_TEXT  && data != null){
                String btnText = data.getExtras().getString("buttontext","null");
                button.setText(btnText);
            }

    }
      else  if(resultCode == RESULT_CANCELED)
            Toast.makeText(this, "RESULT_CANCELED", Toast.LENGTH_SHORT).show();
    }
}
