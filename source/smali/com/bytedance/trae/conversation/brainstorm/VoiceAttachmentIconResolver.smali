# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;
.super Ljava/lang/Object;
.source "VoiceAttachmentIconResolver.kt"

.field private static final COMPOUND_EXTENSIONS:Ljava/util/List;
.field private static final EXTENSION_ICON_MAP:Ljava/util/Map;
.field private static final FILENAME_ICON_MAP:Ljava/util/Map;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;


.method static constructor <clinit>()void
    .registers 12
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;
    const/4 v0, 4
    new-array v1, v0, [Lkotlin/Pair;
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_markdown I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const-string v3, "readme"
    invoke-static v3, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v3, 0
    aput-object v2, v1, v3
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const-string v4, "license"
    invoke-static v4, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v4, 1
    aput-object v2, v1, v4
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const-string v5, "dockerfile"
    invoke-static v5, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v5, 2
    aput-object v2, v1, v5
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const-string v6, "makefile"
    invoke-static v6, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v6, 3
    aput-object v2, v1, v6
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->FILENAME_ICON_MAP Ljava/util/Map;
    const-string/jumbo v1, tar.gz
    const-string/jumbo v2, tar.bz2
    const-string/jumbo v7, tar.xz
    const-string v8, "d.ts"
    filled-new-array v1, v2, v7, v8, [Ljava/lang/String;
    move-result-object v9
    invoke-static v9, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v9
    sput-object v9, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->COMPOUND_EXTENSIONS Ljava/util/List;
    const/16 v9, 93
    new-array v9, v9, [Lkotlin/Pair;
    sget v10, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_png I
    invoke-static v10, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    const-string v11, "png"
    invoke-static v11, v10, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v10
    aput-object v10, v9, v3
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_png I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    const-string v10, "apng"
    invoke-static v10, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    aput-object v3, v9, v4
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_png I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    const-string v4, "gif"
    invoke-static v4, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    aput-object v3, v9, v5
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_png I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    const-string v4, "bmp"
    invoke-static v4, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    aput-object v3, v9, v6
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_png I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    const-string/jumbo v4, webp
    invoke-static v4, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    aput-object v3, v9, v0
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_png I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v3, "heic"
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/4 v3, 5
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_png I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v3, "heif"
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/4 v3, 6
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_png I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v3, tif
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/4 v3, 7
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_png I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v3, tiff
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v3, 8
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_png I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v3, svg
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v3, 9
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_jpg I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v3, "jpg"
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v3, 10
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_jpg I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v3, "jpeg"
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v3, 11
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_html I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v3, "html"
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v3, 12
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_html I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v3, "htm"
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v3, 13
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_zip I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v3, zip
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v3, 14
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_zip I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v3, "rar"
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v3, 15
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_zip I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v3, "7z"
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v3, 16
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_zip I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v3, tar
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v3, 17
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_zip I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v3, "gz"
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v3, 18
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_zip I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v3, "bz2"
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v3, 19
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_zip I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v3, xz
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v3, 20
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_zip I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v3, tgz
    invoke-static v3, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v3, 21
    aput-object v0, v9, v3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_zip I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 22
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_zip I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-static v2, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 23
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_zip I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-static v7, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 24
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_json I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "json"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 25
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_json I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "jsonc"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 26
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_json I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "json5"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 27
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_markdown I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "md"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 28
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_markdown I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "markdown"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 29
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_markdown I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "mdx"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 30
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_pdf I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "pdf"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 31
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_word I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "doc"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 32
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_word I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "docx"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 33
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_word I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, rtf
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 34
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_excel I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, xls
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 35
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_excel I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, xlsx
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 36
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_excel I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "csv"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 37
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_excel I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "numbers"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 38
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_ppt I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "ppt"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 39
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_ppt I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "pptx"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 40
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_ppt I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "key"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 41
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_mp4 I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "mp4"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 42
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_mp4 I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "mov"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 43
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_mp4 I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "m4v"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 44
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_mp4 I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "avi"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 45
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_mp4 I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "mkv"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 46
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_mp4 I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, webm
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 47
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_mp3 I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "mp3"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 48
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_mp3 I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, wav
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 49
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_mp3 I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "m4a"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 50
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_mp3 I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "aac"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 51
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_mp3 I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "flac"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 52
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_mp3 I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "ogg"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 53
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_diff I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "diff"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 54
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_diff I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "patch"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 55
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_design I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "fig"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 56
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_design I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "figma"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 57
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_design I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, sketch
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 58
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_design I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, xd
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 59
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_skill I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, skill
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 60
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_folder I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "folder"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 61
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, txt
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 62
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, text
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 63
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "log"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 64
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, xml
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 65
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, yaml
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 66
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, yml
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 67
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "properties"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 68
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "gradle"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 69
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "js"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 70
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "jsx"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 71
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, ts
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 72
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, tsx
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 73
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-static v8, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 74
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "java"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 75
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "kt"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 76
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "kts"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 77
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "py"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 78
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "go"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 79
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, rs
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 80
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "c"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 81
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "cpp"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 82
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "cc"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 83
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "cxx"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 84
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "h"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 85
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "hpp"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 86
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "css"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 87
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, scss
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 88
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "less"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 89
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, sh
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 90
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string v1, "bash"
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 91
    aput-object v0, v9, v1
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    const-string/jumbo v1, zsh
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    const/16 v1, 92
    aput-object v0, v9, v1
    invoke-static v9, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->EXTENSION_ICON_MAP Ljava/util/Map;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final extensionCandidates(java.lang.String)java.util.List
    .registers 9
    # ins_size=2
    move-object v0, v8
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v8
    return-object v8
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->COMPOUND_EXTENSIONS Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +026h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "."
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 2
    const/4 v5, 0
    const/4 v6, 0
    invoke-static v8, v3, v6, v4, v5, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -022h
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    const/16 v1, 46
    const-string v2, ""
    invoke-static v8, v1, v2, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +00eh
    invoke-static v1, v8, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +008h
    move-object v8, v0
    check-cast v8, Ljava/util/Collection;
    invoke-interface v8, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v8
    return-object v8
.end method

.method public static synthetic getFileIconRes$default(com.bytedance.trae.conversation.brainstorm.VoiceAttachmentIconResolver  java.lang.String  java.lang.String  boolean  int  java.lang.Object)int
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +003h
    const/4 v2, 0
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->getFileIconRes(Ljava/lang/String; Ljava/lang/String; Z)I
    move-result v0
    return v0
.end method

.method private final normalizeFileName(java.lang.String)java.lang.String
    .registers 11
    # ins_size=2
    const/16 v0, 63
    const/4 v1, 0
    const/4 v2, 2
    invoke-static v10, v0, v1, v2, v1, Lkotlin/text/StringsKt;->substringBefore$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    const/16 v0, 35
    invoke-static v10, v0, v1, v2, v1, Lkotlin/text/StringsKt;->substringBefore$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    const/16 v4, 92
    const/16 v5, 47
    const/4 v6, 0
    const/4 v7, 4
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlin/text/StringsKt;->replace$default(Ljava/lang/String; C C Z I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    const/16 v0, 47
    invoke-static v10, v0, v1, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v10, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v10
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v1, "ROOT"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v10
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v10
.end method

.method private final resolveByMimeType(java.lang.String  boolean)int
    .registers 7
    # ins_size=3
    const/4 v0, 2
    const/4 v1, 0
    if-eqz v5, +028h
    const/16 v2, 59
    invoke-static v5, v2, v1, v0, v1, Lkotlin/text/StringsKt;->substringBefore$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +020h
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +014h
    sget-object v2, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v3, "ROOT"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, v2, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v2, toLowerCase(...)
    invoke-static v5, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    move-object v5, v1
    if-nez v5, +004h
    const-string v5, ""
    if-nez v6, +0eeh
    const-string v6, "image/"
    const/4 v2, 0
    invoke-static v5, v6, v2, v0, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +004h
    goto/16 +0e3h
    const-string/jumbo v6, video/
    invoke-static v5, v6, v2, v0, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +006h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_mp4 I
    goto/16 +0d8h
    const-string v6, "audio/"
    invoke-static v5, v6, v2, v0, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +006h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_mp3 I
    goto/16 +0cch
    const-string v6, "application/pdf"
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +006h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_pdf I
    goto/16 +0c0h
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    const-string/jumbo v3, word
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v6, v3, v2, v0, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +0adh
    const-string v3, "msword"
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v6, v3, v2, v0, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +004h
    goto/16 +0a1h
    const-string v3, "excel"
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v6, v3, v2, v0, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +094h
    const-string/jumbo v3, spreadsheet
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v6, v3, v2, v0, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +089h
    const-string v3, "csv"
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v6, v3, v2, v0, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +004h
    goto/16 +07dh
    const-string v3, "powerpoint"
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v6, v3, v2, v0, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +070h
    const-string v3, "presentation"
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v6, v3, v2, v0, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    goto +64h
    const-string v3, "json"
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v6, v3, v2, v0, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_json I
    goto +62h
    const-string v3, "markdown"
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v6, v3, v2, v0, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +005h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_markdown I
    goto +55h
    const-string/jumbo v3, zip
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v6, v3, v2, v0, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +03dh
    const-string v3, "compressed"
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v6, v3, v2, v0, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +033h
    const-string v3, "gzip"
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v6, v3, v2, v0, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +029h
    const-string/jumbo v3, tar
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v6, v3, v2, v0, v1, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    goto +1ch
    const-string/jumbo v6, text/html
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +005h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_html I
    goto +1eh
    const-string/jumbo v6, text/
    invoke-static v5, v6, v2, v0, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +005h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_text I
    goto +12h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_generic I
    goto +fh
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_zip I
    goto +ch
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_ppt I
    goto +9h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_excel I
    goto +6h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_word I
    goto +3h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_voice_file_png I
    return v5
.end method

.method public final getFileIconRes(java.lang.String  java.lang.String  boolean)int
    .registers 6
    # ins_size=4
    const-string v0, "fileName"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->normalizeFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->FILENAME_ICON_MAP Ljava/util/Map;
    invoke-interface v0, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Integer;
    if-eqz v0, +009h
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v3
    return v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->extensionCandidates(Ljava/lang/String;)Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +019h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->EXTENSION_ICON_MAP Ljava/util/Map;
    invoke-interface v1, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Integer;
    if-eqz v0, -014h
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v3
    return v3
    invoke-direct v2, v4, v5, Lcom/bytedance/trae/conversation/brainstorm/VoiceAttachmentIconResolver;->resolveByMimeType(Ljava/lang/String; Z)I
    move-result v3
    return v3
.end method
