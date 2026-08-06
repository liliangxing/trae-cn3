package com.bytedance.sdk.account.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.collection.WeakContainer;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.sdk.account.api.AccountDef;
import com.bytedance.sdk.account.api.BDAccountEvent;
import com.bytedance.sdk.account.api.BDAccountEventListener;
import com.bytedance.sdk.account.api.BDAccountResponseEvent;
import com.bytedance.sdk.account.api.IBDAccount;
import com.bytedance.sdk.account.api.IBDAccountCoreApi;
import com.bytedance.sdk.account.api.call.AbsApiCall;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.account.api.call.LogoutApiResponse;
import com.bytedance.sdk.account.api.call.MobileApiResponse;
import com.bytedance.sdk.account.api.call.ThirdTokenResponse;
import com.bytedance.sdk.account.api.call.UserApiResponse;
import com.bytedance.sdk.account.api.callback.GetAccountInfoCallback;
import com.bytedance.sdk.account.api.callback.UpdateTokenCallback;
import com.bytedance.sdk.account.api.pool.IApiController;
import com.bytedance.sdk.account.api.response.GetAccountInfoResponse;
import com.bytedance.sdk.account.api.response.LoginByTicketResponse;
import com.bytedance.sdk.account.api.response.UpdateTokenResponse;
import com.bytedance.sdk.account.constants.UserInfoThreadConstants;
import com.bytedance.sdk.account.job.UpdateTokenJob;
import com.bytedance.sdk.account.mobile.query.IUserQueryObj;
import com.bytedance.sdk.account.monitor.AccountMonitorUtil;
import com.bytedance.sdk.account.save.SaveService;
import com.bytedance.sdk.account.save.callback.SaveCallback;
import com.bytedance.sdk.account.save.entity.LoginInfo;
import com.bytedance.sdk.account.ticketguard.AccountTicketGuardManager;
import com.bytedance.sdk.account.ticketguard.SecUserIdProcessor;
import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import com.bytedance.sdk.account.utils.IMonitor;
import com.bytedance.sdk.account.utils.Utils;
import com.ss.android.LogHelper;
import com.ss.android.account.BDAccountUserEntity;
import com.ss.android.account.TTAccountInit;
import com.ss.android.account.model2.BDAccountPlatformEntity;
import com.ss.android.token.ITokenService;
import com.ss.android.token.TTTokenManager;
import com.ss.android.token.TTTokenMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class BDAccountManager implements WeakHandler.IHandler, IBDAccount, IDispatchReceiver {
    public static BDAccountPlatformEntity[] ALL = null;
    public static final int DISPATCH_MESSAGE = 100;
    static final BDAccountPlatformEntity EMAIL;

    /* renamed from: FB */
    static final BDAccountPlatformEntity f6FB;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_NONE = 0;
    public static final int GENDER_NOT_SHOW = 3;
    static final BDAccountPlatformEntity GOOGLE;
    static final BDAccountPlatformEntity INSTAGRAM;
    static final BDAccountPlatformEntity KAKAO;
    static final String KEY_AVATAR_URL = "avatar_url";
    private static final String KEY_BG_IMG_URL = "bg_img_url";
    private static final String KEY_CAN_BE_FOUND_BY_PHONE = "can_be_found_by_phone";
    private static final String KEY_CAN_SYNC_SHARE = "can_sync_share";
    static final String KEY_COUNTRY_CODE = "country_code";
    private static final String KEY_DISPLAY_OCR_ENTRANCE = "display_ocr_entrance";
    private static final String KEY_EXPEND_ATTRS = "expend_attrs";
    private static final String KEY_FOLLOWERS_COUNT = "followers_count";
    private static final String KEY_FOLLOWING_COUNT = "following_count";
    static final String KEY_HAS_UPDATE_SEC_UIDS = "has_update_sec_uids";
    private static final String KEY_IS_BLOCKED = "is_blocked";
    private static final String KEY_IS_BLOCKING = "is_blocking";
    private static final String KEY_IS_KIDS_MODE = "is_kids_mode";
    static final String KEY_IS_LOGIN = "is_login";
    static final String KEY_IS_NEW_USER = "is_new_user";
    private static final String KEY_IS_RECOMMEND_ALLOWED = "is_recommend_allowed";
    private static final String KEY_IS_SHARE_SHOW_ICON = "user_privacy_extend";
    private static final String KEY_IS_TOUTIAO = "is_toutiao";
    private static final String KEY_IS_VISITOR_ACCOUNT = "is_visitor_account";
    private static final String KEY_MEDIA_ID = "media_id";
    static final String KEY_MULTI_SID = "multi_sids";
    static final String KEY_ODIN_USER_TYPE = "odin_user_type";
    protected static final String KEY_PGC_AVATAR_URL = "pgc_avatar_url";
    protected static final String KEY_PGC_MEDIAID = "pgc_mediaid";
    protected static final String KEY_PGC_NAME = "pgc_name";
    private static final String KEY_PLATFROM_PREFIX = "_platform_";
    private static final String KEY_RAW_JSON = "raw_json";
    private static final String KEY_RECOMMEND_HINT_MESSAGE = "recommend_hint_message";
    static final String KEY_SCREEN_NAME = "screen_name";
    static final String KEY_SEC_USER_ID = "sec_user_id";
    static final String KEY_SESSION = "session";
    static final String KEY_SESSION_KEY = "session_key";
    static final String KEY_SESSION_SIGN = "session_sign";
    static final String KEY_USER_AREA = "area";
    private static final String KEY_USER_AUTH_INFO = "user_auth_info";
    static final String KEY_USER_BIRTHDAY = "user_birthday";
    static final String KEY_USER_DECORATION = "user_decoration";
    static final String KEY_USER_DESCRIPTION = "user_description";
    static final String KEY_USER_EMAIL = "user_email";
    static final String KEY_USER_GENDER = "user_gender";
    static final String KEY_USER_HASPWD = "user_has_pwd";
    static final String KEY_USER_ID = "user_id";
    static final String KEY_USER_INDUSTRY = "user_industry";
    static final String KEY_USER_MOBILE = "user_mobile";
    static final String KEY_USER_NAME = "user_name";
    private static final String KEY_USER_PRIVACY_EXTEND = "user_privacy_extend_value";
    static final String KEY_USER_VERIFIED = "user_verified";
    static final String KEY_VERIFIED_CONTENT = "verified_content";
    private static final String KEY_VISITORS_COUNT = "visitors_count";
    static final BDAccountPlatformEntity LINE;
    static final BDAccountPlatformEntity MOBILE;
    private static final String PKG_NAME = "com.bytedance.sdk.account";
    static final String SETTING_SP = "com.bytedance.sdk.account_setting";
    private static final String STORE_KEY_SAVED_PLATFORM_APP_ID = "store_key_saved_platform_app_id";
    private static final String TAG = "BDAccountManager";
    static final BDAccountPlatformEntity TIKTOK;
    static final BDAccountPlatformEntity TWITTER;

    /* renamed from: VK */
    static final BDAccountPlatformEntity f7VK;
    private static final List<ApiResponseHandler> apiResponseHandlers;
    private static volatile BDAccountManager sInstance;
    protected IBDAccountCoreApi accountCoreApi;
    private List<String> concerningFields;
    private final BDAccountPlatformEntity[] mAllPlatforms;
    private int mCanFoundByPhone;
    private int mCanSyncShare;
    Context mContext;
    private int mCountryCode;
    private boolean mDataLoaded;
    private JSONObject mExpendAttrs;
    private int mGender;
    private boolean mHasPassword;
    private Set<String> mHashUpdateSecUids;
    private int mIsBlocked;
    private int mIsBlocking;
    private boolean mIsKidsMode;
    private boolean mIsNewUser;
    private boolean mIsRecommendAllowed;
    private boolean mIsToutiao;
    public String mMultiSids;
    private JSONObject mRawJson;
    private int mShareShowIcon;
    IBDAccountUserEntity mUserInfo;
    private int mUserPrivacyExtend;
    private boolean mUserVerified;

    /* renamed from: sp */
    SharedPreferences f8sp;
    private final int MSG_USER_INFO_RETRY = 1000;
    private String mArea = "";
    private String mAvatarUrl = "";
    private String mBgImgUrl = "";
    private String mUserBirthday = "";
    private String mUserDescription = "";
    private String mEmail = "";
    private String mUserIndustry = "";
    public long mMediaId = 0;
    private String mMobile = "";
    private String mUserName = "";
    private String mScreenName = "";
    private String mRecommendHintMessage = "";
    public String mUserAuthInfo = "";
    private String mUserDecoration = "";
    private long mUserId = 0;
    private String mSecUserId = "";
    private int mOdinUserType = 0;
    private String mVerifiedContent = "";
    private String mSessionKey = "";
    private String mSessionSign = "";
    private boolean mIsLogin = false;
    private long mPgcMediaId = 0;
    private String mPgcAvatarUrl = "";
    private String mPgcName = "";
    public int mDisplayOcrEntrance = 0;
    public int mFollowingCount = 0;
    public int mFollowersCount = 0;
    public int mVisitorsCount = 0;
    private boolean mIsVisitorAccount = false;
    protected final WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);
    private WeakContainer<BDAccountEventListener> mAccountListener = new WeakContainer<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface ApiResponseHandler {
        void handle(BaseApiResponse baseApiResponse);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserMobile(String str) {
    }

    static {
        BDAccountPlatformEntity bDAccountPlatformEntity = new BDAccountPlatformEntity("mobile");
        MOBILE = bDAccountPlatformEntity;
        BDAccountPlatformEntity bDAccountPlatformEntity2 = new BDAccountPlatformEntity("email");
        EMAIL = bDAccountPlatformEntity2;
        BDAccountPlatformEntity bDAccountPlatformEntity3 = new BDAccountPlatformEntity("google");
        GOOGLE = bDAccountPlatformEntity3;
        BDAccountPlatformEntity bDAccountPlatformEntity4 = new BDAccountPlatformEntity("facebook");
        f6FB = bDAccountPlatformEntity4;
        BDAccountPlatformEntity bDAccountPlatformEntity5 = new BDAccountPlatformEntity("twitter");
        TWITTER = bDAccountPlatformEntity5;
        BDAccountPlatformEntity bDAccountPlatformEntity6 = new BDAccountPlatformEntity("instagram");
        INSTAGRAM = bDAccountPlatformEntity6;
        BDAccountPlatformEntity bDAccountPlatformEntity7 = new BDAccountPlatformEntity("line");
        LINE = bDAccountPlatformEntity7;
        BDAccountPlatformEntity bDAccountPlatformEntity8 = new BDAccountPlatformEntity("kakaotalk");
        KAKAO = bDAccountPlatformEntity8;
        BDAccountPlatformEntity bDAccountPlatformEntity9 = new BDAccountPlatformEntity("vk");
        f7VK = bDAccountPlatformEntity9;
        BDAccountPlatformEntity bDAccountPlatformEntity10 = new BDAccountPlatformEntity("tiktok");
        TIKTOK = bDAccountPlatformEntity10;
        ALL = new BDAccountPlatformEntity[]{bDAccountPlatformEntity, bDAccountPlatformEntity2, bDAccountPlatformEntity3, bDAccountPlatformEntity4, bDAccountPlatformEntity5, bDAccountPlatformEntity6, bDAccountPlatformEntity7, bDAccountPlatformEntity8, bDAccountPlatformEntity9, bDAccountPlatformEntity10};
        ArrayList arrayList = new ArrayList();
        apiResponseHandlers = arrayList;
        arrayList.add(new UserAPiHandler());
        arrayList.add(new LogoutHandle());
        arrayList.add(new ThirdTokenHandler());
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setConcerningFields(List<String> list) {
        this.concerningFields = list;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void notifyBDAccountEvent(BDAccountEvent bDAccountEvent) {
        synchronized (this.mAccountListener) {
            Iterator it = this.mAccountListener.iterator();
            while (it.hasNext()) {
                BDAccountEventListener bDAccountEventListener = (BDAccountEventListener) it.next();
                if (bDAccountEventListener != null) {
                    bDAccountEventListener.onReceiveAccountEvent(bDAccountEvent);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public BDAccountPlatformEntity getPlatformByName(String str) {
        for (BDAccountPlatformEntity bDAccountPlatformEntity : this.mAllPlatforms) {
            if (bDAccountPlatformEntity != null && StringUtils.equal(bDAccountPlatformEntity.mName, str)) {
                return bDAccountPlatformEntity;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setPlatformMap(HashMap<String, BDAccountPlatformEntity> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        for (BDAccountPlatformEntity bDAccountPlatformEntity : this.mAllPlatforms) {
            bDAccountPlatformEntity.mLogin = false;
            BDAccountPlatformEntity bDAccountPlatformEntity2 = hashMap.get(bDAccountPlatformEntity.mName);
            if (bDAccountPlatformEntity2 == null) {
                bDAccountPlatformEntity.invalidate();
            } else {
                if (!bDAccountPlatformEntity.mLogin) {
                    bDAccountPlatformEntity.mLogin = true;
                }
                bDAccountPlatformEntity.mPlatformId = bDAccountPlatformEntity2.mPlatformId;
                bDAccountPlatformEntity.mExpire = bDAccountPlatformEntity2.mExpire;
                bDAccountPlatformEntity.mExpireIn = bDAccountPlatformEntity2.mExpireIn;
                bDAccountPlatformEntity.mNickname = bDAccountPlatformEntity2.mNickname;
                bDAccountPlatformEntity.mAvatar = bDAccountPlatformEntity2.mAvatar;
                bDAccountPlatformEntity.mPlatformUid = bDAccountPlatformEntity2.mPlatformUid;
                bDAccountPlatformEntity.mUserId = bDAccountPlatformEntity2.mUserId;
                bDAccountPlatformEntity.mModifyTime = bDAccountPlatformEntity2.mModifyTime;
                bDAccountPlatformEntity.mAccessToken = bDAccountPlatformEntity2.mAccessToken;
                bDAccountPlatformEntity.mOpenId = bDAccountPlatformEntity2.mOpenId;
                bDAccountPlatformEntity.mScope = bDAccountPlatformEntity2.mScope;
                bDAccountPlatformEntity.refreshTime = bDAccountPlatformEntity2.refreshTime;
                bDAccountPlatformEntity.refreshAt = bDAccountPlatformEntity2.refreshAt;
                bDAccountPlatformEntity.mExtra = bDAccountPlatformEntity2.mExtra;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePlatformInfo(String str, int i, Bundle bundle) {
        long j;
        long j2;
        if (TextUtils.isEmpty(str) || i == -1 || bundle == null || bundle.isEmpty() || !this.mIsLogin || this.mUserInfo == null) {
            return;
        }
        String valueOf = String.valueOf(i);
        Map<String, BDAccountPlatformEntity> map = this.mUserInfo.thirdPlatform.get(str);
        if (map == null) {
            map = new HashMap<>();
            this.mUserInfo.thirdPlatform.put(str, map);
        }
        BDAccountPlatformEntity bDAccountPlatformEntity = map.get(valueOf);
        if (bDAccountPlatformEntity == null) {
            bDAccountPlatformEntity = new BDAccountPlatformEntity(str);
            bDAccountPlatformEntity.mPlatformId = i;
            bDAccountPlatformEntity.mLogin = true;
            bDAccountPlatformEntity.mUserId = this.mUserId;
            map.put(valueOf, bDAccountPlatformEntity);
        }
        BDAccountPlatformEntity bDAccountPlatformEntity2 = this.mUserInfo.bindMap.get(str);
        if (bDAccountPlatformEntity2 == null) {
            this.mUserInfo.bindMap.put(str, bDAccountPlatformEntity);
            bDAccountPlatformEntity2 = bDAccountPlatformEntity;
        }
        if (bundle.containsKey("access_token")) {
            String string = bundle.getString("access_token", null);
            bDAccountPlatformEntity2.mAccessToken = string;
            bDAccountPlatformEntity.mAccessToken = string;
        }
        if (bundle.containsKey("expires_in")) {
            j = bundle.getLong("expires_in", 0L);
            long currentTimeMillis = j != 0 ? System.currentTimeMillis() + (j * 1000) : 0L;
            bDAccountPlatformEntity2.mExpireIn = j;
            bDAccountPlatformEntity2.mExpire = currentTimeMillis;
            bDAccountPlatformEntity.mExpireIn = j;
            bDAccountPlatformEntity.mExpire = currentTimeMillis;
        } else {
            j = 0;
        }
        if (bundle.containsKey("open_id")) {
            String string2 = bundle.getString("open_id", null);
            bDAccountPlatformEntity2.mOpenId = string2;
            bDAccountPlatformEntity.mOpenId = string2;
        }
        if (bundle.containsKey("scopes")) {
            String string3 = bundle.getString("scopes", null);
            bDAccountPlatformEntity2.mScope = string3;
            bDAccountPlatformEntity.mScope = string3;
        }
        if (bundle.containsKey("extra")) {
            String string4 = bundle.getString("extra", null);
            bDAccountPlatformEntity2.mExtra = string4;
            bDAccountPlatformEntity.mExtra = string4;
        }
        if (bundle.containsKey("refresh_time")) {
            long j3 = bundle.getLong("refresh_time", 0L);
            if (j > j3) {
                j2 = bDAccountPlatformEntity.mExpire - (1000 * j3);
            } else {
                j2 = bDAccountPlatformEntity.mExpire;
            }
            bDAccountPlatformEntity2.refreshTime = j3;
            bDAccountPlatformEntity2.refreshAt = j2;
            bDAccountPlatformEntity.refreshTime = j3;
            bDAccountPlatformEntity.refreshAt = j2;
        }
        setPlatformMap((HashMap) this.mUserInfo.bindMap);
        savePlatform(this.f8sp.edit());
        saveThirdPlatform();
        logThirdInfo("updatePlatformInfo");
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void clearPlatformInfo(final String str, final int i, final boolean z) {
        this.mHandler.post(new Runnable() { // from class: com.bytedance.sdk.account.impl.BDAccountManager.1
            @Override // java.lang.Runnable
            public void run() {
                BDAccountManager.this.clearPlatformInfoInner(str, i, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPlatformInfoInner(String str, int i, boolean z) {
        if (TextUtils.isEmpty(str) || i == -1 || !this.mIsLogin || this.mRawJson == null || this.mUserInfo == null) {
            return;
        }
        if (z) {
            BDAccountPlatformEntity bDAccountPlatformEntity = new BDAccountPlatformEntity(str);
            bDAccountPlatformEntity.mPlatformId = i;
            try {
                JSONArray optJSONArray = this.mRawJson.optJSONObject("data").optJSONArray("connects");
                int i2 = 0;
                while (true) {
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                    if (TextUtils.equals(jSONObject.optString("platform"), str) && jSONObject.optInt("platform_app_id") == i) {
                        this.mRawJson.optJSONObject("data").put("connects", Utils.jsonArrayRemoveAtIndex(optJSONArray, i2));
                        this.mUserInfo.updateRawJson(this.mRawJson);
                        break;
                    }
                    i2++;
                }
                this.mUserInfo.getBindMap().put(str, bDAccountPlatformEntity);
                Map<String, BDAccountPlatformEntity> map = this.mUserInfo.getThirdPlatform().get(str);
                if (map != null) {
                    map.put(String.valueOf(i), bDAccountPlatformEntity);
                }
                SharedPreferences.Editor edit = this.f8sp.edit();
                saveJson(edit);
                savePlatform(edit);
                saveThirdPlatform();
                logThirdInfo("clearPlatformInfoInner");
                return;
            } catch (Exception unused) {
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("access_token", "");
        bundle.putString("open_id", "");
        bundle.putString("scopes", "");
        bundle.putLong("expires_in", 0L);
        bundle.putLong("refresh_time", 0L);
        updatePlatformInfo(str, i, bundle);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getSessionKey() {
        return this.mSessionKey;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setSessionKey(String str) {
        this.mSessionKey = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void addListener(BDAccountEventListener bDAccountEventListener) {
        synchronized (this.mAccountListener) {
            this.mAccountListener.add(bDAccountEventListener);
        }
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void removeListener(BDAccountEventListener bDAccountEventListener) {
        synchronized (this.mAccountListener) {
            this.mAccountListener.remove(bDAccountEventListener);
        }
    }

    private BDAccountManager(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.f8sp = applicationContext.getSharedPreferences(SETTING_SP, 0);
        this.mDataLoaded = false;
        this.mAllPlatforms = ALL;
        try {
            loadData();
        } catch (Exception e) {
            LogHelper.e(TAG, "loadData fail", e);
        }
        this.accountCoreApi = BDAccountCoreApiImpl.instance(this.mContext);
        AccountTicketGuardManager.INSTANCE.register(new SecUserIdProcessor());
    }

    private void handleList(BaseApiResponse baseApiResponse) {
        Iterator<ApiResponseHandler> it = apiResponseHandlers.iterator();
        while (it.hasNext()) {
            it.next().handle(baseApiResponse);
        }
    }

    private void invokeCall(ResponseCallable responseCallable) {
        if (responseCallable.apiCall != null) {
            AbsApiCall absApiCall = responseCallable.apiCall;
            absApiCall.dispatchOnResponse(responseCallable.response);
            IApiController iApiController = absApiCall.mJobController;
            if (iApiController != null) {
                iApiController.releaseRef();
            }
        }
    }

    @Override // com.bytedance.sdk.account.impl.IDispatchReceiver
    public void handleDispatch(ResponseCallable responseCallable) {
        if (responseCallable.response != 0) {
            handleList(responseCallable.response);
            invokeCall(responseCallable);
        }
    }

    public void handleMsg(Message message) {
        if (message.what == 100 && (message.obj instanceof ResponseCallable)) {
            handleDispatch((ResponseCallable) message.obj);
        }
        if (message.what == 1000) {
            this.mHandler.removeMessages(1000);
            tryUpdateUserInfo(AccountDef.AccountInfoScene.POLLING);
        }
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void tryUpdateUserInfo(String str) {
        if (!isLogin()) {
            sendQueryUserInfoMsg();
            return;
        }
        IBDAccountCoreApi iBDAccountCoreApi = this.accountCoreApi;
        if (iBDAccountCoreApi != null) {
            iBDAccountCoreApi.getNewAccountInfo(str, new GetAccountInfoCallback() { // from class: com.bytedance.sdk.account.impl.BDAccountManager.2
                @Override // com.bytedance.sdk.account.CommonCallBack
                public void onSuccess(GetAccountInfoResponse getAccountInfoResponse) {
                    BDAccountManager.this.sendQueryUserInfoMsg();
                }

                @Override // com.bytedance.sdk.account.CommonCallBack
                public void onError(GetAccountInfoResponse getAccountInfoResponse, int i) {
                    BDAccountManager.this.sendQueryUserInfoMsg();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void stopUpdateUserInfo() {
        WeakHandler weakHandler = this.mHandler;
        if (weakHandler != null) {
            weakHandler.removeMessages(1000);
        }
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void updateMultiSid(String str) {
        this.mMultiSids = str;
        this.f8sp.edit().putString(KEY_MULTI_SID, str).apply();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getMultiSid() {
        return this.mMultiSids;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void clearMultiSid() {
        this.mMultiSids = null;
        this.f8sp.edit().putString(KEY_MULTI_SID, "").apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendQueryUserInfoMsg() {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(1000, TTAccountInit.getExtraConfig() != null ? TTAccountInit.getExtraConfig().getUpdateInfoInterval() : 600000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Handler getDispatchHandler() {
        return this.mHandler;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void invalidateSession(boolean z) {
        if (this.mIsLogin) {
            this.mIsNewUser = false;
            this.mIsLogin = false;
            this.mUserId = 0L;
            this.mOdinUserType = 0;
            this.mSessionKey = "";
            this.mSessionSign = "";
            this.mSecUserId = "";
            setAppLogInfo(0L, "");
            this.mUserName = "";
            this.mGender = 0;
            this.mScreenName = "";
            this.mVerifiedContent = "";
            this.mUserDescription = "";
            this.mArea = "";
            this.mUserIndustry = "";
            this.mIsBlocked = 0;
            this.mIsBlocking = 0;
            this.mUserDecoration = "";
            this.mUserBirthday = "";
            this.mUserVerified = false;
            this.mIsRecommendAllowed = false;
            this.mIsToutiao = false;
            this.mCountryCode = 0;
            this.mFollowingCount = 0;
            this.mFollowersCount = 0;
            this.mVisitorsCount = 0;
            this.mHasPassword = false;
            this.mMediaId = 0L;
            this.mBgImgUrl = "";
            this.mEmail = "";
            this.mMobile = "";
            this.mDisplayOcrEntrance = 0;
            this.mPgcAvatarUrl = "";
            this.mPgcMediaId = 0L;
            this.mPgcName = "";
            this.mUserAuthInfo = "";
            this.mIsVisitorAccount = false;
            for (BDAccountPlatformEntity bDAccountPlatformEntity : this.mAllPlatforms) {
                bDAccountPlatformEntity.invalidate();
            }
            Iterator<Map<String, BDAccountPlatformEntity>> it = this.mUserInfo.thirdPlatform.values().iterator();
            while (it.hasNext()) {
                Iterator<BDAccountPlatformEntity> it2 = it.next().values().iterator();
                while (it2.hasNext()) {
                    it2.next().invalidate();
                }
            }
            saveData();
        }
        if (z) {
            notifyUserSessionExpired();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BDAccountManager instance(Context context) {
        if (sInstance == null) {
            synchronized (BDAccountManager.class) {
                if (sInstance == null) {
                    sInstance = new BDAccountManager(context);
                }
            }
        }
        if (sInstance.mContext == null && context.getApplicationContext() != null) {
            sInstance.mContext = context.getApplicationContext();
        }
        return sInstance;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void onUserInfoRefreshed(IBDAccountUserEntity iBDAccountUserEntity, boolean z) {
        boolean z2;
        boolean z3;
        LoginInfo infoCacheLogin;
        if (iBDAccountUserEntity == null) {
            return;
        }
        long userId = iBDAccountUserEntity.getUserId();
        int odinUserType = iBDAccountUserEntity.getOdinUserType();
        boolean z4 = false;
        boolean z5 = true;
        if (odinUserType == 0 || odinUserType == this.mOdinUserType) {
            z2 = false;
        } else {
            this.mOdinUserType = odinUserType;
            z2 = true;
        }
        if (userId <= 0) {
            if (this.mIsLogin) {
                this.mIsNewUser = false;
                this.mIsLogin = false;
                this.mUserId = 0L;
                this.mSecUserId = "";
                this.mOdinUserType = 0;
                this.mUserName = "";
                this.mGender = 0;
                this.mScreenName = "";
                this.mVerifiedContent = "";
                this.mAvatarUrl = "";
                this.mUserBirthday = "";
                this.mArea = "";
                this.mUserIndustry = "";
                this.mUserDecoration = "";
                this.mUserDescription = "";
                this.mUserVerified = false;
                this.mIsRecommendAllowed = false;
                this.mSessionKey = "";
                this.mFollowingCount = 0;
                this.mFollowersCount = 0;
                this.mVisitorsCount = 0;
                this.mIsBlocked = 0;
                this.mIsBlocking = 0;
                this.mIsToutiao = false;
                this.mHasPassword = false;
                this.mMediaId = 0L;
                this.mBgImgUrl = "";
                this.mDisplayOcrEntrance = 0;
                this.mPgcAvatarUrl = "";
                this.mPgcMediaId = 0L;
                this.mPgcName = "";
                this.mUserAuthInfo = "";
                this.mIsVisitorAccount = false;
                this.mRawJson = null;
                this.mExpendAttrs = null;
                this.mUserInfo = null;
                for (BDAccountPlatformEntity bDAccountPlatformEntity : this.mAllPlatforms) {
                    bDAccountPlatformEntity.invalidate();
                }
            } else {
                z5 = z2;
            }
            z3 = false;
        } else {
            this.mUserInfo = iBDAccountUserEntity;
            if (!this.mIsLogin) {
                this.mIsLogin = true;
                Utils.flushCookie();
                z2 = true;
            }
            if (iBDAccountUserEntity.isNewUser) {
                this.mIsNewUser = true;
            }
            if (this.mUserId != userId) {
                this.mUserId = userId;
                z2 = true;
                z4 = true;
            }
            if (!StringUtils.equal(this.mSecUserId, iBDAccountUserEntity.secUserId)) {
                this.mSecUserId = iBDAccountUserEntity.secUserId;
                SaveService.updateSecUid(this.mContext, iBDAccountUserEntity.getUserId() + "", iBDAccountUserEntity.getSecUid(), null);
                z2 = true;
            }
            if (!StringUtils.equal(this.mSessionKey, iBDAccountUserEntity.getSessionKey())) {
                this.mSessionKey = iBDAccountUserEntity.getSessionKey();
                z2 = true;
                z4 = true;
            }
            if (!StringUtils.equal(this.mMobile, iBDAccountUserEntity.getMobile())) {
                this.mMobile = iBDAccountUserEntity.getMobile();
                z2 = true;
            }
            if (!StringUtils.equal(this.mEmail, iBDAccountUserEntity.getEmail())) {
                this.mEmail = iBDAccountUserEntity.getEmail();
                z2 = true;
            }
            if (this.mHasPassword != iBDAccountUserEntity.hasPassword) {
                this.mHasPassword = iBDAccountUserEntity.hasPassword;
                z2 = true;
            }
            if (this.mCountryCode != iBDAccountUserEntity.countryCode) {
                this.mCountryCode = iBDAccountUserEntity.countryCode;
                z2 = true;
            }
            if (this.mIsVisitorAccount != iBDAccountUserEntity.isVisitorAccount) {
                this.mIsVisitorAccount = iBDAccountUserEntity.isVisitorAccount;
                z2 = true;
            }
            if (this.mIsKidsMode != iBDAccountUserEntity.isKidsMode) {
                this.mIsKidsMode = iBDAccountUserEntity.isKidsMode;
                z2 = true;
            }
            if (onUserRefreshPlatformChanged(iBDAccountUserEntity)) {
                z2 = true;
            }
            if (this.mRawJson != null && iBDAccountUserEntity.getRawData() != null) {
                JSONObject optJSONObject = this.mRawJson.optJSONObject("data");
                JSONObject rawData = iBDAccountUserEntity.getRawData();
                List<String> list = this.concerningFields;
                if (list != null && optJSONObject != null && rawData != null) {
                    Iterator<String> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        String next = it.next();
                        if (!Utils.equals(optJSONObject.opt(next), rawData.opt(next))) {
                            z2 = true;
                            break;
                        }
                    }
                }
            }
            this.mRawJson = iBDAccountUserEntity.getRawJson();
            if (iBDAccountUserEntity instanceof BDAccountUserEntity) {
                BDAccountUserEntity bDAccountUserEntity = (BDAccountUserEntity) iBDAccountUserEntity;
                if (!StringUtils.equal(this.mUserName, bDAccountUserEntity.userName)) {
                    this.mUserName = bDAccountUserEntity.userName;
                    z2 = true;
                }
                if (!StringUtils.equal(this.mScreenName, bDAccountUserEntity.screenName)) {
                    this.mScreenName = bDAccountUserEntity.screenName;
                    z2 = true;
                }
                if (!StringUtils.equal(this.mVerifiedContent, bDAccountUserEntity.verifiedContent)) {
                    this.mVerifiedContent = bDAccountUserEntity.verifiedContent;
                    z2 = true;
                }
                if (this.mGender != bDAccountUserEntity.gender) {
                    this.mGender = bDAccountUserEntity.gender;
                    z2 = true;
                }
                if (!StringUtils.equal(this.mUserDescription, bDAccountUserEntity.description)) {
                    this.mUserDescription = bDAccountUserEntity.description;
                    z2 = true;
                }
                if (!StringUtils.equal(this.mAvatarUrl, bDAccountUserEntity.avatarUrl)) {
                    this.mAvatarUrl = bDAccountUserEntity.avatarUrl;
                    z2 = true;
                }
                if (this.mUserVerified != bDAccountUserEntity.user_verified) {
                    this.mUserVerified = bDAccountUserEntity.user_verified;
                    z2 = true;
                }
                if (!StringUtils.equal(this.mUserBirthday, bDAccountUserEntity.birthday)) {
                    this.mUserBirthday = bDAccountUserEntity.birthday;
                    z2 = true;
                }
                if (!StringUtils.equal(this.mArea, bDAccountUserEntity.area)) {
                    this.mArea = bDAccountUserEntity.area;
                    z2 = true;
                }
                if (!StringUtils.equal(this.mUserIndustry, bDAccountUserEntity.industry)) {
                    this.mUserIndustry = bDAccountUserEntity.industry;
                    z2 = true;
                }
                if (this.mIsToutiao != bDAccountUserEntity.isToutiao) {
                    this.mIsToutiao = bDAccountUserEntity.isToutiao;
                    z2 = true;
                }
                if (this.mIsBlocking != bDAccountUserEntity.isBlocking) {
                    this.mIsBlocking = bDAccountUserEntity.isBlocking;
                    z2 = true;
                }
                if (this.mIsBlocked != bDAccountUserEntity.isBlocked) {
                    this.mIsBlocked = bDAccountUserEntity.isBlocked;
                    z2 = true;
                }
                if (this.mIsRecommendAllowed != bDAccountUserEntity.isRecommendAllowed) {
                    this.mIsRecommendAllowed = bDAccountUserEntity.isRecommendAllowed;
                    z2 = true;
                }
                if (!StringUtils.equal(this.mRecommendHintMessage, bDAccountUserEntity.recommendHintMessage)) {
                    this.mRecommendHintMessage = bDAccountUserEntity.recommendHintMessage;
                    z2 = true;
                }
                if (this.mCanFoundByPhone != bDAccountUserEntity.canFoundByPhone) {
                    this.mCanFoundByPhone = bDAccountUserEntity.canFoundByPhone;
                    z2 = true;
                }
                if (this.mShareShowIcon != bDAccountUserEntity.shareShowIcon) {
                    this.mShareShowIcon = bDAccountUserEntity.shareShowIcon;
                    z2 = true;
                }
                if (this.mUserPrivacyExtend != bDAccountUserEntity.userPrivacyExtend) {
                    this.mUserPrivacyExtend = bDAccountUserEntity.userPrivacyExtend;
                    z2 = true;
                }
                if (this.mCanSyncShare != bDAccountUserEntity.canSyncShare) {
                    this.mCanSyncShare = bDAccountUserEntity.canSyncShare;
                    z2 = true;
                }
                if (!StringUtils.equal(this.mUserDecoration, bDAccountUserEntity.user_decoration)) {
                    this.mUserDecoration = bDAccountUserEntity.user_decoration;
                    z2 = true;
                }
                if (this.mMediaId != bDAccountUserEntity.mMediaId) {
                    this.mMediaId = bDAccountUserEntity.mMediaId;
                    z2 = true;
                }
                if (!StringUtils.equal(this.mPgcAvatarUrl, bDAccountUserEntity.pgcAvatarUrl)) {
                    this.mPgcAvatarUrl = bDAccountUserEntity.pgcAvatarUrl;
                    z2 = true;
                }
                if (!StringUtils.equal(this.mPgcName, bDAccountUserEntity.pgcName)) {
                    this.mPgcName = bDAccountUserEntity.pgcName;
                    z2 = true;
                }
                if (this.mPgcMediaId != bDAccountUserEntity.pgcMediaId) {
                    this.mPgcMediaId = bDAccountUserEntity.pgcMediaId;
                    z2 = true;
                }
                if ((!TextUtils.isEmpty(this.mBgImgUrl) && !TextUtils.isEmpty(bDAccountUserEntity.mBgImgUrl) && !StringUtils.equal(this.mBgImgUrl, bDAccountUserEntity.mBgImgUrl)) || ((TextUtils.isEmpty(this.mBgImgUrl) && !TextUtils.isEmpty(bDAccountUserEntity.mBgImgUrl)) || (!TextUtils.isEmpty(this.mBgImgUrl) && TextUtils.isEmpty(bDAccountUserEntity.mBgImgUrl)))) {
                    this.mBgImgUrl = bDAccountUserEntity.mBgImgUrl;
                    z2 = true;
                }
                if (this.mDisplayOcrEntrance != bDAccountUserEntity.mDisplayOcrEntrance) {
                    this.mDisplayOcrEntrance = bDAccountUserEntity.mDisplayOcrEntrance;
                    z2 = true;
                }
                if (!StringUtils.equal(this.mUserAuthInfo, bDAccountUserEntity.user_auth_info)) {
                    this.mUserAuthInfo = bDAccountUserEntity.user_auth_info;
                    z2 = true;
                }
                this.mExpendAttrs = bDAccountUserEntity.expendAttrs;
            }
            this.mIsLogin = true;
            z3 = z4;
            z4 = true;
            z5 = z2;
        }
        if (z5) {
            saveData();
        }
        if (z5 && z) {
            notifyUserInfoChange(z4, iBDAccountUserEntity.getRawJson());
        }
        if (z5 && (infoCacheLogin = SaveService.getInfoCacheLogin(iBDAccountUserEntity)) != null) {
            SaveService.saveLoginInfo(infoCacheLogin, new SaveCallback() { // from class: com.bytedance.sdk.account.impl.BDAccountManager.3
                @Override // com.bytedance.sdk.account.save.callback.SaveCallback
                public void onSuccess() {
                    LogHelper.d(BDAccountManager.TAG, "SaveService.saveLoginInfo success");
                }

                @Override // com.bytedance.sdk.account.save.callback.SaveCallback
                public void onError(int i, String str) {
                    LogHelper.d(BDAccountManager.TAG, "SaveService.saveLoginInfo error: code=" + i + " msg=" + str);
                }
            });
        }
        if (z3) {
            setAppLogInfo(this.mUserId, this.mSessionKey);
        }
    }

    private void notifyUserInfoChange(boolean z, JSONObject jSONObject) {
        BDAccountEvent bDAccountEvent;
        if (z) {
            BDAccountResponseEvent bDAccountResponseEvent = new BDAccountResponseEvent(0);
            bDAccountResponseEvent.respRawJson = jSONObject;
            bDAccountEvent = bDAccountResponseEvent;
        } else {
            bDAccountEvent = new BDAccountEvent(0);
        }
        bDAccountEvent.success = z;
        synchronized (this.mAccountListener) {
            Iterator it = this.mAccountListener.iterator();
            while (it.hasNext()) {
                ((BDAccountEventListener) it.next()).onReceiveAccountEvent(bDAccountEvent);
            }
        }
    }

    private void notifyUserSessionExpired() {
        Pair<Integer, String> sessionDropMessageAndClear;
        BDAccountEvent bDAccountEvent = new BDAccountEvent(2);
        bDAccountEvent.success = false;
        if (SessionDropManager.getInstance() != null && (sessionDropMessageAndClear = SessionDropManager.getInstance().getSessionDropMessageAndClear()) != null) {
            bDAccountEvent.sessionDropProtocolType = ((Integer) sessionDropMessageAndClear.first).intValue();
            bDAccountEvent.sessionDropMessage = (String) sessionDropMessageAndClear.second;
        }
        synchronized (this.mAccountListener) {
            Iterator it = this.mAccountListener.iterator();
            while (it.hasNext()) {
                ((BDAccountEventListener) it.next()).onReceiveAccountEvent(bDAccountEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void notifyLogout(IBDAccount iBDAccount, String str) {
        BDAccountEvent bDAccountEvent = new BDAccountEvent(1);
        bDAccountEvent.logoutScene = BDAccountEvent.getLogoutScene(str);
        iBDAccount.notifyBDAccountEvent(bDAccountEvent);
    }

    private boolean onUserRefreshPlatformChanged(IBDAccountUserEntity iBDAccountUserEntity) {
        boolean z = false;
        for (BDAccountPlatformEntity bDAccountPlatformEntity : this.mAllPlatforms) {
            BDAccountPlatformEntity bDAccountPlatformEntity2 = iBDAccountUserEntity.getBindMap().get(bDAccountPlatformEntity.mName);
            if (bDAccountPlatformEntity2 == null) {
                if (bDAccountPlatformEntity.mLogin) {
                    z = true;
                }
                bDAccountPlatformEntity.invalidate();
            } else {
                if (!bDAccountPlatformEntity.mLogin) {
                    bDAccountPlatformEntity.mLogin = true;
                    z = true;
                }
                bDAccountPlatformEntity.mPlatformId = bDAccountPlatformEntity2.mPlatformId;
                bDAccountPlatformEntity.mExpire = bDAccountPlatformEntity2.mExpire;
                bDAccountPlatformEntity.mExpireIn = bDAccountPlatformEntity2.mExpireIn;
                bDAccountPlatformEntity.mNickname = bDAccountPlatformEntity2.mNickname;
                bDAccountPlatformEntity.mAvatar = bDAccountPlatformEntity2.mAvatar;
                bDAccountPlatformEntity.mPlatformUid = bDAccountPlatformEntity2.mPlatformUid;
                bDAccountPlatformEntity.mUserId = bDAccountPlatformEntity2.mUserId;
                bDAccountPlatformEntity.mModifyTime = bDAccountPlatformEntity2.mModifyTime;
                bDAccountPlatformEntity.mSecPlatformUid = bDAccountPlatformEntity2.mSecPlatformUid;
                bDAccountPlatformEntity.mExtra = bDAccountPlatformEntity2.mExtra;
            }
        }
        return z;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public boolean isLogin() {
        return this.mIsLogin;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setLogin(boolean z) {
        this.mIsLogin = z;
        SharedPreferences.Editor edit = this.f8sp.edit();
        edit.putBoolean(KEY_IS_LOGIN, this.mIsLogin);
        edit.apply();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public long getUserId() {
        return this.mUserId;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserId(long j) {
        this.mUserId = j;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getSecUserId() {
        return this.mSecUserId;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setSecUserId(String str) {
        this.mSecUserId = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public int getOdinUserType() {
        return this.mOdinUserType;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setOdinUserType(int i) {
        this.mOdinUserType = i;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getAvatarUrl() {
        return this.mAvatarUrl;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setAvatarUrl(String str) {
        this.mAvatarUrl = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getUserName() {
        return this.mUserName;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserName(String str) {
        this.mUserName = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public int getUserGender() {
        return this.mGender;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserGender(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.mGender = i;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getScreenName() {
        return this.mScreenName;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setScreenName(String str) {
        this.mScreenName = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getUserDescription() {
        return this.mUserDescription;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserDescription(String str) {
        this.mUserDescription = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getBgImgUrl() {
        return this.mBgImgUrl;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setBgImgUrl(String str) {
        this.mBgImgUrl = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getUserBirthday() {
        return this.mUserBirthday;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserBirthday(String str) {
        this.mUserBirthday = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getUserArea() {
        return this.mArea;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserArea(String str) {
        this.mArea = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getUserIndustry() {
        return this.mUserIndustry;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserIndustry(String str) {
        this.mUserIndustry = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getUserMobile() {
        return this.mMobile;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public int getCountryCode() {
        return this.mCountryCode;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setCountryCode(int i) {
        this.mCountryCode = i;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getUserEmail() {
        return this.mEmail;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserEmail(String str) {
        this.mEmail = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public long getPgcMediaId() {
        return this.mPgcMediaId;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setPgcMediaId(long j) {
        this.mPgcMediaId = j;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getPgcAvatarUrl() {
        return this.mPgcAvatarUrl;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setPgcAvatarUrl(String str) {
        this.mPgcAvatarUrl = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getPgcName() {
        return this.mPgcName;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setPgcName(String str) {
        this.mPgcName = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public boolean getHasPassword() {
        return this.mHasPassword;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setHasPassword(boolean z) {
        this.mHasPassword = z;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public int getCanSyncShare() {
        return this.mCanSyncShare;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setCanSyncShare(int i) {
        this.mCanSyncShare = i;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public int getDisplayOcrEntrance() {
        return this.mDisplayOcrEntrance;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getUserAuth() {
        return this.mUserAuthInfo;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserAuth(String str) {
        this.mUserAuthInfo = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getVerifiedContent() {
        return this.mVerifiedContent;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setVerifiedContent(String str) {
        this.mVerifiedContent = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public boolean isUserVerified() {
        return this.mUserVerified;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserVerified(boolean z) {
        this.mUserVerified = z;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public boolean isRecommendAllowed() {
        return this.mIsRecommendAllowed;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setRecommendAllowed(boolean z) {
        this.mIsRecommendAllowed = z;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getRecommendHintMessage() {
        return this.mRecommendHintMessage;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setRecommendHintMessage(String str) {
        this.mRecommendHintMessage = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public int getFollowingCount() {
        return this.mFollowingCount;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public int getFollowersCount() {
        return this.mFollowersCount;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public int getVisitorsCount() {
        return this.mVisitorsCount;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public long getMediaId() {
        return this.mMediaId;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setMediaId(long j) {
        this.mMediaId = j;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setFollowingCount(int i) {
        this.mFollowingCount = i;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setFollowersCount(int i) {
        this.mFollowersCount = i;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setVisitorsCount(int i) {
        this.mVisitorsCount = i;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public int getCanFoundByPhone() {
        return this.mCanFoundByPhone;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setCanFoundByPhone(int i) {
        this.mCanFoundByPhone = i;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public int getShareShowIcon() {
        return this.mShareShowIcon;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setShareShowIcon(int i) {
        this.mShareShowIcon = i;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public int getUserPrivacyExtend() {
        return this.mUserPrivacyExtend;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserPrivacyExtend(int i) {
        this.mUserPrivacyExtend = i;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public int getUserIsBlock() {
        return this.mIsBlocked;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserIsBlock(int i) {
        this.mIsBlocked = i;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public int getUserIsBlocking() {
        return this.mIsBlocking;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserIsBlocking(int i) {
        this.mIsBlocking = i;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public boolean isUserToutiao() {
        return this.mIsToutiao;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserToutiao(boolean z) {
        this.mIsToutiao = z;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getUserDecoration() {
        return this.mUserDecoration;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setUserDecoration(String str) {
        this.mUserDecoration = str;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public boolean isVisitorAccount() {
        return this.mIsVisitorAccount;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setVisitorAccount(boolean z) {
        this.mIsVisitorAccount = z;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void updateUserInfo(IBDAccountUserEntity iBDAccountUserEntity) {
        this.mUserInfo = iBDAccountUserEntity;
        onUserInfoRefreshed(iBDAccountUserEntity, false);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public IBDAccountUserEntity getUserInfo() {
        return this.mUserInfo;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void wapLoginSync() {
        setLogin(true);
        syncTokenInfo();
    }

    private void syncTokenInfo() {
        if (this.accountCoreApi != null) {
            final String tokenBeatUrl = TTTokenManager.getTokenBeatUrl(false, true, (String) null);
            if (TextUtils.isEmpty(tokenBeatUrl)) {
                return;
            }
            UpdateTokenJob.updateToken(this.mContext, tokenBeatUrl, new UpdateTokenCallback() { // from class: com.bytedance.sdk.account.impl.BDAccountManager.4
                @Override // com.bytedance.sdk.account.CommonCallBack
                public void onSuccess(UpdateTokenResponse updateTokenResponse) {
                }

                @Override // com.bytedance.sdk.account.CommonCallBack
                public void onError(UpdateTokenResponse updateTokenResponse, int i) {
                    if (updateTokenResponse != null && UserInfoThreadConstants.SESSION_EXPIRED.equalsIgnoreCase(updateTokenResponse.errorName)) {
                        TTTokenManager.onSessionExpired(tokenBeatUrl, (List) null, (ITokenService.Callback) null);
                    } else {
                        TTTokenMonitor.monitorToken("tt_token_beat", (List) null, i, updateTokenResponse != null ? updateTokenResponse.errorMsg : "");
                    }
                }
            }).start();
        }
    }

    private void loadPlatform(SharedPreferences sharedPreferences) {
        int i = 0;
        while (true) {
            BDAccountPlatformEntity[] bDAccountPlatformEntityArr = this.mAllPlatforms;
            if (i >= bDAccountPlatformEntityArr.length) {
                return;
            }
            bDAccountPlatformEntityArr[i].mLogin = false;
            BDAccountPlatformEntity bDAccountPlatformEntity = this.mAllPlatforms[i];
            try {
                if (!TextUtils.isEmpty(bDAccountPlatformEntity.mName)) {
                    String string = sharedPreferences.getString(KEY_PLATFROM_PREFIX + bDAccountPlatformEntity.mName, null);
                    if (!TextUtils.isEmpty(string)) {
                        loadPlatformItem(new JSONObject(string), bDAccountPlatformEntity);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    private void loadThirdPlatforms() {
        Set<String> stringSet;
        BDAccountPlatformEntity loadPlatformItem;
        if (this.mUserInfo == null || (stringSet = this.f8sp.getStringSet(STORE_KEY_SAVED_PLATFORM_APP_ID, null)) == null) {
            return;
        }
        try {
            Iterator<String> it = stringSet.iterator();
            while (it.hasNext()) {
                String string = this.f8sp.getString(getStoreKeyThirdPlatform(it.next()), null);
                if (!TextUtils.isEmpty(string) && (loadPlatformItem = loadPlatformItem(new JSONObject(string), null)) != null) {
                    Map<String, BDAccountPlatformEntity> map = this.mUserInfo.thirdPlatform.get(loadPlatformItem.mName);
                    if (map == null) {
                        map = new HashMap<>();
                        this.mUserInfo.thirdPlatform.put(loadPlatformItem.mName, map);
                    }
                    map.put(String.valueOf(loadPlatformItem.mPlatformId), loadPlatformItem);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BDAccountPlatformEntity loadPlatformItem(JSONObject jSONObject, BDAccountPlatformEntity bDAccountPlatformEntity) {
        if (jSONObject == null) {
            return bDAccountPlatformEntity;
        }
        String optString = jSONObject.optString("mName", "");
        if (TextUtils.isEmpty(optString)) {
            return bDAccountPlatformEntity;
        }
        if (bDAccountPlatformEntity == null) {
            bDAccountPlatformEntity = new BDAccountPlatformEntity(optString);
        }
        if (!TextUtils.equals(optString, bDAccountPlatformEntity.mName)) {
            return bDAccountPlatformEntity;
        }
        if (jSONObject.has("mPlatformId")) {
            bDAccountPlatformEntity.mPlatformId = jSONObject.optLong("mPlatformId", 0L);
        }
        if (jSONObject.has("mNickname")) {
            bDAccountPlatformEntity.mNickname = jSONObject.optString("mNickname", "");
        }
        if (jSONObject.has("mAvatar")) {
            bDAccountPlatformEntity.mAvatar = jSONObject.optString("mAvatar", "");
        }
        if (jSONObject.has("mPlatformUid")) {
            bDAccountPlatformEntity.mPlatformUid = jSONObject.optString("mPlatformUid", "");
        }
        if (jSONObject.has("mExpire")) {
            bDAccountPlatformEntity.mExpire = jSONObject.optLong("mExpire", bDAccountPlatformEntity.mExpire);
        }
        if (jSONObject.has("mExpireIn")) {
            bDAccountPlatformEntity.mExpireIn = jSONObject.optLong("mExpireIn", bDAccountPlatformEntity.mExpireIn);
        }
        if (jSONObject.has("isLogin")) {
            bDAccountPlatformEntity.mLogin = jSONObject.optBoolean("isLogin", false);
        }
        if (jSONObject.has("mUserId")) {
            bDAccountPlatformEntity.mUserId = jSONObject.optLong("mUserId", 0L);
        }
        if (jSONObject.has("mModifyTime")) {
            bDAccountPlatformEntity.mModifyTime = jSONObject.optLong("mModifyTime");
        }
        if (jSONObject.has("mSecPlatformUid")) {
            bDAccountPlatformEntity.mSecPlatformUid = jSONObject.optString("mSecPlatformUid");
        }
        if (jSONObject.has("mAccessToken")) {
            bDAccountPlatformEntity.mAccessToken = jSONObject.optString("mAccessToken");
        }
        if (jSONObject.has("mOpenId")) {
            bDAccountPlatformEntity.mOpenId = jSONObject.optString("mOpenId");
        }
        if (jSONObject.has("mScope")) {
            bDAccountPlatformEntity.mScope = jSONObject.optString("mScope");
        }
        if (jSONObject.has("refreshAt")) {
            bDAccountPlatformEntity.refreshAt = jSONObject.optLong("refreshAt", bDAccountPlatformEntity.refreshAt);
        }
        if (jSONObject.has("refreshTime")) {
            bDAccountPlatformEntity.refreshTime = jSONObject.optLong("refreshTime", bDAccountPlatformEntity.refreshTime);
        }
        return bDAccountPlatformEntity;
    }

    private void loadData() {
        if (this.mDataLoaded) {
            return;
        }
        this.mDataLoaded = true;
        try {
            this.mRawJson = new JSONObject(this.f8sp.getString(KEY_RAW_JSON, "{}"));
        } catch (JSONException unused) {
            this.mRawJson = new JSONObject();
        }
        this.mIsLogin = this.f8sp.getBoolean(KEY_IS_LOGIN, false);
        this.mUserId = this.f8sp.getLong("user_id", 0L);
        this.mSecUserId = this.f8sp.getString("sec_user_id", "");
        this.mOdinUserType = this.f8sp.getInt(KEY_ODIN_USER_TYPE, 0);
        this.mIsNewUser = this.f8sp.getBoolean(KEY_IS_NEW_USER, false);
        this.mSessionKey = this.f8sp.getString(KEY_SESSION_KEY, "");
        this.mSessionSign = this.f8sp.getString(KEY_SESSION_SIGN, "");
        this.mUserName = this.f8sp.getString("user_name", "");
        this.mGender = this.f8sp.getInt(KEY_USER_GENDER, 0);
        this.mScreenName = this.f8sp.getString("screen_name", "");
        this.mVerifiedContent = this.f8sp.getString(KEY_VERIFIED_CONTENT, "");
        this.mUserVerified = this.f8sp.getBoolean(KEY_USER_VERIFIED, false);
        this.mAvatarUrl = this.f8sp.getString("avatar_url", "");
        this.mUserBirthday = this.f8sp.getString(KEY_USER_BIRTHDAY, "");
        this.mArea = this.f8sp.getString(KEY_USER_AREA, "");
        this.mUserIndustry = this.f8sp.getString(KEY_USER_INDUSTRY, "");
        this.mEmail = this.f8sp.getString(KEY_USER_EMAIL, "");
        this.mMobile = this.f8sp.getString(KEY_USER_MOBILE, "");
        this.mUserDecoration = this.f8sp.getString(KEY_USER_DECORATION, "");
        this.mUserDescription = this.f8sp.getString(KEY_USER_DESCRIPTION, "");
        this.mIsRecommendAllowed = this.f8sp.getBoolean(KEY_IS_RECOMMEND_ALLOWED, false);
        this.mRecommendHintMessage = this.f8sp.getString(KEY_RECOMMEND_HINT_MESSAGE, "");
        this.mIsBlocked = this.f8sp.getInt(KEY_IS_BLOCKED, 0);
        this.mIsBlocking = this.f8sp.getInt(KEY_IS_BLOCKING, 0);
        this.mIsToutiao = this.f8sp.getBoolean(KEY_IS_TOUTIAO, false);
        this.mHasPassword = this.f8sp.getBoolean(KEY_USER_HASPWD, false);
        this.mCountryCode = this.f8sp.getInt("country_code", 0);
        this.mPgcMediaId = this.f8sp.getLong(KEY_PGC_MEDIAID, 0L);
        this.mPgcAvatarUrl = this.f8sp.getString(KEY_PGC_AVATAR_URL, "");
        this.mPgcName = this.f8sp.getString(KEY_PGC_NAME, "");
        this.mCanFoundByPhone = this.f8sp.getInt(KEY_CAN_BE_FOUND_BY_PHONE, 1);
        this.mCanSyncShare = this.f8sp.getInt(KEY_CAN_SYNC_SHARE, 0);
        this.mShareShowIcon = this.f8sp.getInt(KEY_IS_SHARE_SHOW_ICON, 0);
        this.mUserPrivacyExtend = this.f8sp.getInt(KEY_USER_PRIVACY_EXTEND, 2147483646);
        this.mBgImgUrl = this.f8sp.getString(KEY_BG_IMG_URL, "");
        this.mMultiSids = this.f8sp.getString(KEY_MULTI_SID, "");
        this.mFollowingCount = this.f8sp.getInt(KEY_FOLLOWING_COUNT, 0);
        this.mFollowersCount = this.f8sp.getInt(KEY_FOLLOWERS_COUNT, 0);
        this.mVisitorsCount = this.f8sp.getInt(KEY_VISITORS_COUNT, 0);
        this.mMediaId = this.f8sp.getLong(KEY_MEDIA_ID, 0L);
        this.mBgImgUrl = this.f8sp.getString(KEY_BG_IMG_URL, "");
        this.mDisplayOcrEntrance = this.f8sp.getInt(KEY_DISPLAY_OCR_ENTRANCE, 0);
        this.mUserAuthInfo = this.f8sp.getString(KEY_USER_AUTH_INFO, "");
        this.mIsVisitorAccount = this.f8sp.getBoolean(KEY_IS_VISITOR_ACCOUNT, false);
        this.mHashUpdateSecUids = this.f8sp.getStringSet(KEY_HAS_UPDATE_SEC_UIDS, new HashSet());
        this.mIsKidsMode = this.f8sp.getBoolean(KEY_IS_KIDS_MODE, false);
        boolean z = this.mIsLogin;
        if (z && this.mUserId <= 0) {
            this.mIsLogin = false;
            this.mUserId = 0L;
            this.mSecUserId = "";
            this.mOdinUserType = 0;
        } else if (!z && this.mUserId > 0) {
            this.mUserId = 0L;
            this.mSecUserId = "";
            this.mOdinUserType = 0;
        }
        loadPlatform(this.f8sp);
        long j = this.mUserId;
        if (j > 0) {
            setAppLogInfo(j, this.mSessionKey);
        }
        try {
            this.mExpendAttrs = new JSONObject(this.f8sp.getString(KEY_EXPEND_ATTRS, "{}"));
        } catch (JSONException unused2) {
            this.mExpendAttrs = new JSONObject();
        }
        this.mUserInfo = getAccountEntity();
        loadThirdPlatforms();
        logThirdInfo("loadData");
        boolean z2 = this.mIsLogin;
        IBDAccountUserEntity iBDAccountUserEntity = this.mUserInfo;
        AccountMonitorUtil.eventLoadUserInfo(z2, iBDAccountUserEntity != null && iBDAccountUserEntity.userId > 0, String.valueOf(this.mUserId));
    }

    private void logThirdInfo(String str) {
        if (this.mUserInfo == null) {
            LogHelper.d(TAG, "mUserInfo == null");
            return;
        }
        LogHelper.d(TAG, String.format("%s: bind map entities", str));
        LogHelper.d(TAG, "isLogin==" + this.mIsLogin);
        Iterator<BDAccountPlatformEntity> it = this.mUserInfo.bindMap.values().iterator();
        while (it.hasNext()) {
            LogHelper.d(TAG, String.format("%1s: bind map entity = %2s", str, it.next().getLoggableString()));
        }
        LogHelper.d(TAG, String.format("%s: third platform entities", str));
        Iterator<Map<String, BDAccountPlatformEntity>> it2 = this.mUserInfo.thirdPlatform.values().iterator();
        while (it2.hasNext()) {
            Iterator<BDAccountPlatformEntity> it3 = it2.next().values().iterator();
            while (it3.hasNext()) {
                LogHelper.d(TAG, String.format("%1s: third platform entity = %2s", str, it3.next().getLoggableString()));
            }
        }
    }

    private void savePlatform(SharedPreferences.Editor editor) {
        for (BDAccountPlatformEntity bDAccountPlatformEntity : this.mAllPlatforms) {
            if (!this.mIsLogin) {
                editor.putString(KEY_PLATFROM_PREFIX + bDAccountPlatformEntity.mName, "");
            } else {
                JSONObject platformJsonObject = getPlatformJsonObject(bDAccountPlatformEntity);
                if (platformJsonObject != null) {
                    editor.putString(KEY_PLATFROM_PREFIX + bDAccountPlatformEntity.mName, platformJsonObject.toString());
                }
            }
        }
        editor.apply();
    }

    private void saveThirdPlatform() {
        JSONObject platformJsonObject;
        if (this.mUserInfo == null) {
            return;
        }
        SharedPreferences.Editor edit = this.f8sp.edit();
        Set<String> stringSet = this.f8sp.getStringSet(STORE_KEY_SAVED_PLATFORM_APP_ID, null);
        if (stringSet != null) {
            for (String str : stringSet) {
                String storeKeyThirdPlatform = getStoreKeyThirdPlatform(str);
                String string = this.f8sp.getString(storeKeyThirdPlatform, null);
                if (TextUtils.isEmpty(string)) {
                    edit.remove(storeKeyThirdPlatform);
                } else {
                    try {
                        Map<String, BDAccountPlatformEntity> map = this.mUserInfo.getThirdPlatform().get(new JSONObject(string).optString("mName"));
                        if (map != null && !map.isEmpty()) {
                            BDAccountPlatformEntity bDAccountPlatformEntity = map.get(str);
                            if (bDAccountPlatformEntity == null || !bDAccountPlatformEntity.mLogin) {
                                edit.remove(storeKeyThirdPlatform);
                            }
                        }
                        edit.remove(storeKeyThirdPlatform);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Map<String, BDAccountPlatformEntity> map2 : this.mUserInfo.thirdPlatform.values()) {
            if (map2 != null && !map2.isEmpty()) {
                for (String str2 : map2.keySet()) {
                    BDAccountPlatformEntity bDAccountPlatformEntity2 = map2.get(str2);
                    if (bDAccountPlatformEntity2 != null && bDAccountPlatformEntity2.mLogin && (platformJsonObject = getPlatformJsonObject(bDAccountPlatformEntity2)) != null) {
                        edit.putString(getStoreKeyThirdPlatform(str2), platformJsonObject.toString());
                        hashSet.add(str2);
                    }
                }
            }
        }
        edit.putStringSet(STORE_KEY_SAVED_PLATFORM_APP_ID, hashSet);
        edit.apply();
    }

    String getStoreKeyThirdPlatform(String str) {
        return KEY_PLATFROM_PREFIX + str;
    }

    private JSONObject getPlatformJsonObject(BDAccountPlatformEntity bDAccountPlatformEntity) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mName", bDAccountPlatformEntity.mName);
            jSONObject.put("mPlatformId", bDAccountPlatformEntity.mPlatformId);
            jSONObject.put("mNickname", bDAccountPlatformEntity.mNickname);
            jSONObject.put("mAvatar", bDAccountPlatformEntity.mAvatar);
            jSONObject.put("mPlatformUid", bDAccountPlatformEntity.mPlatformUid);
            jSONObject.put("mExpire", bDAccountPlatformEntity.mExpire);
            jSONObject.put("mExpireIn", bDAccountPlatformEntity.mExpireIn);
            jSONObject.put("isLogin", bDAccountPlatformEntity.mLogin);
            jSONObject.put("mUserId", bDAccountPlatformEntity.mUserId);
            jSONObject.put("mModifyTime", bDAccountPlatformEntity.mModifyTime);
            jSONObject.put("mSecPlatformUid", bDAccountPlatformEntity.mSecPlatformUid);
            jSONObject.put("mAccessToken", bDAccountPlatformEntity.mAccessToken);
            jSONObject.put("mOpenId", bDAccountPlatformEntity.mOpenId);
            jSONObject.put("mScope", bDAccountPlatformEntity.mScope);
            jSONObject.put("refreshAt", bDAccountPlatformEntity.refreshAt);
            jSONObject.put("refreshTime", bDAccountPlatformEntity.refreshTime);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void saveData() {
        SharedPreferences.Editor edit = this.f8sp.edit();
        savePlatform(edit);
        saveThirdPlatform();
        edit.remove(KEY_SESSION);
        edit.putBoolean(KEY_IS_LOGIN, this.mIsLogin);
        edit.putLong("user_id", this.mUserId);
        edit.putInt(KEY_ODIN_USER_TYPE, this.mOdinUserType);
        edit.putString("sec_user_id", this.mSecUserId);
        edit.putString(KEY_SESSION_KEY, this.mSessionKey);
        edit.putString(KEY_SESSION_SIGN, this.mSessionSign);
        edit.putString("user_name", this.mUserName);
        edit.putString(KEY_VERIFIED_CONTENT, this.mVerifiedContent);
        edit.putInt(KEY_USER_GENDER, this.mGender);
        edit.putString("screen_name", this.mScreenName);
        edit.putBoolean(KEY_USER_VERIFIED, this.mUserVerified);
        edit.putString("avatar_url", this.mAvatarUrl);
        edit.putBoolean(KEY_IS_NEW_USER, this.mIsNewUser);
        edit.putString(KEY_USER_EMAIL, this.mEmail);
        edit.putString(KEY_USER_MOBILE, this.mMobile);
        edit.putInt(KEY_IS_BLOCKED, this.mIsBlocked);
        edit.putInt(KEY_IS_BLOCKING, this.mIsBlocking);
        edit.putBoolean(KEY_IS_TOUTIAO, this.mIsToutiao);
        edit.putBoolean(KEY_USER_HASPWD, this.mHasPassword);
        edit.putInt("country_code", this.mCountryCode);
        edit.putString(KEY_USER_AREA, this.mArea);
        edit.putString(KEY_USER_INDUSTRY, this.mUserIndustry);
        edit.putString(KEY_USER_DECORATION, this.mUserDecoration);
        edit.putString(KEY_USER_BIRTHDAY, this.mUserBirthday);
        edit.putLong(KEY_PGC_MEDIAID, this.mPgcMediaId);
        edit.putString(KEY_PGC_AVATAR_URL, this.mPgcAvatarUrl);
        edit.putString(KEY_PGC_NAME, this.mPgcName);
        edit.putString(KEY_USER_DESCRIPTION, this.mUserDescription);
        edit.putBoolean(KEY_IS_RECOMMEND_ALLOWED, this.mIsRecommendAllowed);
        edit.putString(KEY_RECOMMEND_HINT_MESSAGE, this.mRecommendHintMessage);
        edit.putInt(KEY_CAN_BE_FOUND_BY_PHONE, this.mCanFoundByPhone);
        edit.putInt(KEY_CAN_SYNC_SHARE, this.mCanSyncShare);
        edit.putInt(KEY_FOLLOWING_COUNT, this.mFollowingCount);
        edit.putInt(KEY_FOLLOWERS_COUNT, this.mFollowersCount);
        edit.putInt(KEY_VISITORS_COUNT, this.mVisitorsCount);
        edit.putLong(KEY_MEDIA_ID, this.mMediaId);
        edit.putString(KEY_BG_IMG_URL, this.mBgImgUrl);
        edit.putInt(KEY_DISPLAY_OCR_ENTRANCE, this.mDisplayOcrEntrance);
        edit.putString(KEY_USER_AUTH_INFO, this.mUserAuthInfo);
        edit.putInt(KEY_IS_SHARE_SHOW_ICON, this.mShareShowIcon);
        edit.putInt(KEY_USER_PRIVACY_EXTEND, this.mUserPrivacyExtend);
        edit.putBoolean(KEY_IS_VISITOR_ACCOUNT, this.mIsVisitorAccount);
        edit.putBoolean(KEY_IS_KIDS_MODE, this.mIsKidsMode);
        saveJson(edit);
        JSONObject jSONObject = this.mExpendAttrs;
        if (jSONObject == null) {
            edit.putString(KEY_EXPEND_ATTRS, "");
        } else {
            edit.putString(KEY_EXPEND_ATTRS, jSONObject.toString());
        }
        SharedPrefsEditorCompat.apply(edit);
        logThirdInfo("saveData");
    }

    private void saveJson(SharedPreferences.Editor editor) {
        JSONObject jSONObject = this.mRawJson;
        if (jSONObject == null) {
            editor.putString(KEY_RAW_JSON, "");
        } else {
            editor.putString(KEY_RAW_JSON, jSONObject.toString());
        }
        editor.apply();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static class LogoutHandle implements ApiResponseHandler {
        private LogoutHandle() {
        }

        @Override // com.bytedance.sdk.account.impl.BDAccountManager.ApiResponseHandler
        public void handle(BaseApiResponse baseApiResponse) {
            if (baseApiResponse.api == 10001 && baseApiResponse.success) {
                IBDAccount instance = BDAccountDelegateInner.instance(TTAccountInit.getConfig().getApplicationContext());
                instance.invalidateSession(false);
                BDAccountManager.notifyLogout(instance, baseApiResponse instanceof LogoutApiResponse ? ((LogoutApiResponse) baseApiResponse).mLogoutScene : "");
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static class UserAPiHandler implements ApiResponseHandler {
        private UserAPiHandler() {
        }

        @Override // com.bytedance.sdk.account.impl.BDAccountManager.ApiResponseHandler
        public void handle(BaseApiResponse baseApiResponse) {
            IBDAccountUserEntity iBDAccountUserEntity;
            if (baseApiResponse instanceof UserApiResponse) {
                iBDAccountUserEntity = ((UserApiResponse) baseApiResponse).userInfo;
            } else if (baseApiResponse instanceof MobileApiResponse) {
                T t = ((MobileApiResponse) baseApiResponse).mobileObj;
                if (t instanceof IUserQueryObj) {
                    iBDAccountUserEntity = ((IUserQueryObj) t).getUserInfo();
                }
                iBDAccountUserEntity = null;
            } else {
                if (baseApiResponse instanceof LoginByTicketResponse) {
                    iBDAccountUserEntity = ((LoginByTicketResponse) baseApiResponse).mUserInfo;
                }
                iBDAccountUserEntity = null;
            }
            if (iBDAccountUserEntity != null) {
                BDAccountManager.sInstance.onUserInfoRefreshed(iBDAccountUserEntity, true);
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static class ThirdTokenHandler implements ApiResponseHandler {
        private ThirdTokenHandler() {
        }

        @Override // com.bytedance.sdk.account.impl.BDAccountManager.ApiResponseHandler
        public void handle(BaseApiResponse baseApiResponse) {
            Context applicationContext = TTAccountInit.getConfig().getApplicationContext();
            if (baseApiResponse instanceof ThirdTokenResponse) {
                ThirdTokenResponse thirdTokenResponse = (ThirdTokenResponse) baseApiResponse;
                if (baseApiResponse.success) {
                    Bundle bundle = new Bundle();
                    bundle.putString("access_token", thirdTokenResponse.accessToken);
                    bundle.putLong("expires_in", thirdTokenResponse.expiresIn);
                    bundle.putLong("refresh_time", thirdTokenResponse.refreshTime);
                    bundle.putString("open_id", thirdTokenResponse.openId);
                    bundle.putString("scopes", thirdTokenResponse.scopes);
                    LogHelper.d(BDAccountManager.TAG, "ThirdTokenHandler.handle: api=" + baseApiResponse.api + ", updatePlatformInfo. resp=" + thirdTokenResponse.getLoggableString());
                    BDAccountManager.instance(applicationContext).updatePlatformInfo(thirdTokenResponse.platformName, thirdTokenResponse.platformAppId, bundle);
                    return;
                }
                if (thirdTokenResponse.error == 1058 || thirdTokenResponse.error == 1059) {
                    LogHelper.d(BDAccountManager.TAG, "ThirdTokenHandler.handle: api=" + baseApiResponse.api + ", clearPlatformInfoInner. errCode=" + thirdTokenResponse.error);
                    BDAccountManager.instance(applicationContext).clearPlatformInfoInner(thirdTokenResponse.platformName, thirdTokenResponse.platformAppId, thirdTokenResponse.error == 1058);
                }
            }
        }
    }

    public BDAccountUserEntity getAccountEntity() {
        BDAccountUserEntity bDAccountUserEntity = new BDAccountUserEntity(this.mRawJson);
        bDAccountUserEntity.userId = this.mUserId;
        bDAccountUserEntity.odinUserType = this.mOdinUserType;
        bDAccountUserEntity.isNewUser = this.mIsNewUser;
        bDAccountUserEntity.sessionKey = this.mSessionKey;
        bDAccountUserEntity.userName = this.mUserName;
        bDAccountUserEntity.gender = this.mGender;
        bDAccountUserEntity.screenName = this.mScreenName;
        bDAccountUserEntity.verifiedContent = this.mVerifiedContent;
        bDAccountUserEntity.avatarUrl = this.mAvatarUrl;
        bDAccountUserEntity.birthday = this.mUserBirthday;
        bDAccountUserEntity.user_verified = this.mUserVerified;
        bDAccountUserEntity.area = this.mArea;
        bDAccountUserEntity.industry = this.mUserIndustry;
        bDAccountUserEntity.user_decoration = this.mUserDecoration;
        bDAccountUserEntity.description = this.mUserDescription;
        bDAccountUserEntity.isRecommendAllowed = this.mIsRecommendAllowed;
        bDAccountUserEntity.recommendHintMessage = this.mRecommendHintMessage;
        bDAccountUserEntity.canFoundByPhone = this.mCanFoundByPhone;
        bDAccountUserEntity.canSyncShare = this.mCanSyncShare;
        bDAccountUserEntity.mBgImgUrl = this.mBgImgUrl;
        bDAccountUserEntity.mFollowingCount = this.mFollowingCount;
        bDAccountUserEntity.mFollowersCount = this.mFollowersCount;
        bDAccountUserEntity.mVisitorsCount = this.mVisitorsCount;
        bDAccountUserEntity.mMediaId = this.mMediaId;
        bDAccountUserEntity.email = this.mEmail;
        bDAccountUserEntity.user_auth_info = this.mUserAuthInfo;
        bDAccountUserEntity.mDisplayOcrEntrance = this.mDisplayOcrEntrance;
        bDAccountUserEntity.userPrivacyExtend = this.mUserPrivacyExtend;
        bDAccountUserEntity.shareShowIcon = this.mShareShowIcon;
        bDAccountUserEntity.isBlocked = this.mIsBlocked;
        bDAccountUserEntity.isBlocking = this.mIsBlocking;
        bDAccountUserEntity.isToutiao = this.mIsToutiao;
        bDAccountUserEntity.hasPassword = this.mHasPassword;
        bDAccountUserEntity.pgcAvatarUrl = this.mPgcAvatarUrl;
        bDAccountUserEntity.pgcMediaId = this.mMediaId;
        bDAccountUserEntity.pgcName = this.mPgcName;
        bDAccountUserEntity.countryCode = this.mCountryCode;
        bDAccountUserEntity.secUserId = this.mSecUserId;
        bDAccountUserEntity.isVisitorAccount = this.mIsVisitorAccount;
        bDAccountUserEntity.isKidsMode = this.mIsKidsMode;
        bDAccountUserEntity.expendAttrs = this.mExpendAttrs;
        for (BDAccountPlatformEntity bDAccountPlatformEntity : this.mAllPlatforms) {
            if (!TextUtils.isEmpty(bDAccountPlatformEntity.mName) && bDAccountPlatformEntity.mLogin) {
                bDAccountUserEntity.getBindMap().put(bDAccountPlatformEntity.mName, bDAccountPlatformEntity);
            }
        }
        return bDAccountUserEntity;
    }

    void setAppLogInfo(long j, String str) {
        try {
            IMonitor monitor = TTAccountInit.getConfig().getMonitor();
            if (monitor != null) {
                monitor.setAppLogInfo(j, str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void addHasUpdateSecUids(String str) {
        if (this.mHashUpdateSecUids == null) {
            this.mHashUpdateSecUids = new HashSet();
        }
        this.mHashUpdateSecUids.add(str);
        this.f8sp.edit().putStringSet(KEY_HAS_UPDATE_SEC_UIDS, this.mHashUpdateSecUids).apply();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public boolean hasUpdateSecUid(String str) {
        Set<String> set = this.mHashUpdateSecUids;
        if (set == null) {
            return false;
        }
        return set.contains(str);
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public boolean isKidsMode() {
        return this.mIsKidsMode;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public String getXttSessionSign() {
        return this.mSessionSign;
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void setXttSessionSign(String str) {
        this.mSessionSign = str;
        this.f8sp.edit().putString(KEY_SESSION_SIGN, str).apply();
    }

    @Override // com.bytedance.sdk.account.api.IBDAccount
    public void onReceiveLongConnectionMessage(String str) {
        SessionDropManager.getInstance(this).onReceiveLongConnectionMessage(str);
    }
}
