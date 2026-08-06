package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.ThinkingRenderer;
import com.bytedance.trae.conversation.widget.ShimmerTextView;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThinkingRenderer.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;", "<init>", "()V", "managers", "", "", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "update", "", "view", "Companion", "ThinkingViewManager", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ThinkingRenderer implements IBlockRenderer<AgentContentBlock.Thinking> {

    @Deprecated
    public static final String BLOCK_TAG = "AgentBlock";
    private static final Companion Companion = new Companion(null);
    private final Map<String, WeakReference<ThinkingViewManager>> managers = new LinkedHashMap();

    /* compiled from: ThinkingRenderer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$Companion;", "", "<init>", "()V", "BLOCK_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.Thinking block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        ThinkingViewManager thinkingViewManager = new ThinkingViewManager();
        View render = thinkingViewManager.render(context, block);
        this.managers.put(block.getPlanItemId(), new WeakReference<>(thinkingViewManager));
        return render;
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.Thinking block) {
        ThinkingViewManager thinkingViewManager;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        WeakReference<ThinkingViewManager> weakReference = this.managers.get(block.getPlanItemId());
        if (weakReference == null || (thinkingViewManager = weakReference.get()) == null) {
            return;
        }
        thinkingViewManager.update(block);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ThinkingRenderer.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ThinkingRenderer$ThinkingViewManager;", "", "<init>", "()V", "titleView", "Lcom/bytedance/trae/conversation/widget/ShimmerTextView;", "getTitleView", "()Lcom/bytedance/trae/conversation/widget/ShimmerTextView;", "setTitleView", "(Lcom/bytedance/trae/conversation/widget/ShimmerTextView;)V", "contentView", "Landroid/widget/TextView;", "getContentView", "()Landroid/widget/TextView;", "setContentView", "(Landroid/widget/TextView;)V", "expanded", "", "getExpanded", "()Z", "setExpanded", "(Z)V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;", "update", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ThinkingViewManager {
        private TextView contentView;
        private boolean expanded;
        private ShimmerTextView titleView;

        public final ShimmerTextView getTitleView() {
            return this.titleView;
        }

        public final void setTitleView(ShimmerTextView shimmerTextView) {
            this.titleView = shimmerTextView;
        }

        public final TextView getContentView() {
            return this.contentView;
        }

        public final void setContentView(TextView textView) {
            this.contentView = textView;
        }

        public final boolean getExpanded() {
            return this.expanded;
        }

        public final void setExpanded(boolean z) {
            this.expanded = z;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final View render(Context context, AgentContentBlock.Thinking block) {
            String string;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(block, "block");
            float f = context.getResources().getDisplayMetrics().density;
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int i = (int) (4 * f);
            layoutParams.topMargin = i;
            layoutParams.bottomMargin = i;
            linearLayout.setLayoutParams(layoutParams);
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
            ShimmerTextView shimmerTextView = new ShimmerTextView(context, null, 0, 6, null);
            if (block.isThinking()) {
                string = context.getString(C0637R.string.trae_chat_thinking_collapsed);
            } else {
                string = context.getString(C0637R.string.trae_thinking_title_complete);
            }
            shimmerTextView.setText(string);
            shimmerTextView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
            shimmerTextView.setTextSize(2, 16.0f);
            TextViewCompat.setLineHeight((TextView) shimmerTextView, (int) (22 * f));
            shimmerTextView.setLetterSpacing(-0.019f);
            shimmerTextView.setMaxLines(1);
            shimmerTextView.setEllipsize(TextUtils.TruncateAt.END);
            shimmerTextView.setCompoundDrawablePadding(i);
            shimmerTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, C0637R.drawable.chevron_right, 0);
            this.titleView = shimmerTextView;
            linearLayout2.addView((View) shimmerTextView, new LinearLayout.LayoutParams(0, -2, 1.0f));
            TextView textView = new TextView(context);
            textView.setText(block.getReasoningContent());
            textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
            textView.setTextSize(2, 13.0f);
            textView.setVisibility(8);
            textView.setPadding(0, i, 0, 0);
            textView.setMaxLines(20);
            this.contentView = textView;
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ThinkingRenderer$ThinkingViewManager$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ThinkingRenderer.ThinkingViewManager.render$lambda$5(ThinkingRenderer.ThinkingViewManager.this, view);
                }
            });
            ShimmerTextView shimmerTextView2 = this.titleView;
            if (shimmerTextView2 != null) {
                shimmerTextView2.setShimmerEnabled(block.isThinking());
            }
            return linearLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void render$lambda$5(ThinkingViewManager thinkingViewManager, View view) {
            boolean z = !thinkingViewManager.expanded;
            thinkingViewManager.expanded = z;
            TextView textView = thinkingViewManager.contentView;
            if (textView != null) {
                textView.setVisibility(z ? 0 : 8);
            }
            ShimmerTextView shimmerTextView = thinkingViewManager.titleView;
            if (shimmerTextView != null) {
                shimmerTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, thinkingViewManager.expanded ? C0637R.drawable.chevron_fold : C0637R.drawable.chevron_right, 0);
            }
        }

        public final void update(AgentContentBlock.Thinking block) {
            Context context;
            Context context2;
            Intrinsics.checkNotNullParameter(block, "block");
            TextView textView = this.contentView;
            if (textView != null) {
                textView.setText(block.getReasoningContent());
            }
            String str = null;
            if (block.isThinking()) {
                ShimmerTextView shimmerTextView = this.titleView;
                if (shimmerTextView != null) {
                    if (shimmerTextView != null && (context2 = shimmerTextView.getContext()) != null) {
                        str = context2.getString(C0637R.string.trae_chat_thinking_collapsed);
                    }
                    shimmerTextView.setText(str);
                }
                ShimmerTextView shimmerTextView2 = this.titleView;
                if (shimmerTextView2 != null) {
                    shimmerTextView2.setShimmerEnabled(true);
                    return;
                }
                return;
            }
            ShimmerTextView shimmerTextView3 = this.titleView;
            if (shimmerTextView3 != null) {
                if (shimmerTextView3 != null && (context = shimmerTextView3.getContext()) != null) {
                    str = context.getString(C0637R.string.trae_thinking_title_complete);
                }
                shimmerTextView3.setText(str);
            }
            ShimmerTextView shimmerTextView4 = this.titleView;
            if (shimmerTextView4 != null) {
                shimmerTextView4.setShimmerEnabled(false);
            }
        }
    }
}
