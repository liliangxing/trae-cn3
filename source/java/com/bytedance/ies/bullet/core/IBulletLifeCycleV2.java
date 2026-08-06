package com.bytedance.ies.bullet.core;

import android.net.Uri;
import com.bytedance.ies.bullet.core.IBulletLifeCycle;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBulletLifeCycle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u0012J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/core/IBulletLifeCycleV2;", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "beforeLoadTemplateWithUrl", "", "url", "", "loadTemplateError", "error", "", "loadTemplateReady", "resourceInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "onEnterBackground", "uri", "Landroid/net/Uri;", "kitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "onEnterForeground", "Base", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IBulletLifeCycleV2 extends IBulletLifeCycle {

    /* compiled from: IBulletLifeCycle.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static void beforeLoadTemplateWithUrl(IBulletLifeCycleV2 iBulletLifeCycleV2, String str) {
            Intrinsics.checkNotNullParameter(str, "url");
        }

        public static void loadTemplateError(IBulletLifeCycleV2 iBulletLifeCycleV2, Throwable th) {
        }

        public static void loadTemplateReady(IBulletLifeCycleV2 iBulletLifeCycleV2, ResourceInfo resourceInfo) {
            Intrinsics.checkNotNullParameter(resourceInfo, "resourceInfo");
        }

        public static void onEnterBackground(IBulletLifeCycleV2 iBulletLifeCycleV2, Uri uri, IKitViewService iKitViewService) {
        }

        public static void onEnterForeground(IBulletLifeCycleV2 iBulletLifeCycleV2, Uri uri, IKitViewService iKitViewService) {
        }
    }

    void beforeLoadTemplateWithUrl(String url);

    void loadTemplateError(Throwable error);

    void loadTemplateReady(ResourceInfo resourceInfo);

    void onEnterBackground(Uri uri, IKitViewService kitView);

    void onEnterForeground(Uri uri, IKitViewService kitView);

    /* compiled from: IBulletLifeCycle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/bullet/core/IBulletLifeCycleV2$Base;", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle$Base;", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycleV2;", "()V", "beforeLoadTemplateWithUrl", "", "url", "", "loadTemplateError", "error", "", "loadTemplateReady", "resourceInfo", "Lcom/bytedance/ies/bullet/service/base/ResourceInfo;", "onEnterBackground", "uri", "Landroid/net/Uri;", "kitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "onEnterForeground", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Base extends IBulletLifeCycle.Base implements IBulletLifeCycleV2 {
        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycleV2
        public void onEnterBackground(Uri uri, IKitViewService kitView) {
            DefaultImpls.onEnterBackground(this, uri, kitView);
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycleV2
        public void onEnterForeground(Uri uri, IKitViewService kitView) {
            DefaultImpls.onEnterForeground(this, uri, kitView);
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycleV2
        public void beforeLoadTemplateWithUrl(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            DefaultImpls.beforeLoadTemplateWithUrl(this, url);
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycleV2
        public void loadTemplateReady(ResourceInfo resourceInfo) {
            Intrinsics.checkNotNullParameter(resourceInfo, "resourceInfo");
            DefaultImpls.loadTemplateReady(this, resourceInfo);
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycleV2
        public void loadTemplateError(Throwable error) {
            DefaultImpls.loadTemplateError(this, error);
        }
    }
}
