package com.bytedance.apm.data.ui;

import com.bytedance.apm.structure.LimitQueue;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ActionRecord {
    private static volatile ActionRecord singleton;
    private LimitQueue<JSONObject> mActionQueue = new LimitQueue<>(20);

    private ActionRecord() {
    }

    public static ActionRecord getInstance() {
        if (singleton == null) {
            synchronized (ActionRecord.class) {
                if (singleton == null) {
                    singleton = new ActionRecord();
                }
            }
        }
        return singleton;
    }

    public void addRecord(JSONObject jSONObject) {
        this.mActionQueue.enqueue(jSONObject);
    }

    public List<JSONObject> getRecords() {
        return this.mActionQueue.toList();
    }
}
