package eu.jobernas.demorecyclerview.core

import android.graphics.Bitmap
import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import eu.jobernas.androidextensions.decodeBase64

/**
 * Set image async
 *
 * @param url
 * @param placeholderRes
 * @param requestOptions
 */
fun ImageView.setImageAsync(url: Uri,
                            @DrawableRes placeholderRes: Int? = null,
                            requestOptions: RequestOptions? = null) {
    Glide.with(this)
        .load(url)
        .setPlaceholder(placeholderRes)
        .setRequestOptions(requestOptions)
        .into(this)
}

/**
 * Set image async
 *
 * @param imageString
 * @param placeholderRes
 */
fun ImageView.setImageAsync(imageString: String?,
                            @DrawableRes placeholderRes: Int? = null,
                            requestOptions: RequestOptions? = null) {
    if (imageString == null) {
        if (placeholderRes != null)
            setImageResource(placeholderRes)
        else
            setImageDrawable(null)
        return
    }
    Glide
        .with(this)
        .load(imageString.decodeBase64())
        .setPlaceholder(placeholderRes)
        .setRequestOptions(requestOptions)
        .into(this)
}

/**
 * Set image async
 *
 * @param iconRes
 * @param placeholderRes
 * @param requestOptions
 */
fun ImageView.setImageAsync(@DrawableRes iconRes: Int?,
                  @DrawableRes placeholderRes: Int? = null,
                  requestOptions: RequestOptions? = null) {
    if (iconRes == null || iconRes == 0) {
        setImageDrawable(null)
        return
    }
    Glide
        .with(this)
        .load(iconRes)
        .setPlaceholder(placeholderRes)
        .setRequestOptions(requestOptions)
        .into(this)
}

/**
 * Set image async
 *
 * @param bitmap
 * @param placeholderRes
 * @param requestOptions
 */
fun ImageView.setImageAsync(bitmap: Bitmap?,
                            @DrawableRes placeholderRes: Int? = null,
                            requestOptions: RequestOptions? = null) {
    if (bitmap == null) {
        setImageBitmap(null)
        return
    }
    Glide
        .with(this)
        .load(bitmap)
        .setPlaceholder(placeholderRes)
        .setRequestOptions(requestOptions)
        .into(this)
}