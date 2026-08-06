package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* compiled from: PureShowWidgetToolcallGroupRenderer.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\fJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0015\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0013J\u000e\u0010\u0014\u001a\u0004\u0018\u00010\u0015*\u00020\u000bH\u0002J\u0014\u0010\u0016\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0015H\u0002J\f\u0010\u0017\u001a\u00020\u000e*\u00020\u000bH\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "createContainer", "Landroid/widget/LinearLayout;", "createContainer$conversation_mainlandRelease", "update", "", "view", "bind", "root", "release", "release$conversation_mainlandRelease", "findPureShowWidgetInlineView", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;", "notifyPureShowWidgetInlineViewCreated", "notifyContentChanged", "pureShowWidgetLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PureShowWidgetToolcallGroupRenderer implements IBlockRenderer<AgentContentBlock.PureShowWidgetToolcallGroup> {
    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.PureShowWidgetToolcallGroup block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        LinearLayout createContainer$conversation_mainlandRelease = createContainer$conversation_mainlandRelease(context);
        bind(createContainer$conversation_mainlandRelease, block);
        return createContainer$conversation_mainlandRelease;
    }

    public final LinearLayout createContainer$conversation_mainlandRelease(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return linearLayout;
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.PureShowWidgetToolcallGroup block) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        LinearLayout linearLayout = view instanceof LinearLayout ? (LinearLayout) view : null;
        if (linearLayout == null) {
            return;
        }
        bind(linearLayout, block);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
    
        if (r1 == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void bind(LinearLayout root, AgentContentBlock.PureShowWidgetToolcallGroup block) {
        PureShowWidgetPayload pureShowWidgetPayload;
        boolean hasBalancedWidgetTags;
        pureShowWidgetPayload = PureShowWidgetToolcallGroupRendererKt.pureShowWidgetPayload(block);
        if (pureShowWidgetPayload == null) {
            release$conversation_mainlandRelease(root);
            notifyContentChanged(root);
            return;
        }
        String widgetCode = pureShowWidgetPayload.getWidgetCode();
        PureShowWidgetInlineView findPureShowWidgetInlineView = findPureShowWidgetInlineView(root);
        if (block.getGroupFinished()) {
            if (!StringsKt.isBlank(widgetCode)) {
                hasBalancedWidgetTags = PureShowWidgetToolcallGroupRendererKt.hasBalancedWidgetTags(widgetCode);
            }
            release$conversation_mainlandRelease(root);
            notifyContentChanged(root);
            return;
        }
        if (findPureShowWidgetInlineView == null) {
            Context context = root.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            findPureShowWidgetInlineView = new PureShowWidgetInlineView(context);
            notifyPureShowWidgetInlineViewCreated(root, findPureShowWidgetInlineView);
            root.removeAllViews();
            Context context2 = root.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            root.addView(findPureShowWidgetInlineView, pureShowWidgetLayoutParams(context2));
        }
        findPureShowWidgetInlineView.setTag(C0637R.id.tag_on_content_changed, root.getTag(C0637R.id.tag_on_content_changed));
        findPureShowWidgetInlineView.bind(pureShowWidgetPayload, block.getGroupFinished());
    }

    public final void release$conversation_mainlandRelease(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LinearLayout linearLayout = view instanceof LinearLayout ? (LinearLayout) view : null;
        if (linearLayout == null) {
            return;
        }
        PureShowWidgetInlineView findPureShowWidgetInlineView = findPureShowWidgetInlineView(linearLayout);
        if (findPureShowWidgetInlineView != null) {
            findPureShowWidgetInlineView.release();
        }
        linearLayout.removeAllViews();
        linearLayout.requestLayout();
    }

    private final PureShowWidgetInlineView findPureShowWidgetInlineView(LinearLayout linearLayout) {
        int childCount = linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = linearLayout.getChildAt(i);
            if (childAt instanceof PureShowWidgetInlineView) {
                return (PureShowWidgetInlineView) childAt;
            }
        }
        return null;
    }

    private final void notifyPureShowWidgetInlineViewCreated(LinearLayout linearLayout, PureShowWidgetInlineView pureShowWidgetInlineView) {
        LinearLayout linearLayout2 = linearLayout;
        while (linearLayout2 != null) {
            Object tag = linearLayout2.getTag(C0637R.id.tag_on_pure_show_widget_inline_view_created);
            if (TypeIntrinsics.isFunctionOfArity(tag, 1)) {
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Function1<com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView, kotlin.Unit>");
                ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(tag, 1)).invoke(pureShowWidgetInlineView);
                return;
            } else {
                Object parent = linearLayout2.getParent();
                linearLayout2 = parent instanceof View ? (View) parent : null;
            }
        }
    }

    private final void notifyContentChanged(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = linearLayout;
        while (linearLayout2 != null) {
            Object tag = linearLayout2.getTag(C0637R.id.tag_on_content_changed);
            if (TypeIntrinsics.isFunctionOfArity(tag, 0)) {
                ((Function0) tag).invoke();
                return;
            } else {
                Object parent = linearLayout2.getParent();
                linearLayout2 = parent instanceof View ? (View) parent : null;
            }
        }
    }

    private final LinearLayout.LayoutParams pureShowWidgetLayoutParams(Context context) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = context.getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_8);
        return layoutParams;
    }
}
