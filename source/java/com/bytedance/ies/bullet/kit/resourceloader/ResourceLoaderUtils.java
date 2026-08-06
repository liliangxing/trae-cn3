package com.bytedance.ies.bullet.kit.resourceloader;

import android.content.res.AssetManager;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.pia.core.misc.UrlMatcher;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ResourceLoaderUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nJ\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\nJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\nJ$\u0010\u001d\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$J\u0012\u0010\"\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\nJ\u0018\u0010&\u001a\u0004\u0018\u00010\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u0012\u0010(\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002J\"\u0010(\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/ies/bullet/kit/resourceloader/ResourceLoaderUtils;", "", "()V", "HEX_CHARS", "", "pattern", "Ljava/util/regex/Pattern;", "getPattern", "()Ljava/util/regex/Pattern;", "patternStr", "", "checkGeckoUrl", "", "uri", "Landroid/net/Uri;", "createCacheKey", "input", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "config", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "getCDN", "getMimeType", "url", "loadLocalAssetResponse", "Landroid/webkit/WebResourceResponse;", "assetManager", "Landroid/content/res/AssetManager;", "path", "loadLocalDiskResponse", "loadLocalResponse", "mimeType", "encode", "is", "Ljava/io/InputStream;", "md5Hex", "bytes", "", "str", "safeGetQueryParameter", "key", "toHexString", "off", "", "len", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ResourceLoaderUtils {
    private static final char[] HEX_CHARS;
    public static final ResourceLoaderUtils INSTANCE = new ResourceLoaderUtils();
    private static final Pattern pattern;
    private static final String patternStr = "^/obj/[^/]+/[^/]+/gecko/resource";

    private ResourceLoaderUtils() {
    }

    static {
        Pattern compile = Pattern.compile(patternStr);
        Intrinsics.checkNotNullExpressionValue(compile, "compile(patternStr)");
        pattern = compile;
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public final Pattern getPattern() {
        return pattern;
    }

    private final String toHexString(byte[] bytes) {
        if (bytes == null) {
            throw new NullPointerException("bytes is null");
        }
        return toHexString(bytes, 0, bytes.length);
    }

    private final String toHexString(byte[] bytes, int off, int len) {
        if (bytes == null) {
            throw new NullPointerException("bytes is null");
        }
        if (off >= 0 && off + len <= bytes.length) {
            int i = len * 2;
            char[] cArr = new char[i];
            int i2 = 0;
            for (int i3 = 0; i3 < len; i3++) {
                int i4 = bytes[i3 + off] & 255;
                int i5 = i2 + 1;
                char[] cArr2 = HEX_CHARS;
                cArr[i2] = cArr2[i4 >> 4];
                i2 = i5 + 1;
                cArr[i5] = cArr2[i4 & 15];
            }
            return new String(cArr, 0, i);
        }
        throw new IndexOutOfBoundsException();
    }

    public final String md5Hex(byte[] bytes) {
        if (bytes == null) {
            return "";
        }
        try {
            if (!(!(bytes.length == 0))) {
                return "";
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            return toHexString(messageDigest.digest());
        } catch (Exception unused) {
            return "";
        }
    }

    public final String md5Hex(String str) {
        if (str == null) {
            return null;
        }
        try {
            if (!(str.length() > 0)) {
                return null;
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "Charset.forName(charsetName)");
            byte[] bytes = str.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            return toHexString(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    public final boolean checkGeckoUrl(Uri uri) {
        Object obj;
        if (uri == null || uri.getPath() == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            ResourceLoaderUtils resourceLoaderUtils = this;
            Pattern pattern2 = pattern;
            String path = uri.getPath();
            Intrinsics.checkNotNull(path);
            obj = Result.constructor-impl(Boolean.valueOf(pattern2.matcher(path).find()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            th2.printStackTrace();
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public final String getMimeType(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return StringsKt.endsWith$default(url, ".js", false, 2, (Object) null) ? "application/x-javascript" : StringsKt.endsWith$default(url, ".json", false, 2, (Object) null) ? "application/json" : StringsKt.endsWith$default(url, ".css", false, 2, (Object) null) ? "text/css" : StringsKt.endsWith$default(url, ".html", false, 2, (Object) null) ? "text/html" : StringsKt.endsWith$default(url, ".ico", false, 2, (Object) null) ? "image/x-icon" : (StringsKt.endsWith$default(url, ".jpeg", false, 2, (Object) null) || StringsKt.endsWith$default(url, ".jpg", false, 2, (Object) null)) ? "image/jpeg" : StringsKt.endsWith$default(url, ".png", false, 2, (Object) null) ? "image/png" : StringsKt.endsWith$default(url, ".gif", false, 2, (Object) null) ? "image/gif" : StringsKt.endsWith$default(url, ".woff", false, 2, (Object) null) ? "font/woff" : StringsKt.endsWith$default(url, ".svg", false, 2, (Object) null) ? "image/svg+xml" : StringsKt.endsWith$default(url, ".ttf", false, 2, (Object) null) ? "font/ttf" : "";
    }

    public final WebResourceResponse loadLocalAssetResponse(AssetManager assetManager, String path) {
        if (assetManager != null) {
            String str = path;
            if (!(str == null || str.length() == 0)) {
                return loadLocalResponse(getMimeType(path), "", assetManager.open(path));
            }
        }
        return null;
    }

    public final WebResourceResponse loadLocalDiskResponse(String path) {
        try {
            Result.Companion companion = Result.Companion;
            if (path != null) {
                File file = new File(path);
                if (!(file.exists() && !file.isDirectory())) {
                    file = null;
                }
                if (file != null) {
                    ResourceLoaderUtils resourceLoaderUtils = INSTANCE;
                    return resourceLoaderUtils.loadLocalResponse(resourceLoaderUtils.getMimeType(path), "", new FileInputStream(file));
                }
            }
            Result.constructor-impl((Object) null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        return null;
    }

    private final WebResourceResponse loadLocalResponse(String mimeType, String encode, InputStream is) {
        if (is == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Access-Control-Allow-Origin", UrlMatcher.WILDCARD);
            if (Intrinsics.areEqual("font/ttf", mimeType)) {
                return new WebResourceResponse(mimeType, encode, 200, "OK", hashMap, is);
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(mimeType, encode, is);
            webResourceResponse.setResponseHeaders(hashMap);
            return webResourceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String createCacheKey(ResourceInfo input, TaskConfig config) {
        String bundle;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(config, "config");
        if (StringsKt.startsWith$default(config.getBundle(), "/", false, 2, (Object) null)) {
            String bundle2 = config.getBundle();
            if (bundle2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            bundle = bundle2.substring(1);
            Intrinsics.checkNotNullExpressionValue(bundle, "(this as java.lang.String).substring(startIndex)");
        } else {
            bundle = config.getBundle();
        }
        return config.getAccessKey() + '_' + config.getChannel() + '_' + bundle;
    }

    public final String getCDN(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (Intrinsics.areEqual(uri.getScheme(), "http") || Intrinsics.areEqual(uri.getScheme(), "https")) {
            return uri.toString();
        }
        String safeGetQueryParameter = safeGetQueryParameter("a_surl", uri);
        if (safeGetQueryParameter != null) {
            return safeGetQueryParameter;
        }
        String safeGetQueryParameter2 = safeGetQueryParameter(SchemaConstants.QUERY_KEY_SURL, uri);
        return safeGetQueryParameter2 == null ? safeGetQueryParameter("url", uri) : safeGetQueryParameter2;
    }

    public final String safeGetQueryParameter(String key, Uri uri) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            return uri.getQueryParameter(key);
        } catch (Throwable unused) {
            return null;
        }
    }
}
