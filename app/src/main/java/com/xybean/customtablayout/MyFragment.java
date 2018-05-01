package com.xybean.customtablayout;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyFragment extends Fragment {

    public static final String EXTRAS_KEY_COLOR = "extras_key_color";
    public static final String EXTRAS_KEY_TEXT = "extras_key_text";

    public static MyFragment newInstance(int colorRes, String text) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt(EXTRAS_KEY_COLOR, colorRes);
        args.putString(EXTRAS_KEY_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Creating a new TextView
        TextView view = new TextView(getContext());
        view.setTextColor(getResources().getColor(R.color.white));
        view.setTypeface(null, Typeface.BOLD);
        view.setTextSize(getResources().getDimension(R.dimen.text_largest));
        view.setGravity(Gravity.CENTER);

        Bundle args = getArguments();
        if (args != null) {
            if (args.containsKey(EXTRAS_KEY_COLOR)) {
                view.setBackgroundResource(args.getInt(EXTRAS_KEY_COLOR));
            }
            if (args.containsKey(EXTRAS_KEY_TEXT)) {
                view.setText(args.getString(EXTRAS_KEY_TEXT));
            }
        } else {
            view.setText(R.string.app_name);
            view.setBackgroundResource(R.color.md_blue_500);
        }

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
              LinearLayout.LayoutParams.MATCH_PARENT,
              LinearLayout.LayoutParams.MATCH_PARENT);

        view.setLayoutParams(lp);
        return view;
    }

    public String getTitle() {
        if (getArguments() != null && getArguments().containsKey(EXTRAS_KEY_TEXT)) {
            return getArguments().getString(EXTRAS_KEY_TEXT);
        } else {
            return "No title";
        }
    }
}

