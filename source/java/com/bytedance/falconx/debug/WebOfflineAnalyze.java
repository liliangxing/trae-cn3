package com.bytedance.falconx.debug;

import com.bytedance.falconx.WebOfflineConfig;
import com.bytedance.falconx.debug.model.WebOfflineRuleModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class WebOfflineAnalyze {
    private static List<WebOfflineRuleModel> caches;
    private static final List<MatchResult> matchResult = new ArrayList();

    public static void addOfflineCache(WebOfflineConfig webOfflineConfig) {
        if (WebOfflineDebug.isDebug()) {
            if (caches == null) {
                caches = new ArrayList();
            }
            WebOfflineRuleModel webOfflineRuleModel = new WebOfflineRuleModel(webOfflineConfig.getAccessKey(), webOfflineConfig.getCachePrefix(), webOfflineConfig.getCacheDir(), webOfflineConfig.getDeviceId(), webOfflineConfig.isNeedServerMonitor(), webOfflineConfig.getAppVersion(), webOfflineConfig.getHost(), webOfflineConfig.getRegion());
            if (caches.contains(webOfflineRuleModel)) {
                return;
            }
            caches.add(webOfflineRuleModel);
        }
    }

    public static void matchFailed(String str, String str2, long j) {
        if (WebOfflineDebug.isDebug()) {
            List<MatchResult> list = matchResult;
            synchronized (list) {
                list.add(new MatchResult(false, str, str2, j));
            }
        }
    }

    public static void matchSuccess(String str, String str2, long j) {
        if (WebOfflineDebug.isDebug()) {
            List<MatchResult> list = matchResult;
            synchronized (list) {
                list.add(new MatchResult(true, str, str2, j));
            }
        }
    }

    public static List<MatchResult> getMatchResult() {
        return matchResult;
    }

    public static List<WebOfflineRuleModel> getCaches() {
        return caches;
    }

    /* loaded from: classes3.dex */
    public static class MatchResult {
        public boolean match;
        public String msg;
        public String url;
        public long version;

        public MatchResult(boolean z, String str, String str2, long j) {
            this.match = z;
            this.url = str;
            this.msg = str2;
            this.version = j;
        }
    }

    public static void release() {
        List<WebOfflineRuleModel> list = caches;
        if (list == null) {
            return;
        }
        list.clear();
        caches = null;
        matchResult.clear();
    }
}
