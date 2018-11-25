package com.syouth.ngpong.physics

import com.curiouscreature.kotlin.math.Float2
import com.curiouscreature.kotlin.math.Float3
import com.curiouscreature.kotlin.math.cross
import com.curiouscreature.kotlin.math.length
import kotlin.math.sign

class RoundBody(val radius: Float,
                val mass: Float,
                val momentOfInertia: Float,
                var position: Float2,
                var rotation: Float) : Body {

    private var mTotalForce = Float2()
    private var mTotalTorque = 0f
    private var mVelocity = Float2()
    private var mAngularVelocity = 0f

    private val initialPos = position.copy()
    private val initialTime = System.currentTimeMillis()

    override fun applyForce(force: Float2, point: Float2) {
        if (length(point) > radius)
            return
        val torque = cross(Float3(point), Float3(force))

        mTotalForce += force
        mTotalTorque += sign(torque.z) * length(torque)
    }

    override fun tick(dT: Float) {
        val prevVelocity = mVelocity.copy()
        val prevAngularVelocity = mAngularVelocity

        mVelocity += velocityIncrease(dT)
        mAngularVelocity += torqueIncrease(dT)

        position += prevVelocity * dT
        rotation += prevAngularVelocity * dT

        if (rotation > 360)
            rotation -= 360
        if (rotation < 0)
            rotation += 360

        System.out.println("Passed: " + length(position - initialPos) + ", rotation: " + rotation + ", time passed: " + (System.currentTimeMillis() - initialTime) / 1000f)
    }

    private fun velocityIncrease(dT: Float) = (mTotalForce / mass) * dT
    private fun torqueIncrease(dT: Float) = (mTotalTorque / momentOfInertia) * dT

}