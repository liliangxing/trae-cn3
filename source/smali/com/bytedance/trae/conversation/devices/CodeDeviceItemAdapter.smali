# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
.super Landroidx/recyclerview/widget/ListAdapter;
.source "CodeDeviceItemAdapter.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$Companion;
.field private static final DiffCallback:Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$Companion$DiffCallback$1;
.field private static final VIEW_TYPE_ADD_DEVICE:I
.field private static final VIEW_TYPE_DEVICE:I
.field private final onAddDeviceClick:Lkotlin/jvm/functions/Function0;
.field private final onLocationClick:Lkotlin/jvm/functions/Function1;
.field private showProductType:Z


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->Companion Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$Companion$DiffCallback$1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$Companion$DiffCallback$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->DiffCallback Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$Companion$DiffCallback$1;
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=3
    const-string v0, "onLocationClick"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->DiffCallback Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$Companion$DiffCallback$1;
    check-cast v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/ListAdapter;-><init>(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->onLocationClick Lkotlin/jvm/functions/Function1;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->onAddDeviceClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function0  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public static final synthetic access$getItem(com.bytedance.trae.conversation.devices.CodeDeviceItemAdapter  int)com.bytedance.trae.conversation.devices.DeviceItem
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    return-object v0
.end method

.method public static final synthetic access$getOnAddDeviceClick$p(com.bytedance.trae.conversation.devices.CodeDeviceItemAdapter)kotlin.jvm.functions.Function0
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->onAddDeviceClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public static final synthetic access$getOnLocationClick$p(com.bytedance.trae.conversation.devices.CodeDeviceItemAdapter)kotlin.jvm.functions.Function1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->onLocationClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method private final getHasFooter()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->onAddDeviceClick Lkotlin/jvm/functions/Function0;
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public getItemCount()int
    .registers 3
    # ins_size=1
    invoke-super v2, Landroidx/recyclerview/widget/ListAdapter;->getItemCount()I
    move-result v0
    invoke-direct v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->getHasFooter()Z
    move-result v1
    if-eqz v1, +004h
    add-int/lit8 v0, v0, 1
    return v0
.end method

.method public getItemViewType(int)int
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->getHasFooter()Z
    move-result v0
    if-eqz v0, +00ah
    invoke-super v1, Landroidx/recyclerview/widget/ListAdapter;->getItemCount()I
    move-result v0
    if-ne v2, v0, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method public final getShowProductType()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->showProductType Z
    return v0
.end method

.method public onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v0, v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$DeviceViewHolder;
    if-eqz v0, +012h
    check-cast v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$DeviceViewHolder;
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v3
    const-string v0, "getItem(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/conversation/devices/DeviceItem;
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$DeviceViewHolder;->bind(Lcom/bytedance/trae/conversation/devices/DeviceItem;)V
    return-void 
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 6
    # ins_size=3
    const-string v0, "parent"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    const/4 v1, 1
    const/4 v2, 0
    if-ne v5, v1, +013h
    sget v5, Lcom/bytedance/trae/conversation/R$layout;->trae_item_code_device_add I
    invoke-virtual v0, v5, v4, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$AddDeviceViewHolder;
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v5, v3, v4, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$AddDeviceViewHolder;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter; Landroid/view/View;)V
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    goto +11h
    sget v5, Lcom/bytedance/trae/conversation/R$layout;->trae_item_code_device I
    invoke-virtual v0, v5, v4, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$DeviceViewHolder;
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v5, v3, v4, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$DeviceViewHolder;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter; Landroid/view/View;)V
    check-cast v5, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v5
.end method

.method public final setShowProductType(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->showProductType Z
    return-void 
.end method
