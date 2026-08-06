package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.network.ThirdPartyTokenRepository;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.AccountType;
import com.bytedance.trae.login.api.ILoginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoginUtils.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/LoginUtils;", "", "<init>", "()V", "isBytecloudLogin", "", "isEnterpriseLogin", "shouldSkipTocCommercialFeatures", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class LoginUtils {
    public static final LoginUtils INSTANCE = new LoginUtils();

    private LoginUtils() {
    }

    public final boolean shouldSkipTocCommercialFeatures() {
        return isBytecloudLogin() || isEnterpriseLogin();
    }

    public final boolean isBytecloudLogin() {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        AccountInfo accountInfo = iLoginService != null ? iLoginService.getAccountInfo() : null;
        return Intrinsics.areEqual(accountInfo != null ? accountInfo.getLoginPlatform() : null, ThirdPartyTokenRepository.TYPE_BYTECLOUD);
    }

    public final boolean isEnterpriseLogin() {
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        AccountInfo accountInfo = iLoginService != null ? iLoginService.getAccountInfo() : null;
        return (accountInfo != null ? accountInfo.getAccountType() : null) == AccountType.TOB;
    }
}
