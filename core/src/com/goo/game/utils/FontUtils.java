package com.goo.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 * Created by TIO BIGA on 25/03/2018.
 */

public class FontUtils {

    public static FreeTypeFontGenerator generateCrackManFont(){
        return new FreeTypeFontGenerator(Gdx.files.internal("fonts/crackman.ttf"));
    }
}
