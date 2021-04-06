package com.group.firebasedataretrival;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private EditText name, address, email;
    private Button button,button1;
    private FirebaseDatabase fireDB = FirebaseDatabase.getInstance();
    private DatabaseReference root = fireDB.getReference().child("user");
    private FrameLayout favFragment,ShowFragment;
    RelativeLayout mainRel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name1);
        email= findViewById(R.id.email1);
        address= findViewById(R.id.address1);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        favFragment=findViewById(R.id.favFragment);
        ShowFragment = findViewById(R.id.ShowFragment);
        mainRel=findViewById(R.id.mainRel);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String,String> dataMap = new HashMap<>();
                dataMap.put("name",name.getText().toString());
                dataMap.put("email",email.getText().toString());
                dataMap.put("address",address.getText().toString());
                root.push().setValue(dataMap);
                Intent intent = new Intent(MainActivity.this,ShowDataActivity.class);
                startActivity(intent);
            }
        });
        button1.setOnClickListener(v -> {
            FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main,new favFragment());
            transaction.addToBackStack(null);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

            transaction.commit();
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mainRel.setVisibility(View.VISIBLE);
    }
}