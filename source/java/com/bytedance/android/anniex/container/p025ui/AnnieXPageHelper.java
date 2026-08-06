package com.bytedance.android.anniex.container.p025ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.anniex.ability.service.IAnnieXContextProvider;
import com.bytedance.android.anniex.ability.service.IAnnieXLifecycleConfigService;
import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.android.anniex.base.builder.PageBuilder;
import com.bytedance.android.anniex.base.container.holder.IFragmentHolder;
import com.bytedance.android.anniex.base.container.listener.AnnieXFragmentListener;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.base.service.IAnnieXService;
import com.bytedance.android.anniex.container.holder.AnnieXFragmentHolder;
import com.bytedance.ies.bullet.base.BulletSdk;
import com.bytedance.ies.bullet.base.core.common.Components;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import com.bytedance.rts.foundation.RTSStringKt;
import com.lynx.tasm.LynxViewClient;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXPageHelper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper;", "", "()V", "annieXActivity", "Landroidx/fragment/app/FragmentActivity;", "fragmentHolder", "Lcom/bytedance/android/anniex/container/holder/AnnieXFragmentHolder;", "finish", "", "onBackPressed", "onCreate", "activity", "intent", "Landroid/content/Intent;", "resId", "", "onDestroy", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXPageHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_BULLET_BID = "bullet_bid_AnnieXPageHelper";
    private static boolean initializeAnnieX;
    private FragmentActivity annieXActivity;
    private AnnieXFragmentHolder fragmentHolder;

    /* compiled from: AnnieXPageHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXPageHelper$Companion;", "", "()V", "KEY_BULLET_BID", "", "initializeAnnieX", "", "getInitializeAnnieX", "()Z", "setInitializeAnnieX", "(Z)V", "tryInitAnnieXIfNeed", "context", "Landroid/content/Context;", "bid", "tag", "tryInitAnnieXIfNeed$anniex_release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getInitializeAnnieX() {
            return AnnieXPageHelper.initializeAnnieX;
        }

        public final void setInitializeAnnieX(boolean z) {
            AnnieXPageHelper.initializeAnnieX = z;
        }

        public final boolean tryInitAnnieXIfNeed$anniex_release(Context context, String bid, String tag) {
            Intrinsics.checkNotNullParameter(bid, "bid");
            Intrinsics.checkNotNullParameter(tag, "tag");
            if (!getInitializeAnnieX()) {
                setInitializeAnnieX(true);
                if (IConditionCallKt.enableFlowPageAnnieInitFix() && Intrinsics.areEqual(RTSStringKt.toLowerCase(bid), "webcast")) {
                    IAnnieXContextProvider iAnnieXContextProvider = (IAnnieXContextProvider) AnnieX.INSTANCE.getService(bid, IAnnieXContextProvider.class);
                    if (iAnnieXContextProvider == null) {
                        iAnnieXContextProvider = (IAnnieXContextProvider) ServiceCenter.Companion.instance().get(bid, IAnnieXContextProvider.class);
                    }
                    if (iAnnieXContextProvider != null && iAnnieXContextProvider.initAnnieXCardBizEnv(bid)) {
                        HybridLogger.i$default(HybridLogger.INSTANCE, tag, "initAnnieXCardBizEnv success or bid != webcast", (Map) null, (LoggerContext) null, 12, (Object) null);
                    } else {
                        HybridLogger.i$default(HybridLogger.INSTANCE, tag, "initAnnieXCardBizEnv failed", (Map) null, (LoggerContext) null, 12, (Object) null);
                        return false;
                    }
                }
                if (context == null) {
                    HybridLogger.i$default(HybridLogger.INSTANCE, tag, "BulletSdk.ensureDefaultBidReady failed, message = context is null", (Map) null, (LoggerContext) null, 12, (Object) null);
                    return false;
                }
                AnnieX.INSTANCE.ensureLynxInitialized(context);
                try {
                    BulletSdk.INSTANCE.ensureDefaultBidReady(context);
                    HybridLogger.i$default(HybridLogger.INSTANCE, tag, "BulletSdk.ensureDefaultBidReady success", (Map) null, (LoggerContext) null, 12, (Object) null);
                } catch (Throwable th) {
                    HybridLogger.i$default(HybridLogger.INSTANCE, tag, "BulletSdk.ensureDefaultBidReady failed, message = " + th.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(final FragmentActivity activity, final Intent intent, int resId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra(AnnieXPageService.BUNDLE_ANNIEX_BID);
        if (stringExtra == null) {
            stringExtra = "default_bid";
        }
        final String str = stringExtra;
        if (!INSTANCE.tryInitAnnieXIfNeed$anniex_release((Context) activity, str, KEY_BULLET_BID) && IConditionCallKt.enableAnnieXLitePageClose()) {
            HybridLogger.i$default(HybridLogger.INSTANCE, KEY_BULLET_BID, "tryInitAnnieXIfNeed failed, bid = " + str, (Map) null, (LoggerContext) null, 12, (Object) null);
            activity.finish();
            return;
        }
        IAnnieXService service = AnnieX.INSTANCE.getService(str, IAnnieXLifecycleConfigService.class);
        AnnieXFragmentHolder annieXFragmentHolder = null;
        if (!IConditionCallKt.getEnableLitePageBidOpt()) {
            service = null;
        }
        IAnnieXLifecycleConfigService iAnnieXLifecycleConfigService = (IAnnieXLifecycleConfigService) service;
        final AnnieXFragmentListener createFragmentListener = iAnnieXLifecycleConfigService != null ? iAnnieXLifecycleConfigService.createFragmentListener() : null;
        final AbsAnnieXLifecycle createLifecycle = iAnnieXLifecycleConfigService != null ? iAnnieXLifecycleConfigService.createLifecycle() : null;
        this.annieXActivity = activity;
        IFragmentHolder createFragmentHolder = AnnieX.INSTANCE.createFragmentHolder(new Function1<PageBuilder, Unit>() { // from class: com.bytedance.android.anniex.container.ui.AnnieXPageHelper$onCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PageBuilder) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PageBuilder pageBuilder) {
                Intrinsics.checkNotNullParameter(pageBuilder, "$this$createFragmentHolder");
                pageBuilder.activity((Activity) FragmentActivity.this);
                AnnieXFragmentListener annieXFragmentListener = createFragmentListener;
                if (annieXFragmentListener == null) {
                    annieXFragmentListener = new AnnieXFragmentListener() { // from class: com.bytedance.android.anniex.container.ui.AnnieXPageHelper$onCreate$1.1
                    };
                }
                pageBuilder.listener(annieXFragmentListener);
                pageBuilder.lynxViewClient(new LynxViewClient() { // from class: com.bytedance.android.anniex.container.ui.AnnieXPageHelper$onCreate$1.2
                });
                pageBuilder.webViewClient(new WebViewClient());
                AbsAnnieXLifecycle absAnnieXLifecycle = createLifecycle;
                if (absAnnieXLifecycle == null) {
                    absAnnieXLifecycle = new AbsAnnieXLifecycle() { // from class: com.bytedance.android.anniex.container.ui.AnnieXPageHelper$onCreate$1.3
                    };
                }
                pageBuilder.lifecycle(absAnnieXLifecycle);
                pageBuilder.bid(str);
                pageBuilder.clientComponent(Components.Activity);
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    extras = new Bundle();
                }
                pageBuilder.bundle(extras);
            }
        });
        Intrinsics.checkNotNull(createFragmentHolder, "null cannot be cast to non-null type com.bytedance.android.anniex.container.holder.AnnieXFragmentHolder");
        this.fragmentHolder = (AnnieXFragmentHolder) createFragmentHolder;
        FragmentTransaction beginTransaction = activity.getSupportFragmentManager().beginTransaction();
        AnnieXFragmentHolder annieXFragmentHolder2 = this.fragmentHolder;
        if (annieXFragmentHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
            annieXFragmentHolder2 = null;
        }
        beginTransaction.replace(resId, annieXFragmentHolder2.getFragment()).commit();
        Uri data = intent.getData();
        if (data != null) {
            AnnieXFragmentHolder annieXFragmentHolder3 = this.fragmentHolder;
            if (annieXFragmentHolder3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
            } else {
                annieXFragmentHolder = annieXFragmentHolder3;
            }
            String uri = data.toString();
            Intrinsics.checkNotNullExpressionValue(uri, "it.toString()");
            annieXFragmentHolder.loadSchema(uri);
        }
    }

    public final void onDestroy() {
        AnnieXFragmentHolder annieXFragmentHolder = this.fragmentHolder;
        if (annieXFragmentHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
            annieXFragmentHolder = null;
        }
        annieXFragmentHolder.release();
    }

    public final void onBackPressed() {
        AnnieXFragmentHolder annieXFragmentHolder = this.fragmentHolder;
        FragmentActivity fragmentActivity = null;
        if (annieXFragmentHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
            annieXFragmentHolder = null;
        }
        if (annieXFragmentHolder.getContainer().canBackPress()) {
            FragmentActivity fragmentActivity2 = this.annieXActivity;
            if (fragmentActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("annieXActivity");
            } else {
                fragmentActivity = fragmentActivity2;
            }
            fragmentActivity.finish();
        }
    }

    public final void finish() {
        AnnieXFragmentHolder annieXFragmentHolder = this.fragmentHolder;
        if (annieXFragmentHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragmentHolder");
            annieXFragmentHolder = null;
        }
        annieXFragmentHolder.getContainer().finish();
    }
}
