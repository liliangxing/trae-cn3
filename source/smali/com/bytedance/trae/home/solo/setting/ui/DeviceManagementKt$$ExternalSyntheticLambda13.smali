# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda13;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Landroidx/compose/runtime/MutableFloatState;
.field public final synthetic f$1:Landroidx/compose/runtime/MutableFloatState;


.method public synthetic constructor <init>(androidx.compose.runtime.MutableFloatState  androidx.compose.runtime.MutableFloatState)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda13;->f$0 Landroidx/compose/runtime/MutableFloatState;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda13;->f$1 Landroidx/compose/runtime/MutableFloatState;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda13;->f$0 Landroidx/compose/runtime/MutableFloatState;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$$ExternalSyntheticLambda13;->f$1 Landroidx/compose/runtime/MutableFloatState;
    check-cast v3, Landroidx/compose/ui/layout/LayoutCoordinates;
    invoke-static v0, v1, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->$r8$lambda$lq8_bSlQDEJWOrxF6L7qU6u2mSA(Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/ui/layout/LayoutCoordinates;)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
