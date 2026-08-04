# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;
.super Landroidx/recyclerview/widget/RecyclerView$Adapter;
.source "CodeChangedListAdapter.kt"

.field private final items:Ljava/util/List;
.field private final onItemClick:Lkotlin/jvm/functions/Function1;


.method public static synthetic $r8$lambda$ZGnDS-yztPcz5bSwkHkJBPst2z0(com.bytedance.trae.conversation.products.CodeChangedListAdapter  com.bytedance.trae.im.model.FileDiffInfo  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->onBindViewHolder$lambda$0(Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter; Lcom/bytedance/trae/im/model/FileDiffInfo; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;-><init>(Lkotlin/jvm/functions/Function1; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Landroidx/recyclerview/widget/RecyclerView$Adapter;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->onItemClick Lkotlin/jvm/functions/Function1;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->items Ljava/util/List;
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.functions.Function1  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;-><init>(Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method private final extractFileExtension(java.lang.String)java.lang.String
    .registers 11
    # ins_size=2
    move-object v0, v10
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    move v0, v1
    const-string v2, ""
    if-eqz v0, +003h
    return-object v2
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->extractFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    move-object v3, v10
    check-cast v3, Ljava/lang/CharSequence;
    const/16 v4, 46
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v0
    if-lez v0, +00dh
    add-int/2addr v0, v1
    invoke-virtual v10, v0, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v10, substring(...)
    invoke-static v2, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method private final extractFileName(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v1
    goto +2h
    const/4 v2, 1
    if-eqz v2, +005h
    const-string v6, ""
    return-object v6
    const/16 v2, 92
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v0, v2, v1, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; C Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/16 v2, 47
    invoke-static v6, v2, v4, v3, v4, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    return-object v6
.end method

.method private final getCodeFileIcon(java.lang.String)int
    .registers 3
    # ins_size=2
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    if-eqz v0, +005h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_code I
    return v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->extractFileExtension(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v2, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Ljava/lang/String;->hashCode()I
    move-result v0
    sparse-switch v0, +00001d6h
    goto/16 +1cfh
    const-string v0, "markdown"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +17ch
    goto/16 +1c5h
    const-string/jumbo v0, yaml
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +076h
    goto/16 +1bah
    const-string/jumbo v0, xlsx
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +0f0h
    goto/16 +1afh
    const-string/jumbo v0, scss
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +00fh
    goto/16 +1a4h
    const-string/jumbo v0, sass
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +199h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_css I
    goto/16 +197h
    const-string v0, "less"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +18bh
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_css I
    goto/16 +189h
    const-string v0, "json"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +17dh
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_json I
    goto/16 +17bh
    const-string v0, "java"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +16fh
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_java I
    goto/16 +16dh
    const-string v0, "html"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +161h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_html I
    goto/16 +15fh
    const-string v0, "bash"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +0e2h
    goto/16 +153h
    const-string/jumbo v0, yml
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +148h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_yaml I
    goto/16 +146h
    const-string/jumbo v0, xml
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +139h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_xml I
    goto/16 +137h
    const-string/jumbo v0, xls
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +06bh
    goto/16 +12ah
    const-string/jumbo v0, vue
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +11fh
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_vue I
    goto/16 +11dh
    const-string/jumbo v0, txt
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +110h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_txt I
    goto/16 +10eh
    const-string/jumbo v0, tsx
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +101h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_react I
    goto/16 +0ffh
    const-string v0, "pdf"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +0f3h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_pdf I
    goto/16 +0f1h
    const-string v0, "kts"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +0a8h
    goto/16 +0e5h
    const-string v0, "jsx"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +0dbh
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_react I
    goto/16 +0d9h
    const-string v0, "hpp"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +0c0h
    goto/16 +0cdh
    const-string v0, "elx"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +0c3h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_xlsx I
    goto/16 +0c1h
    const-string v0, "dts"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +0b5h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_dts I
    goto/16 +0b3h
    const-string v0, "cxx"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +08eh
    goto/16 +0a7h
    const-string v0, "css"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +09dh
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_css I
    goto/16 +09bh
    const-string v0, "cpp"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +076h
    goto/16 +08fh
    const-string/jumbo v0, ts
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +084h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_ts I
    goto/16 +082h
    const-string/jumbo v0, sh
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +075h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_bash I
    goto/16 +073h
    const-string/jumbo v0, rs
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +066h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_rs I
    goto/16 +064h
    const-string v0, "py"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +58h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_python I
    goto +57h
    const-string v0, "md"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +4ch
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_markdown I
    goto +4bh
    const-string v0, "kt"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +40h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_java I
    goto +3fh
    const-string v0, "js"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +34h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_js I
    goto +33h
    const-string v0, "go"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +28h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_go I
    goto +27h
    const-string v0, "cc"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +1ch
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_cpp I
    goto +1bh
    const-string v0, "h"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +10h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_header I
    goto +fh
    const-string v0, "c"
    invoke-virtual v2, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +003h
    goto +4h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_c I
    goto +3h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->ic_artifact_code I
    return v2
    nop 
    sparse-switch-payload 63 68 c60 ce8 d49 d69 d97 e09 e41 e55 e7f 181a3 18203 182a3 185e3 188b1 19468 19c4f 1a02a 1b0f2 1c1d9 1c270 1c986 1cfff 1d017 1d3d8 2e06d4 3107ab 31aa22 31ece8 32a199 35c12e 35c8b0 383059 387aa7 eb7fcef
.end method

.method private static final onBindViewHolder$lambda$0(com.bytedance.trae.conversation.products.CodeChangedListAdapter  com.bytedance.trae.im.model.FileDiffInfo  android.view.View)void
    .registers 3
    # ins_size=3
    iget-object v0, v0, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->onItemClick Lkotlin/jvm/functions/Function1;
    if-eqz v0, +005h
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public getItemCount()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    return v0
.end method

.method public bridge synthetic onBindViewHolder(androidx.recyclerview.widget.RecyclerView$ViewHolder  int)void
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter$ViewHolder;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->onBindViewHolder(Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter$ViewHolder; I)V
    return-void 
.end method

.method public onBindViewHolder(com.bytedance.trae.conversation.products.CodeChangedListAdapter$ViewHolder  int)void
    .registers 5
    # ins_size=3
    const-string v0, "holder"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->items Ljava/util/List;
    invoke-interface v0, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/FileDiffInfo;
    invoke-virtual v4, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->extractFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter$ViewHolder;->getTvFileName()Landroid/widget/TextView;
    move-result-object v1
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v1, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter$ViewHolder;->getIvFileIcon()Landroid/widget/ImageView;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/im/model/FileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v1
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->getCodeFileIcon(Ljava/lang/String;)I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v3, v3, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter$ViewHolder;->itemView Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, v4, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter; Lcom/bytedance/trae/im/model/FileDiffInfo;)V
    invoke-virtual v3, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public bridge synthetic onCreateViewHolder(android.view.ViewGroup  int)androidx.recyclerview.widget.RecyclerView$ViewHolder
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->onCreateViewHolder(Landroid/view/ViewGroup; I)Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter$ViewHolder;
    move-result-object v1
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    return-object v1
.end method

.method public onCreateViewHolder(android.view.ViewGroup  int)com.bytedance.trae.conversation.products.CodeChangedListAdapter$ViewHolder
    .registers 5
    # ins_size=3
    const-string v4, "parent"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    invoke-static v4, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v4
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_code_changed I
    const/4 v1, 0
    invoke-virtual v4, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter$ViewHolder;
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter$ViewHolder;-><init>(Landroid/view/View;)V
    return-object v4
.end method

.method public final submitList(java.util.List)void
    .registers 3
    # ins_size=2
    const-string v0, "newItems"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->items Ljava/util/List;
    invoke-interface v0, Ljava/util/List;->clear()V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->items Ljava/util/List;
    check-cast v2, Ljava/util/Collection;
    invoke-interface v0, v2, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/CodeChangedListAdapter;->notifyDataSetChanged()V
    return-void 
.end method
