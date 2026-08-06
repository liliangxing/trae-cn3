package com.bytedance.praisedialoglib.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.praisedialoglib.ThreadPool.ThreadPlus;
import com.bytedance.praisedialoglib.callback.IPraiseDialogActionCallback;
import com.bytedance.praisedialoglib.depend.IPraiseDialogAppConfig;
import com.bytedance.praisedialoglib.depend.IPraiseDialogAsyncThreadConfig;
import com.bytedance.praisedialoglib.depend.IPraiseDialogConfig;
import com.bytedance.praisedialoglib.depend.IPraiseDialogLocalConditionConfig;
import com.bytedance.praisedialoglib.depend.IPraiseDialogNetworkConfig;
import com.bytedance.praisedialoglib.depend.IPraiseDialogStartActivityConfig;
import com.bytedance.praisedialoglib.depend.IPraiseDialogUIConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class PraiseDialogCfgManager {
    private static final String TAG = "PraiseDialogCfgManager";
    private IPraiseDialogAppConfig mAppConfig;
    private IPraiseDialogAsyncThreadConfig mAsyncThreadConfig;
    private boolean mDebugMode;
    private boolean mDialogEnable;
    private String mFeedBackUrl;
    private String mGuideStyle1MarketListStr;
    private String mGuideStyle2MarketListStr;
    private String mGuideStyle3MarketListStr;
    private IPraiseDialogActionCallback mIPraiseDialogActionCallback;
    private IPraiseDialogLocalConditionConfig mLocalConfig;
    private String mMarketOrder;
    private IPraiseDialogNetworkConfig mNetworkConfig;
    private IPraiseDialogStartActivityConfig mStartActivityConfig;
    private IPraiseDialogUIConfig mUiConfig;

    /* loaded from: classes4.dex */
    private static class Singleton {
        private static PraiseDialogCfgManager sInstance = new PraiseDialogCfgManager();

        private Singleton() {
        }
    }

    private PraiseDialogCfgManager() {
        this.mMarketOrder = "";
        this.mFeedBackUrl = "";
        this.mGuideStyle1MarketListStr = "";
        this.mGuideStyle2MarketListStr = "";
        this.mGuideStyle3MarketListStr = "";
        this.mDebugMode = false;
    }

    public static PraiseDialogCfgManager getInstance() {
        return Singleton.sInstance;
    }

    public void init(IPraiseDialogConfig iPraiseDialogConfig) {
        if (iPraiseDialogConfig != null) {
            this.mNetworkConfig = iPraiseDialogConfig.getNetworkConfig();
            this.mAppConfig = iPraiseDialogConfig.getAppConfig();
            this.mUiConfig = iPraiseDialogConfig.getUiConfig();
            this.mLocalConfig = iPraiseDialogConfig.getLocalConfig();
            this.mAsyncThreadConfig = iPraiseDialogConfig.getAsyncThreadConfig();
            this.mStartActivityConfig = iPraiseDialogConfig.getStartActivityConfig();
        }
    }

    public String executePost(int i, String str, Map<String, String> map) throws Exception {
        IPraiseDialogNetworkConfig iPraiseDialogNetworkConfig = this.mNetworkConfig;
        if (iPraiseDialogNetworkConfig != null) {
            return iPraiseDialogNetworkConfig.executePost(i, str, map);
        }
        return null;
    }

    public void executeRunnable(Runnable runnable) {
        IPraiseDialogAsyncThreadConfig iPraiseDialogAsyncThreadConfig = this.mAsyncThreadConfig;
        if (iPraiseDialogAsyncThreadConfig != null) {
            iPraiseDialogAsyncThreadConfig.execute(runnable);
        } else {
            ThreadPlus.submitRunnable(runnable);
        }
    }

    public boolean isMatchLocalCondition() {
        IPraiseDialogLocalConditionConfig iPraiseDialogLocalConditionConfig = this.mLocalConfig;
        if (iPraiseDialogLocalConditionConfig != null) {
            return iPraiseDialogLocalConditionConfig.isMatchLocalCondition();
        }
        return false;
    }

    public boolean isCurDemo() {
        IPraiseDialogLocalConditionConfig iPraiseDialogLocalConditionConfig = this.mLocalConfig;
        if (iPraiseDialogLocalConditionConfig != null) {
            return iPraiseDialogLocalConditionConfig.isCurDemo();
        }
        return false;
    }

    public String getHost() {
        IPraiseDialogAppConfig iPraiseDialogAppConfig = this.mAppConfig;
        if (iPraiseDialogAppConfig != null) {
            return iPraiseDialogAppConfig.getHost();
        }
        return null;
    }

    public String getHuaWeiAppId() {
        IPraiseDialogAppConfig iPraiseDialogAppConfig = this.mAppConfig;
        if (iPraiseDialogAppConfig != null) {
            return iPraiseDialogAppConfig.getHuaWeiAppId();
        }
        return null;
    }

    public String getAppId() {
        IPraiseDialogAppConfig iPraiseDialogAppConfig = this.mAppConfig;
        if (iPraiseDialogAppConfig != null) {
            return iPraiseDialogAppConfig.getAppId();
        }
        return null;
    }

    public String getPackageName() {
        IPraiseDialogAppConfig iPraiseDialogAppConfig = this.mAppConfig;
        if (iPraiseDialogAppConfig != null) {
            return iPraiseDialogAppConfig.getPackageName();
        }
        return null;
    }

    public String getDeviceId() {
        IPraiseDialogAppConfig iPraiseDialogAppConfig = this.mAppConfig;
        if (iPraiseDialogAppConfig != null) {
            return iPraiseDialogAppConfig.getDeviceId();
        }
        return null;
    }

    public void onEvent(String str, JSONObject jSONObject) {
        IPraiseDialogAppConfig iPraiseDialogAppConfig = this.mAppConfig;
        if (iPraiseDialogAppConfig != null) {
            iPraiseDialogAppConfig.onEvent(str, jSONObject);
        }
    }

    public void goToFeedback(Context context) {
        IPraiseDialogAppConfig iPraiseDialogAppConfig = this.mAppConfig;
        if (iPraiseDialogAppConfig != null) {
            iPraiseDialogAppConfig.goToFeedback(context, this.mFeedBackUrl);
        }
    }

    public boolean handleNoAppMarket() {
        IPraiseDialogAppConfig iPraiseDialogAppConfig = this.mAppConfig;
        if (iPraiseDialogAppConfig != null) {
            return iPraiseDialogAppConfig.handleNoAppMarket();
        }
        return false;
    }

    public Activity getTopActivity() {
        IPraiseDialogAppConfig iPraiseDialogAppConfig = this.mAppConfig;
        if (iPraiseDialogAppConfig != null) {
            return iPraiseDialogAppConfig.getTopActivity();
        }
        return null;
    }

    public void setAppData(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        Log.d(TAG, "appData is " + jSONObject);
        this.mMarketOrder = jSONObject.optString("app_market_order", "");
        this.mDialogEnable = jSONObject.optInt("market_feedback_dialog_enable", 0) > 0;
        this.mFeedBackUrl = jSONObject.optString("market_feedback_url", "");
        this.mGuideStyle1MarketListStr = jSONObject.optString("guide_style_1_market_list", "");
        this.mGuideStyle2MarketListStr = jSONObject.optString("guide_style_2_market_list", "");
        this.mGuideStyle3MarketListStr = jSONObject.optString("guide_style_3_market_list", "");
    }

    public void setIPraiseDialogActionCallback(IPraiseDialogActionCallback iPraiseDialogActionCallback) {
        this.mIPraiseDialogActionCallback = iPraiseDialogActionCallback;
    }

    public IPraiseDialogActionCallback getIPraiseDialogActionCallback() {
        return this.mIPraiseDialogActionCallback;
    }

    public void setDebugMode(boolean z) {
        this.mDebugMode = z;
    }

    public boolean isDebugMode() {
        return this.mDebugMode;
    }

    public boolean getDialogEnable() {
        return this.mDialogEnable;
    }

    public String getMarketOrder() {
        return this.mMarketOrder;
    }

    public boolean needShowDefaultDialog() {
        IPraiseDialogAppConfig iPraiseDialogAppConfig = this.mAppConfig;
        if (iPraiseDialogAppConfig != null) {
            return iPraiseDialogAppConfig.needShowDefaultDialog();
        }
        return false;
    }

    public ArrayList<String> getGuideStyle1List() {
        if (TextUtils.isEmpty(this.mGuideStyle1MarketListStr)) {
            Log.d(TAG, "initMarketOrder is called, but mMarketOrder is empty");
            return null;
        }
        String[] split = this.mGuideStyle1MarketListStr.split("\\|");
        if (split.length <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, split);
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public ArrayList<String> getGuideStyle2List() {
        if (TextUtils.isEmpty(this.mGuideStyle2MarketListStr)) {
            Log.d(TAG, "initMarketOrder is called, but mMarketOrder is empty");
            return null;
        }
        String[] split = this.mGuideStyle2MarketListStr.split("\\|");
        if (split.length <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, split);
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public ArrayList<String> getGuideStyle3List() {
        if (TextUtils.isEmpty(this.mGuideStyle3MarketListStr)) {
            Log.d(TAG, "initMarketOrder is called, but mMarketOrder is empty");
            return null;
        }
        String[] split = this.mGuideStyle3MarketListStr.split("\\|");
        if (split.length <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, split);
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public String getTitleStr() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig == null || TextUtils.isEmpty(iPraiseDialogUIConfig.getMainTitleString())) {
            return null;
        }
        return this.mUiConfig.getMainTitleString();
    }

    public String getTitleStrColor() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig == null || TextUtils.isEmpty(iPraiseDialogUIConfig.getMainTitleStrColor())) {
            return null;
        }
        return this.mUiConfig.getMainTitleStrColor();
    }

    public int getTitleStrSize() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig != null) {
            return iPraiseDialogUIConfig.getMainTitleStrSize();
        }
        return -1;
    }

    public String getSecondTitleStr() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig == null || TextUtils.isEmpty(iPraiseDialogUIConfig.getSecondTitleString())) {
            return null;
        }
        return this.mUiConfig.getSecondTitleString();
    }

    public String getSecondTitleStrColor() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig == null || TextUtils.isEmpty(iPraiseDialogUIConfig.getSecondTitleStrColor())) {
            return null;
        }
        return this.mUiConfig.getSecondTitleStrColor();
    }

    public int getSecondTitleStrSize() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig != null) {
            return iPraiseDialogUIConfig.getSecondTitleStrSize();
        }
        return -1;
    }

    public String getNegativeBtnStr() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig == null || TextUtils.isEmpty(iPraiseDialogUIConfig.getNegativeBtnText())) {
            return null;
        }
        return this.mUiConfig.getNegativeBtnText();
    }

    public String getNegativeBtnColor() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig == null || TextUtils.isEmpty(iPraiseDialogUIConfig.getNegativeBtnTextColor())) {
            return null;
        }
        return this.mUiConfig.getNegativeBtnTextColor();
    }

    public int getNegativeBtnSize() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig != null) {
            return iPraiseDialogUIConfig.getNegativeBtnTextSize();
        }
        return -1;
    }

    public String getPositiveBtnStr() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig == null || TextUtils.isEmpty(iPraiseDialogUIConfig.getPositiveBtnText())) {
            return null;
        }
        return this.mUiConfig.getPositiveBtnText();
    }

    public String getPositiveBtnColor() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig == null || TextUtils.isEmpty(iPraiseDialogUIConfig.getPositiveBtnTextColor())) {
            return null;
        }
        return this.mUiConfig.getPositiveBtnTextColor();
    }

    public int getPositiveBtnSize() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig != null) {
            return iPraiseDialogUIConfig.getPositiveBtnTextSize();
        }
        return -1;
    }

    public int getMiddleImgResId() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig != null) {
            return iPraiseDialogUIConfig.getMiddleImageResId();
        }
        return -1;
    }

    public int getMiddleImgResIdStyle2() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig != null) {
            return iPraiseDialogUIConfig.getMiddleImageStyle2ResId();
        }
        return -1;
    }

    public int getMiddleImgResIdStyle3() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig != null) {
            return iPraiseDialogUIConfig.getMiddleImageStyle3ResId();
        }
        return -1;
    }

    public int getBackgroundResId() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig != null) {
            return iPraiseDialogUIConfig.getMainBackgroundResId();
        }
        return -1;
    }

    public int getPositiveBtnResId() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig != null) {
            return iPraiseDialogUIConfig.getPositiveBtnResId();
        }
        return -1;
    }

    public int getNegativeBtnResId() {
        IPraiseDialogUIConfig iPraiseDialogUIConfig = this.mUiConfig;
        if (iPraiseDialogUIConfig != null) {
            return iPraiseDialogUIConfig.getNegativeBtnResId();
        }
        return -1;
    }

    public void startActivity(Context context, Intent intent) {
        IPraiseDialogStartActivityConfig iPraiseDialogStartActivityConfig = this.mStartActivityConfig;
        if (iPraiseDialogStartActivityConfig != null) {
            iPraiseDialogStartActivityConfig.startActivity(context, intent);
        } else {
            context.startActivity(intent);
        }
    }

    public void startActivityForResult(Activity activity, Intent intent) {
        IPraiseDialogStartActivityConfig iPraiseDialogStartActivityConfig = this.mStartActivityConfig;
        if (iPraiseDialogStartActivityConfig != null) {
            iPraiseDialogStartActivityConfig.startActivityForResult(activity, intent, 100);
        } else {
            activity.startActivityForResult(intent, 100);
        }
    }
}
