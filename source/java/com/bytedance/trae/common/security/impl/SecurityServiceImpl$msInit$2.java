package com.bytedance.trae.common.security.impl;

import android.content.Context;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.login.api.AccountStatus;
import com.bytedance.trae.login.api.IAccountStatusListener;
import com.bytedance.trae.login.api.ILoginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SecurityServiceImpl.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/bytedance/trae/common/security/impl/SecurityServiceImpl$msInit$2", "Lcom/bytedance/trae/login/api/IAccountStatusListener;", "onAccountStatusChanged", "", "accountStatus", "Lcom/bytedance/trae/login/api/AccountStatus;", "businessScene", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SecurityServiceImpl$msInit$2 implements IAccountStatusListener {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ SecurityServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SecurityServiceImpl$msInit$2(SecurityServiceImpl securityServiceImpl, Context context) {
        this.this$0 = securityServiceImpl;
        this.$appContext = context;
    }

    public void onAccountStatusChanged(AccountStatus accountStatus, String businessScene) {
        Intrinsics.checkNotNullParameter(accountStatus, "accountStatus");
        Intrinsics.checkNotNullParameter(businessScene, "businessScene");
        if (AccountStatus.LOGGED_IN == accountStatus) {
            IApplog.Companion companion = IApplog.INSTANCE;
            final SecurityServiceImpl securityServiceImpl = this.this$0;
            final Context context = this.$appContext;
            companion.doWhenIdsReady(new Function2() { // from class: com.bytedance.trae.common.security.impl.SecurityServiceImpl$msInit$2$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit onAccountStatusChanged$lambda$0;
                    onAccountStatusChanged$lambda$0 = SecurityServiceImpl$msInit$2.onAccountStatusChanged$lambda$0(SecurityServiceImpl.this, context, (String) obj, (String) obj2);
                    return onAccountStatusChanged$lambda$0;
                }
            });
            ILoginService iLoginService = (ILoginService) ServiceManager.get().getService(ILoginService.class);
            if (iLoginService != null) {
                iLoginService.unregisterAccountStatusChangeListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onAccountStatusChanged$lambda$0(SecurityServiceImpl securityServiceImpl, Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(str2, "<unused var>");
        securityServiceImpl.report(context, "login", true);
        return Unit.INSTANCE;
    }
}
