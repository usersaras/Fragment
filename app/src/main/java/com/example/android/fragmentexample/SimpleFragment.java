package com.example.android.fragmentexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleFragment extends Fragment {

    public static final int YES = 0;
    public static final int NO = 1;

    public SimpleFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        final View rootView = inflater.inflate(R.layout.fragment_simple,
                container, false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);
        final RatingBar ratingBar =
                rootView.findViewById(R.id.ratingBar);

        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId) {
                        View radioButton = radioGroup.findViewById(checkedId);
                        int index = radioGroup.indexOfChild(radioButton);
                        TextView textView =
                                rootView.findViewById(R.id.fragment_header);
                        switch (index) {
                            case YES: 
                                textView.setText(R.string.yes_message);
                                break;
                            case NO: .
                                textView.setText(R.string.no_message);
                                break;
                            default: 
                                break;
                        }
                    }
                });

        ratingBar.setOnRatingBarChangeListener
                (new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar,
                                                float rating, boolean fromUser) {
                        String myRating = (getString(R.string.my_rating) +
                                String.valueOf(ratingBar.getRating()));
                        Toast.makeText(getContext(), myRating,
                                Toast.LENGTH_SHORT).show();
                    }
                });

        return rootView;
    }
}
