package com.khs.baseproject.presentation

import android.content.Context
import android.graphics.Rect
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber

abstract class BaseActivity<B : ViewDataBinding?> : AppCompatActivity() {

    var mBinding: B? = null
    private lateinit var mToolbar:Toolbar
    private lateinit var mTitle:TextView

    protected fun bindView(layout: Int) {
        mBinding = DataBindingUtil.setContentView<B>(this, layout)
    }

    protected fun setToolBar(
        toolbar: Toolbar,
        backBtnVisible: Boolean,
        toolbarTitle: String
    ) {
        this.mToolbar = toolbar
        this.mToolbar.apply {
            title = toolbarTitle
            setContentInsetsAbsolute(0, 0) // 좌우 여백 제거.
        }
        if (backBtnVisible) { // 뒤로가기 버튼 보이기.
            // toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        } else {
            // toolbar.setNavigationIcon(R.drawable.ic_baseline_menu)
        }
        setSupportActionBar(toolbar)
    }

    fun changeToolBar(
        toolbarTitle: String,
        navigationIcon: Int
    ) {
        mToolbar.title = toolbarTitle
        mToolbar.setNavigationIcon(navigationIcon)
    }

    override fun onBackPressed() {
        val fragmentList: List<*> = supportFragmentManager.fragments
        var handled = false
        for (f in fragmentList) {
            if (f is BaseFragment<*>) {
                handled = f.onBackPressed()
                if (handled) {
                    break
                }
            }
        }
        if (!handled) {
            super.onBackPressed()
        }
        // overridePendingTransition(android.R.anim.slide_out_right, android.R.anim.slide_in_left)
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            val v = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    v.clearFocus()
                    val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    protected fun startActivityAnimation(context: Context) {
        if (context is AppCompatActivity) {
            context.overridePendingTransition(
                android.R.anim.slide_out_right,
                android.R.anim.slide_in_left
            )
        }
    }

    fun showSnackBar(v: View, @StringRes stringResID: Int) {
        Snackbar.make(v, stringResID, Snackbar.LENGTH_LONG).show()
    }

    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

}