package com.bytedance.ies.bullet.service.base.api;

import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBulletService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/api/IBulletUILifecycleListener;", "", "onClose", "", "component", "Lcom/bytedance/ies/bullet/service/base/api/IBulletUIComponent;", "onLoadFailed", LynxError.LYNX_THROWABLE, "", "onLoadSuccess", "onOpen", "Base", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBulletUILifecycleListener {

    /* compiled from: IBulletService.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/api/IBulletUILifecycleListener$Base;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletUILifecycleListener;", "()V", "onClose", "", "component", "Lcom/bytedance/ies/bullet/service/base/api/IBulletUIComponent;", "onLoadFailed", LynxError.LYNX_THROWABLE, "", "onLoadSuccess", "onOpen", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static class Base implements IBulletUILifecycleListener {
        @Override // com.bytedance.ies.bullet.service.base.api.IBulletUILifecycleListener
        public void onClose(IBulletUIComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
        }

        @Override // com.bytedance.ies.bullet.service.base.api.IBulletUILifecycleListener
        public void onLoadFailed(IBulletUIComponent component, Throwable throwable) {
            Intrinsics.checkNotNullParameter(throwable, "throwable");
        }

        @Override // com.bytedance.ies.bullet.service.base.api.IBulletUILifecycleListener
        public void onLoadSuccess(IBulletUIComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
        }

        @Override // com.bytedance.ies.bullet.service.base.api.IBulletUILifecycleListener
        public void onOpen(IBulletUIComponent component) {
            Intrinsics.checkNotNullParameter(component, "component");
        }
    }

    void onClose(IBulletUIComponent component);

    void onLoadFailed(IBulletUIComponent component, Throwable throwable);

    void onLoadSuccess(IBulletUIComponent component);

    void onOpen(IBulletUIComponent component);
}
