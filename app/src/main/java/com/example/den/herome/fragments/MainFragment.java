package com.example.den.herome.fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.den.herome.R;
import com.example.den.herome.activities.MainActivity;
import com.example.den.herome.customdraws.MainFragmentDraw;


public class MainFragment extends Fragment implements View.OnClickListener{

    private Button accidentButton,geneticButton,bornButton,chooseButton;
    private View chosedView;
    private int leftDrawable,rightDrawable;
    private String name;
    public MainFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        accidentButton = (Button)view.findViewById(R.id.accidentButton);
        geneticButton = (Button)view.findViewById(R.id.geneticButton);
        bornButton = (Button)view.findViewById(R.id.bornButton);
        chooseButton = (Button)view.findViewById(R.id.chooseButton);

        accidentButton.setOnClickListener(this);

        geneticButton.setOnClickListener(this);


        bornButton.setOnClickListener(this);

        chooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).changeFragment(1);
                name = ((Button)chosedView).getText().toString();
                MainActivity.addView(leftDrawable,name,rightDrawable);

            }
        });
        chooseButton.setEnabled(false);
        chooseButton.getBackground().setAlpha(128);
        defaultStateButtons();

        MainFragmentDraw draw = new MainFragmentDraw(getContext());
        FrameLayout drawLayout = (FrameLayout)view.findViewById(R.id.cont);
        drawLayout.addView(draw);
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    @Override
    public void onClick(View v) {
        chosedView = v;
        chooseButton.setEnabled(true);
        chooseButton.getBackground().setAlpha(255);

        defaultStateButtons();
        rightDrawable = R.drawable.item_selected;
        leftDrawable = 0;
        switch (v.getId()){
            case R.id.accidentButton :
                leftDrawable = R.drawable.lightning;
                break;
            case R.id.geneticButton :
                leftDrawable = R.drawable.rocket;
                break;

            case R.id.bornButton :
                leftDrawable = R.drawable.atomic;
                break;
        }

        ((Button)v).setCompoundDrawablesWithIntrinsicBounds(leftDrawable,0,rightDrawable,0);

    }


    private void defaultStateButtons(){
        accidentButton.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
        geneticButton.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
        bornButton.setCompoundDrawablesWithIntrinsicBounds(0,0,0,0);
    }

    private class Draw extends View{

        public Draw(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
        }
    }

}
