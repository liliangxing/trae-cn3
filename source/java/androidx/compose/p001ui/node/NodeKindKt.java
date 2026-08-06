package androidx.compose.p001ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.p001ui.relocation.BringIntoViewModifierNode;
import androidx.compose.p001ui.semantics.SemanticsModifier;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.focus.FocusEventModifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusEventModifierNodeKt;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusPropertiesModifierNodeKt;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.input.indirect.IndirectTouchInputModifierNode;
import androidx.compose.ui.input.key.KeyInputModifierNode;
import androidx.compose.ui.input.key.SoftKeyboardInterceptionModifierNode;
import androidx.compose.ui.input.pointer.PointerInputModifier;
import androidx.compose.ui.input.rotary.RotaryInputModifierNode;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.OnRemeasuredModifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;

/* compiled from: NodeKind.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0080\f¢\u0006\u0004\b\u0004\u0010\u0005\u001a \u0010\u0006\u001a\u00020\u0007*\u00020\u00012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0080\n¢\u0006\u0004\b\t\u0010\n\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\u001a \u0010!\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0001H\u0000\u001a \u0010$\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010%\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0001H\u0002\u001a\f\u0010&\u001a\u00020\u0007*\u00020'H\u0002\u001a\u0010\u0010(\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0000\"\u001c\u0010\u000b\u001a\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0016\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0018\"\u0014\u0010\u0019\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u001a\u0010\u0018\"\u0014\u0010\u001b\u001a\u00020\u0001X\u0082T¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0018¨\u0006)"}, d2 = {"or", "", "other", "Landroidx/compose/ui/node/NodeKind;", "or-64DMado", "(II)I", "contains", "", StrategyConstants.VALUE, "contains-64DMado", "(II)Z", "includeSelfInTraversal", "getIncludeSelfInTraversal-H91voCI", "(I)Z", "calculateNodeKindSetFrom", "element", "Landroidx/compose/ui/Modifier$Element;", "classToKindSetMap", "Landroidx/collection/MutableObjectIntMap;", "", "node", "Landroidx/compose/ui/Modifier$Node;", "Updated", "getUpdated$annotations", "()V", "Inserted", "getInserted$annotations", "Removed", "getRemoved$annotations", "autoInvalidateRemovedNode", "", "autoInvalidateInsertedNode", "autoInvalidateUpdatedNode", "autoInvalidateNodeIncludingDelegates", "remainingSet", "phase", "autoInvalidateNodeSelf", "selfKindSet", "specifiesCanFocusProperty", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "calculateNodeKindSetFromIncludingDelegates", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class NodeKindKt {
    private static final int Inserted = 1;
    private static final int Removed = 2;
    private static final int Updated = 0;
    private static final MutableObjectIntMap<Object> classToKindSetMap = ObjectIntMapKt.mutableObjectIntMapOf();

    /* renamed from: contains-64DMado, reason: not valid java name */
    public static final boolean m1570contains64DMado(int i, int i2) {
        return (i & i2) != 0;
    }

    private static /* synthetic */ void getInserted$annotations() {
    }

    private static /* synthetic */ void getRemoved$annotations() {
    }

    private static /* synthetic */ void getUpdated$annotations() {
    }

    /* renamed from: or-64DMado, reason: not valid java name */
    public static final int m1572or64DMado(int i, int i2) {
        return i | i2;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Node node) {
        if (node.getKindSet$ui_release() != 0) {
            return node.getKindSet$ui_release();
        }
        MutableObjectIntMap<Object> mutableObjectIntMap = classToKindSetMap;
        Object classKeyForObject = Actual_jvmKt.classKeyForObject(node);
        int findKeyIndex = mutableObjectIntMap.findKeyIndex(classKeyForObject);
        if (findKeyIndex >= 0) {
            return mutableObjectIntMap.values[findKeyIndex];
        }
        int m1562constructorimpl = NodeKind.m1562constructorimpl(1);
        if (node instanceof LayoutModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(2);
        }
        if (node instanceof DrawModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(4);
        }
        if (node instanceof SemanticsModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(8);
        }
        if (node instanceof PointerInputModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(16);
        }
        if (node instanceof ModifierLocalModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(32);
        }
        if (node instanceof ParentDataModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(64);
        }
        if (node instanceof LayoutAwareModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(128);
        }
        if (node instanceof GlobalPositionAwareModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(256);
        }
        if (node instanceof ApproachLayoutModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(512);
        }
        if (node instanceof FocusTargetNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(1024);
        }
        if (node instanceof FocusPropertiesModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(2048);
        }
        if (node instanceof FocusEventModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(4096);
        }
        if (node instanceof KeyInputModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(8192);
        }
        if (node instanceof RotaryInputModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(16384);
        }
        if (node instanceof CompositionLocalConsumerModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(32768);
        }
        if (node instanceof SoftKeyboardInterceptionModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(131072);
        }
        if (node instanceof TraversableNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(262144);
        }
        if (node instanceof BringIntoViewModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(524288);
        }
        if (node instanceof OnUnplacedModifierNode) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(1048576);
        }
        int m1562constructorimpl2 = node instanceof IndirectTouchInputModifierNode ? NodeKind.m1562constructorimpl(2097152) | m1562constructorimpl : m1562constructorimpl;
        mutableObjectIntMap.set(classKeyForObject, m1562constructorimpl2);
        return m1562constructorimpl2;
    }

    public static final void autoInvalidateRemovedNode(Modifier.Node node) {
        if (!node.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateRemovedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 2);
    }

    public static final void autoInvalidateInsertedNode(Modifier.Node node) {
        if (!node.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateInsertedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 1);
    }

    public static final void autoInvalidateUpdatedNode(Modifier.Node node) {
        if (!node.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("autoInvalidateUpdatedNode called on unattached node");
        }
        autoInvalidateNodeIncludingDelegates(node, -1, 0);
    }

    public static final void autoInvalidateNodeIncludingDelegates(Modifier.Node node, int i, int i2) {
        if (node instanceof DelegatingNode) {
            DelegatingNode delegatingNode = (DelegatingNode) node;
            autoInvalidateNodeSelf(node, delegatingNode.getSelfKindSet() & i, i2);
            int i3 = (~delegatingNode.getSelfKindSet()) & i;
            for (Modifier.Node delegate = delegatingNode.getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                autoInvalidateNodeIncludingDelegates(delegate, i3, i2);
            }
            return;
        }
        autoInvalidateNodeSelf(node, i & node.getKindSet$ui_release(), i2);
    }

    private static final void autoInvalidateNodeSelf(Modifier.Node node, int i, int i2) {
        if (i2 != 0 || node.getShouldAutoInvalidate()) {
            if (((NodeKind.m1562constructorimpl(2) & i) != 0) && (node instanceof LayoutModifierNode)) {
                LayoutModifierNodeKt.invalidateMeasurement((LayoutModifierNode) node);
                if (i2 == 2) {
                    DelegatableNodeKt.m1341requireCoordinator64DMado((DelegatableNode) node, NodeKind.m1562constructorimpl(2)).onRelease();
                }
            }
            if (((NodeKind.m1562constructorimpl(128) & i) != 0) && (node instanceof LayoutAwareModifierNode) && i2 != 2) {
                DelegatableNodeKt.requireLayoutNode((DelegatableNode) node).invalidateMeasurements$ui_release();
            }
            if (((NodeKind.m1562constructorimpl(256) & i) != 0) && (node instanceof GlobalPositionAwareModifierNode)) {
                if (i2 == 1) {
                    LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode((DelegatableNode) node);
                    requireLayoutNode.setGloballyPositionedObservers(requireLayoutNode.getGloballyPositionedObservers() + 1);
                } else if (i2 == 2) {
                    DelegatableNodeKt.requireLayoutNode((DelegatableNode) node).setGloballyPositionedObservers(r1.getGloballyPositionedObservers() - 1);
                }
                if (i2 != 2) {
                    DelegatableNodeKt.requireLayoutNode((DelegatableNode) node).invalidateOnPositioned$ui_release();
                }
            }
            if (((NodeKind.m1562constructorimpl(4) & i) != 0) && (node instanceof DrawModifierNode)) {
                DrawModifierNodeKt.invalidateDraw((DrawModifierNode) node);
            }
            if (((NodeKind.m1562constructorimpl(8) & i) != 0) && (node instanceof SemanticsModifierNode)) {
                DelegatableNodeKt.requireLayoutNode((DelegatableNode) node).setSemanticsInvalidated$ui_release(true);
            }
            if (((NodeKind.m1562constructorimpl(64) & i) != 0) && (node instanceof ParentDataModifierNode)) {
                ParentDataModifierNodeKt.invalidateParentData((ParentDataModifierNode) node);
            }
            if (((NodeKind.m1562constructorimpl(2048) & i) != 0) && (node instanceof FocusPropertiesModifierNode)) {
                FocusPropertiesModifierNode focusPropertiesModifierNode = (FocusPropertiesModifierNode) node;
                if (specifiesCanFocusProperty(focusPropertiesModifierNode)) {
                    FocusPropertiesModifierNodeKt.invalidateFocusProperties(focusPropertiesModifierNode);
                }
            }
            if (((i & NodeKind.m1562constructorimpl(4096)) != 0) && (node instanceof FocusEventModifierNode)) {
                FocusEventModifierNodeKt.invalidateFocusEvent((FocusEventModifierNode) node);
            }
        }
    }

    private static final boolean specifiesCanFocusProperty(FocusPropertiesModifierNode focusPropertiesModifierNode) {
        CanFocusChecker.INSTANCE.reset();
        focusPropertiesModifierNode.applyFocusProperties(CanFocusChecker.INSTANCE);
        return CanFocusChecker.INSTANCE.isCanFocusSet();
    }

    public static final int calculateNodeKindSetFromIncludingDelegates(Modifier.Node node) {
        if (node instanceof DelegatingNode) {
            DelegatingNode delegatingNode = (DelegatingNode) node;
            int selfKindSet = delegatingNode.getSelfKindSet();
            for (Modifier.Node delegate = delegatingNode.getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                selfKindSet |= calculateNodeKindSetFromIncludingDelegates(delegate);
            }
            return selfKindSet;
        }
        return calculateNodeKindSetFrom(node);
    }

    /* renamed from: getIncludeSelfInTraversal-H91voCI, reason: not valid java name */
    public static final boolean m1571getIncludeSelfInTraversalH91voCI(int i) {
        return (i & NodeKind.m1562constructorimpl(128)) != 0;
    }

    public static final int calculateNodeKindSetFrom(Modifier.Element element) {
        int m1562constructorimpl = NodeKind.m1562constructorimpl(1);
        if (element instanceof LayoutModifier) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(2);
        }
        if (element instanceof DrawModifier) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(4);
        }
        if (element instanceof SemanticsModifier) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(8);
        }
        if (element instanceof PointerInputModifier) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(16);
        }
        if ((element instanceof ModifierLocalConsumer) || (element instanceof ModifierLocalProvider)) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(32);
        }
        if (element instanceof FocusEventModifier) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(4096);
        }
        if (element instanceof FocusOrderModifier) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(2048);
        }
        if (element instanceof OnGloballyPositionedModifier) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(256);
        }
        if (element instanceof ParentDataModifier) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(64);
        }
        if ((element instanceof OnPlacedModifier) || (element instanceof OnRemeasuredModifier)) {
            m1562constructorimpl |= NodeKind.m1562constructorimpl(128);
        }
        return element instanceof BringIntoViewModifierNode ? m1562constructorimpl | NodeKind.m1562constructorimpl(524288) : m1562constructorimpl;
    }
}
