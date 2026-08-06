package com.bytedance.trae.settings.impl.feature;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeatureCapabilityScopeResolver.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScopeResolver;", "", "<init>", "()V", "resolve", "Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;", "isLoggedIn", "", "loginPlatform", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureCapabilityScopeResolver {
    public static final FeatureCapabilityScopeResolver INSTANCE = new FeatureCapabilityScopeResolver();

    private FeatureCapabilityScopeResolver() {
    }

    public final FeatureCapabilityScope resolve(boolean isLoggedIn, String loginPlatform) {
        if (isLoggedIn) {
            return Intrinsics.areEqual(loginPlatform, "bytecloud") ? FeatureCapabilityScope.SSO : Intrinsics.areEqual(loginPlatform, "enterprise") ? FeatureCapabilityScope.TOB : FeatureCapabilityScope.TOC;
        }
        return FeatureCapabilityScope.TOC;
    }
}
