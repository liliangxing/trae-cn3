package com.bytedance.praisedialoglib.manager;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import com.bytedance.praisedialoglib.callback.IPraiseDialog;
import com.bytedance.praisedialoglib.callback.IPraiseDialogCallback;
import com.bytedance.praisedialoglib.callback.PraiseDialogEnableListener;
import com.bytedance.praisedialoglib.googleplay.IGooglePlayDepend;
import com.bytedance.praisedialoglib.googleplay.IGooglePlayPraiseCallback;
import com.bytedance.praisedialoglib.p006ui.PraiseDialogActivity;
import com.bytedance.praisedialoglib.request.GetDialogEnableThread;
import com.bytedance.praisedialoglib.request.GetXiaomiDeeplinkThread;
import com.bytedance.praisedialoglib.utils.EventReportUtil;
import com.bytedance.praisedialoglib.utils.PraiseDialogSdkUtils;
import com.bytedance.trae.kmp.artifacts.artifact.ArtifactRepository;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PraiseDialogManager {
    public static final int DEFAULT_INFO_STYLE = 0;
    public static final int INFO_STYLE_1 = 1;
    public static final int INFO_STYLE_2 = 2;
    private static final String TAG = "PraiseDialogManager";
    private static final String TOAST_CONTENT_1 = "点击进入「评论」页后发表好评";
    private static final String TOAST_CONTENT_2 = "点击页面右下角按钮发表好评";
    private static final String TOAST_CONTENT_3 = "点击进入「评价」页后发表好评";
    private static PraiseDialogManager sManager;
    private String mAimPkgName;
    private int mInfoTipsStyle;
    private String mMarketOrder;
    private ArrayList<String> mToastContentPkgList1;
    private ArrayList<String> mToastContentPkgList2;
    private ArrayList<String> mToastContentPkgList3;
    private String mToastContent = "";
    private Handler mHandler = new Handler(Looper.getMainLooper());

    private PraiseDialogManager() {
        initToastContentPkgLists();
    }

    public static PraiseDialogManager getInstance() {
        PraiseDialogManager praiseDialogManager = sManager;
        if (praiseDialogManager != null) {
            return praiseDialogManager;
        }
        synchronized (PraiseDialogManager.class) {
            if (sManager == null) {
                sManager = new PraiseDialogManager();
            }
        }
        return sManager;
    }

    public void tryGetDialogEnable(final long j, long j2, final PraiseDialogEnableListener praiseDialogEnableListener) {
        if (PraiseDialogCfgManager.getInstance().isDebugMode()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.1
                @Override // java.lang.Runnable
                public void run() {
                    PraiseDialogManager.this.notifyResult(praiseDialogEnableListener, 100, "current is debug mode");
                }
            }, j2);
        } else if (isPraiseDialogEnable()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.2
                @Override // java.lang.Runnable
                public void run() {
                    PraiseDialogCfgManager.getInstance().executeRunnable(new GetDialogEnableThread(String.valueOf(j), new GetDialogEnableThread.IGetDialogEnableListener() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.2.1
                        @Override // com.bytedance.praisedialoglib.request.GetDialogEnableThread.IGetDialogEnableListener
                        public void onSucceed(String str) {
                            PraiseDialogManager.this.notifyResult(praiseDialogEnableListener, 100, str);
                        }

                        @Override // com.bytedance.praisedialoglib.request.GetDialogEnableThread.IGetDialogEnableListener
                        public void onFailed(int i, String str) {
                            PraiseDialogManager.this.notifyResult(praiseDialogEnableListener, i, str);
                        }
                    }));
                }
            }, j2);
        } else {
            notifyResult(praiseDialogEnableListener, -1, "setting switch is close");
        }
    }

    public void tryShowDialog(long j, long j2, final Context context, final String str) {
        if (PraiseDialogCfgManager.getInstance().isDebugMode() || PraiseDialogCfgManager.getInstance().isCurDemo()) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.3
                @Override // java.lang.Runnable
                public void run() {
                    PraiseDialogManager.this.showPraiseDialogDirectly(context, str);
                }
            }, j2);
        } else if (isPraiseDialogEnable()) {
            this.mHandler.postDelayed(new RunnableC05054(j, context, str), j2);
        } else if (PraiseDialogCfgManager.getInstance().isCurDemo()) {
            this.mHandler.post(new Runnable() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.5
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(context, "settings switch is close", 0).show();
                }
            });
        }
    }

    /* renamed from: com.bytedance.praisedialoglib.manager.PraiseDialogManager$4 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    class RunnableC05054 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$from;
        final /* synthetic */ long val$uid;

        RunnableC05054(long j, Context context, String str) {
            this.val$uid = j;
            this.val$context = context;
            this.val$from = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            PraiseDialogCfgManager.getInstance().executeRunnable(new GetDialogEnableThread(String.valueOf(this.val$uid), new GetDialogEnableThread.IGetDialogEnableListener() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.4.1
                @Override // com.bytedance.praisedialoglib.request.GetDialogEnableThread.IGetDialogEnableListener
                public void onSucceed(String str) {
                    if (PraiseDialogCfgManager.getInstance().isMatchLocalCondition()) {
                        PraiseDialogManager.this.mHandler.post(new Runnable() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.4.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PraiseDialogManager.this.showPraiseDialogDirectly(RunnableC05054.this.val$context, RunnableC05054.this.val$from);
                            }
                        });
                    } else if (PraiseDialogCfgManager.getInstance().isCurDemo()) {
                        PraiseDialogManager.this.mHandler.post(new Runnable() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.4.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(RunnableC05054.this.val$context, "client condition not match", 0).show();
                            }
                        });
                    }
                }

                @Override // com.bytedance.praisedialoglib.request.GetDialogEnableThread.IGetDialogEnableListener
                public void onFailed(int i, String str) {
                    if (PraiseDialogCfgManager.getInstance().isCurDemo()) {
                        PraiseDialogManager.this.mHandler.post(new Runnable() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.4.1.3
                            @Override // java.lang.Runnable
                            public void run() {
                                Toast.makeText(RunnableC05054.this.val$context, "server condition not match", 0).show();
                            }
                        });
                    }
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyResult(final PraiseDialogEnableListener praiseDialogEnableListener, final int i, final String str) {
        this.mHandler.post(new Runnable() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.6
            @Override // java.lang.Runnable
            public void run() {
                praiseDialogEnableListener.onGetDialogEnable(i, str);
            }
        });
    }

    private boolean isPraiseDialogEnable() {
        return PraiseDialogCfgManager.getInstance().getDialogEnable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void showPraiseDialogDirectly(final Context context, final String str) {
        initMarketOrder(context);
        if (PraiseDialogCfgManager.getInstance().needShowDefaultDialog()) {
            Log.d(TAG, "need  show default dialog");
            this.mHandler.post(new Runnable() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.7
                @Override // java.lang.Runnable
                public void run() {
                    PraiseDialogManager.this.showDefaultPraiseDialog(context, str);
                }
            });
            return;
        }
        Log.d(TAG, "don't need default dialog");
        if (context instanceof IPraiseDialog) {
            ((IPraiseDialog) context).onPraiseDialogShow(new IPraiseDialogCallback() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.8
                @Override // com.bytedance.praisedialoglib.callback.IPraiseDialogCallback
                public void onDialogShow() {
                    EventReportUtil.onEvent(EventReportUtil.EVENT_NAME_POP_SHOW, str);
                }

                @Override // com.bytedance.praisedialoglib.callback.IPraiseDialogCallback
                public void onDialogDismiss() {
                    EventReportUtil.onEvent(EventReportUtil.EVENT_NAME_POP_CLOSE, str);
                }

                @Override // com.bytedance.praisedialoglib.callback.IPraiseDialogCallback
                public void onPraiseBtnClick() {
                    EventReportUtil.onEvent(EventReportUtil.EVENT_NAME_POP_GOOD, str);
                    PraiseDialogManager.getInstance().goToMarket();
                }

                @Override // com.bytedance.praisedialoglib.callback.IPraiseDialogCallback
                public void onFeedbackBtnClick() {
                    EventReportUtil.onEvent(EventReportUtil.EVENT_NAME_POP_BAD, str);
                    PraiseDialogManager.getInstance().goToAppFeedback();
                }
            });
        } else if (PraiseDialogCfgManager.getInstance().getIPraiseDialogActionCallback() != null) {
            PraiseDialogCfgManager.getInstance().getIPraiseDialogActionCallback().onPraiseDialogShow(new IPraiseDialogCallback() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.9
                @Override // com.bytedance.praisedialoglib.callback.IPraiseDialogCallback
                public void onDialogShow() {
                    EventReportUtil.onEvent(EventReportUtil.EVENT_NAME_POP_SHOW, str);
                }

                @Override // com.bytedance.praisedialoglib.callback.IPraiseDialogCallback
                public void onDialogDismiss() {
                    EventReportUtil.onEvent(EventReportUtil.EVENT_NAME_POP_CLOSE, str);
                }

                @Override // com.bytedance.praisedialoglib.callback.IPraiseDialogCallback
                public void onPraiseBtnClick() {
                    EventReportUtil.onEvent(EventReportUtil.EVENT_NAME_POP_GOOD, str);
                    PraiseDialogManager.getInstance().goToMarket();
                }

                @Override // com.bytedance.praisedialoglib.callback.IPraiseDialogCallback
                public void onFeedbackBtnClick() {
                    EventReportUtil.onEvent(EventReportUtil.EVENT_NAME_POP_BAD, str);
                    PraiseDialogManager.getInstance().goToAppFeedback();
                }
            });
        }
    }

    public void goToMarket() {
        goToMarket(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goToMarket(boolean z) {
        if (GetXiaomiDeeplinkThread.IS_REQUESTING) {
            return;
        }
        Application application = PraiseSdkManager.getInstance().getApplication();
        if (TextUtils.isEmpty(this.mAimPkgName) && PraiseDialogCfgManager.getInstance().handleNoAppMarket()) {
            return;
        }
        if (checkIfNeedJumpSamsungAppMarket(application)) {
            EventReportUtil.onMarketEvent(this.mAimPkgName);
            return;
        }
        if (checkIfNeedJumpVivoAppMarket(application)) {
            EventReportUtil.onMarketEvent(this.mAimPkgName);
            return;
        }
        if (z || !checkIfNeedJumpXiaomiAppMarket(application)) {
            if (checkIfNeedJumpOppoAppMarket(PraiseDialogCfgManager.getInstance().getTopActivity())) {
                EventReportUtil.onMarketEvent(this.mAimPkgName);
                return;
            }
            if (tryShowGooglePlayCommentDialog(PraiseDialogCfgManager.getInstance().getTopActivity())) {
                EventReportUtil.onMarketEvent(this.mAimPkgName);
                return;
            }
            if (checkIfNeedJumpHuaweiAppMarket(PraiseDialogCfgManager.getInstance().getTopActivity())) {
                if (this.mInfoTipsStyle == 1 && !TextUtils.isEmpty(this.mToastContent)) {
                    showTips(application, this.mToastContent);
                }
                EventReportUtil.onMarketEvent(this.mAimPkgName);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(getDefaultUri());
            if (!TextUtils.isEmpty(this.mAimPkgName)) {
                intent.setPackage(this.mAimPkgName);
            }
            boolean canResolveIntent = canResolveIntent(intent, application);
            if (!canResolveIntent && TextUtils.isEmpty(this.mAimPkgName)) {
                goToAppFeedback();
                return;
            }
            if (!canResolveIntent) {
                intent.setPackage(null);
                if (!canResolveIntent(intent, application)) {
                    goToAppFeedback();
                    return;
                }
            }
            if (this.mInfoTipsStyle == 1 && !TextUtils.isEmpty(this.mToastContent)) {
                showTips(application, this.mToastContent);
            }
            intent.addFlags(268435456);
            PraiseDialogCfgManager.getInstance().startActivity(application, intent);
            EventReportUtil.onMarketEvent(this.mAimPkgName);
        }
    }

    private boolean checkIfNeedJumpHuaweiAppMarket(Context context) {
        if (!TextUtils.isEmpty(this.mAimPkgName) && this.mAimPkgName.equalsIgnoreCase(PraiseDialogConstant.HUAWEI_APP_STORE_PKG_NAME) && !TextUtils.isEmpty(PraiseDialogCfgManager.getInstance().getHuaWeiAppId())) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("hiapplink://com.huawei.appmarket?appId=" + PraiseDialogCfgManager.getInstance().getHuaWeiAppId() + "&channelId=share&callType=SHARE"));
            intent.setFlags(268435456);
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setPackage(PraiseDialogConstant.HUAWEI_APP_STORE_PKG_NAME);
            try {
                PraiseDialogCfgManager.getInstance().startActivity(context, intent);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e(TAG, e.getLocalizedMessage());
            }
        }
        return false;
    }

    private boolean checkIfNeedJumpSamsungAppMarket(Context context) {
        if (!TextUtils.isEmpty(this.mAimPkgName) && this.mAimPkgName.equalsIgnoreCase(PraiseDialogConstant.SAMSUNG_APP_STORE_PKG_NAME)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("samsungapps://ProductDetail/" + PraiseDialogCfgManager.getInstance().getPackageName()));
            intent.setPackage(PraiseDialogConstant.SAMSUNG_APP_STORE_PKG_NAME);
            intent.addFlags(268435456);
            try {
                PraiseDialogCfgManager.getInstance().startActivity(context, intent);
                return true;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean checkIfNeedJumpVivoAppMarket(Context context) {
        if (!TextUtils.isEmpty(this.mAimPkgName) && this.mAimPkgName.equalsIgnoreCase(PraiseDialogConstant.VIVO_APP_STORE_PKG_NAME)) {
            Uri defaultUri = getDefaultUri();
            if (PraiseDialogSdkUtils.isViVoMarketVersionMatch(context)) {
                defaultUri = Uri.parse("market://details?id=" + PraiseDialogCfgManager.getInstance().getPackageName() + "&th_name=need_comment");
            }
            Intent intent = new Intent("android.intent.action.VIEW", defaultUri);
            intent.setFlags(268435456);
            intent.setPackage(PraiseDialogConstant.VIVO_APP_STORE_PKG_NAME);
            try {
                PraiseDialogCfgManager.getInstance().startActivity(context, intent);
                return true;
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean checkIfNeedJumpXiaomiAppMarket(final Context context) {
        if (TextUtils.isEmpty(this.mAimPkgName) || !this.mAimPkgName.equalsIgnoreCase(PraiseDialogConstant.XIAOMI_APP_STORE_PKG_NAME)) {
            return false;
        }
        GetXiaomiDeeplinkThread.IS_REQUESTING = true;
        PraiseDialogCfgManager.getInstance().executeRunnable(new GetXiaomiDeeplinkThread(new GetXiaomiDeeplinkThread.IGetXiaomiDeeplinkListener() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.10
            @Override // com.bytedance.praisedialoglib.request.GetXiaomiDeeplinkThread.IGetXiaomiDeeplinkListener
            public void onSucceed(final String str) {
                PraiseDialogManager.this.mHandler.post(new Runnable() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.10.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GetXiaomiDeeplinkThread.IS_REQUESTING = false;
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setData(Uri.parse(str));
                        intent.setFlags(268435456);
                        try {
                            PraiseDialogCfgManager.getInstance().startActivity(context, intent);
                            EventReportUtil.onMarketEvent(PraiseDialogManager.this.mAimPkgName);
                        } catch (ActivityNotFoundException e) {
                            e.printStackTrace();
                            PraiseDialogManager.this.goToMarket(true);
                        }
                    }
                });
            }

            @Override // com.bytedance.praisedialoglib.request.GetXiaomiDeeplinkThread.IGetXiaomiDeeplinkListener
            public void onFailed(int i, String str) {
                PraiseDialogManager.this.mHandler.post(new Runnable() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.10.2
                    @Override // java.lang.Runnable
                    public void run() {
                        GetXiaomiDeeplinkThread.IS_REQUESTING = false;
                        PraiseDialogManager.this.goToMarket(true);
                    }
                });
            }
        }));
        return true;
    }

    private boolean checkIfNeedJumpOppoAppMarket(Activity activity) {
        Log.d(TAG, "checkIfNeedJumpOppoAppMarket is called, aimPkgName is " + this.mAimPkgName);
        if (!TextUtils.isEmpty(this.mAimPkgName) && (this.mAimPkgName.equalsIgnoreCase(PraiseDialogConstant.OPPO_APP_STORE_PKG_NAME) || this.mAimPkgName.equalsIgnoreCase(PraiseDialogConstant.HEYTAP_APP_STORE_PKG_NAME))) {
            if (tryShowOppoCommentDialog(PraiseDialogCfgManager.getInstance().getTopActivity())) {
                Log.d(TAG, "tryShowOppoCommentDialog is success");
                return true;
            }
            Intent intent = new Intent("android.intent.action.VIEW", getDefaultUri());
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(this.mAimPkgName);
            try {
                PraiseDialogCfgManager.getInstance().startActivityForResult(activity, intent);
                Log.d(TAG, "jump appStore is success");
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e(TAG, "checkIfNeedJumpOppoAppMarket jumpAppStore failed, " + e);
                e.printStackTrace();
            }
        }
        return false;
    }

    private static boolean tryShowOppoCommentDialog(Activity activity) {
        if (activity == null) {
            return false;
        }
        String str = PraiseDialogConstant.COMMENT_DEEPLINK_PREFIX + PraiseDialogCfgManager.getInstance().getPackageName();
        if (getVersionCode(activity, PraiseDialogConstant.HEYTAP_APP_STORE_PKG_NAME) > 84000) {
            return showOppoPraiseDialog(activity, Uri.parse(str), PraiseDialogConstant.HEYTAP_APP_STORE_PKG_NAME);
        }
        if (getVersionCode(activity, PraiseDialogConstant.OPPO_APP_STORE_PKG_NAME) > 84000) {
            return showOppoPraiseDialog(activity, Uri.parse(str), PraiseDialogConstant.OPPO_APP_STORE_PKG_NAME);
        }
        return false;
    }

    private boolean tryShowGooglePlayCommentDialog(final Activity activity) {
        if (TextUtils.isEmpty(this.mAimPkgName) || !this.mAimPkgName.equalsIgnoreCase(PraiseDialogConstant.GOOGLE_PLAY_STORE) || !PraiseDialogSdkUtils.isInstalledApp(activity, PraiseDialogConstant.GOOGLE_PLAY_STORE) || !PraiseDialogSdkUtils.isInstalledApp(activity, PraiseDialogConstant.GOOGLE_PLAY_SERVICE)) {
            return false;
        }
        IGooglePlayDepend googlePlayDepend = DependManager.getGooglePlayDepend();
        if (googlePlayDepend != null) {
            googlePlayDepend.showInAppPraiseDialogForGp(activity, new IGooglePlayPraiseCallback() { // from class: com.bytedance.praisedialoglib.manager.PraiseDialogManager.11
                @Override // com.bytedance.praisedialoglib.googleplay.IGooglePlayPraiseCallback
                public void statusCallback(boolean z) {
                    if (z) {
                        return;
                    }
                    PraiseDialogManager.this.jumpToGp(activity);
                }
            });
            return true;
        }
        jumpToGp(activity);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpToGp(Activity activity) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(getDefaultUri());
        intent.setPackage(PraiseDialogConstant.GOOGLE_PLAY_STORE);
        intent.addFlags(268435456);
        PraiseDialogCfgManager.getInstance().startActivity(activity, intent);
        EventReportUtil.onMarketEvent(PraiseDialogConstant.GOOGLE_PLAY_STORE);
    }

    private static long getVersionCode(Activity activity, String str) {
        try {
            PackageInfo packageInfo = activity.getPackageManager().getPackageInfo(str, 128);
            if (packageInfo != null) {
                return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
            }
            return -1L;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "getVersionCode meet exception, " + e);
            return -1L;
        }
    }

    private boolean checkIfNeedShowOppoGuide(Activity activity) {
        if (!PraiseDialogConstant.HEYTAP_APP_STORE_PKG_NAME.equals(this.mAimPkgName) || getVersionCode(activity, PraiseDialogConstant.HEYTAP_APP_STORE_PKG_NAME) <= 84000) {
            return !PraiseDialogConstant.OPPO_APP_STORE_PKG_NAME.equals(this.mAimPkgName) || getVersionCode(activity, PraiseDialogConstant.OPPO_APP_STORE_PKG_NAME) <= 84000;
        }
        return false;
    }

    private static boolean showOppoPraiseDialog(Activity activity, Uri uri, String str) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setPackage(str);
            intent.setData(uri);
            PraiseDialogCfgManager.getInstance().startActivityForResult(activity, intent);
            Log.d(TAG, "showOppoPraiseDialog is called, return true, uri is " + uri);
            return true;
        } catch (Throwable th) {
            Log.e(TAG, "showOppoPraiseDialog meet err, " + th);
            return false;
        }
    }

    private Uri getDefaultUri() {
        return Uri.parse("market://details?id=" + PraiseDialogCfgManager.getInstance().getPackageName());
    }

    public void goToAppFeedback() {
        PraiseDialogCfgManager.getInstance().goToFeedback(PraiseSdkManager.getInstance().getApplication());
    }

    private boolean canResolveIntent(Intent intent, Context context) {
        if (intent == null) {
            return false;
        }
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, ArtifactRepository.IO_CHUNK_SIZE);
            if (queryIntentActivities != null) {
                return queryIntentActivities.size() > 0;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public void initMarketOrder(Context context) {
        this.mAimPkgName = "";
        String marketOrder = PraiseDialogCfgManager.getInstance().getMarketOrder();
        this.mMarketOrder = marketOrder;
        if (TextUtils.isEmpty(marketOrder)) {
            Log.d(TAG, "initMarketOrder is called, but mMarketOrder is empty");
            return;
        }
        String[] split = this.mMarketOrder.split("\\|");
        int length = split.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String str = split[i];
            if (PraiseDialogSdkUtils.isInstalledApp(context, str)) {
                this.mAimPkgName = str;
                break;
            }
            i++;
        }
        initInfoStyle();
    }

    private void initInfoStyle() {
        this.mInfoTipsStyle = 0;
        if (PraiseDialogCfgManager.getInstance().getGuideStyle2List() != null && PraiseDialogCfgManager.getInstance().getGuideStyle2List().contains(this.mAimPkgName)) {
            this.mInfoTipsStyle = 2;
        } else {
            if (PraiseDialogCfgManager.getInstance().getGuideStyle1List() == null || !PraiseDialogCfgManager.getInstance().getGuideStyle1List().contains(this.mAimPkgName)) {
                return;
            }
            this.mInfoTipsStyle = 1;
            initToastContent();
        }
    }

    private void initToastContent() {
        if (this.mToastContentPkgList1.contains(this.mAimPkgName)) {
            this.mToastContent = TOAST_CONTENT_1;
        } else if (this.mToastContentPkgList2.contains(this.mAimPkgName)) {
            this.mToastContent = TOAST_CONTENT_2;
        } else if (this.mToastContentPkgList3.contains(this.mAimPkgName)) {
            this.mToastContent = TOAST_CONTENT_3;
        }
    }

    private void initToastContentPkgLists() {
        ArrayList<String> arrayList = new ArrayList<>();
        this.mToastContentPkgList1 = arrayList;
        arrayList.add(PraiseDialogConstant.OPPO_APP_STORE_PKG_NAME);
        this.mToastContentPkgList1.add("com.meizu.mstore");
        this.mToastContentPkgList1.add("com.tencent.android.qqdownloader");
        this.mToastContentPkgList1.add("com.qihoo.appstore");
        this.mToastContentPkgList1.add("com.baidu.appsearch");
        this.mToastContentPkgList1.add("com.sogou.androidtool");
        ArrayList<String> arrayList2 = new ArrayList<>();
        this.mToastContentPkgList2 = arrayList2;
        arrayList2.add(PraiseDialogConstant.HUAWEI_APP_STORE_PKG_NAME);
        ArrayList<String> arrayList3 = new ArrayList<>();
        this.mToastContentPkgList3 = arrayList3;
        arrayList3.add("com.wandoujia.phoenix2");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDefaultPraiseDialog(Context context, String str) {
        if (context == null) {
            Log.e(TAG, "context is null");
            return;
        }
        try {
            if ((context instanceof Activity) && (((Activity) context).isFinishing() || ((Activity) context).isDestroyed())) {
                Log.i(TAG, "context is finishing or destroyed, replaced by application context");
                context = PraiseSdkManager.getInstance().getApplication().getBaseContext();
            }
            Intent intent = new Intent(context, (Class<?>) PraiseDialogActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(PraiseDialogConstant.FROM, str);
            initDialogUi(intent);
            context.startActivity(intent);
        } catch (Throwable th) {
            Log.e(TAG, "startActivity meet err, " + th);
        }
    }

    private void showTips(Context context, String str) {
        Toast.makeText(context, str, 1).show();
    }

    private void initDialogUi(Intent intent) {
        if (PraiseDialogCfgManager.getInstance().getBackgroundResId() != -1 && PraiseDialogCfgManager.getInstance().getBackgroundResId() != 0) {
            intent.putExtra(PraiseDialogConstant.BACKGROUND_RES, PraiseDialogCfgManager.getInstance().getBackgroundResId());
        }
        int middleImgResId = PraiseDialogCfgManager.getInstance().getMiddleImgResId();
        if (this.mInfoTipsStyle == 2 && checkIfNeedShowOppoGuide(PraiseDialogCfgManager.getInstance().getTopActivity())) {
            middleImgResId = PraiseDialogCfgManager.getInstance().getMiddleImgResIdStyle2();
        }
        if (middleImgResId != -1 && middleImgResId != 0) {
            intent.putExtra(PraiseDialogConstant.MIDDLE_IMAGE_RES, middleImgResId);
        }
        if (!TextUtils.isEmpty(PraiseDialogCfgManager.getInstance().getTitleStr())) {
            intent.putExtra(PraiseDialogConstant.MAIN_TITLE_TEXT, PraiseDialogCfgManager.getInstance().getTitleStr());
        }
        if (!TextUtils.isEmpty(PraiseDialogCfgManager.getInstance().getTitleStrColor())) {
            intent.putExtra(PraiseDialogConstant.MAIN_TITLE_TEXT_COLOR, PraiseDialogCfgManager.getInstance().getTitleStrColor());
        }
        if (PraiseDialogCfgManager.getInstance().getTitleStrSize() != -1 && PraiseDialogCfgManager.getInstance().getTitleStrSize() != 0) {
            intent.putExtra(PraiseDialogConstant.MAIN_TITLE_TEXT_SIZE, PraiseDialogCfgManager.getInstance().getTitleStrSize());
        }
        if (!TextUtils.isEmpty(PraiseDialogCfgManager.getInstance().getSecondTitleStr())) {
            intent.putExtra(PraiseDialogConstant.SECOND_TITLE_TEXT, PraiseDialogCfgManager.getInstance().getSecondTitleStr());
        }
        if (!TextUtils.isEmpty(PraiseDialogCfgManager.getInstance().getSecondTitleStrColor())) {
            intent.putExtra(PraiseDialogConstant.SECOND_TITLE_TEXT_COLOR, PraiseDialogCfgManager.getInstance().getSecondTitleStrColor());
        }
        if (PraiseDialogCfgManager.getInstance().getSecondTitleStrSize() != -1 && PraiseDialogCfgManager.getInstance().getSecondTitleStrSize() != 0) {
            intent.putExtra(PraiseDialogConstant.SECOND_TITLE_TEXT_SIZE, PraiseDialogCfgManager.getInstance().getSecondTitleStrSize());
        }
        if (!TextUtils.isEmpty(PraiseDialogCfgManager.getInstance().getNegativeBtnStr())) {
            intent.putExtra(PraiseDialogConstant.NEGATIVE_BTN_TEXT, PraiseDialogCfgManager.getInstance().getNegativeBtnStr());
        }
        if (!TextUtils.isEmpty(PraiseDialogCfgManager.getInstance().getNegativeBtnColor())) {
            intent.putExtra(PraiseDialogConstant.NEGATIVE_BTN_TEXT_COLOR, PraiseDialogCfgManager.getInstance().getNegativeBtnColor());
        }
        if (PraiseDialogCfgManager.getInstance().getNegativeBtnSize() != -1 && PraiseDialogCfgManager.getInstance().getNegativeBtnSize() != 0) {
            intent.putExtra(PraiseDialogConstant.NEGATIVE_BTN_TEXT_SIZE, PraiseDialogCfgManager.getInstance().getNegativeBtnSize());
        }
        if (PraiseDialogCfgManager.getInstance().getNegativeBtnResId() != -1 && PraiseDialogCfgManager.getInstance().getNegativeBtnResId() != 0) {
            intent.putExtra(PraiseDialogConstant.NEGATIVE_BTN_TEXT_BG, PraiseDialogCfgManager.getInstance().getNegativeBtnResId());
        }
        if (!TextUtils.isEmpty(PraiseDialogCfgManager.getInstance().getPositiveBtnStr())) {
            intent.putExtra(PraiseDialogConstant.POSITIVE_BTN_TEXT, PraiseDialogCfgManager.getInstance().getPositiveBtnStr());
        }
        if (!TextUtils.isEmpty(PraiseDialogCfgManager.getInstance().getPositiveBtnColor())) {
            intent.putExtra(PraiseDialogConstant.POSITIVE_BTN_TEXT_COLOR, PraiseDialogCfgManager.getInstance().getPositiveBtnColor());
        }
        if (PraiseDialogCfgManager.getInstance().getPositiveBtnSize() != -1 && PraiseDialogCfgManager.getInstance().getPositiveBtnSize() != 0) {
            intent.putExtra(PraiseDialogConstant.POSITIVE_BTN_TEXT_SIZE, PraiseDialogCfgManager.getInstance().getPositiveBtnSize());
        }
        if (PraiseDialogCfgManager.getInstance().getPositiveBtnResId() == -1 || PraiseDialogCfgManager.getInstance().getPositiveBtnResId() == 0) {
            return;
        }
        intent.putExtra(PraiseDialogConstant.POSITIVE_BTN_TEXT_BG, PraiseDialogCfgManager.getInstance().getPositiveBtnResId());
    }
}
