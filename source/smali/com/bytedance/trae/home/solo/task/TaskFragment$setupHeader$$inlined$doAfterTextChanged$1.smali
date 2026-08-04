# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskFragment$setupHeader$$inlined$doAfterTextChanged$1;
.super Ljava/lang/Object;
.source "TextView.kt"

.implements Landroid/text/TextWatcher;

.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;


.method public constructor <init>(com.bytedance.trae.home.solo.task.TaskFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$setupHeader$$inlined$doAfterTextChanged$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public afterTextChanged(android.text.Editable)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$setupHeader$$inlined$doAfterTextChanged$1;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$getViewModel$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +009h
    const-string/jumbo v0, viewModel
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    if-eqz v3, +006h
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, ""
    invoke-virtual v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->updateSearchQuery(Ljava/lang/String;)V
    return-void 
.end method

.method public beforeTextChanged(java.lang.CharSequence  int  int  int)void
    .registers 5
    # ins_size=5
    return-void 
.end method

.method public onTextChanged(java.lang.CharSequence  int  int  int)void
    .registers 5
    # ins_size=5
    return-void 
.end method
