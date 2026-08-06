package com.bytedance.trae.settings.api.feature;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeatureCapability.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rJ\u0006\u0010\u000e\u001a\u00020\tJ\u0006\u0010\u000f\u001a\u00020\u0010R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/settings/api/feature/FeatureCapability;", "", "<init>", "()V", "service", "Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;", "getService", "()Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;", "isEnabled", "", "feature", "Lcom/bytedance/trae/settings/api/feature/Feature;", "getEnabledFeatures", "", "isToBUser", "refresh", "", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureCapability {
    public static final FeatureCapability INSTANCE = new FeatureCapability();

    private FeatureCapability() {
    }

    public final boolean isEnabled(Feature feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        IFeatureCapabilityService service = getService();
        if (service != null) {
            return service.isEnabled(feature);
        }
        return false;
    }

    public final Set<Feature> getEnabledFeatures() {
        Set<Feature> enabledFeatures;
        IFeatureCapabilityService service = getService();
        return (service == null || (enabledFeatures = service.getEnabledFeatures()) == null) ? SetsKt.emptySet() : enabledFeatures;
    }

    public final boolean isToBUser() {
        IFeatureCapabilityService service = getService();
        if (service != null) {
            return service.isToBUser();
        }
        return false;
    }

    public final void refresh() {
        IFeatureCapabilityService service = getService();
        if (service != null) {
            service.refresh();
        }
    }

    private final IFeatureCapabilityService getService() {
        return (IFeatureCapabilityService) ServiceManager.get().getService(IFeatureCapabilityService.class);
    }
}
