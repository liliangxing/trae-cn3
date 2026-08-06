package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer;
import com.bytedance.trae.conversation.widget.ShimmerTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceSummaryLoadingRenderer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryLoadingRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$VoiceSummaryLoading;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceSummaryLoadingRenderer implements IBlockRenderer<AgentContentBlock.VoiceSummaryLoading> {
    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.VoiceSummaryLoading voiceSummaryLoading) {
        IBlockRenderer.DefaultImpls.update(this, view, voiceSummaryLoading);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.VoiceSummaryLoading block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        float f = context.getResources().getDisplayMetrics().density;
        ShimmerTextView shimmerTextView = new ShimmerTextView(context, null, 0, 6, null);
        shimmerTextView.setText(context.getString(C0637R.string.trae_brainstorm_voice_summary_loading));
        shimmerTextView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
        shimmerTextView.setTextSize(2, 16.0f);
        shimmerTextView.setIncludeFontPadding(false);
        TextViewCompat.setLineHeight((TextView) shimmerTextView, (int) (22 * f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i = (int) (8 * f);
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i;
        shimmerTextView.setLayoutParams(layoutParams);
        shimmerTextView.setShimmerTimeoutMs(0L);
        shimmerTextView.setShimmerEnabled(true);
        return (View) shimmerTextView;
    }
}
