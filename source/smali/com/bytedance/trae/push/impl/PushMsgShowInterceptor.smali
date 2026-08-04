# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/push/impl/PushMsgShowInterceptor;
.super Ljava/lang/Object;
.source "PushMsgShowInterceptor.kt"

.implements Lcom/bytedance/push/interfaze/IPushMsgShowInterceptor;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final parsePushConversationId(com.bytedance.push.PushBody)java.lang.String
    .registers 4
    # ins_size=2
    const/4 v0, 0
    if-eqz v3, +005h
    iget-object v3, v3, Lcom/bytedance/push/PushBody;->open_url Ljava/lang/String;
    goto +2h
    move-object v3, v0
    move-object v1, v3
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +3h
    const/4 v1, 0
    goto +2h
    const/4 v1, 1
    if-eqz v1, +003h
    return-object v0
    invoke-static v3, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v3
    const-string v1, "conversation_id"
    invoke-virtual v3, v1, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
    :try_start_0x19
.end method

.method public onReceivePassThoughMsg(android.content.Context  int  com.bytedance.push.PushBody)boolean
    .registers 8
    # ins_size=4
    sget-object v5, Lcom/bytedance/trae/push/impl/PushEventManager;->INSTANCE Lcom/bytedance/trae/push/impl/PushEventManager;
    invoke-virtual v5, v7, Lcom/bytedance/trae/push/impl/PushEventManager;->onPushArrive(Lcom/bytedance/push/PushBody;)V
    if-eqz v7, +005h
    iget-object v5, v7, Lcom/bytedance/push/PushBody;->open_url Ljava/lang/String;
    goto +2h
    const/4 v5, 0
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 1
    const/4 v0, 0
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    move v5, v0
    goto +2h
    move v5, v6
    if-eqz v5, +015h
    sget-object v5, Lcom/bytedance/trae/push/impl/PushEventManager;->INSTANCE Lcom/bytedance/trae/push/impl/PushEventManager;
    sget-object v1, Lcom/bytedance/trae/push/impl/PushTrackerType;->VALIDATE_FAIL Lcom/bytedance/trae/push/impl/PushTrackerType;
    const-string v2, "fail_reason"
    const-string v3, "missing_open_url_in_push_body"
    invoke-static v2, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    invoke-static v2, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v2
    invoke-virtual v5, v1, v2, Lcom/bytedance/trae/push/impl/PushEventManager;->trackPushProcess(Lcom/bytedance/trae/push/impl/PushTrackerType; Ljava/util/Map;)V
    sget-object v5, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getActivityStackManager()Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;
    move-result-object v5
    invoke-interface v5, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->isAppBackground()Z
    move-result v5
    if-eqz v5, +003h
    return v0
    sget-object v5, Lcom/bytedance/trae/push/api/ActiveConversationTracker;->INSTANCE Lcom/bytedance/trae/push/api/ActiveConversationTracker;
    invoke-virtual v5, Lcom/bytedance/trae/push/api/ActiveConversationTracker;->getActiveConversationId()Ljava/lang/String;
    move-result-object v5
    move-object v1, v5
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00ah
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +2h
    move v6, v0
    if-eqz v6, +003h
    return v0
    invoke-direct v4, v7, Lcom/bytedance/trae/push/impl/PushMsgShowInterceptor;->parsePushConversationId(Lcom/bytedance/push/PushBody;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    return v0
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    return v5
.end method

.method public onReceiveRevokeMsg(android.content.Context  int  com.bytedance.push.PushBody)boolean
    .registers 4
    # ins_size=4
    const/4 v1, 0
    return v1
.end method
