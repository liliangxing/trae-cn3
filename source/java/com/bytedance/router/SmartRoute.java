package com.bytedance.router;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.router.RouteIntent;
import com.bytedance.router.listener.error.ErrorHandler;
import com.bytedance.router.util.Logger;
import com.bytedance.router.util.Util;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SmartRoute {
    private Context mContext;
    private Uri mData;
    private String mUrl = "";
    private int enterAnim = -1;
    private int exitAnim = -1;
    private Intent mExtraParams = new Intent();

    /* JADX INFO: Access modifiers changed from: package-private */
    public SmartRoute(Context context) {
        this.mContext = context;
    }

    public void open() {
        if (this.mContext == null) {
            Logger.m352e("SmartRoute#open context is null!!!");
            ErrorHandler.noticeError("open context is null");
        } else if (TextUtils.isEmpty(this.mUrl)) {
            Logger.m352e("SmartRoute#url is null!!!");
            ErrorHandler.noticeError("url is null");
        } else if (!Util.isLegalUrl(this.mUrl)) {
            Logger.m352e("SmartRoute#url is illegal and url is " + this.mUrl);
            ErrorHandler.noticeError("url is illegal and url is" + this.mUrl);
        } else {
            RouteManager.getInstance().open(this.mContext, buildRouteIntent());
        }
    }

    public void open(int i) {
        if (i == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("requestCode must not be Integer.MIN_VALUE:-2147483648 !!!");
        }
        if (this.mContext == null) {
            Logger.m352e("SmartRoute#open context is null!!!");
            ErrorHandler.noticeError("context is null");
            return;
        }
        if (TextUtils.isEmpty(this.mUrl)) {
            Logger.m352e("SmartRoute#url is null!!!");
            ErrorHandler.noticeError("url is null");
            return;
        }
        if (!Util.isLegalUrl(this.mUrl)) {
            Logger.m352e("SmartRoute#url is illegal and url is " + this.mUrl);
            ErrorHandler.noticeError("url is illegal and url is " + this.mUrl);
        } else if (!(this.mContext instanceof Activity)) {
            Logger.m352e("SmartRoute#context is not Activity!!!");
            ErrorHandler.noticeError("you have to provide the Context of activity type for use requestCode");
        } else {
            RouteIntent buildRouteIntent = buildRouteIntent();
            buildRouteIntent.setRequestCode(i);
            RouteManager.getInstance().open(this.mContext, buildRouteIntent);
        }
    }

    public Intent buildIntent() {
        if (TextUtils.isEmpty(this.mUrl)) {
            Logger.m352e("SmartRoute#url is null!!!");
            ErrorHandler.noticeError("url is null");
            return null;
        }
        if (!Util.isLegalUrl(this.mUrl)) {
            Logger.m352e("SmartRoute#url is illegal and url is " + this.mUrl);
            ErrorHandler.noticeError("url is illegal and url is " + this.mUrl);
            return null;
        }
        return RouteManager.getInstance().buildIntent(this.mContext, buildRouteIntent());
    }

    private RouteIntent buildRouteIntent() {
        return new RouteIntent.Builder().withUrl(this.mUrl).withParam(this.mExtraParams).addFlags(this.mExtraParams.getFlags()).withAnimation(this.enterAnim, this.exitAnim).withData(this.mData).build();
    }

    public SmartRoute withUrl(String str) {
        this.mUrl = str;
        return this;
    }

    public SmartRoute withParam(String str, boolean z) {
        this.mExtraParams.putExtra(str, z);
        return this;
    }

    public SmartRoute withParam(String str, boolean[] zArr) {
        this.mExtraParams.putExtra(str, zArr);
        return this;
    }

    public SmartRoute withParam(String str, Bundle bundle) {
        this.mExtraParams.putExtra(str, bundle);
        return this;
    }

    public SmartRoute withParam(String str, byte b) {
        this.mExtraParams.putExtra(str, b);
        return this;
    }

    public SmartRoute withParam(String str, byte[] bArr) {
        this.mExtraParams.putExtra(str, bArr);
        return this;
    }

    public SmartRoute withParam(String str, char c) {
        this.mExtraParams.putExtra(str, c);
        return this;
    }

    public SmartRoute withParam(String str, char[] cArr) {
        this.mExtraParams.putExtra(str, cArr);
        return this;
    }

    public SmartRoute withParam(String str, CharSequence charSequence) {
        this.mExtraParams.putExtra(str, charSequence);
        return this;
    }

    public SmartRoute withParam(String str, CharSequence[] charSequenceArr) {
        this.mExtraParams.putExtra(str, charSequenceArr);
        return this;
    }

    public SmartRoute withParamCharSequenceList(String str, ArrayList<CharSequence> arrayList) {
        this.mExtraParams.putCharSequenceArrayListExtra(str, arrayList);
        return this;
    }

    public SmartRoute withParam(String str, double d) {
        this.mExtraParams.putExtra(str, d);
        return this;
    }

    public SmartRoute withParam(String str, double[] dArr) {
        this.mExtraParams.putExtra(str, dArr);
        return this;
    }

    public SmartRoute withParam(String str, float f) {
        this.mExtraParams.putExtra(str, f);
        return this;
    }

    public SmartRoute withParam(String str, float[] fArr) {
        this.mExtraParams.putExtra(str, fArr);
        return this;
    }

    public SmartRoute withParam(String str, int i) {
        this.mExtraParams.putExtra(str, i);
        return this;
    }

    public SmartRoute withParam(String str, int[] iArr) {
        this.mExtraParams.putExtra(str, iArr);
        return this;
    }

    public SmartRoute withParamIntegerList(String str, ArrayList<Integer> arrayList) {
        this.mExtraParams.putIntegerArrayListExtra(str, arrayList);
        return this;
    }

    public SmartRoute withParam(String str, long j) {
        this.mExtraParams.putExtra(str, j);
        return this;
    }

    public SmartRoute withParam(String str, long[] jArr) {
        this.mExtraParams.putExtra(str, jArr);
        return this;
    }

    public SmartRoute withParam(String str, Parcelable parcelable) {
        this.mExtraParams.putExtra(str, parcelable);
        return this;
    }

    public SmartRoute withParam(String str, Parcelable[] parcelableArr) {
        this.mExtraParams.putExtra(str, parcelableArr);
        return this;
    }

    public SmartRoute withParamParcelableList(String str, ArrayList<? extends Parcelable> arrayList) {
        this.mExtraParams.putParcelableArrayListExtra(str, arrayList);
        return this;
    }

    public SmartRoute withParam(String str, Serializable serializable) {
        this.mExtraParams.putExtra(str, serializable);
        return this;
    }

    public SmartRoute withParam(String str, short s) {
        this.mExtraParams.putExtra(str, s);
        return this;
    }

    public SmartRoute withParam(String str, short[] sArr) {
        this.mExtraParams.putExtra(str, sArr);
        return this;
    }

    public SmartRoute withParam(String str, String str2) {
        this.mExtraParams.putExtra(str, str2);
        return this;
    }

    public SmartRoute withParam(String str, String[] strArr) {
        this.mExtraParams.putExtra(str, strArr);
        return this;
    }

    public SmartRoute withParamStringList(String str, ArrayList<String> arrayList) {
        this.mExtraParams.putStringArrayListExtra(str, arrayList);
        return this;
    }

    public SmartRoute withParam(Bundle bundle) {
        this.mExtraParams.putExtras(bundle);
        return this;
    }

    public SmartRoute withParam(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            this.mExtraParams.putExtras(extras);
        }
        return this;
    }

    public SmartRoute addFlags(int i) {
        this.mExtraParams.addFlags(i);
        return this;
    }

    public SmartRoute withAnimation(int i, int i2) {
        this.enterAnim = i;
        this.exitAnim = i2;
        return this;
    }

    public SmartRoute withParam(Uri uri) {
        this.mData = uri;
        return this;
    }

    private void sliceParams2Intent(Intent intent, String str) {
        Map<String, String> sliceUrlParams = Util.sliceUrlParams(str);
        if (sliceUrlParams == null || sliceUrlParams.size() == 0) {
            return;
        }
        for (Map.Entry<String, String> entry : sliceUrlParams.entrySet()) {
            intent.putExtra(entry.getKey(), entry.getValue());
        }
    }
}
