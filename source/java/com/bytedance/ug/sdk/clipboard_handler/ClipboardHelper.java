package com.bytedance.ug.sdk.clipboard_handler;

import android.app.Application;
import android.content.ClipData;
import android.text.TextUtils;
import com.bytedance.ug.sdk.deeplink.ClipboardCompat;
import com.bytedance.ug.sdk.deeplink.FingerPrintUtil;
import com.bytedance.ug.sdk.deeplink.GlobalContext;
import com.bytedance.ug.sdk.deeplink.IClipboardChecker;
import com.bytedance.ug.sdk.deeplink.UgServiceManager;
import com.bytedance.ug.sdk.deeplink.UriCacheHandler;
import com.bytedance.ug.sdk.deeplink.api.internal.IFissionInternalApi;
import com.bytedance.ug.sdk.deeplink.callback.CallbackManager;
import com.bytedance.ug.sdk.deeplink.utils.CollectionsUtils;
import com.bytedance.ug.sdk.deeplink.utils.Logger;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import com.bytedance.ug.sdk.deeplink.utils.UGZlinkLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ClipboardHelper {
    private static final String TAG = "ClipboardHelper";
    private final Application mApplication;
    private final Map<String, IClipboardChecker> mCheckerMap;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    private static class InstanceHolder {
        static final ClipboardHelper sInstance = new ClipboardHelper(GlobalContext.INSTANCE.getApplication());

        private InstanceHolder() {
        }
    }

    public static ClipboardHelper getInstance() {
        return InstanceHolder.sInstance;
    }

    private ClipboardHelper(Application application) {
        HashMap hashMap = new HashMap();
        this.mCheckerMap = hashMap;
        this.mApplication = application;
        hashMap.put("scheme", SchemeClipboardChecker.inst());
        IFissionInternalApi iFissionInternalApi = (IFissionInternalApi) UgServiceManager.INSTANCE.getInternalApi(IFissionInternalApi.class);
        if (iFissionInternalApi != null) {
            hashMap.put(IClipboardChecker.TYPE_FISSION, iFissionInternalApi.getFissionClipBoardChecker());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, IClipboardChecker> getCheckerMap() {
        return this.mCheckerMap;
    }

    public IClipboardChecker getClipboardCheckerWithType(String str) {
        if (this.mCheckerMap == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mCheckerMap.get(str);
    }

    public List<String> getClipBoardText(ClipData clipData) {
        if (clipData != null && clipData.getItemCount() > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < clipData.getItemCount(); i++) {
                ClipData.Item itemAt = clipData.getItemAt(i);
                if (itemAt != null && !TextUtils.isEmpty(itemAt.getText())) {
                    arrayList.add(itemAt.getText().toString());
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearMatchSchemeClipBoard() {
        ClipData clipBoardContent = ClipboardCompat.getClipBoardContent(this.mApplication);
        List<String> clipBoardText = getClipBoardText(clipBoardContent);
        if (CollectionsUtils.isEmptyList(clipBoardText)) {
            return;
        }
        for (String str : clipBoardText) {
            IClipboardChecker iClipboardChecker = this.mCheckerMap.get("scheme");
            if (iClipboardChecker != null && iClipboardChecker.isMatch(str, clipBoardContent)) {
                ClipboardCompat.clearClipBoard(this.mApplication, str, clipBoardContent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkSchemeAsync() {
        ThreadUtils.executeAsync(new Runnable() { // from class: com.bytedance.ug.sdk.clipboard_handler.ClipboardHelper.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ClipboardHelper.this.checkScheme();
                } catch (Throwable th) {
                    CallbackManager.callBackForCheckClipboard("", "", null);
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkScheme() {
        dealWithSchemeList(System.currentTimeMillis(), ClipboardCompat.getClipBoardContent(this.mApplication));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void checkScheme(ClipData clipData) {
        dealWithSchemeList(-1L, clipData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean dealWithSchemeList(long j, ClipData clipData) {
        List<String> clipBoardText = getClipBoardText(clipData);
        boolean z = false;
        if (CollectionsUtils.isEmptyList(clipBoardText)) {
            UGZlinkLogger.onClipDataEmpty();
            FingerPrintUtil.getInstance().checkSchemeWithDevicePrint(GlobalContext.INSTANCE.getApplication(), "");
            CallbackManager.callBackForCheckClipboard("", "", clipData);
            return false;
        }
        for (String str : clipBoardText) {
            if (UriCacheHandler.isRepeatedScheme(clipData, str)) {
                UGZlinkLogger.onRepeatScheme();
                Logger.m449i(TAG, "match by deepLink");
            } else if (doCheckScheme(clipData, str)) {
            }
            z = true;
        }
        if (!z) {
            FingerPrintUtil.getInstance().checkSchemeWithDevicePrint(GlobalContext.INSTANCE.getApplication(), "");
            CallbackManager.callBackForCheckClipboard("", "", null);
        }
        UGZlinkLogger.onClipBoardCheckEnd(z);
        return z;
    }

    private boolean doCheckScheme(ClipData clipData, String str) {
        IClipboardChecker iClipboardChecker;
        if (TextUtils.isEmpty(str) || (iClipboardChecker = this.mCheckerMap.get("scheme")) == null) {
            return false;
        }
        return iClipboardChecker.check(this.mApplication, str, clipData);
    }
}
