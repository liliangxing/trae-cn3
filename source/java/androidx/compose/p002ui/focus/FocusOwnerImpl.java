package androidx.compose.p002ui.focus;

import android.os.Trace;
import android.view.KeyEvent;
import androidx.collection.MutableLongSet;
import androidx.collection.MutableObjectList;
import androidx.compose.p002ui.ComposeUiFlags;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.input.indirect.IndirectTouchEvent;
import androidx.compose.p002ui.input.indirect.IndirectTouchInputModifierNode;
import androidx.compose.p002ui.input.key.KeyEventType;
import androidx.compose.p002ui.input.key.KeyEvent_androidKt;
import androidx.compose.p002ui.input.key.KeyInputModifierNode;
import androidx.compose.p002ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.p002ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.p002ui.input.rotary.RotaryScrollEvent;
import androidx.compose.p002ui.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.InspectorInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: FocusOwnerImpl.kt */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0002\b\u001aJ!\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u0015H\u0016J/\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b&\u0010'J\u001a\u0010#\u001a\u00020\u00152\b\b\u0002\u0010(\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0017\u0010)\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b*\u0010+J7\u0010,\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010-\u001a\u0004\u0018\u00010\u00192\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00150/H\u0016¢\u0006\u0004\b0\u00101J%\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u0002042\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001506H\u0016¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u00152\u0006\u00103\u001a\u000204H\u0016¢\u0006\u0004\b:\u0010;J\u001e\u0010<\u001a\u00020\u00152\u0006\u0010=\u001a\u00020>2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001506H\u0016J\u001e\u0010?\u001a\u00020\u00152\u0006\u0010=\u001a\u00020@2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u001506H\u0016J\u0010\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020\tH\u0016J\u0010\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020CH\u0016J\b\u0010D\u001a\u00020!H\u0016Jd\u0010E\u001a\u00020!\"\n\b\u0000\u0010F\u0018\u0001*\u00020G*\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HF0I2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u00020!0/2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020!062\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u00020!0/H\u0082\b¢\u0006\u0004\bM\u0010NJ0\u0010O\u001a\u0004\u0018\u0001HF\"\n\b\u0000\u0010F\u0018\u0001*\u00020P*\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u0002HF0IH\u0082\b¢\u0006\u0004\bQ\u0010RJ\n\u0010S\u001a\u0004\u0018\u00010\u0019H\u0016J\n\u0010T\u001a\u0004\u0018\u00010\tH\u0002J\u000e\u0010f\u001a\u0004\u0018\u00010g*\u00020GH\u0002J\u0017\u0010h\u001a\u00020\u00152\u0006\u00103\u001a\u000204H\u0002¢\u0006\u0004\bi\u0010;R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010U\u001a\u00020V8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010XR\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020[0ZX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R(\u0010_\u001a\u0004\u0018\u00010\t2\b\u0010^\u001a\u0004\u0018\u00010\t@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u000b\"\u0004\ba\u0010\rR$\u0010b\u001a\u00020\u00152\u0006\u0010^\u001a\u00020\u0015@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e¨\u0006j"}, d2 = {"Landroidx/compose/ui/focus/FocusOwnerImpl;", "Landroidx/compose/ui/focus/FocusOwner;", "platformFocusOwner", "Landroidx/compose/ui/focus/PlatformFocusOwner;", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroidx/compose/ui/focus/PlatformFocusOwner;Landroidx/compose/ui/node/Owner;)V", "rootFocusNode", "Landroidx/compose/ui/focus/FocusTargetNode;", "getRootFocusNode$ui_release", "()Landroidx/compose/ui/focus/FocusTargetNode;", "setRootFocusNode$ui_release", "(Landroidx/compose/ui/focus/FocusTargetNode;)V", "focusInvalidationManager", "Landroidx/compose/ui/focus/FocusInvalidationManager;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "requestOwnerFocus", "", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "previouslyFocusedRect", "Landroidx/compose/ui/geometry/Rect;", "requestOwnerFocus-7o62pno", "keysCurrentlyDown", "Landroidx/collection/MutableLongSet;", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "releaseFocus", "", "clearOwnerFocus", "clearFocus", "force", "refreshFocusEvents", "clearFocus-I7lrPNg", "(ZZZI)Z", "forced", "moveFocus", "moveFocus-3ESFkO8", "(I)Z", "focusSearch", "focusedRect", "onFound", "Lkotlin/Function1;", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "dispatchKeyEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "onFocusedItem", "Lkotlin/Function0;", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchInterceptedSoftKeyboardEvent", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchRotaryEvent", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "dispatchIndirectTouchEvent", "Landroidx/compose/ui/input/indirect/IndirectTouchEvent;", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "scheduleInvalidationForOwner", "traverseAncestorsIncludingSelf", "T", "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "onPreVisit", "onVisit", "onPostVisit", "traverseAncestorsIncludingSelf-QFhIj7k", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "nearestAncestorIncludingSelf", "", "nearestAncestorIncludingSelf-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "getFocusRect", "findFocusTargetNode", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "listeners", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/focus/FocusListener;", "getListeners", "()Landroidx/collection/MutableObjectList;", "value", "activeFocusTargetNode", "getActiveFocusTargetNode", "setActiveFocusTargetNode", "isFocusCaptured", "()Z", "setFocusCaptured", "(Z)V", "lastLocalKeyInputNode", "Landroidx/compose/ui/Modifier$Node;", "validateKeyEvent", "validateKeyEvent-ZmokQxo", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class FocusOwnerImpl implements FocusOwner {
    public static final int $stable = 8;
    private FocusTargetNode activeFocusTargetNode;
    private final FocusInvalidationManager focusInvalidationManager;
    private boolean isFocusCaptured;
    private MutableLongSet keysCurrentlyDown;
    private final Owner owner;
    private final PlatformFocusOwner platformFocusOwner;
    private FocusTargetNode rootFocusNode = new FocusTargetNode(Focusability.INSTANCE.m4528getNeverLCbbffg(), null, null, 6, null);
    private final Modifier modifier = new ModifierNodeElement<FocusTargetNode>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$modifier$1
        public boolean equals(Object other) {
            return other == this;
        }

        public void update(FocusTargetNode node) {
        }

        public FocusTargetNode create() {
            return FocusOwnerImpl.this.getRootFocusNode();
        }

        public void inspectableProperties(InspectorInfo inspectorInfo) {
            inspectorInfo.setName("RootFocusTarget");
        }

        public int hashCode() {
            return FocusOwnerImpl.this.getRootFocusNode().hashCode();
        }
    };
    private final MutableObjectList<FocusListener> listeners = new MutableObjectList<>(1);

    /* compiled from: FocusOwnerImpl.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CustomDestinationResult.values().length];
            try {
                iArr[CustomDestinationResult.Redirected.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomDestinationResult.Cancelled.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomDestinationResult.RedirectCancelled.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomDestinationResult.None.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FocusOwnerImpl(PlatformFocusOwner platformFocusOwner, Owner owner) {
        this.platformFocusOwner = platformFocusOwner;
        this.owner = owner;
        this.focusInvalidationManager = new FocusInvalidationManager(this, owner);
    }

    /* renamed from: getRootFocusNode$ui_release, reason: from getter */
    public final FocusTargetNode getRootFocusNode() {
        return this.rootFocusNode;
    }

    public final void setRootFocusNode$ui_release(FocusTargetNode focusTargetNode) {
        this.rootFocusNode = focusTargetNode;
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    /* renamed from: requestOwnerFocus-7o62pno */
    public boolean mo4482requestOwnerFocus7o62pno(FocusDirection focusDirection, Rect previouslyFocusedRect) {
        return this.platformFocusOwner.m4535requestOwnerFocus7o62pno(focusDirection, previouslyFocusedRect);
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    /* renamed from: takeFocus-aToIllA */
    public boolean mo4483takeFocusaToIllA(final int focusDirection, Rect previouslyFocusedRect) {
        Boolean mo4481focusSearchULY8qGw = mo4481focusSearchULY8qGw(focusDirection, previouslyFocusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$takeFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                return Boolean.valueOf(focusTargetNode.mo4501requestFocus3ESFkO8(focusDirection));
            }
        });
        if (mo4481focusSearchULY8qGw != null) {
            return mo4481focusSearchULY8qGw.booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    public void releaseFocus() {
        FocusTransactionsKt.clearFocus(this.rootFocusNode, true, true);
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    public void clearOwnerFocus() {
        this.platformFocusOwner.clearOwnerFocus();
    }

    @Override // androidx.compose.p002ui.focus.FocusManager
    public void clearFocus(boolean force) {
        mo4478clearFocusI7lrPNg(force, true, true, FocusDirection.INSTANCE.m4466getExitdhqQ8s());
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    /* renamed from: clearFocus-I7lrPNg */
    public boolean mo4478clearFocusI7lrPNg(boolean force, boolean refreshFocusEvents, boolean clearOwnerFocus, int focusDirection) {
        boolean clearFocus;
        if (!force) {
            int i = WhenMappings.$EnumSwitchMapping$0[FocusTransactionsKt.m4510performCustomClearFocusMxy_nc0(this.rootFocusNode, focusDirection).ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                clearFocus = false;
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                clearFocus = clearFocus(force, refreshFocusEvents);
            }
        } else {
            clearFocus = clearFocus(force, refreshFocusEvents);
        }
        if (clearFocus && clearOwnerFocus) {
            clearOwnerFocus();
        }
        return clearFocus;
    }

    static /* synthetic */ boolean clearFocus$default(FocusOwnerImpl focusOwnerImpl, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return focusOwnerImpl.clearFocus(z, z2);
    }

    private final boolean clearFocus(boolean forced, boolean refreshFocusEvents) {
        NodeChain nodes$ui_release;
        if (getActiveFocusTargetNode() == null) {
            return true;
        }
        if (getIsFocusCaptured() && !forced) {
            return false;
        }
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        setActiveFocusTargetNode(null);
        if (refreshFocusEvents && activeFocusTargetNode != null) {
            activeFocusTargetNode.dispatchFocusCallbacks$ui_release(getIsFocusCaptured() ? FocusStateImpl.Captured : FocusStateImpl.Active, FocusStateImpl.Inactive);
            FocusTargetNode focusTargetNode = activeFocusTargetNode;
            int i = NodeKind.constructor-impl(Fields.RotationZ);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = focusTargetNode.getNode().getParent();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            while (requireLayoutNode != null) {
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet() & i) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & i) != 0) {
                            MutableVector mutableVector = null;
                            Modifier.Node node = parent;
                            while (node != null) {
                                if (node instanceof FocusTargetNode) {
                                    ((FocusTargetNode) node).dispatchFocusCallbacks$ui_release(FocusStateImpl.ActiveParent, FocusStateImpl.Inactive);
                                } else if (((node.getKindSet() & i) != 0) && (node instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                                        if ((delegate$ui_release.getKindSet() & i) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                node = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(node);
                                                    }
                                                    node = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                node = DelegatableNodeKt.access$pop(mutableVector);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                parent = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
        }
        return true;
    }

    @Override // androidx.compose.p002ui.focus.FocusManager
    /* renamed from: moveFocus-3ESFkO8 */
    public boolean mo4476moveFocus3ESFkO8(final int focusDirection) {
        if (ComposeUiFlags.isViewFocusFixEnabled && this.platformFocusOwner.m4534moveFocusInChildren3ESFkO8(focusDirection)) {
            return true;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = false;
        FocusTargetNode activeFocusTargetNode = getActiveFocusTargetNode();
        Boolean mo4481focusSearchULY8qGw = mo4481focusSearchULY8qGw(focusDirection, this.platformFocusOwner.getEmbeddedViewFocusRect(), new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$moveFocus$focusSearchSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                objectRef.element = Boolean.valueOf(focusTargetNode.mo4501requestFocus3ESFkO8(focusDirection));
                return (Boolean) objectRef.element;
            }
        });
        if (Intrinsics.areEqual(mo4481focusSearchULY8qGw, true) && activeFocusTargetNode != getActiveFocusTargetNode()) {
            return true;
        }
        if (mo4481focusSearchULY8qGw == null || objectRef.element == null) {
            return false;
        }
        if (mo4481focusSearchULY8qGw.booleanValue() && ((Boolean) objectRef.element).booleanValue()) {
            return true;
        }
        return FocusOwnerImplKt.m4491is1dFocusSearch3ESFkO8(focusDirection) ? mo4478clearFocusI7lrPNg(false, true, false, focusDirection) && mo4483takeFocusaToIllA(focusDirection, null) : !ComposeUiFlags.isViewFocusFixEnabled && this.platformFocusOwner.m4534moveFocusInChildren3ESFkO8(focusDirection);
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    /* renamed from: focusSearch-ULY8qGw */
    public Boolean mo4481focusSearchULY8qGw(int focusDirection, Rect focusedRect, final Function1<? super FocusTargetNode, Boolean> onFound) {
        final FocusTargetNode findFocusTargetNode = findFocusTargetNode();
        if (findFocusTargetNode != null) {
            FocusRequester m4517customFocusSearchOMvw8 = FocusTraversalKt.m4517customFocusSearchOMvw8(findFocusTargetNode, focusDirection, this.owner.getLayoutDirection());
            if (Intrinsics.areEqual(m4517customFocusSearchOMvw8, FocusRequester.INSTANCE.getCancel())) {
                return null;
            }
            if (Intrinsics.areEqual(m4517customFocusSearchOMvw8, FocusRequester.INSTANCE.getRedirect$ui_release())) {
                FocusTargetNode findFocusTargetNode2 = findFocusTargetNode();
                if (findFocusTargetNode2 != null) {
                    return (Boolean) onFound.invoke(findFocusTargetNode2);
                }
                return null;
            }
            if (!Intrinsics.areEqual(m4517customFocusSearchOMvw8, FocusRequester.INSTANCE.getDefault())) {
                return Boolean.valueOf(m4517customFocusSearchOMvw8.findFocusTargetNode$ui_release(onFound));
            }
        } else {
            findFocusTargetNode = null;
        }
        return FocusTraversalKt.m4518focusSearch0X8WOeE(this.rootFocusNode, focusDirection, this.owner.getLayoutDirection(), focusedRect, new Function1<FocusTargetNode, Boolean>() { // from class: androidx.compose.ui.focus.FocusOwnerImpl$focusSearch$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final Boolean invoke(FocusTargetNode focusTargetNode) {
                boolean booleanValue;
                if (Intrinsics.areEqual(focusTargetNode, FocusTargetNode.this)) {
                    booleanValue = false;
                } else {
                    if (Intrinsics.areEqual(focusTargetNode, this.getRootFocusNode())) {
                        throw new IllegalStateException("Focus search landed at the root.".toString());
                    }
                    booleanValue = ((Boolean) onFound.invoke(focusTargetNode)).booleanValue();
                }
                return Boolean.valueOf(booleanValue);
            }
        });
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    /* renamed from: dispatchInterceptedSoftKeyboardEvent-ZmokQxo */
    public boolean mo4479dispatchInterceptedSoftKeyboardEventZmokQxo(KeyEvent keyEvent) {
        SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode;
        int size;
        NodeChain nodes$ui_release;
        DelegatingNode delegatingNode;
        NodeChain nodes$ui_release2;
        if (this.focusInvalidationManager.getIsInvalidationScheduled()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching intercepted soft keyboard event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode findActiveFocusNode = FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
        if (findActiveFocusNode != null) {
            FocusTargetNode focusTargetNode = findActiveFocusNode;
            int i = NodeKind.constructor-impl(Fields.RenderEffect);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            DelegatingNode node = focusTargetNode.getNode();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (requireLayoutNode == null) {
                    delegatingNode = null;
                    break;
                }
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet() & i) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & i) != 0) {
                            MutableVector mutableVector = null;
                            delegatingNode = node;
                            while (delegatingNode != null) {
                                if (delegatingNode instanceof SoftKeyboardInterceptionModifierNode) {
                                    break loop0;
                                }
                                if (((delegatingNode.getKindSet() & i) != 0) && (delegatingNode instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (DelegatingNode delegate$ui_release = delegatingNode.getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                                        if ((delegate$ui_release.getKindSet() & i) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                delegatingNode = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNode != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegatingNode);
                                                    }
                                                    delegatingNode = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                delegatingNode = DelegatableNodeKt.access$pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node = (requireLayoutNode == null || (nodes$ui_release2 = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
            }
            softKeyboardInterceptionModifierNode = (SoftKeyboardInterceptionModifierNode) delegatingNode;
        } else {
            softKeyboardInterceptionModifierNode = null;
        }
        if (softKeyboardInterceptionModifierNode != null) {
            SoftKeyboardInterceptionModifierNode softKeyboardInterceptionModifierNode2 = softKeyboardInterceptionModifierNode;
            int i3 = NodeKind.constructor-impl(Fields.RenderEffect);
            if (!softKeyboardInterceptionModifierNode2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = softKeyboardInterceptionModifierNode2.getNode().getParent();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(softKeyboardInterceptionModifierNode2);
            ArrayList arrayList = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet() & i3) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & i3) != 0) {
                            Modifier.Node node2 = parent;
                            MutableVector mutableVector2 = null;
                            while (node2 != null) {
                                if (node2 instanceof SoftKeyboardInterceptionModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node2);
                                } else if (((node2.getKindSet() & i3) != 0) && (node2 instanceof DelegatingNode)) {
                                    int i4 = 0;
                                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild()) {
                                        if ((delegate$ui_release2.getKindSet() & i3) != 0) {
                                            i4++;
                                            if (i4 == 1) {
                                                node2 = delegate$ui_release2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node2 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node2);
                                                    }
                                                    node2 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui_release2);
                                                }
                                            }
                                        }
                                    }
                                    if (i4 == 1) {
                                    }
                                }
                                node2 = DelegatableNodeKt.access$pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                parent = (requireLayoutNode2 == null || (nodes$ui_release = requireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i5 = size - 1;
                    if (((SoftKeyboardInterceptionModifierNode) arrayList.get(size)).mo5678onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                    if (i5 < 0) {
                        break;
                    }
                    size = i5;
                }
            }
            DelegatingNode node3 = softKeyboardInterceptionModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node3 != null) {
                if (!(node3 instanceof SoftKeyboardInterceptionModifierNode)) {
                    if (((node3.getKindSet() & i3) != 0) && (node3 instanceof DelegatingNode)) {
                        int i6 = 0;
                        for (DelegatingNode delegate$ui_release3 = node3.getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild()) {
                            if ((delegate$ui_release3.getKindSet() & i3) != 0) {
                                i6++;
                                if (i6 == 1) {
                                    node3 = delegate$ui_release3;
                                } else {
                                    if (mutableVector3 == null) {
                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node3 != null) {
                                        if (mutableVector3 != null) {
                                            mutableVector3.add(node3);
                                        }
                                        node3 = null;
                                    }
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(delegate$ui_release3);
                                    }
                                }
                            }
                        }
                        if (i6 == 1) {
                        }
                    }
                } else if (((SoftKeyboardInterceptionModifierNode) node3).mo5678onPreInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                    return true;
                }
                node3 = DelegatableNodeKt.access$pop(mutableVector3);
            }
            DelegatingNode node4 = softKeyboardInterceptionModifierNode2.getNode();
            MutableVector mutableVector4 = null;
            while (node4 != null) {
                if (!(node4 instanceof SoftKeyboardInterceptionModifierNode)) {
                    if (((node4.getKindSet() & i3) != 0) && (node4 instanceof DelegatingNode)) {
                        int i7 = 0;
                        for (DelegatingNode delegate$ui_release4 = node4.getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild()) {
                            if ((delegate$ui_release4.getKindSet() & i3) != 0) {
                                i7++;
                                if (i7 == 1) {
                                    node4 = delegate$ui_release4;
                                } else {
                                    if (mutableVector4 == null) {
                                        mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node4 != null) {
                                        if (mutableVector4 != null) {
                                            mutableVector4.add(node4);
                                        }
                                        node4 = null;
                                    }
                                    if (mutableVector4 != null) {
                                        mutableVector4.add(delegate$ui_release4);
                                    }
                                }
                            }
                        }
                        if (i7 == 1) {
                        }
                    }
                } else if (((SoftKeyboardInterceptionModifierNode) node4).mo5677onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                    return true;
                }
                node4 = DelegatableNodeKt.access$pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    if (((SoftKeyboardInterceptionModifierNode) arrayList.get(i8)).mo5677onInterceptKeyBeforeSoftKeyboardZmokQxo(keyEvent)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    public boolean dispatchRotaryEvent(RotaryScrollEvent event, Function0<Boolean> onFocusedItem) {
        RotaryInputModifierNode rotaryInputModifierNode;
        int size;
        NodeChain nodes$ui_release;
        DelegatingNode delegatingNode;
        NodeChain nodes$ui_release2;
        if (this.focusInvalidationManager.getIsInvalidationScheduled()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching rotary event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode findFocusTargetNode = findFocusTargetNode();
        if (findFocusTargetNode != null) {
            FocusTargetNode focusTargetNode = findFocusTargetNode;
            int i = NodeKind.constructor-impl(Fields.Clip);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            DelegatingNode node = focusTargetNode.getNode();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (requireLayoutNode == null) {
                    delegatingNode = null;
                    break;
                }
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet() & i) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & i) != 0) {
                            MutableVector mutableVector = null;
                            delegatingNode = node;
                            while (delegatingNode != null) {
                                if (delegatingNode instanceof RotaryInputModifierNode) {
                                    break loop0;
                                }
                                if (((delegatingNode.getKindSet() & i) != 0) && (delegatingNode instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (DelegatingNode delegate$ui_release = delegatingNode.getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                                        if ((delegate$ui_release.getKindSet() & i) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                delegatingNode = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNode != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegatingNode);
                                                    }
                                                    delegatingNode = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                delegatingNode = DelegatableNodeKt.access$pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node = (requireLayoutNode == null || (nodes$ui_release2 = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
            }
            rotaryInputModifierNode = (RotaryInputModifierNode) delegatingNode;
        } else {
            rotaryInputModifierNode = null;
        }
        if (rotaryInputModifierNode != null) {
            RotaryInputModifierNode rotaryInputModifierNode2 = rotaryInputModifierNode;
            int i3 = NodeKind.constructor-impl(Fields.Clip);
            if (!rotaryInputModifierNode2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = rotaryInputModifierNode2.getNode().getParent();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(rotaryInputModifierNode2);
            ArrayList arrayList = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet() & i3) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & i3) != 0) {
                            Modifier.Node node2 = parent;
                            MutableVector mutableVector2 = null;
                            while (node2 != null) {
                                if (node2 instanceof RotaryInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node2);
                                } else if (((node2.getKindSet() & i3) != 0) && (node2 instanceof DelegatingNode)) {
                                    int i4 = 0;
                                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild()) {
                                        if ((delegate$ui_release2.getKindSet() & i3) != 0) {
                                            i4++;
                                            if (i4 == 1) {
                                                node2 = delegate$ui_release2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node2 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node2);
                                                    }
                                                    node2 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui_release2);
                                                }
                                            }
                                        }
                                    }
                                    if (i4 == 1) {
                                    }
                                }
                                node2 = DelegatableNodeKt.access$pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                parent = (requireLayoutNode2 == null || (nodes$ui_release = requireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i5 = size - 1;
                    if (((RotaryInputModifierNode) arrayList.get(size)).onPreRotaryScrollEvent(event)) {
                        return true;
                    }
                    if (i5 < 0) {
                        break;
                    }
                    size = i5;
                }
            }
            DelegatingNode node3 = rotaryInputModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node3 != null) {
                if (!(node3 instanceof RotaryInputModifierNode)) {
                    if (((node3.getKindSet() & i3) != 0) && (node3 instanceof DelegatingNode)) {
                        int i6 = 0;
                        for (DelegatingNode delegate$ui_release3 = node3.getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild()) {
                            if ((delegate$ui_release3.getKindSet() & i3) != 0) {
                                i6++;
                                if (i6 == 1) {
                                    node3 = delegate$ui_release3;
                                } else {
                                    if (mutableVector3 == null) {
                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node3 != null) {
                                        if (mutableVector3 != null) {
                                            mutableVector3.add(node3);
                                        }
                                        node3 = null;
                                    }
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(delegate$ui_release3);
                                    }
                                }
                            }
                        }
                        if (i6 == 1) {
                        }
                    }
                } else if (((RotaryInputModifierNode) node3).onPreRotaryScrollEvent(event)) {
                    return true;
                }
                node3 = DelegatableNodeKt.access$pop(mutableVector3);
            }
            if (((Boolean) onFocusedItem.invoke()).booleanValue()) {
                return true;
            }
            DelegatingNode node4 = rotaryInputModifierNode2.getNode();
            MutableVector mutableVector4 = null;
            while (node4 != null) {
                if (!(node4 instanceof RotaryInputModifierNode)) {
                    if (((node4.getKindSet() & i3) != 0) && (node4 instanceof DelegatingNode)) {
                        int i7 = 0;
                        for (DelegatingNode delegate$ui_release4 = node4.getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild()) {
                            if ((delegate$ui_release4.getKindSet() & i3) != 0) {
                                i7++;
                                if (i7 == 1) {
                                    node4 = delegate$ui_release4;
                                } else {
                                    if (mutableVector4 == null) {
                                        mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node4 != null) {
                                        if (mutableVector4 != null) {
                                            mutableVector4.add(node4);
                                        }
                                        node4 = null;
                                    }
                                    if (mutableVector4 != null) {
                                        mutableVector4.add(delegate$ui_release4);
                                    }
                                }
                            }
                        }
                        if (i7 == 1) {
                        }
                    }
                } else if (((RotaryInputModifierNode) node4).onRotaryScrollEvent(event)) {
                    return true;
                }
                node4 = DelegatableNodeKt.access$pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    if (((RotaryInputModifierNode) arrayList.get(i8)).onRotaryScrollEvent(event)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    public boolean dispatchIndirectTouchEvent(IndirectTouchEvent event, Function0<Boolean> onFocusedItem) {
        IndirectTouchInputModifierNode indirectTouchInputModifierNode;
        int size;
        NodeChain nodes$ui_release;
        DelegatingNode delegatingNode;
        NodeChain nodes$ui_release2;
        if (this.focusInvalidationManager.getIsInvalidationScheduled()) {
            System.out.println((Object) "FocusRelatedWarning: Dispatching indirect touch event while the focus system is invalidated.");
            return false;
        }
        FocusTargetNode findFocusTargetNode = findFocusTargetNode();
        if (findFocusTargetNode != null) {
            FocusTargetNode focusTargetNode = findFocusTargetNode;
            int i = NodeKind.constructor-impl(2097152);
            if (!focusTargetNode.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            DelegatingNode node = focusTargetNode.getNode();
            LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
            loop0: while (true) {
                if (requireLayoutNode == null) {
                    delegatingNode = null;
                    break;
                }
                if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet() & i) != 0) {
                    while (node != null) {
                        if ((node.getKindSet() & i) != 0) {
                            MutableVector mutableVector = null;
                            delegatingNode = node;
                            while (delegatingNode != null) {
                                if (delegatingNode instanceof IndirectTouchInputModifierNode) {
                                    break loop0;
                                }
                                if (((delegatingNode.getKindSet() & i) != 0) && (delegatingNode instanceof DelegatingNode)) {
                                    int i2 = 0;
                                    for (DelegatingNode delegate$ui_release = delegatingNode.getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                                        if ((delegate$ui_release.getKindSet() & i) != 0) {
                                            i2++;
                                            if (i2 == 1) {
                                                delegatingNode = delegate$ui_release;
                                            } else {
                                                if (mutableVector == null) {
                                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (delegatingNode != null) {
                                                    if (mutableVector != null) {
                                                        mutableVector.add(delegatingNode);
                                                    }
                                                    delegatingNode = null;
                                                }
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegate$ui_release);
                                                }
                                            }
                                        }
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                delegatingNode = DelegatableNodeKt.access$pop(mutableVector);
                            }
                        }
                        node = node.getParent();
                    }
                }
                requireLayoutNode = requireLayoutNode.getParent$ui_release();
                node = (requireLayoutNode == null || (nodes$ui_release2 = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
            }
            indirectTouchInputModifierNode = (IndirectTouchInputModifierNode) delegatingNode;
        } else {
            indirectTouchInputModifierNode = null;
        }
        if (indirectTouchInputModifierNode != null) {
            IndirectTouchInputModifierNode indirectTouchInputModifierNode2 = indirectTouchInputModifierNode;
            int i3 = NodeKind.constructor-impl(2097152);
            if (!indirectTouchInputModifierNode2.getNode().getIsAttached()) {
                InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
            }
            Modifier.Node parent = indirectTouchInputModifierNode2.getNode().getParent();
            LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(indirectTouchInputModifierNode2);
            ArrayList arrayList = null;
            while (requireLayoutNode2 != null) {
                if ((requireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet() & i3) != 0) {
                    while (parent != null) {
                        if ((parent.getKindSet() & i3) != 0) {
                            Modifier.Node node2 = parent;
                            MutableVector mutableVector2 = null;
                            while (node2 != null) {
                                if (node2 instanceof IndirectTouchInputModifierNode) {
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(node2);
                                } else if (((node2.getKindSet() & i3) != 0) && (node2 instanceof DelegatingNode)) {
                                    int i4 = 0;
                                    for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild()) {
                                        if ((delegate$ui_release2.getKindSet() & i3) != 0) {
                                            i4++;
                                            if (i4 == 1) {
                                                node2 = delegate$ui_release2;
                                            } else {
                                                if (mutableVector2 == null) {
                                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                }
                                                if (node2 != null) {
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(node2);
                                                    }
                                                    node2 = null;
                                                }
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegate$ui_release2);
                                                }
                                            }
                                        }
                                    }
                                    if (i4 == 1) {
                                    }
                                }
                                node2 = DelegatableNodeKt.access$pop(mutableVector2);
                            }
                        }
                        parent = parent.getParent();
                    }
                }
                requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                parent = (requireLayoutNode2 == null || (nodes$ui_release = requireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
            }
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                while (true) {
                    int i5 = size - 1;
                    if (((IndirectTouchInputModifierNode) arrayList.get(size)).onPreIndirectTouchEvent(event)) {
                        return true;
                    }
                    if (i5 < 0) {
                        break;
                    }
                    size = i5;
                }
            }
            DelegatingNode node3 = indirectTouchInputModifierNode2.getNode();
            MutableVector mutableVector3 = null;
            while (node3 != null) {
                if (!(node3 instanceof IndirectTouchInputModifierNode)) {
                    if (((node3.getKindSet() & i3) != 0) && (node3 instanceof DelegatingNode)) {
                        int i6 = 0;
                        for (DelegatingNode delegate$ui_release3 = node3.getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild()) {
                            if ((delegate$ui_release3.getKindSet() & i3) != 0) {
                                i6++;
                                if (i6 == 1) {
                                    node3 = delegate$ui_release3;
                                } else {
                                    if (mutableVector3 == null) {
                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node3 != null) {
                                        if (mutableVector3 != null) {
                                            mutableVector3.add(node3);
                                        }
                                        node3 = null;
                                    }
                                    if (mutableVector3 != null) {
                                        mutableVector3.add(delegate$ui_release3);
                                    }
                                }
                            }
                        }
                        if (i6 == 1) {
                        }
                    }
                } else if (((IndirectTouchInputModifierNode) node3).onPreIndirectTouchEvent(event)) {
                    return true;
                }
                node3 = DelegatableNodeKt.access$pop(mutableVector3);
            }
            if (((Boolean) onFocusedItem.invoke()).booleanValue()) {
                return true;
            }
            DelegatingNode node4 = indirectTouchInputModifierNode2.getNode();
            MutableVector mutableVector4 = null;
            while (node4 != null) {
                if (!(node4 instanceof IndirectTouchInputModifierNode)) {
                    if (((node4.getKindSet() & i3) != 0) && (node4 instanceof DelegatingNode)) {
                        int i7 = 0;
                        for (DelegatingNode delegate$ui_release4 = node4.getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild()) {
                            if ((delegate$ui_release4.getKindSet() & i3) != 0) {
                                i7++;
                                if (i7 == 1) {
                                    node4 = delegate$ui_release4;
                                } else {
                                    if (mutableVector4 == null) {
                                        mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                    }
                                    if (node4 != null) {
                                        if (mutableVector4 != null) {
                                            mutableVector4.add(node4);
                                        }
                                        node4 = null;
                                    }
                                    if (mutableVector4 != null) {
                                        mutableVector4.add(delegate$ui_release4);
                                    }
                                }
                            }
                        }
                        if (i7 == 1) {
                        }
                    }
                } else if (((IndirectTouchInputModifierNode) node4).onIndirectTouchEvent(event)) {
                    return true;
                }
                node4 = DelegatableNodeKt.access$pop(mutableVector4);
            }
            if (arrayList != null) {
                int size2 = arrayList.size();
                for (int i8 = 0; i8 < size2; i8++) {
                    if (((IndirectTouchInputModifierNode) arrayList.get(i8)).onIndirectTouchEvent(event)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    public void scheduleInvalidation(FocusTargetNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    public void scheduleInvalidation(FocusEventModifierNode node) {
        this.focusInvalidationManager.scheduleInvalidation(node);
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    public void scheduleInvalidationForOwner() {
        this.focusInvalidationManager.scheduleInvalidation();
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    public Rect getFocusRect() {
        FocusTargetNode findFocusTargetNode = findFocusTargetNode();
        if (findFocusTargetNode != null) {
            return FocusTraversalKt.focusRect(findFocusTargetNode);
        }
        return null;
    }

    private final FocusTargetNode findFocusTargetNode() {
        return FocusTraversalKt.findActiveFocusNode(this.rootFocusNode);
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    public FocusState getRootState() {
        return this.rootFocusNode.getFocusState();
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    public MutableObjectList<FocusListener> getListeners() {
        return this.listeners;
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    public FocusTargetNode getActiveFocusTargetNode() {
        return this.activeFocusTargetNode;
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    public void setActiveFocusTargetNode(FocusTargetNode focusTargetNode) {
        FocusTargetNode focusTargetNode2 = this.activeFocusTargetNode;
        this.activeFocusTargetNode = focusTargetNode;
        if (focusTargetNode == null || focusTargetNode2 != focusTargetNode) {
            setFocusCaptured(false);
        }
        if (ComposeUiFlags.isSemanticAutofillEnabled) {
            MutableObjectList<FocusListener> listeners = getListeners();
            Object[] objArr = listeners.content;
            int i = listeners._size;
            for (int i2 = 0; i2 < i; i2++) {
                ((FocusListener) objArr[i2]).onFocusChanged(focusTargetNode2, focusTargetNode);
            }
        }
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    /* renamed from: isFocusCaptured, reason: from getter */
    public boolean getIsFocusCaptured() {
        return this.isFocusCaptured;
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    public void setFocusCaptured(boolean z) {
        if (!((z && getActiveFocusTargetNode() == null) ? false : true)) {
            InlineClassHelperKt.throwIllegalArgumentException("Cannot capture focus when the active focus target node is unset");
        }
        this.isFocusCaptured = z;
    }

    /* renamed from: validateKeyEvent-ZmokQxo, reason: not valid java name */
    private final boolean m4489validateKeyEventZmokQxo(KeyEvent keyEvent) {
        long m5990getKeyZmokQxo = KeyEvent_androidKt.m5990getKeyZmokQxo(keyEvent);
        int m5991getTypeZmokQxo = KeyEvent_androidKt.m5991getTypeZmokQxo(keyEvent);
        if (KeyEventType.m5983equalsimpl0(m5991getTypeZmokQxo, KeyEventType.INSTANCE.m5987getKeyDownCS__XNY())) {
            MutableLongSet mutableLongSet = this.keysCurrentlyDown;
            if (mutableLongSet == null) {
                mutableLongSet = new MutableLongSet(3);
                this.keysCurrentlyDown = mutableLongSet;
            }
            mutableLongSet.plusAssign(m5990getKeyZmokQxo);
        } else if (KeyEventType.m5983equalsimpl0(m5991getTypeZmokQxo, KeyEventType.INSTANCE.m5988getKeyUpCS__XNY())) {
            MutableLongSet mutableLongSet2 = this.keysCurrentlyDown;
            if (!(mutableLongSet2 != null && mutableLongSet2.contains(m5990getKeyZmokQxo))) {
                return false;
            }
            MutableLongSet mutableLongSet3 = this.keysCurrentlyDown;
            if (mutableLongSet3 != null) {
                mutableLongSet3.remove(m5990getKeyZmokQxo);
            }
        }
        return true;
    }

    @Override // androidx.compose.p002ui.focus.FocusOwner
    /* renamed from: dispatchKeyEvent-YhN2O0w */
    public boolean mo4480dispatchKeyEventYhN2O0w(KeyEvent keyEvent, Function0<Boolean> onFocusedItem) {
        DelegatingNode delegatingNode;
        Modifier.Node node;
        NodeChain nodes$ui_release;
        DelegatingNode delegatingNode2;
        NodeChain nodes$ui_release2;
        NodeChain nodes$ui_release3;
        Trace.beginSection("FocusOwnerImpl:dispatchKeyEvent");
        try {
            if (this.focusInvalidationManager.getIsInvalidationScheduled()) {
                System.out.println((Object) "FocusRelatedWarning: Dispatching key event while focus system is invalidated.");
                return false;
            }
            if (!m4489validateKeyEventZmokQxo(keyEvent)) {
                return false;
            }
            FocusTargetNode findFocusTargetNode = findFocusTargetNode();
            if (findFocusTargetNode == null || (node = lastLocalKeyInputNode(findFocusTargetNode)) == null) {
                if (findFocusTargetNode != null) {
                    FocusTargetNode focusTargetNode = findFocusTargetNode;
                    int i = NodeKind.constructor-impl(Fields.Shape);
                    if (!focusTargetNode.getNode().getIsAttached()) {
                        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                    }
                    DelegatingNode node2 = focusTargetNode.getNode();
                    LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode);
                    loop10: while (true) {
                        if (requireLayoutNode == null) {
                            delegatingNode2 = null;
                            break;
                        }
                        if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet() & i) != 0) {
                            while (node2 != null) {
                                if ((node2.getKindSet() & i) != 0) {
                                    MutableVector mutableVector = null;
                                    delegatingNode2 = node2;
                                    while (delegatingNode2 != null) {
                                        if (delegatingNode2 instanceof KeyInputModifierNode) {
                                            break loop10;
                                        }
                                        if (((delegatingNode2.getKindSet() & i) != 0) && (delegatingNode2 instanceof DelegatingNode)) {
                                            int i2 = 0;
                                            for (DelegatingNode delegate$ui_release = delegatingNode2.getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                                                if ((delegate$ui_release.getKindSet() & i) != 0) {
                                                    i2++;
                                                    if (i2 == 1) {
                                                        Unit unit = Unit.INSTANCE;
                                                        delegatingNode2 = delegate$ui_release;
                                                    } else {
                                                        if (mutableVector == null) {
                                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                                        }
                                                        if (delegatingNode2 != null) {
                                                            if (mutableVector != null) {
                                                                Boolean.valueOf(mutableVector.add(delegatingNode2));
                                                            }
                                                            delegatingNode2 = null;
                                                        }
                                                        if (mutableVector != null) {
                                                            Boolean.valueOf(mutableVector.add(delegate$ui_release));
                                                        }
                                                    }
                                                }
                                            }
                                            if (i2 == 1) {
                                            }
                                        }
                                        delegatingNode2 = DelegatableNodeKt.access$pop(mutableVector);
                                    }
                                }
                                node2 = node2.getParent();
                            }
                        }
                        requireLayoutNode = requireLayoutNode.getParent$ui_release();
                        node2 = (requireLayoutNode == null || (nodes$ui_release2 = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release2.getTail$ui_release();
                    }
                    KeyInputModifierNode keyInputModifierNode = (KeyInputModifierNode) delegatingNode2;
                    if (keyInputModifierNode != null) {
                        node = keyInputModifierNode.getNode();
                    }
                }
                FocusTargetNode focusTargetNode2 = this.rootFocusNode;
                int i3 = NodeKind.constructor-impl(Fields.Shape);
                if (!focusTargetNode2.getNode().getIsAttached()) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                DelegatingNode parent = focusTargetNode2.getNode().getParent();
                LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
                loop14: while (true) {
                    if (requireLayoutNode2 == null) {
                        delegatingNode = null;
                        break;
                    }
                    if ((requireLayoutNode2.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet() & i3) != 0) {
                        while (parent != null) {
                            if ((parent.getKindSet() & i3) != 0) {
                                MutableVector mutableVector2 = null;
                                delegatingNode = parent;
                                while (delegatingNode != null) {
                                    if (delegatingNode instanceof KeyInputModifierNode) {
                                        break loop14;
                                    }
                                    if (((delegatingNode.getKindSet() & i3) != 0) && (delegatingNode instanceof DelegatingNode)) {
                                        int i4 = 0;
                                        for (DelegatingNode delegate$ui_release2 = delegatingNode.getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild()) {
                                            if ((delegate$ui_release2.getKindSet() & i3) != 0) {
                                                i4++;
                                                if (i4 == 1) {
                                                    Unit unit2 = Unit.INSTANCE;
                                                    delegatingNode = delegate$ui_release2;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (delegatingNode != null) {
                                                        if (mutableVector2 != null) {
                                                            Boolean.valueOf(mutableVector2.add(delegatingNode));
                                                        }
                                                        delegatingNode = null;
                                                    }
                                                    if (mutableVector2 != null) {
                                                        Boolean.valueOf(mutableVector2.add(delegate$ui_release2));
                                                    }
                                                }
                                            }
                                        }
                                        if (i4 == 1) {
                                        }
                                    }
                                    delegatingNode = DelegatableNodeKt.access$pop(mutableVector2);
                                }
                            }
                            parent = parent.getParent();
                        }
                    }
                    requireLayoutNode2 = requireLayoutNode2.getParent$ui_release();
                    parent = (requireLayoutNode2 == null || (nodes$ui_release = requireLayoutNode2.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
                }
                KeyInputModifierNode keyInputModifierNode2 = (KeyInputModifierNode) delegatingNode;
                node = keyInputModifierNode2 != null ? keyInputModifierNode2.getNode() : null;
            }
            if (node != null) {
                Modifier.Node node3 = node;
                int i5 = NodeKind.constructor-impl(Fields.Shape);
                if (!node3.getNode().getIsAttached()) {
                    InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
                }
                Modifier.Node parent2 = node3.getNode().getParent();
                LayoutNode requireLayoutNode3 = DelegatableNodeKt.requireLayoutNode(node3);
                ArrayList arrayList = null;
                while (requireLayoutNode3 != null) {
                    if ((requireLayoutNode3.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet() & i5) != 0) {
                        while (parent2 != null) {
                            if ((parent2.getKindSet() & i5) != 0) {
                                Modifier.Node node4 = parent2;
                                MutableVector mutableVector3 = null;
                                while (node4 != null) {
                                    if (node4 instanceof KeyInputModifierNode) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(node4);
                                    } else if (((node4.getKindSet() & i5) != 0) && (node4 instanceof DelegatingNode)) {
                                        int i6 = 0;
                                        for (Modifier.Node delegate$ui_release3 = ((DelegatingNode) node4).getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild()) {
                                            if ((delegate$ui_release3.getKindSet() & i5) != 0) {
                                                i6++;
                                                if (i6 == 1) {
                                                    Unit unit3 = Unit.INSTANCE;
                                                    node4 = delegate$ui_release3;
                                                } else {
                                                    if (mutableVector3 == null) {
                                                        mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (node4 != null) {
                                                        if (mutableVector3 != null) {
                                                            Boolean.valueOf(mutableVector3.add(node4));
                                                        }
                                                        node4 = null;
                                                    }
                                                    if (mutableVector3 != null) {
                                                        Boolean.valueOf(mutableVector3.add(delegate$ui_release3));
                                                    }
                                                }
                                            }
                                        }
                                        if (i6 == 1) {
                                        }
                                    }
                                    node4 = DelegatableNodeKt.access$pop(mutableVector3);
                                }
                            }
                            parent2 = parent2.getParent();
                        }
                    }
                    requireLayoutNode3 = requireLayoutNode3.getParent$ui_release();
                    parent2 = (requireLayoutNode3 == null || (nodes$ui_release3 = requireLayoutNode3.getNodes$ui_release()) == null) ? null : nodes$ui_release3.getTail$ui_release();
                }
                if (arrayList != null) {
                    int size = arrayList.size() - 1;
                    if (size >= 0) {
                        while (true) {
                            int i7 = size - 1;
                            if (((KeyInputModifierNode) arrayList.get(size)).mo364onPreKeyEventZmokQxo(keyEvent)) {
                                return true;
                            }
                            if (i7 < 0) {
                                break;
                            }
                            size = i7;
                        }
                    }
                    Unit unit4 = Unit.INSTANCE;
                }
                Modifier.Node node5 = node3.getNode();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = node5;
                while (objectRef2.element != null) {
                    if (!(objectRef2.element instanceof KeyInputModifierNode)) {
                        if (((((Modifier.Node) objectRef2.element).getKindSet() & i5) != 0) && (objectRef2.element instanceof DelegatingNode)) {
                            int i8 = 0;
                            for (Modifier.Node delegate$ui_release4 = ((DelegatingNode) objectRef2.element).getDelegate$ui_release(); delegate$ui_release4 != null; delegate$ui_release4 = delegate$ui_release4.getChild()) {
                                if ((delegate$ui_release4.getKindSet() & i5) != 0) {
                                    i8++;
                                    if (i8 == 1) {
                                        objectRef2.element = delegate$ui_release4;
                                        Unit unit5 = Unit.INSTANCE;
                                    } else {
                                        MutableVector mutableVector4 = (MutableVector) objectRef.element;
                                        if (mutableVector4 == null) {
                                            mutableVector4 = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        objectRef.element = mutableVector4;
                                        Modifier.Node node6 = (Modifier.Node) objectRef2.element;
                                        if (node6 != null) {
                                            MutableVector mutableVector5 = (MutableVector) objectRef.element;
                                            if (mutableVector5 != null) {
                                                Boolean.valueOf(mutableVector5.add(node6));
                                            }
                                            objectRef2.element = null;
                                        }
                                        MutableVector mutableVector6 = (MutableVector) objectRef.element;
                                        if (mutableVector6 != null) {
                                            Boolean.valueOf(mutableVector6.add(delegate$ui_release4));
                                        }
                                    }
                                }
                            }
                            if (i8 == 1) {
                            }
                        }
                    } else if (((KeyInputModifierNode) objectRef2.element).mo364onPreKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                    objectRef2.element = DelegatableNodeKt.access$pop((MutableVector) objectRef.element);
                }
                if (((Boolean) onFocusedItem.invoke()).booleanValue()) {
                    return true;
                }
                Modifier.Node node7 = node3.getNode();
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
                objectRef4.element = node7;
                while (objectRef4.element != null) {
                    if (!(objectRef4.element instanceof KeyInputModifierNode)) {
                        if (((((Modifier.Node) objectRef4.element).getKindSet() & i5) != 0) && (objectRef4.element instanceof DelegatingNode)) {
                            int i9 = 0;
                            for (Modifier.Node delegate$ui_release5 = ((DelegatingNode) objectRef4.element).getDelegate$ui_release(); delegate$ui_release5 != null; delegate$ui_release5 = delegate$ui_release5.getChild()) {
                                if ((delegate$ui_release5.getKindSet() & i5) != 0) {
                                    i9++;
                                    if (i9 == 1) {
                                        objectRef4.element = delegate$ui_release5;
                                        Unit unit6 = Unit.INSTANCE;
                                    } else {
                                        MutableVector mutableVector7 = (MutableVector) objectRef3.element;
                                        if (mutableVector7 == null) {
                                            mutableVector7 = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        objectRef3.element = mutableVector7;
                                        Modifier.Node node8 = (Modifier.Node) objectRef4.element;
                                        if (node8 != null) {
                                            MutableVector mutableVector8 = (MutableVector) objectRef3.element;
                                            if (mutableVector8 != null) {
                                                Boolean.valueOf(mutableVector8.add(node8));
                                            }
                                            objectRef4.element = null;
                                        }
                                        MutableVector mutableVector9 = (MutableVector) objectRef3.element;
                                        if (mutableVector9 != null) {
                                            Boolean.valueOf(mutableVector9.add(delegate$ui_release5));
                                        }
                                    }
                                }
                            }
                            if (i9 == 1) {
                            }
                        }
                    } else if (((KeyInputModifierNode) objectRef4.element).mo362onKeyEventZmokQxo(keyEvent)) {
                        return true;
                    }
                    objectRef4.element = DelegatableNodeKt.access$pop((MutableVector) objectRef3.element);
                }
                if (arrayList != null) {
                    int size2 = arrayList.size();
                    for (int i10 = 0; i10 < size2; i10++) {
                        if (((KeyInputModifierNode) arrayList.get(i10)).mo362onKeyEventZmokQxo(keyEvent)) {
                            return true;
                        }
                    }
                    Unit unit7 = Unit.INSTANCE;
                }
                Unit unit8 = Unit.INSTANCE;
            }
            return false;
        } finally {
            Trace.endSection();
        }
    }

    /* renamed from: traverseAncestorsIncludingSelf-QFhIj7k, reason: not valid java name */
    private final /* synthetic */ <T extends DelegatableNode> void m4488traverseAncestorsIncludingSelfQFhIj7k(DelegatableNode delegatableNode, int i, Function1<? super T, Unit> function1, Function0<Unit> function0, Function1<? super T, Unit> function12) {
        int i2;
        int size;
        NodeChain nodes$ui_release;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent = delegatableNode.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        ArrayList arrayList = null;
        while (true) {
            if (requireLayoutNode == null) {
                break;
            }
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet() & i) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & i) != 0) {
                        Modifier.Node node = parent;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if (node instanceof Object) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(node);
                            } else if (((node.getKindSet() & i) != 0) && (node instanceof DelegatingNode)) {
                                int i3 = 0;
                                for (Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                                    if ((delegate$ui_release.getKindSet() & i) != 0) {
                                        i3++;
                                        if (i3 == 1) {
                                            node = delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i3 == 1) {
                                }
                            }
                            node = DelegatableNodeKt.access$pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        if (arrayList != null && arrayList.size() - 1 >= 0) {
            while (true) {
                int i4 = size - 1;
                function1.invoke(arrayList.get(size));
                if (i4 < 0) {
                    break;
                } else {
                    size = i4;
                }
            }
        }
        Modifier.Node node2 = delegatableNode.getNode();
        MutableVector mutableVector2 = null;
        while (node2 != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (node2 instanceof Object) {
                function1.invoke(node2);
            } else if (((node2.getKindSet() & i) != 0) && (node2 instanceof DelegatingNode)) {
                int i5 = 0;
                for (Modifier.Node delegate$ui_release2 = ((DelegatingNode) node2).getDelegate$ui_release(); delegate$ui_release2 != null; delegate$ui_release2 = delegate$ui_release2.getChild()) {
                    if ((delegate$ui_release2.getKindSet() & i) != 0) {
                        i5++;
                        if (i5 == 1) {
                            node2 = delegate$ui_release2;
                        } else {
                            if (mutableVector2 == null) {
                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node2 != null) {
                                if (mutableVector2 != null) {
                                    mutableVector2.add(node2);
                                }
                                node2 = null;
                            }
                            if (mutableVector2 != null) {
                                mutableVector2.add(delegate$ui_release2);
                            }
                        }
                    }
                }
                if (i5 == 1) {
                }
            }
            node2 = DelegatableNodeKt.access$pop(mutableVector2);
        }
        function0.invoke();
        Modifier.Node node3 = delegatableNode.getNode();
        MutableVector mutableVector3 = null;
        while (node3 != null) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (node3 instanceof Object) {
                function12.invoke(node3);
            } else if (((node3.getKindSet() & i) != 0) && (node3 instanceof DelegatingNode)) {
                int i6 = 0;
                for (Modifier.Node delegate$ui_release3 = ((DelegatingNode) node3).getDelegate$ui_release(); delegate$ui_release3 != null; delegate$ui_release3 = delegate$ui_release3.getChild()) {
                    if ((delegate$ui_release3.getKindSet() & i) != 0) {
                        i6++;
                        if (i6 == 1) {
                            node3 = delegate$ui_release3;
                        } else {
                            if (mutableVector3 == null) {
                                mutableVector3 = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (node3 != null) {
                                if (mutableVector3 != null) {
                                    mutableVector3.add(node3);
                                }
                                node3 = null;
                            }
                            if (mutableVector3 != null) {
                                mutableVector3.add(delegate$ui_release3);
                            }
                        }
                    }
                }
                if (i6 == 1) {
                }
            }
            node3 = DelegatableNodeKt.access$pop(mutableVector3);
        }
        if (arrayList != null) {
            int size2 = arrayList.size();
            for (i2 = 0; i2 < size2; i2++) {
                function12.invoke(arrayList.get(i2));
            }
        }
    }

    /* renamed from: nearestAncestorIncludingSelf-64DMado, reason: not valid java name */
    private final /* synthetic */ <T> T m4487nearestAncestorIncludingSelf64DMado(DelegatableNode delegatableNode, int i) {
        NodeChain nodes$ui_release;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        DelegatingNode node = delegatableNode.getNode();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet() & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        DelegatingNode delegatingNode = (T) node;
                        MutableVector mutableVector = null;
                        while (delegatingNode != null) {
                            Intrinsics.reifiedOperationMarker(3, "T");
                            if (delegatingNode instanceof Object) {
                                return (T) delegatingNode;
                            }
                            DelegatingNode delegatingNode2 = delegatingNode;
                            if (((((Modifier.Node) delegatingNode).getKindSet() & i) != 0) && (delegatingNode instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (DelegatingNode delegate$ui_release = delegatingNode.getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                                    if ((delegate$ui_release.getKindSet() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            delegatingNode = (T) delegate$ui_release;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            DelegatingNode delegatingNode3 = delegatingNode;
                                            if (delegatingNode != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(delegatingNode);
                                                }
                                                delegatingNode = (T) null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            delegatingNode = (T) DelegatableNodeKt.access$pop(mutableVector);
                        }
                    }
                    node = node.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            node = (requireLayoutNode == null || (nodes$ui_release = requireLayoutNode.getNodes$ui_release()) == null) ? null : nodes$ui_release.getTail$ui_release();
        }
        return null;
    }

    private final Modifier.Node lastLocalKeyInputNode(DelegatableNode delegatableNode) {
        int i = NodeKind.constructor-impl(Fields.RotationZ) | NodeKind.constructor-impl(Fields.Shape);
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        Modifier.Node node2 = null;
        if ((node.getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node child = node.getChild(); child != null; child = child.getChild()) {
                if ((child.getKindSet() & i) != 0) {
                    if ((NodeKind.constructor-impl(Fields.RotationZ) & child.getKindSet()) != 0) {
                        return node2;
                    }
                    node2 = child;
                }
            }
        }
        return node2;
    }
}
