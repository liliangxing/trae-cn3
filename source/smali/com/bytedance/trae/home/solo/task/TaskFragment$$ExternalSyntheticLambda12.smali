# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda12;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Landroid/widget/PopupWindow$OnDismissListener;

.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;
.field public final synthetic f$1:Landroid/widget/ImageView;


.method public synthetic constructor <init>(com.bytedance.trae.home.solo.task.TaskFragment  android.widget.ImageView)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda12;->f$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda12;->f$1 Landroid/widget/ImageView;
    return-void 
.end method

.method public final onDismiss()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda12;->f$0 Lcom/bytedance/trae/home/solo/task/TaskFragment;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda12;->f$1 Landroid/widget/ImageView;
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->$r8$lambda$1tP9WtNy4i3dGTnVrNYRMe1iGho(Lcom/bytedance/trae/home/solo/task/TaskFragment; Landroid/widget/ImageView;)V
    return-void 
.end method
