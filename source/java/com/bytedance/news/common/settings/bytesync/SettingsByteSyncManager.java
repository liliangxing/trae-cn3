package com.bytedance.news.common.settings.bytesync;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.news.common.settings.SettingsManager;
import com.bytedance.news.common.settings.api.model.SettingsByteSyncModel;
import com.bytedance.news.common.settings.api.model.SettingsRequestParamsModel;
import com.bytedance.platform.thread.Constants;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SettingsByteSyncManager {
    private static final String TAG = "SettingsByteSyncManager";
    private static String callerName;
    private static volatile int receiveCount;
    private static String taskData;
    private static String taskDataTmp;
    private static int taskId;
    private static String taskIdTmp;
    private static int taskType;
    private static long timeStamp;
    static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static List<SettingsByteSyncListener> syncListeners = new ArrayList();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface SettingsByteSyncListener {
        void onSettingsSyncRequest(SettingsByteSyncModel settingsByteSyncModel);

        void onUpdateSettingKey(SettingsByteSyncModel settingsByteSyncModel);
    }

    public static String onReceiveConnectEvent(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            taskType = jSONObject.optInt("task_type");
            taskId = jSONObject.optInt("task_id");
            callerName = jSONObject.optString("caller_name");
            taskData = jSONObject.optString("task_data");
            timeStamp = jSONObject.optLong("time_stamp");
            int i = taskType;
            if (i == 2) {
                updateSettingsFromByteSync(jSONObject);
            } else if (i == 1) {
                if (receiveCount == 0) {
                    receiveCount = 1;
                    if (!TextUtils.isEmpty(taskData)) {
                        taskDataTmp = taskData;
                    }
                    int i2 = taskId;
                    if (i2 != 0) {
                        taskIdTmp = String.valueOf(i2);
                    }
                    SettingsManager.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.bytedance.news.common.settings.bytesync.SettingsByteSyncManager.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SettingsByteSyncModel settingsByteSyncModel = new SettingsByteSyncModel();
                            settingsByteSyncModel.callerName = SettingsByteSyncManager.callerName;
                            settingsByteSyncModel.taskData = SettingsByteSyncManager.taskDataTmp;
                            settingsByteSyncModel.taskId = SettingsByteSyncManager.taskIdTmp;
                            settingsByteSyncModel.taskType = SettingsByteSyncManager.taskType;
                            settingsByteSyncModel.timeStamp = SettingsByteSyncManager.timeStamp * 1000;
                            String unused = SettingsByteSyncManager.taskDataTmp = SettingsByteSyncManager.taskIdTmp = "";
                            if (!TextUtils.isEmpty(SettingsByteSyncManager.callerName)) {
                                if (SettingsByteSyncManager.syncListeners != null) {
                                    for (SettingsByteSyncListener settingsByteSyncListener : SettingsByteSyncManager.syncListeners) {
                                        if (settingsByteSyncListener != null) {
                                            settingsByteSyncListener.onSettingsSyncRequest(settingsByteSyncModel);
                                        }
                                    }
                                }
                            } else if (SettingsManager.isMatchTimeToByteSync(settingsByteSyncModel)) {
                                SettingsManager.setSettingsByteSyncModel(settingsByteSyncModel);
                                SettingsManager.updateSettings(true);
                            }
                            int unused2 = SettingsByteSyncManager.receiveCount = 0;
                        }
                    }, Constants.TASK_RUN_THRESHOLD);
                } else {
                    if (!TextUtils.isEmpty(taskData)) {
                        taskDataTmp += "," + taskData;
                    }
                    if (taskId != 0) {
                        taskIdTmp += "," + taskId;
                    }
                }
            } else if (i == 3) {
                if (isMd5Matched(jSONObject.optString("params_md5"))) {
                    jSONObject.put("valid_params", 1);
                    jSONObject.put("valid_time", updateSettingsFromByteSync(jSONObject));
                } else {
                    jSONObject.put("valid_params", 0);
                    jSONObject.put("valid_time", -1);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return str;
        }
    }

    private static int updateSettingsFromByteSync(JSONObject jSONObject) {
        if (TextUtils.isEmpty(jSONObject.optString("task_data"))) {
            Log.e(TAG, "taskData is empty");
            return -1;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(taskData);
            SettingsByteSyncModel settingsByteSyncModel = new SettingsByteSyncModel();
            settingsByteSyncModel.callerName = callerName;
            settingsByteSyncModel.taskData = taskData;
            settingsByteSyncModel.taskId = String.valueOf(taskId);
            settingsByteSyncModel.taskType = taskType;
            settingsByteSyncModel.timeStamp = timeStamp * 1000;
            if (TextUtils.isEmpty(callerName)) {
                if (!SettingsManager.isMatchTimeToByteSync(settingsByteSyncModel)) {
                    return 0;
                }
                SettingsManager.updateSettingKey(jSONObject2);
                return 1;
            }
            List<SettingsByteSyncListener> list = syncListeners;
            if (list == null) {
                return 1;
            }
            for (SettingsByteSyncListener settingsByteSyncListener : list) {
                if (settingsByteSyncListener != null) {
                    settingsByteSyncListener.onUpdateSettingKey(settingsByteSyncModel);
                }
            }
            return 1;
        } catch (JSONException e) {
            e.printStackTrace();
            return 1;
        }
    }

    private static boolean isMd5Matched(String str) {
        SettingsRequestParamsModel requestParamsModel = ((SettingsConfigProvider) ServiceManager.getService(SettingsConfigProvider.class)).getConfig().getRequestParamsModel();
        if (requestParamsModel == null || str == null) {
            return false;
        }
        return str.equals(md5Hex(requestParamsModel.getStringForChecking()));
    }

    public static String md5Hex(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(str.getBytes("UTF-8"));
                    byte[] digest = messageDigest.digest();
                    return toHexString(digest, 0, digest.length);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static String toHexString(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        if (i >= 0 && i + i2 <= bArr.length) {
            int i3 = i2 * 2;
            char[] cArr = new char[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = bArr[i5 + i] & 255;
                int i7 = i4 + 1;
                char[] cArr2 = HEX_CHARS;
                cArr[i4] = cArr2[i6 >> 4];
                i4 = i7 + 1;
                cArr[i7] = cArr2[i6 & 15];
            }
            return new String(cArr, 0, i3);
        }
        throw new IndexOutOfBoundsException();
    }

    public static void registerByteSyncListener(SettingsByteSyncListener settingsByteSyncListener) {
        syncListeners.add(settingsByteSyncListener);
    }

    public void unregisterByteSyncListener(SettingsByteSyncListener settingsByteSyncListener) {
        syncListeners.remove(settingsByteSyncListener);
    }
}
