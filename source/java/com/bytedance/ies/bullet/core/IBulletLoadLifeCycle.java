package com.bytedance.ies.bullet.core;

import android.net.Uri;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IBulletLifeCycle.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001cJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J$\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\rH&J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH&J\"\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0015\u001a\u00020\u0016H&J\u001a\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\u001a\u0010\u001a\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\u001a\u0010\u001b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/bullet/core/IBulletLoadLifeCycle;", "", "lynxClient", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "getLynxClient", "()Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "setLynxClient", "(Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;)V", "onFallback", "", "uri", "Landroid/net/Uri;", "e", "", "onKitViewCreate", "kitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "onKitViewDestroy", "throwable", "onLoadFail", "onLoadModelSuccess", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "onLoadStart", "container", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "onLoadUriSuccess", "onRuntimeReady", "Base", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IBulletLoadLifeCycle {
    ILynxClientDelegate getLynxClient();

    void onFallback(Uri uri, Throwable e);

    void onKitViewCreate(Uri uri, IKitViewService kitView);

    void onKitViewDestroy(Uri uri, IKitViewService kitView, Throwable throwable);

    void onLoadFail(Uri uri, Throwable e);

    void onLoadModelSuccess(Uri uri, IKitViewService kitView, SchemaModelUnion schemaModelUnion);

    void onLoadStart(Uri uri, IBulletContainer container);

    void onLoadUriSuccess(Uri uri, IKitViewService kitView);

    void onRuntimeReady(Uri uri, IKitViewService kitView);

    void setLynxClient(ILynxClientDelegate iLynxClientDelegate);

    /* compiled from: IBulletLifeCycle.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u001c\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ies/bullet/core/IBulletLoadLifeCycle$Base;", "Lcom/bytedance/ies/bullet/core/IBulletLoadLifeCycle;", "()V", "lynxClient", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "getLynxClient", "()Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "setLynxClient", "(Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;)V", "onFallback", "", "uri", "Landroid/net/Uri;", "e", "", "onKitViewCreate", "kitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "onKitViewDestroy", "throwable", "onLoadFail", "onLoadModelSuccess", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "onLoadStart", "container", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "onLoadUriSuccess", "onRuntimeReady", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Base implements IBulletLoadLifeCycle {
        private ILynxClientDelegate lynxClient;

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
