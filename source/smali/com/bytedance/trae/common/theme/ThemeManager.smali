# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/theme/ThemeManager;
.super Ljava/lang/Object;
.source "ThemeManager.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/common/theme/ThemeManager;
.field private static final KEY_DARK_MODE:Ljava/lang/String;
.field private static final REPO_NAME:Ljava/lang/String;
.field private static bridge darkMode:I
.field private static bridge isDarkMode:Z
.field private static final keva$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$Yn8Rviwfw1QGkZ_oCw1U--Oing0()com.bytedance.keva.Keva
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/common/theme/ThemeManager;->keva_delegate$lambda$0()Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/common/theme/ThemeManager;
    invoke-direct v0, Lcom/bytedance/trae/common/theme/ThemeManager;-><init>()V
    sput-object v0, Lcom/bytedance/trae/common/theme/ThemeManager;->INSTANCE Lcom/bytedance/trae/common/theme/ThemeManager;
    new-instance v0, Lcom/bytedance/trae/common/theme/ThemeManager$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/common/theme/ThemeManager$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/common/theme/ThemeManager;->keva$delegate Lkotlin/Lazy;
    const/4 v0, -1
    sput v0, Lcom/bytedance/trae/common/theme/ThemeManager;->darkMode I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getKeva()com.bytedance.keva.Keva
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/theme/ThemeManager;->keva$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getValue(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/keva/Keva;
    return-object v0
.end method

.method private static final keva_delegate$lambda$0()com.bytedance.keva.Keva
    .registers 2
    # ins_size=0
    const-string/jumbo v0, trae_theme
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String; I)Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method public final applyDarkMode(int)void
    .registers 4
    # ins_size=2
    sput v3, Lcom/bytedance/trae/common/theme/ThemeManager;->darkMode I
    invoke-direct v2, Lcom/bytedance/trae/common/theme/ThemeManager;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string v1, "dark_mode"
    invoke-virtual v0, v1, v3, Lcom/bytedance/keva/Keva;->storeInt(Ljava/lang/String; I)V
    invoke-static v3, Landroidx/appcompat/app/AppCompatDelegate;->setDefaultNightMode(I)V
    return-void 
.end method

.method public final getCurrentMode()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/common/theme/ThemeManager;->darkMode I
    return v0
.end method

.method public final init()void
    .registers 2
    # ins_size=1
    const/4 v0, 1
    sput v0, Lcom/bytedance/trae/common/theme/ThemeManager;->darkMode I
    sget v0, Lcom/bytedance/trae/common/theme/ThemeManager;->darkMode I
    invoke-static v0, Landroidx/appcompat/app/AppCompatDelegate;->setDefaultNightMode(I)V
    return-void 
.end method

.method public final isDarkMode()boolean
    .registers 2
    # ins_size=1
    sget-boolean v0, Lcom/bytedance/trae/common/theme/ThemeManager;->isDarkMode Z
    return v0
.end method

.method public final updateDarkModeFlag(android.content.res.Configuration)void
    .registers 3
    # ins_size=2
    const-string v0, "configuration"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget v2, v2, Landroid/content/res/Configuration;->uiMode I
    and-int/lit8 v2, v2, 48
    const/16 v0, 32
    if-ne v2, v0, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    sput-boolean v2, Lcom/bytedance/trae/common/theme/ThemeManager;->isDarkMode Z
    return-void 
.end method
