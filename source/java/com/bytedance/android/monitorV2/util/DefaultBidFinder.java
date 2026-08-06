package com.bytedance.android.monitorV2.util;

import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.util.AbsBidFinder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HybridBidFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/android/monitorV2/util/DefaultBidFinder;", "Lcom/bytedance/android/monitorV2/util/AbsBidFinder;", "()V", "findBid", "Lcom/bytedance/android/monitorV2/util/AbsBidFinder$BidMatchResult;", "url", "", "schema", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
final class DefaultBidFinder extends AbsBidFinder {
    public static final DefaultBidFinder INSTANCE = new DefaultBidFinder();

    private DefaultBidFinder() {
        super("default_bid");
    }

    @Override // com.bytedance.android.monitorV2.util.AbsBidFinder
    public AbsBidFinder.BidMatchResult findBid(String url, String schema) {
        String DEFAULT = BidInfo.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        return success(DEFAULT);
    }
}
