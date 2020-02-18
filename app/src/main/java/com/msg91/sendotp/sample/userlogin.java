package com.msg91.sendotp.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class userlogin extends AppCompatActivity {
EditText username,password;

Button btnn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);

        username=findViewById(R.id.u_name);
        password=findViewById(R.id.u_pass);
        btnn=findViewById(R.id.u_buttonuser);

        btnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        if (username.getText().toString().isEmpty()){

                            username.setError("Empty Field");
                        }

                        else if (password.getText().toString().isEmpty()){

                            password.setError("Empty Field");
                        }


                        else if (password.getText().toString().length()<=6){

                            password.setError("Password Must Contain minimum 6 Digits");
                        }
                        else
                        {
                            StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://techsaysjustin.000webhostapp.com/city360/login.php",
                                    new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
//If we are getting success from server

                                            if(response.contains("Success"))
                                            {
                                                Toast.makeText(userlogin.this, "sucess", Toast.LENGTH_LONG).show();
                                                // startActivity(new Intent(login.this,Registration.class));
                                            }
                                            else {
                                                Toast.makeText(userlogin.this, "Incorrect Details", Toast.LENGTH_LONG).show();
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

                                    params.put("username",username.getText().toString());
                                    params.put("password",password.getText().toString());

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
                            RequestQueue requestQueue = Volley.newRequestQueue(userlogin.this);
                            requestQueue.add(stringRequest);

                        }




                    }
                });



            }
        };
