package com.bytedance.push.settings.delay.start;

import com.bytedance.common.push.BaseJson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class DelayStartChildProcessSettingsModel extends BaseJson {
    private final String DELAY_START_CHILD_PROCESS_MODE = "delay_start_child_process_mode";
    private final String DELAY_START_CHILD_PROCESS_TIMEOUT_IN_MILL = "delay_start_child_process_timeout_in_mill";
    private final String NEED_DISABLE_CHANNEL = "need_disable_channel";
    public int delayStartChildProcessMode;
    public long delayStartChildProcessTimeoutInMill;
    public List<Integer> needDisableChannel;

    public DelayStartChildProcessSettingsModel() {
        init();
    }

    private void init() {
        this.delayStartChildProcessMode = 0;
        this.delayStartChildProcessTimeoutInMill = 300000L;
        this.needDisableChannel = new ArrayList();
    }

    public DelayStartChildProcessSettingsModel(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.delayStartChildProcessMode = jSONObject.optInt("delay_start_child_process_mode", 0);
            this.delayStartChildProcessTimeoutInMill = jSONObject.optLong("delay_start_child_process_timeout_in_mill", 300000L);
            JSONArray optJSONArray = jSONObject.optJSONArray("need_disable_channel");
            this.needDisableChannel = new ArrayList();
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    this.needDisableChannel.add((Integer) optJSONArray.get(i));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
            init();
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        add(jSONObject, "delay_start_child_process_mode", this.delayStartChildProcessMode);
        add(jSONObject, "delay_start_child_process_timeout_in_mill", this.delayStartChildProcessTimeoutInMill);
        JSONArray jSONArray = new JSONArray();
        Iterator<Integer> it = this.needDisableChannel.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        add(jSONObject, "need_disable_channel", jSONArray);
        return jSONObject.toString();
    }
}
