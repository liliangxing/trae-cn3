# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda8;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
.field public final synthetic f$1:Landroidx/compose/runtime/MutableFloatState;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  androidx.compose.runtime.MutableFloatState)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda8;->f$0 Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda8;->f$1 Landroidx/compose/runtime/MutableFloatState;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda8;->f$0 Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda8;->f$1 Landroidx/compose/runtime/MutableFloatState;
    check-cast v3, Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->$r8$lambda$YpFTc04bKto84cYR_9CR1R2Wml4(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
