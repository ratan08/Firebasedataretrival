package com.group.firebasedataretrival;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ShowDataActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    TextView aa;
    Button fav;
    FirebaseDatabase showDB = FirebaseDatabase.getInstance();
    DatabaseReference root = showDB.getReference().child("user");
    //DatabaseReference root1 = showDB.getReference().child("Fav");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        aa=findViewById(R.id.aa);


        recyclerView = findViewById(R.id.recyclerView);
        fav=findViewById(R.id.fav);
        ArrayList<model> arrayList = new ArrayList<>();
        AdepterShow adepterShow = new AdepterShow(arrayList,this);
        adepterShow.setArrayList(arrayList);



        recyclerView.setAdapter(adepterShow);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    model model1 = dataSnapshot1.getValue(model.class);
                    arrayList.add(model1);
                    aa.setText(root.push().getKey());

                }
                adepterShow.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });







    }
}