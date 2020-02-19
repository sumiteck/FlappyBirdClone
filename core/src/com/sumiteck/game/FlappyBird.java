package com.sumiteck.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FlappyBird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture[] bird;
	float birdY = 0;
	int flapstate = 0;
	float velocity = 0;
	int gameState = 0;
	float gravity = 2;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("bg.png");
		bird = new Texture[2];
		bird[0] = new Texture("bird.png");
		bird[1] = new Texture("bird2.png");
		birdY = Gdx.graphics.getHeight()/2 - bird[0].getHeight()/2;



	}

	@Override
	public void render () {


		batch.begin();
		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw((bird[flapstate]), Gdx.graphics.getWidth() / 2, birdY);
		batch.end();
		if (gameState != 0) {
			if (Gdx.input.justTouched()) {
				Gdx.app.log("Screen Touched", "Yes");
				velocity = -30;
			}
			if (birdY > 0 || velocity < 0) {
				velocity = velocity + gravity;
				birdY -= velocity;
			}
		}else {
				if (Gdx.input.justTouched()) {
					Gdx.app.log("Screen Touched", "Yes");
					gameState = 1;
				}
			}

			if (flapstate == 0) {
				flapstate = 1;
			} else {
				flapstate = 0;
			}


		}
	
	
	@Override
	public void dispose () {

	}
}
