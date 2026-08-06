package androidx.compose.p001ui.viewinterop;

import android.graphics.Rect;
import android.view.FocusFinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.compose.p001ui.node.DelegatableNode;
import androidx.compose.p001ui.node.DelegatableNodeKt;
import androidx.compose.p001ui.node.DelegatableNode_androidKt;
import androidx.compose.p001ui.node.DelegatingNode;
import androidx.compose.p001ui.node.NodeKind;
import androidx.compose.p001ui.node.Owner;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusEnterExitScope;
import androidx.compose.ui.focus.FocusInteropUtils_androidKt;
import androidx.compose.ui.focus.FocusOwner;
import androidx.compose.ui.focus.FocusProperties;
import androidx.compose.ui.focus.FocusPropertiesModifierNode;
import androidx.compose.ui.focus.FocusTargetNode;
import androidx.compose.ui.focus.FocusTransactionsKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FocusGroupNode.android.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u001c\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\b\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006%"}, d2 = {"Landroidx/compose/ui/viewinterop/FocusGroupPropertiesNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "<init>", "()V", "focusedChild", "Landroid/view/View;", "getFocusedChild", "()Landroid/view/View;", "setFocusedChild", "(Landroid/view/View;)V", "attachedViewTreeObserver", "Landroid/view/ViewTreeObserver;", "getAttachedViewTreeObserver", "()Landroid/view/ViewTreeObserver;", "setAttachedViewTreeObserver", "(Landroid/view/ViewTreeObserver;)V", "onEnter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEnterExitScope;", "", "Lkotlin/ExtensionFunctionType;", "getOnEnter", "()Lkotlin/jvm/functions/Function1;", "onExit", "getOnExit", "applyFocusProperties", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "getFocusTargetOfEmbeddedViewWrapper", "Landroidx/compose/ui/focus/FocusTargetNode;", "onGlobalFocusChanged", "oldFocus", "newFocus", "onAttach", "onDetach", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class FocusGroupPropertiesNode extends Modifier.Node implements FocusPropertiesModifierNode, ViewTreeObserver.OnGlobalFocusChangeListener {
    private ViewTreeObserver attachedViewTreeObserver;
    private View focusedChild;
    private final Function1<FocusEnterExitScope, Unit> onEnter = new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$onEnter$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FocusEnterExitScope) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(FocusEnterExitScope focusEnterExitScope) {
            View embeddedView;
            Rect currentlyFocusedRect;
            embeddedView = FocusGroupNode_androidKt.getEmbeddedView(FocusGroupPropertiesNode.this);
            if (embeddedView.isFocused() || embeddedView.hasFocus()) {
                return;
            }
            FocusOwner focusOwner = DelegatableNodeKt.requireOwner((DelegatableNode) FocusGroupPropertiesNode.this).getFocusOwner();
            View requireView = DelegatableNode_androidKt.requireView((DelegatableNode) FocusGroupPropertiesNode.this);
            Integer num = FocusInteropUtils_androidKt.toAndroidFocusDirection-3ESFkO8(focusEnterExitScope.getRequestedFocusDirection-dhqQ-8s());
            currentlyFocusedRect = FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, requireView, embeddedView);
            if (FocusInteropUtils_androidKt.requestInteropFocus(embeddedView, num, currentlyFocusedRect)) {
                return;
            }
            focusEnterExitScope.cancelFocusChange();
        }
    };
    private final Function1<FocusEnterExitScope, Unit> onExit = new Function1<FocusEnterExitScope, Unit>() { // from class: androidx.compose.ui.viewinterop.FocusGroupPropertiesNode$onExit$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((FocusEnterExitScope) obj);
            return Unit.INSTANCE;
        }

        public final void invoke(FocusEnterExitScope focusEnterExitScope) {
            View embeddedView;
            Rect currentlyFocusedRect;
            View findNextFocusFromRect;
            boolean containsDescendant;
            embeddedView = FocusGroupNode_androidKt.getEmbeddedView(FocusGroupPropertiesNode.this);
            if (ComposeUiFlags.isViewFocusFixEnabled) {
                if (embeddedView.hasFocus() || embeddedView.isFocused()) {
                    embeddedView.clearFocus();
                    return;
                }
                return;
            }
            if (embeddedView.hasFocus()) {
                FocusOwner focusOwner = DelegatableNodeKt.requireOwner((DelegatableNode) FocusGroupPropertiesNode.this).getFocusOwner();
                View requireView = DelegatableNode_androidKt.requireView((DelegatableNode) FocusGroupPropertiesNode.this);
                if (embeddedView instanceof ViewGroup) {
                    currentlyFocusedRect = FocusGroupNode_androidKt.getCurrentlyFocusedRect(focusOwner, requireView, embeddedView);
                    Integer num = FocusInteropUtils_androidKt.toAndroidFocusDirection-3ESFkO8(focusEnterExitScope.getRequestedFocusDirection-dhqQ-8s());
                    int intValue = num != null ? num.intValue() : 130;
                    FocusFinder focusFinder = FocusFinder.getInstance();
                    FocusGroupPropertiesNode focusGroupPropertiesNode = FocusGroupPropertiesNode.this;
                    if (focusGroupPropertiesNode.getFocusedChild() != null) {
                        Intrinsics.checkNotNull(requireView, "null cannot be cast to non-null type android.view.ViewGroup");
                        findNextFocusFromRect = focusFinder.findNextFocus((ViewGroup) requireView, focusGroupPropertiesNode.getFocusedChild(), intValue);
                    } else {
                        Intrinsics.checkNotNull(requireView, "null cannot be cast to non-null type android.view.ViewGroup");
                        findNextFocusFromRect = focusFinder.findNextFocusFromRect((ViewGroup) requireView, currentlyFocusedRect, intValue);
                    }
                    if (findNextFocusFromRect != null) {
                        containsDescendant = FocusGroupNode_androidKt.containsDescendant(embeddedView, findNextFocusFromRect);
                        if (containsDescendant) {
                            findNextFocusFromRect.requestFocus(intValue, currentlyFocusedRect);
                            focusEnterExitScope.cancelFocusChange();
                            return;
                        }
                    }
                    if (!requireView.requestFocus()) {
                        throw new IllegalStateException("host view did not take focus".toString());
                    }
                    return;
                }
                if (!requireView.requestFocus()) {
                    throw new IllegalStateException("host view did not take focus".toString());
                }
            }
        }
    };

    public final View getFocusedChild() {
        return this.focusedChild;
    }

    public final void setFocusedChild(View view) {
        this.focusedChild = view;
    }

    public final ViewTreeObserver getAttachedViewTreeObserver() {
        return this.attachedViewTreeObserver;
    }

    public final void setAttachedViewTreeObserver(ViewTreeObserver viewTreeObserver) {
        this.attachedViewTreeObserver = viewTreeObserver;
    }

    public final Function1<FocusEnterExitScope, Unit> getOnEnter() {
        return this.onEnter;
    }

    public final Function1<FocusEnterExitScope, Unit> getOnExit() {
        return this.onExit;
    }

    public void applyFocusProperties(FocusProperties focusProperties) {
        focusProperties.setCanFocus(false);
        focusProperties.setOnEnter(this.onEnter);
        focusProperties.setOnExit(this.onExit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final FocusTargetNode getFocusTargetOfEmbeddedViewWrapper() {
        DelegatableNode delegatableNode = (DelegatableNode) this;
        int m1562constructorimpl = NodeKind.m1562constructorimpl(1024);
        if (!delegatableNode.getNode().isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet$ui_release() & m1562constructorimpl) != 0) {
            boolean z = false;
            for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                if ((child$ui_release.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                    Modifier.Node node2 = child$ui_release;
                    MutableVector mutableVector = null;
                    while (node2 != null) {
                        if (node2 instanceof FocusTargetNode) {
                            FocusTargetNode focusTargetNode = (FocusTargetNode) node2;
                            if (z) {
                                return focusTargetNode;
                            }
                            z = true;
                        } else if (((node2.getKindSet$ui_release() & m1562constructorimpl) != 0) && (node2 instanceof DelegatingNode)) {
                            int i = 0;
                            for (Modifier.Node delegate = ((DelegatingNode) node2).getDelegate(); delegate != null; delegate = delegate.getChild$ui_release()) {
                                if ((delegate.getKindSet$ui_release() & m1562constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        node2 = delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (node2 != null) {
                                            if (mutableVector != null) {
                                                mutableVector.add(node2);
                                            }
                                            node2 = null;
                                        }
                                        if (mutableVector != null) {
                                            mutableVector.add(delegate);
                                        }
                                    }
                                }
                            }
                            if (i == 1) {
                            }
                        }
                        node2 = DelegatableNodeKt.pop(mutableVector);
                    }
                }
            }
        }
        throw new IllegalStateException("Could not find focus target of embedded view wrapper".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0047 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        View embeddedView;
        boolean z;
        boolean z2;
        boolean containsDescendant;
        boolean containsDescendant2;
        DelegatableNode delegatableNode = (DelegatableNode) this;
        if (DelegatableNodeKt.requireLayoutNode(delegatableNode).getOwner() == null) {
            return;
        }
        embeddedView = FocusGroupNode_androidKt.getEmbeddedView(this);
        FocusOwner focusOwner = DelegatableNodeKt.requireOwner(delegatableNode).getFocusOwner();
        Owner requireOwner = DelegatableNodeKt.requireOwner(delegatableNode);
        if (oldFocus != null && !Intrinsics.areEqual(oldFocus, requireOwner)) {
            containsDescendant2 = FocusGroupNode_androidKt.containsDescendant(embeddedView, oldFocus);
            if (containsDescendant2) {
                z = true;
                if (newFocus != null && !Intrinsics.areEqual(newFocus, requireOwner)) {
                    containsDescendant = FocusGroupNode_androidKt.containsDescendant(embeddedView, newFocus);
                    if (containsDescendant) {
                        z2 = true;
                        if (!z && z2) {
                            this.focusedChild = newFocus;
                            return;
                        }
                        if (z2) {
                            this.focusedChild = newFocus;
                            FocusTargetNode focusTargetOfEmbeddedViewWrapper = getFocusTargetOfEmbeddedViewWrapper();
                            if (focusTargetOfEmbeddedViewWrapper.getFocusState().getHasFocus()) {
                                return;
                            }
                            FocusTransactionsKt.performRequestFocus(focusTargetOfEmbeddedViewWrapper);
                            return;
                        }
                        if (z) {
                            this.focusedChild = null;
                            if (getFocusTargetOfEmbeddedViewWrapper().getFocusState().isFocused()) {
                                focusOwner.clearFocus-I7lrPNg(false, true, false, FocusDirection.Companion.getExit-dhqQ-8s());
                                return;
                            }
                            return;
                        }
                        this.focusedChild = null;
                        return;
                    }
                }
                z2 = false;
                if (!z) {
                }
                if (z2) {
                }
            }
        }
        z = false;
        if (newFocus != null) {
            containsDescendant = FocusGroupNode_androidKt.containsDescendant(embeddedView, newFocus);
            if (containsDescendant) {
            }
        }
        z2 = false;
        if (!z) {
        }
        if (z2) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttach() {
        super.onAttach();
        ViewTreeObserver viewTreeObserver = DelegatableNode_androidKt.requireView((DelegatableNode) this).getViewTreeObserver();
        this.attachedViewTreeObserver = viewTreeObserver;
        viewTreeObserver.addOnGlobalFocusChangeListener(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDetach() {
        ViewTreeObserver viewTreeObserver = this.attachedViewTreeObserver;
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalFocusChangeListener(this);
        }
        this.attachedViewTreeObserver = null;
        DelegatableNode_androidKt.requireView((DelegatableNode) this).getViewTreeObserver().removeOnGlobalFocusChangeListener(this);
        this.focusedChild = null;
        super.onDetach();
    }
}
