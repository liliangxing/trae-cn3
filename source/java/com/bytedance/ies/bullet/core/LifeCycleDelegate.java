package com.bytedance.ies.bullet.core;

import android.net.Uri;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.base.lynx.ILynxClientDelegate;
import com.bytedance.ies.bullet.service.schema.SchemaModelUnion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LifeCycleDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J$\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0016J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\"\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u001a\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\u001a\u0010#\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006$"}, d2 = {"Lcom/bytedance/ies/bullet/core/LifeCycleDelegate;", "Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "origin", "(Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;)V", "lynxClient", "Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "getLynxClient", "()Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;", "setLynxClient", "(Lcom/bytedance/ies/bullet/service/base/lynx/ILynxClientDelegate;)V", "getOrigin", "()Lcom/bytedance/ies/bullet/core/IBulletLifeCycle;", "onBulletViewCreate", "", "onBulletViewRelease", "onClose", "onFallback", "uri", "Landroid/net/Uri;", "e", "", "onKitViewCreate", "kitView", "Lcom/bytedance/ies/bullet/service/base/IKitViewService;", "onKitViewDestroy", "throwable", "onLoadFail", "onLoadModelSuccess", "schemaModelUnion", "Lcom/bytedance/ies/bullet/service/schema/SchemaModelUnion;", "onLoadStart", "container", "Lcom/bytedance/ies/bullet/core/container/IBulletContainer;", "onLoadUriSuccess", "onOpen", "onRuntimeReady", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LifeCycleDelegate implements IBulletLifeCycle {
    private ILynxClientDelegate lynxClient;
    private final IBulletLifeCycle origin;

    public LifeCycleDelegate(IBulletLifeCycle iBulletLifeCycle) {
        Intrinsics.checkNotNullParameter(iBulletLifeCycle, "origin");
        this.origin = iBulletLifeCycle;
        this.lynxClient = iBulletLifeCycle.getLynxClient();
    }

    public final IBulletLifeCycle getOrigin() {
        return this.origin;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public ILynxClientDelegate getLynxClient() {
        return this.lynxClient;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void setLynxClient(ILynxClientDelegate iLynxClientDelegate) {
        this.lynxClient = iLynxClientDelegate;
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onOpen() {
        this.origin.onOpen();
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onBulletViewCreate() {
        this.origin.onBulletViewCreate();
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onFallback(Uri uri, Throwable e) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(e, "e");
        this.origin.onFallback(uri, e);
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onBulletViewRelease() {
        this.origin.onBulletViewRelease();
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLifeCycle
    public void onClose() {
        this.origin.onClose();
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadStart(Uri uri, IBulletContainer container) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.origin.onLoadStart(uri, container);
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadModelSuccess(Uri uri, IKitViewService kitView, SchemaModelUnion schemaModelUnion) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(schemaModelUnion, "schemaModelUnion");
        this.origin.onLoadModelSuccess(uri, kitView, schemaModelUnion);
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onKitViewCreate(Uri uri, IKitViewService kitView) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.origin.onKitViewCreate(uri, kitView);
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onRuntimeReady(Uri uri, IKitViewService kitView) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.origin.onRuntimeReady(uri, kitView);
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onKitViewDestroy(Uri uri, IKitViewService kitView, Throwable throwable) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.origin.onKitViewDestroy(uri, kitView, throwable);
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadUriSuccess(Uri uri, IKitViewService kitView) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.origin.onLoadUriSuccess(uri, kitView);
    }

    @Override // com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
    public void onLoadFail(Uri uri, Throwable e) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(e, "e");
        this.origin.onLoadFail(uri, e);
    }
}
