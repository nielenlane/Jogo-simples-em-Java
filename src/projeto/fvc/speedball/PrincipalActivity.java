package projeto.fvc.speedball;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import projeto.fvc.speedball.R;


public class PrincipalActivity extends Activity{	
	
	MediaPlayer musica;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        //setContentView(new MainGameView(this));
	        setContentView(R.layout.activity_principal);
	        barra();
	    }
	 
	 public void barra(){
			ActionBar barra = getActionBar();
			barra.hide();	
		}
	 
	 public void btJogar(View v){
		 musica = MediaPlayer.create(this, R.raw.click);
		 musica.start();
		 
		 Intent troca = new Intent(PrincipalActivity.this, MainGameActivity.class);
		 startActivity(troca);
		 finish();		
		 
	 }
	 
	 public void btAjuda(View v){
		 musica = MediaPlayer.create(this, R.raw.click);
		 musica.start();	 
		 
		 AlertDialog.Builder ajuda = new AlertDialog.Builder(this);
		ajuda.setTitle("Ajuda");
		ajuda.setIcon(R.drawable.ic_launcher);
		ajuda.setMessage("Seu objetivo é clicar nas bolinhas "+
		"da cor de acordo com o que vai "+
				"aparecer no topo da tela, a medida "
		+"que você vai clicando, mais rápido "+
				"as bolinhas vão ficar, se clicar "+ ""
						+ "na bolinha errada é GameOver. Boa sorte!");
		
		ajuda.setPositiveButton("OK", new DialogInterface.OnClickListener()
		 {@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(PrincipalActivity.this, "É hora de Jogar !",
						Toast.LENGTH_SHORT).show();
			}
		});
		
		ajuda.show();
	 }
	 
	 public void btScore(View v){
		 musica = MediaPlayer.create(this, R.raw.click);
		 musica.start();		 
		
	 }
}
