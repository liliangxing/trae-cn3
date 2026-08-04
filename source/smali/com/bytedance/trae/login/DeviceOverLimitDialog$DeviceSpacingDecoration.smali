# Decompiled TRAE business class
# Source DEX: classes4.dex
.class final Lcom/bytedance/trae/login/DeviceOverLimitDialog$DeviceSpacingDecoration;
.super Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;
.source "DeviceOverLimitDialog.kt"

.field private final spacing:I


.method public constructor <init>(int)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;-><init>()V
    iput v1, v0, Lcom/bytedance/trae/login/DeviceOverLimitDialog$DeviceSpacingDecoration;->spacing I
    return-void 
.end method

.method public getItemOffsets(android.graphics.Rect  android.view.View  androidx.recyclerview.widget.RecyclerView  androidx.recyclerview.widget.RecyclerView$State)void
    .registers 6
    # ins_size=5
    const-string/jumbo v0, outRect
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, view
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, parent
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, state
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v3, Landroidx/recyclerview/widget/RecyclerView;->getChildAdapterPosition(Landroid/view/View;)I
    move-result v3
    invoke-virtual v4, Landroidx/recyclerview/widget/RecyclerView;->getAdapter()Landroidx/recyclerview/widget/RecyclerView$Adapter;
    move-result-object v4
    if-eqz v4, +011h
    invoke-virtual v4, Landroidx/recyclerview/widget/RecyclerView$Adapter;->getItemCount()I
    move-result v4
    const/4 v5, -1
    if-eq v3, v5, +00ah
    add-int/lit8 v4, v4, -1
    if-ge v3, v4, +006h
    iget v3, v1, Lcom/bytedance/trae/login/DeviceOverLimitDialog$DeviceSpacingDecoration;->spacing I
    iput v3, v2, Landroid/graphics/Rect;->bottom I
    return-void 
.end method
