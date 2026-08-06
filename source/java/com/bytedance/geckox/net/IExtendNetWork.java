package com.bytedance.geckox.net;

import com.bytedance.geckox.buffer.stream.BufferOutputStream;
import java.util.Map;

/* loaded from: classes3.dex */
public interface IExtendNetWork extends INetWork {
    Response doPost(String str, String str2, Map<String, String> map) throws Exception;

    void downloadFile(String str, long j, BufferOutputStream bufferOutputStream, Map<String, String> map) throws Exception;
}
