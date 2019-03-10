package com.example.mahe.webrover2;

import android.content.Context;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import static com.example.mahe.webrover2.one.decodedByte;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link two.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link two#newInstance} factory method to
 * create an instance of this fragment.
 */
public class two extends Fragment {

    public two() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters

    private static final String TAG = "MyActivity";
    static FirebaseDatabase database5 = FirebaseDatabase.getInstance();
    static DatabaseReference myRef4 = database5.getReference("/armcam/now");
    static DatabaseReference myRef5 = database5.getReference("/grab/now");

    static int i2=10;

    static int i4=0;
    ImageView image1;

    public static two newInstance() {
        two fragment = new two();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView1 = inflater.inflate(R.layout.fragment_two, container, false);
        image1=(ImageView) rootView1.findViewById(R.id.imageView1);
        ImageButton IB31=(ImageButton) rootView1.findViewById(R.id.imageButton31);
        ImageButton IB32=(ImageButton) rootView1.findViewById(R.id.imageButton32);
        ImageButton IB33=(ImageButton) rootView1.findViewById(R.id.imageButton33);
        ImageButton IB34=(ImageButton) rootView1.findViewById(R.id.imageButton34);
        Button b2=(Button) rootView1.findViewById(R.id.button2);
        Button b3=(Button) rootView1.findViewById(R.id.button3);
        Button b4=(Button) rootView1.findViewById(R.id.button4);
        myRef4.setValue("A");
        image1.setImageBitmap(decodedByte);
        IB31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i4 > 1) {
                    i4 = i4 - 1;
                    myRef4.setValue("U" + i4);
                    Vibrator vb = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);
                }

            }
        });

        IB32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i2<17) {
                    i2 = i2 + 1;
                    myRef4.setValue("L" + i2);
                    Vibrator vb = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);
                }

            }
        });

        IB33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i2 > 1) {
                    i2 = i2 - 1;
                    myRef4.setValue("L" + i2);
                    Vibrator vb = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);
                }

            }
        });

        IB34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i4<17) {
                    i4 = i4 + 1;
                    myRef4.setValue("U" + i4);
                    Vibrator vb = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);

                }

            }
        });

        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                myRef4.setValue("G1");
                Vibrator vb = (Vibrator)  getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vb.vibrate(100);
            }

        });
        b3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                myRef4.setValue("G2");
                Vibrator vb = (Vibrator)  getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vb.vibrate(100);
            }

        });
        b4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                i2=0;
                i4=0;
                myRef4.setValue("A");
                Vibrator vb = (Vibrator)  getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vb.vibrate(100);
                myRef5.setValue(0);
            }

        });

        return rootView1;
    }

}
