# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager$DefaultImpls;
.super Ljava/lang/Object;
.source "ActivityStackManager.kt"


.method public static synthetic getPreviousActivity$default(com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager  android.app.Activity  kotlin.jvm.functions.Function1  int  java.lang.Object)android.app.Activity
    .registers 5
    # ins_size=5
    if-nez v4, +00ch
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-interface v0, v1, v2, Lcom/bytedance/trae/common/apphost/lifecycle/ActivityStackManager;->getPreviousActivity(Landroid/app/Activity; Lkotlin/jvm/functions/Function1;)Landroid/app/Activity;
    move-result-object v0
    return-object v0
    new-instance v0, Ljava/lang/UnsupportedOperationException;
    const-string v1, "Super calls with default arguments not supported in this target, function: getPreviousActivity"
    invoke-direct v0, v1, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V
    throw v0
.end method
