package com.wkcof.fbconnect;

import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.Facebook.DialogListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class FbConnectActivity extends Activity {
	Facebook facebook = new Facebook("293614224018917");
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        facebook.authorize(this, new String[]{"email","publish_checkins"}, new DialogListener(){
        	@Override
        	public void onComplete(Bundle values){}
        	@Override 
        	public void onFacebookError(FacebookError error){}
        	@Override
        	public void onError(DialogError e) {}
        	@Override 
        	public void onCancel(){}
        }
        );
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	super.onActivityResult(requestCode, resultCode, data);
    	
    	facebook.authorizeCallback(requestCode, resultCode, data);
    }
}