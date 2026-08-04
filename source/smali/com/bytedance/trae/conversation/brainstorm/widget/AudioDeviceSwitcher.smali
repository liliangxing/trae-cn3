# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "AudioDeviceSwitcher.kt"

.field private static final ARG_AVAILABLE_DEVICES:Ljava/lang/String;
.field private static final ARG_BLUETOOTH_NAME:Ljava/lang/String;
.field private static final ARG_SELECTED_DEVICE:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$Companion;
.field private availableDevices:Ljava/util/List;
.field private bluetoothDeviceName:Ljava/lang/String;
.field private onDeviceSelected:Lkotlin/jvm/functions/Function1;
.field private selectedDevice:Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;


.method public static synthetic $r8$lambda$RhPuXd0b2ZQ6v71ODFUhIJEFrUA(com.bytedance.trae.conversation.brainstorm.widget.AudioDeviceSwitcher  com.bytedance.trae.conversation.brainstorm.model.AudioDevice  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->addDeviceItem$lambda$6(Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$r3Q0werHflpcn-g90e0VK4Kj_68(com.bytedance.trae.conversation.brainstorm.widget.AudioDeviceSwitcher  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->onViewCreated$lambda$4(Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->Companion Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->Speaker Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->selectedDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    const/4 v0, 2
    new-array v0, v0, [Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->Speaker Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->Earpiece Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    aput-object v2, v0, v1
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->availableDevices Ljava/util/List;
    return-void 
.end method

.method private final addDeviceItem(android.widget.LinearLayout  com.bytedance.trae.conversation.brainstorm.model.AudioDevice  java.lang.String  boolean)void
    .registers 9
    # ins_size=5
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->requireContext()Landroid/content/Context;
    move-result-object v0
    invoke-static v0, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$layout;->trae_item_audio_device I
    move-object v2, v5
    check-cast v2, Landroid/view/ViewGroup;
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v0
    invoke-virtual v5, Landroid/widget/LinearLayout;->getChildCount()I
    move-result v1
    if-lez v1, +01eh
    invoke-virtual v0, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v1
    const-string v2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_device_item_gap I
    invoke-virtual v2, v3, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_checkbox I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_device_name I
    invoke-virtual v0, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v2, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    if-eqz v8, +00dh
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_brainstorm_checkbox_checked I
    invoke-virtual v1, v7, Landroid/widget/ImageView;->setImageResource(I)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_brainstorm_device_item_selected I
    invoke-virtual v0, v7, Landroid/view/View;->setBackgroundResource(I)V
    goto +bh
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_brainstorm_checkbox_unchecked I
    invoke-virtual v1, v7, Landroid/widget/ImageView;->setImageResource(I)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_brainstorm_device_item_normal I
    invoke-virtual v0, v7, Landroid/view/View;->setBackgroundResource(I)V
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$$ExternalSyntheticLambda1;
    invoke-direct v7, v4, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;)V
    invoke-virtual v0, v7, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v5, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    return-void 
.end method

.method private static final addDeviceItem$lambda$6(com.bytedance.trae.conversation.brainstorm.widget.AudioDeviceSwitcher  com.bytedance.trae.conversation.brainstorm.model.AudioDevice  android.view.View)void
    .registers 3
    # ins_size=3
    iget-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->onDeviceSelected Lkotlin/jvm/functions/Function1;
    if-eqz v2, +005h
    invoke-interface v2, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->dismiss()V
    return-void 
.end method

.method private final getDeviceDisplayName(com.bytedance.trae.conversation.brainstorm.model.AudioDevice)java.lang.String
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->ordinal()I
    move-result v3
    aget v3, v0, v3
    const/4 v0, 1
    const-string v1, "getString(...)"
    if-eq v3, v0, +015h
    const/4 v0, 2
    if-ne v3, v0, +00ch
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_device_earpiece I
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +10h
    new-instance v3, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v3, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v3
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_device_speaker I
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method

.method private static final onViewCreated$lambda$4(com.bytedance.trae.conversation.brainstorm.widget.AudioDeviceSwitcher  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->dismiss()V
    return-void 
.end method

.method public final getOnDeviceSelected()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->onDeviceSelected Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public getTheme()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$style;->Trae_BottomSheetDialog I
    return v0
.end method

.method public onCreate(android.os.Bundle)void
    .registers 5
    # ins_size=2
    invoke-super v3, v4, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreate(Landroid/os/Bundle;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->getArguments()Landroid/os/Bundle;
    move-result-object v4
    if-eqz v4, +04fh
    const-string v0, "arg_selected_device"
    invoke-virtual v4, v0, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00bh
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    move-result-object v0
    goto +3h
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->Speaker Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->selectedDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    const-string v0, "arg_available_devices"
    invoke-virtual v4, v0, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;
    move-result-object v0
    if-eqz v0, +02eh
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +017h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;->valueOf(Ljava/lang/String;)Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    if-eqz v2, -015h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v1, Ljava/util/List;
    iput-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->availableDevices Ljava/util/List;
    const-string v0, "arg_bluetooth_name"
    invoke-virtual v4, v0, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    iput-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->bluetoothDeviceName Ljava/lang/String;
    return-void 
    :try_start_0x11
    :try_start_0x3b
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_layout_audio_device_switcher I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onStart()void
    .registers 4
    # ins_size=1
    invoke-super v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onStart()V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->getDialog()Landroid/app/Dialog;
    move-result-object v0
    if-eqz v0, +009h
    sget v1, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v0, v1, Landroid/app/Dialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-eqz v0, +020h
    const/16 v1, 360
    int-to-float v1, v1
    invoke-virtual v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v1, v2
    float-to-int v1, v1
    invoke-static v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v0
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    const/4 v1, 3
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 6
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v3, v4, v5, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v5, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$$ExternalSyntheticLambda0;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;)V
    invoke-virtual v5, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    sget v5, Lcom/bytedance/trae/conversation/R$id;->device_list_container I
    invoke-virtual v4, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/LinearLayout;
    iget-object v5, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->availableDevices Ljava/util/List;
    invoke-interface v5, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +01ah
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->getDeviceDisplayName(Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;)Ljava/lang/String;
    move-result-object v1
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->selectedDevice Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;
    if-ne v0, v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    invoke-direct v3, v4, v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->addDeviceItem(Landroid/widget/LinearLayout; Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice; Ljava/lang/String; Z)V
    goto -1dh
    return-void 
.end method

.method public final setOnDeviceSelected(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AudioDeviceSwitcher;->onDeviceSelected Lkotlin/jvm/functions/Function1;
    return-void 
.end method
