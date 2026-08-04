# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/common/widget/CustomToast$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Ljava/lang/Runnable;

.field public final synthetic f$0:Landroid/content/Context;
.field public final synthetic f$1:Ljava/lang/String;
.field public final synthetic f$2:I


.method public synthetic constructor <init>(android.content.Context  java.lang.String  int)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/common/widget/CustomToast$$ExternalSyntheticLambda1;->f$0 Landroid/content/Context;
    iput-object v2, v0, Lcom/bytedance/trae/common/widget/CustomToast$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iput v3, v0, Lcom/bytedance/trae/common/widget/CustomToast$$ExternalSyntheticLambda1;->f$2 I
    return-void 
.end method

.method public final run()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/CustomToast$$ExternalSyntheticLambda1;->f$0 Landroid/content/Context;
    iget-object v1, v3, Lcom/bytedance/trae/common/widget/CustomToast$$ExternalSyntheticLambda1;->f$1 Ljava/lang/String;
    iget v2, v3, Lcom/bytedance/trae/common/widget/CustomToast$$ExternalSyntheticLambda1;->f$2 I
    invoke-static v0, v1, v2, Lcom/bytedance/trae/common/widget/CustomToast;->lambda$show$0(Landroid/content/Context; Ljava/lang/String; I)V
    return-void 
.end method
