# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;
.super Ljava/lang/Object;
.source "AssistantAvatarDisplayConfig.kt"

.field private static final AVATAR_KEY_TRAE_CODE:Ljava/lang/String;
.field private static final AVATAR_KEY_TRAE_IDE:Ljava/lang/String;
.field private static final AVATAR_KEY_TRAE_WORK:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;
.field private static final codeDisplay:Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
.field private static final defaultDisplay:Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
.field private static final ideDisplay:Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
.field private static final localDefaults:Ljava/util/Map;


.method static constructor <clinit>()void
    .registers 5
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
    const-string v1, "TRAE IDE"
    const-string/jumbo v2, trae_ide
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->ideDisplay Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
    const-string v1, "TRAE Code"
    const-string/jumbo v2, trae_code
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->codeDisplay Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
    const-string v2, "TRAE Work"
    const-string/jumbo v3, trae_work
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    sput-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->defaultDisplay Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
    const/4 v2, 4
    new-array v2, v2, [Lkotlin/Pair;
    const-string/jumbo v3, solo_agent_lite
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    const/4 v4, 0
    aput-object v3, v2, v4
    const-string/jumbo v3, solo_agent_remote
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/4 v3, 1
    aput-object v0, v2, v3
    const-string/jumbo v0, solo_work_lite
    invoke-static v0, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/4 v3, 2
    aput-object v0, v2, v3
    const-string/jumbo v0, solo_work_remote
    invoke-static v0, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/4 v1, 3
    aput-object v0, v2, v1
    invoke-static v2, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->localDefaults Ljava/util/Map;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic resolve$default(com.bytedance.trae.conversation.chat.block.renderer.AssistantAvatarDisplayConfig  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.chat.block.renderer.AssistantAvatarDisplay
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->resolve(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
    move-result-object v0
    return-object v0
.end method

.method public final avatarResId(java.lang.String)int
    .registers 4
    # ins_size=2
    if-eqz v3, +03ah
    invoke-virtual v3, Ljava/lang/String;->hashCode()I
    move-result v0
    const v1, 776444138
    if-eq v0, v1, +024h
    const v1, 777040398
    if-eq v0, v1, +015h
    const v1, 1271977997
    if-eq v0, v1, +003h
    goto +25h
    const-string/jumbo v0, trae_ide
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +1bh
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_avatar_coder I
    goto +1ah
    const-string/jumbo v0, trae_work
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +00dh
    goto +eh
    const-string/jumbo v0, trae_code
    invoke-virtual v3, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +003h
    goto +4h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_avatar_non_ide I
    goto +3h
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_avatar_non_ide I
    return v3
.end method

.method public final resolve(java.lang.String  java.lang.String)com.bytedance.trae.conversation.chat.block.renderer.AssistantAvatarDisplay
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v0, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v0
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->ideDisplay Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
    return-object v2
    if-eqz v2, +01fh
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +003h
    goto +2h
    const/4 v2, 0
    if-nez v2, +003h
    goto +eh
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->localDefaults Ljava/util/Map;
    invoke-interface v3, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
    if-nez v2, +004h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->defaultDisplay Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
    return-object v2
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->defaultDisplay Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
    return-object v2
.end method
