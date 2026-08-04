# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;
.super Landroidx/recyclerview/widget/ListAdapter;
.source "DebugLoginDevicesAdapter.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$Companion;
.field private static final DiffCallback:Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$Companion$DiffCallback$1;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;->Companion Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$Companion;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$Companion$DiffCallback$1;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$Companion$DiffCallback$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;->DiffCallback Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$Companion$DiffCallback$1;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;->DiffCallback Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$Companion$DiffCallback$1;
    check-cast v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/ListAdapter;-><init>(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V
    return-void 
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;->onBindViewHolder(Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.home.solo.setting.DebugLoginDevicesAdapter$DeviceViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v3
    const-string v0, "getItem(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/login/api/LoginDeviceInfo;
    invoke-virtual v2, v3, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;->bind(Lcom/bytedance/trae/login/api/LoginDeviceInfo;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.home.solo.setting.DebugLoginDevicesAdapter$DeviceViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/home/R$layout;->item_debug_login_device I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v3, Lcom/bytedance/trae/home/solo/setting/DebugLoginDevicesAdapter$DeviceViewHolder;-><init>(Landroid/view/View;)V
    return-object v4
.end method
