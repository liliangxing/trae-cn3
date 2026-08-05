.class public final synthetic Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda27;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

# interfaces
.implements Lkotlin/jvm/functions/Function0;


# instance fields
.field public final synthetic f$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;

.field public final synthetic f$1:Lcom/bytedance/trae/home/solo/task/TaskModel;


# direct methods
.method public synthetic constructor <init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda27;->f$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;

    iput-object p2, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda27;->f$1:Lcom/bytedance/trae/home/solo/task/TaskModel;

    return-void
.end method


# virtual methods
.method public final invoke()Ljava/lang/Object;
    .locals 2

    iget-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda27;->f$0:Lcom/bytedance/trae/home/solo/task/TaskFragment;

    iget-object v1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda27;->f$1:Lcom/bytedance/trae/home/solo/task/TaskModel;

    invoke-static {v0, v1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->extractConversation(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;

    move-result-object v0

    return-object v0
.end method
