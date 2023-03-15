package projeto.fvc.speedball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.R.color;
import android.R.integer;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.os.Parcelable.Creator;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import projeto.fvc.speedball.R;

import com.gdacarv.engine.androidgame.GameView;
import com.gdacarv.engine.androidgame.Sprite;

@SuppressLint("WrongCall")
public class MainGameView extends GameView{
	
	protected ArrayList<Bolinhas> bolinhas; //Lista as bolinhas.
	MediaPlayer musica;
	private Context context;
	Integer[] bolitas;
	Bitmap bitmapBolinhas;
	int limitBolinhasX ;
	int limitBolinhasY ;
	Random random;
	Resources res;
	Paint quadrado;
	int cor;
	private int pontos = 0;
	boolean inicio = false;
	Canvas canvas;
	Sprite background, gameover;
	Paint paintText;
	
	public MainGameView(Context context) {
		super(context);
		bolitas = new Integer[6];
		bolitas[0] = R.drawable.vermelho;
		bolitas[1] = R.drawable.azul;
		bolitas[2] = R.drawable.amarelo;
		bolitas[3] = R.drawable.branco;
		bolitas[4] = R.drawable.rosa;
		bolitas[5] = R.drawable.preto;
		quadrado = new Paint();
		inicio = true;
	}
	
	public void mudarCor(){
		int cor= 0;
		cor = random.nextInt(6);
		this.cor = cor;
		switch (cor) {
			case 0:{
				quadrado.setColor(Color.RED);
				break;
			}
			case 1:{
				quadrado.setColor(Color.BLUE);
				break;
			}
			case 2:{
				quadrado.setColor(Color.YELLOW);
				break;
			}
			case 3:{
				quadrado.setColor(Color.WHITE);
				break;
			}
			case 4:{
				quadrado.setColor(Color.MAGENTA);
				break;
			}
			case 5:{
				quadrado.setColor(Color.BLACK);
				break;
			}
		}
	}
	
	@Override
	public void TouchEvents(MotionEvent event) {	
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) { 
			int action = event.getAction();
			synchronized (getHolder()) {
				for (Bolinhas b : bolinhas){	
					if (action == MotionEvent.ACTION_DOWN) {
					if(b.isCollition(event.getX(), event.getY())){
						if(b.cor == cor){
							b.speedX++;
							b.speedY++;
							mudarCor();	
							pontos ++;
						}else if(b.cor != cor){													
							mSprites.add(gameover = new Sprite(BitmapFactory.decodeResource(res, R.drawable.gameover)));
							gameover.x = getWidth()/2 - gameover.width/2;
							gameover.y = getHeight()/2 - gameover.height/2;
							quadrado.setColor(color.transparent);
							//pontos--;
						}
					}
				}else if (action==MotionEvent.ACTION_UP) {
                    //soltou o dedo
	            } else if (action==MotionEvent.ACTION_MOVE) {
	                    //movimentou o dedo
	            }
			}
		}
		return super.onTouchEvent(event);
	}
	
	@Override
	protected void onLoad() {
		bolinhas = new ArrayList<Bolinhas>();
		random = new Random();
		res = getResources();
		for(int n= 0; n < 6; ++n){
			bitmapBolinhas = BitmapFactory.decodeResource(res,bolitas[n]);
			limitBolinhasX = getWidth()-bitmapBolinhas.getWidth();
			limitBolinhasY = getHeight()-bitmapBolinhas.getHeight();
			for(int i = 0; i < 5; i++){
				bolinhas.add(new Bolinhas(random.nextInt(limitBolinhasX), random.nextInt(limitBolinhasY), random, bitmapBolinhas, 1, 1,n));
			}			
		}			
		mSprites.add(background = new Sprite(BitmapFactory.decodeResource(res, R.drawable.parque)));
		mSprites.addAll(bolinhas);	// Adiciona bolinhas a lista de Sprites para serem desenhados e atualizados automaticamente.
	}
	
	@Override
	public void update(){
		super.update();
		for(Bolinhas bolinha : bolinhas){ // Para cada bolinha, verifica se ele chegou nas bordas da tela e muda de direção caso ocorra.
		 if(bolinha.x < 0 || bolinha.x > getWidth()-bolinha.width)
			 bolinha.speedX *= -1;			
		 	else if(bolinha.y < 10 || bolinha.y > getHeight()-bolinha.height-1)
		 		bolinha.speedY *= -1;	
		}	
	}
		
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if(inicio){
		inicio = false;
		quadrado = new Paint();
		quadrado.setColor(Color.BLUE);
		this.cor = 1;		
		}
		canvas.drawRect(0, 0, getWidth(), 30, quadrado);
		//Pontuação
		paintText = new Paint();
		canvas.drawText("Pontos: " + pontos, 1, 40, paintText);
		paintText.setColor(Color.BLACK);
        paintText.setTextSize(14);
        paintText.setTextAlign(Align.LEFT);
	}
} 


