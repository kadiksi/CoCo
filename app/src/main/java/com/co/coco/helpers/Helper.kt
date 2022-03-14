package com.co.coco.helpers

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle

val FragmentManager.isNotEmpty: Boolean
    get() = backStackEntryCount > 0

val Fragment.canPerformTransaction: Boolean?
    get() = activity?.lifecycle?.currentState?.isAtLeast(Lifecycle.State.RESUMED)

fun Activity.hideKeyboard() {
    val view = currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Fragment.goBack(): Boolean {
    if (canPerformTransaction == true && childFragmentManager.isNotEmpty) {
        childFragmentManager.popBackStack()
        return false
    }
    return true
}