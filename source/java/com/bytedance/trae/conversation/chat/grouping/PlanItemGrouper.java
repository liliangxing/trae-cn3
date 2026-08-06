package com.bytedance.trae.conversation.chat.grouping;

import android.content.res.Resources;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.checkpoint.creators.RunCommandDialogCreator;
import com.bytedance.trae.conversation.chat.grouping.PlanItemGrouper;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedPlanItem;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.ParsedToolCallResult;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: PlanItemGrouper.kt */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002UVB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J(\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J8\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u001d2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J8\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u001d2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J*\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\"2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020%0$H\u0002J2\u0010&\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\"2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u001d2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010'\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\"H\u0002J4\u0010(\u001a\u00020)2\u0006\u0010\f\u001a\u00020%2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u001d2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u0018H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0010H\u0002J\u0016\u0010.\u001a\u00020)2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020,0\rH\u0002J \u00100\u001a\u00020)2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010*\u001a\u00020\u00182\u0006\u00101\u001a\u00020\u0018H\u0002J2\u00102\u001a\u0002032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u001d2\u0006\u00104\u001a\u00020\u0005H\u0002J,\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u001d2\u0006\u00104\u001a\u00020\u0005H\u0002J,\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J,\u00108\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J,\u00109\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010:\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\rH\u0002J(\u0010>\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010?\u001a\u00020\u0018H\u0002J4\u0010@\u001a\u00020\u00182\f\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\r2\u0006\u0010A\u001a\u00020\u00182\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J&\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u00020=2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010E\u001a\u0004\u0018\u00010\u00052\u0006\u00106\u001a\u00020\u000eH\u0002J&\u0010F\u001a\u0004\u0018\u00010\u00052\u0006\u00106\u001a\u00020\u000e2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\u001dH\u0002J\u0012\u0010G\u001a\u00020\u00182\b\u0010H\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010I\u001a\u00020\u00182\b\u0010H\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010J\u001a\u00020\u00182\b\u0010H\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010K\u001a\u00020\u00182\b\u0010H\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010L\u001a\u00020\u00182\b\u0010H\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010M\u001a\u00020\u00182\b\u0010H\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010N\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010\r2\b\u0010P\u001a\u0004\u0018\u00010QH\u0002J\u001a\u0010R\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010\r2\b\u0010S\u001a\u0004\u0018\u00010TH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper;", "", "<init>", "()V", "AGENT_FLOW_TAG", "", "EXPLORE_TOOLS", "", "FINISH_TOOLS", "TODO_TOOLS", "PURE_SHOW_WIDGET_TOOL", "BROWSER_PREFIX", "group", "", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "planItems", "Lcom/bytedance/trae/im/model/ParsedPlanItem;", "resources", "Landroid/content/res/Resources;", "context", "Lcom/bytedance/trae/conversation/chat/grouping/GroupingContext;", "expandPlanItem", "item", "isLastPlanItem", "", "shouldSkipEmptyFinishToolcall", "applyTodoGrouping", "blocks", "planItemMap", "", "applySubAgentGrouping", "markRunningSubAgentsCompleted", "", "output", "", "subAgentGroupMap", "", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$SubAgentGroup;", "correctSubAgentStatuses", "markLastRunningSubAgent", "computeSubAgentStatus", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupStatus;", "isLast", "computePlanItemExecutionStatus", "Lcom/bytedance/trae/conversation/chat/grouping/PlanItemExecutionStatus;", "planItem", "aggregateGroupStatus", "statuses", "computeTodoStatus", "allTodosCompleted", "filterFinishElements", "Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$FilterFinishResult;", "mainAgentRunId", "isMainAgentFinish", "block", "applyToolAggregation", "aggregateAllTools", "aggregateContainerChildren", "determineGroupType", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$GroupType;", "toolcalls", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "buildGroupTitle", "groupFinished", "computeGroupFinished", "hasThinking", "children", "isToolcallFinished", "toolCallInfo", "getPlanItemId", "getAgentRunId", "isExploreTool", "name", "isBrowserTool", "isFinishTool", "isTodoTool", "isPureShowWidgetTool", "isSearchTool", "parseTodosFromParams", "Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;", "params", "Lcom/google/gson/JsonObject;", "parseTodosFromResult", "result", "Lcom/bytedance/trae/im/model/ParsedToolCallResult;", "TodoItem", "FilterFinishResult", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PlanItemGrouper {
    private static final String AGENT_FLOW_TAG = "AgentDataFlow";
    private static final String BROWSER_PREFIX = "browser_";
    private static final String PURE_SHOW_WIDGET_TOOL = "PureShowWidget";
    public static final PlanItemGrouper INSTANCE = new PlanItemGrouper();
    private static final Set<String> EXPLORE_TOOLS = SetsKt.setOf(new String[]{"Read", "view_file", "view_files", "view_folder", "LS", "SearchCodebase", "Grep", "Glob", "file_search", "search_codebase", "search_by_regex"});
    private static final Set<String> FINISH_TOOLS = SetsKt.setOf(new String[]{"finish", "Finish", "agent_finish", "AgentFinish", "response_to_user", "ResponseToUser", "Task"});
    private static final Set<String> TODO_TOOLS = SetsKt.setOf(new String[]{"todo_write", "TodoWrite"});

    private PlanItemGrouper() {
    }

    public final List<AgentContentBlock> group(List<ParsedPlanItem> planItems, Resources resources, GroupingContext context) {
        Intrinsics.checkNotNullParameter(planItems, "planItems");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(context, "context");
        TraeLogUtil.INSTANCE.d(AGENT_FLOW_TAG, "[Node7] Grouper.group: input planItems=" + planItems.size() + ", mainAgentRunId=" + context.getMainAgentRunId() + ", messageStatus=" + context.getMessageStatus() + ", isHistory=" + context.isHistory());
        List<ParsedPlanItem> list = planItems;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (Object obj : list) {
            String id = ((ParsedPlanItem) obj).getId();
            if (id == null) {
                id = "";
            }
            linkedHashMap.put(id, obj);
        }
        List<? extends AgentContentBlock> arrayList = new ArrayList<>();
        int i = 0;
        for (Object obj2 : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            CollectionsKt.addAll(arrayList, INSTANCE.expandPlanItem((ParsedPlanItem) obj2, context, i == CollectionsKt.getLastIndex(planItems)));
            i = i2;
        }
        List<? extends AgentContentBlock> list2 = arrayList;
        TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
        StringBuilder append = new StringBuilder("[Node7] afterExpand: elements=").append(list2.size()).append(", types=");
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : list2) {
            String simpleName = Reflection.getOrCreateKotlinClass(((AgentContentBlock) obj3).getClass()).getSimpleName();
            Object obj4 = linkedHashMap2.get(simpleName);
            if (obj4 == null) {
                obj4 = (List) new ArrayList();
                linkedHashMap2.put(simpleName, obj4);
            }
            ((List) obj4).add(obj3);
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
        for (Map.Entry entry : linkedHashMap2.entrySet()) {
            linkedHashMap3.put(entry.getKey(), Integer.valueOf(((List) entry.getValue()).size()));
        }
        traeLogUtil.d(AGENT_FLOW_TAG, append.append(linkedHashMap3).toString());
        List<AgentContentBlock> applyTodoGrouping = applyTodoGrouping(list2, linkedHashMap, context);
        TraeLogUtil traeLogUtil2 = TraeLogUtil.INSTANCE;
        StringBuilder append2 = new StringBuilder("[Node7] afterTodoGrouping: blocks=").append(applyTodoGrouping.size()).append(", types=");
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        for (Object obj5 : applyTodoGrouping) {
            String simpleName2 = Reflection.getOrCreateKotlinClass(((AgentContentBlock) obj5).getClass()).getSimpleName();
            Object obj6 = linkedHashMap4.get(simpleName2);
            if (obj6 == null) {
                obj6 = (List) new ArrayList();
                linkedHashMap4.put(simpleName2, obj6);
            }
            ((List) obj6).add(obj5);
        }
        LinkedHashMap linkedHashMap5 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap4.size()));
        for (Map.Entry entry2 : linkedHashMap4.entrySet()) {
            linkedHashMap5.put(entry2.getKey(), Integer.valueOf(((List) entry2.getValue()).size()));
        }
        traeLogUtil2.d(AGENT_FLOW_TAG, append2.append(linkedHashMap5).toString());
        List<AgentContentBlock> applySubAgentGrouping = applySubAgentGrouping(applyTodoGrouping, linkedHashMap, context);
        TraeLogUtil traeLogUtil3 = TraeLogUtil.INSTANCE;
        StringBuilder append3 = new StringBuilder("[Node7] afterSubAgentGrouping: blocks=").append(applySubAgentGrouping.size()).append(", types=");
        LinkedHashMap linkedHashMap6 = new LinkedHashMap();
        for (Object obj7 : applySubAgentGrouping) {
            String simpleName3 = Reflection.getOrCreateKotlinClass(((AgentContentBlock) obj7).getClass()).getSimpleName();
            Object obj8 = linkedHashMap6.get(simpleName3);
            if (obj8 == null) {
                obj8 = (List) new ArrayList();
                linkedHashMap6.put(simpleName3, obj8);
            }
            ((List) obj8).add(obj7);
        }
        LinkedHashMap linkedHashMap7 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap6.size()));
        for (Map.Entry entry3 : linkedHashMap6.entrySet()) {
            linkedHashMap7.put(entry3.getKey(), Integer.valueOf(((List) entry3.getValue()).size()));
        }
        traeLogUtil3.d(AGENT_FLOW_TAG, append3.append(linkedHashMap7).toString());
        List<AgentContentBlock> applyToolAggregation = applyToolAggregation(applySubAgentGrouping, resources, context);
        TraeLogUtil traeLogUtil4 = TraeLogUtil.INSTANCE;
        StringBuilder append4 = new StringBuilder("[Node7] afterToolAggregation (FINAL): blocks=").append(applyToolAggregation.size()).append(", types=");
        LinkedHashMap linkedHashMap8 = new LinkedHashMap();
        for (Object obj9 : applyToolAggregation) {
            String simpleName4 = Reflection.getOrCreateKotlinClass(((AgentContentBlock) obj9).getClass()).getSimpleName();
            Object obj10 = linkedHashMap8.get(simpleName4);
            if (obj10 == null) {
                obj10 = (List) new ArrayList();
                linkedHashMap8.put(simpleName4, obj10);
            }
            ((List) obj10).add(obj9);
        }
        LinkedHashMap linkedHashMap9 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap8.size()));
        for (Map.Entry entry4 : linkedHashMap8.entrySet()) {
            linkedHashMap9.put(entry4.getKey(), Integer.valueOf(((List) entry4.getValue()).size()));
        }
        traeLogUtil4.d(AGENT_FLOW_TAG, append4.append(linkedHashMap9).toString());
        return applyToolAggregation;
    }

    static /* synthetic */ List expandPlanItem$default(PlanItemGrouper planItemGrouper, ParsedPlanItem parsedPlanItem, GroupingContext groupingContext, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return planItemGrouper.expandPlanItem(parsedPlanItem, groupingContext, z);
    }

    private final List<AgentContentBlock> expandPlanItem(ParsedPlanItem item, GroupingContext context, boolean isLastPlanItem) {
        boolean z;
        boolean z2 = true;
        if (Intrinsics.areEqual(item.getHide(), true)) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        String id = item.getId();
        if (id == null) {
            id = "";
        }
        String reasoningContent = item.getReasoningContent();
        if (reasoningContent != null) {
            if (!(reasoningContent.length() > 0)) {
                reasoningContent = null;
            }
            if (reasoningContent != null) {
                ParsedToolCallInfo toolCallInfo = item.getToolCallInfo();
                String name = toolCallInfo != null ? toolCallInfo.getName() : null;
                if (name == null || name.length() == 0) {
                    String thought = item.getThought();
                    if (thought == null || StringsKt.isBlank(thought)) {
                        z = false;
                        arrayList.add(new AgentContentBlock.Thinking(id, reasoningContent, item.getToolCallInfo(), z && !(isLastPlanItem ^ true) && context.isStreaming()));
                    }
                }
                z = true;
                arrayList.add(new AgentContentBlock.Thinking(id, reasoningContent, item.getToolCallInfo(), z && !(isLastPlanItem ^ true) && context.isStreaming()));
            }
        }
        String thought2 = item.getThought();
        if (thought2 != null) {
            if (!(thought2.length() > 0)) {
                thought2 = null;
            }
            if (thought2 != null) {
                PlanItemGrouper planItemGrouper = INSTANCE;
                ParsedToolCallInfo toolCallInfo2 = item.getToolCallInfo();
                if (!planItemGrouper.isFinishTool(toolCallInfo2 != null ? toolCallInfo2.getName() : null)) {
                    arrayList.add(new AgentContentBlock.Thought(id, thought2));
                }
            }
        }
        ParsedToolCallInfo toolCallInfo3 = item.getToolCallInfo();
        if (toolCallInfo3 != null) {
            String name2 = toolCallInfo3.getName();
            if (name2 != null && name2.length() != 0) {
                z2 = false;
            }
            if (!z2) {
                PlanItemGrouper planItemGrouper2 = INSTANCE;
                if (!planItemGrouper2.isFinishTool(toolCallInfo3.getName()) && !planItemGrouper2.shouldSkipEmptyFinishToolcall(item)) {
                    arrayList.add(new AgentContentBlock.Toolcall(id, toolCallInfo3, item.getConfirmInfo()));
                }
            }
        }
        return arrayList;
    }

    private final boolean shouldSkipEmptyFinishToolcall(ParsedPlanItem item) {
        String name;
        boolean z;
        JsonObject params;
        JsonElement jsonElement;
        String asString;
        ParsedToolCallInfo toolCallInfo = item.getToolCallInfo();
        if (toolCallInfo == null || (name = toolCallInfo.getName()) == null || !isFinishTool(name)) {
            return false;
        }
        String thought = item.getThought();
        boolean z2 = !(thought == null || StringsKt.isBlank(thought));
        String reasoningContent = item.getReasoningContent();
        boolean z3 = !(reasoningContent == null || StringsKt.isBlank(reasoningContent));
        ParsedToolCallInfo toolCallInfo2 = item.getToolCallInfo();
        if (toolCallInfo2 != null && (params = toolCallInfo2.getParams()) != null && (jsonElement = params.get("summary")) != null) {
            if (!jsonElement.isJsonPrimitive()) {
                jsonElement = null;
            }
            if (jsonElement != null && (asString = jsonElement.getAsString()) != null && (!StringsKt.isBlank(asString))) {
                z = true;
                return z2 ? false : false;
            }
        }
        z = false;
        return z2 ? false : false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x009b, code lost:
    
        if ((r33.getMainAgentRunId().length() == 0) != false) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0211 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x020d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0028 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<AgentContentBlock> applyTodoGrouping(List<? extends AgentContentBlock> blocks, Map<String, ParsedPlanItem> planItemMap, GroupingContext context) {
        String str;
        List<TodoItem> parseTodosFromResult;
        Object obj;
        String content;
        ParsedToolCallInfo toolCallInfo;
        JsonElement jsonElement;
        ParsedToolCallInfo toolCallInfo2;
        boolean z;
        String str2;
        List<TodoItem> parseTodosFromResult2;
        LinkedHashSet linkedHashSet;
        boolean z2;
        boolean z3;
        JsonElement jsonElement2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        boolean z4 = false;
        boolean z5 = false;
        for (AgentContentBlock agentContentBlock : blocks) {
            String planItemId = getPlanItemId(agentContentBlock);
            ParsedPlanItem parsedPlanItem = planItemId != null ? planItemMap.get(planItemId) : null;
            if ((agentContentBlock instanceof AgentContentBlock.Toolcall) && isTodoTool(((AgentContentBlock.Toolcall) agentContentBlock).getToolCallInfo().getName())) {
                if (!Intrinsics.areEqual(parsedPlanItem != null ? parsedPlanItem.getAgentRunId() : null, context.getMainAgentRunId())) {
                    String agentRunId = parsedPlanItem != null ? parsedPlanItem.getAgentRunId() : null;
                    if (agentRunId == null || agentRunId.length() == 0) {
                    }
                }
                z = true;
                if (!z) {
                    if (!z4) {
                        ArrayList arrayList3 = arrayList2;
                        if (!arrayList3.isEmpty()) {
                            arrayList.addAll(arrayList3);
                            arrayList2.clear();
                        }
                    }
                    Intrinsics.checkNotNull(agentContentBlock, "null cannot be cast to non-null type com.bytedance.trae.conversation.chat.block.AgentContentBlock.Toolcall");
                    AgentContentBlock.Toolcall toolcall = (AgentContentBlock.Toolcall) agentContentBlock;
                    ParsedToolCallInfo toolCallInfo3 = toolcall.getToolCallInfo();
                    ParsedToolCallResult result = toolCallInfo3.getResult();
                    JsonObject params = toolCallInfo3.getParams();
                    List<TodoItem> parseTodosFromParams = parseTodosFromParams(params);
                    if (params != null && (jsonElement2 = params.get("summary")) != null) {
                        if (!jsonElement2.isJsonPrimitive()) {
                            jsonElement2 = null;
                        }
                        if (jsonElement2 != null) {
                            str2 = jsonElement2.getAsString();
                            parseTodosFromResult2 = parseTodosFromResult(result);
                            if (parseTodosFromResult2 != null) {
                                parseTodosFromParams = parseTodosFromResult2;
                            }
                            if (Intrinsics.areEqual(result == null ? result.getStatus() : null, "success") || parseTodosFromParams == null) {
                                linkedHashSet = linkedHashSet2;
                                z2 = true;
                            } else {
                                List<TodoItem> list = parseTodosFromParams;
                                if (!(list instanceof Collection) || !list.isEmpty()) {
                                    Iterator<T> it = list.iterator();
                                    while (it.hasNext()) {
                                        if (!Intrinsics.areEqual(((TodoItem) it.next()).getStatus(), "completed")) {
                                            z3 = false;
                                            break;
                                        }
                                    }
                                }
                                z3 = true;
                                String planItemId2 = toolcall.getPlanItemId();
                                ArrayList arrayList4 = new ArrayList();
                                for (Object obj2 : list) {
                                    TodoItem todoItem = (TodoItem) obj2;
                                    if (Intrinsics.areEqual(todoItem.getStatus(), "completed") && !linkedHashSet2.contains(todoItem.getId())) {
                                        arrayList4.add(obj2);
                                    }
                                }
                                ArrayList arrayList5 = arrayList4;
                                if (!arrayList5.isEmpty()) {
                                    arrayList2.add(agentContentBlock);
                                    ArrayList arrayList6 = arrayList5;
                                    ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
                                    Iterator it2 = arrayList6.iterator();
                                    while (it2.hasNext()) {
                                        arrayList7.add(((TodoItem) it2.next()).getId());
                                    }
                                    linkedHashSet2.addAll(arrayList7);
                                    applyTodoGrouping$flushTodoSection(planItemMap, context, arrayList, toolcall.getPlanItemId(), CollectionsKt.toList(arrayList2), CollectionsKt.joinToString$default(arrayList6, " & ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.bytedance.trae.conversation.chat.grouping.PlanItemGrouper$$ExternalSyntheticLambda0
                                        public final Object invoke(Object obj3) {
                                            CharSequence applyTodoGrouping$lambda$21;
                                            applyTodoGrouping$lambda$21 = PlanItemGrouper.applyTodoGrouping$lambda$21((PlanItemGrouper.TodoItem) obj3);
                                            return applyTodoGrouping$lambda$21;
                                        }
                                    }, 30, (Object) null), str2, false, z3);
                                    arrayList2.clear();
                                    str4 = toolcall.getPlanItemId();
                                    z4 = true;
                                    linkedHashSet2 = linkedHashSet2;
                                    str6 = str2;
                                    z5 = z3;
                                    str5 = planItemId2;
                                } else {
                                    linkedHashSet = linkedHashSet2;
                                    z2 = true;
                                    z5 = z3;
                                    str5 = planItemId2;
                                }
                            }
                            arrayList2.add(agentContentBlock);
                            str4 = toolcall.getPlanItemId();
                            z4 = z2;
                            linkedHashSet2 = linkedHashSet;
                            if (str2 == null) {
                                str6 = str2;
                            }
                        }
                    }
                    str2 = null;
                    parseTodosFromResult2 = parseTodosFromResult(result);
                    if (parseTodosFromResult2 != null) {
                    }
                    if (Intrinsics.areEqual(result == null ? result.getStatus() : null, "success")) {
                    }
                    linkedHashSet = linkedHashSet2;
                    z2 = true;
                    arrayList2.add(agentContentBlock);
                    str4 = toolcall.getPlanItemId();
                    z4 = z2;
                    linkedHashSet2 = linkedHashSet;
                    if (str2 == null) {
                    }
                } else {
                    arrayList2.add(agentContentBlock);
                }
            }
            z = false;
            if (!z) {
            }
        }
        ArrayList arrayList8 = arrayList2;
        if (!arrayList8.isEmpty()) {
            FilterFinishResult filterFinishElements = filterFinishElements(arrayList2, planItemMap, context.getMainAgentRunId());
            AgentContentBlock.GroupStatus computeTodoStatus = computeTodoStatus(context, true, false);
            if ((!z4 || str4 == null || z5 || !(filterFinishElements.getFilteredBlocks().isEmpty() ^ true) || computeTodoStatus == AgentContentBlock.GroupStatus.COMPLETED) ? false : true) {
                if (str5 != null) {
                    ParsedPlanItem parsedPlanItem2 = planItemMap.get(str5);
                    JsonObject params2 = (parsedPlanItem2 == null || (toolCallInfo2 = parsedPlanItem2.getToolCallInfo()) == null) ? null : toolCallInfo2.getParams();
                    if (params2 != null && (jsonElement = params2.get("summary")) != null) {
                        if (!jsonElement.isJsonPrimitive()) {
                            jsonElement = null;
                        }
                        if (jsonElement != null) {
                            str = jsonElement.getAsString();
                            if (str != null) {
                                str6 = str;
                            }
                            parseTodosFromResult = parseTodosFromResult((parsedPlanItem2 != null || (toolCallInfo = parsedPlanItem2.getToolCallInfo()) == null) ? null : toolCallInfo.getResult());
                            if (parseTodosFromResult == null) {
                                parseTodosFromResult = parseTodosFromParams(params2);
                            }
                            if (parseTodosFromResult != null) {
                                Iterator<T> it3 = parseTodosFromResult.iterator();
                                while (true) {
                                    if (!it3.hasNext()) {
                                        obj = null;
                                        break;
                                    }
                                    obj = it3.next();
                                    if (Intrinsics.areEqual(((TodoItem) obj).getStatus(), "in_progress")) {
                                        break;
                                    }
                                }
                                TodoItem todoItem2 = (TodoItem) obj;
                                if (todoItem2 != null && (content = todoItem2.getContent()) != null && (!StringsKt.isBlank(content))) {
                                    str3 = content;
                                }
                            }
                        }
                    }
                    str = null;
                    if (str != null) {
                    }
                    parseTodosFromResult = parseTodosFromResult((parsedPlanItem2 != null || (toolCallInfo = parsedPlanItem2.getToolCallInfo()) == null) ? null : toolCallInfo.getResult());
                    if (parseTodosFromResult == null) {
                    }
                    if (parseTodosFromResult != null) {
                    }
                }
                arrayList.add(new AgentContentBlock.TodoGroup(str4, str3, str6, filterFinishElements.getFilteredBlocks(), computeTodoStatus));
                arrayList.addAll(filterFinishElements.getFinishBlocks());
            } else {
                arrayList.addAll(arrayList8);
            }
        }
        return arrayList;
    }

    private static final void applyTodoGrouping$flushTodoSection(Map<String, ParsedPlanItem> map, GroupingContext groupingContext, List<AgentContentBlock> list, String str, List<? extends AgentContentBlock> list2, String str2, String str3, boolean z, boolean z2) {
        PlanItemGrouper planItemGrouper = INSTANCE;
        FilterFinishResult filterFinishElements = planItemGrouper.filterFinishElements(list2, map, groupingContext.getMainAgentRunId());
        list.add(new AgentContentBlock.TodoGroup(str, str2, str3, filterFinishElements.getFilteredBlocks(), planItemGrouper.computeTodoStatus(groupingContext, z, z2)));
        list.addAll(filterFinishElements.getFinishBlocks());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence applyTodoGrouping$lambda$21(TodoItem todoItem) {
        Intrinsics.checkNotNullParameter(todoItem, "it");
        return todoItem.getContent();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004a, code lost:
    
        if ((r7.length() == 0) != false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00f6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<AgentContentBlock> applySubAgentGrouping(List<? extends AgentContentBlock> blocks, Map<String, ParsedPlanItem> planItemMap, GroupingContext context) {
        boolean z;
        String planItemId;
        ParsedPlanItem parsedPlanItem;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Iterator<? extends AgentContentBlock> it = blocks.iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                break;
            }
            AgentContentBlock next = it.next();
            if (!(next instanceof AgentContentBlock.TodoGroup)) {
                String agentRunId = getAgentRunId(next, planItemMap);
                String str = agentRunId != null ? agentRunId : "";
                if (!Intrinsics.areEqual(str, context.getMainAgentRunId())) {
                }
                z2 = true;
                if (!z2) {
                    Object obj = linkedHashMap.get(str);
                    if (obj == null) {
                        obj = (List) new ArrayList();
                        linkedHashMap.put(str, obj);
                    }
                    ((List) obj).add(next);
                    if (!linkedHashMap2.containsKey(str) && (planItemId = getPlanItemId(next)) != null && (parsedPlanItem = planItemMap.get(planItemId)) != null) {
                        linkedHashMap2.put(str, parsedPlanItem);
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (AgentContentBlock agentContentBlock : blocks) {
            if (agentContentBlock instanceof AgentContentBlock.TodoGroup) {
                AgentContentBlock.TodoGroup todoGroup = (AgentContentBlock.TodoGroup) agentContentBlock;
                arrayList.add(AgentContentBlock.TodoGroup.copy$default(todoGroup, null, null, null, applySubAgentGrouping(todoGroup.getChildren(), planItemMap, context), null, 23, null));
            } else {
                String agentRunId2 = getAgentRunId(agentContentBlock, planItemMap);
                if (agentRunId2 == null) {
                    agentRunId2 = "";
                }
                if (!Intrinsics.areEqual(agentRunId2, context.getMainAgentRunId())) {
                    if (!(agentRunId2.length() == 0)) {
                        z = false;
                        if (!z) {
                            if (!linkedHashMap3.isEmpty()) {
                                markRunningSubAgentsCompleted(arrayList, linkedHashMap3);
                            }
                            arrayList.add(agentContentBlock);
                        } else if (!linkedHashSet.contains(agentRunId2)) {
                            linkedHashSet.add(agentRunId2);
                            List list = (List) linkedHashMap.get(agentRunId2);
                            if (list == null) {
                                list = CollectionsKt.emptyList();
                            }
                            List list2 = list;
                            ParsedPlanItem parsedPlanItem2 = (ParsedPlanItem) linkedHashMap2.get(agentRunId2);
                            AgentContentBlock.SubAgentGroup subAgentGroup = new AgentContentBlock.SubAgentGroup(agentRunId2, parsedPlanItem2 != null ? parsedPlanItem2.getAgentId() : null, parsedPlanItem2 != null ? parsedPlanItem2.getAgentDisplayName() : null, parsedPlanItem2 != null ? parsedPlanItem2.getSubAgentCallDescription() : null, list2, AgentContentBlock.GroupStatus.RUNNING, false, 64, null);
                            linkedHashMap3.put(agentRunId2, subAgentGroup);
                            arrayList.add(subAgentGroup);
                        }
                    }
                }
                z = true;
                if (!z) {
                }
            }
        }
        correctSubAgentStatuses(arrayList, planItemMap, context);
        markLastRunningSubAgent(arrayList);
        return arrayList;
    }

    private final void markRunningSubAgentsCompleted(List<AgentContentBlock> output, Map<String, AgentContentBlock.SubAgentGroup> subAgentGroupMap) {
        int size = output.size();
        for (int i = 0; i < size; i++) {
            AgentContentBlock agentContentBlock = output.get(i);
            if (agentContentBlock instanceof AgentContentBlock.SubAgentGroup) {
                AgentContentBlock.SubAgentGroup subAgentGroup = (AgentContentBlock.SubAgentGroup) agentContentBlock;
                if (subAgentGroup.getStatus() == AgentContentBlock.GroupStatus.RUNNING) {
                    AgentContentBlock.SubAgentGroup copy$default = AgentContentBlock.SubAgentGroup.copy$default(subAgentGroup, null, null, null, null, null, AgentContentBlock.GroupStatus.COMPLETED, false, 95, null);
                    output.set(i, copy$default);
                    subAgentGroupMap.put(subAgentGroup.getAgentRunId(), copy$default);
                }
            }
        }
    }

    private final void correctSubAgentStatuses(List<AgentContentBlock> output, Map<String, ParsedPlanItem> planItemMap, GroupingContext context) {
        boolean areEqual = Intrinsics.areEqual(context.getMessageStatus(), "in_progress");
        if (context.isHistory() || !areEqual) {
            int size = output.size();
            for (int i = 0; i < size; i++) {
                AgentContentBlock agentContentBlock = output.get(i);
                if (agentContentBlock instanceof AgentContentBlock.SubAgentGroup) {
                    AgentContentBlock.SubAgentGroup subAgentGroup = (AgentContentBlock.SubAgentGroup) agentContentBlock;
                    if (subAgentGroup.getStatus() == AgentContentBlock.GroupStatus.RUNNING) {
                        AgentContentBlock.GroupStatus computeSubAgentStatus = computeSubAgentStatus(subAgentGroup, planItemMap, context, false);
                        if (computeSubAgentStatus == AgentContentBlock.GroupStatus.RUNNING) {
                            computeSubAgentStatus = AgentContentBlock.GroupStatus.CANCELED;
                        }
                        output.set(i, AgentContentBlock.SubAgentGroup.copy$default(subAgentGroup, null, null, null, null, null, computeSubAgentStatus, false, 95, null));
                    }
                }
            }
        }
    }

    private final void markLastRunningSubAgent(List<AgentContentBlock> output) {
        List<AgentContentBlock> list = output;
        int i = -1;
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i2 = size - 1;
                if (output.get(size) instanceof AgentContentBlock.SubAgentGroup) {
                    AgentContentBlock agentContentBlock = output.get(size);
                    Intrinsics.checkNotNull(agentContentBlock, "null cannot be cast to non-null type com.bytedance.trae.conversation.chat.block.AgentContentBlock.SubAgentGroup");
                    if (((AgentContentBlock.SubAgentGroup) agentContentBlock).getStatus() == AgentContentBlock.GroupStatus.RUNNING) {
                        i = size;
                        break;
                    }
                }
                if (i2 < 0) {
                    break;
                } else {
                    size = i2;
                }
            }
        }
        int size2 = list.size();
        int i3 = 0;
        while (i3 < size2) {
            AgentContentBlock agentContentBlock2 = output.get(i3);
            if (agentContentBlock2 instanceof AgentContentBlock.SubAgentGroup) {
                output.set(i3, AgentContentBlock.SubAgentGroup.copy$default((AgentContentBlock.SubAgentGroup) agentContentBlock2, null, null, null, null, null, null, i3 == i, 63, null));
            }
            i3++;
        }
    }

    private final AgentContentBlock.GroupStatus computeSubAgentStatus(AgentContentBlock.SubAgentGroup group, Map<String, ParsedPlanItem> planItemMap, GroupingContext context, boolean isLast) {
        List<AgentContentBlock> children = group.getChildren();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = children.iterator();
        while (it.hasNext()) {
            String planItemId = INSTANCE.getPlanItemId((AgentContentBlock) it.next());
            if (planItemId != null) {
                arrayList.add(planItemId);
            }
        }
        List distinct = CollectionsKt.distinct(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = distinct.iterator();
        while (it2.hasNext()) {
            ParsedPlanItem parsedPlanItem = planItemMap.get((String) it2.next());
            if (parsedPlanItem != null) {
                arrayList2.add(parsedPlanItem);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            arrayList4.add(INSTANCE.computePlanItemExecutionStatus((ParsedPlanItem) it3.next()));
        }
        AgentContentBlock.GroupStatus aggregateGroupStatus = aggregateGroupStatus(arrayList4);
        if (aggregateGroupStatus == AgentContentBlock.GroupStatus.FAILED) {
            return AgentContentBlock.GroupStatus.FAILED;
        }
        if (aggregateGroupStatus == AgentContentBlock.GroupStatus.WAITING_CONFIRM) {
            return AgentContentBlock.GroupStatus.WAITING_CONFIRM;
        }
        return (context.isHistory() || !Intrinsics.areEqual(context.getMessageStatus(), "in_progress")) ? aggregateGroupStatus == AgentContentBlock.GroupStatus.RUNNING ? AgentContentBlock.GroupStatus.CANCELED : aggregateGroupStatus : (isLast && context.isLatestTurn()) ? AgentContentBlock.GroupStatus.RUNNING : aggregateGroupStatus;
    }

    private final PlanItemExecutionStatus computePlanItemExecutionStatus(ParsedPlanItem planItem) {
        ParsedToolCallResult result;
        ConfirmInfo confirmInfo = planItem.getConfirmInfo();
        boolean z = true;
        if (confirmInfo != null && confirmInfo.isEnterpriseCommandBlacklist()) {
            return PlanItemExecutionStatus.SKIPPED;
        }
        String str = null;
        String confirmStatus = confirmInfo != null ? confirmInfo.getConfirmStatus() : null;
        ParsedToolCallInfo toolCallInfo = planItem.getToolCallInfo();
        if (toolCallInfo != null && (result = toolCallInfo.getResult()) != null) {
            str = result.getStatus();
        }
        if (confirmInfo != null && Intrinsics.areEqual(confirmStatus, ConfirmInfo.STATUS_UNCONFIRMED)) {
            if (!Intrinsics.areEqual(confirmInfo.getBlockLevel(), RunCommandDialogCreator.BLOCK_LEVEL_REDLIST)) {
                List<String> hitRedList = confirmInfo.getHitRedList();
                if (hitRedList == null || hitRedList.isEmpty()) {
                    z = false;
                }
            }
            return z ? PlanItemExecutionStatus.WAITING_CONFIRM_REDLIST : PlanItemExecutionStatus.WAITING_CONFIRM;
        }
        if (Intrinsics.areEqual(confirmStatus, ConfirmInfo.STATUS_CANCELED)) {
            return PlanItemExecutionStatus.CANCELED;
        }
        if (Intrinsics.areEqual(confirmStatus, ConfirmInfo.STATUS_SKIPPED) || Intrinsics.areEqual(confirmStatus, ConfirmInfo.STATUS_SKIPPED_RUN)) {
            return PlanItemExecutionStatus.SKIPPED;
        }
        if (str != null) {
            switch (str.hashCode()) {
                case -1867169789:
                    if (str.equals("success")) {
                        return PlanItemExecutionStatus.SUCCESS;
                    }
                    break;
                case -1281977283:
                    if (str.equals("failed")) {
                        return PlanItemExecutionStatus.FAILED;
                    }
                    break;
                case 1550783935:
                    if (str.equals("running")) {
                        return PlanItemExecutionStatus.RUNNING;
                    }
                    break;
                case 2147444528:
                    if (str.equals(ConfirmInfo.STATUS_SKIPPED)) {
                        return PlanItemExecutionStatus.SKIPPED;
                    }
                    break;
            }
        }
        return PlanItemExecutionStatus.PENDING;
    }

    private final AgentContentBlock.GroupStatus aggregateGroupStatus(List<? extends PlanItemExecutionStatus> statuses) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (statuses.isEmpty()) {
            return AgentContentBlock.GroupStatus.RUNNING;
        }
        List<? extends PlanItemExecutionStatus> list = statuses;
        boolean z5 = list instanceof Collection;
        boolean z6 = true;
        if (!z5 || !list.isEmpty()) {
            for (PlanItemExecutionStatus planItemExecutionStatus : list) {
                if (planItemExecutionStatus == PlanItemExecutionStatus.WAITING_CONFIRM || planItemExecutionStatus == PlanItemExecutionStatus.WAITING_CONFIRM_REDLIST) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            return AgentContentBlock.GroupStatus.WAITING_CONFIRM;
        }
        if (!z5 || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((PlanItemExecutionStatus) it.next()) == PlanItemExecutionStatus.RUNNING) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        if (z2) {
            return AgentContentBlock.GroupStatus.RUNNING;
        }
        if (!z5 || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (((PlanItemExecutionStatus) it2.next()) == PlanItemExecutionStatus.FAILED) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        if (z3) {
            return AgentContentBlock.GroupStatus.FAILED;
        }
        if (!z5 || !list.isEmpty()) {
            for (PlanItemExecutionStatus planItemExecutionStatus2 : list) {
                if (!(planItemExecutionStatus2 == PlanItemExecutionStatus.CANCELED || planItemExecutionStatus2 == PlanItemExecutionStatus.SKIPPED)) {
                    z4 = false;
                    break;
                }
            }
        }
        z4 = true;
        if (z4) {
            return AgentContentBlock.GroupStatus.CANCELED;
        }
        if (!z5 || !list.isEmpty()) {
            Iterator<T> it3 = list.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                PlanItemExecutionStatus planItemExecutionStatus3 = (PlanItemExecutionStatus) it3.next();
                if (!(planItemExecutionStatus3 == PlanItemExecutionStatus.SUCCESS || planItemExecutionStatus3 == PlanItemExecutionStatus.SKIPPED || planItemExecutionStatus3 == PlanItemExecutionStatus.CANCELED)) {
                    z6 = false;
                    break;
                }
            }
        }
        if (z6) {
            return AgentContentBlock.GroupStatus.COMPLETED;
        }
        return AgentContentBlock.GroupStatus.RUNNING;
    }

    private final AgentContentBlock.GroupStatus computeTodoStatus(GroupingContext context, boolean isLast, boolean allTodosCompleted) {
        if (allTodosCompleted) {
            return AgentContentBlock.GroupStatus.COMPLETED;
        }
        if (!isLast) {
            return AgentContentBlock.GroupStatus.COMPLETED;
        }
        boolean z = context.isHistory() && Intrinsics.areEqual(context.getMessageStatus(), "in_progress");
        if (Intrinsics.areEqual(context.getMessageStatus(), ConfirmInfo.STATUS_CANCELED) || z) {
            return AgentContentBlock.GroupStatus.CANCELED;
        }
        if (Intrinsics.areEqual(context.getMessageStatus(), "paused")) {
            return AgentContentBlock.GroupStatus.WAITING_CONFIRM;
        }
        if (Intrinsics.areEqual(context.getMessageStatus(), "failed")) {
            return AgentContentBlock.GroupStatus.FAILED;
        }
        if (Intrinsics.areEqual(context.getMessageStatus(), "completed")) {
            return AgentContentBlock.GroupStatus.COMPLETED;
        }
        if (context.isHistory() || !context.isLatestTurn()) {
            return AgentContentBlock.GroupStatus.COMPLETED;
        }
        if (Intrinsics.areEqual(context.getMessageStatus(), "in_progress") || Intrinsics.areEqual(context.getMessageStatus(), "queuing")) {
            return AgentContentBlock.GroupStatus.RUNNING;
        }
        return AgentContentBlock.GroupStatus.COMPLETED;
    }

    private final FilterFinishResult filterFinishElements(List<? extends AgentContentBlock> blocks, Map<String, ParsedPlanItem> planItemMap, String mainAgentRunId) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AgentContentBlock agentContentBlock : blocks) {
            if (isMainAgentFinish(agentContentBlock, planItemMap, mainAgentRunId)) {
                arrayList2.add(agentContentBlock);
            } else {
                arrayList.add(agentContentBlock);
            }
        }
        return new FilterFinishResult(arrayList, arrayList2);
    }

    private final boolean isMainAgentFinish(AgentContentBlock block, Map<String, ParsedPlanItem> planItemMap, String mainAgentRunId) {
        if (!(block instanceof AgentContentBlock.Toolcall)) {
            return false;
        }
        AgentContentBlock.Toolcall toolcall = (AgentContentBlock.Toolcall) block;
        if (!isFinishTool(toolcall.getToolCallInfo().getName())) {
            return false;
        }
        ParsedPlanItem parsedPlanItem = planItemMap.get(toolcall.getPlanItemId());
        String agentRunId = parsedPlanItem != null ? parsedPlanItem.getAgentRunId() : null;
        if (agentRunId == null) {
            agentRunId = "";
        }
        if (!Intrinsics.areEqual(agentRunId, mainAgentRunId)) {
            if (!(agentRunId.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    private final List<AgentContentBlock> applyToolAggregation(List<? extends AgentContentBlock> blocks, Resources resources, GroupingContext context) {
        return aggregateAllTools(blocks, resources, context);
    }

    private final List<AgentContentBlock> aggregateAllTools(List<? extends AgentContentBlock> blocks, Resources resources, GroupingContext context) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (AgentContentBlock agentContentBlock : blocks) {
            if (agentContentBlock instanceof AgentContentBlock.Thought) {
                aggregateAllTools$flushBuffer(arrayList2, context, resources, arrayList);
                arrayList.add(agentContentBlock);
            } else if (agentContentBlock instanceof AgentContentBlock.TodoGroup) {
                aggregateAllTools$flushBuffer(arrayList2, context, resources, arrayList);
                AgentContentBlock.TodoGroup todoGroup = (AgentContentBlock.TodoGroup) agentContentBlock;
                arrayList.add(AgentContentBlock.TodoGroup.copy$default(todoGroup, null, null, null, aggregateContainerChildren(todoGroup.getChildren(), resources, context), null, 23, null));
            } else if (agentContentBlock instanceof AgentContentBlock.SubAgentGroup) {
                aggregateAllTools$flushBuffer(arrayList2, context, resources, arrayList);
                AgentContentBlock.SubAgentGroup subAgentGroup = (AgentContentBlock.SubAgentGroup) agentContentBlock;
                arrayList.add(AgentContentBlock.SubAgentGroup.copy$default(subAgentGroup, null, null, null, null, aggregateContainerChildren(subAgentGroup.getChildren(), resources, context), null, false, 111, null));
            } else if (agentContentBlock instanceof AgentContentBlock.Thinking) {
                arrayList2.add(agentContentBlock);
            } else if (agentContentBlock instanceof AgentContentBlock.Toolcall) {
                if (isPureShowWidgetTool(((AgentContentBlock.Toolcall) agentContentBlock).getToolCallInfo().getName())) {
                    aggregateAllTools$flushBuffer(arrayList2, context, resources, arrayList);
                    arrayList2.add(agentContentBlock);
                    aggregateAllTools$flushBuffer(arrayList2, context, resources, arrayList);
                } else {
                    arrayList2.add(agentContentBlock);
                }
            } else {
                aggregateAllTools$flushBuffer(arrayList2, context, resources, arrayList);
                arrayList.add(agentContentBlock);
            }
        }
        aggregateAllTools$flushBuffer(arrayList2, context, resources, arrayList);
        return arrayList;
    }

    private static final void aggregateAllTools$flushBuffer(List<AgentContentBlock> list, GroupingContext groupingContext, Resources resources, List<AgentContentBlock> list2) {
        if (list.isEmpty()) {
            return;
        }
        List<AgentContentBlock> list3 = list;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list3) {
            if (obj instanceof AgentContentBlock.Toolcall) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((AgentContentBlock.Toolcall) it.next()).getToolCallInfo());
        }
        ArrayList arrayList4 = arrayList3;
        boolean z = false;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator<T> it2 = list3.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((AgentContentBlock) it2.next()) instanceof AgentContentBlock.Thinking) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        PlanItemGrouper planItemGrouper = INSTANCE;
        boolean computeGroupFinished = planItemGrouper.computeGroupFinished(arrayList4, z, list, groupingContext);
        String buildGroupTitle = planItemGrouper.buildGroupTitle(list, resources, computeGroupFinished);
        List list4 = CollectionsKt.toList(list3);
        Object singleOrNull = CollectionsKt.singleOrNull(list4);
        AgentContentBlock.Toolcall toolcall = singleOrNull instanceof AgentContentBlock.Toolcall ? (AgentContentBlock.Toolcall) singleOrNull : null;
        if (toolcall != null && planItemGrouper.isPureShowWidgetTool(toolcall.getToolCallInfo().getName())) {
            list2.add(new AgentContentBlock.PureShowWidgetToolcallGroup(buildGroupTitle, arrayList4, list4, true, computeGroupFinished));
        } else {
            list2.add(new AgentContentBlock.ToolcallGroup(planItemGrouper.determineGroupType(arrayList4), buildGroupTitle, arrayList4, list4, true, computeGroupFinished));
        }
        list.clear();
    }

    private final List<AgentContentBlock> aggregateContainerChildren(List<? extends AgentContentBlock> blocks, Resources resources, GroupingContext context) {
        List<? extends AgentContentBlock> list = blocks;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof AgentContentBlock.Toolcall) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (INSTANCE.isPureShowWidgetTool(((AgentContentBlock.Toolcall) obj2).getToolCallInfo().getName())) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            return aggregateAllTools(blocks, resources, context);
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : list) {
            AgentContentBlock agentContentBlock = (AgentContentBlock) obj3;
            if (!((agentContentBlock instanceof AgentContentBlock.Toolcall) && INSTANCE.isPureShowWidgetTool(((AgentContentBlock.Toolcall) agentContentBlock).getToolCallInfo().getName()))) {
                arrayList4.add(obj3);
            }
        }
        return CollectionsKt.plus(aggregateAllTools(arrayList4, resources, context), aggregateAllTools(arrayList3, resources, context));
    }

    private final AgentContentBlock.GroupType determineGroupType(List<ParsedToolCallInfo> toolcalls) {
        List<ParsedToolCallInfo> list = toolcalls;
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (INSTANCE.isBrowserTool(((ParsedToolCallInfo) it.next()).getName())) {
                    z = true;
                    break;
                }
            }
        }
        if (z) {
            return AgentContentBlock.GroupType.BROWSER;
        }
        return AgentContentBlock.GroupType.EXPLORE;
    }

    static /* synthetic */ String buildGroupTitle$default(PlanItemGrouper planItemGrouper, List list, Resources resources, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return planItemGrouper.buildGroupTitle(list, resources, z);
    }

    private final String buildGroupTitle(List<? extends AgentContentBlock> blocks, Resources resources, boolean groupFinished) {
        boolean z;
        List<? extends AgentContentBlock> list = blocks;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof AgentContentBlock.Toolcall) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((AgentContentBlock.Toolcall) it.next()).getToolCallInfo());
        }
        ArrayList arrayList4 = arrayList3;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                if (((AgentContentBlock) it2.next()) instanceof AgentContentBlock.Thinking) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : arrayList2) {
            ConfirmInfo confirmInfo = ((AgentContentBlock.Toolcall) obj2).getConfirmInfo();
            if (confirmInfo != null && confirmInfo.isWaitingConfirm()) {
                arrayList5.add(obj2);
            }
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it3 = arrayList5.iterator();
        while (it3.hasNext()) {
            String id = ((AgentContentBlock.Toolcall) it3.next()).getToolCallInfo().getId();
            if (id != null) {
                arrayList6.add(id);
            }
        }
        return ToolDisplayCategory.INSTANCE.buildDynamicGroupTitle(arrayList4, z, resources, groupFinished, CollectionsKt.toSet(arrayList6));
    }

    private final boolean computeGroupFinished(List<ParsedToolCallInfo> toolcalls, boolean hasThinking, List<? extends AgentContentBlock> children, GroupingContext context) {
        if (context.isHistory()) {
            return true;
        }
        if (!toolcalls.isEmpty()) {
            List<ParsedToolCallInfo> list = toolcalls;
            if ((list instanceof Collection) && list.isEmpty()) {
                return true;
            }
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (!INSTANCE.isToolcallFinished((ParsedToolCallInfo) it.next(), children, context)) {
                    return false;
                }
            }
            return true;
        }
        if (!hasThinking) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : children) {
            if (obj instanceof AgentContentBlock.Thinking) {
                arrayList.add(obj);
            }
        }
        AgentContentBlock.Thinking thinking = (AgentContentBlock.Thinking) CollectionsKt.lastOrNull(arrayList);
        return (thinking == null || thinking.isThinking()) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ab, code lost:
    
        if (r5.equals(com.bytedance.trae.im.model.ConfirmInfo.STATUS_SKIPPED) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ca, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b4, code lost:
    
        if (r5.equals("error") == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00bd, code lost:
    
        if (r5.equals("failed") == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c7, code lost:
    
        if (r5.equals("success") == false) goto L68;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:50:0x00a3. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isToolcallFinished(ParsedToolCallInfo toolCallInfo, List<? extends AgentContentBlock> children, GroupingContext context) {
        Object obj;
        int hashCode;
        if (context.isHistory()) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : children) {
            if (obj2 instanceof AgentContentBlock.Toolcall) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((AgentContentBlock.Toolcall) obj).getToolCallInfo().getId(), toolCallInfo.getId())) {
                break;
            }
        }
        AgentContentBlock.Toolcall toolcall = (AgentContentBlock.Toolcall) obj;
        ConfirmInfo confirmInfo = toolcall != null ? toolcall.getConfirmInfo() : null;
        if (confirmInfo != null && confirmInfo.isEnterpriseCommandBlacklist()) {
            return true;
        }
        if (confirmInfo != null && confirmInfo.isWaitingConfirm()) {
            return false;
        }
        ParsedToolCallResult result = toolCallInfo.getResult();
        if ((result != null ? result.getData() : null) == null) {
            if ((result != null ? result.getErrorMessage() : null) == null) {
                String status = result != null ? result.getStatus() : null;
                if (status != null) {
                    switch (status.hashCode()) {
                        case -1867169789:
                            break;
                        case -1281977283:
                            break;
                        case 96784904:
                            break;
                        case 2147444528:
                            break;
                    }
                }
                String confirmStatus = confirmInfo != null ? confirmInfo.getConfirmStatus() : null;
                return confirmStatus != null && ((hashCode = confirmStatus.hashCode()) == -123173735 ? confirmStatus.equals(ConfirmInfo.STATUS_CANCELED) : hashCode == 982142267 ? confirmStatus.equals(ConfirmInfo.STATUS_SKIPPED_RUN) : hashCode == 2147444528 && confirmStatus.equals(ConfirmInfo.STATUS_SKIPPED));
            }
        }
        return true;
    }

    private final String getPlanItemId(AgentContentBlock block) {
        if (block instanceof AgentContentBlock.Thinking) {
            return ((AgentContentBlock.Thinking) block).getPlanItemId();
        }
        if (block instanceof AgentContentBlock.Thought) {
            return ((AgentContentBlock.Thought) block).getPlanItemId();
        }
        if (block instanceof AgentContentBlock.Toolcall) {
            return ((AgentContentBlock.Toolcall) block).getPlanItemId();
        }
        return null;
    }

    private final String getAgentRunId(AgentContentBlock block, Map<String, ParsedPlanItem> planItemMap) {
        ParsedPlanItem parsedPlanItem;
        String planItemId = getPlanItemId(block);
        if (planItemId == null || (parsedPlanItem = planItemMap.get(planItemId)) == null) {
            return null;
        }
        return parsedPlanItem.getAgentRunId();
    }

    private final boolean isExploreTool(String name) {
        return CollectionsKt.contains(EXPLORE_TOOLS, name);
    }

    private final boolean isBrowserTool(String name) {
        return name != null && StringsKt.startsWith$default(name, BROWSER_PREFIX, false, 2, (Object) null);
    }

    private final boolean isFinishTool(String name) {
        return CollectionsKt.contains(FINISH_TOOLS, name);
    }

    private final boolean isTodoTool(String name) {
        return CollectionsKt.contains(TODO_TOOLS, name);
    }

    private final boolean isPureShowWidgetTool(String name) {
        return Intrinsics.areEqual(name, "PureShowWidget");
    }

    private final boolean isSearchTool(String name) {
        return CollectionsKt.contains(SetsKt.setOf(new String[]{"SearchCodebase", "Grep", "Glob", "file_search", "search_codebase", "search_by_regex"}), name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlanItemGrouper.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$TodoItem;", "", "id", "", ReportConstant.COMMON_CONTENT, PageDataManager.EXTRA_STATUS, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getContent", "getStatus", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class TodoItem {
        private final String content;
        private final String id;
        private final String status;

        public static /* synthetic */ TodoItem copy$default(TodoItem todoItem, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = todoItem.id;
            }
            if ((i & 2) != 0) {
                str2 = todoItem.content;
            }
            if ((i & 4) != 0) {
                str3 = todoItem.status;
            }
            return todoItem.copy(str, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* renamed from: component2, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        /* renamed from: component3, reason: from getter */
        public final String getStatus() {
            return this.status;
        }

        public final TodoItem copy(String id, String content, String status) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
            Intrinsics.checkNotNullParameter(status, PageDataManager.EXTRA_STATUS);
            return new TodoItem(id, content, status);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TodoItem)) {
                return false;
            }
            TodoItem todoItem = (TodoItem) other;
            return Intrinsics.areEqual(this.id, todoItem.id) && Intrinsics.areEqual(this.content, todoItem.content) && Intrinsics.areEqual(this.status, todoItem.status);
        }

        public int hashCode() {
            return (((this.id.hashCode() * 31) + this.content.hashCode()) * 31) + this.status.hashCode();
        }

        public String toString() {
            return "TodoItem(id=" + this.id + ", content=" + this.content + ", status=" + this.status + ')';
        }

        public TodoItem(String str, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, ReportConstant.COMMON_CONTENT);
            Intrinsics.checkNotNullParameter(str3, PageDataManager.EXTRA_STATUS);
            this.id = str;
            this.content = str2;
            this.status = str3;
        }

        public final String getId() {
            return this.id;
        }

        public final String getContent() {
            return this.content;
        }

        public final String getStatus() {
            return this.status;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlanItemGrouper.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/chat/grouping/PlanItemGrouper$FilterFinishResult;", "", "filteredBlocks", "", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;", "finishBlocks", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getFilteredBlocks", "()Ljava/util/List;", "getFinishBlocks", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class FilterFinishResult {
        private final List<AgentContentBlock> filteredBlocks;
        private final List<AgentContentBlock> finishBlocks;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ FilterFinishResult copy$default(FilterFinishResult filterFinishResult, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = filterFinishResult.filteredBlocks;
            }
            if ((i & 2) != 0) {
                list2 = filterFinishResult.finishBlocks;
            }
            return filterFinishResult.copy(list, list2);
        }

        public final List<AgentContentBlock> component1() {
            return this.filteredBlocks;
        }

        public final List<AgentContentBlock> component2() {
            return this.finishBlocks;
        }

        public final FilterFinishResult copy(List<? extends AgentContentBlock> filteredBlocks, List<? extends AgentContentBlock> finishBlocks) {
            Intrinsics.checkNotNullParameter(filteredBlocks, "filteredBlocks");
            Intrinsics.checkNotNullParameter(finishBlocks, "finishBlocks");
            return new FilterFinishResult(filteredBlocks, finishBlocks);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FilterFinishResult)) {
                return false;
            }
            FilterFinishResult filterFinishResult = (FilterFinishResult) other;
            return Intrinsics.areEqual(this.filteredBlocks, filterFinishResult.filteredBlocks) && Intrinsics.areEqual(this.finishBlocks, filterFinishResult.finishBlocks);
        }

        public int hashCode() {
            return (this.filteredBlocks.hashCode() * 31) + this.finishBlocks.hashCode();
        }

        public String toString() {
            return "FilterFinishResult(filteredBlocks=" + this.filteredBlocks + ", finishBlocks=" + this.finishBlocks + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public FilterFinishResult(List<? extends AgentContentBlock> list, List<? extends AgentContentBlock> list2) {
            Intrinsics.checkNotNullParameter(list, "filteredBlocks");
            Intrinsics.checkNotNullParameter(list2, "finishBlocks");
            this.filteredBlocks = list;
            this.finishBlocks = list2;
        }

        public final List<AgentContentBlock> getFilteredBlocks() {
            return this.filteredBlocks;
        }

        public final List<AgentContentBlock> getFinishBlocks() {
            return this.finishBlocks;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0078 A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:81:0x0003, B:5:0x000e, B:9:0x0018, B:14:0x0020, B:15:0x0033, B:17:0x0039, B:19:0x0041, B:23:0x004b, B:26:0x0053, B:28:0x005b, B:32:0x0065, B:36:0x0070, B:38:0x0078, B:42:0x0082, B:45:0x008b, B:47:0x0094, B:51:0x009e, B:54:0x00a8, B:57:0x00b1, B:71:0x00b6), top: B:80:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0094 A[Catch: all -> 0x00b9, TryCatch #0 {all -> 0x00b9, blocks: (B:81:0x0003, B:5:0x000e, B:9:0x0018, B:14:0x0020, B:15:0x0033, B:17:0x0039, B:19:0x0041, B:23:0x004b, B:26:0x0053, B:28:0x005b, B:32:0x0065, B:36:0x0070, B:38:0x0078, B:42:0x0082, B:45:0x008b, B:47:0x0094, B:51:0x009e, B:54:0x00a8, B:57:0x00b1, B:71:0x00b6), top: B:80:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0033 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<TodoItem> parseTodosFromParams(JsonObject params) {
        JsonElement jsonElement;
        Iterable asJsonArray;
        TodoItem todoItem;
        JsonObject asJsonObject;
        String str;
        JsonElement jsonElement2;
        String str2;
        JsonElement jsonElement3;
        String str3;
        if (params != null) {
            try {
                jsonElement = params.get("todos");
            } catch (Throwable unused) {
                return null;
            }
        } else {
            jsonElement = null;
        }
        if (jsonElement == null) {
            return null;
        }
        if (!jsonElement.isJsonArray()) {
            jsonElement = null;
        }
        if (jsonElement != null && (asJsonArray = jsonElement.getAsJsonArray()) != null) {
            List<JsonElement> list = CollectionsKt.toList(asJsonArray);
            ArrayList arrayList = new ArrayList();
            for (JsonElement jsonElement4 : list) {
                if (jsonElement4 != null) {
                    if (!jsonElement4.isJsonObject()) {
                        jsonElement4 = null;
                    }
                    if (jsonElement4 != null && (asJsonObject = jsonElement4.getAsJsonObject()) != null) {
                        JsonElement jsonElement5 = asJsonObject.get("id");
                        if (jsonElement5 != null) {
                            if (!jsonElement5.isJsonPrimitive()) {
                                jsonElement5 = null;
                            }
                            if (jsonElement5 != null) {
                                str = jsonElement5.getAsString();
                                String str4 = "";
                                if (str == null) {
                                    str = "";
                                }
                                jsonElement2 = asJsonObject.get(ReportConstant.COMMON_CONTENT);
                                if (jsonElement2 != null) {
                                    if (!jsonElement2.isJsonPrimitive()) {
                                        jsonElement2 = null;
                                    }
                                    if (jsonElement2 != null) {
                                        str2 = jsonElement2.getAsString();
                                        if (str2 == null) {
                                            str2 = "";
                                        }
                                        jsonElement3 = asJsonObject.get(PageDataManager.EXTRA_STATUS);
                                        if (jsonElement3 != null) {
                                            if (!jsonElement3.isJsonPrimitive()) {
                                                jsonElement3 = null;
                                            }
                                            if (jsonElement3 != null) {
                                                str3 = jsonElement3.getAsString();
                                                if (str3 == null) {
                                                    str4 = str3;
                                                }
                                                todoItem = new TodoItem(str, str2, str4);
                                                if (todoItem != null) {
                                                    arrayList.add(todoItem);
                                                }
                                            }
                                        }
                                        str3 = null;
                                        if (str3 == null) {
                                        }
                                        todoItem = new TodoItem(str, str2, str4);
                                        if (todoItem != null) {
                                        }
                                    }
                                }
                                str2 = null;
                                if (str2 == null) {
                                }
                                jsonElement3 = asJsonObject.get(PageDataManager.EXTRA_STATUS);
                                if (jsonElement3 != null) {
                                }
                                str3 = null;
                                if (str3 == null) {
                                }
                                todoItem = new TodoItem(str, str2, str4);
                                if (todoItem != null) {
                                }
                            }
                        }
                        str = null;
                        String str42 = "";
                        if (str == null) {
                        }
                        jsonElement2 = asJsonObject.get(ReportConstant.COMMON_CONTENT);
                        if (jsonElement2 != null) {
                        }
                        str2 = null;
                        if (str2 == null) {
                        }
                        jsonElement3 = asJsonObject.get(PageDataManager.EXTRA_STATUS);
                        if (jsonElement3 != null) {
                        }
                        str3 = null;
                        if (str3 == null) {
                        }
                        todoItem = new TodoItem(str, str2, str42);
                        if (todoItem != null) {
                        }
                    }
                }
                todoItem = null;
                if (todoItem != null) {
                }
            }
            return arrayList;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0099 A[Catch: all -> 0x00db, TryCatch #0 {all -> 0x00db, blocks: (B:4:0x0003, B:9:0x000b, B:11:0x0014, B:15:0x001e, B:19:0x0026, B:21:0x002f, B:25:0x0039, B:29:0x0041, B:30:0x0054, B:32:0x005a, B:34:0x0062, B:38:0x006c, B:41:0x0074, B:43:0x007c, B:47:0x0086, B:51:0x0091, B:53:0x0099, B:57:0x00a3, B:60:0x00ac, B:62:0x00b5, B:66:0x00bf, B:69:0x00c9, B:72:0x00d2, B:86:0x00d7), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b5 A[Catch: all -> 0x00db, TryCatch #0 {all -> 0x00db, blocks: (B:4:0x0003, B:9:0x000b, B:11:0x0014, B:15:0x001e, B:19:0x0026, B:21:0x002f, B:25:0x0039, B:29:0x0041, B:30:0x0054, B:32:0x005a, B:34:0x0062, B:38:0x006c, B:41:0x0074, B:43:0x007c, B:47:0x0086, B:51:0x0091, B:53:0x0099, B:57:0x00a3, B:60:0x00ac, B:62:0x00b5, B:66:0x00bf, B:69:0x00c9, B:72:0x00d2, B:86:0x00d7), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<TodoItem> parseTodosFromResult(ParsedToolCallResult result) {
        JsonElement jsonElement;
        JsonObject asJsonObject;
        JsonElement jsonElement2;
        Iterable asJsonArray;
        TodoItem todoItem;
        JsonObject asJsonObject2;
        String str;
        JsonElement jsonElement3;
        String str2;
        JsonElement jsonElement4;
        String str3;
        if (result == null) {
            return null;
        }
        try {
            JsonObject data = result.getData();
            if (data == null || (jsonElement = data.get("todo_list")) == null) {
                return null;
            }
            if (!jsonElement.isJsonObject()) {
                jsonElement = null;
            }
            if (jsonElement == null || (asJsonObject = jsonElement.getAsJsonObject()) == null || (jsonElement2 = asJsonObject.get("todos")) == null) {
                return null;
            }
            if (!jsonElement2.isJsonArray()) {
                jsonElement2 = null;
            }
            if (jsonElement2 != null && (asJsonArray = jsonElement2.getAsJsonArray()) != null) {
                List<JsonElement> list = CollectionsKt.toList(asJsonArray);
                ArrayList arrayList = new ArrayList();
                for (JsonElement jsonElement5 : list) {
                    if (jsonElement5 != null) {
                        if (!jsonElement5.isJsonObject()) {
                            jsonElement5 = null;
                        }
                        if (jsonElement5 != null && (asJsonObject2 = jsonElement5.getAsJsonObject()) != null) {
                            JsonElement jsonElement6 = asJsonObject2.get("id");
                            if (jsonElement6 != null) {
                                if (!jsonElement6.isJsonPrimitive()) {
                                    jsonElement6 = null;
                                }
                                if (jsonElement6 != null) {
                                    str = jsonElement6.getAsString();
                                    String str4 = "";
                                    if (str == null) {
                                        str = "";
                                    }
                                    jsonElement3 = asJsonObject2.get(ReportConstant.COMMON_CONTENT);
                                    if (jsonElement3 != null) {
                                        if (!jsonElement3.isJsonPrimitive()) {
                                            jsonElement3 = null;
                                        }
                                        if (jsonElement3 != null) {
                                            str2 = jsonElement3.getAsString();
                                            if (str2 == null) {
                                                str2 = "";
                                            }
                                            jsonElement4 = asJsonObject2.get(PageDataManager.EXTRA_STATUS);
                                            if (jsonElement4 != null) {
                                                if (!jsonElement4.isJsonPrimitive()) {
                                                    jsonElement4 = null;
                                                }
                                                if (jsonElement4 != null) {
                                                    str3 = jsonElement4.getAsString();
                                                    if (str3 == null) {
                                                        str4 = str3;
                                                    }
                                                    todoItem = new TodoItem(str, str2, str4);
                                                    if (todoItem != null) {
                                                        arrayList.add(todoItem);
                                                    }
                                                }
                                            }
                                            str3 = null;
                                            if (str3 == null) {
                                            }
                                            todoItem = new TodoItem(str, str2, str4);
                                            if (todoItem != null) {
                                            }
                                        }
                                    }
                                    str2 = null;
                                    if (str2 == null) {
                                    }
                                    jsonElement4 = asJsonObject2.get(PageDataManager.EXTRA_STATUS);
                                    if (jsonElement4 != null) {
                                    }
                                    str3 = null;
                                    if (str3 == null) {
                                    }
                                    todoItem = new TodoItem(str, str2, str4);
                                    if (todoItem != null) {
                                    }
                                }
                            }
                            str = null;
                            String str42 = "";
                            if (str == null) {
                            }
                            jsonElement3 = asJsonObject2.get(ReportConstant.COMMON_CONTENT);
                            if (jsonElement3 != null) {
                            }
                            str2 = null;
                            if (str2 == null) {
                            }
                            jsonElement4 = asJsonObject2.get(PageDataManager.EXTRA_STATUS);
                            if (jsonElement4 != null) {
                            }
                            str3 = null;
                            if (str3 == null) {
                            }
                            todoItem = new TodoItem(str, str2, str42);
                            if (todoItem != null) {
                            }
                        }
                    }
                    todoItem = null;
                    if (todoItem != null) {
                    }
                }
                return arrayList;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
