package com.columnhack.dm;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    // we can only use this when our fragment is attached to the activity
    private onFragmentBtnSelected listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button goToSecondFragment = view.findViewById(R.id.main_button);
        goToSecondFragment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                listener.onButtonSelected();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof onFragmentBtnSelected){
            listener = (onFragmentBtnSelected) context;
        } else {
            throw new ClassCastException(context.toString() + "must implement listener interface");
        }

    }

    public interface onFragmentBtnSelected{
        public void onButtonSelected();
    }
}
