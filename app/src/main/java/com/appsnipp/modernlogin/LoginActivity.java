package com.appsnipp.modernlogin;

import android.content.Context;
import android.content.Intent;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;


import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;


public class LoginActivity extends AppCompatActivity {

    private static final String EMAIL = "email";
    private static final String USER_POSTS = "user_posts";
    private static final String AUTH_TYPE = "rerequest";
    private static String profilePicture="profilePicture";
    private static String userId="userId";
    private static String firstName="firstName";
    private static String lastName="lastName";
    private static String email="email";

    private CallbackManager callbackManager;
    ImageView fbLogin;
    LoginButton loginButton;
CircularProgressButton cirLoginButton;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for changing status bar icon colors
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);
        callbackManager = CallbackManager.Factory.create();
       fbLogin = (ImageView) findViewById(R.id.fb_login);
        loginButton=(LoginButton)findViewById(R.id.login_button);
        cirLoginButton=(CircularProgressButton) findViewById(R.id.cirLoginButton);
        cirLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, DashboardActivity.class));

            }
        });
        fbLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           //startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
               loginButton.performClick();
            }
        });

        FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(final LoginResult loginResult) {
                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                      Log.e("login",object.toString());
                        String AccessToken = loginResult.getAccessToken().getToken();
                        System.out.println("Access Token : "+AccessToken);

                        try {
                            userId = object.getString("id");
                            profilePicture = new String("https://graph.facebook.com/" + userId + "/picture?width=500&height=500");
                            if(object.has("first_name"))
                                firstName = object.getString("first_name");
                            if(object.has("last_name"))
                                lastName = object.getString("last_name");
                            if (object.has("email"))
                                email = object.getString("email");

                            System.out.println("Profile Picture : "+profilePicture);

                            //checkCredentials(email,"Social",userId,firstName+" "+lastName,"Facebook");


                        } catch (JSONException e) {
                            e.printStackTrace();
//                        } catch (MalformedURLException e) {
//                            e.printStackTrace();
                        }
                    }

                });

                //Here we put the requested fields to be returned from the JSONObject
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id, first_name, last_name, email");
                request.setParameters(parameters);
                request.executeAsync();
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException e) {
                e.printStackTrace();
            }
        };
        loginButton.setReadPermissions("email");
        loginButton.registerCallback(callbackManager, callback);

    }


    public void onLoginClick(View View){
        startActivity(new Intent(this,RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }


}
