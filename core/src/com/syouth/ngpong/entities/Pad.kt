package com.syouth.ngpong.entities

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import java.lang.IllegalStateException

class Pad(shapeRenderer: ShapeRenderer,
          x: Float,
          y: Float,
          width: Float,
          height: Float,
          roation: Float) : Entity {

    private val mShapeRenderer = shapeRenderer

    private var mX = x
    private var mY = y
    private var mWidth = width
        set(w) {
            if (w < 0) {
                throw IllegalStateException("Can not be less than 0")
            }
            field = w
        }
    private var mHeight = height
        set(h) {
            if (h < 0) {
                throw IllegalStateException("Can not be less than 0")
            }
            field = h
        }

    var mRotation = roation


    override fun draw() {
        mShapeRenderer.begin(ShapeRenderer.ShapeType.Filled)
        mShapeRenderer.identity()
        mShapeRenderer.translate(mX, mY, 0f)
        mShapeRenderer.rotate(0f, 0f, 1f, mRotation)
        mShapeRenderer.rect(0f, 0f, mWidth, mHeight)
        mShapeRenderer.end()
    }

    override fun setX(x: Float) {
        mX = x
    }

    override fun setY(y: Float) {
        mY = y
    }

    override fun setRotation(degree: Float) {
        mRotation = degree
    }

    override fun getX(): Float = mX

    override fun getY(): Float = mY

    override fun getRotation(): Float = mRotation

    override fun destroy() {
    }
}