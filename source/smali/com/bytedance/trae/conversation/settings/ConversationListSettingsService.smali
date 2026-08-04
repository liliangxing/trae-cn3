# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;
.super Ljava/lang/Object;
.source "IConversationListSettings.kt"

.field private static final DEFAULT_PAGE_SIZE:I
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;
.field private static final TAG:Ljava/lang/String;
.field private static bridge cachedPageSize:Ljava/lang/Integer;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;
    invoke-direct v0, Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;->INSTANCE Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getPageSize()int
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;->cachedPageSize Ljava/lang/Integer;
    if-eqz v0, +009h
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    return v0
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v6
    check-cast v1, Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;
    const-class v1, Lcom/bytedance/trae/conversation/settings/IConversationListSettings;
    invoke-static v1, Lcom/bytedance/news/common/settings/SettingsManager;->obtain(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/settings/IConversationListSettings;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/conversation/settings/IConversationListSettings;->getConversationListPageSize()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v0
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v2
    if-eqz v2, +00bh
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v4, "ConversationListSettings"
    const-string v5, "obtain conversation_list_page_size settings failed"
    invoke-virtual v3, v4, v5, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    if-eqz v1, +01eh
    invoke-static v1, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v1
    if-eqz v1, +018h
    move-object v2, v1
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v2
    if-lez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, +003h
    move-object v0, v1
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    goto +3h
    const/16 v0, 300
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/conversation/settings/ConversationListSettingsService;->cachedPageSize Ljava/lang/Integer;
    return v0
    :try_start_0xc
.end method
