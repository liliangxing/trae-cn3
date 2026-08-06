package com.bytedance.apm.impl;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.util.FileUploadUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import com.bytedance.services.apm.api.IRequestTagHeaderProvider;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DefaultTTNetImpl implements IHttpService {
    public HttpResponse doPost(String str, byte[] bArr, Map<String, String> map) throws Exception {
        int i;
        Call<TypedInput> report = ((RetrofitMonitorService) RetrofitUtils.createSsService(str, RetrofitMonitorService.class)).report(str, new TypedByteArray("application/json; charset=utf-8", bArr, new String[0]), convertHeaderMap(map), false);
        HashMap hashMap = new HashMap();
        byte[] bArr2 = null;
        try {
            SsResponse execute = report.execute();
            bArr2 = toByteArray(((TypedInput) execute.body()).in());
            List<Header> headers = execute.headers();
            if (!ListUtils.isEmpty(headers)) {
                for (Header header : headers) {
                    hashMap.put(header.getName(), header.getValue());
                }
            }
            i = execute.code();
        } catch (Throwable th) {
            try {
                r2 = th instanceof HttpResponseException ? th.getStatusCode() : 0;
                if (th instanceof CronetIOException) {
                    i = ((CronetIOException) th).getStatusCode();
                }
            } catch (Exception unused) {
            }
            i = r2;
        }
        return new HttpResponse(i, hashMap, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static List<Header> convertHeaderMap(Map<String, String> map) {
        Map requestTagHeader;
        ArrayList arrayList = new ArrayList();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    arrayList.add(new Header(entry.getKey(), entry.getValue()));
                }
            }
        }
        IRequestTagHeaderProvider requestTagHeaderProvider = ApmContext.getRequestTagHeaderProvider();
        if (requestTagHeaderProvider != null && (requestTagHeader = requestTagHeaderProvider.getRequestTagHeader()) != null && !requestTagHeader.isEmpty()) {
            for (Map.Entry entry2 : requestTagHeader.entrySet()) {
                if (entry2 != null) {
                    arrayList.add(new Header((String) entry2.getKey(), (String) entry2.getValue()));
                }
            }
        }
        return arrayList;
    }

    public HttpResponse doGet(String str, Map<String, String> map) throws Exception {
        Call<TypedInput> fetch;
        List<Header> convertHeaderMap = convertHeaderMap(null);
        RetrofitMonitorService retrofitMonitorService = (RetrofitMonitorService) RetrofitUtils.createSsService(str, RetrofitMonitorService.class);
        if (convertHeaderMap != null && convertHeaderMap.size() > 0) {
            fetch = retrofitMonitorService.fetch(str, convertHeaderMap, map, false);
        } else {
            fetch = retrofitMonitorService.fetch(str, map, false);
        }
        SsResponse execute = fetch.execute();
        return new HttpResponse(execute.code(), toByteArray(((TypedInput) execute.body()).in()));
    }

    public HttpResponse uploadFiles(String str, List<File> list, Map<String, String> map) throws Exception {
        return FileUploadUtils.uploadFiles(str, list, map);
    }

    public IMultipartUploader buildMultipartUpload(String str, String str2, boolean z) throws Exception {
        return new TTNetMultipartUploader(str, str2, z, null);
    }

    public IMultipartUploader buildMultipartUpload(String str, String str2, boolean z, Map<String, String> map) throws Exception {
        return new TTNetMultipartUploader(str, str2, z, map);
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        if (inputStream == null) {
            return new byte[0];
        }
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
