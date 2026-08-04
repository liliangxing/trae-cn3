# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public abstract Lcom/bytedance/trae/common/fragment/TraceFragment;
.super Landroidx/fragment/app/Fragment;
.source "TraceFragment.kt"

.field private enterPageTraced:Z


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/fragment/app/Fragment;-><init>()V
    return-void 
.end method

.method public abstract autoLogEnterPage()boolean
    # abstract or native
.end method

.method public logEnterPage()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public onCreate(android.os.Bundle)void
    .registers 2
    # ins_size=2
    invoke-super v0, v1, Landroidx/fragment/app/Fragment;->onCreate(Landroid/os/Bundle;)V
    return-void 
.end method

.method public onResume()void
    .registers 2
    # ins_size=1
    invoke-super v1, Landroidx/fragment/app/Fragment;->onResume()V
    invoke-virtual v1, Lcom/bytedance/trae/common/fragment/TraceFragment;->autoLogEnterPage()Z
    move-result v0
    if-eqz v0, +00ch
    iget-boolean v0, v1, Lcom/bytedance/trae/common/fragment/TraceFragment;->enterPageTraced Z
    if-nez v0, +008h
    invoke-virtual v1, Lcom/bytedance/trae/common/fragment/TraceFragment;->logEnterPage()V
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/common/fragment/TraceFragment;->enterPageTraced Z
    return-void 
.end method
