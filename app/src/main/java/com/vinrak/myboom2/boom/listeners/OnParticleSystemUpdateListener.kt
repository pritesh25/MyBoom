package com.vinrak.myboom2.boom.listeners

import com.vinrak.myboom2.boom.KonfettiView
import com.vinrak.myboom2.boom.ParticleSystem

/**
 * Created by dionsegijn on 5/31/17.
 */
interface OnParticleSystemUpdateListener {
    fun onParticleSystemStarted(view: KonfettiView, system: ParticleSystem, activeSystems: Int)
    fun onParticleSystemEnded(view: KonfettiView, system: ParticleSystem, activeSystems: Int)
}
