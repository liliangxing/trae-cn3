# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;
.super Ljava/lang/Object;
.source "ConversationDebugInfoCopier.kt"

.field public static final CLIP_LABEL_AVATAR:Ljava/lang/String;
.field public static final CLIP_LABEL_VOICE_DISCUSSION:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;
.field private static final prettyGson:Lcom/google/gson/Gson;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;
    invoke-direct v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->INSTANCE Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;
    new-instance v0, Lcom/google/gson/GsonBuilder;
    invoke-direct v0, Lcom/google/gson/GsonBuilder;-><init>()V
    invoke-virtual v0, Lcom/google/gson/GsonBuilder;->disableHtmlEscaping()Lcom/google/gson/GsonBuilder;
    move-result-object v0
    invoke-virtual v0, Lcom/google/gson/GsonBuilder;->setPrettyPrinting()Lcom/google/gson/GsonBuilder;
    move-result-object v0
    invoke-virtual v0, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->prettyGson Lcom/google/gson/Gson;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic buildInfo$default(com.bytedance.trae.conversation.debug.ConversationDebugInfoCopier  long  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.debug.VoiceDiscussionDebugLogInfo  int  java.lang.Object)com.bytedance.trae.conversation.debug.ConversationDebugLogInfo
    .registers 18
    # ins_size=9
    and-int/lit8 v0, v16, 2
    const-string v1, ""
    if-eqz v0, +004h
    move-object v5, v1
    goto +2h
    move-object v5, v12
    and-int/lit8 v0, v16, 4
    if-eqz v0, +004h
    move-object v6, v1
    goto +2h
    move-object v6, v13
    and-int/lit8 v0, v16, 8
    if-eqz v0, +004h
    move-object v7, v1
    goto +2h
    move-object v7, v14
    and-int/lit8 v0, v16, 16
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v8, v0
    goto +2h
    move-object v8, v15
    move-object v2, v9
    move-wide v3, v10
    invoke-virtual/range v2 ... v8, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->buildInfo(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;)Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;
    move-result-object v0
    return-object v0
.end method

.method public final buildInfo(long  java.lang.String  java.lang.String  java.lang.String  com.bytedance.trae.conversation.debug.VoiceDiscussionDebugLogInfo)com.bytedance.trae.conversation.debug.ConversationDebugLogInfo
    .registers 18
    # ins_size=7
    const-string v0, "messageId"
    move-object v4, v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, replyToMessageId
    move-object v5, v15
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, sessionId
    move-object/from16 v6, v16
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00dh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    move-object v8, v0
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +005h
    const-string v0, "Oversea"
    goto +3h
    const-string v0, "CN"
    move-object v9, v0
    new-instance v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v7
    move-object v1, v0
    move-wide v2, v12
    move-object v4, v14
    move-object v5, v15
    move-object/from16 v6, v16
    move-object/from16 v10, v17
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;)V
    return-object v0
.end method

.method public final buildJsonFields(com.bytedance.trae.conversation.debug.ConversationDebugLogInfo)java.util.Map
    .registers 5
    # ins_size=2
    const-string v0, "info"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->getCreatedAt()J
    move-result-wide v1
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    const-string v2, "createdAt"
    invoke-virtual v0, v2, v1, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v1, "messageId"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->getMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, replyToMessageId
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->getReplyToMessageId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, sessionId
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->getSessionId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v1, "deviceid"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->getDeviceId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, userId
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->getUserId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v1, "location"
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->getLocation()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;->getVoiceDiscussion()Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;
    move-result-object v4
    if-eqz v4, +048h
    const-string/jumbo v1, voiceRoomId
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;->getVoiceRoomId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, voiceTaskId
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;->getVoiceTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, subTaskSessionId
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;->getSubTaskSessionId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, subTaskParentSessionId
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;->getSubTaskParentSessionId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, subTaskSourceTaskId
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;->getSubTaskSourceTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, subTaskLocalTaskId
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;->getSubTaskLocalTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, subTaskState
    invoke-virtual v4, Lcom/bytedance/trae/conversation/debug/VoiceDiscussionDebugLogInfo;->getSubTaskState()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v1, v4, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v0, Ljava/util/Map;
    return-object v0
.end method

.method public final buildJsonString(com.bytedance.trae.conversation.debug.ConversationDebugLogInfo)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "info"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->prettyGson Lcom/google/gson/Gson;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->buildJsonFields(Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;)Ljava/util/Map;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, toJson(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public final copy(android.content.Context  java.lang.String  com.bytedance.trae.conversation.debug.ConversationDebugLogInfo)void
    .registers 6
    # ins_size=4
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "label"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "info"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "clipboard"
    invoke-virtual v3, v0, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroid/content/ClipboardManager;
    if-eqz v1, +005h
    check-cast v0, Landroid/content/ClipboardManager;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +011h
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v2, v5, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->buildJsonString(Lcom/bytedance/trae/conversation/debug/ConversationDebugLogInfo;)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v4, v5, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Landroid/content/ClipData;
    move-result-object v4
    invoke-virtual v0, v4, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_copied I
    invoke-static v3, v4, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; I)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/debug/ConversationDebugInfoCopier;->uploadALog()V
    return-void 
.end method

.method public final uploadALog()void
    .registers 12
    # ins_size=1
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    const-wide/16 v2, 1000
    div-long v8, v0, v2
    const/16 v0, 18000
    int-to-long v0, v0
    sub-long v6, v8, v0
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v5, "feedback"
    const/4 v10, 0
    invoke-virtual/range v4 ... v10, Lcom/bytedance/trae/utils/logger/FLogger;->uploadALog(Ljava/lang/String; J J Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method
