package com.bytedance.trae.settings.api.feature;

import java.util.Set;
import kotlin.Metadata;

/* compiled from: IFeatureCapabilityService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u001f\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\nH&¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/settings/api/feature/IFeatureCapabilityService;", "", "isEnabled", "", "feature", "Lcom/bytedance/trae/settings/api/feature/Feature;", "getEnabledFeatures", "", "isToBUser", "setDebugOverride", "", "enabled", "(Lcom/bytedance/trae/settings/api/feature/Feature;Ljava/lang/Boolean;)V", "refresh", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface IFeatureCapabilityService {
    Set<Feature> getEnabledFeatures();

    boolean isEnabled(Feature feature);

    boolean isToBUser();

    void refresh();

    void setDebugOverride(Feature feature, Boolean enabled);
}
