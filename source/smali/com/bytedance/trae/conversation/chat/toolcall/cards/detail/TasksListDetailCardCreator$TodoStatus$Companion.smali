# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus$Companion;
.super Ljava/lang/Object;
.source "TasksListDetailCardCreator.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus$Companion;-><init>()V
    return-void 
.end method

.method public final fromString(java.lang.String)com.bytedance.trae.conversation.chat.toolcall.cards.detail.TasksListDetailCardCreator$TodoStatus
    .registers 3
    # ins_size=2
    const-string v0, "completed"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;->COMPLETED Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;
    goto +eh
    const-string v0, "in_progress"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;->IN_PROGRESS Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;->PENDING Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/TasksListDetailCardCreator$TodoStatus;
    return-object v2
.end method
