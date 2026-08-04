# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda0;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute;
.field public final synthetic f$1:Lcom/bytedance/trae/home/MainActivity;


.method public synthetic constructor <init>(com.bytedance.trae.home.zlink.PendingDeepLinkRoute  com.bytedance.trae.home.MainActivity)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute;
    iput-object v2, v0, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/home/MainActivity;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda0;->f$0 Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute;
    iget-object v1, v2, Lcom/bytedance/trae/home/MainActivity$$ExternalSyntheticLambda0;->f$1 Lcom/bytedance/trae/home/MainActivity;
    invoke-static v0, v1, Lcom/bytedance/trae/home/MainActivity;->$r8$lambda$WPJbe_A251TyWrCVpwcMra7A1NM(Lcom/bytedance/trae/home/zlink/PendingDeepLinkRoute; Lcom/bytedance/trae/home/MainActivity;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
