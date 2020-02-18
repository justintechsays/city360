package com.msg91.sendotp.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class userregistration extends AppCompatActivity {
    TextView name,password,phonenumber,repeatpassword;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregistration);
        btn=findViewById(R.id.u_buttonuser);
        name=findViewById(R.id.uname);
        password=findViewById(R.id.upass);
        phonenumber=findViewById(R.id.uphone);
        repeatpassword=findViewById(R.id.urptpass);



                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (name.getText().toString().isEmpty()){

                            name.setError("Empty Field");
                        }

                        else if (password.getText().toString().isEmpty()){

                            password.setError("Empty Field");
                        } else if (phonenumber.getText().toString().isEmpty()) {
                            password.setError("Empty field");

                        } else if (password.getText().toString().length() <= 6) {

                            password.setError("Password Must Contain 6 Digits");
                        }

                         else {


                            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://techsaysjustin.000webhostapp.com/city360/userregisteration.php",
                                    new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
//If we are getting success from server

                                            if (response.contains("Success")) {
                                                Toast.makeText(userregistration.this, "success", Toast.LENGTH_LONG).show();
                                                // startActivity(new Intent(login.this,Registration.class));
                                            } else {
                                                Toast.makeText(userregistration.this, "Incorrect Details", Toast.LENGTH_LONG).show();
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

                                    params.put("username", name.getText().toString());
                                    params.put("phonenumber", phonenumber.getText().toString());
                                    params.put("password", password.getText().toString());

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
                            RequestQueue requestQueue = Volley.newRequestQueue(userregistration.this);
                            requestQueue.add(stringRequest);

                        }




                    }

        });

    }
}
