package com.bytedance.trae.network;

import kotlin.Metadata;

/* compiled from: HostResolver.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/network/LoginContextProvider;", "", "isBytecloudLogin", "", "isEnterpriseLogin", "isEnterpriseBoeEnv", "getAiRegion", "Lcom/bytedance/trae/network/AiRegion;", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface LoginContextProvider {

    /* compiled from: HostResolver.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static boolean isEnterpriseBoeEnv(LoginContextProvider loginContextProvider) {
            return false;
        }

        public static boolean isEnterpriseLogin(LoginContextProvider loginContextProvider) {
            return false;
        }
    }

    AiRegion getAiRegion();

    boolean isBytecloudLogin();

    boolean isEnterpriseBoeEnv();

    boolean isEnterpriseLogin();
}
