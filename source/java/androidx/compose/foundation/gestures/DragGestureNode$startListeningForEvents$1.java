package androidx.compose.foundation.gestures;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.DragEvent;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Draggable.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1", f = "Draggable.kt", i = {0, 0, 1, 1, 2, 2, 3, 4, 5}, l = {436, 438, 440, 447, 449, 452}, m = "invokeSuspend", n = {"$this$launch", "event", "$this$launch", "event", "$this$launch", "event", "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$0", "L$0"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class DragGestureNode$startListeningForEvents$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DragGestureNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragGestureNode$startListeningForEvents$1(DragGestureNode dragGestureNode, Continuation<? super DragGestureNode$startListeningForEvents$1> continuation) {
        super(2, continuation);
        this.this$0 = dragGestureNode;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> dragGestureNode$startListeningForEvents$1 = new DragGestureNode$startListeningForEvents$1(this.this$0, continuation);
        dragGestureNode$startListeningForEvents$1.L$0 = obj;
        return dragGestureNode$startListeningForEvents$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:27|28|29|30|(2:35|(2:37|(1:39)))(2:32|(1:34))|8|(2:50|51)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0122, code lost:
    
        r1 = r0;
        r0 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0138, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0139, code lost:
    
        r9 = r0;
        r0 = r1;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0007. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00e1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ed A[Catch: CancellationException -> 0x0122, TryCatch #0 {CancellationException -> 0x0122, blocks: (B:30:0x00e7, B:32:0x00ed, B:35:0x0109, B:37:0x010f), top: B:29:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0109 A[Catch: CancellationException -> 0x0122, TryCatch #0 {CancellationException -> 0x0122, blocks: (B:30:0x00e7, B:32:0x00ed, B:35:0x0109, B:37:0x010f), top: B:29:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0138 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0142  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0106 -> B:8:0x006f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x010d -> B:8:0x006f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x011f -> B:8:0x006f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0139 -> B:8:0x006f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x013d -> B:8:0x006f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        DragGestureNode$startListeningForEvents$1 dragGestureNode$startListeningForEvents$1;
        CoroutineScope coroutineScope2;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        Object obj2;
        DragGestureNode$startListeningForEvents$1 dragGestureNode$startListeningForEvents$12;
        CoroutineScope coroutineScope3;
        Ref.ObjectRef objectRef3;
        CoroutineScope coroutineScope4;
        Object processDragCancel;
        Object processDragCancel2;
        Object processDragStop;
        DragEvent dragEvent;
        Object processDragStart;
        Channel channel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                dragGestureNode$startListeningForEvents$1 = this;
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                    Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
                    channel = dragGestureNode$startListeningForEvents$1.this$0.channel;
                    if (channel != null) {
                        dragGestureNode$startListeningForEvents$1.L$0 = coroutineScope;
                        dragGestureNode$startListeningForEvents$1.L$1 = objectRef4;
                        dragGestureNode$startListeningForEvents$1.L$2 = objectRef4;
                        dragGestureNode$startListeningForEvents$1.label = 1;
                        Object receive = channel.receive((Continuation) dragGestureNode$startListeningForEvents$1);
                        if (receive == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        coroutineScope2 = coroutineScope;
                        objectRef = objectRef4;
                        obj2 = coroutine_suspended;
                        dragGestureNode$startListeningForEvents$12 = dragGestureNode$startListeningForEvents$1;
                        obj = receive;
                        objectRef2 = objectRef;
                        dragEvent = (DragEvent) obj;
                        objectRef2.element = dragEvent;
                        if (objectRef.element instanceof DragEvent.DragStarted) {
                            dragGestureNode$startListeningForEvents$12.L$0 = coroutineScope2;
                            dragGestureNode$startListeningForEvents$12.L$1 = objectRef;
                            dragGestureNode$startListeningForEvents$12.L$2 = null;
                            dragGestureNode$startListeningForEvents$12.label = 2;
                            processDragStart = dragGestureNode$startListeningForEvents$12.this$0.processDragStart((DragEvent.DragStarted) objectRef.element, (Continuation) dragGestureNode$startListeningForEvents$12);
                            if (processDragStart == obj2) {
                                return obj2;
                            }
                            coroutineScope3 = coroutineScope2;
                            try {
                            } catch (CancellationException unused) {
                                coroutineScope = coroutineScope3;
                                dragGestureNode$startListeningForEvents$12.L$0 = coroutineScope;
                                dragGestureNode$startListeningForEvents$12.L$1 = null;
                                dragGestureNode$startListeningForEvents$12.label = 6;
                                processDragCancel = dragGestureNode$startListeningForEvents$12.this$0.processDragCancel((Continuation) dragGestureNode$startListeningForEvents$12);
                                if (processDragCancel != obj2) {
                                }
                            }
                            dragGestureNode$startListeningForEvents$12.L$0 = coroutineScope3;
                            dragGestureNode$startListeningForEvents$12.L$1 = objectRef;
                            dragGestureNode$startListeningForEvents$12.label = 3;
                            if (dragGestureNode$startListeningForEvents$12.this$0.drag(new C02681(objectRef, dragGestureNode$startListeningForEvents$12.this$0, null), (Continuation) dragGestureNode$startListeningForEvents$12) != obj2) {
                                return obj2;
                            }
                            dragGestureNode$startListeningForEvents$1 = dragGestureNode$startListeningForEvents$12;
                            coroutine_suspended = obj2;
                            objectRef3 = objectRef;
                            coroutineScope = coroutineScope3;
                            if (objectRef3.element instanceof DragEvent.DragStopped) {
                                DragGestureNode dragGestureNode = dragGestureNode$startListeningForEvents$1.this$0;
                                Object obj3 = objectRef3.element;
                                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type androidx.compose.foundation.gestures.DragEvent.DragStopped");
                                dragGestureNode$startListeningForEvents$1.L$0 = coroutineScope;
                                dragGestureNode$startListeningForEvents$1.L$1 = null;
                                dragGestureNode$startListeningForEvents$1.label = 4;
                                processDragStop = dragGestureNode.processDragStop((DragEvent.DragStopped) obj3, (Continuation) dragGestureNode$startListeningForEvents$1);
                                if (processDragStop == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (objectRef3.element instanceof DragEvent.DragCancelled) {
                                dragGestureNode$startListeningForEvents$1.L$0 = coroutineScope;
                                dragGestureNode$startListeningForEvents$1.L$1 = null;
                                dragGestureNode$startListeningForEvents$1.label = 5;
                                processDragCancel2 = dragGestureNode$startListeningForEvents$1.this$0.processDragCancel((Continuation) dragGestureNode$startListeningForEvents$1);
                                if (processDragCancel2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            if (!CoroutineScopeKt.isActive(coroutineScope)) {
                                return Unit.INSTANCE;
                            }
                        } else {
                            dragGestureNode$startListeningForEvents$1 = dragGestureNode$startListeningForEvents$12;
                            coroutine_suspended = obj2;
                            coroutineScope = coroutineScope2;
                            if (!CoroutineScopeKt.isActive(coroutineScope)) {
                            }
                        }
                    } else {
                        objectRef2 = objectRef4;
                        coroutineScope2 = coroutineScope;
                        obj2 = coroutine_suspended;
                        objectRef = objectRef2;
                        dragGestureNode$startListeningForEvents$12 = dragGestureNode$startListeningForEvents$1;
                        dragEvent = null;
                        objectRef2.element = dragEvent;
                        if (objectRef.element instanceof DragEvent.DragStarted) {
                        }
                    }
                }
                break;
            case 1:
                Ref.ObjectRef objectRef5 = (Ref.ObjectRef) this.L$2;
                Ref.ObjectRef objectRef6 = (Ref.ObjectRef) this.L$1;
                CoroutineScope coroutineScope5 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope2 = coroutineScope5;
                objectRef = objectRef6;
                objectRef2 = objectRef5;
                obj2 = coroutine_suspended;
                dragGestureNode$startListeningForEvents$12 = this;
                dragEvent = (DragEvent) obj;
                objectRef2.element = dragEvent;
                if (objectRef.element instanceof DragEvent.DragStarted) {
                }
                break;
            case 2:
                Ref.ObjectRef objectRef7 = (Ref.ObjectRef) this.L$1;
                coroutineScope3 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                objectRef = objectRef7;
                obj2 = coroutine_suspended;
                dragGestureNode$startListeningForEvents$12 = this;
                dragGestureNode$startListeningForEvents$12.L$0 = coroutineScope3;
                dragGestureNode$startListeningForEvents$12.L$1 = objectRef;
                dragGestureNode$startListeningForEvents$12.label = 3;
                if (dragGestureNode$startListeningForEvents$12.this$0.drag(new C02681(objectRef, dragGestureNode$startListeningForEvents$12.this$0, null), (Continuation) dragGestureNode$startListeningForEvents$12) != obj2) {
                }
                break;
            case 3:
                objectRef3 = (Ref.ObjectRef) this.L$1;
                coroutineScope3 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    dragGestureNode$startListeningForEvents$1 = this;
                } catch (CancellationException unused2) {
                    obj2 = coroutine_suspended;
                    coroutineScope = coroutineScope3;
                    dragGestureNode$startListeningForEvents$12 = this;
                    dragGestureNode$startListeningForEvents$12.L$0 = coroutineScope;
                    dragGestureNode$startListeningForEvents$12.L$1 = null;
                    dragGestureNode$startListeningForEvents$12.label = 6;
                    processDragCancel = dragGestureNode$startListeningForEvents$12.this$0.processDragCancel((Continuation) dragGestureNode$startListeningForEvents$12);
                    if (processDragCancel != obj2) {
                    }
                }
                coroutineScope = coroutineScope3;
                if (objectRef3.element instanceof DragEvent.DragStopped) {
                }
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                }
                break;
            case 4:
                coroutineScope4 = (CoroutineScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    dragGestureNode$startListeningForEvents$1 = this;
                    coroutineScope = coroutineScope4;
                } catch (CancellationException unused3) {
                    coroutineScope = coroutineScope4;
                    obj2 = coroutine_suspended;
                    dragGestureNode$startListeningForEvents$12 = this;
                    dragGestureNode$startListeningForEvents$12.L$0 = coroutineScope;
                    dragGestureNode$startListeningForEvents$12.L$1 = null;
                    dragGestureNode$startListeningForEvents$12.label = 6;
                    processDragCancel = dragGestureNode$startListeningForEvents$12.this$0.processDragCancel((Continuation) dragGestureNode$startListeningForEvents$12);
                    if (processDragCancel != obj2) {
                    }
                }
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                }
                break;
            case 5:
                coroutineScope4 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                dragGestureNode$startListeningForEvents$1 = this;
                coroutineScope = coroutineScope4;
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                }
                break;
            case 6:
                coroutineScope4 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                dragGestureNode$startListeningForEvents$1 = this;
                coroutineScope = coroutineScope4;
                if (!CoroutineScopeKt.isActive(coroutineScope)) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Draggable.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "processDelta", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "dragDelta"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1", f = "Draggable.kt", i = {0}, l = {443}, m = "invokeSuspend", n = {"processDelta"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureNode$startListeningForEvents$1$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public static final class C02681 extends SuspendLambda implements Function2<Function1<? super DragEvent.DragDelta, ? extends Unit>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<DragEvent> $event;
        /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ DragGestureNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02681(Ref.ObjectRef<DragEvent> objectRef, DragGestureNode dragGestureNode, Continuation<? super C02681> continuation) {
            super(2, continuation);
            this.$event = objectRef;
            this.this$0 = dragGestureNode;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> c02681 = new C02681(this.$event, this.this$0, continuation);
            c02681.L$0 = obj;
            return c02681;
        }

        public final Object invoke(Function1<? super DragEvent.DragDelta, Unit> function1, Continuation<? super Unit> continuation) {
            return create(function1, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0056 -> B:6:0x0075). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0068 -> B:5:0x006e). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Function1 function1;
            C02681 c02681;
            Channel channel;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                function1 = (Function1) this.L$0;
                c02681 = this;
                if (c02681.$event.element instanceof DragEvent.DragStopped) {
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Ref.ObjectRef<DragEvent> objectRef = (Ref.ObjectRef) this.L$1;
            Function1 function12 = (Function1) this.L$0;
            ResultKt.throwOnFailure(obj);
            Function1 function13 = function12;
            Ref.ObjectRef<DragEvent> objectRef2 = objectRef;
            Object obj2 = coroutine_suspended;
            C02681 c026812 = this;
            DragEvent dragEvent = (DragEvent) obj;
            c02681 = c026812;
            coroutine_suspended = obj2;
            Ref.ObjectRef<DragEvent> objectRef3 = objectRef2;
            function1 = function13;
            objectRef3.element = dragEvent;
            if ((c02681.$event.element instanceof DragEvent.DragStopped) && !(c02681.$event.element instanceof DragEvent.DragCancelled)) {
                Object obj3 = c02681.$event.element;
                dragEvent = null;
                DragEvent.DragDelta dragDelta = obj3 instanceof DragEvent.DragDelta ? (DragEvent.DragDelta) obj3 : null;
                if (dragDelta != null) {
                    function1.invoke(dragDelta);
                }
                objectRef3 = c02681.$event;
                channel = c02681.this$0.channel;
                if (channel != null) {
                    c02681.L$0 = function1;
                    c02681.L$1 = objectRef3;
                    c02681.label = 1;
                    Object receive = channel.receive((Continuation) c02681);
                    if (receive == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Object obj4 = coroutine_suspended;
                    c026812 = c02681;
                    obj = receive;
                    function13 = function1;
                    objectRef2 = objectRef3;
                    obj2 = obj4;
                    DragEvent dragEvent2 = (DragEvent) obj;
                    c02681 = c026812;
                    coroutine_suspended = obj2;
                    Ref.ObjectRef<DragEvent> objectRef32 = objectRef2;
                    function1 = function13;
                }
                objectRef32.element = dragEvent2;
                if (c02681.$event.element instanceof DragEvent.DragStopped) {
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }
}
