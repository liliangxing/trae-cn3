package com.bytedance.trae.conversation.plugin.authorization;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PluginConnectorOAuthManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1", f = "PluginConnectorOAuthManager.kt", i = {2}, l = {216, 228, 231, 236, 242}, m = "invokeSuspend", n = {"transactionId"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ Function1<String, Unit> $onComplete;
    final /* synthetic */ String $provider;
    final /* synthetic */ String $returnTo;
    final /* synthetic */ IConnectorOAuthApi $service;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1(IConnectorOAuthApi iConnectorOAuthApi, String str, String str2, Function1<? super String, Unit> function1, Context context, Continuation<? super PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1> continuation) {
        super(2, continuation);
        this.$service = iConnectorOAuthApi;
        this.$provider = str;
        this.$returnTo = str2;
        this.$onComplete = function1;
        this.$appContext = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1(this.$service, this.$provider, this.$returnTo, this.$onComplete, this.$appContext, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00c9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0086 A[Catch: Exception -> 0x003d, TryCatch #1 {Exception -> 0x003d, blocks: (B:15:0x0025, B:17:0x002e, B:18:0x00b4, B:21:0x0034, B:22:0x00fb, B:24:0x0039, B:25:0x005c, B:27:0x0060, B:29:0x0068, B:31:0x006e, B:32:0x0074, B:34:0x007a, B:39:0x0086, B:41:0x008b, B:47:0x0096, B:51:0x00ca, B:52:0x00d7, B:55:0x00df, B:56:0x00e0, B:61:0x00ff, B:62:0x0100, B:67:0x0043, B:54:0x00d8), top: B:2:0x000c, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object obj2;
        boolean z;
        Object obj3;
        String str;
        ConnectorOAuthMetadata metadata;
        Object pollCustomAuth;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z2 = true;
        try {
        } catch (Exception e) {
            if (e instanceof CancellationException) {
                throw e;
            }
            FLogger.INSTANCE.e("ConnectorOAuth", "startCustomAuthPollingAuth failed", e);
            PluginTracker pluginTracker = PluginTracker.INSTANCE;
            String str2 = this.$provider;
            StringBuilder sb = new StringBuilder("custom_auth_start_error:");
            String message = e.getMessage();
            pluginTracker.trackAuthFail(str2, sb.append(message != null ? StringsKt.take(message, 100) : null).toString());
            obj2 = PluginConnectorOAuthManager.lock;
            synchronized (obj2) {
                PluginConnectorOAuthManager pluginConnectorOAuthManager = PluginConnectorOAuthManager.INSTANCE;
                PluginConnectorOAuthManager.pendingProvider = null;
                Unit unit = Unit.INSTANCE;
                this.L$0 = null;
                this.label = 5;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C07455(this.$onComplete, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
                    String str3 = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    str = str3;
                    this.L$0 = null;
                    this.label = 4;
                    pollCustomAuth = PluginConnectorOAuthManager.INSTANCE.pollCustomAuth(this.$service, this.$provider, str, this.$onComplete, (Continuation) this);
                    if (pollCustomAuth == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (i == 4) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ConnectorOAuthStartResponse connectorOAuthStartResponse = (ConnectorOAuthStartResponse) obj;
        String authorizeUrl = connectorOAuthStartResponse != null ? connectorOAuthStartResponse.getAuthorizeUrl() : null;
        String transactionId = (connectorOAuthStartResponse == null || (metadata = connectorOAuthStartResponse.getMetadata()) == null) ? null : metadata.getTransactionId();
        String str4 = authorizeUrl;
        if (str4 != null && !StringsKt.isBlank(str4)) {
            z = false;
            if (!z) {
                String str5 = transactionId;
                if (str5 != null && !StringsKt.isBlank(str5)) {
                    z2 = false;
                }
                this.L$0 = transactionId;
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C07443(authorizeUrl, this.$appContext, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                str = transactionId;
                this.L$0 = null;
                this.label = 4;
                pollCustomAuth = PluginConnectorOAuthManager.INSTANCE.pollCustomAuth(this.$service, this.$provider, str, this.$onComplete, (Continuation) this);
                if (pollCustomAuth == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            PluginTracker.INSTANCE.trackAuthFail(this.$provider, "custom_auth_metadata_missing");
            obj3 = PluginConnectorOAuthManager.lock;
            synchronized (obj3) {
                PluginConnectorOAuthManager pluginConnectorOAuthManager2 = PluginConnectorOAuthManager.INSTANCE;
                PluginConnectorOAuthManager.pendingProvider = null;
                Unit unit2 = Unit.INSTANCE;
            }
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C07432(this.$onComplete, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        z = true;
        if (!z) {
        }
        PluginTracker.INSTANCE.trackAuthFail(this.$provider, "custom_auth_metadata_missing");
        obj3 = PluginConnectorOAuthManager.lock;
        synchronized (obj3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginConnectorOAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$2", f = "PluginConnectorOAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07432 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onComplete;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07432(Function1<? super String, Unit> function1, Continuation<? super C07432> continuation) {
            super(2, continuation);
            this.$onComplete = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07432(this.$onComplete, continuation);
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
            this.$onComplete.invoke("error");
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginConnectorOAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3", f = "PluginConnectorOAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07443 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $appContext;
        final /* synthetic */ String $authorizeUrl;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07443(String str, Context context, Continuation<? super C07443> continuation) {
            super(2, continuation);
            this.$authorizeUrl = str;
            this.$appContext = context;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07443(this.$authorizeUrl, this.$appContext, continuation);
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
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.$authorizeUrl));
            intent.addFlags(268435456);
            this.$appContext.startActivity(intent);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginConnectorOAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$5", f = "PluginConnectorOAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$5 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07455 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onComplete;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07455(Function1<? super String, Unit> function1, Continuation<? super C07455> continuation) {
            super(2, continuation);
            this.$onComplete = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07455(this.$onComplete, continuation);
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
            this.$onComplete.invoke("error");
            return Unit.INSTANCE;
        }
    }
}
