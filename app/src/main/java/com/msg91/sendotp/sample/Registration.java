package com.msg91.sendotp.sample;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
SharedPreferences sh;
TextView rname,rregister,remail,raddress,rpass,rpassr;
Spinner rspin;
Button registerationbt;


    String[] sex = {"Electrician", "Plumber", "Helper","Telephone","DTH","Painter"};


    Spinner areaofwork;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        sh=getSharedPreferences("reg",MODE_PRIVATE);

//        toasts the phonennumber that is passed in the sharedpreferences
//        Toast.makeText(getApplicationContext(),sh.getString("ph",null),Toast.LENGTH_SHORT).show();
        rname=findViewById(R.id.r_name);
//        rregister=findViewById(R.id.r_register);
        remail=findViewById(R.id.r_emailid);
        raddress=findViewById(R.id.r_address);
        areaofwork=findViewById(R.id.r_registern);
        registerationbt=findViewById(R.id.r_button);
        rpass=findViewById(R.id.r_pass);
        rpassr=findViewById(R.id.r_passr);





        areaofwork.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, sex);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        areaofwork.setAdapter(aa);




        registerationbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                if (rname.getText().toString().isEmpty()){

                rname.setError("Empty Field");
            }


            else if (remail.getText().toString().isEmpty()){

                remail.setError("Empty Field");
            }
            else if (raddress.getText().toString().isEmpty()){

                raddress.setError("Empty Field");
            }
            else if (rpass.getText().toString().isEmpty()){

                rpass.setError("Empty Field");
            }
            else if (rpassr.getText().toString().isEmpty()){

                rpassr.setError("Empty Field");
            }





            else if (rpass.getText().toString().length()<=6){

                rpass.setError("Password Must Contain 6 Digits");
            }

            else


            {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://techsaysjustin.000webhostapp.com/city360/registration.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
//If we are getting success from server
                                Toast.makeText(Registration.this, response, Toast.LENGTH_LONG).show();
                                if (response.equals("Success")) {
                                    startActivity(new Intent(Registration.this, login.class));
                                }
                                try {
                                    JSONArray jsonArray = new JSONArray(response);
                                    for (int i = 0; i < jsonArray.length(); i++) {
                                        JSONObject json_obj = jsonArray.getJSONObject(i);
//ba = json_obj.getString("balance");


                                    }
//Toast.makeText(Recharge.this, "your new balnce is "+ba, Toast.LENGTH_LONG).show();
                                } catch (JSONException e) {
                                    e.printStackTrace();

                                }


                            }
                        },

                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
//You can handle error here if you want
                            }

                        }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
//Adding parameters to request

                        params.put("cname", rname.getText().toString());
                        params.put("cemail",remail.getText().toString());
                        params.put("cphonenumber",sh.getString("ph",null));
                        params.put("caddress", raddress.getText().toString());
                     //   params.put("nu",rspin.getSelectedItem().toString());
                        params.put("cpassword", rpass.getText().toString());
                        params.put("careaofwork", areaofwork.getSelectedItem().toString());

// params.put("confpass", confpass.getText().toString());
// params.put("phone", phone.getText().toString());
// Toast.makeText(MainActivity.this,"submitted",Toast.LENGTH_LONG).show();

//returning parameter
                        return params;
                    }

                };

// m = Integer.parseInt(ba) - Integer.parseInt(result.getContents());
// balance.setText(m+"");


//Adding the string request to the queue
                RequestQueue requestQueue = Volley.newRequestQueue(Registration.this);
                requestQueue.add(stringRequest);

            }}


    });

}


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        Toast.makeText(Registration.this,"Sex not selected",Toast.LENGTH_SHORT).show();


    }


}
//
//    public void EnableRuntimePermission() {
//
//        if (ActivityCompat.shouldShowRequestPermissionRationale(Registration.this,
//                Manifest.permission.CALL_PHONE)) {
//
//// Toast.makeText(Cpature_image.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();
//
//        } else {
//
//            ActivityCompat.requestPermissions(Registration.this, new String[]{
//                    Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
//
//
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {
//
//        switch (RC) {
//
//            case 1:
//
//                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {
//
//// Toast.makeText(Cpature_image.this,"Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();
//
//                } else {
//
//                    Toast.makeText(this, "Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();
//
//                }
//                break;
//        }
//    }
//}



