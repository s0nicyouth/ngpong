package com.syouth.ngpong.desktop

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.syouth.ngpong.input.CommandsProcessor

class CommandsProcessorDesktop : CommandsProcessor {
    override fun isLeft(): Boolean  = Gdx.input.isKeyPressed(Input.Keys.LEFT)

    override fun isRight(): Boolean = Gdx.input.isKeyPressed(Input.Keys.RIGHT)

    override fun isUp() : Boolean = Gdx.input.isKeyPressed(Input.Keys.UP)

    override fun isDown() : Boolean = Gdx.input.isKeyPressed(Input.Keys.DOWN)

}