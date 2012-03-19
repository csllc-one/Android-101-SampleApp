package cs.android.aug.mn.sampleapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;


public class MainActivity extends Activity {
    
	private TextView textview_One = null;
	private TextView textview_Two = null;
	private EditText edittext_DataEntry = null;
	private static final int SECONDARY_RESULT = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(this.toString(),"onCreate");
        
        try{
			
    		setContentView(R.layout.main);
    		
    		// get ui elements wire up events as necessary
    		textview_One = (TextView) findViewById(R.id.textview_One);
    		textview_Two = (TextView) findViewById(R.id.textview_Two);
    		edittext_DataEntry = (EditText) findViewById(R.id.edittext_DataEntry);
    		
    		Button button_one = (Button) this.findViewById(R.id.button_one);
    		button_one.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					textview_Two.setText(textview_One.getText());
					textview_One.setText(edittext_DataEntry.getText());		
					edittext_DataEntry.setText("");
				}
			});
    		
    		Button button_two = (Button)this.findViewById(R.id.button_two);
    		button_two.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					
					Intent i = new Intent(MainActivity.this, SecondaryActivity.class);
					Bundle bundle = new Bundle();
					bundle.putString("text_one", textview_One.getText().toString());
					bundle.putString("text_two", textview_Two.getText().toString());
					i.putExtras(bundle);
					//startActivity(i);
					startActivityForResult(i,SECONDARY_RESULT);
				}
			});
    		
    	}catch(Exception e){
    		Log.e(this.toString(),"[onCreate] "+e.getMessage());
    	}
        
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
    
    @Override
    public void onActivityResult(int code, int result, Intent data){
    	
    	
    	switch(code){
	    	case SECONDARY_RESULT:{
	    		if(result == Activity.RESULT_OK){
	    			Bundle bundle = data.getExtras();
	    			String text_value = bundle.getString("update_value");	
	    			MainActivity.this.edittext_DataEntry.setText(text_value);
	    			String text_value_one = bundle.getString("text_one");	
	    			String text_value_two = bundle.getString("text_two");
	    			MainActivity.this.textview_One.setText(text_value_two);	    				
	    			MainActivity.this.textview_Two.setText(text_value_one);
	    			
	    			break;
	    		}
	    		
	    		
	    	}
    	
    	}
    	
    }



}