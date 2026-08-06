package com.bytedance.services.apm.api;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes5.dex */
public interface IMultipartUploader {
    void addFilePart(String str, File file, String str2, Map<String, String> map) throws IOException;

    void addFilePart(String str, String str2, String str3, Map<String, String> map) throws IOException;

    void addFormField(String str, String str2);

    HttpResponse finish() throws IOException;
}
