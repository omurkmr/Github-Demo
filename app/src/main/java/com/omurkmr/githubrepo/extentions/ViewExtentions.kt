package com.omurkmr.githubrepo.extentions

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

/**
 * binding adapter for image showing by using glide
 *
 * @param url image url
 */
@BindingAdapter("imageUrl")
fun ImageView.setImageUrl(url: String?) {
    Glide.with(context).load(url).apply(RequestOptions().circleCrop()).into(this)
}