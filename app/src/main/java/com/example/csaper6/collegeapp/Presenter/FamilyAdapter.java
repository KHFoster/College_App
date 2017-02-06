package com.example.csaper6.collegeapp.Presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.csaper6.collegeapp.Model.Person;
import com.example.csaper6.collegeapp.R;

import java.util.List;

/**
 * Created by csaper6 on 2/6/17.
 */
public class FamilyAdapter extends ArrayAdapter<Person> {

    public FamilyAdapter(Context context, List<Person> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //if not given a view we need to make one
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_fam, null);
        }
        //get the item at the position where we are
        Person familyMember = getItem(position);

        //wire up our view
        TextView FnameText = (TextView) convertView.findViewById(R.id.text_Fname);
        TextView LnameText = (TextView) convertView.findViewById(R.id.text_Lname);


        //put the text of the hero into the appropriate views
        FnameText.setText(familyMember.getFirstName());
        LnameText.setText(familyMember.getLastName());

        //return the vie that you edited
        return convertView;
    }
}
