package androidx.webkit.internal;

import androidx.webkit.Navigation;
import androidx.webkit.NavigationListener;
import androidx.webkit.Page;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebViewNavigationListenerBoundaryInterface;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class NavigationListenerAdapter implements WebViewNavigationListenerBoundaryInterface {
    private static final String[] SUPPORTED_FEATURES = {"WEB_VIEW_NAVIGATION_LISTENER_V1", "WEB_VIEW_NAVIGATION_LISTENER_V2"};
    private final NavigationListener mImpl;

    @Deprecated
    public void onFirstContentfulPaint(InvocationHandler invocationHandler, long j) {
    }

    public NavigationListenerAdapter(NavigationListener navigationListener) {
        this.mImpl = navigationListener;
    }

    public void onNavigationStarted(InvocationHandler invocationHandler) {
        this.mImpl.onNavigationStarted(Navigation.forInvocationHandler(invocationHandler));
    }

    public void onNavigationRedirected(InvocationHandler invocationHandler) {
        this.mImpl.onNavigationRedirected(Navigation.forInvocationHandler(invocationHandler));
    }

    public void onNavigationCompleted(InvocationHandler invocationHandler) {
        this.mImpl.onNavigationCompleted(Navigation.forInvocationHandler(invocationHandler));
    }

    public void onPageDeleted(InvocationHandler invocationHandler) {
        this.mImpl.onPageDeleted(Page.forInvocationHandler(invocationHandler));
    }

    public void onPageLoadEventFired(InvocationHandler invocationHandler) {
        this.mImpl.onPageLoadEvent(Page.forInvocationHandler(invocationHandler));
    }

    public void onPageDOMContentLoadedEventFired(InvocationHandler invocationHandler) {
        this.mImpl.onPageDomContentLoadedEvent(Page.forInvocationHandler(invocationHandler));
    }

    public void onFirstContentfulPaintMillis(InvocationHandler invocationHandler, long j) {
        this.mImpl.onFirstContentfulPaintMillis(Page.forInvocationHandler(invocationHandler), j);
    }

    public void onLargestContentfulPaintMillis(InvocationHandler invocationHandler, long j) {
        this.mImpl.onLargestContentfulPaintMillis(Page.forInvocationHandler(invocationHandler), j);
    }

    public void onPerformanceMarkMillis(InvocationHandler invocationHandler, String str, long j) {
        this.mImpl.onPerformanceMarkMillis(Page.forInvocationHandler(invocationHandler), str, j);
    }

    public String[] getSupportedFeatures() {
        return SUPPORTED_FEATURES;
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof NavigationListenerAdapter)) {
            return this.mImpl.equals(((NavigationListenerAdapter) obj).mImpl);
        }
        return false;
    }
}
