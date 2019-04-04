package com.example.connnectit;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class AcitvityLifecycle extends AppCompatActivity {
    private Button detailButton;
    public static final int DETAIL_REQUEST = 1;
    private Button back;
    private String status  = "";
    private TextView selected;

    public void displayStatus(){
        Toast.makeText(getApplicationContext(), status, Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitvity_lifecycle);
        status = "Creating ...";
        displayStatus();

        detailButton = findViewById(R.id.detailButton);
        back = findViewById(R.id.backButton);
        selected = findViewById(R.id.textSelected);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ib = new Intent(AcitvityLifecycle.this, ConnectActivity.class);
                startActivity(ib);
            }
        });


        detailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DetailActivity.class);
                i.putExtra("MYNAME", "Moussa Sarr is the man");
                startActivityForResult(i, DETAIL_REQUEST);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        status = "On Start ";
        displayStatus();
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        status = "Restoring Instance state aka.  onRestoreInstance";
        displayStatus();
    }

     @Override
    protected void onResume(){
        super.onResume();
        status = "Resuming aka. onResume";
        displayStatus();
     }


    @Override
    protected void onPause() {
        super.onPause();
        status = "Pausing";
        displayStatus();
    }

   @Override
   protected void onSaveInstanceState(Bundle instanceState){
        super.onSaveInstanceState(instanceState);
        status = "Saving Instance State";
        displayStatus();

   }

   @Override
   protected void onStop(){
        super.onStop();
        status = "Stopping ...";
        displayStatus();
   }


   @Override
   protected void onRestart(){
        super.onRestart();
        status = "Restarting ...";
        displayStatus();
   }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        status = "Destroying ...";
        displayStatus();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK && requestCode == DETAIL_REQUEST){
            if(data.hasExtra("returningKey")){
               String myValue = data.getExtras().getString("returningKey");
               selected.setText(myValue);
            }
        }
    }
}
