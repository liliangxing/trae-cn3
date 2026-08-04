# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
.super Landroidx/recyclerview/widget/ListAdapter;
.source "SettingsDeviceAdapter.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$Companion;
.field private static final DiffCallback:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$Companion$DiffCallback$1;
.field private final onLongPress:Lkotlin/jvm/functions/Function4;
.field private final onRenameClick:Lkotlin/jvm/functions/Function2;
.field private final onUnbindClick:Lkotlin/jvm/functions/Function2;
.field private final onUnpairedDeviceClick:Lkotlin/jvm/functions/Function1;
.field private final onUnsupportedAction:Lkotlin/jvm/functions/Function0;
.field private openViewHolder:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
.field private showProductType:Z


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->Companion Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->$stable I
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$Companion$DiffCallback$1;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$Companion$DiffCallback$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->DiffCallback Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$Companion$DiffCallback$1;
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function4  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function0)void
    .registers 7
    # ins_size=6
    const-string v0, "onUnpairedDeviceClick"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onLongPress"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onRenameClick"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onUnbindClick"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onUnsupportedAction"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->DiffCallback Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$Companion$DiffCallback$1;
    check-cast v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/ListAdapter;-><init>(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->onUnpairedDeviceClick Lkotlin/jvm/functions/Function1;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->onLongPress Lkotlin/jvm/functions/Function4;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->onRenameClick Lkotlin/jvm/functions/Function2;
    iput-object v5, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->onUnbindClick Lkotlin/jvm/functions/Function2;
    iput-object v6, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->onUnsupportedAction Lkotlin/jvm/functions/Function0;
    const/4 v2, 1
    iput-boolean v2, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->showProductType Z
    return-void 
.end method

.method public static final synthetic access$getOnLongPress$p(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter)kotlin.jvm.functions.Function4
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->onLongPress Lkotlin/jvm/functions/Function4;
    return-object v0
.end method

.method public static final synthetic access$getOnRenameClick$p(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter)kotlin.jvm.functions.Function2
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->onRenameClick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public static final synthetic access$getOnUnbindClick$p(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter)kotlin.jvm.functions.Function2
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->onUnbindClick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public static final synthetic access$getOnUnpairedDeviceClick$p(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter)kotlin.jvm.functions.Function1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->onUnpairedDeviceClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public static final synthetic access$getOnUnsupportedAction$p(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter)kotlin.jvm.functions.Function0
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->onUnsupportedAction Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public static final synthetic access$getOpenViewHolder$p(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter)com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->openViewHolder Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    return-object v0
.end method

.method public static final synthetic access$setOpenViewHolder$p(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->openViewHolder Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    return-void 
.end method

.method public final closeOpenItem()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->openViewHolder Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->animateClose()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->openViewHolder Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    return-void 
.end method

.method public final getShowProductType()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->showProductType Z
    return v0
.end method

.method public final hasOpenItem()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->openViewHolder Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->onBindViewHolder(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v3
    const-string v0, "getItem(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    invoke-virtual v2, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->bind(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/home/R$layout;->item_settings_device I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v2, v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Landroid/view/View;)V
    return-object v4
.end method

.method public final setShowProductType(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->showProductType Z
    return-void 
.end method
