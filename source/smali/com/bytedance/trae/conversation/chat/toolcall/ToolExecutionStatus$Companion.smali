# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;
.super Ljava/lang/Object;
.source "ToolExecutionStatus.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus$Companion;-><init>()V
    return-void 
.end method

.method public final fromString(java.lang.String)com.bytedance.trae.conversation.chat.toolcall.ToolExecutionStatus
    .registers 3
    # ins_size=2
    if-eqz v2, +05eh
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v0
    sparse-switch v0, +000005ch
    goto +55h
    const-string/jumbo v0, skipped
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +4bh
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->SKIPPED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    goto +4ah
    const-string/jumbo v0, running
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +3eh
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->RUNNING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    goto +3dh
    const-string v0, "error"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +024h
    goto +32h
    const-string v0, "canceled"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +29h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->CANCELED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    goto +28h
    const-string v0, "pending"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +1dh
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    goto +1ch
    const-string v0, "failed"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +11h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->FAILED Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    goto +10h
    const-string/jumbo v0, success
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +4h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->SUCCESS Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/ToolExecutionStatus;
    return-object v2
    nop 
    sparse-switch-payload -6f4abffd -4c696bc3 -28af7669 -7577b67 5c4d208 5c6f15bf 7fff6730
.end method
