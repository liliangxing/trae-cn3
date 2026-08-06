package androidx.compose.p002ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.p002ui.ComposeUiFlags;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.input.pointer.PointerInteropFilter;
import androidx.compose.p002ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerInteropFilter.android.kt */
@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"androidx/compose/ui/input/pointer/PointerInteropFilter$pointerInputFilter$1", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "state", "Landroidx/compose/ui/input/pointer/PointerInteropFilter$DispatchToViewState;", "shareWithSiblings", "", "getShareWithSiblings", "()Z", "lastEventDispatchedToInitialPass", "Landroidx/compose/ui/input/pointer/PointerEvent;", "onPointerEvent", "", "pointerEvent", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancel", "reset", "dispatchToView", "shouldConsume", "stopDispatching", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class PointerInteropFilter$pointerInputFilter$1 extends PointerInputFilter {
    private PointerEvent lastEventDispatchedToInitialPass;
    private PointerInteropFilter.DispatchToViewState state = PointerInteropFilter.DispatchToViewState.Unknown;
    final /* synthetic */ PointerInteropFilter this$0;

    @Override // androidx.compose.p002ui.input.pointer.PointerInputFilter
    public boolean getShareWithSiblings() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PointerInteropFilter$pointerInputFilter$1(PointerInteropFilter pointerInteropFilter) {
        this.this$0 = pointerInteropFilter;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x015c A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f8  */
    @Override // androidx.compose.p002ui.input.pointer.PointerInputFilter
    /* renamed from: onPointerEvent-H0pRuoY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo6167onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        List<PointerInputChange> list = changes;
        int size = list.size();
        int i = 0;
        while (true) {
            z = true;
            if (i >= size) {
                z2 = true;
                break;
            }
            PointerInputChange pointerInputChange = changes.get(i);
            if (!((PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange) || PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) ? false : true)) {
                z2 = false;
                break;
            }
            i++;
        }
        if (z2) {
            int size2 = list.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size2) {
                    z7 = true;
                    break;
                } else {
                    if (!(!changes.get(i2).isConsumed())) {
                        z7 = false;
                        break;
                    }
                    i2++;
                }
            }
            if (z7) {
                z3 = true;
                if (!this.this$0.getDisallowIntercept()) {
                    int size3 = list.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size3) {
                            z6 = false;
                            break;
                        }
                        PointerInputChange pointerInputChange2 = changes.get(i3);
                        if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange2) || PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange2)) {
                            z6 = true;
                            break;
                        }
                        i3++;
                    }
                    if (!z6 && (!z3 || !ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled)) {
                        z4 = false;
                        if (this.state != PointerInteropFilter.DispatchToViewState.NotDispatching) {
                            if (pass == PointerEventPass.Initial && z4) {
                                this.lastEventDispatchedToInitialPass = pointerEvent;
                                dispatchToView(pointerEvent, !z2 || this.this$0.getDisallowIntercept());
                            }
                            if (pass == PointerEventPass.Main && z2 && Intrinsics.areEqual(pointerEvent, this.lastEventDispatchedToInitialPass) && this.this$0.getDisallowIntercept() && ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled) {
                                int size4 = list.size();
                                for (int i4 = 0; i4 < size4; i4++) {
                                    changes.get(i4).consume();
                                }
                            }
                            if (!ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled ? pass != PointerEventPass.Final || z4 : pass != PointerEventPass.Final || z4 || Intrinsics.areEqual(pointerEvent, this.lastEventDispatchedToInitialPass)) {
                                dispatchToView(pointerEvent, true);
                            }
                        }
                        if (pass == PointerEventPass.Final) {
                            int size5 = list.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size5) {
                                    z5 = true;
                                    break;
                                } else {
                                    if (!PointerEventKt.changedToUpIgnoreConsumed(changes.get(i5))) {
                                        z5 = false;
                                        break;
                                    }
                                    i5++;
                                }
                            }
                            if (z5) {
                                reset();
                            }
                            if (Intrinsics.areEqual(pointerEvent, this.lastEventDispatchedToInitialPass) && z2 && ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled) {
                                int size6 = list.size();
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= size6) {
                                        z = false;
                                        break;
                                    } else if (changes.get(i6).isConsumed()) {
                                        break;
                                    } else {
                                        i6++;
                                    }
                                }
                                if (z && !this.this$0.getDisallowIntercept()) {
                                    stopDispatching(pointerEvent);
                                    return;
                                }
                                int size7 = list.size();
                                for (int i7 = 0; i7 < size7; i7++) {
                                    changes.get(i7).consume();
                                }
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                z4 = true;
                if (this.state != PointerInteropFilter.DispatchToViewState.NotDispatching) {
                }
                if (pass == PointerEventPass.Final) {
                }
            }
        }
        z3 = false;
        if (!this.this$0.getDisallowIntercept()) {
        }
        z4 = true;
        if (this.state != PointerInteropFilter.DispatchToViewState.NotDispatching) {
        }
        if (pass == PointerEventPass.Final) {
        }
    }

    @Override // androidx.compose.p002ui.input.pointer.PointerInputFilter
    public void onCancel() {
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            long uptimeMillis = SystemClock.uptimeMillis();
            final PointerInteropFilter pointerInteropFilter = this.this$0;
            PointerInteropUtils_androidKt.emptyCancelMotionEventScope(uptimeMillis, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$onCancel$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((MotionEvent) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(MotionEvent motionEvent) {
                    PointerInteropFilter.this.getOnTouchEvent().invoke(motionEvent);
                }
            });
            reset();
        }
    }

    private final void reset() {
        this.state = PointerInteropFilter.DispatchToViewState.Unknown;
        this.this$0.setDisallowIntercept$ui_release(false);
        this.lastEventDispatchedToInitialPass = null;
    }

    private final void dispatchToView(PointerEvent pointerEvent, boolean shouldConsume) {
        boolean z;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        List<PointerInputChange> list = changes;
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                z = false;
                break;
            } else {
                if (changes.get(i2).isConsumed()) {
                    z = true;
                    break;
                }
                i2++;
            }
        }
        if (z) {
            stopDispatching(pointerEvent);
            return;
        }
        LayoutCoordinates layoutCoordinates$ui_release = getLayoutCoordinates();
        if (layoutCoordinates$ui_release != null) {
            long mo6342localToRootMKHz9U = layoutCoordinates$ui_release.mo6342localToRootMKHz9U(Offset.INSTANCE.m4609getZeroF1C5BW0());
            final PointerInteropFilter pointerInteropFilter = this.this$0;
            PointerInteropUtils_androidKt.m6203toMotionEventScoped4ec7I(pointerEvent, mo6342localToRootMKHz9U, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$dispatchToView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((MotionEvent) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(MotionEvent motionEvent) {
                    PointerInteropFilter.DispatchToViewState dispatchToViewState;
                    if (motionEvent.getActionMasked() == 0) {
                        PointerInteropFilter$pointerInputFilter$1 pointerInteropFilter$pointerInputFilter$1 = PointerInteropFilter$pointerInputFilter$1.this;
                        if (((Boolean) pointerInteropFilter.getOnTouchEvent().invoke(motionEvent)).booleanValue()) {
                            dispatchToViewState = PointerInteropFilter.DispatchToViewState.Dispatching;
                        } else {
                            dispatchToViewState = PointerInteropFilter.DispatchToViewState.NotDispatching;
                        }
                        pointerInteropFilter$pointerInputFilter$1.state = dispatchToViewState;
                        return;
                    }
                    pointerInteropFilter.getOnTouchEvent().invoke(motionEvent);
                }
            });
            if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
                if (!ComposeUiFlags.isPointerInteropFilterDispatchingFixEnabled) {
                    int size2 = list.size();
                    while (i < size2) {
                        changes.get(i).consume();
                        i++;
                    }
                } else if (shouldConsume) {
                    int size3 = list.size();
                    while (i < size3) {
                        changes.get(i).consume();
                        i++;
                    }
                }
                InternalPointerEvent internalPointerEvent = pointerEvent.getInternalPointerEvent();
                if (internalPointerEvent != null) {
                    internalPointerEvent.setSuppressMovementConsumption(!this.this$0.getDisallowIntercept());
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("layoutCoordinates not set".toString());
    }

    private final void stopDispatching(PointerEvent pointerEvent) {
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            LayoutCoordinates layoutCoordinates$ui_release = getLayoutCoordinates();
            if (layoutCoordinates$ui_release != null) {
                long mo6342localToRootMKHz9U = layoutCoordinates$ui_release.mo6342localToRootMKHz9U(Offset.INSTANCE.m4609getZeroF1C5BW0());
                final PointerInteropFilter pointerInteropFilter = this.this$0;
                PointerInteropUtils_androidKt.m6202toCancelMotionEventScoped4ec7I(pointerEvent, mo6342localToRootMKHz9U, new Function1<MotionEvent, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1$stopDispatching$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((MotionEvent) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(MotionEvent motionEvent) {
                        PointerInteropFilter.this.getOnTouchEvent().invoke(motionEvent);
                    }
                });
            } else {
                throw new IllegalStateException("layoutCoordinates not set".toString());
            }
        }
        this.state = PointerInteropFilter.DispatchToViewState.NotDispatching;
    }
}
