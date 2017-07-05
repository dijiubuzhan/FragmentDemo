package com.example.fragment2;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MessageFragment2 extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG ="MessageFragment2[]" ;
    private LinearLayout m_layout;

    @Override
    public void onClick(View v) {
        if (getActivity() instanceof MessageClickListener) {
            ((MessageClickListener)getActivity()).onMessageClick();
        }
    }

    interface MessageClickListener{
        void onMessageClick();
    }

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public static MessageFragment2 newInstance(String param1) {
        Log.d(TAG,"newInstance() ");
        MessageFragment2 fragment = new MessageFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate() "+(getArguments() != null));
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG,"onCreateView() ");
        View view=inflater.inflate(R.layout.message_layout, container, false);
        m_layout= (LinearLayout) view.findViewById(R.id.message_layout);
        TextView txt= (TextView) m_layout.findViewById(R.id.txt);
        txt.setText(mParam1);
        m_layout.setOnClickListener(this);
        return view;
    }

}
