# Decompiled TRAE business class
# Source DEX: classes.dex
.class final Lcom/bytedance/trae/keva/KevaSharedPreference$KevaPrefEdit;
.super Ljava/lang/Object;
.source "KevaSharedPreference.kt"

.implements Landroid/content/SharedPreferences$Editor;

.field private final sp:Lcom/bytedance/keva/Keva;


.method public constructor <init>(com.bytedance.keva.Keva)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, sp
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$KevaPrefEdit;->sp Lcom/bytedance/keva/Keva;
    return-void 
.end method

.method public apply()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public clear()android.content.SharedPreferences$Editor
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$KevaPrefEdit;->sp Lcom/bytedance/keva/Keva;
    invoke-virtual v0, Lcom/bytedance/keva/Keva;->clear()V
    move-object v0, v1
    check-cast v0, Landroid/content/SharedPreferences$Editor;
    return-object v0
.end method

.method public commit()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public putBoolean(java.lang.String  boolean)android.content.SharedPreferences$Editor
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$KevaPrefEdit;->sp Lcom/bytedance/keva/Keva;
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v0, v2, v3, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    move-object v2, v1
    check-cast v2, Landroid/content/SharedPreferences$Editor;
    return-object v2
.end method

.method public putFloat(java.lang.String  float)android.content.SharedPreferences$Editor
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$KevaPrefEdit;->sp Lcom/bytedance/keva/Keva;
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v0, v2, v3, Lcom/bytedance/keva/Keva;->storeFloat(Ljava/lang/String; F)V
    move-object v2, v1
    check-cast v2, Landroid/content/SharedPreferences$Editor;
    return-object v2
.end method

.method public putInt(java.lang.String  int)android.content.SharedPreferences$Editor
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$KevaPrefEdit;->sp Lcom/bytedance/keva/Keva;
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v0, v2, v3, Lcom/bytedance/keva/Keva;->storeInt(Ljava/lang/String; I)V
    move-object v2, v1
    check-cast v2, Landroid/content/SharedPreferences$Editor;
    return-object v2
.end method

.method public putLong(java.lang.String  long)android.content.SharedPreferences$Editor
    .registers 5
    # ins_size=4
    iget-object v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$KevaPrefEdit;->sp Lcom/bytedance/keva/Keva;
    if-nez v2, +004h
    const-string v2, ""
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/keva/Keva;->storeLong(Ljava/lang/String; J)V
    move-object v2, v1
    check-cast v2, Landroid/content/SharedPreferences$Editor;
    return-object v2
.end method

.method public putString(java.lang.String  java.lang.String)android.content.SharedPreferences$Editor
    .registers 5
    # ins_size=3
    iget-object v0, v2, Lcom/bytedance/trae/keva/KevaSharedPreference$KevaPrefEdit;->sp Lcom/bytedance/keva/Keva;
    const-string v1, ""
    if-nez v3, +003h
    move-object v3, v1
    if-nez v4, +003h
    move-object v4, v1
    invoke-virtual v0, v3, v4, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    move-object v3, v2
    check-cast v3, Landroid/content/SharedPreferences$Editor;
    return-object v3
.end method

.method public putStringSet(java.lang.String  java.util.Set)android.content.SharedPreferences$Editor
    .registers 4
    # ins_size=3
    iget-object v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$KevaPrefEdit;->sp Lcom/bytedance/keva/Keva;
    if-nez v2, +004h
    const-string v2, ""
    if-nez v3, +009h
    new-instance v3, Ljava/util/LinkedHashSet;
    invoke-direct v3, Ljava/util/LinkedHashSet;-><init>()V
    check-cast v3, Ljava/util/Set;
    invoke-virtual v0, v2, v3, Lcom/bytedance/keva/Keva;->storeStringSet(Ljava/lang/String; Ljava/util/Set;)V
    move-object v2, v1
    check-cast v2, Landroid/content/SharedPreferences$Editor;
    return-object v2
.end method

.method public remove(java.lang.String)android.content.SharedPreferences$Editor
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/keva/KevaSharedPreference$KevaPrefEdit;->sp Lcom/bytedance/keva/Keva;
    invoke-virtual v0, v2, Lcom/bytedance/keva/Keva;->erase(Ljava/lang/String;)V
    move-object v2, v1
    check-cast v2, Landroid/content/SharedPreferences$Editor;
    return-object v2
.end method
