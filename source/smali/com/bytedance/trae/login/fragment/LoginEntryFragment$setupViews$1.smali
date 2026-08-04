# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/fragment/LoginEntryFragment$setupViews$1;
.super Ljava/lang/Object;
.source "LoginEntryFragment.kt"

.implements Lcom/bytedance/trae/common/widget/UrlSpanTextView$OnClickListener;

.field final synthetic this$0:Lcom/bytedance/trae/login/fragment/LoginEntryFragment;


.method constructor <init>(com.bytedance.trae.login.fragment.LoginEntryFragment)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$setupViews$1;->this$0 Lcom/bytedance/trae/login/fragment/LoginEntryFragment;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onUrlClick(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, url
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, url1
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00ah
    iget-object v2, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$setupViews$1;->this$0 Lcom/bytedance/trae/login/fragment/LoginEntryFragment;
    const-string v0, "https://www.trae.cn/terms-of-service"
    invoke-static v2, v0, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->access$openUrl(Lcom/bytedance/trae/login/fragment/LoginEntryFragment; Ljava/lang/String;)V
    goto +11h
    const-string/jumbo v0, url2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +009h
    iget-object v2, v1, Lcom/bytedance/trae/login/fragment/LoginEntryFragment$setupViews$1;->this$0 Lcom/bytedance/trae/login/fragment/LoginEntryFragment;
    const-string v0, "https://www.trae.cn/privacy-policy"
    invoke-static v2, v0, Lcom/bytedance/trae/login/fragment/LoginEntryFragment;->access$openUrl(Lcom/bytedance/trae/login/fragment/LoginEntryFragment; Ljava/lang/String;)V
    return-void 
.end method
