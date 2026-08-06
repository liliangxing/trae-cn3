package com.bytedance.trae.conversation.plugin.authorization;

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
@DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startQrCodeAuth$job$1", f = "PluginConnectorOAuthManager.kt", i = {2}, l = {137, 149, 152, 153, 158}, m = "invokeSuspend", n = {"transactionId"}, s = {"L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginConnectorOAuthManager$startQrCodeAuth$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onComplete;
    final /* synthetic */ Function0<Unit> $onError;
    final /* synthetic */ Function1<String, Unit> $onQrCodeReady;
    final /* synthetic */ String $provider;
    final /* synthetic */ String $returnTo;
    final /* synthetic */ IConnectorOAuthApi $service;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PluginConnectorOAuthManager$startQrCodeAuth$job$1(IConnectorOAuthApi iConnectorOAuthApi, String str, String str2, Function1<? super String, Unit> function1, Function0<Unit> function0, Function1<? super String, Unit> function12, Continuation<? super PluginConnectorOAuthManager$startQrCodeAuth$job$1> continuation) {
        super(2, continuation);
        this.$service = iConnectorOAuthApi;
        this.$provider = str;
        this.$returnTo = str2;
        this.$onComplete = function1;
        this.$onError = function0;
        this.$onQrCodeReady = function12;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PluginConnectorOAuthManager$startQrCodeAuth$job$1(this.$service, this.$provider, this.$returnTo, this.$onComplete, this.$onError, this.$onQrCodeReady, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0091 A[Catch: Exception -> 0x003d, TryCatch #0 {Exception -> 0x003d, blocks: (B:15:0x0025, B:17:0x002e, B:19:0x00be, B:22:0x0034, B:23:0x00f8, B:25:0x0039, B:26:0x005c, B:28:0x0060, B:30:0x0068, B:33:0x0078, B:34:0x007f, B:36:0x0085, B:41:0x0091, B:43:0x0096, B:49:0x00a1, B:52:0x00d4, B:58:0x0070, B:62:0x0043), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f7 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        String authorizeUrl;
        String transactionId;
        boolean z;
        Object startPolling;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z2 = true;
        try {
        } catch (Exception e) {
            if (e instanceof CancellationException) {
                throw e;
            }
            FLogger.INSTANCE.e("ConnectorOAuth", "startQrCodeAuth failed", e);
            PluginTracker pluginTracker = PluginTracker.INSTANCE;
            String str = this.$provider;
            StringBuilder sb = new StringBuilder("qrcode_start_error:");
            String message = e.getMessage();
            pluginTracker.trackAuthFail(str, sb.append(message != null ? StringsKt.take(message, 100) : null).toString());
            this.L$0 = null;
            this.label = 5;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C07533(this.$onError, null), (Continuation) this) == coroutine_suspended) {
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
                    transactionId = (String) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    String str2 = transactionId;
                    this.L$0 = null;
                    this.label = 4;
                    startPolling = PluginConnectorOAuthManager.INSTANCE.startPolling(this.$service, this.$provider, str2, this.$onComplete, (Continuation) this);
                    if (startPolling == coroutine_suspended) {
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
        ConnectorOAuthMetadata metadata = connectorOAuthStartResponse != null ? connectorOAuthStartResponse.getMetadata() : null;
        if (metadata == null || (authorizeUrl = metadata.getQrcodeUrl()) == null) {
            authorizeUrl = connectorOAuthStartResponse != null ? connectorOAuthStartResponse.getAuthorizeUrl() : null;
        }
        transactionId = metadata != null ? metadata.getTransactionId() : null;
        String str3 = authorizeUrl;
        if (str3 != null && !StringsKt.isBlank(str3)) {
            z = false;
            if (!z) {
                String str4 = transactionId;
                if (str4 != null && !StringsKt.isBlank(str4)) {
                    z2 = false;
                }
                this.L$0 = transactionId;
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C07522(this.$onQrCodeReady, authorizeUrl, null), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                String str22 = transactionId;
                this.L$0 = null;
                this.label = 4;
                startPolling = PluginConnectorOAuthManager.INSTANCE.startPolling(this.$service, this.$provider, str22, this.$onComplete, (Continuation) this);
                if (startPolling == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            PluginTracker.INSTANCE.trackAuthFail(this.$provider, "qrcode_metadata_missing");
            this.label = 2;
            if (BuildersKt.withContext(Dispatchers.getMain(), new C07511(this.$onError, null), (Continuation) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        z = true;
        if (!z) {
        }
        PluginTracker.INSTANCE.trackAuthFail(this.$provider, "qrcode_metadata_missing");
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getMain(), new C07511(this.$onError, null), (Continuation) this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginConnectorOAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startQrCodeAuth$job$1$1", f = "PluginConnectorOAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startQrCodeAuth$job$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onError;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07511(Function0<Unit> function0, Continuation<? super C07511> continuation) {
            super(2, continuation);
            this.$onError = function0;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07511(this.$onError, continuation);
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
            this.$onError.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginConnectorOAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startQrCodeAuth$job$1$2", f = "PluginConnectorOAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startQrCodeAuth$job$1$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07522 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onQrCodeReady;
        final /* synthetic */ String $qrcodeUrl;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07522(Function1<? super String, Unit> function1, String str, Continuation<? super C07522> continuation) {
            super(2, continuation);
            this.$onQrCodeReady = function1;
            this.$qrcodeUrl = str;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07522(this.$onQrCodeReady, this.$qrcodeUrl, continuation);
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
            this.$onQrCodeReady.invoke(this.$qrcodeUrl);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginConnectorOAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startQrCodeAuth$job$1$3", f = "PluginConnectorOAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$startQrCodeAuth$job$1$3 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07533 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $onError;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07533(Function0<Unit> function0, Continuation<? super C07533> continuation) {
            super(2, continuation);
            this.$onError = function0;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07533(this.$onError, continuation);
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
            this.$onError.invoke();
            return Unit.INSTANCE;
        }
    }
}
