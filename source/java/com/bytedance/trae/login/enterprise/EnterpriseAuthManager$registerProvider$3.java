package com.bytedance.trae.login.enterprise;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: EnterpriseAuthManager.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
/* synthetic */ class EnterpriseAuthManager$registerProvider$3 extends FunctionReferenceImpl implements Function2<Map<String, ? extends String>, Continuation<? super Boolean>, Object>, SuspendFunction {
    /* JADX INFO: Access modifiers changed from: package-private */
    public EnterpriseAuthManager$registerProvider$3(Object obj) {
        super(2, obj, EnterpriseAuthManager.class, "updateEnterpriseUserProfile", "updateEnterpriseUserProfile(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(Map<String, String> map, Continuation<? super Boolean> continuation) {
        Object updateEnterpriseUserProfile;
        updateEnterpriseUserProfile = ((EnterpriseAuthManager) this.receiver).updateEnterpriseUserProfile(map, continuation);
        return updateEnterpriseUserProfile;
    }
}
