package com.omurkmr.githubrepo.extentions

import android.content.Context
import androidx.annotation.BoolRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

/**
 * getting string resource
 *
 * @param id id of the resource
 */
fun Context.resString(@StringRes id:Int): String {
    return this.resources.getString(id)
}

/**
 * getting integer resource
 *
 * @param id id of the resource
 */
fun Context.resInt(@IntegerRes id:Int): Int {
    return this.resources.getInteger(id)
}

/**
 * getting long resource
 *
 * @param id id of the resource
 */
fun Context.resLong(@IntegerRes id:Int): Long {
    return this.resources.getInteger(id).toLong()
}

/**
 * getting boolean resource
 *
 * @param id id of the resource
 */
fun Context.resBoolean(@BoolRes id:Int): Boolean {
    return this.resources.getBoolean(id)
}
