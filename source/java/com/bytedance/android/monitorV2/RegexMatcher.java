package com.bytedance.android.monitorV2;

import android.util.LruCache;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidRegex;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RegexMatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\b\u001a\u00020\tJ(\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0010J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ \u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/monitorV2/RegexMatcher;", "", "()V", "lruCache", "Landroid/util/LruCache;", "", "maxMemory", "", "clearCache", "", "matchBid", "url", "regexList", "", "Lcom/bytedance/android/monitorV2/hybridSetting/entity/BidRegex;", "tryRegexListWhenMiss", "", "matchBidInner", "reportRegexCost", "hitCache", "startTs", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class RegexMatcher {
    public static final RegexMatcher INSTANCE = new RegexMatcher();
    private static final LruCache<String, String> lruCache;
    private static final int maxMemory;

    private RegexMatcher() {
    }

    static {
        int maxMemory2 = ((int) Runtime.getRuntime().maxMemory()) / 1024;
        maxMemory = maxMemory2;
        final int i = maxMemory2 / 8;
        lruCache = new LruCache<String, String>(i) { // from class: com.bytedance.android.monitorV2.RegexMatcher$lruCache$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // android.util.LruCache
            public int sizeOf(String key, String value) {
                if (key == null) {
                    return 0;
                }
                return (value != null ? value.length() : 0) + key.length();
            }
        };
    }

    public static /* synthetic */ String matchBid$default(RegexMatcher regexMatcher, String str, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return regexMatcher.matchBid(str, list, z);
    }

    public final String matchBid(String url, List<? extends BidRegex> regexList, boolean tryRegexListWhenMiss) {
        Intrinsics.checkNotNullParameter(url, "url");
        List<? extends BidRegex> list = regexList;
        if (list == null || list.isEmpty()) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        LruCache<String, String> lruCache2 = lruCache;
        String str = lruCache2.get(url);
        if (str != null) {
            System.out.println((Object) ("hit cache: " + str));
            reportRegexCost(true, url, currentTimeMillis);
            return str;
        }
        if (!tryRegexListWhenMiss) {
            return "";
        }
        BidRegex matchBidInner = matchBidInner(url, regexList);
        String bid = matchBidInner != null ? matchBidInner.getBid() : "";
        lruCache2.put(url, bid);
        reportRegexCost(false, url, currentTimeMillis);
        return bid;
    }

    public final BidRegex matchBidInner(String url, List<? extends BidRegex> regexList) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(regexList, "regexList");
        for (BidRegex bidRegex : regexList) {
            if (bidRegex.getRegex().containsMatchIn(url)) {
                System.out.print((Object) (bidRegex.getRegex() + " match " + bidRegex.getBid()));
                return bidRegex;
            }
        }
        return null;
    }

    public final void clearCache() {
        lruCache.evictAll();
    }

    private final void reportRegexCost(boolean hitCache, String url, long startTs) {
        InternalWatcher.INSTANCE.notice(null, InternalWatcher.EVENT_REGEX_PERF, MapsKt.mapOf(new Pair[]{TuplesKt.to("url", url), TuplesKt.to(InternalWatcher.PARAM_REGEX_HIT_CACHE, String.valueOf(hitCache))}), MapsKt.mapOf(TuplesKt.to(InternalWatcher.PARAM_REGEX_MATCH_TIME, Long.valueOf(System.currentTimeMillis() - startTs))));
    }
}
