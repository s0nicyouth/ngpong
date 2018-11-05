package com.syouth.ngpong.desktop

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.syouth.ngpong.input.CommandsProcessor

class CommandsProcessorDesktop : CommandsProcessor {
    override fun isUp() : Boolean {
        return Gdx.input.isKeyPressed(Input.Keys.UP)
    }

    override fun isDown() : Boolean {
        return Gdx.input.isKeyPressed(Input.Keys.DOWN)
    }

}