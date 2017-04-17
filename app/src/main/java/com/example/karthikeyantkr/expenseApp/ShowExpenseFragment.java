package com.example.karthikeyantkr.expenseApp;

/*
InClass08
InClass08
Karthikeyan TKR

*/

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowExpenseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShowExpenseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowExpenseFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ShowExpenseFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShowExpenseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShowExpenseFragment newInstance(String param1, String param2) {
        ShowExpenseFragment fragment = new ShowExpenseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<Expense> expenses=mListener.getexpenselist();
        String pos = getArguments().getString("pos");
        View view=inflater.inflate(R.layout.fragment_show_expense, container, false);

        TextView name= (TextView) view.findViewById(R.id.textView_nameData);
        TextView date = (TextView) view.findViewById(R.id.textView_dateData);
        TextView category = (TextView) view.findViewById(R.id.textView_categoryData);
        TextView amt = (TextView) view.findViewById(R.id.textView_amountData);
Button close= (Button) view.findViewById(R.id.buttonCloseExpense);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.container_main, new ExpenseAppFragment(), "second").addToBackStack(null).commit();
            }
        });
        Expense first_exp=expenses.get(Integer.parseInt(pos));
        name.setText(first_exp.getExpName());
        date.setText(first_exp.getDate());
        category.setText(first_exp.getCategory());
        amt.setText(first_exp.getAmount());

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
        public ArrayList<Expense> getexpenselist();
    }
}
