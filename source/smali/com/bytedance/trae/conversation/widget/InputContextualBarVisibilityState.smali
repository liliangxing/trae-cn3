# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;
.super Ljava/lang/Object;
.source "InputContextualBarVisibilityState.kt"

.field private requestedVisible:Z


.method public constructor <init>()void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    const/4 v1, 0
    const/4 v2, 0
    invoke-direct v3, v2, v0, v1, Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;-><init>(Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(boolean)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;->requestedVisible Z
    return-void 
.end method

.method public synthetic constructor <init>(boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    const/4 v3, 1
    and-int/2addr v2, v3
    if-eqz v2, +003h
    move v1, v3
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;-><init>(Z)V
    return-void 
.end method

.method public final setRequestedVisible(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;->requestedVisible Z
    return-void 
.end method

.method public final shouldShowForDevice(boolean)boolean
    .registers 3
    # ins_size=2
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/widget/InputContextualBarVisibilityState;->requestedVisible Z
    if-eqz v0, +006h
    if-eqz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method
