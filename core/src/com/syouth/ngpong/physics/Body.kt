package com.syouth.ngpong.physics

import com.curiouscreature.kotlin.math.Float2

interface Body {
    /**
     * Applies force to the point(in model coordinates).
     */
    fun applyForce(force: Float2, point: Float2)

    /**
     * Updates body state based on applied forces
     */
    fun tick(dT: Float)
}