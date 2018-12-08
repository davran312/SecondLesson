package application.first.secondlesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//           String intentMessage =  getIntent().getExtras().getString("text","nothing sended");
//           if(intentMessage != null){
//               textView.setText(intentMessage);
//           }
        ImageView image = findViewById(R.id.iw_click);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = getIntent();
                resultIntent.putExtra("buttontext","RESULT_OK");
                setResult(RESULT_OK,resultIntent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        finish();

    }
}
