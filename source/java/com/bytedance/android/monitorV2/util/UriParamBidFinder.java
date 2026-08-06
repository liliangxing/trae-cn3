package com.bytedance.android.monitorV2.util;

import android.net.Uri;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.util.AbsBidFinder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HybridBidFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\rH\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/monitorV2/util/UriParamBidFinder;", "Lcom/bytedance/android/monitorV2/util/AbsBidFinder;", "()V", "bidQueryKeys", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "findBid", "Lcom/bytedance/android/monitorV2/util/AbsBidFinder$BidMatchResult;", "url", "schema", "getBid", "input", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final class UriParamBidFinder extends AbsBidFinder {
    public static final UriParamBidFinder INSTANCE = new UriParamBidFinder();
    private static final ArrayList<String> bidQueryKeys = CollectionsKt.arrayListOf(new String[]{"bd_hybrid_monitor_bid", "bdhm_bid"});

    private UriParamBidFinder() {
        super(ReportConst.BidSourceInfo.BID_SOURCE_REGEX_PARAM);
    }

    @Override // com.bytedance.android.monitorV2.util.AbsBidFinder
    public AbsBidFinder.BidMatchResult findBid(String url, String schema) {
        String str;
        String str2;
        if (url != null) {
            String str3 = url.length() > 0 ? url : null;
            if (str3 != null && (str2 = AbsBidFinder.INSTANCE.getCache().get(str3)) != null) {
                return INSTANCE.success(str2);
            }
        }
        if (schema != null) {
            String str4 = schema.length() > 0 ? schema : null;
            if (str4 != null && (str = AbsBidFinder.INSTANCE.getCache().get(str4)) != null) {
                return INSTANCE.success(str);
            }
        }
        String bid = getBid(CollectionsKt.arrayListOf(new String[]{url, schema}));
        if ((bid.length() == 0) || Intrinsics.areEqual(bid, BidInfo.DEFAULT)) {
            return getDefault();
        }
        return success(bid);
    }

    private final String getBid(List<String> input) {
        Object obj;
        String queryParameter;
        List<String> list = input;
        if (list == null || list.isEmpty()) {
            return "";
        }
        for (String str : input) {
            for (String str2 : bidQueryKeys) {
                try {
                    Result.Companion companion = Result.Companion;
                    queryParameter = Uri.parse(str).getQueryParameter(str2);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (queryParameter == null) {
                    obj = Result.constructor-impl((Object) null);
                    Result.exceptionOrNull-impl(obj);
                } else {
                    AbsBidFinder.INSTANCE.getCache().put(str, queryParameter);
                    Intrinsics.checkNotNullExpressionValue(queryParameter, "it");
                    return queryParameter;
                }
            }
        }
        return "";
    }
}
