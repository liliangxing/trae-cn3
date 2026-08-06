package androidx.webkit.internal;

import androidx.webkit.PrefetchException;
import androidx.webkit.PrefetchNetworkException;
import androidx.webkit.WebViewOutcomeReceiver;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.PrefetchOperationCallbackBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import org.chromium.support_lib_boundary.util.Features;

/* loaded from: classes2.dex */
public class PrefetchOperationCallbackAdapter {
    private PrefetchOperationCallbackAdapter() {
    }

    public static InvocationHandler buildInvocationHandler(final WebViewOutcomeReceiver<Void, PrefetchException> webViewOutcomeReceiver) {
        return BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new PrefetchOperationCallbackBoundaryInterface() { // from class: androidx.webkit.internal.PrefetchOperationCallbackAdapter.1
            @Override // org.chromium.support_lib_boundary.PrefetchOperationCallbackBoundaryInterface
            public void onSuccess() {
                WebViewOutcomeReceiver.this.onResult(null);
            }

            @Override // org.chromium.support_lib_boundary.PrefetchOperationCallbackBoundaryInterface
            public void onResult(int i) {
                if (i == 0 || i == 1) {
                    WebViewOutcomeReceiver.this.onResult(null);
                    return;
                }
                throw new IllegalArgumentException("Given type isn't defined.");
            }

            @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
            public String[] getSupportedFeatures() {
                return new String[]{Features.PREFETCH_WITH_CALLBACK_RESULT_V1};
            }

            @Override // org.chromium.support_lib_boundary.PrefetchOperationCallbackBoundaryInterface
            public void onFailure(int i, String str, int i2) {
                if (i == 1) {
                    WebViewOutcomeReceiver.this.onError(new PrefetchNetworkException(str, i2));
                } else {
                    WebViewOutcomeReceiver.this.onError(new PrefetchException(str));
                }
            }
        });
    }
}
