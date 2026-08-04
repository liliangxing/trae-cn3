# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$setupViews$1;
.super Ljava/lang/Object;
.source "OneClickLoginFragment.kt"

.implements Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;

.field final synthetic $carrierAgreementUrl:Ljava/lang/String;
.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;


.method constructor <init>(java.lang.String  com.bytedance.trae.login.fragment.OneClickLoginFragment)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$setupViews$1;->$carrierAgreementUrl Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$setupViews$1;->this$0 Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onUrlClick(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, url
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v0
    sparse-switch v0, +000003ch
    goto +37h
    const-string/jumbo v0, url_carrier
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +02fh
    iget-object v2, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$setupViews$1;->$carrierAgreementUrl Ljava/lang/String;
    if-eqz v2, +02bh
    iget-object v0, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$setupViews$1;->this$0 Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
    invoke-static v0, v2, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->access$openUrl(Lcom/bytedance/trae/login/fragment/OneClickLoginFragment; Ljava/lang/String;)V
    goto +24h
    const-string/jumbo v0, url2
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +1ah
    iget-object v2, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$setupViews$1;->this$0 Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
    const-string v0, "https://www.trae.cn/privacy-policy"
    invoke-static v2, v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->access$openUrl(Lcom/bytedance/trae/login/fragment/OneClickLoginFragment; Ljava/lang/String;)V
    goto +12h
    const-string/jumbo v0, url1
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +8h
    iget-object v2, v1, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment$setupViews$1;->this$0 Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;
    const-string v0, "https://www.trae.cn/terms-of-service"
    invoke-static v2, v0, Lcom/bytedance/trae/login/fragment/OneClickLoginFragment;->access$openUrl(Lcom/bytedance/trae/login/fragment/OneClickLoginFragment; Ljava/lang/String;)V
    return-void 
    nop 
    sparse-switch-payload 36e8a2 36e8a3 fb36c28
.end method
