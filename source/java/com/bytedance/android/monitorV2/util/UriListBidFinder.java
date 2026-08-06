package com.bytedance.android.monitorV2.util;

import android.net.Uri;
import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.InternalWatcher;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidRegex;
import com.bytedance.android.monitorV2.util.AbsBidFinder;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.text.StringsKt;

/* compiled from: HybridBidFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/monitorV2/util/UriListBidFinder;", "Lcom/bytedance/android/monitorV2/util/AbsBidFinder;", "()V", "findBid", "Lcom/bytedance/android/monitorV2/util/AbsBidFinder$BidMatchResult;", "url", "", "schema", "reportRegexCost", "", "hitCache", "", "startTs", "", "tryGetFormatUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class UriListBidFinder extends AbsBidFinder {
    public static final UriListBidFinder INSTANCE = new UriListBidFinder();

    private UriListBidFinder() {
        super(ReportConst.BidSourceInfo.BID_SOURCE_REGEX_LIST);
    }

    @Override // com.bytedance.android.monitorV2.util.AbsBidFinder
    public AbsBidFinder.BidMatchResult findBid(String url, String schema) {
        String str;
        List<BidRegex> rexList = HybridMultiMonitor.getInstance().getHybridSettingManager().getRexList();
        List<BidRegex> list = rexList;
        if (list == null || list.isEmpty()) {
            return getDefault();
        }
        if (url == null) {
            return getDefault();
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = AbsBidFinder.INSTANCE.getCache().get(url);
        if (str2 != null) {
            reportRegexCost(true, url, currentTimeMillis);
            return success(str2);
        }
        String tryGetFormatUrl = tryGetFormatUrl(url);
        Iterator<BidRegex> it = rexList.iterator();
        while (true) {
            if (!it.hasNext()) {
                str = "";
                break;
            }
            BidRegex next = it.next();
            if (next.getRegex().containsMatchIn(tryGetFormatUrl)) {
                str = next.getBid();
                break;
            }
        }
        AbsBidFinder.INSTANCE.getCache().put(url, str);
        reportRegexCost(false, url, currentTimeMillis);
        return success(str);
    }

    private final void reportRegexCost(boolean hitCache, String url, long startTs) {
        InternalWatcher.INSTANCE.notice(null, InternalWatcher.EVENT_REGEX_PERF, MapsKt.mapOf(new Pair[]{TuplesKt.to("url", url), TuplesKt.to(InternalWatcher.PARAM_REGEX_HIT_CACHE, String.valueOf(hitCache))}), MapsKt.mapOf(TuplesKt.to(InternalWatcher.PARAM_REGEX_MATCH_TIME, Long.valueOf(System.currentTimeMillis() - startTs))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String tryGetFormatUrl(String url) {
        String str;
        try {
            Result.Companion companion = Result.Companion;
            UriListBidFinder uriListBidFinder = this;
            String queryParameter = Uri.parse(url).getQueryParameter("url");
            if (queryParameter != null) {
                queryParameter.length();
            }
            str = Result.constructor-impl(StringsKt.startsWith$default(url, "http", false, 2, (Object) null) ? (String) CollectionsKt.first(StringsKt.split$default(url, new String[]{"?"}, false, 0, 6, (Object) null)) : url);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            str = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (!Result.isFailure-impl(str)) {
            url = str;
        }
        return url;
    }
}
