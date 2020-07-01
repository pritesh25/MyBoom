package com.vinrak.explosion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.vinrak.explosion.explosion.ExplosionField

class HomeFragment : Fragment() {

    private var mExplosionField: ExplosionField? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mExplosionField = ExplosionField.attach2Window(requireActivity())
        addListener(view.findViewById(R.id.root))
    }

    override fun onStop() {
        super.onStop()
        mExplosionField!!.clear()
    }

    private fun addListener(root: View) {
        if (root is ViewGroup) {
            val parent = root
            for (i in 0 until parent.childCount) {
                addListener(parent.getChildAt(i))
            }
        } else {
            root.isClickable = true
            root.setOnClickListener { v ->
                mExplosionField!!.explode(v)
                v.setOnClickListener(null)
            }
        }
    }

    private fun reset(root: View) {
        if (root is ViewGroup) {
            val parent = root
            for (i in 0 until parent.childCount) {
                reset(parent.getChildAt(i))
            }
        } else {
            root.scaleX = 1f
            root.scaleY = 1f
            root.alpha = 1f
        }
    }

}