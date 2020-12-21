package com.example.finai;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SupportFragment extends Fragment {

    EditText Fullname;
    EditText Email;
    EditText Phone;
    EditText Address;
    EditText Postcode;
    EditText Query;
    Button Submit_Form;

    FirebaseDatabase rootNode;
    DatabaseReference reference;


    public SupportFragment() {

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Fullname = (EditText) view.findViewById(R.id.Sfullname);
        Email = (EditText) view.findViewById(R.id.Semail);
        Phone = (EditText) view.findViewById(R.id.Sphone);
        Address = (EditText) view.findViewById(R.id.Saddress);
        Postcode = (EditText) view.findViewById(R.id.Spostcode);
        Query = (EditText) view.findViewById(R.id.Squery);
        Submit_Form = (Button) view.findViewById(R.id.submit_form);



        Submit_Form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Support");

                String fullname = Fullname.getEditableText().toString().trim();
                String email = Email.getEditableText().toString().trim();
                String phone = Phone.getEditableText().toString().trim();
                String address = Address.getEditableText().toString().trim();
                String postcode = Postcode.getEditableText().toString().trim();
                String query = Query.getEditableText().toString().trim();

                if (TextUtils.isEmpty(fullname)) {
                    Fullname.setError("Fullname is Required");
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Email.setError("Email is Required");
                    return;
                }

                if (TextUtils.isEmpty(address)) {
                    Address.setError("Address is Required");
                    return;
                }
                if (TextUtils.isEmpty(postcode)) {
                    Postcode.setError("Postcode is Required");
                    return;
                }
                if (TextUtils.isEmpty(query)) {
                    Query.setError("Query is Required");
                    return;
                }

                if (TextUtils.isEmpty((fullname)) || TextUtils.isEmpty((email)) || TextUtils.isEmpty((address)) || TextUtils.isEmpty((postcode)) || TextUtils.isEmpty((query))){
                    Query.setError("Error! Make sure all fields are filled in");
                }
                else{
                    SupportFormDatabaseHelper helper = new SupportFormDatabaseHelper(fullname,email,phone,address,postcode,query);
                    reference.child(phone).setValue(helper);
                    Toast.makeText(getActivity(),"Form submitted!",Toast.LENGTH_SHORT).show();
                    Fullname.setText("");
                    Email.setText("");
                    Phone.setText("");
                    Address.setText("");
                    Postcode.setText("");
                    Query.setText("");
                }
            }
        });


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_support,container,false);
        

    }



}


