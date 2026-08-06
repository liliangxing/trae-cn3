package com.bytedance.dataplatform;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.dataplatform.applog.AppLogManager;
import com.bytedance.dataplatform.client.ClientDataSource;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class ExposureManager {
    private Context context;
    private String currentUID;
    private String exposureInfo;
    private IExposureService exposureService;
    private Set<String> exposureVids;
    private Set<String> extraVids;
    private Set<String> userExposureVids;
    private Map<String, String> vidMap;
    private Set<String> clientExposureVids = new ConcurrentSkipListSet();
    private Map<String, Map<String, String>> clientExposureModuleVids = new ConcurrentHashMap();
    private List<String> noAptExperiemnts = new CopyOnWriteArrayList();

    public ExposureManager(Context context, IExposureService exposureService, Set<String> extraVids) {
        this.context = context;
        this.exposureService = exposureService;
        this.extraVids = extraVids;
        this.currentUID = CacheRepository.getString(context, "SP_EXPERIMENT_CACHE", ExperimentConst.CURRENT_UID);
        this.exposureVids = CacheRepository.getStringSet(context, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_EXPOSURE_CACHE");
        this.userExposureVids = CacheRepository.getStringSet(context, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_EXPOSURE_CACHE_" + this.currentUID);
        this.vidMap = CacheRepository.getAllString(context, "SP_EXPERIMENT_EXPOSURE_CACHE");
        for (String str : CacheRepository.getStringSet(context, "SP_EXPERIMENT_CACHE", "SP_CLIENT_EXPOSURE_CACHE")) {
            Map<String, String> allString = CacheRepository.getAllString(context, "SP_CLIENT_EXPOSURE_CACHE$$$" + str);
            this.clientExposureModuleVids.put(str, allString);
            this.clientExposureVids.addAll(allString.values());
        }
        updateExposureInfo();
        Worker.run(new Runnable() { // from class: com.bytedance.dataplatform.ExposureManager.1
            @Override // java.lang.Runnable
            public void run() {
                ExposureManager exposureManager = ExposureManager.this;
                exposureManager.clearClientVid(ExperimentConst.AB_TEST_NOAPT_MODULE_NAME, exposureManager.noAptExperiemnts);
            }
        }, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void expose(String key, boolean isBindToUser) {
        if (this.vidMap.containsKey(key)) {
            if (isBindToUser && TextUtils.isEmpty(this.currentUID)) {
                return;
            }
            String str = this.vidMap.get(key);
            if (!TextUtils.isEmpty(str) && !this.exposureVids.contains(str) && !this.userExposureVids.contains(str)) {
                if (isBindToUser) {
                    this.userExposureVids.add(str);
                    CacheRepository.saveStringSet(this.context, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_EXPOSURE_CACHE_" + this.currentUID, this.userExposureVids);
                } else {
                    this.exposureVids.add(str);
                    CacheRepository.saveStringSet(this.context, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_EXPOSURE_CACHE", this.exposureVids);
                }
                updateExposureInfo();
            }
            AppLogManager.sendExposureEvent(str, this.exposureInfo);
        }
    }

    private void updateExposureInfo() {
        String joinStringSet = (this.exposureVids.isEmpty() && this.userExposureVids.isEmpty() && this.clientExposureVids.isEmpty() && this.extraVids.isEmpty()) ? null : joinStringSet(this.exposureVids, this.userExposureVids, this.clientExposureVids, this.extraVids);
        if (TextUtils.equals(joinStringSet, this.exposureInfo)) {
            return;
        }
        this.exposureInfo = joinStringSet;
        IExposureService iExposureService = this.exposureService;
        if (iExposureService != null) {
            iExposureService.expose(joinStringSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateVidAndEt(Map<String, String> vidData, Map<String, Long> etData) {
        this.vidMap = vidData;
        CacheRepository.replaceAllString(this.context, "SP_EXPERIMENT_EXPOSURE_CACHE", vidData);
        this.exposureVids.retainAll(this.vidMap.values());
        CacheRepository.saveStringSet(this.context, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_EXPOSURE_CACHE", this.exposureVids);
        updateExposureInfo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> void exposeClient(String experimentKey, ClientDataSource<T> clientDataSource, String vid) {
        if (clientDataSource == null) {
            return;
        }
        String module = clientDataSource.getModule();
        if (!this.clientExposureModuleVids.containsKey(module)) {
            this.clientExposureModuleVids.put(module, new ConcurrentHashMap());
            CacheRepository.saveStringSet(this.context, "SP_EXPERIMENT_CACHE", "SP_CLIENT_EXPOSURE_CACHE", this.clientExposureModuleVids.keySet());
        }
        if (clientDataSource.getModuleExperiments() != null) {
            clearClientVid(module, Arrays.asList(clientDataSource.getModuleExperiments()));
        } else {
            this.noAptExperiemnts.add(experimentKey);
        }
        Map<String, String> map = this.clientExposureModuleVids.get(module);
        String str = map.get(experimentKey);
        if (!TextUtils.equals(str, vid)) {
            if (!TextUtils.isEmpty(str)) {
                this.clientExposureVids.remove(str);
                map.remove(experimentKey);
            }
            if (!TextUtils.isEmpty(vid)) {
                this.clientExposureVids.add(vid);
                map.put(experimentKey, vid);
            }
            CacheRepository.saveString(this.context, "SP_CLIENT_EXPOSURE_CACHE$$$" + module, experimentKey, vid);
            updateExposureInfo();
        }
        AppLogManager.sendExposureEvent(vid, this.exposureInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearClientVid(String module, List<String> experiemnts) {
        Map<String, String> map = this.clientExposureModuleVids.get(module);
        for (String str : map.keySet()) {
            if (!experiemnts.contains(str)) {
                try {
                    this.clientExposureVids.remove(map.get(str));
                    map.remove(str);
                    CacheRepository.removeKey(this.context, "SP_CLIENT_EXPOSURE_CACHE$$$" + module, str);
                } catch (Throwable unused) {
                }
            }
        }
    }

    public String getExposureInfo(String key) {
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        String str = this.vidMap.get(key);
        if (!TextUtils.isEmpty(str)) {
            if (this.exposureVids.contains(str)) {
                return str;
            }
            return null;
        }
        Iterator<Map<String, String>> it = this.clientExposureModuleVids.values().iterator();
        while (it.hasNext()) {
            String str2 = it.next().get(key);
            if (!TextUtils.isEmpty(str2)) {
                return str2;
            }
        }
        return null;
    }

    public String getAllExposureInfo() {
        return "exposureVids:" + this.exposureVids + "  clientExposureVids:" + this.clientExposureVids;
    }

    public void updateUserId(String userId) {
        if (TextUtils.isEmpty(userId) || "0".equals(userId)) {
            userId = "";
        }
        if (TextUtils.equals(this.currentUID, userId)) {
            return;
        }
        this.currentUID = userId;
        this.userExposureVids = CacheRepository.getStringSet(this.context, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_EXPOSURE_CACHE_" + this.currentUID);
        CacheRepository.saveString(this.context, "SP_EXPERIMENT_CACHE", ExperimentConst.CURRENT_UID, this.currentUID);
        updateExposureInfo();
    }

    public String getUserVids(String userId) {
        if (TextUtils.isEmpty(userId) || "0".equals(userId)) {
            userId = "";
        }
        return TextUtils.equals(this.currentUID, userId) ? this.exposureInfo : joinStringSet(CacheRepository.getStringSet(this.context, "SP_EXPERIMENT_CACHE", "SP_EXPERIMENT_EXPOSURE_CACHE_" + userId), this.exposureVids, this.clientExposureVids);
    }

    private String joinStringSet(Set<String>... stringSet) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Set<String> set : stringSet) {
            if (set != null) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    if (z) {
                        z = false;
                    } else {
                        sb.append(',');
                    }
                    sb.append(it.next());
                }
            }
        }
        return sb.toString();
    }
}
