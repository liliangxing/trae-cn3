package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.TodoGroupRenderer;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: TodoGroupRenderer.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;", "<init>", "()V", "BLOCK_TAG", "", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "update", "", "view", "TodoGroupViewManager", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TodoGroupRenderer implements IBlockRenderer<AgentContentBlock.TodoGroup> {
    private final String BLOCK_TAG = "TodoGroupRenderer";

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(Context context, AgentContentBlock.TodoGroup block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        TodoGroupViewManager todoGroupViewManager = new TodoGroupViewManager();
        View render = todoGroupViewManager.render(context, block);
        render.setTag(C0637R.id.trae_tag_todo_group_view_manager, todoGroupViewManager);
        return render;
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.TodoGroup block) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        Object tag = view.getTag(C0637R.id.trae_tag_todo_group_view_manager);
        TodoGroupViewManager todoGroupViewManager = tag instanceof TodoGroupViewManager ? (TodoGroupViewManager) tag : null;
        if (todoGroupViewManager == null) {
            return;
        }
        todoGroupViewManager.update(view, block);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TodoGroupRenderer.kt */
    @Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010[\u001a\u0002052\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_J(\u0010`\u001a\u00020a2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0017H\u0002J\u0018\u0010e\u001a\u00020a2\u0006\u0010b\u001a\u00020c2\u0006\u0010f\u001a\u00020VH\u0002J\u0016\u0010g\u001a\u00020a2\u0006\u0010h\u001a\u0002052\u0006\u0010^\u001a\u00020_J \u0010i\u001a\u00020a2\u0006\u0010\\\u001a\u00020]2\u0006\u0010f\u001a\u00020V2\u0006\u0010g\u001a\u00020>H\u0002J\b\u0010j\u001a\u00020aH\u0002J\b\u0010k\u001a\u00020aH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010\u001bR\u001a\u0010=\u001a\u00020>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010@\"\u0004\bE\u0010BR\u001a\u0010F\u001a\u00020>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010@\"\u0004\bH\u0010BR\u001c\u0010I\u001a\u0004\u0018\u00010JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010O\u001a\u0004\u0018\u00010PX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u00020VX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010Z¨\u0006l"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/TodoGroupRenderer$TodoGroupViewManager;", "", "<init>", "()V", "iconView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "setIconView", "(Landroid/widget/ImageView;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "setTitleView", "(Landroid/widget/TextView;)V", "summaryView", "Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;", "getSummaryView", "()Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;", "setSummaryView", "(Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;)V", "contentRow", "Landroid/widget/LinearLayout;", "getContentRow", "()Landroid/widget/LinearLayout;", "setContentRow", "(Landroid/widget/LinearLayout;)V", "contentArea", "Landroid/widget/FrameLayout;", "getContentArea", "()Landroid/widget/FrameLayout;", "setContentArea", "(Landroid/widget/FrameLayout;)V", "childRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getChildRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setChildRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerWrapper", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getRecyclerWrapper", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setRecyclerWrapper", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "childAdapter", "Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;", "getChildAdapter", "()Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;", "setChildAdapter", "(Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;)V", "fadeMask", "Landroid/view/View;", "getFadeMask", "()Landroid/view/View;", "setFadeMask", "(Landroid/view/View;)V", "headerRow", "getHeaderRow", "setHeaderRow", "expanded", "", "getExpanded", "()Z", "setExpanded", "(Z)V", "userOverrodeExpanded", "getUserOverrodeExpanded", "setUserOverrodeExpanded", "hasVisibleChildren", "getHasVisibleChildren", "setHasVisibleChildren", "currentSummary", "", "getCurrentSummary", "()Ljava/lang/String;", "setCurrentSummary", "(Ljava/lang/String;)V", "frameAnimation", "Landroid/graphics/drawable/AnimationDrawable;", "getFrameAnimation", "()Landroid/graphics/drawable/AnimationDrawable;", "setFrameAnimation", "(Landroid/graphics/drawable/AnimationDrawable;)V", "currentStatus", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;", "getCurrentStatus", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;", "setCurrentStatus", "(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;)V", "render", "context", "Landroid/content/Context;", "block", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$TodoGroup;", "buildContentArea", "", "density", "", "root", "applyCollapsedState", PageDataManager.EXTRA_STATUS, "update", "view", "applyStatusIcon", "startFrameAnimation", "stopSpinAnimation", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class TodoGroupViewManager {
        private TodoChildAdapter childAdapter;
        private RecyclerView childRecyclerView;
        private FrameLayout contentArea;
        private LinearLayout contentRow;
        private AgentContentBlock.GroupStatus currentStatus = AgentContentBlock.GroupStatus.RUNNING;
        private String currentSummary;
        private boolean expanded;
        private View fadeMask;
        private AnimationDrawable frameAnimation;
        private boolean hasVisibleChildren;
        private LinearLayout headerRow;
        private ImageView iconView;
        private ConstraintLayout recyclerWrapper;
        private SimpleMarkdownTextView summaryView;
        private TextView titleView;
        private boolean userOverrodeExpanded;

        /* compiled from: TodoGroupRenderer.kt */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AgentContentBlock.GroupStatus.values().length];
                try {
                    iArr[AgentContentBlock.GroupStatus.COMPLETED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AgentContentBlock.GroupStatus.FAILED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AgentContentBlock.GroupStatus.CANCELED.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AgentContentBlock.GroupStatus.INTERJECTED.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AgentContentBlock.GroupStatus.RUNNING.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[AgentContentBlock.GroupStatus.WAITING_CONFIRM.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public final ImageView getIconView() {
            return this.iconView;
        }

        public final void setIconView(ImageView imageView) {
            this.iconView = imageView;
        }

        public final TextView getTitleView() {
            return this.titleView;
        }

        public final void setTitleView(TextView textView) {
            this.titleView = textView;
        }

        public final SimpleMarkdownTextView getSummaryView() {
            return this.summaryView;
        }

        public final void setSummaryView(SimpleMarkdownTextView simpleMarkdownTextView) {
            this.summaryView = simpleMarkdownTextView;
        }

        public final LinearLayout getContentRow() {
            return this.contentRow;
        }

        public final void setContentRow(LinearLayout linearLayout) {
            this.contentRow = linearLayout;
        }

        public final FrameLayout getContentArea() {
            return this.contentArea;
        }

        public final void setContentArea(FrameLayout frameLayout) {
            this.contentArea = frameLayout;
        }

        public final RecyclerView getChildRecyclerView() {
            return this.childRecyclerView;
        }

        public final void setChildRecyclerView(RecyclerView recyclerView) {
            this.childRecyclerView = recyclerView;
        }

        public final ConstraintLayout getRecyclerWrapper() {
            return this.recyclerWrapper;
        }

        public final void setRecyclerWrapper(ConstraintLayout constraintLayout) {
            this.recyclerWrapper = constraintLayout;
        }

        public final TodoChildAdapter getChildAdapter() {
            return this.childAdapter;
        }

        public final void setChildAdapter(TodoChildAdapter todoChildAdapter) {
            this.childAdapter = todoChildAdapter;
        }

        public final View getFadeMask() {
            return this.fadeMask;
        }

        public final void setFadeMask(View view) {
            this.fadeMask = view;
        }

        public final LinearLayout getHeaderRow() {
            return this.headerRow;
        }

        public final void setHeaderRow(LinearLayout linearLayout) {
            this.headerRow = linearLayout;
        }

        public final boolean getExpanded() {
            return this.expanded;
        }

        public final void setExpanded(boolean z) {
            this.expanded = z;
        }

        public final boolean getUserOverrodeExpanded() {
            return this.userOverrodeExpanded;
        }

        public final void setUserOverrodeExpanded(boolean z) {
            this.userOverrodeExpanded = z;
        }

        public final boolean getHasVisibleChildren() {
            return this.hasVisibleChildren;
        }

        public final void setHasVisibleChildren(boolean z) {
            this.hasVisibleChildren = z;
        }

        public final String getCurrentSummary() {
            return this.currentSummary;
        }

        public final void setCurrentSummary(String str) {
            this.currentSummary = str;
        }

        public final AnimationDrawable getFrameAnimation() {
            return this.frameAnimation;
        }

        public final void setFrameAnimation(AnimationDrawable animationDrawable) {
            this.frameAnimation = animationDrawable;
        }

        public final AgentContentBlock.GroupStatus getCurrentStatus() {
            return this.currentStatus;
        }

        public final void setCurrentStatus(AgentContentBlock.GroupStatus groupStatus) {
            Intrinsics.checkNotNullParameter(groupStatus, "<set-?>");
            this.currentStatus = groupStatus;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final View render(Context context, AgentContentBlock.TodoGroup block) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(block, "block");
            final float f = context.getResources().getDisplayMetrics().density;
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int i = (int) (4 * f);
            layoutParams.topMargin = i;
            layoutParams.bottomMargin = i;
            linearLayout.setLayoutParams(layoutParams);
            this.currentStatus = block.getStatus();
            this.currentSummary = block.getSummary();
            this.expanded = TodoChildPresentationPolicy.INSTANCE.shouldAutoExpand(block.getChildren());
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(16);
            this.headerRow = linearLayout2;
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
            int i2 = (int) (20 * f);
            ImageView imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.iconView = imageView;
            applyStatusIcon(context, block.getStatus(), false);
            LinearLayout linearLayout3 = this.headerRow;
            if (linearLayout3 != null) {
                linearLayout3.addView(this.iconView, new LinearLayout.LayoutParams(i2, i2));
            }
            int i3 = this.expanded ? C0637R.drawable.trae_ic_chevron_fold : C0637R.drawable.chevron_unfold;
            String title = block.getTitle();
            if (title == null && (title = block.getSummary()) == null) {
                title = context.getString(C0637R.string.trae_chat_todo_in_progress);
                Intrinsics.checkNotNullExpressionValue(title, "getString(...)");
            }
            TextView textView = new TextView(context);
            textView.setText(title);
            textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
            textView.setTextSize(2, 15.0f);
            TextViewCompat.setLineHeight(textView, (int) (24 * f));
            textView.setMaxLines(1);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setCompoundDrawablePadding(i);
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, i3, 0);
            this.titleView = textView;
            LinearLayout linearLayout4 = this.headerRow;
            if (linearLayout4 != null) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                layoutParams2.setMarginStart(i);
                Unit unit = Unit.INSTANCE;
                linearLayout4.addView(textView, layoutParams2);
            }
            buildContentArea(context, block, f, linearLayout);
            SimpleMarkdownTextView simpleMarkdownTextView = new SimpleMarkdownTextView(context, null, 0, 6, null);
            simpleMarkdownTextView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
            simpleMarkdownTextView.setTextSize(2, 15.0f);
            TextViewCompat.setLineHeight((TextView) simpleMarkdownTextView, i2);
            int i4 = 8;
            simpleMarkdownTextView.setVisibility(8);
            this.summaryView = simpleMarkdownTextView;
            String summary = block.getSummary();
            String str = summary;
            if (!(str == null || StringsKt.isBlank(str))) {
                SimpleMarkdownTextView simpleMarkdownTextView2 = this.summaryView;
                if (simpleMarkdownTextView2 != null) {
                    simpleMarkdownTextView2.setText(str);
                }
                SimpleMarkdownTextView simpleMarkdownTextView3 = this.summaryView;
                if (simpleMarkdownTextView3 != null) {
                    if (!this.expanded && block.getStatus() == AgentContentBlock.GroupStatus.COMPLETED) {
                        i4 = 0;
                    }
                    simpleMarkdownTextView3.setVisibility(i4);
                }
                MarkdownHelper markdownHelper = MarkdownHelper.INSTANCE;
                SimpleMarkdownTextView simpleMarkdownTextView4 = this.summaryView;
                Intrinsics.checkNotNull(simpleMarkdownTextView4);
                MarkdownHelper.setMarkdownContent$default(markdownHelper, simpleMarkdownTextView4, summary, block.getStatus() == AgentContentBlock.GroupStatus.COMPLETED, null, 8, null);
            }
            View view = (View) this.summaryView;
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.topMargin = (int) (2 * f);
            Unit unit2 = Unit.INSTANCE;
            linearLayout.addView(view, layoutParams3);
            applyCollapsedState(f, block.getStatus());
            LinearLayout linearLayout5 = this.headerRow;
            if (linearLayout5 != null) {
                linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.TodoGroupRenderer$TodoGroupViewManager$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        TodoGroupRenderer.TodoGroupViewManager.render$lambda$8(TodoGroupRenderer.TodoGroupViewManager.this, f, view2);
                    }
                });
            }
            return linearLayout;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
        
            if (r5 != false) goto L21;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static final void render$lambda$8(TodoGroupViewManager todoGroupViewManager, float f, View view) {
            boolean z = true;
            todoGroupViewManager.userOverrodeExpanded = true;
            boolean z2 = !todoGroupViewManager.expanded;
            todoGroupViewManager.expanded = z2;
            TextView textView = todoGroupViewManager.titleView;
            int i = 0;
            if (textView != null) {
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, z2 ? C0637R.drawable.trae_ic_chevron_fold : C0637R.drawable.chevron_unfold, 0);
            }
            todoGroupViewManager.applyCollapsedState(f, todoGroupViewManager.currentStatus);
            SimpleMarkdownTextView simpleMarkdownTextView = todoGroupViewManager.summaryView;
            if (simpleMarkdownTextView != null) {
                if (!todoGroupViewManager.expanded && todoGroupViewManager.currentStatus != AgentContentBlock.GroupStatus.RUNNING) {
                    String str = todoGroupViewManager.currentSummary;
                    if (str != null && !StringsKt.isBlank(str)) {
                        z = false;
                    }
                }
                i = 8;
                simpleMarkdownTextView.setVisibility(i);
            }
        }

        private final void buildContentArea(Context context, AgentContentBlock.TodoGroup block, float density, LinearLayout root) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            this.contentRow = linearLayout;
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setOrientation(1);
            linearLayout2.setGravity(1);
            int i = (int) (1 * density);
            linearLayout2.setPadding(0, i, 0, i);
            View view = new View(context);
            view.setBackgroundColor(Color.argb(45, 106, 105, 104));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(RangesKt.coerceAtLeast(i, 1), 0, 1.0f);
            int i2 = (int) (4 * density);
            layoutParams.topMargin = i2;
            Unit unit = Unit.INSTANCE;
            linearLayout2.addView(view, layoutParams);
            LinearLayout linearLayout3 = this.contentRow;
            if (linearLayout3 != null) {
                linearLayout3.addView(linearLayout2, new LinearLayout.LayoutParams((int) (20 * density), -1));
            }
            this.contentArea = new FrameLayout(context);
            this.childAdapter = new TodoChildAdapter();
            List<AgentContentBlock> visibleChildren = TodoChildPresentationPolicy.INSTANCE.visibleChildren(block.getChildren());
            this.hasVisibleChildren = !visibleChildren.isEmpty();
            TodoChildAdapter todoChildAdapter = this.childAdapter;
            if (todoChildAdapter != null) {
                todoChildAdapter.submitList(visibleChildren);
            }
            RecyclerView recyclerView = new RecyclerView(context);
            recyclerView.setId(View.generateViewId());
            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(context, 1, false);
            linearLayoutManager.setStackFromEnd(true);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(this.childAdapter);
            recyclerView.setItemAnimator((RecyclerView.ItemAnimator) null);
            recyclerView.setOverScrollMode(2);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setHasFixedSize(false);
            this.childRecyclerView = recyclerView;
            ConstraintLayout constraintLayout = new ConstraintLayout(context);
            this.recyclerWrapper = constraintLayout;
            View view2 = this.childRecyclerView;
            ViewGroup.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-1, -2);
            ((ConstraintLayout.LayoutParams) layoutParams2).topToTop = 0;
            ((ConstraintLayout.LayoutParams) layoutParams2).startToStart = 0;
            ((ConstraintLayout.LayoutParams) layoutParams2).endToEnd = 0;
            ((ConstraintLayout.LayoutParams) layoutParams2).matchConstraintMaxHeight = (int) (100 * density);
            Unit unit2 = Unit.INSTANCE;
            constraintLayout.addView(view2, layoutParams2);
            FrameLayout frameLayout = this.contentArea;
            if (frameLayout != null) {
                frameLayout.addView((View) this.recyclerWrapper, new FrameLayout.LayoutParams(-1, -2));
            }
            final int color = ContextCompat.getColor(context, C0591R.color.trae_bg_bg_base_secondary);
            final int argb = Color.argb(0, Color.red(color), Color.green(color), Color.blue(color));
            View view3 = new View(context);
            PaintDrawable paintDrawable = new PaintDrawable();
            paintDrawable.setShape(new RectShape());
            paintDrawable.setShaderFactory(new ShapeDrawable.ShaderFactory() { // from class: com.bytedance.trae.conversation.chat.block.renderer.TodoGroupRenderer$TodoGroupViewManager$buildContentArea$5$1
                @Override // android.graphics.drawable.ShapeDrawable.ShaderFactory
                public Shader resize(int width, int height) {
                    return new LinearGradient(0.0f, 0.0f, 0.0f, height, color, argb, Shader.TileMode.CLAMP);
                }
            });
            view3.setBackground(paintDrawable);
            view3.setVisibility(8);
            this.fadeMask = view3;
            FrameLayout frameLayout2 = this.contentArea;
            if (frameLayout2 != null) {
                frameLayout2.addView(view3, new FrameLayout.LayoutParams(-1, (int) (24 * density)));
            }
            LinearLayout linearLayout4 = this.contentRow;
            if (linearLayout4 != null) {
                FrameLayout frameLayout3 = this.contentArea;
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
                layoutParams3.setMarginStart(i2);
                Unit unit3 = Unit.INSTANCE;
                linearLayout4.addView(frameLayout3, layoutParams3);
            }
            LinearLayout linearLayout5 = this.contentRow;
            if (linearLayout5 != null) {
                root.addView(linearLayout5, new LinearLayout.LayoutParams(-1, -2));
            }
        }

        private final void applyCollapsedState(float density, AgentContentBlock.GroupStatus status) {
            RecyclerView recyclerView;
            this.currentStatus = status;
            LinearLayout linearLayout = this.contentRow;
            if (linearLayout == null) {
                return;
            }
            if (!this.hasVisibleChildren) {
                linearLayout.setVisibility(8);
                return;
            }
            linearLayout.setVisibility(0);
            FrameLayout frameLayout = this.contentArea;
            if (frameLayout == null || (recyclerView = this.childRecyclerView) == null) {
                return;
            }
            ConstraintLayout.LayoutParams layoutParams = recyclerView.getLayoutParams();
            ConstraintLayout.LayoutParams layoutParams2 = layoutParams instanceof ConstraintLayout.LayoutParams ? layoutParams : null;
            if (layoutParams2 == null) {
                return;
            }
            boolean z = status == AgentContentBlock.GroupStatus.RUNNING || status == AgentContentBlock.GroupStatus.WAITING_CONFIRM;
            if (z && !this.expanded) {
                layoutParams2.matchConstraintMaxHeight = (int) (100 * density);
                recyclerView.setLayoutParams((ViewGroup.LayoutParams) layoutParams2);
                frameLayout.setVisibility(0);
                View view = this.fadeMask;
                if (view != null) {
                    view.setVisibility(0);
                }
            } else if (z && this.expanded) {
                layoutParams2.matchConstraintMaxHeight = 0;
                recyclerView.setLayoutParams((ViewGroup.LayoutParams) layoutParams2);
                frameLayout.setVisibility(0);
                View view2 = this.fadeMask;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            } else if (!z && !this.expanded) {
                frameLayout.setVisibility(8);
                View view3 = this.fadeMask;
                if (view3 != null) {
                    view3.setVisibility(8);
                }
            } else {
                layoutParams2.matchConstraintMaxHeight = 0;
                recyclerView.setLayoutParams((ViewGroup.LayoutParams) layoutParams2);
                frameLayout.setVisibility(0);
                View view4 = this.fadeMask;
                if (view4 != null) {
                    view4.setVisibility(8);
                }
            }
            RecyclerView recyclerView2 = this.childRecyclerView;
            if (recyclerView2 != null) {
                recyclerView2.setNestedScrollingEnabled(false);
            }
        }

        public final void update(View view, AgentContentBlock.TodoGroup block) {
            String str;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(block, "block");
            Context context = view.getContext();
            float f = context.getResources().getDisplayMetrics().density;
            this.currentStatus = block.getStatus();
            this.currentSummary = block.getSummary();
            if (!this.userOverrodeExpanded && TodoChildPresentationPolicy.INSTANCE.shouldAutoExpand(block.getChildren())) {
                this.expanded = true;
            }
            Intrinsics.checkNotNull(context);
            applyStatusIcon(context, block.getStatus(), true);
            TextView textView = this.titleView;
            if (textView != null) {
                String title = block.getTitle();
                if (title == null && (title = block.getSummary()) == null) {
                    String string = context.getString(C0637R.string.trae_chat_todo_in_progress);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    str = string;
                } else {
                    str = title;
                }
                textView.setText(str);
            }
            String summary = block.getSummary();
            String str2 = summary;
            if (!(str2 == null || StringsKt.isBlank(str2))) {
                SimpleMarkdownTextView simpleMarkdownTextView = this.summaryView;
                if (simpleMarkdownTextView != null) {
                    MarkdownHelper.setMarkdownContent$default(MarkdownHelper.INSTANCE, simpleMarkdownTextView, summary, block.getStatus() == AgentContentBlock.GroupStatus.COMPLETED, null, 8, null);
                }
            } else {
                SimpleMarkdownTextView simpleMarkdownTextView2 = this.summaryView;
                if (simpleMarkdownTextView2 != null) {
                    simpleMarkdownTextView2.setText("");
                }
            }
            SimpleMarkdownTextView simpleMarkdownTextView3 = this.summaryView;
            if (simpleMarkdownTextView3 != null) {
                simpleMarkdownTextView3.setVisibility(((str2 == null || StringsKt.isBlank(str2)) || this.expanded || block.getStatus() != AgentContentBlock.GroupStatus.COMPLETED) ? 8 : 0);
            }
            List<AgentContentBlock> visibleChildren = TodoChildPresentationPolicy.INSTANCE.visibleChildren(block.getChildren());
            this.hasVisibleChildren = true ^ visibleChildren.isEmpty();
            TodoChildAdapter todoChildAdapter = this.childAdapter;
            if (todoChildAdapter != null) {
                todoChildAdapter.submitList(visibleChildren);
            }
            TextView textView2 = this.titleView;
            if (textView2 != null) {
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, this.expanded ? C0637R.drawable.trae_ic_chevron_fold : C0637R.drawable.chevron_unfold, 0);
            }
            applyCollapsedState(f, block.getStatus());
            view.requestLayout();
            Object tag = view.getTag(C0637R.id.tag_on_content_changed);
            if (TypeIntrinsics.isFunctionOfArity(tag, 0)) {
                ((Function0) tag).invoke();
            }
        }

        private final void applyStatusIcon(Context context, AgentContentBlock.GroupStatus status, boolean update) {
            ImageView imageView = this.iconView;
            if (imageView == null) {
                return;
            }
            switch (WhenMappings.$EnumSwitchMapping$0[status.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    stopSpinAnimation();
                    imageView.setImageResource(C0637R.drawable.checkmark_circle);
                    return;
                case 5:
                case 6:
                    if (update) {
                        return;
                    }
                    imageView.setImageResource(C0637R.drawable.status_loading_anim);
                    startFrameAnimation();
                    return;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        private final void startFrameAnimation() {
            ImageView imageView = this.iconView;
            if (imageView == null) {
                return;
            }
            Drawable drawable = imageView.getDrawable();
            AnimationDrawable animationDrawable = drawable instanceof AnimationDrawable ? (AnimationDrawable) drawable : null;
            if (animationDrawable == null || animationDrawable.isRunning()) {
                return;
            }
            this.frameAnimation = animationDrawable;
            animationDrawable.start();
        }

        private final void stopSpinAnimation() {
            AnimationDrawable animationDrawable = this.frameAnimation;
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
            this.frameAnimation = null;
        }
    }
}
