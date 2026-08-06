package com.bytedance.android.anniex.ability;

import android.view.View;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.ILoadUriListener;
import com.bytedance.ies.bullet.service.base.api.IServiceToken;
import com.bytedance.ies.bullet.service.base.bridge.IWebJsBridge;
import com.bytedance.ies.bullet.service.base.callbacks.KitViewCallback;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.base.web.IWebKitViewService;
import com.bytedance.ies.bullet.service.context.IContextProviderFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeWebHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u00100\u001a\u00020\u0007H\u0016J\u001a\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u000104H\u0016J \u00105\u001a\u00020(2\u0006\u00102\u001a\u00020\u00072\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u0007H\u0016J\b\u00109\u001a\u00020*H\u0016J\b\u0010:\u001a\u00020(H\u0016J\b\u0010;\u001a\u00020(H\u0016J\n\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020(H\u0016J\b\u0010?\u001a\u00020(H\u0016J,\u0010@\u001a\u00020(2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00072\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020E0\u0006H\u0016J,\u0010F\u001a\u00020(2\u0006\u0010G\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00072\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020E0\u0006H\u0016J\u001a\u0010H\u001a\u00020(2\u0006\u0010I\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010EH\u0016J\"\u0010H\u001a\u00020(2\u0006\u0010I\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010E2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010K\u001a\u00020(H\u0016J\u001c\u0010L\u001a\u00020(2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020E0\u0006H\u0016J\u001c\u0010M\u001a\u00020(2\u0012\u0010N\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020E0\u0006H\u0016R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006O"}, d2 = {"Lcom/bytedance/android/anniex/ability/BaseWebKitService;", "Lcom/bytedance/ies/bullet/service/base/web/IWebKitViewService;", "context", "Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "(Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;)V", "additionalHttpHeaders", "", "", "getAdditionalHttpHeaders", "()Ljava/util/Map;", "setAdditionalHttpHeaders", "(Ljava/util/Map;)V", "getContext", "()Lcom/bytedance/ies/bullet/service/base/api/IServiceToken;", "setContext", "contextProviderFactory", "Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;", "getContextProviderFactory", "()Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;", "setContextProviderFactory", "(Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;)V", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitType", "()Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "setKitType", "(Lcom/bytedance/ies/bullet/service/base/utils/KitType;)V", "kitViewCallback", "Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;", "getKitViewCallback", "()Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;", "setKitViewCallback", "(Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;)V", "mWebJsBridge", "Lcom/bytedance/ies/bullet/service/base/bridge/IWebJsBridge;", "getMWebJsBridge", "()Lcom/bytedance/ies/bullet/service/base/bridge/IWebJsBridge;", "setMWebJsBridge", "(Lcom/bytedance/ies/bullet/service/base/bridge/IWebJsBridge;)V", "destroy", "", "useDelegate", "", "ensureViewCreated", "getSccLevel", "Lcom/bytedance/ies/bullet/secure/SccConfig$SccLevel;", "getSdkVersion", "getSessionId", "getViewTag", "load", StreamTrafficObservable.STREAM_URL, "listener", "Lcom/bytedance/ies/bullet/service/base/ILoadUriListener;", "loadUri", "lifeCycle", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "sessionId", "onBackPressed", "onHide", "onShow", "realView", "Landroid/view/View;", "reload", "reloadCurrentUrl", "renderSSR", "template", "", "baseUrl", Constants.KEY_DATA, "", "renderSSRHydrate", "templateArray", "sendEvent", "eventName", "params", "triggerBlankDetect", "updateData", "updateGlobalProps", "globalprops", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class BaseWebKitService implements IWebKitViewService {
    private Map<String, String> additionalHttpHeaders;
    private IServiceToken context;
    private IContextProviderFactory contextProviderFactory;
    private KitType kitType;
    private KitViewCallback kitViewCallback;
    private IWebJsBridge mWebJsBridge;

    public void destroy(boolean useDelegate) {
    }

    public boolean ensureViewCreated() {
        return true;
    }

    public String getSdkVersion() {
        return "";
    }

    public String getSessionId() {
        return null;
    }

    public String getViewTag() {
        return "anniex-web";
    }

    public void load(String url, ILoadUriListener listener) {
        Intrinsics.checkNotNullParameter(url, StreamTrafficObservable.STREAM_URL);
    }

    public void loadUri(String url, IBulletLifeCycle lifeCycle, String sessionId) {
        Intrinsics.checkNotNullParameter(url, StreamTrafficObservable.STREAM_URL);
        Intrinsics.checkNotNullParameter(lifeCycle, "lifeCycle");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onHide() {
    }

    public void onShow() {
    }

    public View realView() {
        return null;
    }

    public void reload() {
    }

    public void reloadCurrentUrl() {
    }

    public void renderSSR(byte[] template, String baseUrl, Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
    }

    public void renderSSRHydrate(byte[] templateArray, String baseUrl, Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(templateArray, "templateArray");
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
    }

    public void sendEvent(String eventName, Object params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    public void sendEvent(String eventName, Object params, boolean useDelegate) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    public void triggerBlankDetect() {
    }

    public void updateData(Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
    }

    public void updateGlobalProps(Map<String, ? extends Object> globalprops) {
        Intrinsics.checkNotNullParameter(globalprops, "globalprops");
    }

    public BaseWebKitService(IServiceToken iServiceToken) {
        Intrinsics.checkNotNullParameter(iServiceToken, "context");
        this.context = iServiceToken;
        this.kitType = KitType.WEB;
    }

    public boolean ensureViewCreated(String str) {
        return IWebKitViewService.DefaultImpls.ensureViewCreated(this, str);
    }

    public IServiceToken getContext() {
        return this.context;
    }

    public void setContext(IServiceToken iServiceToken) {
        Intrinsics.checkNotNullParameter(iServiceToken, "<set-?>");
        this.context = iServiceToken;
    }

    public IWebJsBridge getMWebJsBridge() {
        return this.mWebJsBridge;
    }

    public void setMWebJsBridge(IWebJsBridge iWebJsBridge) {
        this.mWebJsBridge = iWebJsBridge;
    }

    public Map<String, String> getAdditionalHttpHeaders() {
        return this.additionalHttpHeaders;
    }

    public void setAdditionalHttpHeaders(Map<String, String> map) {
        this.additionalHttpHeaders = map;
    }

    public KitType getKitType() {
        return this.kitType;
    }

    public void setKitType(KitType kitType) {
        Intrinsics.checkNotNullParameter(kitType, "<set-?>");
        this.kitType = kitType;
    }

    public IContextProviderFactory getContextProviderFactory() {
        return this.contextProviderFactory;
    }

    public void setContextProviderFactory(IContextProviderFactory iContextProviderFactory) {
        this.contextProviderFactory = iContextProviderFactory;
    }

    public KitViewCallback getKitViewCallback() {
        return this.kitViewCallback;
    }

    public void setKitViewCallback(KitViewCallback kitViewCallback) {
        this.kitViewCallback = kitViewCallback;
    }

    public SccConfig.SccLevel getSccLevel() {
        return SccConfig.SccLevel.SAFE;
    }
}
