package com.bytedance.ies.bullet.lynx.util;

import android.graphics.Typeface;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FontCacheHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0006R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/util/FontCacheHelper;", "", "()V", "mFontCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Landroid/graphics/Typeface;", "findFontCache", "", "url", "getFontCache", "setFontCache", "", "cache", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class FontCacheHelper {
    public static final FontCacheHelper INSTANCE = new FontCacheHelper();
    private static ConcurrentHashMap<String, Typeface> mFontCache = new ConcurrentHashMap<>();

    private FontCacheHelper() {
    }

    public final void setFontCache(String url, Typeface cache) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(cache, "cache");
        mFontCache.put(url, cache);
    }

    public final Typeface getFontCache(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return mFontCache.get(url);
    }

    public final boolean findFontCache(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return mFontCache.containsKey(url);
    }
}
