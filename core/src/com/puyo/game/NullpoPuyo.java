package com.puyo.game;

import java.util.HashMap;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;

public class NullpoPuyo extends ApplicationAdapter {
	//Initializes the variables required for graphics
	final HashMap<String, Sprite> sprites = new HashMap<>();

	SpriteBatch batch;
	TextureAtlas textureAtlas;
	OrthographicCamera camera;
	ExtendViewport viewport;



	@Override
	public void create() {
		//Instantiates the variables required for graphics
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas("sprites.txt");
		addSprites();
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(1920, 1080, camera);
		//Get resolution of current display
		Graphics.DisplayMode mode = Gdx.graphics.getDisplayMode();
		//Change res to native fullscreen
		Gdx.graphics.setFullscreenMode(mode);
	}

	@Override
	public void render() {
		//Renders the backgroud and sprites of the game
		Gdx.gl.glClearColor(0.57f, 0.77f, 0.85f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.end();
	}

	//Resizes the windows and sprites according to how the window is resized
	@Override
	public void resize(int width, int height) {
		viewport.update(width, height, true);
		batch.setProjectionMatrix(camera.combined);
	}

	//Disposes of the graphics currently rendered
	@Override
	public void dispose() {
		textureAtlas.dispose();
	}

	//Draws a given sprite at the given position
	private void drawSprite(String name, float x, float y) {
		Sprite sprite = sprites.get(name);
		sprite.setPosition(x, y);
		sprite.draw(batch);
	}

	//Adds the necessary sprites to the textureAtlas
	private void addSprites() {
		Array<AtlasRegion> regions = textureAtlas.getRegions();

		for (AtlasRegion region : regions) {
			Sprite sprite = textureAtlas.createSprite(region.name);

			sprites.put(region.name, sprite);
		}
	}
}
