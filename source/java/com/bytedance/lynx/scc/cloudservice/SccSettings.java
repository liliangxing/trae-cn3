package com.bytedance.lynx.scc.cloudservice;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.lynx.scc.cloudservice.utils.JsonUtils;
import com.bytedance.lynx.scc.cloudservice.utils.SccUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SccSettings {
    private int mCsMaxWaitMs;
    private final Set<String> mDomainAllowSet;
    private boolean mEnablePrefetch;
    private boolean mEnableScc;
    private boolean mIsDebug;
    private String mSeclinkScene;

    public SccSettings() {
        this.mEnableScc = true;
        this.mEnablePrefetch = false;
        this.mCsMaxWaitMs = 450;
        this.mSeclinkScene = null;
        this.mIsDebug = false;
        this.mDomainAllowSet = new HashSet();
    }

    public SccSettings(SccSettings settings) {
        this.mEnableScc = settings.mEnableScc;
        this.mEnablePrefetch = settings.mEnablePrefetch;
        this.mCsMaxWaitMs = settings.mCsMaxWaitMs;
        this.mSeclinkScene = settings.mSeclinkScene;
        this.mIsDebug = settings.mIsDebug;
        this.mDomainAllowSet = new HashSet(settings.mDomainAllowSet);
    }

    public boolean isEnableScc() {
        return this.mEnableScc;
    }

    public void setEnableScc(boolean enableScc) {
        this.mEnableScc = enableScc;
    }

    public boolean isEnablePrefetch() {
        return this.mEnablePrefetch;
    }

    public void setEnablePrefetch(boolean enablePrefetch) {
        this.mEnablePrefetch = enablePrefetch;
    }

    public int getCsMaxWaitMs() {
        return this.mCsMaxWaitMs;
    }

    public void setCsMaxWaitMs(int csMaxWaitMs) {
        this.mCsMaxWaitMs = csMaxWaitMs;
    }

    public String getSeclinkScene() {
        return this.mSeclinkScene;
    }

    public void setSeclinkScene(String seclinkScene) {
        this.mSeclinkScene = seclinkScene;
    }

    public boolean isDebug() {
        return this.mIsDebug;
    }

    public void setDebug(boolean isDebug) {
        this.mIsDebug = isDebug;
    }

    public void addAllowDomains(Collection<String> allowDomains) {
        if (allowDomains != null) {
            this.mDomainAllowSet.addAll(allowDomains);
        }
    }

    public void removeAllowDomains(Collection<String> removeDomains) {
        if (removeDomains != null) {
            this.mDomainAllowSet.removeAll(removeDomains);
        }
    }

    public void clearAllowDomains() {
        this.mDomainAllowSet.clear();
    }

    public SccUrlCheckResult hitAllowDomains(String host) {
        if (TextUtils.isEmpty(host)) {
            return null;
        }
        for (String str : this.mDomainAllowSet) {
            if (host.equals(str) || host.endsWith(LibrarianImpl.Constants.DOT + str)) {
                return new SccUrlCheckResult(true, str);
            }
        }
        return null;
    }

    public String toString() {
        return "SccSettings{mEnableScc=" + this.mEnableScc + ", mEnablePrefetch=" + this.mEnablePrefetch + ", mCsMaxWaitMs=" + this.mCsMaxWaitMs + ", mSeclinkScene='" + this.mSeclinkScene + "', mIsDebug=" + this.mIsDebug + ", mDomainAllowSet=" + this.mDomainAllowSet + '}';
    }

    public static void fromJson(JsonObject json, SccSettings settings) {
        settings.setEnableScc(SccCloudServiceManager.getGlobalSccSettings().isEnableScc() && json != null && JsonUtils.getJsonValueAsBoolean(json, SccUtils.CS_ENABLE, false));
        if (settings.isEnableScc()) {
            settings.setDebug(JsonUtils.getJsonValueAsBoolean(json, SccUtils.CS_IS_DEBUG, settings.isDebug()));
            settings.setEnablePrefetch(JsonUtils.getJsonValueAsBoolean(json, SccUtils.CS_ENABLE_PREFETCH, settings.isEnablePrefetch()));
            int jsonValueAsInt = JsonUtils.getJsonValueAsInt(json, SccUtils.CS_MAX_WAIT_TIME, settings.getCsMaxWaitMs());
            if (jsonValueAsInt <= 0) {
                jsonValueAsInt = 450;
            }
            settings.setCsMaxWaitMs(jsonValueAsInt);
            settings.setSeclinkScene(JsonUtils.getJsonValueAsString(json, SccUtils.CS_SECLINK_SCENE, settings.getSeclinkScene()));
            JsonArray jsonValueAsArray = JsonUtils.getJsonValueAsArray(json, SccUtils.CS_ALLOW_LIST);
            if (jsonValueAsArray == null || jsonValueAsArray.size() <= 0) {
                return;
            }
            HashSet hashSet = new HashSet();
            for (int i = 0; i < jsonValueAsArray.size(); i++) {
                JsonElement jsonElement = jsonValueAsArray.get(i);
                if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isString()) {
                    hashSet.add(jsonElement.getAsString());
                }
            }
            settings.addAllowDomains(hashSet);
        }
    }
}
