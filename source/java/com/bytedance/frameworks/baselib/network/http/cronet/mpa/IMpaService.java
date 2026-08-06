package com.bytedance.frameworks.baselib.network.http.cronet.mpa;

import java.util.List;

/* loaded from: classes2.dex */
public interface IMpaService {

    /* loaded from: classes2.dex */
    public interface ICallback {
        void onFinish(boolean z, String str);
    }

    void command(String str, String str2);

    void init(ICallback iCallback);

    void setAccAddress(List<String> list, ICallback iCallback);

    void start();

    void stop();
}
