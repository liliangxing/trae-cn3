package com.bytedance.rts.foundation;

import com.bytedance.push.event.sync.ISignalReportConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: RTSPromise.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 '*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0001'BW\b\u0016\u0012N\u0010\u0003\u001aJ\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u000bJ/\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00028\u00000\u0005Jb\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002%\b\u0002\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00052+\b\u0002\u0010\u0019\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0018\u00010\u0005H\bJ5\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002'\u0010\u0017\u001a#\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u0005J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002J\u0015\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\b¢\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0006H\u0002J\\\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H 0\u0000\"\u0004\b\u0001\u0010 2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H 0\u00052%\b\u0002\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H \u0018\u00010\u0005J¼\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u0002H 0\u0000\"\u0004\b\u0001\u0010 2%\b\u0002\u0010!\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H \u0018\u00010\u00052%\b\u0002\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H \u0018\u00010\u00052+\b\u0002\u0010#\u001a%\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0\u0000\u0018\u00010\u00052+\b\u0002\u0010\u0019\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0\u0000\u0018\u00010\u0005H\u0002Jb\u0010$\u001a\b\u0012\u0004\u0012\u0002H 0\u0000\"\u0004\b\u0001\u0010 2'\u0010!\u001a#\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0\u00000\u00052%\b\u0002\u0010\u0017\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H \u0018\u00010\u0005Jh\u0010%\u001a\b\u0012\u0004\u0012\u0002H 0\u0000\"\u0004\b\u0001\u0010 2'\u0010!\u001a#\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0\u00000\u00052+\b\u0002\u0010\u0017\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0\u0000\u0018\u00010\u0005Jb\u0010&\u001a\b\u0012\u0004\u0012\u0002H 0\u0000\"\u0004\b\u0001\u0010 2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H 0\u00052+\b\u0002\u0010\u0017\u001a%\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H 0\u0000\u0018\u00010\u0005R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R»\u0001\u0010\u000f\u001a®\u0001\u0012M\u0012K\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\u00110\u0010j[\u0012W\u0012U\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\u0011j\b\u0012\u0004\u0012\u00028\u0000`\u0014`\u0013X\u0088\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00018\u0000X\u0088\u000e¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006("}, d2 = {"Lcom/bytedance/rts/foundation/Promise;", "T", "", "executor", "Lkotlin/Function2;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "resolve", "reject", "(Lkotlin/jvm/functions/Function2;)V", ISignalReportConstants.KEY_REASON, "state", "Lcom/bytedance/rts/foundation/PromiseStates;", "thenCallbacks", "Ljava/util/ArrayList;", "Lkotlin/Function3;", "value", "Lcom/bytedance/rts/foundation/RTSArray;", "Lcom/bytedance/rts/foundation/PromiseStateCB;", "Ljava/lang/Object;", "catch", "onrejected", "catchInside", "onrejectedPromise", "catchPromise", "rejectInside", "resolveInside", "(Ljava/lang/Object;)V", "runThenCallbacks", "then", "R", "onfulfilled", "thenInside", "onfulfilledPromise", "thenPromiseOnfulfilled", "thenPromiseOnfulfilledOnrejected", "thenPromiseOnrejected", "Companion", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class Promise<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Object reason;
    private PromiseStates state;
    private ArrayList<Function3<PromiseStates, T, Object, Unit>> thenCallbacks;
    private T value;

    public Promise(Function2<? super Function1<? super T, Unit>, ? super Function1<Object, Unit>, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "executor");
        this.state = PromiseStates.PENDING;
        this.value = null;
        this.reason = null;
        this.thenCallbacks = new ArrayList<>();
        try {
            function2.invoke(new Function1<T, Unit>(this) { // from class: com.bytedance.rts.foundation.Promise.1
                final /* synthetic */ Promise<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m822invoke((C07851) obj);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m822invoke(T t) {
                    this.this$0.resolveInside(t);
                }
            }, new Function1<Object, Unit>(this) { // from class: com.bytedance.rts.foundation.Promise.2
                final /* synthetic */ Promise<T> this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.this$0 = this;
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m823invoke(obj);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m823invoke(Object obj) {
                    Intrinsics.checkNotNullParameter(obj, ISignalReportConstants.KEY_REASON);
                    this.this$0.rejectInside(obj);
                }
            });
        } catch (Throwable th) {
            rejectInside(th);
        }
    }

    static /* synthetic */ Promise thenInside$default(Promise promise, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function12 = null;
        }
        if ((i & 4) != 0) {
            function13 = null;
        }
        if ((i & 8) != 0) {
            function14 = null;
        }
        return promise.thenInside(function1, function12, function13, function14);
    }

    private final <R> Promise<R> thenInside(final Function1<? super T, ? extends R> onfulfilled, final Function1<Object, ? extends R> onrejected, final Function1<? super T, ? extends Promise<? extends R>> onfulfilledPromise, final Function1<Object, ? extends Promise<? extends R>> onrejectedPromise) {
        return new Promise<>(new Function2<Function1<? super R, ? extends Unit>, Function1<? super Object, ? extends Unit>, Unit>(this) { // from class: com.bytedance.rts.foundation.Promise$thenInside$1
            final /* synthetic */ Promise<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Function1) obj, (Function1<Object, Unit>) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(final Function1<? super R, Unit> function1, final Function1<Object, Unit> function12) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(function1, "resolve");
                Intrinsics.checkNotNullParameter(function12, "reject");
                arrayList = ((Promise) this.this$0).thenCallbacks;
                final Function1<T, R> function13 = onfulfilled;
                final Function1<T, Promise<R>> function14 = onfulfilledPromise;
                final Function1<Object, R> function15 = onrejected;
                final Function1<Object, Promise<R>> function16 = onrejectedPromise;
                RTSArrayKt.push(arrayList, new Function3<PromiseStates, T, Object, Unit>() { // from class: com.bytedance.rts.foundation.Promise$thenInside$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((PromiseStates) obj, (PromiseStates) obj2, obj3);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PromiseStates promiseStates, T t, Object obj) {
                        Promise promise;
                        Intrinsics.checkNotNullParameter(promiseStates, "state");
                        try {
                            if (promiseStates == PromiseStates.RESOLVED) {
                                Function1<T, R> function17 = function13;
                                if (function17 != null) {
                                    if (t == null) {
                                        function1.invoke(function17.invoke((Object) null));
                                        return;
                                    } else {
                                        function1.invoke(function17.invoke(t));
                                        return;
                                    }
                                }
                                Function1<T, Promise<R>> function18 = function14;
                                if (function18 != null) {
                                    if (t == null) {
                                        promise = (Promise) function18.invoke((Object) null);
                                    } else {
                                        promise = (Promise) function18.invoke(t);
                                    }
                                    promise.then(function1, function12);
                                    return;
                                }
                                return;
                            }
                            Function1<Object, R> function19 = function15;
                            if (function19 == null && function16 == null) {
                                Function1<Object, Unit> function110 = function12;
                                Intrinsics.checkNotNull(obj);
                                function110.invoke(obj);
                            } else if (function19 != null) {
                                Intrinsics.checkNotNull(obj);
                                function1.invoke(function19.invoke(obj));
                            } else {
                                Function1<Object, Promise<R>> function111 = function16;
                                Intrinsics.checkNotNull(function111);
                                Intrinsics.checkNotNull(obj);
                                ((Promise) function111.invoke(obj)).then(function1, function12);
                            }
                        } catch (Error e) {
                            function12.invoke(e);
                        }
                    }
                });
                this.this$0.runThenCallbacks();
            }
        });
    }

    public static /* synthetic */ Promise then$default(Promise promise, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function12 = null;
        }
        return promise.then(function1, function12);
    }

    public final <R> Promise<R> then(Function1<? super T, ? extends R> onfulfilled, Function1<Object, ? extends R> onrejected) {
        Intrinsics.checkNotNullParameter(onfulfilled, "onfulfilled");
        return thenInside$default(this, onfulfilled, onrejected, null, null, 12, null);
    }

    public static /* synthetic */ Promise thenPromiseOnfulfilled$default(Promise promise, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function12 = null;
        }
        return promise.thenPromiseOnfulfilled(function1, function12);
    }

    public final <R> Promise<R> thenPromiseOnfulfilled(Function1<? super T, ? extends Promise<? extends R>> onfulfilled, Function1<Object, ? extends R> onrejected) {
        Intrinsics.checkNotNullParameter(onfulfilled, "onfulfilled");
        return thenInside$default(this, null, onrejected, onfulfilled, null, 9, null);
    }

    public static /* synthetic */ Promise thenPromiseOnrejected$default(Promise promise, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function12 = null;
        }
        return promise.thenPromiseOnrejected(function1, function12);
    }

    public final <R> Promise<R> thenPromiseOnrejected(Function1<? super T, ? extends R> onfulfilled, Function1<Object, ? extends Promise<? extends R>> onrejected) {
        Intrinsics.checkNotNullParameter(onfulfilled, "onfulfilled");
        return thenInside$default(this, onfulfilled, null, null, onrejected, 6, null);
    }

    public static /* synthetic */ Promise thenPromiseOnfulfilledOnrejected$default(Promise promise, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function12 = null;
        }
        return promise.thenPromiseOnfulfilledOnrejected(function1, function12);
    }

    public final <R> Promise<R> thenPromiseOnfulfilledOnrejected(Function1<? super T, ? extends Promise<? extends R>> onfulfilled, Function1<Object, ? extends Promise<? extends R>> onrejected) {
        Intrinsics.checkNotNullParameter(onfulfilled, "onfulfilled");
        return thenInside$default(this, null, null, onfulfilled, onrejected, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resolveInside(T value) {
        if (this.state != PromiseStates.PENDING) {
            return;
        }
        this.value = value;
        this.state = PromiseStates.RESOLVED;
        runThenCallbacks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void rejectInside(Object reason) {
        if (this.state != PromiseStates.PENDING) {
            return;
        }
        Intrinsics.checkNotNull(reason);
        this.reason = reason;
        this.state = PromiseStates.REJECTED;
        runThenCallbacks();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runThenCallbacks() {
        RTSMessageLooper rTSMessageLooper;
        if (this.state == PromiseStates.PENDING || (rTSMessageLooper = ThreadLocalLooper.INSTANCE.getLooper().get()) == null) {
            return;
        }
        rTSMessageLooper.postMicroTask$lib_release(new Function0<Unit>(this) { // from class: com.bytedance.rts.foundation.Promise$runThenCallbacks$1
            final /* synthetic */ Promise<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m826invoke();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Incorrect condition in loop: B:3:0x001c */
            /* renamed from: invoke, reason: collision with other method in class */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void m826invoke() {
                PromiseStates promiseStates;
                Object obj;
                Object obj2;
                ArrayList arrayList;
                ArrayList arrayList2;
                promiseStates = ((Promise) this.this$0).state;
                obj = ((Promise) this.this$0).value;
                obj2 = ((Promise) this.this$0).reason;
                while (RTSArrayKt.getLength(arrayList) > 0) {
                    arrayList2 = ((Promise) this.this$0).thenCallbacks;
                    Object shift = RTSArrayKt.shift(arrayList2);
                    Intrinsics.checkNotNull(shift);
                    ((Function3) shift).invoke(promiseStates, obj, obj2);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Promise catchInside$default(Promise promise, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function12 = null;
        }
        return promise.catchInside(function1, function12);
    }

    private final Promise<T> catchInside(final Function1<Object, ? extends T> onrejected, final Function1<Object, ? extends Promise<? extends T>> onrejectedPromise) {
        return new Promise<>(new Function2<Function1<? super T, ? extends Unit>, Function1<? super Object, ? extends Unit>, Unit>(this) { // from class: com.bytedance.rts.foundation.Promise$catchInside$1
            final /* synthetic */ Promise<T> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Function1) obj, (Function1<Object, Unit>) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(final Function1<? super T, Unit> function1, final Function1<Object, Unit> function12) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(function1, "resolve");
                Intrinsics.checkNotNullParameter(function12, "reject");
                arrayList = ((Promise) this.this$0).thenCallbacks;
                final Function1<Object, T> function13 = onrejected;
                final Function1<Object, Promise<T>> function14 = onrejectedPromise;
                final Promise<T> promise = this;
                RTSArrayKt.push(arrayList, new Function3<PromiseStates, T, Object, Unit>() { // from class: com.bytedance.rts.foundation.Promise$catchInside$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        invoke((PromiseStates) obj, (PromiseStates) obj2, obj3);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(PromiseStates promiseStates, T t, Object obj) {
                        PromiseStates promiseStates2;
                        Intrinsics.checkNotNullParameter(promiseStates, "state");
                        try {
                            if (promiseStates == PromiseStates.RESOLVED) {
                                if (t == null) {
                                    function1.invoke((Object) null);
                                    return;
                                } else {
                                    function1.invoke(t);
                                    return;
                                }
                            }
                            Function1<Object, T> function15 = function13;
                            if (function15 != null) {
                                Function1<T, Unit> function16 = function1;
                                Intrinsics.checkNotNull(obj);
                                function16.invoke(function15.invoke(obj));
                            }
                            Function1<Object, Promise<T>> function17 = function14;
                            if (function17 != null) {
                                Intrinsics.checkNotNull(obj);
                                ((Promise) function17.invoke(obj)).then(function1, function12);
                            }
                            promiseStates2 = ((Promise) promise).state;
                            if (promiseStates2 == PromiseStates.REJECTED) {
                                ((Promise) promise).state = PromiseStates.RESOLVED;
                            }
                        } catch (Error e) {
                            function12.invoke(e);
                        }
                    }
                });
                this.this$0.runThenCallbacks();
            }
        });
    }

    /* renamed from: catch, reason: not valid java name */
    public final Promise<T> m821catch(Function1<Object, ? extends T> onrejected) {
        Intrinsics.checkNotNullParameter(onrejected, "onrejected");
        return catchInside$default(this, onrejected, null, 2, null);
    }

    public final Promise<T> catchPromise(Function1<Object, ? extends Promise<? extends T>> onrejected) {
        Intrinsics.checkNotNullParameter(onrejected, "onrejected");
        return catchInside$default(this, null, onrejected, 1, null);
    }

    /* compiled from: RTSPromise.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JF\u0010\u0003\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00060\u0005j\b\u0012\u0004\u0012\u0002H\u0006`\u00070\u0004\"\u0004\b\u0001\u0010\u00062\"\u0010\b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u00040\u0005j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u0004`\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/rts/foundation/Promise$Companion;", "", "()V", "all", "Lcom/bytedance/rts/foundation/Promise;", "Ljava/util/ArrayList;", "T0", "Lcom/bytedance/rts/foundation/RTSArray;", "values", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T0> Promise<ArrayList<T0>> all(final ArrayList<Promise<T0>> values) {
            Intrinsics.checkNotNullParameter(values, "values");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            final ArrayList arrayList = new ArrayList(RTSArrayKt.getLength(values));
            RTSArrayKt.fill$default(arrayList, null, 0, 0, 6, null);
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = RTSArrayKt.getLength(values);
            return new Promise<>(new Function2<Function1<? super ArrayList<T0>, ? extends Unit>, Function1<? super Object, ? extends Unit>, Unit>() { // from class: com.bytedance.rts.foundation.Promise$Companion$all$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Function1) obj, (Function1<Object, Unit>) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(final Function1<? super ArrayList<T0>, Unit> function1, final Function1<Object, Unit> function12) {
                    Intrinsics.checkNotNullParameter(function1, "resolve");
                    Intrinsics.checkNotNullParameter(function12, "reject");
                    for (final int i = 0; i < RTSArrayKt.getLength(values); i++) {
                        Promise<T0> promise = values.get(i);
                        Intrinsics.checkNotNullExpressionValue(promise, "values[i]");
                        final ArrayList<Object> arrayList2 = arrayList;
                        final Ref.IntRef intRef2 = intRef;
                        Function1<T0, Unit> function13 = new Function1<T0, Unit>() { // from class: com.bytedance.rts.foundation.Promise$Companion$all$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                m824invoke((C07871) obj);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m824invoke(T0 t0) {
                                arrayList2.set(i, t0);
                                Ref.IntRef intRef3 = intRef2;
                                intRef3.element--;
                                int i2 = intRef2.element;
                                if (intRef2.element == 0) {
                                    Function1<ArrayList<T0>, Unit> function14 = function1;
                                    ArrayList<Object> arrayList3 = arrayList2;
                                    Intrinsics.checkNotNull(arrayList3, "null cannot be cast to non-null type java.util.ArrayList<T0 of com.bytedance.rts.foundation.Promise.Companion.all>{ com.bytedance.rts.foundation.RTSArrayKt.RTSArray<T0 of com.bytedance.rts.foundation.Promise.Companion.all> }");
                                    function14.invoke(arrayList3);
                                }
                            }
                        };
                        final Ref.ObjectRef<Object> objectRef2 = objectRef;
                        promise.then(function13, new Function1<Object, Unit>() { // from class: com.bytedance.rts.foundation.Promise$Companion$all$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                m825invoke(obj);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: collision with other method in class */
                            public final void m825invoke(Object obj) {
                                Intrinsics.checkNotNullParameter(obj, ISignalReportConstants.KEY_REASON);
                                if (objectRef2.element == null) {
                                    objectRef2.element = obj;
                                    function12.invoke(obj);
                                }
                            }
                        });
                    }
                }
            });
        }
    }
}
