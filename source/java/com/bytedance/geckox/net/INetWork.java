package com.bytedance.geckox.net;

import android.util.Pair;
import com.bytedance.geckox.buffer.stream.BufferOutputStream;
import java.util.List;

/* loaded from: classes3.dex */
public interface INetWork {
    Response doGet(String str) throws Exception;

    Response doPost(String str, String str2) throws Exception;

    Response doPost(String str, List<Pair<String, String>> list) throws Exception;

    void downloadFile(String str, long j, BufferOutputStream bufferOutputStream) throws Exception;
}
