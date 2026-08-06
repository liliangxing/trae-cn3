package com.bytedance.trae.im.service;

import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedPlanItem;
import com.bytedance.trae.im.model.ParsedPlanItemMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMMessage.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\f\u0010\b\u001a\u00020\u0005*\u00020\u0004H\u0002\u001a\u001c\u0010\u0011\u001a\u00020\u0012*\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0001\u001a\n\u0010\u0016\u001a\u00020\u0012*\u00020\u0004\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0017\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u001b\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"AGENT_FLOW_TAG", "", "aggregatorMap", "Ljava/util/IdentityHashMap;", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "Lcom/bytedance/trae/im/service/PlanItemAggregator;", "normalizeDoneStatus", PageDataManager.EXTRA_STATUS, "getOrCreateAggregator", "taskId", "getTaskId", "(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/lang/String;", "items", "", "Lcom/bytedance/trae/im/model/ParsedPlanItem;", "getItems", "(Lcom/bytedance/trae/im/model/ParsedChatMessage;)Ljava/util/List;", "applyEvent", "", Fields.EVENT, "Lcom/bytedance/trae/im/service/ChatEvent;", TimonPipeline.KEY_SOURCE, "releaseAggregator", "im_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IMMessageKt {
    private static final String AGENT_FLOW_TAG = "AgentDataFlow_IMMessage";
    private static final IdentityHashMap<ParsedChatMessage, PlanItemAggregator> aggregatorMap = new IdentityHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    public static final String normalizeDoneStatus(String str) {
        if (str == null) {
            return str;
        }
        switch (str.hashCode()) {
            case -1402931637:
                if (!str.equals("completed")) {
                    return str;
                }
                return "completed";
            case -1281977283:
                if (!str.equals("failed")) {
                    return str;
                }
                return "failed";
            case -995321554:
                return !str.equals("paused") ? str : "paused";
            case -753541113:
                if (!str.equals("in_progress")) {
                    return str;
                }
                return "in_progress";
            case -673660814:
                if (!str.equals("finished")) {
                    return str;
                }
                return "completed";
            case -315615134:
                if (!str.equals("streaming")) {
                    return str;
                }
                return "in_progress";
            case -123173735:
                if (!str.equals(ConfirmInfo.STATUS_CANCELED)) {
                    return str;
                }
                return ConfirmInfo.STATUS_CANCELED;
            case 96784904:
                if (!str.equals("error")) {
                    return str;
                }
                return "failed";
            case 476588369:
                if (!str.equals("cancelled")) {
                    return str;
                }
                return ConfirmInfo.STATUS_CANCELED;
            case 1550783935:
                if (!str.equals("running")) {
                    return str;
                }
                return "in_progress";
            default:
                return str;
        }
    }

    private static final PlanItemAggregator getOrCreateAggregator(ParsedChatMessage parsedChatMessage) {
        IdentityHashMap<ParsedChatMessage, PlanItemAggregator> identityHashMap = aggregatorMap;
        PlanItemAggregator planItemAggregator = identityHashMap.get(parsedChatMessage);
        if (planItemAggregator == null) {
            planItemAggregator = new PlanItemAggregator();
            identityHashMap.put(parsedChatMessage, planItemAggregator);
        }
        return planItemAggregator;
    }

    public static final String getTaskId(ParsedChatMessage parsedChatMessage) {
        Intrinsics.checkNotNullParameter(parsedChatMessage, "<this>");
        ParsedTaskContent taskContent = parsedChatMessage.getTaskContent();
        if (taskContent != null) {
            return taskContent.getTaskId();
        }
        return null;
    }

    public static final List<ParsedPlanItem> getItems(ParsedChatMessage parsedChatMessage) {
        List<ParsedPlanItemMessage> messages;
        Intrinsics.checkNotNullParameter(parsedChatMessage, "<this>");
        PlanItemAggregator planItemAggregator = aggregatorMap.get(parsedChatMessage);
        if (planItemAggregator == null) {
            ParsedTaskContent taskContent = parsedChatMessage.getTaskContent();
            if (taskContent == null || (messages = taskContent.getMessages()) == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = messages.iterator();
            while (it.hasNext()) {
                ParsedPlanItem planItem = ((ParsedPlanItemMessage) it.next()).getPlanItem();
                if (planItem != null) {
                    arrayList.add(planItem);
                }
            }
            return arrayList;
        }
        return planItemAggregator.getAllItems();
    }

    public static /* synthetic */ void applyEvent$default(ParsedChatMessage parsedChatMessage, ChatEvent chatEvent, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "unknown";
        }
        applyEvent(parsedChatMessage, chatEvent, str);
    }

    public static final void applyEvent(ParsedChatMessage parsedChatMessage, ChatEvent chatEvent, String str) {
        Intrinsics.checkNotNullParameter(parsedChatMessage, "<this>");
        Intrinsics.checkNotNullParameter(chatEvent, Fields.EVENT);
        Intrinsics.checkNotNullParameter(str, TimonPipeline.KEY_SOURCE);
        getOrCreateAggregator(parsedChatMessage).apply(parsedChatMessage, chatEvent, str);
    }

    public static final void releaseAggregator(ParsedChatMessage parsedChatMessage) {
        Intrinsics.checkNotNullParameter(parsedChatMessage, "<this>");
        aggregatorMap.remove(parsedChatMessage);
    }
}
