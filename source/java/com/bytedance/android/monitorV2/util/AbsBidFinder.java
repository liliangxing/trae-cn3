package com.bytedance.android.monitorV2.util;

import android.util.LruCache;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HybridBidFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 \u00102\u00020\u0001:\u0002\u000f\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\u0006H\u0004J\u001c\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0003H\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/monitorV2/util/AbsBidFinder;", "", "matcherName", "", "(Ljava/lang/String;)V", "default", "Lcom/bytedance/android/monitorV2/util/AbsBidFinder$BidMatchResult;", "getDefault", "()Lcom/bytedance/android/monitorV2/util/AbsBidFinder$BidMatchResult;", "failed", "findBid", "url", "schema", "success", "bid", "BidMatchResult", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AbsBidFinder {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LruCache<String, String> cache;
    private static final int maxMemory;
    private final BidMatchResult default;
    private final String matcherName;

    public abstract BidMatchResult findBid(String url, String schema);

    /* compiled from: HybridBidFinder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bR\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/monitorV2/util/AbsBidFinder$Companion;", "", "()V", "cache", "Landroid/util/LruCache;", "", "getCache", "()Landroid/util/LruCache;", "maxMemory", "", "clearCache", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LruCache<String, String> getCache() {
            return AbsBidFinder.cache;
        }

        public final void clearCache() {
            getCache().evictAll();
        }
    }

    public AbsBidFinder(String matcherName) {
        Intrinsics.checkNotNullParameter(matcherName, "matcherName");
        this.matcherName = matcherName;
        String DEFAULT = BidInfo.DEFAULT;
        Intrinsics.checkNotNullExpressionValue(DEFAULT, "DEFAULT");
        this.default = new BidMatchResult(DEFAULT, "default_bid");
    }

    static {
        int maxMemory2 = ((int) Runtime.getRuntime().maxMemory()) / 1024;
        maxMemory = maxMemory2;
        final int i = maxMemory2 / 8;
        cache = new LruCache<String, String>(i) { // from class: com.bytedance.android.monitorV2.util.AbsBidFinder$Companion$cache$1
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

    /* compiled from: HybridBidFinder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\rJ\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/monitorV2/util/AbsBidFinder$BidMatchResult;", "", "bid", "", "source", "(Ljava/lang/String;Ljava/lang/String;)V", "getBid", "()Ljava/lang/String;", "getSource", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "isFailed", "isSuccess", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class BidMatchResult {
        private final String bid;
        private final String source;

        public static /* synthetic */ BidMatchResult copy$default(BidMatchResult bidMatchResult, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = bidMatchResult.bid;
            }
            if ((i & 2) != 0) {
                str2 = bidMatchResult.source;
            }
            return bidMatchResult.copy(str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getBid() {
            return this.bid;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSource() {
            return this.source;
        }

        public final BidMatchResult copy(String bid, String source) {
            Intrinsics.checkNotNullParameter(bid, "bid");
            Intrinsics.checkNotNullParameter(source, "source");
            return new BidMatchResult(bid, source);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BidMatchResult)) {
                return false;
            }
            BidMatchResult bidMatchResult = (BidMatchResult) other;
            return Intrinsics.areEqual(this.bid, bidMatchResult.bid) && Intrinsics.areEqual(this.source, bidMatchResult.source);
        }

        public int hashCode() {
            return (this.bid.hashCode() * 31) + this.source.hashCode();
        }

        public String toString() {
            return "BidMatchResult(bid=" + this.bid + ", source=" + this.source + ')';
        }

        public BidMatchResult(String bid, String source) {
            Intrinsics.checkNotNullParameter(bid, "bid");
            Intrinsics.checkNotNullParameter(source, "source");
            this.bid = bid;
            this.source = source;
        }

        public final String getBid() {
            return this.bid;
        }

        public final String getSource() {
            return this.source;
        }

        public final boolean isFailed() {
            return (this.bid.length() == 0) || Intrinsics.areEqual(this.bid, BidInfo.DEFAULT);
        }

        public final boolean isSuccess() {
            return !isFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BidMatchResult getDefault() {
        return this.default;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: failed, reason: from getter */
    public final BidMatchResult getDefault() {
        return this.default;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BidMatchResult success(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        return new BidMatchResult(bid, this.matcherName);
    }
}
