package com.bytedance.ug.sdk.clipboard_handler;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.applog.AppLog;
import com.bytedance.ug.sdk.deeplink.CBDInterfaceResolveUtils;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.bytedance.ug.sdk.deeplink.FingerPrintUtil;
import com.bytedance.ug.sdk.deeplink.GlobalContext;
import com.bytedance.ug.sdk.deeplink.HostCommonServices;
import com.bytedance.ug.sdk.deeplink.IClipboardChecker;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.UgServiceManager;
import com.bytedance.ug.sdk.deeplink.UriCacheHandler;
import com.bytedance.ug.sdk.deeplink.UriType;
import com.bytedance.ug.sdk.deeplink.api.internal.IFissionInternalApi;
import com.bytedance.ug.sdk.deeplink.callback.CallbackManager;
import com.bytedance.ug.sdk.deeplink.settings.ZlinkSettingsApi;
import com.bytedance.ug.sdk.deeplink.utils.Base64Util;
import com.bytedance.ug.sdk.deeplink.utils.CollectionsUtils;
import com.bytedance.ug.sdk.deeplink.utils.EventUtil;
import com.bytedance.ug.sdk.deeplink.utils.ThreadUtils;
import com.bytedance.ug.sdk.deeplink.utils.UGZlinkLogger;
import com.bytedance.ug.sdk.deeplink.utils.ZLinkToolUtils;
import com.ss.android.deviceregister.DeviceRegisterManager;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SchemeClipboardChecker implements IClipboardChecker {
    private static volatile SchemeClipboardChecker INSTANCE = null;
    static final String PREFIX = "ttcb";
    private static final String TAG = "SchemeClipboardChecker";
    private static ClipData mClipData;
    private static String mText;

    @Override // com.bytedance.ug.sdk.deeplink.IClipboardChecker
    public int getPriority() {
        return 0;
    }

    SchemeClipboardChecker() {
    }

    public static SchemeClipboardChecker inst() {
        if (INSTANCE == null) {
            synchronized (SchemeClipboardChecker.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SchemeClipboardChecker();
                }
            }
        }
        return INSTANCE;
    }

    @Override // com.bytedance.ug.sdk.deeplink.IClipboardChecker
    public boolean check(Context context, String str, ClipData clipData) {
        if (!canHandle(str)) {
            return false;
        }
        mText = str;
        mClipData = clipData;
        IZlinkDepend zlinkDepend = HostCommonServices.getZlinkDepend();
        if (zlinkDepend != null && TextUtils.isEmpty(zlinkDepend.getDeviceId())) {
            UGZlinkLogger.onDidEmpty();
            addDidCallBack(context);
        }
        return doCheck(str, clipData);
    }

    private void addDidCallBack(Context context) {
        if (ZLinkToolUtils.isMainProcess(context)) {
            try {
                try {
                    DeviceRegisterManager.addOnDeviceConfigUpdateListener(DeviceRegisterListener.getInstance());
                } catch (NoClassDefFoundError unused) {
                    AppLog.addDataObserver(DataObserver.getInstance());
                }
            } catch (NoClassDefFoundError unused2) {
            }
        }
    }

    private boolean doCheck(String str, ClipData clipData) {
        JSONObject jSONObject = new JSONObject();
        String parseClipboardContent = CBDInterfaceResolveUtils.parseClipboardContent(str, jSONObject);
        EventUtil.sendClipboardVerifyEvent(jSONObject);
        if (UriCacheHandler.isRepeatedOrInvalid(clipData, str, parseClipboardContent)) {
            return false;
        }
        if (isSelf(parseClipboardContent)) {
            GlobalContext.INSTANCE.setUriType(UriType.CLIPBOARD);
            EventUtil.sendActivationEvent(UriType.CLIPBOARD, parseClipboardContent, null);
            doCallbackOnMainThread(parseClipboardContent, clipData, str);
            if (!ZlinkSettingsApi.isEnableDevicePrintVerify(GlobalContext.INSTANCE.getApplication())) {
                return true;
            }
            FingerPrintUtil.getInstance().checkSchemeWithDevicePrint(GlobalContext.INSTANCE.getApplication(), parseClipboardContent);
            return true;
        }
        UGZlinkLogger.onSchemeNotInList();
        return false;
    }

    private void doCallbackOnMainThread(final String str, final ClipData clipData, final String str2) {
        final JSONObject customParamsFromScheme = UriCacheHandler.getCustomParamsFromScheme(str);
        ThreadUtils.postMainThread(new Runnable() { // from class: com.bytedance.ug.sdk.clipboard_handler.SchemeClipboardChecker.1
            @Override // java.lang.Runnable
            public void run() {
                CallbackManager.callBackForCheckClipboard(str, str2, clipData);
                IFissionInternalApi iFissionInternalApi = (IFissionInternalApi) UgServiceManager.INSTANCE.getInternalApi(IFissionInternalApi.class);
                if (iFissionInternalApi != null) {
                    iFissionInternalApi.doAttributionOnMainThread(clipData, str2, customParamsFromScheme);
                }
            }
        });
    }

    @Override // com.bytedance.ug.sdk.deeplink.IClipboardChecker
    public boolean isMatch(String str, ClipData clipData) {
        if (canHandle(str)) {
            return isSelf(Base64Util.decode(str, PREFIX));
        }
        return false;
    }

    private boolean canHandle(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(PREFIX)) {
            return true;
        }
        try {
            str2 = Uri.parse(str).getQueryParameter(CommonConstants.ZLINK);
        } catch (Throwable th) {
            th.printStackTrace();
            str2 = null;
        }
        return !TextUtils.isEmpty(str2);
    }

    @Override // com.bytedance.ug.sdk.deeplink.IClipboardChecker
    public boolean isSelf(String str) {
        Uri uri;
        if (!TextUtils.isEmpty(str)) {
            try {
                uri = Uri.parse(str);
            } catch (Throwable th) {
                th.printStackTrace();
                uri = null;
            }
            if (uri == null) {
                return false;
            }
            String scheme = uri.getScheme();
            List<String> schemeList = HostCommonServices.getZlinkDepend() != null ? HostCommonServices.getZlinkDepend().getSchemeList() : null;
            if (!CollectionsUtils.isEmptyList(schemeList)) {
                int size = schemeList.size();
                for (int i = 0; i < size; i++) {
                    if (scheme.equals(schemeList.get(i))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.bytedance.ug.sdk.deeplink.IClipboardChecker
    public boolean process(long j, ClipData clipData) {
        try {
            return ClipboardHelper.getInstance().dealWithSchemeList(j, clipData);
        } catch (Throwable th) {
            CallbackManager.callBackForCheckClipboard("", "", clipData);
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doReCheck() {
        doCheck(mText, mClipData);
    }
}
