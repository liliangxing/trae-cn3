# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/home/MainActivity;
.field public final synthetic f$1:Landroid/net/Uri;


.method public synthetic constructor <init>(com.bytedance.trae.home.MainActivity  android.net.Uri)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/home/MainActivity;
    iput-object v2, v0, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda1;->f$1 Landroid/net/Uri;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda1;->f$0 Lcom/bytedance/trae/home/MainActivity;
    iget-object v1, v2, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda1;->f$1 Landroid/net/Uri;
    invoke-static v0, v1, Lcom/bytedance/trae/home/MainActivity;->$r8$lambda$rW4miCde10D2FxRg_8fMJdlNOlo(Lcom/bytedance/trae/home/MainActivity; Landroid/net/Uri;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
