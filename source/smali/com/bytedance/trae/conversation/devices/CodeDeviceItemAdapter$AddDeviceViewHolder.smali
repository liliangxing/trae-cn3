# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$AddDeviceViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "CodeDeviceItemAdapter.kt"

.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;


.method public static synthetic $r8$lambda$DB6-_iTf6SPBFkgxZ9NGDcJEMn8(com.bytedance.trae.conversation.devices.CodeDeviceItemAdapter  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$AddDeviceViewHolder;->_init_$lambda$0(Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.devices.CodeDeviceItemAdapter  android.view.View)void
    .registers 4
    # ins_size=3
    const-string v0, "itemView"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$AddDeviceViewHolder;->this$0 Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;
    invoke-direct v1, v3, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$AddDeviceViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter$AddDeviceViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;)V
    invoke-virtual v3, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final _init_$lambda$0(com.bytedance.trae.conversation.devices.CodeDeviceItemAdapter  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;->access$getOnAddDeviceClick$p(Lcom/bytedance/trae/conversation/devices/CodeDeviceItemAdapter;)Lkotlin/jvm/functions/Function0;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method
