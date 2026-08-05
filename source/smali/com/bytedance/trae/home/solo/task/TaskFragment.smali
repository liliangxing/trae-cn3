.class public final Lcom/bytedance/trae/home/solo/task/TaskFragment;
.super Landroidx/fragment/app/Fragment;
.source "TaskFragment.kt"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bytedance/trae/home/solo/task/TaskFragment$RawTaskContentState;,
        Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;
    }
.end annotation

.annotation system Ldalvik/annotation/SourceDebugExtension;
    value = "SMAP\nTaskFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TaskFragment.kt\ncom/bytedance/trae/home/solo/task/TaskFragment\n+ 2 Extention.kt\ncom/ss/android/ugc/aweme/framework/services/ExtentionKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 TextView.kt\nandroidx/core/widget/TextViewKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,946:1\n11#2:947\n11#2:989\n1788#3,4:948\n1788#3,4:952\n1788#3,4:956\n1761#3,3:982\n1761#3,3:985\n48#4,19:960\n84#4,3:979\n1#5:988\n*S KotlinDebug\n*F\n+ 1 TaskFragment.kt\ncom/bytedance/trae/home/solo/task/TaskFragment\n*L\n100#1:947\n897#1:989\n210#1:948,4\n211#1:952,4\n212#1:956,4\n363#1:982,3\n364#1:985,3\n255#1:960,19\n255#1:979,3\n*E\n"
.end annotation

.annotation runtime Lkotlin/Metadata;
    d1 = {
        "\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\u00020\u0001:\u0002cdB\t\u0008\u0007\u00a2\u0006\u0004\u0008\u0002\u0010\u0003J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0008\u0010 \u001a\u0004\u0018\u00010!2\u0008\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001d2\u0008\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010\'\u001a\u00020(2\u0006\u0010&\u001a\u00020\u001dH\u0002J\u0008\u0010)\u001a\u00020%H\u0016J\u0008\u0010*\u001a\u00020%H\u0016J\u0008\u0010+\u001a\u00020%H\u0016J\u0010\u0010,\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001dH\u0002J \u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020\u001d2\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0014H\u0002J\u0018\u00101\u001a\u00020%2\u0006\u00102\u001a\u0002032\u0006\u00100\u001a\u00020\u0014H\u0002J\u0010\u00104\u001a\u00020%2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00105\u001a\u00020%2\u0006\u00102\u001a\u000203H\u0002J\u0018\u00106\u001a\u00020%2\u0006\u00107\u001a\u00020\u001d2\u0006\u00108\u001a\u000209H\u0002J\u0008\u0010:\u001a\u00020%H\u0002J\u0010\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020\u001dH\u0002J\u0010\u0010=\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001dH\u0002J\u001a\u0010>\u001a\u00020%2\u0008\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010A\u001a\u00020\u0011H\u0002J \u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020FH\u0002J&\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020\u00142\u0006\u0010J\u001a\u00020\u00142\u000c\u0010K\u001a\u0008\u0012\u0004\u0012\u00020%0LH\u0002J\u001e\u0010M\u001a\u00020%2\u0006\u0010I\u001a\u00020\u00142\u000c\u0010K\u001a\u0008\u0012\u0004\u0012\u00020%0LH\u0002J\u0008\u0010O\u001a\u00020%H\u0002J\u0010\u0010P\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020RH\u0002JL\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020U2\u0008\u0010?\u001a\u0004\u0018\u00010@2\u0008\u0010V\u001a\u0004\u0018\u00010\u001d2\u0008\u0010W\u001a\u0004\u0018\u00010\u001d2\u0008\u0010X\u001a\u0004\u0018\u00010\u001d2\u0008\u0010Y\u001a\u0004\u0018\u00010Z2\u0008\u0010[\u001a\u0004\u0018\u00010\u001dH\u0002J\u0008\u0010\\\u001a\u00020%H\u0002J\u0010\u0010]\u001a\u00020%2\u0006\u0010^\u001a\u00020_H\u0002J\u0010\u0010`\u001a\u00020%2\u0006\u0010a\u001a\u00020bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006e"
    }
    d2 = {
        "Lcom/bytedance/trae/home/solo/task/TaskFragment;",
        "Landroidx/fragment/app/Fragment;",
        "<init>",
        "()V",
        "fpsTracer",
        "Lcom/bytedance/apm/trace/fps/FpsTracer;",
        "viewModel",
        "Lcom/bytedance/trae/home/solo/task/TaskViewModel;",
        "adapter",
        "Lcom/bytedance/trae/home/solo/task/TaskAdapter;",
        "swipeRefresh",
        "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;",
        "filterPopup",
        "Landroid/widget/PopupWindow;",
        "actionPopup",
        "Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;",
        "isFilterOpen",
        "",
        "shouldScrollToTop",
        "suppressNextTopChangedScrollTaskId",
        "",
        "isFirstResume",
        "hasSuspendByPeerCrashFixed",
        "isSearchHeaderRendered",
        "operationIconVisibilityBeforeSearch",
        "",
        "defaultTaskListItemAnimator",
        "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;",
        "onCreateView",
        "Landroid/view/View;",
        "inflater",
        "Landroid/view/LayoutInflater;",
        "container",
        "Landroid/view/ViewGroup;",
        "savedInstanceState",
        "Landroid/os/Bundle;",
        "onViewCreated",
        "",
        "view",
        "setupTaskTitleBar",
        "Lcom/bytedance/trae/common/widget/TraeTitleBar;",
        "onResume",
        "onPause",
        "onDestroyView",
        "setupHeader",
        "renderSearchHeader",
        "root",
        "isSearchMode",
        "query",
        "syncSearchInputText",
        "searchInput",
        "Landroid/widget/EditText;",
        "requestSearchInputFocus",
        "hideKeyboard",
        "showFilterPopup",
        "anchor",
        "chevron",
        "Landroid/widget/ImageView;",
        "dismissFilterPopup",
        "setupFilterItems",
        "popupView",
        "setupRecyclerView",
        "setTaskListItemAnimationsSuppressed",
        "recyclerView",
        "Landroidx/recyclerview/widget/RecyclerView;",
        "suppress",
        "showActionPopup",
        "task",
        "Lcom/bytedance/trae/home/solo/task/TaskModel;",
        "rawX",
        "",
        "rawY",
        "showRenameDialog",
        "taskId",
        "currentTitle",
        "closeAction",
        "Lkotlin/Function0;",
        "showDeleteDialog",
        "topTaskId",
        "observeViewModel",
        "titleForFilter",
        "filter",
        "Lcom/bytedance/trae/home/solo/task/FilterOption;",
        "renderTaskContent",
        "state",
        "Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;",
        "emptyStateView",
        "searchLoadingView",
        "searchEmptyView",
        "searchEmptyText",
        "Landroid/widget/TextView;",
        "networkErrorView",
        "observeCustomActivity",
        "loadAvatar",
        "iv",
        "Lcom/facebook/drawee/view/SimpleDraweeView;",
        "fixSuspendByPeerCrash",
        "context",
        "Landroid/content/Context;",
        "RawTaskContentState",
        "TaskContentState",
        "impl_mainlandRelease"
    }
    k = 0x1
    mv = {
        0x2,
        0x0,
        0x0
    }
    xi = 0x30
.end annotation


# static fields
.field public static final $stable:I = 0x8


# instance fields
.field private actionPopup:Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;

.field private adapter:Lcom/bytedance/trae/home/solo/task/TaskAdapter;

.field private defaultTaskListItemAnimator:Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;

.field private filterPopup:Landroid/widget/PopupWindow;

.field private final fpsTracer:Lcom/bytedance/apm/trace/fps/FpsTracer;

.field private hasSuspendByPeerCrashFixed:Z

.field private isFilterOpen:Z

.field private isFirstResume:Z

.field private isSearchHeaderRendered:Z

.field private operationIconVisibilityBeforeSearch:I

.field private shouldScrollToTop:Z

.field private suppressNextTopChangedScrollTaskId:Ljava/lang/String;

.field private swipeRefresh:Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;

.field private topTaskId:Ljava/lang/String;

.field private viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;


