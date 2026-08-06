package androidx.compose.p001ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatingNode.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0010¢\u0006\u0002\b\rJ!\u0010\u0013\u001a\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0014H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0001H\u0010¢\u0006\u0002\b\u001eJ\u001f\u0010\u000e\u001a\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0014H\u0004¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0015H\u0004J\u0018\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0001H\u0002J\u0018\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0002J\"\u0010'\u001a\u00020\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0)H\u0080\b¢\u0006\u0002\b*J\r\u0010+\u001a\u00020\nH\u0010¢\u0006\u0002\b,J\r\u0010-\u001a\u00020\nH\u0010¢\u0006\u0002\b.J\r\u0010/\u001a\u00020\nH\u0010¢\u0006\u0002\b0J\r\u00101\u001a\u00020\nH\u0010¢\u0006\u0002\b2J\r\u00103\u001a\u00020\nH\u0010¢\u0006\u0002\b4R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u00065"}, d2 = {"Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "selfKindSet", "", "getSelfKindSet$ui_release$annotations", "getSelfKindSet$ui_release", "()I", "updateCoordinator", "", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "updateCoordinator$ui_release", "delegate", "getDelegate$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "setDelegate$ui_release", "(Landroidx/compose/ui/Modifier$Node;)V", "delegateUnprotected", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/DelegatableNode;", "delegatableNode", "delegateUnprotected$ui_release", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/DelegatableNode;", "undelegateUnprotected", "instance", "undelegateUnprotected$ui_release", "setAsDelegateTo", "owner", "setAsDelegateTo$ui_release", "undelegate", "validateDelegateKindSet", "delegateKindSet", "delegateNode", "updateNodeKindSet", "newKindSet", "recalculateOwner", "", "forEachImmediateDelegate", "block", "Lkotlin/Function1;", "forEachImmediateDelegate$ui_release", "markAsAttached", "markAsAttached$ui_release", "runAttachLifecycle", "runAttachLifecycle$ui_release", "runDetachLifecycle", "runDetachLifecycle$ui_release", "markAsDetached", "markAsDetached$ui_release", "reset", "reset$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class DelegatingNode extends Modifier.Node {
    public static final int $stable = 8;
    private Modifier.Node delegate;
    private final int selfKindSet = NodeKindKt.calculateNodeKindSetFrom(this);

    public static /* synthetic */ void getSelfKindSet$ui_release$annotations() {
    }

    /* renamed from: getSelfKindSet$ui_release, reason: from getter */
    public final int getSelfKindSet() {
        return this.selfKindSet;
    }

    public void updateCoordinator$ui_release(NodeCoordinator coordinator) {
        super.updateCoordinator$ui_release(coordinator);
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
            delegate.updateCoordinator$ui_release(coordinator);
        }
    }

    /* renamed from: getDelegate$ui_release, reason: from getter */
    public final Modifier.Node getDelegate() {
        return this.delegate;
    }

    public final void setDelegate$ui_release(Modifier.Node node) {
        this.delegate = node;
    }

    public final <T extends DelegatableNode> T delegateUnprotected$ui_release(T delegatableNode) {
        return (T) delegate(delegatableNode);
    }

    public final void undelegateUnprotected$ui_release(DelegatableNode instance) {
        undelegate(instance);
    }

    public void setAsDelegateTo$ui_release(Modifier.Node owner) {
        super.setAsDelegateTo$ui_release(owner);
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
            delegate.setAsDelegateTo$ui_release(owner);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final <T extends DelegatableNode> T delegate(T delegatableNode) {
        Modifier.Node node = delegatableNode.getNode();
        if (node != delegatableNode) {
            Modifier.Node node2 = delegatableNode instanceof Modifier.Node ? (Modifier.Node) delegatableNode : null;
            if (node == getNode() && Intrinsics.areEqual(node2 != null ? node2.getParent$ui_release() : null, this)) {
                return delegatableNode;
            }
            throw new IllegalStateException("Cannot delegate to an already delegated node".toString());
        }
        if (!(!node.isAttached())) {
            InlineClassHelperKt.throwIllegalStateException("Cannot delegate to an already attached node");
        }
        node.setAsDelegateTo$ui_release(getNode());
        int kindSet$ui_release = getKindSet$ui_release();
        int calculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node);
        node.setKindSet$ui_release(calculateNodeKindSetFromIncludingDelegates);
        validateDelegateKindSet(calculateNodeKindSetFromIncludingDelegates, node);
        node.setChild$ui_release(this.delegate);
        this.delegate = node;
        node.setParent$ui_release(this);
        updateNodeKindSet(getKindSet$ui_release() | calculateNodeKindSetFromIncludingDelegates, false);
        if (isAttached()) {
            if ((calculateNodeKindSetFromIncludingDelegates & NodeKind.m1562constructorimpl(2)) != 0) {
                if (!((kindSet$ui_release & NodeKind.m1562constructorimpl(2)) != 0)) {
                    NodeChain nodes = DelegatableNodeKt.requireLayoutNode((DelegatableNode) this).getNodes();
                    getNode().updateCoordinator$ui_release((NodeCoordinator) null);
                    nodes.syncCoordinators();
                    node.markAsAttached$ui_release();
                    node.runAttachLifecycle$ui_release();
                    NodeKindKt.autoInvalidateInsertedNode(node);
                }
            }
            updateCoordinator$ui_release(getCoordinator$ui_release());
            node.markAsAttached$ui_release();
            node.runAttachLifecycle$ui_release();
            NodeKindKt.autoInvalidateInsertedNode(node);
        }
        return delegatableNode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void undelegate(DelegatableNode instance) {
        boolean z;
        Modifier.Node node = this.delegate;
        Modifier.Node node2 = null;
        while (true) {
            if (node == null) {
                z = false;
                break;
            }
            if (node == instance) {
                if (node.isAttached()) {
                    NodeKindKt.autoInvalidateRemovedNode(node);
                    node.runDetachLifecycle$ui_release();
                    node.markAsDetached$ui_release();
                }
                node.setAsDelegateTo$ui_release(node);
                node.setAggregateChildKindSet$ui_release(0);
                if (node2 == null) {
                    this.delegate = node.getChild$ui_release();
                } else {
                    node2.setChild$ui_release(node.getChild$ui_release());
                }
                node.setChild$ui_release((Modifier.Node) null);
                node.setParent$ui_release((Modifier.Node) null);
                z = true;
            } else {
                node2 = node;
                node = node.getChild$ui_release();
            }
        }
        if (z) {
            int kindSet$ui_release = getKindSet$ui_release();
            int calculateNodeKindSetFromIncludingDelegates = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(this);
            updateNodeKindSet(calculateNodeKindSetFromIncludingDelegates, true);
            if (isAttached()) {
                if ((kindSet$ui_release & NodeKind.m1562constructorimpl(2)) != 0) {
                    if ((NodeKind.m1562constructorimpl(2) & calculateNodeKindSetFromIncludingDelegates) != 0) {
                        return;
                    }
                    NodeChain nodes = DelegatableNodeKt.requireLayoutNode((DelegatableNode) this).getNodes();
                    getNode().updateCoordinator$ui_release((NodeCoordinator) null);
                    nodes.syncCoordinators();
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException(("Could not find delegate: " + instance).toString());
    }

    private final void validateDelegateKindSet(int delegateKindSet, Modifier.Node delegateNode) {
        int kindSet$ui_release = getKindSet$ui_release();
        if ((delegateKindSet & NodeKind.m1562constructorimpl(2)) != 0) {
            if (!((NodeKind.m1562constructorimpl(2) & kindSet$ui_release) != 0) || (this instanceof LayoutModifierNode)) {
                return;
            }
            InlineClassHelperKt.throwIllegalStateException("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + delegateNode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateNodeKindSet(int newKindSet, boolean recalculateOwner) {
        Modifier.Node child$ui_release;
        int kindSet$ui_release = getKindSet$ui_release();
        setKindSet$ui_release(newKindSet);
        if (kindSet$ui_release != newKindSet) {
            if (DelegatableNodeKt.isDelegationRoot((DelegatableNode) this)) {
                setAggregateChildKindSet$ui_release(newKindSet);
            }
            if (isAttached()) {
                Modifier.Node node = getNode();
                DelegatingNode delegatingNode = this;
                while (delegatingNode != null) {
                    newKindSet |= delegatingNode.getKindSet$ui_release();
                    delegatingNode.setKindSet$ui_release(newKindSet);
                    if (delegatingNode == node) {
                        break;
                    } else {
                        delegatingNode = delegatingNode.getParent$ui_release();
                    }
                }
                if (recalculateOwner && delegatingNode == node) {
                    newKindSet = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(node);
                    node.setKindSet$ui_release(newKindSet);
                }
                int aggregateChildKindSet$ui_release = newKindSet | ((delegatingNode == null || (child$ui_release = delegatingNode.getChild$ui_release()) == null) ? 0 : child$ui_release.getAggregateChildKindSet$ui_release());
                while (delegatingNode != null) {
                    aggregateChildKindSet$ui_release |= delegatingNode.getKindSet$ui_release();
                    delegatingNode.setAggregateChildKindSet$ui_release(aggregateChildKindSet$ui_release);
                    delegatingNode = delegatingNode.getParent$ui_release();
                }
            }
        }
    }

    public final void forEachImmediateDelegate$ui_release(Function1<? super Modifier.Node, Unit> block) {
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
            block.invoke(delegate);
        }
    }

    public void markAsAttached$ui_release() {
        super.markAsAttached$ui_release();
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
            delegate.updateCoordinator$ui_release(getCoordinator$ui_release());
            if (!delegate.isAttached()) {
                delegate.markAsAttached$ui_release();
            }
        }
    }

    public void runDetachLifecycle$ui_release() {
        super.runDetachLifecycle$ui_release();
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
            delegate.runDetachLifecycle$ui_release();
        }
    }

    public void reset$ui_release() {
        super.reset$ui_release();
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
            delegate.reset$ui_release();
        }
    }

    public void runAttachLifecycle$ui_release() {
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
            delegate.runAttachLifecycle$ui_release();
        }
        super.runAttachLifecycle$ui_release();
    }

    public void markAsDetached$ui_release() {
        for (Modifier.Node delegate = getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
            delegate.markAsDetached$ui_release();
        }
        super.markAsDetached$ui_release();
    }
}
