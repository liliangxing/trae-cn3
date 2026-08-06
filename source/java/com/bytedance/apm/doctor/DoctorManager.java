package com.bytedance.apm.doctor;

import com.bytedance.apm6.util.ListUtils;
import com.bytedance.monitor.util.thread.AsyncTaskManager;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.monitor.util.thread.TaskRunnable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DoctorManager {
    private final String TYPE;
    private boolean mHasChangedEncrypt;
    private boolean mIsEncrypt;
    private List<ApmListener> mList;

    /* loaded from: classes3.dex */
    public interface ApmListener {
        void onDataEvent(int i, String str, JSONObject jSONObject);

        void onEvent(String str, String str2);
    }

    private DoctorManager() {
        this.TYPE = "doctor";
        this.mList = new ArrayList();
        this.mHasChangedEncrypt = false;
    }

    /* loaded from: classes3.dex */
    private static class Holder {
        private static final DoctorManager INSTANCE = new DoctorManager();

        private Holder() {
        }
    }

    public static DoctorManager getInstance() {
        return Holder.INSTANCE;
    }

    public void registerApmListener(ApmListener apmListener) {
        if (apmListener != null) {
            this.mList.add(apmListener);
        }
    }

    public void onEvent(final String str, final String str2) {
        if (ListUtils.isEmpty(this.mList)) {
            return;
        }
        final ArrayList arrayList = new ArrayList(this.mList);
        AsyncTaskManager.getInstance().post(new TaskRunnable() { // from class: com.bytedance.apm.doctor.DoctorManager.1
            @Override // com.bytedance.monitor.util.thread.TaskRunnable
            public String getTaskName() {
                return "doctor";
            }

            @Override // com.bytedance.monitor.util.thread.TaskRunnable
            public AsyncTaskType getTaskType() {
                return AsyncTaskType.LIGHT_WEIGHT;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ApmListener) it.next()).onEvent(str, str2);
                }
            }
        });
    }

    public void onDataEvent(final String str, final JSONObject jSONObject) {
        if (ListUtils.isEmpty(this.mList) || jSONObject == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList(this.mList);
        AsyncTaskManager.getInstance().post(new TaskRunnable() { // from class: com.bytedance.apm.doctor.DoctorManager.2
            @Override // com.bytedance.monitor.util.thread.TaskRunnable
            public String getTaskName() {
                return "doctor";
            }

            @Override // com.bytedance.monitor.util.thread.TaskRunnable
            public AsyncTaskType getTaskType() {
                return AsyncTaskType.LIGHT_WEIGHT;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(DoctorConstants.DATA_DOCTOR);
                    jSONObject2.put(str, System.currentTimeMillis());
                    int optInt = jSONObject2.optInt(DoctorConstants.DATA_ID);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((ApmListener) it.next()).onDataEvent(optInt, str, jSONObject);
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    public boolean isEncrypt() {
        return this.mIsEncrypt;
    }

    public void setEncrypt(boolean z) {
        this.mHasChangedEncrypt = true;
        this.mIsEncrypt = z;
    }

    public boolean isEncryptSet() {
        return this.mHasChangedEncrypt;
    }
}
