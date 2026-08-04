# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet$$ExternalSyntheticLambda4;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Landroid/view/View;
.field public final synthetic f$1:Landroid/view/View;


.method public synthetic constructor <init>(android.view.View  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet$$ExternalSyntheticLambda4;->f$0 Landroid/view/View;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet$$ExternalSyntheticLambda4;->f$1 Landroid/view/View;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet$$ExternalSyntheticLambda4;->f$0 Landroid/view/View;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet$$ExternalSyntheticLambda4;->f$1 Landroid/view/View;
    check-cast v3, Ljava/lang/Boolean;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/conversation/devices/DeviceSelectBottomSheet;->$r8$lambda$gpwUrisfwvSO06wrZnUrLXY8fKo(Landroid/view/View; Landroid/view/View; Ljava/lang/Boolean;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
