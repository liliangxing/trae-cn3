package com.bytedance.trae.conversation.chat.detail;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.ConversationActivity;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.detail.ToolListFragment;
import com.bytedance.trae.conversation.chat.toolcall.PlanItemContext;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCardFactory;
import com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.conversation.widget.ShimmerTextView;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.ParsedToolCallResult;
import com.bytedance.trae.im.service.Conversation;
import com.bytedance.trae.utils.logger.FLogger;
import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* compiled from: ToolListFragment.kt */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u000f\u0018\u0000 72\u00020\u0001:\u00044567B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016J\u0010\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J.\u0010 \u001a\u00020\u001a2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001f0\"2\b\u0010#\u001a\u0004\u0018\u00010$2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001c\u0010+\u001a\u00020\u001a2\n\u0010,\u001a\u00060-j\u0002`.2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010$2\u0006\u00100\u001a\u000201H\u0002J\u0012\u00102\u001a\u00020$2\b\u00103\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u00068"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "blockKey", "", "adapter", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;", "items", "", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem;", "lastFingerprint", "pollHandler", "Landroid/os/Handler;", "pollRunnable", "com/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$pollRunnable$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "flattenBlock", "block", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "flattenChildren", "children", "", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "isBlockRunning", "", "isToolCallRunning", "info", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "computeFingerprint", "appendBlockFingerprint", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "buildPlanItemContextFromGroup", "group", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;", "buildPlanItemContext", "planItemId", "ToolCategory", "ToolListItem", "ToolListAdapter", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ToolListFragment extends Fragment {
    private static final String ARG_BLOCK_KEY = "block_key";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long POLL_INTERVAL_MS = 1000;
    private static final String TOOL_TAG = "AgentTool";
    private ToolListAdapter adapter;
    private String blockKey = "";
    private final List<ToolListItem> items = new ArrayList();
    private String lastFingerprint = "";
    private final Handler pollHandler = new Handler(Looper.getMainLooper());
    private final ToolListFragment$pollRunnable$1 pollRunnable = new Runnable() { // from class: com.bytedance.trae.conversation.chat.detail.ToolListFragment$pollRunnable$1
        @Override // java.lang.Runnable
        public void run() {
            String str;
            String computeFingerprint;
            String str2;
            boolean isBlockRunning;
            Handler handler;
            List list;
            ToolListFragment.ToolListAdapter toolListAdapter;
            String str3;
            DetailBlockStore detailBlockStore = DetailBlockStore.INSTANCE;
            str = ToolListFragment.this.blockKey;
            AgentContentBlock agentContentBlock = detailBlockStore.get(str);
            if (agentContentBlock != null) {
                computeFingerprint = ToolListFragment.this.computeFingerprint(agentContentBlock);
                str2 = ToolListFragment.this.lastFingerprint;
                if (!Intrinsics.areEqual(computeFingerprint, str2)) {
                    ToolListFragment.this.lastFingerprint = computeFingerprint;
                    ToolListFragment.this.flattenBlock(agentContentBlock);
                    FLogger fLogger = FLogger.INSTANCE;
                    StringBuilder sb = new StringBuilder("[ToolList] poll: data changed, items=");
                    list = ToolListFragment.this.items;
                    fLogger.d("AgentTool", sb.append(list.size()).toString());
                    toolListAdapter = ToolListFragment.this.adapter;
                    if (toolListAdapter != null) {
                        toolListAdapter.notifyDataSetChanged();
                    }
                }
                isBlockRunning = ToolListFragment.this.isBlockRunning(agentContentBlock);
                if (isBlockRunning) {
                    handler = ToolListFragment.this.pollHandler;
                    handler.postDelayed(this, 1000L);
                    return;
                } else {
                    FLogger.INSTANCE.i("AgentTool", "[ToolList] poll: block finished, stop polling");
                    return;
                }
            }
            ToolListFragment toolListFragment = ToolListFragment.this;
            FLogger fLogger2 = FLogger.INSTANCE;
            StringBuilder sb2 = new StringBuilder("[ToolList] poll: block not found for key=");
            str3 = toolListFragment.blockKey;
            fLogger2.w("AgentTool", sb2.append(str3).toString());
        }
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(C0637R.layout.trae_fragment_tool_list, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_BLOCK_KEY) : null;
        if (string == null) {
            string = "";
        }
        this.blockKey = string;
        AgentContentBlock agentContentBlock = DetailBlockStore.INSTANCE.get(this.blockKey);
        if (agentContentBlock == null) {
            FLogger.INSTANCE.w("AgentTool", "[ToolList] onViewCreated: block not found for key=" + this.blockKey);
            return;
        }
        FLogger.INSTANCE.i("AgentTool", "[ToolList] onViewCreated: blockKey=" + this.blockKey + ", blockType=" + Reflection.getOrCreateKotlinClass(agentContentBlock.getClass()).getSimpleName());
        RecyclerView findViewById = view.findViewById(C0637R.id.rv_tool_list);
        findViewById.setLayoutManager(new LinearLayoutManager(requireContext()));
        findViewById.setItemAnimator((RecyclerView.ItemAnimator) null);
        flattenBlock(agentContentBlock);
        this.lastFingerprint = computeFingerprint(agentContentBlock);
        ToolListAdapter toolListAdapter = new ToolListAdapter(this, this.items);
        this.adapter = toolListAdapter;
        findViewById.setAdapter(toolListAdapter);
        FLogger.INSTANCE.i("AgentTool", "[ToolList] onViewCreated: items=" + this.items.size() + ", start polling");
        this.pollHandler.postDelayed(this.pollRunnable, 1000L);
    }

    public void onDestroyView() {
        FLogger.INSTANCE.i("AgentTool", "[ToolList] onDestroyView: blockKey=" + this.blockKey + ", stop polling");
        this.pollHandler.removeCallbacks(this.pollRunnable);
        this.adapter = null;
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flattenBlock(AgentContentBlock block) {
        PlanItemContext buildPlanItemContext;
        PlanItemContext planItemContext;
        boolean z = block instanceof AgentContentBlock.ToolcallGroup;
        if (z) {
            buildPlanItemContext = buildPlanItemContextFromGroup((AgentContentBlock.ToolcallGroup) block);
        } else {
            buildPlanItemContext = block instanceof AgentContentBlock.Toolcall ? buildPlanItemContext(((AgentContentBlock.Toolcall) block).getPlanItemId()) : null;
        }
        PlanItemContext planItemContext2 = buildPlanItemContext;
        this.items.clear();
        if (z) {
            flattenChildren(((AgentContentBlock.ToolcallGroup) block).getChildren(), planItemContext2, this.items);
        } else if (block instanceof AgentContentBlock.Toolcall) {
            if (planItemContext2 == null || (planItemContext = PlanItemContext.copy$default(planItemContext2, null, null, null, null, null, ((AgentContentBlock.Toolcall) block).getConfirmInfo(), null, 95, null)) == null) {
                planItemContext = new PlanItemContext(null, null, null, null, null, ((AgentContentBlock.Toolcall) block).getConfirmInfo(), null, 95, null);
            }
            this.items.add(new ToolListItem.Tool(((AgentContentBlock.Toolcall) block).getToolCallInfo(), planItemContext));
        }
    }

    private final void flattenChildren(List<? extends AgentContentBlock> children, PlanItemContext planItemContext, List<ToolListItem> items) {
        PlanItemContext planItemContext2;
        for (AgentContentBlock agentContentBlock : children) {
            if (agentContentBlock instanceof AgentContentBlock.Toolcall) {
                if (planItemContext == null || (planItemContext2 = PlanItemContext.copy$default(planItemContext, null, null, null, null, null, ((AgentContentBlock.Toolcall) agentContentBlock).getConfirmInfo(), null, 95, null)) == null) {
                    planItemContext2 = new PlanItemContext(null, null, null, null, null, ((AgentContentBlock.Toolcall) agentContentBlock).getConfirmInfo(), null, 95, null);
                }
                items.add(new ToolListItem.Tool(((AgentContentBlock.Toolcall) agentContentBlock).getToolCallInfo(), planItemContext2));
            } else if (agentContentBlock instanceof AgentContentBlock.Thinking) {
                AgentContentBlock.Thinking thinking = (AgentContentBlock.Thinking) agentContentBlock;
                ParsedToolCallInfo toolCallInfo = thinking.getToolCallInfo();
                if (toolCallInfo == null) {
                    toolCallInfo = new ParsedToolCallInfo(null, null, null, null, null, 31, null);
                }
                items.add(new ToolListItem.Thinking(thinking, toolCallInfo));
            } else if (agentContentBlock instanceof AgentContentBlock.ToolcallGroup) {
                flattenChildren(((AgentContentBlock.ToolcallGroup) agentContentBlock).getChildren(), planItemContext, items);
            } else if (agentContentBlock instanceof AgentContentBlock.TodoGroup) {
                flattenChildren(((AgentContentBlock.TodoGroup) agentContentBlock).getChildren(), planItemContext, items);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBlockRunning(AgentContentBlock block) {
        if (block instanceof AgentContentBlock.ToolcallGroup) {
            List<AgentContentBlock> children = ((AgentContentBlock.ToolcallGroup) block).getChildren();
            if (!(children instanceof Collection) || !children.isEmpty()) {
                Iterator<T> it = children.iterator();
                while (it.hasNext()) {
                    if (isBlockRunning((AgentContentBlock) it.next())) {
                        return true;
                    }
                }
            }
        } else if (block instanceof AgentContentBlock.TodoGroup) {
            if (((AgentContentBlock.TodoGroup) block).getStatus() == AgentContentBlock.GroupStatus.RUNNING) {
                return true;
            }
        } else {
            if (block instanceof AgentContentBlock.Toolcall) {
                return isToolCallRunning(((AgentContentBlock.Toolcall) block).getToolCallInfo());
            }
            if (block instanceof AgentContentBlock.Thinking) {
                AgentContentBlock.Thinking thinking = (AgentContentBlock.Thinking) block;
                if (thinking.getToolCallInfo() == null || isToolCallRunning(thinking.getToolCallInfo())) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isToolCallRunning(ParsedToolCallInfo info) {
        ParsedToolCallResult result = info.getResult();
        String status = result != null ? result.getStatus() : null;
        return status == null || Intrinsics.areEqual(status, "pending") || Intrinsics.areEqual(status, "running");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String computeFingerprint(AgentContentBlock block) {
        StringBuilder sb = new StringBuilder();
        appendBlockFingerprint(sb, block);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    private final void appendBlockFingerprint(StringBuilder sb, AgentContentBlock block) {
        List<String> blockCommandList;
        JsonObject data;
        if (block instanceof AgentContentBlock.Toolcall) {
            AgentContentBlock.Toolcall toolcall = (AgentContentBlock.Toolcall) block;
            ParsedToolCallInfo toolCallInfo = toolcall.getToolCallInfo();
            StringBuilder append = sb.append("TC|").append(toolCallInfo.getId()).append('|').append(toolCallInfo.getName()).append('|');
            ParsedToolCallResult result = toolCallInfo.getResult();
            StringBuilder append2 = append.append(result != null ? result.getStatus() : null).append('|');
            JsonObject params = toolCallInfo.getParams();
            int i = 0;
            StringBuilder append3 = append2.append(params != null ? params.hashCode() : 0).append('|');
            ParsedToolCallResult result2 = toolCallInfo.getResult();
            StringBuilder append4 = append3.append((result2 == null || (data = result2.getData()) == null) ? 0 : data.hashCode()).append('|');
            ConfirmInfo confirmInfo = toolcall.getConfirmInfo();
            StringBuilder append5 = append4.append(confirmInfo != null ? confirmInfo.getConfirmStatus() : null).append('|');
            ConfirmInfo confirmInfo2 = toolcall.getConfirmInfo();
            StringBuilder append6 = append5.append(confirmInfo2 != null ? confirmInfo2.getBlockLevel() : null).append('|');
            ConfirmInfo confirmInfo3 = toolcall.getConfirmInfo();
            if (confirmInfo3 != null && (blockCommandList = confirmInfo3.getBlockCommandList()) != null) {
                i = blockCommandList.hashCode();
            }
            append6.append(i).append(';');
            return;
        }
        if (block instanceof AgentContentBlock.Thinking) {
            AgentContentBlock.Thinking thinking = (AgentContentBlock.Thinking) block;
            sb.append("TH|").append(thinking.getPlanItemId()).append('|').append(thinking.getReasoningContent().length()).append('|');
            ParsedToolCallInfo toolCallInfo2 = thinking.getToolCallInfo();
            if (toolCallInfo2 != null) {
                StringBuilder append7 = sb.append(toolCallInfo2.getId()).append('|').append(toolCallInfo2.getName()).append('|');
                ParsedToolCallResult result3 = toolCallInfo2.getResult();
                append7.append(result3 != null ? result3.getStatus() : null);
            }
            sb.append(';');
            return;
        }
        if (block instanceof AgentContentBlock.ToolcallGroup) {
            AgentContentBlock.ToolcallGroup toolcallGroup = (AgentContentBlock.ToolcallGroup) block;
            sb.append("TG|").append(toolcallGroup.getTitle()).append('|').append(toolcallGroup.getChildren().size()).append('{');
            Iterator<AgentContentBlock> it = toolcallGroup.getChildren().iterator();
            while (it.hasNext()) {
                appendBlockFingerprint(sb, it.next());
            }
            sb.append('}');
            return;
        }
        if (block instanceof AgentContentBlock.TodoGroup) {
            AgentContentBlock.TodoGroup todoGroup = (AgentContentBlock.TodoGroup) block;
            sb.append("TD|").append(todoGroup.getTodoWriteId()).append('|').append(todoGroup.getStatus()).append('|').append(todoGroup.getChildren().size()).append('{');
            Iterator<AgentContentBlock> it2 = todoGroup.getChildren().iterator();
            while (it2.hasNext()) {
                appendBlockFingerprint(sb, it2.next());
            }
            sb.append('}');
            return;
        }
        sb.append("OTHER;");
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: ToolListFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;", "", "<init>", "(Ljava/lang/String;I)V", "EDIT_FILE", "CREATE_FILE", "VIEW_FILE", "CODE_SEARCH", "WEB_SEARCH", "RUN_COMMAND", "TODO_LIST", "BROWSER", "OPEN_PREVIEW", "MCP", "SKILL", "ASK_USER", "THINKING", "ENVIRONMENT_SETUP", "IMAGE_GENERATE", "FALLBACK", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ToolCategory {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ToolCategory[] $VALUES;
        private static final Set<String> ASK_USER_NAMES;
        private static final Set<String> CODE_SEARCH_NAMES;
        private static final Set<String> CREATE_FILE_NAMES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private static final Set<String> EDIT_FILE_NAMES;
        private static final Set<String> ENVIRONMENT_SETUP_NAMES;
        private static final Set<String> IMAGE_GENERATE_NAMES;
        private static final Set<String> MCP_NAMES;
        private static final Set<String> OPEN_PREVIEW_NAMES;
        private static final Set<String> RUN_COMMAND_NAMES;
        private static final Set<String> SKILL_NAMES;
        private static final Set<String> TODO_NAMES;
        private static final Set<String> VIEW_FILE_NAMES;
        private static final Set<String> WEB_SEARCH_NAMES;
        public static final ToolCategory EDIT_FILE = new ToolCategory("EDIT_FILE", 0);
        public static final ToolCategory CREATE_FILE = new ToolCategory("CREATE_FILE", 1);
        public static final ToolCategory VIEW_FILE = new ToolCategory("VIEW_FILE", 2);
        public static final ToolCategory CODE_SEARCH = new ToolCategory("CODE_SEARCH", 3);
        public static final ToolCategory WEB_SEARCH = new ToolCategory("WEB_SEARCH", 4);
        public static final ToolCategory RUN_COMMAND = new ToolCategory("RUN_COMMAND", 5);
        public static final ToolCategory TODO_LIST = new ToolCategory("TODO_LIST", 6);
        public static final ToolCategory BROWSER = new ToolCategory("BROWSER", 7);
        public static final ToolCategory OPEN_PREVIEW = new ToolCategory("OPEN_PREVIEW", 8);
        public static final ToolCategory MCP = new ToolCategory("MCP", 9);
        public static final ToolCategory SKILL = new ToolCategory("SKILL", 10);
        public static final ToolCategory ASK_USER = new ToolCategory("ASK_USER", 11);
        public static final ToolCategory THINKING = new ToolCategory("THINKING", 12);
        public static final ToolCategory ENVIRONMENT_SETUP = new ToolCategory("ENVIRONMENT_SETUP", 13);
        public static final ToolCategory IMAGE_GENERATE = new ToolCategory("IMAGE_GENERATE", 14);
        public static final ToolCategory FALLBACK = new ToolCategory("FALLBACK", 15);

        private static final /* synthetic */ ToolCategory[] $values() {
            return new ToolCategory[]{EDIT_FILE, CREATE_FILE, VIEW_FILE, CODE_SEARCH, WEB_SEARCH, RUN_COMMAND, TODO_LIST, BROWSER, OPEN_PREVIEW, MCP, SKILL, ASK_USER, THINKING, ENVIRONMENT_SETUP, IMAGE_GENERATE, FALLBACK};
        }

        public static EnumEntries<ToolCategory> getEntries() {
            return $ENTRIES;
        }

        private ToolCategory(String str, int i) {
        }

        static {
            ToolCategory[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
            EDIT_FILE_NAMES = SetsKt.setOf(new String[]{"edit_file_search_replace", "Write", "Edit", "MultiEdit", "SearchReplace", "edit_file", "write_to_file", "edit_file_update", "delete_file", "DeleteFile"});
            CREATE_FILE_NAMES = SetsKt.setOf("create_file");
            VIEW_FILE_NAMES = SetsKt.setOf(new String[]{"view_file", "Read", "LS", "view_files", "view_folder"});
            CODE_SEARCH_NAMES = SetsKt.setOf(new String[]{"file_search", "Glob", "search_codebase", "SearchCodebase", "search_by_regex", "Grep"});
            WEB_SEARCH_NAMES = SetsKt.setOf(new String[]{"web_search", "WebSearch"});
            RUN_COMMAND_NAMES = SetsKt.setOf(new String[]{"run_command", "RunCommand", "Shell", "exec_command"});
            TODO_NAMES = SetsKt.setOf(new String[]{"todo_write", "TodoWrite"});
            OPEN_PREVIEW_NAMES = SetsKt.setOf(new String[]{"open_preview", "OpenPreview", "open_preview_and_wait_for_error", "open_folder"});
            MCP_NAMES = SetsKt.setOf(new String[]{"run_mcp", "mcp_call", "MCPCall"});
            SKILL_NAMES = SetsKt.setOf("Skill");
            ASK_USER_NAMES = SetsKt.setOf("AskUserQuestion");
            ENVIRONMENT_SETUP_NAMES = SetsKt.setOf(new String[]{"environment_setup", "EnvironmentSetup"});
            IMAGE_GENERATE_NAMES = SetsKt.setOf(new String[]{"image_ocr", "GenerateImage"});
        }

        /* compiled from: ToolListFragment.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory$Companion;", "", "<init>", "()V", "EDIT_FILE_NAMES", "", "", "CREATE_FILE_NAMES", "VIEW_FILE_NAMES", "CODE_SEARCH_NAMES", "WEB_SEARCH_NAMES", "RUN_COMMAND_NAMES", "TODO_NAMES", "OPEN_PREVIEW_NAMES", "MCP_NAMES", "SKILL_NAMES", "ASK_USER_NAMES", "ENVIRONMENT_SETUP_NAMES", "IMAGE_GENERATE_NAMES", "fromToolName", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;", "name", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final ToolCategory fromToolName(String name) {
                if (name != null) {
                    if (ToolCategory.EDIT_FILE_NAMES.contains(name)) {
                        return ToolCategory.EDIT_FILE;
                    }
                    if (ToolCategory.CREATE_FILE_NAMES.contains(name)) {
                        return ToolCategory.CREATE_FILE;
                    }
                    if (ToolCategory.VIEW_FILE_NAMES.contains(name)) {
                        return ToolCategory.VIEW_FILE;
                    }
                    if (ToolCategory.CODE_SEARCH_NAMES.contains(name)) {
                        return ToolCategory.CODE_SEARCH;
                    }
                    if (ToolCategory.WEB_SEARCH_NAMES.contains(name)) {
                        return ToolCategory.WEB_SEARCH;
                    }
                    if (ToolCategory.RUN_COMMAND_NAMES.contains(name)) {
                        return ToolCategory.RUN_COMMAND;
                    }
                    if (ToolCategory.TODO_NAMES.contains(name)) {
                        return ToolCategory.TODO_LIST;
                    }
                    if (StringsKt.startsWith$default(name, "browser_", false, 2, (Object) null) || Intrinsics.areEqual(name, "BrowserHandOver") || Intrinsics.areEqual(name, "BrowserWaitingForUserInteraction")) {
                        return ToolCategory.BROWSER;
                    }
                    return ToolCategory.OPEN_PREVIEW_NAMES.contains(name) ? ToolCategory.OPEN_PREVIEW : ToolCategory.MCP_NAMES.contains(name) ? ToolCategory.MCP : ToolCategory.SKILL_NAMES.contains(name) ? ToolCategory.SKILL : ToolCategory.ASK_USER_NAMES.contains(name) ? ToolCategory.ASK_USER : ToolCategory.ENVIRONMENT_SETUP_NAMES.contains(name) ? ToolCategory.ENVIRONMENT_SETUP : ToolCategory.IMAGE_GENERATE_NAMES.contains(name) ? ToolCategory.IMAGE_GENERATE : ToolCategory.FALLBACK;
                }
                return ToolCategory.FALLBACK;
            }
        }

        public static ToolCategory valueOf(String str) {
            return (ToolCategory) Enum.valueOf(ToolCategory.class, str);
        }

        public static ToolCategory[] values() {
            return (ToolCategory[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToolListFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem;", "", "<init>", "()V", "category", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;", "getCategory", "()Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;", "Tool", "Thinking", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Thinking;", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static abstract class ToolListItem {
        public /* synthetic */ ToolListItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract ToolCategory getCategory();

        private ToolListItem() {
        }

        /* compiled from: ToolListFragment.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Tool;", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "planItemContext", "Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "<init>", "(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;)V", "getToolCallInfo", "()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "getPlanItemContext", "()Lcom/bytedance/trae/conversation/chat/toolcall/PlanItemContext;", "category", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;", "getCategory", "()Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Tool extends ToolListItem {
            private final PlanItemContext planItemContext;
            private final ParsedToolCallInfo toolCallInfo;

            public static /* synthetic */ Tool copy$default(Tool tool, ParsedToolCallInfo parsedToolCallInfo, PlanItemContext planItemContext, int i, Object obj) {
                if ((i & 1) != 0) {
                    parsedToolCallInfo = tool.toolCallInfo;
                }
                if ((i & 2) != 0) {
                    planItemContext = tool.planItemContext;
                }
                return tool.copy(parsedToolCallInfo, planItemContext);
            }

            /* renamed from: component1, reason: from getter */
            public final ParsedToolCallInfo getToolCallInfo() {
                return this.toolCallInfo;
            }

            /* renamed from: component2, reason: from getter */
            public final PlanItemContext getPlanItemContext() {
                return this.planItemContext;
            }

            public final Tool copy(ParsedToolCallInfo toolCallInfo, PlanItemContext planItemContext) {
                Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
                return new Tool(toolCallInfo, planItemContext);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Tool)) {
                    return false;
                }
                Tool tool = (Tool) other;
                return Intrinsics.areEqual(this.toolCallInfo, tool.toolCallInfo) && Intrinsics.areEqual(this.planItemContext, tool.planItemContext);
            }

            public int hashCode() {
                int hashCode = this.toolCallInfo.hashCode() * 31;
                PlanItemContext planItemContext = this.planItemContext;
                return hashCode + (planItemContext == null ? 0 : planItemContext.hashCode());
            }

            public String toString() {
                return "Tool(toolCallInfo=" + this.toolCallInfo + ", planItemContext=" + this.planItemContext + ')';
            }

            public final ParsedToolCallInfo getToolCallInfo() {
                return this.toolCallInfo;
            }

            public final PlanItemContext getPlanItemContext() {
                return this.planItemContext;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Tool(ParsedToolCallInfo parsedToolCallInfo, PlanItemContext planItemContext) {
                super(null);
                Intrinsics.checkNotNullParameter(parsedToolCallInfo, "toolCallInfo");
                this.toolCallInfo = parsedToolCallInfo;
                this.planItemContext = planItemContext;
            }

            @Override // com.bytedance.trae.conversation.chat.detail.ToolListFragment.ToolListItem
            public ToolCategory getCategory() {
                return ToolCategory.INSTANCE.fromToolName(this.toolCallInfo.getName());
            }
        }

        /* compiled from: ToolListFragment.kt */
        @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem$Thinking;", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem;", "thinking", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;", "toolCallInfo", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "<init>", "(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)V", "getThinking", "()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Thinking;", "getToolCallInfo", "()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "category", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;", "getCategory", "()Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolCategory;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Thinking extends ToolListItem {
            private final ToolCategory category;
            private final AgentContentBlock.Thinking thinking;
            private final ParsedToolCallInfo toolCallInfo;

            public static /* synthetic */ Thinking copy$default(Thinking thinking, AgentContentBlock.Thinking thinking2, ParsedToolCallInfo parsedToolCallInfo, int i, Object obj) {
                if ((i & 1) != 0) {
                    thinking2 = thinking.thinking;
                }
                if ((i & 2) != 0) {
                    parsedToolCallInfo = thinking.toolCallInfo;
                }
                return thinking.copy(thinking2, parsedToolCallInfo);
            }

            /* renamed from: component1, reason: from getter */
            public final AgentContentBlock.Thinking getThinking() {
                return this.thinking;
            }

            /* renamed from: component2, reason: from getter */
            public final ParsedToolCallInfo getToolCallInfo() {
                return this.toolCallInfo;
            }

            public final Thinking copy(AgentContentBlock.Thinking thinking, ParsedToolCallInfo toolCallInfo) {
                Intrinsics.checkNotNullParameter(thinking, "thinking");
                Intrinsics.checkNotNullParameter(toolCallInfo, "toolCallInfo");
                return new Thinking(thinking, toolCallInfo);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Thinking)) {
                    return false;
                }
                Thinking thinking = (Thinking) other;
                return Intrinsics.areEqual(this.thinking, thinking.thinking) && Intrinsics.areEqual(this.toolCallInfo, thinking.toolCallInfo);
            }

            public int hashCode() {
                return (this.thinking.hashCode() * 31) + this.toolCallInfo.hashCode();
            }

            public String toString() {
                return "Thinking(thinking=" + this.thinking + ", toolCallInfo=" + this.toolCallInfo + ')';
            }

            public final AgentContentBlock.Thinking getThinking() {
                return this.thinking;
            }

            public final ParsedToolCallInfo getToolCallInfo() {
                return this.toolCallInfo;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Thinking(AgentContentBlock.Thinking thinking, ParsedToolCallInfo parsedToolCallInfo) {
                super(null);
                Intrinsics.checkNotNullParameter(thinking, "thinking");
                Intrinsics.checkNotNullParameter(parsedToolCallInfo, "toolCallInfo");
                this.thinking = thinking;
                this.toolCallInfo = parsedToolCallInfo;
                this.category = ToolCategory.THINKING;
            }

            @Override // com.bytedance.trae.conversation.chat.detail.ToolListFragment.ToolListItem
            public ToolCategory getCategory() {
                return this.category;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToolListFragment.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0019B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ \u0010\t\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J \u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0012\u001a\u00020\rH\u0016J \u0010\u0013\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0006H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0017\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;", "items", "", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListItem;", "<init>", "(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "onBindViewHolder", "", "holder", NewTaskTracker.Param.POSITION, "bindCard", "card", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "createCard", "item", "updateCard", "ToolViewHolder", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public final class ToolListAdapter extends RecyclerView.Adapter<ToolViewHolder> {
        private final List<ToolListItem> items;
        final /* synthetic */ ToolListFragment this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public ToolListAdapter(ToolListFragment toolListFragment, List<? extends ToolListItem> list) {
            Intrinsics.checkNotNullParameter(list, "items");
            this.this$0 = toolListFragment;
            this.items = list;
        }

        /* compiled from: ToolListFragment.kt */
        @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter$ToolViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$ToolListAdapter;Landroid/view/View;)V", "ivIcon", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "tvIconEmoji", "Landroid/widget/TextView;", "getTvIconEmoji", "()Landroid/widget/TextView;", "tvTitle", "Lcom/bytedance/trae/conversation/widget/ShimmerTextView;", "getTvTitle", "()Lcom/bytedance/trae/conversation/widget/ShimmerTextView;", "tvSubtitle", "getTvSubtitle", "tvBadge", "getTvBadge", "ivChevronRight", "getIvChevronRight", "llHeader", "Landroid/widget/LinearLayout;", "getLlHeader", "()Landroid/widget/LinearLayout;", "llBody", "getLlBody", "flContent", "Landroid/widget/FrameLayout;", "getFlContent", "()Landroid/widget/FrameLayout;", "card", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "getCard", "()Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "setCard", "(Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;)V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public final class ToolViewHolder extends RecyclerView.ViewHolder {
            private ToolDetailCard card;
            private final FrameLayout flContent;
            private final ImageView ivChevronRight;
            private final ImageView ivIcon;
            private final LinearLayout llBody;
            private final LinearLayout llHeader;
            final /* synthetic */ ToolListAdapter this$0;
            private final TextView tvBadge;
            private final TextView tvIconEmoji;
            private final TextView tvSubtitle;
            private final ShimmerTextView tvTitle;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ToolViewHolder(ToolListAdapter toolListAdapter, View view) {
                super(view);
                Intrinsics.checkNotNullParameter(view, "itemView");
                this.this$0 = toolListAdapter;
                View findViewById = view.findViewById(C0637R.id.iv_icon);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
                this.ivIcon = (ImageView) findViewById;
                View findViewById2 = view.findViewById(C0637R.id.tv_icon_emoji);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
                this.tvIconEmoji = (TextView) findViewById2;
                Object findViewById3 = view.findViewById(C0637R.id.tv_title);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
                this.tvTitle = (ShimmerTextView) findViewById3;
                View findViewById4 = view.findViewById(C0637R.id.tv_subtitle);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
                this.tvSubtitle = (TextView) findViewById4;
                View findViewById5 = view.findViewById(C0637R.id.tv_badge);
                Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
                this.tvBadge = (TextView) findViewById5;
                View findViewById6 = view.findViewById(C0637R.id.iv_chevron_right);
                Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
                this.ivChevronRight = (ImageView) findViewById6;
                View findViewById7 = view.findViewById(C0637R.id.ll_header);
                Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
                this.llHeader = (LinearLayout) findViewById7;
                View findViewById8 = view.findViewById(C0637R.id.ll_body);
                Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
                this.llBody = (LinearLayout) findViewById8;
                View findViewById9 = view.findViewById(C0637R.id.fl_content);
                Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
                this.flContent = (FrameLayout) findViewById9;
            }

            public final ImageView getIvIcon() {
                return this.ivIcon;
            }

            public final TextView getTvIconEmoji() {
                return this.tvIconEmoji;
            }

            public final ShimmerTextView getTvTitle() {
                return this.tvTitle;
            }

            public final TextView getTvSubtitle() {
                return this.tvSubtitle;
            }

            public final TextView getTvBadge() {
                return this.tvBadge;
            }

            public final ImageView getIvChevronRight() {
                return this.ivChevronRight;
            }

            public final LinearLayout getLlHeader() {
                return this.llHeader;
            }

            public final LinearLayout getLlBody() {
                return this.llBody;
            }

            public final FrameLayout getFlContent() {
                return this.flContent;
            }

            public final ToolDetailCard getCard() {
                return this.card;
            }

            public final void setCard(ToolDetailCard toolDetailCard) {
                this.card = toolDetailCard;
            }
        }

        public ToolViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(C0637R.layout.trae_item_tool_list, parent, false);
            Intrinsics.checkNotNull(inflate);
            return new ToolViewHolder(this, inflate);
        }

        public int getItemCount() {
            return this.items.size();
        }

        public void onBindViewHolder(ToolViewHolder holder, int position) {
            ToolDetailCard createCard;
            Intrinsics.checkNotNullParameter(holder, "holder");
            ToolListItem toolListItem = this.items.get(position);
            if (holder.getCard() == null) {
                createCard = createCard(toolListItem);
            } else {
                ToolDetailCard updateCard = updateCard(toolListItem);
                createCard = updateCard == null ? createCard(toolListItem) : updateCard;
            }
            holder.setCard(createCard);
            bindCard(holder, createCard);
        }

        private final void bindCard(ToolViewHolder holder, ToolDetailCard card) {
            ColorStateList valueOf;
            Context context = holder.itemView.getContext();
            if (card.getIconResId() != 0) {
                holder.getIvIcon().setImageResource(card.getIconResId());
                ImageView ivIcon = holder.getIvIcon();
                if (card.getIconTintColorRes() != 0) {
                    valueOf = ColorStateList.valueOf(ContextCompat.getColor(context, card.getIconTintColorRes()));
                } else {
                    valueOf = ColorStateList.valueOf(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
                }
                ivIcon.setImageTintList(valueOf);
                holder.getIvIcon().setVisibility(0);
                holder.getTvIconEmoji().setVisibility(8);
            } else {
                holder.getTvIconEmoji().setText(card.getIconEmoji());
                holder.getTvIconEmoji().setVisibility(0);
                holder.getIvIcon().setVisibility(8);
            }
            holder.getTvTitle().setText(card.getTitle());
            holder.getTvTitle().setShimmerEnabled(card.getShimmerTitle());
            String subtitle = card.getSubtitle();
            boolean z = true;
            if (subtitle == null || subtitle.length() == 0) {
                holder.getTvSubtitle().setVisibility(8);
            } else {
                holder.getTvSubtitle().setText(card.getSubtitle());
                holder.getTvSubtitle().setVisibility(0);
            }
            String badgeText = card.getBadgeText();
            if (badgeText != null && badgeText.length() != 0) {
                z = false;
            }
            if (z) {
                holder.getTvBadge().setVisibility(8);
            } else {
                holder.getTvBadge().setText(card.getBadgeText());
                if (card.getStatus() == ToolExecutionStatus.CANCELED) {
                    holder.getTvBadge().setBackgroundResource(C0637R.drawable.trae_bg_tool_badge_cancel);
                    holder.getTvBadge().setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
                } else {
                    holder.getTvBadge().setBackgroundResource(C0637R.drawable.trae_bg_tool_badge_warning);
                    holder.getTvBadge().setTextColor(ContextCompat.getColor(context, C0591R.color.trae_status_warning_default));
                }
                holder.getTvBadge().setVisibility(0);
            }
            holder.getFlContent().removeAllViews();
            Intrinsics.checkNotNull(context);
            View orCreateContentView = card.getOrCreateContentView(context);
            if (orCreateContentView != null) {
                if (orCreateContentView.getParent() != null) {
                    ViewParent parent = orCreateContentView.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        viewGroup.removeView(orCreateContentView);
                    }
                }
                holder.getFlContent().addView(orCreateContentView);
                holder.getFlContent().setVisibility(0);
            } else {
                holder.getFlContent().setVisibility(8);
            }
            if (card.getOnDetailClick() != null) {
                holder.getIvChevronRight().setVisibility(0);
                LinearLayout llHeader = holder.getLlHeader();
                final Function1<View, Unit> onDetailClick = card.getOnDetailClick();
                llHeader.setOnClickListener(onDetailClick != null ? new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.detail.ToolListFragment$ToolListAdapter$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        onDetailClick.invoke(view);
                    }
                } : null);
                return;
            }
            holder.getIvChevronRight().setVisibility(8);
            holder.getLlHeader().setOnClickListener(null);
            holder.getLlHeader().setClickable(false);
        }

        private final ToolDetailCard createCard(ToolListItem item) {
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (item instanceof ToolListItem.Tool) {
                ToolListItem.Tool tool = (ToolListItem.Tool) item;
                return ToolDetailCardFactory.INSTANCE.createDetailCard(requireContext, tool.getToolCallInfo(), tool.getPlanItemContext());
            }
            if (!(item instanceof ToolListItem.Thinking)) {
                throw new NoWhenBranchMatchedException();
            }
            ToolListItem.Thinking thinking = (ToolListItem.Thinking) item;
            return ToolDetailCardFactory.INSTANCE.createThinkingCard(requireContext, thinking.getToolCallInfo(), new PlanItemContext(thinking.getThinking().getPlanItemId(), null, null, null, null, null, thinking.getThinking().getReasoningContent(), 62, null));
        }

        private final ToolDetailCard updateCard(ToolListItem item) {
            Context requireContext = this.this$0.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
            if (item instanceof ToolListItem.Tool) {
                ToolListItem.Tool tool = (ToolListItem.Tool) item;
                return ToolDetailCardFactory.INSTANCE.updateDetailCard(requireContext, tool.getToolCallInfo(), tool.getPlanItemContext());
            }
            if (!(item instanceof ToolListItem.Thinking)) {
                throw new NoWhenBranchMatchedException();
            }
            ToolListItem.Thinking thinking = (ToolListItem.Thinking) item;
            return ToolDetailCardFactory.INSTANCE.updateThinkingCard(requireContext, thinking.getToolCallInfo(), new PlanItemContext(thinking.getThinking().getPlanItemId(), null, null, null, null, null, thinking.getThinking().getReasoningContent(), 62, null));
        }
    }

    /* compiled from: ToolListFragment.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment$Companion;", "", "<init>", "()V", "ARG_BLOCK_KEY", "", "POLL_INTERVAL_MS", "", "TOOL_TAG", "newInstance", "Lcom/bytedance/trae/conversation/chat/detail/ToolListFragment;", "blockKey", "block", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ToolcallGroup;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ToolListFragment newInstance(String blockKey) {
            Intrinsics.checkNotNullParameter(blockKey, "blockKey");
            FLogger.INSTANCE.i("AgentTool", "[ToolList] newInstance: blockKey=" + blockKey);
            ToolListFragment toolListFragment = new ToolListFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ToolListFragment.ARG_BLOCK_KEY, blockKey);
            toolListFragment.setArguments(bundle);
            return toolListFragment;
        }

        public final ToolListFragment newInstance(AgentContentBlock.ToolcallGroup block) {
            Intrinsics.checkNotNullParameter(block, "block");
            String put = DetailBlockStore.INSTANCE.put(block);
            FLogger.INSTANCE.i("AgentTool", "[ToolList] newInstance(ToolcallGroup): key=" + put + ", toolcalls=" + block.getToolcalls().size());
            return newInstance(put);
        }

        public final ToolListFragment newInstance(AgentContentBlock.Toolcall block) {
            Intrinsics.checkNotNullParameter(block, "block");
            String put = DetailBlockStore.INSTANCE.put(block);
            FLogger.INSTANCE.i("AgentTool", "[ToolList] newInstance(Toolcall): key=" + put + ", toolName=" + block.getToolCallInfo().getName());
            return newInstance(put);
        }
    }
}
