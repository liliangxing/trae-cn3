package com.bytedance.salamander.anniex;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.xbridge.XBridge;
import com.bytedance.rts.foundation.RTSMapKt;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorSettingsHybridSettingsResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\b\u0016¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0005H\u0016R6\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/salamander/anniex/BidInfo;", "", "()V", "bidInfoMap", "", "", "Lcom/bytedance/salamander/anniex/BidConfig;", "Lcom/bytedance/rts/foundation/RTSMap;", "getBidInfoMap", "()Ljava/util/Map;", "setBidInfoMap", "(Ljava/util/Map;)V", "regexList", "Ljava/util/ArrayList;", "Lcom/bytedance/salamander/anniex/BidRegex;", "Lcom/bytedance/rts/foundation/RTSArray;", "getRegexList", "()Ljava/util/ArrayList;", "setRegexList", "(Ljava/util/ArrayList;)V", PrefetchRequestConfig.METHOD_GET, "bid", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BidInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static String DEFAULT = "__hybrid_default";
    private Map<String, BidConfig> bidInfoMap = RTSMapKt.RTSMap();
    private ArrayList<BidRegex> regexList = new ArrayList<>();

    public Map<String, BidConfig> getBidInfoMap() {
        return this.bidInfoMap;
    }

    public void setBidInfoMap(Map<String, BidConfig> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.bidInfoMap = map;
    }

    public ArrayList<BidRegex> getRegexList() {
        return this.regexList;
    }

    public void setRegexList(ArrayList<BidRegex> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.regexList = arrayList;
    }

    public BidConfig get(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        if (RTSMapKt.has(getBidInfoMap(), bid)) {
            BidConfig bidConfig = getBidInfoMap().get(bid);
            Intrinsics.checkNotNull(bidConfig);
            return bidConfig;
        }
        if (RTSMapKt.has(getBidInfoMap(), DEFAULT)) {
            BidConfig bidConfig2 = getBidInfoMap().get(DEFAULT);
            Intrinsics.checkNotNull(bidConfig2);
            return bidConfig2;
        }
        return new BidConfig(DEFAULT);
    }

    /* compiled from: AnniexMonitorSettingsHybridSettingsResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/salamander/anniex/BidInfo$Companion;", "", "()V", XBridge.DEFAULT_NAMESPACE, "", "getDEFAULT", "()Ljava/lang/String;", "setDEFAULT", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public String getDEFAULT() {
            return BidInfo.DEFAULT;
        }

        public void setDEFAULT(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            BidInfo.DEFAULT = str;
        }
    }
}
