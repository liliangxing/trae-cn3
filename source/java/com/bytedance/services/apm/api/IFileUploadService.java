package com.bytedance.services.apm.api;

import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface IFileUploadService {
    void uploadFiles(String str, String str2, String str3, List<String> list, String str4, JSONObject jSONObject, IFileUploadCallback iFileUploadCallback);
}
