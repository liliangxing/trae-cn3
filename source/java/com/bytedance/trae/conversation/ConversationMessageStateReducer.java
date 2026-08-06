package com.bytedance.trae.conversation;

import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.timonbase.scene.PageDataManager;
import com.bytedance.trae.im.model.ConfirmInfo;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedPlanItemMessage;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: ConversationMessageStateReducer.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u000f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jb\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u000528\b\u0002\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\nJ\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u001e\u0010\u0013\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u0002JV\u0010\u001f\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010 \u001a\u00020\u000626\u0010\t\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\nH\u0002J.\u0010!\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u000bH\u0002J\u001a\u0010&\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u0006H\u0002J\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\f\u0010(\u001a\u00020\u0017*\u00020\u0006H\u0002J\f\u0010)\u001a\u00020\u0017*\u00020\u0006H\u0002J\f\u0010*\u001a\u00020\u0017*\u00020\u0006H\u0002J\u001e\u0010+\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010,\u001a\u00020#H\u0002J\u001e\u0010-\u001a\u00020#2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010.\u001a\u00020#H\u0002J\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002R\u000e\u00100\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/trae/conversation/ConversationMessageStateReducer;", "", "<init>", "()V", "mergeMessages", "", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "currentMessages", "newMessages", "onUserMessageFixup", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "oldMessageId", "fixedMessage", "", "sortMessages", "messages", "upsertMessage", "", "message", "isSameAssistantTurn", "", "existing", "incoming", "mergeExistingNoticeIntoIncoming", "mergeRuntimeNoticeIntoExisting", "shouldKeepExistingTerminalMessage", "isTerminalStatus", PageDataManager.EXTRA_STATUS, "fixupUserMessageForAssistant", "assistantMessage", "removeDuplicateFixedUserMessages", "fixedIndex", "", "taskId", "replyToMessageId", "mergeDuplicateMessage", "markAppendInterjections", "hasAppendInterjectionSignal", "hasAppendInput", "isAppendUserMessage", "markInterjected", "index", "previousAssistantIndexBefore", "beforeIndex", "removeStalePlaceholders", "APPEND_INPUT_TYPE", "APPEND_USER_CONTEXT_KEY", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationMessageStateReducer {
    private static final String APPEND_INPUT_TYPE = "append_input";
    private static final String APPEND_USER_CONTEXT_KEY = "is_append_msg";
    public static final ConversationMessageStateReducer INSTANCE = new ConversationMessageStateReducer();

    private ConversationMessageStateReducer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List mergeMessages$default(ConversationMessageStateReducer conversationMessageStateReducer, List list, List list2, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            function2 = new Function2() { // from class: com.bytedance.trae.conversation.ConversationMessageStateReducer$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2, Object obj3) {
                    Unit mergeMessages$lambda$0;
                    mergeMessages$lambda$0 = ConversationMessageStateReducer.mergeMessages$lambda$0((String) obj2, (ParsedChatMessage) obj3);
                    return mergeMessages$lambda$0;
                }
            };
        }
        return conversationMessageStateReducer.mergeMessages(list, list2, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mergeMessages$lambda$0(String str, ParsedChatMessage parsedChatMessage) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        Intrinsics.checkNotNullParameter(parsedChatMessage, "<unused var>");
        return Unit.INSTANCE;
    }

    public final List<ParsedChatMessage> mergeMessages(List<ParsedChatMessage> currentMessages, List<ParsedChatMessage> newMessages, Function2<? super String, ? super ParsedChatMessage, Unit> onUserMessageFixup) {
        Intrinsics.checkNotNullParameter(currentMessages, "currentMessages");
        Intrinsics.checkNotNullParameter(newMessages, "newMessages");
        Intrinsics.checkNotNullParameter(onUserMessageFixup, "onUserMessageFixup");
        if (newMessages.isEmpty()) {
            return sortMessages(currentMessages);
        }
        List<ParsedChatMessage> mutableList = CollectionsKt.toMutableList(currentMessages);
        List<ParsedChatMessage> list = newMessages;
        for (ParsedChatMessage parsedChatMessage : list) {
            if (!StringsKt.isBlank(parsedChatMessage.getMessageId())) {
                if (parsedChatMessage.isAssistantMessage()) {
                    INSTANCE.fixupUserMessageForAssistant(mutableList, parsedChatMessage, onUserMessageFixup);
                }
                INSTANCE.upsertMessage(mutableList, parsedChatMessage);
            }
        }
        List<ParsedChatMessage> markAppendInterjections = markAppendInterjections(sortMessages(mutableList));
        boolean z = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ParsedChatMessage parsedChatMessage2 = (ParsedChatMessage) it.next();
                if (parsedChatMessage2.isHistory() && parsedChatMessage2.isAssistantMessage()) {
                    z = true;
                    break;
                }
            }
        }
        return z ? removeStalePlaceholders(markAppendInterjections) : markAppendInterjections;
    }

    public final List<ParsedChatMessage> sortMessages(List<ParsedChatMessage> messages) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList<ParsedChatMessage> arrayList = new ArrayList();
        for (Object obj : messages) {
            if (true ^ StringsKt.isBlank(((ParsedChatMessage) obj).getMessageId())) {
                arrayList.add(obj);
            }
        }
        for (ParsedChatMessage parsedChatMessage : arrayList) {
            linkedHashMap.put(parsedChatMessage.getMessageId(), INSTANCE.mergeDuplicateMessage((ParsedChatMessage) linkedHashMap.get(parsedChatMessage.getMessageId()), parsedChatMessage));
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList<ParsedChatMessage> arrayList3 = new ArrayList();
        Collection<ParsedChatMessage> values = linkedHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        for (ParsedChatMessage parsedChatMessage2 : values) {
            if (parsedChatMessage2.isUserMessage()) {
                Intrinsics.checkNotNull(parsedChatMessage2);
                arrayList2.add(parsedChatMessage2);
            } else {
                Intrinsics.checkNotNull(parsedChatMessage2);
                arrayList3.add(parsedChatMessage2);
            }
        }
        ArrayList<ParsedChatMessage> arrayList4 = arrayList2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList4, 10)), 16));
        for (Object obj2 : arrayList4) {
            linkedHashMap2.put(((ParsedChatMessage) obj2).getMessageId(), obj2);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList5 = new ArrayList();
        for (ParsedChatMessage parsedChatMessage3 : arrayList3) {
            String replyToMessageId = parsedChatMessage3.getReplyToMessageId();
            if (replyToMessageId == null || !(!StringsKt.isBlank(replyToMessageId))) {
                replyToMessageId = null;
            }
            ParsedChatMessage parsedChatMessage4 = replyToMessageId != null ? (ParsedChatMessage) linkedHashMap2.get(replyToMessageId) : null;
            if (parsedChatMessage4 != null) {
                linkedHashSet.add(parsedChatMessage4.getMessageId());
                arrayList5.add(TuplesKt.to(parsedChatMessage4, parsedChatMessage3));
            } else {
                arrayList5.add(TuplesKt.to((Object) null, parsedChatMessage3));
            }
        }
        for (ParsedChatMessage parsedChatMessage5 : arrayList4) {
            if (!linkedHashSet.contains(parsedChatMessage5.getMessageId())) {
                arrayList5.add(TuplesKt.to(parsedChatMessage5, (Object) null));
            }
        }
        final Comparator comparator = new Comparator() { // from class: com.bytedance.trae.conversation.ConversationMessageStateReducer$sortMessages$$inlined$compareBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Pair pair = (Pair) t;
                ParsedChatMessage parsedChatMessage6 = (ParsedChatMessage) pair.component1();
                ParsedChatMessage parsedChatMessage7 = (ParsedChatMessage) pair.component2();
                if (parsedChatMessage6 == null) {
                    parsedChatMessage6 = parsedChatMessage7;
                }
                Long valueOf = parsedChatMessage6 != null ? Long.valueOf(parsedChatMessage6.getCreatedAt()) : 0L;
                Pair pair2 = (Pair) t2;
                ParsedChatMessage parsedChatMessage8 = (ParsedChatMessage) pair2.component1();
                ParsedChatMessage parsedChatMessage9 = (ParsedChatMessage) pair2.component2();
                if (parsedChatMessage8 == null) {
                    parsedChatMessage8 = parsedChatMessage9;
                }
                return ComparisonsKt.compareValues(valueOf, parsedChatMessage8 != null ? Long.valueOf(parsedChatMessage8.getCreatedAt()) : 0L);
            }
        };
        List<Pair> sortedWith = CollectionsKt.sortedWith(arrayList5, new Comparator() { // from class: com.bytedance.trae.conversation.ConversationMessageStateReducer$sortMessages$$inlined$thenBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                if (compare != 0) {
                    return compare;
                }
                Pair pair = (Pair) t;
                ParsedChatMessage parsedChatMessage6 = (ParsedChatMessage) pair.component1();
                ParsedChatMessage parsedChatMessage7 = (ParsedChatMessage) pair.component2();
                if (parsedChatMessage6 == null) {
                    parsedChatMessage6 = parsedChatMessage7;
                }
                Integer valueOf = parsedChatMessage6 != null ? Integer.valueOf(parsedChatMessage6.getMessageIndex()) : 0;
                Pair pair2 = (Pair) t2;
                ParsedChatMessage parsedChatMessage8 = (ParsedChatMessage) pair2.component1();
                ParsedChatMessage parsedChatMessage9 = (ParsedChatMessage) pair2.component2();
                if (parsedChatMessage8 == null) {
                    parsedChatMessage8 = parsedChatMessage9;
                }
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(parsedChatMessage8 != null ? parsedChatMessage8.getMessageIndex() : 0));
            }
        });
        ArrayList arrayList6 = new ArrayList();
        for (Pair pair : sortedWith) {
            CollectionsKt.addAll(arrayList6, CollectionsKt.listOfNotNull(new ParsedChatMessage[]{(ParsedChatMessage) pair.component1(), (ParsedChatMessage) pair.component2()}));
        }
        return arrayList6;
    }

    private final boolean isSameAssistantTurn(ParsedChatMessage existing, ParsedChatMessage incoming) {
        String str = null;
        if (StringsKt.startsWith$default(existing.getMessageId(), "placeholder_", false, 2, (Object) null) || StringsKt.startsWith$default(incoming.getMessageId(), "placeholder_", false, 2, (Object) null)) {
            return true;
        }
        String replyToMessageId = existing.getReplyToMessageId();
        if (replyToMessageId == null || !(!StringsKt.isBlank(replyToMessageId))) {
            replyToMessageId = null;
        }
        String replyToMessageId2 = incoming.getReplyToMessageId();
        if (replyToMessageId2 != null && (!StringsKt.isBlank(replyToMessageId2))) {
            str = replyToMessageId2;
        }
        return replyToMessageId == null || str == null || Intrinsics.areEqual(replyToMessageId, str);
    }

    private final ParsedChatMessage mergeExistingNoticeIntoIncoming(ParsedChatMessage existing, ParsedChatMessage incoming) {
        if (!existing.isAssistantMessage() || !incoming.isAssistantMessage() || incoming.isHistory()) {
            return incoming;
        }
        String noticeType = incoming.getNoticeType();
        if (noticeType == null) {
            noticeType = existing.getNoticeType();
        }
        incoming.setNoticeType(noticeType);
        String noticeTitle = incoming.getNoticeTitle();
        if (noticeTitle == null) {
            noticeTitle = existing.getNoticeTitle();
        }
        incoming.setNoticeTitle(noticeTitle);
        String noticeMessage = incoming.getNoticeMessage();
        if (noticeMessage == null) {
            noticeMessage = existing.getNoticeMessage();
        }
        incoming.setNoticeMessage(noticeMessage);
        String contentSecurityRuleName = incoming.getContentSecurityRuleName();
        if (contentSecurityRuleName == null) {
            contentSecurityRuleName = existing.getContentSecurityRuleName();
        }
        incoming.setContentSecurityRuleName(contentSecurityRuleName);
        return incoming;
    }

    private final ParsedChatMessage mergeRuntimeNoticeIntoExisting(ParsedChatMessage existing, ParsedChatMessage incoming) {
        if (!existing.isAssistantMessage() || !incoming.isAssistantMessage() || incoming.isHistory()) {
            return existing;
        }
        String noticeType = incoming.getNoticeType();
        if (noticeType != null) {
            existing.setNoticeType(noticeType);
        }
        String noticeTitle = incoming.getNoticeTitle();
        if (noticeTitle != null) {
            existing.setNoticeTitle(noticeTitle);
        }
        String noticeMessage = incoming.getNoticeMessage();
        if (noticeMessage != null) {
            existing.setNoticeMessage(noticeMessage);
        }
        String contentSecurityRuleName = incoming.getContentSecurityRuleName();
        if (contentSecurityRuleName != null) {
            existing.setContentSecurityRuleName(contentSecurityRuleName);
        }
        return existing;
    }

    private final boolean shouldKeepExistingTerminalMessage(ParsedChatMessage existing, ParsedChatMessage incoming) {
        if (existing.isAssistantMessage() && incoming.isAssistantMessage() && isTerminalStatus(existing.getStatus())) {
            return !incoming.isHistory() || incoming.getStatus() == null || Intrinsics.areEqual(incoming.getStatus(), "in_progress") || Intrinsics.areEqual(incoming.getStatus(), "queuing");
        }
        return false;
    }

    private final boolean isTerminalStatus(String status) {
        return Intrinsics.areEqual(status, "completed") || Intrinsics.areEqual(status, "failed") || Intrinsics.areEqual(status, ConfirmInfo.STATUS_CANCELED);
    }

    private final void fixupUserMessageForAssistant(List<ParsedChatMessage> messages, ParsedChatMessage assistantMessage, Function2<? super String, ? super ParsedChatMessage, Unit> onUserMessageFixup) {
        String taskId;
        int i;
        int i2;
        long createdAt;
        ParsedChatMessage copy;
        String replyToMessageId = assistantMessage.getReplyToMessageId();
        if (replyToMessageId != null) {
            if (!(!StringsKt.isBlank(replyToMessageId))) {
                replyToMessageId = null;
            }
            if (replyToMessageId != null) {
                ParsedTaskContent taskContent = assistantMessage.getTaskContent();
                if (taskContent != null && (taskId = taskContent.getTaskId()) != null) {
                    if (!(!StringsKt.isBlank(taskId))) {
                        taskId = null;
                    }
                    if (taskId != null) {
                        ListIterator<ParsedChatMessage> listIterator = messages.listIterator(messages.size());
                        while (true) {
                            i = -1;
                            if (!listIterator.hasPrevious()) {
                                i2 = -1;
                                break;
                            }
                            ParsedChatMessage previous = listIterator.previous();
                            if (previous.isUserMessage() && Intrinsics.areEqual(previous.getTaskIdUser(), taskId)) {
                                i2 = listIterator.nextIndex();
                                break;
                            }
                        }
                        Integer valueOf = Integer.valueOf(i2);
                        if (!(valueOf.intValue() >= 0)) {
                            valueOf = null;
                        }
                        if (valueOf != null) {
                            i = valueOf.intValue();
                        } else {
                            ListIterator<ParsedChatMessage> listIterator2 = messages.listIterator(messages.size());
                            while (true) {
                                if (!listIterator2.hasPrevious()) {
                                    break;
                                }
                                ParsedChatMessage previous2 = listIterator2.previous();
                                if (previous2.isUserMessage() && Intrinsics.areEqual(previous2.getMessageId(), replyToMessageId)) {
                                    i = listIterator2.nextIndex();
                                    break;
                                }
                            }
                        }
                        if (i < 0) {
                            return;
                        }
                        ParsedChatMessage parsedChatMessage = messages.get(i);
                        Long valueOf2 = Long.valueOf(assistantMessage.getCreatedAt());
                        Long l = valueOf2.longValue() > 0 ? valueOf2 : null;
                        if (l != null) {
                            createdAt = l.longValue() - 1;
                        } else {
                            createdAt = parsedChatMessage.getCreatedAt();
                        }
                        long j = createdAt;
                        int i3 = i;
                        copy = parsedChatMessage.copy((r81 & 1) != 0 ? parsedChatMessage.sessionId : null, (r81 & 2) != 0 ? parsedChatMessage.messageId : replyToMessageId, (r81 & 4) != 0 ? parsedChatMessage.taskIdUser : null, (r81 & 8) != 0 ? parsedChatMessage.turnId : null, (r81 & 16) != 0 ? parsedChatMessage.status : null, (r81 & 32) != 0 ? parsedChatMessage.messageType : null, (r81 & 64) != 0 ? parsedChatMessage.role : null, (r81 & 128) != 0 ? parsedChatMessage.messageIndex : 0, (r81 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? parsedChatMessage.replyToMessageId : null, (r81 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? parsedChatMessage.userMessageContext : null, (r81 & 1024) != 0 ? parsedChatMessage.error : null, (r81 & 2048) != 0 ? parsedChatMessage.revertible : null, (r81 & 4096) != 0 ? parsedChatMessage.versionCode : null, (r81 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? parsedChatMessage.references : null, (r81 & 16384) != 0 ? parsedChatMessage.contextMetadata : null, (r81 & 32768) != 0 ? parsedChatMessage.searchReferenceData : null, (r81 & 65536) != 0 ? parsedChatMessage.docReferences : null, (r81 & 131072) != 0 ? parsedChatMessage.agentType : null, (r81 & 262144) != 0 ? parsedChatMessage.agentId : null, (r81 & FConstants.SLICE_SIZE) != 0 ? parsedChatMessage.agentName : null, (r81 & 1048576) != 0 ? parsedChatMessage.agentAvatarId : null, (r81 & 2097152) != 0 ? parsedChatMessage.traceId : null, (r81 & 4194304) != 0 ? parsedChatMessage.createdAt : j, (r81 & 8388608) != 0 ? parsedChatMessage.feeUsage : null, (16777216 & r81) != 0 ? parsedChatMessage.maxFeeUsage : null, (r81 & 33554432) != 0 ? parsedChatMessage.notifications : null, (r81 & 67108864) != 0 ? parsedChatMessage.modelSmartSelectionMeta : null, (r81 & 134217728) != 0 ? parsedChatMessage.fromAppendMsg : null, (r81 & 268435456) != 0 ? parsedChatMessage.shallowMementoType : null, (r81 & 536870912) != 0 ? parsedChatMessage.chatProcessVersion : null, (r81 & 1073741824) != 0 ? parsedChatMessage.tokenUsage : null, (r81 & Integer.MIN_VALUE) != 0 ? parsedChatMessage.contextUsage : null, (r82 & 1) != 0 ? parsedChatMessage.agentProcessSupport : null, (r82 & 2) != 0 ? parsedChatMessage.isWorktree : null, (r82 & 4) != 0 ? parsedChatMessage.isUserCanceled : null, (r82 & 8) != 0 ? parsedChatMessage.chatStartTime : null, (r82 & 16) != 0 ? parsedChatMessage.chatEndTime : null, (r82 & 32) != 0 ? parsedChatMessage.content : null, (r82 & 64) != 0 ? parsedChatMessage.query : null, (r82 & 128) != 0 ? parsedChatMessage.fastRequestSavings : null, (r82 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? parsedChatMessage.isHistory : true, (r82 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? parsedChatMessage.isAppendMessage : false, (r82 & 1024) != 0 ? parsedChatMessage.isInterjected : false, (r82 & 2048) != 0 ? parsedChatMessage.streamingChatModel : null, (r82 & 4096) != 0 ? parsedChatMessage.queuingPosition : null, (r82 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? parsedChatMessage.queuingMessage : null, (r82 & 16384) != 0 ? parsedChatMessage.noticeTitle : null, (r82 & 32768) != 0 ? parsedChatMessage.noticeMessage : null, (r82 & 65536) != 0 ? parsedChatMessage.contentSecurityRuleName : null, (r82 & 131072) != 0 ? parsedChatMessage.noticeType : null, (r82 & 262144) != 0 ? parsedChatMessage.queueId : null, (r82 & FConstants.SLICE_SIZE) != 0 ? parsedChatMessage.requestUUID : null, (r82 & 1048576) != 0 ? parsedChatMessage.fastRequestEvent : null, (r82 & 2097152) != 0 ? parsedChatMessage.hasMetaData : null, (r82 & 4194304) != 0 ? parsedChatMessage.sourcePhase : null);
                        messages.set(i3, copy);
                        removeDuplicateFixedUserMessages(messages, i3, taskId, replyToMessageId);
                        if (Intrinsics.areEqual(parsedChatMessage.getMessageId(), copy.getMessageId()) && parsedChatMessage.getCreatedAt() == copy.getCreatedAt() && parsedChatMessage.isHistory()) {
                            return;
                        }
                        onUserMessageFixup.invoke(parsedChatMessage.getMessageId(), copy);
                    }
                }
            }
        }
    }

    private final void removeDuplicateFixedUserMessages(List<ParsedChatMessage> messages, int fixedIndex, String taskId, String replyToMessageId) {
        int size = messages.size() - 1;
        if (size < 0) {
            return;
        }
        while (true) {
            int i = size - 1;
            if (size != fixedIndex) {
                ParsedChatMessage parsedChatMessage = messages.get(size);
                if (parsedChatMessage.isUserMessage() && (Intrinsics.areEqual(parsedChatMessage.getMessageId(), replyToMessageId) || Intrinsics.areEqual(parsedChatMessage.getTaskIdUser(), taskId))) {
                    messages.remove(size);
                }
            }
            if (i < 0) {
                return;
            } else {
                size = i;
            }
        }
    }

    private final ParsedChatMessage mergeDuplicateMessage(ParsedChatMessage existing, ParsedChatMessage incoming) {
        long createdAt;
        ParsedChatMessage copy;
        if (existing == null || !existing.isUserMessage() || !incoming.isUserMessage()) {
            return incoming;
        }
        if (existing.getCreatedAt() <= 0) {
            createdAt = incoming.getCreatedAt();
        } else {
            createdAt = incoming.getCreatedAt() <= 0 ? existing.getCreatedAt() : Math.min(existing.getCreatedAt(), incoming.getCreatedAt());
        }
        long j = createdAt;
        String taskIdUser = incoming.getTaskIdUser();
        if (taskIdUser == null) {
            taskIdUser = existing.getTaskIdUser();
        }
        String str = taskIdUser;
        String agentType = incoming.getAgentType();
        if (agentType == null) {
            agentType = existing.getAgentType();
        }
        String str2 = agentType;
        Object content = incoming.getContent();
        if (content == null) {
            content = existing.getContent();
        }
        Object obj = content;
        List<MessagePart> query = incoming.getQuery();
        if (query == null) {
            query = existing.getQuery();
        }
        copy = incoming.copy((r81 & 1) != 0 ? incoming.sessionId : null, (r81 & 2) != 0 ? incoming.messageId : null, (r81 & 4) != 0 ? incoming.taskIdUser : str, (r81 & 8) != 0 ? incoming.turnId : null, (r81 & 16) != 0 ? incoming.status : null, (r81 & 32) != 0 ? incoming.messageType : null, (r81 & 64) != 0 ? incoming.role : null, (r81 & 128) != 0 ? incoming.messageIndex : 0, (r81 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? incoming.replyToMessageId : null, (r81 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? incoming.userMessageContext : null, (r81 & 1024) != 0 ? incoming.error : null, (r81 & 2048) != 0 ? incoming.revertible : null, (r81 & 4096) != 0 ? incoming.versionCode : null, (r81 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? incoming.references : null, (r81 & 16384) != 0 ? incoming.contextMetadata : null, (r81 & 32768) != 0 ? incoming.searchReferenceData : null, (r81 & 65536) != 0 ? incoming.docReferences : null, (r81 & 131072) != 0 ? incoming.agentType : str2, (r81 & 262144) != 0 ? incoming.agentId : null, (r81 & FConstants.SLICE_SIZE) != 0 ? incoming.agentName : null, (r81 & 1048576) != 0 ? incoming.agentAvatarId : null, (r81 & 2097152) != 0 ? incoming.traceId : null, (r81 & 4194304) != 0 ? incoming.createdAt : j, (r81 & 8388608) != 0 ? incoming.feeUsage : null, (16777216 & r81) != 0 ? incoming.maxFeeUsage : null, (r81 & 33554432) != 0 ? incoming.notifications : null, (r81 & 67108864) != 0 ? incoming.modelSmartSelectionMeta : null, (r81 & 134217728) != 0 ? incoming.fromAppendMsg : null, (r81 & 268435456) != 0 ? incoming.shallowMementoType : null, (r81 & 536870912) != 0 ? incoming.chatProcessVersion : null, (r81 & 1073741824) != 0 ? incoming.tokenUsage : null, (r81 & Integer.MIN_VALUE) != 0 ? incoming.contextUsage : null, (r82 & 1) != 0 ? incoming.agentProcessSupport : null, (r82 & 2) != 0 ? incoming.isWorktree : null, (r82 & 4) != 0 ? incoming.isUserCanceled : null, (r82 & 8) != 0 ? incoming.chatStartTime : null, (r82 & 16) != 0 ? incoming.chatEndTime : null, (r82 & 32) != 0 ? incoming.content : obj, (r82 & 64) != 0 ? incoming.query : query, (r82 & 128) != 0 ? incoming.fastRequestSavings : null, (r82 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? incoming.isHistory : existing.isHistory() || incoming.isHistory(), (r82 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? incoming.isAppendMessage : false, (r82 & 1024) != 0 ? incoming.isInterjected : false, (r82 & 2048) != 0 ? incoming.streamingChatModel : null, (r82 & 4096) != 0 ? incoming.queuingPosition : null, (r82 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? incoming.queuingMessage : null, (r82 & 16384) != 0 ? incoming.noticeTitle : null, (r82 & 32768) != 0 ? incoming.noticeMessage : null, (r82 & 65536) != 0 ? incoming.contentSecurityRuleName : null, (r82 & 131072) != 0 ? incoming.noticeType : null, (r82 & 262144) != 0 ? incoming.queueId : null, (r82 & FConstants.SLICE_SIZE) != 0 ? incoming.requestUUID : null, (r82 & 1048576) != 0 ? incoming.fastRequestEvent : null, (r82 & 2097152) != 0 ? incoming.hasMetaData : null, (r82 & 4194304) != 0 ? incoming.sourcePhase : null);
        return copy;
    }

    private final List<ParsedChatMessage> markAppendInterjections(List<ParsedChatMessage> messages) {
        boolean z;
        List<ParsedChatMessage> list = messages;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (INSTANCE.hasAppendInterjectionSignal((ParsedChatMessage) it.next())) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            return messages;
        }
        List<ParsedChatMessage> mutableList = CollectionsKt.toMutableList(messages);
        int i = 0;
        for (Object obj : mutableList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ParsedChatMessage parsedChatMessage = (ParsedChatMessage) obj;
            if (parsedChatMessage.isAssistantMessage()) {
                ConversationMessageStateReducer conversationMessageStateReducer = INSTANCE;
                if (conversationMessageStateReducer.hasAppendInput(parsedChatMessage)) {
                    conversationMessageStateReducer.markInterjected(mutableList, i);
                    i = i2;
                }
            }
            if (parsedChatMessage.isUserMessage()) {
                ConversationMessageStateReducer conversationMessageStateReducer2 = INSTANCE;
                if (conversationMessageStateReducer2.isAppendUserMessage(parsedChatMessage)) {
                    conversationMessageStateReducer2.markInterjected(mutableList, conversationMessageStateReducer2.previousAssistantIndexBefore(mutableList, i));
                    i = i2;
                }
            }
            if (parsedChatMessage.isAssistantMessage() && Intrinsics.areEqual(parsedChatMessage.getFromAppendMsg(), true)) {
                String replyToMessageId = parsedChatMessage.getReplyToMessageId();
                Integer num = null;
                if (replyToMessageId != null) {
                    Iterator<ParsedChatMessage> it2 = mutableList.iterator();
                    int i3 = 0;
                    while (true) {
                        if (!it2.hasNext()) {
                            i3 = -1;
                            break;
                        }
                        if (Intrinsics.areEqual(it2.next().getMessageId(), replyToMessageId)) {
                            break;
                        }
                        i3++;
                    }
                    Integer valueOf = Integer.valueOf(i3);
                    if (valueOf.intValue() >= 0) {
                        num = valueOf;
                    }
                }
                if (num != null) {
                    i = num.intValue();
                }
                ConversationMessageStateReducer conversationMessageStateReducer3 = INSTANCE;
                conversationMessageStateReducer3.markInterjected(mutableList, conversationMessageStateReducer3.previousAssistantIndexBefore(mutableList, i));
            }
            i = i2;
        }
        return mutableList;
    }

    private final boolean hasAppendInterjectionSignal(ParsedChatMessage parsedChatMessage) {
        return hasAppendInput(parsedChatMessage) || isAppendUserMessage(parsedChatMessage) || Intrinsics.areEqual(parsedChatMessage.getFromAppendMsg(), true);
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

    private final boolean isAppendUserMessage(ParsedChatMessage parsedChatMessage) {
        JsonElement jsonElement;
        Object obj;
        boolean z = true;
        if (parsedChatMessage.isAppendMessage()) {
            return true;
        }
        JsonObject userMessageContext = parsedChatMessage.getUserMessageContext();
        if (userMessageContext == null || (jsonElement = userMessageContext.get(APPEND_USER_CONTEXT_KEY)) == null) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            if (!jsonElement.isJsonPrimitive() || !jsonElement.getAsJsonPrimitive().getAsBoolean()) {
                z = false;
            }
            obj = Result.constructor-impl(Boolean.valueOf(z));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = false;
        }
        return ((Boolean) obj).booleanValue();
    }

    private final void markInterjected(List<ParsedChatMessage> messages, int index) {
        ParsedChatMessage copy;
        if (index < 0 || messages.get(index).isInterjected()) {
            return;
        }
        copy = r2.copy((r81 & 1) != 0 ? r2.sessionId : null, (r81 & 2) != 0 ? r2.messageId : null, (r81 & 4) != 0 ? r2.taskIdUser : null, (r81 & 8) != 0 ? r2.turnId : null, (r81 & 16) != 0 ? r2.status : null, (r81 & 32) != 0 ? r2.messageType : null, (r81 & 64) != 0 ? r2.role : null, (r81 & 128) != 0 ? r2.messageIndex : 0, (r81 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r2.replyToMessageId : null, (r81 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r2.userMessageContext : null, (r81 & 1024) != 0 ? r2.error : null, (r81 & 2048) != 0 ? r2.revertible : null, (r81 & 4096) != 0 ? r2.versionCode : null, (r81 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r2.references : null, (r81 & 16384) != 0 ? r2.contextMetadata : null, (r81 & 32768) != 0 ? r2.searchReferenceData : null, (r81 & 65536) != 0 ? r2.docReferences : null, (r81 & 131072) != 0 ? r2.agentType : null, (r81 & 262144) != 0 ? r2.agentId : null, (r81 & FConstants.SLICE_SIZE) != 0 ? r2.agentName : null, (r81 & 1048576) != 0 ? r2.agentAvatarId : null, (r81 & 2097152) != 0 ? r2.traceId : null, (r81 & 4194304) != 0 ? r2.createdAt : 0L, (r81 & 8388608) != 0 ? r2.feeUsage : null, (16777216 & r81) != 0 ? r2.maxFeeUsage : null, (r81 & 33554432) != 0 ? r2.notifications : null, (r81 & 67108864) != 0 ? r2.modelSmartSelectionMeta : null, (r81 & 134217728) != 0 ? r2.fromAppendMsg : null, (r81 & 268435456) != 0 ? r2.shallowMementoType : null, (r81 & 536870912) != 0 ? r2.chatProcessVersion : null, (r81 & 1073741824) != 0 ? r2.tokenUsage : null, (r81 & Integer.MIN_VALUE) != 0 ? r2.contextUsage : null, (r82 & 1) != 0 ? r2.agentProcessSupport : null, (r82 & 2) != 0 ? r2.isWorktree : null, (r82 & 4) != 0 ? r2.isUserCanceled : null, (r82 & 8) != 0 ? r2.chatStartTime : null, (r82 & 16) != 0 ? r2.chatEndTime : null, (r82 & 32) != 0 ? r2.content : null, (r82 & 64) != 0 ? r2.query : null, (r82 & 128) != 0 ? r2.fastRequestSavings : null, (r82 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? r2.isHistory : false, (r82 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? r2.isAppendMessage : false, (r82 & 1024) != 0 ? r2.isInterjected : true, (r82 & 2048) != 0 ? r2.streamingChatModel : null, (r82 & 4096) != 0 ? r2.queuingPosition : null, (r82 & FConstants.DOWNLOAD_BUFFER_SIZE) != 0 ? r2.queuingMessage : null, (r82 & 16384) != 0 ? r2.noticeTitle : null, (r82 & 32768) != 0 ? r2.noticeMessage : null, (r82 & 65536) != 0 ? r2.contentSecurityRuleName : null, (r82 & 131072) != 0 ? r2.noticeType : null, (r82 & 262144) != 0 ? r2.queueId : null, (r82 & FConstants.SLICE_SIZE) != 0 ? r2.requestUUID : null, (r82 & 1048576) != 0 ? r2.fastRequestEvent : null, (r82 & 2097152) != 0 ? r2.hasMetaData : null, (r82 & 4194304) != 0 ? messages.get(index).sourcePhase : null);
        messages.set(index, copy);
    }

    private final int previousAssistantIndexBefore(List<ParsedChatMessage> messages, int beforeIndex) {
        if (beforeIndex <= 0) {
            return -1;
        }
        for (int i = beforeIndex - 1; -1 < i; i--) {
            if (messages.get(i).isAssistantMessage()) {
                return i;
            }
        }
        return -1;
    }

    private final List<ParsedChatMessage> removeStalePlaceholders(List<ParsedChatMessage> messages) {
        List<ParsedChatMessage> list = messages;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ParsedChatMessage parsedChatMessage = (ParsedChatMessage) next;
            if (parsedChatMessage.isAssistantMessage() && StringsKt.startsWith$default(parsedChatMessage.getMessageId(), "placeholder_", false, 2, (Object) null) && i < CollectionsKt.getLastIndex(messages)) {
                arrayList.add(next);
            }
            i = i2;
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return messages;
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            arrayList4.add(((ParsedChatMessage) it2.next()).getMessageId());
        }
        Set set = CollectionsKt.toSet(arrayList4);
        ArrayList arrayList5 = new ArrayList();
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            String replyToMessageId = ((ParsedChatMessage) it3.next()).getReplyToMessageId();
            if (replyToMessageId != null) {
                arrayList5.add(replyToMessageId);
            }
        }
        Set set2 = CollectionsKt.toSet(arrayList5);
        ArrayList arrayList6 = new ArrayList();
        for (Object obj : list) {
            ParsedChatMessage parsedChatMessage2 = (ParsedChatMessage) obj;
            if ((set.contains(parsedChatMessage2.getMessageId()) || (parsedChatMessage2.isUserMessage() && set2.contains(parsedChatMessage2.getMessageId()))) ? false : true) {
                arrayList6.add(obj);
            }
        }
        return arrayList6;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008c A[LOOP:1: B:22:0x005a->B:35:0x008c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0090 A[EDGE_INSN: B:36:0x0090->B:37:0x0090 BREAK  A[LOOP:1: B:22:0x005a->B:35:0x008c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0139 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[LOOP:3: B:67:0x00fe->B:85:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void upsertMessage(List<ParsedChatMessage> messages, ParsedChatMessage message) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        Iterator<ParsedChatMessage> it = messages.iterator();
        boolean z4 = false;
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getMessageId(), message.getMessageId())) {
                break;
            } else {
                i3++;
            }
        }
        if (!message.isAssistantMessage()) {
            if (i3 >= 0) {
                messages.set(i3, mergeDuplicateMessage(messages.get(i3), message));
                return;
            } else {
                messages.add(message);
                return;
            }
        }
        ParsedTaskContent taskContent = message.getTaskContent();
        String taskId = taskContent != null ? taskContent.getTaskId() : null;
        if (taskId != null) {
            i = 0;
            for (ParsedChatMessage parsedChatMessage : messages) {
                if (parsedChatMessage.isAssistantMessage()) {
                    ParsedTaskContent taskContent2 = parsedChatMessage.getTaskContent();
                    if (Intrinsics.areEqual(taskContent2 != null ? taskContent2.getTaskId() : null, taskId) && INSTANCE.isSameAssistantTurn(parsedChatMessage, message)) {
                        z3 = true;
                        if (!z3) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                z3 = false;
                if (!z3) {
                }
            }
        }
        i = -1;
        String replyToMessageId = message.getReplyToMessageId();
        if (replyToMessageId != null) {
            if (!(!StringsKt.isBlank(replyToMessageId))) {
                replyToMessageId = null;
            }
            if (replyToMessageId != null) {
                i2 = 0;
                for (ParsedChatMessage parsedChatMessage2 : messages) {
                    if (parsedChatMessage2.isAssistantMessage() && StringsKt.startsWith$default(parsedChatMessage2.getMessageId(), "placeholder_", false, 2, (Object) null) && Intrinsics.areEqual(parsedChatMessage2.getReplyToMessageId(), replyToMessageId)) {
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        i2 = -1;
        if (!StringsKt.startsWith$default(message.getMessageId(), "placeholder_", false, 2, (Object) null)) {
            int i4 = i3 >= 0 ? i3 : i >= 0 ? i : i2 >= 0 ? i2 : -1;
            if (i4 >= 0) {
                if (shouldKeepExistingTerminalMessage(messages.get(i4), message)) {
                    messages.set(i4, mergeRuntimeNoticeIntoExisting(messages.get(i4), message));
                    return;
                } else {
                    messages.set(i4, mergeExistingNoticeIntoIncoming(messages.get(i4), message));
                    return;
                }
            }
            messages.add(message);
            return;
        }
        if (taskId != null) {
            List<ParsedChatMessage> list = messages;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (ParsedChatMessage parsedChatMessage3 : list) {
                    if (parsedChatMessage3.isAssistantMessage()) {
                        ParsedTaskContent taskContent3 = parsedChatMessage3.getTaskContent();
                        if (Intrinsics.areEqual(taskContent3 != null ? taskContent3.getTaskId() : null, taskId) && INSTANCE.isSameAssistantTurn(parsedChatMessage3, message) && !StringsKt.startsWith$default(parsedChatMessage3.getMessageId(), "placeholder_", false, 2, (Object) null)) {
                            z = true;
                            if (!z) {
                                z2 = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
            z2 = false;
            if (z2) {
                z4 = true;
            }
        }
        if (z4) {
            return;
        }
        int i5 = i3 >= 0 ? i3 : i >= 0 ? i : -1;
        if (i5 >= 0) {
            messages.set(i5, message);
        } else {
            messages.add(message);
        }
    }
}
