package com.example.csaper6.collegeapp.Presenter;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.csaper6.collegeapp.Model.Guardian;
import com.example.csaper6.collegeapp.Model.Person;
import com.example.csaper6.collegeapp.Model.Sibling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by csaper6 on 2/6/17.
 */
public class FamilyListFragent extends ListFragment {
    private List<Person> familyMembers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        
        familyMembers = new ArrayList<>();
        populateList();

        FamilyAdapter adapter= new FamilyAdapter(getActivity(), familyMembers);

        //set the listView's adapter
        setListAdapter(adapter);
        
        return rootView;
    }

    private void populateList() {
        familyMembers.add(new Guardian("Dat","Boy", 21, "Playa"));
        familyMembers.add(new Sibling("Hummie","Bigboi",43,"Unemployed"));
        familyMembers.add(new Guardian("Spencer","Burley", 19, "Physical Therapist"));
        familyMembers.add(new Sibling("Keric","Ew", 9, "Gro Penji"));
        familyMembers.add(new Guardian("Boseph","Jew", 28, "Accountant"));
    }
}
