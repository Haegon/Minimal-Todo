package com.example.avjindersinghsekhon.minimaltodo

import android.content.Context

/**
 * Created by gohn on 2017. 7. 22..
 */
class UtilsKt {
    companion object {
        fun getToolbarHeight(context: Context): Int {
            val styledAttributes = context.theme.obtainStyledAttributes(intArrayOf(R.attr.actionBarSize))
            val toolbarHeight = styledAttributes.getDimension(0, 0f).toInt()
            styledAttributes.recycle()

            return toolbarHeight
        }
    }
}