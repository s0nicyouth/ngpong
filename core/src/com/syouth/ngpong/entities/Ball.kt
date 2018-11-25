package com.syouth.ngpong.entities

import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.curiouscreature.kotlin.math.Float2
import com.syouth.ngpong.physics.RoundBody

class Ball(val shapeRenderer: ShapeRenderer,
           val camera: Camera,
           val radius: Float,
           var position: Float2,
           var rotatiton: Float) : Entity {

    val physicalBody = RoundBody(radius, 10f, 40f, position, rotatiton)

    fun update(dT: Float) = physicalBody.tick(dT)

    override fun draw() {
        shapeRenderer.projectionMatrix = camera.combined
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line)
        shapeRenderer.identity()
        shapeRenderer.translate(physicalBody.position.x, physicalBody.position.y, 0f)
        shapeRenderer.rotate(0f, 0f, 1f, physicalBody.rotation)
        shapeRenderer.color = Color.WHITE
        shapeRenderer.circle(0f, 0f, radius)
        shapeRenderer.color = Color.BLACK
        shapeRenderer.circle(0f, radius / 2, 5f)
        shapeRenderer.end()
    }

    override fun setX(x: Float) {
        position.x = x
    }

    override fun setY(y: Float) {
        position.y = y
    }

    override fun setRotation(degree: Float) {
        rotatiton = degree
    }

    override fun getX(): Float = position.x

    override fun getY(): Float = position.y

    override fun getRotation(): Float = rotatiton

    override fun destroy() {
    }
}