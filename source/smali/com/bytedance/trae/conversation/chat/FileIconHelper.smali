# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/FileIconHelper;
.super Ljava/lang/Object;
.source "FileIconHelper.kt"

.field private static final EXTENSION_ICON_MAP:Ljava/util/Map;
.field private static final FILENAME_ICON_MAP:Ljava/util/Map;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/FileIconHelper;


.method static constructor <clinit>()void
    .registers 16
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/FileIconHelper;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/FileIconHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/FileIconHelper;
    const/16 v0, 81
    new-array v0, v0, [Lkotlin/Pair;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_js I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "js"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_js I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v3, "mjs"
    invoke-static v3, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v3, 1
    aput-object v1, v0, v3
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_js I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v4, "cjs"
    invoke-static v4, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v4, 2
    aput-object v1, v0, v4
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_ts I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v5, ts
    invoke-static v5, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v5, 3
    aput-object v1, v0, v5
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_ts I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v6, "mts"
    invoke-static v6, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v6, 4
    aput-object v1, v0, v6
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_ts I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v7, "cts"
    invoke-static v7, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v7, 5
    aput-object v1, v0, v7
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_dts I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v8, "d.ts"
    invoke-static v8, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v8, 6
    aput-object v1, v0, v8
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_react I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v9, tsx
    invoke-static v9, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v9, 7
    aput-object v1, v0, v9
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_react I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v10, "jsx"
    invoke-static v10, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v10, 8
    aput-object v1, v0, v10
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_vue_1 I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v11, vue
    invoke-static v11, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v11, 9
    aput-object v1, v0, v11
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_python_1 I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v12, "py"
    invoke-static v12, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v12, 10
    aput-object v1, v0, v12
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_python_1 I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v13, "pyw"
    invoke-static v13, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v13, 11
    aput-object v1, v0, v13
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_python_1 I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v14, "pyx"
    invoke-static v14, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v14, 12
    aput-object v1, v0, v14
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_go I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "go"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 13
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_java I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "java"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 14
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_java I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "kt"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 15
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_java I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "kts"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 16
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_rs I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, rs
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 17
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_c I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "c"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 18
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_cpp I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "cpp"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 19
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_cpp I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "cc"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 20
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_cpp I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "cxx"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 21
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_c_sharp I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "cs"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 22
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_css I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "css"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 23
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_css I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, scss
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 24
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_css I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, sass
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 25
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_css I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "less"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 26
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_css I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "postcss"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 27
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_html I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "html"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 28
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_html I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "htm"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 29
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_xml I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, xml
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 30
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_xml I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, xsl
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 31
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_xml I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, xslt
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 32
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_xml I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "plist"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 33
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_json I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "json"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 34
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_json I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "jsonc"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 35
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_json I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "json5"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 36
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_yaml I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, yaml
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 37
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_yaml I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, yml
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 38
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_bat I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "bat"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 39
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_bat I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "cmd"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 40
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_header I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "h"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 41
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_header I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "hpp"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 42
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_header I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "hxx"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 43
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_markdown_1 I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "md"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 44
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_markdown_1 I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "markdown"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 45
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_markdown_1 I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "mdx"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 46
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_pdf I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "pdf"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 47
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_image I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "png"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 48
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_image I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "jpg"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 49
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_image I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "jpeg"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 50
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_image I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "gif"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 51
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_image I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "bmp"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 52
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_image I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, webp
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 53
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_ico I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "ico"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 54
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_svg I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, svg
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 55
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_txt I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, txt
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 56
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_txt I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "log"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 57
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_doc I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "doc"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 58
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_docx I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "docx"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 59
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_pptx I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "ppt"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 60
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_pptx I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "pptx"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 61
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_xlsx I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, xls
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 62
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_xlsx I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, xlsx
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 63
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_xlsx I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "csv"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 64
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_numbers I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "numbers"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 65
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_pages I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "pages"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 66
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_key I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "key"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 67
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_bash I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, sh
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 68
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_bash I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "bash"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 69
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_bash I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, zsh
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 70
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_bash I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "fish"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 71
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_class I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "class"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 72
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_file_zip I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, zip
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 73
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_file_zip I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "rar"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 74
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_file_zip I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "7z"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 75
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_file_zip I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, tar
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 76
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_file_zip I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "gz"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 77
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_file_zip I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "bz2"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 78
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_file_zip I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, xz
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 79
    aput-object v1, v0, v15
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->ic_file_zip I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string/jumbo v15, tgz
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v15, 80
    aput-object v1, v0, v15
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->EXTENSION_ICON_MAP Ljava/util/Map;
    const/16 v0, 25
    new-array v0, v0, [Lkotlin/Pair;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_docker I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v15, "dockerfile"
    invoke-static v15, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_docker I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "docker-compose.yml"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v3
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_docker I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "docker-compose.yaml"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v4
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_git I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, ".gitignore"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v5
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_git I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, ".gitmodules"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v6
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_git I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, ".gitattributes"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v7
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_gitlab I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, ".gitlab-ci.yml"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v8
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_npm I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "package.json"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v9
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_npm I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "package-lock.json"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v10
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_eslint I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, ".eslintrc"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v11
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_eslint I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, ".eslintrc.js"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v12
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_eslint I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, ".eslintrc.json"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v13
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_eslint I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, ".eslintrc.yml"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v14
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_eslint I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "eslint.config.js"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v2, 13
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_eslint I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "eslint.config.mjs"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v2, 14
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_eslint I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "eslint.config.ts"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v2, 15
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_eslint_ignore I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, ".eslintignore"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v2, 16
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_license I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "license"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v2, 17
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_license I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "license.md"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v2, 18
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_type_license I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "license.txt"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v2, 19
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_file_readme I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "readme.md"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v2, 20
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_file_readme I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "readme"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v2, 21
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_next I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "next.config.js"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v2, 22
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_next I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "next.config.mjs"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v2, 23
    aput-object v1, v0, v2
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_lang_next I
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    const-string v2, "next.config.ts"
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/16 v2, 24
    aput-object v1, v0, v2
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->FILENAME_ICON_MAP Ljava/util/Map;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic getFolderIconRes$default(com.bytedance.trae.conversation.chat.FileIconHelper  boolean  int  java.lang.Object)int
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    const/4 v1, 0
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->getFolderIconRes(Z)I
    move-result v0
    return v0
.end method

.method public final getFileIconRes(java.lang.String)int
    .registers 8
    # ins_size=2
    const-string v0, "path"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/16 v0, 47
    const/4 v1, 0
    const/4 v2, 2
    invoke-static v7, v0, v1, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v7, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v3, toLowerCase(...)
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->FILENAME_ICON_MAP Ljava/util/Map;
    invoke-interface v4, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Integer;
    if-eqz v0, +009h
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v7
    return v7
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v4, 0
    const/16 v5, 46
    invoke-static v0, v5, v4, v2, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; C Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +005h
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->explorer_file I
    return v7
    invoke-static v7, v5, v1, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v7, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/FileIconHelper;->EXTENSION_ICON_MAP Ljava/util/Map;
    invoke-interface v0, v7, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/Integer;
    if-eqz v7, +007h
    invoke-virtual v7, Ljava/lang/Integer;->intValue()I
    move-result v7
    goto +3h
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->explorer_file I
    return v7
.end method

.method public final getFolderIconRes(boolean)int
    .registers 2
    # ins_size=2
    if-eqz v1, +005h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_folder_open I
    goto +3h
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->explorer_folder_closed I
    return v1
.end method
