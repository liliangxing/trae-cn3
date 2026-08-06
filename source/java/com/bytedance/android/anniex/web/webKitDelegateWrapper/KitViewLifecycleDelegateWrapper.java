package com.bytedance.android.anniex.web.webKitDelegateWrapper;

import android.net.Uri;
import com.bytedance.ies.bullet.core.IBulletLifeCycleV2;
import com.bytedance.ies.bullet.core.IBulletLoadLifeCycle;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.kit.web.service.IWebGlobalConfigService;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KitViewLifecycleDelegateWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\r\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ!\u0010\f\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u0011J!\u0010\u0012\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u0013J\r\u0010\u0014\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0015R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/anniex/web/webKitDelegateWrapper/KitViewLifecycleDelegateWrapper;", "", "contextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "bid", "", "(Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;Ljava/lang/String;)V", "kitViewLifecycleDelegate", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycleV2;", "onClose", "", "onClose$anniex_release", "onEnterBackground", "uri", "Landroid/net/Uri;", "kitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "onEnterBackground$anniex_release", "onEnterForeground", "onEnterForeground$anniex_release", "onOpen", "onOpen$anniex_release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class KitViewLifecycleDelegateWrapper {
    private final IBulletLifeCycleV2 kitViewLifecycleDelegate;

    public KitViewLifecycleDelegateWrapper(ContextProviderFactory contextProviderFactory, String str) {
        Intrinsics.checkNotNullParameter(contextProviderFactory, "contextProviderFactory");
        Intrinsics.checkNotNullParameter(str, "bid");
        IWebGlobalConfigService iWebGlobalConfigService = ServiceCenter.Companion.instance().get(str, IWebGlobalConfigService.class);
        IBulletLoadLifeCycle createKitViewLifecycleDelegate = iWebGlobalConfigService != null ? iWebGlobalConfigService.createKitViewLifecycleDelegate(contextProviderFactory) : null;
        this.kitViewLifecycleDelegate = createKitViewLifecycleDelegate instanceof IBulletLifeCycleV2 ? (IBulletLifeCycleV2) createKitViewLifecycleDelegate : null;
    }

    public final void onOpen$anniex_release() {
        IBulletLifeCycleV2 iBulletLifeCycleV2 = this.kitViewLifecycleDelegate;
        if (iBulletLifeCycleV2 != null) {
            iBulletLifeCycleV2.onOpen();
        }
    }

    public final void onEnterForeground$anniex_release(Uri uri, IKitViewService kitView) {
        IBulletLifeCycleV2 iBulletLifeCycleV2 = this.kitViewLifecycleDelegate;
        if (iBulletLifeCycleV2 != null) {
            iBulletLifeCycleV2.onEnterForeground(uri, kitView);
        }
    }

    public final void onEnterBackground$anniex_release(Uri uri, IKitViewService kitView) {
        IBulletLifeCycleV2 iBulletLifeCycleV2 = this.kitViewLifecycleDelegate;
        if (iBulletLifeCycleV2 != null) {
            iBulletLifeCycleV2.onEnterBackground(uri, kitView);
        }
    }

    public final void onClose$anniex_release() {
        IBulletLifeCycleV2 iBulletLifeCycleV2 = this.kitViewLifecycleDelegate;
        if (iBulletLifeCycleV2 != null) {
            iBulletLifeCycleV2.onClose();
        }
    }
}
