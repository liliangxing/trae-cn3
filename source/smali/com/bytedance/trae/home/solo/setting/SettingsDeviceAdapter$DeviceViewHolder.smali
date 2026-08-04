# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "SettingsDeviceAdapter.kt"

.field private final btnRename:Landroid/view/View;
.field private final btnUnbind:Landroid/view/View;
.field private currentItem:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
.field private final ivIcon:Landroid/widget/ImageView;
.field private final layoutContent:Landroid/view/View;
.field private final layoutSwipeActions:Landroid/view/View;
.field private final llProductType:Landroid/widget/LinearLayout;
.field private final swipeReveal:Lcom/bytedance/trae/common/widget/SwipeRevealController;
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
.field private final tvName:Landroid/widget/TextView;
.field private final tvProductType:Landroid/widget/TextView;
.field private final tvStatus:Landroid/widget/TextView;
.field private final unsupportedActionGestureState:Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;


.method public static synthetic $r8$lambda$1EzJTBjhzEyiAD6TBF0Dplonnvc(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->bind$lambda$4(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$96e9KrXSuSq3rSnlhlT-Z-u3baA(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->enableContentTapToClose$lambda$17(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$D6QEGkL0Wu7ktMGAycQHBzjWoCg(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->swipeReveal$lambda$2(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$OB8GS_BH7bsXkpY299gg4irKQzc(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->bind$lambda$7$lambda$6$lambda$5(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$R6dryfkDMp_gISAETHlDVG5EeH0(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->bind$lambda$11$lambda$10$lambda$9(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$RwfJ-8DJcCtqcCNiJmkBXqqJgB8(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  android.view.View)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->configureActions$lambda$16(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Landroid/view/View;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$_ksXU-WrOiADwuFxr2BfwFQX_I4(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->configureActions$lambda$15(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$dKmXcHXTZ4RjdgJyN2D_tXlVyS0(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->swipeReveal$lambda$0(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$eNAvRpNmeKbCkV3_x7remQSNnmo(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->bind$lambda$7(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$fCeCRtknat20T9W9fmgDxlqZoZc(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->bind$lambda$11(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$jl_LwyG59QEoTsg-6WtgUeeAcq8(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->swipeReveal$lambda$1(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$kcwS1t8UtsN-shdr-2mMufWLLks(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  com.bytedance.trae.common.widget.SwipeRevealController$LongPressTouch)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->configureActions$lambda$14(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  android.view.View)void
    .registers 21
    # ins_size=3
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    move-object/from16 v2, v20
    const-string v3, "itemView"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    invoke-direct v0, v2, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v3, Lcom/bytedance/trae/home/R$id;->layout_content I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    const-string v3, "findViewById(...)"
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v5, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutContent Landroid/view/View;
    sget v4, Lcom/bytedance/trae/home/R$id;->layout_swipe_actions I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-static v6, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutSwipeActions Landroid/view/View;
    sget v4, Lcom/bytedance/trae/home/R$id;->btn_rename I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->btnRename Landroid/view/View;
    sget v4, Lcom/bytedance/trae/home/R$id;->btn_delete I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->btnUnbind Landroid/view/View;
    sget v4, Lcom/bytedance/trae/home/R$id;->tv_device_name I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvName Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/home/R$id;->ll_product_type I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/LinearLayout;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->llProductType Landroid/widget/LinearLayout;
    sget v4, Lcom/bytedance/trae/home/R$id;->tv_product_type I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvProductType Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/home/R$id;->tv_device_status I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvStatus Landroid/widget/TextView;
    sget v4, Lcom/bytedance/trae/home/R$id;->iv_device_icon I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->ivIcon Landroid/widget/ImageView;
    new-instance v3, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual/range v20, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-static v2, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;
    move-result-object v2
    invoke-virtual v2, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I
    move-result v2
    int-to-float v2, v2
    const/high16 v4, 1065353216
    invoke-direct v3, v2, v4, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;-><init>(F F)V
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->unsupportedActionGestureState Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    new-instance v2, Lcom/bytedance/trae/common/widget/SwipeRevealController;
    const/4 v7, 0
    const-wide/16 v8, 0
    const/4 v10, 0
    const/4 v11, 0
    new-instance v12, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda6;
    invoke-direct v12, v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;)V
    const/4 v13, 0
    new-instance v14, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda7;
    invoke-direct v14, v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;)V
    new-instance v15, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda8;
    invoke-direct v15, v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;)V
    const/16 v16, 188
    const/16 v17, 0
    move-object v4, v2
    invoke-direct/range v4 ... v17, Lcom/bytedance/trae/common/widget/SwipeRevealController;-><init>(Landroid/view/View; Landroid/view/View; I J F F Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->swipeReveal Lcom/bytedance/trae/common/widget/SwipeRevealController;
    return-void 
.end method

.method private static final bind$lambda$11(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  android.view.View)void
    .registers 4
    # ins_size=3
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->currentItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    if-eqz v3, +018h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    const/4 v3, 0
    if-eqz v3, +00eh
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->access$getOnUnbindClick$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)Lkotlin/jvm/functions/Function2;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda9;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;)V
    invoke-interface v2, v3, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bind$lambda$11$lambda$10$lambda$9(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->animateClose()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final bind$lambda$4(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  android.view.View)void
    .registers 3
    # ins_size=3
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->currentItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    if-eqz v0, +015h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +009h
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->access$getOnUnpairedDeviceClick$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)Lkotlin/jvm/functions/Function1;
    move-result-object v1
    invoke-interface v1, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bind$lambda$7(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  android.view.View)void
    .registers 4
    # ins_size=3
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->currentItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    if-eqz v3, +018h
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    const/4 v3, 0
    if-eqz v3, +00eh
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->access$getOnRenameClick$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)Lkotlin/jvm/functions/Function2;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;)V
    invoke-interface v2, v3, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final bind$lambda$7$lambda$6$lambda$5(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->animateClose()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final bindProductType(com.bytedance.trae.conversation.devices.DeviceProductType)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->ordinal()I
    move-result v3
    aget v3, v0, v3
    const/4 v0, 1
    if-eq v3, v0, +037h
    const/4 v0, 2
    if-ne v3, v0, +02eh
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvProductType Landroid/widget/TextView;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_device_add_target_ide I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v3, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvProductType Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_product_type_ide I
    invoke-virtual v3, v0, Landroid/widget/TextView;->setBackgroundResource(I)V
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvProductType Landroid/widget/TextView;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_brand_trae_green_900 I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v3, v0, Landroid/widget/TextView;->setTextColor(I)V
    goto +32h
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvProductType Landroid/widget/TextView;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_device_add_target_work I
    invoke-virtual v0, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v3, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvProductType Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_product_type_work I
    invoke-virtual v3, v0, Landroid/widget/TextView;->setBackgroundResource(I)V
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvProductType Landroid/widget/TextView;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_brand_brand_700 I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v3, v0, Landroid/widget/TextView;->setTextColor(I)V
    return-void 
.end method

.method private final configureActions(boolean)void
    .registers 4
    # ins_size=2
    if-eqz v3, +00fh
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->swipeReveal Lcom/bytedance/trae/common/widget/SwipeRevealController;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda10;
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)V
    invoke-virtual v3, v1, Lcom/bytedance/trae/common/widget/SwipeRevealController;->attachToContentWithTouch(Lkotlin/jvm/functions/Function1;)V
    goto +23h
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutSwipeActions Landroid/view/View;
    const/16 v0, 8
    invoke-virtual v3, v0, Landroid/view/View;->setVisibility(I)V
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->unsupportedActionGestureState Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual v3, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->setClosed()V
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutContent Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda11;
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda11;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;)V
    invoke-virtual v3, v0, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutContent Landroid/view/View;
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)V
    invoke-virtual v3, v1, Landroid/view/View;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V
    return-void 
.end method

.method private static final configureActions$lambda$14(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  com.bytedance.trae.common.widget.SwipeRevealController$LongPressTouch)kotlin.Unit
    .registers 5
    # ins_size=3
    const-string/jumbo v0, touch
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->currentItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    if-eqz v0, +025h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +01bh
    invoke-static v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->access$getOnLongPress$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)Lkotlin/jvm/functions/Function4;
    move-result-object v3
    iget-object v2, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutContent Landroid/view/View;
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->getRawX()F
    move-result v1
    invoke-static v1, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v1
    invoke-virtual v4, Lcom/bytedance/trae/common/widget/SwipeRevealController$LongPressTouch;->getRawY()F
    move-result v4
    invoke-static v4, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;
    move-result-object v4
    invoke-interface v3, v0, v2, v1, v4, Lkotlin/jvm/functions/Function4;->invoke(Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final configureActions$lambda$15(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->handleUnsupportedActionTouch(Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method private static final configureActions$lambda$16(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  android.view.View)boolean
    .registers 4
    # ins_size=3
    iget-object v1, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->currentItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    const/4 v3, 1
    const/4 v0, 0
    if-eqz v1, +009h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v1
    if-nez v1, +003h
    move v0, v3
    if-eqz v0, +009h
    invoke-static v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->access$getOnUnsupportedAction$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)Lkotlin/jvm/functions/Function0;
    move-result-object v1
    invoke-interface v1, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return v3
.end method

.method private final disableContentTap()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutContent Landroid/view/View;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutContent Landroid/view/View;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/View;->setClickable(Z)V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutContent Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/View;->setFocusable(Z)V
    return-void 
.end method

.method private final enableContentTapToClose()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutContent Landroid/view/View;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda2;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;)V
    invoke-virtual v0, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final enableContentTapToClose$lambda$17(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->animateClose()V
    return-void 
.end method

.method private final handleUnsupportedActionTouch(android.view.MotionEvent)boolean
    .registers 7
    # ins_size=2
    invoke-virtual v6, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v0
    const/4 v1, 0
    if-eqz v0, +052h
    const/4 v2, 0
    const/4 v3, 1
    if-eq v0, v3, +043h
    const/4 v4, 2
    if-eq v0, v4, +00ch
    const/4 v6, 3
    if-eq v0, v6, +03dh
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->unsupportedActionGestureState Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->isDragging()Z
    move-result v1
    goto +4dh
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->unsupportedActionGestureState Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawX()F
    move-result v4
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawY()F
    move-result v6
    invoke-virtual v0, v4, v6, v2, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->onMove(F F F)Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->getDragStarted()Z
    move-result v0
    if-eqz v0, +01dh
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->currentItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    if-eqz v0, +009h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v0
    if-nez v0, +003h
    move v1, v3
    if-eqz v1, +010h
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutContent Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->cancelLongPress()V
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->access$getOnUnsupportedAction$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)Lkotlin/jvm/functions/Function0;
    move-result-object v0
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$MoveResult;->isDragging()Z
    move-result v1
    goto +19h
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->unsupportedActionGestureState Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual v6, v2, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->onRelease(F)Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$ReleaseResult;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState$ReleaseResult;->getWasDragging()Z
    move-result v1
    goto +eh
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->unsupportedActionGestureState Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawX()F
    move-result v2
    invoke-virtual v6, Landroid/view/MotionEvent;->getRawY()F
    move-result v6
    invoke-virtual v0, v2, v6, Lcom/bytedance/trae/common/widget/SwipeRevealGestureState;->onDown(F F)V
    return v1
.end method

.method private final resetSwipe()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->swipeReveal Lcom/bytedance/trae/common/widget/SwipeRevealController;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/SwipeRevealController;->reset()V
    return-void 
.end method

.method private static final swipeReveal$lambda$0(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder)kotlin.Unit
    .registers 3
    # ins_size=2
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->access$getOpenViewHolder$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    move-result-object v0
    if-eqz v0, +015h
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->access$getOpenViewHolder$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    move-result-object v0
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00bh
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->access$getOpenViewHolder$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    move-result-object v1
    if-eqz v1, +005h
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->animateClose()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final swipeReveal$lambda$1(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->access$setOpenViewHolder$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;)V
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->enableContentTapToClose()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final swipeReveal$lambda$2(com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter  com.bytedance.trae.home.solo.setting.SettingsDeviceAdapter$DeviceViewHolder)kotlin.Unit
    .registers 3
    # ins_size=2
    invoke-static v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->access$getOpenViewHolder$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;
    move-result-object v0
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    const/4 v0, 0
    invoke-static v1, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->access$setOpenViewHolder$p(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;)V
    invoke-direct v2, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->disableContentTap()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final animateClose()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->swipeReveal Lcom/bytedance/trae/common/widget/SwipeRevealController;
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/SwipeRevealController;->animateClose()V
    return-void 
.end method

.method public final bind(com.bytedance.trae.home.solo.setting.SettingsDeviceItem)void
    .registers 7
    # ins_size=2
    const-string v0, "item"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v6, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->currentItem Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvName Landroid/widget/TextView;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getName()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;->getShowProductType()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +00fh
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->llProductType Landroid/widget/LinearLayout;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setVisibility(I)V
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->getProductType()Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v0
    invoke-direct v5, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->bindProductType(Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V
    goto +8h
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->llProductType Landroid/widget/LinearLayout;
    const/16 v2, 8
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvStatus Landroid/widget/TextView;
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabelPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceStatusLabelPolicy;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isOnline()Z
    move-result v3
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v4
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabelPolicy;->resolve(Z Z)Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceStatusLabel;->getTextRes()I
    move-result v2
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(I)V
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->ivIcon Landroid/widget/ImageView;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isOnline()Z
    move-result v2
    if-eqz v2, +005h
    sget v2, Lcom/bytedance/trae/home/R$drawable;->ic_setting_computer_screen I
    goto +3h
    sget v2, Lcom/bytedance/trae/home/R$drawable;->ic_setting_computer_screen_offline I
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v0
    if-nez v0, +01bh
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvStatus Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/home/R$drawable;->bg_setting_device_status_unpaired I
    invoke-virtual v0, v2, Landroid/widget/TextView;->setBackgroundResource(I)V
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvStatus Landroid/widget/TextView;
    iget-object v2, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->itemView Landroid/view/View;
    invoke-virtual v2, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_special_white I
    invoke-static v2, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v0, v2, Landroid/widget/TextView;->setTextColor(I)V
    goto +38h
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isOnline()Z
    move-result v0
    if-eqz v0, +01bh
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvStatus Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/home/R$drawable;->bg_setting_device_status_online I
    invoke-virtual v0, v2, Landroid/widget/TextView;->setBackgroundResource(I)V
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvStatus Landroid/widget/TextView;
    iget-object v2, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->itemView Landroid/view/View;
    invoke-virtual v2, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_white I
    invoke-static v2, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v0, v2, Landroid/widget/TextView;->setTextColor(I)V
    goto +19h
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvStatus Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/home/R$drawable;->bg_setting_device_status_offline I
    invoke-virtual v0, v2, Landroid/widget/TextView;->setBackgroundResource(I)V
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->tvStatus Landroid/widget/TextView;
    iget-object v2, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->itemView Landroid/view/View;
    invoke-virtual v2, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/home/R$color;->trae_setting_device_status_offline_text I
    invoke-static v2, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v0, v2, Landroid/widget/TextView;->setTextColor(I)V
    invoke-direct v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->resetSwipe()V
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v0
    invoke-direct v5, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->configureActions(Z)V
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v0
    const/4 v2, 0
    if-eqz v0, +012h
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutContent Landroid/view/View;
    invoke-virtual v0, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutContent Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/View;->setClickable(Z)V
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutContent Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/View;->setFocusable(Z)V
    goto +dh
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->layoutContent Landroid/view/View;
    iget-object v1, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda3;
    invoke-direct v3, v5, v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)V
    invoke-virtual v0, v3, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceItem;->isPaired()Z
    move-result v6
    if-eqz v6, +01bh
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->btnRename Landroid/view/View;
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda4;
    invoke-direct v1, v5, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)V
    invoke-virtual v6, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->btnUnbind Landroid/view/View;
    iget-object v0, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->this$0 Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda5;
    invoke-direct v1, v5, v0, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder; Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter;)V
    invoke-virtual v6, v1, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +bh
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->btnRename Landroid/view/View;
    invoke-virtual v6, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v6, v5, Lcom/bytedance/trae/home/solo/setting/SettingsDeviceAdapter$DeviceViewHolder;->btnUnbind Landroid/view/View;
    invoke-virtual v6, v2, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
