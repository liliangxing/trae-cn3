package com.bytedance.android.anniex.base.depend;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ApplicationDepend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0017J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/anniex/base/depend/ApplicationDepend;", "", "()V", "cachedWebUserAgent", "", "getCachedWebUserAgent", "getCachedWebUserAgent$anniex_release", "getDomainParty", "", "url", "getWebUserAgent", "isBaseMode", "", "isDarkMode", "isDebug", "isDouyinPaas", "isPreInstallApp", "isPrivacyDialogShow", "DomainParty", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public class ApplicationDepend {
    private String cachedWebUserAgent;

    @DomainParty
    public int getDomainParty(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return 1;
    }

    public String getWebUserAgent() {
        return AnnieXRuntime.NOT_IMPLEMENT;
    }

    public boolean isBaseMode() {
        return false;
    }

    public boolean isDarkMode() {
        return false;
    }

    public boolean isDebug() {
        return false;
    }

    public boolean isDouyinPaas() {
        return false;
    }

    public boolean isPreInstallApp() {
        return false;
    }

    public boolean isPrivacyDialogShow() {
        return false;
    }

    public final String getCachedWebUserAgent$anniex_release() {
        String str = this.cachedWebUserAgent;
        if (str != null) {
            return str;
        }
        String webUserAgent = getWebUserAgent();
        this.cachedWebUserAgent = webUserAgent;
        return webUserAgent;
    }

    /* compiled from: ApplicationDepend.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/anniex/base/depend/ApplicationDepend$DomainParty;", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes2.dex */
    public @interface DomainParty {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int FIRST = 1;
        public static final int SECOND = 2;
        public static final int THIRD = 3;

        /* compiled from: ApplicationDepend.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/anniex/base/depend/ApplicationDepend$DomainParty$Companion;", "", "()V", "FIRST", "", "SECOND", "THIRD", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int FIRST = 1;
            public static final int SECOND = 2;
            public static final int THIRD = 3;

            private Companion() {
            }
        }
    }
}
