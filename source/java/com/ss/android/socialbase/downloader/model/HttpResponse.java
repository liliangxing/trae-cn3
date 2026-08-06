package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.IOException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class HttpResponse {
    public final IDownloadHeadHttpConnection connection;
    private long contentLength;
    public final int responseCode;
    private long totalLength;
    public final String url;

    public HttpResponse(String str, IDownloadHeadHttpConnection iDownloadHeadHttpConnection) throws IOException {
        this.url = str;
        this.responseCode = iDownloadHeadHttpConnection.getResponseCode();
        this.connection = iDownloadHeadHttpConnection;
    }

    public HttpResponse(String str, IDownloadHeadHttpConnection iDownloadHeadHttpConnection, int i) {
        this.url = str;
        this.responseCode = i;
        this.connection = iDownloadHeadHttpConnection;
    }

    public boolean isResponseDataFromBegin() {
        return DownloadHelper.isResponseDataFromBegin(this.responseCode);
    }

    public boolean acceptPartial() {
        return DownloadHelper.canAcceptPartial(this.responseCode, this.connection.getResponseHeaderField(DownloadHelper.ACCEPT_RANGES));
    }

    public String getEtag() {
        return this.connection.getResponseHeaderField(DownloadHelper.ETAG);
    }

    public String getContentType() {
        return this.connection.getResponseHeaderField("Content-Type");
    }

    public String getContentRange() {
        return DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, DownloadUtils.CONTENT_RANGE);
    }

    public String getLastModified() {
        String respHeadFieldIgnoreCase = DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "last-modified");
        return TextUtils.isEmpty(respHeadFieldIgnoreCase) ? DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "Last-Modified") : respHeadFieldIgnoreCase;
    }

    public String getCacheControl() {
        return DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "Cache-Control");
    }

    public long getContentLength() {
        if (this.contentLength <= 0) {
            this.contentLength = DownloadUtils.getContentLength(this.connection);
        }
        return this.contentLength;
    }

    public boolean isChunked() {
        return DownloadHelper.isChunkedTask(this.connection);
    }

    public long getXContentLength() {
        String respHeadFieldIgnoreCase = DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, DownloadHelper.X_CONTENT_LENGTH);
        if (!TextUtils.isEmpty(respHeadFieldIgnoreCase)) {
            try {
                return Long.parseLong(respHeadFieldIgnoreCase);
            } catch (NumberFormatException unused) {
            }
        }
        return -1L;
    }

    public long getTotalLength() {
        if (this.totalLength <= 0) {
            if (!isChunked()) {
                String contentRange = getContentRange();
                if (!TextUtils.isEmpty(contentRange)) {
                    this.totalLength = DownloadHelper.parseContentRangeOfInstanceLength(contentRange);
                }
            } else {
                this.totalLength = -1L;
            }
        }
        return this.totalLength;
    }

    public long getMaxAge() {
        return DownloadHelper.parserMaxAge(getCacheControl());
    }

    public String getContentEncoding() {
        return DownloadUtils.getRespHeadFieldIgnoreCase(this.connection, "Content-Encoding");
    }
}
