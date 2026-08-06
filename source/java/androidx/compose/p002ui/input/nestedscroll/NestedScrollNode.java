package androidx.compose.p002ui.input.nestedscroll;

import androidx.compose.p002ui.ComposeUiFlags;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: NestedScrollNode.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'J'\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0004\b*\u0010+J\u0018\u0010,\u001a\u00020-2\u0006\u0010#\u001a\u00020-H\u0096@¢\u0006\u0004\b.\u0010/J \u00100\u001a\u00020-2\u0006\u0010)\u001a\u00020-2\u0006\u0010#\u001a\u00020-H\u0096@¢\u0006\u0004\b1\u00102J\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u00106\u001a\u000204H\u0016J\b\u00107\u001a\u000204H\u0016J\b\u00108\u001a\u000204H\u0002J\b\u00109\u001a\u000204H\u0002J\u001f\u0010:\u001a\u0002042\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0002\b;R\u001a\u0010\u0004\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\nR\u0014\u0010\u0017\u001a\u00020\u0018X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006<"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/Modifier$Node;", "connection", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "<init>", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "resolvedDispatcher", "lastKnownParentNode", "getLastKnownParentNode$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "setLastKnownParentNode$ui_release", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;)V", "parentNestedScrollNode", "getParentNestedScrollNode$ui_release", "parentConnection", "getParentConnection", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope$annotations", "()V", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "onPreScroll", "Landroidx/compose/ui/geometry/Offset;", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPreScroll-OzD1aCk", "(JI)J", "onPostScroll", "consumed", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDispatcher", "", "newDispatcher", "onAttach", "onDetach", "updateDispatcherFields", "resetDispatcherFields", "updateNode", "updateNode$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class NestedScrollNode extends Modifier.Node implements TraversableNode, NestedScrollConnection {
    public static final int $stable = 8;
    private NestedScrollConnection connection;
    private NestedScrollNode lastKnownParentNode;
    private NestedScrollDispatcher resolvedDispatcher;
    private final Object traverseKey;

    private static /* synthetic */ void getNestedCoroutineScope$annotations() {
    }

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    public final void setConnection(NestedScrollConnection nestedScrollConnection) {
        this.connection = nestedScrollConnection;
    }

    public NestedScrollNode(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        this.resolvedDispatcher = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.traverseKey = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    }

    /* renamed from: getLastKnownParentNode$ui_release, reason: from getter */
    public final NestedScrollNode getLastKnownParentNode() {
        return this.lastKnownParentNode;
    }

    public final void setLastKnownParentNode$ui_release(NestedScrollNode nestedScrollNode) {
        this.lastKnownParentNode = nestedScrollNode;
    }

    public final NestedScrollNode getParentNestedScrollNode$ui_release() {
        if (getIsAttached()) {
            return (NestedScrollNode) TraversableNodeKt.findNearestAncestor(this);
        }
        return null;
    }

    private final NestedScrollConnection getParentConnection() {
        if (getIsAttached()) {
            return getParentNestedScrollNode$ui_release();
        }
        return null;
    }

    public Object getTraverseKey() {
        return this.traverseKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope scope;
        if (ComposeUiFlags.isNestedScrollDispatcherNodeFixEnabled) {
            NestedScrollNode parentNestedScrollNode$ui_release = getParentNestedScrollNode$ui_release();
            scope = parentNestedScrollNode$ui_release != null ? parentNestedScrollNode$ui_release.getNestedCoroutineScope() : null;
            boolean z = false;
            if (scope != null && CoroutineScopeKt.isActive(scope)) {
                z = true;
            }
            if (!z && (scope = this.resolvedDispatcher.getScope()) == null) {
                throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
            }
        } else {
            NestedScrollNode parentNestedScrollNode$ui_release2 = getParentNestedScrollNode$ui_release();
            if ((parentNestedScrollNode$ui_release2 == null || (scope = parentNestedScrollNode$ui_release2.getNestedCoroutineScope()) == null) && (scope = this.resolvedDispatcher.getScope()) == null) {
                throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
            }
        }
        return scope;
    }

    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo1159onPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection parentConnection = getParentConnection();
        long mo1159onPreScrollOzD1aCk = parentConnection != null ? parentConnection.mo1159onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m4609getZeroF1C5BW0();
        return Offset.m4598plusMKHz9U(mo1159onPreScrollOzD1aCk, this.connection.mo1159onPreScrollOzD1aCk(Offset.m4597minusMKHz9U(available, mo1159onPreScrollOzD1aCk), source));
    }

    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo777onPostScrollDzOQY0M(long consumed, long available, int source) {
        long m4609getZeroF1C5BW0;
        long mo777onPostScrollDzOQY0M = this.connection.mo777onPostScrollDzOQY0M(consumed, available, source);
        NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            m4609getZeroF1C5BW0 = parentConnection.mo777onPostScrollDzOQY0M(Offset.m4598plusMKHz9U(consumed, mo777onPostScrollDzOQY0M), Offset.m4597minusMKHz9U(available, mo777onPostScrollDzOQY0M), source);
        } else {
            m4609getZeroF1C5BW0 = Offset.INSTANCE.m4609getZeroF1C5BW0();
        }
        return Offset.m4598plusMKHz9U(mo777onPostScrollDzOQY0M, m4609getZeroF1C5BW0);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo1158onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPreFling$1 nestedScrollNode$onPreFling$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        long j2;
        long j3;
        if (continuation instanceof NestedScrollNode$onPreFling$1) {
            nestedScrollNode$onPreFling$1 = (NestedScrollNode$onPreFling$1) continuation;
            if ((nestedScrollNode$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPreFling$1.label -= Integer.MIN_VALUE;
                obj = nestedScrollNode$onPreFling$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = nestedScrollNode$onPreFling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NestedScrollConnection parentConnection = getParentConnection();
                    if (parentConnection == null) {
                        j2 = Velocity.Companion.getZero-9UxMQ8M();
                        long j4 = j;
                        j3 = j2;
                        NestedScrollConnection nestedScrollConnection = this.connection;
                        long j5 = Velocity.minus-AH228Gc(j4, j3);
                        nestedScrollNode$onPreFling$1.J$0 = j3;
                        nestedScrollNode$onPreFling$1.label = 2;
                        obj = nestedScrollConnection.mo1158onPreFlingQWom1Mo(j5, nestedScrollNode$onPreFling$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Velocity.box-impl(Velocity.plus-AH228Gc(j3, ((Velocity) obj).unbox-impl()));
                    }
                    nestedScrollNode$onPreFling$1.J$0 = j;
                    nestedScrollNode$onPreFling$1.label = 1;
                    obj = parentConnection.mo1158onPreFlingQWom1Mo(j, nestedScrollNode$onPreFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j3 = nestedScrollNode$onPreFling$1.J$0;
                        ResultKt.throwOnFailure(obj);
                        return Velocity.box-impl(Velocity.plus-AH228Gc(j3, ((Velocity) obj).unbox-impl()));
                    }
                    j = nestedScrollNode$onPreFling$1.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                j2 = ((Velocity) obj).unbox-impl();
                long j42 = j;
                j3 = j2;
                NestedScrollConnection nestedScrollConnection2 = this.connection;
                long j52 = Velocity.minus-AH228Gc(j42, j3);
                nestedScrollNode$onPreFling$1.J$0 = j3;
                nestedScrollNode$onPreFling$1.label = 2;
                obj = nestedScrollConnection2.mo1158onPreFlingQWom1Mo(j52, nestedScrollNode$onPreFling$1);
                if (obj == coroutine_suspended) {
                }
                return Velocity.box-impl(Velocity.plus-AH228Gc(j3, ((Velocity) obj).unbox-impl()));
            }
        }
        nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, continuation);
        obj = nestedScrollNode$onPreFling$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = nestedScrollNode$onPreFling$1.label;
        if (i != 0) {
        }
        j2 = ((Velocity) obj).unbox-impl();
        long j422 = j;
        j3 = j2;
        NestedScrollConnection nestedScrollConnection22 = this.connection;
        long j522 = Velocity.minus-AH228Gc(j422, j3);
        nestedScrollNode$onPreFling$1.J$0 = j3;
        nestedScrollNode$onPreFling$1.label = 2;
        obj = nestedScrollConnection22.mo1158onPreFlingQWom1Mo(j522, nestedScrollNode$onPreFling$1);
        if (obj == coroutine_suspended) {
        }
        return Velocity.box-impl(Velocity.plus-AH228Gc(j3, ((Velocity) obj).unbox-impl()));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo776onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$1;
        int i;
        long j3;
        long j4;
        long j5;
        NestedScrollConnection parentConnection;
        long j6;
        long j7;
        if (continuation instanceof NestedScrollNode$onPostFling$1) {
            nestedScrollNode$onPostFling$1 = (NestedScrollNode$onPostFling$1) continuation;
            if ((nestedScrollNode$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPostFling$1.label -= Integer.MIN_VALUE;
                Object obj = nestedScrollNode$onPostFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = nestedScrollNode$onPostFling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NestedScrollConnection nestedScrollConnection = this.connection;
                    j3 = j;
                    nestedScrollNode$onPostFling$1.J$0 = j3;
                    j4 = j2;
                    nestedScrollNode$onPostFling$1.J$1 = j4;
                    nestedScrollNode$onPostFling$1.label = 1;
                    obj = nestedScrollConnection.mo776onPostFlingRZ2iAVY(j, j2, nestedScrollNode$onPostFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j7 = nestedScrollNode$onPostFling$1.J$0;
                        ResultKt.throwOnFailure(obj);
                        j6 = ((Velocity) obj).unbox-impl();
                        j5 = j7;
                        return Velocity.box-impl(Velocity.plus-AH228Gc(j5, j6));
                    }
                    long j8 = nestedScrollNode$onPostFling$1.J$1;
                    long j9 = nestedScrollNode$onPostFling$1.J$0;
                    ResultKt.throwOnFailure(obj);
                    j4 = j8;
                    j3 = j9;
                }
                j5 = ((Velocity) obj).unbox-impl();
                parentConnection = !getIsAttached() ? getParentConnection() : this.lastKnownParentNode;
                if (parentConnection == null) {
                    long j10 = Velocity.plus-AH228Gc(j3, j5);
                    long j11 = Velocity.minus-AH228Gc(j4, j5);
                    nestedScrollNode$onPostFling$1.J$0 = j5;
                    nestedScrollNode$onPostFling$1.label = 2;
                    obj = parentConnection.mo776onPostFlingRZ2iAVY(j10, j11, nestedScrollNode$onPostFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    j7 = j5;
                    j6 = ((Velocity) obj).unbox-impl();
                    j5 = j7;
                    return Velocity.box-impl(Velocity.plus-AH228Gc(j5, j6));
                }
                j6 = Velocity.Companion.getZero-9UxMQ8M();
                return Velocity.box-impl(Velocity.plus-AH228Gc(j5, j6));
            }
        }
        nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, continuation);
        Object obj2 = nestedScrollNode$onPostFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = nestedScrollNode$onPostFling$1.label;
        if (i != 0) {
        }
        j5 = ((Velocity) obj2).unbox-impl();
        parentConnection = !getIsAttached() ? getParentConnection() : this.lastKnownParentNode;
        if (parentConnection == null) {
        }
    }

    private final void updateDispatcher(NestedScrollDispatcher newDispatcher) {
        resetDispatcherFields();
        if (newDispatcher == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!Intrinsics.areEqual(newDispatcher, this.resolvedDispatcher)) {
            this.resolvedDispatcher = newDispatcher;
        }
        if (getIsAttached()) {
            updateDispatcherFields();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDispatcherFields();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        NestedScrollNode nestedScrollNode = (NestedScrollNode) NestedScrollNodeKt.access$findNearestAttachedAncestor(this);
        this.lastKnownParentNode = nestedScrollNode;
        this.resolvedDispatcher.setLastKnownParentNode$ui_release(nestedScrollNode);
        resetDispatcherFields();
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setNestedScrollNode$ui_release(this);
        this.resolvedDispatcher.setLastKnownParentNode$ui_release(null);
        this.lastKnownParentNode = null;
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release(new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNode$updateDispatcherFields$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public final CoroutineScope invoke() {
                CoroutineScope nestedCoroutineScope;
                nestedCoroutineScope = NestedScrollNode.this.getNestedCoroutineScope();
                return nestedCoroutineScope;
            }
        });
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getNestedScrollNode() == this) {
            this.resolvedDispatcher.setNestedScrollNode$ui_release(null);
        }
    }

    public final void updateNode$ui_release(NestedScrollConnection connection, NestedScrollDispatcher dispatcher) {
        this.connection = connection;
        updateDispatcher(dispatcher);
    }
}
