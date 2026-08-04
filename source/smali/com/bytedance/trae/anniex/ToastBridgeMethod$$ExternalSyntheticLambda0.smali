# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/anniex/ToastBridgeMethod$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroid/app/Activity;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:I


.method public synthetic constructor <init>(android.app.Activity  java.lang.String  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/anniex/ToastBridgeMethod$$ExternalSyntheticLambda0;->f$0 Landroid/app/Activity;
    iput-object v2, v0, Lcom/bytedance/trae/anniex/ToastBridgeMethod$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    iput v3, v0, Lcom/bytedance/trae/anniex/ToastBridgeMethod$$ExternalSyntheticLambda0;->f$2 I
    return-void 
.end method

.method public final run()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/anniex/ToastBridgeMethod$$ExternalSyntheticLambda0;->f$0 Landroid/app/Activity;
    iget-object v1, v3, Lcom/bytedance/trae/anniex/ToastBridgeMethod$$ExternalSyntheticLambda0;->f$1 Ljava/lang/String;
    iget v2, v3, Lcom/bytedance/trae/anniex/ToastBridgeMethod$$ExternalSyntheticLambda0;->f$2 I
    invoke-static v0, v1, v2, Lcom/bytedance/trae/anniex/ToastBridgeMethod;->$r8$lambda$UTcDFyvLxC7tT_2lc6JSSfYoDps(Landroid/app/Activity; Ljava/lang/String; I)V
    return-void 
.end method
