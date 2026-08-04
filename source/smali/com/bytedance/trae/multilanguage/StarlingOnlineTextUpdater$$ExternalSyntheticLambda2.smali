# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final synthetic Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;


.method public synthetic constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 2
    # ins_size=2
    check-cast v1, Lcom/bytedance/trae/multilanguage/I18nLanguage;
    invoke-static v1, Lcom/bytedance/trae/multilanguage/StarlingOnlineTextUpdater;->$r8$lambda$jZ6aPI2XkL6qorbcMQsTmUlu47M(Lcom/bytedance/trae/multilanguage/I18nLanguage;)Ljava/lang/CharSequence;
    move-result-object v1
    return-object v1
.end method
