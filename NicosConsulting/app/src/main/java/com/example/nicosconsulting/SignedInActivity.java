package com.example.nicosconsulting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.net.Inet4Address;

public class SignedInActivity extends AppCompatActivity {
    private static final String TAG = "SignedInActivity";
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signedin);
        Log.d(TAG, "onCreate Started.");

        setupFirebaseAuth();
        //getUserDetails();
        setUserDetails();

    }

    private void setUserDetails(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            try {
                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                        .setDisplayName("Nicos waves")
                        .setPhotoUri(Uri.parse("data:image/jpeg;base64,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"))
                        .build();
                user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Log.d(TAG, "onComplete :user profile updated.");
                            getUserDetails();
                        }
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void getUserDetails(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user !=null){
            String uid = user.getUid();
            String name = user.getDisplayName();
            String  email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            String properties = "uid : " + uid + "\n" +
                    "name : " + name + "\n" +
                    "email : " + email + "\n" +
                    "photoUrl : " + photoUrl + "\n" ;
            Log.d(TAG, "getUserDetails : properties : \n " + properties);

        }
    }


    @Override
    protected void onResume(){
        super.onResume();
        checkAuthenticationState();
    }

    private void checkAuthenticationState(){

        Log.d(TAG, "CheckAuthenticationState: checking authentication state.");
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user == null){
            Log.d(TAG, "checkAuthenticationState: user is null , navigation back to login screen.");
            Intent intent = new Intent(SignedInActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        else {
            Log.d(TAG, "checkAuthenticationState: user is authenticated.");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.optionSignout:
                signOut();
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
    }

    private void signOut(){
        Log.d(TAG, "signOut : signing Out");
        FirebaseAuth.getInstance().signOut();
    }


    private void setupFirebaseAuth(){
        Log.d(TAG, "setupFirebaseAuth: started.");

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {

                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());

                } else {
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    Intent intent = new Intent(SignedInActivity.this, LoginActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
                // ...
            }
        };
    }


    @Override
    public void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }

}
