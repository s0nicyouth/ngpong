package com.syouth.ngpong.actors

import com.syouth.ngpong.entities.Entity
import com.syouth.ngpong.input.CommandsProcessor

class PadActor(commandsProcessor: CommandsProcessor, entity: Entity) : Actor {

    companion object {
        private const val MASS = 5f
        private const val RESISTANCE = 8f
        private const val APPLIED_FORCE = 2500f
    }

    private val mEntity = entity
    private val mCommandsProcessor = commandsProcessor
    private var mCurrentSpeed = 0f

    override fun update(dT: Float) {
        val prevSpeed = mCurrentSpeed
        val force  = let {
            var ret = -mCurrentSpeed * RESISTANCE
            if (mCommandsProcessor.isUp()) {
                ret = APPLIED_FORCE - mCurrentSpeed * RESISTANCE
            }
            if (mCommandsProcessor.isDown()) {
                ret = -APPLIED_FORCE - mCurrentSpeed * RESISTANCE
            }

            ret
        }

        val acceleration = force / MASS

        mCurrentSpeed += acceleration * dT
        if (Math.signum(mCurrentSpeed) * Math.signum(prevSpeed) < 0) {
            mCurrentSpeed = 0f
        }

        mEntity.setY(mEntity.getY() + prevSpeed * dT)
    }
}