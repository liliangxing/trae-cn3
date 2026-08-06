package com.bytedance.trae.conversation.chat.detail;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.detail.DetailSegment;
import com.bytedance.trae.conversation.chat.toolcall.PlanItemContext;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCardFactory;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CollapsibleToolSegmentView.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J<\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\r2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\"\u0010\u001c\u001a\u00020\u00102\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/CollapsibleToolSegmentView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "headerRow", "titleView", "Landroid/widget/TextView;", "unfoldIcon", "Landroid/widget/ImageView;", "contentContainer", "expanded", "", "onExpandedStateChanged", "Lkotlin/Function1;", "", "density", "", "bind", "segment", "Lcom/bytedance/trae/conversation/chat/detail/DetailSegment$ToolSegment;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "initialExpanded", "update", "toggle", "applyExpandedState", "renderChildren", "children", "", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CollapsibleToolSegmentView extends LinearLayout {
    private final LinearLayout contentContainer;
    private final float density;
    private boolean expanded;
    private final LinearLayout headerRow;
    private Function1<? super Boolean, Unit> onExpandedStateChanged;
    private final TextView titleView;
    private final ImageView unfoldIcon;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CollapsibleToolSegmentView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        float f = context.getResources().getDisplayMetrics().density;
        this.density = f;
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        float f2 = 8;
        layoutParams.bottomMargin = (int) (f2 * f);
        setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int i = (int) (f2 * f);
        linearLayout.setPadding(0, i, 0, i);
        this.headerRow = linearLayout;
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(context);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
        textView.setTextSize(2, 13.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleView = textView;
        linearLayout.addView(textView, new LinearLayout.LayoutParams(0, -2, 1.0f));
        int i2 = (int) (16 * f);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(C0637R.drawable.chevron_unfold);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.unfoldIcon = imageView;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i2, i2);
        layoutParams2.setMarginStart((int) (4 * f));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(imageView, layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setVisibility(8);
        this.contentContainer = linearLayout2;
        addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.detail.CollapsibleToolSegmentView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CollapsibleToolSegmentView.this.toggle();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void bind$default(CollapsibleToolSegmentView collapsibleToolSegmentView, DetailSegment.ToolSegment toolSegment, PlanItemContext planItemContext, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            planItemContext = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            function1 = null;
        }
        collapsibleToolSegmentView.bind(toolSegment, planItemContext, z, function1);
    }

    public final void bind(DetailSegment.ToolSegment segment, PlanItemContext planItemContext, boolean initialExpanded, Function1<? super Boolean, Unit> onExpandedStateChanged) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        this.expanded = initialExpanded;
        this.onExpandedStateChanged = onExpandedStateChanged;
        this.titleView.setText(segment.getTitle());
        this.contentContainer.removeAllViews();
        renderChildren(segment.getChildren(), planItemContext);
        applyExpandedState();
    }

    public static /* synthetic */ void update$default(CollapsibleToolSegmentView collapsibleToolSegmentView, DetailSegment.ToolSegment toolSegment, PlanItemContext planItemContext, int i, Object obj) {
        if ((i & 2) != 0) {
            planItemContext = null;
        }
        collapsibleToolSegmentView.update(toolSegment, planItemContext);
    }

    public final void update(DetailSegment.ToolSegment segment, PlanItemContext planItemContext) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        this.titleView.setText(segment.getTitle());
        this.contentContainer.removeAllViews();
        renderChildren(segment.getChildren(), planItemContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggle() {
        this.expanded = !this.expanded;
        applyExpandedState();
        Function1<? super Boolean, Unit> function1 = this.onExpandedStateChanged;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(this.expanded));
        }
    }

    private final void applyExpandedState() {
        this.contentContainer.setVisibility(this.expanded ? 0 : 8);
        this.unfoldIcon.setImageResource(this.expanded ? C0637R.drawable.chevron_fold : C0637R.drawable.chevron_unfold);
    }

    static /* synthetic */ void renderChildren$default(CollapsibleToolSegmentView collapsibleToolSegmentView, List list, PlanItemContext planItemContext, int i, Object obj) {
        if ((i & 2) != 0) {
            planItemContext = null;
        }
        collapsibleToolSegmentView.renderChildren(list, planItemContext);
    }

    private final void renderChildren(List<? extends AgentContentBlock> children, PlanItemContext planItemContext) {
        PlanItemContext planItemContext2;
        for (AgentContentBlock agentContentBlock : children) {
            if (agentContentBlock instanceof AgentContentBlock.Thinking) {
                AgentContentBlock.Thinking thinking = (AgentContentBlock.Thinking) agentContentBlock;
                PlanItemContext planItemContext3 = new PlanItemContext(thinking.getPlanItemId(), null, null, null, null, null, thinking.getReasoningContent(), 62, null);
                ToolDetailCardFactory toolDetailCardFactory = ToolDetailCardFactory.INSTANCE;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                ParsedToolCallInfo toolCallInfo = thinking.getToolCallInfo();
                if (toolCallInfo == null) {
                    toolCallInfo = new ParsedToolCallInfo(null, null, null, null, null, 31, null);
                }
                ToolDetailCard createThinkingCard = toolDetailCardFactory.createThinkingCard(context, toolCallInfo, planItemContext3);
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                ToolItemView toolItemView = new ToolItemView(context2);
                toolItemView.bind(createThinkingCard);
                this.contentContainer.addView(toolItemView);
            } else if (agentContentBlock instanceof AgentContentBlock.Toolcall) {
                if (planItemContext == null || (planItemContext2 = PlanItemContext.copy$default(planItemContext, null, null, null, null, null, ((AgentContentBlock.Toolcall) agentContentBlock).getConfirmInfo(), null, 95, null)) == null) {
                    planItemContext2 = new PlanItemContext(null, null, null, null, null, ((AgentContentBlock.Toolcall) agentContentBlock).getConfirmInfo(), null, 95, null);
                }
                ToolDetailCardFactory toolDetailCardFactory2 = ToolDetailCardFactory.INSTANCE;
                Context context3 = getContext();
                Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                ToolDetailCard createDetailCard = toolDetailCardFactory2.createDetailCard(context3, ((AgentContentBlock.Toolcall) agentContentBlock).getToolCallInfo(), planItemContext2);
                Context context4 = getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
                ToolItemView toolItemView2 = new ToolItemView(context4);
                toolItemView2.bind(createDetailCard);
                this.contentContainer.addView(toolItemView2);
            } else if (agentContentBlock instanceof AgentContentBlock.ToolcallGroup) {
                Iterator<AgentContentBlock> it = ((AgentContentBlock.ToolcallGroup) agentContentBlock).getChildren().iterator();
                while (it.hasNext()) {
                    renderChildren(CollectionsKt.listOf(it.next()), planItemContext);
                }
            } else if (agentContentBlock instanceof AgentContentBlock.TodoGroup) {
                Iterator<AgentContentBlock> it2 = ((AgentContentBlock.TodoGroup) agentContentBlock).getChildren().iterator();
                while (it2.hasNext()) {
                    renderChildren(CollectionsKt.listOf(it2.next()), planItemContext);
                }
            }
        }
    }
}
