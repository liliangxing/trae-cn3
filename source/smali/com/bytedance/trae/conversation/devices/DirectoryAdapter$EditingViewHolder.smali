# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "DirectoryAdapter.kt"

.field private final etName:Landroid/widget/EditText;
.field private hasConfirmed:Z
.field private final ivIcon:Landroid/widget/ImageView;
.field private final progressBar:Landroid/widget/ProgressBar;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
.field private final viewIndent:Landroid/view/View;


.method public static synthetic $r8$lambda$8fW9OfY5XnpNIA7mcT40w2jM3T8(com.bytedance.trae.conversation.devices.DirectoryAdapter$EditingViewHolder  com.bytedance.trae.conversation.devices.DirectoryAdapter  com.bytedance.trae.conversation.devices.DirectoryNode  android.view.View  boolean)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->bind$lambda$2(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder; Lcom/bytedance/trae/conversation/devices/DirectoryAdapter; Lcom/bytedance/trae/conversation/devices/DirectoryNode; Landroid/view/View; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$kM78zKItpdPHyFvVFe-f0g2fZA4(com.bytedance.trae.conversation.devices.DirectoryAdapter$EditingViewHolder)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->bind$lambda$0(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$sNPCWoiVnOQK_u7b3b_MqxYOzDQ(com.bytedance.trae.conversation.devices.DirectoryAdapter$EditingViewHolder  com.bytedance.trae.conversation.devices.DirectoryAdapter  com.bytedance.trae.conversation.devices.DirectoryNode  android.widget.TextView  int  android.view.KeyEvent)boolean
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->bind$lambda$1(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder; Lcom/bytedance/trae/conversation/devices/DirectoryAdapter; Lcom/bytedance/trae/conversation/devices/DirectoryNode; Landroid/widget/TextView; I Landroid/view/KeyEvent;)Z
    move-result v0
    return v0
.end method

.method public constructor <init>(com.bytedance.trae.conversation.devices.DirectoryAdapter  android.view.View)void
    .registers 4
    # ins_size=3
    const-string v0, "itemView"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    invoke-direct v1, v3, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v2, Lcom/bytedance/trae/conversation/R$id;->iv_icon_editing I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    const-string v0, "findViewById(...)"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ImageView;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->ivIcon Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->et_folder_name I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/EditText;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->progress_creating I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ProgressBar;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->progressBar Landroid/widget/ProgressBar;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->view_indent_editing I
    invoke-virtual v3, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->viewIndent Landroid/view/View;
    return-void 
.end method

.method private static final bind$lambda$0(com.bytedance.trae.conversation.devices.DirectoryAdapter$EditingViewHolder)void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    invoke-virtual v0, Landroid/widget/EditText;->selectAll()V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "input_method"
    invoke-virtual v0, v1, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    const-string v1, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;
    iget-object v2, v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    check-cast v2, Landroid/view/View;
    const/4 v1, 1
    invoke-virtual v0, v2, v1, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View; I)Z
    return-void 
.end method

.method private static final bind$lambda$1(com.bytedance.trae.conversation.devices.DirectoryAdapter$EditingViewHolder  com.bytedance.trae.conversation.devices.DirectoryAdapter  com.bytedance.trae.conversation.devices.DirectoryNode  android.widget.TextView  int  android.view.KeyEvent)boolean
    .registers 6
    # ins_size=6
    const/4 v3, 2
    if-eq v4, v3, +007h
    const/4 v3, 6
    if-eq v4, v3, +004h
    const/4 v0, 0
    goto +25h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->hasConfirmed Z
    const/4 v4, 1
    if-nez v3, +019h
    iput-boolean v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->hasConfirmed Z
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->access$getOnFolderNameConfirmed$p(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;)Lkotlin/jvm/functions/Function2;
    move-result-object v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v2
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    invoke-virtual v3, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-interface v1, v2, v3, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    check-cast v1, Landroid/view/View;
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->hideKeyboard(Landroid/view/View;)V
    move v0, v4
    return v0
.end method

.method private static final bind$lambda$2(com.bytedance.trae.conversation.devices.DirectoryAdapter$EditingViewHolder  com.bytedance.trae.conversation.devices.DirectoryAdapter  com.bytedance.trae.conversation.devices.DirectoryNode  android.view.View  boolean)void
    .registers 5
    # ins_size=5
    if-nez v4, +041h
    iget-boolean v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->hasConfirmed Z
    if-nez v3, +03dh
    const/4 v3, 1
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->hasConfirmed Z
    iget-object v0, v0, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    invoke-virtual v0, Landroid/widget/EditText;->getText()Landroid/text/Editable;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    move-object v4, v0
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +2h
    const/4 v3, 0
    if-eqz v3, +00eh
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->access$getOnFolderNameCancelled$p(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;)Lkotlin/jvm/functions/Function1;
    move-result-object v0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    goto +ch
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;->access$getOnFolderNameConfirmed$p(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;)Lkotlin/jvm/functions/Function2;
    move-result-object v1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v1, v2, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final hideKeyboard(android.view.View)void
    .registers 4
    # ins_size=2
    invoke-virtual v3, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v0
    const-string v1, "input_method"
    invoke-virtual v0, v1, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    const-string v1, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;
    invoke-virtual v3, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;
    move-result-object v3
    const/4 v1, 0
    invoke-virtual v0, v3, v1, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder; I)Z
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.devices.DirectoryNode)void
    .registers 5
    # ins_size=2
    const-string v0, "node"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    iput-boolean v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->hasConfirmed Z
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v2
    mul-int/lit8 v2, v2, 16
    int-to-float v2, v2
    mul-float/2addr v2, v1
    float-to-int v1, v2
    iget-object v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->viewIndent Landroid/view/View;
    invoke-virtual v2, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v2
    iput v1, v2, Landroid/view/ViewGroup$LayoutParams;->width I
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->viewIndent Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->requestLayout()V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->ivIcon Landroid/widget/ImageView;
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_device_folder I
    invoke-virtual v1, v2, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->isLoading()Z
    move-result v1
    if-eqz v1, +018h
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    invoke-virtual v1, v0, Landroid/widget/EditText;->setEnabled(Z)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getName()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v1, v4, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->progressBar Landroid/widget/ProgressBar;
    invoke-virtual v4, v0, Landroid/widget/ProgressBar;->setVisibility(I)V
    return-void 
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->progressBar Landroid/widget/ProgressBar;
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    const/4 v1, 1
    invoke-virtual v0, v1, Landroid/widget/EditText;->setEnabled(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getName()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    invoke-virtual v0, v1, Landroid/widget/EditText;->setSelectAllOnFocus(Z)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    invoke-virtual v0, Landroid/widget/EditText;->requestFocus()Z
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    new-instance v1, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;)V
    invoke-virtual v0, v1, Landroid/widget/EditText;->post(Ljava/lang/Runnable;)Z
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    new-instance v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v2, v3, v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder; Lcom/bytedance/trae/conversation/devices/DirectoryAdapter; Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    invoke-virtual v0, v2, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->etName Landroid/widget/EditText;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryAdapter;
    new-instance v2, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda2;
    invoke-direct v2, v3, v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryAdapter$EditingViewHolder; Lcom/bytedance/trae/conversation/devices/DirectoryAdapter; Lcom/bytedance/trae/conversation/devices/DirectoryNode;)V
    invoke-virtual v0, v2, Landroid/widget/EditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V
    return-void 
.end method
