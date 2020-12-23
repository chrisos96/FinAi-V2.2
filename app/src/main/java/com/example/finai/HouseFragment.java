package com.example.finai;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HouseFragment extends Fragment {

    EditText house_id;
    EditText price;
    EditText bedrooms;
    EditText bathrooms;
    EditText sqft_living;
    EditText sqft_lot;
    EditText floors;
    EditText waterfront;
    EditText house_view;
    EditText condition;
    EditText grade;
    EditText sqft_above;
    EditText sqft_basement;
    EditText year_built;
    EditText year_renovated;
    Button submit_house;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    public HouseFragment() {

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        house_id = (EditText) view.findViewById(R.id.House_id);
        price = (EditText) view.findViewById(R.id.Price);
        bedrooms = (EditText) view.findViewById(R.id.Bedrooms);
        bathrooms = (EditText) view.findViewById(R.id.Bathrooms);
        sqft_living = (EditText) view.findViewById(R.id.SQFT_living);
        sqft_lot = (EditText) view.findViewById(R.id.SQFT_lot);
        floors = (EditText) view.findViewById(R.id.Floors);
        waterfront = (EditText) view.findViewById(R.id.Waterfront);
        house_view = (EditText) view.findViewById(R.id.House_view);
        condition = (EditText) view.findViewById(R.id.Condition);
        grade = (EditText) view.findViewById(R.id.Grade);
        sqft_above = (EditText) view.findViewById(R.id.SQFT_above);
        sqft_basement = (EditText) view.findViewById(R.id.SQFT_basement);
        year_built = (EditText) view.findViewById(R.id.Year_built);
        year_renovated = (EditText) view.findViewById(R.id.Year_renovated);
        submit_house = (Button) view.findViewById(R.id.Submit_loan);

        submit_house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("HouseSpecification");

                String shouse_id = house_id.getEditableText().toString().trim();
                int sprice = Integer.parseInt(price.getEditableText().toString().trim());
                int sbedrooms = Integer.parseInt(bedrooms.getEditableText().toString().trim());
                int sbathrooms = Integer.parseInt(bathrooms.getEditableText().toString().trim());
                int ssqft_living = Integer.parseInt(sqft_living.getEditableText().toString().trim());
                int ssqft_lot = Integer.parseInt(sqft_lot.getEditableText().toString().trim());
                int sfloors = Integer.parseInt(floors.getEditableText().toString().trim());
                int swaterfront = Integer.parseInt(waterfront.getEditableText().toString().trim());
                int shouse_view = Integer.parseInt(house_view.getEditableText().toString().trim());
                int scondition = Integer.parseInt(condition.getEditableText().toString().trim());
                int sgrade = Integer.parseInt(grade.getEditableText().toString().trim());
                int ssqft_above = Integer.parseInt(sqft_above.getEditableText().toString().trim());
                int ssqft_basement = Integer.parseInt(sqft_basement.getEditableText().toString().trim());
                int syear_built = Integer.parseInt(year_built.getEditableText().toString().trim());
                int syear_renovated = Integer.parseInt(year_renovated.getEditableText().toString().trim());

                if (shouse_id.equals("")) {
                    house_id.setError("Field must not be empty");
                }
                if (String.valueOf(sprice).equals("")) {
                    price.setError("Field must not be empty");
                }
                if (String.valueOf(sbedrooms).equals("")) {
                    bedrooms.setError("Field must not be empty");
                }
                if (String.valueOf(sbathrooms).equals("")) {
                    bathrooms.setError("Field must not be empty");
                }
                if (String.valueOf(ssqft_living).equals("")) {
                    sqft_living.setError("Field must not be empty");
                }
                if (String.valueOf(ssqft_lot).equals("")) {
                    sqft_lot.setError("Field must not be empty");
                }
                if (String.valueOf(sfloors).equals("")) {
                    floors.setError("Field must not be empty");
                }
                if (String.valueOf(swaterfront).equals("")) {
                    waterfront.setError("Field must not be empty");
                }
                if (String.valueOf(shouse_view).equals("")) {
                    house_view.setError("Field must not be empty");
                }
                if (String.valueOf(scondition).equals("")) {
                    condition.setError("Field must not be empty");
                }
                if (String.valueOf(sgrade).equals("")) {
                    grade.setError("Field must not be empty");
                }
                if (String.valueOf(ssqft_above).equals("")) {
                    sqft_above.setError("Field must not be empty");
                }
                if (String.valueOf(ssqft_basement).equals("")) {
                    sqft_basement.setError("Field must not be empty");
                }
                if (String.valueOf(syear_built).equals("")) {
                    year_built.setError("Field must not be empty");
                }
                if (String.valueOf(syear_renovated).equals("")) {
                    year_renovated.setError("Field must not be empty");
                } else {
                    HouseFormDatabaseHelper helper = new HouseFormDatabaseHelper(shouse_id, sprice, sbedrooms, sbathrooms, ssqft_living, ssqft_lot, sfloors, swaterfront, shouse_view, scondition, sgrade, ssqft_above, ssqft_basement,syear_built,syear_renovated);
                    reference.child(shouse_id).setValue(helper);
                    Toast.makeText(getActivity(), "House Spec Form submitted!", Toast.LENGTH_SHORT).show();
                    house_id.setText("");
                    price.setText("");
                    bedrooms.setText("");
                    bathrooms.setText("");
                    sqft_living.setText("");
                    sqft_lot.setText("");
                    floors.setText("");
                    waterfront.setText("");
                    house_view.setText("");
                    condition.setText("");
                    grade.setText("");
                    sqft_above.setText("");
                    sqft_basement.setText("");
                    year_built.setText("");
                    year_renovated.setText("");
                }
            }
        });
    }

        @Override
        public void onCreate (@Nullable Bundle savedInstanceState){
            super.onCreate(savedInstanceState);


        }

        @Nullable
        @Override
        public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
            return inflater.inflate(R.layout.fragment_house, container, false);


        }


    }

