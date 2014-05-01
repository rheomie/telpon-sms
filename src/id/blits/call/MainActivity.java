package id.blits.call;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener{
    /**
     * Called when the activity is first created.
     */
    String nomorPacar = "123";
    String nomorRumah = "234";
    String nomor;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.buttonTelpPacar).setOnClickListener(this);
        findViewById(R.id.buttonTelpRumah).setOnClickListener(this);

        findViewById(R.id.buttonSMSPacar).setOnClickListener(this);
        findViewById(R.id.buttonSMSRumah).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonTelpRumah :
                                nomor = nomorRumah;
                                telepon();
                                break;
            case R.id.buttonTelpPacar :
                                nomor = nomorPacar;
                                telepon();
                                break;
            case R.id.buttonSMSPacar :
                                nomor = nomorPacar;
                                sms();
                                break;
            case R.id.buttonSMSRumah :
                                nomor = nomorRumah;
                                sms();
                                break;
            default:break;
        }
    }

    private void telepon(){
        Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
        phoneCallIntent.setData(Uri.parse("tel:"+nomor));
        startActivity(phoneCallIntent);
    }

    private void sms(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms",
                nomor, null)));
    }
}
