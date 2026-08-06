package com.bytedance.bdturing.ttnet;

import android.content.Context;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TTNetHttpClient implements HttpClient {
    private Context context;

    public TTNetHttpClient(Context context) {
        this.context = context;
    }

    @Override // com.bytedance.bdturing.ttnet.HttpClient
    public byte[] get(String str, Map<String, String> map) {
        TrafficColorHelper.addColorToHeader(this.context, str, map);
        return TTNetUtil.executeGet(str, null, null, map);
    }

    @Override // com.bytedance.bdturing.ttnet.HttpClient
    public byte[] post(String str, Map<String, String> map, byte[] bArr) {
        TrafficColorHelper.addColorToHeader(this.context, str, map);
        return TTNetUtil.executePost(str, null, null, bArr, map);
    }
}
