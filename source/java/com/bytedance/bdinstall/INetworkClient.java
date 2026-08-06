package com.bytedance.bdinstall;

import android.util.Pair;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface INetworkClient {
    String get(String str, Map<String, String> map) throws Exception;

    String post(String str, List<Pair<String, String>> list) throws Exception;

    String post(String str, byte[] bArr, String str2) throws Exception;

    String post(String str, byte[] bArr, Map<String, String> map) throws Exception;

    byte[] postStream(String str, byte[] bArr, Map<String, String> map) throws RangersHttpException;
}
