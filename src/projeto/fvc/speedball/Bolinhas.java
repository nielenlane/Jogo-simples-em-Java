package projeto.fvc.speedball;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Paint;

import com.gdacarv.engine.androidgame.Sprite;

public class Bolinhas extends Sprite {
	
	public int speedX, speedY;
	int cor;
	
	public Bolinhas(int x, int y, Random random, Bitmap bmp, int bmp_rows, int bmp_columns,int cor) {
		super(bmp, bmp_rows, bmp_columns);		
		setAnimation(ANIM_GO); //Seta a animação apenas como "ida" (ciclíca).
		speedX = random.nextInt(7) - 0; //Velocidade horizontal de -3 a 3.
		speedY = random.nextInt(7) - 0; //Velocidade vertical de -3 a 3.
		this.x = x;
		this.y = y;
		this.cor =cor;
	}		
	
	@Override
	public void update() { //Anda
		super.update();
		x += speedX;
		y += speedY;
	}
	
	public void mudaCor(){
		
	}

	public boolean isCollition(float x2, float y2){ 
		return x2 >= x && x2 <= x + width && y2 >= y && y2 <= y + height;		
	}
}
