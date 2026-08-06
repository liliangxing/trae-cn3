package com.bytedance.trae.login.enterprise;

import com.bytedance.trae.network.DebugSettings;
import com.bytedance.trae.network.DomainList;
import com.bytedance.trae.network.E2ENetworkOverrides;
import com.bytedance.trae.network.HostEntry;
import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import kotlin.Metadata;

/* compiled from: EnterpriseLoginConfig.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseLoginConfig;", "", "<init>", "()V", "LOGIN_PLATFORM", "", "baseUrl", "getBaseUrl", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EnterpriseLoginConfig {
    public static final EnterpriseLoginConfig INSTANCE = new EnterpriseLoginConfig();
    public static final String LOGIN_PLATFORM = "enterprise";

    private EnterpriseLoginConfig() {
    }

    public final String getBaseUrl() {
        String normal;
        String overrideBaseUrlOrNull = E2ENetworkOverrides.INSTANCE.overrideBaseUrlOrNull();
        if (overrideBaseUrlOrNull != null) {
            return overrideBaseUrlOrNull;
        }
        HostEntry entry = HostResolver.INSTANCE.getEntry(HostType.LOGIN);
        if (entry == null) {
            return "";
        }
        String str = null;
        if (DebugSettings.INSTANCE.isEnterpriseTestEnv()) {
            DomainList enterpriseBoeUser = entry.getEnterpriseBoeUser();
            if (enterpriseBoeUser == null || (normal = enterpriseBoeUser.getNormal()) == null) {
                DomainList enterpriseUser = entry.getEnterpriseUser();
                if (enterpriseUser != null) {
                    str = enterpriseUser.getNormal();
                }
            } else {
                str = normal;
            }
        } else {
            DomainList enterpriseUser2 = entry.getEnterpriseUser();
            if (enterpriseUser2 != null) {
                str = enterpriseUser2.getNormal();
            }
        }
        StringBuilder sb = new StringBuilder("https://");
        if (str == null) {
            str = entry.getPublicUser().getNormal();
        }
        return sb.append(str).toString();
    }
}
