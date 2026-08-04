# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final enum Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
.super Ljava/lang/Enum;
.source "CustomTagStyle.kt"

.field private static final synthetic $ENTRIES:Lkotlin/enums/EnumEntries;
.field private static final synthetic $VALUES:[Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
.field public static final enum CODE:Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
.field private static final CODE_EXTENSIONS:Ljava/util/Set;
.field public static final Companion:Lcom/bytedance/trae/conversation/widget/CustomTagStyle$Companion;
.field public static final enum FILE:Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
.field public static final enum FOLDER:Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
.field public static final enum SLASH_COMMAND:Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
.field public static final enum SPEC:Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
.field public static final enum TERMINAL:Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
.field public static final enum TYPE_CREATE_MR:Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
.field private final bgColorRes:I
.field private final iconRes:I
.field private final textColorRes:I


.method private static final synthetic $values()com.bytedance.trae.conversation.widget.CustomTagStyle[]
    .registers 3
    # ins_size=0
    const/4 v0, 7
    new-array v0, v0, [Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    const/4 v1, 0
    sget-object v2, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->FOLDER Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    aput-object v2, v0, v1
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->CODE Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    aput-object v2, v0, v1
    const/4 v1, 2
    sget-object v2, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->TERMINAL Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    aput-object v2, v0, v1
    const/4 v1, 3
    sget-object v2, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->FILE Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    aput-object v2, v0, v1
    const/4 v1, 4
    sget-object v2, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->TYPE_CREATE_MR Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    aput-object v2, v0, v1
    const/4 v1, 5
    sget-object v2, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->SLASH_COMMAND Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    aput-object v2, v0, v1
    const/4 v1, 6
    sget-object v2, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->SPEC Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    aput-object v2, v0, v1
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 63
    # ins_size=0
    new-instance v6, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    const-string v1, "FOLDER"
    const/4 v2, 0
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->ic_tag_folder I
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_accent_accent_slate I
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;-><init>(Ljava/lang/String; I I I I)V
    sput-object v6, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->FOLDER Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    const-string v8, "CODE"
    const/4 v9, 1
    sget v10, Lcom/bytedance/trae/conversation/R$drawable;->ic_tag_code I
    sget v11, Lcom/bytedance/trae/common_ui/R$color;->trae_accent_accent_slate I
    sget v12, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    move-object v7, v0
    invoke-direct/range v7 ... v12, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;-><init>(Ljava/lang/String; I I I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->CODE Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    const-string v2, "TERMINAL"
    const/4 v3, 2
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_tag_terminal I
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_accent_accent_slate I
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    move-object v1, v0
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;-><init>(Ljava/lang/String; I I I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->TERMINAL Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    const-string v8, "FILE"
    const/4 v9, 3
    sget v10, Lcom/bytedance/trae/conversation/R$drawable;->ic_tag_file I
    sget v11, Lcom/bytedance/trae/common_ui/R$color;->trae_accent_accent_slate I
    sget v12, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    move-object v7, v0
    invoke-direct/range v7 ... v12, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;-><init>(Ljava/lang/String; I I I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->FILE Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    const-string v2, "TYPE_CREATE_MR"
    const/4 v3, 4
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_tag_pr I
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_spec_color I
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    move-object v1, v0
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;-><init>(Ljava/lang/String; I I I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->TYPE_CREATE_MR Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    const-string v8, "SLASH_COMMAND"
    const/4 v9, 5
    sget v10, Lcom/bytedance/trae/conversation/R$drawable;->ic_tag_slash I
    sget v11, Lcom/bytedance/trae/common_ui/R$color;->trae_spec_color I
    sget v12, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    move-object v7, v0
    invoke-direct/range v7 ... v12, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;-><init>(Ljava/lang/String; I I I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->SLASH_COMMAND Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    const-string v2, "SPEC"
    const/4 v3, 6
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_tag_plan I
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_spec_color I
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    move-object v1, v0
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;-><init>(Ljava/lang/String; I I I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->SPEC Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    invoke-static Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->$values()[Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->$VALUES [Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    check-cast v0, [Ljava/lang/Enum;
    invoke-static v0, Lkotlin/enums/EnumEntriesKt;->enumEntries([Ljava/lang/Enum;)Lkotlin/enums/EnumEntries;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->$ENTRIES Lkotlin/enums/EnumEntries;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/CustomTagStyle$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->Companion Lcom/bytedance/trae/conversation/widget/CustomTagStyle$Companion;
    const-string v2, "kt"
    const-string v3, "java"
    const-string v4, "py"
    const-string v5, "js"
    const-string/jumbo v6, ts
    const-string/jumbo v7, tsx
    const-string v8, "jsx"
    const-string v9, "c"
    const-string v10, "cpp"
    const-string v11, "h"
    const-string v12, "hpp"
    const-string v13, "cs"
    const-string v14, "go"
    const-string/jumbo v15, rs
    const-string v16, "rb"
    const-string v17, "php"
    const-string/jumbo v18, swift
    const-string v19, "m"
    const-string v20, "mm"
    const-string/jumbo v21, scala
    const-string v22, "groovy"
    const-string/jumbo v23, sh
    const-string v24, "bash"
    const-string/jumbo v25, zsh
    const-string v26, "bat"
    const-string v27, "ps1"
    const-string v28, "pl"
    const-string v29, "lua"
    const-string v30, "r"
    const-string/jumbo v31, sql
    const-string v32, "css"
    const-string/jumbo v33, scss
    const-string v34, "less"
    const-string/jumbo v35, sass
    const-string/jumbo v36, xml
    const-string v37, "json"
    const-string/jumbo v38, yaml
    const-string/jumbo v39, yml
    const-string/jumbo v40, toml
    const-string v41, "ini"
    const-string v42, "cfg"
    const-string v43, "conf"
    const-string v44, "properties"
    const-string v45, "gradle"
    const-string v46, "cmake"
    const-string v47, "makefile"
    const-string v48, "dockerfile"
    const-string v49, "dart"
    const-string/jumbo v50, vue
    const-string/jumbo v51, svelte
    const-string/jumbo v52, zig
    const-string v53, "nim"
    const-string v54, "ex"
    const-string v55, "exs"
    const-string v56, "erl"
    const-string v57, "hs"
    const-string v58, "ml"
    const-string v59, "mli"
    const-string v60, "clj"
    const-string v61, "cljs"
    const-string v62, "elm"
    filled-new-array/range v2 ... v62, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->CODE_EXTENSIONS Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>(java.lang.String  int  int  int  int)void
    .registers 6
    # ins_size=6
    invoke-direct v0, v1, v2, Ljava/lang/Enum;-><init>(Ljava/lang/String; I)V
    iput v3, v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->iconRes I
    iput v4, v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->bgColorRes I
    iput v5, v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->textColorRes I
    return-void 
.end method

.method public static final synthetic access$getCODE_EXTENSIONS$cp()java.util.Set
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->CODE_EXTENSIONS Ljava/util/Set;
    return-object v0
.end method

.method public static getEntries()kotlin.enums.EnumEntries
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->$ENTRIES Lkotlin/enums/EnumEntries;
    return-object v0
.end method

.method public static valueOf(java.lang.String)com.bytedance.trae.conversation.widget.CustomTagStyle
    .registers 2
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    invoke-static v0, v1, Ljava/lang/Enum;->valueOf(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/Enum;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    return-object v1
.end method

.method public static values()com.bytedance.trae.conversation.widget.CustomTagStyle[]
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->$VALUES [Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    invoke-virtual v0, Ljava/lang/Object;->clone()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lcom/bytedance/trae/conversation/widget/CustomTagStyle;
    return-object v0
.end method

.method public final getBgColor(android.content.Context)int
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->bgColorRes I
    invoke-static v2, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    return v2
.end method

.method public final getIconRes()int
    .registers 2
    # ins_size=1
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->iconRes I
    return v0
.end method

.method public final getTextColor(android.content.Context)int
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget v0, v1, Lcom/bytedance/trae/conversation/widget/CustomTagStyle;->textColorRes I
    invoke-static v2, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    return v2
.end method
