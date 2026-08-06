package com.bytedance.trae.conversation.devices;

import com.bytedance.trae.settings.api.feature.Feature;
import com.bytedance.trae.settings.api.feature.FeatureCapability;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MobileIdeFeatureGate.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nJ\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/devices/MobileIdeFeatureGate;", "", "<init>", "()V", "isGuideEnabled", "", "canOpenConnectGuide", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "eligibleNewFeaturePromptProducts", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MobileIdeFeatureGate {
    public static final MobileIdeFeatureGate INSTANCE = new MobileIdeFeatureGate();

    private MobileIdeFeatureGate() {
    }

    public final boolean isGuideEnabled() {
        return FeatureCapability.INSTANCE.isEnabled(Feature.MOBILE_IDE_GUIDE);
    }

    public final boolean canOpenConnectGuide(DeviceProductType productType) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        return canOpenConnectGuide(productType, isGuideEnabled());
    }

    public final boolean canOpenConnectGuide(DeviceProductType productType, boolean isGuideEnabled) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        return productType != DeviceProductType.IDE || isGuideEnabled;
    }

    public final Set<DeviceProductType> eligibleNewFeaturePromptProducts() {
        return eligibleNewFeaturePromptProducts(isGuideEnabled());
    }

    public final Set<DeviceProductType> eligibleNewFeaturePromptProducts(boolean isGuideEnabled) {
        if (isGuideEnabled) {
            return ArraysKt.toSet(DeviceProductType.values());
        }
        return SetsKt.setOf(DeviceProductType.WORK);
    }
}
