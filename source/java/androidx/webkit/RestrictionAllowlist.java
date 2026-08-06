package androidx.webkit;

import androidx.webkit.RestrictionAllowlist;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.chromium.support_lib_boundary.WebViewBuilderBoundaryInterface;

/* loaded from: classes2.dex */
public final class RestrictionAllowlist {
    private final List<ConfigTask> mConfigTasks;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface ConfigTask {
        void configure(WebViewBuilderBoundaryInterface.Config config);
    }

    private RestrictionAllowlist(List<ConfigTask> list) {
        this.mConfigTasks = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void configure(WebViewBuilderBoundaryInterface.Config config) {
        Iterator<ConfigTask> it = this.mConfigTasks.iterator();
        while (it.hasNext()) {
            it.next().configure(config);
        }
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        private final List<ConfigTask> mConfigTasks = new ArrayList();
        private final List<String> mOriginPatterns;

        public Builder(Set<String> set) {
            this.mOriginPatterns = new ArrayList(set);
        }

        public Builder addJavaScriptInterface(final Object obj, final String str) {
            this.mConfigTasks.add(new ConfigTask() { // from class: androidx.webkit.RestrictionAllowlist$Builder$$ExternalSyntheticLambda0
                @Override // androidx.webkit.RestrictionAllowlist.ConfigTask
                public final void configure(WebViewBuilderBoundaryInterface.Config config) {
                    RestrictionAllowlist.Builder.this.m7534xa22786c9(obj, str, config);
                }
            });
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$addJavaScriptInterface$0$androidx-webkit-RestrictionAllowlist$Builder, reason: not valid java name */
        public /* synthetic */ void m7534xa22786c9(Object obj, String str, WebViewBuilderBoundaryInterface.Config config) {
            config.addJavascriptInterface(obj, str, this.mOriginPatterns);
        }

        public RestrictionAllowlist build() {
            return new RestrictionAllowlist(this.mConfigTasks);
        }
    }
}
