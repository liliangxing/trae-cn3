package com.bytedance.trae.login.enterprise;

import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.enterprise.EnterpriseAuthManager;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EnterpriseAuthManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.enterprise.EnterpriseAuthManager$login$1", f = "EnterpriseAuthManager.kt", i = {}, l = {133, 145, 160, 172, 182}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EnterpriseAuthManager$login$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EnterpriseAuthManager.Callback $callback;
    final /* synthetic */ String $email;
    final /* synthetic */ String $password;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterpriseAuthManager$login$1(String str, String str2, EnterpriseAuthManager.Callback callback, Continuation<? super EnterpriseAuthManager$login$1> continuation) {
        super(2, continuation);
        this.$email = str;
        this.$password = str2;
        this.$callback = callback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EnterpriseAuthManager$login$1(this.$email, this.$password, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bd, code lost:
    
        com.bytedance.trae.utils.logger.FLogger.INSTANCE.mo426e("EnterpriseAuthManager", "login: missing X-Cloudide-Tob-Session");
        com.bytedance.trae.login.traeauth.TraeAuthManager.reportLoginFunnel$default(com.bytedance.trae.login.traeauth.TraeAuthManager.INSTANCE, com.bytedance.trae.login.traeauth.TraeAuthManager.STAGE_LOGIN_FAILURE, "enterprise", null, null, null, "missing_tob_session", null, null, null, null, null, 2012, null);
        r24.label = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f8, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.bytedance.trae.login.enterprise.EnterpriseAuthManager$login$1.C08332(r24.$callback, null), (kotlin.coroutines.Continuation) r24) != r2) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00fa, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Pair doAccountLogin;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
        } catch (EnterpriseAuthException e) {
            FLogger.INSTANCE.mo426e("EnterpriseAuthManager", "login failed: " + e.getMessage());
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, "enterprise", null, e.getFailedStep(), String.valueOf(e.getErrorCode()), e.getMessage(), null, null, null, null, null, 1988, null);
            this.label = 4;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C08354(this.$callback, e, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } catch (Exception e2) {
            FLogger.INSTANCE.mo426e("EnterpriseAuthManager", "login unexpected error: " + e2.getMessage());
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, "enterprise", null, null, null, e2.getMessage(), null, null, null, null, null, 2012, null);
            this.label = 5;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C08365(this.$callback, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i == 3) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 4 && i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        FLogger.INSTANCE.mo428i("EnterpriseAuthManager", "login: starting enterprise login flow");
        doAccountLogin = EnterpriseAuthManager.INSTANCE.doAccountLogin(this.$email, this.$password);
        EnterpriseAccountLoginResult enterpriseAccountLoginResult = (EnterpriseAccountLoginResult) doAccountLogin.component1();
        String str = (String) doAccountLogin.component2();
        if (Intrinsics.areEqual(enterpriseAccountLoginResult.isAllowLogin(), Boxing.boxBoolean(false))) {
            FLogger.INSTANCE.mo426e("EnterpriseAuthManager", "login: account login not allowed");
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, "enterprise", null, null, null, "not_allow_login", null, null, null, null, null, 2012, null);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C08321(this.$callback, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        FLogger.INSTANCE.mo428i("EnterpriseAuthManager", "login: account login succeeded, session obtained");
        EnterpriseAuthManager.INSTANCE.completeTokenFlow(this.$email, str);
        FLogger.INSTANCE.mo428i("EnterpriseAuthManager", "login: enterprise login completed successfully");
        TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_SUCCESS, "enterprise", null, null, null, null, null, null, null, null, null, 2044, null);
        this.label = 3;
        if (BuildersKt.withContext(Dispatchers.getMain(), new C08343(this.$callback, null), (Continuation) this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EnterpriseAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.enterprise.EnterpriseAuthManager$login$1$1", f = "EnterpriseAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.enterprise.EnterpriseAuthManager$login$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08321 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EnterpriseAuthManager.Callback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08321(EnterpriseAuthManager.Callback callback, Continuation<? super C08321> continuation) {
            super(2, continuation);
            this.$callback = callback;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08321(this.$callback, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$callback.onFailure(AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_not_allow_login));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EnterpriseAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.enterprise.EnterpriseAuthManager$login$1$2", f = "EnterpriseAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.enterprise.EnterpriseAuthManager$login$1$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08332 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EnterpriseAuthManager.Callback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08332(EnterpriseAuthManager.Callback callback, Continuation<? super C08332> continuation) {
            super(2, continuation);
            this.$callback = callback;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08332(this.$callback, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$callback.onFailure(AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_login_failed));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EnterpriseAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.enterprise.EnterpriseAuthManager$login$1$3", f = "EnterpriseAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.enterprise.EnterpriseAuthManager$login$1$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08343 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EnterpriseAuthManager.Callback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08343(EnterpriseAuthManager.Callback callback, Continuation<? super C08343> continuation) {
            super(2, continuation);
            this.$callback = callback;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08343(this.$callback, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$callback.onSuccess();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EnterpriseAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.enterprise.EnterpriseAuthManager$login$1$4", f = "EnterpriseAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.enterprise.EnterpriseAuthManager$login$1$4 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08354 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EnterpriseAuthManager.Callback $callback;

        /* renamed from: $e */
        final /* synthetic */ EnterpriseAuthException f128$e;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08354(EnterpriseAuthManager.Callback callback, EnterpriseAuthException enterpriseAuthException, Continuation<? super C08354> continuation) {
            super(2, continuation);
            this.$callback = callback;
            this.f128$e = enterpriseAuthException;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08354(this.$callback, this.f128$e, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$callback.onFailure(this.f128$e.getUserMessage());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EnterpriseAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.enterprise.EnterpriseAuthManager$login$1$5", f = "EnterpriseAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.enterprise.EnterpriseAuthManager$login$1$5 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08365 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EnterpriseAuthManager.Callback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08365(EnterpriseAuthManager.Callback callback, Continuation<? super C08365> continuation) {
            super(2, continuation);
            this.$callback = callback;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08365(this.$callback, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$callback.onFailure(AppHost.Companion.getApplication().getString(C0882R.string.trae_enterprise_error_login_failed));
            return Unit.INSTANCE;
        }
    }
}
