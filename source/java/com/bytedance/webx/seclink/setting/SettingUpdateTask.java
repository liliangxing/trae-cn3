package com.bytedance.webx.seclink.setting;

import android.text.TextUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.bytedance.webx.seclink.util.Log;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class SettingUpdateTask implements Runnable {
    private static final String TAG = "SettingUpdateTask";
    private TaskCallBack mCallBack;
    private final Map<String, String> mQueryMap;
    private final String mUrl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface TaskCallBack {
        void onFail(String str);

        void onSuccess(String str);
    }

    public SettingUpdateTask(String str, Map<String, String> map, TaskCallBack taskCallBack) {
        this.mUrl = str;
        this.mQueryMap = map;
        this.mCallBack = taskCallBack;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(this.mUrl)) {
                throw new IllegalArgumentException("setting host or path is empty");
            }
            SsResponse execute = ((INetworkApi) RetrofitUtils.getSsRetrofit(this.mUrl).create(INetworkApi.class)).doGet(true, -1, "", this.mQueryMap, (List) null, (Object) null).execute();
            int code = execute.code();
            Log.m51i(TAG, "pull setting finish responseCode:" + code + ":body=" + ((String) execute.body()));
            if (code == 200) {
                onSuccess((String) execute.body());
            } else {
                onFail("network error responseCode=" + code);
            }
        } catch (Exception e) {
            e.printStackTrace();
            onFail(e.getMessage());
        }
    }

    private void onFail(String str) {
        TaskCallBack taskCallBack = this.mCallBack;
        if (taskCallBack != null) {
            taskCallBack.onFail(str);
        }
    }

    private void onSuccess(String str) {
        TaskCallBack taskCallBack = this.mCallBack;
        if (taskCallBack != null) {
            taskCallBack.onSuccess(str);
        }
    }
}
