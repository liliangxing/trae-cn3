# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;
.super Ljava/lang/Object;
.source "PureShowWidgetPresentationState.kt"

.field private currentWidgetId:Ljava/lang/String;
.field private hasCompletedContent:Z
.field private initialized:Z


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final reset()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;->initialized Z
    const/4 v1, 0
    iput-object v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;->currentWidgetId Ljava/lang/String;
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;->hasCompletedContent Z
    return-void 
.end method

.method public final resolve(java.lang.String  boolean  boolean)com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetPresentationDecision
    .registers 7
    # ins_size=4
    iget-boolean v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;->initialized Z
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00dh
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;->currentWidgetId Ljava/lang/String;
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +008h
    iput-boolean v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;->initialized Z
    iput-object v4, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;->currentWidgetId Ljava/lang/String;
    iput-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;->hasCompletedContent Z
    if-eqz v5, +009h
    if-eqz v6, +007h
    iput-boolean v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;->hasCompletedContent Z
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->SHOW_COMPLETED Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    goto +11h
    if-eqz v5, +007h
    iput-boolean v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;->hasCompletedContent Z
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->SHOW_LOADING Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    goto +ah
    iget-boolean v4, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationState;->hasCompletedContent Z
    if-eqz v4, +005h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->KEEP_COMPLETED Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    goto +3h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;->SHOW_LOADING Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode;
    new-instance v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationDecision;
    invoke-direct v5, v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationDecision;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPresentationMode; Z)V
    return-object v5
.end method
