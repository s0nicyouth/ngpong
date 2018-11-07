package com.syouth.ngpong

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.viewport.FitViewport
import com.syouth.ngpong.actors.Actor
import com.syouth.ngpong.actors.PadActor
import com.syouth.ngpong.entities.Entity
import com.syouth.ngpong.entities.Pad
import com.syouth.ngpong.input.CommandsProcessor

class NgPongMain(commandsProcessor: CommandsProcessor) : ApplicationAdapter() {

    private val mCommandsProcessor = commandsProcessor

    private lateinit var mShapeRenderer: ShapeRenderer
    private lateinit var mPlayer: Entity
    private lateinit var mPlayerActor: Actor
    private lateinit var mCamera: Camera
    private lateinit var mViewport: FitViewport

    override fun create() {
        mCamera = OrthographicCamera(1024f, 768f)
        mViewport = FitViewport(1024f, 768f, mCamera)
        mShapeRenderer = ShapeRenderer()
        mPlayer = Pad(mShapeRenderer, 100f, 200f, 100f, 5f, 90f, mCamera)
        mPlayerActor = PadActor(mCommandsProcessor, mPlayer)
    }

    override fun render() {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        mPlayerActor.update(Gdx.graphics.deltaTime)
        mPlayer.draw()
    }

    override fun dispose() {
        mPlayer.destroy()
        mShapeRenderer.dispose()
    }

    override fun resize(width: Int, height: Int) {
        mViewport.update(width, height, true)
    }
}
