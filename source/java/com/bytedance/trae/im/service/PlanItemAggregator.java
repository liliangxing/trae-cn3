package com.bytedance.trae.im.service;

import com.bytedance.timonbase.pipeline.TimonPipeline;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.im.log.IMApmEvent;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.ModelSmartSelectionMeta;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedError;
import com.bytedance.trae.im.model.ParsedPlanItem;
import com.bytedance.trae.im.model.ParsedPlanItemMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.im.model.ParsedToolCallInfo;
import com.bytedance.trae.im.model.ParsedToolCallResult;
import com.bytedance.trae.im.service.ChatEventPayload;
import com.bytedance.trae.utils.logger.FLogger;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMMessage.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u0006J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u0006H\u0002J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/bytedance/trae/im/service/PlanItemAggregator;", "", "<init>", "()V", "planItemMap", "Ljava/util/LinkedHashMap;", "", "Lcom/bytedance/trae/im/model/ParsedPlanItem;", "Lkotlin/collections/LinkedHashMap;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "currentPlanItemId", "currentToolCall", "Lcom/bytedance/trae/im/model/ParsedToolCallInfo;", "allItems", "", "getAllItems", "()Ljava/util/List;", "apply", "", "message", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", Fields.EVENT, "Lcom/bytedance/trae/im/service/ChatEvent;", TimonPipeline.KEY_SOURCE, "appendNameIfNotSame", "currentName", "newName", "syncTaskContent", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PlanItemAggregator {
    private String currentPlanItemId;
    private ParsedToolCallInfo currentToolCall;
    private final LinkedHashMap<String, ParsedPlanItem> planItemMap = new LinkedHashMap<>();

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private final Lazy gson = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.im.service.PlanItemAggregator$$ExternalSyntheticLambda0
        public final Object invoke() {
            Gson gson_delegate$lambda$0;
            gson_delegate$lambda$0 = PlanItemAggregator.gson_delegate$lambda$0();
            return gson_delegate$lambda$0;
        }
    });

    private final Gson getGson() {
        return (Gson) this.gson.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson gson_delegate$lambda$0() {
        return new Gson();
    }

    public final List<ParsedPlanItem> getAllItems() {
        Collection<ParsedPlanItem> values = this.planItemMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return CollectionsKt.toList(values);
    }

    public static /* synthetic */ void apply$default(PlanItemAggregator planItemAggregator, ParsedChatMessage parsedChatMessage, ChatEvent chatEvent, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "unknown";
        }
        planItemAggregator.apply(parsedChatMessage, chatEvent, str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:193|(3:195|(1:197)|(14:199|200|(3:(1:203)(1:272)|204|(10:206|207|(1:271)(1:211)|(4:(5:236|(1:238)(1:244)|239|(1:241)(1:243)|242)(1:215)|216|(3:219|(1:221)(1:223)|222)|224)(3:245|(4:247|(1:249)(1:260)|(1:251)|(3:253|(2:(1:256)(1:258)|257)|259))|(3:262|(1:264)(1:270)|(2:266|(1:268))(1:269)))|225|226|227|(1:231)|232|233))|273|207|(0)|271|(0)(0)|225|226|227|(2:229|231)|232|233))|274|200|(0)|273|207|(0)|271|(0)(0)|225|226|227|(0)|232|233) */
    /* JADX WARN: Can't wrap try/catch for region: R(8:104|(3:106|(1:108)|(6:110|111|112|(1:114)(1:129)|115|116))|131|111|112|(0)(0)|115|116) */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x00c2, code lost:
    
        if (r2 == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x038b, code lost:
    
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x04e1, code lost:
    
        if ((r6.length() > 0) != false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x05f5, code lost:
    
        if ((r0.length() > 0) != false) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x08bb, code lost:
    
        r15 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x019c, code lost:
    
        if (r2 == null) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x037b A[Catch: Exception -> 0x038b, TRY_LEAVE, TryCatch #2 {Exception -> 0x038b, blocks: (B:112:0x0375, B:114:0x037b), top: B:111:0x0375 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x05e9  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x05fb  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x071e  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0727 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0728  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0735  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x074d  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0772 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x077c  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x08be  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x085d  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x06e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x070c  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void apply(ParsedChatMessage message, ChatEvent event, String source) {
        String normalizeDoneStatus;
        String str;
        boolean z;
        ChatEventPayload.PlanItem planItem;
        String str2;
        Boolean bool;
        String str3;
        String thought;
        String str4;
        boolean z2;
        JsonElement confirmInfo;
        boolean z3;
        PlanItemAggregator planItemAggregator;
        ConfirmInfo confirmInfo2;
        boolean z4;
        ToolCallInfo toolCallInfo;
        String id;
        JsonElement params;
        JsonObject jsonObject;
        ParsedToolCallInfo parsedToolCallInfo;
        boolean z5;
        boolean areEqual;
        boolean areEqual2;
        JsonElement jsonElement;
        ParsedToolCallResult parsedToolCallResult;
        ParsedToolCallInfo parsedToolCallInfo2;
        ParsedPlanItem parsedPlanItem;
        ParsedPlanItem parsedPlanItem2;
        ParsedToolCallInfo parsedToolCallInfo3;
        ConfirmInfo confirmInfo3;
        JsonObject jsonObject2;
        long createdAt;
        Boolean fromAppend;
        Long versionCode;
        JsonElement modelSmartSelectionMeta;
        ModelSmartSelectionMeta modelSmartSelectionMeta2;
        UserMessageContext userMessageContext;
        ModelInfo modelInfo;
        String displayModelName;
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        Intrinsics.checkNotNullParameter(source, TimonPipeline.KEY_SOURCE);
        ChatEventPayload data = event.getData();
        if (data instanceof ChatEventPayload.Metadata) {
            ChatEventPayload.Metadata metadata = (ChatEventPayload.Metadata) data;
            TraeLogUtil.INSTANCE.d("AgentDataFlow_IMMessage", "IMMessage: [Node2] Aggregator.Metadata: source=" + source + ", seq=" + event.getSeq() + ", agentType=" + metadata.getAgentType() + ", agentId=" + metadata.getAgentId() + ", status=" + metadata.getStatus() + ", messageType=" + metadata.getMessageType() + ", payload=" + IMService.INSTANCE.getGson().toJson(data) + ",message=" + IMService.INSTANCE.getGson().toJson(message));
            String messageId = metadata.getMessageId();
            if (messageId != null) {
                if (!(messageId.length() > 0)) {
                    messageId = null;
                }
            }
            messageId = message.getMessageId();
            message.setMessageId(messageId);
            message.setTurnId(metadata.getTurnId());
            message.setHasMetaData(true);
            String status = metadata.getStatus();
            if (status == null) {
                status = message.getStatus();
            }
            message.setStatus(status);
            String messageType = metadata.getMessageType();
            if (messageType == null) {
                messageType = message.getMessageType();
            }
            message.setMessageType(messageType);
            Integer messageIndex = metadata.getMessageIndex();
            message.setMessageIndex(messageIndex != null ? messageIndex.intValue() : message.getMessageIndex());
            message.setReplyToMessageId(metadata.getReplyToMessageId());
            message.setAgentType(metadata.getAgentType());
            message.setAgentId(metadata.getAgentId());
            message.setAgentName(metadata.getAgentName());
            message.setAgentAvatarId(metadata.getAgentAvatarId());
            message.setTraceId(metadata.getTraceId());
            Long createdAt2 = metadata.getCreatedAt();
            if (createdAt2 != null) {
                if (!(createdAt2.longValue() > 0)) {
                    createdAt2 = null;
                }
                if (createdAt2 != null) {
                    createdAt = ParsedChatMessage.INSTANCE.normalizeToMillis(createdAt2.longValue());
                    message.setCreatedAt(createdAt);
                    message.setChatProcessVersion(metadata.getChatProcessVersion());
                    message.setAgentProcessSupport(metadata.getAgentProcessSupport());
                    fromAppend = metadata.getFromAppend();
                    if (fromAppend == null) {
                        fromAppend = message.getFromAppendMsg();
                    }
                    message.setFromAppendMsg(fromAppend);
                    message.setWorktree(metadata.isWorktree());
                    message.setChatStartTime(metadata.getChatStartTime());
                    versionCode = metadata.getVersionCode();
                    if (versionCode != null) {
                        if (!(versionCode.longValue() > 0)) {
                            versionCode = null;
                        }
                    }
                    versionCode = message.getVersionCode();
                    message.setVersionCode(versionCode);
                    message.setShallowMementoType(metadata.getShallowMementoType());
                    modelSmartSelectionMeta = metadata.getModelSmartSelectionMeta();
                    if (modelSmartSelectionMeta != null) {
                        try {
                            modelSmartSelectionMeta2 = (ModelSmartSelectionMeta) getGson().fromJson(modelSmartSelectionMeta, ModelSmartSelectionMeta.class);
                        } catch (Exception unused) {
                            modelSmartSelectionMeta2 = null;
                        }
                        message.setModelSmartSelectionMeta(modelSmartSelectionMeta2);
                        Unit unit = Unit.INSTANCE;
                        Unit unit2 = Unit.INSTANCE;
                    }
                    userMessageContext = metadata.getUserMessageContext();
                    if (userMessageContext != null || (modelInfo = userMessageContext.getModelInfo()) == null || (displayModelName = modelInfo.getDisplayModelName()) == null) {
                        return;
                    }
                    message.setStreamingChatModel(displayModelName);
                    Unit unit3 = Unit.INSTANCE;
                    Unit unit4 = Unit.INSTANCE;
                    return;
                }
            }
            createdAt = message.getCreatedAt();
            message.setCreatedAt(createdAt);
            message.setChatProcessVersion(metadata.getChatProcessVersion());
            message.setAgentProcessSupport(metadata.getAgentProcessSupport());
            fromAppend = metadata.getFromAppend();
            if (fromAppend == null) {
            }
            message.setFromAppendMsg(fromAppend);
            message.setWorktree(metadata.isWorktree());
            message.setChatStartTime(metadata.getChatStartTime());
            versionCode = metadata.getVersionCode();
            if (versionCode != null) {
            }
            versionCode = message.getVersionCode();
            message.setVersionCode(versionCode);
            message.setShallowMementoType(metadata.getShallowMementoType());
            modelSmartSelectionMeta = metadata.getModelSmartSelectionMeta();
            if (modelSmartSelectionMeta != null) {
            }
            userMessageContext = metadata.getUserMessageContext();
            if (userMessageContext != null) {
                return;
            } else {
                return;
            }
        }
        if (data instanceof ChatEventPayload.PlanItem) {
            ChatEventPayload.PlanItem planItem2 = (ChatEventPayload.PlanItem) data;
            String id2 = planItem2.getId();
            if (id2 == null) {
                return;
            }
            TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
            StringBuilder sb = new StringBuilder("[Node2] Aggregator.PlanItem: source=");
            StringBuilder append = sb.append(source).append(", seq=").append(event.getSeq()).append(", id=").append(id2).append(", currentPlanItemId=").append(this.currentPlanItemId).append(", hasThought=").append(planItem2.getThought() != null).append(", hasReasoning=").append(planItem2.getReasoningContent() != null).append(", hasTool=").append(planItem2.getToolCallInfo() != null).append(", toolName=");
            ToolCallInfo toolCallInfo2 = planItem2.getToolCallInfo();
            append.append(toolCallInfo2 != null ? toolCallInfo2.getName() : null).append(", agentId=").append(planItem2.getAgentId()).append(", agentRunId=").append(planItem2.getAgentRunId()).append(", cleanThought=").append(event.getCleanThought()).append(", thoughtFirstData=");
            sb.append(event.getThoughtFirstData()).append(", toolcallFirstData=").append(event.getToolcallFirstData()).append(",payload=").append(IMService.INSTANCE.getGson().toJson(data)).append(",message=").append(IMService.INSTANCE.getGson().toJson(message));
            traeLogUtil.d("AgentDataFlow_IMMessage", sb.toString());
            if (!Intrinsics.areEqual(id2, this.currentPlanItemId)) {
                this.currentPlanItemId = id2;
                ParsedPlanItem parsedPlanItem3 = this.planItemMap.get(id2);
                this.currentToolCall = parsedPlanItem3 != null ? parsedPlanItem3.getToolCallInfo() : null;
            }
            if (message.getHasMetaData() == null || Intrinsics.areEqual(message.getHasMetaData(), false)) {
                if (planItem2.getReplyToMessageId() != null) {
                    IMApmEvent.INSTANCE.reportMessageStatus(message, planItem2.getReplyToMessageId(), "no_meta_data");
                } else {
                    IMApmEvent.INSTANCE.reportMessageStatus(message, "", "no_meta_data");
                }
            } else if (planItem2.getReplyToMessageId() != null && !Intrinsics.areEqual(planItem2.getReplyToMessageId(), message.getReplyToMessageId())) {
                IMApmEvent.INSTANCE.reportMessageStatus(message, planItem2.getReplyToMessageId(), "reply_to_message_is_not_same");
            }
            if (Intrinsics.areEqual(source, "http")) {
                ToolCallInfo toolCallInfo3 = planItem2.getToolCallInfo();
                if (toolCallInfo3 != null) {
                    JsonElement params2 = toolCallInfo3.getParams();
                    if (params2 != null) {
                        if (!params2.isJsonObject()) {
                            params2 = null;
                        }
                        if (params2 != null) {
                            jsonObject2 = params2.getAsJsonObject();
                            JsonElement result = toolCallInfo3.getResult();
                            ParsedToolCallResult parsedToolCallResult2 = result == null ? (ParsedToolCallResult) getGson().fromJson(result, ParsedToolCallResult.class) : null;
                            parsedToolCallInfo3 = new ParsedToolCallInfo(toolCallInfo3.getId(), toolCallInfo3.getName(), jsonObject2, parsedToolCallResult2, null, 16, null);
                        }
                    }
                    jsonObject2 = null;
                    JsonElement result2 = toolCallInfo3.getResult();
                    ParsedToolCallResult parsedToolCallResult22 = result2 == null ? (ParsedToolCallResult) getGson().fromJson(result2, ParsedToolCallResult.class) : null;
                    parsedToolCallInfo3 = new ParsedToolCallInfo(toolCallInfo3.getId(), toolCallInfo3.getName(), jsonObject2, parsedToolCallResult22, null, 16, null);
                } else {
                    parsedToolCallInfo3 = null;
                }
                try {
                    JsonElement confirmInfo4 = ((ChatEventPayload.PlanItem) data).getConfirmInfo();
                    confirmInfo3 = confirmInfo4 != null ? (ConfirmInfo) getGson().fromJson(confirmInfo4, ConfirmInfo.class) : null;
                } catch (Exception unused2) {
                    confirmInfo3 = null;
                }
                this.planItemMap.put(id2, new ParsedPlanItem(id2, planItem2.getAgentId(), planItem2.getAgentDisplayName(), planItem2.getAgentRunId(), planItem2.getSubAgentCallDescription(), planItem2.getThought(), null, planItem2.getReasoningContent(), parsedToolCallInfo3, confirmInfo3, planItem2.getHide(), 64, null));
                this.currentToolCall = parsedToolCallInfo3;
                syncTaskContent(message);
                return;
            }
            LinkedHashMap<String, ParsedPlanItem> linkedHashMap = this.planItemMap;
            ParsedPlanItem parsedPlanItem4 = linkedHashMap.get(id2);
            if (parsedPlanItem4 == null) {
                parsedPlanItem4 = new ParsedPlanItem(id2, planItem2.getAgentId(), planItem2.getAgentDisplayName(), planItem2.getAgentRunId(), planItem2.getSubAgentCallDescription(), null, null, null, null, null, planItem2.getHide(), 992, null);
                linkedHashMap.put(id2, parsedPlanItem4);
            }
            ParsedPlanItem parsedPlanItem5 = parsedPlanItem4;
            if (parsedPlanItem5.getAgentId() == null) {
                parsedPlanItem5.setAgentId(planItem2.getAgentId());
            }
            if (parsedPlanItem5.getAgentRunId() == null) {
                parsedPlanItem5.setAgentRunId(planItem2.getAgentRunId());
            }
            if (parsedPlanItem5.getAgentDisplayName() == null) {
                parsedPlanItem5.setAgentDisplayName(planItem2.getAgentDisplayName());
            }
            String subAgentCallDescription = planItem2.getSubAgentCallDescription();
            if (subAgentCallDescription != null) {
                parsedPlanItem5.setSubAgentCallDescription(subAgentCallDescription);
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
            }
            Boolean hide = planItem2.getHide();
            if (hide != null) {
                parsedPlanItem5.setHide(Boolean.valueOf(hide.booleanValue()));
                Unit unit7 = Unit.INSTANCE;
                Unit unit8 = Unit.INSTANCE;
            }
            if (Intrinsics.areEqual(event.getCleanThought(), true)) {
                str = "";
                TraeLogUtil.INSTANCE.d("AgentDataFlow_IMMessage", "[Node2] Aggregator.PlanItem clean_thought: source=" + source + ", seq=" + event.getSeq() + ", planItemId=" + id2 + ", oldThought=" + parsedPlanItem5.getThought());
                parsedPlanItem5.setThought(null);
            } else {
                str = "";
            }
            boolean areEqual3 = Intrinsics.areEqual(event.getThoughtFirstData(), true);
            String reasoningContent = planItem2.getReasoningContent();
            if (reasoningContent != null) {
            }
            reasoningContent = null;
            if (reasoningContent == null) {
                z = areEqual3;
                planItem = planItem2;
                str2 = ", oldThought=";
                bool = true;
            } else if (areEqual3) {
                bool = true;
                str2 = ", oldThought=";
                TraeLogUtil.INSTANCE.d("AgentDataFlow_IMMessage", "[Node2] Aggregator.PlanItem thought_first_data overwrite reasoning: source=" + source + ", seq=" + event.getSeq() + ", planItemId=" + id2 + ", reasoning=" + reasoningContent + ", oldReasoning=" + parsedPlanItem5.getReasoningContent());
                parsedPlanItem5.setReasoningContent(reasoningContent);
                z = areEqual3;
                planItem = planItem2;
            } else {
                str2 = ", oldThought=";
                bool = true;
                String reasoningContent2 = parsedPlanItem5.getReasoningContent();
                if (reasoningContent2 != null) {
                    z = areEqual3;
                    planItem = planItem2;
                    parsedPlanItem2 = parsedPlanItem5;
                    if (StringsKt.contains$default(reasoningContent2, reasoningContent, false, 2, (Object) null)) {
                        str3 = ", message=";
                        TraeLogUtil.INSTANCE.d("AgentDataFlow_IMMessage", "[Node2] Aggregator.PlanItem DUPLICATE reasoning: source=" + source + ", seq=" + event.getSeq() + ", planItemId=" + id2 + ", reasoning=" + reasoningContent + ", existingReasoning=" + reasoningContent2 + ", payload=" + IMService.INSTANCE.getGson().toJson(data) + str3 + IMService.INSTANCE.getGson().toJson(message));
                        StringBuilder sb2 = new StringBuilder();
                        if (reasoningContent2 == null) {
                            reasoningContent2 = str;
                        }
                        parsedPlanItem5 = parsedPlanItem2;
                        parsedPlanItem5.setReasoningContent(sb2.append(reasoningContent2).append(reasoningContent).toString());
                        thought = planItem.getThought();
                        if (thought != null) {
                        }
                        thought = null;
                        if (thought != null) {
                            if (z) {
                                TraeLogUtil.INSTANCE.d("AgentDataFlow_IMMessage", "[Node2] Aggregator.PlanItem thought_first_data overwrite thought: source=" + source + ", seq=" + event.getSeq() + ", planItemId=" + id2 + ", thought=" + thought + str2 + parsedPlanItem5.getThought());
                                parsedPlanItem5.setThought(thought);
                            } else {
                                String thought2 = parsedPlanItem5.getThought();
                                if (thought2 != null) {
                                    parsedPlanItem = parsedPlanItem5;
                                    z2 = false;
                                    if (StringsKt.contains$default(thought2, thought, false, 2, (Object) null)) {
                                        str4 = "AgentDataFlow_IMMessage";
                                        TraeLogUtil.INSTANCE.d(str4, "[Node2] Aggregator.PlanItem DUPLICATE thought: source=" + source + ", seq=" + event.getSeq() + ", planItemId=" + id2 + ", thought=" + thought + ", existingThought=" + thought2 + ", payload=" + IMService.INSTANCE.getGson().toJson(data) + str3 + IMService.INSTANCE.getGson().toJson(message));
                                    } else {
                                        str4 = "AgentDataFlow_IMMessage";
                                    }
                                } else {
                                    parsedPlanItem = parsedPlanItem5;
                                    str4 = "AgentDataFlow_IMMessage";
                                    z2 = false;
                                }
                                parsedPlanItem5 = parsedPlanItem;
                                parsedPlanItem5.setThought((thought2 == null ? str : thought2) + thought);
                                confirmInfo = planItem.getConfirmInfo();
                                if (confirmInfo == null) {
                                    try {
                                        parsedPlanItem5.setConfirmInfo((ConfirmInfo) getGson().fromJson(confirmInfo, ConfirmInfo.class));
                                        confirmInfo2 = parsedPlanItem5.getConfirmInfo();
                                    } catch (Exception unused3) {
                                        z3 = true;
                                    }
                                    if (confirmInfo2 != null) {
                                        z3 = true;
                                        if (confirmInfo2.isWaitingConfirm()) {
                                            z4 = true;
                                            if (z4) {
                                                planItemAggregator = this;
                                                try {
                                                    parsedPlanItem5.setToolCallInfo(planItemAggregator.currentToolCall);
                                                } catch (Exception unused4) {
                                                }
                                                Unit unit9 = Unit.INSTANCE;
                                                Unit unit10 = Unit.INSTANCE;
                                            }
                                            planItemAggregator = this;
                                            Unit unit92 = Unit.INSTANCE;
                                            Unit unit102 = Unit.INSTANCE;
                                        }
                                    } else {
                                        z3 = true;
                                    }
                                    z4 = z2;
                                    if (z4) {
                                    }
                                    planItemAggregator = this;
                                    Unit unit922 = Unit.INSTANCE;
                                    Unit unit1022 = Unit.INSTANCE;
                                } else {
                                    z3 = true;
                                    planItemAggregator = this;
                                }
                                toolCallInfo = planItem.getToolCallInfo();
                                if (toolCallInfo == null && (id = toolCallInfo.getId()) != null) {
                                    params = toolCallInfo.getParams();
                                    if (params != null) {
                                        if (!params.isJsonObject()) {
                                            params = null;
                                        }
                                        if (params != null) {
                                            jsonObject = params.getAsJsonObject();
                                            JsonElement result3 = toolCallInfo.getResult();
                                            parsedToolCallInfo = planItemAggregator.currentToolCall;
                                            if (parsedToolCallInfo != null) {
                                                if (Intrinsics.areEqual(parsedToolCallInfo != null ? parsedToolCallInfo.getId() : null, id)) {
                                                    z5 = z3;
                                                    Boolean bool2 = bool;
                                                    areEqual = Intrinsics.areEqual(event.getNewToolCall(), bool2);
                                                    areEqual2 = Intrinsics.areEqual(event.getToolcallFirstData(), bool2);
                                                    if (!(z5 || areEqual || areEqual2)) {
                                                        if (areEqual2 || areEqual) {
                                                            TraeLogUtil traeLogUtil2 = TraeLogUtil.INSTANCE;
                                                            jsonElement = result3;
                                                            StringBuilder append2 = new StringBuilder("[Node2] Aggregator.PlanItem toolcall_first_data=").append(areEqual2).append(", isNewToolCall=").append(areEqual).append(", source=").append(source).append(", seq=").append(event.getSeq()).append(", planItemId=").append(id2).append(", toolId=").append(id).append(", oldName=");
                                                            ParsedToolCallInfo parsedToolCallInfo4 = planItemAggregator.currentToolCall;
                                                            StringBuilder append3 = append2.append(parsedToolCallInfo4 != null ? parsedToolCallInfo4.getName() : null).append(", oldParams=");
                                                            ParsedToolCallInfo parsedToolCallInfo5 = planItemAggregator.currentToolCall;
                                                            traeLogUtil2.d(str4, append3.append(parsedToolCallInfo5 != null ? parsedToolCallInfo5.getParams() : null).toString());
                                                        } else {
                                                            jsonElement = result3;
                                                        }
                                                        if (planItemAggregator.currentToolCall != null && !z5) {
                                                            TraeLogUtil traeLogUtil3 = TraeLogUtil.INSTANCE;
                                                            StringBuilder append4 = new StringBuilder("[Node2] ToolCall id changed: source=").append(source).append(", seq=").append(event.getSeq()).append(", old=");
                                                            ParsedToolCallInfo parsedToolCallInfo6 = planItemAggregator.currentToolCall;
                                                            traeLogUtil3.d(str4, append4.append(parsedToolCallInfo6 != null ? parsedToolCallInfo6.getId() : null).append(", new=").append(id).append(", planItemId=").append(id2).toString());
                                                        }
                                                        ParsedToolCallInfo parsedToolCallInfo7 = new ParsedToolCallInfo(id, toolCallInfo.getName(), jsonObject, null, null, 24, null);
                                                        planItemAggregator.currentToolCall = parsedToolCallInfo7;
                                                        parsedPlanItem5.setToolCallInfo(parsedToolCallInfo7);
                                                    } else {
                                                        jsonElement = result3;
                                                        String name = toolCallInfo.getName();
                                                        if (name != null) {
                                                            if (!(name.length() > 0)) {
                                                                name = null;
                                                            }
                                                            if (name != null) {
                                                                ParsedToolCallInfo parsedToolCallInfo8 = planItemAggregator.currentToolCall;
                                                                if (parsedToolCallInfo8 != null) {
                                                                    parsedToolCallInfo8.setName(planItemAggregator.appendNameIfNotSame(parsedToolCallInfo8 != null ? parsedToolCallInfo8.getName() : null, name));
                                                                    Unit unit11 = Unit.INSTANCE;
                                                                }
                                                                Unit unit12 = Unit.INSTANCE;
                                                                Unit unit13 = Unit.INSTANCE;
                                                            }
                                                        }
                                                        if (jsonObject != null) {
                                                            ParsedToolCallInfo parsedToolCallInfo9 = planItemAggregator.currentToolCall;
                                                            JsonObject params3 = parsedToolCallInfo9 != null ? parsedToolCallInfo9.getParams() : null;
                                                            if (params3 == null) {
                                                                ParsedToolCallInfo parsedToolCallInfo10 = planItemAggregator.currentToolCall;
                                                                if (parsedToolCallInfo10 != null) {
                                                                    parsedToolCallInfo10.setParams(jsonObject);
                                                                    Unit unit14 = Unit.INSTANCE;
                                                                }
                                                            } else {
                                                                JsonUtilsKt.mergeJsonObjects(params3, jsonObject);
                                                            }
                                                        }
                                                    }
                                                    parsedToolCallResult = (ParsedToolCallResult) getGson().fromJson(jsonElement, ParsedToolCallResult.class);
                                                    if (parsedToolCallResult != null && (parsedToolCallInfo2 = planItemAggregator.currentToolCall) != null) {
                                                        parsedToolCallInfo2.setResult(parsedToolCallResult);
                                                        Unit unit15 = Unit.INSTANCE;
                                                    }
                                                    syncTaskContent(message);
                                                    Unit unit16 = Unit.INSTANCE;
                                                    return;
                                                }
                                            }
                                            z5 = z2;
                                            Boolean bool22 = bool;
                                            areEqual = Intrinsics.areEqual(event.getNewToolCall(), bool22);
                                            areEqual2 = Intrinsics.areEqual(event.getToolcallFirstData(), bool22);
                                            if (!(z5 || areEqual || areEqual2)) {
                                            }
                                            parsedToolCallResult = (ParsedToolCallResult) getGson().fromJson(jsonElement, ParsedToolCallResult.class);
                                            if (parsedToolCallResult != null) {
                                                parsedToolCallInfo2.setResult(parsedToolCallResult);
                                                Unit unit152 = Unit.INSTANCE;
                                            }
                                            syncTaskContent(message);
                                            Unit unit162 = Unit.INSTANCE;
                                            return;
                                        }
                                    }
                                    jsonObject = null;
                                    JsonElement result32 = toolCallInfo.getResult();
                                    parsedToolCallInfo = planItemAggregator.currentToolCall;
                                    if (parsedToolCallInfo != null) {
                                    }
                                    z5 = z2;
                                    Boolean bool222 = bool;
                                    areEqual = Intrinsics.areEqual(event.getNewToolCall(), bool222);
                                    areEqual2 = Intrinsics.areEqual(event.getToolcallFirstData(), bool222);
                                    if (!(z5 || areEqual || areEqual2)) {
                                    }
                                    parsedToolCallResult = (ParsedToolCallResult) getGson().fromJson(jsonElement, ParsedToolCallResult.class);
                                    if (parsedToolCallResult != null) {
                                    }
                                    syncTaskContent(message);
                                    Unit unit1622 = Unit.INSTANCE;
                                    return;
                                }
                                return;
                            }
                        }
                        str4 = "AgentDataFlow_IMMessage";
                        z2 = false;
                        confirmInfo = planItem.getConfirmInfo();
                        if (confirmInfo == null) {
                        }
                        toolCallInfo = planItem.getToolCallInfo();
                        if (toolCallInfo == null) {
                            return;
                        }
                        params = toolCallInfo.getParams();
                        if (params != null) {
                        }
                        jsonObject = null;
                        JsonElement result322 = toolCallInfo.getResult();
                        parsedToolCallInfo = planItemAggregator.currentToolCall;
                        if (parsedToolCallInfo != null) {
                        }
                        z5 = z2;
                        Boolean bool2222 = bool;
                        areEqual = Intrinsics.areEqual(event.getNewToolCall(), bool2222);
                        areEqual2 = Intrinsics.areEqual(event.getToolcallFirstData(), bool2222);
                        if (!(z5 || areEqual || areEqual2)) {
                        }
                        parsedToolCallResult = (ParsedToolCallResult) getGson().fromJson(jsonElement, ParsedToolCallResult.class);
                        if (parsedToolCallResult != null) {
                        }
                        syncTaskContent(message);
                        Unit unit16222 = Unit.INSTANCE;
                        return;
                    }
                } else {
                    z = areEqual3;
                    planItem = planItem2;
                    parsedPlanItem2 = parsedPlanItem5;
                }
                str3 = ", message=";
                StringBuilder sb22 = new StringBuilder();
                if (reasoningContent2 == null) {
                }
                parsedPlanItem5 = parsedPlanItem2;
                parsedPlanItem5.setReasoningContent(sb22.append(reasoningContent2).append(reasoningContent).toString());
                thought = planItem.getThought();
                if (thought != null) {
                }
                thought = null;
                if (thought != null) {
                }
                str4 = "AgentDataFlow_IMMessage";
                z2 = false;
                confirmInfo = planItem.getConfirmInfo();
                if (confirmInfo == null) {
                }
                toolCallInfo = planItem.getToolCallInfo();
                if (toolCallInfo == null) {
                }
            }
            str3 = ", message=";
            thought = planItem.getThought();
            if (thought != null) {
            }
            thought = null;
            if (thought != null) {
            }
            str4 = "AgentDataFlow_IMMessage";
            z2 = false;
            confirmInfo = planItem.getConfirmInfo();
            if (confirmInfo == null) {
            }
            toolCallInfo = planItem.getToolCallInfo();
            if (toolCallInfo == null) {
            }
        } else {
            if (data instanceof ChatEventPayload.Done) {
                this.currentPlanItemId = null;
                this.currentToolCall = null;
                ChatEventPayload.Done done = (ChatEventPayload.Done) data;
                normalizeDoneStatus = IMMessageKt.normalizeDoneStatus(done.getStatus());
                if (normalizeDoneStatus == null) {
                    normalizeDoneStatus = message.getStatus();
                }
                message.setStatus(normalizeDoneStatus);
                Long chatStartTime = done.getChatStartTime();
                if (chatStartTime == null) {
                    chatStartTime = message.getChatStartTime();
                }
                message.setChatStartTime(chatStartTime);
                message.setChatEndTime(done.getChatEndTime());
                message.setReplyToMessageId(done.getReplyToMessageId());
                message.setQueuingPosition(null);
                message.setQueuingMessage(null);
                message.setQueueId(null);
                syncTaskContent(message);
                TraeLogUtil.INSTANCE.d("AgentDataFlow_IMMessage", "IMMessage: [Node2] Aggregator.Done: source=" + source + ", seq=" + event.getSeq() + ", status=" + message.getStatus() + ", totalPlanItems=" + getAllItems().size() + ", payload=" + IMService.INSTANCE.getGson().toJson(data) + ",message=" + IMService.INSTANCE.getGson().toJson(message));
                Unit unit17 = Unit.INSTANCE;
                return;
            }
            if (data instanceof ChatEventPayload.Error) {
                this.currentPlanItemId = null;
                this.currentToolCall = null;
                ChatEventPayload.Error error = (ChatEventPayload.Error) data;
                message.setError(new ParsedError(error.getCode(), error.getMessage(), error.getData()));
                message.setStatus("failed");
                String replyToMessageId = error.getReplyToMessageId();
                if (replyToMessageId == null) {
                    replyToMessageId = message.getReplyToMessageId();
                }
                message.setReplyToMessageId(replyToMessageId);
                message.setQueuingPosition(null);
                message.setQueuingMessage(null);
                message.setQueueId(null);
                syncTaskContent(message);
                TraeLogUtil.INSTANCE.d("AgentDataFlow_IMMessage", "IMMessage: [Node2] Aggregator.Error: source=" + source + ", seq=" + event.getSeq() + ", code=" + error.getCode() + ", message=" + error.getMessage() + ", status=" + message.getStatus());
            }
            Unit unit18 = Unit.INSTANCE;
        }
    }

    private final String appendNameIfNotSame(String currentName, String newName) {
        if (!Intrinsics.areEqual(currentName, newName)) {
            return currentName == null ? newName : currentName + newName;
        }
        FLogger.INSTANCE.i("AgentDataFlow_IMMessage", "IMMessage: appendNameIfNotSame same : currentName=" + currentName + ", newName=" + newName);
        return currentName;
    }

    private final void syncTaskContent(ParsedChatMessage message) {
        ParsedTaskContent taskContent = message.getTaskContent();
        if (taskContent == null) {
            taskContent = new ParsedTaskContent(null, null, null, 6, null);
            message.setContent(taskContent);
        }
        Set<Map.Entry<String, ParsedPlanItem>> entrySet = this.planItemMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
        Set<Map.Entry<String, ParsedPlanItem>> set = entrySet;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        int i = 0;
        for (Object obj : set) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Map.Entry entry = (Map.Entry) obj;
            Intrinsics.checkNotNull(entry);
            Object key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "component1(...)");
            Object value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "component2(...)");
            arrayList.add(new ParsedPlanItemMessage((String) key, "plan_item", (ParsedPlanItem) value));
            i = i2;
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            arrayList2 = null;
        }
        taskContent.setMessages(arrayList2);
    }
}
