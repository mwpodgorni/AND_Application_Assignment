package com.example.myproject;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myproject.Notes.SeeNotesActivity;
import com.example.myproject.Stories.MainActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.squareup.picasso.Picasso;

public class LoginActivity extends AppCompatActivity {
    static final int GOOGLE_SIGN = 123;
    FirebaseAuth mAuth;
    Button btn_login, btn_logout;
    Button seeNotes, seeStories, parseStoriesFromJson;
    TextView text;
    ImageView image;
    ProgressBar progressBar;
    GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btn_login = findViewById(R.id.login);
        btn_logout = findViewById(R.id.logout);
        seeNotes = findViewById(R.id.seeNotes);
        seeStories = findViewById(R.id.seeStories);
        parseStoriesFromJson = findViewById(R.id.parseStoriesFromJson);
        text = findViewById(R.id.text);
        image = findViewById(R.id.image);
        progressBar = findViewById(R.id.progress_circular);
        mAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions
                .Builder()
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient= GoogleSignIn.getClient(this, googleSignInOptions);
        btn_login.setOnClickListener(v -> SignInGoogle());
        btn_logout.setOnClickListener(v -> Logout());
        if(mAuth.getCurrentUser() != null){
            FirebaseUser user = mAuth.getCurrentUser();
            updateUI(user);
        }
        findViewById(R.id.parseStoriesFromJson).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ParsingJsonActivity.class));
            }
        });
        findViewById(R.id.seeNotes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SeeNotesActivity.class));
            }
        });
        findViewById(R.id.seeStories).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
        });
        seeNotes.setVisibility(View.INVISIBLE);
        seeStories.setVisibility(View.INVISIBLE);
        parseStoriesFromJson.setVisibility(View.INVISIBLE);
    }
    void SignInGoogle(){
        progressBar.setVisibility(View.VISIBLE);
        Intent signIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signIntent, GOOGLE_SIGN);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GOOGLE_SIGN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try{
                GoogleSignInAccount account = task.getResult(ApiException.class);
                if(account!= null) firebaseAuthWithGoogle(account);
            }catch (ApiException e){
                e.printStackTrace();
            }
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        Log.d("TAG", "firebaseAuthWithGoogle: "+ account.getId());
        AuthCredential credential = GoogleAuthProvider
                .getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, task ->{
                    if(task.isSuccessful()){
                        progressBar.setVisibility(View.INVISIBLE);
                        Log.d("TAG", "signin success");
                        FirebaseUser user =mAuth.getCurrentUser();
                        updateUI(user);
                    }else{
                        progressBar.setVisibility(View.INVISIBLE);
                        Log.w("TAG", "signin failure", task.getException());
                        Toast.makeText(this, "SignIn Failed!", Toast.LENGTH_SHORT);
                        updateUI(null);
                    }
        });
    }
    private void updateUI(FirebaseUser user) {
        if(user!= null){
            String name = user.getDisplayName();
            String email = user.getEmail();
            String photo = String.valueOf(user.getPhotoUrl());
            text.append("Info: \n");
            text.append(name + "\n");
            text.append(email);
            Picasso.get().load(photo).into(image);
            btn_login.setVisibility(View.INVISIBLE);
            btn_logout.setVisibility(View.VISIBLE);
            seeNotes.setVisibility(View.VISIBLE);
            seeStories.setVisibility(View.VISIBLE);
            parseStoriesFromJson.setVisibility(View.VISIBLE);
        }else {
            text.setText(getString(R.string.firebase_login));
            Picasso.get().load(R.drawable.ic_firebase_logo).into(image);
            btn_login.setVisibility(View.VISIBLE);
            btn_logout.setVisibility(View.INVISIBLE);
            seeNotes.setVisibility(View.INVISIBLE);
            seeStories.setVisibility(View.INVISIBLE);
            parseStoriesFromJson.setVisibility(View.INVISIBLE);
        }
    }
    void Logout(){
        FirebaseAuth.getInstance().signOut();
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, task ->{ updateUI(null);});
    }
}
