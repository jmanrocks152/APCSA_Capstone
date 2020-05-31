package com.puyo.game;

import java.util.HashMap;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.Input.Keys;

public class NullpoPuyo extends ApplicationAdapter {
	//Initializes the variables required for graphics
	final HashMap<String, Sprite> sprites = new HashMap<>();

	SpriteBatch batch;
	TextureAtlas textureAtlas;
	OrthographicCamera camera;
	ExtendViewport viewport;

	//Initializes the board holding the game logic
	Board board;

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

		//Instantiates the variables required for game logic
		board = new Board();
	}

	@Override
	public void render() {
		//Renders the background and sprites of the game
		Gdx.gl.glClearColor(0.57f, 0.77f, 0.85f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//TODO: Try to render X with coordinate system and see how it goes, add X to sprite sheet
		//TODO: Add input functionality with one test pair
		batch.begin();
		//Checks for input and moves the PuyoPair accordingly
		if(Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			board.moveOneLeft();
		}

		if(Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
			board.moveOneRight();
		}

		if(Gdx.input.isKeyJustPressed(Keys.UP) || Gdx.input.isKeyJustPressed(Keys.X)) {
			board.rotate90Right();
		}

		if(Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			board.hardDrop();
		}

		//Renders the activePuyoPair's Puyos
		drawPuyoPair();
		//TODO: Add check for popped puyos here
		//TODO: Add PC Check here
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

	//Renders the activePuyoPair's Puyos
	private void drawPuyoPair() {
		int topR = board.getActivePuyoPair().getTopRow();
		int topC = board.getActivePuyoPair().getTopCol();
		int botR = board.getActivePuyoPair().getBotRow();
		int botC = board.getActivePuyoPair().getBotRow();

		Puyo.Color topColor = board.getActivePuyoPair().getTopColor();
		Puyo.Color botColor = board.getActivePuyoPair().getBotColor();

		String topColorString = topColor.toString();
		String botColorString = botColor.toString();

		int topX = board.colToPixels(topC);
		int topY = board.rowToPixels(topR);
		int botX = board.colToPixels(botC);
		int botY = board.rowToPixels(botR);

		drawSprite("PPTPuyo" + topColorString, topX, topY);
		drawSprite("PPTPuyo" + botColorString, botX, botY);
	}
}
