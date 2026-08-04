# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskFragment$onViewCreated$3;
.super Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;
.source "TaskFragment.kt"

.field final synthetic $ivAvatar:Lcom/facebook/drawee/view/SimpleDraweeView;
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;


.method constructor <init>(com.bytedance.trae.home.solo.task.TaskFragment  com.facebook.drawee.view.SimpleDraweeView)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$onViewCreated$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$onViewCreated$3;->$ivAvatar Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-direct v0, Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;-><init>()V
    return-void 
.end method

.method public onFragmentDestroyed(androidx.fragment.app.FragmentManager  androidx.fragment.app.Fragment)void
    .registers 4
    # ins_size=3
    const-string v0, "fm"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "f"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v2, v3, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;
    if-nez v2, +006h
    instance-of v2, v3, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;
    if-eqz v2, +009h
    iget-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$onViewCreated$3;->this$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$onViewCreated$3;->$ivAvatar Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-static v2, v3, Lcom/bytedance/trae/home/solo/task/TaskFragment;->access$loadAvatar(Lcom/bytedance/trae/home/solo/task/TaskFragment; Lcom/facebook/drawee/view/SimpleDraweeView;)V
    return-void 
.end method
