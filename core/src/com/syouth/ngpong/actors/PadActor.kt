package com.syouth.ngpong.actors

import com.syouth.ngpong.entities.Entity
import com.syouth.ngpong.input.CommandsProcessor

private const val MASS = 5f
private const val RESISTANCE = 8f
private const val APPLIED_FORCE = 2500f

private const val MOMENT_OF_INERTIA = 5f
private const val APPLIED_TORQUE = 2500f

class PadActor(commandsProcessor: CommandsProcessor, entity: Entity) : Actor {

    private val mEntity = entity
    private val mCommandsProcessor = commandsProcessor
    private var mCurrentSpeed = 0f
    private var mCurrentAngularSpeed = 0f

    override fun update(dT: Float) {
        updateSpeed(dT)
        updateRotationSpeed(dT)
    }

    private fun updateRotationSpeed(dT: Float) {
        val prevAngularSpeed = mCurrentAngularSpeed
        val torque = let {
            var ret = -mCurrentAngularSpeed * RESISTANCE
            if (mCommandsProcessor.isLeft()) {
                ret = APPLIED_TORQUE - mCurrentAngularSpeed * RESISTANCE
            }
            if (mCommandsProcessor.isRight()) {
                ret = -APPLIED_TORQUE - mCurrentAngularSpeed * RESISTANCE
            }

            ret
        }

        val angular_accel = torque /  MOMENT_OF_INERTIA

        mCurrentAngularSpeed += angular_accel * dT

        if (Math.signum(mCurrentAngularSpeed ) * Math.signum(prevAngularSpeed) < 0) {
            mCurrentAngularSpeed = 0f
        }

        mEntity.setRotation(mEntity.getRotation() + prevAngularSpeed * dT)
    }

    private fun updateSpeed(dT: Float) {
        val prevSpeed = mCurrentSpeed
        val force = let {
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