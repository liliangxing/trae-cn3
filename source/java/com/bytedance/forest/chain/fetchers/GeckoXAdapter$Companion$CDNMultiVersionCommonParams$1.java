package com.bytedance.forest.chain.fetchers;

import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: GeckoXAdapter.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final /* synthetic */ class GeckoXAdapter$Companion$CDNMultiVersionCommonParams$1 extends MutablePropertyReference0 {
    GeckoXAdapter$Companion$CDNMultiVersionCommonParams$1(GeckoXAdapter.Companion companion) {
        super(companion);
    }

    public String getName() {
        return "CDNMultiVersionCommonParamsDelegate";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(GeckoXAdapter.Companion.class);
    }

    public String getSignature() {
        return "getCDNMultiVersionCommonParamsDelegate()Ljava/util/Map;";
    }

    public Object get() {
        Map map = GeckoXAdapter.CDNMultiVersionCommonParamsDelegate;
        if (map == null) {
            Intrinsics.throwUninitializedPropertyAccessException("CDNMultiVersionCommonParamsDelegate");
        }
        return map;
    }

    public void set(Object obj) {
        GeckoXAdapter.CDNMultiVersionCommonParamsDelegate = (Map) obj;
    }
}
