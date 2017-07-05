package com.example.fragment2;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class ContactsFragment2 extends Fragment implements View.OnClickListener{

    private LinearLayout m_layout;
    private ContactClickListener m_contactClickListener;

    @Override
    public void onClick(View v) {
        if (getActivity() instanceof ContactClickListener) {
            ((ContactClickListener)getActivity()).onContactClick();
        }
    }

    public void setContactClickListener(ContactClickListener contactClickListener){
        this.m_contactClickListener=contactClickListener;
    }

    public interface ContactClickListener{
        void onContactClick();
    }

    public ContactsFragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=inflater.inflate(R.layout.contacts_layout, container, false);
        m_layout= (LinearLayout) view.findViewById(R.id.Contact_layout);
        m_layout.setOnClickListener(this);
        return view;
    }


}
