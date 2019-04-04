package com.example.connnectit;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.List;
public class DetailActivity extends Activity {
    private Bundle extras;
    private String message;
    private Button returnButton;
    private Spinner spin;
    private String mySelection;
    private Button performSelect;
    Intent implicitIntent;


    public boolean isIntentAvailable(Intent i){
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities  = packageManager.queryIntentActivities(i,0);
        boolean isAvailable = activities.size() > 0 ;
        return isAvailable;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        spin = findViewById(R.id.spinner);
        returnButton = findViewById(R.id.returnSelection);
        performSelect = findViewById(R.id.performSelection);

        extras = getIntent().getExtras();
        if(extras != null){
            message = extras.getString("MYNAME");
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }

        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                mySelection = spin.getSelectedItem().toString();

                Log.e("SELECTED ITEM", mySelection);
                i.putExtra("returningKey", mySelection);
                setResult(RESULT_OK,i);
                finish();
            }
        });





        performSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = spin.getSelectedItemPosition();


                switch (position){

                    case 1:
                        //moussasarr.com
                        implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://moussasarr.com"));
                        break;
                    case 2:
                        //Call Mother
                        implicitIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+221)774440811"));

                    case 3:
                        //Map of YetSpace using geo intent
                        implicitIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 30.2715,-97.742 "));
                    case 4:
                        //Take a picture not returned to App
                        implicitIntent = new Intent("android.media.action.IMAGE_CAPTURE");
                    case 5:
                        //Edit first contact
                        implicitIntent = new Intent(Intent.ACTION_EDIT, Uri.parse("content://contacts/people/1"));
                        break;
                }

                if( implicitIntent != null){
                    if(isIntentAvailable(implicitIntent)){
                        startActivity(implicitIntent);
                    } else {
                        Toast.makeText(v.getContext(), "No avaialable Intent", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }
}
