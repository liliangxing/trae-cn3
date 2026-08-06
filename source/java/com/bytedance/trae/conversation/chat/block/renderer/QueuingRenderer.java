package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.StreamBannerView;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: QueuingRenderer.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/QueuingRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Queuing;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "update", "", "view", "buildDisplayText", "", "buildTitleText", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class QueuingRenderer implements IBlockRenderer<AgentContentBlock.Queuing> {
    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.Queuing block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        FLogger.INSTANCE.i("AgentBlock", "[QueuingRenderer] render: position=" + block.getPosition());
        if (!AppHost.INSTANCE.isOversea()) {
            float f = context.getResources().getDisplayMetrics().density;
            QueuingBannerView queuingBannerView = new QueuingBannerView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = (int) (8 * f);
            layoutParams.bottomMargin = (int) (4 * f);
            queuingBannerView.setLayoutParams(layoutParams);
            queuingBannerView.render(block);
            return queuingBannerView;
        }
        float f2 = context.getResources().getDisplayMetrics().density;
        StreamBannerView streamBannerView = new StreamBannerView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = (int) (8 * f2);
        layoutParams2.bottomMargin = (int) (4 * f2);
        streamBannerView.setLayoutParams(layoutParams2);
        streamBannerView.configure(buildTitleText(context, block), buildDisplayText(context, block), StreamBannerView.Style.TIPS, C0637R.drawable.info_filled_blue);
        return streamBannerView;
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.Queuing block) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        FLogger.INSTANCE.i("AgentBlock", "[QueuingRenderer] update: position=" + block.getPosition());
        if (AppHost.INSTANCE.isOversea()) {
            StreamBannerView streamBannerView = view instanceof StreamBannerView ? (StreamBannerView) view : null;
            if (streamBannerView == null) {
                return;
            }
            StreamBannerView streamBannerView2 = (StreamBannerView) view;
            Context context = streamBannerView2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            streamBannerView.updateTitle(buildTitleText(context, block));
            Context context2 = streamBannerView2.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            streamBannerView.updateMessage(buildDisplayText(context2, block));
            return;
        }
        QueuingBannerView queuingBannerView = view instanceof QueuingBannerView ? (QueuingBannerView) view : null;
        if (queuingBannerView == null) {
            return;
        }
        queuingBannerView.updateQueue(block);
    }

    private final String buildDisplayText(Context context, AgentContentBlock.Queuing block) {
        String message = block.getMessage();
        if (message != null) {
            if (!(!StringsKt.isBlank(message))) {
                message = null;
            }
            if (message != null) {
                return message;
            }
        }
        String string = context.getString(C0637R.string.trae_chat_queue_alert_body, Integer.valueOf(block.getPosition()));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final String buildTitleText(Context context, AgentContentBlock.Queuing block) {
        String noticeTitle = block.getNoticeTitle();
        if (noticeTitle != null) {
            if (!(!StringsKt.isBlank(noticeTitle))) {
                noticeTitle = null;
            }
            if (noticeTitle != null) {
                return noticeTitle;
            }
        }
        String string = context.getString(C0637R.string.trae_chat_queue_alert_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
