package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: TodoChildAdapter.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002%&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011H\u0016J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010$\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;", "<init>", "()V", "items", "", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "pureShowWidgetRenderer", "Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRenderer;", "subAgentGroupRenderer", "Lcom/bytedance/trae/conversation/chat/block/renderer/SubAgentGroupRenderer;", "submitList", "", "list", "", "getItemCount", "", "getItemViewType", NewTaskTracker.Param.POSITION, "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "holder", "onViewRecycled", "releasePureShowWidgetInlineViews", "root", "Landroid/view/View;", "createThoughtView", "context", "Landroid/content/Context;", "density", "", "createSubAgentRow", "createArrowRow", "Companion", "ChildViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TodoChildAdapter extends RecyclerView.Adapter<ChildViewHolder> {
    private static final int TYPE_PURE_SHOW_WIDGET = 3;
    private static final int TYPE_SUB_AGENT = 2;
    private static final int TYPE_SUB_AGENT_WITH_WIDGET = 4;
    private static final int TYPE_THOUGHT = 0;
    private static final int TYPE_TOOL = 1;
    private final List<AgentContentBlock> items = new ArrayList();
    private final PureShowWidgetToolcallGroupRenderer pureShowWidgetRenderer = new PureShowWidgetToolcallGroupRenderer();
    private final SubAgentGroupRenderer subAgentGroupRenderer = new SubAgentGroupRenderer();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3(View view) {
    }

    public final void submitList(List<? extends AgentContentBlock> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.items.clear();
        this.items.addAll(list);
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.items.size();
    }

    public int getItemViewType(int position) {
        AgentContentBlock agentContentBlock = this.items.get(position);
        if (agentContentBlock instanceof AgentContentBlock.Thought) {
            return 0;
        }
        return agentContentBlock instanceof AgentContentBlock.SubAgentGroup ? TodoChildPresentationPolicy.INSTANCE.containsPureShowWidget(((AgentContentBlock.SubAgentGroup) agentContentBlock).getChildren()) ? 4 : 2 : agentContentBlock instanceof AgentContentBlock.PureShowWidgetToolcallGroup ? 3 : 1;
    }

    public ChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        float f = context.getResources().getDisplayMetrics().density;
        if (viewType == 0) {
            Intrinsics.checkNotNull(context);
            return new ChildViewHolder(createThoughtView(context, f));
        }
        if (viewType == 2) {
            Intrinsics.checkNotNull(context);
            return new ChildViewHolder(createSubAgentRow(context, f));
        }
        if (viewType == 3) {
            PureShowWidgetToolcallGroupRenderer pureShowWidgetToolcallGroupRenderer = this.pureShowWidgetRenderer;
            Intrinsics.checkNotNull(context);
            LinearLayout createContainer$conversation_mainlandRelease = pureShowWidgetToolcallGroupRenderer.createContainer$conversation_mainlandRelease(context);
            createContainer$conversation_mainlandRelease.setLayoutParams((ViewGroup.LayoutParams) new RecyclerView.LayoutParams(-1, -2));
            return new ChildViewHolder(createContainer$conversation_mainlandRelease);
        }
        if (viewType == 4) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams((ViewGroup.LayoutParams) new RecyclerView.LayoutParams(-1, -2));
            return new ChildViewHolder(linearLayout);
        }
        Intrinsics.checkNotNull(context);
        return new ChildViewHolder(createArrowRow(context, f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBindViewHolder(ChildViewHolder holder, int position) {
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        final AgentContentBlock agentContentBlock = this.items.get(position);
        if (agentContentBlock instanceof AgentContentBlock.Thought) {
            View view = holder.itemView;
            SimpleMarkdownTextView simpleMarkdownTextView = view instanceof SimpleMarkdownTextView ? (SimpleMarkdownTextView) view : null;
            if (simpleMarkdownTextView != null) {
                simpleMarkdownTextView.setText(((AgentContentBlock.Thought) agentContentBlock).getThought());
            }
            MarkdownHelper markdownHelper = MarkdownHelper.INSTANCE;
            View view2 = holder.itemView;
            MarkdownHelper.setMarkdownContent$default(markdownHelper, view2 instanceof SimpleMarkdownTextView ? (SimpleMarkdownTextView) view2 : null, ((AgentContentBlock.Thought) agentContentBlock).getThought(), false, null, 12, null);
            return;
        }
        if (agentContentBlock instanceof AgentContentBlock.SubAgentGroup) {
            if (holder.getItemViewType() == 4) {
                View view3 = holder.itemView;
                Intrinsics.checkNotNull(view3, "null cannot be cast to non-null type android.widget.LinearLayout");
                LinearLayout linearLayout = (LinearLayout) view3;
                View childAt = linearLayout.getChildAt(0);
                if (childAt == null) {
                    SubAgentGroupRenderer subAgentGroupRenderer = this.subAgentGroupRenderer;
                    Context context = linearLayout.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    linearLayout.addView(subAgentGroupRenderer.render(context, (AgentContentBlock.SubAgentGroup) agentContentBlock), new LinearLayout.LayoutParams(-1, -2));
                    return;
                }
                this.subAgentGroupRenderer.update(childAt, (AgentContentBlock.SubAgentGroup) agentContentBlock);
                return;
            }
            View view4 = holder.itemView;
            Intrinsics.checkNotNull(view4, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout2 = (LinearLayout) view4;
            View childAt2 = linearLayout2.getChildAt(1);
            TextView textView = childAt2 instanceof TextView ? (TextView) childAt2 : null;
            if (textView != null) {
                AgentContentBlock.SubAgentGroup subAgentGroup = (AgentContentBlock.SubAgentGroup) agentContentBlock;
                String description = subAgentGroup.getDescription();
                if (description != null) {
                    str = description;
                } else {
                    String agentDisplayName = subAgentGroup.getAgentDisplayName();
                    if (agentDisplayName != null) {
                        str = agentDisplayName;
                    } else {
                        String string = linearLayout2.getContext().getString(C0637R.string.trae_chat_sub_agent_default);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        str = string;
                    }
                }
                textView.setText(str);
            }
            View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.TodoChildAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    TodoChildAdapter.onBindViewHolder$lambda$2(AgentContentBlock.this, view5);
                }
            };
            linearLayout2.setOnClickListener(onClickListener);
            if (textView != null) {
                textView.setOnClickListener(onClickListener);
                return;
            }
            return;
        }
        if (agentContentBlock instanceof AgentContentBlock.Toolcall) {
            View view5 = holder.itemView;
            Intrinsics.checkNotNull(view5, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout3 = (LinearLayout) view5;
            View childAt3 = linearLayout3.getChildAt(0);
            TextView textView2 = childAt3 instanceof TextView ? (TextView) childAt3 : null;
            if (textView2 != null) {
                String name = ((AgentContentBlock.Toolcall) agentContentBlock).getToolCallInfo().getName();
                textView2.setText(name != null ? name : "");
            }
            View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.TodoChildAdapter$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view6) {
                    TodoChildAdapter.onBindViewHolder$lambda$3(view6);
                }
            };
            linearLayout3.setOnClickListener(onClickListener2);
            if (textView2 != null) {
                textView2.setOnClickListener(onClickListener2);
                return;
            }
            return;
        }
        if (agentContentBlock instanceof AgentContentBlock.ToolcallGroup) {
            View view6 = holder.itemView;
            Intrinsics.checkNotNull(view6, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout4 = (LinearLayout) view6;
            View childAt4 = linearLayout4.getChildAt(0);
            TextView textView3 = childAt4 instanceof TextView ? (TextView) childAt4 : null;
            if (textView3 != null) {
                textView3.setText(((AgentContentBlock.ToolcallGroup) agentContentBlock).getTitle());
            }
            View.OnClickListener onClickListener3 = new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.TodoChildAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view7) {
                    TodoChildAdapter.onBindViewHolder$lambda$6(AgentContentBlock.this, view7);
                }
            };
            linearLayout4.setOnClickListener(onClickListener3);
            if (textView3 != null) {
                textView3.setOnClickListener(onClickListener3);
                return;
            }
            return;
        }
        if (agentContentBlock instanceof AgentContentBlock.PureShowWidgetToolcallGroup) {
            PureShowWidgetToolcallGroupRenderer pureShowWidgetToolcallGroupRenderer = this.pureShowWidgetRenderer;
            View view7 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view7, "itemView");
            pureShowWidgetToolcallGroupRenderer.update(view7, (AgentContentBlock.PureShowWidgetToolcallGroup) agentContentBlock);
            return;
        }
        View view8 = holder.itemView;
        SimpleMarkdownTextView simpleMarkdownTextView2 = view8 instanceof SimpleMarkdownTextView ? (SimpleMarkdownTextView) view8 : null;
        if (simpleMarkdownTextView2 != null) {
            simpleMarkdownTextView2.setText("");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(AgentContentBlock agentContentBlock, View view) {
        FragmentManager supportFragmentManager;
        FragmentActivity context = view.getContext();
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? context : null;
        if (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null) {
            return;
        }
        ProcessDetailBottomSheet.INSTANCE.showAgentDetail(supportFragmentManager, (AgentContentBlock.SubAgentGroup) agentContentBlock);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$6(AgentContentBlock agentContentBlock, View view) {
        FragmentManager supportFragmentManager;
        FragmentActivity context = view.getContext();
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? context : null;
        if (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null) {
            return;
        }
        AgentContentBlock.ToolcallGroup toolcallGroup = (AgentContentBlock.ToolcallGroup) agentContentBlock;
        ProcessDetailBottomSheet.INSTANCE.showToolList(supportFragmentManager, toolcallGroup);
        List<ParsedToolCallInfo> toolcalls = toolcallGroup.getToolcalls();
        boolean z = false;
        if (!(toolcalls instanceof Collection) || !toolcalls.isEmpty()) {
            Iterator<T> it = toolcalls.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ParsedToolCallInfo parsedToolCallInfo = (ParsedToolCallInfo) it.next();
                if (StringsKt.equals(parsedToolCallInfo.getName(), "TodoWrite", true) || StringsKt.equals(parsedToolCallInfo.getName(), "todo_write", true)) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            IApplog.Companion companion = IApplog.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DBData.FIELD_TYPE, "todo");
            Unit unit = Unit.INSTANCE;
            companion.reportEvent("icube_tab_click", jSONObject);
        }
    }

    public void onViewRecycled(ChildViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 3) {
            PureShowWidgetToolcallGroupRenderer pureShowWidgetToolcallGroupRenderer = this.pureShowWidgetRenderer;
            View view = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "itemView");
            pureShowWidgetToolcallGroupRenderer.release$conversation_mainlandRelease(view);
        } else if (itemViewType == 4) {
            View view2 = holder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "itemView");
            releasePureShowWidgetInlineViews(view2);
            View view3 = holder.itemView;
            ViewGroup viewGroup = view3 instanceof ViewGroup ? (ViewGroup) view3 : null;
            if (viewGroup != null) {
                viewGroup.removeAllViews();
            }
        }
        super.onViewRecycled(holder);
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

    /* JADX WARN: Multi-variable type inference failed */
    private final View createThoughtView(Context context, float density) {
        int i = (int) (2 * density);
        SimpleMarkdownTextView simpleMarkdownTextView = new SimpleMarkdownTextView(context, null, 0, 6, null);
        simpleMarkdownTextView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
        simpleMarkdownTextView.setTextSize(2, 15.0f);
        TextViewCompat.setLineHeight((TextView) simpleMarkdownTextView, (int) (22 * density));
        simpleMarkdownTextView.setPadding(0, i, 0, i);
        simpleMarkdownTextView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return (View) simpleMarkdownTextView;
    }

    private final View createSubAgentRow(Context context, float density) {
        int i = (int) (3 * density);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(0, i, 0, i);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams) new RecyclerView.LayoutParams(-1, -2));
        int i2 = (int) (16 * density);
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(C0637R.drawable.agent);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        int i3 = (int) (4 * density);
        layoutParams.setMarginEnd(i3);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(context);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
        textView.setTextSize(2, 15.0f);
        TextViewCompat.setLineHeight(textView, (int) (22 * density));
        textView.setLetterSpacing(-0.019f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setCompoundDrawablePadding(i3);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, C0637R.drawable.chevron_right, 0);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        return linearLayout;
    }

    private final View createArrowRow(Context context, float density) {
        int i = (int) (3 * density);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setPadding(0, i, 0, i);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams) new RecyclerView.LayoutParams(-1, -2));
        TextView textView = new TextView(context);
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
        textView.setTextSize(2, 15.0f);
        TextViewCompat.setLineHeight(textView, (int) (22 * density));
        textView.setLetterSpacing(-0.019f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setCompoundDrawablePadding((int) (4 * density));
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, C0637R.drawable.chevron_right, 0);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        return linearLayout;
    }

    /* compiled from: TodoChildAdapter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/TodoChildAdapter$ChildViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ChildViewHolder extends RecyclerView.ViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChildViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }
}
