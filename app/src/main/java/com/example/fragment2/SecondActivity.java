package com.example.fragment2;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener ,MessageFragment2.MessageClickListener,ContactsFragment2.ContactClickListener{

    private MessageFragment2 messageFragment2;
    private ContactsFragment2 contactsFragment2;
    private NewsFragment2 newsFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String bunStr=getIntent().getStringExtra(MessageFragment2.ARG_PARAM1);
        messageFragment2=MessageFragment2.newInstance(bunStr);
        contactsFragment2=new ContactsFragment2();
        newsFragment2=new NewsFragment2();

        getFragmentManager().beginTransaction().replace(R.id.mytitle,messageFragment2,"message").commit();

    }


    @Override
    public void onContactClick() {
        if (newsFragment2==null) {
            newsFragment2=new NewsFragment2();
        }
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.hide(contactsFragment2);
        transaction.add(R.id.mytitle,newsFragment2,"news");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onMessageClick() {
        if (contactsFragment2==null) {
            contactsFragment2=new ContactsFragment2();
            contactsFragment2.setContactClickListener(this);
        }
        FragmentManager fm=getFragmentManager();
        FragmentTransaction transaction=fm.beginTransaction();
        transaction.replace(R.id.mytitle,contactsFragment2,"contact");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {

    }
}
