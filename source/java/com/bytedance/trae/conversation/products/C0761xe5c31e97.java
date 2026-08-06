package com.bytedance.trae.conversation.products;

import com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HtmlArtifactRemoteArchiveUrlResolver.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1", f = "HtmlArtifactRemoteArchiveUrlResolver.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0761xe5c31e97 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RealtimeSandboxStatusUpdate>, Object> {
    final /* synthetic */ String $chatSessionId;
    final /* synthetic */ Ref.ObjectRef<RealtimeSandboxStatusUpdate> $lastAnyUpdate;
    final /* synthetic */ Ref.ObjectRef<RealtimeSandboxStatusUpdate> $lastMatchingUpdate;
    int label;
    final /* synthetic */ HtmlArtifactRemoteArchiveUrlResolver this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0761xe5c31e97(HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver, String str, Ref.ObjectRef<RealtimeSandboxStatusUpdate> objectRef, Ref.ObjectRef<RealtimeSandboxStatusUpdate> objectRef2, Continuation<? super C0761xe5c31e97> continuation) {
        super(2, continuation);
        this.this$0 = htmlArtifactRemoteArchiveUrlResolver;
        this.$chatSessionId = str;
        this.$lastAnyUpdate = objectRef;
        this.$lastMatchingUpdate = objectRef2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new C0761xe5c31e97(this.this$0, this.$chatSessionId, this.$lastAnyUpdate, this.$lastMatchingUpdate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RealtimeSandboxStatusUpdate> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        long j;
        HtmlArtifactRemoteSandboxStatusSource htmlArtifactRemoteSandboxStatusSource;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HtmlArtifactRemoteArchiveUrlResolver htmlArtifactRemoteArchiveUrlResolver = this.this$0;
            StringBuilder append = new StringBuilder("resolve: wait sandbox ready start, chatSessionId=").append(this.$chatSessionId).append(", timeoutMs=");
            j = this.this$0.sandboxReadyTimeoutMs;
            htmlArtifactRemoteArchiveUrlResolver.logD(append.append(j).toString());
            htmlArtifactRemoteSandboxStatusSource = this.this$0.sandboxStatusSource;
            final Flow onEach = FlowKt.onEach(htmlArtifactRemoteSandboxStatusSource.updates(), new C0762xc0a52683(this.$lastAnyUpdate, this.$chatSessionId, this.$lastMatchingUpdate, this.this$0, null));
            final String str = this.$chatSessionId;
            this.label = 1;
            obj = FlowKt.first(new Flow<RealtimeSandboxStatusUpdate>() { // from class: com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1
                public Object collect(FlowCollector flowCollector, Continuation continuation) {
                    Object collect = onEach.collect(new AnonymousClass2(flowCollector, str), continuation);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }

                /* compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {UserScopedModelListMemoryCache.ANONYMOUS_USER, "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
                /* renamed from: com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2, reason: invalid class name */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ String $chatSessionId$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                    @DebugMetadata(c = "com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2", f = "HtmlArtifactRemoteArchiveUrlResolver.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                    /* renamed from: com.bytedance.trae.conversation.products.HtmlArtifactRemoteArchiveUrlResolver$waitForSandboxReady$readyUpdate$1$invokeSuspend$$inlined$filter$1$2$1, reason: invalid class name */
                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        Object L$1;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, (Continuation) this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, String str) {
                        this.$this_unsafeFlow = flowCollector;
                        this.$chatSessionId$inlined = str;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                    /* JADX WARN: Removed duplicated region for block: B:23:0x005d  */
                    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
                        int i;
                        boolean z;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label -= Integer.MIN_VALUE;
                                Object obj2 = anonymousClass1.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                i = anonymousClass1.label;
                                if (i != 0) {
                                    ResultKt.throwOnFailure(obj2);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    RealtimeSandboxStatusUpdate realtimeSandboxStatusUpdate = (RealtimeSandboxStatusUpdate) obj;
                                    if (realtimeSandboxStatusUpdate.matches(this.$chatSessionId$inlined)) {
                                        Integer status = realtimeSandboxStatusUpdate.getStatus();
                                        int value = RealtimeSandboxStatus.READY.getValue();
                                        if (status != null && status.intValue() == value) {
                                            z = true;
                                            if (z) {
                                                anonymousClass1.label = 1;
                                                if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            }
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                } else {
                                    if (i != 1) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj2);
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        anonymousClass1 = new AnonymousClass1(continuation);
                        Object obj22 = anonymousClass1.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = anonymousClass1.label;
                        if (i != 0) {
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, (Continuation) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return (RealtimeSandboxStatusUpdate) obj;
    }
}
