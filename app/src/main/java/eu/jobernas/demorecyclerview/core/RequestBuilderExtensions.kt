package eu.jobernas.demorecyclerview.core

import androidx.annotation.DrawableRes
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.request.RequestOptions

/**
 * Set request options
 *
 * @param A
 * @param requestOptions
 * @return
 */
fun <A> RequestBuilder<A>.setRequestOptions(requestOptions: RequestOptions?): RequestBuilder<A> {
    return if (requestOptions != null)
        apply(requestOptions)
    else this
}

/**
 * Set placeholder
 *
 * @param placeholderRes
 * @return
 */
fun <A> RequestBuilder<A>.setPlaceholder(@DrawableRes placeholderRes: Int?): RequestBuilder<A> {
    return if (placeholderRes != null)
        placeholder(placeholderRes)
    else this
}