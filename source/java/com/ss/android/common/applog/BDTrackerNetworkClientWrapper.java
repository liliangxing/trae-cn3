package com.ss.android.common.applog;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class BDTrackerNetworkClientWrapper implements INetworkClient {
    @Override // com.bytedance.bdinstall.INetworkClient
    public String get(String str, Map<String, String> map) throws RangersHttpException {
        try {
            return NetworkClient.getDefault().get(str, map, null);
        } catch (Exception e) {
            if (e instanceof CommonHttpException) {
                CommonHttpException commonHttpException = (CommonHttpException) e;
                throw new RangersHttpException(commonHttpException.getResponseCode(), commonHttpException.getCause());
            }
            throw new RangersHttpException(400, e.getCause());
        }
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String str, byte[] bArr, Map<String, String> map) throws RangersHttpException {
        try {
            return NetworkClient.getDefault().post(str, bArr, map, (NetworkClient.ReqContext) null);
        } catch (CommonHttpException e) {
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        }
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String str, byte[] bArr, String str2) throws RangersHttpException {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("Content-Type", str2);
        }
        return post(str, bArr, hashMap);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String str, List<Pair<String, String>> list) throws RangersHttpException {
        try {
            return NetworkClient.getDefault().post(str, list);
        } catch (CommonHttpException e) {
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        }
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public byte[] postStream(String str, byte[] bArr, Map<String, String> map) throws RangersHttpException {
        try {
            return NetworkClient.getDefault().postDataStream(str, bArr, map, null);
        } catch (CommonHttpException e) {
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        }
    }
}
