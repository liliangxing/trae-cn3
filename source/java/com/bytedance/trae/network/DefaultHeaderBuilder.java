package com.bytedance.trae.network;

import com.bytedance.ies.xbridge.base.runtime.utils.XBridgeAPIRequestUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultHeaderBuilder.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\b\u001a\u00020\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/network/DefaultHeaderBuilder;", "", "<init>", "()V", "build", "", "", "ppeHeaders", "envLane", "extras", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DefaultHeaderBuilder {
    public static final DefaultHeaderBuilder INSTANCE = new DefaultHeaderBuilder();

    private DefaultHeaderBuilder() {
    }

    public final Map<String, String> build(Map<String, String> ppeHeaders, String envLane, Map<String, String> extras) {
        Intrinsics.checkNotNullParameter(ppeHeaders, "ppeHeaders");
        Intrinsics.checkNotNullParameter(envLane, "envLane");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Map<String, String> mutableMapOf = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(XBridgeAPIRequestUtils.CONTENT_TYPE, "application/json"), TuplesKt.to("X-App-Id", "6eefa01c-1036-4c7e-9ca5-d891f63bfcd8"), TuplesKt.to("X-App-Version-Code", "20260310")});
        mutableMapOf.putAll(ppeHeaders);
        if (envLane.length() > 0) {
            mutableMapOf.put("X-Env-Lane", envLane);
        }
        mutableMapOf.putAll(extras);
        return mutableMapOf;
    }
}
