package com.bytedance.crash.service;

import android.util.Pair;
import java.util.Map;

/* loaded from: classes3.dex */
public interface IHttpService {
    IMultipartService buildMultipartService(String str, String str2, boolean z) throws Exception;

    Pair<Integer, byte[]> doGet(String str, Map<String, String> map) throws Exception;

    Pair<Integer, byte[]> doPost(String str, byte[] bArr, Map<String, String> map) throws Exception;
}
