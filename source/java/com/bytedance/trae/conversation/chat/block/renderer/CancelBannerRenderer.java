package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer;
import com.bytedance.trae.conversation.chat.block.renderer.StreamBannerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CancelBannerRenderer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/CancelBannerRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$CancelBanner;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CancelBannerRenderer implements IBlockRenderer<AgentContentBlock.CancelBanner> {
    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.CancelBanner cancelBanner) {
        IBlockRenderer.DefaultImpls.update(this, view, cancelBanner);
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.CancelBanner block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        float f = context.getResources().getDisplayMetrics().density;
        StreamBannerView streamBannerView = new StreamBannerView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = (int) (8 * f);
        layoutParams.bottomMargin = (int) (4 * f);
        streamBannerView.setLayoutParams(layoutParams);
        String string = context.getString(C0637R.string.trae_chat_stream_canceled_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = context.getString(C0637R.string.trae_chat_stream_canceled);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        streamBannerView.configure(string, string2, StreamBannerView.Style.TIPS, C0637R.drawable.info_filled_blue);
        return streamBannerView;
    }
}
