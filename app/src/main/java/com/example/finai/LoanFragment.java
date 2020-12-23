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

public class LoanFragment extends Fragment {

    EditText loan_id;
    EditText gender;
    EditText married;
    EditText dependents;
    EditText education;
    EditText self_employed;
    EditText applicant_income;
    EditText co_applicant_income;
    EditText loan_amount;
    EditText credit_history;
    EditText property_area;
    Button submit_loan;

    FirebaseDatabase rootNode;
    DatabaseReference reference;


    public LoanFragment(){

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        loan_id = (EditText) view.findViewById(R.id.Loan_id);
        gender = (EditText) view.findViewById(R.id.Gender);
        married = (EditText) view.findViewById(R.id.Married);
        dependents = (EditText) view.findViewById(R.id.Dependants);
        education = (EditText) view.findViewById(R.id.Education);
        self_employed = (EditText) view.findViewById(R.id.Self_Employed);
        applicant_income = (EditText) view.findViewById(R.id.ApplicantIncome);
        co_applicant_income = (EditText) view.findViewById(R.id.CoApplicantIncome);
        loan_amount = (EditText) view.findViewById(R.id.Loan_amount_term);
        credit_history = (EditText) view.findViewById(R.id.Credit_history);
        property_area = (EditText) view.findViewById(R.id.Property_area);
        submit_loan = (Button) view.findViewById(R.id.Submit_loan);

        submit_loan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Loan");

                String sloan_id = loan_id.getEditableText().toString().trim();
                int sgender = Integer.parseInt(gender.getEditableText().toString().trim());
                int smarried = Integer.parseInt(married.getEditableText().toString().trim());
                int sdependents = Integer.parseInt(dependents.getEditableText().toString().trim());
                int seducation = Integer.parseInt(education.getEditableText().toString().trim());
                int sself_employed = Integer.parseInt(self_employed.getEditableText().toString().trim());
                int sapplicant_income = Integer.parseInt(applicant_income.getEditableText().toString().trim());
                int sco_applicant_income = Integer.parseInt(co_applicant_income.getEditableText().toString().trim());
                int sloan_amount = Integer.parseInt(loan_amount.getEditableText().toString().trim());
                int scredit_history = Integer.parseInt(credit_history.getEditableText().toString().trim());
                int sproperty_area = Integer.parseInt(property_area.getEditableText().toString().trim());

                if (sloan_id.equals("")) {
                    loan_id.setError("Field must not be empty");
                }
                if (sgender > 2 || sgender < 0 || String.valueOf(sgender).equals("")){
                    gender.setError("Value must be either [0] or [1]");
                }
                if (smarried > 2 || smarried < 0 || String.valueOf(smarried).equals("")){
                    married.setError("Value must be either [0] or [1]");
                }
                if (sdependents > 2 || sdependents < 0 || String.valueOf(sdependents).equals("")){
                    dependents.setError("Value must be either [0] or [1]");
                }
                if (seducation > 2 || seducation < 0 || String.valueOf(seducation).equals("")){
                    education.setError("Value must be either [0] or [1]");
                }
                if (sself_employed > 2 || sself_employed < 0 || String.valueOf(sself_employed).equals("")){
                    self_employed.setError("Value must be either [0] or [1]");
                }
                if (sapplicant_income < 0 || String.valueOf(sapplicant_income).equals("")){
                    applicant_income.setError("Value must be greater than 0");
                }
                if (sco_applicant_income < 0 || String.valueOf(sco_applicant_income).equals("")) {
                    co_applicant_income.setError("Value must be >= 0");
                }
                if (sloan_amount < 0 || String.valueOf(sloan_amount).equals("")){
                    gender.setError("Value must be greater than 0");
                }
                if (scredit_history > 2 || scredit_history < 0 || String.valueOf(scredit_history).equals("")){
                    credit_history.setError("Value must be either [0] or [1]");
                }
                if (sproperty_area > 2 || sproperty_area < 0 || String.valueOf(sproperty_area).equals("")){
                    property_area.setError("Value must be either [0] or [1] or [2]");
                }

                else{
                    LoanFormDatabaseHelper helper = new LoanFormDatabaseHelper(sloan_id,sgender,smarried,sdependents,seducation,sself_employed,sapplicant_income,sco_applicant_income,sloan_amount,scredit_history,sproperty_area);
                    reference.child(sloan_id).setValue(helper);
                    Toast.makeText(getActivity(),"Loan Application Form submitted!",Toast.LENGTH_SHORT).show();
                    loan_id.setText("");
                    gender.setText("");
                    married.setText("");
                    dependents.setText("");
                    education.setText("");
                    self_employed.setText("");
                    applicant_income.setText("");
                    co_applicant_income.setText("");
                    loan_amount.setText("");
                    credit_history.setText("");
                    property_area.setText("");
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
        return inflater.inflate(R.layout.fragment_loan,container,false);


    }



}
