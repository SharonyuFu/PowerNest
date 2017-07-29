package com.codepath.powernest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.codepath.powernest.R;


public class FilterDialogFragment extends DialogFragment {
    private RadioButton radioType;
    private RadioButton radioTime;
    private RadioButton radioDistan;
    private Button btFilter;

    public FilterDialogFragment() {

    }

    public static FilterDialogFragment newInstance(String title) {
        FilterDialogFragment frag = new FilterDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_filter_dialog, container);

    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        radioTime = (RadioButton) view.findViewById(R.id.radioButton);
        radioType = (RadioButton) view.findViewById(R.id.radioButton2);
        radioDistan = (RadioButton) view.findViewById(R.id.radioButton3);
        btFilter = (Button) view.findViewById(R.id.btFilter);

        btFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

    }


}
