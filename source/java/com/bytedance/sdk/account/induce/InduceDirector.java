package com.bytedance.sdk.account.induce;

import android.text.TextUtils;
import com.bytedance.sdk.account.BDAccountExtraApiImpl;
import com.bytedance.sdk.account.CommonCallBack;
import com.bytedance.sdk.account.api.BDAccountEvent;
import com.bytedance.sdk.account.api.BDAccountEventListener;
import com.bytedance.sdk.account.api.IBDAccount;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.impl.BDAccountDelegateInner;
import com.ss.android.LogHelper;
import com.ss.android.account.TTAccountInit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class InduceDirector implements BDAccountEventListener {
    private static final String TAG = "InduceDirector";
    private static volatile InduceDirector sDirector;
    private final IBDAccount mBdAccountInstance;
    private final FrequencyController mFrequencyController;
    private final InduceRecorder mInduceRecorder;
    private boolean mIsUpdatingStrategy;
    private final TriggerCounter mTriggerCounter;

    private InduceDirector() {
        InduceRecorder induceRecorder = new InduceRecorder();
        this.mInduceRecorder = induceRecorder;
        this.mTriggerCounter = new TriggerCounter(induceRecorder);
        this.mFrequencyController = new FrequencyController(induceRecorder);
        IBDAccount instance = BDAccountDelegateInner.instance(TTAccountInit.getConfig().getApplicationContext());
        this.mBdAccountInstance = instance;
        instance.addListener(this);
    }

    public static InduceDirector getInstance() {
        if (sDirector == null) {
            synchronized (InduceDirector.class) {
                if (sDirector == null) {
                    sDirector = new InduceDirector();
                }
            }
        }
        return sDirector;
    }

    public void onShowLogin(String str) {
        if (this.mBdAccountInstance.isLogin()) {
            return;
        }
        this.mFrequencyController.markShowLogin(str);
    }

    public void onShowLogin(InduceResult induceResult) {
        if (this.mBdAccountInstance.isLogin() || !induceResult.showLogin || induceResult.scenes == null || induceResult.scenes.isEmpty()) {
            return;
        }
        Iterator<String> it = induceResult.scenes.iterator();
        while (it.hasNext()) {
            this.mFrequencyController.markShowLogin(it.next());
        }
    }

    public InduceResult shouldShowLogin(String str, String str2) {
        return shouldShowLogin(str, SceneInfo.createProgress(str2, 1L));
    }

    public InduceResult shouldShowLogin(String str, SceneInfo... sceneInfoArr) {
        InduceResult induceResult = new InduceResult();
        if (this.mBdAccountInstance.isLogin()) {
            induceResult.notShowLoginReason = "already login";
            return induceResult;
        }
        if (TextUtils.isEmpty(str) || sceneInfoArr == null) {
            induceResult.notShowLoginReason = "params invalid";
            return induceResult;
        }
        JSONObject guideLoginStrategy = this.mInduceRecorder.getGuideLoginStrategy();
        if (guideLoginStrategy == null) {
            updateInduceStrategy(null);
            induceResult.notShowLoginReason = "do not have induce strategy";
            return induceResult;
        }
        if (isStrategyExpired(guideLoginStrategy)) {
            updateInduceStrategy(null);
        }
        JSONObject optJSONObject = guideLoginStrategy.optJSONObject("login_methods");
        if (optJSONObject == null) {
            induceResult.notShowLoginReason = "induce strategy do not have \"login_methods\" packet";
            return induceResult;
        }
        JSONObject optJSONObject2 = optJSONObject.optJSONObject(str);
        if (optJSONObject2 == null) {
            induceResult.notShowLoginReason = "do not have induce strategy for loginWay: " + str;
            return induceResult;
        }
        for (SceneInfo sceneInfo : sceneInfoArr) {
            this.mTriggerCounter.increaseProgress(optJSONObject2, sceneInfo.scene, sceneInfo.progress, sceneInfo.percent);
            if (induceResult.scenes == null) {
                induceResult.scenes = new ArrayList<>();
            }
            induceResult.scenes.add(sceneInfo.scene);
            InduceResult checkConfigAndMakeDecision = checkConfigAndMakeDecision(optJSONObject2, sceneInfo.scene, sceneInfo.progress);
            if (checkConfigAndMakeDecision.showLogin) {
                induceResult.showLogin = true;
                if (induceResult.extraInfo == null) {
                    induceResult.extraInfo = checkConfigAndMakeDecision.extraInfo;
                }
                if (induceResult.sceneStrategy == null) {
                    induceResult.sceneStrategy = checkConfigAndMakeDecision.sceneStrategy;
                }
            } else if (!induceResult.showLogin) {
                induceResult.notShowLoginReason = checkConfigAndMakeDecision.notShowLoginReason;
            }
        }
        return induceResult;
    }

    private InduceResult checkConfigAndMakeDecision(JSONObject jSONObject, String str, long j) {
        InduceResult induceResult = new InduceResult();
        JSONObject optJSONObject = jSONObject.optJSONObject("frequency_control");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("range_type");
            int optInt = optJSONObject.optInt("range_interval");
            int optInt2 = optJSONObject.optInt("max_count", -1);
            int optInt3 = optJSONObject.optInt("max_time_in_range", -1);
            if (optInt3 <= 0) {
                optInt3 = 1;
            }
            if (!this.mFrequencyController.satisfyFrequencyTypeInRange(optString, optInt, optInt3, optInt2)) {
                induceResult.notShowLoginReason = "do not satisfy all scene frequency control, rangeType: " + optString + ", rangeInterval: " + optInt + "maxCount:" + optInt2 + ", lastShowLoginTimeAllScene: " + this.mFrequencyController.lastShowLoginTimeAllScene();
                return induceResult;
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("scenes");
        if (optJSONObject2 == null) {
            induceResult.notShowLoginReason = "induce strategy do not have \"scenes\" packet";
            return induceResult;
        }
        JSONObject optJSONObject3 = optJSONObject2.optJSONObject(str);
        if (optJSONObject3 == null) {
            induceResult.notShowLoginReason = "do not have induce strategy for scene: " + str;
            return induceResult;
        }
        JSONObject optJSONObject4 = optJSONObject3.optJSONObject("frequency_control");
        if (optJSONObject4 != null) {
            String optString2 = optJSONObject4.optString("range_type");
            int optInt4 = optJSONObject4.optInt("range_interval");
            int optInt5 = optJSONObject4.optInt("max_count", -1);
            int optInt6 = optJSONObject4.optInt("max_time_in_range", -1);
            if (!this.mFrequencyController.satisfyFrequencyTypeInRangeForScene(str, optString2, optInt4, optInt6 <= 0 ? 1 : optInt6, optInt5)) {
                induceResult.notShowLoginReason = "do not satisfy frequency control for scene: " + str + ", rangeType: " + optString2 + ", rangeInterval: " + optInt4 + "maxCount:" + optInt5 + ", lastShowLoginTimeByScene: " + this.mFrequencyController.lastShowLoginTimeByScene(str);
                return induceResult;
            }
        }
        JSONObject optJSONObject5 = optJSONObject3.optJSONObject("trigger");
        if (optJSONObject5 == null) {
            induceResult.notShowLoginReason = "induce strategy do not have \"trigger\" packet";
            return induceResult;
        }
        int optInt7 = optJSONObject5.optInt("trigger_type", -1);
        int optInt8 = optJSONObject5.optInt("counts");
        if (this.mTriggerCounter.satisfyTriggerCondition(str, optInt7, optInt8, j)) {
            induceResult.showLogin = true;
            induceResult.sceneStrategy = optJSONObject3;
            JSONObject optJSONObject6 = jSONObject.optJSONObject("extra");
            JSONObject optJSONObject7 = optJSONObject3.optJSONObject("extra");
            if (optJSONObject6 == null) {
                induceResult.extraInfo = optJSONObject7;
            } else {
                if (optJSONObject7 != null) {
                    try {
                        if (optJSONObject7.length() > 0) {
                            Iterator<String> keys = optJSONObject7.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                optJSONObject6.put(next, optJSONObject7.opt(next));
                            }
                        }
                    } catch (Exception e) {
                        LogHelper.e(TAG, "checkConfigAndMakeDecision", e);
                    }
                }
                induceResult.extraInfo = optJSONObject6;
            }
        } else {
            induceResult.notShowLoginReason = "do not satisfy trigger config, triggerType: " + optInt7 + ", count: " + optInt8 + ", current count is " + this.mTriggerCounter.currentSceneProgress(str);
        }
        return induceResult;
    }

    private boolean isStrategyExpired(JSONObject jSONObject) {
        return jSONObject == null || ((long) jSONObject.optInt("expire_time", 0)) < System.currentTimeMillis() / 1000;
    }

    public void tryUpdateInduceStrategy(Map<String, String> map) {
        JSONObject guideLoginStrategy = this.mInduceRecorder.getGuideLoginStrategy();
        if (guideLoginStrategy == null || isStrategyExpired(guideLoginStrategy)) {
            updateInduceStrategy(map);
        }
    }

    private void updateInduceStrategy(Map<String, String> map) {
        if (this.mIsUpdatingStrategy) {
            return;
        }
        BDAccountExtraApiImpl.instance().getLoginGuideStrategy(map, new CommonCallBack<BaseApiResponse>() { // from class: com.bytedance.sdk.account.induce.InduceDirector.1
            @Override // com.bytedance.sdk.account.CommonCallBack
            public void onSuccess(BaseApiResponse baseApiResponse) {
                InduceDirector.this.mIsUpdatingStrategy = false;
                if (baseApiResponse == null || baseApiResponse.result == null) {
                    return;
                }
                InduceDirector.this.mInduceRecorder.setGuideLoginStrategy(baseApiResponse.result.optJSONObject("data"));
            }

            @Override // com.bytedance.sdk.account.CommonCallBack
            public void onError(BaseApiResponse baseApiResponse, int i) {
                InduceDirector.this.mIsUpdatingStrategy = false;
            }
        });
    }

    @Override // com.bytedance.sdk.account.api.BDAccountEventListener
    public void onReceiveAccountEvent(BDAccountEvent bDAccountEvent) {
        if (bDAccountEvent.type == 0 && this.mBdAccountInstance.isLogin()) {
            this.mTriggerCounter.reset();
            this.mFrequencyController.reset();
        }
    }
}
