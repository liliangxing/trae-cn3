package com.bytedance.trae.im.repository;

import android.util.Log;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.im.database.ConversationDetailDao;
import com.bytedance.trae.im.database.ConversationDetailEntity;
import com.bytedance.trae.im.model.ChatMessage;
import com.bytedance.trae.im.model.ChatMessageParser;
import com.bytedance.trae.im.model.DocReferencesData;
import com.bytedance.trae.im.model.MessagePart;
import com.bytedance.trae.im.model.ModelSmartSelectionMeta;
import com.bytedance.trae.im.model.NotificationPayload;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.bytedance.trae.im.model.ParsedContextUsage;
import com.bytedance.trae.im.model.ParsedError;
import com.bytedance.trae.im.model.ParsedTaskContent;
import com.bytedance.trae.im.model.ParsedTokenUsage;
import com.bytedance.trae.im.model.Reference;
import com.bytedance.trae.im.model.SearchReferenceData;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: ConversationDetailCacheRepository.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0002-.B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u001c\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0010J\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0011J\u001e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0011J\u0016\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013J\u001c\u0010 \u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010J\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010#\u001a\u00020\u0017J\u0010\u0010$\u001a\u00020\u00172\b\b\u0002\u0010%\u001a\u00020\u0015J\b\u0010&\u001a\u00020\u0017H\u0002J\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J\u0012\u0010)\u001a\u0004\u0018\u00010\u00112\u0006\u0010*\u001a\u00020(H\u0002J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\t¨\u0006/"}, d2 = {"Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;", "", "dao", "Lcom/bytedance/trae/im/database/ConversationDetailDao;", "<init>", "(Lcom/bytedance/trae/im/database/ConversationDetailDao;)V", "chatMessageGson", "Lcom/google/gson/Gson;", "getChatMessageGson", "()Lcom/google/gson/Gson;", "chatMessageGson$delegate", "Lkotlin/Lazy;", "parsedMessageGson", "getParsedMessageGson", "parsedMessageGson$delegate", "loadCachedMessages", "", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "conversationId", "", "limit", "", "cacheNetworkMessages", "", "messages", "Lcom/bytedance/trae/im/model/ChatMessage;", "cacheParsedMessage", "message", "replaceUserMessage", "oldMessageId", "deleteUserMessage", "messageId", "deleteUserMessages", "messageIds", "deleteByConversationId", "deleteAll", "trimIfNeeded", "maxRows", "triggerTrimOnce", "toEntity", "Lcom/bytedance/trae/im/database/ConversationDetailEntity;", "deserialize", "entity", "repairContentType", "msg", "ParsedContentTypeAdapter", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationDetailCacheRepository {
    private static final String CONTENT_TYPE_CHAT_MESSAGE = "chat_message";
    private static final String CONTENT_TYPE_PARSED_CHAT_MESSAGE = "parsed_chat_message";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String DIFF_TAG = "CacheFieldDiff";
    private static final int MAX_ROWS = 2000;
    private static final String TAG = "ConvDetailCacheRepo";
    private static volatile boolean trimExecuted;

    /* renamed from: chatMessageGson$delegate, reason: from kotlin metadata */
    private final Lazy chatMessageGson;
    private final ConversationDetailDao dao;

    /* renamed from: parsedMessageGson$delegate, reason: from kotlin metadata */
    private final Lazy parsedMessageGson;

    public ConversationDetailCacheRepository(ConversationDetailDao conversationDetailDao) {
        Intrinsics.checkNotNullParameter(conversationDetailDao, "dao");
        this.dao = conversationDetailDao;
        this.chatMessageGson = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.im.repository.ConversationDetailCacheRepository$$ExternalSyntheticLambda1
            public final Object invoke() {
                Gson chatMessageGson_delegate$lambda$0;
                chatMessageGson_delegate$lambda$0 = ConversationDetailCacheRepository.chatMessageGson_delegate$lambda$0();
                return chatMessageGson_delegate$lambda$0;
            }
        });
        this.parsedMessageGson = LazyKt.lazy(new Function0() { // from class: com.bytedance.trae.im.repository.ConversationDetailCacheRepository$$ExternalSyntheticLambda2
            public final Object invoke() {
                Gson parsedMessageGson_delegate$lambda$1;
                parsedMessageGson_delegate$lambda$1 = ConversationDetailCacheRepository.parsedMessageGson_delegate$lambda$1();
                return parsedMessageGson_delegate$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson chatMessageGson_delegate$lambda$0() {
        return new Gson();
    }

    private final Gson getChatMessageGson() {
        return (Gson) this.chatMessageGson.getValue();
    }

    private final Gson getParsedMessageGson() {
        Object value = this.parsedMessageGson.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Gson) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson parsedMessageGson_delegate$lambda$1() {
        return new GsonBuilder().registerTypeAdapter(Object.class, new ParsedContentTypeAdapter()).create();
    }

    public static /* synthetic */ List loadCachedMessages$default(ConversationDetailCacheRepository conversationDetailCacheRepository, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 10;
        }
        return conversationDetailCacheRepository.loadCachedMessages(str, i);
    }

    public final List<ParsedChatMessage> loadCachedMessages(String conversationId, int limit) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        try {
            List<ConversationDetailEntity> queryLatest = this.dao.queryLatest(conversationId, limit);
            for (ConversationDetailEntity conversationDetailEntity : queryLatest) {
                if (Intrinsics.areEqual(conversationDetailEntity.getContentType(), CONTENT_TYPE_PARSED_CHAT_MESSAGE) && AppHost.INSTANCE.isDebug()) {
                    INSTANCE.dumpRawJsonFields("READ_raw", conversationDetailEntity.getMessageId(), conversationDetailEntity.getContent());
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = queryLatest.iterator();
            while (it.hasNext()) {
                ParsedChatMessage deserialize = deserialize((ConversationDetailEntity) it.next());
                if (deserialize != null) {
                    arrayList.add(deserialize);
                }
            }
            ArrayList<ParsedChatMessage> arrayList2 = arrayList;
            for (ParsedChatMessage parsedChatMessage : arrayList2) {
                if (AppHost.INSTANCE.isDebug()) {
                    INSTANCE.dumpParsedMessageFields("READ_parsed", parsedChatMessage.getMessageId(), parsedChatMessage);
                }
            }
            List<ParsedChatMessage> normalizeDisplayableHistoryMessages = ChatMessageParser.INSTANCE.normalizeDisplayableHistoryMessages(CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: com.bytedance.trae.im.repository.ConversationDetailCacheRepository$loadCachedMessages$$inlined$sortedBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Long.valueOf(((ParsedChatMessage) t).getCreatedAt()), Long.valueOf(((ParsedChatMessage) t2).getCreatedAt()));
                }
            }));
            triggerTrimOnce();
            return normalizeDisplayableHistoryMessages;
        } catch (Exception e) {
            Log.w(TAG, "loadCachedMessages failed: conversationId=" + conversationId, e);
            return CollectionsKt.emptyList();
        }
    }

    public final void cacheNetworkMessages(String conversationId, List<ChatMessage> messages) {
        ArrayList arrayList;
        String role;
        long currentTimeMillis;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messages, "messages");
        try {
            arrayList = new ArrayList();
            for (ChatMessage chatMessage : messages) {
                String messageId = chatMessage.getMessageId();
                ConversationDetailEntity conversationDetailEntity = null;
                if (messageId != null && (role = chatMessage.getRole()) != null) {
                    Long messageIndex = chatMessage.getMessageIndex();
                    int coerceIn = messageIndex != null ? (int) RangesKt.coerceIn(messageIndex.longValue(), -2147483648L, 2147483647L) : 0;
                    String json = getChatMessageGson().toJson(chatMessage);
                    Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
                    String status = chatMessage.getStatus();
                    String createdAtMs = chatMessage.getCreatedAtMs();
                    if (createdAtMs != null && (longOrNull = StringsKt.toLongOrNull(createdAtMs)) != null) {
                        currentTimeMillis = ParsedChatMessage.INSTANCE.normalizeToMillis(longOrNull.longValue());
                    } else {
                        currentTimeMillis = System.currentTimeMillis();
                    }
                    conversationDetailEntity = new ConversationDetailEntity(conversationId, messageId, coerceIn, role, CONTENT_TYPE_CHAT_MESSAGE, json, status, currentTimeMillis, System.currentTimeMillis());
                }
                if (conversationDetailEntity != null) {
                    arrayList.add(conversationDetailEntity);
                }
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            this.dao.replaceAllForConversation(conversationId, arrayList);
        } catch (Exception e2) {
            e = e2;
            Log.w(TAG, "cacheNetworkMessages failed: conversationId=" + conversationId, e);
        }
    }

    public final void cacheParsedMessage(String conversationId, ParsedChatMessage message) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            if (AppHost.INSTANCE.isDebug()) {
                INSTANCE.dumpParsedMessageFields("WRITE_cache", message.getMessageId(), message);
            }
            this.dao.insertOrReplace(toEntity(conversationId, message));
        } catch (Exception e) {
            Log.w(TAG, "cacheParsedMessage failed: messageId=" + message.getMessageId(), e);
        }
    }

    public final void replaceUserMessage(String conversationId, String oldMessageId, ParsedChatMessage message) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(oldMessageId, "oldMessageId");
        Intrinsics.checkNotNullParameter(message, "message");
        try {
            if (AppHost.INSTANCE.isDebug()) {
                INSTANCE.dumpParsedMessageFields("WRITE_replace", message.getMessageId(), message);
            }
            this.dao.deleteByMessageId(conversationId, oldMessageId);
            this.dao.insertOrReplace(toEntity(conversationId, message));
        } catch (Exception e) {
            Log.w(TAG, "replaceUserMessage failed: old=" + oldMessageId + ", new=" + message.getMessageId(), e);
        }
    }

    public final void deleteUserMessage(String conversationId, String messageId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageId, "messageId");
        try {
            this.dao.deleteByMessageId(conversationId, messageId);
        } catch (Exception e) {
            Log.w(TAG, "deleteUserMessage failed: messageId=" + messageId, e);
        }
    }

    public final void deleteUserMessages(String conversationId, List<String> messageIds) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(messageIds, "messageIds");
        try {
            this.dao.deleteByMessageIds(conversationId, messageIds);
        } catch (Exception e) {
            Log.w(TAG, "deleteUserMessages failed: count=" + messageIds.size(), e);
        }
    }

    public final void deleteByConversationId(String conversationId) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        try {
            this.dao.deleteByConversationId(conversationId);
        } catch (Exception e) {
            Log.w(TAG, "deleteByConversationId failed: " + conversationId, e);
        }
    }

    public final void deleteAll() {
        try {
            this.dao.deleteAll();
        } catch (Exception e) {
            Log.w(TAG, "deleteAll failed", e);
        }
    }

    public static /* synthetic */ void trimIfNeeded$default(ConversationDetailCacheRepository conversationDetailCacheRepository, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2000;
        }
        conversationDetailCacheRepository.trimIfNeeded(i);
    }

    public final void trimIfNeeded(int maxRows) {
        try {
            int trimOldConversations = this.dao.trimOldConversations(maxRows);
            if (trimOldConversations > 0) {
                Log.i(TAG, "trimIfNeeded: removed " + trimOldConversations + " stale conversation(s)");
            }
        } catch (Exception e) {
            Log.w(TAG, "trimIfNeeded failed", e);
        }
    }

    private final void triggerTrimOnce() {
        if (trimExecuted) {
            return;
        }
        trimExecuted = true;
        new Thread(new Runnable() { // from class: com.bytedance.trae.im.repository.ConversationDetailCacheRepository$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ConversationDetailCacheRepository.trimIfNeeded$default(ConversationDetailCacheRepository.this, 0, 1, null);
            }
        }).start();
    }

    private final ConversationDetailEntity toEntity(String conversationId, ParsedChatMessage message) {
        String messageId = message.getMessageId();
        int messageIndex = message.getMessageIndex();
        String role = message.getRole();
        String json = getParsedMessageGson().toJson(message);
        Intrinsics.checkNotNullExpressionValue(json, "toJson(...)");
        return new ConversationDetailEntity(conversationId, messageId, messageIndex, role, CONTENT_TYPE_PARSED_CHAT_MESSAGE, json, message.getStatus(), message.getCreatedAt(), System.currentTimeMillis());
    }

    private final ParsedChatMessage deserialize(ConversationDetailEntity entity) {
        ParsedChatMessage parsedChatMessage;
        try {
            String contentType = entity.getContentType();
            if (Intrinsics.areEqual(contentType, CONTENT_TYPE_CHAT_MESSAGE)) {
                ChatMessage chatMessage = (ChatMessage) getChatMessageGson().fromJson(entity.getContent(), ChatMessage.class);
                ChatMessageParser chatMessageParser = ChatMessageParser.INSTANCE;
                Intrinsics.checkNotNull(chatMessage);
                parsedChatMessage = chatMessageParser.parse(chatMessage);
                if (parsedChatMessage == null) {
                    return null;
                }
                parsedChatMessage.setHistory(true);
            } else {
                if (!Intrinsics.areEqual(contentType, CONTENT_TYPE_PARSED_CHAT_MESSAGE) || (parsedChatMessage = (ParsedChatMessage) getParsedMessageGson().fromJson(entity.getContent(), ParsedChatMessage.class)) == null) {
                    return null;
                }
                parsedChatMessage.setHistory(true);
                repairContentType(parsedChatMessage);
            }
            return parsedChatMessage;
        } catch (Exception e) {
            Log.w(TAG, "deserialize failed: messageId=" + entity.getMessageId() + ", contentType=" + entity.getContentType(), e);
            return null;
        }
    }

    private final void repairContentType(ParsedChatMessage msg) {
        Object content = msg.getContent();
        if (content instanceof Map) {
            try {
                msg.setContent((ParsedTaskContent) getChatMessageGson().fromJson(getChatMessageGson().toJson(content), ParsedTaskContent.class));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConversationDetailCacheRepository.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$ParsedContentTypeAdapter;", "Lcom/google/gson/JsonSerializer;", "", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "deserialize", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ParsedContentTypeAdapter implements JsonSerializer<Object>, JsonDeserializer<Object> {
        private final Gson gson = new Gson();

        public JsonElement serialize(Object src, Type typeOfSrc, JsonSerializationContext context) {
            Intrinsics.checkNotNullParameter(typeOfSrc, "typeOfSrc");
            Intrinsics.checkNotNullParameter(context, "context");
            if (src instanceof String) {
                return new JsonPrimitive((String) src);
            }
            if (src instanceof ParsedTaskContent) {
                JsonElement jsonTree = this.gson.toJsonTree(src, ParsedTaskContent.class);
                Intrinsics.checkNotNullExpressionValue(jsonTree, "toJsonTree(...)");
                return jsonTree;
            }
            JsonElement serialize = context.serialize(src);
            Intrinsics.checkNotNullExpressionValue(serialize, "serialize(...)");
            return serialize;
        }

        public Object deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(typeOfT, "typeOfT");
            Intrinsics.checkNotNullParameter(context, "context");
            if (json.isJsonPrimitive() && json.getAsJsonPrimitive().isString()) {
                return json.getAsString();
            }
            if (json.isJsonObject()) {
                return this.gson.fromJson(json, ParsedTaskContent.class);
            }
            return null;
        }
    }

    /* compiled from: ConversationDetailCacheRepository.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000f\u001a\u00020\bH\u0002J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository$Companion;", "", "<init>", "()V", "TAG", "", "DIFF_TAG", "MAX_ROWS", "", "trimExecuted", "", "CONTENT_TYPE_CHAT_MESSAGE", "CONTENT_TYPE_PARSED_CHAT_MESSAGE", "truncate", "value", "maxLen", "dumpParsedMessageFields", "", "op", "msgId", "msg", "Lcom/bytedance/trae/im/model/ParsedChatMessage;", "dumpRawJsonFields", "json", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        static /* synthetic */ String truncate$default(Companion companion, String str, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 30;
            }
            return companion.truncate(str, i);
        }

        private final String truncate(String value, int maxLen) {
            return value == null ? "null" : value.length() <= maxLen ? value : StringsKt.take(value, maxLen) + (char) 8230;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void dumpParsedMessageFields(String op, String msgId, ParsedChatMessage msg) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("[" + op + "] msgId=" + msgId);
                sb.append(" | session_id=" + truncate$default(this, msg.getSessionId(), 0, 2, null));
                sb.append(" | message_id=" + truncate$default(this, msg.getMessageId(), 0, 2, null));
                sb.append(" | turn_id=" + truncate$default(this, msg.getTurnId(), 0, 2, null));
                sb.append(" | status=" + truncate$default(this, msg.getStatus(), 0, 2, null));
                sb.append(" | message_type=" + truncate$default(this, msg.getMessageType(), 0, 2, null));
                sb.append(" | role=" + truncate$default(this, msg.getRole(), 0, 2, null));
                sb.append(" | message_index=" + msg.getMessageIndex());
                sb.append(" | reply_to_message_id=" + truncate$default(this, msg.getReplyToMessageId(), 0, 2, null));
                StringBuilder sb2 = new StringBuilder(" | user_message_context=");
                JsonObject userMessageContext = msg.getUserMessageContext();
                sb.append(sb2.append(truncate$default(this, userMessageContext != null ? userMessageContext.toString() : null, 0, 2, null)).toString());
                StringBuilder sb3 = new StringBuilder(" | error=");
                ParsedError error = msg.getError();
                sb.append(sb3.append(truncate$default(this, error != null ? error.toString() : null, 0, 2, null)).toString());
                sb.append(" | revertible=" + msg.getRevertible());
                StringBuilder sb4 = new StringBuilder(" | references=");
                List<Reference> references = msg.getReferences();
                sb.append(sb4.append(truncate$default(this, references != null ? references.toString() : null, 0, 2, null)).toString());
                StringBuilder sb5 = new StringBuilder(" | context_metadata=");
                JsonObject contextMetadata = msg.getContextMetadata();
                sb.append(sb5.append(truncate$default(this, contextMetadata != null ? contextMetadata.toString() : null, 0, 2, null)).toString());
                StringBuilder sb6 = new StringBuilder(" | search_reference_data=");
                SearchReferenceData searchReferenceData = msg.getSearchReferenceData();
                sb.append(sb6.append(truncate$default(this, searchReferenceData != null ? searchReferenceData.toString() : null, 0, 2, null)).toString());
                StringBuilder sb7 = new StringBuilder(" | doc_references=");
                DocReferencesData docReferences = msg.getDocReferences();
                sb.append(sb7.append(truncate$default(this, docReferences != null ? docReferences.toString() : null, 0, 2, null)).toString());
                sb.append(" | agent_type=" + truncate$default(this, msg.getAgentType(), 0, 2, null));
                sb.append(" | agent_id=" + truncate$default(this, msg.getAgentId(), 0, 2, null));
                sb.append(" | agent_name=" + truncate$default(this, msg.getAgentName(), 0, 2, null));
                sb.append(" | agent_avatar_id=" + truncate$default(this, msg.getAgentAvatarId(), 0, 2, null));
                sb.append(" | trace_id=" + truncate$default(this, msg.getTraceId(), 0, 2, null));
                sb.append(" | created_at=" + msg.getCreatedAt());
                StringBuilder sb8 = new StringBuilder(" | fee_usage=");
                JsonObject feeUsage = msg.getFeeUsage();
                sb.append(sb8.append(truncate$default(this, feeUsage != null ? feeUsage.toString() : null, 0, 2, null)).toString());
                StringBuilder sb9 = new StringBuilder(" | max_fee_usage=");
                JsonObject maxFeeUsage = msg.getMaxFeeUsage();
                sb.append(sb9.append(truncate$default(this, maxFeeUsage != null ? maxFeeUsage.toString() : null, 0, 2, null)).toString());
                StringBuilder sb10 = new StringBuilder(" | notifications=");
                List<NotificationPayload> notifications = msg.getNotifications();
                sb.append(sb10.append(truncate$default(this, notifications != null ? notifications.toString() : null, 0, 2, null)).toString());
                StringBuilder sb11 = new StringBuilder(" | model_smart_selection_meta=");
                ModelSmartSelectionMeta modelSmartSelectionMeta = msg.getModelSmartSelectionMeta();
                sb.append(sb11.append(truncate$default(this, modelSmartSelectionMeta != null ? modelSmartSelectionMeta.toString() : null, 0, 2, null)).toString());
                sb.append(" | from_append_msg=" + msg.getFromAppendMsg());
                sb.append(" | shallow_memento_type=" + truncate$default(this, msg.getShallowMementoType(), 0, 2, null));
                sb.append(" | chat_process_version=" + truncate$default(this, msg.getChatProcessVersion(), 0, 2, null));
                StringBuilder sb12 = new StringBuilder(" | token_usage=");
                ParsedTokenUsage tokenUsage = msg.getTokenUsage();
                sb.append(sb12.append(truncate$default(this, tokenUsage != null ? tokenUsage.toString() : null, 0, 2, null)).toString());
                StringBuilder sb13 = new StringBuilder(" | context_usage=");
                ParsedContextUsage contextUsage = msg.getContextUsage();
                sb.append(sb13.append(truncate$default(this, contextUsage != null ? contextUsage.toString() : null, 0, 2, null)).toString());
                sb.append(" | agent_process_support=" + truncate$default(this, msg.getAgentProcessSupport(), 0, 2, null));
                sb.append(" | is_worktree=" + msg.isWorktree());
                sb.append(" | is_user_canceled=" + msg.isUserCanceled());
                sb.append(" | chat_start_time=" + msg.getChatStartTime());
                sb.append(" | chat_end_time=" + msg.getChatEndTime());
                StringBuilder sb14 = new StringBuilder(" | content=");
                Object content = msg.getContent();
                sb.append(sb14.append(truncate$default(this, content != null ? content.toString() : null, 0, 2, null)).toString());
                StringBuilder sb15 = new StringBuilder(" | query=");
                List<MessagePart> query = msg.getQuery();
                sb.append(sb15.append(truncate$default(this, query != null ? query.toString() : null, 0, 2, null)).toString());
                TraeLogUtil.INSTANCE.d(ConversationDetailCacheRepository.DIFF_TAG, sb.toString());
            } catch (Exception unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void dumpRawJsonFields(String op, String msgId, String json) {
            String str;
            try {
                JsonObject jsonObject = (JsonObject) new Gson().fromJson(json, JsonObject.class);
                if (jsonObject == null) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[" + op + "] msgId=" + msgId);
                Set keySet = jsonObject.keySet();
                Intrinsics.checkNotNullExpressionValue(keySet, "keySet(...)");
                for (String str2 : CollectionsKt.sorted(keySet)) {
                    JsonElement jsonElement = jsonObject.get(str2);
                    if (jsonElement == null || (str = jsonElement.toString()) == null) {
                        str = "null";
                    }
                    sb.append(" | " + str2 + '=' + truncate$default(this, str, 0, 2, null));
                }
                TraeLogUtil.INSTANCE.d(ConversationDetailCacheRepository.DIFF_TAG, sb.toString());
            } catch (Exception e) {
                TraeLogUtil.INSTANCE.w(ConversationDetailCacheRepository.DIFF_TAG, "[" + op + "] dumpRawJsonFields error: msgId=" + msgId, e);
            }
        }
    }
}
