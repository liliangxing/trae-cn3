package com.bytedance.trae.account;

import com.bytedance.sdk.account.settings.AuthExpirationConfigManager;
import com.bytedance.trae.login.enterprise.EnterpriseAuthManager;
import kotlin.Metadata;

/* compiled from: AccountInitExt.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/account/AccountInitExt;", "", "<init>", "()V", "setupAuthExpirationConfig", "", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AccountInitExt {
    public static final int $stable = 0;
    public static final AccountInitExt INSTANCE = new AccountInitExt();

    private AccountInitExt() {
    }

    public final void setupAuthExpirationConfig() {
        AuthExpirationConfigManager.setLocalConfig(new AuthExpirationConfigManager.GetLocalConfig() { // from class: com.bytedance.trae.account.AccountInitExt$$ExternalSyntheticLambda0
            @Override // com.bytedance.sdk.account.settings.AuthExpirationConfigManager.GetLocalConfig
            public final AuthExpirationConfigManager.Config getConfig() {
                AuthExpirationConfigManager.Config config;
                config = AccountInitExt.setupAuthExpirationConfig$lambda$1();
                return config;
            }
        });
        EnterpriseAuthManager.INSTANCE.registerProvider();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AuthExpirationConfigManager.Config setupAuthExpirationConfig$lambda$1() {
        AuthExpirationConfigManager.Config config = new AuthExpirationConfigManager.Config();
        config.enable = true;
        return config;
    }
}
