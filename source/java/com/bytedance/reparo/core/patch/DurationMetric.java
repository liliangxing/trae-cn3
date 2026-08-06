package com.bytedance.reparo.core.patch;

import android.text.TextUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.reparo.core.PatchLogger;
import com.bytedance.reparo.core.common.event.Event;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: classes4.dex */
public class DurationMetric {
    private String startTag;
    private long startTime;
    private HashMap<String, Long> metrics = new HashMap<>();
    private HashMap<String, String> errorsCategory = new HashMap<>();
    private LinkedList<String[]> nativeTags = new LinkedList<>();
    private LinkedList<long[]> nativeTimes = new LinkedList<>();

    public String[] getNativeTags() {
        String[] strArr = new String[100];
        this.nativeTags.add(strArr);
        return strArr;
    }

    public long[] getNativeTimes() {
        long[] jArr = new long[100];
        this.nativeTimes.add(jArr);
        return jArr;
    }

    public void start(String str) {
        this.startTime = System.currentTimeMillis();
        this.startTag = str;
    }

    public void end(String str) {
        if (str.equals(this.startTag)) {
            long currentTimeMillis = System.currentTimeMillis() - this.startTime;
            if (this.metrics.containsKey(str) && currentTimeMillis < this.metrics.get(str).longValue()) {
                return;
            } else {
                this.metrics.put(str, Long.valueOf(currentTimeMillis));
            }
        } else if (this.errorsCategory.isEmpty()) {
            this.errorsCategory.put("last", this.startTag);
            this.errorsCategory.put(PerfConsts.KEY_CURRENT_GALVANIC, str);
        }
        this.startTag = null;
    }

    public Event putEvent(Event event) {
        while (!this.nativeTags.isEmpty()) {
            String[] pop = this.nativeTags.pop();
            long[] pop2 = this.nativeTimes.pop();
            for (int i = 0; i < pop.length && !TextUtils.isEmpty(pop[i]); i++) {
                if (pop2[i] >= 0) {
                    String str = pop[i];
                    int i2 = 1;
                    while (this.metrics.containsKey(str)) {
                        str = pop[i] + i2;
                        i2++;
                    }
                    this.metrics.put(str, Long.valueOf(pop2[i]));
                } else {
                    this.errorsCategory.put("nativeErr", pop[i]);
                }
            }
        }
        for (Map.Entry<String, Long> entry : this.metrics.entrySet()) {
            event.putMetrics(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, String> entry2 : this.errorsCategory.entrySet()) {
            event.putCategory(entry2.getKey(), entry2.getValue());
            PatchLogger.w("DurationMetric", "error tag " + entry2.getKey() + " : " + entry2.getValue());
        }
        return event;
    }
}
