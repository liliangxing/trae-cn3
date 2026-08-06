package com.bytedance.trae.conversation.chat.block.renderer;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewVoiceHistoryRenderer.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ViewVoiceHistory;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ViewVoiceHistoryRenderer implements IBlockRenderer<AgentContentBlock.ViewVoiceHistory> {

    @Deprecated
    public static final String BLOCK_TAG = "AgentBlock";
    private static final Companion Companion = new Companion(null);

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.ViewVoiceHistory viewVoiceHistory) {
        IBlockRenderer.DefaultImpls.update(this, view, viewVoiceHistory);
    }

    /* compiled from: ViewVoiceHistoryRenderer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ViewVoiceHistoryRenderer$Companion;", "", "<init>", "()V", "BLOCK_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(final Context context, final AgentContentBlock.ViewVoiceHistory block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        FLogger.INSTANCE.i("AgentBlock", "[ViewVoiceHistoryRenderer] render: sessionId=" + block.getSessionId() + ", convId=" + block.getConversationId());
        float f = context.getResources().getDisplayMetrics().density;
        TextView textView = new TextView(context);
        textView.setText(C0637R.string.trae_brainstorm_view_voice_history);
        textView.setGravity(17);
        textView.setTextColor(Color.parseColor("#0A0A0A"));
        textView.setTextSize(2, 17.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setLetterSpacing(-0.025f);
        textView.setBackgroundResource(C0637R.drawable.trae_bg_view_voice_history_btn);
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
        textView.setForeground(context.getDrawable(typedValue.resourceId));
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (36 * f)));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ViewVoiceHistoryRenderer$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewVoiceHistoryRenderer.render$lambda$1$lambda$0(AgentContentBlock.ViewVoiceHistory.this, context, view);
            }
        });
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void render$lambda$1$lambda$0(AgentContentBlock.ViewVoiceHistory viewVoiceHistory, Context context, View view) {
        FLogger.INSTANCE.i("AgentBlock", "[ViewVoiceHistoryRenderer] click: sessionId=" + viewVoiceHistory.getSessionId());
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity == null) {
            return;
        }
        BrainstormVoiceHistorySheet.Companion companion = BrainstormVoiceHistorySheet.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        companion.show(supportFragmentManager, viewVoiceHistory.getSessionId(), viewVoiceHistory.getConversationId());
    }
}
