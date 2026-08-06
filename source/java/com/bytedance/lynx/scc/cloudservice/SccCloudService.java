package com.bytedance.lynx.scc.cloudservice;

import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import com.bytedance.lynx.scc.cloudservice.worker.SccCloudServiceImpl;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class SccCloudService {
    private final ArrayList<String> mDenyUrls;
    private final ArrayList<String> mNoticeUrls;
    private final SccCloudServiceImpl mServiceImpl;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface SccUrlCheckerDelegate {
        boolean isInAllowList(String url);
    }

    public SccCloudService() {
        this(null);
    }

    public SccCloudService(SccUrlCheckerDelegate delegate) {
        this.mServiceImpl = new SccCloudServiceImpl(delegate);
        this.mNoticeUrls = new ArrayList<>();
        this.mDenyUrls = new ArrayList<>();
    }

    public void doCheck(String url) {
        this.mServiceImpl.doCheck(url);
    }

    public void setSettingsJsonConfig(JsonObject json) {
        this.mServiceImpl.setSettingsJsonConfig(json);
    }

    public void setSeclinkScene(String scene) {
        this.mServiceImpl.setSeclinkScene(scene);
    }

    public void onUserAllow(String url) {
        this.mServiceImpl.onUserAllow(url);
    }

    public void addDomainsAllowList(List<String> domains) {
        this.mServiceImpl.addDomainsAllowList(domains);
    }

    public void clearAllowList() {
        this.mServiceImpl.clearAllowList();
    }

    public SccResult getCloudServiceResponse(String url) {
        return this.mServiceImpl.getCloudServiceResponse(url);
    }

    public WebResourceResponse tryGetPrefetchResponse(String url) {
        return this.mServiceImpl.tryGetPrefetchResponse(url);
    }

    public boolean isEnable() {
        return this.mServiceImpl.getSettings().isEnableScc();
    }

    public SccSettings getSettingsForTest() {
        return this.mServiceImpl.getSettings();
    }

    public void addNoticeUrls(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        synchronized (this.mNoticeUrls) {
            this.mNoticeUrls.add(url);
        }
    }

    public void addDenyUrl(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        synchronized (this.mDenyUrls) {
            this.mDenyUrls.add(url);
        }
    }

    public boolean isNoticeUrl(String url) {
        boolean remove;
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        synchronized (this.mNoticeUrls) {
            remove = this.mNoticeUrls.remove(url);
        }
        return remove;
    }

    public boolean isDenyUrl(String url) {
        boolean remove;
        if (TextUtils.isEmpty(url)) {
            return false;
        }
        synchronized (this.mDenyUrls) {
            remove = this.mDenyUrls.remove(url);
        }
        return remove;
    }
}
