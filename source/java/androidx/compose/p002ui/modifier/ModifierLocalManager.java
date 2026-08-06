package androidx.compose.p002ui.modifier;

import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.internal.InlineClassHelperKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.node.BackwardsCompatNode;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ModifierLocalManager.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J*\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\u001aH\u0002J\u001a\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\n2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\fJ\u001a\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\n2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\fJ\u001a\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\n2\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/modifier/ModifierLocalManager;", "", "owner", "Landroidx/compose/ui/node/Owner;", "<init>", "(Landroidx/compose/ui/node/Owner;)V", "getOwner", "()Landroidx/compose/ui/node/Owner;", "inserted", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/BackwardsCompatNode;", "insertedLocal", "Landroidx/compose/ui/modifier/ModifierLocal;", "removed", "Landroidx/compose/ui/node/LayoutNode;", "removedLocal", "invalidated", "", "invalidate", "", "triggerUpdates", "invalidateConsumersOfNodeForKey", "node", "Landroidx/compose/ui/Modifier$Node;", "key", "set", "", "updatedProvider", "insertedProvider", "removedProvider", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class ModifierLocalManager {
    public static final int $stable = 8;
    private boolean invalidated;
    private final Owner owner;
    private final MutableVector<BackwardsCompatNode> inserted = new MutableVector<>(new BackwardsCompatNode[16], 0);
    private final MutableVector<ModifierLocal<?>> insertedLocal = new MutableVector<>(new ModifierLocal[16], 0);
    private final MutableVector<LayoutNode> removed = new MutableVector<>(new LayoutNode[16], 0);
    private final MutableVector<ModifierLocal<?>> removedLocal = new MutableVector<>(new ModifierLocal[16], 0);

    public ModifierLocalManager(Owner owner) {
        this.owner = owner;
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final void invalidate() {
        if (this.invalidated) {
            return;
        }
        this.invalidated = true;
        this.owner.registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.modifier.ModifierLocalManager$invalidate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m6494invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m6494invoke() {
                ModifierLocalManager.this.triggerUpdates();
            }
        });
    }

    public final void triggerUpdates() {
        this.invalidated = false;
        HashSet hashSet = new HashSet();
        MutableVector<LayoutNode> mutableVector = this.removed;
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode = layoutNodeArr[i];
            ModifierLocal<?> modifierLocal = this.removedLocal.content[i];
            if (layoutNode.getNodes$ui_release().getHead$ui_release().getIsAttached()) {
                invalidateConsumersOfNodeForKey(layoutNode.getNodes$ui_release().getHead$ui_release(), modifierLocal, hashSet);
            }
        }
        this.removed.clear();
        this.removedLocal.clear();
        MutableVector<BackwardsCompatNode> mutableVector2 = this.inserted;
        BackwardsCompatNode[] backwardsCompatNodeArr = mutableVector2.content;
        int size2 = mutableVector2.getSize();
        for (int i2 = 0; i2 < size2; i2++) {
            BackwardsCompatNode backwardsCompatNode = backwardsCompatNodeArr[i2];
            ModifierLocal<?> modifierLocal2 = this.insertedLocal.content[i2];
            if (backwardsCompatNode.isAttached()) {
                invalidateConsumersOfNodeForKey((Modifier.Node) backwardsCompatNode, modifierLocal2, hashSet);
            }
        }
        this.inserted.clear();
        this.insertedLocal.clear();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((BackwardsCompatNode) it.next()).updateModifierLocalConsumer();
        }
    }

    private final void invalidateConsumersOfNodeForKey(Modifier.Node node, ModifierLocal<?> key, Set<BackwardsCompatNode> set) {
        boolean z;
        Modifier.Node node2 = node;
        int i = NodeKind.constructor-impl(32);
        if (!node2.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = node2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, node2.getNode(), false);
        } else {
            mutableVector.add(child);
        }
        while (true) {
            if (!(mutableVector.getSize() != 0)) {
                return;
            }
            DelegatingNode delegatingNode = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((delegatingNode.getAggregateChildKindSet() & i) != 0) {
                for (DelegatingNode delegatingNode2 = delegatingNode; delegatingNode2 != null; delegatingNode2 = delegatingNode2.getChild()) {
                    if ((delegatingNode2.getKindSet() & i) != 0) {
                        DelegatingNode delegatingNode3 = delegatingNode2;
                        MutableVector mutableVector2 = null;
                        while (true) {
                            if (delegatingNode3 == null) {
                                z = true;
                                break;
                            }
                            if (delegatingNode3 instanceof ModifierLocalModifierNode) {
                                BackwardsCompatNode backwardsCompatNode = (ModifierLocalModifierNode) delegatingNode3;
                                if (backwardsCompatNode instanceof BackwardsCompatNode) {
                                    BackwardsCompatNode backwardsCompatNode2 = backwardsCompatNode;
                                    if ((backwardsCompatNode2.getElement() instanceof ModifierLocalConsumer) && backwardsCompatNode2.getReadValues().contains(key)) {
                                        set.add(backwardsCompatNode);
                                    }
                                }
                                if (!(!backwardsCompatNode.getProvidedValues().contains$ui_release(key))) {
                                    z = false;
                                    break;
                                }
                            } else if (((delegatingNode3.getKindSet() & i) != 0) && (delegatingNode3 instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (DelegatingNode delegate$ui_release = delegatingNode3.getDelegate$ui_release(); delegate$ui_release != null; delegate$ui_release = delegate$ui_release.getChild()) {
                                    if ((delegate$ui_release.getKindSet() & i) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            delegatingNode3 = delegate$ui_release;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNode3 != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(delegatingNode3);
                                                }
                                                delegatingNode3 = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate$ui_release);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            delegatingNode3 = DelegatableNodeKt.access$pop(mutableVector2);
                        }
                        if (z) {
                        }
                    }
                }
            }
            DelegatableNodeKt.access$addLayoutNodeChildren(mutableVector, delegatingNode, false);
        }
    }

    public final void updatedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        this.inserted.add(node);
        this.insertedLocal.add(key);
        invalidate();
    }

    public final void insertedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        this.inserted.add(node);
        this.insertedLocal.add(key);
        invalidate();
    }

    public final void removedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        this.removed.add(DelegatableNodeKt.requireLayoutNode((DelegatableNode) node));
        this.removedLocal.add(key);
        invalidate();
    }
}
