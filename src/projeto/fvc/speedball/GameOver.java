package projeto.fvc.speedball;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import projeto.fvc.speedball.R;

public class GameOver extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);        
        barra();
    }
 
	public void barra(){
		ActionBar barra = getActionBar();
		barra.hide();	
	}

}
