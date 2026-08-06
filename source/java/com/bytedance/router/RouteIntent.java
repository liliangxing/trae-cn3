package com.bytedance.router;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.router.util.Logger;
import com.bytedance.router.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public class RouteIntent {
    public static final int DEFAULT_REQUEST_CODE = Integer.MIN_VALUE;
    private int enterAnim;
    private int exitAnim;
    private Uri mData;
    private Intent mExtraIntent;
    private String mHost;
    private String mOriginUrl;
    private String mPath;
    private int mRequestCode;
    private String mScheme;
    private Uri mUri;
    private String mUrl;

    private RouteIntent() {
        this.mOriginUrl = "";
        this.mExtraIntent = null;
        this.mUrl = "";
        this.mUri = null;
        this.mScheme = "";
        this.mHost = "";
        this.mPath = "";
        this.enterAnim = -1;
        this.exitAnim = -1;
        this.mRequestCode = Integer.MIN_VALUE;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        if (str == null) {
            return;
        }
        if (!Util.isLegalUrl(str)) {
            throw new IllegalArgumentException("url is illegal!!!");
        }
        if (str.equals(this.mUrl)) {
            return;
        }
        this.mUrl = str;
        parseUrl();
        sliceParams2Intent(this.mExtraIntent, this.mUrl, true);
    }

    public void setData(Uri uri) {
        this.mData = uri;
    }

    public Uri getData() {
        return this.mData;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public String getScheme() {
        return this.mScheme;
    }

    public String getHost() {
        return this.mHost;
    }

    public String getPath() {
        return this.mPath;
    }

    public String getOriginUrl() {
        return this.mOriginUrl;
    }

    public int getEnterAnim() {
        return this.enterAnim;
    }

    public int getExitAnim() {
        return this.exitAnim;
    }

    public void setRequestCode(int i) {
        this.mRequestCode = i;
    }

    public int getRequestCode() {
        return this.mRequestCode;
    }

    public boolean hasRequestCode() {
        return this.mRequestCode != Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOriginUrl(String str) {
        this.mOriginUrl = str;
        if (this.mUrl.equals(str)) {
            return;
        }
        this.mUrl = this.mOriginUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAnimation(int i, int i2) {
        this.enterAnim = i;
        this.exitAnim = i2;
    }

    void setExtra(Intent intent) {
        this.mExtraIntent = intent;
    }

    public Intent getExtra() {
        return this.mExtraIntent;
    }

    void parseUrl() {
        if (TextUtils.isEmpty(this.mUrl)) {
            return;
        }
        Uri parse = Uri.parse(this.mUrl);
        this.mUri = parse;
        this.mExtraIntent.setData(parse);
        this.mScheme = this.mUri.getScheme();
        this.mHost = this.mUri.getHost();
        String path = this.mUri.getPath();
        this.mPath = path;
        if (this.mScheme == null) {
            this.mScheme = "";
        }
        if (this.mHost == null) {
            this.mHost = "";
        }
        if (path == null) {
            this.mPath = "";
        }
    }

    static void sliceParams2Intent(Intent intent, String str, boolean z) {
        Map<String, String> sliceUrlParams;
        if (intent == null || (sliceUrlParams = Util.sliceUrlParams(str)) == null || sliceUrlParams.size() == 0) {
            return;
        }
        for (Map.Entry<String, String> entry : sliceUrlParams.entrySet()) {
            if (z) {
                intent.putExtra(entry.getKey(), entry.getValue());
            } else if (!intent.hasExtra(entry.getKey())) {
                intent.putExtra(entry.getKey(), entry.getValue());
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class Builder {
        private int enterAnim;
        private int exitAnim;
        private Uri mData;
        private Intent mExtraParams;
        private String mUrl;

        public Builder(String str) {
            this.mUrl = "";
            this.mExtraParams = new Intent();
            this.enterAnim = -1;
            this.exitAnim = -1;
            this.mUrl = str;
        }

        public Builder() {
            this.mUrl = "";
            this.mExtraParams = new Intent();
            this.enterAnim = -1;
            this.exitAnim = -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0041  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public RouteIntent build() {
            boolean z;
            RouteIntent routeIntent = new RouteIntent();
            Logger.d("Build RouteIntent url: " + this.mUrl);
            IRouterIntentAdapter routerIntentAdapter = SmartRouter.getRouterIntentAdapter();
            if (routerIntentAdapter != null) {
                String targetModelClassName = RouteManager.getInstance().getRouterMapper().getTargetModelClassName(this.mUrl);
                if (!TextUtils.isEmpty(targetModelClassName)) {
                    z = routerIntentAdapter.processUrl(this.mUrl, this.mExtraParams, targetModelClassName);
                    if (!z) {
                        RouteIntent.sliceParams2Intent(this.mExtraParams, this.mUrl, false);
                    }
                    routeIntent.setOriginUrl(this.mUrl);
                    routeIntent.setExtra(this.mExtraParams);
                    routeIntent.setAnimation(this.enterAnim, this.exitAnim);
                    routeIntent.setData(this.mData);
                    routeIntent.parseUrl();
                    return routeIntent;
                }
            }
            z = false;
            if (!z) {
            }
            routeIntent.setOriginUrl(this.mUrl);
            routeIntent.setExtra(this.mExtraParams);
            routeIntent.setAnimation(this.enterAnim, this.exitAnim);
            routeIntent.setData(this.mData);
            routeIntent.parseUrl();
            return routeIntent;
        }

        public Builder withUrl(String str) {
            this.mUrl = str;
            return this;
        }

        public Builder withParam(String str, boolean z) {
            this.mExtraParams.putExtra(str, z);
            return this;
        }

        public Builder withParam(String str, boolean[] zArr) {
            this.mExtraParams.putExtra(str, zArr);
            return this;
        }

        public Builder withParam(String str, Bundle bundle) {
            this.mExtraParams.putExtra(str, bundle);
            return this;
        }

        public Builder withParam(String str, byte b) {
            this.mExtraParams.putExtra(str, b);
            return this;
        }

        public Builder withParam(String str, byte[] bArr) {
            this.mExtraParams.putExtra(str, bArr);
            return this;
        }

        public Builder withParam(String str, char c) {
            this.mExtraParams.putExtra(str, c);
            return this;
        }

        public Builder withParam(String str, char[] cArr) {
            this.mExtraParams.putExtra(str, cArr);
            return this;
        }

        public Builder withParam(String str, CharSequence charSequence) {
            this.mExtraParams.putExtra(str, charSequence);
            return this;
        }

        public Builder withParam(String str, CharSequence[] charSequenceArr) {
            this.mExtraParams.putExtra(str, charSequenceArr);
            return this;
        }

        public Builder withParamCharSequenceList(String str, ArrayList<CharSequence> arrayList) {
            this.mExtraParams.putExtra(str, arrayList);
            return this;
        }

        public Builder withParam(String str, double d) {
            this.mExtraParams.putExtra(str, d);
            return this;
        }

        public Builder withParam(String str, double[] dArr) {
            this.mExtraParams.putExtra(str, dArr);
            return this;
        }

        public Builder withParam(String str, float f) {
            this.mExtraParams.putExtra(str, f);
            return this;
        }

        public Builder withParam(String str, float[] fArr) {
            this.mExtraParams.putExtra(str, fArr);
            return this;
        }

        public Builder withParam(String str, int i) {
            this.mExtraParams.putExtra(str, i);
            return this;
        }

        public Builder withParam(String str, int[] iArr) {
            this.mExtraParams.putExtra(str, iArr);
            return this;
        }

        public Builder withParamIntegerList(String str, ArrayList<Integer> arrayList) {
            this.mExtraParams.putExtra(str, arrayList);
            return this;
        }

        public Builder withParam(String str, long j) {
            this.mExtraParams.putExtra(str, j);
            return this;
        }

        public Builder withParam(String str, long[] jArr) {
            this.mExtraParams.putExtra(str, jArr);
            return this;
        }

        public Builder withParam(String str, Parcelable parcelable) {
            this.mExtraParams.putExtra(str, parcelable);
            return this;
        }

        public Builder withParam(String str, Parcelable[] parcelableArr) {
            this.mExtraParams.putExtra(str, parcelableArr);
            return this;
        }

        public Builder withParamParcelableList(String str, ArrayList<Parcelable> arrayList) {
            this.mExtraParams.putExtra(str, arrayList);
            return this;
        }

        public Builder withParam(String str, Serializable serializable) {
            this.mExtraParams.putExtra(str, serializable);
            return this;
        }

        public Builder withParam(String str, short s) {
            this.mExtraParams.putExtra(str, s);
            return this;
        }

        public Builder withParam(String str, short[] sArr) {
            this.mExtraParams.putExtra(str, sArr);
            return this;
        }

        public Builder withParam(String str, String str2) {
            this.mExtraParams.putExtra(str, str2);
            return this;
        }

        public Builder withParam(String str, String[] strArr) {
            this.mExtraParams.putExtra(str, strArr);
            return this;
        }

        public Builder withParamStringList(String str, ArrayList<String> arrayList) {
            this.mExtraParams.putExtra(str, arrayList);
            return this;
        }

        public Builder withParam(Bundle bundle) {
            this.mExtraParams.putExtras(bundle);
            return this;
        }

        public Builder withParam(Intent intent) {
            this.mExtraParams.putExtras(intent);
            return this;
        }

        public Builder addFlags(int i) {
            this.mExtraParams.addFlags(i);
            return this;
        }

        public Builder withAnimation(int i, int i2) {
            this.enterAnim = i;
            this.exitAnim = i2;
            return this;
        }

        public Builder withData(Uri uri) {
            this.mData = uri;
            return this;
        }
    }

    public String toString() {
        return "RouteIntent{mOriginUrl='" + this.mOriginUrl + "', mExtraIntent=" + this.mExtraIntent + ", mUrl='" + this.mUrl + "', mUri=" + this.mUri + ", mScheme='" + this.mScheme + "', mHost='" + this.mHost + "', mPath='" + this.mPath + "', enterAnim=" + this.enterAnim + ", exitAnim=" + this.exitAnim + ", mRequestCode=" + this.mRequestCode + ", mData=" + this.mData + AbstractJsonLexerKt.END_OBJ;
    }
}
