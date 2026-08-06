package com.bytedance.apm.impl;

import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.StackUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedFile;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedance.retrofit2.mime.TypedString;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IMultipartUploader;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TTNetMultipartUploader implements IMultipartUploader {
    private String charset;
    private boolean gzip;
    private Map<String, String> header;
    private Map<String, TypedOutput> partMap = new HashMap();
    private String requestURL;

    public TTNetMultipartUploader(String str, String str2, boolean z, Map<String, String> map) {
        this.requestURL = str;
        this.header = map;
        this.charset = str2;
        this.gzip = z;
    }

    public void addFormField(String str, String str2) {
        this.partMap.put(str, new TypedString(str2));
    }

    public void addFilePart(String str, File file, String str2, Map<String, String> map) throws IOException {
        this.partMap.put(str, new MonitorFiledPart(map, new TypedFile((String) null, file)));
    }

    public void addFilePart(String str, String str2, String str3, Map<String, String> map) throws IOException {
        this.partMap.put(str, new MonitorAdditionalPart(str, str2, map));
    }

    public HttpResponse finish() throws IOException {
        return uploadMultiPartFiles(this.requestURL, this.partMap, this.header);
    }

    private HttpResponse uploadMultiPartFiles(String str, Map<String, TypedOutput> map, Map<String, String> map2) {
        byte[] bytes;
        int i;
        RetrofitMonitorService retrofitMonitorService = (RetrofitMonitorService) RetrofitUtils.createSsService(str, RetrofitMonitorService.class);
        HashMap hashMap = new HashMap();
        try {
            SsResponse execute = retrofitMonitorService.uploadFiles(str, map, DefaultTTNetImpl.convertHeaderMap(map2)).execute();
            bytes = DefaultTTNetImpl.toByteArray(((TypedInput) execute.body()).in());
            List<Header> headers = execute.headers();
            if (!ListUtils.isEmpty(headers)) {
                for (Header header : headers) {
                    hashMap.put(header.getName(), header.getValue());
                }
            }
            i = execute.code();
        } catch (Throwable th) {
            th.printStackTrace();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("exception", th.getMessage() + StackUtils.getStack(th));
                jSONObject.put(AlogMonitor.ALOG_RESULT_EXCEPTION_OBJECT, th.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            bytes = jSONObject.toString().getBytes();
            i = 100001;
        }
        return new HttpResponse(i, hashMap, bytes);
    }
}
