# Decompiled TRAE business class
# Source DEX: classes.dex
.class public final Lcom/bytedance/trae/keva/KevaSharedPreference;
.super Ljava/lang/Object;
.source "KevaSharedPreference.kt"

.implements Landroid/content/SharedPreferences;
.implements Lcom/bytedance/keva/Keva$OnChangeListener;

.field private final keva$delegate:Lkotlin/Lazy;
.field private final listeners$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$TH0MCP_qujzwCXg_p8B61Jbjx6U(com.bytedance.trae.keva.KevaSharedPreference)com.bytedance.trae.keva.KevaSharedPreference$listeners$2$1
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/keva/KevaSharedPreference;->listeners_delegate$lambda$1(Lcom/bytedance/trae/keva/KevaSharedPreference;)Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$dx2bLNSfhkV7ViviWmo2IswxYvY(java.lang.String  int)com.bytedance.keva.Keva
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->keva_delegate$lambda$0(Ljava/lang/String; I)Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method public constructor <init>(java.lang.String  int)void
    .registers 4
    # ins_size=3
    const-string v0, "fileName"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Lcom/bytedance/trae/keva/KevaSharedPreference$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/keva/KevaSharedPreference$$ExternalSyntheticLambda0;-><init>(Ljava/lang/String; I)V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->keva$delegate Lkotlin/Lazy;
    new-instance v2, Lcom/bytedance/trae/keva/KevaSharedPreference$$ExternalSyntheticLambda1;
    invoke-direct v2, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/keva/KevaSharedPreference;)V
    invoke-static v2, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->listeners$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public synthetic constructor <init>(java.lang.String  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 0
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/keva/KevaSharedPreference;-><init>(Ljava/lang/String; I)V
    return-void 
.end method

.method public static final synthetic access$getKeva(com.bytedance.trae.keva.KevaSharedPreference)com.bytedance.keva.Keva
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/keva/KevaSharedPreference;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method private final getKeva()com.bytedance.keva.Keva
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->keva$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/keva/Keva;
    return-object v0
.end method

.method private final getListeners()com.bytedance.trae.keva.KevaSharedPreference$listeners$2$1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->listeners$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;
    return-object v0
.end method

.method private static final keva_delegate$lambda$0(java.lang.String  int)com.bytedance.keva.Keva
    .registers 3
    # ins_size=2
    const/4 v0, 4
    if-ne v2, v0, +003h
    const/4 v2, 1
    invoke-static v1, v2, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String; I)Lcom/bytedance/keva/Keva;
    move-result-object v1
    return-object v1
.end method

.method private static final listeners_delegate$lambda$1(com.bytedance.trae.keva.KevaSharedPreference)com.bytedance.trae.keva.KevaSharedPreference$listeners$2$1
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;
    invoke-direct v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;-><init>(Lcom/bytedance/trae/keva/KevaSharedPreference;)V
    return-object v0
.end method

.method public contains(java.lang.String)boolean
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v0, v2, Lcom/bytedance/keva/Keva;->contains(Ljava/lang/String;)Z
    move-result v2
    return v2
.end method

.method public edit()android.content.SharedPreferences$Editor
    .registers 4
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/keva/KevaSharedPreference$KevaPrefEdit;
    invoke-direct v3, Lcom/bytedance/trae/keva/KevaSharedPreference;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v1
    const-string v2, "<get-keva>(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$KevaPrefEdit;-><init>(Lcom/bytedance/keva/Keva;)V
    check-cast v0, Landroid/content/SharedPreferences$Editor;
    return-object v0
.end method

.method public getAll()java.util.Map
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/keva/KevaSharedPreference;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/keva/Keva;->getAll()Ljava/util/Map;
    move-result-object v0
    const-string v1, "getAll(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public getBoolean(java.lang.String  boolean)boolean
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v0, v2, v3, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v2
    return v2
.end method

.method public final getBytes(java.lang.String  byte[])byte[]
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v0, v2, v3, Lcom/bytedance/keva/Keva;->getBytes(Ljava/lang/String; [B)[B
    move-result-object v2
    return-object v2
.end method

.method public getFloat(java.lang.String  float)float
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v0, v2, v3, Lcom/bytedance/keva/Keva;->getFloat(Ljava/lang/String; F)F
    move-result v2
    return v2
.end method

.method public getInt(java.lang.String  int)int
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v0, v2, v3, Lcom/bytedance/keva/Keva;->getInt(Ljava/lang/String; I)I
    move-result v2
    return v2
.end method

.method public getLong(java.lang.String  long)long
    .registers 5
    # ins_size=4
    invoke-direct v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/keva/Keva;->getLong(Ljava/lang/String; J)J
    move-result-wide v2
    return-wide v2
.end method

.method public getString(java.lang.String  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v0, v2, v3, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public final getStringArray(java.lang.String  java.lang.String[])java.lang.String[]
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    invoke-virtual v0, v2, v3, Lcom/bytedance/keva/Keva;->getStringArray(Ljava/lang/String; [Ljava/lang/String;)[Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public getStringSet(java.lang.String  java.util.Set)java.util.Set
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v0, v2, v3, Lcom/bytedance/keva/Keva;->getStringSet(Ljava/lang/String; Ljava/util/Set;)Ljava/util/Set;
    move-result-object v2
    return-object v2
.end method

.method public onChanged(com.bytedance.keva.Keva  java.lang.String)void
    .registers 5
    # ins_size=3
    invoke-direct v2, Lcom/bytedance/trae/keva/KevaSharedPreference;->getListeners()Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;->getListeners()Ljava/util/HashSet;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00fh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;
    move-object v1, v2
    check-cast v1, Landroid/content/SharedPreferences;
    invoke-interface v0, v1, v4, Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;->onSharedPreferenceChanged(Landroid/content/SharedPreferences; Ljava/lang/String;)V
    goto -12h
    return-void 
.end method

.method public final putBytes(java.lang.String  byte[])void
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    invoke-virtual v0, v2, v3, Lcom/bytedance/keva/Keva;->storeBytes(Ljava/lang/String; [B)V
    return-void 
.end method

.method public final putStringArray(java.lang.String  java.lang.String[])void
    .registers 4
    # ins_size=3
    invoke-direct v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    invoke-virtual v0, v2, v3, Lcom/bytedance/keva/Keva;->storeStringArray(Ljava/lang/String; [Ljava/lang/String;)V
    return-void 
.end method

.method public registerOnSharedPreferenceChangeListener(android.content.SharedPreferences$OnSharedPreferenceChangeListener)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->getListeners()Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;->registerListener(Ljava/lang/Object;)V
    return-void 
.end method

.method public unregisterOnSharedPreferenceChangeListener(android.content.SharedPreferences$OnSharedPreferenceChangeListener)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/keva/KevaSharedPreference;->getListeners()Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/trae/keva/KevaSharedPreference$listeners$2$1;->unregisterListener(Ljava/lang/Object;)V
    return-void 
.end method
