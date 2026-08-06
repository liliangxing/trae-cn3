package com.bytedance.trae.login.enterprise;

import com.bytedance.trae.login.traeauth.TraeExchangeTokenResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
/* synthetic */ class EnterpriseAuthManager$registerProvider$1 extends FunctionReferenceImpl implements Function1<String, TraeExchangeTokenResult> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EnterpriseAuthManager$registerProvider$1(Object obj) {
        super(1, obj, EnterpriseAuthManager.class, "exchangeTokenForRefresh", "exchangeTokenForRefresh(Ljava/lang/String;)Lcom/bytedance/trae/login/traeauth/TraeExchangeTokenResult;", 0);
    }

    public final TraeExchangeTokenResult invoke(String str) {
        TraeExchangeTokenResult exchangeTokenForRefresh;
        Intrinsics.checkNotNullParameter(str, "p0");
        exchangeTokenForRefresh = ((EnterpriseAuthManager) this.receiver).exchangeTokenForRefresh(str);
        return exchangeTokenForRefresh;
    }
}
