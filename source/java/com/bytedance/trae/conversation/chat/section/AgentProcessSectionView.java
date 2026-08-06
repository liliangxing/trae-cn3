package com.bytedance.trae.conversation.chat.section;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.BlockRendererFactory;
import com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer;
import com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetInlineView;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: AgentProcessSectionView.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u00016B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0011J \u0010 \u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0013J\u0016\u0010#\u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J$\u0010%\u001a\u00020\u00112\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020*H\u0002J$\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020*2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\u001b0.H\u0002J\u0010\u00100\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020*H\u0002J\u000e\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u0011J\u000e\u00103\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u00104\u001a\u00020\u001bH\u0002J\u0006\u00105\u001a\u00020\u001bR\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "headerView", "durationView", "Landroid/widget/TextView;", "arrowView", "Landroid/widget/ImageView;", "contentContainer", "isCollapsed", "", "state", "Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;", "factory", "Lcom/bytedance/trae/conversation/chat/block/renderer/BlockRendererFactory;", "lastProcessBlocks", "", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "pendingBlocks", "setState", "", "newState", "durationMs", "", "autoCollapse", "updateBlocks", "blocks", "pendingState", "renderBlocks", "flushPendingBlocksIfNeeded", "prefixTypesMatch", "old", "new", "attachBlockTags", "view", "Landroid/view/View;", "notifyPureShowWidgetInlineViewCreated", "root", "callback", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineView;", "releasePureShowWidgetInlineViews", "setCollapsed", "collapsed", "setDuration", "toggleCollapsed", "reset", "ProcessState", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AgentProcessSectionView extends LinearLayout {
    private final ImageView arrowView;
    private final LinearLayout contentContainer;
    private final TextView durationView;
    private final BlockRendererFactory factory;
    private final LinearLayout headerView;
    private boolean isCollapsed;
    private List<? extends AgentContentBlock> lastProcessBlocks;
    private List<? extends AgentContentBlock> pendingBlocks;
    private ProcessState state;

    /* compiled from: AgentProcessSectionView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProcessState.values().length];
            try {
                iArr[ProcessState.IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProcessState.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AgentProcessSectionView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AgentProcessSectionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AgentProcessSectionView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgentProcessSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isCollapsed = true;
        this.state = ProcessState.IN_PROGRESS;
        this.factory = BlockRendererFactory.INSTANCE.getInstance();
        this.lastProcessBlocks = CollectionsKt.emptyList();
        setOrientation(1);
        float f = getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int i2 = (int) (4 * f);
        linearLayout.setPadding(0, i2, 0, i2);
        this.headerView = linearLayout;
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        int color = ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1);
        int max = Math.max(1, (int) (0.5f * f));
        View view = new View(context);
        view.setBackgroundColor(color);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, max, 1.0f);
        layoutParams.gravity = 16;
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(view, layoutParams);
        TextView textView = new TextView(context);
        textView.setText(context.getString(C0637R.string.trae_chat_working));
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
        textView.setTextSize(2, 15.0f);
        textView.setGravity(17);
        this.durationView = textView;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMarginStart(i2);
        Unit unit2 = Unit.INSTANCE;
        linearLayout.addView(textView, layoutParams2);
        int i3 = (int) (16 * f);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(C0637R.drawable.trae_ic_chevron_fold);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.arrowView = imageView;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i3, i3);
        layoutParams3.setMarginStart(i2);
        layoutParams3.gravity = 16;
        Unit unit3 = Unit.INSTANCE;
        linearLayout.addView(imageView, layoutParams3);
        View view2 = new View(context);
        view2.setBackgroundColor(color);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, max, 1.0f);
        layoutParams4.setMarginStart(i2);
        layoutParams4.gravity = 16;
        Unit unit4 = Unit.INSTANCE;
        linearLayout.addView(view2, layoutParams4);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setPadding(0, i2, 0, 0);
        this.contentContainer = linearLayout2;
        addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setVisibility(8);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.section.AgentProcessSectionView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                AgentProcessSectionView.this.toggleCollapsed();
            }
        });
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AgentProcessSectionView.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/section/AgentProcessSectionView$ProcessState;", "", "<init>", "(Ljava/lang/String;I)V", "IN_PROGRESS", "COMPLETED", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ProcessState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ProcessState[] $VALUES;
        public static final ProcessState IN_PROGRESS = new ProcessState("IN_PROGRESS", 0);
        public static final ProcessState COMPLETED = new ProcessState("COMPLETED", 1);

        private static final /* synthetic */ ProcessState[] $values() {
            return new ProcessState[]{IN_PROGRESS, COMPLETED};
        }

        public static EnumEntries<ProcessState> getEntries() {
            return $ENTRIES;
        }

        private ProcessState(String str, int i) {
        }

        static {
            ProcessState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static ProcessState valueOf(String str) {
            return (ProcessState) Enum.valueOf(ProcessState.class, str);
        }

        public static ProcessState[] values() {
            return (ProcessState[]) $VALUES.clone();
        }
    }

    public static /* synthetic */ void setState$default(AgentProcessSectionView agentProcessSectionView, ProcessState processState, long j, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        if ((i & 4) != 0) {
            z = true;
        }
        agentProcessSectionView.setState(processState, j, z);
    }

    public final void setState(ProcessState newState, long durationMs, boolean autoCollapse) {
        Intrinsics.checkNotNullParameter(newState, "newState");
        this.state = newState;
        int i = WhenMappings.$EnumSwitchMapping$0[newState.ordinal()];
        if (i == 1) {
            this.headerView.setVisibility(8);
            this.contentContainer.setVisibility(0);
            setVisibility(0);
            return;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        List<? extends AgentContentBlock> list = this.pendingBlocks;
        if (list == null) {
            list = this.lastProcessBlocks;
        }
        if (list.isEmpty()) {
            setVisibility(8);
            requestLayout();
            return;
        }
        setVisibility(0);
        this.headerView.setVisibility(0);
        setDuration(durationMs);
        if (autoCollapse) {
            this.isCollapsed = true;
            this.contentContainer.setVisibility(8);
            this.arrowView.setImageResource(C0637R.drawable.chevron_unfold);
        } else {
            flushPendingBlocksIfNeeded();
            this.isCollapsed = false;
            this.contentContainer.setVisibility(0);
            this.arrowView.setImageResource(C0637R.drawable.trae_ic_chevron_fold);
        }
    }

    public static /* synthetic */ void updateBlocks$default(AgentProcessSectionView agentProcessSectionView, List list, ProcessState processState, int i, Object obj) {
        if ((i & 2) != 0) {
            processState = null;
        }
        agentProcessSectionView.updateBlocks(list, processState);
    }

    public final void updateBlocks(List<? extends AgentContentBlock> blocks, ProcessState pendingState) {
        Intrinsics.checkNotNullParameter(blocks, "blocks");
        if (pendingState == null) {
            pendingState = this.state;
        }
        if (pendingState == ProcessState.COMPLETED && this.isCollapsed) {
            this.pendingBlocks = blocks;
        } else {
            this.pendingBlocks = null;
            renderBlocks(blocks);
        }
    }

    private final void renderBlocks(List<? extends AgentContentBlock> blocks) {
        IBlockRenderer renderer;
        if (!(blocks.size() >= this.lastProcessBlocks.size() && (this.lastProcessBlocks.isEmpty() ^ true) && prefixTypesMatch(this.lastProcessBlocks, blocks))) {
            releasePureShowWidgetInlineViews(this.contentContainer);
            this.contentContainer.removeAllViews();
            for (AgentContentBlock agentContentBlock : blocks) {
                IBlockRenderer renderer2 = this.factory.getRenderer(agentContentBlock);
                if (renderer2 != null) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    View render = renderer2.render(context, agentContentBlock);
                    attachBlockTags(render);
                    this.contentContainer.addView(render);
                }
            }
        } else {
            int size = this.lastProcessBlocks.size();
            for (int i = 0; i < size && i < this.contentContainer.getChildCount(); i++) {
                if (!Intrinsics.areEqual(blocks.get(i), this.lastProcessBlocks.get(i))) {
                    View childAt = this.contentContainer.getChildAt(i);
                    if (childAt != null && blocks.get(i).getClass() == this.lastProcessBlocks.get(i).getClass()) {
                        IBlockRenderer renderer3 = this.factory.getRenderer(blocks.get(i));
                        if (renderer3 != null) {
                            renderer3.update(childAt, blocks.get(i));
                        }
                    } else if (childAt != null && (renderer = this.factory.getRenderer(blocks.get(i))) != null) {
                        Context context2 = getContext();
                        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                        View render2 = renderer.render(context2, blocks.get(i));
                        attachBlockTags(render2);
                        releasePureShowWidgetInlineViews(childAt);
                        this.contentContainer.removeViewAt(i);
                        this.contentContainer.addView(render2, i);
                    }
                }
            }
            int size2 = blocks.size();
            for (int size3 = this.lastProcessBlocks.size(); size3 < size2; size3++) {
                IBlockRenderer renderer4 = this.factory.getRenderer(blocks.get(size3));
                if (renderer4 != null) {
                    Context context3 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
                    View render3 = renderer4.render(context3, blocks.get(size3));
                    attachBlockTags(render3);
                    this.contentContainer.addView(render3);
                }
            }
        }
        this.lastProcessBlocks = CollectionsKt.toList(blocks);
        if (this.state == ProcessState.IN_PROGRESS && this.lastProcessBlocks.isEmpty()) {
            setVisibility(8);
        } else if (this.state == ProcessState.IN_PROGRESS && (!this.lastProcessBlocks.isEmpty())) {
            setVisibility(0);
        }
    }

    private final void flushPendingBlocksIfNeeded() {
        List<? extends AgentContentBlock> list = this.pendingBlocks;
        if (list == null) {
            return;
        }
        this.pendingBlocks = null;
        renderBlocks(list);
    }

    private final boolean prefixTypesMatch(List<? extends AgentContentBlock> old, List<? extends AgentContentBlock> r7) {
        int size = old.size();
        for (int i = 0; i < size; i++) {
            if (i >= r7.size() || old.get(i).getClass() != r7.get(i).getClass()) {
                return false;
            }
        }
        return true;
    }

    private final void attachBlockTags(View view) {
        view.setTag(C0637R.id.tag_on_content_changed, getTag(C0637R.id.tag_on_content_changed));
        view.setTag(C0637R.id.tag_on_pure_show_widget_inline_view_created, getTag(C0637R.id.tag_on_pure_show_widget_inline_view_created));
        notifyPureShowWidgetInlineViewCreated(view);
    }

    private final void notifyPureShowWidgetInlineViewCreated(View root) {
        Object tag = getTag(C0637R.id.tag_on_pure_show_widget_inline_view_created);
        Function1<? super PureShowWidgetInlineView, Unit> function1 = TypeIntrinsics.isFunctionOfArity(tag, 1) ? (Function1) tag : null;
        if (function1 == null) {
            return;
        }
        notifyPureShowWidgetInlineViewCreated(root, function1);
    }

    private final void notifyPureShowWidgetInlineViewCreated(View root, Function1<? super PureShowWidgetInlineView, Unit> callback) {
        if (root instanceof PureShowWidgetInlineView) {
            callback.invoke(root);
            return;
        }
        if (root instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) root;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                notifyPureShowWidgetInlineViewCreated(childAt, callback);
            }
        }
    }

    private final void releasePureShowWidgetInlineViews(View root) {
        if (root instanceof PureShowWidgetInlineView) {
            ((PureShowWidgetInlineView) root).release();
            return;
        }
        if (root instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) root;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(...)");
                releasePureShowWidgetInlineViews(childAt);
            }
        }
    }

    public final void setCollapsed(boolean collapsed) {
        this.isCollapsed = collapsed;
        if (!collapsed) {
            flushPendingBlocksIfNeeded();
        }
        this.contentContainer.setVisibility(collapsed ? 8 : 0);
        this.arrowView.setImageResource(collapsed ? C0637R.drawable.chevron_unfold : C0637R.drawable.trae_ic_chevron_fold);
    }

    public final void setDuration(long durationMs) {
        String string;
        long j = durationMs / 1000;
        long j2 = 60;
        long j3 = j / j2;
        long j4 = j % j2;
        TextView textView = this.durationView;
        if (j3 > 0) {
            string = getContext().getString(C0637R.string.trae_chat_worked_minutes, Long.valueOf(j3), Long.valueOf(j4));
        } else if (j > 0) {
            string = getContext().getString(C0637R.string.trae_chat_worked_seconds, Long.valueOf(j));
        } else {
            string = getContext().getString(C0637R.string.trae_chat_working);
        }
        textView.setText(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toggleCollapsed() {
        setCollapsed(!this.isCollapsed);
    }

    public final void reset() {
        releasePureShowWidgetInlineViews(this.contentContainer);
        this.contentContainer.removeAllViews();
        this.lastProcessBlocks = CollectionsKt.emptyList();
        this.pendingBlocks = null;
        this.state = ProcessState.IN_PROGRESS;
        this.isCollapsed = true;
        this.headerView.setVisibility(8);
        this.contentContainer.setVisibility(0);
        setVisibility(0);
    }
}
