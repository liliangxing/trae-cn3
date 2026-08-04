# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "FileTreeBottomSheetFragment.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$Companion;
.field private static pendingDiffFiles:Ljava/util/List;
.field private diffFiles:Ljava/util/List;
.field private onFileClick:Lkotlin/jvm/functions/Function1;


.method public static synthetic $r8$lambda$McXysJ9t41LkY93ujmlE6iRYeAY(com.google.android.material.bottomsheet.BottomSheetDialog  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->onCreateDialog$lambda$0(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$_Tf2rQ1qNTMITI7T1Vr1gbeGkGQ(com.bytedance.trae.conversation.chat.block.renderer.FileTreeBottomSheetFragment  java.lang.String)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->onViewCreated$lambda$2(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$muaxNLvUXUTY0I9xRx2xo0V7lIc(com.bytedance.trae.conversation.chat.block.renderer.FileTreeBottomSheetFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->onViewCreated$lambda$1(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->diffFiles Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$setPendingDiffFiles$cp(java.util.List)void
    .registers 1
    # ins_size=1
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->pendingDiffFiles Ljava/util/List;
    return-void 
.end method

.method private static final onCreateDialog$lambda$0(com.google.android.material.bottomsheet.BottomSheetDialog  android.content.DialogInterface)void
    .registers 2
    # ins_size=2
    sget v1, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v0
    if-eqz v0, +014h
    const v1, 17170445
    invoke-virtual v0, v1, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v0
    const/4 v1, 3
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    return-void 
.end method

.method private static final onViewCreated$lambda$1(com.bytedance.trae.conversation.chat.block.renderer.FileTreeBottomSheetFragment  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->dismiss()V
    return-void 
.end method

.method private static final onViewCreated$lambda$2(com.bytedance.trae.conversation.chat.block.renderer.FileTreeBottomSheetFragment  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "filePath"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->onFileClick Lkotlin/jvm/functions/Function1;
    if-eqz v0, +005h
    invoke-interface v0, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->dismiss()V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public final getOnFileClick()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->onFileClick Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public onCreate(android.os.Bundle)void
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreate(Landroid/os/Bundle;)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->pendingDiffFiles Ljava/util/List;
    if-nez v1, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->diffFiles Ljava/util/List;
    const/4 v1, 0
    sput-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->pendingDiffFiles Ljava/util/List;
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
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$$ExternalSyntheticLambda2;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$$ExternalSyntheticLambda2;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v2, Landroid/app/Dialog;
    return-object v2
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 5
    # ins_size=4
    const-string v4, "inflater"
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget v4, Lcom/bytedance/trae/conversation/R$layout;->trae_fragment_file_tree_bottom_sheet I
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
    sget v3, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$$ExternalSyntheticLambda0;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;)V
    invoke-virtual v3, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    sget v3, Lcom/bytedance/trae/conversation/R$id;->rv_files I
    invoke-virtual v2, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView;
    new-instance v3, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-direct v3, v0, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v3, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v2, v3, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$$ExternalSyntheticLambda1;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;)V
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;-><init>(Lkotlin/jvm/functions/Function1;)V
    move-object v0, v3
    check-cast v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v2, v0, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->diffFiles Ljava/util/List;
    invoke-virtual v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeAdapter;->setDiffFiles(Ljava/util/List;)V
    return-void 
.end method

.method public final setOnFileClick(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/FileTreeBottomSheetFragment;->onFileClick Lkotlin/jvm/functions/Function1;
    return-void 
.end method
