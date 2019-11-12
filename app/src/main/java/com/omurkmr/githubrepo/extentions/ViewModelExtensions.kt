package com.omurkmr.githubrepo.extentions

import androidx.annotation.MainThread
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 *  lazy viewmodel initializer
 *
 * @param VM
 */
@MainThread
inline fun <reified VM : ViewModel> viewModel(context: FragmentActivity) = lazy { ViewModelProvider(context).get(VM::class.java) }