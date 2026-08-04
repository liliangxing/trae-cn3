# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1;
.super Ljava/lang/Object;
.source "DeviceManagement.kt"

.implements Landroidx/compose/ui/input/pointer/PointerInputEventHandler;

.field final synthetic $device:Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
.field final synthetic $isSwipeOpen:Z
.field final synthetic $onAction:Lkotlin/jvm/functions/Function1;
.field final synthetic $rowAnchorX$delegate:Landroidx/compose/runtime/MutableFloatState;
.field final synthetic $rowAnchorY$delegate:Landroidx/compose/runtime/MutableFloatState;


.method public static synthetic $r8$lambda$QUDOAEOHWH6G3gvbj1yJGMR27Wo(boolean  androidx.compose.ui.input.pointer.PointerInputScope  kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  androidx.compose.runtime.MutableFloatState  androidx.compose.runtime.MutableFloatState  androidx.compose.ui.geometry.Offset)kotlin.Unit
    .registers 7
    # ins_size=7
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1;->invoke$lambda$0(Z Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/ui/geometry/Offset;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(boolean  kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  androidx.compose.runtime.MutableFloatState  androidx.compose.runtime.MutableFloatState)void
    .registers 6
    # ins_size=6
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1;->$isSwipeOpen Z
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1;->$onAction Lkotlin/jvm/functions/Function1;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1;->$device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1;->$rowAnchorX$delegate Landroidx/compose/runtime/MutableFloatState;
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1;->$rowAnchorY$delegate Landroidx/compose/runtime/MutableFloatState;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final invoke$lambda$0(boolean  androidx.compose.ui.input.pointer.PointerInputScope  kotlin.jvm.functions.Function1  com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  androidx.compose.runtime.MutableFloatState  androidx.compose.runtime.MutableFloatState  androidx.compose.ui.geometry.Offset)kotlin.Unit
    .registers 13
    # ins_size=7
    if-eqz v6, +005h
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
    invoke-static v10, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->access$DeviceRow$lambda$44(Landroidx/compose/runtime/MutableFloatState;)F
    move-result v6
    invoke-interface v7, Landroidx/compose/ui/input/pointer/PointerInputScope;->getSize-YbymL2g()J
    move-result-wide v0
    const/16 v10, 32
    shr-long/2addr v0, v10
    long-to-int v0, v0
    int-to-float v0, v0
    const/high16 v1, 1073741824
    div-float/2addr v0, v1
    sub-float/2addr v6, v0
    invoke-virtual v12, Landroidx/compose/ui/geometry/Offset;->unbox-impl()J
    move-result-wide v2
    shr-long/2addr v2, v10
    long-to-int v10, v2
    invoke-static v10, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v10
    add-float/2addr v6, v10
    invoke-static v11, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->access$DeviceRow$lambda$47(Landroidx/compose/runtime/MutableFloatState;)F
    move-result v10
    invoke-interface v7, Landroidx/compose/ui/input/pointer/PointerInputScope;->getSize-YbymL2g()J
    move-result-wide v2
    const-wide v4, 4294967295
    and-long/2addr v2, v4
    long-to-int v7, v2
    int-to-float v7, v7
    div-float/2addr v7, v1
    sub-float/2addr v10, v7
    invoke-virtual v12, Landroidx/compose/ui/geometry/Offset;->unbox-impl()J
    move-result-wide v11
    and-long/2addr v11, v4
    long-to-int v7, v11
    invoke-static v7, Ljava/lang/Float;->intBitsToFloat(I)F
    move-result v7
    add-float/2addr v10, v7
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;
    sget-object v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;->LongPress Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;
    invoke-direct v7, v9, v11, v6, v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource; F F)V
    invoke-interface v8, v7, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method public final invoke(androidx.compose.ui.input.pointer.PointerInputScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=3
    const/4 v1, 0
    iget-boolean v3, v10, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1;->$isSwipeOpen Z
    iget-object v5, v10, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1;->$onAction Lkotlin/jvm/functions/Function1;
    iget-object v6, v10, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1;->$device Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iget-object v7, v10, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1;->$rowAnchorX$delegate Landroidx/compose/runtime/MutableFloatState;
    iget-object v8, v10, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1;->$rowAnchorY$delegate Landroidx/compose/runtime/MutableFloatState;
    new-instance v9, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;
    move-object v2, v9
    move-object v4, v11
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$5$1$$ExternalSyntheticLambda0;-><init>(Z Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/runtime/MutableFloatState;)V
    const/4 v3, 0
    const/4 v4, 0
    const/16 v6, 13
    const/4 v7, 0
    move-object v0, v11
    move-object v5, v12
    invoke-static/range v0 ... v7, Landroidx/compose/foundation/gestures/TapGestureDetectorKt;->detectTapGestures$default(Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v12
    if-ne v11, v12, +003h
    return-object v11
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method
