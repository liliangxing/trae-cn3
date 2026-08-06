package com.bytedance.ies.argus.util;

import android.util.LruCache;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RegUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n*\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/argus/util/RegUtils;", "", "()V", "MAX_CACHE_SIZE", "", "patternCache", "Landroid/util/LruCache;", "", "Ljava/util/regex/Pattern;", "matchReg", "", "reg", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class RegUtils {
    private static final int MAX_CACHE_SIZE = 100;
    public static final RegUtils INSTANCE = new RegUtils();
    private static final LruCache<String, Pattern> patternCache = new LruCache<>(100);

    private RegUtils() {
    }

    public final boolean matchReg(String str, String reg) {
        Object m10253constructorimpl;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(reg, "reg");
        try {
            Result.Companion companion = Result.INSTANCE;
            LruCache<String, Pattern> lruCache = patternCache;
            Pattern pattern = lruCache.get(reg);
            if (pattern == null) {
                pattern = Pattern.compile(reg);
                lruCache.put(reg, pattern);
            }
            m10253constructorimpl = Result.m10253constructorimpl(Boolean.valueOf(pattern.matcher(str).find()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10253constructorimpl = Result.m10253constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10256exceptionOrNullimpl(m10253constructorimpl) != null) {
            m10253constructorimpl = false;
        }
        return ((Boolean) m10253constructorimpl).booleanValue();
    }
}
