package com.lfoliveira.lasalle.exampleexam;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class StorageFragment extends Fragment implements View.OnClickListener {

    int index = 0;
    TextView textViewValue;

    public StorageFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btnMore = getView().findViewById(R.id.btnMore);
        Button btnLess = getView().findViewById(R.id.btnLess);
        textViewValue = getView().findViewById(R.id.textViewValue);
        btnLess.setOnClickListener(this);
        btnMore.setOnClickListener(this);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_storage, container, false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnMore:

                index = index + 1;
                textViewValue.setText(Integer.toString(index));
                break;
            case R.id.btnLess:

                if (index <= 0){
                    return;
                } else {
                    index = index - 1;
                }

                textViewValue.setText(Integer.toString(index));

                break;

        }
    }


    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        index = sharedPref.getInt("index", 0);

        textViewValue.setText(Integer.toString(index));

    }

    @Override
    public void onPause() {
        super.onPause();

        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        sharedPref.edit().putInt("index", index).commit();
    }
}
