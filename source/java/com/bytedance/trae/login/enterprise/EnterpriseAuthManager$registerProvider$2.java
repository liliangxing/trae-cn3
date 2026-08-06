package com.bytedance.trae.login.enterprise;

import com.bytedance.trae.login.api.AccountInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: EnterpriseAuthManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
/* synthetic */ class EnterpriseAuthManager$registerProvider$2 extends FunctionReferenceImpl implements Function2<String, Continuation<? super AccountInfo>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EnterpriseAuthManager$registerProvider$2(Object obj) {
        super(2, obj, EnterpriseAuthManager.class, "refreshEnterpriseUserInfo", "refreshEnterpriseUserInfo(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(String str, Continuation<? super AccountInfo> continuation) {
        Object refreshEnterpriseUserInfo;
        refreshEnterpriseUserInfo = ((EnterpriseAuthManager) this.receiver).refreshEnterpriseUserInfo(str, continuation);
        return refreshEnterpriseUserInfo;
    }
}
