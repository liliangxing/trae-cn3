package com.bytedance.trae.network;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HubClientMetadata.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"buildFrontierIdentityExtras", "", "", "frontierId", "", "clientMetadata", "Lcom/bytedance/trae/network/HubClientMetadata;", "ttnet_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HubClientMetadataKt {
    public static final Map<String, String> buildFrontierIdentityExtras(long j, HubClientMetadata hubClientMetadata) {
        Intrinsics.checkNotNullParameter(hubClientMetadata, "clientMetadata");
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("frontier_id", String.valueOf(j)), TuplesKt.to("name", hubClientMetadata.getDeviceName())});
    }
}
