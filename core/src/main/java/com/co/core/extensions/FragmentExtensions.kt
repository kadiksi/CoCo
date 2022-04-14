package com.co.core.extensions

import androidx.fragment.app.Fragment

inline val Fragment.flowFragment: Fragment
    get() = parentFragment?.parentFragment?.parentFragment?.parentFragment
        ?: parentFragment?.parentFragment?.parentFragment
        ?: parentFragment?.parentFragment
        ?: parentFragment
        ?: this