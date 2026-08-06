package com.bytedance.crash.service;

import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface IMultipartService {
    void addFilePart(File file, String str, Map<String, String> map) throws IOException;

    void addFilePart(File file, Map<String, String> map) throws IOException;

    void addFilePart(String str, File file) throws IOException;

    void addFormField(String str, String str2);

    void addFormField(String str, byte[] bArr);

    void addGZIPFilePart(String str, List<File> list) throws IOException;

    Pair<Integer, String> finish() throws IOException;
}
