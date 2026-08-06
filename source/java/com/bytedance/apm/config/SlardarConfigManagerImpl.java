package com.bytedance.apm.config;

import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm6.Apm6;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.bytedance.services.slardar.config.IResponseConfigListener;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SlardarConfigManagerImpl implements IConfigManager {
    private SlardarConfigFetcher mSlardarConfigFetcher = new SlardarConfigFetcher();

    public void initParams(boolean z, IQueryParams iQueryParams, List<String> list) {
        this.mSlardarConfigFetcher.initParams(z, iQueryParams, list);
    }

    public void forceUpdateFromRemote(IQueryParams iQueryParams, List<String> list) {
        this.mSlardarConfigFetcher.forceUpdateFromRemote(iQueryParams, list);
    }

    public void fetchConfig() {
        this.mSlardarConfigFetcher.initConfig();
    }

    public JSONObject getConfig() {
        return this.mSlardarConfigFetcher.getConfigData();
    }

    public String queryConfig() {
        return this.mSlardarConfigFetcher.queryFromLocal();
    }

    public boolean getLogTypeSwitch(String str) {
        return this.mSlardarConfigFetcher.getLogTypeSwitch(str);
    }

    public boolean getServiceSwitch(String str) {
        return this.mSlardarConfigFetcher.getServiceSwitch(str);
    }

    public boolean getMetricTypeSwitch(String str) {
        return this.mSlardarConfigFetcher.getMetricTypeSwitch(str);
    }

    public boolean getSwitch(String str) {
        return this.mSlardarConfigFetcher.getSwitch(str);
    }

    public JSONObject getConfigJSON(String str) {
        return this.mSlardarConfigFetcher.getJson(str);
    }

    public int getConfigInt(String str, int i) {
        return this.mSlardarConfigFetcher.getInt(str, i);
    }

    public boolean isConfigReady() {
        return this.mSlardarConfigFetcher.isReady();
    }

    public void registerConfigListener(IConfigListener iConfigListener) {
        this.mSlardarConfigFetcher.addConfigListener(iConfigListener);
    }

    public void unregisterConfigListener(IConfigListener iConfigListener) {
        this.mSlardarConfigFetcher.removeConfigListener(iConfigListener);
    }

    public void registerResponseConfigListener(IResponseConfigListener iResponseConfigListener) {
        Apm6.registerResponseConfigListener(iResponseConfigListener);
    }

    public void unregisterResponseConfigListener(IResponseConfigListener iResponseConfigListener) {
        Apm6.unregisterResponseConfigListener(iResponseConfigListener);
    }

    public boolean updateWithSpecificAidResult(JSONObject jSONObject) {
        return this.mSlardarConfigFetcher.updateWithSpecificAidResult(jSONObject);
    }

    public JSONObject retrieveSettingsParams() {
        return this.mSlardarConfigFetcher.retrieveSettingsParams();
    }
}
