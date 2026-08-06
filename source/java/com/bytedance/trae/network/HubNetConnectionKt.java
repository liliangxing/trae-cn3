package com.bytedance.trae.network;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* compiled from: HubNetConnection.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0080@¢\u0006\u0002\u0010\u0005\u001a$\u0010\u0006\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0080@¢\u0006\u0002\u0010\t\u001aV\u0010\n\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u001c\u0010\r\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0080@¢\u0006\u0002\u0010\u0013\u001aS\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0000¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"awaitNetworkRecovery", "", "isConnected", "Lkotlinx/coroutines/flow/StateFlow;", "", "(Lkotlinx/coroutines/flow/StateFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitNetworkRecoveryOrRetryDelay", "retryDelayMs", "", "(Lkotlinx/coroutines/flow/StateFlow;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startTransportThenRegister", "startTransport", "Lkotlin/Function0;", "register", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "onRegisterSuccess", "onRegisterFailure", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildRegisterAppRequest", "Lcom/bytedance/trae/network/RegisterAppRequest;", "config", "Lcom/bytedance/trae/network/FrontierConfig;", "isToB", "deviceId", "", "userId", "frontierId", "appRuntimeType", "processId", "", "clientMetadata", "Lcom/bytedance/trae/network/HubClientMetadata;", "(Lcom/bytedance/trae/network/FrontierConfig;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;ILcom/bytedance/trae/network/HubClientMetadata;)Lcom/bytedance/trae/network/RegisterAppRequest;", "ttnet_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HubNetConnectionKt {
    /* JADX WARN: Removed duplicated region for block: B:19:0x0075 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitNetworkRecovery(StateFlow<Boolean> stateFlow, Continuation<? super Unit> continuation) {
        HubNetConnectionKt$awaitNetworkRecovery$1 hubNetConnectionKt$awaitNetworkRecovery$1;
        Object coroutine_suspended;
        int i;
        Flow<Boolean> flow;
        if (continuation instanceof HubNetConnectionKt$awaitNetworkRecovery$1) {
            hubNetConnectionKt$awaitNetworkRecovery$1 = (HubNetConnectionKt$awaitNetworkRecovery$1) continuation;
            if ((hubNetConnectionKt$awaitNetworkRecovery$1.label & Integer.MIN_VALUE) != 0) {
                hubNetConnectionKt$awaitNetworkRecovery$1.label -= Integer.MIN_VALUE;
                Object obj = hubNetConnectionKt$awaitNetworkRecovery$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = hubNetConnectionKt$awaitNetworkRecovery$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (((Boolean) stateFlow.getValue()).booleanValue()) {
                        final Flow flow2 = (Flow) stateFlow;
                        Flow<Boolean> flow3 = new Flow<Boolean>() { // from class: com.bytedance.trae.network.HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$1
                            public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                                Object collect = flow2.collect(new C08852(flowCollector), continuation2);
                                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                            }

                            /* compiled from: Emitters.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
                            /* renamed from: com.bytedance.trae.network.HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$1$2 */
                            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
                            public static final class C08852<T> implements FlowCollector {
                                final /* synthetic */ FlowCollector $this_unsafeFlow;

                                /* compiled from: Emitters.kt */
                                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                                @DebugMetadata(c = "com.bytedance.trae.network.HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$1$2", f = "HubNetConnection.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                                /* renamed from: com.bytedance.trae.network.HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$1$2$1, reason: invalid class name */
                                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
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
                                        return C08852.this.emit(null, (Continuation) this);
                                    }
                                }

                                public C08852(FlowCollector flowCollector) {
                                    this.$this_unsafeFlow = flowCollector;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Object emit(Object obj, Continuation continuation) {
                                    AnonymousClass1 anonymousClass1;
                                    int i;
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
                                                if (!((Boolean) obj).booleanValue()) {
                                                    anonymousClass1.label = 1;
                                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                                        return coroutine_suspended;
                                                    }
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
                        };
                        hubNetConnectionKt$awaitNetworkRecovery$1.L$0 = stateFlow;
                        hubNetConnectionKt$awaitNetworkRecovery$1.label = 1;
                        if (FlowKt.first(flow3, hubNetConnectionKt$awaitNetworkRecovery$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    stateFlow = (StateFlow) hubNetConnectionKt$awaitNetworkRecovery$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                final Flow flow4 = (Flow) stateFlow;
                flow = new Flow<Boolean>() { // from class: com.bytedance.trae.network.HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$2
                    public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                        Object collect = flow4.collect(new C08862(flowCollector), continuation2);
                        return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                    }

                    /* compiled from: Emitters.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
                    /* renamed from: com.bytedance.trae.network.HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$2$2 */
                    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
                    public static final class C08862<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* compiled from: Emitters.kt */
                        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                        @DebugMetadata(c = "com.bytedance.trae.network.HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$2$2", f = "HubNetConnection.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                        /* renamed from: com.bytedance.trae.network.HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$2$2$1, reason: invalid class name */
                        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
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
                                return C08862.this.emit(null, (Continuation) this);
                            }
                        }

                        public C08862(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Object emit(Object obj, Continuation continuation) {
                            AnonymousClass1 anonymousClass1;
                            int i;
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
                                        if (((Boolean) obj).booleanValue()) {
                                            anonymousClass1.label = 1;
                                            if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
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
                };
                hubNetConnectionKt$awaitNetworkRecovery$1.L$0 = null;
                hubNetConnectionKt$awaitNetworkRecovery$1.label = 2;
                if (FlowKt.first(flow, hubNetConnectionKt$awaitNetworkRecovery$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        hubNetConnectionKt$awaitNetworkRecovery$1 = new HubNetConnectionKt$awaitNetworkRecovery$1(continuation);
        Object obj2 = hubNetConnectionKt$awaitNetworkRecovery$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = hubNetConnectionKt$awaitNetworkRecovery$1.label;
        if (i != 0) {
        }
        final Flow flow42 = (Flow) stateFlow;
        flow = new Flow<Boolean>() { // from class: com.bytedance.trae.network.HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$2
            public Object collect(FlowCollector flowCollector, Continuation continuation2) {
                Object collect = flow42.collect(new C08862(flowCollector), continuation2);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            /* compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
            /* renamed from: com.bytedance.trae.network.HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$2$2 */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
            public static final class C08862<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                @DebugMetadata(c = "com.bytedance.trae.network.HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$2$2", f = "HubNetConnection.kt", i = {}, l = {219}, m = "emit", n = {}, s = {})
                /* renamed from: com.bytedance.trae.network.HubNetConnectionKt$awaitNetworkRecovery$$inlined$filter$2$2$1, reason: invalid class name */
                /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
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
                        return C08862.this.emit(null, (Continuation) this);
                    }
                }

                public C08862(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    int i;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            Object obj22 = anonymousClass1.result;
                            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            i = anonymousClass1.label;
                            if (i != 0) {
                                ResultKt.throwOnFailure(obj22);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                if (((Boolean) obj).booleanValue()) {
                                    anonymousClass1.label = 1;
                                    if (flowCollector.emit(obj, anonymousClass1) == coroutine_suspended2) {
                                        return coroutine_suspended2;
                                    }
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.throwOnFailure(obj22);
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    Object obj222 = anonymousClass1.result;
                    Object coroutine_suspended22 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = anonymousClass1.label;
                    if (i != 0) {
                    }
                    return Unit.INSTANCE;
                }
            }
        };
        hubNetConnectionKt$awaitNetworkRecovery$1.L$0 = null;
        hubNetConnectionKt$awaitNetworkRecovery$1.label = 2;
        if (FlowKt.first(flow, hubNetConnectionKt$awaitNetworkRecovery$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    public static final Object awaitNetworkRecoveryOrRetryDelay(StateFlow<Boolean> stateFlow, long j, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new HubNetConnectionKt$awaitNetworkRecoveryOrRetryDelay$2(j, stateFlow, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object startTransportThenRegister(Function0<Unit> function0, Function1<? super Continuation<? super Boolean>, ? extends Object> function1, Function0<Unit> function02, Function0<Unit> function03, Continuation<? super Unit> continuation) {
        HubNetConnectionKt$startTransportThenRegister$1 hubNetConnectionKt$startTransportThenRegister$1;
        Object obj;
        int i;
        if (continuation instanceof HubNetConnectionKt$startTransportThenRegister$1) {
            hubNetConnectionKt$startTransportThenRegister$1 = (HubNetConnectionKt$startTransportThenRegister$1) continuation;
            if ((hubNetConnectionKt$startTransportThenRegister$1.label & Integer.MIN_VALUE) != 0) {
                hubNetConnectionKt$startTransportThenRegister$1.label -= Integer.MIN_VALUE;
                obj = hubNetConnectionKt$startTransportThenRegister$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = hubNetConnectionKt$startTransportThenRegister$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    function0.invoke();
                    hubNetConnectionKt$startTransportThenRegister$1.L$0 = function02;
                    hubNetConnectionKt$startTransportThenRegister$1.L$1 = function03;
                    hubNetConnectionKt$startTransportThenRegister$1.label = 1;
                    obj = function1.invoke(hubNetConnectionKt$startTransportThenRegister$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    function03 = (Function0) hubNetConnectionKt$startTransportThenRegister$1.L$1;
                    function02 = (Function0) hubNetConnectionKt$startTransportThenRegister$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (!((Boolean) obj).booleanValue()) {
                    function02.invoke();
                } else {
                    function03.invoke();
                }
                return Unit.INSTANCE;
            }
        }
        hubNetConnectionKt$startTransportThenRegister$1 = new HubNetConnectionKt$startTransportThenRegister$1(continuation);
        obj = hubNetConnectionKt$startTransportThenRegister$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = hubNetConnectionKt$startTransportThenRegister$1.label;
        if (i != 0) {
        }
        if (!((Boolean) obj).booleanValue()) {
        }
        return Unit.INSTANCE;
    }

    public static final RegisterAppRequest buildRegisterAppRequest(FrontierConfig frontierConfig, boolean z, String str, String str2, Long l, String str3, int i, HubClientMetadata hubClientMetadata) {
        Intrinsics.checkNotNullParameter(frontierConfig, "config");
        Intrinsics.checkNotNullParameter(str3, "appRuntimeType");
        Intrinsics.checkNotNullParameter(hubClientMetadata, "clientMetadata");
        return new RegisterAppRequest(z ? null : str, hubClientMetadata.getDeviceName(), z ? str2 : null, l, z ? null : "online", frontierConfig.getAppId(), str3, i, frontierConfig.getProductId());
    }
}
