package com.bytedance.ies.bullet.core;

import com.bytedance.ies.bullet.base.constants.GlobalPropertiesConstants;
import com.bytedance.ies.bullet.core.kit.Fallback;
import com.bytedance.ies.bullet.p003ui.common.IBulletViewProvider;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.IViewService;
import com.bytedance.ies.bullet.service.monitor.task.LoaderTasksPerfMetric;
import com.lynx.tasm.TemplateData;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\u001a\u0010,\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\u001a\u0010.\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010'\"\u0004\b/\u0010)R\u001e\u00100\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u0010\n\u0002\u00104\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00105\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010'\"\u0004\b6\u0010)R\u001a\u00107\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R\u001a\u00109\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010'\"\u0004\b:\u0010)R\u001a\u0010;\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR&\u0010L\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bN\u0010\u0002\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u001c\u0010S\u001a\u0004\u0018\u00010TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010=\"\u0004\b[\u0010?R\u001c\u0010\\\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010=\"\u0004\b^\u0010?¨\u0006_"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletContainerContext;", "", "()V", "annieXGlobalProps", "", "", "getAnnieXGlobalProps", "()Ljava/util/Map;", "setAnnieXGlobalProps", "(Ljava/util/Map;)V", "annieXTemplateData", "Lcom/lynx/tasm/TemplateData;", "getAnnieXTemplateData", "()Lcom/lynx/tasm/TemplateData;", "setAnnieXTemplateData", "(Lcom/lynx/tasm/TemplateData;)V", "cacheType", "Lcom/bytedance/ies/bullet/service/base/CacheType;", "getCacheType", "()Lcom/bytedance/ies/bullet/service/base/CacheType;", "setCacheType", "(Lcom/bytedance/ies/bullet/service/base/CacheType;)V", "cpuMemoryPerfMetric", "getCpuMemoryPerfMetric", "()Ljava/lang/Object;", "setCpuMemoryPerfMetric", "(Ljava/lang/Object;)V", "fallbackInfo", "Lcom/bytedance/ies/bullet/core/kit/Fallback;", "getFallbackInfo", "()Lcom/bytedance/ies/bullet/core/kit/Fallback;", "setFallbackInfo", "(Lcom/bytedance/ies/bullet/core/kit/Fallback;)V", "globalProps", "getGlobalProps", "setGlobalProps", "hasErrorView", "", "getHasErrorView", "()Z", "setHasErrorView", "(Z)V", "isAnniePro", "setAnniePro", "isFirstLoad", "setFirstLoad", GlobalPropertiesConstants.IS_PRE_CREATE, "setPreCreate", "isPreload", "()Ljava/lang/Boolean;", "setPreload", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isRelease", "setRelease", "isReload", "setReload", "isVisibleAndSurvival", "setVisibleAndSurvival", "loadStatus", "getLoadStatus", "()Ljava/lang/String;", "setLoadStatus", "(Ljava/lang/String;)V", "loaderTaskPerfMetric", "Lcom/bytedance/ies/bullet/service/monitor/task/LoaderTasksPerfMetric;", "getLoaderTaskPerfMetric", "()Lcom/bytedance/ies/bullet/service/monitor/task/LoaderTasksPerfMetric;", "setLoaderTaskPerfMetric", "(Lcom/bytedance/ies/bullet/service/monitor/task/LoaderTasksPerfMetric;)V", "ssrConfig", "Lcom/bytedance/ies/bullet/core/SSRConfig;", "getSsrConfig", "()Lcom/bytedance/ies/bullet/core/SSRConfig;", "setSsrConfig", "(Lcom/bytedance/ies/bullet/core/SSRConfig;)V", "titleBarProvider", "Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBarProvider;", "getTitleBarProvider$annotations", "getTitleBarProvider", "()Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBarProvider;", "setTitleBarProvider", "(Lcom/bytedance/ies/bullet/ui/common/IBulletViewProvider$IBulletTitleBarProvider;)V", "viewService", "Lcom/bytedance/ies/bullet/service/base/IViewService;", "getViewService", "()Lcom/bytedance/ies/bullet/service/base/IViewService;", "setViewService", "(Lcom/bytedance/ies/bullet/service/base/IViewService;)V", "viewType", "getViewType", "setViewType", "visibleState", "getVisibleState", "setVisibleState", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BulletContainerContext {
    private Map<String, ? extends Object> annieXGlobalProps;
    private TemplateData annieXTemplateData;
    private CacheType cacheType;
    private Object cpuMemoryPerfMetric;
    private Fallback fallbackInfo;
    private Map<String, ? extends Object> globalProps;
    private boolean hasErrorView;
    private boolean isAnniePro;
    private boolean isFirstLoad;
    private boolean isPreCreate;
    private boolean isRelease;
    private boolean isReload;
    private boolean isVisibleAndSurvival;
    private SSRConfig ssrConfig;
    private IBulletViewProvider.IBulletTitleBarProvider titleBarProvider;
    private IViewService viewService;
    private String visibleState;
    private Boolean isPreload = false;
    private String viewType = "card";
    private LoaderTasksPerfMetric loaderTaskPerfMetric = new LoaderTasksPerfMetric();
    private String loadStatus = "cancel";

    @Deprecated(message = "使用 viewService 代替")
    public static /* synthetic */ void getTitleBarProvider$annotations() {
    }

    /* renamed from: isReload, reason: from getter */
    public final boolean getIsReload() {
        return this.isReload;
    }

    public final void setReload(boolean z) {
        this.isReload = z;
    }

    /* renamed from: isPreload, reason: from getter */
    public final Boolean getIsPreload() {
        return this.isPreload;
    }

    public final void setPreload(Boolean bool) {
        this.isPreload = bool;
    }

    /* renamed from: isPreCreate, reason: from getter */
    public final boolean getIsPreCreate() {
        return this.isPreCreate;
    }

    public final void setPreCreate(boolean z) {
        this.isPreCreate = z;
    }

    /* renamed from: isFirstLoad, reason: from getter */
    public final boolean getIsFirstLoad() {
        return this.isFirstLoad;
    }

    public final void setFirstLoad(boolean z) {
        this.isFirstLoad = z;
    }

    public final CacheType getCacheType() {
        return this.cacheType;
    }

    public final void setCacheType(CacheType cacheType) {
        this.cacheType = cacheType;
    }

    /* renamed from: isAnniePro, reason: from getter */
    public final boolean getIsAnniePro() {
        return this.isAnniePro;
    }

    public final void setAnniePro(boolean z) {
        this.isAnniePro = z;
    }

    public final Fallback getFallbackInfo() {
        return this.fallbackInfo;
    }

    public final void setFallbackInfo(Fallback fallback) {
        this.fallbackInfo = fallback;
    }

    public final String getVisibleState() {
        return this.visibleState;
    }

    public final void setVisibleState(String str) {
        this.visibleState = str;
    }

    public final Map<String, Object> getGlobalProps() {
        return this.globalProps;
    }

    public final void setGlobalProps(Map<String, ? extends Object> map) {
        this.globalProps = map;
    }

    public final Map<String, Object> getAnnieXGlobalProps() {
        return this.annieXGlobalProps;
    }

    public final void setAnnieXGlobalProps(Map<String, ? extends Object> map) {
        this.annieXGlobalProps = map;
    }

    public final TemplateData getAnnieXTemplateData() {
        return this.annieXTemplateData;
    }

    public final void setAnnieXTemplateData(TemplateData templateData) {
        this.annieXTemplateData = templateData;
    }

    public final Object getCpuMemoryPerfMetric() {
        return this.cpuMemoryPerfMetric;
    }

    public final void setCpuMemoryPerfMetric(Object obj) {
        this.cpuMemoryPerfMetric = obj;
    }

    public final String getViewType() {
        return this.viewType;
    }

    public final void setViewType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.viewType = str;
    }

    public final IBulletViewProvider.IBulletTitleBarProvider getTitleBarProvider() {
        return this.titleBarProvider;
    }

    public final void setTitleBarProvider(IBulletViewProvider.IBulletTitleBarProvider iBulletTitleBarProvider) {
        this.titleBarProvider = iBulletTitleBarProvider;
    }

    public final IViewService getViewService() {
        return this.viewService;
    }

    public final void setViewService(IViewService iViewService) {
        this.viewService = iViewService;
    }

    public final LoaderTasksPerfMetric getLoaderTaskPerfMetric() {
        return this.loaderTaskPerfMetric;
    }

    public final void setLoaderTaskPerfMetric(LoaderTasksPerfMetric loaderTasksPerfMetric) {
        Intrinsics.checkNotNullParameter(loaderTasksPerfMetric, "<set-?>");
        this.loaderTaskPerfMetric = loaderTasksPerfMetric;
    }

    /* renamed from: isVisibleAndSurvival, reason: from getter */
    public final boolean getIsVisibleAndSurvival() {
        return this.isVisibleAndSurvival;
    }

    public final void setVisibleAndSurvival(boolean z) {
        this.isVisibleAndSurvival = z;
    }

    /* renamed from: isRelease, reason: from getter */
    public final boolean getIsRelease() {
        return this.isRelease;
    }

    public final void setRelease(boolean z) {
        this.isRelease = z;
    }

    public final boolean getHasErrorView() {
        return this.hasErrorView;
    }

    public final void setHasErrorView(boolean z) {
        this.hasErrorView = z;
    }

    public final String getLoadStatus() {
        return this.loadStatus;
    }

    public final void setLoadStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.loadStatus = str;
    }

    public final SSRConfig getSsrConfig() {
        return this.ssrConfig;
    }

    public final void setSsrConfig(SSRConfig sSRConfig) {
        this.ssrConfig = sSRConfig;
    }
}
