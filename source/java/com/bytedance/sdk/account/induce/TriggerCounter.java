package com.bytedance.sdk.account.induce;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class TriggerCounter {
    private final InduceRecorder mInduceRecorder;
    private Map<String, Long> mSceneTriggerCount;

    /* loaded from: classes5.dex */
    interface TriggerType {
        public static final int FROM_X = 2;
        public static final int NONE = 0;
        public static final int PER_X = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TriggerCounter(InduceRecorder induceRecorder) {
        this.mInduceRecorder = induceRecorder;
    }

    private void initSceneTriggerCountMapIfNeed() {
        if (this.mSceneTriggerCount != null) {
            return;
        }
        this.mSceneTriggerCount = new HashMap();
        Set<String> allTriggerCountKeys = this.mInduceRecorder.getAllTriggerCountKeys();
        if (allTriggerCountKeys.isEmpty()) {
            return;
        }
        for (String str : allTriggerCountKeys) {
            this.mSceneTriggerCount.put(str, Long.valueOf(this.mInduceRecorder.getSceneCurrentCount(str)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        if (r11 >= r7) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        if (r11 <= r7) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void increaseProgress(JSONObject jSONObject, String str, long j, long j2) {
        boolean z;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        Long l = 0L;
        if (j2 > 0 && (optJSONObject = jSONObject.optJSONObject("scenes")) != null && (optJSONObject2 = optJSONObject.optJSONObject(str)) != null && (optJSONObject3 = optJSONObject2.optJSONObject("trigger")) != null && (optJSONObject4 = optJSONObject3.optJSONObject(NotificationCompat.CATEGORY_PROGRESS)) != null) {
            String optString = optJSONObject4.optString("type");
            int optInt = optJSONObject4.optInt("percent");
            z = true;
            if (TextUtils.equals(optString, "lower")) {
            }
            if (TextUtils.equals(optString, "upper")) {
            }
        }
        z = false;
        initSceneTriggerCountMapIfNeed();
        Long l2 = this.mSceneTriggerCount.get(str);
        if (l2 == null) {
            l2 = l;
        }
        if (!z) {
            l = Long.valueOf(l2.longValue() + j);
        }
        this.mSceneTriggerCount.put(str, l);
        this.mInduceRecorder.markSceneCurrentCount(str, l.longValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long currentSceneProgress(String str) {
        initSceneTriggerCountMapIfNeed();
        Long l = this.mSceneTriggerCount.get(str);
        if (l == null) {
            l = 0L;
        }
        return l.longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean satisfyTriggerCondition(String str, int i, int i2, long j) {
        Long l;
        initSceneTriggerCountMapIfNeed();
        if (i <= 0 || i2 < 0 || (l = this.mSceneTriggerCount.get(str)) == null || l.longValue() < j) {
            return false;
        }
        if (i == 1) {
            if (j == 1) {
                return l.longValue() % ((long) i2) == 0;
            }
            long j2 = i2;
            if (j > j2 || ((l.longValue() - j) % j2) + j >= j2) {
                return true;
            }
        }
        return i == 2 && l.longValue() >= ((long) i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        Map<String, Long> map = this.mSceneTriggerCount;
        if (map != null) {
            map.clear();
        }
        this.mInduceRecorder.clearSceneTriggerCount();
    }
}
