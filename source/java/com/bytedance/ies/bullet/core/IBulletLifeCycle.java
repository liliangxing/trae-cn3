package com.bytedance.ies.bullet.core;

import android.net.Uri;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBulletLifeCycle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0007J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "Lcom/bytedance/ies/bullet/core/IBulletLoadLifeCycle;", "onBulletViewCreate", "", "onBulletViewRelease", "onClose", "onOpen", "Base", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBulletLifeCycle extends IBulletLoadLifeCycle {
    void onBulletViewCreate();

    void onBulletViewRelease();

    void onClose();

    void onOpen();

    /* compiled from: IBulletLifeCycle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J$\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\u001a\u0010 \u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006!"}, d2 = {"Lcom/bytedance/ies/bullet/core/IBulletLifeCycle$Base;", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "()V", "lynxClient", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "getLynxClient", "()Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "setLynxClient", "(Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;)V", "onBulletViewCreate", "", "onBulletViewRelease", "onClose", "onFallback", "uri", "Landroid/net/Uri;", "e", "", "onKitViewCreate", "kitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "onKitViewDestroy", LynxError.LYNX_THROWABLE, "onLoadFail", "onLoadModelSuccess", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "onLoadStart", "container", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "onLoadUriSuccess", "onOpen", "onRuntimeReady", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static class Base implements IBulletLifeCycle {
        private ILynxClientDelegate lynxClient;

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
        public void onBulletViewCreate() {
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
        public void onBulletViewRelease() {
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
        public void onClose() {
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onFallback(Uri uri, Throwable e) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(e, "e");
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onKitViewCreate(Uri uri, IKitViewService kitView) {
            Intrinsics.checkNotNullParameter(uri, "uri");
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onKitViewDestroy(Uri uri, IKitViewService kitView, Throwable throwable) {
            Intrinsics.checkNotNullParameter(uri, "uri");
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onLoadFail(Uri uri, Throwable e) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(e, "e");
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onLoadModelSuccess(Uri uri, IKitViewService kitView, SchemaModelUnion schemaModelUnion) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(schemaModelUnion, "schemaModelUnion");
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onLoadStart(Uri uri, IBulletContainer container) {
            Intrinsics.checkNotNullParameter(uri, "uri");
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onLoadUriSuccess(Uri uri, IKitViewService kitView) {
            Intrinsics.checkNotNullParameter(uri, "uri");
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
        public void onOpen() {
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void onRuntimeReady(Uri uri, IKitViewService kitView) {
            Intrinsics.checkNotNullParameter(uri, "uri");
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public ILynxClientDelegate getLynxClient() {
            return this.lynxClient;
        }

        @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
        public void setLynxClient(ILynxClientDelegate iLynxClientDelegate) {
            this.lynxClient = iLynxClientDelegate;
        }
    }
}
