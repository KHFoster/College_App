package com.example.csaper6.collegeapp.Presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.csaper6.collegeapp.Model.Guardian;
import com.example.csaper6.collegeapp.R;

/**
 * Created by csaper6 on 12/13/16.
 */
public class GuardianFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_guardian,container,false);


        //wire our widgets
        EditText editFirstName = (EditText) rootView.findViewById(R.id.name_guardian);
        EditText editLastName = (EditText) rootView.findViewById(R.id.lname_guardian);
        EditText editOccupation = (EditText) rootView.findViewById(R.id.occupation_text);
        Log.d("TAG", "editFirstName:"+ (editFirstName == null));

        //get information from the model layer
        Guardian g = new Guardian("Dare-It", "Morre", 123, "Stuntman");

        //put the information in the view layer
        //set the text for your editTexts with the info you get from the object you made
        editFirstName.setText(g.getFirstName());
        editLastName.setText(g.getLastName());
        editOccupation.setText(g.getOccupation());


        return rootView;    }
}
