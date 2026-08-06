package com.bytedance.applog.sampling;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EventSampling {
    public static final String KEY_CONFIG_IDS = "config_ids";
    public static final String KEY_SAMPLING = "event_sampling";
    public static final String KEY_SAMPLING_CAPABILITY = "capability";
    public static final String KEY_SAMPLING_LOG_DATA = "log_data";
    public static final String KEY_SAMPLING_VERSION = "version";
    public static final int SAMPLING_METHOD_MODULO_CRC32_DID = 2;
    public static final int SAMPLING_METHOD_MODULO_DID = 3;
    public static final int SAMPLING_METHOD_RANDOM = 1;
    public static final int SAMPLING_METHOD_TEA_HASH_DID = 4;
    public static final int SAMPLING_METHOD_TEA_HASH_UT_UID = 6;
    public static final int SWITCH_NON_TEA = 1;
    public static final int SWITCH_TEA = 2;
    private int capability;
    private JSONArray configIdArray;
    private JSONArray configJson;
    private final List<AbsSamplingStrategy> mSamplingStrategyList = new ArrayList();
    private int mSamplingVersion;

    public int getSamplingVersion() {
        return this.mSamplingVersion;
    }

    public void setSamplingVersion(int i) {
        this.mSamplingVersion = i;
    }

    public void setCapability(int i) {
        this.capability = i;
    }

    public int getCapability() {
        return this.capability;
    }

    public void setConfigIdArray(JSONArray jSONArray) {
        this.configIdArray = jSONArray;
    }

    public JSONArray getConfigIdArray() {
        return this.configIdArray;
    }

    public void setConfigJson(JSONArray jSONArray) {
        this.configJson = jSONArray;
    }

    public JSONArray getConfigJson() {
        return this.configJson;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addSamplingStrategy(int i, int i2, Set<String> set, Map<String, List<Set<String>>> map, Map<String, List<Map<String, Object>>> map2) {
        AbsSamplingStrategy samplingRandom;
        AbsSamplingStrategy absSamplingStrategy;
        if (i2 == 1) {
            samplingRandom = new SamplingRandom(i, set, map, map2);
        } else if (i2 == 2) {
            samplingRandom = new SamplingCrc32Did(i, set, map, map2);
        } else if (i2 == 3) {
            samplingRandom = new SamplingModDid(i, set, map, map2);
        } else if (i2 == 4) {
            samplingRandom = new SamplingTeaHashDid(i, set, map, map2);
        } else {
            if (i2 != 6) {
                absSamplingStrategy = null;
                if (absSamplingStrategy == null) {
                    this.mSamplingStrategyList.add(absSamplingStrategy);
                    return;
                }
                return;
            }
            samplingRandom = new SamplingTeaHashUtUid(i, set, map, map2);
        }
        absSamplingStrategy = samplingRandom;
        if (absSamplingStrategy == null) {
        }
    }

    public boolean isHitSamplingDrop(AbsSamplingUser absSamplingUser, String str) {
        return isHitSamplingDropString(absSamplingUser, str, "");
    }

    public boolean isHitSamplingDropString(AbsSamplingUser absSamplingUser, String str, String str2) {
        for (AbsSamplingStrategy absSamplingStrategy : this.mSamplingStrategyList) {
            if (absSamplingStrategy.isEventMatchString(str, str2)) {
                return absSamplingStrategy.isHitSamplingDrop(absSamplingUser);
            }
        }
        return false;
    }

    public boolean isHitSamplingDrop(AbsSamplingUser absSamplingUser, String str, JSONObject jSONObject) {
        for (AbsSamplingStrategy absSamplingStrategy : this.mSamplingStrategyList) {
            if (absSamplingStrategy.isEventMatch(str, jSONObject)) {
                return absSamplingStrategy.isHitSamplingDrop(absSamplingUser);
            }
        }
        return false;
    }

    public boolean isHitStickySamplingDrop(AbsSamplingUser absSamplingUser, String str, JSONObject jSONObject) {
        for (AbsSamplingStrategy absSamplingStrategy : this.mSamplingStrategyList) {
            if (absSamplingStrategy.isEventMatch(str, jSONObject)) {
                if (absSamplingStrategy instanceof SamplingRandom) {
                    return false;
                }
                return absSamplingStrategy.isHitSamplingDrop(absSamplingUser);
            }
        }
        return false;
    }

    public boolean hasStrategy() {
        return !this.mSamplingStrategyList.isEmpty();
    }
}
