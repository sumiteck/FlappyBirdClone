package com.sumiteck.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class FlappyBird extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture[] bird;
	Texture topTube;
	Texture bottomTube;
	float birdY = 0;
	int flapstate = 0;
	float velocity = 0;
	int gameState = 0;
	float gravity = 2;
	int gap = 200;
	float maxTubeOfset;
	Random random;
	float pipevelocity = 4;
	int numberOfPipes = 4;
	float[] tubex= new float[numberOfPipes];
	float[] tubeoffset = new float[numberOfPipes];

	float distancebtwpipe;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("bg.png");
		bird = new Texture[2];
		bird[0] = new Texture("bird.png");
		bird[1] = new Texture("bird2.png");
		topTube = new Texture("toptube.png");
		bottomTube = new Texture("bottomtube.png");
		birdY = Gdx.graphics.getHeight()/2 - bird[0].getHeight()/2;
		maxTubeOfset = Gdx.graphics.getHeight()/2 - gap/2 - 100;
		random = new Random();
		distancebtwpipe = Gdx.graphics.getWidth()/2;
		for(int i = 0 ; i< numberOfPipes ; i++) {
			tubeoffset[i] = (random.nextFloat()-0.5f) * (Gdx.graphics.getHeight()- gap - 100);
			tubex[i] = Gdx.graphics.getWidth() / 2 - topTube.getWidth() + i * distancebtwpipe;


		}

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
			for(int i = 0 ; i< numberOfPipes ; i++) {
				if (tubex[i] < -topTube.getWidth()) {
					tubex[i] += numberOfPipes * distancebtwpipe;
				} else {
					tubex[i] = tubex[i] - pipevelocity;
					batch.begin();
					batch.draw(topTube, tubex[i], Gdx.graphics.getHeight() / 2 + gap / 2 + tubeoffset[i]);
					batch.draw(bottomTube, tubex[i], Gdx.graphics.getHeight() / 2 - gap - bottomTube.getHeight() + tubeoffset[i]);
					batch.end();
				}
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
