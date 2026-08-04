# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskAdapter;
.super Landroidx/recyclerview/widget/ListAdapter;
.source "TaskAdapter.kt"

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/home/solo/task/TaskAdapter$Companion;
.field private static final DIFF_CALLBACK:Lcom/bytedance/trae/home/solo/task/TaskAdapter$Companion$DIFF_CALLBACK$1;
.field private final onDeleteClick:Lkotlin/jvm/functions/Function2;
.field private final onItemClick:Lkotlin/jvm/functions/Function2;
.field private final onLongPress:Lkotlin/jvm/functions/Function3;
.field private final onPinClick:Lkotlin/jvm/functions/Function2;
.field private final onRenameClick:Lkotlin/jvm/functions/Function2;
.field private final onSlideOpen:Lkotlin/jvm/functions/Function1;
.field private openViewHolder:Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
.field private showProductType:Z


.method public static synthetic $r8$lambda$-2z39C9SjZcy1PkhCrnnzgoFzhU(com.bytedance.trae.home.solo.task.TaskModel  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->_init_$lambda$5(Lcom/bytedance/trae/home/solo/task/TaskModel; Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$-zHQLwAWfvkp9sTpZGQIw09payU(com.bytedance.trae.home.solo.task.TaskModel  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->_init_$lambda$4(Lcom/bytedance/trae/home/solo/task/TaskModel; Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$LO4-WjoBFipRv2V_sTahTJfq0NU(com.bytedance.trae.home.solo.task.TaskModel  float  float)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->_init_$lambda$2(Lcom/bytedance/trae/home/solo/task/TaskModel; F F)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$QFdkpFckllAHYZykKGzVRgoRNrw(com.bytedance.trae.home.solo.task.TaskModel  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->_init_$lambda$3(Lcom/bytedance/trae/home/solo/task/TaskModel; Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$dKe5eNFIAZ7NCxF1sOF0TkHhy38(com.bytedance.trae.home.solo.task.TaskModel)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->_init_$lambda$1(Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$igJ0sR2QyGeMLXKAYQrqxTjohQg(com.bytedance.trae.home.solo.task.TaskModel  int)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->_init_$lambda$0(Lcom/bytedance/trae/home/solo/task/TaskModel; I)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->Companion Lcom/bytedance/trae/home/solo/task/TaskAdapter$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->$stable I
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$Companion$DIFF_CALLBACK$1;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$Companion$DIFF_CALLBACK$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->DIFF_CALLBACK Lcom/bytedance/trae/home/solo/task/TaskAdapter$Companion$DIFF_CALLBACK$1;
    return-void 
.end method

.method public constructor <init>()void
    .registers 10
    # ins_size=1
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 63
    const/4 v8, 0
    move-object v0, v9
    invoke-direct/range v0 ... v8, Lcom/bytedance/trae/home/solo/task/TaskAdapter;-><init>(Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function3  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function2)void
    .registers 8
    # ins_size=7
    const-string v0, "onItemClick"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onSlideOpen"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onLongPress"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onPinClick"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onRenameClick"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "onDeleteClick"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->DIFF_CALLBACK Lcom/bytedance/trae/home/solo/task/TaskAdapter$Companion$DIFF_CALLBACK$1;
    check-cast v0, Landroidx/recyclerview/widget/DiffUtil$ItemCallback;
    invoke-direct v1, v0, Landroidx/recyclerview/widget/ListAdapter;-><init>(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->onItemClick Lkotlin/jvm/functions/Function2;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->onSlideOpen Lkotlin/jvm/functions/Function1;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->onLongPress Lkotlin/jvm/functions/Function3;
    iput-object v5, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->onPinClick Lkotlin/jvm/functions/Function2;
    iput-object v6, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->onRenameClick Lkotlin/jvm/functions/Function2;
    iput-object v7, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->onDeleteClick Lkotlin/jvm/functions/Function2;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function1  kotlin.jvm.functions.Function3  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function2  kotlin.jvm.functions.Function2  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +007h
    new-instance v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$$ExternalSyntheticLambda0;
    invoke-direct v5, Lcom/bytedance/trae/home/solo/task/TaskAdapter$$ExternalSyntheticLambda0;-><init>()V
    and-int/lit8 v12, v11, 2
    if-eqz v12, +007h
    new-instance v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter$$ExternalSyntheticLambda1;
    invoke-direct v6, Lcom/bytedance/trae/home/solo/task/TaskAdapter$$ExternalSyntheticLambda1;-><init>()V
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +007h
    new-instance v7, Lcom/bytedance/trae/home/solo/task/TaskAdapter$$ExternalSyntheticLambda2;
    invoke-direct v7, Lcom/bytedance/trae/home/solo/task/TaskAdapter$$ExternalSyntheticLambda2;-><init>()V
    move-object v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +007h
    new-instance v8, Lcom/bytedance/trae/home/solo/task/TaskAdapter$$ExternalSyntheticLambda3;
    invoke-direct v8, Lcom/bytedance/trae/home/solo/task/TaskAdapter$$ExternalSyntheticLambda3;-><init>()V
    move-object v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +007h
    new-instance v9, Lcom/bytedance/trae/home/solo/task/TaskAdapter$$ExternalSyntheticLambda4;
    invoke-direct v9, Lcom/bytedance/trae/home/solo/task/TaskAdapter$$ExternalSyntheticLambda4;-><init>()V
    move-object v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +007h
    new-instance v10, Lcom/bytedance/trae/home/solo/task/TaskAdapter$$ExternalSyntheticLambda5;
    invoke-direct v10, Lcom/bytedance/trae/home/solo/task/TaskAdapter$$ExternalSyntheticLambda5;-><init>()V
    move-object v3, v10
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move-object v9, v0
    move-object v10, v1
    move-object v11, v2
    move-object v12, v3
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/home/solo/task/TaskAdapter;-><init>(Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function1; Lkotlin/jvm/functions/Function3; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final _init_$lambda$0(com.bytedance.trae.home.solo.task.TaskModel  int)kotlin.Unit
    .registers 2
    # ins_size=2
    const-string v1, "<unused var>"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final _init_$lambda$1(com.bytedance.trae.home.solo.task.TaskModel)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final _init_$lambda$2(com.bytedance.trae.home.solo.task.TaskModel  float  float)kotlin.Unit
    .registers 3
    # ins_size=3
    const-string v1, "<unused var>"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final _init_$lambda$3(com.bytedance.trae.home.solo.task.TaskModel  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "<unused var>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final _init_$lambda$4(com.bytedance.trae.home.solo.task.TaskModel  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "<unused var>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private static final _init_$lambda$5(com.bytedance.trae.home.solo.task.TaskModel  kotlin.jvm.functions.Function0)kotlin.Unit
    .registers 3
    # ins_size=2
    const-string v0, "<unused var>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method public static final synthetic access$getOnDeleteClick$p(com.bytedance.trae.home.solo.task.TaskAdapter)kotlin.jvm.functions.Function2
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->onDeleteClick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public static final synthetic access$getOnItemClick$p(com.bytedance.trae.home.solo.task.TaskAdapter)kotlin.jvm.functions.Function2
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->onItemClick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public static final synthetic access$getOnLongPress$p(com.bytedance.trae.home.solo.task.TaskAdapter)kotlin.jvm.functions.Function3
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->onLongPress Lkotlin/jvm/functions/Function3;
    return-object v0
.end method

.method public static final synthetic access$getOnPinClick$p(com.bytedance.trae.home.solo.task.TaskAdapter)kotlin.jvm.functions.Function2
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->onPinClick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public static final synthetic access$getOnRenameClick$p(com.bytedance.trae.home.solo.task.TaskAdapter)kotlin.jvm.functions.Function2
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->onRenameClick Lkotlin/jvm/functions/Function2;
    return-object v0
.end method

.method public static final synthetic access$getOnSlideOpen$p(com.bytedance.trae.home.solo.task.TaskAdapter)kotlin.jvm.functions.Function1
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->onSlideOpen Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public static final synthetic access$getOpenViewHolder$p(com.bytedance.trae.home.solo.task.TaskAdapter)com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->openViewHolder Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    return-object v0
.end method

.method public static final synthetic access$setOpenViewHolder$p(com.bytedance.trae.home.solo.task.TaskAdapter  com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->openViewHolder Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    return-void 
.end method

.method public final closeOpenItem()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->openViewHolder Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->animateClose()V
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->openViewHolder Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    return-void 
.end method

.method public final getShowProductType()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->showProductType Z
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->onBindViewHolder(Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder  int)void
    .registers 4
    # ins_size=3
    const-string v0, "holder"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->getItem(I)Ljava/lang/Object;
    move-result-object v3
    const-string v0, "getItem(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v2, v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;->bind(Lcom/bytedance/trae/home/solo/task/TaskModel;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.home.solo.task.TaskAdapter$TaskViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/home/R$layout;->item_task I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskAdapter$TaskViewHolder;-><init>(Lcom/bytedance/trae/home/solo/task/TaskAdapter; Landroid/view/View;)V
    return-object v4
.end method

.method public final setShowProductType(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->showProductType Z
    return-void 
.end method
