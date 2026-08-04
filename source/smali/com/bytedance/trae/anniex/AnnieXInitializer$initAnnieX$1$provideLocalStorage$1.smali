# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1$provideLocalStorage$1;
.super Ljava/lang/Object;
.source "AnnieXInitializer.kt"

.implements Lcom/bytedance/sdk/xbridge/cn/auth/ILocalStorage;

.field final synthetic this$0:Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;


.method constructor <init>(com.bytedance.trae.anniex.AnnieXInitializer$initAnnieX$1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1$provideLocalStorage$1;->this$0 Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public read(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    const-string v0, "key"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1$provideLocalStorage$1;->this$0 Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;
    invoke-static v0, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;->access$getPrefs(Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;)Landroid/content/SharedPreferences;
    move-result-object v0
    const/4 v1, 0
    invoke-interface v0, v3, v1, Landroid/content/SharedPreferences;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public readObject(java.lang.String)org.json.JSONObject
    .registers 4
    # ins_size=2
    const-string v0, "key"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1$provideLocalStorage$1;->this$0 Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;
    invoke-static v0, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;->access$getPrefs(Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;)Landroid/content/SharedPreferences;
    move-result-object v0
    const/4 v1, 0
    invoke-interface v0, v3, v1, Landroid/content/SharedPreferences;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    return-object v1
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, v3, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    move-object v1, v0
    return-object v1
    :try_start_0x13
.end method

.method public write(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1$provideLocalStorage$1;->this$0 Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;
    invoke-static v0, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;->access$getPrefs(Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;)Landroid/content/SharedPreferences;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    invoke-interface v0, v2, v3, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String; Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v2
    invoke-interface v2, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method

.method public writeObject(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1$provideLocalStorage$1;->this$0 Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;
    invoke-static v0, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;->access$getPrefs(Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;)Landroid/content/SharedPreferences;
    move-result-object v0
    invoke-interface v0, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;
    move-result-object v0
    invoke-virtual v3, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-interface v0, v2, v3, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String; Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    move-result-object v2
    invoke-interface v2, Landroid/content/SharedPreferences$Editor;->apply()V
    return-void 
.end method
