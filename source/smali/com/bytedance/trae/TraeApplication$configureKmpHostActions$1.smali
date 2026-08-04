# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/TraeApplication$configureKmpHostActions$1;
.super Ljava/lang/Object;
.source "TraeApplication.kt"

.implements Lcom/bytedance/trae/kmp/host/KmpHostActionHandler;

.field final synthetic $context:Landroid/content/Context;


.method constructor <init>(android.content.Context)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/TraeApplication$configureKmpHostActions$1;->$context Landroid/content/Context;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public copyToClipboard(java.lang.String)void
    .registers 5
    # ins_size=2
    const-string/jumbo v0, text
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v1, v3, Lcom/bytedance/trae/TraeApplication$configureKmpHostActions$1;->$context Landroid/content/Context;
    invoke-virtual v1, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v1
    if-nez v1, +004h
    iget-object v1, v3, Lcom/bytedance/trae/TraeApplication$configureKmpHostActions$1;->$context Landroid/content/Context;
    const-string v2, "clipboard"
    invoke-virtual v1, v2, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v1
    const-string v2, "null cannot be cast to non-null type android.content.ClipboardManager"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/content/ClipboardManager;
    check-cast v0, Ljava/lang/CharSequence;
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v0, v4, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Landroid/content/ClipData;
    move-result-object v4
    invoke-virtual v1, v4, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V
    return-void 
.end method

.method public showToast(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "message"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/TraeApplication$configureKmpHostActions$1;->$context Landroid/content/Context;
    invoke-virtual v0, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +004h
    iget-object v0, v1, Lcom/bytedance/trae/TraeApplication$configureKmpHostActions$1;->$context Landroid/content/Context;
    invoke-static v0, v2, Lcom/bytedance/trae/common/widget/CustomToast;->showShort(Landroid/content/Context; Ljava/lang/String;)V
    return-void 
.end method
