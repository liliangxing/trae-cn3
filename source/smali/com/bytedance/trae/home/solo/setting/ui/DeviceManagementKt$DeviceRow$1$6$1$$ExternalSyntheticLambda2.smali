# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function2;

.field public final synthetic f$0:F
.field public final synthetic f$1:Landroidx/compose/runtime/MutableFloatState;


.method public synthetic constructor <init>(float  androidx.compose.runtime.MutableFloatState)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1$$ExternalSyntheticLambda2;->f$0 F
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1$$ExternalSyntheticLambda2;->f$1 Landroidx/compose/runtime/MutableFloatState;
    return-void 
.end method

.method public final invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=3
    iget v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1$$ExternalSyntheticLambda2;->f$0 F
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1$$ExternalSyntheticLambda2;->f$1 Landroidx/compose/runtime/MutableFloatState;
    check-cast v3, Landroidx/compose/ui/input/pointer/PointerInputChange;
    check-cast v4, Ljava/lang/Float;
    invoke-virtual v4, Ljava/lang/Float;->floatValue()F
    move-result v4
    invoke-static v0, v1, v3, v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;->$r8$lambda$8CQgxwwhNeVwbP3HZhOHmrJBlJM(F Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/ui/input/pointer/PointerInputChange; F)Lkotlin/Unit;
    move-result-object v3
    return-object v3
.end method
