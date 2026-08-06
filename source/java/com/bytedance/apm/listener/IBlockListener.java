package com.bytedance.apm.listener;

/* loaded from: classes3.dex */
public interface IBlockListener {
    void onBlockDetect(String str, long j, String str2, String str3);

    void onSeriousBlockDetect(String str, long j, String str2, String str3);
}
