package com.larus.business.markdown.impl.common;

import android.app.Application;
import android.content.Context;
import com.larus.business.markdown.api.MarkdownService;
import io.noties.markwon.ext.tables.TableAwareMovementMethod;
import io.noties.markwon.movement.MovementMethodPlugin;
import io.noties.markwon.movement.ReplacementLinkMovementMethod;
import io.noties.markwon.scrollable.HorizontalScrollableMovementMethod2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PluginManager.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/larus/business/markdown/impl/common/PluginManager;", "", "()V", "_movementMethodAllowInterceptPlugin", "Lio/noties/markwon/movement/MovementMethodPlugin;", "get_movementMethodAllowInterceptPlugin", "()Lio/noties/markwon/movement/MovementMethodPlugin;", "_movementMethodAllowInterceptPlugin$delegate", "Lkotlin/Lazy;", "_movementMethodAllowInterceptPluginInstance", "_movementMethodPlugin", "get_movementMethodPlugin", "_movementMethodPlugin$delegate", "_movementMethodPluginInstance", "getMovementMethodPluginInstance", "fallBackContext", "Landroid/content/Context;", "allowParentInterceptTouchWhenOverScroll", "", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class PluginManager {
    private static MovementMethodPlugin _movementMethodAllowInterceptPluginInstance;
    private static MovementMethodPlugin _movementMethodPluginInstance;
    public static final PluginManager INSTANCE = new PluginManager();

    /* renamed from: _movementMethodPlugin$delegate, reason: from kotlin metadata */
    private static final Lazy _movementMethodPlugin = LazyKt.lazy(new Function0<MovementMethodPlugin>() { // from class: com.larus.business.markdown.impl.common.PluginManager$_movementMethodPlugin$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MovementMethodPlugin m2823invoke() {
            MovementMethodPlugin movementMethodPlugin;
            MovementMethodPlugin movementMethodPlugin2;
            movementMethodPlugin = PluginManager._movementMethodPluginInstance;
            if (movementMethodPlugin == null) {
                Application application = MarkdownService.Companion.getApplication();
                if (application == null) {
                    return null;
                }
                PluginManager pluginManager = PluginManager.INSTANCE;
                PluginManager._movementMethodPluginInstance = MovementMethodPlugin.create(new HorizontalScrollableMovementMethod2(application, new TableAwareMovementMethod(new ReplacementLinkMovementMethod()), false));
            }
            movementMethodPlugin2 = PluginManager._movementMethodPluginInstance;
            return movementMethodPlugin2;
        }
    });

    /* renamed from: _movementMethodAllowInterceptPlugin$delegate, reason: from kotlin metadata */
    private static final Lazy _movementMethodAllowInterceptPlugin = LazyKt.lazy(new Function0<MovementMethodPlugin>() { // from class: com.larus.business.markdown.impl.common.PluginManager$_movementMethodAllowInterceptPlugin$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final MovementMethodPlugin m2822invoke() {
            MovementMethodPlugin movementMethodPlugin;
            MovementMethodPlugin movementMethodPlugin2;
            movementMethodPlugin = PluginManager._movementMethodAllowInterceptPluginInstance;
            if (movementMethodPlugin == null) {
                Application application = MarkdownService.Companion.getApplication();
                if (application == null) {
                    return null;
                }
                PluginManager pluginManager = PluginManager.INSTANCE;
                PluginManager._movementMethodAllowInterceptPluginInstance = MovementMethodPlugin.create(new HorizontalScrollableMovementMethod2(application, new TableAwareMovementMethod(new ReplacementLinkMovementMethod()), true));
            }
            movementMethodPlugin2 = PluginManager._movementMethodAllowInterceptPluginInstance;
            return movementMethodPlugin2;
        }
    });

    private PluginManager() {
    }

    private final MovementMethodPlugin get_movementMethodPlugin() {
        return (MovementMethodPlugin) _movementMethodPlugin.getValue();
    }

    private final MovementMethodPlugin get_movementMethodAllowInterceptPlugin() {
        return (MovementMethodPlugin) _movementMethodAllowInterceptPlugin.getValue();
    }

    public static /* synthetic */ MovementMethodPlugin getMovementMethodPluginInstance$default(PluginManager pluginManager, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return pluginManager.getMovementMethodPluginInstance(context, z);
    }

    public final MovementMethodPlugin getMovementMethodPluginInstance(Context fallBackContext, boolean allowParentInterceptTouchWhenOverScroll) {
        Intrinsics.checkNotNullParameter(fallBackContext, "fallBackContext");
        if (allowParentInterceptTouchWhenOverScroll) {
            MovementMethodPlugin movementMethodPlugin = get_movementMethodAllowInterceptPlugin();
            if (movementMethodPlugin != null) {
                return movementMethodPlugin;
            }
            MovementMethodPlugin create = MovementMethodPlugin.create(new HorizontalScrollableMovementMethod2(fallBackContext, new TableAwareMovementMethod(new ReplacementLinkMovementMethod()), true));
            Intrinsics.checkNotNullExpressionValue(create, "create(\n                …          )\n            )");
            return create;
        }
        MovementMethodPlugin movementMethodPlugin2 = get_movementMethodPlugin();
        if (movementMethodPlugin2 != null) {
            return movementMethodPlugin2;
        }
        MovementMethodPlugin create2 = MovementMethodPlugin.create(new HorizontalScrollableMovementMethod2(fallBackContext, new TableAwareMovementMethod(new ReplacementLinkMovementMethod()), false));
        Intrinsics.checkNotNullExpressionValue(create2, "create(\n                …          )\n            )");
        return create2;
    }

    public final MovementMethodPlugin getMovementMethodPluginInstance(Context fallBackContext) {
        Intrinsics.checkNotNullParameter(fallBackContext, "fallBackContext");
        MovementMethodPlugin movementMethodPlugin = get_movementMethodPlugin();
        if (movementMethodPlugin != null) {
            return movementMethodPlugin;
        }
        MovementMethodPlugin create = MovementMethodPlugin.create(new HorizontalScrollableMovementMethod2(fallBackContext, new TableAwareMovementMethod(new ReplacementLinkMovementMethod()), false, 4, (DefaultConstructorMarker) null));
        Intrinsics.checkNotNullExpressionValue(create, "create(HorizontalScrolla…ntLinkMovementMethod())))");
        return create;
    }
}
