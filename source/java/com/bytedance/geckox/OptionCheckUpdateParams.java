package com.bytedance.geckox;

import com.bytedance.geckox.listener.GeckoUpdateListener;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: classes3.dex */
public class OptionCheckUpdateParams {
    private boolean lazyUpdate;
    private GeckoUpdateListener listener;
    private boolean enableThrottle = true;
    private Map<String, Map<String, Object>> customParam = new HashMap();
    private boolean enableRetry = true;
    private boolean enableDownloadAutoRetry = true;
    private int updatePriority = 1;
    private boolean requestWhenHasLocalVersion = true;
    private String tag = null;

    /* loaded from: classes3.dex */
    public interface ChannelUpdatePriority {
        public static final int HIGH = 2;
        public static final int LOW = 0;
        public static final int MIDDLE = 1;
        public static final int USE_INTERACTION = 3;
    }

    /* loaded from: classes3.dex */
    public interface CustomValue {
        Object getValue();
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean isEnableThrottle() {
        return this.enableThrottle;
    }

    public GeckoUpdateListener getListener() {
        return this.listener;
    }

    public Map<String, Map<String, Object>> getCustomParam() {
        return this.customParam;
    }

    public boolean isEnableRetry() {
        return this.enableRetry;
    }

    public boolean isLazyUpdate() {
        return this.lazyUpdate;
    }

    public boolean isEnableDownloadAutoRetry() {
        return this.enableDownloadAutoRetry;
    }

    public int getChannelUpdatePriority() {
        return this.updatePriority;
    }

    public boolean isRequestWhenHasLocalVersion() {
        return this.requestWhenHasLocalVersion;
    }

    public OptionCheckUpdateParams setEnableThrottle(boolean z) {
        this.enableThrottle = z;
        return this;
    }

    public OptionCheckUpdateParams setListener(GeckoUpdateListener geckoUpdateListener) {
        this.listener = geckoUpdateListener;
        return this;
    }

    public OptionCheckUpdateParams setCustomParam(Map<String, Map<String, Object>> map) {
        this.customParam = map;
        return this;
    }

    public OptionCheckUpdateParams setEnableRetry(boolean z) {
        this.enableRetry = z;
        return this;
    }

    public OptionCheckUpdateParams setEnableDownloadAutoRetry(boolean z) {
        this.enableDownloadAutoRetry = z;
        return this;
    }

    public OptionCheckUpdateParams setLazyUpdate(boolean z) {
        this.lazyUpdate = z;
        return this;
    }

    public OptionCheckUpdateParams setChannelUpdatePriority(int i) {
        this.updatePriority = i;
        return this;
    }

    public OptionCheckUpdateParams setRequestWhenHasLocalVersion(boolean z) {
        this.requestWhenHasLocalVersion = z;
        return this;
    }
}
