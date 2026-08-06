package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.deviceregister.utils.RomUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadInnerConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.network.IDefaultDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.LruCache;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DefaultDownloadHttpService implements IDownloadHttpService {
    private static final String TAG = "DefaultDownloadHttpService";
    private final LruCache<String, OkHttpClient> hostIpClientCache = new LruCache<>(4, 8);

    @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
    public IDownloadHttpConnection downloadWithConnection(int i, String str, List<HttpHeader> list) throws IOException {
        String str2;
        OkHttpClient downloadClient;
        Headers headers;
        Request.Builder url = new Request.Builder().url(str);
        int i2 = -1;
        if (list == null || list.size() <= 0) {
            str2 = null;
        } else {
            str2 = null;
            for (HttpHeader httpHeader : list) {
                String name = httpHeader.getName();
                if (!DownloadInnerConstants.TTNET_BIZ_ID_HEADER_NAME.equals(name) && !DownloadInnerConstants.TTNET_BIZ_VERSION_HEADER_NAME.equals(name)) {
                    if ("extra_download_id".equalsIgnoreCase(httpHeader.getName())) {
                        try {
                            i2 = Integer.parseInt(httpHeader.getValue());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    } else if (str2 == null && DownloadConstants.EXTRA_REQUEST_HOST_IP.equals(name)) {
                        str2 = httpHeader.getValue();
                    } else {
                        url.addHeader(name, DownloadUtils.getEncodedStr(httpHeader.getValue()));
                    }
                }
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            downloadClient = createSpecialHostIpClient(str, str2);
        } else {
            downloadClient = DownloadComponentManager.getDownloadClient();
        }
        if (downloadClient == null) {
            throw new IOException("can't get httpClient");
        }
        Request build = url.build();
        if (Logger.alog()) {
            Logger.globalDebug(TAG, "downloadWithConnection", i2 + "|Request Url:" + str);
            Headers headers2 = build.headers();
            if (headers2 != null) {
                Logger.globalDebug(TAG, "downloadWithConnection", i2 + "|Request Headers: " + headers2.toString());
            }
        }
        final Call newCall = downloadClient.newCall(build);
        final Response execute = newCall.execute();
        if (execute == null) {
            throw new IOException("can't get response");
        }
        if (Logger.alog() && (headers = execute.headers()) != null) {
            Logger.globalDebug(TAG, "downloadWithConnection", i2 + "|Response Header");
            Logger.globalDebug(TAG, "downloadWithConnection", i2 + "|Response Headers: " + headers.toString());
        }
        final ResponseBody body = execute.body();
        if (body == null) {
            return null;
        }
        InputStream byteStream = body.byteStream();
        String header = execute.header("Content-Encoding");
        final InputStream gZIPInputStream = (header == null || !DownloadHelper.GZIP.equalsIgnoreCase(header) || (byteStream instanceof GZIPInputStream)) ? byteStream : new GZIPInputStream(byteStream);
        return new IDefaultDownloadHttpConnection() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService.1
            @Override // com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection
            public String getHostIp() {
                return "";
            }

            @Override // com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection
            public boolean isOkhttp() {
                return true;
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
            public InputStream getInputStream() throws IOException {
                return gZIPInputStream;
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public String getResponseHeaderField(String str3) {
                return execute.header(str3);
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public int getResponseCode() throws IOException {
                return execute.code();
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection
            public void cancel() {
                Call call = newCall;
                if (call == null || call.isCanceled()) {
                    return;
                }
                newCall.cancel();
            }

            @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpConnection
            public void end() {
                try {
                    ResponseBody responseBody = body;
                    if (responseBody != null) {
                        responseBody.close();
                    }
                    Call call = newCall;
                    if (call == null || call.isCanceled()) {
                        return;
                    }
                    newCall.cancel();
                } catch (Throwable unused) {
                }
            }

            @Override // com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection
            public List<Pair<String, String>> getResponseHeaders() {
                Headers headers3 = execute.headers();
                if (headers3 == null) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                int size = headers3.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.add(new Pair(headers3.name(i3), headers3.value(i3)));
                }
                return arrayList;
            }
        };
    }

    private OkHttpClient createSpecialHostIpClient(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + RomUtils.SEPARATOR + str2;
                synchronized (this.hostIpClientCache) {
                    OkHttpClient okHttpClient = this.hostIpClientCache.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder createDownloadClientBuilder = DownloadComponentManager.createDownloadClientBuilder();
                    createDownloadClientBuilder.dns(new Dns() { // from class: com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService.2
                        public List<InetAddress> lookup(String str4) throws UnknownHostException {
                            if (TextUtils.equals(host, str4)) {
                                return Collections.singletonList(InetAddress.getByName(str2));
                            }
                            return Dns.SYSTEM.lookup(str4);
                        }
                    });
                    OkHttpClient build = createDownloadClientBuilder.build();
                    synchronized (this.hostIpClientCache) {
                        this.hostIpClientCache.put(str3, build);
                    }
                    return build;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return DownloadComponentManager.getDownloadClient();
    }
}
