package org.techtown.project_elect;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;


public class MajorFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    public MajorFragment() {
        // Required empty public constructor
    }

    private ArrayAdapter univAdapter;
    private ArrayAdapter majorAdapter;
    private Spinner univSpinner;
    private Spinner majorSpinner;
    private RadioButton a;
    private RadioButton b;
    private int[] Uni = {R.array.major_management, R.array.major_agriculture, R.array.major_animal,
            R.array.major_edu, R.array.major_social, R.array.major_it, R.array.major_veterinary, R.array.major_natural, R.array.major_humanities, R.array.major_caluture, R.array.major_dendrology};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        univSpinner = (Spinner) getView().findViewById(R.id.univSpinner);
        majorSpinner = (Spinner) getView().findViewById(R.id.majorSpinner);
        a = getView().findViewById(R.id.radioButton1);
        b = getView().findViewById(R.id.radioButton2);
        final Button searching_btn = (Button) getView().findViewById(R.id.search_btn);
        univAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.University, android.R.layout.simple_selectable_list_item);
        univSpinner.setAdapter(univAdapter);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                univSpinner.setVisibility(View.VISIBLE);
                majorSpinner.setVisibility(View.VISIBLE);
                searching_btn.setVisibility(View.VISIBLE);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                univSpinner.setVisibility(View.GONE);
                majorSpinner.setVisibility(View.GONE);
                searching_btn.setVisibility(View.GONE);
            }
        });
        univSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                majorAdapter = ArrayAdapter.createFromResource(getActivity(), Uni[position], android.R.layout.simple_spinner_item);
                majorSpinner.setAdapter(majorAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        searching_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_major, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    */
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
