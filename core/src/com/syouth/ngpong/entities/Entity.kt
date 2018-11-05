package com.syouth.ngpong.entities

interface Entity {
    fun draw()
    fun destroy()
    fun setX(x: Float)
    fun setY(y: Float)
    fun getX(): Float
    fun getY(): Float
    fun setRotation(degree: Float)
    fun getRotation(): Float
}