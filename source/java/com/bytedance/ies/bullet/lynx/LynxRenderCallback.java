package com.bytedance.ies.bullet.lynx;

import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import com.bytedance.ies.bullet.service.base.resourceloader.config.TaskConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxKitInitParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/bullet/lynx/LynxRenderCallback;", "", "()V", "afterReadTemplate", "", "url", "", "lynxFile", "", "listener", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "afterRender", "beforeLoadTemplate", "beforeLoadTemplateWithUrl", "beforeReadTemplate", "beforeRender", "loadTemplateError", "error", "", "loadTemplateReady", "resourceInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "provideTaskConfig", "Lcom/bytedance/ies/bullet/service/base/resourceloader/config/TaskConfig;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LynxRenderCallback {
    public void afterReadTemplate(String url, byte[] lynxFile, IBulletLifeCycle listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(lynxFile, "lynxFile");
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    public void afterRender() {
    }

    public void beforeLoadTemplate() {
    }

    public void beforeLoadTemplateWithUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void beforeReadTemplate() {
    }

    public void beforeRender() {
    }

    public void loadTemplateError(String url, Throwable error) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void loadTemplateError(Throwable error) {
    }

    public void loadTemplateReady(ResourceInfo resourceInfo) {
        Intrinsics.checkNotNullParameter(resourceInfo, "resourceInfo");
    }

    public TaskConfig provideTaskConfig() {
        return null;
    }
}
