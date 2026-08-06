package com.bytedance.trae.conversation;

import com.bytedance.keva.Keva;
import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.api.ILoginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccountSettingsKeva.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/AccountSettingsKeva;", "", "<init>", "()V", "getKeva", "Lcom/bytedance/keva/Keva;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AccountSettingsKeva {
    public static final AccountSettingsKeva INSTANCE = new AccountSettingsKeva();

    private AccountSettingsKeva() {
    }

    public final Keva getKeva() {
        String str;
        AccountInfo accountInfo;
        ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (iLoginService == null || (accountInfo = iLoginService.getAccountInfo()) == null || (str = accountInfo.getUserId()) == null) {
            str = "";
        }
        Keva repo = Keva.getRepo(str + "settings");
        Intrinsics.checkNotNullExpressionValue(repo, "getRepo(...)");
        return repo;
    }
}
