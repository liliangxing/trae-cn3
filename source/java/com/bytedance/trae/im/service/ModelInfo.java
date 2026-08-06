package com.bytedance.trae.im.service;

import androidx.compose.ui.spatial.RectListKt;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import com.ss.ttm.utils.AVLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMEvent.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\bX\b\u0086\b\u0018\u00002\u00020\u0001B¿\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0001\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001f\u0010 J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010C\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010#J\u0010\u0010J\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010'J\u0010\u0010K\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010L\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010P\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010S\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0010\u0010T\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010U\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÆ\u0002\u0010Z\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010[J\u0013\u0010\\\u001a\u00020\u00052\b\u0010]\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010^\u001a\u00020\bHÖ\u0001J\t\u0010_\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\u0004\u0010#R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\"R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b-\u0010#R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b.\u0010#R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b/\u0010'R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b0\u0010'R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00102R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00102R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b5\u0010'R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00102R\u001a\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b8\u0010'R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u001a\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b:\u0010'R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u00102R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\"R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\"R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\"¨\u0006`"}, d2 = {"Lcom/bytedance/trae/im/service/ModelInfo;", "", "provider", "", "isPreset", "", "configName", "configSource", "", "modelName", "displayModelName", "ak", "baseUrl", "useRemoteService", "multimodal", "promptMaxTokens", "toolcallHistoryMaxTokens", "extraConfig", "abVersions", "persistMeta", "rawChatFunction", "promptSet", "contextWindowSizes", "maxTurn", "displayOptions", "maxTokens", "applicationConfig", "sk", "authType", "region", "sessionToken", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getProvider", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getConfigName", "getConfigSource", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getModelName", "getDisplayModelName", "getAk", "getBaseUrl", "getUseRemoteService", "getMultimodal", "getPromptMaxTokens", "getToolcallHistoryMaxTokens", "getExtraConfig", "()Ljava/lang/Object;", "getAbVersions", "getPersistMeta", "getRawChatFunction", "getPromptSet", "getContextWindowSizes", "getMaxTurn", "getDisplayOptions", "getMaxTokens", "getApplicationConfig", "getSk", "getAuthType", "getRegion", "getSessionToken", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/Integer;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/trae/im/service/ModelInfo;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ModelInfo {

    @SerializedName("ab_versions")
    private final Object abVersions;

    @SerializedName("ak")
    private final String ak;

    @SerializedName("application_config")
    private final Object applicationConfig;

    @SerializedName("auth_type")
    private final String authType;

    @SerializedName("base_url")
    private final String baseUrl;

    @SerializedName("config_name")
    private final String configName;

    @SerializedName("config_source")
    private final Integer configSource;

    @SerializedName("context_window_sizes")
    private final Object contextWindowSizes;

    @SerializedName("display_model_name")
    private final String displayModelName;

    @SerializedName("display_options")
    private final Object displayOptions;

    @SerializedName("extra_config")
    private final Object extraConfig;

    @SerializedName("is_preset")
    private final Boolean isPreset;

    @SerializedName("max_tokens")
    private final Integer maxTokens;

    @SerializedName("max_turn")
    private final Integer maxTurn;

    @SerializedName(StrategyConstants.MODEL_NAME)
    private final String modelName;

    @SerializedName("multimodal")
    private final Boolean multimodal;

    @SerializedName("persist_meta")
    private final Object persistMeta;

    @SerializedName("prompt_max_tokens")
    private final Integer promptMaxTokens;

    @SerializedName("prompt_set")
    private final Object promptSet;

    @SerializedName("provider")
    private final String provider;

    @SerializedName("raw_chat_function")
    private final Integer rawChatFunction;

    @SerializedName("region")
    private final String region;

    @SerializedName(StrategyConstants.SESSION_TOKEN)
    private final String sessionToken;

    @SerializedName("sk")
    private final String sk;

    @SerializedName("toolcall_history_max_tokens")
    private final Integer toolcallHistoryMaxTokens;

    @SerializedName("use_remote_service")
    private final Boolean useRemoteService;

    public ModelInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, RectListKt.Lower26Bits, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getProvider() {
        return this.provider;
    }

    /* renamed from: component10, reason: from getter */
    public final Boolean getMultimodal() {
        return this.multimodal;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getPromptMaxTokens() {
        return this.promptMaxTokens;
    }

    /* renamed from: component12, reason: from getter */
    public final Integer getToolcallHistoryMaxTokens() {
        return this.toolcallHistoryMaxTokens;
    }

    /* renamed from: component13, reason: from getter */
    public final Object getExtraConfig() {
        return this.extraConfig;
    }

    /* renamed from: component14, reason: from getter */
    public final Object getAbVersions() {
        return this.abVersions;
    }

    /* renamed from: component15, reason: from getter */
    public final Object getPersistMeta() {
        return this.persistMeta;
    }

    /* renamed from: component16, reason: from getter */
    public final Integer getRawChatFunction() {
        return this.rawChatFunction;
    }

    /* renamed from: component17, reason: from getter */
    public final Object getPromptSet() {
        return this.promptSet;
    }

    /* renamed from: component18, reason: from getter */
    public final Object getContextWindowSizes() {
        return this.contextWindowSizes;
    }

    /* renamed from: component19, reason: from getter */
    public final Integer getMaxTurn() {
        return this.maxTurn;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getIsPreset() {
        return this.isPreset;
    }

    /* renamed from: component20, reason: from getter */
    public final Object getDisplayOptions() {
        return this.displayOptions;
    }

    /* renamed from: component21, reason: from getter */
    public final Integer getMaxTokens() {
        return this.maxTokens;
    }

    /* renamed from: component22, reason: from getter */
    public final Object getApplicationConfig() {
        return this.applicationConfig;
    }

    /* renamed from: component23, reason: from getter */
    public final String getSk() {
        return this.sk;
    }

    /* renamed from: component24, reason: from getter */
    public final String getAuthType() {
        return this.authType;
    }

    /* renamed from: component25, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* renamed from: component26, reason: from getter */
    public final String getSessionToken() {
        return this.sessionToken;
    }

    /* renamed from: component3, reason: from getter */
    public final String getConfigName() {
        return this.configName;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getConfigSource() {
        return this.configSource;
    }

    /* renamed from: component5, reason: from getter */
    public final String getModelName() {
        return this.modelName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getDisplayModelName() {
        return this.displayModelName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getAk() {
        return this.ak;
    }

    /* renamed from: component8, reason: from getter */
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    /* renamed from: component9, reason: from getter */
    public final Boolean getUseRemoteService() {
        return this.useRemoteService;
    }

    public final ModelInfo copy(String provider, Boolean isPreset, String configName, Integer configSource, String modelName, String displayModelName, String ak, String baseUrl, Boolean useRemoteService, Boolean multimodal, Integer promptMaxTokens, Integer toolcallHistoryMaxTokens, Object extraConfig, Object abVersions, Object persistMeta, Integer rawChatFunction, Object promptSet, Object contextWindowSizes, Integer maxTurn, Object displayOptions, Integer maxTokens, Object applicationConfig, String sk, String authType, String region, String sessionToken) {
        return new ModelInfo(provider, isPreset, configName, configSource, modelName, displayModelName, ak, baseUrl, useRemoteService, multimodal, promptMaxTokens, toolcallHistoryMaxTokens, extraConfig, abVersions, persistMeta, rawChatFunction, promptSet, contextWindowSizes, maxTurn, displayOptions, maxTokens, applicationConfig, sk, authType, region, sessionToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelInfo)) {
            return false;
        }
        ModelInfo modelInfo = (ModelInfo) other;
        return Intrinsics.areEqual(this.provider, modelInfo.provider) && Intrinsics.areEqual(this.isPreset, modelInfo.isPreset) && Intrinsics.areEqual(this.configName, modelInfo.configName) && Intrinsics.areEqual(this.configSource, modelInfo.configSource) && Intrinsics.areEqual(this.modelName, modelInfo.modelName) && Intrinsics.areEqual(this.displayModelName, modelInfo.displayModelName) && Intrinsics.areEqual(this.ak, modelInfo.ak) && Intrinsics.areEqual(this.baseUrl, modelInfo.baseUrl) && Intrinsics.areEqual(this.useRemoteService, modelInfo.useRemoteService) && Intrinsics.areEqual(this.multimodal, modelInfo.multimodal) && Intrinsics.areEqual(this.promptMaxTokens, modelInfo.promptMaxTokens) && Intrinsics.areEqual(this.toolcallHistoryMaxTokens, modelInfo.toolcallHistoryMaxTokens) && Intrinsics.areEqual(this.extraConfig, modelInfo.extraConfig) && Intrinsics.areEqual(this.abVersions, modelInfo.abVersions) && Intrinsics.areEqual(this.persistMeta, modelInfo.persistMeta) && Intrinsics.areEqual(this.rawChatFunction, modelInfo.rawChatFunction) && Intrinsics.areEqual(this.promptSet, modelInfo.promptSet) && Intrinsics.areEqual(this.contextWindowSizes, modelInfo.contextWindowSizes) && Intrinsics.areEqual(this.maxTurn, modelInfo.maxTurn) && Intrinsics.areEqual(this.displayOptions, modelInfo.displayOptions) && Intrinsics.areEqual(this.maxTokens, modelInfo.maxTokens) && Intrinsics.areEqual(this.applicationConfig, modelInfo.applicationConfig) && Intrinsics.areEqual(this.sk, modelInfo.sk) && Intrinsics.areEqual(this.authType, modelInfo.authType) && Intrinsics.areEqual(this.region, modelInfo.region) && Intrinsics.areEqual(this.sessionToken, modelInfo.sessionToken);
    }

    public int hashCode() {
        String str = this.provider;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.isPreset;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.configName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.configSource;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.modelName;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.displayModelName;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.ak;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.baseUrl;
        int hashCode8 = (hashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool2 = this.useRemoteService;
        int hashCode9 = (hashCode8 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.multimodal;
        int hashCode10 = (hashCode9 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num2 = this.promptMaxTokens;
        int hashCode11 = (hashCode10 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.toolcallHistoryMaxTokens;
        int hashCode12 = (hashCode11 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Object obj = this.extraConfig;
        int hashCode13 = (hashCode12 + (obj == null ? 0 : obj.hashCode())) * 31;
        Object obj2 = this.abVersions;
        int hashCode14 = (hashCode13 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Object obj3 = this.persistMeta;
        int hashCode15 = (hashCode14 + (obj3 == null ? 0 : obj3.hashCode())) * 31;
        Integer num4 = this.rawChatFunction;
        int hashCode16 = (hashCode15 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Object obj4 = this.promptSet;
        int hashCode17 = (hashCode16 + (obj4 == null ? 0 : obj4.hashCode())) * 31;
        Object obj5 = this.contextWindowSizes;
        int hashCode18 = (hashCode17 + (obj5 == null ? 0 : obj5.hashCode())) * 31;
        Integer num5 = this.maxTurn;
        int hashCode19 = (hashCode18 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Object obj6 = this.displayOptions;
        int hashCode20 = (hashCode19 + (obj6 == null ? 0 : obj6.hashCode())) * 31;
        Integer num6 = this.maxTokens;
        int hashCode21 = (hashCode20 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Object obj7 = this.applicationConfig;
        int hashCode22 = (hashCode21 + (obj7 == null ? 0 : obj7.hashCode())) * 31;
        String str7 = this.sk;
        int hashCode23 = (hashCode22 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.authType;
        int hashCode24 = (hashCode23 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.region;
        int hashCode25 = (hashCode24 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.sessionToken;
        return hashCode25 + (str10 != null ? str10.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ModelInfo(provider=");
        sb.append(this.provider).append(", isPreset=").append(this.isPreset).append(", configName=").append(this.configName).append(", configSource=").append(this.configSource).append(", modelName=").append(this.modelName).append(", displayModelName=").append(this.displayModelName).append(", ak=").append(this.ak).append(", baseUrl=").append(this.baseUrl).append(", useRemoteService=").append(this.useRemoteService).append(", multimodal=").append(this.multimodal).append(", promptMaxTokens=").append(this.promptMaxTokens).append(", toolcallHistoryMaxTokens=");
        sb.append(this.toolcallHistoryMaxTokens).append(", extraConfig=").append(this.extraConfig).append(", abVersions=").append(this.abVersions).append(", persistMeta=").append(this.persistMeta).append(", rawChatFunction=").append(this.rawChatFunction).append(", promptSet=").append(this.promptSet).append(", contextWindowSizes=").append(this.contextWindowSizes).append(", maxTurn=").append(this.maxTurn).append(", displayOptions=").append(this.displayOptions).append(", maxTokens=").append(this.maxTokens).append(", applicationConfig=").append(this.applicationConfig).append(", sk=").append(this.sk);
        sb.append(", authType=").append(this.authType).append(", region=").append(this.region).append(", sessionToken=").append(this.sessionToken).append(')');
        return sb.toString();
    }

    public ModelInfo(String str, Boolean bool, String str2, Integer num, String str3, String str4, String str5, String str6, Boolean bool2, Boolean bool3, Integer num2, Integer num3, Object obj, Object obj2, Object obj3, Integer num4, Object obj4, Object obj5, Integer num5, Object obj6, Integer num6, Object obj7, String str7, String str8, String str9, String str10) {
        this.provider = str;
        this.isPreset = bool;
        this.configName = str2;
        this.configSource = num;
        this.modelName = str3;
        this.displayModelName = str4;
        this.ak = str5;
        this.baseUrl = str6;
        this.useRemoteService = bool2;
        this.multimodal = bool3;
        this.promptMaxTokens = num2;
        this.toolcallHistoryMaxTokens = num3;
        this.extraConfig = obj;
        this.abVersions = obj2;
        this.persistMeta = obj3;
        this.rawChatFunction = num4;
        this.promptSet = obj4;
        this.contextWindowSizes = obj5;
        this.maxTurn = num5;
        this.displayOptions = obj6;
        this.maxTokens = num6;
        this.applicationConfig = obj7;
        this.sk = str7;
        this.authType = str8;
        this.region = str9;
        this.sessionToken = str10;
    }

    public /* synthetic */ ModelInfo(String str, Boolean bool, String str2, Integer num, String str3, String str4, String str5, String str6, Boolean bool2, Boolean bool3, Integer num2, Integer num3, Object obj, Object obj2, Object obj3, Integer num4, Object obj4, Object obj5, Integer num5, Object obj6, Integer num6, Object obj7, String str7, String str8, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : bool2, (i & 512) != 0 ? null : bool3, (i & 1024) != 0 ? null : num2, (i & 2048) != 0 ? null : num3, (i & 4096) != 0 ? null : obj, (i & 8192) != 0 ? null : obj2, (i & 16384) != 0 ? null : obj3, (i & 32768) != 0 ? null : num4, (i & 65536) != 0 ? null : obj4, (i & 131072) != 0 ? null : obj5, (i & 262144) != 0 ? null : num5, (i & 524288) != 0 ? null : obj6, (i & 1048576) != 0 ? null : num6, (i & 2097152) != 0 ? null : obj7, (i & 4194304) != 0 ? null : str7, (i & 8388608) != 0 ? null : str8, (i & 16777216) != 0 ? null : str9, (i & AVLogger.LEVEL_LOG_INFO) != 0 ? null : str10);
    }

    public final String getProvider() {
        return this.provider;
    }

    public final Boolean isPreset() {
        return this.isPreset;
    }

    public final String getConfigName() {
        return this.configName;
    }

    public final Integer getConfigSource() {
        return this.configSource;
    }

    public final String getModelName() {
        return this.modelName;
    }

    public final String getDisplayModelName() {
        return this.displayModelName;
    }

    public final String getAk() {
        return this.ak;
    }

    public final String getBaseUrl() {
        return this.baseUrl;
    }

    public final Boolean getUseRemoteService() {
        return this.useRemoteService;
    }

    public final Boolean getMultimodal() {
        return this.multimodal;
    }

    public final Integer getPromptMaxTokens() {
        return this.promptMaxTokens;
    }

    public final Integer getToolcallHistoryMaxTokens() {
        return this.toolcallHistoryMaxTokens;
    }

    public final Object getExtraConfig() {
        return this.extraConfig;
    }

    public final Object getAbVersions() {
        return this.abVersions;
    }

    public final Object getPersistMeta() {
        return this.persistMeta;
    }

    public final Integer getRawChatFunction() {
        return this.rawChatFunction;
    }

    public final Object getPromptSet() {
        return this.promptSet;
    }

    public final Object getContextWindowSizes() {
        return this.contextWindowSizes;
    }

    public final Integer getMaxTurn() {
        return this.maxTurn;
    }

    public final Object getDisplayOptions() {
        return this.displayOptions;
    }

    public final Integer getMaxTokens() {
        return this.maxTokens;
    }

    public final Object getApplicationConfig() {
        return this.applicationConfig;
    }

    public final String getSk() {
        return this.sk;
    }

    public final String getAuthType() {
        return this.authType;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getSessionToken() {
        return this.sessionToken;
    }
}
