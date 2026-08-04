# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/ConversationDevicePolicy;
.super Ljava/lang/Object;
.source "ConversationDevicePolicy.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/ConversationDevicePolicy;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/ConversationDevicePolicy;
    invoke-direct v0, Lcom/bytedance/trae/conversation/ConversationDevicePolicy;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/ConversationDevicePolicy;->INSTANCE Lcom/bytedance/trae/conversation/ConversationDevicePolicy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final buildSelectedDevice(com.bytedance.trae.im.service.Conversation  com.bytedance.trae.im.service.Cli  java.lang.String)com.bytedance.trae.conversation.devices.SelectedDeviceItem
    .registers 21
    # ins_size=4
    move-object/from16 v0, v18
    const-string v1, "conversation"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v1, v17
    move-object/from16 v2, v20
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/conversation/ConversationDevicePolicy;->resolveCliType(Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String;)Lcom/bytedance/trae/im/service/CliType;
    move-result-object v5
    invoke-static/range v18, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->ownerIdeProjectId(Lcom/bytedance/trae/im/service/Conversation;)Ljava/lang/String;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    const/4 v4, 0
    const/4 v6, 1
    if-ne v5, v3, +018h
    invoke-static/range v18, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->ideProjectId(Lcom/bytedance/trae/im/service/Conversation;)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    move v3, v4
    goto +2h
    move v3, v6
    if-nez v3, +004h
    move v3, v6
    goto +2h
    move v3, v4
    if-eqz v3, +015h
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    move v3, v4
    goto +2h
    move v3, v6
    if-eqz v3, +004h
    move v3, v6
    goto +2h
    move v3, v4
    sget-object v7, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v5, v7, +00dh
    invoke-static/range v18, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->ideProjectPath(Lcom/bytedance/trae/im/service/Conversation;)Ljava/lang/String;
    move-result-object v7
    if-nez v7, +00bh
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/Conversation;->getWorkspace()Ljava/lang/String;
    move-result-object v7
    goto +5h
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/Conversation;->getWorkspace()Ljava/lang/String;
    move-result-object v7
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v8
    const-string v9, ""
    if-nez v8, +003h
    move-object v8, v9
    const/4 v10, 0
    if-eqz v19, +007h
    invoke-virtual/range v19, Lcom/bytedance/trae/im/service/Cli;->getName()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v10
    invoke-static v11, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->takeNotBlank(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    if-nez v11, +00ah
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +005h
    move-object v0, v9
    goto +2h
    move-object v0, v11
    if-eqz v19, +007h
    invoke-virtual/range v19, Lcom/bytedance/trae/im/service/Cli;->getIdeVersion()Ljava/lang/String;
    move-result-object v9
    goto +2h
    move-object v9, v10
    if-eqz v2, +00dh
    sget-object v11, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v5, v11, +004h
    move v11, v6
    goto +2h
    move v11, v4
    if-eqz v11, +004h
    move-object v11, v2
    goto +2h
    move-object v11, v10
    xor-int/lit8 v12, v3, 1
    if-eqz v7, +027h
    new-array v2, v6, [C
    const/16 v3, 47
    aput-char v3, v2, v4
    invoke-static v7, v2, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +01bh
    const/4 v13, 2
    invoke-static v2, v3, v10, v13, v10, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +014h
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v5, v3, +00dh
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v6
    if-eqz v3, +003h
    move v4, v6
    if-eqz v4, +003h
    move-object v10, v2
    const/4 v13, 0
    const/16 v14, 256
    const/4 v15, 0
    new-instance v16, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;
    move-object/from16 v2, v16
    move-object v3, v8
    move-object v4, v0
    move-object v6, v7
    move-object v7, v9
    move-object v8, v11
    move v9, v12
    move v11, v13
    move v12, v14
    move-object v13, v15
    invoke-direct/range v2 ... v13, Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v16
.end method

.method public final resolveCliType(com.bytedance.trae.im.service.Conversation  java.lang.String)com.bytedance.trae.im.service.CliType
    .registers 5
    # ins_size=3
    const-string v0, "conversation"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->takeNotBlank(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-static v4, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->takeNotBlank(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-static v3, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->ideProjectId(Lcom/bytedance/trae/im/service/Conversation;)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v3, +00bh
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +3h
    const/4 v3, 0
    goto +2h
    move v3, v1
    xor-int/2addr v3, v1
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +017h
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +00bh
    if-eqz v3, +009h
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v0
    goto +4h
    if-nez v0, +003h
    move-object v0, v4
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    goto +12h
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v3
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    goto +3h
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    return-object v3
.end method

.method public final shouldCheckIdeProject(com.bytedance.trae.im.service.Conversation  java.lang.String)boolean
    .registers 7
    # ins_size=3
    const-string v0, "conversation"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->ownerIdeProjectId(Lcom/bytedance/trae/im/service/Conversation;)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    xor-int/2addr v0, v2
    invoke-virtual v4, v5, v6, Lcom/bytedance/trae/conversation/ConversationDevicePolicy;->resolveCliType(Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String;)Lcom/bytedance/trae/im/service/CliType;
    move-result-object v6
    sget-object v3, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v6, v3, +019h
    if-nez v0, +017h
    invoke-static v5, Lcom/bytedance/trae/conversation/ConversationProjectContextKt;->ideProjectId(Lcom/bytedance/trae/im/service/Conversation;)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    move v5, v1
    goto +2h
    move v5, v2
    if-nez v5, +003h
    move v1, v2
    return v1
.end method
