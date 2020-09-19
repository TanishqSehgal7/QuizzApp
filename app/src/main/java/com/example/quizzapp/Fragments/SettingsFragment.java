package com.example.quizzapp.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.quizzapp.R;

import org.w3c.dom.Text;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    LinearLayout about;
    LinearLayout linkedin;
    TextView close;
    TextView aboutinfo;
    LinearLayout email_the_developer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsFragment() {
        // Required empty public constructor
    }
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        ViewGroup settings=(ViewGroup) inflater.inflate(R.layout.fragment_settings, container, false);

        about=(LinearLayout) settings.findViewById(R.id.about);
        final Dialog aboutDialog= new Dialog(Objects.requireNonNull(getActivity()));
        close=(TextView) aboutDialog.findViewById(R.id.close);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aboutDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                aboutDialog.setContentView(R.layout.about_dialog);
                aboutinfo=aboutDialog.findViewById(R.id.aboutInfo);
                aboutinfo.setText("QuizzApp is an android mobile application with it's source code written in Java and it's question set based on Firebase Realtime Database. " +
                        "This application lets you play quiz in various categories like Art and Literature, History, Geography, and many more. " );
                aboutDialog.show();

                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        aboutDialog.dismiss();
                    }
                },5000);

            }
        });

        final Uri linkedin_url=Uri.parse("https://www.linkedin.com/in/ramneek-kaur-226431181");
        final Uri email=Uri.parse("mailto:tsgl7246@gmail.com");

        linkedin=settings.findViewById(R.id.linkedin);
        linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW,linkedin_url);
                intent.setPackage("com.linkedin.android");
                try {
                    intent.setData(linkedin_url);
                    startActivity(intent);
                } catch (Exception e){
                    startActivity(new Intent(Intent.ACTION_VIEW,linkedin_url));
                }
            }
        });

        email_the_developer=settings.findViewById(R.id.email);
        email_the_developer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_SENDTO,email);
                intent.setPackage("com.google.android.gm");
                if (intent.getPackage()==null){
                    intent.setData(email);
                    startActivity(intent);
                } else {
                    startActivity(Intent.createChooser(intent,"Email Us"));
                }
            }
        });



        return settings;
    }
}