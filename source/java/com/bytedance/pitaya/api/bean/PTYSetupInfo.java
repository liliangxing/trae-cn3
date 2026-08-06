package com.bytedance.pitaya.api.bean;

import com.bytedance.pitaya.api.PTYCustomURLHost;
import com.bytedance.pitaya.api.PTYDIDCallback;
import com.bytedance.pitaya.api.PTYPackageFilterCallback;
import com.bytedance.pitaya.api.PTYPyBinderCallback;
import com.bytedance.pitaya.api.PTYSettingsCallback;
import com.bytedance.pitaya.api.PTYUIDCallback;
import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PTYSetupInfo.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001sB\u0007\b\u0017¢\u0006\u0002\u0010\u0002B¯\u0001\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001cB¥\u0001\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b¢\u0006\u0002\u0010\u001dB\u000f\b\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0002\u0010 R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\"\"\u0004\b8\u0010$R\u001a\u00109\u001a\u00020:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010.\"\u0004\bM\u00100R\u001a\u0010\u0018\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010.\"\u0004\bO\u00100R\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010.\"\u0004\bQ\u00100R\u001a\u0010\u0019\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010.\"\u0004\bR\u00100R\"\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\"\"\u0004\b^\u0010$R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010H\"\u0004\bd\u0010JR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020jX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010r¨\u0006t"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYSetupInfo;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "()V", CommonConstants.KEY_AID, "", "appVersion", "channel", "didCallback", "Lcom/bytedance/pitaya/api/PTYDIDCallback;", "uidCallback", "Lcom/bytedance/pitaya/api/PTYUIDCallback;", "packageFilterCallback", "Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;", "settingsCallback", "Lcom/bytedance/pitaya/api/PTYSettingsCallback;", "downloadConcurrency", "", "autoRequestUpdate", "", "idleDownloadEnable", "pluginVersion", "pyConcurrency", "pyBinder", "Lcom/bytedance/pitaya/api/PTYPyBinderCallback;", "flEnable", "isDebugMode", "customURLHost", "Lcom/bytedance/pitaya/api/PTYCustomURLHost;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/pitaya/api/PTYDIDCallback;Lcom/bytedance/pitaya/api/PTYUIDCallback;Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;Lcom/bytedance/pitaya/api/PTYSettingsCallback;IZZLjava/lang/String;ILcom/bytedance/pitaya/api/PTYPyBinderCallback;ZZLcom/bytedance/pitaya/api/PTYCustomURLHost;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/pitaya/api/PTYDIDCallback;Lcom/bytedance/pitaya/api/PTYUIDCallback;Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;Lcom/bytedance/pitaya/api/PTYSettingsCallback;IZLjava/lang/String;ILcom/bytedance/pitaya/api/PTYPyBinderCallback;ZZLcom/bytedance/pitaya/api/PTYCustomURLHost;)V", "builder", "Lcom/bytedance/pitaya/api/bean/PTYSetupInfo$Builder;", "(Lcom/bytedance/pitaya/api/bean/PTYSetupInfo$Builder;)V", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "appStartTime", "", "getAppStartTime", "()J", "setAppStartTime", "(J)V", "getAppVersion", "setAppVersion", "getAutoRequestUpdate", "()Z", "setAutoRequestUpdate", "(Z)V", "cepMode", "Lcom/bytedance/pitaya/api/bean/PTYCepMode;", "getCepMode", "()Lcom/bytedance/pitaya/api/bean/PTYCepMode;", "setCepMode", "(Lcom/bytedance/pitaya/api/bean/PTYCepMode;)V", "getChannel", "setChannel", "cleanStrategy", "Lcom/bytedance/pitaya/api/bean/PTYCleanStrategy;", "getCleanStrategy", "()Lcom/bytedance/pitaya/api/bean/PTYCleanStrategy;", "setCleanStrategy", "(Lcom/bytedance/pitaya/api/bean/PTYCleanStrategy;)V", "getCustomURLHost", "()Lcom/bytedance/pitaya/api/PTYCustomURLHost;", "setCustomURLHost", "(Lcom/bytedance/pitaya/api/PTYCustomURLHost;)V", "getDidCallback", "()Lcom/bytedance/pitaya/api/PTYDIDCallback;", "setDidCallback", "(Lcom/bytedance/pitaya/api/PTYDIDCallback;)V", "getDownloadConcurrency", "()I", "setDownloadConcurrency", "(I)V", "enableResourcePolicyCheck", "getEnableResourcePolicyCheck", "setEnableResourcePolicyCheck", "getFlEnable", "setFlEnable", "getIdleDownloadEnable", "setIdleDownloadEnable", "setDebugMode", "moduleList", "", "getModuleList", "()Ljava/util/List;", "setModuleList", "(Ljava/util/List;)V", "getPackageFilterCallback", "()Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;", "setPackageFilterCallback", "(Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;)V", "getPluginVersion", "setPluginVersion", "getPyBinder", "()Lcom/bytedance/pitaya/api/PTYPyBinderCallback;", "setPyBinder", "(Lcom/bytedance/pitaya/api/PTYPyBinderCallback;)V", "getPyConcurrency", "setPyConcurrency", "getSettingsCallback", "()Lcom/bytedance/pitaya/api/PTYSettingsCallback;", "setSettingsCallback", "(Lcom/bytedance/pitaya/api/PTYSettingsCallback;)V", "setupMode", "Lcom/bytedance/pitaya/api/bean/PTYSetupMode;", "getSetupMode", "()Lcom/bytedance/pitaya/api/bean/PTYSetupMode;", "setSetupMode", "(Lcom/bytedance/pitaya/api/bean/PTYSetupMode;)V", "getUidCallback", "()Lcom/bytedance/pitaya/api/PTYUIDCallback;", "setUidCallback", "(Lcom/bytedance/pitaya/api/PTYUIDCallback;)V", "Builder", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PTYSetupInfo implements ReflectionCall {
    private String aid;
    private long appStartTime;
    private String appVersion;
    private boolean autoRequestUpdate;
    private PTYCepMode cepMode;
    private String channel;
    private PTYCleanStrategy cleanStrategy;
    private PTYCustomURLHost customURLHost;
    private PTYDIDCallback didCallback;
    private int downloadConcurrency;
    private boolean enableResourcePolicyCheck;
    private boolean flEnable;
    private boolean idleDownloadEnable;
    private boolean isDebugMode;
    private List<String> moduleList;
    private PTYPackageFilterCallback packageFilterCallback;
    private String pluginVersion;
    private PTYPyBinderCallback pyBinder;
    private int pyConcurrency;
    private PTYSettingsCallback settingsCallback;
    private PTYSetupMode setupMode;
    private PTYUIDCallback uidCallback;

    public /* synthetic */ PTYSetupInfo(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private PTYSetupInfo(Builder builder) {
        this.aid = "";
        this.appVersion = "";
        this.channel = "";
        this.downloadConcurrency = 2;
        this.autoRequestUpdate = true;
        this.pyConcurrency = 2;
        this.setupMode = PTYSetupMode.Normal;
        this.cleanStrategy = PTYCleanStrategy.Normal;
        this.cepMode = PTYCepMode.Dependent;
        this.aid = builder.getAid();
        this.appVersion = builder.getAppVersion();
        this.channel = builder.getChannel();
        this.didCallback = builder.getDidCallback();
        this.uidCallback = builder.getUidCallback();
        this.packageFilterCallback = builder.getPackageFilterCallback();
        this.settingsCallback = builder.getSettingsCallback();
        this.downloadConcurrency = builder.getDownloadConcurrency();
        this.autoRequestUpdate = builder.getAutoRequestUpdate();
        this.idleDownloadEnable = builder.getIdleDownloadEnable();
        this.pluginVersion = builder.getPluginVersion();
        this.pyConcurrency = builder.getPyConcurrency();
        this.pyBinder = builder.getPyBinder();
        this.flEnable = builder.getFlEnable();
        this.isDebugMode = builder.getIsDebugMode();
        this.customURLHost = builder.getCustomURLHost();
        this.moduleList = builder.getModuleList();
        this.setupMode = builder.getSetupMode();
        this.cleanStrategy = builder.getCleanStrategy();
        this.cepMode = builder.getCepMode();
        this.appStartTime = builder.getAppStartTime();
        this.enableResourcePolicyCheck = builder.getEnableResourcePolicyCheck();
    }

    public final String getAid() {
        return this.aid;
    }

    public final void setAid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.aid = str;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final void setAppVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appVersion = str;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final void setChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channel = str;
    }

    public final PTYDIDCallback getDidCallback() {
        return this.didCallback;
    }

    public final void setDidCallback(PTYDIDCallback pTYDIDCallback) {
        this.didCallback = pTYDIDCallback;
    }

    public final PTYUIDCallback getUidCallback() {
        return this.uidCallback;
    }

    public final void setUidCallback(PTYUIDCallback pTYUIDCallback) {
        this.uidCallback = pTYUIDCallback;
    }

    public final PTYPackageFilterCallback getPackageFilterCallback() {
        return this.packageFilterCallback;
    }

    public final void setPackageFilterCallback(PTYPackageFilterCallback pTYPackageFilterCallback) {
        this.packageFilterCallback = pTYPackageFilterCallback;
    }

    public final PTYSettingsCallback getSettingsCallback() {
        return this.settingsCallback;
    }

    public final void setSettingsCallback(PTYSettingsCallback pTYSettingsCallback) {
        this.settingsCallback = pTYSettingsCallback;
    }

    public final int getDownloadConcurrency() {
        return this.downloadConcurrency;
    }

    public final void setDownloadConcurrency(int i) {
        this.downloadConcurrency = i;
    }

    public final boolean getAutoRequestUpdate() {
        return this.autoRequestUpdate;
    }

    public final void setAutoRequestUpdate(boolean z) {
        this.autoRequestUpdate = z;
    }

    public final boolean getIdleDownloadEnable() {
        return this.idleDownloadEnable;
    }

    public final void setIdleDownloadEnable(boolean z) {
        this.idleDownloadEnable = z;
    }

    public final String getPluginVersion() {
        return this.pluginVersion;
    }

    public final void setPluginVersion(String str) {
        this.pluginVersion = str;
    }

    public final int getPyConcurrency() {
        return this.pyConcurrency;
    }

    public final void setPyConcurrency(int i) {
        this.pyConcurrency = i;
    }

    public final PTYPyBinderCallback getPyBinder() {
        return this.pyBinder;
    }

    public final void setPyBinder(PTYPyBinderCallback pTYPyBinderCallback) {
        this.pyBinder = pTYPyBinderCallback;
    }

    public final boolean getFlEnable() {
        return this.flEnable;
    }

    public final void setFlEnable(boolean z) {
        this.flEnable = z;
    }

    /* renamed from: isDebugMode, reason: from getter */
    public final boolean getIsDebugMode() {
        return this.isDebugMode;
    }

    public final void setDebugMode(boolean z) {
        this.isDebugMode = z;
    }

    public final PTYCustomURLHost getCustomURLHost() {
        return this.customURLHost;
    }

    public final void setCustomURLHost(PTYCustomURLHost pTYCustomURLHost) {
        this.customURLHost = pTYCustomURLHost;
    }

    public final List<String> getModuleList() {
        return this.moduleList;
    }

    public final void setModuleList(List<String> list) {
        this.moduleList = list;
    }

    public final PTYSetupMode getSetupMode() {
        return this.setupMode;
    }

    public final void setSetupMode(PTYSetupMode pTYSetupMode) {
        Intrinsics.checkNotNullParameter(pTYSetupMode, "<set-?>");
        this.setupMode = pTYSetupMode;
    }

    public final PTYCleanStrategy getCleanStrategy() {
        return this.cleanStrategy;
    }

    public final void setCleanStrategy(PTYCleanStrategy pTYCleanStrategy) {
        Intrinsics.checkNotNullParameter(pTYCleanStrategy, "<set-?>");
        this.cleanStrategy = pTYCleanStrategy;
    }

    public final PTYCepMode getCepMode() {
        return this.cepMode;
    }

    public final void setCepMode(PTYCepMode pTYCepMode) {
        Intrinsics.checkNotNullParameter(pTYCepMode, "<set-?>");
        this.cepMode = pTYCepMode;
    }

    public final long getAppStartTime() {
        return this.appStartTime;
    }

    public final void setAppStartTime(long j) {
        this.appStartTime = j;
    }

    public final boolean getEnableResourcePolicyCheck() {
        return this.enableResourcePolicyCheck;
    }

    public final void setEnableResourcePolicyCheck(boolean z) {
        this.enableResourcePolicyCheck = z;
    }

    /* compiled from: PTYSetupInfo.kt */
    @Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010n\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010o\u001a\u00020pJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010q\u001a\u00020\"J\u0010\u0010'\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010(J\u0010\u0010-\u001a\u00020\u00002\b\u0010-\u001a\u0004\u0018\u00010.J\u000e\u00103\u001a\u00020\u00002\u0006\u00103\u001a\u000204J\u000e\u00109\u001a\u00020\u00002\u0006\u0010r\u001a\u00020\u0013J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0013J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u0013J\u000e\u0010B\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0013J\u0016\u0010D\u001a\u00020\u00002\u000e\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010EJ\u0010\u0010J\u001a\u00020\u00002\b\u0010J\u001a\u0004\u0018\u00010KJ\u0010\u0010P\u001a\u00020\u00002\b\u0010P\u001a\u0004\u0018\u00010\u0004J\u0010\u0010S\u001a\u00020\u00002\b\u0010S\u001a\u0004\u0018\u00010TJ\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010Y\u001a\u000204J\u0010\u0010\\\u001a\u00020\u00002\b\u0010\\\u001a\u0004\u0018\u00010]J\u000e\u0010b\u001a\u00020\u00002\u0006\u0010b\u001a\u00020cJ\u0010\u0010h\u001a\u00020\u00002\b\u0010h\u001a\u0004\u0018\u00010iR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001a\u0010!\u001a\u00020\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017R\u001a\u0010<\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0015\"\u0004\b>\u0010\u0017R\u001a\u0010?\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0015\"\u0004\bA\u0010\u0017R\u001a\u0010B\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0015\"\u0004\bC\u0010\u0017R\"\u0010D\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0006\"\u0004\bR\u0010\bR\u001c\u0010S\u001a\u0004\u0018\u00010TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00106\"\u0004\b[\u00108R\u001c\u0010\\\u001a\u0004\u0018\u00010]X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u001c\u0010h\u001a\u0004\u0018\u00010iX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m¨\u0006s"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYSetupInfo$Builder;", "", "()V", CommonConstants.KEY_AID, "", "getAid", "()Ljava/lang/String;", "setAid", "(Ljava/lang/String;)V", "appStartTime", "", "getAppStartTime", "()J", "setAppStartTime", "(J)V", "appVersion", "getAppVersion", "setAppVersion", "autoRequestUpdate", "", "getAutoRequestUpdate", "()Z", "setAutoRequestUpdate", "(Z)V", "cepMode", "Lcom/bytedance/pitaya/api/bean/PTYCepMode;", "getCepMode", "()Lcom/bytedance/pitaya/api/bean/PTYCepMode;", "setCepMode", "(Lcom/bytedance/pitaya/api/bean/PTYCepMode;)V", "channel", "getChannel", "setChannel", "cleanStrategy", "Lcom/bytedance/pitaya/api/bean/PTYCleanStrategy;", "getCleanStrategy", "()Lcom/bytedance/pitaya/api/bean/PTYCleanStrategy;", "setCleanStrategy", "(Lcom/bytedance/pitaya/api/bean/PTYCleanStrategy;)V", "customURLHost", "Lcom/bytedance/pitaya/api/PTYCustomURLHost;", "getCustomURLHost", "()Lcom/bytedance/pitaya/api/PTYCustomURLHost;", "setCustomURLHost", "(Lcom/bytedance/pitaya/api/PTYCustomURLHost;)V", "didCallback", "Lcom/bytedance/pitaya/api/PTYDIDCallback;", "getDidCallback", "()Lcom/bytedance/pitaya/api/PTYDIDCallback;", "setDidCallback", "(Lcom/bytedance/pitaya/api/PTYDIDCallback;)V", "downloadConcurrency", "", "getDownloadConcurrency", "()I", "setDownloadConcurrency", "(I)V", "enableResourcePolicyCheck", "getEnableResourcePolicyCheck", "setEnableResourcePolicyCheck", "flEnable", "getFlEnable", "setFlEnable", "idleDownloadEnable", "getIdleDownloadEnable", "setIdleDownloadEnable", "isDebugMode", "setDebugMode", "moduleList", "", "getModuleList", "()Ljava/util/List;", "setModuleList", "(Ljava/util/List;)V", "packageFilterCallback", "Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;", "getPackageFilterCallback", "()Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;", "setPackageFilterCallback", "(Lcom/bytedance/pitaya/api/PTYPackageFilterCallback;)V", "pluginVersion", "getPluginVersion", "setPluginVersion", "pyBinder", "Lcom/bytedance/pitaya/api/PTYPyBinderCallback;", "getPyBinder", "()Lcom/bytedance/pitaya/api/PTYPyBinderCallback;", "setPyBinder", "(Lcom/bytedance/pitaya/api/PTYPyBinderCallback;)V", "pyConcurrency", "getPyConcurrency", "setPyConcurrency", "settingsCallback", "Lcom/bytedance/pitaya/api/PTYSettingsCallback;", "getSettingsCallback", "()Lcom/bytedance/pitaya/api/PTYSettingsCallback;", "setSettingsCallback", "(Lcom/bytedance/pitaya/api/PTYSettingsCallback;)V", "setupMode", "Lcom/bytedance/pitaya/api/bean/PTYSetupMode;", "getSetupMode", "()Lcom/bytedance/pitaya/api/bean/PTYSetupMode;", "setSetupMode", "(Lcom/bytedance/pitaya/api/bean/PTYSetupMode;)V", "uidCallback", "Lcom/bytedance/pitaya/api/PTYUIDCallback;", "getUidCallback", "()Lcom/bytedance/pitaya/api/PTYUIDCallback;", "setUidCallback", "(Lcom/bytedance/pitaya/api/PTYUIDCallback;)V", "startTime", "build", "Lcom/bytedance/pitaya/api/bean/PTYSetupInfo;", "strategy", "enable", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Builder {
        private long appStartTime;
        private PTYCustomURLHost customURLHost;
        private PTYDIDCallback didCallback;
        private boolean enableResourcePolicyCheck;
        private boolean flEnable;
        private boolean idleDownloadEnable;
        private boolean isDebugMode;
        private List<String> moduleList;
        private PTYPackageFilterCallback packageFilterCallback;
        private String pluginVersion;
        private PTYPyBinderCallback pyBinder;
        private PTYSettingsCallback settingsCallback;
        private PTYUIDCallback uidCallback;
        private String aid = "";
        private String appVersion = "";
        private String channel = "";
        private int downloadConcurrency = 2;
        private boolean autoRequestUpdate = true;
        private int pyConcurrency = 2;
        private PTYSetupMode setupMode = PTYSetupMode.Normal;
        private PTYCleanStrategy cleanStrategy = PTYCleanStrategy.Normal;
        private PTYCepMode cepMode = PTYCepMode.Dependent;

        public final String getAid() {
            return this.aid;
        }

        public final void setAid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.aid = str;
        }

        public final String getAppVersion() {
            return this.appVersion;
        }

        public final void setAppVersion(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.appVersion = str;
        }

        public final String getChannel() {
            return this.channel;
        }

        public final void setChannel(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.channel = str;
        }

        public final PTYDIDCallback getDidCallback() {
            return this.didCallback;
        }

        public final void setDidCallback(PTYDIDCallback pTYDIDCallback) {
            this.didCallback = pTYDIDCallback;
        }

        public final PTYUIDCallback getUidCallback() {
            return this.uidCallback;
        }

        public final void setUidCallback(PTYUIDCallback pTYUIDCallback) {
            this.uidCallback = pTYUIDCallback;
        }

        public final PTYPackageFilterCallback getPackageFilterCallback() {
            return this.packageFilterCallback;
        }

        public final void setPackageFilterCallback(PTYPackageFilterCallback pTYPackageFilterCallback) {
            this.packageFilterCallback = pTYPackageFilterCallback;
        }

        public final PTYSettingsCallback getSettingsCallback() {
            return this.settingsCallback;
        }

        public final void setSettingsCallback(PTYSettingsCallback pTYSettingsCallback) {
            this.settingsCallback = pTYSettingsCallback;
        }

        public final int getDownloadConcurrency() {
            return this.downloadConcurrency;
        }

        public final void setDownloadConcurrency(int i) {
            this.downloadConcurrency = i;
        }

        public final boolean getAutoRequestUpdate() {
            return this.autoRequestUpdate;
        }

        public final void setAutoRequestUpdate(boolean z) {
            this.autoRequestUpdate = z;
        }

        public final boolean getIdleDownloadEnable() {
            return this.idleDownloadEnable;
        }

        public final void setIdleDownloadEnable(boolean z) {
            this.idleDownloadEnable = z;
        }

        public final String getPluginVersion() {
            return this.pluginVersion;
        }

        public final void setPluginVersion(String str) {
            this.pluginVersion = str;
        }

        public final int getPyConcurrency() {
            return this.pyConcurrency;
        }

        public final void setPyConcurrency(int i) {
            this.pyConcurrency = i;
        }

        public final PTYPyBinderCallback getPyBinder() {
            return this.pyBinder;
        }

        public final void setPyBinder(PTYPyBinderCallback pTYPyBinderCallback) {
            this.pyBinder = pTYPyBinderCallback;
        }

        public final boolean getFlEnable() {
            return this.flEnable;
        }

        public final void setFlEnable(boolean z) {
            this.flEnable = z;
        }

        /* renamed from: isDebugMode, reason: from getter */
        public final boolean getIsDebugMode() {
            return this.isDebugMode;
        }

        public final void setDebugMode(boolean z) {
            this.isDebugMode = z;
        }

        public final PTYCustomURLHost getCustomURLHost() {
            return this.customURLHost;
        }

        public final void setCustomURLHost(PTYCustomURLHost pTYCustomURLHost) {
            this.customURLHost = pTYCustomURLHost;
        }

        public final List<String> getModuleList() {
            return this.moduleList;
        }

        public final void setModuleList(List<String> list) {
            this.moduleList = list;
        }

        public final PTYSetupMode getSetupMode() {
            return this.setupMode;
        }

        public final void setSetupMode(PTYSetupMode pTYSetupMode) {
            Intrinsics.checkNotNullParameter(pTYSetupMode, "<set-?>");
            this.setupMode = pTYSetupMode;
        }

        public final PTYCleanStrategy getCleanStrategy() {
            return this.cleanStrategy;
        }

        public final void setCleanStrategy(PTYCleanStrategy pTYCleanStrategy) {
            Intrinsics.checkNotNullParameter(pTYCleanStrategy, "<set-?>");
            this.cleanStrategy = pTYCleanStrategy;
        }

        public final PTYCepMode getCepMode() {
            return this.cepMode;
        }

        public final void setCepMode(PTYCepMode pTYCepMode) {
            Intrinsics.checkNotNullParameter(pTYCepMode, "<set-?>");
            this.cepMode = pTYCepMode;
        }

        public final long getAppStartTime() {
            return this.appStartTime;
        }

        public final void setAppStartTime(long j) {
            this.appStartTime = j;
        }

        public final boolean getEnableResourcePolicyCheck() {
            return this.enableResourcePolicyCheck;
        }

        public final void setEnableResourcePolicyCheck(boolean z) {
            this.enableResourcePolicyCheck = z;
        }

        public final Builder aid(String aid) {
            Intrinsics.checkNotNullParameter(aid, CommonConstants.KEY_AID);
            this.aid = aid;
            return this;
        }

        public final Builder appVersion(String appVersion) {
            Intrinsics.checkNotNullParameter(appVersion, "appVersion");
            this.appVersion = appVersion;
            return this;
        }

        public final Builder channel(String channel) {
            Intrinsics.checkNotNullParameter(channel, "channel");
            this.channel = channel;
            return this;
        }

        public final Builder didCallback(PTYDIDCallback didCallback) {
            this.didCallback = didCallback;
            return this;
        }

        public final Builder uidCallback(PTYUIDCallback uidCallback) {
            this.uidCallback = uidCallback;
            return this;
        }

        public final Builder packageFilterCallback(PTYPackageFilterCallback packageFilterCallback) {
            this.packageFilterCallback = packageFilterCallback;
            return this;
        }

        public final Builder settingsCallback(PTYSettingsCallback settingsCallback) {
            this.settingsCallback = settingsCallback;
            return this;
        }

        public final Builder downloadConcurrency(int downloadConcurrency) {
            this.downloadConcurrency = downloadConcurrency;
            return this;
        }

        public final Builder autoRequestUpdate(boolean autoRequestUpdate) {
            this.autoRequestUpdate = autoRequestUpdate;
            return this;
        }

        public final Builder idleDownloadEnable(boolean idleDownloadEnable) {
            this.idleDownloadEnable = idleDownloadEnable;
            return this;
        }

        public final Builder pluginVersion(String pluginVersion) {
            this.pluginVersion = pluginVersion;
            return this;
        }

        public final Builder pyConcurrency(int pyConcurrency) {
            this.pyConcurrency = pyConcurrency;
            return this;
        }

        public final Builder pyBinder(PTYPyBinderCallback pyBinder) {
            this.pyBinder = pyBinder;
            return this;
        }

        public final Builder flEnable(boolean flEnable) {
            this.flEnable = flEnable;
            return this;
        }

        public final Builder isDebugMode(boolean isDebugMode) {
            this.isDebugMode = isDebugMode;
            return this;
        }

        public final Builder customURLHost(PTYCustomURLHost customURLHost) {
            this.customURLHost = customURLHost;
            return this;
        }

        public final Builder moduleList(List<String> moduleList) {
            this.moduleList = moduleList;
            return this;
        }

        public final Builder setupMode(PTYSetupMode setupMode) {
            Intrinsics.checkNotNullParameter(setupMode, "setupMode");
            this.setupMode = setupMode;
            return this;
        }

        public final Builder cleanStrategy(PTYCleanStrategy strategy) {
            Intrinsics.checkNotNullParameter(strategy, "strategy");
            this.cleanStrategy = strategy;
            return this;
        }

        public final Builder cepMode(PTYCepMode cepMode) {
            Intrinsics.checkNotNullParameter(cepMode, "cepMode");
            this.cepMode = cepMode;
            return this;
        }

        public final Builder appStartTime(long startTime) {
            this.appStartTime = startTime;
            return this;
        }

        public final Builder enableResourcePolicyCheck(boolean enable) {
            this.enableResourcePolicyCheck = enable;
            return this;
        }

        public final PTYSetupInfo build() {
            return new PTYSetupInfo(this, null);
        }
    }

    @Deprecated(message = "Use PTYSetupInfo.Builder instead")
    public PTYSetupInfo() {
        this(new Builder());
    }

    public /* synthetic */ PTYSetupInfo(String str, String str2, String str3, PTYDIDCallback pTYDIDCallback, PTYUIDCallback pTYUIDCallback, PTYPackageFilterCallback pTYPackageFilterCallback, PTYSettingsCallback pTYSettingsCallback, int i, boolean z, boolean z2, String str4, int i2, PTYPyBinderCallback pTYPyBinderCallback, boolean z3, boolean z4, PTYCustomURLHost pTYCustomURLHost, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i3 & 8) != 0 ? null : pTYDIDCallback, (i3 & 16) != 0 ? null : pTYUIDCallback, (i3 & 32) != 0 ? null : pTYPackageFilterCallback, (i3 & 64) != 0 ? null : pTYSettingsCallback, (i3 & 128) != 0 ? 2 : i, (i3 & 256) != 0 ? true : z, (i3 & 512) != 0 ? false : z2, (i3 & 1024) != 0 ? null : str4, (i3 & 2048) != 0 ? 2 : i2, (i3 & 4096) != 0 ? null : pTYPyBinderCallback, (i3 & 8192) != 0 ? false : z3, (i3 & 16384) != 0 ? false : z4, (i3 & 32768) != 0 ? null : pTYCustomURLHost);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use PTYSetupInfo.Builder instead")
    public PTYSetupInfo(String str, String str2, String str3, PTYDIDCallback pTYDIDCallback, PTYUIDCallback pTYUIDCallback, PTYPackageFilterCallback pTYPackageFilterCallback, PTYSettingsCallback pTYSettingsCallback, int i, boolean z, boolean z2, String str4, int i2, PTYPyBinderCallback pTYPyBinderCallback, boolean z3, boolean z4, PTYCustomURLHost pTYCustomURLHost) {
        this(new Builder());
        Intrinsics.checkNotNullParameter(str, CommonConstants.KEY_AID);
        Intrinsics.checkNotNullParameter(str2, "appVersion");
        Intrinsics.checkNotNullParameter(str3, "channel");
        this.aid = str;
        this.appVersion = str2;
        this.channel = str3;
        this.didCallback = pTYDIDCallback;
        this.uidCallback = pTYUIDCallback;
        this.packageFilterCallback = pTYPackageFilterCallback;
        this.settingsCallback = pTYSettingsCallback;
        this.downloadConcurrency = i;
        this.autoRequestUpdate = z;
        this.idleDownloadEnable = z2;
        this.pluginVersion = str4;
        this.pyConcurrency = i2;
        this.pyBinder = pTYPyBinderCallback;
        this.flEnable = z3;
        this.isDebugMode = z4;
        this.customURLHost = pTYCustomURLHost;
    }

    public /* synthetic */ PTYSetupInfo(String str, String str2, String str3, PTYDIDCallback pTYDIDCallback, PTYUIDCallback pTYUIDCallback, PTYPackageFilterCallback pTYPackageFilterCallback, PTYSettingsCallback pTYSettingsCallback, int i, boolean z, String str4, int i2, PTYPyBinderCallback pTYPyBinderCallback, boolean z2, boolean z3, PTYCustomURLHost pTYCustomURLHost, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i3 & 8) != 0 ? null : pTYDIDCallback, (i3 & 16) != 0 ? null : pTYUIDCallback, (i3 & 32) != 0 ? null : pTYPackageFilterCallback, (i3 & 64) != 0 ? null : pTYSettingsCallback, (i3 & 128) != 0 ? 2 : i, (i3 & 256) != 0 ? true : z, (i3 & 512) != 0 ? null : str4, (i3 & 1024) != 0 ? 2 : i2, (i3 & 2048) != 0 ? null : pTYPyBinderCallback, (i3 & 4096) != 0 ? false : z2, (i3 & 8192) != 0 ? false : z3, (i3 & 16384) != 0 ? null : pTYCustomURLHost);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use PTYSetupInfo.Builder instead")
    public PTYSetupInfo(String str, String str2, String str3, PTYDIDCallback pTYDIDCallback, PTYUIDCallback pTYUIDCallback, PTYPackageFilterCallback pTYPackageFilterCallback, PTYSettingsCallback pTYSettingsCallback, int i, boolean z, String str4, int i2, PTYPyBinderCallback pTYPyBinderCallback, boolean z2, boolean z3, PTYCustomURLHost pTYCustomURLHost) {
        this(new Builder());
        Intrinsics.checkNotNullParameter(str, CommonConstants.KEY_AID);
        Intrinsics.checkNotNullParameter(str2, "appVersion");
        Intrinsics.checkNotNullParameter(str3, "channel");
        this.aid = str;
        this.appVersion = str2;
        this.channel = str3;
        this.didCallback = pTYDIDCallback;
        this.uidCallback = pTYUIDCallback;
        this.packageFilterCallback = pTYPackageFilterCallback;
        this.settingsCallback = pTYSettingsCallback;
        this.downloadConcurrency = i;
        this.autoRequestUpdate = z;
        this.pluginVersion = str4;
        this.pyConcurrency = i2;
        this.pyBinder = pTYPyBinderCallback;
        this.flEnable = z2;
        this.isDebugMode = z3;
        this.customURLHost = pTYCustomURLHost;
    }
}
