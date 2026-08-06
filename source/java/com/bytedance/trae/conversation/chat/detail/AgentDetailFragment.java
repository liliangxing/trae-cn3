package com.bytedance.trae.conversation.chat.detail;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.ConversationActivity;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.MarkdownHelper;
import com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView;
import com.bytedance.trae.conversation.chat.detail.DetailSegment;
import com.bytedance.trae.conversation.chat.toolcall.PlanItemContext;
import com.bytedance.trae.im.service.Conversation;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AgentDetailFragment.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "agentHeaderContainer", "Landroid/widget/FrameLayout;", "contentContainer", "Landroid/widget/LinearLayout;", "blockKey", "", "expandedSegments", "", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "renderAgentDetail", "block", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;", "renderHeader", "renderContent", "createThoughtView", "thought", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thought;", "createSubAgentRow", "buildPlanItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AgentDetailFragment extends Fragment {
    private static final String ARG_BLOCK_KEY = "block_key";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FrameLayout agentHeaderContainer;
    private LinearLayout contentContainer;
    private String blockKey = "";
    private final Set<Integer> expandedSegments = new LinkedHashSet();

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.trae_fragment_agent_detail, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.agentHeaderContainer = (FrameLayout) view.findViewById(C0637R.id.fl_agent_header);
        this.contentContainer = (LinearLayout) view.findViewById(C0637R.id.ll_content);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_BLOCK_KEY) : null;
        if (string == null) {
            string = "";
        }
        this.blockKey = string;
        AgentContentBlock agentContentBlock = DetailBlockStore.INSTANCE.get(this.blockKey);
        AgentContentBlock.SubAgentGroup subAgentGroup = (AgentContentBlock.SubAgentGroup) (agentContentBlock instanceof AgentContentBlock.SubAgentGroup ? agentContentBlock : null);
        if (subAgentGroup == null) {
            return;
        }
        renderAgentDetail(subAgentGroup);
    }

    private final void renderAgentDetail(AgentContentBlock.SubAgentGroup block) {
        renderHeader(block);
        renderContent(block);
    }

    private final void renderHeader(AgentContentBlock.SubAgentGroup block) {
        FrameLayout frameLayout = this.agentHeaderContainer;
        if (frameLayout == null) {
            return;
        }
        frameLayout.removeAllViews();
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        AgentHeaderView agentHeaderView = new AgentHeaderView(requireContext);
        agentHeaderView.bind(block.getAgentDisplayName(), block.getDescription(), block.getAgentId());
        frameLayout.addView(agentHeaderView);
    }

    private final void renderContent(AgentContentBlock.SubAgentGroup block) {
        LinearLayout linearLayout = this.contentContainer;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        List<DetailSegment> segment = DetailSegmenter.INSTANCE.segment(block.getChildren());
        PlanItemContext buildPlanItemContext = buildPlanItemContext(block);
        final int i = 0;
        for (DetailSegment detailSegment : segment) {
            if (detailSegment instanceof DetailSegment.ToolSegment) {
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                CollapsibleToolSegmentView collapsibleToolSegmentView = new CollapsibleToolSegmentView(requireContext);
                collapsibleToolSegmentView.bind((DetailSegment.ToolSegment) detailSegment, buildPlanItemContext, this.expandedSegments.contains(Integer.valueOf(i)), new Function1() { // from class: com.bytedance.trae.conversation.chat.detail.AgentDetailFragment$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        Unit renderContent$lambda$0;
                        renderContent$lambda$0 = AgentDetailFragment.renderContent$lambda$0(AgentDetailFragment.this, i, ((Boolean) obj).booleanValue());
                        return renderContent$lambda$0;
                    }
                });
                linearLayout.addView(collapsibleToolSegmentView);
                i++;
            } else if (detailSegment instanceof DetailSegment.ThoughtSegment) {
                linearLayout.addView(createThoughtView(((DetailSegment.ThoughtSegment) detailSegment).getThought()));
            } else {
                if (!(detailSegment instanceof DetailSegment.SubAgentSegment)) {
                    throw new NoWhenBranchMatchedException();
                }
                linearLayout.addView(createSubAgentRow(((DetailSegment.SubAgentSegment) detailSegment).getSubAgent()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit renderContent$lambda$0(AgentDetailFragment agentDetailFragment, int i, boolean z) {
        if (z) {
            agentDetailFragment.expandedSegments.add(Integer.valueOf(i));
        } else {
            agentDetailFragment.expandedSegments.remove(Integer.valueOf(i));
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final View createThoughtView(AgentContentBlock.Thought thought) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        float f = requireContext.getResources().getDisplayMetrics().density;
        SimpleMarkdownTextView simpleMarkdownTextView = new SimpleMarkdownTextView(requireContext, null, 0, 6, null);
        simpleMarkdownTextView.setTextColor(ContextCompat.getColor(requireContext, C0591R.color.trae_text_text_default));
        simpleMarkdownTextView.setTextSize(2, 15.0f);
        simpleMarkdownTextView.setLineSpacing(0.0f, 1.4f);
        simpleMarkdownTextView.setMovementMethod(LinkMovementMethod.getInstance());
        int i = (int) (8 * f);
        simpleMarkdownTextView.setPadding(0, i, 0, i);
        simpleMarkdownTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        MarkdownHelper.setMarkdownContent$default(MarkdownHelper.INSTANCE, simpleMarkdownTextView, thought.getThought(), true, null, 8, null);
        return (View) simpleMarkdownTextView;
    }

    private final View createSubAgentRow(final AgentContentBlock.SubAgentGroup block) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        float f = requireContext.getResources().getDisplayMetrics().density;
        LinearLayout linearLayout = new LinearLayout(requireContext);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int i = (int) (10 * f);
        linearLayout.setPadding(0, i, 0, i);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(requireContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(AgentAvatarHelper.INSTANCE.getAvatarResId(block.getAgentId()));
        int i2 = (int) (24 * f);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(i2, i2));
        TextView textView = new TextView(requireContext);
        String agentDisplayName = block.getAgentDisplayName();
        if (agentDisplayName == null) {
            agentDisplayName = getString(C0637R.string.trae_chat_sub_agent_default);
            Intrinsics.checkNotNullExpressionValue(agentDisplayName, "getString(...)");
        }
        textView.setText(agentDisplayName);
        textView.setTextColor(ContextCompat.getColor(requireContext, C0591R.color.trae_text_text_default));
        textView.setTextSize(2, 14.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart((int) (6 * f));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(requireContext);
        textView2.setText("›");
        textView2.setTextColor(ContextCompat.getColor(requireContext, C0591R.color.trae_text_text_tertiary));
        textView2.setTextSize(2, 16.0f);
        linearLayout.addView(textView2);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.detail.AgentDetailFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AgentDetailFragment.createSubAgentRow$lambda$7(AgentDetailFragment.this, block, view);
            }
        });
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createSubAgentRow$lambda$7(AgentDetailFragment agentDetailFragment, AgentContentBlock.SubAgentGroup subAgentGroup, View view) {
        ProcessDetailBottomSheet parentFragment = agentDetailFragment.getParentFragment();
        ProcessDetailBottomSheet processDetailBottomSheet = parentFragment instanceof ProcessDetailBottomSheet ? parentFragment : null;
        if (processDetailBottomSheet == null) {
            return;
        }
        processDetailBottomSheet.navigateTo(INSTANCE.newInstance(subAgentGroup));
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
    
        if (r1 != null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final PlanItemContext buildPlanItemContext(AgentContentBlock.SubAgentGroup block) {
        String id;
        Serializable serializableExtra = requireActivity().getIntent().getSerializableExtra(ConversationActivity.EXTRA_CONVERSATION);
        Conversation conversation = serializableExtra instanceof Conversation ? (Conversation) serializableExtra : null;
        if (conversation != null && (id = conversation.getCliConversationId()) != null) {
            if (!(!StringsKt.isBlank(id))) {
                id = null;
            }
        }
        id = conversation != null ? conversation.getId() : null;
        if (id == null) {
            id = requireActivity().getIntent().getStringExtra(ConversationActivity.EXTRA_CONVERSATION_ID);
        }
        return new PlanItemContext(null, block.getAgentId(), block.getAgentRunId(), id, conversation != null ? conversation.getEnvironment() : null, null, null, 97, null);
    }

    /* compiled from: AgentDetailFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment$Companion;", "", "<init>", "()V", "ARG_BLOCK_KEY", "", "newInstance", "Lcom/bytedance/trae/conversation/chat/detail/AgentDetailFragment;", "blockKey", "block", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AgentDetailFragment newInstance(String blockKey) {
            Intrinsics.checkNotNullParameter(blockKey, "blockKey");
            AgentDetailFragment agentDetailFragment = new AgentDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(AgentDetailFragment.ARG_BLOCK_KEY, blockKey);
            agentDetailFragment.setArguments(bundle);
            return agentDetailFragment;
        }

        public final AgentDetailFragment newInstance(AgentContentBlock.SubAgentGroup block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return newInstance(DetailBlockStore.INSTANCE.put(block));
        }
    }
}
