# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;
.super Landroidx/recyclerview/widget/ListAdapter;
.source "InputAttachmentAdapter.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$Companion;
.field private static final DIFF_CALLBACK:Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$Companion$DIFF_CALLBACK$1;
.field private static final PAYLOAD_STATUS_CHANGED:I
.field private final onRemove:Lkotlin/jvm/functions/Function1;
.field private final onRetry:Lkotlin/jvm/functions/Function1;


.method public static synthetic $r8$lambda$WxbdMBj5lWHGQ6FPX4e0Th0YmyY(com.bytedance.trae.conversation.widget.AttachmentItem)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;->_init_$lambda$0(Lcom/bytedance/trae/conversation/widget/AttachmentItem;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;->Companion Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$Companion$DIFF_CALLBACK$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$Companion$DIFF_CALLBACK$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;->DIFF_CALLBACK Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$Companion$DIFF_CALLBACK$1;
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1)void
    .registers 4
    # ins_size=3
    const-string v0, "onRemove"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onRetry"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;->DIFF_CALLBACK Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$Companion$DIFF_CALLBACK$1;
    check-cast v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/ListAdapter;-><init>(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;->onRemove Lkotlin/jvm/functions/Function1;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;->onRetry Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function1  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +007h
    new-instance v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$$ExternalSyntheticLambda0;
    invoke-direct v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$$ExternalSyntheticLambda0;-><init>()V
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private static final _init_$lambda$0(com.bytedance.trae.conversation.widget.AttachmentItem)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder; I)V
    return-void 
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int  java.util.List)void
    .registers 4
    # ins_size=4
    check-cast v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder; I Ljava/util/List;)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.widget.InputAttachmentAdapter$ViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v3
    const-string v0, "getItem(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->bind(Lcom/bytedance/trae/conversation/widget/AttachmentItem;)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.widget.InputAttachmentAdapter$ViewHolder  int  java.util.List)void
    .registers 5
    # ins_size=4
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "payloads"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v4, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +008h
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    invoke-super v1, v2, v3, v4, Landroidx/recyclerview/widget/ListAdapter;->onBindViewHolder(Landroidx/recyclerview/widget/RecyclerView$ViewHolder; I Ljava/util/List;)V
    goto +fh
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v3
    const-string v4, "getItem(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/conversation/widget/AttachmentItem;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;->bindStatus(Lcom/bytedance/trae/conversation/widget/AttachmentItem;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.widget.InputAttachmentAdapter$ViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    const/4 v0, 0
    invoke-static v4, v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding;
    move-result-object v3
    const-string v4, "inflate(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v4, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;->onRemove Lkotlin/jvm/functions/Function1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter;->onRetry Lkotlin/jvm/functions/Function1;
    invoke-direct v4, v3, v0, v1, Lcom/bytedance/trae/conversation/widget/InputAttachmentAdapter$ViewHolder;-><init>(Lcom/bytedance/trae/conversation/databinding/TraeItemAttachmentBinding; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1;)V
    return-object v4
.end method
