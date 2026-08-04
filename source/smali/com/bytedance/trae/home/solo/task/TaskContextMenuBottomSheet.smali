# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "TaskContextMenuBottomSheet.kt"

.field public static final $stable:I
.field private static final ARG_CURRENT_TITLE:Ljava/lang/String;
.field private static final ARG_TASK_ID:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$Companion;
.field public static final TAG:Ljava/lang/String;
.field private currentTitle:Ljava/lang/String;
.field private listener:Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$OnMenuItemClickListener;
.field private taskId:Ljava/lang/String;


.method public static synthetic $r8$lambda$ENFrq971rX04sEpsAP1uYpLeoeo(com.bytedance.trae.home.solo.task.TaskContextMenuBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->onViewCreated$lambda$1(Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$OzGa1Op3l_mO0WaB8jJ_b2N6yLQ(com.bytedance.trae.home.solo.task.TaskContextMenuBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->onViewCreated$lambda$2(Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$vS9u7N3wG7HLkS7T_vOaTJMslXA(com.google.android.material.bottomsheet.BottomSheetDialog  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->onCreateDialog$lambda$4(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->Companion Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->$stable I
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    const-string v0, ""
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->taskId Ljava/lang/String;
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->currentTitle Ljava/lang/String;
    return-void 
.end method

.method private static final onCreateDialog$lambda$4(com.google.android.material.bottomsheet.BottomSheetDialog  android.content.DialogInterface)void
    .registers 3
    # ins_size=2
    sget v2, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/FrameLayout;
    if-eqz v1, +01bh
    new-instance v2, Landroid/graphics/drawable/ColorDrawable;
    const/4 v0, 0
    invoke-direct v2, v0, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v2, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v2, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    check-cast v1, Landroid/view/View;
    invoke-static v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v1
    const/4 v2, 3
    invoke-virtual v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v2, 1
    invoke-virtual v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    return-void 
.end method

.method private static final onViewCreated$lambda$1(com.bytedance.trae.home.solo.task.TaskContextMenuBottomSheet  android.view.View)void
    .registers 4
    # ins_size=2
    iget-object v3, v2, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->listener Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$OnMenuItemClickListener;
    if-eqz v3, +009h
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->taskId Ljava/lang/String;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->currentTitle Ljava/lang/String;
    invoke-interface v3, v0, v1, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$OnMenuItemClickListener;->onRenameClick(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->dismiss()V
    return-void 
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.home.solo.task.TaskContextMenuBottomSheet  android.view.View)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->listener Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$OnMenuItemClickListener;
    if-eqz v2, +007h
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->taskId Ljava/lang/String;
    invoke-interface v2, v0, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$OnMenuItemClickListener;->onDeleteClick(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->dismiss()V
    return-void 
.end method

.method public onCreate(android.os.Bundle)void
    .registers 5
    # ins_size=2
    invoke-super v3, v4, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreate(Landroid/os/Bundle;)V
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v4
    if-eqz v4, +01ch
    const-string v0, "arg_task_id"
    const-string v1, ""
    invoke-virtual v4, v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    const-string v2, "getString(...)"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v3, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->taskId Ljava/lang/String;
    const-string v0, "arg_current_title"
    invoke-virtual v4, v0, v1, Landroid/os/Bundle;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v4, v3, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->currentTitle Ljava/lang/String;
    return-void 
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v2
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$$ExternalSyntheticLambda2;
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$$ExternalSyntheticLambda2;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v2, Landroid/app/Dialog;
    return-object v2
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/home/R$layout;->bottom_sheet_context_menu I
    const/4 v0, 0
    invoke-virtual v2, v4, v3, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    return-object v2
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    sget v3, Lcom/bytedance/trae/home/R$id;->ll_rename I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/LinearLayout;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;)V
    invoke-virtual v3, v0, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v3, Lcom/bytedance/trae/home/R$id;->ll_delete I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/LinearLayout;
    new-instance v3, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v3, v1, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;)V
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public final setOnMenuItemClickListener(com.bytedance.trae.home.solo.task.TaskContextMenuBottomSheet$OnMenuItemClickListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet;->listener Lcom/bytedance/trae/home/solo/task/TaskContextMenuBottomSheet$OnMenuItemClickListener;
    return-void 
.end method
