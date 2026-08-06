package com.bytedance.ies.bullet.pool.util;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.ies.bullet.core.BulletContainerContext;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.p003ui.common.BulletContainerView;
import com.bytedance.ies.bullet.service.base.CacheItem;
import com.bytedance.ies.bullet.service.base.CacheType;
import com.bytedance.ies.bullet.service.base.Event;
import com.bytedance.ies.bullet.service.context.ContextProviderManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PoolUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a(\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\u0003\u001a\u0012\u0010\t\u001a\u00020\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u0012\u0010\r\u001a\u00020\b*\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\u0003\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a-\u0010\u0014\u001a\u00020\b*\u00020\u00032!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\b0\u0016¨\u0006\u001b"}, d2 = {"replaceView", "", "newView", "Landroid/view/View;", "originView", "openPreRender", "openReUse", "removeParent", "", "setBaseContext", "Lcom/bytedance/ies/bullet/ui/common/BulletContainerView;", "context", "Landroid/content/Context;", "setCacheType", "cacheType", "Lcom/bytedance/ies/bullet/service/base/CacheType;", "toBulletView", "transform", "Lcom/bytedance/ies/bullet/service/base/Event;", "Lcom/bytedance/ies/bullet/service/base/CacheItem;", "withParent", "resolve", "Lkotlin/Function1;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", "name", "parent", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PoolUtilKt {
    public static final BulletContainerView toBulletView(View view) {
        if (view == null) {
            return null;
        }
        if (!(view instanceof BulletContainerView)) {
            view = null;
        }
        if (view != null) {
            return (BulletContainerView) view;
        }
        return null;
    }

    public static final boolean replaceView(View view, View view2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(view2, "originView");
        final BulletContainerView bulletView = toBulletView(view);
        final BulletContainerView bulletView2 = toBulletView(view2);
        if (bulletView == null || bulletView2 == null) {
            return false;
        }
        ContextProviderManager contextProviderManager = ContextProviderManager.INSTANCE;
        BulletContext bulletContext = bulletView.getBulletContext();
        contextProviderManager.getProviderFactory(bulletContext != null ? bulletContext.getSessionId() : null).registerHolder(Context.class, view2.getContext());
        Context context = view2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "originView.context");
        setBaseContext(bulletView, context);
        if (z) {
            setCacheType(bulletView, CacheType.PRE_RENDER);
        }
        if (z2) {
            setCacheType(bulletView, CacheType.REUSE);
        }
        bulletView2.release();
        removeParent(bulletView);
        withParent(bulletView2, new Function1<ViewGroup, Unit>() { // from class: com.bytedance.ies.bullet.pool.util.PoolUtilKt$replaceView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ViewGroup) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "it");
                viewGroup.removeView(BulletContainerView.this);
                viewGroup.addView(bulletView, BulletContainerView.this.getLayoutParams());
            }
        });
        return true;
    }

    public static final boolean replaceView(View view, View view2) {
        Intrinsics.checkNotNullParameter(view2, "originView");
        return replaceView(view, view2, false, false);
    }

    public static final void setBaseContext(BulletContainerView bulletContainerView, Context context) {
        Intrinsics.checkNotNullParameter(bulletContainerView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Context context2 = bulletContainerView.getContext();
        MutableContextWrapper mutableContextWrapper = null;
        if (context2 != null) {
            if (!(context2 instanceof MutableContextWrapper)) {
                context2 = null;
            }
            if (context2 != null) {
                mutableContextWrapper = (MutableContextWrapper) context2;
            }
        }
        if (mutableContextWrapper != null) {
            mutableContextWrapper.setBaseContext(context);
        }
    }

    public static final void setCacheType(BulletContainerView bulletContainerView, CacheType cacheType) {
        Intrinsics.checkNotNullParameter(bulletContainerView, "<this>");
        Intrinsics.checkNotNullParameter(cacheType, "cacheType");
        BulletContext bulletContext = bulletContainerView.getBulletContext();
        BulletContainerContext containerContext = bulletContext != null ? bulletContext.getContainerContext() : null;
        if (containerContext == null) {
            return;
        }
        containerContext.setCacheType(cacheType);
    }

    public static final void withParent(View view, Function1<? super ViewGroup, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(function1, "resolve");
        ViewParent parent = view.getParent();
        if (parent != null) {
            if (!(parent instanceof ViewGroup)) {
                parent = null;
            }
            if (parent != null) {
                function1.invoke((ViewGroup) parent);
            }
        }
    }

    public static final void removeParent(final View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        withParent(view, new Function1<ViewGroup, Unit>() { // from class: com.bytedance.ies.bullet.pool.util.PoolUtilKt$removeParent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ViewGroup) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ViewGroup viewGroup) {
                Intrinsics.checkNotNullParameter(viewGroup, "it");
                viewGroup.removeView(view);
            }
        });
    }

    public static final Event transform(CacheItem cacheItem) {
        Intrinsics.checkNotNullParameter(cacheItem, "<this>");
        return new Event(cacheItem.getOriginSchema(), cacheItem.getUniqueSchema(), cacheItem.getCacheType());
    }
}
