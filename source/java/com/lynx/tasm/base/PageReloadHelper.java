package com.lynx.tasm.base;

import android.text.TextUtils;
import android.util.Base64;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.shadow.text.TextRendererCache;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class PageReloadHelper {
    private static final String TAG = "PageReloadHelper";
    private InitData mInitBinaryData;
    private InitBundleData mInitBundleData;
    private InitUrlData mInitUrlData;
    private WeakReference<LynxView> mLynxView;
    private TemplateData mInitTemplateData = TemplateData.fromMap(new HashMap());
    private TemplateData mInitGlobalProps = null;
    private String mUrl = null;
    private boolean mInitWithBinary = false;
    private boolean mInitWithUrl = false;
    private boolean mInitWithBundle = false;
    private ByteBuffer mFragmentsBuffer = null;
    private boolean mIgnoreCache = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class InitData {
        private String mBaseUrl;
        private byte[] mTemplate;

        private InitData() {
            this.mTemplate = null;
            this.mBaseUrl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class InitUrlData {
        private String mInitUrl;
        private byte[] mTemplate;

        private InitUrlData() {
            this.mTemplate = null;
            this.mInitUrl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class InitBundleData {
        private String mBaseUrl;
        private TemplateBundle mTemplateBundle;

        private InitBundleData() {
            this.mTemplateBundle = null;
            this.mBaseUrl = null;
        }
    }

    public PageReloadHelper(LynxView lynxView) {
        this.mLynxView = new WeakReference<>(lynxView);
        this.mInitBinaryData = new InitData();
        this.mInitBundleData = new InitBundleData();
        this.mInitUrlData = new InitUrlData();
    }

    public void attach(LynxView lynxView) {
        this.mLynxView = new WeakReference<>(lynxView);
    }

    public void saveURL(String str, TemplateData templateData, Map<String, Object> map, String str2) {
        if (templateData != null) {
            loadFromURL(str, templateData);
            return;
        }
        if (map != null) {
            loadFromURL(str, TemplateData.fromMap(map));
        } else if (str2 != null) {
            loadFromURL(str, TemplateData.fromString(str2));
        } else {
            loadFromURL(str, null);
        }
    }

    public void loadFromURL(String str, TemplateData templateData) {
        LLog.m2578i(TAG, "loadFromURL:" + str);
        this.mInitWithBinary = false;
        this.mInitWithBundle = false;
        this.mInitWithUrl = true;
        this.mInitUrlData.mInitUrl = str;
        updateInitTemplateData(templateData);
        this.mUrl = str;
    }

    public void onTemplateDataUpdated(TemplateData templateData) {
        updateInitTemplateData(templateData);
    }

    private void updateInitTemplateData(TemplateData templateData) {
        if (templateData == null) {
            return;
        }
        this.mInitTemplateData.updateWithTemplateData(templateData.deepClone());
    }

    public void onTemplateDataReset(TemplateData templateData) {
        resetInitTemplateData(templateData);
    }

    private void resetInitTemplateData(TemplateData templateData) {
        this.mInitTemplateData = templateData;
    }

    public void onGlobalPropsUpdated(TemplateData templateData) {
        this.mInitGlobalProps = templateData;
    }

    public void loadFromLocalFile(byte[] bArr, TemplateData templateData, String str) {
        LLog.m2578i(TAG, "loadFromLocalFile:" + str);
        this.mInitWithUrl = false;
        this.mInitWithBundle = false;
        this.mInitWithBinary = true;
        this.mInitBinaryData.mTemplate = bArr;
        this.mInitBinaryData.mBaseUrl = str;
        updateInitTemplateData(templateData);
        this.mUrl = str;
    }

    public void loadFromBundle(TemplateBundle templateBundle, TemplateData templateData, String str) {
        LLog.m2578i(TAG, "loadFromBundle:" + str);
        this.mInitWithBinary = false;
        this.mInitWithUrl = false;
        this.mInitWithBundle = true;
        this.mInitBundleData.mTemplateBundle = templateBundle;
        this.mInitBundleData.mBaseUrl = str;
        updateInitTemplateData(templateData);
        this.mUrl = str;
    }

    public void reload(boolean z) {
        reload(z, null);
    }

    public void reload(boolean z, String str, boolean z2, int i) {
        reload(z, str, z2, i, null);
    }

    public void reloadWithUrl(boolean z, String str) {
        LLog.m2578i(TAG, "reloadWithUrl passed by Page.reload CDP msg:" + str);
        this.mUrl = str;
        if (z) {
            clearCache();
        }
        LynxView lynxView = this.mLynxView.get();
        if (lynxView == null || TextUtils.isEmpty(str)) {
            return;
        }
        lynxView.renderTemplateUrl(str, this.mInitTemplateData);
    }

    public void reload(boolean z, String str, boolean z2, int i, String str2) {
        if (str2 != null && str2.startsWith("http")) {
            reloadWithUrl(z, str2);
            return;
        }
        byte[] bArr = null;
        if (!TextUtils.isEmpty(str)) {
            LLog.m2578i(TAG, "reload with single template binary transferred by usb");
            try {
                bArr = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                LLog.m2577e(TAG, "Template base64 decode failed:" + e.getMessage());
            }
            reload(z, bArr);
            return;
        }
        if (z2 && i > 0) {
            LLog.m2578i(TAG, "reload with template fragments transferred by usb");
            this.mFragmentsBuffer = ByteBuffer.allocate(i);
            this.mIgnoreCache = z;
            return;
        }
        reload(z, null);
    }

    private void reload(boolean z, byte[] bArr) {
        String str;
        String str2;
        if (z) {
            clearCache();
        }
        LynxView lynxView = this.mLynxView.get();
        if (lynxView == null) {
            return;
        }
        TemplateBundle templateBundle = null;
        if (this.mInitWithBinary) {
            if ((TextUtils.isEmpty(this.mUrl) || !this.mUrl.startsWith("http")) && bArr == null) {
                bArr = this.mInitBinaryData.mTemplate;
                LLog.m2580w(TAG, "Reloading lynx view with the old template binary data, the code changes may not take effect.");
            }
            str = this.mUrl;
        } else if (!this.mInitWithBundle) {
            str = this.mInitUrlData.mInitUrl;
            if (str != null) {
                long currentTimeMillis = System.currentTimeMillis();
                int lastIndexOf = str.lastIndexOf("?");
                if (lastIndexOf != -1) {
                    str2 = str.substring(0, lastIndexOf + 1);
                } else {
                    str2 = str + "?";
                }
                str = str2 + String.valueOf(currentTimeMillis);
            }
        } else {
            if (TextUtils.isEmpty(this.mUrl) || !this.mUrl.startsWith("http")) {
                templateBundle = this.mInitBundleData.mTemplateBundle;
                LLog.m2580w(TAG, "Reloading lynx view with the old template bundle data, the code changes may not take effect.");
            }
            str = this.mUrl;
        }
        if (bArr != null) {
            lynxView.renderTemplateWithBaseUrl(bArr, this.mInitTemplateData, str);
            return;
        }
        if (templateBundle != null) {
            lynxView.renderTemplateBundle(templateBundle, this.mInitTemplateData, str);
        } else if (str != null) {
            lynxView.renderTemplateUrl(str, this.mInitTemplateData);
        } else {
            LLog.m2580w(TAG, "Failed to reload, the lynx view may not have been loaded before.");
        }
    }

    public void onReceiveTemplateFragment(String str, boolean z) {
        byte[] decode;
        LLog.m2578i(TAG, "on receive template fragment");
        try {
            if (!TextUtils.isEmpty(str) && this.mFragmentsBuffer != null && (decode = Base64.decode(str, 0)) != null && decode.length > 0 && this.mFragmentsBuffer.remaining() >= decode.length) {
                this.mFragmentsBuffer.put(decode);
            }
        } catch (Exception e) {
            LLog.m2577e(TAG, "Template fragments base64 decode failed:" + e.getMessage());
        }
        if (z) {
            LLog.m2578i(TAG, "end of template fragments");
            ByteBuffer byteBuffer = this.mFragmentsBuffer;
            if (byteBuffer != null && byteBuffer.position() > 0) {
                reload(this.mIgnoreCache, this.mFragmentsBuffer.array());
            } else {
                reload(this.mIgnoreCache, null);
            }
            this.mFragmentsBuffer = null;
        }
    }

    public void navigate(String str) {
        this.mInitWithBinary = false;
        this.mInitWithBundle = false;
        this.mInitWithUrl = true;
        this.mInitUrlData.mInitUrl = str;
        this.mInitTemplateData = TemplateData.fromString("");
        LynxView lynxView = this.mLynxView.get();
        if (lynxView == null) {
            return;
        }
        lynxView.renderTemplateUrl(this.mInitUrlData.mInitUrl, this.mInitTemplateData);
    }

    public String getURL() {
        return this.mUrl;
    }

    public void clearCache() {
        TextRendererCache.cache().clearCache();
    }

    public long getTemplateDataPtr() {
        TemplateData templateData = this.mInitTemplateData;
        if (templateData != null) {
            return templateData.getNativePtr();
        }
        return 0L;
    }

    public String getTemplateJsInfo(int i, int i2) {
        byte[] bArr;
        if (this.mInitWithBinary) {
            bArr = this.mInitBinaryData.mTemplate;
        } else {
            bArr = this.mInitWithUrl ? this.mInitUrlData.mTemplate : null;
        }
        if (bArr == null || i >= bArr.length) {
            return "";
        }
        int length = bArr.length;
        if (i + i2 > length) {
            i2 = length - i;
        }
        return Base64.encodeToString(bArr, i, i2, 0);
    }

    public void onTemplateLoadSuccess(byte[] bArr) {
        this.mInitUrlData.mTemplate = bArr;
    }
}
