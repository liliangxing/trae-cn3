package com.bytedance.trae.login.enterprise;

import com.bytedance.trae.login.api.AccountInfo;
import com.bytedance.trae.login.traeauth.TraeAuthStorage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseProfileRefresher.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0015J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\f2\u0006\u0010\n\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u001bJ\"\u0010\u001c\u001a\u00020\u00152\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0013H\u0086@¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000RK\u0010\u0006\u001a1\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010RU\u0010\u0012\u001a;\b\u0001\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0013¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u000e\"\u0004\b\u0017\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseProfileRefresher;", "", "<init>", "()V", "LOGIN_PLATFORM_ENTERPRISE", "", "refreshProvider", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "jwtToken", "Lkotlin/coroutines/Continuation;", "Lcom/bytedance/trae/login/api/AccountInfo;", "getRefreshProvider", "()Lkotlin/jvm/functions/Function2;", "setRefreshProvider", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "updateProfileProvider", "", "params", "", "getUpdateProfileProvider", "setUpdateProfileProvider", "isEnterpriseLogin", "hasRefreshProvider", "refresh", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserProfile", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EnterpriseProfileRefresher {
    public static final EnterpriseProfileRefresher INSTANCE = new EnterpriseProfileRefresher();
    public static final String LOGIN_PLATFORM_ENTERPRISE = "enterprise";
    private static Function2<? super String, ? super Continuation<? super AccountInfo>, ? extends Object> refreshProvider;
    private static Function2<? super Map<String, String>, ? super Continuation<? super Boolean>, ? extends Object> updateProfileProvider;

    private EnterpriseProfileRefresher() {
    }

    public final Function2<String, Continuation<? super AccountInfo>, Object> getRefreshProvider() {
        return refreshProvider;
    }

    public final void setRefreshProvider(Function2<? super String, ? super Continuation<? super AccountInfo>, ? extends Object> function2) {
        refreshProvider = function2;
    }

    public final Function2<Map<String, String>, Continuation<? super Boolean>, Object> getUpdateProfileProvider() {
        return updateProfileProvider;
    }

    public final void setUpdateProfileProvider(Function2<? super Map<String, String>, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        updateProfileProvider = function2;
    }

    public final boolean isEnterpriseLogin() {
        return Intrinsics.areEqual(TraeAuthStorage.INSTANCE.getLoginPlatform(), "enterprise");
    }

    public final boolean hasRefreshProvider() {
        return refreshProvider != null;
    }

    public final Object refresh(String str, Continuation<? super AccountInfo> continuation) {
        Function2<? super String, ? super Continuation<? super AccountInfo>, ? extends Object> function2 = refreshProvider;
        if (function2 != null) {
            return function2.invoke(str, continuation);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object updateUserProfile(Map<String, String> map, Continuation<? super Boolean> continuation) {
        EnterpriseProfileRefresher$updateUserProfile$1 enterpriseProfileRefresher$updateUserProfile$1;
        Object obj;
        int i;
        if (continuation instanceof EnterpriseProfileRefresher$updateUserProfile$1) {
            enterpriseProfileRefresher$updateUserProfile$1 = (EnterpriseProfileRefresher$updateUserProfile$1) continuation;
            if ((enterpriseProfileRefresher$updateUserProfile$1.label & Integer.MIN_VALUE) != 0) {
                enterpriseProfileRefresher$updateUserProfile$1.label -= Integer.MIN_VALUE;
                obj = enterpriseProfileRefresher$updateUserProfile$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = enterpriseProfileRefresher$updateUserProfile$1.label;
                boolean z = false;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Function2<? super Map<String, String>, ? super Continuation<? super Boolean>, ? extends Object> function2 = updateProfileProvider;
                    if (function2 != null) {
                        enterpriseProfileRefresher$updateUserProfile$1.label = 1;
                        obj = function2.invoke(map, enterpriseProfileRefresher$updateUserProfile$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return Boxing.boxBoolean(z);
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    z = true;
                }
                return Boxing.boxBoolean(z);
            }
        }
        enterpriseProfileRefresher$updateUserProfile$1 = new EnterpriseProfileRefresher$updateUserProfile$1(this, continuation);
        obj = enterpriseProfileRefresher$updateUserProfile$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = enterpriseProfileRefresher$updateUserProfile$1.label;
        boolean z2 = false;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
        return Boxing.boxBoolean(z2);
    }
}
