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
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MajorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MajorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MajorFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    public MajorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MajorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MajorFragment newInstance(String param1, String param2) {
        MajorFragment fragment = new MajorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private ArrayAdapter univAdapter;
    private ArrayAdapter majorAdapter;
    private Spinner univSpinner;
    private Spinner majorSpinner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        univSpinner = (Spinner)getView().findViewById(R.id.univSpinner);
        majorSpinner = (Spinner)getView().findViewById(R.id.majorSpinner);
        univAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.University, android.R.layout.simple_selectable_list_item);
        univSpinner.setAdapter(univAdapter);

        univSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedUniv = univSpinner.getSelectedItem().toString();
                if(selectedUniv.equals("IT대학")){
                    majorAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.major_it, android.R.layout.simple_spinner_item);
                    majorSpinner.setAdapter(majorAdapter);
                }
                else if(selectedUniv.equals("사범대학")){
                    majorAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.major_edu, android.R.layout.simple_spinner_item);
                    majorSpinner.setAdapter(majorAdapter);
                }
                else if(selectedUniv.equals("경영대학")){
                    majorAdapter = ArrayAdapter.createFromResource(getActivity(), R.array.major_management, android.R.layout.simple_spinner_item);
                    majorSpinner.setAdapter(majorAdapter);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Button searching_btn = (Button)getView().findViewById(R.id.search_btn);
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
