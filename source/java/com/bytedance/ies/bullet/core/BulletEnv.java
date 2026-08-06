package com.bytedance.ies.bullet.core;

import android.app.Application;
import android.view.View;
import com.bytedance.ies.bullet.kit.web.SSWebView;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletEnv.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 72\u00020\u0001:\u000267B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u00042\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001601J\u0006\u00102\u001a\u00020&J\u000e\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\"J\u000e\u00105\u001a\u00020&2\u0006\u00104\u001a\u00020\"R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR9\u0010 \u001a!\u0012\u0015\u0012\u0013\u0018\u00010\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020&\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001a¨\u00068"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletEnv;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appVersion", "getAppVersion", "setAppVersion", "application", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "setApplication", "(Landroid/app/Application;)V", "channel", "getChannel", "setChannel", "debuggable", "", "getDebuggable", "()Z", "setDebuggable", "(Z)V", CommonConstants.KEY_DEVICE_ID, "getDid", "setDid", "isFirstLoad", "setFirstLoad", "onTagClickListener", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "target", "", "getOnTagClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnTagClickListener", "(Lkotlin/jvm/functions/Function1;)V", "showTag", "getShowTag", "setShowTag", "assertTrue", "errorMessage", "block", "Lkotlin/Function0;", "initBulletEnv", "isBulletView", "view", "markBulletView", "BulletEnvHolder", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class BulletEnv {
    private static final int TAG_ID = 305419896;
    private String appId;
    private String appVersion;
    private Application application;
    private String channel;
    private boolean debuggable;
    private String did;
    private volatile boolean isFirstLoad;
    private Function1<? super View, Unit> onTagClickListener;
    private boolean showTag;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BulletEnv instance = BulletEnvHolder.INSTANCE.getHolder();

    public /* synthetic */ BulletEnv(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void initBulletEnv() {
    }

    /* compiled from: BulletEnv.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletEnv$Companion;", "", "()V", "TAG_ID", "", "instance", "Lcom/bytedance/ies/bullet/core/BulletEnv;", "getInstance", "()Lcom/bytedance/ies/bullet/core/BulletEnv;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BulletEnv getInstance() {
            return BulletEnv.instance;
        }
    }

    private BulletEnv() {
        this.showTag = true;
        this.isFirstLoad = true;
    }

    /* compiled from: BulletEnv.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ies/bullet/core/BulletEnv$BulletEnvHolder;", "", "()V", "holder", "Lcom/bytedance/ies/bullet/core/BulletEnv;", "getHolder", "()Lcom/bytedance/ies/bullet/core/BulletEnv;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    private static final class BulletEnvHolder {
        public static final BulletEnvHolder INSTANCE = new BulletEnvHolder();
        private static final BulletEnv holder = new BulletEnv(null);

        private BulletEnvHolder() {
        }

        public final BulletEnv getHolder() {
            return holder;
        }
    }

    public final boolean getDebuggable() {
        return this.debuggable;
    }

    public final void setDebuggable(boolean z) {
        this.debuggable = z;
    }

    public final boolean getShowTag() {
        return this.showTag;
    }

    public final void setShowTag(boolean z) {
        this.showTag = z;
    }

    public final Function1<View, Unit> getOnTagClickListener() {
        return this.onTagClickListener;
    }

    public final void setOnTagClickListener(Function1<? super View, Unit> function1) {
        this.onTagClickListener = function1;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final void setApplication(Application application) {
        this.application = application;
    }

    /* renamed from: isFirstLoad, reason: from getter */
    public final boolean getIsFirstLoad() {
        return this.isFirstLoad;
    }

    public final void setFirstLoad(boolean z) {
        this.isFirstLoad = z;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final void setAppId(String str) {
        this.appId = str;
    }

    public final String getChannel() {
        return this.channel;
    }

    public final void setChannel(String str) {
        this.channel = str;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final void setAppVersion(String str) {
        this.appVersion = str;
    }

    public final String getDid() {
        return this.did;
    }

    public final void setDid(String str) {
        this.did = str;
    }

    public final void assertTrue(String errorMessage, Function0<Boolean> block) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(block, "block");
        if (this.debuggable && block.invoke().booleanValue()) {
            throw new RuntimeException(errorMessage);
        }
    }

    public final void markBulletView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setTag(TAG_ID, "AnnieX");
    }

    public final boolean isBulletView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return Intrinsics.areEqual(view.getTag(TAG_ID), "AnnieX") || (view instanceof SSWebView);
    }
}
