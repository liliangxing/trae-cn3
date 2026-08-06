package com.bytedance.reparo;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.memory.api.MemoryApi;
import com.bytedance.reparo.core.ReparoPatch;
import com.bytedance.reparo.core.common.utils.StringUtils;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.utils.PackageUtils;
import com.bytedance.reparo.model.PatchFetchInfo;
import com.bytedance.reparo.model.Response;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RemotePatchFetcher {
    private static final String CONTENT_TYPE = "application/json; charset=utf-8";
    private static final int MAX_SIZE = 33554432;
    private static final String SUCCESS_MESSAGE_IN_SERVER_INTERFACE = "success";
    private Application mApplication;
    private IReparoConfig mFrankieConfig;
    private String mSdkVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface RemoteQueryCallback {
        void onFailed(PatchException patchException);

        void onSuccess(List<PatchFetchInfo> list);
    }

    public RemotePatchFetcher(Application application, IReparoConfig iReparoConfig, String str) {
        this.mApplication = application;
        this.mFrankieConfig = iReparoConfig;
        this.mSdkVersion = str;
    }

    public void queryRemotePatchInfo(RemoteQueryCallback remoteQueryCallback) {
        try {
            int hostApkAbiBits = ReparoPatch.getInstance().getHostApkAbiBits();
            if (hostApkAbiBits == -1) {
                remoteQueryCallback.onFailed(new PatchException("wrong abi bits", 0));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("patch", new JSONArray());
            jSONObject.put(MemoryApi.DEBUG, PackageUtils.isApkInDebug(this.mApplication) ? 1 : 0);
            Uri.Builder buildUpon = Uri.parse(Reparo.getInstance().getServerUrl()).buildUpon();
            buildUpon.appendQueryParameter("hotfix_abi", String.valueOf(hostApkAbiBits));
            buildUpon.appendQueryParameter(CommonConstants.SDK_VERSION, StringUtils.notNull(this.mSdkVersion));
            buildUpon.appendQueryParameter("hotfix_type", "reparo");
            buildUpon.appendQueryParameter("channel", this.mFrankieConfig.getChannel());
            remoteQueryCallback.onSuccess(parseResponse(this.mFrankieConfig.executePatchRequest(MAX_SIZE, buildUpon.toString(), jSONObject.toString().getBytes(), "application/json; charset=utf-8")));
        } catch (Throwable th) {
            remoteQueryCallback.onFailed(new PatchException("queryRemotePatchInfo error.", th, 0));
        }
    }

    private List<PatchFetchInfo> parseResponse(String str) throws IllegalAccessException {
        if (TextUtils.isEmpty(str)) {
            throw new ResponseNullException("response is null");
        }
        Response response = (Response) new Gson().fromJson(str, Response.class);
        if (!TextUtils.equals("success", response.message)) {
            throw new IllegalAccessException(String.format("an error occurred on this interface, response is %s", str));
        }
        Response.PatchResponse patchResponse = response.data;
        if (patchResponse.patch == null) {
            return new ArrayList();
        }
        return patchResponse.patch;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class ResponseNullException extends PatchException {
        public ResponseNullException(String str) {
            super(str, 0);
        }
    }
}
