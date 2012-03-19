package cs.android.aug.mn.sampleapp;

import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class SecondaryActivity extends Activity{

	private TextView textview_One = null;
	private TextView textview_Two = null;
	private EditText edittext_DataEntry = null;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    	try{
    			
    		setContentView(R.layout.secondary);
    		
    		// get ui elements wire up events as necessary
    		this.textview_One = (TextView) this.findViewById(R.id.textview_One);
    		this.textview_Two = (TextView) this.findViewById(R.id.textview_Two);
    		this.edittext_DataEntry = (EditText) this.findViewById(R.id.edittext_DataEntry);
    		Button button_one = (Button) this.findViewById(R.id.button_Ok);
    		button_one.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {	
					Intent i = SecondaryActivity.this.getIntent();
					Bundle bundle = SecondaryActivity.this.getIntent().getExtras();
					bundle.putString("update_value", SecondaryActivity.this.edittext_DataEntry.getText().toString());	
					i.putExtras(bundle);
					SecondaryActivity.this.setResult(RESULT_OK,i);
		    		finish();		
				}
			});
    		
    		Button button_two = (Button)this.findViewById(R.id.button_Cancel);
    		button_two.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					SecondaryActivity.this.setResult(RESULT_CANCELED);
			    	finish();
					
				}
			});
    		
    		
    		// get the intent and all its attribute data
    		String action = this.getIntent().getAction();
    		Uri uri = this.getIntent().getData();
    		Set<String> categories = this.getIntent().getCategories();
    		String type = this.getIntent().getType();
    		//Component
    		Bundle bundle = this.getIntent().getExtras();
    		String text_one = bundle.getString("text_one");
    		String text_two = bundle.getString("text_two");
    		
    		this.textview_One.setText(text_one);
    		this.textview_Two.setText(text_two);
    		
    		
    	}catch(Exception e){
    		Log.e(this.toString(),"[onResume] "+e.getMessage());
    	}
        Log.i(this.toString(),"onCreate");
    }
    
    @Override
    protected void onStart(){
    	Log.i(this.toString(),"onStart");
    	super.onStart();
    }
    
    @Override
    protected void onResume(){
    	Log.i(this.toString(),"onResume");
    	super.onResume();
    	
    }
    
    @Override
    protected void onPause(){
    	Log.i(this.toString(),"onPause");
    	super.onPause();
    }
    
    @Override
    protected void onStop(){
    	Log.i(this.toString(),"onStop");
    	super.onStop();
    }
    
    @Override
    protected void onDestroy(){
    	Log.i(this.toString(),"onDestroy");
    	super.onDestroy();
    }
    
    

	
}
