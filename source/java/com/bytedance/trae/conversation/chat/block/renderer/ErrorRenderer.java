package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer;
import com.bytedance.trae.conversation.chat.block.renderer.StreamBannerView;
import com.bytedance.trae.conversation.chat.error.AgentErrorLevel;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorRenderer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ErrorRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Error;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ErrorRenderer implements IBlockRenderer<AgentContentBlock.Error> {

    @Deprecated
    public static final String BLOCK_TAG = "AgentBlock";
    private static final Companion Companion = new Companion(null);

    /* compiled from: ErrorRenderer.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentErrorLevel.values().length];
            try {
                iArr[AgentErrorLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentErrorLevel.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgentErrorLevel.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.Error error) {
        IBlockRenderer.DefaultImpls.update(this, view, error);
    }

    /* compiled from: ErrorRenderer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ErrorRenderer$Companion;", "", "<init>", "()V", "BLOCK_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.Error block) {
        Pair pair;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        FLogger.INSTANCE.i("AgentBlock", "[ErrorRenderer] render: error=" + block.getError().getMessage() + ", level=" + block.getLevel());
        float f = context.getResources().getDisplayMetrics().density;
        int i = WhenMappings.$EnumSwitchMapping$0[block.getLevel().ordinal()];
        if (i == 1) {
            pair = new Pair(StreamBannerView.Style.ERROR, Integer.valueOf(C0637R.string.trae_chat_stream_error_title));
        } else if (i == 2) {
            pair = new Pair(StreamBannerView.Style.WARNING, Integer.valueOf(C0637R.string.trae_chat_stream_warning_title));
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            pair = new Pair(StreamBannerView.Style.TIPS, Integer.valueOf(C0637R.string.trae_chat_stream_tips_title));
        }
        StreamBannerView.Style style = (StreamBannerView.Style) pair.component1();
        int intValue = ((Number) pair.component2()).intValue();
        StreamBannerView streamBannerView = new StreamBannerView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int i2 = (int) (8 * f);
        layoutParams.topMargin = i2;
        layoutParams.bottomMargin = i2;
        streamBannerView.setLayoutParams(layoutParams);
        String displayTitle = block.getDisplayTitle();
        if (displayTitle == null) {
            displayTitle = context.getString(intValue);
            Intrinsics.checkNotNullExpressionValue(displayTitle, "getString(...)");
        }
        streamBannerView.configureInlineAlert(displayTitle, block.getDisplayMessage(), style, block.getShowInfoIcon() ? Integer.valueOf(C0637R.drawable.info_filled) : null);
        return streamBannerView;
    }
}
