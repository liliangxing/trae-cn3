# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/MarkdownHelper$createMarkdownContent$1;
.super Ljava/lang/Object;
.source "MarkdownHelper.kt"

.implements Lcom/larus/business/markdown/api/model/CodeCopySpanClickListener;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onClick(com.larus.business.markdown.api.model.MarkdownContent  android.view.View  com.larus.business.markdown.api.model.ICodeCopyInfoSpan)void
    .registers 5
    # ins_size=4
    const-string v0, "markdownContent"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, view
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v2, span
    invoke-static v4, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    if-nez v2, +003h
    return-void 
    const-string v3, "clipboard"
    invoke-virtual v2, v3, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v3
    instance-of v0, v3, Landroid/content/ClipboardManager;
    if-eqz v0, +005h
    check-cast v3, Landroid/content/ClipboardManager;
    goto +2h
    const/4 v3, 0
    if-nez v3, +003h
    return-void 
    const-string v0, "code"
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v4, Lcom/larus/business/markdown/api/model/ICodeCopyInfoSpan;->getCode()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v0, v4, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence; Ljava/lang/CharSequence;)Landroid/content/ClipData;
    move-result-object v4
    invoke-virtual v3, v4, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V
    sget v3, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_copied I
    const/4 v4, 0
    invoke-static v2, v3, v4, Landroid/widget/Toast;->makeText(Landroid/content/Context; I I)Landroid/widget/Toast;
    move-result-object v2
    invoke-virtual v2, Landroid/widget/Toast;->show()V
    return-void 
.end method
