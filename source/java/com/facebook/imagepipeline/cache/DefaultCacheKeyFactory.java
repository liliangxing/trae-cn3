package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class DefaultCacheKeyFactory implements CacheKeyFactory {
    private static DefaultCacheKeyFactory sInstance;
    private boolean useUriWithoutHost = false;
    private boolean useUriWithoutHostBlackList = false;
    private boolean cacheKeyOnlyPath = false;
    private boolean ignoreRotationOptions = false;
    private boolean ignoreHttpScheme = false;
    private String[] cacheNoHostAllowlist = null;
    private Set<String> cacheNoHostAllowSet = null;
    private String[] cacheKeepHostAllowlist = null;
    private Set<String> cacheKeepHostAllowSet = null;
    private boolean cacheKeyUseSet = false;

    protected Uri getCacheKeySourceUri(Uri uri) {
        return uri;
    }

    protected DefaultCacheKeyFactory() {
    }

    public static synchronized DefaultCacheKeyFactory getInstance() {
        DefaultCacheKeyFactory defaultCacheKeyFactory;
        synchronized (DefaultCacheKeyFactory.class) {
            if (sInstance == null) {
                sInstance = new DefaultCacheKeyFactory();
            }
            defaultCacheKeyFactory = sInstance;
        }
        return defaultCacheKeyFactory;
    }

    public void setUseUriWithoutHost(boolean z, String[] strArr) {
        this.useUriWithoutHost = z;
        this.cacheNoHostAllowlist = strArr;
        if (this.cacheKeyUseSet) {
            generateCacheSet();
        }
    }

    public void setUseUriWithoutHostBlackList(boolean z, String[] strArr) {
        this.useUriWithoutHostBlackList = z;
        this.cacheKeepHostAllowlist = strArr;
        if (this.cacheKeyUseSet) {
            generateCacheSet();
        }
    }

    public void setCacheKeyOnlyPath(boolean z) {
        this.cacheKeyOnlyPath = z;
    }

    public void setIgnoreRotationOptions(boolean z) {
        this.ignoreRotationOptions = z;
    }

    public void setIgnoreHttpScheme(boolean z) {
        this.ignoreHttpScheme = z;
    }

    public void setCacheKeyUseSet(boolean z) {
        this.cacheKeyUseSet = z;
        if (z) {
            generateCacheSet();
        }
    }

    private void generateCacheSet() {
        String[] strArr = this.cacheNoHostAllowlist;
        if (strArr != null && strArr.length > 0) {
            this.cacheNoHostAllowSet = new HashSet(Arrays.asList(this.cacheNoHostAllowlist));
            this.cacheNoHostAllowlist = null;
        }
        String[] strArr2 = this.cacheKeepHostAllowlist;
        if (strArr2 == null || strArr2.length <= 0) {
            return;
        }
        this.cacheKeepHostAllowSet = new HashSet(Arrays.asList(this.cacheKeepHostAllowlist));
        this.cacheKeepHostAllowlist = null;
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getBitmapCacheKey(ImageRequest imageRequest, Object obj) {
        return new BitmapMemoryCacheKey(getCacheKeySourceUriStr(getCacheKeySourceUri(imageRequest)), imageRequest.isLoadThumbnailOnly(), imageRequest.getResizeOptions(), this.ignoreRotationOptions ? null : imageRequest.getRotationOptions(), imageRequest.getImageDecodeOptions(), null, null, obj);
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getPostprocessedBitmapCacheKey(ImageRequest imageRequest, Object obj) {
        CacheKey cacheKey;
        String str;
        Postprocessor postprocessor = imageRequest.getPostprocessor();
        if (postprocessor != null) {
            CacheKey postprocessorCacheKey = postprocessor.getPostprocessorCacheKey();
            str = postprocessor.getClass().getName();
            cacheKey = postprocessorCacheKey;
        } else {
            cacheKey = null;
            str = null;
        }
        return new BitmapMemoryCacheKey(getCacheKeySourceUriStr(getCacheKeySourceUri(imageRequest)), imageRequest.isLoadThumbnailOnly(), imageRequest.getResizeOptions(), this.ignoreRotationOptions ? null : imageRequest.getRotationOptions(), imageRequest.getImageDecodeOptions(), cacheKey, str, obj);
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getEncodedCacheKey(ImageRequest imageRequest, @Nullable Object obj) {
        return getEncodedCacheKey(imageRequest, getCacheKeySourceUri(imageRequest), obj);
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getEncodedCacheKey(ImageRequest imageRequest, Uri uri, @Nullable Object obj) {
        return new SimpleCacheKey(getCacheKeySourceUriStr(getCacheKeySourceUri(uri)));
    }

    @Override // com.facebook.imagepipeline.cache.CacheKeyFactory
    public CacheKey getResizedImageCacheKey(ImageRequest imageRequest, @Nullable Object obj) {
        return new ResizedImageCacheKey(getCacheKeySourceUri(imageRequest).toString(), imageRequest.getResizeOptions(), imageRequest.getSourceFile());
    }

    private Uri getCacheKeySourceUri(ImageRequest imageRequest) {
        Uri cacheKeyUri = imageRequest.getCacheKeyUri();
        return cacheKeyUri == null ? imageRequest.getSourceUri() : cacheKeyUri;
    }

    protected String getCacheKeySourceUriStr(Uri uri) {
        if (this.useUriWithoutHost) {
            return getUriCacheKey(uri);
        }
        return uri.toString();
    }

    private String getUriCacheKey(Uri uri) {
        if (uri == null) {
            return "";
        }
        if (!"http".equals(uri.getScheme()) && !"https".equals(uri.getScheme())) {
            return uri.toString();
        }
        if (this.useUriWithoutHostBlackList) {
            if (isKeepHostCollectionEmpty()) {
                return toStringWithoutHost(uri);
            }
            String host = uri.getHost();
            if (host == null || isInKeepHostCollection(host)) {
                return uri.toString();
            }
            return toStringWithoutHost(uri);
        }
        if (isNoHostCollectionEmpty()) {
            return uri.toString();
        }
        String host2 = uri.getHost();
        if (host2 != null && isInNoHostCollection(host2)) {
            return toStringWithoutHost(uri);
        }
        return uri.toString();
    }

    private boolean isKeepHostCollectionEmpty() {
        return isHostCollectionEmpty(this.cacheKeepHostAllowlist, this.cacheKeepHostAllowSet);
    }

    private boolean isInKeepHostCollection(String str) {
        return isInHostCollection(str, this.cacheKeepHostAllowlist, this.cacheKeepHostAllowSet);
    }

    private boolean isNoHostCollectionEmpty() {
        return isHostCollectionEmpty(this.cacheNoHostAllowlist, this.cacheNoHostAllowSet);
    }

    private boolean isInNoHostCollection(String str) {
        return isInHostCollection(str, this.cacheNoHostAllowlist, this.cacheNoHostAllowSet);
    }

    private boolean isHostCollectionEmpty(String[] strArr, Set<String> set) {
        return this.cacheKeyUseSet ? set == null || set.size() <= 0 : strArr == null || strArr.length <= 0;
    }

    private boolean isInHostCollection(String str, String[] strArr, Set<String> set) {
        if (!this.cacheKeyUseSet) {
            for (String str2 : strArr) {
                if (str2 != null && str.endsWith(str2)) {
                    return true;
                }
            }
        } else if (set.contains(str)) {
            return true;
        }
        return false;
    }

    private String toStringWithoutHost(Uri uri) {
        StringBuilder sb = new StringBuilder();
        if (!this.ignoreHttpScheme) {
            sb.append(uri.getScheme()).append(":");
        }
        if (uri.getEncodedAuthority() != null) {
            sb.append("//");
        }
        String encodedPath = uri.getEncodedPath();
        if (encodedPath != null) {
            sb.append(encodedPath);
        }
        if (this.cacheKeyOnlyPath) {
            return sb.toString();
        }
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery != null) {
            sb.append("?").append(encodedQuery);
        }
        String encodedFragment = uri.getEncodedFragment();
        if (encodedFragment != null) {
            sb.append("#").append(encodedFragment);
        }
        return sb.toString();
    }
}
