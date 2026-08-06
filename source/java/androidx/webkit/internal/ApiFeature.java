package androidx.webkit.internal;

import android.os.Build;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public abstract class ApiFeature implements ConditionallySupportedFeature {
    private static final Set<ApiFeature> sValues = new HashSet();
    private final String mInternalFeatureValue;
    private final String mPublicFeatureValue;

    public abstract boolean isSupportedByFramework();

    ApiFeature(String str, String str2) {
        this.mPublicFeatureValue = str;
        this.mInternalFeatureValue = str2;
        sValues.add(this);
    }

    @Override // androidx.webkit.internal.ConditionallySupportedFeature
    public String getPublicFeatureName() {
        return this.mPublicFeatureValue;
    }

    @Override // androidx.webkit.internal.ConditionallySupportedFeature
    public boolean isSupported() {
        return isSupportedByFramework() || isSupportedByWebView();
    }

    public boolean isSupportedByWebView() {
        return BoundaryInterfaceReflectionUtil.containsFeature(LAZY_HOLDER.WEBVIEW_APK_FEATURES, this.mInternalFeatureValue);
    }

    public static Set<ApiFeature> values() {
        return Collections.unmodifiableSet(sValues);
    }

    public static Set<String> getWebViewApkFeaturesForTesting() {
        return LAZY_HOLDER.WEBVIEW_APK_FEATURES;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class LAZY_HOLDER {
        static final Set<String> WEBVIEW_APK_FEATURES = new HashSet(Arrays.asList(WebViewGlueCommunicator.getFactory().getWebViewFeatures()));

        private LAZY_HOLDER() {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class NoFramework extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public NoFramework(String str, String str2) {
            super(str, str2);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class NoFrameworkInternal extends ApiFeature {
        private static final String PUBLIC_NAME = "IMPLEMENTATION_ONLY_FEATURE";

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public NoFrameworkInternal(String str) {
            super(PUBLIC_NAME, str);
        }
    }

    /* renamed from: androidx.webkit.internal.ApiFeature$M */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class C0579M extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0579M(String str, String str2) {
            super(str, str2);
        }
    }

    /* renamed from: androidx.webkit.internal.ApiFeature$N */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class C0580N extends ApiFeature {
        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0580N(String str, String str2) {
            super(str, str2);
        }
    }

    /* renamed from: androidx.webkit.internal.ApiFeature$O */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class C0581O extends ApiFeature {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C0581O(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 26;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class O_MR1 extends ApiFeature {
        /* JADX INFO: Access modifiers changed from: package-private */
        public O_MR1(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 27;
        }
    }

    /* renamed from: androidx.webkit.internal.ApiFeature$P */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class C0582P extends ApiFeature {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C0582P(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 28;
        }
    }

    /* renamed from: androidx.webkit.internal.ApiFeature$Q */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class C0583Q extends ApiFeature {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C0583Q(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 29;
        }
    }

    /* renamed from: androidx.webkit.internal.ApiFeature$T */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class C0584T extends ApiFeature {
        /* JADX INFO: Access modifiers changed from: package-private */
        public C0584T(String str, String str2) {
            super(str, str2);
        }

        @Override // androidx.webkit.internal.ApiFeature
        public final boolean isSupportedByFramework() {
            return Build.VERSION.SDK_INT >= 33;
        }
    }
}
