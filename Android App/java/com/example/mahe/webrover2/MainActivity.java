package com.example.mahe.webrover2;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    static String dir;

    static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference myRef = database.getReference("/action/now");
    static FirebaseDatabase database1 = FirebaseDatabase.getInstance();
    static DatabaseReference myRef1 = database1.getReference("/status/Move");
    static DatabaseReference myRef0 = database1.getReference("/status/Ultrasonic_Status");
    static DatabaseReference myRef6 = database1.getReference("/status/Image");

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Swipe through screens or Tap on the Action Bar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            myRef0.setValue(0);
            myRef6.setValue(0);
            myRef1.setValue("7");
            myRef.setValue("Everything Good");
            ImageButton IB1=(ImageButton) rootView.findViewById(R.id.imageButton1);
            ImageButton IB2=(ImageButton) rootView.findViewById(R.id.imageButton2);
            ImageButton IB3=(ImageButton) rootView.findViewById(R.id.imageButton3);
            ImageButton IB4=(ImageButton) rootView.findViewById(R.id.imageButton4);
            ImageButton IB5=(ImageButton) rootView.findViewById(R.id.imageButton5);
            ImageButton IB6=(ImageButton) rootView.findViewById(R.id.imageButton6);
            ImageButton IB7=(ImageButton) rootView.findViewById(R.id.imageButton7);
            final ToggleButton TB=(ToggleButton) rootView.findViewById(R.id.toggleButton);
            final CheckBox c2=(CheckBox) rootView.findViewById(R.id.checkBox2);
            final CheckBox c=(CheckBox) rootView.findViewById(R.id.checkBox);
            final TextView t=(TextView) rootView.findViewById(R.id.textView);
            final NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(getActivity())
                            .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark_focused)
                            .setContentTitle("Alert")
                            .setContentText("Get Back").setColor(RED);
            t.setTextColor(Color.RED);
            c.setTextColor(Color.GREEN);
            c2.setTextColor(Color.GREEN);
            IB1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(c2.isChecked())
                    {dir="1";}

                    myRef1.setValue(dir);
                    int i=0;
                    Vibrator vb = (Vibrator)  getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);


                }
            });

            IB2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(c2.isChecked())
                    {dir="2";}

                    myRef1.setValue(dir);
                    Vibrator vb = (Vibrator)  getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);


                }
            });

            IB3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(c2.isChecked())
                    {dir="3";}

                    myRef1.setValue(dir);
                    Vibrator vb = (Vibrator)  getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);


                }
            });

            IB4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(c2.isChecked())
                    {dir="4";}

                    myRef1.setValue(dir);
                    Vibrator vb = (Vibrator)  getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);



                }
            });

            IB5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i=0;
                    if(c2.isChecked())
                    {dir="5";}

                    myRef1.setValue(dir);
                    Vibrator vb = (Vibrator)  getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);


                }
            });

            IB6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i=0;
                    if(c2.isChecked())
                    {dir="6";}

                    myRef1.setValue(dir);
                    Vibrator vb = (Vibrator)  getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);


                }
            });

            IB7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int i=0;
                    if(c2.isChecked())
                    {dir="7";}

                    myRef1.setValue(dir);
                    Vibrator vb = (Vibrator)  getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);


                }
            });

            c.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int i=0;
                    if (c.isChecked()) {

                        //  final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                        //        android.R.layout.simple_list_item_1, android.R.id.text1);




                    /*    FirebaseDatabase.getInstance()
                                .getReferenceFromUrl("https://botnet3-f4eca.firebaseio.com/todoItems").
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
                                */
                        myRef.addValueEventListener(new ValueEventListener() {
                            @Override

                            public void onDataChange(DataSnapshot dataSnapshot) {
                                // This method is called once with the initial value and again
                                // whenever data at this location is updated.
                                String value = dataSnapshot.getValue(String.class);

                                if (value.equals("Get Back"))

                                {
                                    int mNotificationId = 001;

                                    NotificationManager mNotifyMgr =
                                            (NotificationManager) getActivity().getSystemService(NOTIFICATION_SERVICE);

                                    mNotifyMgr.notify(mNotificationId, mBuilder.build());
                                    Vibrator vb = (Vibrator)  getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                                    vb.vibrate(200);


                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError error) {
                            }
                        });

                    }
                }
            });
            TB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Vibrator vb = (Vibrator)  getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);
                    if(TB.isChecked()){
                        myRef6.setValue(1);
                        TB.setTextColor(Color.YELLOW);
                    }
                    else
                        myRef6.setValue(0);

                }
            });
            c.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(c.isChecked()){
                        myRef0.setValue(1);
                    }
                    else
                        myRef0.setValue(0);
                }
            });



            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return PlaceholderFragment.newInstance(position + 1);

                case 1 :
                    return one.newInstance();

                case 2:
                    return two.newInstance();
                // default: return MyFragment.newInstance();
/* It is better to use default so that it always returns a fragment and no problems would ever occur */
            }
            return null;
            //if you use default, you would not need to return null
        }


        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Move";
                case 1:
                    return "Camera";
                case 2:
                    return "Arm";
            }
            return null;
        }
    }
}
