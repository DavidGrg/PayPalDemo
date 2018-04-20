package com.example.davidg.paypaldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DavidG on 20/04/2018.
 */

public class PaymentDetails extends AppCompatActivity {


     @BindView( R.id.txtID ) TextView txtId;
     @BindView( R.id.txtAmount ) TextView txtAmount;
     @BindView( R.id.txtStatus ) TextView txtStatus;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
          super.onCreate( savedInstanceState );
          setContentView( R.layout.activity_payment_details );

          ButterKnife.bind( this );



          Intent intent = getIntent();



          try {

               JSONObject jsonObject = new JSONObject( intent.getStringExtra("Payment Details") );
                showDetails(jsonObject.getJSONObject( "response" ), intent.getStringExtra( "Payment Amount" ));
                 
          } catch (JSONException e) {
               e.printStackTrace();
          }
     }

     private void showDetails(JSONObject response, String stringExtra) {
          try {
               txtId.setText( response.getString("id") );
               txtAmount.setText( response.getString("status") );
               txtStatus.setText( response.getString(String.format( "$%s", stringExtra )) );

          } catch (JSONException e) {
               e.printStackTrace();
          }


     }


}
