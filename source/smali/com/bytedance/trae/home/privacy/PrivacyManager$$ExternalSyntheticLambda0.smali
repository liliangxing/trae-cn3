# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/privacy/PrivacyManager$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Thread$UncaughtExceptionHandler;

.field public final synthetic f$0:Landroid/content/Context;


.method public synthetic constructor <init>(android.content.Context)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/privacy/PrivacyManager$$ExternalSyntheticLambda0;->f$0 Landroid/content/Context;
    return-void 
.end method

.method public final uncaughtException(java.lang.Thread  java.lang.Throwable)void
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/home/privacy/PrivacyManager$$ExternalSyntheticLambda0;->f$0 Landroid/content/Context;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/home/privacy/PrivacyManager;->$r8$lambda$K9gIovtgl09CSCxFKTflgUlsT_8(Landroid/content/Context; Ljava/lang/Thread; Ljava/lang/Throwable;)V
    return-void 
.end method
