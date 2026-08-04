# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/praise/PraiseDialogUIConfigImpl;
.super Ljava/lang/Object;
.source "PraiseDialogUIConfigImpl.kt"

.implements Lcom/bytedance/praisedialoglib/depend/IPraiseDialogUIConfig;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getMainBackgroundResId()int
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public getMainTitleStrColor()java.lang.String
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method

.method public getMainTitleStrSize()int
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public getMainTitleString()java.lang.String
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    const-string v2, "getResources(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_praise_title I
    const/4 v3, 0
    new-array v3, v3, [Ljava/lang/Object;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getMiddleImageResId()int
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public getMiddleImageStyle2ResId()int
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public getMiddleImageStyle3ResId()int
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public getNegativeBtnResId()int
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public getNegativeBtnText()java.lang.String
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    const-string v2, "getResources(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_praise_negative_btn I
    const/4 v3, 0
    new-array v3, v3, [Ljava/lang/Object;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getNegativeBtnTextColor()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "#000000"
    return-object v0
.end method

.method public getNegativeBtnTextSize()int
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public getPositiveBtnResId()int
    .registers 2
    # ins_size=1
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_brand I
    return v0
.end method

.method public getPositiveBtnText()java.lang.String
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    const-string v2, "getResources(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_praise_positive_btn I
    const/4 v3, 0
    new-array v3, v3, [Ljava/lang/Object;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getPositiveBtnTextColor()java.lang.String
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method

.method public getPositiveBtnTextSize()int
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public getSecondTitleStrColor()java.lang.String
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method

.method public getSecondTitleStrSize()int
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public getSecondTitleString()java.lang.String
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    invoke-virtual v1, Landroid/app/Application;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    const-string v2, "getResources(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->trae_praise_subtitle I
    const/4 v3, 0
    new-array v3, v3, [Ljava/lang/Object;
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
