package com.bytedance.trae.conversation.plugin.authorization;

import android.content.Context;
import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.tracker.PluginTracker;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PluginConnectorOAuthManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startOAuth$job$1", f = "PluginConnectorOAuthManager.kt", i = {}, l = {85, 97, 101, 108}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginConnectorOAuthManager$startOAuth$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ Function0<Unit> $onBrowserOpened;
    final /* synthetic */ String $provider;
    final /* synthetic */ String $returnTo;
    final /* synthetic */ IConnectorOAuthApi $service;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PluginConnectorOAuthManager$startOAuth$job$1(IConnectorOAuthApi iConnectorOAuthApi, String str, String str2, Context context, Function0<Unit> function0, Continuation<? super PluginConnectorOAuthManager$startOAuth$job$1> continuation) {
        super(2, continuation);
        this.$service = iConnectorOAuthApi;
        this.$provider = str;
        this.$returnTo = str2;
        this.$appContext = context;
        this.$onBrowserOpened = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PluginConnectorOAuthManager$startOAuth$job$1(this.$service, this.$provider, this.$returnTo, this.$appContext, this.$onBrowserOpened, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        r1 = new android.content.Intent("android.intent.action.VIEW", android.net.Uri.parse(r11));
        r1.addFlags(268435456);
        r10.$appContext.startActivity(r1);
        r10.label = 2;
        r11 = kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startOAuth$job$1.C07461(r10.$onBrowserOpened, null), (kotlin.coroutines.Continuation) r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0094, code lost:
    
        if (r11 != r0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0096, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Function1 clearPendingAndGetCompletion;
        Function1 clearPendingAndGetCompletion2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        try {
        } catch (Exception e) {
            if (e instanceof CancellationException) {
                throw e;
            }
            FLogger.INSTANCE.e("ConnectorOAuth", "startOAuth failed", e);
            PluginTracker pluginTracker = PluginTracker.INSTANCE;
            String str = this.$provider;
            StringBuilder sb = new StringBuilder("oauth_start_error:");
            String message = e.getMessage();
            pluginTracker.trackAuthFail(str, sb.append(message != null ? StringsKt.take(message, 100) : null).toString());
            clearPendingAndGetCompletion = PluginConnectorOAuthManager.INSTANCE.clearPendingAndGetCompletion();
            this.label = 4;
            obj = BuildersKt.withContext(Dispatchers.getMain(), new C07483(clearPendingAndGetCompletion, null), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.$service.startOAuth(new ConnectorOAuthStartRequest(this.$provider, this.$returnTo, "mobile"), (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i == 3) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ConnectorOAuthStartResponse connectorOAuthStartResponse = (ConnectorOAuthStartResponse) obj;
        String authorizeUrl = connectorOAuthStartResponse != null ? connectorOAuthStartResponse.getAuthorizeUrl() : null;
        String str2 = authorizeUrl;
        if (str2 != null && !StringsKt.isBlank(str2)) {
            z = false;
        }
        PluginTracker.INSTANCE.trackAuthFail(this.$provider, "empty_authorize_url");
        clearPendingAndGetCompletion2 = PluginConnectorOAuthManager.INSTANCE.clearPendingAndGetCompletion();
        this.label = 3;
        obj = BuildersKt.withContext(Dispatchers.getMain(), new C07472(clearPendingAndGetCompletion2, null), (Continuation) this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginConnectorOAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startOAuth$job$1$1", f = "PluginConnectorOAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startOAuth$job$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07461 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onBrowserOpened;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07461(Function0<Unit> function0, Continuation<? super C07461> continuation) {
            super(2, continuation);
            this.$onBrowserOpened = function0;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07461(this.$onBrowserOpened, continuation);
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
            Function0<Unit> function0 = this.$onBrowserOpened;
            if (function0 == null) {
                return null;
            }
            function0.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginConnectorOAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startOAuth$job$1$2", f = "PluginConnectorOAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startOAuth$job$1$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07472 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $completion;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07472(Function1<? super String, Unit> function1, Continuation<? super C07472> continuation) {
            super(2, continuation);
            this.$completion = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07472(this.$completion, continuation);
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
            Function1<String, Unit> function1 = this.$completion;
            if (function1 == null) {
                return null;
            }
            function1.invoke("user_cancel");
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginConnectorOAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startOAuth$job$1$3", f = "PluginConnectorOAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startOAuth$job$1$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07483 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $completion;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07483(Function1<? super String, Unit> function1, Continuation<? super C07483> continuation) {
            super(2, continuation);
            this.$completion = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07483(this.$completion, continuation);
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
            Function1<String, Unit> function1 = this.$completion;
            if (function1 == null) {
                return null;
            }
            function1.invoke("user_cancel");
            return Unit.INSTANCE;
        }
    }
}
