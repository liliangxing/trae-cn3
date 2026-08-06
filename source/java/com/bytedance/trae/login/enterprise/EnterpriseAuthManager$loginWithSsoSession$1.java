package com.bytedance.trae.login.enterprise;

import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.login.enterprise.EnterpriseAuthManager;
import com.bytedance.trae.login.traeauth.TraeAuthManager;
import com.bytedance.trae.multilanguage.C0882R;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EnterpriseAuthManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.login.enterprise.EnterpriseAuthManager$loginWithSsoSession$1", f = "EnterpriseAuthManager.kt", i = {}, l = {90, 102, 112}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class EnterpriseAuthManager$loginWithSsoSession$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EnterpriseAuthManager.Callback $callback;
    final /* synthetic */ String $email;
    final /* synthetic */ String $tobSession;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterpriseAuthManager$loginWithSsoSession$1(String str, String str2, EnterpriseAuthManager.Callback callback, Continuation<? super EnterpriseAuthManager$loginWithSsoSession$1> continuation) {
        super(2, continuation);
        this.$email = str;
        this.$tobSession = str2;
        this.$callback = callback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EnterpriseAuthManager$loginWithSsoSession$1(this.$email, this.$tobSession, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
        } catch (EnterpriseAuthException e) {
            FLogger.INSTANCE.mo426e("EnterpriseAuthManager", "loginWithSsoSession failed: " + e.getMessage());
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, "enterprise", null, e.getFailedStep(), String.valueOf(e.getErrorCode()), e.getMessage(), null, null, null, null, null, 1988, null);
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C08382(this.$callback, e, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } catch (Exception e2) {
            FLogger.INSTANCE.mo426e("EnterpriseAuthManager", "loginWithSsoSession unexpected error: " + e2.getMessage());
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_FAILURE, "enterprise", null, null, null, e2.getMessage(), null, null, null, null, null, 2012, null);
            this.label = 3;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C08393(this.$callback, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FLogger.INSTANCE.mo428i("EnterpriseAuthManager", "loginWithSsoSession: starting SSO token flow");
            EnterpriseAuthManager.INSTANCE.completeTokenFlow(this.$email, this.$tobSession);
            FLogger.INSTANCE.mo428i("EnterpriseAuthManager", "loginWithSsoSession: completed successfully");
            TraeAuthManager.reportLoginFunnel$default(TraeAuthManager.INSTANCE, TraeAuthManager.STAGE_LOGIN_SUCCESS, "enterprise", null, null, null, null, null, null, null, null, null, 2044, null);
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C08371(this.$callback, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i != 2 && i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EnterpriseAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.enterprise.EnterpriseAuthManager$loginWithSsoSession$1$1", f = "EnterpriseAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.enterprise.EnterpriseAuthManager$loginWithSsoSession$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08371 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EnterpriseAuthManager.Callback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08371(EnterpriseAuthManager.Callback callback, Continuation<? super C08371> continuation) {
            super(2, continuation);
            this.$callback = callback;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08371(this.$callback, continuation);
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
    @DebugMetadata(c = "com.bytedance.trae.login.enterprise.EnterpriseAuthManager$loginWithSsoSession$1$2", f = "EnterpriseAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.enterprise.EnterpriseAuthManager$loginWithSsoSession$1$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08382 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EnterpriseAuthManager.Callback $callback;

        /* renamed from: $e */
        final /* synthetic */ EnterpriseAuthException f129$e;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08382(EnterpriseAuthManager.Callback callback, EnterpriseAuthException enterpriseAuthException, Continuation<? super C08382> continuation) {
            super(2, continuation);
            this.$callback = callback;
            this.f129$e = enterpriseAuthException;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08382(this.$callback, this.f129$e, continuation);
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
            this.$callback.onFailure(this.f129$e.getUserMessage());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EnterpriseAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.login.enterprise.EnterpriseAuthManager$loginWithSsoSession$1$3", f = "EnterpriseAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.login.enterprise.EnterpriseAuthManager$loginWithSsoSession$1$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class C08393 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EnterpriseAuthManager.Callback $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08393(EnterpriseAuthManager.Callback callback, Continuation<? super C08393> continuation) {
            super(2, continuation);
            this.$callback = callback;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08393(this.$callback, continuation);
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
