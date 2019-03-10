package com.example.mahe.webrover2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import static com.example.mahe.webrover2.two.myRef4;


/**
 * Created by MAHE on 7/17/2016.
 */

public class one extends Fragment {
    private static final String TAG = "MyActivity";
    static FirebaseDatabase database3 = FirebaseDatabase.getInstance();
    static DatabaseReference myRef3 = database3.getReference("/image/now");
    static FirebaseDatabase database4 = FirebaseDatabase.getInstance();
    static int j1=10;
    static int j4=10;
    static Bitmap decodedByte;
    public String value ;
    ImageView image;
    public static one newInstance() {
        one fragment = new one();
        return fragment;
    }

    public one(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int i=0;
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        image=(ImageView) rootView.findViewById(R.id.imageView);
        Log.v(TAG, "index=" + i);

        ImageButton IB21=(ImageButton) rootView.findViewById(R.id.imageButton8);
        ImageButton IB22=(ImageButton) rootView.findViewById(R.id.imageButton9);
        ImageButton IB23=(ImageButton) rootView.findViewById(R.id.imageButton10);
        ImageButton IB24=(ImageButton) rootView.findViewById(R.id.imageButton11);
        Button b5=(Button) rootView.findViewById(R.id.button5);

        FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://webrover2.firebaseio.com/").
                addChildEventListener(new ChildEventListener() {
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        //       adapter.add((String) dataSnapshot.child("text").getValue());

                    }

                    public void onChildRemoved(DataSnapshot dataSnapshot) {
                        //      adapter.remove((String) dataSnapshot.child("text").getValue());
                    }

                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        Log.d(TAG, "onChildChanged:" + dataSnapshot.getKey());

                    }

                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    }

                    public void onCancelled(DatabaseError firebaseError) {
                    }
                });

        myRef3.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
                System.out.print(value);
                byte[] decodedString = Base64.decode(value, Base64.DEFAULT);
                decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                image.setImageBitmap(decodedByte);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        IB21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(j1<17) {
                    j1 = j1 + 1;
                    myRef4.setValue("u" + j1);
                    Vibrator vb = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);
                }

            }
        });

        IB22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(j4>1){
                    j4=j4-1;
                    myRef4.setValue("l"+j4);
                    Vibrator vb = (Vibrator)  getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);


                }}
        });

        IB23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(j1>1) {
                    j1 = j1 - 1;
                    myRef4.setValue("u" + j1);
                    Vibrator vb = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);
                }

            }
        });

        IB24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(j4<17) {
                    j4 = j4 + 1;
                    myRef4.setValue("l" + j4);
                    Vibrator vb = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);

                }

            }
        });

        b5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                j1=9;
                j4=9;
                myRef4.setValue("C");
                Vibrator vb = (Vibrator)  getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vb.vibrate(100);
            }

        });

        return rootView;
    }

}


