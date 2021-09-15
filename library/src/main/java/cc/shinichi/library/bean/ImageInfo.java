package cc.shinichi.library.bean;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 工藤
 * @email qinglingou@gmail.com
 * 图片信息
 */
public class ImageInfo implements Serializable {

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    private Map<String, String> headers;

    /**
     * 缩略图
     */
    private String thumbnailUrl;

    /**
     * 原图
     */
    private String originUrl;

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getOriginUrl() {
        return originUrl;
    }

    public void setOriginUrl(String originUrl) {
        this.originUrl = originUrl;
    }


    public GlideUrl getGlideUrl() {
        LazyHeaders.Builder builder = new LazyHeaders.Builder();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }
        GlideUrl glideUrl = new GlideUrl(originUrl, builder.build());
        return glideUrl;
    }
}