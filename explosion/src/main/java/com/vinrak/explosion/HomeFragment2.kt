package com.vinrak.explosion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.vinrak.explosion.R
import com.vinrak.explosion.explosion.ExplosionField

class HomeFragment2 : Fragment() {

    private var mExplosionField: ExplosionField? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mExplosionField = ExplosionField.attach2Window(requireActivity())

        view.findViewById<ImageView>(R.id.ivP).setOnClickListener {
            mExplosionField!!.explode(it)
        }
    }

    override fun onStop() {
        super.onStop()
        mExplosionField!!.clear()
    }

}