package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.SubAgentGroupRenderer;
import com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet;
import com.bytedance.trae.conversation.widget.ShimmerTextView;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubAgentGroupRenderer.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\r\u000eB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "update", "", "view", "Companion", "SubAgentGroupViewManager", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SubAgentGroupRenderer implements IBlockRenderer<AgentContentBlock.SubAgentGroup> {

    @Deprecated
    public static final String BLOCK_TAG = "AgentBlock";
    private static final Companion Companion = new Companion(null);

    /* compiled from: SubAgentGroupRenderer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$Companion;", "", "<init>", "()V", "BLOCK_TAG", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.SubAgentGroup block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        FLogger.INSTANCE.i("AgentBlock", "[SubAgentGroupRenderer] render: children=" + block.getChildren().size());
        SubAgentGroupViewManager subAgentGroupViewManager = new SubAgentGroupViewManager();
        View render = subAgentGroupViewManager.render(context, block);
        render.setTag(C0637R.id.tag_sub_agent_group_manager, subAgentGroupViewManager);
        return render;
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.SubAgentGroup block) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        FLogger.INSTANCE.i("AgentBlock", "[SubAgentGroupRenderer] update: children=" + block.getChildren().size());
        Object tag = view.getTag(C0637R.id.tag_sub_agent_group_manager);
        SubAgentGroupViewManager subAgentGroupViewManager = tag instanceof SubAgentGroupViewManager ? (SubAgentGroupViewManager) tag : null;
        if (subAgentGroupViewManager == null) {
            return;
        }
        subAgentGroupViewManager.update(block);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubAgentGroupRenderer.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020 J\u000e\u0010.\u001a\u00020/2\u0006\u0010-\u001a\u00020 J\u0016\u00100\u001a\u00020/2\f\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0002J\u0010\u00104\u001a\u00020/2\u0006\u00105\u001a\u00020\u001aH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u00066"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer$SubAgentGroupViewManager;", "", "<init>", "()V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "setIconView", "(Landroid/widget/ImageView;)V", "titleView", "Lcom/bytedance/trae/conversation/widget/ShimmerTextView;", "getTitleView", "()Lcom/bytedance/trae/conversation/widget/ShimmerTextView;", "setTitleView", "(Lcom/bytedance/trae/conversation/widget/ShimmerTextView;)V", "headerRow", "Landroid/widget/LinearLayout;", "getHeaderRow", "()Landroid/widget/LinearLayout;", "setHeaderRow", "(Landroid/widget/LinearLayout;)V", "widgetContainer", "getWidgetContainer", "setWidgetContainer", "currentStatus", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;", "getCurrentStatus", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;", "setCurrentStatus", "(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;)V", "latestBlock", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;", "getLatestBlock", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;", "setLatestBlock", "(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;)V", "pureShowWidgetRenderer", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;", "getPureShowWidgetRenderer", "()Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "update", "", "bindWidgets", "children", "", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "applyStatus", PageDataManager.EXTRA_STATUS, "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class SubAgentGroupViewManager {
        private LinearLayout headerRow;
        private ImageView iconView;
        private AgentContentBlock.SubAgentGroup latestBlock;
        private ShimmerTextView titleView;
        private LinearLayout widgetContainer;
        private AgentContentBlock.GroupStatus currentStatus = AgentContentBlock.GroupStatus.RUNNING;
        private final PureShowWidgetToolcallGroupRenderer pureShowWidgetRenderer = new PureShowWidgetToolcallGroupRenderer();

        public final ImageView getIconView() {
            return this.iconView;
        }

        public final void setIconView(ImageView imageView) {
            this.iconView = imageView;
        }

        public final ShimmerTextView getTitleView() {
            return this.titleView;
        }

        public final void setTitleView(ShimmerTextView shimmerTextView) {
            this.titleView = shimmerTextView;
        }

        public final LinearLayout getHeaderRow() {
            return this.headerRow;
        }

        public final void setHeaderRow(LinearLayout linearLayout) {
            this.headerRow = linearLayout;
        }

        public final LinearLayout getWidgetContainer() {
            return this.widgetContainer;
        }

        public final void setWidgetContainer(LinearLayout linearLayout) {
            this.widgetContainer = linearLayout;
        }

        public final AgentContentBlock.GroupStatus getCurrentStatus() {
            return this.currentStatus;
        }

        public final void setCurrentStatus(AgentContentBlock.GroupStatus groupStatus) {
            Intrinsics.checkNotNullParameter(groupStatus, "<set-?>");
            this.currentStatus = groupStatus;
        }

        public final AgentContentBlock.SubAgentGroup getLatestBlock() {
            return this.latestBlock;
        }

        public final void setLatestBlock(AgentContentBlock.SubAgentGroup subAgentGroup) {
            this.latestBlock = subAgentGroup;
        }

        public final PureShowWidgetToolcallGroupRenderer getPureShowWidgetRenderer() {
            return this.pureShowWidgetRenderer;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final View render(Context context, AgentContentBlock.SubAgentGroup block) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(block, "block");
            this.latestBlock = block;
            float f = context.getResources().getDisplayMetrics().density;
            this.currentStatus = block.getStatus();
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
            this.headerRow = linearLayout2;
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
            int i2 = (int) (16 * f);
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(C0637R.drawable.agent);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.iconView = imageView;
            LinearLayout linearLayout3 = this.headerRow;
            if (linearLayout3 != null) {
                linearLayout3.addView(imageView, new LinearLayout.LayoutParams(i2, i2));
            }
            String description = block.getDescription();
            if (description == null && (description = block.getAgentDisplayName()) == null) {
                description = context.getString(C0637R.string.trae_chat_sub_agent_default);
                Intrinsics.checkNotNullExpressionValue(description, "getString(...)");
            }
            ShimmerTextView shimmerTextView = new ShimmerTextView(context, null, 0, 6, null);
            shimmerTextView.setText(description);
            shimmerTextView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
            shimmerTextView.setTextSize(2, 16.0f);
            TextViewCompat.setLineHeight((TextView) shimmerTextView, (int) (22 * f));
            shimmerTextView.setLetterSpacing(-0.019f);
            shimmerTextView.setMaxLines(1);
            shimmerTextView.setEllipsize(TextUtils.TruncateAt.END);
            shimmerTextView.setCompoundDrawablePadding(i);
            shimmerTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, C0637R.drawable.chevron_right, 0);
            this.titleView = shimmerTextView;
            LinearLayout linearLayout4 = this.headerRow;
            if (linearLayout4 != null) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMarginStart(i);
                Unit unit = Unit.INSTANCE;
                linearLayout4.addView((View) shimmerTextView, layoutParams2);
            }
            LinearLayout linearLayout5 = new LinearLayout(context);
            linearLayout5.setOrientation(1);
            this.widgetContainer = linearLayout5;
            linearLayout.addView(linearLayout5, new LinearLayout.LayoutParams(-1, -2));
            applyStatus(block.getStatus());
            bindWidgets(block.getChildren());
            LinearLayout linearLayout6 = this.headerRow;
            if (linearLayout6 != null) {
                linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.SubAgentGroupRenderer$SubAgentGroupViewManager$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SubAgentGroupRenderer.SubAgentGroupViewManager.render$lambda$7(SubAgentGroupRenderer.SubAgentGroupViewManager.this, view);
                    }
                });
            }
            return linearLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void render$lambda$7(SubAgentGroupViewManager subAgentGroupViewManager, View view) {
            FragmentManager supportFragmentManager;
            AgentContentBlock.SubAgentGroup subAgentGroup;
            FragmentActivity context = view.getContext();
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? context : null;
            if (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null || (subAgentGroup = subAgentGroupViewManager.latestBlock) == null) {
                return;
            }
            ProcessDetailBottomSheet.INSTANCE.showAgentDetail(supportFragmentManager, subAgentGroup);
        }

        public final void update(AgentContentBlock.SubAgentGroup block) {
            ShimmerTextView shimmerTextView;
            Intrinsics.checkNotNullParameter(block, "block");
            this.latestBlock = block;
            this.currentStatus = block.getStatus();
            String description = block.getDescription();
            if (description == null) {
                description = block.getAgentDisplayName();
            }
            if (description != null && (shimmerTextView = this.titleView) != null) {
                shimmerTextView.setText(description);
            }
            applyStatus(block.getStatus());
            bindWidgets(block.getChildren());
        }

        private final void bindWidgets(List<? extends AgentContentBlock> children) {
            LinearLayout linearLayout = this.widgetContainer;
            if (linearLayout == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : children) {
                if (obj instanceof AgentContentBlock.PureShowWidgetToolcallGroup) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            while (linearLayout.getChildCount() > arrayList2.size()) {
                int childCount = linearLayout.getChildCount() - 1;
                PureShowWidgetToolcallGroupRenderer pureShowWidgetToolcallGroupRenderer = this.pureShowWidgetRenderer;
                View childAt = linearLayout.getChildAt(childCount);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                pureShowWidgetToolcallGroupRenderer.release$conversation_mainlandRelease(childAt);
                linearLayout.removeViewAt(childCount);
            }
            int i = 0;
            for (Object obj2 : arrayList2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                AgentContentBlock.PureShowWidgetToolcallGroup pureShowWidgetToolcallGroup = (AgentContentBlock.PureShowWidgetToolcallGroup) obj2;
                View childAt2 = linearLayout.getChildAt(i);
                if (childAt2 != null) {
                    this.pureShowWidgetRenderer.update(childAt2, pureShowWidgetToolcallGroup);
                } else {
                    PureShowWidgetToolcallGroupRenderer pureShowWidgetToolcallGroupRenderer2 = this.pureShowWidgetRenderer;
                    Context context = linearLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    linearLayout.addView(pureShowWidgetToolcallGroupRenderer2.render(context, pureShowWidgetToolcallGroup), new LinearLayout.LayoutParams(-1, -2));
                }
                i = i2;
            }
            linearLayout.setVisibility(arrayList2.isEmpty() ? 8 : 0);
        }

        private final void applyStatus(AgentContentBlock.GroupStatus status) {
            boolean z = status == AgentContentBlock.GroupStatus.RUNNING || status == AgentContentBlock.GroupStatus.WAITING_CONFIRM;
            ShimmerTextView shimmerTextView = this.titleView;
            if (shimmerTextView != null) {
                shimmerTextView.setShimmerEnabled(z);
            }
        }
    }
}
