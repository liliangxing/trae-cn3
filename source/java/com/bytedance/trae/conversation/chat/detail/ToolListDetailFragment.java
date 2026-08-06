package com.bytedance.trae.conversation.chat.detail;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.ConversationActivity;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.toolcall.PlanItemContext;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCardFactory;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.service.Conversation;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ToolListDetailFragment.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J(\u0010\u0016\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "toolListContainer", "Landroid/widget/LinearLayout;", "blockKey", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "renderBlock", "block", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "renderToolcallList", "children", "", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "renderSingleTool", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;", "buildPlanItemContextFromGroup", "group", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;", "buildPlanItemContext", "planItemId", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ToolListDetailFragment extends Fragment {
    private static final String ARG_BLOCK_KEY = "block_key";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String blockKey = "";
    private LinearLayout toolListContainer;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.trae_fragment_tool_list_detail, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.toolListContainer = (LinearLayout) view.findViewById(C0637R.id.ll_tool_list);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_BLOCK_KEY) : null;
        if (string == null) {
            string = "";
        }
        this.blockKey = string;
        AgentContentBlock agentContentBlock = DetailBlockStore.INSTANCE.get(this.blockKey);
        if (agentContentBlock != null) {
            renderBlock(agentContentBlock);
        }
    }

    private final void renderBlock(AgentContentBlock block) {
        LinearLayout linearLayout = this.toolListContainer;
        if (linearLayout == null) {
            return;
        }
        linearLayout.removeAllViews();
        if (block instanceof AgentContentBlock.ToolcallGroup) {
            AgentContentBlock.ToolcallGroup toolcallGroup = (AgentContentBlock.ToolcallGroup) block;
            renderToolcallList(linearLayout, toolcallGroup.getChildren(), buildPlanItemContextFromGroup(toolcallGroup));
        } else if (block instanceof AgentContentBlock.Toolcall) {
            renderSingleTool(linearLayout, (AgentContentBlock.Toolcall) block);
        }
    }

    private final void renderToolcallList(LinearLayout container, List<? extends AgentContentBlock> children, PlanItemContext planItemContext) {
        PlanItemContext planItemContext2;
        for (AgentContentBlock agentContentBlock : children) {
            if (agentContentBlock instanceof AgentContentBlock.Toolcall) {
                if (planItemContext == null || (planItemContext2 = PlanItemContext.copy$default(planItemContext, null, null, null, null, null, ((AgentContentBlock.Toolcall) agentContentBlock).getConfirmInfo(), null, 95, null)) == null) {
                    planItemContext2 = new PlanItemContext(null, null, null, null, null, ((AgentContentBlock.Toolcall) agentContentBlock).getConfirmInfo(), null, 95, null);
                }
                ToolDetailCardFactory toolDetailCardFactory = ToolDetailCardFactory.INSTANCE;
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                ToolDetailCard createDetailCard = toolDetailCardFactory.createDetailCard(requireContext, ((AgentContentBlock.Toolcall) agentContentBlock).getToolCallInfo(), planItemContext2);
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                ToolItemView toolItemView = new ToolItemView(requireContext2);
                toolItemView.bind(createDetailCard);
                container.addView(toolItemView);
            } else if (agentContentBlock instanceof AgentContentBlock.Thinking) {
                AgentContentBlock.Thinking thinking = (AgentContentBlock.Thinking) agentContentBlock;
                PlanItemContext planItemContext3 = new PlanItemContext(thinking.getPlanItemId(), null, null, null, null, null, thinking.getReasoningContent(), 62, null);
                ToolDetailCardFactory toolDetailCardFactory2 = ToolDetailCardFactory.INSTANCE;
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext(...)");
                ParsedToolCallInfo toolCallInfo = thinking.getToolCallInfo();
                if (toolCallInfo == null) {
                    toolCallInfo = new ParsedToolCallInfo(null, null, null, null, null, 31, null);
                }
                ToolDetailCard createThinkingCard = toolDetailCardFactory2.createThinkingCard(requireContext3, toolCallInfo, planItemContext3);
                Context requireContext4 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext(...)");
                ToolItemView toolItemView2 = new ToolItemView(requireContext4);
                toolItemView2.bind(createThinkingCard);
                container.addView(toolItemView2);
            } else if (agentContentBlock instanceof AgentContentBlock.ToolcallGroup) {
                renderToolcallList(container, ((AgentContentBlock.ToolcallGroup) agentContentBlock).getChildren(), planItemContext);
            } else if (agentContentBlock instanceof AgentContentBlock.TodoGroup) {
                renderToolcallList(container, ((AgentContentBlock.TodoGroup) agentContentBlock).getChildren(), planItemContext);
            }
        }
    }

    private final void renderSingleTool(LinearLayout container, AgentContentBlock.Toolcall block) {
        PlanItemContext copy$default = PlanItemContext.copy$default(buildPlanItemContext(block.getPlanItemId()), null, null, null, null, null, block.getConfirmInfo(), null, 95, null);
        ToolDetailCardFactory toolDetailCardFactory = ToolDetailCardFactory.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        ToolDetailCard createDetailCard = toolDetailCardFactory.createDetailCard(requireContext, block.getToolCallInfo(), copy$default);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
        ToolItemView toolItemView = new ToolItemView(requireContext2);
        toolItemView.bind(createDetailCard);
        container.addView(toolItemView);
    }

    private final PlanItemContext buildPlanItemContextFromGroup(AgentContentBlock.ToolcallGroup group) {
        List<AgentContentBlock> children = group.getChildren();
        ArrayList arrayList = new ArrayList();
        for (Object obj : children) {
            if (obj instanceof AgentContentBlock.Toolcall) {
                arrayList.add(obj);
            }
        }
        AgentContentBlock.Toolcall toolcall = (AgentContentBlock.Toolcall) CollectionsKt.firstOrNull(arrayList);
        if (toolcall == null) {
            return null;
        }
        return buildPlanItemContext(toolcall.getPlanItemId());
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002c, code lost:
    
        if (r1 != null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final PlanItemContext buildPlanItemContext(String planItemId) {
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
        return new PlanItemContext(planItemId, null, null, id, conversation != null ? conversation.getEnvironment() : null, null, null, 102, null);
    }

    /* compiled from: ToolListDetailFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment$Companion;", "", "<init>", "()V", "ARG_BLOCK_KEY", "", "newInstance", "Lcom/bytedance/trae/conversation/chat/detail/ToolListDetailFragment;", "blockKey", "block", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ToolListDetailFragment newInstance(String blockKey) {
            Intrinsics.checkNotNullParameter(blockKey, "blockKey");
            ToolListDetailFragment toolListDetailFragment = new ToolListDetailFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ToolListDetailFragment.ARG_BLOCK_KEY, blockKey);
            toolListDetailFragment.setArguments(bundle);
            return toolListDetailFragment;
        }

        public final ToolListDetailFragment newInstance(AgentContentBlock.ToolcallGroup block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return newInstance(DetailBlockStore.INSTANCE.put(block));
        }

        public final ToolListDetailFragment newInstance(AgentContentBlock.Toolcall block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return newInstance(DetailBlockStore.INSTANCE.put(block));
        }
    }
}
