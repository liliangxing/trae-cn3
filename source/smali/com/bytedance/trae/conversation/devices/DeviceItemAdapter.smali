# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;
.super Landroidx/recyclerview/widget/ListAdapter;
.source "DeviceItemAdapter.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$Companion;
.field private static final DiffCallback:Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$Companion$DiffCallback$1;
.field private final onLocationClick:Lkotlin/jvm/functions/Function1;
.field private showProductType:Z


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;->Companion Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$Companion$DiffCallback$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$Companion$DiffCallback$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;->DiffCallback Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$Companion$DiffCallback$1;
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=2
    const-string v0, "onLocationClick"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;->DiffCallback Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$Companion$DiffCallback$1;
    check-cast v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/ListAdapter;-><init>(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;->onLocationClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public static final synthetic access$getItem(com.bytedance.trae.conversation.devices.DeviceItemAdapter  int)com.bytedance.trae.conversation.devices.DeviceItem
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    return-object v0
.end method

.method public static final synthetic access$getOnLocationClick$p(com.bytedance.trae.conversation.devices.DeviceItemAdapter)kotlin.jvm.functions.Function1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;->onLocationClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getShowProductType()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;->showProductType Z
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.devices.DeviceItemAdapter$LocationViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v3
    const-string v0, "getItem(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;->bind(Lcom/bytedance/trae/conversation/devices/DeviceItem;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.devices.DeviceItemAdapter$LocationViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_task_location I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v2, v3, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter$LocationViewHolder;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter; Landroid/view/View;)V
    return-object v4
.end method

.method public final setShowProductType(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/devices/DeviceItemAdapter;->showProductType Z
    return-void 
.end method
