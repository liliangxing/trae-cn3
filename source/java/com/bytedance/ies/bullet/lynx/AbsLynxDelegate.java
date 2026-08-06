package com.bytedance.ies.bullet.lynx;

import android.view.View;
import com.bytedance.ies.argus.api.interfaces.service.ArgusBaseBizService;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.device.PropsUtilsKt;
import com.bytedance.ies.bullet.lynx.init.LynxKitBase;
import com.bytedance.ies.bullet.lynx.model.LynxModuleWrapper;
import com.bytedance.ies.bullet.service.base.IEventHandler;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.impl.BaseBulletService;
import com.bytedance.ies.bullet.service.base.lynx.ILynxKitViewService;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxViewBuilder;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.Behavior;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AbsLynxDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0014\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0016H\u0014J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0013H\u0016J\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0013H\u0016J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0013H&J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H&J\b\u0010+\u001a\u00020,H&J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\n\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0010\u00101\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u000202H\u0016J\u0010\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u0013H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u00068"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/AbsLynxDelegate;", "", "service", "Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "(Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;)V", "kitView", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxKitViewService;", "getKitView", "()Lcom/bytedance/ies/bullet/service/base/lynx/ILynxKitViewService;", "setKitView", "(Lcom/bytedance/ies/bullet/service/base/lynx/ILynxKitViewService;)V", "getService", "()Lcom/bytedance/ies/bullet/service/base/impl/BaseBulletService;", "bindKitView", "", "createEventHandler", "Lcom/bytedance/ies/bullet/service/base/IEventHandler;", "createLynxModule", "", "", "Lcom/bytedance/ies/bullet/lynx/model/LynxModuleWrapper;", "generateGlobalProps", "", "getContext", "Lcom/bytedance/ies/bullet/core/BulletContext;", "getDebugUrl", "getGlobalProps", "injectLynxBuilder", "viewBuilder", "Lcom/lynx/tasm/LynxViewBuilder;", "onBackPressed", "", "onLoadStart", "sessionId", "onLynxViewCreated", "view", "Landroid/view/View;", "parseSchema", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "url", "provideBehavior", "", "Lcom/lynx/tasm/behavior/Behavior;", "provideLynxInitParams", "Lcom/bytedance/ies/bullet/lynx/LynxKitInitParams;", "provideRenderCallback", "Lcom/bytedance/ies/bullet/lynx/LynxRenderCallback;", "provideTemplateData", "Lcom/lynx/tasm/TemplateData;", "registerSecureService", "Lcom/bytedance/ies/argus/api/interfaces/service/ArgusBaseBizService;", "release", "kitViewService", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "setDebugInitialData", "data", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class AbsLynxDelegate {
    private ILynxKitViewService kitView;
    private final BaseBulletService service;

    public IEventHandler createEventHandler() {
        return null;
    }

    public BulletContext getContext() {
        return null;
    }

    public String getDebugUrl() {
        return null;
    }

    public void injectLynxBuilder(LynxViewBuilder viewBuilder) {
        Intrinsics.checkNotNullParameter(viewBuilder, "viewBuilder");
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onLoadStart(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
    }

    public void onLynxViewCreated(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public abstract SchemaModelUnion parseSchema(String url, String sessionId);

    public abstract List<Behavior> provideBehavior();

    public abstract LynxKitInitParams provideLynxInitParams();

    public LynxRenderCallback provideRenderCallback() {
        return null;
    }

    public TemplateData provideTemplateData() {
        return null;
    }

    public void registerSecureService(ArgusBaseBizService service) {
        Intrinsics.checkNotNullParameter(service, "service");
    }

    public void release(IKitViewService kitViewService) {
        Intrinsics.checkNotNullParameter(kitViewService, "kitViewService");
    }

    public void setDebugInitialData(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public AbsLynxDelegate(BaseBulletService baseBulletService) {
        Intrinsics.checkNotNullParameter(baseBulletService, "service");
        this.service = baseBulletService;
    }

    public final BaseBulletService getService() {
        return this.service;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ILynxKitViewService getKitView() {
        return this.kitView;
    }

    protected final void setKitView(ILynxKitViewService iLynxKitViewService) {
        this.kitView = iLynxKitViewService;
    }

    public final void bindKitView(ILynxKitViewService kitView) {
        Intrinsics.checkNotNullParameter(kitView, "kitView");
        this.kitView = kitView;
    }

    public Map<String, LynxModuleWrapper> createLynxModule() {
        return new LinkedHashMap();
    }

    public final Map<String, Object> getGlobalProps() {
        LinkedHashMap deviceProps = PropsUtilsKt.getDeviceProps(KitType.LYNX, LynxKitBase.INSTANCE.getContext(), getContext());
        if (deviceProps == null) {
            deviceProps = new LinkedHashMap();
        }
        String lynxVersion = LynxEnv.inst().getLynxVersion();
        Intrinsics.checkNotNullExpressionValue(lynxVersion, "inst().lynxVersion");
        deviceProps.put("lynxSdkVersion", lynxVersion);
        deviceProps.putAll(generateGlobalProps());
        return deviceProps;
    }

    protected Map<String, Object> generateGlobalProps() {
        return new LinkedHashMap();
    }
}
