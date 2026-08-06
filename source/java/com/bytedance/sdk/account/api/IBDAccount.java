package com.bytedance.sdk.account.api;

import com.bytedance.sdk.account.user.IBDAccountUserEntity;
import com.ss.android.account.model2.BDAccountPlatformEntity;
import java.util.HashMap;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public interface IBDAccount {
    void addHasUpdateSecUids(String str);

    void addListener(BDAccountEventListener bDAccountEventListener);

    void clearMultiSid();

    void clearPlatformInfo(String str, int i, boolean z);

    String getAvatarUrl();

    String getBgImgUrl();

    int getCanFoundByPhone();

    int getCanSyncShare();

    int getCountryCode();

    int getDisplayOcrEntrance();

    int getFollowersCount();

    int getFollowingCount();

    boolean getHasPassword();

    long getMediaId();

    String getMultiSid();

    int getOdinUserType();

    String getPgcAvatarUrl();

    long getPgcMediaId();

    String getPgcName();

    BDAccountPlatformEntity getPlatformByName(String str);

    String getRecommendHintMessage();

    String getScreenName();

    String getSecUserId();

    String getSessionKey();

    int getShareShowIcon();

    String getUserArea();

    String getUserAuth();

    String getUserBirthday();

    String getUserDecoration();

    String getUserDescription();

    String getUserEmail();

    int getUserGender();

    long getUserId();

    String getUserIndustry();

    IBDAccountUserEntity getUserInfo();

    int getUserIsBlock();

    int getUserIsBlocking();

    String getUserMobile();

    String getUserName();

    int getUserPrivacyExtend();

    String getVerifiedContent();

    int getVisitorsCount();

    String getXttSessionSign();

    boolean hasUpdateSecUid(String str);

    void invalidateSession(boolean z);

    boolean isKidsMode();

    boolean isLogin();

    boolean isRecommendAllowed();

    boolean isUserToutiao();

    boolean isUserVerified();

    boolean isVisitorAccount();

    void notifyBDAccountEvent(BDAccountEvent bDAccountEvent);

    void onReceiveLongConnectionMessage(String str);

    void onUserInfoRefreshed(IBDAccountUserEntity iBDAccountUserEntity, boolean z);

    void removeListener(BDAccountEventListener bDAccountEventListener);

    void saveData();

    void setAvatarUrl(String str);

    void setBgImgUrl(String str);

    void setCanFoundByPhone(int i);

    void setCanSyncShare(int i);

    void setConcerningFields(List<String> list);

    void setCountryCode(int i);

    void setFollowersCount(int i);

    void setFollowingCount(int i);

    void setHasPassword(boolean z);

    void setLogin(boolean z);

    void setMediaId(long j);

    void setOdinUserType(int i);

    void setPgcAvatarUrl(String str);

    void setPgcMediaId(long j);

    void setPgcName(String str);

    void setPlatformMap(HashMap<String, BDAccountPlatformEntity> hashMap);

    void setRecommendAllowed(boolean z);

    void setRecommendHintMessage(String str);

    void setScreenName(String str);

    void setSecUserId(String str);

    void setSessionKey(String str);

    void setShareShowIcon(int i);

    void setUserArea(String str);

    void setUserAuth(String str);

    void setUserBirthday(String str);

    void setUserDecoration(String str);

    void setUserDescription(String str);

    void setUserEmail(String str);

    void setUserGender(int i);

    void setUserId(long j);

    void setUserIndustry(String str);

    void setUserIsBlock(int i);

    void setUserIsBlocking(int i);

    void setUserMobile(String str);

    void setUserName(String str);

    void setUserPrivacyExtend(int i);

    void setUserToutiao(boolean z);

    void setUserVerified(boolean z);

    void setVerifiedContent(String str);

    void setVisitorAccount(boolean z);

    void setVisitorsCount(int i);

    void setXttSessionSign(String str);

    void stopUpdateUserInfo();

    void tryUpdateUserInfo(String str);

    void updateMultiSid(String str);

    void updateUserInfo(IBDAccountUserEntity iBDAccountUserEntity);

    void wapLoginSync();
}
