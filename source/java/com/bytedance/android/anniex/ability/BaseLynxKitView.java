package com.bytedance.android.anniex.ability;

import android.view.View;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.StreamTrafficObservable;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.argus.api.interfaces.service.ArgusBaseBizService;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.secure.SccConfig;
import com.bytedance.ies.bullet.service.base.ILoadUriListener;
import com.bytedance.ies.bullet.service.base.callbacks.KitViewCallback;
import com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.context.IContextProviderFactory;
import com.lynx.tasm.LynxEnv;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010\u001f\u001a\u00020\u00162\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00160!2\u0006\u0010#\u001a\u00020\u0018H\u0016J\u001a\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010$\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J \u0010+\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001dH\u0016J\b\u0010/\u001a\u00020\u0018H\u0016J\b\u00100\u001a\u00020\u0016H\u0016J\b\u00101\u001a\u00020\u0016H\u0016J\n\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020\u0016H\u0016J\b\u00105\u001a\u00020\u0016H\u0016J\b\u00106\u001a\u00020\u0016H\u0016J\b\u00107\u001a\u00020\u0016H\u0016J\u001c\u00107\u001a\u00020\u00162\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\"09H\u0016J,\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001d2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\"09H\u0016J,\u0010=\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001d2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\"09H\u0016J\b\u0010>\u001a\u00020\u0016H\u0016J\u001a\u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u001d2\b\u0010A\u001a\u0004\u0018\u00010\"H\u0016J\"\u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u00020\u001d2\b\u0010A\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010B\u001a\u00020\u00162\u0006\u0010C\u001a\u00020\u0018H\u0016J\b\u0010D\u001a\u00020\u0016H\u0016J\u001c\u0010E\u001a\u00020\u00162\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\"09H\u0016J\u001c\u0010F\u001a\u00020\u00162\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\"09H\u0016J\u0018\u0010H\u001a\u00020\u00162\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006L"}, d2 = {"Lcom/bytedance/android/anniex/ability/BaseLynxKitView;", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxKitViewService;", "()V", "contextProviderFactory", "Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;", "getContextProviderFactory", "()Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;", "setContextProviderFactory", "(Lcom/bytedance/ies/bullet/service/context/IContextProviderFactory;)V", "kitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitType", "()Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "setKitType", "(Lcom/bytedance/ies/bullet/service/base/utils/KitType;)V", "kitViewCallback", "Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;", "getKitViewCallback", "()Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;", "setKitViewCallback", "(Lcom/bytedance/ies/bullet/service/base/callbacks/KitViewCallback;)V", "destroy", "", "useDelegate", "", "ensureViewCreated", "getSccLevel", "Lcom/bytedance/ies/bullet/secure/SccConfig$SccLevel;", "getSdkVersion", "", "getSessionId", "listenPreserveDataChanged", "callback", "Lkotlin/Function1;", "", "onlyGetPreserveData", "load", "templateArray", "", "baseUrl", StreamTrafficObservable.STREAM_URL, "listener", "Lcom/bytedance/ies/bullet/service/base/ILoadUriListener;", "loadUri", "lifeCycle", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "sessionId", "onBackPressed", "onHide", "onShow", "realView", "Landroid/view/View;", "reload", "reloadCurrentUrl", "reloadTemplate", "reloadTemplateWithGlobalProps", "globalProps", "", "renderSSR", "template", Constants.KEY_DATA, "renderSSRHydrate", "resetData", "sendEvent", "eventName", "params", "setPreCreate", "isPreCreate", "triggerBlankDetect", "updateData", "updateGlobalProps", "globalprops", "updateScreenMetrics", "width", "", "height", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class BaseLynxKitView implements ILynxKitViewService {
    private IContextProviderFactory contextProviderFactory;
    private KitType kitType = KitType.LYNX;
    private KitViewCallback kitViewCallback;

    public void destroy(boolean useDelegate) {
    }

    public boolean ensureViewCreated() {
        return false;
    }

    public String getSessionId() {
        return null;
    }

    public void listenPreserveDataChanged(Function1<Object, Unit> callback, boolean onlyGetPreserveData) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public void load(String url, ILoadUriListener listener) {
        Intrinsics.checkNotNullParameter(url, StreamTrafficObservable.STREAM_URL);
    }

    public void load(byte[] templateArray, String baseUrl) {
        Intrinsics.checkNotNullParameter(templateArray, "templateArray");
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

    public void reloadTemplate() {
    }

    public void reloadTemplateWithGlobalProps() {
    }

    public void reloadTemplateWithGlobalProps(Map<String, ? extends Object> globalProps) {
        Intrinsics.checkNotNullParameter(globalProps, "globalProps");
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

    public void resetData() {
    }

    public void sendEvent(String eventName, Object params) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    public void sendEvent(String eventName, Object params, boolean useDelegate) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    public void setPreCreate(boolean isPreCreate) {
    }

    public void triggerBlankDetect() {
    }

    public void updateData(Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
    }

    public void updateGlobalProps(Map<String, ? extends Object> globalprops) {
        Intrinsics.checkNotNullParameter(globalprops, "globalprops");
    }

    public void updateScreenMetrics(int width, int height) {
    }

    public boolean ensureViewCreated(String str) {
        return ILynxKitViewService.DefaultImpls.ensureViewCreated(this, str);
    }

    public void registerSecureService(ArgusBaseBizService argusBaseBizService) {
        ILynxKitViewService.DefaultImpls.registerSecureService(this, argusBaseBizService);
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

    public String getSdkVersion() {
        String lynxVersion = LynxEnv.inst().getLynxVersion();
        Intrinsics.checkNotNullExpressionValue(lynxVersion, "inst().lynxVersion");
        return lynxVersion;
    }
}
