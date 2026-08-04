# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;
.super Ljava/lang/Object;
.source "DeviceManagement.kt"

.implements Landroidx/compose/ui/input/pointer/PointerInputEventHandler;

.field final synthetic $offsetX$delegate:Landroidx/compose/runtime/MutableFloatState;
.field final synthetic $onSwipeInteractionChanged:Lkotlin/jvm/functions/Function1;
.field final synthetic $openOffset:F


.method public static synthetic $r8$lambda$8CQgxwwhNeVwbP3HZhOHmrJBlJM(float  androidx.compose.runtime.MutableFloatState  androidx.compose.ui.input.pointer.PointerInputChange  float)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;->invoke$lambda$2(F Landroidx/compose/runtime/MutableFloatState; Landroidx/compose/ui/input/pointer/PointerInputChange; F)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$R7k610dZttzrm9OY7rbaEfK-8CY(kotlin.jvm.functions.Function1  androidx.compose.runtime.MutableFloatState)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;->invoke$lambda$1(Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/MutableFloatState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$hwlG_jFxYVP-Y-26XdXkkvtyg2Q(float  kotlin.jvm.functions.Function1  androidx.compose.runtime.MutableFloatState)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;->invoke$lambda$0(F Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/MutableFloatState;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(float  kotlin.jvm.functions.Function1  androidx.compose.runtime.MutableFloatState)void
    .registers 4
    # ins_size=4
    iput v1, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;->$openOffset F
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;->$onSwipeInteractionChanged Lkotlin/jvm/functions/Function1;
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;->$offsetX$delegate Landroidx/compose/runtime/MutableFloatState;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final invoke$lambda$0(float  kotlin.jvm.functions.Function1  androidx.compose.runtime.MutableFloatState)kotlin.Unit
    .registers 5
    # ins_size=3
    invoke-static v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->access$DeviceRow$lambda$41(Landroidx/compose/runtime/MutableFloatState;)F
    move-result v0
    const/high16 v1, 1073741824
    div-float v1, v2, v1
    cmpg-float v0, v0, v1
    const/4 v1, 0
    if-gez v0, +003h
    goto +2h
    move v2, v1
    invoke-static v4, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->access$DeviceRow$lambda$42(Landroidx/compose/runtime/MutableFloatState; F)V
    invoke-static v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->access$DeviceRow$lambda$41(Landroidx/compose/runtime/MutableFloatState;)F
    move-result v2
    cmpg-float v2, v2, v1
    if-gez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v3, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final invoke$lambda$1(kotlin.jvm.functions.Function1  androidx.compose.runtime.MutableFloatState)kotlin.Unit
    .registers 3
    # ins_size=2
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->access$DeviceRow$lambda$41(Landroidx/compose/runtime/MutableFloatState;)F
    move-result v2
    const/4 v0, 0
    cmpg-float v2, v2, v0
    if-gez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v1, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final invoke$lambda$2(float  androidx.compose.runtime.MutableFloatState  androidx.compose.ui.input.pointer.PointerInputChange  float)kotlin.Unit
    .registers 5
    # ins_size=4
    const-string v0, "<unused var>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->access$DeviceRow$lambda$41(Landroidx/compose/runtime/MutableFloatState;)F
    move-result v3
    add-float/2addr v3, v4
    const/4 v4, 0
    invoke-static v3, v1, v4, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v1
    invoke-static v2, v1, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt;->access$DeviceRow$lambda$42(Landroidx/compose/runtime/MutableFloatState; F)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final invoke(androidx.compose.ui.input.pointer.PointerInputScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=3
    const/4 v1, 0
    iget v0, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;->$openOffset F
    iget-object v2, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;->$onSwipeInteractionChanged Lkotlin/jvm/functions/Function1;
    iget-object v3, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;->$offsetX$delegate Landroidx/compose/runtime/MutableFloatState;
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1$$ExternalSyntheticLambda0;
    invoke-direct v4, v0, v2, v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1$$ExternalSyntheticLambda0;-><init>(F Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/MutableFloatState;)V
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;->$onSwipeInteractionChanged Lkotlin/jvm/functions/Function1;
    iget-object v2, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;->$offsetX$delegate Landroidx/compose/runtime/MutableFloatState;
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1$$ExternalSyntheticLambda1;
    invoke-direct v3, v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function1; Landroidx/compose/runtime/MutableFloatState;)V
    iget v0, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;->$openOffset F
    iget-object v2, v8, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1;->$offsetX$delegate Landroidx/compose/runtime/MutableFloatState;
    new-instance v5, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1$$ExternalSyntheticLambda2;
    invoke-direct v5, v0, v2, Lcom/bytedance/trae/home/solo/setting/ui/DeviceManagementKt$DeviceRow$1$6$1$$ExternalSyntheticLambda2;-><init>(F Landroidx/compose/runtime/MutableFloatState;)V
    const/4 v6, 1
    const/4 v7, 0
    move-object v0, v9
    move-object v2, v4
    move-object v4, v5
    move-object v5, v10
    invoke-static/range v0 ... v7, Landroidx/compose/foundation/gestures/DragGestureDetectorKt;->detectHorizontalDragGestures$default(Landroidx/compose/ui/input/pointer/PointerInputScope; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v10
    if-ne v9, v10, +003h
    return-object v9
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method
