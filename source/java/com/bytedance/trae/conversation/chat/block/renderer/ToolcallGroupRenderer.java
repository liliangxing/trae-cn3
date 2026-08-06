package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.ToolcallGroupRenderer;
import com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet;
import com.bytedance.trae.conversation.widget.ShimmerTextView;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToolcallGroupRenderer.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;", "<init>", "()V", "managers", "", "", "Ljava/lang/ref/WeakReference;", "Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;", "keyCounter", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "update", "", "view", "Companion", "ToolcallGroupViewManager", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ToolcallGroupRenderer implements IBlockRenderer<AgentContentBlock.ToolcallGroup> {

    @Deprecated
    public static final String BLOCK_TAG = "AgentBlock";
    private static final Companion Companion = new Companion(null);
    private int keyCounter;
    private final Map<Integer, WeakReference<ToolcallGroupViewManager>> managers = new LinkedHashMap();

    /* compiled from: ToolcallGroupRenderer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$Companion;", "", "<init>", "()V", "BLOCK_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.ToolcallGroup block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        ToolcallGroupViewManager toolcallGroupViewManager = new ToolcallGroupViewManager();
        int i = this.keyCounter;
        this.keyCounter = i + 1;
        View render = toolcallGroupViewManager.render(context, block);
        render.setTag(C0637R.id.tag_toolcall_group_key, Integer.valueOf(i));
        this.managers.put(Integer.valueOf(i), new WeakReference<>(toolcallGroupViewManager));
        return render;
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.ToolcallGroup block) {
        ToolcallGroupViewManager toolcallGroupViewManager;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        Object tag = view.getTag(C0637R.id.tag_toolcall_group_key);
        Integer num = tag instanceof Integer ? (Integer) tag : null;
        if (num != null) {
            WeakReference<ToolcallGroupViewManager> weakReference = this.managers.get(Integer.valueOf(num.intValue()));
            if (weakReference == null || (toolcallGroupViewManager = weakReference.get()) == null) {
                return;
            }
            toolcallGroupViewManager.update(block);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToolcallGroupRenderer.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ToolcallGroupRenderer$ToolcallGroupViewManager;", "", "<init>", "()V", "titleView", "Lcom/bytedance/trae/conversation/widget/ShimmerTextView;", "getTitleView", "()Lcom/bytedance/trae/conversation/widget/ShimmerTextView;", "setTitleView", "(Lcom/bytedance/trae/conversation/widget/ShimmerTextView;)V", "latestBlock", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;", "getLatestBlock", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;", "setLatestBlock", "(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;)V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "update", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ToolcallGroupViewManager {
        private AgentContentBlock.ToolcallGroup latestBlock;
        private ShimmerTextView titleView;

        public final ShimmerTextView getTitleView() {
            return this.titleView;
        }

        public final void setTitleView(ShimmerTextView shimmerTextView) {
            this.titleView = shimmerTextView;
        }

        public final AgentContentBlock.ToolcallGroup getLatestBlock() {
            return this.latestBlock;
        }

        public final void setLatestBlock(AgentContentBlock.ToolcallGroup toolcallGroup) {
            this.latestBlock = toolcallGroup;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final View render(Context context, AgentContentBlock.ToolcallGroup block) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(block, "block");
            this.latestBlock = block;
            float f = context.getResources().getDisplayMetrics().density;
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(16);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int i = (int) (2 * f);
            layoutParams.topMargin = i;
            layoutParams.bottomMargin = i;
            linearLayout.setPadding(0, i, 0, i);
            linearLayout.setLayoutParams(layoutParams);
            ShimmerTextView shimmerTextView = new ShimmerTextView(context, null, 0, 6, null);
            shimmerTextView.setText(block.getTitle());
            shimmerTextView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
            shimmerTextView.setTextSize(2, 15.0f);
            shimmerTextView.setMaxLines(1);
            shimmerTextView.setEllipsize(TextUtils.TruncateAt.END);
            shimmerTextView.setCompoundDrawablePadding((int) (4 * f));
            shimmerTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, C0637R.drawable.chevron_right, 0);
            this.titleView = shimmerTextView;
            linearLayout.addView((View) shimmerTextView, new LinearLayout.LayoutParams(-2, -2));
            ShimmerTextView shimmerTextView2 = this.titleView;
            if (shimmerTextView2 != null) {
                shimmerTextView2.setShimmerEnabled(true ^ block.getGroupFinished());
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ToolcallGroupRenderer$ToolcallGroupViewManager$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ToolcallGroupRenderer.ToolcallGroupViewManager.render$lambda$3(ToolcallGroupRenderer.ToolcallGroupViewManager.this, view);
                }
            };
            linearLayout.setOnClickListener(onClickListener);
            ShimmerTextView shimmerTextView3 = this.titleView;
            if (shimmerTextView3 != null) {
                shimmerTextView3.setOnClickListener(onClickListener);
            }
            return linearLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void render$lambda$3(ToolcallGroupViewManager toolcallGroupViewManager, View view) {
            FragmentManager supportFragmentManager;
            AgentContentBlock.ToolcallGroup toolcallGroup;
            FragmentActivity context = view.getContext();
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? context : null;
            if (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null || (toolcallGroup = toolcallGroupViewManager.latestBlock) == null) {
                return;
            }
            ProcessDetailBottomSheet.INSTANCE.showToolList(supportFragmentManager, toolcallGroup);
        }

        public final void update(AgentContentBlock.ToolcallGroup block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.latestBlock = block;
            ShimmerTextView shimmerTextView = this.titleView;
            if (shimmerTextView != null) {
                shimmerTextView.setText(block.getTitle());
            }
            ShimmerTextView shimmerTextView2 = this.titleView;
            if (shimmerTextView2 != null) {
                shimmerTextView2.setShimmerEnabled(!block.getGroupFinished());
            }
        }
    }
}
