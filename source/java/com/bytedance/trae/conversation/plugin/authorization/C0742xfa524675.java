package com.bytedance.trae.conversation.plugin.authorization;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import com.bytedance.trae.conversation.tracker.PluginTracker;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$pollListConnectorConnections$result$1", f = "PluginConnectorOAuthManager.kt", i = {0, 0, 1, 1, 2, 2, 3, 3}, l = {369, 372, 382, 388}, m = "invokeSuspend", n = {"firstPoll", "consecutiveErrors", "firstPoll", "consecutiveErrors", "firstPoll", "consecutiveErrors", "firstPoll", "consecutiveErrors"}, s = {"I$0", "I$1", "I$0", "I$1", "I$0", "I$1", "I$0", "I$1"})
/* renamed from: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$pollListConnectorConnections$result$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0742xfa524675 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onComplete;
    final /* synthetic */ String $provider;
    final /* synthetic */ IConnectorOAuthApi $service;
    int I$0;
    int I$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C0742xfa524675(String str, IConnectorOAuthApi iConnectorOAuthApi, Function1<? super String, Unit> function1, Continuation<? super C0742xfa524675> continuation) {
        super(2, continuation);
        this.$provider = str;
        this.$service = iConnectorOAuthApi;
        this.$onComplete = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0742xfa524675(this.$provider, this.$service, this.$onComplete, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0046: MOVE (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:115:0x0046 */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0126: MOVE (r11 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:118:0x0124 */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0124: MOVE (r16 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]), block:B:118:0x0124 */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e4 A[Catch: Exception -> 0x00db, TryCatch #1 {Exception -> 0x00db, blocks: (B:80:0x00b1, B:82:0x00b7, B:83:0x00bf, B:85:0x00c5, B:89:0x00d8, B:22:0x00e4, B:23:0x00ea, B:25:0x00f2, B:26:0x00f6, B:29:0x00fe, B:30:0x00ff, B:38:0x0129, B:39:0x012a, B:60:0x012b, B:62:0x0133, B:63:0x0140, B:66:0x0148, B:67:0x0149, B:75:0x016e, B:76:0x016f, B:28:0x00f7, B:65:0x0141), top: B:79:0x00b1, inners: #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00f2 A[Catch: Exception -> 0x00db, TryCatch #1 {Exception -> 0x00db, blocks: (B:80:0x00b1, B:82:0x00b7, B:83:0x00bf, B:85:0x00c5, B:89:0x00d8, B:22:0x00e4, B:23:0x00ea, B:25:0x00f2, B:26:0x00f6, B:29:0x00fe, B:30:0x00ff, B:38:0x0129, B:39:0x012a, B:60:0x012b, B:62:0x0133, B:63:0x0140, B:66:0x0148, B:67:0x0149, B:75:0x016e, B:76:0x016f, B:28:0x00f7, B:65:0x0141), top: B:79:0x00b1, inners: #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012b A[Catch: Exception -> 0x00db, TryCatch #1 {Exception -> 0x00db, blocks: (B:80:0x00b1, B:82:0x00b7, B:83:0x00bf, B:85:0x00c5, B:89:0x00d8, B:22:0x00e4, B:23:0x00ea, B:25:0x00f2, B:26:0x00f6, B:29:0x00fe, B:30:0x00ff, B:38:0x0129, B:39:0x012a, B:60:0x012b, B:62:0x0133, B:63:0x0140, B:66:0x0148, B:67:0x0149, B:75:0x016e, B:76:0x016f, B:28:0x00f7, B:65:0x0141), top: B:79:0x00b1, inners: #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00b1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x0067 -> B:7:0x007e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0079 -> B:6:0x007c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        C0742xfa524675 c0742xfa524675;
        C0742xfa524675 c0742xfa5246752;
        int i;
        int i2;
        C0742xfa524675 c0742xfa5246753;
        int i3;
        int i4;
        String str;
        int i5;
        Object obj2;
        ConnectorConnectionItem connectorConnectionItem;
        String status;
        Object obj3;
        Object obj4;
        String str2;
        int i6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i7 = this.label;
        try {
        } catch (Exception e) {
            e = e;
            c0742xfa5246752 = c0742xfa524675;
            i2 = i;
            c0742xfa5246753 = c0742xfa5246752;
            if (e instanceof CancellationException) {
            }
        }
        if (i7 == 0) {
            ResultKt.throwOnFailure(obj);
            c0742xfa5246753 = this;
            i4 = 0;
            i3 = 1;
            str = PluginConnectorOAuthManager.pendingProvider;
            if (Intrinsics.areEqual(str, c0742xfa5246753.$provider)) {
            }
            return Unit.INSTANCE;
        }
        if (i7 == 1) {
            i4 = this.I$1;
            i3 = this.I$0;
            ResultKt.throwOnFailure(obj);
            c0742xfa5246753 = this;
            i2 = i3;
            i5 = i4;
            str2 = PluginConnectorOAuthManager.pendingProvider;
            if (Intrinsics.areEqual(str2, c0742xfa5246753.$provider)) {
            }
            return Unit.INSTANCE;
        }
        try {
        } catch (Exception e2) {
            e = e2;
            i2 = i6;
            c0742xfa5246753 = this;
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
        Object obj5 = obj;
        C0742xfa524675 c0742xfa5246754 = this;
        int i14 = i12;
        i3 = i13;
        try {
        } catch (Exception e3) {
            e = e3;
            c0742xfa5246752 = c0742xfa5246754;
            i2 = i3;
            i5 = i14;
            c0742xfa5246753 = c0742xfa5246752;
            if (e instanceof CancellationException) {
            }
        }
        ListConnectorConnectionsResponse listConnectorConnectionsResponse = (ListConnectorConnectionsResponse) obj5;
        if (listConnectorConnectionsResponse != null) {
            try {
            } catch (Exception e4) {
                e = e4;
                c0742xfa5246753 = c0742xfa5246754;
                i2 = i3;
                i5 = 0;
            }
            List<ConnectorConnectionItem> result = listConnectorConnectionsResponse.getResult();
            if (result != null) {
                String str3 = c0742xfa5246754.$provider;
                Iterator<T> it = result.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    if (StringsKt.equals(((ConnectorConnectionItem) obj2).getProvider(), str3, true)) {
                        break;
                    }
                }
                connectorConnectionItem = (ConnectorConnectionItem) obj2;
                status = connectorConnectionItem == null ? connectorConnectionItem.getStatus() : null;
                if (Intrinsics.areEqual(status, "ACTIVE")) {
                    obj4 = PluginConnectorOAuthManager.lock;
                    synchronized (obj4) {
                        PluginConnectorOAuthManager pluginConnectorOAuthManager = PluginConnectorOAuthManager.INSTANCE;
                        PluginConnectorOAuthManager.pendingProvider = null;
                        Unit unit = Unit.INSTANCE;
                    }
                    c0742xfa5246754.I$0 = i3;
                    c0742xfa5246754.I$1 = 0;
                    c0742xfa5246754.label = 3;
                    return BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(c0742xfa5246754.$onComplete, null), (Continuation) c0742xfa5246754) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                }
                if (!Intrinsics.areEqual(status, "FAILED")) {
                    i4 = 0;
                    c0742xfa5246753 = c0742xfa5246754;
                    str = PluginConnectorOAuthManager.pendingProvider;
                    if (Intrinsics.areEqual(str, c0742xfa5246753.$provider)) {
                        if (i3 != 0) {
                            i5 = i4;
                            i2 = 0;
                            str2 = PluginConnectorOAuthManager.pendingProvider;
                            if (Intrinsics.areEqual(str2, c0742xfa5246753.$provider)) {
                                try {
                                } catch (Exception e5) {
                                    e = e5;
                                }
                                c0742xfa5246753.I$0 = i2;
                                c0742xfa5246753.I$1 = i5;
                                c0742xfa5246753.label = 2;
                                obj5 = c0742xfa5246753.$service.listConnectorConnections(new ListConnectorConnectionsRequest(CollectionsKt.listOf(c0742xfa5246753.$provider)), (Continuation) c0742xfa5246753);
                                if (obj5 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                C0742xfa524675 c0742xfa5246755 = c0742xfa5246753;
                                i14 = i5;
                                i3 = i2;
                                c0742xfa5246754 = c0742xfa5246755;
                                ListConnectorConnectionsResponse listConnectorConnectionsResponse2 = (ListConnectorConnectionsResponse) obj5;
                                if (listConnectorConnectionsResponse2 != null) {
                                }
                            }
                        } else {
                            c0742xfa5246753.I$0 = i3;
                            c0742xfa5246753.I$1 = i4;
                            c0742xfa5246753.label = 1;
                            if (DelayKt.delay(2000L, (Continuation) c0742xfa5246753) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i2 = i3;
                            i5 = i4;
                            str2 = PluginConnectorOAuthManager.pendingProvider;
                            if (Intrinsics.areEqual(str2, c0742xfa5246753.$provider)) {
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
                PluginTracker.INSTANCE.trackAuthFail(c0742xfa5246754.$provider, "desktop_poll_failed");
                obj3 = PluginConnectorOAuthManager.lock;
                synchronized (obj3) {
                    PluginConnectorOAuthManager pluginConnectorOAuthManager2 = PluginConnectorOAuthManager.INSTANCE;
                    PluginConnectorOAuthManager.pendingProvider = null;
                    Unit unit2 = Unit.INSTANCE;
                }
                c0742xfa5246754.I$0 = i3;
                c0742xfa5246754.I$1 = 0;
                c0742xfa5246754.label = 4;
                return BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass4(c0742xfa5246754.$onComplete, null), (Continuation) c0742xfa5246754) == coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                e = e4;
                c0742xfa5246753 = c0742xfa5246754;
                i2 = i3;
                i5 = 0;
                if (e instanceof CancellationException) {
                    int i15 = i5 + 1;
                    if (i15 == 5) {
                        PluginTracker pluginTracker = PluginTracker.INSTANCE;
                        String str4 = c0742xfa5246753.$provider;
                        StringBuilder sb = new StringBuilder("desktop_poll_network_error:");
                        String message = e.getMessage();
                        pluginTracker.trackAuthFail(str4, sb.append(message != null ? StringsKt.take(message, 80) : null).toString());
                    }
                    i4 = i15;
                    i3 = i2;
                    str = PluginConnectorOAuthManager.pendingProvider;
                    if (Intrinsics.areEqual(str, c0742xfa5246753.$provider)) {
                    }
                    return Unit.INSTANCE;
                }
                throw e;
            }
        }
        connectorConnectionItem = null;
        if (connectorConnectionItem == null) {
        }
        if (Intrinsics.areEqual(status, "ACTIVE")) {
        }
        e = e4;
        c0742xfa5246753 = c0742xfa5246754;
        i2 = i3;
        i5 = 0;
        if (e instanceof CancellationException) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PluginConnectorOAuthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$pollListConnectorConnections$result$1$2", f = "PluginConnectorOAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$pollListConnectorConnections$result$1$2, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onComplete;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Function1<? super String, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$onComplete = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$onComplete, continuation);
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
    @DebugMetadata(c = "com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$pollListConnectorConnections$result$1$4", f = "PluginConnectorOAuthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.bytedance.trae.conversation.plugin.authorization.PluginConnectorOAuthManager$pollListConnectorConnections$result$1$4, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<String, Unit> $onComplete;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(Function1<? super String, Unit> function1, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$onComplete = function1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$onComplete, continuation);
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
