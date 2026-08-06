package com.bytedance.trae.settings.impl.feature;

import com.bytedance.trae.settings.api.feature.Feature;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeatureCapabilityDefaults.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityDefaults;", "", "<init>", "()V", "tocDefaults", "", "Lcom/bytedance/trae/settings/api/feature/Feature;", "", "tobDefaults", "ssoDefaults", "getDefault", "feature", "scope", "Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class FeatureCapabilityDefaults {
    public static final FeatureCapabilityDefaults INSTANCE = new FeatureCapabilityDefaults();
    private static final Map<Feature, Boolean> tocDefaults = MapsKt.mapOf(new Pair[]{TuplesKt.to(Feature.CONNECTORS, true), TuplesKt.to(Feature.MOBILE_IDE_GUIDE, false), TuplesKt.to(Feature.BRAINSTORM_V2, true), TuplesKt.to(Feature.TASK_LIST_SEARCH, true), TuplesKt.to(Feature.TASK_LIST_PIN, true), TuplesKt.to(Feature.HTML_SHARE, true), TuplesKt.to(Feature.PLUGIN, true)});
    private static final Map<Feature, Boolean> tobDefaults = MapsKt.mapOf(new Pair[]{TuplesKt.to(Feature.CONNECTORS, false), TuplesKt.to(Feature.MOBILE_IDE_GUIDE, false), TuplesKt.to(Feature.BRAINSTORM_V2, false), TuplesKt.to(Feature.TASK_LIST_SEARCH, false), TuplesKt.to(Feature.TASK_LIST_PIN, false), TuplesKt.to(Feature.HTML_SHARE, false), TuplesKt.to(Feature.PLUGIN, false)});
    private static final Map<Feature, Boolean> ssoDefaults = MapsKt.mapOf(new Pair[]{TuplesKt.to(Feature.CONNECTORS, true), TuplesKt.to(Feature.MOBILE_IDE_GUIDE, false), TuplesKt.to(Feature.BRAINSTORM_V2, true), TuplesKt.to(Feature.TASK_LIST_SEARCH, true), TuplesKt.to(Feature.TASK_LIST_PIN, true), TuplesKt.to(Feature.HTML_SHARE, true), TuplesKt.to(Feature.PLUGIN, true)});

    /* compiled from: FeatureCapabilityDefaults.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FeatureCapabilityScope.values().length];
            try {
                iArr[FeatureCapabilityScope.TOC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FeatureCapabilityScope.SSO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FeatureCapabilityScope.TOB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private FeatureCapabilityDefaults() {
    }

    public final boolean getDefault(Feature feature, FeatureCapabilityScope scope) {
        Map<Feature, Boolean> map;
        Intrinsics.checkNotNullParameter(feature, "feature");
        Intrinsics.checkNotNullParameter(scope, "scope");
        int i = WhenMappings.$EnumSwitchMapping$0[scope.ordinal()];
        if (i == 1) {
            map = tocDefaults;
        } else if (i == 2) {
            map = ssoDefaults;
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            map = tobDefaults;
        }
        Boolean bool = map.get(feature);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
