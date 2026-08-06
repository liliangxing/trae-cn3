package com.bytedance.ies.bullet.pool;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import com.bytedance.ies.bullet.core.BulletContainerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.PoolBulletLifeCycle;
import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.p003ui.common.BulletContainerView;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.CacheItem;
import com.bytedance.ies.bullet.service.base.CacheItemStatus;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.IKitViewService;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PoolKit.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002T\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012%\u0012#\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0001¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\b0\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007`\nB\u001d\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0002\u0010\u0010J+\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0001H\u0096\u0002R\u000e\u0010\u000f\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/bullet/pool/KeyPreRenderOperation;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "cacheKey", "Lcom/bytedance/ies/bullet/service/base/CacheItemStatus;", "Lcom/bytedance/ies/bullet/service/base/CacheItem;", "", "callback", "Lcom/bytedance/ies/bullet/pool/api/PreRenderOperationWithKey;", "context", "Landroid/content/Context;", "originSchema", "Landroid/net/Uri;", "bid", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;)V", SchemaConstants.QUERY_KEY_BUNDLE, "Landroid/os/Bundle;", "getBundle", "()Landroid/os/Bundle;", "setBundle", "(Landroid/os/Bundle;)V", "contextRef", "Ljava/lang/ref/WeakReference;", "getOriginSchema", "()Landroid/net/Uri;", "invoke", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KeyPreRenderOperation implements Function2<String, Function2<? super CacheItemStatus, ? super CacheItem, ? extends Unit>, Unit> {
    private final String bid;
    private Bundle bundle;
    private final WeakReference<Context> contextRef;
    private final Uri originSchema;

    public KeyPreRenderOperation(Context context, Uri uri, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "originSchema");
        Intrinsics.checkNotNullParameter(str, "bid");
        this.originSchema = uri;
        this.bid = str;
        this.contextRef = new WeakReference<>(context);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (Function2<? super CacheItemStatus, ? super CacheItem, Unit>) obj2);
        return Unit.INSTANCE;
    }

    public final Uri getOriginSchema() {
        return this.originSchema;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public void invoke(String cacheKey, final Function2<? super CacheItemStatus, ? super CacheItem, Unit> callback) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Context context = this.contextRef.get();
        if (context != null) {
            BulletContainerView bulletContainerView = new BulletContainerView(new MutableContextWrapper(context), null, 0, 6, null);
            bulletContainerView.bind(this.bid);
            Uri uri = this.originSchema;
            final CacheItem cacheItem = new CacheItem(uri, uri, bulletContainerView, CacheType.PRE_RENDER);
            cacheItem.setCacheKey(cacheKey);
            BulletLogger bulletLogger = BulletLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("Create View Success, Start Load uri, sessionId=");
            Bundle bundle = this.bundle;
            BulletLogger.printLog$default(bulletLogger, sb.append(bundle != null ? bundle.getString("__x_session_id") : null).toString(), null, "XPreRender", 2, null);
            bulletContainerView.loadUri(this.originSchema, this.bundle, null, new PoolBulletLifeCycle() { // from class: com.bytedance.ies.bullet.pool.KeyPreRenderOperation$invoke$1$1$1
                @Override // com.bytedance.ies.bullet.core.PoolBulletLifeCycle, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
                public void onLoadStart(Uri uri2, IBulletContainer container) {
                    BulletContext bulletContext;
                    Intrinsics.checkNotNullParameter(uri2, "uri");
                    callback.invoke(CacheItemStatus.LOADING, cacheItem);
                    BulletContainerContext containerContext = (container == null || (bulletContext = container.getBulletContext()) == null) ? null : bulletContext.getContainerContext();
                    if (containerContext != null) {
                        containerContext.setPreload(true);
                    }
                    super.onLoadStart(uri2, container);
                }

                @Override // com.bytedance.ies.bullet.core.PoolBulletLifeCycle, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
                public void onLoadUriSuccess(Uri uri2, IKitViewService kitView) {
                    Intrinsics.checkNotNullParameter(uri2, "uri");
                    if (getHasCallback().compareAndSet(false, true)) {
                        callback.invoke(CacheItemStatus.SUCCESS, cacheItem);
                    }
                    super.onLoadUriSuccess(uri2, kitView);
                }

                @Override // com.bytedance.ies.bullet.core.PoolBulletLifeCycle, com.bytedance.ies.bullet.core.IBulletLoadLifeCycle
                public void onLoadFail(Uri uri2, Throwable e) {
                    Intrinsics.checkNotNullParameter(uri2, "uri");
                    Intrinsics.checkNotNullParameter(e, "e");
                    if (getHasCallback().compareAndSet(false, true)) {
                        callback.invoke(CacheItemStatus.FAILED, cacheItem);
                    }
                    super.onLoadFail(uri2, e);
                }
            });
        }
    }
}
