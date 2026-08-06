package com.bytedance.trae.conversation.plugin.authorization;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.tracker.PluginTracker;
import java.util.Locale;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PluginConnectorOAuthManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$pollCustomAuth$result$1", f = "PluginConnectorOAuthManager.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {324, 327, 334, 340}, m = "invokeSuspend", n = {"firstPoll", "consecutiveErrors", "firstPoll", "consecutiveErrors", "firstPoll", "consecutiveErrors", "firstPoll", "consecutiveErrors"}, s = {"I$0", "I$1", "I$0", "I$1", "I$0", "I$1", "I$0", "I$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PluginConnectorOAuthManager$pollCustomAuth$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onComplete;
    final /* synthetic */ String $provider;
    final /* synthetic */ IConnectorOAuthApi $service;
    final /* synthetic */ String $transactionId;
    int I$0;
    int I$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PluginConnectorOAuthManager$pollCustomAuth$result$1(String str, IConnectorOAuthApi iConnectorOAuthApi, String str2, Function1<? super String, Unit> function1, Continuation<? super PluginConnectorOAuthManager$pollCustomAuth$result$1> continuation) {
        super(2, continuation);
        this.$provider = str;
        this.$service = iConnectorOAuthApi;
        this.$transactionId = str2;
        this.$onComplete = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PluginConnectorOAuthManager$pollCustomAuth$result$1(this.$provider, this.$service, this.$transactionId, this.$onComplete, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0046: MOVE (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:113:0x0046 */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0110: MOVE (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:116:0x010e */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x010e: MOVE (r16 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:116:0x010e */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00bd A[Catch: Exception -> 0x00b4, TryCatch #6 {Exception -> 0x00b4, blocks: (B:90:0x00af, B:22:0x00bd, B:29:0x00d2, B:32:0x00dc, B:33:0x00e0, B:36:0x00e8, B:37:0x00e9, B:45:0x0114, B:46:0x0115, B:67:0x0116, B:70:0x0128, B:71:0x0159, B:74:0x0161, B:75:0x0162, B:83:0x0187, B:84:0x0188, B:85:0x011f, B:35:0x00e1, B:73:0x015a), top: B:89:0x00af, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0067 -> B:7:0x007e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:64:0x0079 -> B:6:0x007c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        PluginConnectorOAuthManager$pollCustomAuth$result$1 pluginConnectorOAuthManager$pollCustomAuth$result$1;
        PluginConnectorOAuthManager$pollCustomAuth$result$1 pluginConnectorOAuthManager$pollCustomAuth$result$12;
        int i;
        int i2;
        PluginConnectorOAuthManager$pollCustomAuth$result$1 pluginConnectorOAuthManager$pollCustomAuth$result$13;
        int i3;
        int i4;
        String str;
        int i5;
        String status;
        Object obj2;
        Object obj3;
        String str2;
        int i6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i7 = this.label;
        try {
        } catch (Exception e) {
            e = e;
            pluginConnectorOAuthManager$pollCustomAuth$result$12 = pluginConnectorOAuthManager$pollCustomAuth$result$1;
            i2 = i;
            pluginConnectorOAuthManager$pollCustomAuth$result$13 = pluginConnectorOAuthManager$pollCustomAuth$result$12;
            if (!(e instanceof CancellationException)) {
            }
        }
        if (i7 == 0) {
            ResultKt.throwOnFailure(obj);
            pluginConnectorOAuthManager$pollCustomAuth$result$13 = this;
            i4 = 0;
            i3 = 1;
            str = PluginConnectorOAuthManager.pendingProvider;
            if (Intrinsics.areEqual(str, pluginConnectorOAuthManager$pollCustomAuth$result$13.$provider)) {
            }
            return Unit.INSTANCE;
        }
        if (i7 == 1) {
            i4 = this.I$1;
            i3 = this.I$0;
            ResultKt.throwOnFailure(obj);
            pluginConnectorOAuthManager$pollCustomAuth$result$13 = this;
            i2 = i3;
            i5 = i4;
            str2 = PluginConnectorOAuthManager.pendingProvider;
            if (Intrinsics.areEqual(str2, pluginConnectorOAuthManager$pollCustomAuth$result$13.$provider)) {
            }
            return Unit.INSTANCE;
        }
        try {
        } catch (Exception e2) {
            e = e2;
            i2 = i6;
            pluginConnectorOAuthManager$pollCustomAuth$result$13 = this;
            if (!(e instanceof CancellationException)) {
            }
        }
        if (i7 != 2) {
            if (i7 == 3) {
                int i8 = this.I$1;
                int i9 = this.I$0;
                ResultKt.throwOnFailure(obj);
            }
            if (i7 != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i10 = this.I$1;
            int i11 = this.I$0;
            ResultKt.throwOnFailure(obj);
        }
        int i12 = this.I$1;
        int i13 = this.I$0;
        ResultKt.throwOnFailure(obj);
        Object obj4 = obj;
        PluginConnectorOAuthManager$pollCustomAuth$result$1 pluginConnectorOAuthManager$pollCustomAuth$result$14 = this;
        int i14 = i12;
        i3 = i13;
        try {
        } catch (Exception e3) {
            e = e3;
            pluginConnectorOAuthManager$pollCustomAuth$result$12 = pluginConnectorOAuthManager$pollCustomAuth$result$14;
            i2 = i3;
            i5 = i14;
            pluginConnectorOAuthManager$pollCustomAuth$result$13 = pluginConnectorOAuthManager$pollCustomAuth$result$12;
            if (!(e instanceof CancellationException)) {
                int i15 = i5 + 1;
                if (i15 == 5) {
                    PluginTracker pluginTracker = PluginTracker.INSTANCE;
                    String str3 = pluginConnectorOAuthManager$pollCustomAuth$result$13.$provider;
                    StringBuilder sb = new StringBuilder("custom_poll_network_error:");
                    String message = e.getMessage();
                    pluginTracker.trackAuthFail(str3, sb.append(message != null ? StringsKt.take(message, 80) : null).toString());
                }
                i4 = i15;
                i3 = i2;
                str = PluginConnectorOAuthManager.pendingProvider;
                if (Intrinsics.areEqual(str, pluginConnectorOAuthManager$pollCustomAuth$result$13.$provider)) {
                }
                return Unit.INSTANCE;
            }
            throw e;
        }
        ConnectorOAuthPollResponse connectorOAuthPollResponse = (ConnectorOAuthPollResponse) obj4;
        if (connectorOAuthPollResponse != null) {
            try {
            } catch (Exception e4) {
                e = e4;
                pluginConnectorOAuthManager$pollCustomAuth$result$13 = pluginConnectorOAuthManager$pollCustomAuth$result$14;
                i2 = i3;
                i5 = 0;
                if (!(e instanceof CancellationException)) {
                }
            }
            status = connectorOAuthPollResponse.getStatus();
        } else {
            status = null;
        }
        if (status != null) {
            int hashCode = status.hashCode();
            if (hashCode == -591252731) {
                if (!status.equals("EXPIRED")) {
                }
                PluginTracker pluginTracker2 = PluginTracker.INSTANCE;
                String str4 = pluginConnectorOAuthManager$pollCustomAuth$result$14.$provider;
                StringBuilder append = new StringBuilder().append("custom_poll_");
                String status2 = connectorOAuthPollResponse.getStatus();
                Intrinsics.checkNotNull(status2);
                String lowerCase = status2.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                pluginTracker2.trackAuthFail(str4, append.append(lowerCase).toString());
                obj2 = PluginConnectorOAuthManager.lock;
                synchronized (obj2) {
                    PluginConnectorOAuthManager pluginConnectorOAuthManager = PluginConnectorOAuthManager.INSTANCE;
                    PluginConnectorOAuthManager.pendingProvider = null;
                    Unit unit = Unit.INSTANCE;
                }
                pluginConnectorOAuthManager$pollCustomAuth$result$14.I$0 = i3;
                pluginConnectorOAuthManager$pollCustomAuth$result$14.I$1 = 0;
                pluginConnectorOAuthManager$pollCustomAuth$result$14.label = 4;
                return BuildersKt.withContext(Dispatchers.getMain(), new C07414(pluginConnectorOAuthManager$pollCustomAuth$result$14.$onComplete, null), (Continuation) pluginConnectorOAuthManager$pollCustomAuth$result$14) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
            }
            if (hashCode == 1818119806) {
                if (!status.equals("REVOKED")) {
                }
                PluginTracker pluginTracker22 = PluginTracker.INSTANCE;
                String str42 = pluginConnectorOAuthManager$pollCustomAuth$result$14.$provider;
                StringBuilder append2 = new StringBuilder().append("custom_poll_");
                String status22 = connectorOAuthPollResponse.getStatus();
                Intrinsics.checkNotNull(status22);
                String lowerCase2 = status22.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                pluginTracker22.trackAuthFail(str42, append2.append(lowerCase2).toString());
                obj2 = PluginConnectorOAuthManager.lock;
                synchronized (obj2) {
                }
            } else if (hashCode == 1925346054 && status.equals("ACTIVE")) {
                obj3 = PluginConnectorOAuthManager.lock;
                synchronized (obj3) {
                    PluginConnectorOAuthManager pluginConnectorOAuthManager2 = PluginConnectorOAuthManager.INSTANCE;
                    PluginConnectorOAuthManager.pendingProvider = null;
                    Unit unit2 = Unit.INSTANCE;
                }
                pluginConnectorOAuthManager$pollCustomAuth$result$14.I$0 = i3;
                pluginConnectorOAuthManager$pollCustomAuth$result$14.I$1 = 0;
                pluginConnectorOAuthManager$pollCustomAuth$result$14.label = 3;
                return BuildersKt.withContext(Dispatchers.getMain(), new C07402(pluginConnectorOAuthManager$pollCustomAuth$result$14.$onComplete, null), (Continuation) pluginConnectorOAuthManager$pollCustomAuth$result$14) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
            }
            ConnectorOAuthPollResponse connectorOAuthPollResponse2 = (ConnectorOAuthPollResponse) obj4;
            if (connectorOAuthPollResponse2 != null) {
            }
            if (status != null) {
            }
        }
        i4 = 0;
        pluginConnectorOAuthManager$pollCustomAuth$result$13 = pluginConnectorOAuthManager$pollCustomAuth$result$14;
        str = PluginConnectorOAuthManager.pendingProvider;
        if (Intrinsics.areEqual(str, pluginConnectorOAuthManager$pollCustomAuth$result$13.$provider)) {
            if (i3 != 0) {
                i5 = i4;
                i2 = 0;
                str2 = PluginConnectorOAuthManager.pendingProvider;
                if (Intrinsics.areEqual(str2, pluginConnectorOAuthManager$pollCustomAuth$result$13.$provider)) {
                    try {
                    } catch (Exception e5) {
                        e = e5;
                        if (!(e instanceof CancellationException)) {
                        }
                    }
                    pluginConnectorOAuthManager$pollCustomAuth$result$13.I$0 = i2;
                    pluginConnectorOAuthManager$pollCustomAuth$result$13.I$1 = i5;
                    pluginConnectorOAuthManager$pollCustomAuth$result$13.label = 2;
                    obj4 = pluginConnectorOAuthManager$pollCustomAuth$result$13.$service.pollAuth(new ConnectorOAuthPollRequest(pluginConnectorOAuthManager$pollCustomAuth$result$13.$provider, pluginConnectorOAuthManager$pollCustomAuth$result$13.$transactionId), (Continuation) pluginConnectorOAuthManager$pollCustomAuth$result$13);
                    if (obj4 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    PluginConnectorOAuthManager$pollCustomAuth$result$1 pluginConnectorOAuthManager$pollCustomAuth$result$15 = pluginConnectorOAuthManager$pollCustomAuth$result$13;
                    i14 = i5;
                    i3 = i2;
                    pluginConnectorOAuthManager$pollCustomAuth$result$14 = pluginConnectorOAuthManager$pollCustomAuth$result$15;
                    ConnectorOAuthPollResponse connectorOAuthPollResponse22 = (ConnectorOAuthPollResponse) obj4;
                    if (connectorOAuthPollResponse22 != null) {
                    }
                    if (status != null) {
                    }
                    i4 = 0;
                    pluginConnectorOAuthManager$pollCustomAuth$result$13 = pluginConnectorOAuthManager$pollCustomAuth$result$14;
                    str = PluginConnectorOAuthManager.pendingProvider;
                    if (Intrinsics.areEqual(str, pluginConnectorOAuthManager$pollCustomAuth$result$13.$provider)) {
                    }
                }
            } else {
                pluginConnectorOAuthManager$pollCustomAuth$result$13.I$0 = i3;
                pluginConnectorOAuthManager$pollCustomAuth$result$13.I$1 = i4;
                pluginConnectorOAuthManager$pollCustomAuth$result$13.label = 1;
                if (DelayKt.delay(1000L, (Continuation) pluginConnectorOAuthManager$pollCustomAuth$result$13) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i2 = i3;
                i5 = i4;
                str2 = PluginConnectorOAuthManager.pendingProvider;
                if (Intrinsics.areEqual(str2, pluginConnectorOAuthManager$pollCustomAuth$result$13.$provider)) {
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginConnectorOAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$pollCustomAuth$result$1$2", f = "PluginConnectorOAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$pollCustomAuth$result$1$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07402 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onComplete;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07402(Function1<? super String, Unit> function1, Continuation<? super C07402> continuation) {
            super(2, continuation);
            this.$onComplete = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07402(this.$onComplete, continuation);
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
            this.$onComplete.invoke("success");
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginConnectorOAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$pollCustomAuth$result$1$4", f = "PluginConnectorOAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$pollCustomAuth$result$1$4 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class C07414 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onComplete;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C07414(Function1<? super String, Unit> function1, Continuation<? super C07414> continuation) {
            super(2, continuation);
            this.$onComplete = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07414(this.$onComplete, continuation);
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
            this.$onComplete.invoke("expired");
            return Unit.INSTANCE;
        }
    }
}
