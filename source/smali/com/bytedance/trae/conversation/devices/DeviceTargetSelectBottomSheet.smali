# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "DeviceTargetSelectBottomSheet.kt"

.field private static final ARG_AVAILABLE_TARGETS:Ljava/lang/String;
.field private static final ARG_ENTER_FROM:Ljava/lang/String;
.field private static final ARG_HAS_IDE_DEVICE:Ljava/lang/String;
.field private static final ARG_HAS_WORK_DEVICE:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$Companion;
.field private static final STATE_PAGE_EXPOSURE_REPORTED:Ljava/lang/String;
.field private static final STATE_TARGET_CLICK_REPORTED:Ljava/lang/String;
.field public static final TAG:Ljava/lang/String;
.field private onTargetSelected:Lkotlin/jvm/functions/Function1;
.field private pageExposureGate:Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
.field private targetClickGate:Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;


.method public static synthetic $r8$lambda$23VR8gry5Qg5L53sa8nMqbcToEI(com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->onViewCreated$lambda$5$lambda$4(Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$LXIFatIbKC-LLCclYDpJhZnlzwE(int  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->onCreateDialog$lambda$2(I Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$RqDmZDx5wvvV4XnakTnx_1fOlto(com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet  com.bytedance.trae.conversation.devices.DeviceProductType  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->bindTargetItem$lambda$6(Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$fBArkss36U3joyIB-iZIjIoYrfc(com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->onViewCreated$lambda$5$lambda$3(Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->Companion Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 5
    # ins_size=1
    invoke-direct v4, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    const/4 v1, 0
    const/4 v2, 1
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v0, v4, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->pageExposureGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v0, v4, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->targetClickGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    return-void 
.end method

.method private final availableTargets()java.util.List
    .registers 12
    # ins_size=1
    invoke-virtual v11, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +009h
    const-string v2, "arg_available_targets"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;
    move-result-object v0
    goto +2h
    move-object v0, v1
    move-object v2, v0
    check-cast v2, Ljava/util/Collection;
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v3
    goto +2h
    move v2, v4
    if-eqz v2, +009h
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
    invoke-static v0, v3, v4, v1, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->availableTargets$default(Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy; Z I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    return-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +027h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    invoke-static Lcom/bytedance/trae/conversation/devices/DeviceProductType;->values()[Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    move-result-object v6
    array-length v7, v6
    move v8, v3
    if-ge v8, v7, +012h
    aget-object v9, v6, v8
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->name()Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v10
    if-eqz v10, +003h
    goto +5h
    add-int/lit8 v8, v8, 1
    goto -11h
    move-object v9, v1
    if-eqz v9, -025h
    invoke-interface v2, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2ah
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +008h
    sget-object v0, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->INSTANCE Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;
    invoke-static v0, v3, v4, v1, Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy;->availableTargets$default(Lcom/bytedance/trae/conversation/devices/DeviceAddTargetPolicy; Z I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    return-object v2
.end method

.method private final bindOrHideTargetItem(android.view.View  com.bytedance.trae.conversation.devices.DeviceProductType  java.util.Set  int  java.lang.String  java.lang.String)void
    .registers 13
    # ins_size=7
    invoke-interface v9, v8, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +00ch
    const/16 v8, 8
    invoke-virtual v7, v8, Landroid/view/View;->setVisibility(I)V
    const/4 v8, 0
    invoke-virtual v7, v8, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
    const/4 v9, 0
    invoke-virtual v7, v9, Landroid/view/View;->setVisibility(I)V
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    move v3, v10
    move-object v4, v11
    move-object v5, v12
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->bindTargetItem(Landroid/view/View; Lcom/bytedance/trae/conversation/devices/DeviceProductType; I Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final bindTargetItem(android.view.View  com.bytedance.trae.conversation.devices.DeviceProductType  int  java.lang.String  java.lang.String)void
    .registers 7
    # ins_size=6
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_target_icon I
    invoke-virtual v2, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/ImageView;
    invoke-virtual v0, v4, Landroid/widget/ImageView;->setImageResource(I)V
    sget v4, Lcom/bytedance/trae/conversation/R$id;->tv_target_title I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/TextView;
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v4, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v4, Lcom/bytedance/trae/conversation/R$id;->tv_target_subtitle I
    invoke-virtual v2, v4, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/TextView;
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v4, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    new-instance v4, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$$ExternalSyntheticLambda3;
    invoke-direct v4, v1, v3, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V
    invoke-virtual v2, v4, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method private static final bindTargetItem$lambda$6(com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet  com.bytedance.trae.conversation.devices.DeviceProductType  android.view.View)void
    .registers 4
    # ins_size=3
    iget-object v3, v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->targetClickGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->tryConsume()Z
    move-result v3
    if-nez v3, +003h
    return-void 
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-direct v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->trackingEnterFrom()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, v0, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackTargetSelectClick(Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DeviceProductType;)V
    move-object v3, v1
    check-cast v3, Landroidx/fragment/app/Fragment;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v3
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->onTargetSelected Lkotlin/jvm/functions/Function1;
    if-eqz v0, +005h
    invoke-interface v0, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    if-nez v3, +005h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->dismiss()V
    return-void 
.end method

.method private static final onCreateDialog$lambda$2(int  android.content.DialogInterface)void
    .registers 4
    # ins_size=2
    instance-of v0, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    if-eqz v0, +005h
    check-cast v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    goto +2h
    const/4 v3, 0
    if-eqz v3, +02ch
    sget v0, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v3
    if-nez v3, +003h
    goto +22h
    const v0, 17170445
    invoke-virtual v3, v0, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v3, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v1, 3
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setHideable(Z)V
    invoke-virtual v3, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    iput v2, v0, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v3, v0, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private static final onViewCreated$lambda$5$lambda$3(com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    move-object v1, v0
    check-cast v1, Landroidx/fragment/app/Fragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v1
    if-eqz v1, +006h
    invoke-interface v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->onRouteBack()Z
    goto +4h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->dismiss()V
    return-void 
.end method

.method private static final onViewCreated$lambda$5$lambda$4(com.bytedance.trae.conversation.devices.DeviceTargetSelectBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    move-object v1, v0
    check-cast v1, Landroidx/fragment/app/Fragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigatorKt;->deviceFlowNavigator(Landroidx/fragment/app/Fragment;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;
    move-result-object v1
    if-eqz v1, +006h
    invoke-interface v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;->closeCurrentFlow()V
    goto +4h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->dismiss()V
    return-void 
.end method

.method private final trackingEnterFrom()java.lang.String
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +00ah
    const-string v1, "arg_enter_from"
    invoke-virtual v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, "device_list"
    return-object v0
.end method

.method public final getOnTargetSelected()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->onTargetSelected Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public onCreate(android.os.Bundle)void
    .registers 6
    # ins_size=2
    invoke-super v4, v5, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreate(Landroid/os/Bundle;)V
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v5, +00dh
    const-string/jumbo v3, state_page_exposure_reported
    invoke-virtual v5, v3, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v3
    if-ne v3, v1, +004h
    move v3, v1
    goto +2h
    move v3, v2
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z)V
    iput-object v0, v4, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->pageExposureGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    new-instance v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    if-eqz v5, +00ch
    const-string/jumbo v3, state_target_click_reported
    invoke-virtual v5, v3, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v5
    if-ne v5, v1, +003h
    goto +2h
    move v1, v2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;-><init>(Z)V
    iput-object v0, v4, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->targetClickGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    return-void 
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 4
    # ins_size=2
    invoke-super v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v3
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_device_target_select_sheet_height I
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    new-instance v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$$ExternalSyntheticLambda0;-><init>(I)V
    invoke-virtual v3, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v3, Landroid/app/Dialog;
    return-object v3
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->bottom_sheet_device_target_select I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    const-string v3, "inflate(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public onDestroyView()void
    .registers 4
    # ins_size=1
    invoke-super v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onDestroyView()V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-virtual v0, Landroidx/fragment/app/FragmentActivity;->isChangingConfigurations()Z
    move-result v0
    const/4 v2, 1
    if-ne v0, v2, +003h
    move v1, v2
    if-nez v1, +00ch
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->pageExposureGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->reset()V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->targetClickGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->reset()V
    return-void 
.end method

.method public onSaveInstanceState(android.os.Bundle)void
    .registers 4
    # ins_size=2
    const-string v0, "outState"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->pageExposureGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->isConsumed()Z
    move-result v0
    const-string/jumbo v1, state_page_exposure_reported
    invoke-virtual v3, v1, v0, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->targetClickGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->isConsumed()Z
    move-result v0
    const-string/jumbo v1, state_target_click_reported
    invoke-virtual v3, v1, v0, Landroid/os/Bundle;->putBoolean(Ljava/lang/String; Z)V
    invoke-super v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onSaveInstanceState(Landroid/os/Bundle;)V
    return-void 
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 11
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v8, v9, v10, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->availableTargets()Ljava/util/List;
    move-result-object v10
    check-cast v10, Ljava/lang/Iterable;
    invoke-static v10, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v10
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v9, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v1, v8, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnLeftActionClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v1, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$$ExternalSyntheticLambda2;
    invoke-direct v1, v8, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->item_work I
    invoke-virtual v9, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->item_ide I
    invoke-virtual v9, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v9
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->WORK Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->trae_device_target_work_icon I
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_device_add_target_work I
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->getString(I)Ljava/lang/String;
    move-result-object v5
    const-string v7, "getString(...)"
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_device_target_select_work_subtitle I
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v8
    move-object v3, v10
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->bindOrHideTargetItem(Landroid/view/View; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; I Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->IDE Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->trae_device_target_ide_icon I
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_device_add_target_ide I
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->getString(I)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_device_target_select_ide_subtitle I
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v8
    move-object v1, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->bindOrHideTargetItem(Landroid/view/View; Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; I Ljava/lang/String; Ljava/lang/String;)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->pageExposureGate Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;->tryConsume()Z
    move-result v9
    if-eqz v9, +032h
    sget-object v9, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-direct v8, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->trackingEnterFrom()Ljava/lang/String;
    move-result-object v0
    invoke-interface v10, Ljava/util/Set;->size()I
    move-result v10
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v1
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +00ch
    const-string v4, "arg_has_work_device"
    invoke-virtual v1, v4, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v1
    if-ne v1, v2, +004h
    move v1, v2
    goto +2h
    move v1, v3
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v4
    if-eqz v4, +00bh
    const-string v5, "arg_has_ide_device"
    invoke-virtual v4, v5, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z
    move-result v4
    if-ne v4, v2, +003h
    goto +2h
    move v2, v3
    invoke-virtual v9, v0, v10, v1, v2, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->trackTargetSelectShow(Ljava/lang/String; I Z Z)V
    return-void 
.end method

.method public final setOnTargetSelected(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DeviceTargetSelectBottomSheet;->onTargetSelected Lkotlin/jvm/functions/Function1;
    return-void 
.end method
