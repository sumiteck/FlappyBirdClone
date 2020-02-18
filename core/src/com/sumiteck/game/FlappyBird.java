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
	int flapstate = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Texture("bg.png");
		bird = new Texture[2];
		bird[0] = new Texture("bird.png");
		bird[1] = new Texture("bird2.png");


	}

	@Override
	public void render () {
		if(flapstate==0){
			flapstate = 1;
		}else {
			flapstate = 0;
		}
		batch.begin();
		batch.draw(background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		batch.draw((bird[flapstate]) ,Gdx.graphics.getWidth()/2  ,Gdx.graphics.getHeight()/2);
		batch.end();

	}
	
	@Override
	public void dispose () {

	}
}
