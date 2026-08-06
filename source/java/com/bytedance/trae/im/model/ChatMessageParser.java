package com.bytedance.trae.im.model;

import android.util.Log;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: ChatMessageParser.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rJ\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\rJ\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0014\u001a\u00020\u0010J\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010\u001f\u001a\u00020 2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\f\u0010!\u001a\u00020\"*\u00020\u000eH\u0002J\u000e\u0010#\u001a\u00020\"*\u0004\u0018\u00010\u001eH\u0002J \u0010$\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u000eH\u0002J\f\u0010)\u001a\u00020\"*\u00020\u000eH\u0002J\u001a\u0010*\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\r2\b\u0010,\u001a\u0004\u0018\u00010\u0005H\u0002J\"\u0010-\u001a\u0004\u0018\u0001H.\"\u0006\b\u0000\u0010.\u0018\u00012\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0082\b¢\u0006\u0002\u00100J#\u00101\u001a\n\u0012\u0004\u0012\u0002H.\u0018\u00010\r\"\u0006\b\u0000\u0010.\u0018\u00012\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0082\bJ\u0014\u00102\u001a\u0004\u0018\u00010\u001e2\b\u0010/\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u00103\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u00105\u001a\u0012\u0012\u0004\u0012\u00020\u000e06j\b\u0012\u0004\u0012\u00020\u000e`7X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedance/trae/im/model/ChatMessageParser;", "", "<init>", "()V", "TAG", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "parseList", "", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "messages", "Lcom/bytedance/trae/im/model/ChatMessage;", "parseDisplayableHistoryList", "normalizeDisplayableHistoryMessages", "parse", "dto", "parseContent", "rawContent", "role", "parseUserContent", "extractTextFromArray", "array", "Lcom/google/gson/JsonArray;", "extractTextFromObject", "obj", "Lcom/google/gson/JsonObject;", "applyAppendInterjectionState", "", "hasAppendInput", "", "isAppendUserMessage", "findPreviousAssistant", "beforeIndex", "", "markInterjected", "message", "isDisplayableHistoryMessage", "parseNotifications", "Lcom/bytedance/trae/im/model/NotificationPayload;", AccountMonitorConstants.CommonParameter.RAW, "safeParse", "T", "json", "(Ljava/lang/String;)Ljava/lang/Object;", "safeParseList", "safeParseJsonObject", "APPEND_INPUT_TYPE", "APPEND_USER_CONTEXT_KEY", "CHRONOLOGICAL_MESSAGE_COMPARATOR", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ChatMessageParser {
    private static final String APPEND_INPUT_TYPE = "append_input";
    private static final String APPEND_USER_CONTEXT_KEY = "is_append_msg";
    private static final Comparator<ParsedChatMessage> CHRONOLOGICAL_MESSAGE_COMPARATOR;
    private static final String TAG = "ChatMessageParser";
    public static final ChatMessageParser INSTANCE = new ChatMessageParser();

    /* renamed from: gson$delegate, reason: from kotlin metadata */
    private static final Lazy gson = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.im.model.ChatMessageParser$$ExternalSyntheticLambda0
        public final Object invoke() {
            Gson gson_delegate$lambda$0;
            gson_delegate$lambda$0 = ChatMessageParser.gson_delegate$lambda$0();
            return gson_delegate$lambda$0;
        }
    });

    private ChatMessageParser() {
    }

    static {
        final Comparator comparator = new Comparator() { // from class: com.bytedance.trae.im.model.ChatMessageParser$special$$inlined$compareBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((ParsedChatMessage) t).getCreatedAt()), Long.valueOf(((ParsedChatMessage) t2).getCreatedAt()));
            }
        };
        CHRONOLOGICAL_MESSAGE_COMPARATOR = new Comparator() { // from class: com.bytedance.trae.im.model.ChatMessageParser$special$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                return compare != 0 ? compare : ComparisonsKt.compareValues(Integer.valueOf(((ParsedChatMessage) t).getMessageIndex()), Integer.valueOf(((ParsedChatMessage) t2).getMessageIndex()));
            }
        };
    }

    private final Gson getGson() {
        return (Gson) gson.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson gson_delegate$lambda$0() {
        return new Gson();
    }

    public final List<ParsedChatMessage> parseList(List<ChatMessage> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = messages.iterator();
        while (it.hasNext()) {
            ParsedChatMessage parse = INSTANCE.parse((ChatMessage) it.next());
            if (parse != null) {
                arrayList.add(parse);
            }
        }
        ArrayList arrayList2 = arrayList;
        INSTANCE.applyAppendInterjectionState(arrayList2);
        return arrayList2;
    }

    public final List<ParsedChatMessage> parseDisplayableHistoryList(List<ChatMessage> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        return normalizeDisplayableHistoryMessages(parseList(messages));
    }

    public final List<ParsedChatMessage> normalizeDisplayableHistoryMessages(List<ParsedChatMessage> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        applyAppendInterjectionState(messages);
        List<ParsedChatMessage> list = messages;
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((ParsedChatMessage) it.next()).setHistory(true);
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (INSTANCE.isDisplayableHistoryMessage((ParsedChatMessage) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x03d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0383 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0344 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x026f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0230 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0336  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final ParsedChatMessage parse(ChatMessage dto) {
        List list;
        List list2;
        String str;
        int i;
        Object fromJson;
        Long versionCode;
        Long l;
        String str2;
        List list3;
        List list4;
        String str3;
        Object fromJson2;
        String str4;
        Object fromJson3;
        String createdAtMs;
        long currentTimeMillis;
        String str5;
        Object fromJson4;
        String str6;
        Object fromJson5;
        String str7;
        Object fromJson6;
        String str8;
        Object fromJson7;
        Long longOrNull;
        Class<?> cls;
        List<ParsedPlanItemMessage> messages;
        Intrinsics.checkNotNullParameter(dto, "dto");
        String messageId = dto.getMessageId();
        if (messageId == null) {
            return null;
        }
        String chatSessionId = dto.getChatSessionId();
        String str9 = chatSessionId == null ? "" : chatSessionId;
        String role = dto.getRole();
        String str10 = role == null ? "" : role;
        Object parseContent = parseContent(dto.getContent(), str10);
        String query = dto.getQuery();
        String str11 = query;
        boolean z = true;
        if (str11 == null || str11.length() == 0) {
            list2 = null;
        } else {
            try {
                list = (List) getGson().fromJson(query, TypeToken.getParameterized(List.class, new Type[]{MessagePart.class}).getType());
            } catch (Exception e) {
                Log.w(TAG, "safeParseList<MessagePart> failed: " + query, e);
                list = null;
            }
            list2 = list;
        }
        if (Intrinsics.areEqual(str10, ParsedChatMessage.ROLE_ASSISTANT)) {
            ParsedTaskContent parsedTaskContent = parseContent instanceof ParsedTaskContent ? (ParsedTaskContent) parseContent : null;
            int size = (parsedTaskContent == null || (messages = parsedTaskContent.getMessages()) == null) ? 0 : messages.size();
            TraeLogUtil.INSTANCE.d("AgentDataFlow", "[Node2.5] Parser.parse: msgId=" + messageId + ", role=" + str10 + ", contentType=" + ((parseContent == null || (cls = parseContent.getClass()) == null) ? null : cls.getSimpleName()) + ", planItemCount=" + size + ", agentType=" + dto.getAgentType() + ", agentId=" + dto.getAgentId());
            if (size == 0) {
                TraeLogUtil traeLogUtil = TraeLogUtil.INSTANCE;
                StringBuilder sb = new StringBuilder("[Node2.5] Parser.parse WARNING: assistant message with 0 planItems! rawContent=");
                String content = dto.getContent();
                traeLogUtil.w("AgentDataFlow", sb.append(content != null ? StringsKt.take(content, FConstants.URI_FAIL_CODE) : null).toString());
            }
        }
        String turnId = dto.getTurnId();
        String status = dto.getStatus();
        String messageType = Intrinsics.areEqual(str10, ParsedChatMessage.ROLE_ASSISTANT) ? "task" : dto.getMessageType();
        Long messageIndex = dto.getMessageIndex();
        if (messageIndex != null) {
            str = messageId;
            i = (int) RangesKt.coerceIn(messageIndex.longValue(), -2147483648L, 2147483647L);
        } else {
            str = messageId;
            i = 0;
        }
        String replyToMessageId = dto.getReplyToMessageId();
        JsonObject safeParseJsonObject = safeParseJsonObject(dto.getUserMessageContext());
        String error = dto.getError();
        String str12 = error;
        if (!(str12 == null || str12.length() == 0)) {
            try {
                fromJson = getGson().fromJson(error, ParsedError.class);
            } catch (Exception e2) {
                Log.w(TAG, "safeParse<ParsedError> failed: " + error, e2);
            }
            ParsedError parsedError = (ParsedError) fromJson;
            Boolean revertible = dto.getRevertible();
            versionCode = dto.getVersionCode();
            if (versionCode != null) {
                if (versionCode.longValue() > 0) {
                    l = versionCode;
                    String references = dto.getReferences();
                    str2 = references;
                    if (str2 != null || str2.length() == 0) {
                        list4 = null;
                    } else {
                        try {
                            list3 = (List) getGson().fromJson(references, TypeToken.getParameterized(List.class, new Type[]{Reference.class}).getType());
                        } catch (Exception e3) {
                            Log.w(TAG, "safeParseList<Reference> failed: " + references, e3);
                            list3 = null;
                        }
                        list4 = list3;
                    }
                    JsonObject safeParseJsonObject2 = safeParseJsonObject(dto.getContextMetadata());
                    String searchReferenceData = dto.getSearchReferenceData();
                    str3 = searchReferenceData;
                    if (!(str3 != null || str3.length() == 0)) {
                        try {
                            fromJson2 = getGson().fromJson(searchReferenceData, SearchReferenceData.class);
                        } catch (Exception e4) {
                            Log.w(TAG, "safeParse<SearchReferenceData> failed: " + searchReferenceData, e4);
                        }
                        SearchReferenceData searchReferenceData2 = (SearchReferenceData) fromJson2;
                        String docReferences = dto.getDocReferences();
                        str4 = docReferences;
                        if (!(str4 != null || str4.length() == 0)) {
                            try {
                                fromJson3 = getGson().fromJson(docReferences, DocReferencesData.class);
                            } catch (Exception e5) {
                                Log.w(TAG, "safeParse<DocReferencesData> failed: " + docReferences, e5);
                            }
                            DocReferencesData docReferencesData = (DocReferencesData) fromJson3;
                            String agentType = dto.getAgentType();
                            String agentId = dto.getAgentId();
                            String agentName = dto.getAgentName();
                            String agentAvatarId = dto.getAgentAvatarId();
                            String traceId = dto.getTraceId();
                            createdAtMs = dto.getCreatedAtMs();
                            if (createdAtMs == null && (longOrNull = StringsKt.toLongOrNull(createdAtMs)) != null) {
                                currentTimeMillis = ParsedChatMessage.INSTANCE.normalizeToMillis(longOrNull.longValue());
                            } else {
                                currentTimeMillis = System.currentTimeMillis();
                            }
                            long j = currentTimeMillis;
                            JsonObject safeParseJsonObject3 = safeParseJsonObject(dto.getFeeUsage());
                            JsonObject safeParseJsonObject4 = safeParseJsonObject(dto.getMaxFeeUsage());
                            List<NotificationPayload> parseNotifications = parseNotifications(dto.getNotifications());
                            String modelSmartSelectionMeta = dto.getModelSmartSelectionMeta();
                            str5 = modelSmartSelectionMeta;
                            if (!(str5 != null || str5.length() == 0)) {
                                try {
                                    fromJson4 = getGson().fromJson(modelSmartSelectionMeta, ModelSmartSelectionMeta.class);
                                } catch (Exception e6) {
                                    Log.w(TAG, "safeParse<ModelSmartSelectionMeta> failed: " + modelSmartSelectionMeta, e6);
                                }
                                ModelSmartSelectionMeta modelSmartSelectionMeta2 = (ModelSmartSelectionMeta) fromJson4;
                                Boolean fromAppendMsg = dto.getFromAppendMsg();
                                String shallowMementoType = dto.getShallowMementoType();
                                String chatProcessVersion = dto.getChatProcessVersion();
                                String tokenUsage = dto.getTokenUsage();
                                str6 = tokenUsage;
                                if (!(str6 != null || str6.length() == 0)) {
                                    try {
                                        fromJson5 = getGson().fromJson(tokenUsage, ParsedTokenUsage.class);
                                    } catch (Exception e7) {
                                        Log.w(TAG, "safeParse<ParsedTokenUsage> failed: " + tokenUsage, e7);
                                    }
                                    ParsedTokenUsage parsedTokenUsage = (ParsedTokenUsage) fromJson5;
                                    String contextUsage = dto.getContextUsage();
                                    str7 = contextUsage;
                                    if (!(str7 != null || str7.length() == 0)) {
                                        try {
                                            fromJson6 = getGson().fromJson(contextUsage, ParsedContextUsage.class);
                                        } catch (Exception e8) {
                                            Log.w(TAG, "safeParse<ParsedContextUsage> failed: " + contextUsage, e8);
                                        }
                                        ParsedContextUsage parsedContextUsage = (ParsedContextUsage) fromJson6;
                                        String agentProcessSupport = dto.getAgentProcessSupport();
                                        Boolean isWorktree = dto.isWorktree();
                                        Boolean isUserCanceled = dto.isUserCanceled();
                                        Long chatStartTime = dto.getChatStartTime();
                                        Long chatEndTime = dto.getChatEndTime();
                                        String fastRequestSavings = dto.getFastRequestSavings();
                                        str8 = fastRequestSavings;
                                        if (str8 != null && str8.length() != 0) {
                                            z = false;
                                        }
                                        if (!z) {
                                            try {
                                                fromJson7 = getGson().fromJson(fastRequestSavings, FastRequestSavings.class);
                                            } catch (Exception e9) {
                                                Log.w(TAG, "safeParse<FastRequestSavings> failed: " + fastRequestSavings, e9);
                                            }
                                            return new ParsedChatMessage(str9, str, null, turnId, status, messageType, str10, i, replyToMessageId, safeParseJsonObject, parsedError, revertible, l, list4, safeParseJsonObject2, searchReferenceData2, docReferencesData, agentType, agentId, agentName, agentAvatarId, traceId, j, safeParseJsonObject3, safeParseJsonObject4, parseNotifications, modelSmartSelectionMeta2, fromAppendMsg, shallowMementoType, chatProcessVersion, parsedTokenUsage, parsedContextUsage, agentProcessSupport, isWorktree, isUserCanceled, chatStartTime, chatEndTime, parseContent, list2, (FastRequestSavings) fromJson7, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, 4, 8388352, null);
                                        }
                                        fromJson7 = null;
                                        return new ParsedChatMessage(str9, str, null, turnId, status, messageType, str10, i, replyToMessageId, safeParseJsonObject, parsedError, revertible, l, list4, safeParseJsonObject2, searchReferenceData2, docReferencesData, agentType, agentId, agentName, agentAvatarId, traceId, j, safeParseJsonObject3, safeParseJsonObject4, parseNotifications, modelSmartSelectionMeta2, fromAppendMsg, shallowMementoType, chatProcessVersion, parsedTokenUsage, parsedContextUsage, agentProcessSupport, isWorktree, isUserCanceled, chatStartTime, chatEndTime, parseContent, list2, (FastRequestSavings) fromJson7, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, 4, 8388352, null);
                                    }
                                    fromJson6 = null;
                                    ParsedContextUsage parsedContextUsage2 = (ParsedContextUsage) fromJson6;
                                    String agentProcessSupport2 = dto.getAgentProcessSupport();
                                    Boolean isWorktree2 = dto.isWorktree();
                                    Boolean isUserCanceled2 = dto.isUserCanceled();
                                    Long chatStartTime2 = dto.getChatStartTime();
                                    Long chatEndTime2 = dto.getChatEndTime();
                                    String fastRequestSavings2 = dto.getFastRequestSavings();
                                    str8 = fastRequestSavings2;
                                    if (str8 != null) {
                                        z = false;
                                    }
                                    if (!z) {
                                    }
                                    fromJson7 = null;
                                    return new ParsedChatMessage(str9, str, null, turnId, status, messageType, str10, i, replyToMessageId, safeParseJsonObject, parsedError, revertible, l, list4, safeParseJsonObject2, searchReferenceData2, docReferencesData, agentType, agentId, agentName, agentAvatarId, traceId, j, safeParseJsonObject3, safeParseJsonObject4, parseNotifications, modelSmartSelectionMeta2, fromAppendMsg, shallowMementoType, chatProcessVersion, parsedTokenUsage, parsedContextUsage2, agentProcessSupport2, isWorktree2, isUserCanceled2, chatStartTime2, chatEndTime2, parseContent, list2, (FastRequestSavings) fromJson7, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, 4, 8388352, null);
                                }
                                fromJson5 = null;
                                ParsedTokenUsage parsedTokenUsage2 = (ParsedTokenUsage) fromJson5;
                                String contextUsage2 = dto.getContextUsage();
                                str7 = contextUsage2;
                                if (!(str7 != null || str7.length() == 0)) {
                                }
                                fromJson6 = null;
                                ParsedContextUsage parsedContextUsage22 = (ParsedContextUsage) fromJson6;
                                String agentProcessSupport22 = dto.getAgentProcessSupport();
                                Boolean isWorktree22 = dto.isWorktree();
                                Boolean isUserCanceled22 = dto.isUserCanceled();
                                Long chatStartTime22 = dto.getChatStartTime();
                                Long chatEndTime22 = dto.getChatEndTime();
                                String fastRequestSavings22 = dto.getFastRequestSavings();
                                str8 = fastRequestSavings22;
                                if (str8 != null) {
                                }
                                if (!z) {
                                }
                                fromJson7 = null;
                                return new ParsedChatMessage(str9, str, null, turnId, status, messageType, str10, i, replyToMessageId, safeParseJsonObject, parsedError, revertible, l, list4, safeParseJsonObject2, searchReferenceData2, docReferencesData, agentType, agentId, agentName, agentAvatarId, traceId, j, safeParseJsonObject3, safeParseJsonObject4, parseNotifications, modelSmartSelectionMeta2, fromAppendMsg, shallowMementoType, chatProcessVersion, parsedTokenUsage2, parsedContextUsage22, agentProcessSupport22, isWorktree22, isUserCanceled22, chatStartTime22, chatEndTime22, parseContent, list2, (FastRequestSavings) fromJson7, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, 4, 8388352, null);
                            }
                            fromJson4 = null;
                            ModelSmartSelectionMeta modelSmartSelectionMeta22 = (ModelSmartSelectionMeta) fromJson4;
                            Boolean fromAppendMsg2 = dto.getFromAppendMsg();
                            String shallowMementoType2 = dto.getShallowMementoType();
                            String chatProcessVersion2 = dto.getChatProcessVersion();
                            String tokenUsage2 = dto.getTokenUsage();
                            str6 = tokenUsage2;
                            if (!(str6 != null || str6.length() == 0)) {
                            }
                            fromJson5 = null;
                            ParsedTokenUsage parsedTokenUsage22 = (ParsedTokenUsage) fromJson5;
                            String contextUsage22 = dto.getContextUsage();
                            str7 = contextUsage22;
                            if (!(str7 != null || str7.length() == 0)) {
                            }
                            fromJson6 = null;
                            ParsedContextUsage parsedContextUsage222 = (ParsedContextUsage) fromJson6;
                            String agentProcessSupport222 = dto.getAgentProcessSupport();
                            Boolean isWorktree222 = dto.isWorktree();
                            Boolean isUserCanceled222 = dto.isUserCanceled();
                            Long chatStartTime222 = dto.getChatStartTime();
                            Long chatEndTime222 = dto.getChatEndTime();
                            String fastRequestSavings222 = dto.getFastRequestSavings();
                            str8 = fastRequestSavings222;
                            if (str8 != null) {
                            }
                            if (!z) {
                            }
                            fromJson7 = null;
                            return new ParsedChatMessage(str9, str, null, turnId, status, messageType, str10, i, replyToMessageId, safeParseJsonObject, parsedError, revertible, l, list4, safeParseJsonObject2, searchReferenceData2, docReferencesData, agentType, agentId, agentName, agentAvatarId, traceId, j, safeParseJsonObject3, safeParseJsonObject4, parseNotifications, modelSmartSelectionMeta22, fromAppendMsg2, shallowMementoType2, chatProcessVersion2, parsedTokenUsage22, parsedContextUsage222, agentProcessSupport222, isWorktree222, isUserCanceled222, chatStartTime222, chatEndTime222, parseContent, list2, (FastRequestSavings) fromJson7, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, 4, 8388352, null);
                        }
                        fromJson3 = null;
                        DocReferencesData docReferencesData2 = (DocReferencesData) fromJson3;
                        String agentType2 = dto.getAgentType();
                        String agentId2 = dto.getAgentId();
                        String agentName2 = dto.getAgentName();
                        String agentAvatarId2 = dto.getAgentAvatarId();
                        String traceId2 = dto.getTraceId();
                        createdAtMs = dto.getCreatedAtMs();
                        if (createdAtMs == null) {
                        }
                        currentTimeMillis = System.currentTimeMillis();
                        long j2 = currentTimeMillis;
                        JsonObject safeParseJsonObject32 = safeParseJsonObject(dto.getFeeUsage());
                        JsonObject safeParseJsonObject42 = safeParseJsonObject(dto.getMaxFeeUsage());
                        List<NotificationPayload> parseNotifications2 = parseNotifications(dto.getNotifications());
                        String modelSmartSelectionMeta3 = dto.getModelSmartSelectionMeta();
                        str5 = modelSmartSelectionMeta3;
                        if (!(str5 != null || str5.length() == 0)) {
                        }
                        fromJson4 = null;
                        ModelSmartSelectionMeta modelSmartSelectionMeta222 = (ModelSmartSelectionMeta) fromJson4;
                        Boolean fromAppendMsg22 = dto.getFromAppendMsg();
                        String shallowMementoType22 = dto.getShallowMementoType();
                        String chatProcessVersion22 = dto.getChatProcessVersion();
                        String tokenUsage22 = dto.getTokenUsage();
                        str6 = tokenUsage22;
                        if (!(str6 != null || str6.length() == 0)) {
                        }
                        fromJson5 = null;
                        ParsedTokenUsage parsedTokenUsage222 = (ParsedTokenUsage) fromJson5;
                        String contextUsage222 = dto.getContextUsage();
                        str7 = contextUsage222;
                        if (!(str7 != null || str7.length() == 0)) {
                        }
                        fromJson6 = null;
                        ParsedContextUsage parsedContextUsage2222 = (ParsedContextUsage) fromJson6;
                        String agentProcessSupport2222 = dto.getAgentProcessSupport();
                        Boolean isWorktree2222 = dto.isWorktree();
                        Boolean isUserCanceled2222 = dto.isUserCanceled();
                        Long chatStartTime2222 = dto.getChatStartTime();
                        Long chatEndTime2222 = dto.getChatEndTime();
                        String fastRequestSavings2222 = dto.getFastRequestSavings();
                        str8 = fastRequestSavings2222;
                        if (str8 != null) {
                        }
                        if (!z) {
                        }
                        fromJson7 = null;
                        return new ParsedChatMessage(str9, str, null, turnId, status, messageType, str10, i, replyToMessageId, safeParseJsonObject, parsedError, revertible, l, list4, safeParseJsonObject2, searchReferenceData2, docReferencesData2, agentType2, agentId2, agentName2, agentAvatarId2, traceId2, j2, safeParseJsonObject32, safeParseJsonObject42, parseNotifications2, modelSmartSelectionMeta222, fromAppendMsg22, shallowMementoType22, chatProcessVersion22, parsedTokenUsage222, parsedContextUsage2222, agentProcessSupport2222, isWorktree2222, isUserCanceled2222, chatStartTime2222, chatEndTime2222, parseContent, list2, (FastRequestSavings) fromJson7, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, 4, 8388352, null);
                    }
                    fromJson2 = null;
                    SearchReferenceData searchReferenceData22 = (SearchReferenceData) fromJson2;
                    String docReferences2 = dto.getDocReferences();
                    str4 = docReferences2;
                    if (!(str4 != null || str4.length() == 0)) {
                    }
                    fromJson3 = null;
                    DocReferencesData docReferencesData22 = (DocReferencesData) fromJson3;
                    String agentType22 = dto.getAgentType();
                    String agentId22 = dto.getAgentId();
                    String agentName22 = dto.getAgentName();
                    String agentAvatarId22 = dto.getAgentAvatarId();
                    String traceId22 = dto.getTraceId();
                    createdAtMs = dto.getCreatedAtMs();
                    if (createdAtMs == null) {
                    }
                    currentTimeMillis = System.currentTimeMillis();
                    long j22 = currentTimeMillis;
                    JsonObject safeParseJsonObject322 = safeParseJsonObject(dto.getFeeUsage());
                    JsonObject safeParseJsonObject422 = safeParseJsonObject(dto.getMaxFeeUsage());
                    List<NotificationPayload> parseNotifications22 = parseNotifications(dto.getNotifications());
                    String modelSmartSelectionMeta32 = dto.getModelSmartSelectionMeta();
                    str5 = modelSmartSelectionMeta32;
                    if (!(str5 != null || str5.length() == 0)) {
                    }
                    fromJson4 = null;
                    ModelSmartSelectionMeta modelSmartSelectionMeta2222 = (ModelSmartSelectionMeta) fromJson4;
                    Boolean fromAppendMsg222 = dto.getFromAppendMsg();
                    String shallowMementoType222 = dto.getShallowMementoType();
                    String chatProcessVersion222 = dto.getChatProcessVersion();
                    String tokenUsage222 = dto.getTokenUsage();
                    str6 = tokenUsage222;
                    if (!(str6 != null || str6.length() == 0)) {
                    }
                    fromJson5 = null;
                    ParsedTokenUsage parsedTokenUsage2222 = (ParsedTokenUsage) fromJson5;
                    String contextUsage2222 = dto.getContextUsage();
                    str7 = contextUsage2222;
                    if (!(str7 != null || str7.length() == 0)) {
                    }
                    fromJson6 = null;
                    ParsedContextUsage parsedContextUsage22222 = (ParsedContextUsage) fromJson6;
                    String agentProcessSupport22222 = dto.getAgentProcessSupport();
                    Boolean isWorktree22222 = dto.isWorktree();
                    Boolean isUserCanceled22222 = dto.isUserCanceled();
                    Long chatStartTime22222 = dto.getChatStartTime();
                    Long chatEndTime22222 = dto.getChatEndTime();
                    String fastRequestSavings22222 = dto.getFastRequestSavings();
                    str8 = fastRequestSavings22222;
                    if (str8 != null) {
                    }
                    if (!z) {
                    }
                    fromJson7 = null;
                    return new ParsedChatMessage(str9, str, null, turnId, status, messageType, str10, i, replyToMessageId, safeParseJsonObject, parsedError, revertible, l, list4, safeParseJsonObject2, searchReferenceData22, docReferencesData22, agentType22, agentId22, agentName22, agentAvatarId22, traceId22, j22, safeParseJsonObject322, safeParseJsonObject422, parseNotifications22, modelSmartSelectionMeta2222, fromAppendMsg222, shallowMementoType222, chatProcessVersion222, parsedTokenUsage2222, parsedContextUsage22222, agentProcessSupport22222, isWorktree22222, isUserCanceled22222, chatStartTime22222, chatEndTime22222, parseContent, list2, (FastRequestSavings) fromJson7, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, 4, 8388352, null);
                }
            }
            l = null;
            String references2 = dto.getReferences();
            str2 = references2;
            if (str2 != null || str2.length() == 0) {
            }
            JsonObject safeParseJsonObject22 = safeParseJsonObject(dto.getContextMetadata());
            String searchReferenceData3 = dto.getSearchReferenceData();
            str3 = searchReferenceData3;
            if (!(str3 != null || str3.length() == 0)) {
            }
            fromJson2 = null;
            SearchReferenceData searchReferenceData222 = (SearchReferenceData) fromJson2;
            String docReferences22 = dto.getDocReferences();
            str4 = docReferences22;
            if (!(str4 != null || str4.length() == 0)) {
            }
            fromJson3 = null;
            DocReferencesData docReferencesData222 = (DocReferencesData) fromJson3;
            String agentType222 = dto.getAgentType();
            String agentId222 = dto.getAgentId();
            String agentName222 = dto.getAgentName();
            String agentAvatarId222 = dto.getAgentAvatarId();
            String traceId222 = dto.getTraceId();
            createdAtMs = dto.getCreatedAtMs();
            if (createdAtMs == null) {
            }
            currentTimeMillis = System.currentTimeMillis();
            long j222 = currentTimeMillis;
            JsonObject safeParseJsonObject3222 = safeParseJsonObject(dto.getFeeUsage());
            JsonObject safeParseJsonObject4222 = safeParseJsonObject(dto.getMaxFeeUsage());
            List<NotificationPayload> parseNotifications222 = parseNotifications(dto.getNotifications());
            String modelSmartSelectionMeta322 = dto.getModelSmartSelectionMeta();
            str5 = modelSmartSelectionMeta322;
            if (!(str5 != null || str5.length() == 0)) {
            }
            fromJson4 = null;
            ModelSmartSelectionMeta modelSmartSelectionMeta22222 = (ModelSmartSelectionMeta) fromJson4;
            Boolean fromAppendMsg2222 = dto.getFromAppendMsg();
            String shallowMementoType2222 = dto.getShallowMementoType();
            String chatProcessVersion2222 = dto.getChatProcessVersion();
            String tokenUsage2222 = dto.getTokenUsage();
            str6 = tokenUsage2222;
            if (!(str6 != null || str6.length() == 0)) {
            }
            fromJson5 = null;
            ParsedTokenUsage parsedTokenUsage22222 = (ParsedTokenUsage) fromJson5;
            String contextUsage22222 = dto.getContextUsage();
            str7 = contextUsage22222;
            if (!(str7 != null || str7.length() == 0)) {
            }
            fromJson6 = null;
            ParsedContextUsage parsedContextUsage222222 = (ParsedContextUsage) fromJson6;
            String agentProcessSupport222222 = dto.getAgentProcessSupport();
            Boolean isWorktree222222 = dto.isWorktree();
            Boolean isUserCanceled222222 = dto.isUserCanceled();
            Long chatStartTime222222 = dto.getChatStartTime();
            Long chatEndTime222222 = dto.getChatEndTime();
            String fastRequestSavings222222 = dto.getFastRequestSavings();
            str8 = fastRequestSavings222222;
            if (str8 != null) {
            }
            if (!z) {
            }
            fromJson7 = null;
            return new ParsedChatMessage(str9, str, null, turnId, status, messageType, str10, i, replyToMessageId, safeParseJsonObject, parsedError, revertible, l, list4, safeParseJsonObject22, searchReferenceData222, docReferencesData222, agentType222, agentId222, agentName222, agentAvatarId222, traceId222, j222, safeParseJsonObject3222, safeParseJsonObject4222, parseNotifications222, modelSmartSelectionMeta22222, fromAppendMsg2222, shallowMementoType2222, chatProcessVersion2222, parsedTokenUsage22222, parsedContextUsage222222, agentProcessSupport222222, isWorktree222222, isUserCanceled222222, chatStartTime222222, chatEndTime222222, parseContent, list2, (FastRequestSavings) fromJson7, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, 4, 8388352, null);
        }
        fromJson = null;
        ParsedError parsedError2 = (ParsedError) fromJson;
        Boolean revertible2 = dto.getRevertible();
        versionCode = dto.getVersionCode();
        if (versionCode != null) {
        }
        l = null;
        String references22 = dto.getReferences();
        str2 = references22;
        if (str2 != null || str2.length() == 0) {
        }
        JsonObject safeParseJsonObject222 = safeParseJsonObject(dto.getContextMetadata());
        String searchReferenceData32 = dto.getSearchReferenceData();
        str3 = searchReferenceData32;
        if (!(str3 != null || str3.length() == 0)) {
        }
        fromJson2 = null;
        SearchReferenceData searchReferenceData2222 = (SearchReferenceData) fromJson2;
        String docReferences222 = dto.getDocReferences();
        str4 = docReferences222;
        if (!(str4 != null || str4.length() == 0)) {
        }
        fromJson3 = null;
        DocReferencesData docReferencesData2222 = (DocReferencesData) fromJson3;
        String agentType2222 = dto.getAgentType();
        String agentId2222 = dto.getAgentId();
        String agentName2222 = dto.getAgentName();
        String agentAvatarId2222 = dto.getAgentAvatarId();
        String traceId2222 = dto.getTraceId();
        createdAtMs = dto.getCreatedAtMs();
        if (createdAtMs == null) {
        }
        currentTimeMillis = System.currentTimeMillis();
        long j2222 = currentTimeMillis;
        JsonObject safeParseJsonObject32222 = safeParseJsonObject(dto.getFeeUsage());
        JsonObject safeParseJsonObject42222 = safeParseJsonObject(dto.getMaxFeeUsage());
        List<NotificationPayload> parseNotifications2222 = parseNotifications(dto.getNotifications());
        String modelSmartSelectionMeta3222 = dto.getModelSmartSelectionMeta();
        str5 = modelSmartSelectionMeta3222;
        if (!(str5 != null || str5.length() == 0)) {
        }
        fromJson4 = null;
        ModelSmartSelectionMeta modelSmartSelectionMeta222222 = (ModelSmartSelectionMeta) fromJson4;
        Boolean fromAppendMsg22222 = dto.getFromAppendMsg();
        String shallowMementoType22222 = dto.getShallowMementoType();
        String chatProcessVersion22222 = dto.getChatProcessVersion();
        String tokenUsage22222 = dto.getTokenUsage();
        str6 = tokenUsage22222;
        if (!(str6 != null || str6.length() == 0)) {
        }
        fromJson5 = null;
        ParsedTokenUsage parsedTokenUsage222222 = (ParsedTokenUsage) fromJson5;
        String contextUsage222222 = dto.getContextUsage();
        str7 = contextUsage222222;
        if (!(str7 != null || str7.length() == 0)) {
        }
        fromJson6 = null;
        ParsedContextUsage parsedContextUsage2222222 = (ParsedContextUsage) fromJson6;
        String agentProcessSupport2222222 = dto.getAgentProcessSupport();
        Boolean isWorktree2222222 = dto.isWorktree();
        Boolean isUserCanceled2222222 = dto.isUserCanceled();
        Long chatStartTime2222222 = dto.getChatStartTime();
        Long chatEndTime2222222 = dto.getChatEndTime();
        String fastRequestSavings2222222 = dto.getFastRequestSavings();
        str8 = fastRequestSavings2222222;
        if (str8 != null) {
        }
        if (!z) {
        }
        fromJson7 = null;
        return new ParsedChatMessage(str9, str, null, turnId, status, messageType, str10, i, replyToMessageId, safeParseJsonObject, parsedError2, revertible2, l, list4, safeParseJsonObject222, searchReferenceData2222, docReferencesData2222, agentType2222, agentId2222, agentName2222, agentAvatarId2222, traceId2222, j2222, safeParseJsonObject32222, safeParseJsonObject42222, parseNotifications2222, modelSmartSelectionMeta222222, fromAppendMsg22222, shallowMementoType22222, chatProcessVersion22222, parsedTokenUsage222222, parsedContextUsage2222222, agentProcessSupport2222222, isWorktree2222222, isUserCanceled2222222, chatStartTime2222222, chatEndTime2222222, parseContent, list2, (FastRequestSavings) fromJson7, false, false, false, null, null, null, null, null, null, null, null, null, null, null, null, 4, 8388352, null);
    }

    private final Object parseContent(String rawContent, String role) {
        String str = rawContent;
        if (str == null || str.length() == 0) {
            return null;
        }
        if (Intrinsics.areEqual(role, ParsedChatMessage.ROLE_USER)) {
            return parseUserContent(rawContent);
        }
        if (!Intrinsics.areEqual(role, ParsedChatMessage.ROLE_ASSISTANT)) {
            return rawContent;
        }
        if (!(str == null || str.length() == 0)) {
            try {
                return getGson().fromJson(rawContent, ParsedTaskContent.class);
            } catch (Exception e) {
                Log.w(TAG, "safeParse<ParsedTaskContent> failed: " + rawContent, e);
            }
        }
        return null;
    }

    private final String parseUserContent(String rawContent) {
        String obj = StringsKt.trim(rawContent).toString();
        if (!StringsKt.startsWith$default(obj, "{", false, 2, (Object) null) && !StringsKt.startsWith$default(obj, "[", false, 2, (Object) null)) {
            return rawContent;
        }
        try {
            JsonElement jsonElement = (JsonElement) getGson().fromJson(obj, JsonElement.class);
            if (jsonElement == null || jsonElement.isJsonNull()) {
                return rawContent;
            }
            if (jsonElement.isJsonArray()) {
                JsonArray asJsonArray = jsonElement.getAsJsonArray();
                Intrinsics.checkNotNullExpressionValue(asJsonArray, "getAsJsonArray(...)");
                return extractTextFromArray(asJsonArray);
            }
            if (!jsonElement.isJsonObject()) {
                return rawContent;
            }
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(asJsonObject, "getAsJsonObject(...)");
            String extractTextFromObject = extractTextFromObject(asJsonObject);
            return extractTextFromObject == null ? rawContent : extractTextFromObject;
        } catch (Exception unused) {
            return rawContent;
        }
    }

    private final String extractTextFromArray(JsonArray array) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (JsonElement jsonElement : (Iterable) array) {
            if (jsonElement.isJsonObject()) {
                ChatMessageParser chatMessageParser = INSTANCE;
                JsonObject asJsonObject = jsonElement.getAsJsonObject();
                Intrinsics.checkNotNullExpressionValue(asJsonObject, "getAsJsonObject(...)");
                str = chatMessageParser.extractTextFromObject(asJsonObject);
            } else {
                str = null;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        String joinToString$default = CollectionsKt.joinToString$default(arrayList, "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        if (joinToString$default.length() == 0) {
            joinToString$default = "";
        }
        return joinToString$default;
    }

    private final String extractTextFromObject(JsonObject obj) {
        String str;
        JsonElement jsonElement;
        JsonElement jsonElement2 = obj.get(DBData.FIELD_TYPE);
        if (jsonElement2 != null) {
            if (!jsonElement2.isJsonPrimitive()) {
                jsonElement2 = null;
            }
            if (jsonElement2 != null) {
                str = jsonElement2.getAsString();
                if (!Intrinsics.areEqual(str, "text") && (jsonElement = obj.get("text_content")) != null) {
                    if (!jsonElement.isJsonPrimitive()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null) {
                        return jsonElement.getAsString();
                    }
                    return null;
                }
            }
        }
        str = null;
        return !Intrinsics.areEqual(str, "text") ? null : null;
    }

    private final void applyAppendInterjectionState(List<ParsedChatMessage> messages) {
        ParsedChatMessage findPreviousAssistant;
        List<ParsedChatMessage> sortedWith = CollectionsKt.sortedWith(messages, CHRONOLOGICAL_MESSAGE_COMPARATOR);
        int i = 0;
        for (Object obj : sortedWith) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ParsedChatMessage parsedChatMessage = (ParsedChatMessage) obj;
            if (parsedChatMessage.isAssistantMessage()) {
                ChatMessageParser chatMessageParser = INSTANCE;
                if (chatMessageParser.hasAppendInput(parsedChatMessage)) {
                    chatMessageParser.markInterjected(parsedChatMessage);
                }
            }
            if (parsedChatMessage.isUserMessage()) {
                ChatMessageParser chatMessageParser2 = INSTANCE;
                if (chatMessageParser2.isAppendUserMessage(parsedChatMessage.getUserMessageContext()) && (findPreviousAssistant = chatMessageParser2.findPreviousAssistant(sortedWith, i)) != null) {
                    chatMessageParser2.markInterjected(findPreviousAssistant);
                }
            }
            if (parsedChatMessage.isAssistantMessage()) {
                if (Intrinsics.areEqual(parsedChatMessage.getFromAppendMsg(), true)) {
                    String replyToMessageId = parsedChatMessage.getReplyToMessageId();
                    Integer num = null;
                    if (replyToMessageId != null) {
                        Iterator<ParsedChatMessage> it = sortedWith.iterator();
                        int i3 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i3 = -1;
                                break;
                            } else if (Intrinsics.areEqual(it.next().getMessageId(), replyToMessageId)) {
                                break;
                            } else {
                                i3++;
                            }
                        }
                        Integer valueOf = Integer.valueOf(i3);
                        if (valueOf.intValue() >= 0) {
                            num = valueOf;
                        }
                    }
                    if (num != null) {
                        i = num.intValue();
                    }
                    ChatMessageParser chatMessageParser3 = INSTANCE;
                    ParsedChatMessage findPreviousAssistant2 = chatMessageParser3.findPreviousAssistant(sortedWith, i);
                    if (findPreviousAssistant2 != null) {
                        chatMessageParser3.markInterjected(findPreviousAssistant2);
                    }
                }
            }
            i = i2;
        }
    }

    private final boolean hasAppendInput(ParsedChatMessage parsedChatMessage) {
        List<ParsedPlanItemMessage> messages;
        boolean z;
        ParsedTaskContent taskContent = parsedChatMessage.getTaskContent();
        if (taskContent == null || (messages = taskContent.getMessages()) == null) {
            return false;
        }
        List<ParsedPlanItemMessage> list = messages;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((ParsedPlanItemMessage) it.next()).getType(), APPEND_INPUT_TYPE)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return z;
    }

    private final boolean isAppendUserMessage(JsonObject jsonObject) {
        JsonElement jsonElement;
        Object obj;
        if (jsonObject == null || (jsonElement = jsonObject.get(APPEND_USER_CONTEXT_KEY)) == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Boolean.valueOf(jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().getAsBoolean()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }

    private final ParsedChatMessage findPreviousAssistant(List<ParsedChatMessage> messages, int beforeIndex) {
        ParsedChatMessage parsedChatMessage;
        if (beforeIndex <= 0) {
            return null;
        }
        do {
            beforeIndex--;
            if (-1 >= beforeIndex) {
                return null;
            }
            parsedChatMessage = messages.get(beforeIndex);
        } while (!parsedChatMessage.isAssistantMessage());
        return parsedChatMessage;
    }

    private final void markInterjected(ParsedChatMessage message) {
        message.setInterjected(true);
    }

    private final boolean isDisplayableHistoryMessage(ParsedChatMessage parsedChatMessage) {
        return (parsedChatMessage.isAssistantMessage() && CollectionsKt.contains(CollectionsKt.listOf(new String[]{"in_progress", "queuing"}), parsedChatMessage.getStatus()) && !parsedChatMessage.isInterjected()) ? false : true;
    }

    private final List<NotificationPayload> parseNotifications(String raw) {
        NotificationPayload notificationPayload;
        NotificationPayload notificationPayload2;
        Object fromJson;
        String str = raw;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            String obj = StringsKt.trim(raw).toString();
            if (StringsKt.startsWith$default(obj, "[", false, 2, (Object) null)) {
                Iterable<JsonElement> iterable = (JsonArray) getGson().fromJson(obj, JsonArray.class);
                if (iterable == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (JsonElement jsonElement : iterable) {
                    if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
                        ChatMessageParser chatMessageParser = INSTANCE;
                        String asString = jsonElement.getAsString();
                        String str2 = asString;
                        if (!(str2 == null || str2.length() == 0)) {
                            try {
                                fromJson = chatMessageParser.getGson().fromJson(asString, NotificationPayload.class);
                            } catch (Exception e) {
                                Log.w(TAG, "safeParse<NotificationPayload> failed: " + asString, e);
                            }
                            notificationPayload2 = (NotificationPayload) fromJson;
                        }
                        fromJson = null;
                        notificationPayload2 = (NotificationPayload) fromJson;
                    } else {
                        notificationPayload2 = jsonElement.isJsonObject() ? (NotificationPayload) INSTANCE.getGson().fromJson(jsonElement, NotificationPayload.class) : null;
                    }
                    if (notificationPayload2 != null) {
                        arrayList.add(notificationPayload2);
                    }
                }
                return arrayList;
            }
            if (!StringsKt.startsWith$default(obj, "{", false, 2, (Object) null) || (notificationPayload = (NotificationPayload) getGson().fromJson(obj, NotificationPayload.class)) == null) {
                return null;
            }
            return CollectionsKt.listOf(notificationPayload);
        } catch (Exception e2) {
            Log.w(TAG, "parseNotifications failed: " + raw, e2);
            return null;
        }
    }

    private final /* synthetic */ <T> T safeParse(String json) {
        String str = json;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            Gson gson2 = getGson();
            Intrinsics.reifiedOperationMarker(4, "T");
            return (T) gson2.fromJson(json, Object.class);
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("safeParse<");
            Intrinsics.reifiedOperationMarker(4, "T");
            Log.w(TAG, sb.append(Object.class.getSimpleName()).append("> failed: ").append(json).toString(), e);
            return null;
        }
    }

    private final /* synthetic */ <T> List<T> safeParseList(String json) {
        String str = json;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            Intrinsics.reifiedOperationMarker(4, "T");
            return (List) getGson().fromJson(json, TypeToken.getParameterized(List.class, new Type[]{Object.class}).getType());
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder("safeParseList<");
            Intrinsics.reifiedOperationMarker(4, "T");
            Log.w(TAG, sb.append(Object.class.getSimpleName()).append("> failed: ").append(json).toString(), e);
            return null;
        }
    }

    private final JsonObject safeParseJsonObject(String json) {
        String str = json;
        if (str == null || str.length() == 0) {
            return null;
        }
        try {
            return (JsonObject) getGson().fromJson(json, JsonObject.class);
        } catch (Exception e) {
            Log.w(TAG, "safeParseJsonObject failed: " + json, e);
            return null;
        }
    }
}
