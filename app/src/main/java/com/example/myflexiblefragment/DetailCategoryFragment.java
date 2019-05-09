package com.example.myflexiblefragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailCategoryFragment extends Fragment implements View.OnClickListener {
    public static String EXTRA_NAME = "extra_name";
    public static String ETRA_DESCRIPTION = "extra_dscription";
    TextView tvCategoryName, getTvCategoryDescription;
    Button btnProfile, btnShowDialog;
    private String desctiption;

    public DetailCategoryFragment() {
        // Required empty public constructor
    }

    public String getDesctiption() {
        return desctiption;
    }

    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCategoryName = view.findViewById(R.id.tv_category_name);
        getTvCategoryDescription = view.findViewById(R.id.tv_category_description);
        btnProfile = view.findViewById(R.id.btn_profile);
        btnProfile.setOnClickListener(this);
        btnShowDialog = view.findViewById(R.id.btn_show_dialog);
        btnShowDialog.setOnClickListener(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String categoryName = getArguments().getString(EXTRA_NAME);
        tvCategoryName.setText(categoryName);
        getTvCategoryDescription.setText(getDesctiption());
    }

    OptionDialogFragment.OnOptionDialogListener onOptionDialogListener = new OptionDialogFragment.OnOptionDialogListener() {
        @Override
        public void onOptionChosen(String text) {
            Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_profile:
                Intent mIntent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btn_show_dialog:
                OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment();

                FragmentManager mFragmentManager = getChildFragmentManager();
                mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment.class.getSimpleName());
                break;
        }
    }
}