# direct methods
.method public static synthetic $r8$lambda$-6-GroGTyFqkNFhHl--LkSiSveg(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupFilterItems$lambda$20(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$0Me2H8UVS0Sm7LYpBEBuVPnMyJA(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/DeviceInfo;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupFilterItems$lambda$22(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/DeviceInfo;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$1tP9WtNy4i3dGTnVrNYRMe1iGho(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/widget/ImageView;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showFilterPopup$lambda$17$lambda$16(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/widget/ImageView;)V

    return-void
.end method

.method public static synthetic $r8$lambda$5K601pHhOC-bxn6SzvMt5iCOgcs(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupHeader$lambda$13(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$5S7W8JNV0jPetmKguIzdZLItyqc(Lkotlin/jvm/functions/Function0;Landroid/content/DialogInterface;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showRenameDialog$lambda$40(Lkotlin/jvm/functions/Function0;Landroid/content/DialogInterface;)V

    return-void
.end method

.method public static synthetic $r8$lambda$6oDt_cu3ZPBz9DLhhNqLalHEnfE(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupFilterItems$lambda$21(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$8homNJbzFXFIUFqDO-6Bhh4HH_s()Lkotlin/Unit;
    .locals 1

    invoke-static {}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showActionPopup$lambda$37$lambda$36$lambda$35()Lkotlin/Unit;

    move-result-object v0

    return-object v0
.end method

.method public static synthetic $r8$lambda$B4fKk7rvJBfI3oda2Vp0MuqSP_0(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView$lambda$31(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$BO0c-hQyX1j8MmMUde7dNYmhNmI(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;FF)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2, p3}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView$lambda$28(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;FF)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$InybVxIk8v0jXNzQJ6PNfQfu0lE(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupHeader$lambda$14(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$JG3SUt8GkiX67wAh8i9pahZYaLc(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView$lambda$30(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$Jbgh7seuglANjVzNdOApL2N-wLw(Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView$lambda$27(Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$Mkepj8_OrjEt_rCX24v5apyGmoQ(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupHeader$lambda$11(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$NAmbT-lz_b1jnAHBK0zDTjDMaFg(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showActionPopup$lambda$37$lambda$34(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$POcVu037s_1kpKqaJyoCw1fZ8fg(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showActionPopup$lambda$37$lambda$36(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$Qupsv8xJW88nDe2hdzEY3wj-jk0(Lcom/bytedance/trae/home/solo/task/TaskFragment;Ljava/lang/String;Ljava/lang/String;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showRenameDialog$lambda$39(Lcom/bytedance/trae/home/solo/task/TaskFragment;Ljava/lang/String;Ljava/lang/String;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$RJKXKAVEnnU9VYP6nNheTTk85T4(Lcom/bytedance/trae/home/solo/task/TaskModel;Lcom/bytedance/trae/home/solo/task/TaskFragment;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showActionPopup$lambda$37$lambda$32(Lcom/bytedance/trae/home/solo/task/TaskModel;Lcom/bytedance/trae/home/solo/task/TaskFragment;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$RTb0jacbAFxQyZRuYM4SRT_bubU(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->onViewCreated$lambda$3(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$RkqCiZTdo_AlKTfMB5kDGa3QyBY(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->onViewCreated$lambda$0(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$TwbtPn8KtPMyp4ST_JnPqqdJmNg(Lcom/bytedance/trae/home/solo/task/TaskFragment;Ljava/lang/String;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showDeleteDialog$lambda$41(Lcom/bytedance/trae/home/solo/task/TaskFragment;Ljava/lang/String;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$UebE9c19xcEGdBjHBdcnmIbNrUY(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;Landroid/widget/ImageView;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1, p2, p3}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupHeader$lambda$10(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;Landroid/widget/ImageView;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$W0D_GAMYir5sftTsiiCO4Qaq6eE(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/widget/EditText;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requestSearchInputFocus$lambda$15(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/widget/EditText;)V

    return-void
.end method

.method public static synthetic $r8$lambda$ZGJXpSCkEr92-OEUap67yfj8d2E(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView$lambda$29(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$ZMHNXDZANnrTyPAwtg4ZA4UdT1k(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    .locals 0

    invoke-static {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView$lambda$24(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    return-void
.end method

.method public static synthetic $r8$lambda$algrCfpJyqkZ2GCgQNEWh_P9V3M(Lkotlin/jvm/functions/Function0;Landroid/content/DialogInterface;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showDeleteDialog$lambda$42(Lkotlin/jvm/functions/Function0;Landroid/content/DialogInterface;)V

    return-void
.end method

.method public static synthetic $r8$lambda$fI5XBjzPIv64ubrZ7kLugtulSCc(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 0

    invoke-static {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->onViewCreated$lambda$5(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V

    return-void
.end method

.method public static synthetic $r8$lambda$o-AUZ-J0rI592irKFqy5FGIfegM(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;I)Lkotlin/Unit;
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView$lambda$26(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;I)Lkotlin/Unit;

    move-result-object p0

    return-object p0
.end method

.method public static synthetic $r8$lambda$ovlNyKSx8671MWRkWgZZ2swHIGU()Lkotlin/Unit;
    .locals 1

    invoke-static {}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showActionPopup$lambda$37$lambda$34$lambda$33()Lkotlin/Unit;

    move-result-object v0

    return-object v0
.end method

.method static constructor <clinit>()V
    .locals 0

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .line 60
    invoke-direct {p0}, Landroidx/fragment/app/Fragment;-><init>()V

    .line 61
    new-instance v0, Lcom/bytedance/apm/trace/fps/FpsTracer;

    const-string/jumbo v1, "task_list"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/bytedance/apm/trace/fps/FpsTracer;-><init>(Ljava/lang/String;Z)V

    iput-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->fpsTracer:Lcom/bytedance/apm/trace/fps/FpsTracer;

    const/4 v0, 0x1

    .line 71
    iput-boolean v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isFirstResume:Z

    const/16 v0, 0x8

    .line 74
    iput v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->operationIconVisibilityBeforeSearch:I

    return-void
.end method

.method public static final synthetic access$getAdapter$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Lcom/bytedance/trae/home/solo/task/TaskAdapter;
    .locals 0

    .line 60
    iget-object p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->adapter:Lcom/bytedance/trae/home/solo/task/TaskAdapter;

    return-object p0
.end method

.method public static final synthetic access$getShouldScrollToTop$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Z
    .locals 0

    .line 60
    iget-boolean p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->shouldScrollToTop:Z

    return p0
.end method

.method public static final synthetic access$getSuppressNextTopChangedScrollTaskId$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Ljava/lang/String;
    .locals 0

    .line 60
    iget-object p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->suppressNextTopChangedScrollTaskId:Ljava/lang/String;

    return-object p0
.end method

.method public static final synthetic access$getSwipeRefresh$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    .locals 0

    .line 60
    iget-object p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->swipeRefresh:Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;

    return-object p0
.end method

.method public static final synthetic access$getTopTaskId$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Ljava/lang/String;
    .locals 0

    .line 60
    iget-object p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->topTaskId:Ljava/lang/String;

    return-object p0
.end method

.method public static final synthetic access$getViewModel$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;)Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    .locals 0

    .line 60
    iget-object p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    return-object p0
.end method

.method public static final synthetic access$loadAvatar(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/facebook/drawee/view/SimpleDraweeView;)V
    .locals 0

    .line 60
    invoke-direct {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->loadAvatar(Lcom/facebook/drawee/view/SimpleDraweeView;)V

    return-void
.end method

.method public static final synthetic access$renderSearchHeader(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;ZLjava/lang/String;)V
    .locals 0

    .line 60
    invoke-direct {p0, p1, p2, p3}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->renderSearchHeader(Landroid/view/View;ZLjava/lang/String;)V

    return-void
.end method

.method public static final synthetic access$renderTaskContent(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/view/View;)V
    .locals 0

    .line 60
    invoke-direct/range {p0 .. p7}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->renderTaskContent(Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/view/View;)V

    return-void
.end method

.method public static final synthetic access$setShouldScrollToTop$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;Z)V
    .locals 0

    .line 60
    iput-boolean p1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->shouldScrollToTop:Z

    return-void
.end method

.method public static final synthetic access$setSuppressNextTopChangedScrollTaskId$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;Ljava/lang/String;)V
    .locals 0

    .line 60
    iput-object p1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->suppressNextTopChangedScrollTaskId:Ljava/lang/String;

    return-void
.end method

.method public static final synthetic access$setTaskListItemAnimationsSuppressed(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroidx/recyclerview/widget/RecyclerView;Z)V
    .locals 0

    .line 60
    invoke-direct {p0, p1, p2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setTaskListItemAnimationsSuppressed(Landroidx/recyclerview/widget/RecyclerView;Z)V

    return-void
.end method

.method public static final synthetic access$setTopTaskId$p(Lcom/bytedance/trae/home/solo/task/TaskFragment;Ljava/lang/String;)V
    .locals 0

    .line 60
    iput-object p1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->topTaskId:Ljava/lang/String;

    return-void
.end method

.method public static final synthetic access$titleForFilter(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/FilterOption;)Ljava/lang/String;
    .locals 0

    .line 60
    invoke-direct {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->titleForFilter(Lcom/bytedance/trae/home/solo/task/FilterOption;)Ljava/lang/String;

    move-result-object p0

    return-object p0
.end method

.method private final dismissFilterPopup()V
    .locals 1

    .line 357
    iget-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->filterPopup:Landroid/widget/PopupWindow;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    :cond_0
    const/4 v0, 0x0

    .line 358
    iput-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->filterPopup:Landroid/widget/PopupWindow;

    return-void
.end method

.method private final fixSuspendByPeerCrash(Landroid/content/Context;)V
    .locals 6

    .line 923
    iget-boolean v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->hasSuspendByPeerCrashFixed:Z

    if-eqz v0, :cond_0

    return-void

    :cond_0
    const/4 v0, 0x1

    .line 926
    iput-boolean v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->hasSuspendByPeerCrashFixed:Z

    .line 928
    invoke-static {p1}, Lcom/ss/android/common/util/ToolUtils;->isMainProcess(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    return-void

    .line 932
    :cond_1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion:Lcom/bytedance/trae/common/apphost/AppHost$Companion;

    invoke-virtual {v0}, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z

    move-result v0

    .line 933
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion:Lcom/bytedance/trae/common/apphost/AppHost$Companion;

    invoke-virtual {v1}, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isTestChannel()Z

    move-result v1

    .line 934
    sget-object v2, Lcom/bytedance/trae/home/solo/task/FixCrashSettingsService;->INSTANCE:Lcom/bytedance/trae/home/solo/task/FixCrashSettingsService;

    invoke-virtual {v2}, Lcom/bytedance/trae/home/solo/task/FixCrashSettingsService;->isFixSuspendByPeerCrashEnable()Z

    move-result v2

    if-nez v0, :cond_2

    if-nez v1, :cond_2

    if-eqz v2, :cond_3

    .line 937
    :cond_2
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE:Lcom/bytedance/trae/utils/logger/FLogger;

    .line 939
    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "runInternal, isDebug: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ", isTestChannel: "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", isFixSuspendByPeerCrashEnable: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "fixSuspendByPeerCrash"

    .line 937
    invoke-virtual {v3, v1, v0}, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    .line 942
    invoke-static {p1, v0}, Lcom/bytedance/sysoptimizer/SuspendByPeerOpt;->start(Landroid/content/Context;Z)I

    :cond_3
    return-void
.end method

.method private final hideKeyboard(Landroid/widget/EditText;)V
    .locals 3

    .line 319
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getContext()Landroid/content/Context;

    move-result-object v0

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    const-string v2, "input_method"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    :cond_0
    move-object v0, v1

    :goto_0
    instance-of v2, v0, Landroid/view/inputmethod/InputMethodManager;

    if-eqz v2, :cond_1

    move-object v1, v0

    check-cast v1, Landroid/view/inputmethod/InputMethodManager;

    :cond_1
    if-eqz v1, :cond_2

    .line 320
    invoke-virtual {p1}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v0

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 321
    :cond_2
    invoke-virtual {p1}, Landroid/widget/EditText;->clearFocus()V

    return-void
.end method

.method private final loadAvatar(Lcom/facebook/drawee/view/SimpleDraweeView;)V
    .locals 2

    .line 897
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;

    .line 989
    invoke-static {}, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;

    move-result-object v0

    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;

    invoke-virtual {v0, v1}, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    .line 897
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;

    if-eqz v0, :cond_0

    invoke-interface {v0}, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/bytedance/trae/login/api/AccountInfo;->getAvatarUrl()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 898
    :goto_0
    move-object v1, v0

    check-cast v1, Ljava/lang/CharSequence;

    if-eqz v1, :cond_2

    invoke-interface {v1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    if-nez v1, :cond_1

    goto :goto_1

    :cond_1
    const/4 v1, 0x0

    goto :goto_2

    :cond_2
    :goto_1
    const/4 v1, 0x1

    :goto_2
    if-nez v1, :cond_3

    .line 899
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V

    goto :goto_3

    .line 901
    :cond_3
    sget v0, Lcom/bytedance/trae/home/R$drawable;->trae_default_avatar:I

    invoke-virtual {p1, v0}, Lcom/facebook/drawee/view/SimpleDraweeView;->setActualImageResource(I)V

    :goto_3
    return-void
.end method

.method private final observeCustomActivity()V
    .locals 9

    .line 862
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1

    sget v1, Lcom/bytedance/trae/home/R$id;->title_bar:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;

    if-nez v0, :cond_0

    goto :goto_0

    .line 863
    :cond_0
    invoke-virtual {v0}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getTaskOperationIconView()Lcom/facebook/drawee/view/SimpleDraweeView;

    move-result-object v1

    .line 864
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object v2

    const-string v3, "getViewLifecycleOwner(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v2}, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;

    move-result-object v2

    move-object v3, v2

    check-cast v3, Lkotlinx/coroutines/CoroutineScope;

    const/4 v4, 0x0

    const/4 v5, 0x0

    new-instance v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1;

    const/4 v6, 0x0

    invoke-direct {v2, p0, v0, v1, v6}, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeCustomActivity$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/common/widget/TraeTitleBar;Lcom/facebook/drawee/view/SimpleDraweeView;Lkotlin/coroutines/Continuation;)V

    move-object v6, v2

    check-cast v6, Lkotlin/jvm/functions/Function2;

    const/4 v7, 0x3

    const/4 v8, 0x0

    invoke-static/range {v3 .. v8}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    :cond_1
    :goto_0
    return-void
.end method

.method private final observeViewModel()V
    .locals 18

    move-object/from16 v9, p0

    .line 651
    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;

    move-result-object v0

    const/4 v10, 0x0

    if-eqz v0, :cond_0

    sget v1, Lcom/bytedance/trae/home/R$id;->layout_empty_state:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    move-object v3, v0

    goto :goto_0

    :cond_0
    move-object v3, v10

    .line 652
    :goto_0
    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_1

    sget v1, Lcom/bytedance/trae/home/R$id;->layout_task_search_loading:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    move-object v4, v0

    goto :goto_1

    :cond_1
    move-object v4, v10

    .line 653
    :goto_1
    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_2

    sget v1, Lcom/bytedance/trae/home/R$id;->layout_task_search_empty_state:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    move-object v5, v0

    goto :goto_2

    :cond_2
    move-object v5, v10

    .line 654
    :goto_2
    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_3

    sget v1, Lcom/bytedance/trae/home/R$id;->tv_task_search_empty_text:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    move-object v6, v0

    goto :goto_3

    :cond_3
    move-object v6, v10

    .line 655
    :goto_3
    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_4

    sget v1, Lcom/bytedance/trae/home/R$id;->rv_tasks:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;

    move-object v2, v0

    goto :goto_4

    :cond_4
    move-object v2, v10

    .line 656
    :goto_4
    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_5

    sget v1, Lcom/bytedance/trae/home/R$id;->layout_network_error:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    move-object v7, v0

    goto :goto_5

    :cond_5
    move-object v7, v10

    .line 658
    :goto_5
    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object v0

    const-string v11, "getViewLifecycleOwner(...)"

    invoke-static {v0, v11}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v0}, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;

    move-result-object v0

    move-object v12, v0

    check-cast v12, Lkotlinx/coroutines/CoroutineScope;

    const/4 v13, 0x0

    const/4 v14, 0x0

    new-instance v15, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;

    const/4 v8, 0x0

    move-object v0, v15

    move-object/from16 v1, p0

    invoke-direct/range {v0 .. v8}, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/view/View;Lkotlin/coroutines/Continuation;)V

    check-cast v15, Lkotlin/jvm/functions/Function2;

    const/16 v16, 0x3

    const/16 v17, 0x0

    invoke-static/range {v12 .. v17}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 757
    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object v0

    invoke-static {v0, v11}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v0}, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Lkotlinx/coroutines/CoroutineScope;

    const/4 v2, 0x0

    const/4 v3, 0x0

    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2;

    invoke-direct {v0, v9, v10}, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$2;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lkotlin/coroutines/Continuation;)V

    move-object v4, v0

    check-cast v4, Lkotlin/jvm/functions/Function2;

    const/4 v5, 0x3

    const/4 v6, 0x0

    invoke-static/range {v1 .. v6}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 768
    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object v0

    invoke-static {v0, v11}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v0}, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Lkotlinx/coroutines/CoroutineScope;

    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$3;

    invoke-direct {v0, v9, v10}, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$3;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lkotlin/coroutines/Continuation;)V

    move-object v4, v0

    check-cast v4, Lkotlin/jvm/functions/Function2;

    invoke-static/range {v1 .. v6}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 775
    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object v0

    invoke-static {v0, v11}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v0}, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Lkotlinx/coroutines/CoroutineScope;

    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$4;

    invoke-direct {v0, v9, v10}, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$4;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lkotlin/coroutines/Continuation;)V

    move-object v4, v0

    check-cast v4, Lkotlin/jvm/functions/Function2;

    invoke-static/range {v1 .. v6}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 782
    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object v0

    invoke-static {v0, v11}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {v0}, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;

    move-result-object v0

    move-object v1, v0

    check-cast v1, Lkotlinx/coroutines/CoroutineScope;

    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5;

    invoke-direct {v0, v9, v10}, Lcom/bytedance/trae/home/solo/task/TaskFragment$observeViewModel$5;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lkotlin/coroutines/Continuation;)V

    move-object v4, v0

    check-cast v4, Lkotlin/jvm/functions/Function2;

    invoke-static/range {v1 .. v6}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 789
    invoke-direct/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->observeCustomActivity()V

    return-void
.end method

.method private static final onViewCreated$lambda$0(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 2

    .line 106
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object p1

    invoke-virtual {p1}, Landroidx/fragment/app/FragmentManager;->isStateSaved()Z

    move-result p1

    if-nez p1, :cond_2

    .line 107
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object p1

    const-string v0, "AccountSettingsBottomSheet"

    invoke-virtual {p1, v0}, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;

    move-result-object p1

    if-nez p1, :cond_2

    .line 108
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object p1

    const-string v1, "CmpAccountSettingsBottomSheet"

    invoke-virtual {p1, v1}, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;

    move-result-object p1

    if-eqz p1, :cond_0

    goto :goto_0

    .line 112
    :cond_0
    sget-object p1, Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;->INSTANCE:Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;

    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/setting/platform/CmpPageSettings;->isSettingsEntryEnabled()Z

    move-result p1

    if-eqz p1, :cond_1

    .line 113
    sget-object p1, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->Companion:Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet$Companion;

    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;

    move-result-object p1

    .line 114
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object p0

    .line 113
    invoke-virtual {p1, p0, v1}, Lcom/bytedance/trae/home/solo/setting/CmpAccountSettingsBottomSheet;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    goto :goto_0

    .line 118
    :cond_1
    sget-object p1, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->Companion:Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$Companion;

    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet$Companion;->newInstance()Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;

    move-result-object p1

    .line 119
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object p0

    .line 118
    invoke-virtual {p1, p0, v0}, Lcom/bytedance/trae/home/solo/setting/AccountSettingsBottomSheet;->show(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V

    :cond_2
    :goto_0
    return-void
.end method

.method private static final onViewCreated$lambda$3(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 0

    .line 164
    iget-object p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez p0, :cond_0

    const-string/jumbo p0, "viewModel"

    invoke-static {p0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p0, 0x0

    :cond_0
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->retry()V

    return-void
.end method

.method private static final onViewCreated$lambda$5(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 2

    .line 168
    new-instance p1, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "com.bytedance.trae.conversation.ConversationActivity"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    invoke-direct {p1, v0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    const-string v0, "extra_enter_from"

    const-string/jumbo v1, "task_list"

    .line 169
    invoke-virtual {p1, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 168
    invoke-virtual {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method private final renderSearchHeader(Landroid/view/View;ZLjava/lang/String;)V
    .locals 7

    .line 269
    sget v0, Lcom/bytedance/trae/home/R$id;->title_bar:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;

    .line 270
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_task_search_header:I

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 271
    sget v2, Lcom/bytedance/trae/home/R$id;->et_task_search:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/EditText;

    .line 272
    sget v3, Lcom/bytedance/trae/home/R$id;->btn_task_search_clear:I

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 273
    sget v4, Lcom/bytedance/trae/home/R$id;->fab_add:I

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const/4 v4, 0x1

    const/16 v5, 0x8

    const/4 v6, 0x0

    if-eqz p2, :cond_4

    .line 276
    iget-boolean p2, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isSearchHeaderRendered:Z

    if-nez p2, :cond_1

    .line 278
    invoke-virtual {v0}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->isTaskOperationIconVisible()Z

    move-result p2

    if-eqz p2, :cond_0

    move p2, v6

    goto :goto_0

    :cond_0
    move p2, v5

    .line 277
    :goto_0
    iput p2, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->operationIconVisibilityBeforeSearch:I

    .line 280
    :cond_1
    iput-boolean v4, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isSearchHeaderRendered:Z

    const/4 p2, 0x4

    .line 281
    invoke-virtual {v0, p2}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setVisibility(I)V

    .line 282
    invoke-virtual {v1, v6}, Landroid/view/View;->setVisibility(I)V

    .line 283
    invoke-virtual {p1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 284
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-direct {p0, v2, p3}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->syncSearchInputText(Landroid/widget/EditText;Ljava/lang/String;)V

    .line 285
    check-cast p3, Ljava/lang/CharSequence;

    invoke-interface {p3}, Ljava/lang/CharSequence;->length()I

    move-result p1

    if-lez p1, :cond_2

    goto :goto_1

    :cond_2
    move v4, v6

    :goto_1
    if-eqz v4, :cond_3

    move v5, v6

    :cond_3
    invoke-virtual {v3, v5}, Landroid/view/View;->setVisibility(I)V

    .line 286
    invoke-direct {p0, v2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requestSearchInputFocus(Landroid/widget/EditText;)V

    goto :goto_3

    .line 288
    :cond_4
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    const-string p2, ""

    invoke-direct {p0, v2, p2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->syncSearchInputText(Landroid/widget/EditText;Ljava/lang/String;)V

    .line 289
    invoke-virtual {v3, v5}, Landroid/view/View;->setVisibility(I)V

    .line 290
    invoke-virtual {v1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 291
    invoke-virtual {v0, v6}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setVisibility(I)V

    .line 292
    iget-boolean p2, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isSearchHeaderRendered:Z

    if-eqz p2, :cond_6

    .line 293
    iget p2, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->operationIconVisibilityBeforeSearch:I

    if-nez p2, :cond_5

    goto :goto_2

    :cond_5
    move v4, v6

    :goto_2
    invoke-virtual {v0, v4}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskOperationIconVisible(Z)V

    .line 295
    :cond_6
    invoke-virtual {p1, v6}, Landroid/view/View;->setVisibility(I)V

    .line 296
    iput-boolean v6, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isSearchHeaderRendered:Z

    .line 297
    invoke-direct {p0, v2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->hideKeyboard(Landroid/widget/EditText;)V

    :goto_3
    return-void
.end method

.method private final renderTaskContent(Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;Landroidx/recyclerview/widget/RecyclerView;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/widget/TextView;Landroid/view/View;)V
    .locals 16

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    move-object/from16 v2, p3

    move-object/from16 v3, p4

    move-object/from16 v4, p5

    move-object/from16 v5, p6

    move-object/from16 v6, p7

    .line 809
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getQuery()Ljava/lang/String;

    move-result-object v7

    check-cast v7, Ljava/lang/CharSequence;

    invoke-static {v7}, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    .line 810
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchMode()Z

    move-result v8

    const/4 v9, 0x1

    const/4 v10, 0x0

    if-eqz v8, :cond_1

    move-object v8, v7

    check-cast v8, Ljava/lang/CharSequence;

    invoke-interface {v8}, Ljava/lang/CharSequence;->length()I

    move-result v8

    if-lez v8, :cond_0

    move v8, v9

    goto :goto_0

    :cond_0
    move v8, v10

    :goto_0
    if-eqz v8, :cond_1

    move v8, v9

    goto :goto_1

    :cond_1
    move v8, v10

    .line 812
    :goto_1
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getHasError()Z

    move-result v11

    const/16 v12, 0x8

    if-eqz v11, :cond_8

    if-nez v8, :cond_8

    if-eqz v6, :cond_2

    .line 813
    invoke-virtual {v6, v10}, Landroid/view/View;->setVisibility(I)V

    :cond_2
    if-eqz v1, :cond_3

    .line 814
    invoke-virtual {v1, v12}, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V

    :cond_3
    if-eqz v2, :cond_4

    .line 815
    invoke-virtual {v2, v12}, Landroid/view/View;->setVisibility(I)V

    :cond_4
    if-eqz v3, :cond_5

    .line 816
    invoke-virtual {v3, v12}, Landroid/view/View;->setVisibility(I)V

    :cond_5
    if-eqz v4, :cond_6

    .line 817
    invoke-virtual {v4, v12}, Landroid/view/View;->setVisibility(I)V

    .line 818
    :cond_6
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->swipeRefresh:Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;

    if-eqz v1, :cond_7

    invoke-virtual {v1, v12}, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;->setVisibility(I)V

    :cond_7
    return-void

    :cond_8
    if-eqz v6, :cond_9

    .line 822
    invoke-virtual {v6, v12}, Landroid/view/View;->setVisibility(I)V

    .line 824
    :cond_9
    sget-object v6, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->INSTANCE:Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;

    .line 825
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchMode()Z

    move-result v11

    .line 826
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getQuery()Ljava/lang/String;

    move-result-object v13

    .line 827
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->isSearchLoading()Z

    move-result v14

    .line 828
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getSearchResults()Ljava/util/List;

    move-result-object v15

    .line 824
    invoke-virtual {v6, v11, v13, v14, v15}, Lcom/bytedance/trae/home/solo/task/TaskSearchContentResolver;->isSearchPending(ZLjava/lang/String;ZLjava/util/List;)Z

    move-result v6

    if-eqz v6, :cond_f

    .line 831
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->swipeRefresh:Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;

    if-eqz v5, :cond_a

    invoke-virtual {v5, v12}, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;->setVisibility(I)V

    :cond_a
    if-eqz v1, :cond_b

    .line 832
    invoke-virtual {v1, v12}, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V

    :cond_b
    if-eqz v2, :cond_c

    .line 833
    invoke-virtual {v2, v12}, Landroid/view/View;->setVisibility(I)V

    :cond_c
    if-eqz v4, :cond_d

    .line 834
    invoke-virtual {v4, v12}, Landroid/view/View;->setVisibility(I)V

    :cond_d
    if-eqz v3, :cond_e

    .line 835
    invoke-virtual {v3, v10}, Landroid/view/View;->setVisibility(I)V

    :cond_e
    return-void

    :cond_f
    if-eqz v3, :cond_10

    .line 839
    invoke-virtual {v3, v12}, Landroid/view/View;->setVisibility(I)V

    :cond_10
    if-eqz v8, :cond_16

    .line 841
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getTasks()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_16

    .line 842
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->swipeRefresh:Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;

    if-eqz v3, :cond_11

    invoke-virtual {v3, v12}, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;->setVisibility(I)V

    :cond_11
    if-eqz v1, :cond_12

    .line 843
    invoke-virtual {v1, v12}, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V

    :cond_12
    if-eqz v2, :cond_13

    .line 844
    invoke-virtual {v2, v12}, Landroid/view/View;->setVisibility(I)V

    :cond_13
    if-eqz v5, :cond_14

    .line 845
    sget v1, Lcom/bytedance/trae/home/R$string;->solo_task_search_empty_format:I

    new-array v2, v9, [Ljava/lang/Object;

    aput-object v7, v2, v10

    invoke-virtual {v0, v1, v2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    :cond_14
    if-eqz v4, :cond_15

    .line 846
    invoke-virtual {v4, v10}, Landroid/view/View;->setVisibility(I)V

    :cond_15
    return-void

    :cond_16
    if-eqz v4, :cond_17

    .line 850
    invoke-virtual {v4, v12}, Landroid/view/View;->setVisibility(I)V

    .line 851
    :cond_17
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->swipeRefresh:Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;

    if-eqz v3, :cond_18

    invoke-virtual {v3, v10}, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;->setVisibility(I)V

    .line 852
    :cond_18
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$TaskContentState;->getTasks()Ljava/util/List;

    move-result-object v3

    check-cast v3, Ljava/util/Collection;

    invoke-interface {v3}, Ljava/util/Collection;->isEmpty()Z

    move-result v3

    xor-int/2addr v3, v9

    if-eqz v3, :cond_1a

    if-eqz v1, :cond_19

    .line 853
    invoke-virtual {v1, v10}, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V

    :cond_19
    if-eqz v2, :cond_1c

    .line 854
    invoke-virtual {v2, v12}, Landroid/view/View;->setVisibility(I)V

    goto :goto_2

    :cond_1a
    if-eqz v1, :cond_1b

    .line 856
    invoke-virtual {v1, v12}, Landroidx/recyclerview/widget/RecyclerView;->setVisibility(I)V

    :cond_1b
    if-eqz v2, :cond_1c

    .line 857
    invoke-virtual {v2, v10}, Landroid/view/View;->setVisibility(I)V

    :cond_1c
    :goto_2
    return-void
.end method

.method private final requestSearchInputFocus(Landroid/widget/EditText;)V
    .locals 1

    .line 309
    invoke-virtual {p1}, Landroid/widget/EditText;->hasFocus()Z

    move-result v0

    if-eqz v0, :cond_0

    return-void

    .line 310
    :cond_0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda20;

    invoke-direct {v0, p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda20;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/widget/EditText;)V

    invoke-virtual {p1, v0}, Landroid/widget/EditText;->post(Ljava/lang/Runnable;)Z

    return-void
.end method

.method private static final requestSearchInputFocus$lambda$15(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/widget/EditText;)V
    .locals 2

    .line 311
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    const-string/jumbo v0, "viewModel"

    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_0
    invoke-virtual {v0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isSearchMode()Lkotlinx/coroutines/flow/StateFlow;

    move-result-object v0

    invoke-interface {v0}, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_1

    goto :goto_0

    .line 312
    :cond_1
    invoke-virtual {p1}, Landroid/widget/EditText;->requestFocus()Z

    .line 313
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;

    move-result-object p0

    const-string v0, "input_method"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object p0

    instance-of v0, p0, Landroid/view/inputmethod/InputMethodManager;

    if-eqz v0, :cond_2

    move-object v1, p0

    check-cast v1, Landroid/view/inputmethod/InputMethodManager;

    :cond_2
    if-eqz v1, :cond_3

    .line 314
    check-cast p1, Landroid/view/View;

    const/4 p0, 0x1

    invoke-virtual {v1, p1, p0}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    :cond_3
    :goto_0
    return-void
.end method

.method private final setTaskListItemAnimationsSuppressed(Landroidx/recyclerview/widget/RecyclerView;Z)V
    .locals 0

    if-nez p1, :cond_0

    return-void

    :cond_0
    if-eqz p2, :cond_2

    .line 550
    invoke-virtual {p1}, Landroidx/recyclerview/widget/RecyclerView;->getItemAnimator()Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;

    move-result-object p2

    if-eqz p2, :cond_1

    invoke-virtual {p2}, Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;->endAnimations()V

    :cond_1
    const/4 p2, 0x0

    .line 551
    invoke-virtual {p1, p2}, Landroidx/recyclerview/widget/RecyclerView;->setItemAnimator(Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;)V

    goto :goto_0

    .line 552
    :cond_2
    invoke-virtual {p1}, Landroidx/recyclerview/widget/RecyclerView;->getItemAnimator()Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;

    move-result-object p2

    if-nez p2, :cond_3

    .line 553
    iget-object p2, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->defaultTaskListItemAnimator:Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;

    invoke-virtual {p1, p2}, Landroidx/recyclerview/widget/RecyclerView;->setItemAnimator(Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;)V

    :cond_3
    :goto_0
    return-void
.end method

.method private final setupFilterItems(Landroid/view/View;)V
    .locals 13

    .line 362
    iget-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    const/4 v1, 0x0

    const-string/jumbo v2, "viewModel"

    if-nez v0, :cond_0

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_0
    invoke-virtual {v0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->getDevices()Lkotlinx/coroutines/flow/StateFlow;

    move-result-object v0

    invoke-interface {v0}, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 363
    move-object v3, v0

    check-cast v3, Ljava/lang/Iterable;

    .line 982
    instance-of v4, v3, Ljava/util/Collection;

    const/4 v5, 0x1

    const/4 v6, 0x0

    if-eqz v4, :cond_2

    move-object v7, v3

    check-cast v7, Ljava/util/Collection;

    invoke-interface {v7}, Ljava/util/Collection;->isEmpty()Z

    move-result v7

    if-eqz v7, :cond_2

    :cond_1
    move v7, v6

    goto :goto_0

    .line 983
    :cond_2
    invoke-interface {v3}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_3
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/bytedance/trae/home/solo/task/DeviceInfo;

    .line 363
    invoke-virtual {v8}, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getType()Ljava/lang/String;

    move-result-object v8

    sget-object v9, Lcom/bytedance/trae/im/service/CliType;->LOCAL:Lcom/bytedance/trae/im/service/CliType;

    invoke-virtual {v9}, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_3

    move v7, v5

    :goto_0
    if-eqz v4, :cond_5

    .line 985
    move-object v4, v3

    check-cast v4, Ljava/util/Collection;

    invoke-interface {v4}, Ljava/util/Collection;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_5

    :cond_4
    move v3, v6

    goto :goto_1

    .line 986
    :cond_5
    invoke-interface {v3}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_6
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/bytedance/trae/home/solo/task/DeviceInfo;

    .line 364
    invoke-virtual {v4}, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getType()Ljava/lang/String;

    move-result-object v4

    sget-object v8, Lcom/bytedance/trae/im/service/CliType;->IDE:Lcom/bytedance/trae/im/service/CliType;

    invoke-virtual {v8}, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;

    move-result-object v8

    invoke-static {v4, v8}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6

    move v3, v5

    :goto_1
    if-eqz v7, :cond_7

    if-eqz v3, :cond_7

    goto :goto_2

    :cond_7
    move v5, v6

    .line 367
    :goto_2
    iget-object v3, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez v3, :cond_8

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_3

    :cond_8
    move-object v1, v3

    :goto_3
    invoke-virtual {v1}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->getSelectedFilter()Lkotlinx/coroutines/flow/StateFlow;

    move-result-object v1

    invoke-interface {v1}, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bytedance/trae/home/solo/task/FilterOption;

    .line 368
    sget v2, Lcom/bytedance/trae/home/R$id;->ll_device_container:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 371
    sget v3, Lcom/bytedance/trae/home/R$id;->iv_check_all:I

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 373
    instance-of v4, v1, Lcom/bytedance/trae/home/solo/task/FilterOption$All;

    const/16 v7, 0x8

    if-eqz v4, :cond_9

    move v4, v6

    goto :goto_4

    :cond_9
    move v4, v7

    .line 372
    :goto_4
    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    if-eqz v5, :cond_a

    const/16 v3, 0xc

    int-to-float v3, v3

    .line 375
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v4

    iget v4, v4, Landroid/util/DisplayMetrics;->density:F

    goto :goto_5

    :cond_a
    int-to-float v3, v7

    .line 377
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v4

    iget v4, v4, Landroid/util/DisplayMetrics;->density:F

    :goto_5
    mul-float/2addr v3, v4

    float-to-int v3, v3

    .line 379
    sget v4, Lcom/bytedance/trae/home/R$id;->iv_check_cloud:I

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 381
    instance-of v8, v1, Lcom/bytedance/trae/home/solo/task/FilterOption$Cloud;

    if-eqz v8, :cond_b

    move v8, v6

    goto :goto_6

    :cond_b
    move v8, v7

    .line 380
    :goto_6
    invoke-virtual {v4, v8}, Landroid/view/View;->setVisibility(I)V

    .line 383
    sget v4, Lcom/bytedance/trae/home/R$id;->item_cloud:I

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 385
    invoke-virtual {v4}, Landroid/view/View;->getPaddingLeft()I

    move-result v8

    invoke-virtual {v4}, Landroid/view/View;->getPaddingRight()I

    move-result v9

    invoke-virtual {v4, v8, v3, v9, v3}, Landroid/view/View;->setPadding(IIII)V

    .line 387
    sget v4, Lcom/bytedance/trae/home/R$id;->item_all:I

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    new-instance v8, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda5;

    invoke-direct {v8, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    invoke-virtual {v4, v8}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 393
    sget v4, Lcom/bytedance/trae/home/R$id;->item_all:I

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 395
    invoke-virtual {v4}, Landroid/view/View;->getPaddingLeft()I

    move-result v8

    invoke-virtual {v4}, Landroid/view/View;->getPaddingRight()I

    move-result v9

    invoke-virtual {v4, v8, v3, v9, v3}, Landroid/view/View;->setPadding(IIII)V

    .line 398
    sget v3, Lcom/bytedance/trae/home/R$id;->item_cloud:I

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    new-instance v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda6;

    invoke-direct {v3, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    invoke-virtual {p1, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 406
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;

    move-result-object p1

    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object p1

    .line 407
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_7
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_11

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/bytedance/trae/home/solo/task/DeviceInfo;

    .line 408
    sget v4, Lcom/bytedance/trae/home/R$layout;->item_filter_device:I

    move-object v8, v2

    check-cast v8, Landroid/view/ViewGroup;

    invoke-virtual {p1, v4, v8, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .line 409
    sget v8, Lcom/bytedance/trae/home/R$id;->tv_device_name:I

    invoke-virtual {v4, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 410
    sget v9, Lcom/bytedance/trae/home/R$id;->iv_device_icon:I

    invoke-virtual {v4, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/ImageView;

    .line 411
    sget v10, Lcom/bytedance/trae/home/R$id;->iv_check_device:I

    invoke-virtual {v4, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    .line 413
    invoke-virtual {v3}, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getName()Ljava/lang/String;

    move-result-object v11

    check-cast v11, Ljava/lang/CharSequence;

    invoke-virtual {v8, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 414
    invoke-virtual {v3}, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->isOnline()Z

    move-result v8

    if-nez v8, :cond_c

    .line 415
    sget v8, Lcom/bytedance/trae/home/R$drawable;->ic_solo_filter_computer_off:I

    invoke-virtual {v9, v8}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 419
    :cond_c
    sget v8, Lcom/bytedance/trae/home/R$id;->ll_product_tag:I

    invoke-virtual {v4, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    .line 420
    sget v9, Lcom/bytedance/trae/home/R$id;->tv_product_type:I

    invoke-virtual {v4, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    if-nez v5, :cond_d

    .line 422
    invoke-virtual {v8, v7}, Landroid/view/View;->setVisibility(I)V

    goto :goto_8

    .line 423
    :cond_d
    invoke-virtual {v3}, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getType()Ljava/lang/String;

    move-result-object v11

    sget-object v12, Lcom/bytedance/trae/im/service/CliType;->LOCAL:Lcom/bytedance/trae/im/service/CliType;

    invoke-virtual {v12}, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_e

    .line 424
    invoke-virtual {v8, v6}, Landroid/view/View;->setVisibility(I)V

    .line 425
    sget v11, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_trae_work:I

    invoke-virtual {v8, v11}, Landroid/view/View;->setBackgroundResource(I)V

    const-string v8, "TRAE Work"

    .line 426
    check-cast v8, Ljava/lang/CharSequence;

    invoke-virtual {v9, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 429
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;

    move-result-object v8

    .line 430
    sget v11, Lcom/bytedance/trae/home/R$color;->solo_filter_tag_trae_work:I

    .line 428
    invoke-static {v8, v11}, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context;I)I

    move-result v8

    .line 427
    invoke-virtual {v9, v8}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_8

    .line 433
    :cond_e
    invoke-virtual {v3}, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getType()Ljava/lang/String;

    move-result-object v11

    sget-object v12, Lcom/bytedance/trae/im/service/CliType;->IDE:Lcom/bytedance/trae/im/service/CliType;

    invoke-virtual {v12}, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_f

    .line 434
    invoke-virtual {v8, v6}, Landroid/view/View;->setVisibility(I)V

    .line 435
    sget v11, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_trae_ide:I

    invoke-virtual {v8, v11}, Landroid/view/View;->setBackgroundResource(I)V

    const-string v8, "TRAE IDE"

    .line 436
    check-cast v8, Ljava/lang/CharSequence;

    invoke-virtual {v9, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 439
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;

    move-result-object v8

    .line 440
    sget v11, Lcom/bytedance/trae/home/R$color;->solo_filter_tag_trae_ide:I

    .line 438
    invoke-static {v8, v11}, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context;I)I

    move-result v8

    .line 437
    invoke-virtual {v9, v8}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_8

    .line 445
    :cond_f
    invoke-virtual {v8, v7}, Landroid/view/View;->setVisibility(I)V

    .line 449
    :goto_8
    instance-of v8, v1, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;

    if-eqz v8, :cond_10

    move-object v8, v1

    check-cast v8, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;

    invoke-virtual {v8}, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;->getCliId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3}, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getCliId()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_10

    move v8, v6

    goto :goto_9

    :cond_10
    move v8, v7

    .line 448
    :goto_9
    invoke-virtual {v10, v8}, Landroid/view/View;->setVisibility(I)V

    .line 451
    sget v8, Lcom/bytedance/trae/home/R$id;->item_device:I

    invoke-virtual {v4, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    new-instance v9, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda7;

    invoke-direct {v9, p0, v3}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda7;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/DeviceInfo;)V

    invoke-virtual {v8, v9}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 457
    invoke-virtual {v2, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto/16 :goto_7

    .line 459
    :cond_11
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;

    move-result-object p1

    if-eqz p1, :cond_12

    sget v0, Lcom/bytedance/trae/home/R$id;->iv_avatar:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Lcom/facebook/drawee/view/SimpleDraweeView;

    if-eqz p1, :cond_12

    invoke-direct {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->loadAvatar(Lcom/facebook/drawee/view/SimpleDraweeView;)V

    :cond_12
    return-void
.end method

.method private static final setupFilterItems$lambda$20(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 1

    .line 388
    iget-object p1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez p1, :cond_0

    const-string/jumbo p1, "viewModel"

    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p1, 0x0

    :cond_0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/FilterOption$All;->INSTANCE:Lcom/bytedance/trae/home/solo/task/FilterOption$All;

    check-cast v0, Lcom/bytedance/trae/home/solo/task/FilterOption;

    invoke-virtual {p1, v0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->setFilter(Lcom/bytedance/trae/home/solo/task/FilterOption;)V

    .line 389
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;

    move-result-object p1

    if-eqz p1, :cond_1

    sget v0, Lcom/bytedance/trae/home/R$id;->tv_title:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    if-eqz p1, :cond_1

    sget v0, Lcom/bytedance/trae/home/R$string;->solo_task_title:I

    invoke-virtual {p0, v0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 390
    :cond_1
    invoke-direct {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->dismissFilterPopup()V

    return-void
.end method

.method private static final setupFilterItems$lambda$21(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 1

    .line 399
    iget-object p1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez p1, :cond_0

    const-string/jumbo p1, "viewModel"

    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p1, 0x0

    :cond_0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/FilterOption$Cloud;->INSTANCE:Lcom/bytedance/trae/home/solo/task/FilterOption$Cloud;

    check-cast v0, Lcom/bytedance/trae/home/solo/task/FilterOption;

    invoke-virtual {p1, v0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->setFilter(Lcom/bytedance/trae/home/solo/task/FilterOption;)V

    .line 400
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;

    move-result-object p1

    if-eqz p1, :cond_1

    sget v0, Lcom/bytedance/trae/home/R$id;->tv_title:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/TextView;

    if-eqz p1, :cond_1

    .line 401
    sget v0, Lcom/bytedance/trae/home/R$string;->solo_filter_cloud:I

    invoke-virtual {p0, v0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    .line 400
    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 402
    :cond_1
    invoke-direct {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->dismissFilterPopup()V

    return-void
.end method

.method private static final setupFilterItems$lambda$22(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/DeviceInfo;Landroid/view/View;)V
    .locals 3

    .line 452
    iget-object p2, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez p2, :cond_0

    const-string/jumbo p2, "viewModel"

    invoke-static {p2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p2, 0x0

    :cond_0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;

    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getCliId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    check-cast v0, Lcom/bytedance/trae/home/solo/task/FilterOption;

    invoke-virtual {p2, v0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->setFilter(Lcom/bytedance/trae/home/solo/task/FilterOption;)V

    .line 453
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getView()Landroid/view/View;

    move-result-object p2

    if-eqz p2, :cond_1

    sget v0, Lcom/bytedance/trae/home/R$id;->tv_title:I

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p2

    check-cast p2, Landroid/widget/TextView;

    if-eqz p2, :cond_1

    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getName()Ljava/lang/String;

    move-result-object p1

    check-cast p1, Ljava/lang/CharSequence;

    invoke-virtual {p2, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 454
    :cond_1
    invoke-direct {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->dismissFilterPopup()V

    return-void
.end method

.method private final setupHeader(Landroid/view/View;)V
    .locals 6

    .line 233
    sget v0, Lcom/bytedance/trae/home/R$id;->title_bar:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;

    .line 234
    sget v1, Lcom/bytedance/trae/home/R$id;->iv_chevron:I

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 235
    sget v2, Lcom/bytedance/trae/home/R$id;->ll_title_filter:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 236
    sget v3, Lcom/bytedance/trae/home/R$id;->et_task_search:I

    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/EditText;

    .line 237
    sget v4, Lcom/bytedance/trae/home/R$id;->btn_task_search_clear:I

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 238
    sget v5, Lcom/bytedance/trae/home/R$id;->btn_task_search_exit:I

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    .line 240
    new-instance v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda1;

    invoke-direct {v5, p0, v2, v1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;Landroid/widget/ImageView;)V

    invoke-virtual {v0, v5}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnTaskTitleClickListener(Landroid/view/View$OnClickListener;)V

    .line 249
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda2;

    invoke-direct {v1, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    invoke-virtual {v0, v1}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnTaskSearchClickListener(Landroid/view/View$OnClickListener;)V

    .line 255
    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    check-cast v3, Landroid/widget/TextView;

    .line 978
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$setupHeader$$inlined$doAfterTextChanged$1;

    invoke-direct {v0, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$setupHeader$$inlined$doAfterTextChanged$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    .line 979
    check-cast v0, Landroid/text/TextWatcher;

    invoke-virtual {v3, v0}, Landroid/widget/TextView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 259
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda3;

    invoke-direct {v0, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    invoke-virtual {v4, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 263
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda4;

    invoke-direct {v0, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    invoke-virtual {p1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    return-void
.end method

.method private static final setupHeader$lambda$10(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;Landroid/widget/ImageView;Landroid/view/View;)V
    .locals 0

    .line 241
    iget-object p3, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->adapter:Lcom/bytedance/trae/home/solo/task/TaskAdapter;

    if-nez p3, :cond_0

    const-string p3, "adapter"

    invoke-static {p3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p3, 0x0

    :cond_0
    invoke-virtual {p3}, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->closeOpenItem()V

    .line 242
    iget-boolean p3, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isFilterOpen:Z

    if-eqz p3, :cond_1

    .line 243
    invoke-direct {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->dismissFilterPopup()V

    goto :goto_0

    .line 245
    :cond_1
    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-static {p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-direct {p0, p1, p2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showFilterPopup(Landroid/view/View;Landroid/widget/ImageView;)V

    :goto_0
    return-void
.end method

.method private static final setupHeader$lambda$11(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 1

    .line 250
    iget-object p1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->adapter:Lcom/bytedance/trae/home/solo/task/TaskAdapter;

    const/4 v0, 0x0

    if-nez p1, :cond_0

    const-string p1, "adapter"

    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object p1, v0

    :cond_0
    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->closeOpenItem()V

    .line 251
    invoke-direct {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->dismissFilterPopup()V

    .line 252
    iget-object p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez p0, :cond_1

    const-string/jumbo p0, "viewModel"

    invoke-static {p0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    move-object v0, p0

    :goto_0
    invoke-virtual {v0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->enterSearchMode()V

    return-void
.end method

.method private static final setupHeader$lambda$13(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 0

    .line 260
    iget-object p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez p0, :cond_0

    const-string/jumbo p0, "viewModel"

    invoke-static {p0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p0, 0x0

    :cond_0
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->clearSearchQuery()V

    return-void
.end method

.method private static final setupHeader$lambda$14(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/view/View;)V
    .locals 0

    .line 264
    iget-object p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez p0, :cond_0

    const-string/jumbo p0, "viewModel"

    invoke-static {p0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p0, 0x0

    :cond_0
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->exitSearchMode()V

    return-void
.end method

.method private final setupRecyclerView(Landroid/view/View;)V
    .locals 9

    .line 463
    sget v0, Lcom/bytedance/trae/home/R$id;->rv_tasks:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const-string v1, "findViewById(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroidx/recyclerview/widget/RecyclerView;

    .line 464
    iget-object v1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->fpsTracer:Lcom/bytedance/apm/trace/fps/FpsTracer;

    invoke-virtual {v1, v0}, Lcom/bytedance/apm/trace/fps/FpsTracer;->startRecyclerView(Landroidx/recyclerview/widget/RecyclerView;)V

    .line 465
    sget v1, Lcom/bytedance/trae/home/R$id;->swipe_refresh:I

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;

    iput-object p1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->swipeRefresh:Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;

    if-eqz p1, :cond_0

    .line 466
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda13;

    invoke-direct {v1, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda13;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    invoke-virtual {p1, v1}, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;->setOnRefreshListener(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 469
    :cond_0
    new-instance p1, Lcom/bytedance/trae/home/solo/task/TaskAdapter;

    new-instance v3, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda14;

    invoke-direct {v3, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda14;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda15;

    invoke-direct {v4}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda15;-><init>()V

    new-instance v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda16;

    invoke-direct {v5, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda16;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    new-instance v6, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda17;

    invoke-direct {v6, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda17;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    new-instance v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda18;

    invoke-direct {v7, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda18;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    new-instance v8, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda19;

    invoke-direct {v8, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda19;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    move-object v2, p1

    invoke-direct/range {v2 .. v8}, Lcom/bytedance/trae/home/solo/task/TaskAdapter;-><init>(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V

    iput-object p1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->adapter:Lcom/bytedance/trae/home/solo/task/TaskAdapter;

    .line 531
    new-instance p1, Landroidx/recyclerview/widget/LinearLayoutManager;

    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {p1, v1}, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V

    check-cast p1, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;

    invoke-virtual {v0, p1}, Landroidx/recyclerview/widget/RecyclerView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V

    .line 532
    iget-object p1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->adapter:Lcom/bytedance/trae/home/solo/task/TaskAdapter;

    if-nez p1, :cond_1

    const-string p1, "adapter"

    invoke-static {p1}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p1, 0x0

    :cond_1
    check-cast p1, Landroidx/recyclerview/widget/RecyclerView$Adapter;

    invoke-virtual {v0, p1}, Landroidx/recyclerview/widget/RecyclerView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V

    .line 533
    invoke-virtual {v0}, Landroidx/recyclerview/widget/RecyclerView;->getItemAnimator()Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;

    move-result-object p1

    iput-object p1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->defaultTaskListItemAnimator:Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;

    .line 535
    new-instance p1, Lcom/bytedance/trae/home/solo/task/TaskFragment$setupRecyclerView$8;

    invoke-direct {p1, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$setupRecyclerView$8;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    check-cast p1, Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;

    invoke-virtual {v0, p1}, Landroidx/recyclerview/widget/RecyclerView;->addOnScrollListener(Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;)V

    return-void
.end method

.method private static final setupRecyclerView$lambda$24(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V
    .locals 0

    .line 467
    iget-object p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez p0, :cond_0

    const-string/jumbo p0, "viewModel"

    invoke-static {p0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p0, 0x0

    :cond_0
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->refreshTasks()V

    return-void
.end method

.method private static final setupRecyclerView$lambda$26(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;I)Lkotlin/Unit;
    .locals 35

    move-object/from16 v0, p0

    const-string/jumbo v1, "task"

    move-object/from16 v2, p1

    invoke-static {v2, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 471
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->INSTANCE:Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;

    .line 472
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;

    move-result-object v3

    .line 473
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getStatus()Lcom/bytedance/trae/home/solo/task/TaskStatus;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getLabel()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {v4, v5}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "toLowerCase(...)"

    invoke-static {v4, v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    move/from16 v6, p2

    .line 471
    invoke-virtual {v1, v3, v4, v6}, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->trackTaskCardClick(Ljava/lang/String;Ljava/lang/String;I)V

    .line 476
    new-instance v1, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;

    move-result-object v3

    const-class v4, Lcom/bytedance/trae/conversation/ConversationActivity;

    invoke-direct {v1, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 477
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getSearchAnchorCreatedAtMs()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    const-string v4, "extra_anchor_created_at_ms"

    .line 478
    invoke-virtual {v1, v4, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    :cond_0
    const-string v3, "extra_enter_from"

    const-string/jumbo v4, "task_list"

    .line 480
    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 481
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez v3, :cond_1

    const-string/jumbo v3, "viewModel"

    invoke-static {v3}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v3, 0x0

    :cond_1
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->getConversation(Ljava/lang/String;)Lcom/bytedance/trae/im/service/Conversation;

    move-result-object v3

    if-nez v3, :cond_2

    .line 482
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;

    move-result-object v7

    .line 483
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getTitle()Ljava/lang/String;

    move-result-object v13

    .line 484
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliId()Ljava/lang/String;

    move-result-object v12

    .line 485
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getMode()Ljava/lang/String;

    move-result-object v16

    .line 486
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliType()Ljava/lang/String;

    move-result-object v18

    .line 487
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getStatus()Lcom/bytedance/trae/home/solo/task/TaskStatus;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getStatusCode()I

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v17

    .line 488
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z

    move-result v3

    .line 489
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getPinnedAt()Ljava/lang/String;

    move-result-object v32

    .line 490
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getUpdatedAt()Ljava/lang/String;

    move-result-object v23

    .line 491
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getIconType()Lcom/bytedance/trae/home/solo/task/TaskIconType;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bytedance/trae/home/solo/task/TaskIconType;->name()Ljava/lang/String;

    move-result-object v4

    sget-object v6, Ljava/util/Locale;->ROOT:Ljava/util/Locale;

    invoke-virtual {v4, v6}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v4

    move-object/from16 v25, v4

    invoke-static {v4, v5}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 481
    new-instance v4, Lcom/bytedance/trae/im/service/Conversation;

    move-object v6, v4

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    const/16 v21, 0x0

    const/16 v22, 0x0

    const/16 v24, 0x0

    const/16 v26, 0x0

    const/16 v27, 0x0

    const/16 v28, 0x0

    const/16 v29, 0x0

    const/16 v30, 0x0

    .line 488
    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v31

    const v33, 0xfaf19e

    const/16 v34, 0x0

    .line 481
    invoke-direct/range {v6 .. v34}, Lcom/bytedance/trae/im/service/Conversation;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/im/service/ConversationSource;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    move-object v3, v4

    .line 493
    :cond_2
    invoke-virtual {v3}, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->REMOTE:Lcom/bytedance/trae/im/service/CliType;

    invoke-virtual {v5}, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v4

    const-string v5, "extra_icon_type"

    const-string v6, "extra_conversation"

    if-eqz v4, :cond_3

    .line 494
    check-cast v3, Ljava/io/Serializable;

    invoke-virtual {v1, v6, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 495
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getIconType()Lcom/bytedance/trae/home/solo/task/TaskIconType;

    move-result-object v2

    check-cast v2, Ljava/io/Serializable;

    invoke-virtual {v1, v5, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 496
    invoke-virtual {v0, v1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 498
    :cond_3
    sget-object v4, Lcom/bytedance/trae/conversation/CliListRepository;->Companion:Lcom/bytedance/trae/conversation/CliListRepository$Companion;

    invoke-virtual {v4}, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;

    move-result-object v4

    invoke-virtual {v3}, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 500
    sget-object v4, Lcom/bytedance/trae/conversation/CliListRepository;->Companion:Lcom/bytedance/trae/conversation/CliListRepository$Companion;

    invoke-virtual {v4}, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;

    move-result-object v4

    invoke-virtual {v3}, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 499
    invoke-virtual {v3, v4}, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V

    .line 501
    check-cast v3, Ljava/io/Serializable;

    invoke-virtual {v1, v6, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 502
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getIconType()Lcom/bytedance/trae/home/solo/task/TaskIconType;

    move-result-object v2

    check-cast v2, Ljava/io/Serializable;

    invoke-virtual {v1, v5, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 503
    invoke-virtual {v0, v1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->startActivity(Landroid/content/Intent;)V

    .line 506
    :cond_4
    :goto_0
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method private static final setupRecyclerView$lambda$27(Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;
    .locals 1

    const-string/jumbo v0, "task"

    invoke-static {p0, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 508
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->INSTANCE:Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;

    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;

    move-result-object p0

    invoke-virtual {v0, p0}, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->trackTaskCardSlide(Ljava/lang/String;)V

    .line 509
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final setupRecyclerView$lambda$28(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;FF)Lkotlin/Unit;
    .locals 1

    const-string/jumbo v0, "task"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 511
    invoke-direct {p0, p1, p2, p3}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showActionPopup(Lcom/bytedance/trae/home/solo/task/TaskModel;FF)V

    .line 512
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final setupRecyclerView$lambda$29(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    .locals 3

    const-string/jumbo v0, "task"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "closeAction"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 514
    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z

    move-result v0

    const/4 v1, 0x0

    const-string/jumbo v2, "viewModel"

    if-eqz v0, :cond_1

    .line 515
    iget-object p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez p0, :cond_0

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    move-object v1, p0

    :goto_0
    invoke-virtual {v1, p1}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->unpinConversation(Lcom/bytedance/trae/home/solo/task/TaskModel;)V

    goto :goto_2

    .line 517
    :cond_1
    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->suppressNextTopChangedScrollTaskId:Ljava/lang/String;

    .line 518
    iget-object p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez p0, :cond_2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    move-object v1, p0

    :goto_1
    invoke-virtual {v1, p1}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pinConversation(Lcom/bytedance/trae/home/solo/task/TaskModel;)V

    .line 520
    :goto_2
    invoke-interface {p2}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    .line 521
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final setupRecyclerView$lambda$30(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    .locals 2

    const-string/jumbo v0, "task"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "closeAction"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 523
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->INSTANCE:Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;

    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->trackTaskRenameClick(Ljava/lang/String;)V

    .line 524
    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getTitle()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, v0, p1, p2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showRenameDialog(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V

    .line 525
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final setupRecyclerView$lambda$31(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;Lkotlin/jvm/functions/Function0;)Lkotlin/Unit;
    .locals 2

    const-string/jumbo v0, "task"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    const-string v0, "closeAction"

    invoke-static {p2, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 527
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->INSTANCE:Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;

    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->trackTaskDeleteClick(Ljava/lang/String;)V

    .line 528
    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;

    move-result-object p1

    invoke-direct {p0, p1, p2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showDeleteDialog(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V

    .line 529
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private final setupTaskTitleBar(Landroid/view/View;)Lcom/bytedance/trae/common/widget/TraeTitleBar;
    .locals 10

    .line 177
    sget v0, Lcom/bytedance/trae/home/R$id;->title_bar:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    move-object v9, p1

    check-cast v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;

    .line 178
    invoke-virtual {v9}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->showTaskListHeader()V

    .line 179
    sget v0, Lcom/bytedance/trae/home/R$string;->solo_task_title:I

    invoke-virtual {v9, v0}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(I)V

    .line 181
    sget v1, Lcom/bytedance/trae/home/R$id;->ll_title_filter:I

    .line 182
    sget v2, Lcom/bytedance/trae/home/R$id;->tv_title:I

    .line 183
    sget v3, Lcom/bytedance/trae/home/R$id;->iv_chevron:I

    .line 184
    sget v4, Lcom/bytedance/trae/home/R$id;->btn_task_search_entry:I

    .line 185
    sget v5, Lcom/bytedance/trae/home/R$id;->fl_avatar_container:I

    .line 186
    sget v6, Lcom/bytedance/trae/home/R$id;->iv_avatar:I

    .line 187
    sget v7, Lcom/bytedance/trae/home/R$id;->iv_bytecloud_badge:I

    .line 188
    sget v8, Lcom/bytedance/trae/home/R$id;->iv_operation_icon:I

    move-object v0, v9

    .line 180
    invoke-virtual/range {v0 .. v8}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskHeaderViewIds(IIIIIIII)V

    .line 190
    sget v0, Lcom/bytedance/trae/home/R$drawable;->ic_solo_drop_down:I

    invoke-virtual {v9, v0}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskTitleTrailingIcon(I)V

    .line 191
    sget v0, Lcom/bytedance/trae/home/R$drawable;->ic_task_search:I

    invoke-virtual {v9, v0}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskSearchIcon(I)V

    .line 192
    sget v0, Lcom/bytedance/trae/home/R$string;->solo_task_search_entry_content_description:I

    invoke-virtual {p0, v0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {v9, v0}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskSearchContentDescription(Ljava/lang/CharSequence;)V

    .line 193
    sget-object v0, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE:Lcom/bytedance/trae/settings/api/feature/FeatureCapability;

    sget-object v1, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_SEARCH:Lcom/bytedance/trae/settings/api/feature/Feature;

    invoke-virtual {v0, v1}, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z

    move-result v0

    invoke-virtual {v9, v0}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskSearchButtonVisible(Z)V

    .line 194
    sget v0, Lcom/bytedance/trae/home/R$drawable;->trae_ic_bytecloud_badge_small:I

    invoke-virtual {v9, v0}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskAvatarBadgeImageResource(I)V

    const-string v0, "apply(...)"

    .line 177
    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    return-object v9
.end method

.method private static final extractConversation(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;
    .locals 6

    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getTitle()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_title

    const-string v0, "conversation"

    :cond_title
    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_id

    const-string v1, ""

    :cond_id
    move-object v3, v1

    iget-object v2, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-eqz v2, :cond_vm_done

    invoke-virtual {v2, v1}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->getConversation(Ljava/lang/String;)Lcom/bytedance/trae/im/service/Conversation;

    move-result-object v2

    if-eqz v2, :cond_vm_done

    invoke-virtual {v2}, Lcom/bytedance/trae/im/service/Conversation;->getLatestTaskId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_vm_done

    move-object v3, v2

    :cond_vm_done
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v4

    if-nez v4, :cond_activity

    sget-object v5, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v5

    :cond_activity
    check-cast v4, Landroid/app/Activity;

    sget-object v5, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->INSTANCE:Lcom/bytedance/trae/conversation/extract/ExtractHelper;

    invoke-virtual {v5, v4, v3, v0}, Lcom/bytedance/trae/conversation/extract/ExtractHelper;->start(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v5, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v5
.end method

.method private final showActionPopup(Lcom/bytedance/trae/home/solo/task/TaskModel;FF)V
    .locals 25

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    .line 558
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->actionPopup:Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;

    if-eqz v2, :cond_0

    invoke-virtual {v2}, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->dismiss()V

    .line 559
    :cond_0
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->adapter:Lcom/bytedance/trae/home/solo/task/TaskAdapter;

    if-nez v2, :cond_1

    const-string v2, "adapter"

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v2, 0x0

    :cond_1
    invoke-virtual {v2}, Lcom/bytedance/trae/home/solo/task/TaskAdapter;->closeOpenItem()V

    .line 560
    invoke-static {}, Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;

    move-result-object v2

    new-instance v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;

    const v5, 0x7f07018f

    move v6, v5

    const v5, 0x7f0f078e

    invoke-virtual {v0, v5}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    const-string v4, "getString(...)"

    invoke-static {v5, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v7, v5

    check-cast v7, Ljava/lang/CharSequence;

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const v11, 0x7f080686

    new-instance v12, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda27;

    invoke-direct {v12, v0, v1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda27;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;)V

    const/16 v13, 0x1c

    const/4 v14, 0x0

    move-object v5, v3

    invoke-direct/range {v5 .. v14}, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(ILjava/lang/CharSequence;ZLjava/lang/Integer;Ljava/lang/Integer;ILkotlin/jvm/functions/Function0;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 561
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getSupportsPin()Z

    move-result v3

    const-string v4, "getString(...)"

    if-eqz v3, :cond_4

    sget-object v3, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->INSTANCE:Lcom/bytedance/trae/settings/api/feature/FeatureCapability;

    sget-object v5, Lcom/bytedance/trae/settings/api/feature/Feature;->TASK_LIST_PIN:Lcom/bytedance/trae/settings/api/feature/Feature;

    invoke-virtual {v3, v5}, Lcom/bytedance/trae/settings/api/feature/FeatureCapability;->isEnabled(Lcom/bytedance/trae/settings/api/feature/Feature;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 563
    new-instance v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;

    .line 564
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 565
    sget v5, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_context_menu_unpin:I

    goto :goto_0

    .line 567
    :cond_2
    sget v5, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_context_menu_pin:I

    :goto_0
    move v6, v5

    .line 570
    invoke-virtual/range {p1 .. p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 571
    sget v5, Lcom/bytedance/trae/home/R$string;->solo_context_menu_unpin:I

    goto :goto_1

    .line 573
    :cond_3
    sget v5, Lcom/bytedance/trae/home/R$string;->solo_context_menu_pin:I

    .line 569
    :goto_1
    invoke-virtual {v0, v5}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v7, v5

    check-cast v7, Ljava/lang/CharSequence;

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    .line 576
    sget v11, Lcom/bytedance/trae/home/R$id;->menu_pin:I

    .line 562
    new-instance v12, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda24;

    invoke-direct {v12, v1, v0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda24;-><init>(Lcom/bytedance/trae/home/solo/task/TaskModel;Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    const/16 v13, 0x1c

    const/4 v14, 0x0

    move-object v5, v3

    .line 563
    invoke-direct/range {v5 .. v14}, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(ILjava/lang/CharSequence;ZLjava/lang/Integer;Ljava/lang/Integer;ILkotlin/jvm/functions/Function0;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 562
    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 589
    :cond_4
    new-instance v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;

    .line 590
    sget v16, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_context_menu_rename:I

    .line 591
    sget v5, Lcom/bytedance/trae/home/R$string;->solo_context_menu_rename:I

    invoke-virtual {v0, v5}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    move-object/from16 v17, v5

    check-cast v17, Ljava/lang/CharSequence;

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    .line 592
    sget v21, Lcom/bytedance/trae/home/R$id;->menu_rename:I

    .line 588
    new-instance v5, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda25;

    invoke-direct {v5, v0, v1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda25;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;)V

    const/16 v23, 0x1c

    const/16 v24, 0x0

    move-object v15, v3

    move-object/from16 v22, v5

    .line 589
    invoke-direct/range {v15 .. v24}, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(ILjava/lang/CharSequence;ZLjava/lang/Integer;Ljava/lang/Integer;ILkotlin/jvm/functions/Function0;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 588
    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 597
    new-instance v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;

    .line 598
    sget v7, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_context_menu_delete:I

    .line 599
    sget v5, Lcom/bytedance/trae/home/R$string;->solo_context_menu_delete:I

    invoke-virtual {v0, v5}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    move-object v8, v5

    check-cast v8, Ljava/lang/CharSequence;

    const/4 v9, 0x1

    const/4 v10, 0x0

    const/4 v11, 0x0

    .line 601
    sget v12, Lcom/bytedance/trae/home/R$id;->menu_delete:I

    .line 596
    new-instance v13, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda26;

    invoke-direct {v13, v0, v1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda26;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;)V

    const/16 v14, 0x18

    const/4 v15, 0x0

    move-object v6, v3

    .line 597
    invoke-direct/range {v6 .. v15}, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;-><init>(ILjava/lang/CharSequence;ZLjava/lang/Integer;Ljava/lang/Integer;ILkotlin/jvm/functions/Function0;ILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 596
    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 560
    invoke-static {v2}, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;

    move-result-object v18

    .line 607
    new-instance v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;

    .line 608
    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;

    move-result-object v2

    const-string/jumbo v3, "requireContext(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/16 v19, 0x0

    const/16 v20, 0x4

    const/16 v21, 0x0

    move-object/from16 v16, v1

    move-object/from16 v17, v2

    .line 607
    invoke-direct/range {v16 .. v21}, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;-><init>(Landroid/content/Context;Ljava/util/List;IILkotlin/jvm/internal/DefaultConstructorMarker;)V

    .line 611
    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireView()Landroid/view/View;

    move-result-object v2

    const-string/jumbo v3, "requireView(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    move/from16 v3, p2

    move/from16 v4, p3

    invoke-virtual {v1, v2, v3, v4}, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->showNear(Landroid/view/View;FF)V

    .line 607
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->actionPopup:Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;

    return-void
.end method

.method private static final showActionPopup$lambda$37$lambda$32(Lcom/bytedance/trae/home/solo/task/TaskModel;Lcom/bytedance/trae/home/solo/task/TaskFragment;)Lkotlin/Unit;
    .locals 3

    .line 578
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z

    move-result v0

    const/4 v1, 0x0

    const-string/jumbo v2, "viewModel"

    if-eqz v0, :cond_1

    .line 579
    iget-object p1, p1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez p1, :cond_0

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    move-object v1, p1

    :goto_0
    invoke-virtual {v1, p0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->unpinConversation(Lcom/bytedance/trae/home/solo/task/TaskModel;)V

    goto :goto_2

    .line 581
    :cond_1
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->suppressNextTopChangedScrollTaskId:Ljava/lang/String;

    .line 582
    iget-object p1, p1, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez p1, :cond_2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    move-object v1, p1

    :goto_1
    invoke-virtual {v1, p0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pinConversation(Lcom/bytedance/trae/home/solo/task/TaskModel;)V

    .line 584
    :goto_2
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final showActionPopup$lambda$37$lambda$34(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;
    .locals 2

    .line 593
    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getTitle()Ljava/lang/String;

    move-result-object p1

    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda23;

    invoke-direct {v1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda23;-><init>()V

    invoke-direct {p0, v0, p1, v1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showRenameDialog(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V

    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final showActionPopup$lambda$37$lambda$34$lambda$33()Lkotlin/Unit;
    .locals 1

    .line 593
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method private static final showActionPopup$lambda$37$lambda$36(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/bytedance/trae/home/solo/task/TaskModel;)Lkotlin/Unit;
    .locals 1

    .line 602
    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;

    move-result-object p1

    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda27;

    invoke-direct {v0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda27;-><init>()V

    invoke-direct {p0, p1, v0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->showDeleteDialog(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V

    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final showActionPopup$lambda$37$lambda$36$lambda$35()Lkotlin/Unit;
    .locals 1

    .line 602
    sget-object v0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object v0
.end method

.method private final showDeleteDialog(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V
    .locals 21
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lkotlin/jvm/functions/Function0<",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    move-object/from16 v0, p0

    .line 634
    sget-object v1, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion:Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;

    .line 635
    invoke-virtual/range {p0 .. p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;

    move-result-object v3

    move-object v2, v3

    const-string/jumbo v4, "requireContext(...)"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 636
    sget v3, Lcom/bytedance/trae/home/R$string;->solo_dialog_delete_title:I

    invoke-virtual {v0, v3}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    move-object v3, v4

    const-string v7, "getString(...)"

    invoke-static {v4, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 637
    sget v4, Lcom/bytedance/trae/home/R$string;->solo_dialog_delete_message:I

    invoke-virtual {v0, v4}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    move-object v4, v5

    invoke-static {v5, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 638
    sget v5, Lcom/bytedance/trae/home/R$string;->solo_dialog_btn_cancel:I

    invoke-virtual {v0, v5}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    move-object v5, v6

    invoke-static {v6, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 639
    sget v6, Lcom/bytedance/trae/home/R$string;->solo_dialog_btn_delete:I

    invoke-virtual {v0, v6}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object v8

    move-object v6, v8

    invoke-static {v8, v7}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    const/4 v13, 0x0

    const/4 v14, 0x0

    const/4 v15, 0x0

    const/16 v16, 0x0

    .line 634
    new-instance v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda21;

    move-object/from16 v17, v7

    move-object/from16 v8, p1

    invoke-direct {v7, v0, v8}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda21;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Ljava/lang/String;)V

    const/16 v18, 0x0

    const v19, 0x17fe0

    const/16 v20, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-static/range {v1 .. v20}, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->delete$default(Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ILjava/lang/Object;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;

    move-result-object v1

    .line 644
    new-instance v2, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda22;

    move-object/from16 v3, p2

    invoke-direct {v2, v3}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda22;-><init>(Lkotlin/jvm/functions/Function0;)V

    invoke-virtual {v1, v2}, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 645
    invoke-virtual {v1}, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V

    return-void
.end method

.method private static final showDeleteDialog$lambda$41(Lcom/bytedance/trae/home/solo/task/TaskFragment;Ljava/lang/String;)Lkotlin/Unit;
    .locals 0

    .line 641
    iget-object p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez p0, :cond_0

    const-string/jumbo p0, "viewModel"

    invoke-static {p0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p0, 0x0

    :cond_0
    invoke-virtual {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->deleteConversation(Ljava/lang/String;)V

    .line 642
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final showDeleteDialog$lambda$42(Lkotlin/jvm/functions/Function0;Landroid/content/DialogInterface;)V
    .locals 0

    .line 644
    invoke-interface {p0}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    return-void
.end method

.method private final showFilterPopup(Landroid/view/View;Landroid/widget/ImageView;)V
    .locals 6

    .line 325
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 326
    sget v1, Lcom/bytedance/trae/home/R$layout;->dialog_task_filter:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 328
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    const/16 v2, 0xc8

    int-to-float v2, v2

    mul-float/2addr v2, v1

    float-to-int v2, v2

    .line 331
    new-instance v3, Landroid/widget/PopupWindow;

    const/4 v4, -0x2

    const/4 v5, 0x1

    invoke-direct {v3, v0, v4, v4, v5}, Landroid/widget/PopupWindow;-><init>(Landroid/view/View;IIZ)V

    const/high16 v4, 0x41000000    # 8.0f

    mul-float/2addr v4, v1

    .line 337
    invoke-virtual {v3, v4}, Landroid/widget/PopupWindow;->setElevation(F)V

    .line 338
    invoke-virtual {v3, v5}, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V

    .line 339
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda12;

    invoke-direct {v4, p0, p2}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda12;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/widget/ImageView;)V

    invoke-virtual {v3, v4}, Landroid/widget/PopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V

    .line 331
    iput-object v3, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->filterPopup:Landroid/widget/PopupWindow;

    .line 345
    invoke-virtual {v0, v2}, Landroid/view/View;->setMinimumWidth(I)V

    .line 347
    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V

    invoke-direct {p0, v0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupFilterItems(Landroid/view/View;)V

    .line 349
    iput-boolean v5, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isFilterOpen:Z

    const/high16 v0, 0x43340000    # 180.0f

    .line 350
    invoke-virtual {p2, v0}, Landroid/widget/ImageView;->setRotation(F)V

    const/16 p2, 0x8

    int-to-float p2, p2

    mul-float/2addr p2, v1

    float-to-int p2, p2

    .line 353
    iget-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->filterPopup:Landroid/widget/PopupWindow;

    if-eqz v0, :cond_0

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1, p2}, Landroid/widget/PopupWindow;->showAsDropDown(Landroid/view/View;II)V

    :cond_0
    return-void
.end method

.method private static final showFilterPopup$lambda$17$lambda$16(Lcom/bytedance/trae/home/solo/task/TaskFragment;Landroid/widget/ImageView;)V
    .locals 1

    const/4 v0, 0x0

    .line 340
    iput-boolean v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isFilterOpen:Z

    const/4 p0, 0x0

    .line 341
    invoke-virtual {p1, p0}, Landroid/widget/ImageView;->setRotation(F)V

    return-void
.end method

.method private final showRenameDialog(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lkotlin/jvm/functions/Function0<",
            "Lkotlin/Unit;",
            ">;)V"
        }
    .end annotation

    .line 616
    sget-object v0, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->Companion:Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;

    .line 617
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;

    move-result-object v1

    const-string/jumbo v2, "requireContext(...)"

    invoke-static {v1, v2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 618
    sget v2, Lcom/bytedance/trae/home/R$string;->solo_dialog_rename_title:I

    invoke-virtual {p0, v2}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, "getString(...)"

    invoke-static {v2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    const/4 v4, 0x0

    .line 620
    sget v5, Lcom/bytedance/trae/home/R$string;->solo_dialog_btn_cancel:I

    invoke-virtual {p0, v5}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 621
    sget v6, Lcom/bytedance/trae/home/R$string;->solo_dialog_btn_confirm:I

    invoke-virtual {p0, v6}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    .line 616
    new-instance v7, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda0;

    invoke-direct {v7, p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Ljava/lang/String;)V

    const/4 v8, 0x0

    const/16 v9, 0x88

    const/4 v10, 0x0

    move-object v3, p2

    invoke-static/range {v0 .. v10}, Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;->rename$default(Lcom/bytedance/trae/common/widget/CustomConfirmDialog$Companion;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;ILjava/lang/Object;)Lcom/bytedance/trae/common/widget/CustomConfirmDialog;

    move-result-object p1

    .line 629
    new-instance p2, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda11;

    invoke-direct {p2, p3}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda11;-><init>(Lkotlin/jvm/functions/Function0;)V

    invoke-virtual {p1, p2}, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 630
    invoke-virtual {p1}, Lcom/bytedance/trae/common/widget/CustomConfirmDialog;->show()V

    return-void
.end method

.method private static final showRenameDialog$lambda$39(Lcom/bytedance/trae/home/solo/task/TaskFragment;Ljava/lang/String;Ljava/lang/String;)Lkotlin/Unit;
    .locals 2

    .line 623
    move-object v0, p2

    check-cast v0, Ljava/lang/CharSequence;

    const/4 v1, 0x1

    if-eqz v0, :cond_1

    invoke-static {v0}, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    :goto_0
    move v0, v1

    :goto_1
    if-nez v0, :cond_3

    .line 624
    iput-boolean v1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->shouldScrollToTop:Z

    .line 625
    iget-object p0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez p0, :cond_2

    const-string/jumbo p0, "viewModel"

    invoke-static {p0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 p0, 0x0

    :cond_2
    invoke-virtual {p0, p1, p2}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->renameConversation(Ljava/lang/String;Ljava/lang/String;)V

    .line 627
    :cond_3
    sget-object p0, Lkotlin/Unit;->INSTANCE:Lkotlin/Unit;

    return-object p0
.end method

.method private static final showRenameDialog$lambda$40(Lkotlin/jvm/functions/Function0;Landroid/content/DialogInterface;)V
    .locals 0

    .line 629
    invoke-interface {p0}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    return-void
.end method

.method private final syncSearchInputText(Landroid/widget/EditText;Ljava/lang/String;)V
    .locals 1

    .line 302
    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    if-nez v0, :cond_1

    const-string v0, ""

    :cond_1
    invoke-static {v0, p2}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 303
    move-object v0, p2

    check-cast v0, Ljava/lang/CharSequence;

    invoke-virtual {p1, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 304
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result p2

    invoke-virtual {p1, p2}, Landroid/widget/EditText;->setSelection(I)V

    :cond_2
    return-void
.end method

.method private final titleForFilter(Lcom/bytedance/trae/home/solo/task/FilterOption;)Ljava/lang/String;
    .locals 2

    .line 794
    sget-object v0, Lcom/bytedance/trae/home/solo/task/FilterOption$All;->INSTANCE:Lcom/bytedance/trae/home/solo/task/FilterOption$All;

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    const-string v1, "getString(...)"

    if-eqz v0, :cond_0

    sget p1, Lcom/bytedance/trae/home/R$string;->solo_task_title:I

    invoke-virtual {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    goto :goto_0

    .line 795
    :cond_0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/FilterOption$Cloud;->INSTANCE:Lcom/bytedance/trae/home/solo/task/FilterOption$Cloud;

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    sget p1, Lcom/bytedance/trae/home/R$string;->solo_filter_cloud:I

    invoke-virtual {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    invoke-static {p1, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    goto :goto_0

    .line 796
    :cond_1
    instance-of v0, p1, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;

    if-eqz v0, :cond_2

    check-cast p1, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;

    invoke-virtual {p1}, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;->getName()Ljava/lang/String;

    move-result-object p1

    :goto_0
    return-object p1

    .line 793
    :cond_2
    new-instance p1, Lkotlin/NoWhenBranchMatchedException;

    invoke-direct {p1}, Lkotlin/NoWhenBranchMatchedException;-><init>()V

    throw p1
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1

    const-string p3, "inflater"

    invoke-static {p1, p3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 82
    sget p3, Lcom/bytedance/trae/home/R$layout;->fragment_task:I

    const/4 v0, 0x0

    invoke-virtual {p1, p3, p2, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p1

    return-object p1
.end method

.method public onDestroyView()V
    .locals 2

    .line 225
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onDestroyView()V

    .line 226
    iget-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->filterPopup:Landroid/widget/PopupWindow;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    :cond_0
    const/4 v0, 0x0

    .line 227
    iput-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->filterPopup:Landroid/widget/PopupWindow;

    .line 228
    iget-object v1, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->actionPopup:Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->dismiss()V

    .line 229
    :cond_1
    iput-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->actionPopup:Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;

    return-void
.end method

.method public onPause()V
    .locals 1

    .line 218
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onPause()V

    .line 219
    iget-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-eqz v0, :cond_1

    if-nez v0, :cond_0

    const-string/jumbo v0, "viewModel"

    .line 220
    invoke-static {v0}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    const/4 v0, 0x0

    :cond_0
    invoke-virtual {v0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->stopPolling()V

    :cond_1
    return-void
.end method

.method public onResume()V
    .locals 11

    .line 199
    invoke-super {p0}, Landroidx/fragment/app/Fragment;->onResume()V

    .line 200
    iget-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-eqz v0, :cond_e

    const/4 v1, 0x0

    const-string/jumbo v2, "viewModel"

    if-nez v0, :cond_0

    .line 201
    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_0
    invoke-virtual {v0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->forceLoadTasks()V

    .line 202
    iget-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez v0, :cond_1

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_1
    invoke-virtual {v0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadDevices()V

    .line 203
    iget-object v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez v0, :cond_2

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    move-object v0, v1

    :cond_2
    invoke-virtual {v0}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->startPollingIfNeeded()V

    .line 204
    iget-boolean v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isFirstResume:Z

    if-eqz v0, :cond_3

    const-string v0, "new_create"

    goto :goto_0

    :cond_3
    const-string v0, ""

    :goto_0
    move-object v5, v0

    const/4 v0, 0x0

    .line 205
    iput-boolean v0, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->isFirstResume:Z

    .line 206
    iget-object v3, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    if-nez v3, :cond_4

    invoke-static {v2}, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V

    goto :goto_1

    :cond_4
    move-object v1, v3

    :goto_1
    invoke-virtual {v1}, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->getTasks()Lkotlinx/coroutines/flow/StateFlow;

    move-result-object v1

    invoke-interface {v1}, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 207
    sget-object v3, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->INSTANCE:Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;

    .line 208
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v4

    .line 210
    check-cast v1, Ljava/lang/Iterable;

    .line 948
    instance-of v2, v1, Ljava/util/Collection;

    if-eqz v2, :cond_5

    move-object v6, v1

    check-cast v6, Ljava/util/Collection;

    invoke-interface {v6}, Ljava/util/Collection;->isEmpty()Z

    move-result v6

    if-eqz v6, :cond_5

    move v6, v0

    goto :goto_3

    .line 950
    :cond_5
    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v6

    move v7, v0

    :cond_6
    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_7

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/bytedance/trae/home/solo/task/TaskModel;

    .line 210
    invoke-virtual {v8}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliType()Ljava/lang/String;

    move-result-object v8

    const-string v9, "local_ide"

    invoke-static {v8, v9}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_6

    add-int/lit8 v7, v7, 0x1

    if-gez v7, :cond_6

    .line 950
    invoke-static {}, Lkotlin/collections/CollectionsKt;->throwCountOverflow()V

    goto :goto_2

    :cond_7
    move v6, v7

    :goto_3
    if-eqz v2, :cond_8

    .line 952
    move-object v7, v1

    check-cast v7, Ljava/util/Collection;

    invoke-interface {v7}, Ljava/util/Collection;->isEmpty()Z

    move-result v7

    if-eqz v7, :cond_8

    move v7, v0

    goto :goto_5

    .line 954
    :cond_8
    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v7

    move v8, v0

    :cond_9
    :goto_4
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_a

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/bytedance/trae/home/solo/task/TaskModel;

    .line 211
    invoke-virtual {v9}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliType()Ljava/lang/String;

    move-result-object v9

    const-string v10, "local"

    invoke-static {v9, v10}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_9

    add-int/lit8 v8, v8, 0x1

    if-gez v8, :cond_9

    .line 954
    invoke-static {}, Lkotlin/collections/CollectionsKt;->throwCountOverflow()V

    goto :goto_4

    :cond_a
    move v7, v8

    :goto_5
    if-eqz v2, :cond_c

    .line 956
    move-object v2, v1

    check-cast v2, Ljava/util/Collection;

    invoke-interface {v2}, Ljava/util/Collection;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_c

    :cond_b
    move v8, v0

    goto :goto_7

    .line 958
    :cond_c
    invoke-interface {v1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_d
    :goto_6
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_b

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/bytedance/trae/home/solo/task/TaskModel;

    .line 212
    invoke-virtual {v2}, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliType()Ljava/lang/String;

    move-result-object v2

    const-string v8, "remote"

    invoke-static {v2, v8}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_d

    add-int/lit8 v0, v0, 0x1

    if-gez v0, :cond_d

    .line 958
    invoke-static {}, Lkotlin/collections/CollectionsKt;->throwCountOverflow()V

    goto :goto_6

    .line 207
    :goto_7
    invoke-virtual/range {v3 .. v8}, Lcom/bytedance/trae/conversation/tracker/NewTaskTracker;->trackTaskListPageView(ILjava/lang/String;III)V

    :cond_e
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 13

    const-string/jumbo v0, "view"

    invoke-static {p1, v0}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object;Ljava/lang/String;)V

    .line 86
    invoke-super {p0, p1, p2}, Landroidx/fragment/app/Fragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 88
    new-instance p2, Landroidx/lifecycle/ViewModelProvider;

    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireActivity()Landroidx/fragment/app/FragmentActivity;

    move-result-object v0

    const-string/jumbo v1, "requireActivity(...)"

    invoke-static {v0, v1}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    check-cast v0, Landroidx/lifecycle/ViewModelStoreOwner;

    invoke-direct {p2, v0}, Landroidx/lifecycle/ViewModelProvider;-><init>(Landroidx/lifecycle/ViewModelStoreOwner;)V

    const-class v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    invoke-virtual {p2, v0}, Landroidx/lifecycle/ViewModelProvider;->get(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;

    move-result-object p2

    check-cast p2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    iput-object p2, p0, Lcom/bytedance/trae/home/solo/task/TaskFragment;->viewModel:Lcom/bytedance/trae/home/solo/task/TaskViewModel;

    .line 90
    invoke-direct {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupTaskTitleBar(Landroid/view/View;)Lcom/bytedance/trae/common/widget/TraeTitleBar;

    move-result-object p2

    .line 91
    invoke-direct {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupRecyclerView(Landroid/view/View;)V

    .line 92
    invoke-direct {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->setupHeader(Landroid/view/View;)V

    .line 93
    invoke-direct {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->observeViewModel()V

    .line 95
    invoke-virtual {p2}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->getTaskAvatarView()Lcom/facebook/drawee/view/SimpleDraweeView;

    move-result-object v0

    .line 97
    invoke-direct {p0, v0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->loadAvatar(Lcom/facebook/drawee/view/SimpleDraweeView;)V

    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;

    .line 947
    invoke-static {}, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;

    move-result-object v1

    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;

    invoke-virtual {v1, v2}, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    .line 100
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;

    const/4 v2, 0x0

    if-eqz v1, :cond_0

    .line 101
    invoke-interface {v1}, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;

    move-result-object v1

    goto :goto_0

    :cond_0
    move-object v1, v2

    :goto_0
    if-eqz v1, :cond_1

    .line 102
    invoke-virtual {v1}, Lcom/bytedance/trae/login/api/AccountInfo;->getLoginPlatform()Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    :cond_1
    move-object v3, v2

    :goto_1
    const-string v4, "bytecloud"

    invoke-static {v3, v4}, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    .line 103
    invoke-virtual {p2, v3}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskAvatarBadgeVisible(Z)V

    .line 105
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda8;

    invoke-direct {v4, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda8;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    invoke-virtual {p2, v4}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnTaskAvatarClickListener(Landroid/view/View$OnClickListener;)V

    if-eqz v1, :cond_2

    .line 125
    invoke-virtual {v1}, Lcom/bytedance/trae/login/api/AccountInfo;->getAccountType()Lcom/bytedance/trae/login/api/AccountType;

    move-result-object v1

    goto :goto_2

    :cond_2
    move-object v1, v2

    :goto_2
    sget-object v4, Lcom/bytedance/trae/login/api/AccountType;->TOB:Lcom/bytedance/trae/login/api/AccountType;

    const/4 v5, 0x1

    const/4 v6, 0x0

    if-ne v1, v4, :cond_3

    move v1, v5

    goto :goto_3

    :cond_3
    move v1, v6

    :goto_3
    if-eqz v1, :cond_4

    .line 127
    invoke-virtual {p2, v5}, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTaskEnterpriseMode(Z)V

    .line 129
    :cond_4
    sget p2, Lcom/bytedance/trae/home/R$id;->fl_avatar_container:I

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p2

    check-cast p2, Landroid/view/ViewGroup;

    if-nez v3, :cond_5

    if-nez v1, :cond_5

    .line 131
    new-instance v1, Landroid/view/View;

    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v1, v3}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 132
    sget v3, Lcom/bytedance/trae/home/R$id;->v_unread_dot:I

    invoke-virtual {v1, v3}, Landroid/view/View;->setId(I)V

    .line 133
    invoke-virtual {v1}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->density:F

    const/16 v4, 0x8

    int-to-float v5, v4

    mul-float/2addr v5, v3

    float-to-int v3, v5

    .line 136
    new-instance v5, Landroid/widget/FrameLayout$LayoutParams;

    const v7, 0x800035

    invoke-direct {v5, v3, v3, v7}, Landroid/widget/FrameLayout$LayoutParams;-><init>(III)V

    .line 137
    iput v3, v5, Landroid/widget/FrameLayout$LayoutParams;->topMargin:I

    .line 138
    invoke-virtual {v5, v3}, Landroid/widget/FrameLayout$LayoutParams;->setMarginEnd(I)V

    .line 136
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;

    invoke-virtual {v1, v5}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 140
    sget v3, Lcom/bytedance/trae/home/R$drawable;->bg_solo_notification_dot:I

    invoke-virtual {v1, v3}, Landroid/view/View;->setBackgroundResource(I)V

    .line 141
    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 143
    invoke-virtual {p2, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 144
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;

    move-result-object p2

    const-string v3, "getViewLifecycleOwner(...)"

    invoke-static {p2, v3}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-static {p2}, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;

    move-result-object p2

    move-object v7, p2

    check-cast v7, Lkotlinx/coroutines/CoroutineScope;

    const/4 v8, 0x0

    const/4 v9, 0x0

    new-instance p2, Lcom/bytedance/trae/home/solo/task/TaskFragment$onViewCreated$2;

    invoke-direct {p2, v1, v2}, Lcom/bytedance/trae/home/solo/task/TaskFragment$onViewCreated$2;-><init>(Landroid/view/View;Lkotlin/coroutines/Continuation;)V

    move-object v10, p2

    check-cast v10, Lkotlin/jvm/functions/Function2;

    const/4 v11, 0x3

    const/4 v12, 0x0

    invoke-static/range {v7 .. v12}, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineStart;Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Lkotlinx/coroutines/Job;

    .line 151
    :cond_5
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->getChildFragmentManager()Landroidx/fragment/app/FragmentManager;

    move-result-object p2

    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskFragment$onViewCreated$3;

    invoke-direct {v1, p0, v0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$onViewCreated$3;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;Lcom/facebook/drawee/view/SimpleDraweeView;)V

    check-cast v1, Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;

    invoke-virtual {p2, v1, v6}, Landroidx/fragment/app/FragmentManager;->registerFragmentLifecycleCallbacks(Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;Z)V

    .line 163
    sget p2, Lcom/bytedance/trae/home/R$id;->btn_retry_network:I

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p2

    if-eqz p2, :cond_6

    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda9;

    invoke-direct {v0, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda9;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    invoke-virtual {p2, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 167
    :cond_6
    sget p2, Lcom/bytedance/trae/home/R$id;->fab_add:I

    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    new-instance p2, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda10;

    invoke-direct {p2, p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment$$ExternalSyntheticLambda10;-><init>(Lcom/bytedance/trae/home/solo/task/TaskFragment;)V

    invoke-virtual {p1, p2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 173
    invoke-virtual {p0}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->requireContext()Landroid/content/Context;

    move-result-object p1

    const-string/jumbo p2, "requireContext(...)"

    invoke-static {p1, p2}, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object;Ljava/lang/String;)V

    invoke-direct {p0, p1}, Lcom/bytedance/trae/home/solo/task/TaskFragment;->fixSuspendByPeerCrash(Landroid/content/Context;)V

    return-void
.end method
