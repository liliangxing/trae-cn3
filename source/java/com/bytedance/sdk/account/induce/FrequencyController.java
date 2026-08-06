package com.bytedance.sdk.account.induce;

import android.text.TextUtils;
import com.ss.android.LogHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
class FrequencyController {
    private static final String TAG = "FrequencyController";
    private ArrayList<Long> mAllSceneShowLoginTimes;
    private final InduceRecorder mInduceRecorder;
    private Map<String, List<Long>> mSceneShowLoginTimes;

    /* loaded from: classes5.dex */
    interface RangeType {
        public static final String DAY = "day";
        public static final String HOUR = "hour";
        public static final String MINUTE = "minute";
        public static final String WEEK = "week";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrequencyController(InduceRecorder induceRecorder) {
        this.mInduceRecorder = induceRecorder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean satisfyFrequencyTypeInRange(String str, int i, int i2, int i3) {
        initHistoryLoginTimesListIfNeed();
        return satisfyFrequencyTypeInRange(this.mAllSceneShowLoginTimes, str, i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean satisfyFrequencyTypeInRangeForScene(String str, String str2, int i, int i2, int i3) {
        initHistoryLoginTimesListIfNeed();
        Map<String, List<Long>> map = this.mSceneShowLoginTimes;
        if (map == null) {
            return true;
        }
        return satisfyFrequencyTypeInRange(map.get(str), str2, i, i2, i3);
    }

    private boolean satisfyFrequencyTypeInRange(List<Long> list, String str, int i, int i2, int i3) {
        if (list == null || list.isEmpty() || i == 0) {
            return true;
        }
        int size = list.size();
        if (i3 != -1 && size >= i3) {
            return false;
        }
        long sentinelTime = getSentinelTime(str, i);
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                break;
            }
            if (list.get((size - 1) - i4).longValue() < sentinelTime) {
                size = i4;
                break;
            }
            if (i4 >= i2) {
                return false;
            }
            i4++;
        }
        return size < i2;
    }

    private long getSentinelTime(String str, int i) {
        long currentTimeMillis;
        long millis;
        long currentTimeMillis2 = System.currentTimeMillis();
        if (RangeType.WEEK.equalsIgnoreCase(str)) {
            currentTimeMillis = System.currentTimeMillis();
            millis = TimeUnit.DAYS.toMillis(i) * 7;
        } else if (RangeType.DAY.equalsIgnoreCase(str)) {
            currentTimeMillis = System.currentTimeMillis();
            millis = TimeUnit.DAYS.toMillis(i);
        } else if (RangeType.HOUR.equalsIgnoreCase(str)) {
            currentTimeMillis = System.currentTimeMillis();
            millis = TimeUnit.HOURS.toMillis(i);
        } else {
            if (!RangeType.MINUTE.equalsIgnoreCase(str)) {
                return currentTimeMillis2;
            }
            currentTimeMillis = System.currentTimeMillis();
            millis = TimeUnit.MINUTES.toMillis(i);
        }
        return currentTimeMillis - millis;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void markShowLogin(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        initHistoryLoginTimesListIfNeed();
        initLoginTimesListIfNeed(str);
        List<Long> list = this.mSceneShowLoginTimes.get(str);
        if (list == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        list.add(Long.valueOf(currentTimeMillis));
        this.mAllSceneShowLoginTimes.add(Long.valueOf(currentTimeMillis));
        Collections.sort(list);
        Collections.sort(this.mAllSceneShowLoginTimes);
        saveTimes(str, list);
    }

    private void initHistoryLoginTimesListIfNeed() {
        if (this.mAllSceneShowLoginTimes == null || this.mSceneShowLoginTimes == null) {
            this.mAllSceneShowLoginTimes = new ArrayList<>();
            this.mSceneShowLoginTimes = new HashMap();
            Set<String> allSceneShowKeys = this.mInduceRecorder.getAllSceneShowKeys();
            if (!allSceneShowKeys.isEmpty()) {
                for (String str : allSceneShowKeys) {
                    List<Long> transferTimesStringToList = transferTimesStringToList(this.mInduceRecorder.getSceneShowTimes(str));
                    Collections.sort(transferTimesStringToList);
                    this.mSceneShowLoginTimes.put(str, transferTimesStringToList);
                    this.mAllSceneShowLoginTimes.addAll(transferTimesStringToList);
                }
            }
            Collections.sort(this.mAllSceneShowLoginTimes);
        }
    }

    private void initLoginTimesListIfNeed(String str) {
        if (this.mSceneShowLoginTimes.get(str) == null) {
            this.mSceneShowLoginTimes.put(str, new ArrayList());
        }
    }

    private List<Long> transferTimesStringToList(String str) {
        String[] split;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str) && (split = str.split(",")) != null && split.length > 0) {
            try {
                for (String str2 : split) {
                    arrayList.add(Long.valueOf(Long.parseLong(str2)));
                }
            } catch (Exception e) {
                LogHelper.e(TAG, "transferTimesStringToList", e);
            }
        }
        return arrayList;
    }

    void saveTimes(String str, List<Long> list) {
        StringBuilder sb = new StringBuilder();
        for (Long l : list) {
            if (sb.length() > 0) {
                sb.append(",").append(l);
            } else {
                sb.append(l);
            }
        }
        this.mInduceRecorder.saveSceneShowTimes(str, sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long lastShowLoginTimeAllScene() {
        initHistoryLoginTimesListIfNeed();
        if (this.mAllSceneShowLoginTimes.isEmpty()) {
            return 0L;
        }
        return this.mAllSceneShowLoginTimes.get(r0.size() - 1).longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long lastShowLoginTimeByScene(String str) {
        initHistoryLoginTimesListIfNeed();
        List<Long> list = this.mSceneShowLoginTimes.get(str);
        if (list == null || list.isEmpty()) {
            return 0L;
        }
        return list.get(list.size() - 1).longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        Map<String, List<Long>> map = this.mSceneShowLoginTimes;
        if (map != null) {
            map.clear();
        }
        ArrayList<Long> arrayList = this.mAllSceneShowLoginTimes;
        if (arrayList != null) {
            arrayList.clear();
        }
        this.mInduceRecorder.clearSceneShowTimes();
    }
}
