package com.syouth.ngpong.input

interface CommandsProcessor {
    fun isUp() : Boolean
    fun isDown() : Boolean
    fun isLeft() : Boolean
    fun isRight() : Boolean
}