package com.passingdatabetweenfragment.ca;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {


    SendMessage sendMessage;

    public OneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btPassData = (Button) view.findViewById(R.id.btPassData);
        final EditText etMessage = (EditText) view.findViewById(R.id.etMessage);

        btPassData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage.sendData(etMessage.getText().toString().trim());
            }
        });

    }


    interface SendMessage {
        void sendData(String message);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            sendMessage = (SendMessage) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException("Error in retrieving data. Please try again");
        }
    }
}
