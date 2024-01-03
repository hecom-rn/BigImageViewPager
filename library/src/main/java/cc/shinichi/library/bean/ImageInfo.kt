package cc.shinichi.library.bean

import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import java.io.Serializable

/**
 * @author 工藤
 * @email qinglingou@gmail.com
 * 图片信息
 */
class ImageInfo : Serializable {
    /**
     * 缩略图
     */
    var thumbnailUrl: String = ""

    /**
     * 原图
     */
    var originUrl: String = ""

    var headers: Map<String, String>? = null

    val glideUrl: GlideUrl
        get() {
            val builder: LazyHeaders.Builder = LazyHeaders.Builder()
            if (headers != null) {
                for ((key, value) in headers!!) {
                    builder.addHeader(key, value)
                }
            }
            return GlideUrl(originUrl, builder.build())
        }
}