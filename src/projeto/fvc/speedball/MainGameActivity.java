package projeto.fvc.speedball;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class MainGameActivity extends Activity {
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);	        
	        setContentView(new MainGameView(this));
	        barra();
	    }
	 
	 public void barra(){
			ActionBar barra = getActionBar();
			barra.hide();	
		}
}
