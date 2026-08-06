package com.ss.mediakit.image.impl;

import com.ss.mediakit.image.MDLCallback;
import com.ss.mediakit.image.MDLImageRequest;
import com.ss.mediakit.image.api.Callback;
import com.ss.mediakit.image.api.IRequest;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes7.dex */
public class ImageRequest implements IRequest {
    static final String TAG = "ImageRequest";
    private final String extInfos;
    private final Map<String, String> headers;
    private final Map<String, String> params;
    MDLImageRequest request = new MDLImageRequest();
    private final String url;

    ImageRequest(Builder builder) {
        this.url = builder.url;
        this.headers = builder.headers;
        this.params = builder.params;
        this.extInfos = builder.extInfos;
    }

    @Override // com.ss.mediakit.image.api.IRequest
    public void start(Callback callback) {
        MDLImageRequest mDLImageRequest = this.request;
        if (mDLImageRequest != null) {
            mDLImageRequest.start(this.url, this.headers, this.params, this.extInfos, new ImageTaskCallback(callback));
        }
    }

    @Override // com.ss.mediakit.image.api.IRequest
    public void cancel() {
        MDLImageRequest mDLImageRequest = this.request;
        if (mDLImageRequest != null) {
            mDLImageRequest.cancel();
        }
    }

    @Override // com.ss.mediakit.image.api.IRequest
    public boolean isCanceled() {
        MDLImageRequest mDLImageRequest = this.request;
        if (mDLImageRequest != null) {
            return mDLImageRequest.isCanceled();
        }
        return false;
    }

    /* loaded from: classes7.dex */
    public static class Builder {
        private String extInfos;
        private Map<String, String> headers;
        private Map<String, String> params;
        private String url;

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder headers(Map<String, String> map) {
            this.headers = map;
            return this;
        }

        public Builder params(Map<String, String> map) {
            this.params = map;
            return this;
        }

        public Builder extInfos(String str) {
            this.extInfos = str;
            return this;
        }

        public ImageRequest build() {
            return new ImageRequest(this);
        }
    }

    /* loaded from: classes7.dex */
    private class ImageTaskCallback implements MDLCallback {
        Callback callback;

        public ImageTaskCallback(Callback callback) {
            this.callback = callback;
        }

        @Override // com.ss.mediakit.image.MDLCallback
        public int onInfos(int i, String str, String str2) {
            Callback callback = this.callback;
            if (callback == null) {
                return 0;
            }
            callback.onInfos(i, str, str2);
            return 0;
        }

        @Override // com.ss.mediakit.image.MDLCallback
        public int onHeaders(int i, int i2, Map<String, String> map) {
            Callback callback = this.callback;
            if (callback == null) {
                return 0;
            }
            callback.onHeaders(i, i2, map);
            return 0;
        }

        @Override // com.ss.mediakit.image.MDLCallback
        public int onResponse(int i, InputStream inputStream, int i2) {
            Callback callback = this.callback;
            if (callback == null) {
                return 0;
            }
            callback.onResponse(i, inputStream, i2);
            return 0;
        }

        @Override // com.ss.mediakit.image.MDLCallback
        public int onFailure(int i, int i2, String str, Throwable th) {
            Callback callback = this.callback;
            if (callback == null) {
                return 0;
            }
            callback.onFailure(i, i2, str, th);
            return 0;
        }
    }
}
