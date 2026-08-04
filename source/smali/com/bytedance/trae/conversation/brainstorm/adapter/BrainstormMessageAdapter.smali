# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter;
.super Landroidx/recyclerview/widget/ListAdapter;
.source "BrainstormMessageAdapter.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$Companion;
.field private static final DIFF_CALLBACK:Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$Companion$DIFF_CALLBACK$1;
.field private static final TYPE_ASSISTANT:I
.field private static final TYPE_USER:I


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter;->Companion Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$Companion$DIFF_CALLBACK$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$Companion$DIFF_CALLBACK$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter;->DIFF_CALLBACK Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$Companion$DIFF_CALLBACK$1;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter;->DIFF_CALLBACK Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$Companion$DIFF_CALLBACK$1;
    check-cast v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/ListAdapter;-><init>(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V
    return-void 
.end method

.method public getItemViewType(int)int
    .registers 4
    # ins_size=2
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;->getRole()Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->ordinal()I
    move-result v3
    aget v3, v0, v3
    const/4 v0, 1
    if-eq v3, v0, +00ch
    const/4 v1, 2
    if-ne v3, v1, +003h
    goto +8h
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
    const/4 v0, 0
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$MessageViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$MessageViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.brainstorm.adapter.BrainstormMessageAdapter$MessageViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v3
    const-string v0, "getItem(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$MessageViewHolder;->bind(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessage;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$MessageViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.brainstorm.adapter.BrainstormMessageAdapter$MessageViewHolder
    .registers 5
    # ins_size=3
    const-string v0, "parent"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v4, +005h
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_message_user I
    goto +3h
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_message_ai I
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v4, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$MessageViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/BrainstormMessageAdapter$MessageViewHolder;-><init>(Landroid/view/View;)V
    return-object v4
.end method
