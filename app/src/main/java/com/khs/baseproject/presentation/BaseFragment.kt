package com.khs.baseproject.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<B : ViewDataBinding?> : Fragment() {
    var mBinding: B? = null

    protected fun bindView(
        inflater: LayoutInflater,
        container: ViewGroup,
        layout: Int
    ) {
        mBinding = DataBindingUtil.inflate<B>(inflater, layout, container, false)
    }

    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    abstract fun onBackPressed(): Boolean
}
