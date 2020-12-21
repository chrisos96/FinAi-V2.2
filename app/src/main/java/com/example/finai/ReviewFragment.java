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

import org.w3c.dom.Text;

public class ReviewFragment extends Fragment {


    EditText Rev_mail;
    EditText StarRating;
    EditText Review;
    Button Submit_rev;

    FirebaseDatabase rootNode;
    DatabaseReference reference;


    public ReviewFragment(){

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        Rev_mail = (EditText) view.findViewById(R.id.email_review);
        StarRating = (EditText) view.findViewById(R.id.app_rating);
        Review = (EditText) view.findViewById(R.id.app_review);
        Submit_rev = (Button) view.findViewById(R.id.submit_review);


        Submit_rev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Review");

                String memail = Rev_mail.getEditableText().toString().trim();
                String mrate = StarRating.getEditableText().toString().trim();
                String mreview = Review.getEditableText().toString().trim();

                if (TextUtils.isEmpty((mrate))) {
                    Rev_mail.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty((mrate))) {
                    StarRating.setError("Rating is Required");
                    return;
                }

                if (!(mrate.equals("1") || (mrate.equals("2")) || (mrate.equals("3")) || (mrate.equals("4")) || (mrate.equals("5")))){
                    StarRating.setError("Rating must be between 1-5 stars");
                }
                if (TextUtils.isEmpty(mreview)) {
                    Review.setError("Review is Required");
                    return;
                }


                if (TextUtils.isEmpty((mrate)) || TextUtils.isEmpty((mreview)) || TextUtils.isEmpty(memail) || (!(mrate.equals("1") || (mrate.equals("2")) || (mrate.equals("3")) || (mrate.equals("4")) || (mrate.equals("5"))))){
                    Review.setError("Error! Make sure all fields are filled in properly");
                }
                else{
                    ReviewFormDatabaseHelper helper = new ReviewFormDatabaseHelper(memail,mrate,mreview);
                    reference.child(mreview).setValue(helper);
                    Toast.makeText(getActivity(),"Review submitted!",Toast.LENGTH_SHORT).show();
                    Rev_mail.setText("");
                    StarRating.setText("");
                    Review.setText("");

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
        return inflater.inflate(R.layout.fragment_review,container,false);

    }
}
