package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThoughtRenderer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ThoughtRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "update", "", "view", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ThoughtRenderer implements IBlockRenderer<AgentContentBlock.Thought> {

    @Deprecated
    public static final String BLOCK_TAG = "AgentBlock";
    private static final Companion Companion = new Companion(null);

    /* compiled from: ThoughtRenderer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ThoughtRenderer$Companion;", "", "<init>", "()V", "BLOCK_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.Thought block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        float f = context.getResources().getDisplayMetrics().density;
        SimpleMarkdownTextView simpleMarkdownTextView = new SimpleMarkdownTextView(context, null, 0, 6, null);
        simpleMarkdownTextView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        simpleMarkdownTextView.setTextSize(2, 15.0f);
        simpleMarkdownTextView.setLineSpacing(0.0f, 1.1f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i = (int) (4 * f);
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i;
        simpleMarkdownTextView.setLayoutParams(layoutParams);
        MarkdownHelper.setMarkdownContent$default(MarkdownHelper.INSTANCE, simpleMarkdownTextView, block.getThought(), false, null, 12, null);
        return (View) simpleMarkdownTextView;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.Thought block) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        SimpleMarkdownTextView simpleMarkdownTextView = view instanceof SimpleMarkdownTextView ? (SimpleMarkdownTextView) view : null;
        if (simpleMarkdownTextView == null) {
            return;
        }
        MarkdownHelper.setMarkdownContent$default(MarkdownHelper.INSTANCE, simpleMarkdownTextView, block.getThought(), false, null, 12, null);
    }
}
