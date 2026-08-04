# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/widget/VerifyCodeInputView$pasteOnlyCallback$1;
.super Ljava/lang/Object;
.source "VerifyCodeInputView.kt"

.implements Landroid/view/ActionMode$Callback;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onActionItemClicked(android.view.ActionMode  android.view.MenuItem)boolean
    .registers 3
    # ins_size=3
    const/4 v1, 0
    return v1
.end method

.method public onCreateActionMode(android.view.ActionMode  android.view.Menu)boolean
    .registers 3
    # ins_size=3
    if-eqz v2, +014h
    const v1, 16908319
    invoke-interface v2, v1, Landroid/view/Menu;->removeItem(I)V
    const v1, 16908321
    invoke-interface v2, v1, Landroid/view/Menu;->removeItem(I)V
    const v1, 16908320
    invoke-interface v2, v1, Landroid/view/Menu;->removeItem(I)V
    const/4 v1, 1
    return v1
.end method

.method public onDestroyActionMode(android.view.ActionMode)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public onPrepareActionMode(android.view.ActionMode  android.view.Menu)boolean
    .registers 3
    # ins_size=3
    const/4 v1, 0
    return v1
.end method
