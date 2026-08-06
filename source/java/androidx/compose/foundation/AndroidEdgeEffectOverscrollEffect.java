package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.p002ui.geometry.InlineClassHelperKt;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.geometry.SizeKt;
import androidx.compose.p002ui.graphics.ColorKt;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.p002ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.p002ui.input.pointer.PointerEventPass;
import androidx.compose.p002ui.input.pointer.PointerId;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.compose.p002ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;

/* compiled from: AndroidOverscroll.android.kt */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0$H\u0016¢\u0006\u0004\b%\u0010&J<\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\"\u0010*\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0,\u0012\u0006\u0012\u0004\u0018\u00010-0+H\u0096@¢\u0006\u0004\b.\u0010/J\u0017\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u000201H\u0000¢\u0006\u0004\b5\u00106J\u000f\u00109\u001a\u00020\rH\u0000¢\u0006\u0004\b:\u0010;J\r\u0010B\u001a\u00020\u0013H\u0000¢\u0006\u0002\bCJ\b\u0010D\u001a\u00020\u0013H\u0002J\u0017\u0010E\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\bF\u0010GJ\u0017\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bK\u0010LJ\u0017\u0010M\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bN\u0010LJ\u0017\u0010O\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bP\u0010LJ\u0017\u0010Q\u001a\u00020I2\u0006\u0010J\u001a\u00020\rH\u0002¢\u0006\u0004\bR\u0010LR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00178\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u000201X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u00102\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u001bR\u0010\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020?X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A¨\u0006S"}, d2 = {"Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "Landroidx/compose/foundation/OverscrollEffect;", "context", "Landroid/content/Context;", "density", "Landroidx/compose/ui/unit/Density;", "glowColor", "Landroidx/compose/ui/graphics/Color;", "glowDrawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "<init>", "(Landroid/content/Context;Landroidx/compose/ui/unit/Density;JLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "J", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "redrawSignal", "Landroidx/compose/runtime/MutableState;", "", "getRedrawSignal$foundation_release", "()Landroidx/compose/runtime/MutableState;", "invalidationEnabled", "", "getInvalidationEnabled$foundation_release$annotations", "()V", "getInvalidationEnabled$foundation_release", "()Z", "setInvalidationEnabled$foundation_release", "(Z)V", "scrollCycleInProgress", "applyToScroll", "delta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "performScroll", "Lkotlin/Function1;", "applyToScroll-Rhakbz0", "(JILkotlin/jvm/functions/Function1;)J", "applyToFling", "velocity", "Landroidx/compose/ui/unit/Velocity;", "performFling", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "applyToFling-BMRW4eQ", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "containerSize", "Landroidx/compose/ui/geometry/Size;", "isInProgress", "updateSize", "size", "updateSize-uvyYCjk$foundation_release", "(J)V", "pointerId", "Landroidx/compose/ui/input/pointer/PointerId;", "displacement", "displacement-F1C5BW0$foundation_release", "()J", "pointerInputNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "getNode", "()Landroidx/compose/ui/node/DelegatableNode;", "invalidateOverscroll", "invalidateOverscroll$foundation_release", "animateToReleaseIfNeeded", "releaseOppositeOverscroll", "releaseOppositeOverscroll-k-4lQ0M", "(J)Z", "pullTop", "", "scroll", "pullTop-k-4lQ0M", "(J)F", "pullBottom", "pullBottom-k-4lQ0M", "pullLeft", "pullLeft-k-4lQ0M", "pullRight", "pullRight-k-4lQ0M", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class AndroidEdgeEffectOverscrollEffect implements OverscrollEffect {
    public static final int $stable = 0;
    private long containerSize;
    private final Density density;
    private final EdgeEffectWrapper edgeEffectWrapper;
    private boolean invalidationEnabled;
    private final DelegatableNode node;
    private long pointerId;
    private final SuspendingPointerInputModifierNode pointerInputNode;
    private long pointerPosition;
    private final MutableState<Unit> redrawSignal;
    private boolean scrollCycleInProgress;

    public /* synthetic */ AndroidEdgeEffectOverscrollEffect(Context context, Density density, long j, PaddingValues paddingValues, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, density, j, paddingValues);
    }

    public static /* synthetic */ void getInvalidationEnabled$foundation_release$annotations() {
    }

    private AndroidEdgeEffectOverscrollEffect(Context context, Density density, long j, PaddingValues paddingValues) {
        DelegatableNode glowOverscrollNode;
        this.density = density;
        this.pointerPosition = Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
        EdgeEffectWrapper edgeEffectWrapper = new EdgeEffectWrapper(context, ColorKt.m4893toArgb8_81llA(j));
        this.edgeEffectWrapper = edgeEffectWrapper;
        this.redrawSignal = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        this.invalidationEnabled = true;
        this.containerSize = Size.INSTANCE.m4671getZeroNHjbRc();
        this.pointerId = PointerId.m6124constructorimpl(-1L);
        DelegatableNode SuspendingPointerInputModifierNode = SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new PointerInputEventHandler() { // from class: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1

            /* compiled from: AndroidOverscroll.android.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
            @DebugMetadata(c = "androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1$1", f = "AndroidOverscroll.android.kt", i = {0, 1}, l = {783, 787}, m = "invokeSuspend", n = {"$this$awaitEachGesture", "$this$awaitEachGesture"}, s = {"L$0", "L$0"})
            /* renamed from: androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect$pointerInputNode$1$1 */
            /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
            static final class C02181 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ AndroidEdgeEffectOverscrollEffect this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C02181(AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect, Continuation<? super C02181> continuation) {
                    super(2, continuation);
                    this.this$0 = androidEdgeEffectOverscrollEffect;
                }

                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    Continuation<Unit> c02181 = new C02181(this.this$0, continuation);
                    c02181.L$0 = obj;
                    return c02181;
                }

                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                    return create(awaitPointerEventScope, continuation).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x00a7  */
                /* JADX WARN: Removed duplicated region for block: B:23:0x00c7  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
                /* JADX WARN: Removed duplicated region for block: B:28:0x00e9  */
                /* JADX WARN: Removed duplicated region for block: B:31:0x00f7  */
                /* JADX WARN: Removed duplicated region for block: B:34:0x0069 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:35:0x00c2 A[SYNTHETIC] */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0084  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0067 -> B:6:0x006a). Please report as a decompilation issue!!! */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    AwaitPointerEventScope awaitPointerEventScope;
                    Object awaitFirstDown$default;
                    C02181 c02181;
                    Object awaitPointerEvent$default;
                    int size;
                    int i;
                    int i2;
                    int size2;
                    Object obj2;
                    PointerInputChange pointerInputChange;
                    long j;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    int i4 = 2;
                    PointerEventPass pointerEventPass = null;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        this.L$0 = awaitPointerEventScope;
                        this.label = 1;
                        awaitFirstDown$default = TapGestureDetectorKt.awaitFirstDown$default(awaitPointerEventScope, false, null, (Continuation) this, 2, null);
                        if (awaitFirstDown$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i3 == 1) {
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        awaitFirstDown$default = obj;
                    } else {
                        if (i3 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        awaitPointerEvent$default = obj;
                        c02181 = this;
                        List<PointerInputChange> changes = ((PointerEvent) awaitPointerEvent$default).getChanges();
                        ArrayList arrayList = new ArrayList(changes.size());
                        size = changes.size();
                        i = 0;
                        for (i2 = 0; i2 < size; i2++) {
                            PointerInputChange pointerInputChange2 = changes.get(i2);
                            if (pointerInputChange2.getPressed()) {
                                arrayList.add(pointerInputChange2);
                            }
                        }
                        ArrayList arrayList2 = arrayList;
                        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect = c02181.this$0;
                        size2 = arrayList2.size();
                        while (true) {
                            if (i >= size2) {
                                obj2 = null;
                                break;
                            }
                            obj2 = arrayList2.get(i);
                            long id = ((PointerInputChange) obj2).getId();
                            j = androidEdgeEffectOverscrollEffect.pointerId;
                            if (PointerId.m6126equalsimpl0(id, j)) {
                                break;
                            }
                            i++;
                        }
                        pointerInputChange = (PointerInputChange) obj2;
                        if (pointerInputChange == null) {
                            pointerInputChange = (PointerInputChange) CollectionsKt.firstOrNull(arrayList2);
                        }
                        if (pointerInputChange != null) {
                            c02181.this$0.pointerId = pointerInputChange.getId();
                            c02181.this$0.pointerPosition = pointerInputChange.getPosition();
                        }
                        if (!(!r9.isEmpty())) {
                            c02181.this$0.pointerId = PointerId.m6124constructorimpl(-1L);
                            return Unit.INSTANCE;
                        }
                        i4 = 2;
                        pointerEventPass = null;
                        c02181.L$0 = awaitPointerEventScope;
                        c02181.label = i4;
                        awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, pointerEventPass, (Continuation) c02181, 1, pointerEventPass);
                        if (awaitPointerEvent$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        List<PointerInputChange> changes2 = ((PointerEvent) awaitPointerEvent$default).getChanges();
                        ArrayList arrayList3 = new ArrayList(changes2.size());
                        size = changes2.size();
                        i = 0;
                        while (i2 < size) {
                        }
                        ArrayList arrayList22 = arrayList3;
                        AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect2 = c02181.this$0;
                        size2 = arrayList22.size();
                        while (true) {
                            if (i >= size2) {
                            }
                            i++;
                        }
                        pointerInputChange = (PointerInputChange) obj2;
                        if (pointerInputChange == null) {
                        }
                        if (pointerInputChange != null) {
                        }
                        if (!(!r9.isEmpty())) {
                        }
                    }
                    PointerInputChange pointerInputChange3 = (PointerInputChange) awaitFirstDown$default;
                    this.this$0.pointerId = pointerInputChange3.getId();
                    this.this$0.pointerPosition = pointerInputChange3.getPosition();
                    c02181 = this;
                    c02181.L$0 = awaitPointerEventScope;
                    c02181.label = i4;
                    awaitPointerEvent$default = AwaitPointerEventScope.awaitPointerEvent$default(awaitPointerEventScope, pointerEventPass, (Continuation) c02181, 1, pointerEventPass);
                    if (awaitPointerEvent$default == coroutine_suspended) {
                    }
                    List<PointerInputChange> changes22 = ((PointerEvent) awaitPointerEvent$default).getChanges();
                    ArrayList arrayList32 = new ArrayList(changes22.size());
                    size = changes22.size();
                    i = 0;
                    while (i2 < size) {
                    }
                    ArrayList arrayList222 = arrayList32;
                    AndroidEdgeEffectOverscrollEffect androidEdgeEffectOverscrollEffect22 = c02181.this$0;
                    size2 = arrayList222.size();
                    while (true) {
                        if (i >= size2) {
                        }
                        i++;
                    }
                    pointerInputChange = (PointerInputChange) obj2;
                    if (pointerInputChange == null) {
                    }
                    if (pointerInputChange != null) {
                    }
                    if (!(!r9.isEmpty())) {
                    }
                }
            }

            @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
            public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                Object awaitEachGesture = ForEachGestureKt.awaitEachGesture(pointerInputScope, new C02181(AndroidEdgeEffectOverscrollEffect.this, null), continuation);
                return awaitEachGesture == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? awaitEachGesture : Unit.INSTANCE;
            }
        });
        this.pointerInputNode = SuspendingPointerInputModifierNode;
        if (Build.VERSION.SDK_INT >= 31) {
            glowOverscrollNode = (DelegatableNode) new StretchOverscrollNode(SuspendingPointerInputModifierNode, this, edgeEffectWrapper);
        } else {
            glowOverscrollNode = new GlowOverscrollNode(SuspendingPointerInputModifierNode, this, edgeEffectWrapper, paddingValues);
        }
        this.node = glowOverscrollNode;
    }

    public final MutableState<Unit> getRedrawSignal$foundation_release() {
        return this.redrawSignal;
    }

    /* renamed from: getInvalidationEnabled$foundation_release, reason: from getter */
    public final boolean getInvalidationEnabled() {
        return this.invalidationEnabled;
    }

    public final void setInvalidationEnabled$foundation_release(boolean z) {
        this.invalidationEnabled = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x01e9, code lost:
    
        if ((java.lang.Float.intBitsToFloat((int) (r6 & 4294967295L)) == 0.0f) == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x020e, code lost:
    
        if ((java.lang.Float.intBitsToFloat((int) (r14 & 4294967295L)) == 0.0f) == false) goto L112;
     */
    /* JADX WARN: Removed duplicated region for block: B:127:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0280 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02a0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0114  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToScroll-Rhakbz0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long mo372applyToScrollRhakbz0(long delta, int source, Function1<? super Offset, Offset> performScroll) {
        float m366pullBottomk4lQ0M;
        float intBitsToFloat;
        int i;
        float intBitsToFloat2;
        long m4585constructorimpl;
        long m4597minusMKHz9U;
        long m4603unboximpl;
        EdgeEffectWrapper edgeEffectWrapper;
        boolean z;
        boolean z2;
        int i2;
        boolean z3;
        if (Size.m4664isEmptyimpl(this.containerSize)) {
            return ((Offset) performScroll.invoke(Offset.m4582boximpl(delta))).m4603unboximpl();
        }
        if (!this.scrollCycleInProgress) {
            if (this.edgeEffectWrapper.isLeftStretched()) {
                m367pullLeftk4lQ0M(Offset.INSTANCE.m4609getZeroF1C5BW0());
            }
            if (this.edgeEffectWrapper.isRightStretched()) {
                m368pullRightk4lQ0M(Offset.INSTANCE.m4609getZeroF1C5BW0());
            }
            if (this.edgeEffectWrapper.isTopStretched()) {
                m369pullTopk4lQ0M(Offset.INSTANCE.m4609getZeroF1C5BW0());
            }
            if (this.edgeEffectWrapper.isBottomStretched()) {
                m366pullBottomk4lQ0M(Offset.INSTANCE.m4609getZeroF1C5BW0());
            }
            this.scrollCycleInProgress = true;
        }
        float m392access$destretchMultiplierGyEprt8 = AndroidOverscroll_androidKt.m392access$destretchMultiplierGyEprt8(source);
        long m4600timestuRUvjQ = Offset.m4600timestuRUvjQ(delta, m392access$destretchMultiplierGyEprt8);
        int i3 = (int) (delta & 4294967295L);
        if (!(Float.intBitsToFloat(i3) == 0.0f)) {
            if (this.edgeEffectWrapper.isTopStretched() && Float.intBitsToFloat(i3) < 0.0f) {
                m366pullBottomk4lQ0M = m369pullTopk4lQ0M(m4600timestuRUvjQ);
                if (!this.edgeEffectWrapper.isTopStretched()) {
                    this.edgeEffectWrapper.getOrCreateTopEffect().finish();
                }
                if (m366pullBottomk4lQ0M == Float.intBitsToFloat((int) (m4600timestuRUvjQ & 4294967295L))) {
                    intBitsToFloat = Float.intBitsToFloat(i3);
                }
                intBitsToFloat = m366pullBottomk4lQ0M / m392access$destretchMultiplierGyEprt8;
            } else if (this.edgeEffectWrapper.isBottomStretched() && Float.intBitsToFloat(i3) > 0.0f) {
                m366pullBottomk4lQ0M = m366pullBottomk4lQ0M(m4600timestuRUvjQ);
                if (!this.edgeEffectWrapper.isBottomStretched()) {
                    this.edgeEffectWrapper.getOrCreateBottomEffect().finish();
                }
                if (m366pullBottomk4lQ0M == Float.intBitsToFloat((int) (m4600timestuRUvjQ & 4294967295L))) {
                    intBitsToFloat = Float.intBitsToFloat(i3);
                }
                intBitsToFloat = m366pullBottomk4lQ0M / m392access$destretchMultiplierGyEprt8;
            }
            i = (int) (delta >> 32);
            if (!(Float.intBitsToFloat(i) != 0.0f)) {
                if (this.edgeEffectWrapper.isLeftStretched() && Float.intBitsToFloat(i) < 0.0f) {
                    float m367pullLeftk4lQ0M = m367pullLeftk4lQ0M(m4600timestuRUvjQ);
                    if (!this.edgeEffectWrapper.isLeftStretched()) {
                        this.edgeEffectWrapper.getOrCreateLeftEffect().finish();
                    }
                    intBitsToFloat2 = (m367pullLeftk4lQ0M > Float.intBitsToFloat((int) (m4600timestuRUvjQ >> 32)) ? 1 : (m367pullLeftk4lQ0M == Float.intBitsToFloat((int) (m4600timestuRUvjQ >> 32)) ? 0 : -1)) == 0 ? Float.intBitsToFloat(i) : m367pullLeftk4lQ0M / m392access$destretchMultiplierGyEprt8;
                } else if (this.edgeEffectWrapper.isRightStretched() && Float.intBitsToFloat(i) > 0.0f) {
                    float m368pullRightk4lQ0M = m368pullRightk4lQ0M(m4600timestuRUvjQ);
                    if (!this.edgeEffectWrapper.isRightStretched()) {
                        this.edgeEffectWrapper.getOrCreateRightEffect().finish();
                    }
                    intBitsToFloat2 = (m368pullRightk4lQ0M > Float.intBitsToFloat((int) (m4600timestuRUvjQ >> 32)) ? 1 : (m368pullRightk4lQ0M == Float.intBitsToFloat((int) (m4600timestuRUvjQ >> 32)) ? 0 : -1)) == 0 ? Float.intBitsToFloat(i) : m368pullRightk4lQ0M / m392access$destretchMultiplierGyEprt8;
                }
                m4585constructorimpl = Offset.m4585constructorimpl((Float.floatToRawIntBits(intBitsToFloat2) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L));
                if (!Offset.m4590equalsimpl0(m4585constructorimpl, Offset.INSTANCE.m4609getZeroF1C5BW0())) {
                    invalidateOverscroll$foundation_release();
                }
                m4597minusMKHz9U = Offset.m4597minusMKHz9U(delta, m4585constructorimpl);
                m4603unboximpl = ((Offset) performScroll.invoke(Offset.m4582boximpl(m4597minusMKHz9U))).m4603unboximpl();
                long m4597minusMKHz9U2 = Offset.m4597minusMKHz9U(m4597minusMKHz9U, m4603unboximpl);
                if (Float.intBitsToFloat((int) (m4597minusMKHz9U >> 32)) == 0.0f) {
                }
                if (Float.intBitsToFloat((int) (m4603unboximpl >> 32)) == 0.0f) {
                }
                edgeEffectWrapper = this.edgeEffectWrapper;
                if (!edgeEffectWrapper.isLeftStretched() || edgeEffectWrapper.isTopStretched() || edgeEffectWrapper.isRightStretched() || edgeEffectWrapper.isBottomStretched()) {
                    animateToReleaseIfNeeded();
                }
                if (NestedScrollSource.m6020equalsimpl0(source, NestedScrollSource.INSTANCE.m6032getUserInputWNlRxjI())) {
                    int i4 = (int) (m4597minusMKHz9U2 >> 32);
                    if (Float.intBitsToFloat(i4) > 0.5f) {
                        m367pullLeftk4lQ0M(m4597minusMKHz9U2);
                    } else if (Float.intBitsToFloat(i4) < -0.5f) {
                        m368pullRightk4lQ0M(m4597minusMKHz9U2);
                    } else {
                        z2 = false;
                        i2 = (int) (4294967295L & m4597minusMKHz9U2);
                        if (Float.intBitsToFloat(i2) <= 0.5f) {
                            m369pullTopk4lQ0M(m4597minusMKHz9U2);
                        } else if (Float.intBitsToFloat(i2) < -0.5f) {
                            m366pullBottomk4lQ0M(m4597minusMKHz9U2);
                        } else {
                            z3 = false;
                            if (!z2 || z3) {
                                z = true;
                                if (!Offset.m4590equalsimpl0(m4597minusMKHz9U, Offset.INSTANCE.m4609getZeroF1C5BW0())) {
                                    z = m370releaseOppositeOverscrollk4lQ0M(delta) || z;
                                }
                                if (z) {
                                    invalidateOverscroll$foundation_release();
                                }
                                return Offset.m4598plusMKHz9U(m4585constructorimpl, m4603unboximpl);
                            }
                        }
                        z3 = true;
                        if (!z2) {
                        }
                        z = true;
                        if (!Offset.m4590equalsimpl0(m4597minusMKHz9U, Offset.INSTANCE.m4609getZeroF1C5BW0())) {
                        }
                        if (z) {
                        }
                        return Offset.m4598plusMKHz9U(m4585constructorimpl, m4603unboximpl);
                    }
                    z2 = true;
                    i2 = (int) (4294967295L & m4597minusMKHz9U2);
                    if (Float.intBitsToFloat(i2) <= 0.5f) {
                    }
                    z3 = true;
                    if (!z2) {
                    }
                    z = true;
                    if (!Offset.m4590equalsimpl0(m4597minusMKHz9U, Offset.INSTANCE.m4609getZeroF1C5BW0())) {
                    }
                    if (z) {
                    }
                    return Offset.m4598plusMKHz9U(m4585constructorimpl, m4603unboximpl);
                }
                z = false;
                if (!Offset.m4590equalsimpl0(m4597minusMKHz9U, Offset.INSTANCE.m4609getZeroF1C5BW0())) {
                }
                if (z) {
                }
                return Offset.m4598plusMKHz9U(m4585constructorimpl, m4603unboximpl);
            }
            intBitsToFloat2 = 0.0f;
            m4585constructorimpl = Offset.m4585constructorimpl((Float.floatToRawIntBits(intBitsToFloat2) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L));
            if (!Offset.m4590equalsimpl0(m4585constructorimpl, Offset.INSTANCE.m4609getZeroF1C5BW0())) {
            }
            m4597minusMKHz9U = Offset.m4597minusMKHz9U(delta, m4585constructorimpl);
            m4603unboximpl = ((Offset) performScroll.invoke(Offset.m4582boximpl(m4597minusMKHz9U))).m4603unboximpl();
            long m4597minusMKHz9U22 = Offset.m4597minusMKHz9U(m4597minusMKHz9U, m4603unboximpl);
            if (Float.intBitsToFloat((int) (m4597minusMKHz9U >> 32)) == 0.0f) {
            }
            if (Float.intBitsToFloat((int) (m4603unboximpl >> 32)) == 0.0f) {
            }
            edgeEffectWrapper = this.edgeEffectWrapper;
            if (!edgeEffectWrapper.isLeftStretched()) {
            }
            animateToReleaseIfNeeded();
            if (NestedScrollSource.m6020equalsimpl0(source, NestedScrollSource.INSTANCE.m6032getUserInputWNlRxjI())) {
            }
            z = false;
            if (!Offset.m4590equalsimpl0(m4597minusMKHz9U, Offset.INSTANCE.m4609getZeroF1C5BW0())) {
            }
            if (z) {
            }
            return Offset.m4598plusMKHz9U(m4585constructorimpl, m4603unboximpl);
        }
        intBitsToFloat = 0.0f;
        i = (int) (delta >> 32);
        if (!(Float.intBitsToFloat(i) != 0.0f)) {
        }
        intBitsToFloat2 = 0.0f;
        m4585constructorimpl = Offset.m4585constructorimpl((Float.floatToRawIntBits(intBitsToFloat2) << 32) | (Float.floatToRawIntBits(intBitsToFloat) & 4294967295L));
        if (!Offset.m4590equalsimpl0(m4585constructorimpl, Offset.INSTANCE.m4609getZeroF1C5BW0())) {
        }
        m4597minusMKHz9U = Offset.m4597minusMKHz9U(delta, m4585constructorimpl);
        m4603unboximpl = ((Offset) performScroll.invoke(Offset.m4582boximpl(m4597minusMKHz9U))).m4603unboximpl();
        long m4597minusMKHz9U222 = Offset.m4597minusMKHz9U(m4597minusMKHz9U, m4603unboximpl);
        if (Float.intBitsToFloat((int) (m4597minusMKHz9U >> 32)) == 0.0f) {
        }
        if (Float.intBitsToFloat((int) (m4603unboximpl >> 32)) == 0.0f) {
        }
        edgeEffectWrapper = this.edgeEffectWrapper;
        if (!edgeEffectWrapper.isLeftStretched()) {
        }
        animateToReleaseIfNeeded();
        if (NestedScrollSource.m6020equalsimpl0(source, NestedScrollSource.INSTANCE.m6032getUserInputWNlRxjI())) {
        }
        z = false;
        if (!Offset.m4590equalsimpl0(m4597minusMKHz9U, Offset.INSTANCE.m4609getZeroF1C5BW0())) {
        }
        if (z) {
        }
        return Offset.m4598plusMKHz9U(m4585constructorimpl, m4603unboximpl);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: applyToFling-BMRW4eQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo371applyToFlingBMRW4eQ(long j, Function2<? super Velocity, ? super Continuation<? super Velocity>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        AndroidEdgeEffectOverscrollEffect$applyToFling$1 androidEdgeEffectOverscrollEffect$applyToFling$1;
        int i;
        float f;
        float f2;
        long j2;
        long j3;
        if (continuation instanceof AndroidEdgeEffectOverscrollEffect$applyToFling$1) {
            androidEdgeEffectOverscrollEffect$applyToFling$1 = (AndroidEdgeEffectOverscrollEffect$applyToFling$1) continuation;
            if ((androidEdgeEffectOverscrollEffect$applyToFling$1.label & Integer.MIN_VALUE) != 0) {
                androidEdgeEffectOverscrollEffect$applyToFling$1.label -= Integer.MIN_VALUE;
                Object obj = androidEdgeEffectOverscrollEffect$applyToFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j2 = androidEdgeEffectOverscrollEffect$applyToFling$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    j3 = Velocity.minus-AH228Gc(j2, ((Velocity) obj).unbox-impl());
                    this.scrollCycleInProgress = false;
                    if (Velocity.getX-impl(j3) <= 0.0f) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateLeftEffect(), MathKt.roundToInt(Velocity.getX-impl(j3)));
                    } else if (Velocity.getX-impl(j3) < 0.0f) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateRightEffect(), -MathKt.roundToInt(Velocity.getX-impl(j3)));
                    }
                    if (Velocity.getY-impl(j3) <= 0.0f) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateTopEffect(), MathKt.roundToInt(Velocity.getY-impl(j3)));
                    } else if (Velocity.getY-impl(j3) < 0.0f) {
                        EdgeEffectCompat.INSTANCE.onAbsorbCompat(this.edgeEffectWrapper.getOrCreateBottomEffect(), -MathKt.roundToInt(Velocity.getY-impl(j3)));
                    }
                    animateToReleaseIfNeeded();
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                if (Size.m4664isEmptyimpl(this.containerSize)) {
                    Velocity velocity = Velocity.box-impl(j);
                    androidEdgeEffectOverscrollEffect$applyToFling$1.label = 1;
                    if (function2.invoke(velocity, androidEdgeEffectOverscrollEffect$applyToFling$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (this.edgeEffectWrapper.isLeftStretched() && Velocity.getX-impl(j) < 0.0f) {
                    f = EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateLeftEffect(), Velocity.getX-impl(j), Float.intBitsToFloat((int) (this.containerSize >> 32)), this.density);
                } else {
                    f = (!this.edgeEffectWrapper.isRightStretched() || Velocity.getX-impl(j) <= 0.0f) ? 0.0f : -EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateRightEffect(), -Velocity.getX-impl(j), Float.intBitsToFloat((int) (this.containerSize >> 32)), this.density);
                }
                if (this.edgeEffectWrapper.isTopStretched() && Velocity.getY-impl(j) < 0.0f) {
                    f2 = EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateTopEffect(), Velocity.getY-impl(j), Float.intBitsToFloat((int) (4294967295L & this.containerSize)), this.density);
                } else {
                    f2 = (!this.edgeEffectWrapper.isBottomStretched() || Velocity.getY-impl(j) <= 0.0f) ? 0.0f : -EdgeEffectCompat.INSTANCE.absorbToRelaxIfNeeded(this.edgeEffectWrapper.getOrCreateBottomEffect(), -Velocity.getY-impl(j), Float.intBitsToFloat((int) (4294967295L & this.containerSize)), this.density);
                }
                long Velocity = VelocityKt.Velocity(f, f2);
                if (!Velocity.equals-impl0(Velocity, Velocity.Companion.getZero-9UxMQ8M())) {
                    invalidateOverscroll$foundation_release();
                }
                j2 = Velocity.minus-AH228Gc(j, Velocity);
                Velocity velocity2 = Velocity.box-impl(j2);
                androidEdgeEffectOverscrollEffect$applyToFling$1.J$0 = j2;
                androidEdgeEffectOverscrollEffect$applyToFling$1.label = 2;
                obj = function2.invoke(velocity2, androidEdgeEffectOverscrollEffect$applyToFling$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j3 = Velocity.minus-AH228Gc(j2, ((Velocity) obj).unbox-impl());
                this.scrollCycleInProgress = false;
                if (Velocity.getX-impl(j3) <= 0.0f) {
                }
                if (Velocity.getY-impl(j3) <= 0.0f) {
                }
                animateToReleaseIfNeeded();
                return Unit.INSTANCE;
            }
        }
        androidEdgeEffectOverscrollEffect$applyToFling$1 = new AndroidEdgeEffectOverscrollEffect$applyToFling$1(this, continuation);
        Object obj2 = androidEdgeEffectOverscrollEffect$applyToFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidEdgeEffectOverscrollEffect$applyToFling$1.label;
        if (i == 0) {
        }
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        if (edgeEffect != null) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect) == 0.0f)) {
                return true;
            }
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect2) == 0.0f)) {
                return true;
            }
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect3) == 0.0f)) {
                return true;
            }
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        if (edgeEffect4 != null) {
            if (!(EdgeEffectCompat.INSTANCE.getDistanceCompat(edgeEffect4) == 0.0f)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: updateSize-uvyYCjk$foundation_release, reason: not valid java name */
    public final void m374updateSizeuvyYCjk$foundation_release(long size) {
        boolean m4658equalsimpl0 = Size.m4658equalsimpl0(this.containerSize, Size.INSTANCE.m4671getZeroNHjbRc());
        boolean z = !Size.m4658equalsimpl0(size, this.containerSize);
        this.containerSize = size;
        if (z) {
            this.edgeEffectWrapper.m462updateSizeozmzZPI(IntSize.constructor-impl((MathKt.roundToInt(Float.intBitsToFloat((int) (size & 4294967295L))) & 4294967295L) | (MathKt.roundToInt(Float.intBitsToFloat((int) (size >> 32))) << 32)));
        }
        if (m4658equalsimpl0 || !z) {
            return;
        }
        animateToReleaseIfNeeded();
    }

    /* renamed from: displacement-F1C5BW0$foundation_release, reason: not valid java name */
    public final long m373displacementF1C5BW0$foundation_release() {
        long j = this.pointerPosition;
        if (!((9223372034707292159L & j) != InlineClassHelperKt.UnspecifiedPackedFloats)) {
            j = SizeKt.m4672getCenteruvyYCjk(this.containerSize);
        }
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        return Offset.m4585constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (j & 4294967295L)) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits(intBitsToFloat) << 32));
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public DelegatableNode getNode() {
        return this.node;
    }

    public final void invalidateOverscroll$foundation_release() {
        if (this.invalidationEnabled) {
            this.redrawSignal.setValue(Unit.INSTANCE);
        }
    }

    private final void animateToReleaseIfNeeded() {
        boolean z;
        EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        EdgeEffect edgeEffect = edgeEffectWrapper.topEffect;
        boolean z2 = true;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = !edgeEffect.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = edgeEffectWrapper.bottomEffect;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z = !edgeEffect2.isFinished() || z;
        }
        EdgeEffect edgeEffect3 = edgeEffectWrapper.leftEffect;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z = !edgeEffect3.isFinished() || z;
        }
        EdgeEffect edgeEffect4 = edgeEffectWrapper.rightEffect;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            if (edgeEffect4.isFinished() && !z) {
                z2 = false;
            }
            z = z2;
        }
        if (z) {
            invalidateOverscroll$foundation_release();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0037  */
    /* renamed from: releaseOppositeOverscroll-k-4lQ0M, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean m370releaseOppositeOverscrollk4lQ0M(long delta) {
        boolean z;
        if (this.edgeEffectWrapper.isLeftAnimating()) {
            int i = (int) (delta >> 32);
            if (Float.intBitsToFloat(i) < 0.0f) {
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateLeftEffect(), Float.intBitsToFloat(i));
                z = this.edgeEffectWrapper.isLeftAnimating();
                if (this.edgeEffectWrapper.isRightAnimating()) {
                    int i2 = (int) (delta >> 32);
                    if (Float.intBitsToFloat(i2) > 0.0f) {
                        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateRightEffect(), Float.intBitsToFloat(i2));
                        z = z || this.edgeEffectWrapper.isRightAnimating();
                    }
                }
                if (this.edgeEffectWrapper.isTopAnimating()) {
                    int i3 = (int) (delta & 4294967295L);
                    if (Float.intBitsToFloat(i3) < 0.0f) {
                        EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateTopEffect(), Float.intBitsToFloat(i3));
                        z = z || this.edgeEffectWrapper.isTopAnimating();
                    }
                }
                if (this.edgeEffectWrapper.isBottomAnimating()) {
                    return z;
                }
                int i4 = (int) (delta & 4294967295L);
                if (Float.intBitsToFloat(i4) <= 0.0f) {
                    return z;
                }
                EdgeEffectCompat.INSTANCE.onReleaseWithOppositeDelta(this.edgeEffectWrapper.getOrCreateBottomEffect(), Float.intBitsToFloat(i4));
                return z || this.edgeEffectWrapper.isBottomAnimating();
            }
        }
        z = false;
        if (this.edgeEffectWrapper.isRightAnimating()) {
        }
        if (this.edgeEffectWrapper.isTopAnimating()) {
        }
        if (this.edgeEffectWrapper.isBottomAnimating()) {
        }
    }

    /* renamed from: pullTop-k-4lQ0M, reason: not valid java name */
    private final float m369pullTopk4lQ0M(long scroll) {
        float intBitsToFloat = Float.intBitsToFloat((int) (m373displacementF1C5BW0$foundation_release() >> 32));
        int i = (int) (scroll & 4294967295L);
        float intBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        EdgeEffect orCreateTopEffect = this.edgeEffectWrapper.getOrCreateTopEffect();
        return !((EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateTopEffect) > 0.0f ? 1 : (EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateTopEffect) == 0.0f ? 0 : -1)) == 0) ? Float.intBitsToFloat(i) : EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateTopEffect, intBitsToFloat2, intBitsToFloat) * Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
    }

    /* renamed from: pullBottom-k-4lQ0M, reason: not valid java name */
    private final float m366pullBottomk4lQ0M(long scroll) {
        float intBitsToFloat = Float.intBitsToFloat((int) (m373displacementF1C5BW0$foundation_release() >> 32));
        int i = (int) (scroll & 4294967295L);
        float intBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
        EdgeEffect orCreateBottomEffect = this.edgeEffectWrapper.getOrCreateBottomEffect();
        return !(EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateBottomEffect) == 0.0f) ? Float.intBitsToFloat(i) : (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateBottomEffect, -intBitsToFloat2, 1 - intBitsToFloat)) * Float.intBitsToFloat((int) (this.containerSize & 4294967295L));
    }

    /* renamed from: pullLeft-k-4lQ0M, reason: not valid java name */
    private final float m367pullLeftk4lQ0M(long scroll) {
        float intBitsToFloat = Float.intBitsToFloat((int) (m373displacementF1C5BW0$foundation_release() & 4294967295L));
        int i = (int) (scroll >> 32);
        float intBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect orCreateLeftEffect = this.edgeEffectWrapper.getOrCreateLeftEffect();
        return !(EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateLeftEffect) == 0.0f) ? Float.intBitsToFloat(i) : EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateLeftEffect, intBitsToFloat2, 1 - intBitsToFloat) * Float.intBitsToFloat((int) (this.containerSize >> 32));
    }

    /* renamed from: pullRight-k-4lQ0M, reason: not valid java name */
    private final float m368pullRightk4lQ0M(long scroll) {
        float intBitsToFloat = Float.intBitsToFloat((int) (m373displacementF1C5BW0$foundation_release() & 4294967295L));
        int i = (int) (scroll >> 32);
        float intBitsToFloat2 = Float.intBitsToFloat(i) / Float.intBitsToFloat((int) (this.containerSize >> 32));
        EdgeEffect orCreateRightEffect = this.edgeEffectWrapper.getOrCreateRightEffect();
        return !((EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateRightEffect) > 0.0f ? 1 : (EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateRightEffect) == 0.0f ? 0 : -1)) == 0) ? Float.intBitsToFloat(i) : (-EdgeEffectCompat.INSTANCE.onPullDistanceCompat(orCreateRightEffect, -intBitsToFloat2, intBitsToFloat)) * Float.intBitsToFloat((int) (this.containerSize >> 32));
    }
}
