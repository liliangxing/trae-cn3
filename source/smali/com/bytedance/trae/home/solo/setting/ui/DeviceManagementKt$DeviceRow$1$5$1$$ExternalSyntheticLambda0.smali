# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Z
.field public final synthetic f$1:Landroidx/compose/ui/input/pointer/PointerInputScope;
.field public final synthetic f$2:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$3:Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
.field public final synthetic f$4:Landroidx/compose/runtime/MutableFloatState;
.field public final synthetic f$5:Landroidx/compose/runtime/MutableFloatState;


.method public synthetic constructor <init>(boolean  androidx.compose.ui.input.pointer.PointerInputScope  kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  androidx.compose.runtime.MutableFloatState  androidx.compose.runtime.MutableFloatState)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;->f$0 Z
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;->f$1 Landroidx/compose/ui/input/pointer/PointerInputScope;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;->f$2 Lkotlin/jvm/functions/Function1;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;->f$4 Landroidx/compose/runtime/MutableFloatState;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;->f$5 Landroidx/compose/runtime/MutableFloatState;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    iget-boolean v0, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;->f$0 Z
    iget-object v1, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;->f$1 Landroidx/compose/ui/input/pointer/PointerInputScope;
    iget-object v2, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;->f$2 Lkotlin/jvm/functions/Function1;
    iget-object v3, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;->f$3 Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iget-object v4, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;->f$4 Landroidx/compose/runtime/MutableFloatState;
    iget-object v5, v7, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;->f$5 Landroidx/compose/runtime/MutableFloatState;
    move-object v6, v8
    check-cast v6, Landroidx/compose/ui/geometry/Offset;
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1;->$r8$lambda$QUDOAEOHWH6G3gvbj1yJGMR27Wo(Z Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/ui/geometry/Offset;)Lkotlin/Unit;
    move-result-object v8
    return-object v8
.end method
