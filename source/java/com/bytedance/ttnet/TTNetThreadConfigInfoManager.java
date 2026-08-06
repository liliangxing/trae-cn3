package com.bytedance.ttnet;

import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TTNetThreadConfigInfoManager {
    private TTNetThreadConfig.Callback mThreadConfigCallback;
    private ArrayList<TTNetThreadConfig> mThreadConfigInfoSubsetList;

    public TTNetThreadConfigInfoManager(ArrayList<TTNetThreadConfig> arrayList, TTNetThreadConfig.Callback callback) {
        this.mThreadConfigInfoSubsetList = arrayList;
        this.mThreadConfigCallback = callback;
    }

    public List<TTNetThreadConfig> getThreadConfigInfoList() {
        return this.mThreadConfigInfoSubsetList;
    }

    public TTNetThreadConfig.Callback getThreadConfigCallbackImpl() {
        return this.mThreadConfigCallback;
    }

    public static void bindBigCore(TTNetThreadConfig.ThreadType threadType) {
        try {
            if (getCronetHttpClient() != null) {
                SsCronetHttpClient.bindBigCore(threadType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void bindLittleCore(TTNetThreadConfig.ThreadType threadType) {
        try {
            if (getCronetHttpClient() != null) {
                SsCronetHttpClient.bindLittleCore(threadType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void resetCoreBind(TTNetThreadConfig.ThreadType threadType) {
        try {
            if (getCronetHttpClient() != null) {
                SsCronetHttpClient.resetCoreBind(threadType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static SsCronetHttpClient getCronetHttpClient() throws Exception {
        if (HttpClient.isCronetClientEnable()) {
            return SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext());
        }
        throw new UnsupportedOperationException("Cronet is not enabled");
    }
}
