package com.ss.android.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TTTokenConfig {
    private static final String SP_KEY_SHARE_COOKIE_HOST_LIST = "share_cookie_host_list";
    private static final String SP_NAME_LOCAL_CONFIG = "com_ss_android_token_sp_host";
    private static final String SP_NAME_TTNET_CONFIG = "ss_app_config";
    private String mBeatUrl;
    private IBlockList mBlockList;
    private ILocalTest mIsLocalTest;
    private String mTokenSaveName;
    private Set<String> mHostSet = new CopyOnWriteArraySet();
    private boolean hasCallAddHostList = false;
    private boolean mNeedSign = false;
    private long mUpdateInterval = 600000;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface IBlockList {
        boolean inBlockList(String str);
    }

    @Deprecated
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ILocalTest {
        boolean isLocalTest();
    }

    private SharedPreferences getSpLocalConfig() {
        Context applicationContext = TTTokenManager.getApplicationContext();
        if (applicationContext != null) {
            return applicationContext.getSharedPreferences(SP_NAME_LOCAL_CONFIG, 0);
        }
        return null;
    }

    private SharedPreferences getSpTTNetConfig() {
        Context applicationContext = TTTokenManager.getApplicationContext();
        if (applicationContext != null) {
            return applicationContext.getSharedPreferences(SP_NAME_TTNET_CONFIG, 0);
        }
        return null;
    }

    public boolean hasCallAddHostList() {
        return this.hasCallAddHostList;
    }

    public TTTokenConfig setTokenSaveName(String str) {
        this.mTokenSaveName = str;
        return this;
    }

    public String getTokenSaveName() {
        return this.mTokenSaveName;
    }

    public TTTokenConfig() {
        String str = "https://" + TTTokenManager.getHost();
        this.mBeatUrl = str;
        String topDomain = TokenUtils.getTopDomain(str);
        if (topDomain != null) {
            this.mHostSet.add(topDomain);
        }
    }

    public String getBeatHost() {
        return this.mBeatUrl;
    }

    public Set<String> getHostList() {
        return this.mHostSet;
    }

    public boolean isHostListValid() {
        this.mHostSet.remove(null);
        return !this.mHostSet.isEmpty();
    }

    public void saveHostList() {
        SharedPreferences spLocalConfig = getSpLocalConfig();
        if (spLocalConfig == null || !isHostListValid()) {
            return;
        }
        spLocalConfig.edit().putStringSet(SP_KEY_SHARE_COOKIE_HOST_LIST, this.mHostSet).apply();
    }

    public void addHostListFromLocalAndTTNet() {
        addFromLocal();
        addFromTTNet();
        saveHostList();
    }

    public void addFromLocal() {
        Set<String> stringSet;
        SharedPreferences spLocalConfig = getSpLocalConfig();
        if (spLocalConfig == null || (stringSet = spLocalConfig.getStringSet(SP_KEY_SHARE_COOKIE_HOST_LIST, null)) == null) {
            return;
        }
        this.mHostSet.addAll(stringSet);
    }

    public void addFromTTNet() {
        SharedPreferences spTTNetConfig = getSpTTNetConfig();
        if (spTTNetConfig != null) {
            String string = spTTNetConfig.getString(SP_KEY_SHARE_COOKIE_HOST_LIST, "");
            HashSet hashSet = new HashSet();
            if (!TextUtils.isEmpty(string)) {
                String[] split = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length > 0) {
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str)) {
                            if (str.length() > 1 && str.startsWith(".")) {
                                str = str.substring(1);
                            }
                            hashSet.add(str);
                        }
                    }
                }
            }
            this.mHostSet.addAll(hashSet);
        }
    }

    public TTTokenConfig addHostList(Collection<String> collection) {
        dynamicAddHostList(collection);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getUpdateInterval() {
        return this.mUpdateInterval;
    }

    public TTTokenConfig setUpdateInterval(long j) {
        this.mUpdateInterval = j;
        return this;
    }

    public TTTokenConfig setTokenSign(boolean z) {
        this.mNeedSign = z;
        return this;
    }

    protected boolean isNeedTokenSign() {
        return this.mNeedSign;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IBlockList getBlockList() {
        return this.mBlockList;
    }

    public TTTokenConfig setBlackList(IBlockList iBlockList) {
        this.mBlockList = iBlockList;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dynamicAddHostList(Collection<String> collection) {
        if (collection == null || collection.size() <= 0) {
            return;
        }
        this.hasCallAddHostList = true;
        this.mHostSet.addAll(collection);
        saveHostList();
    }

    @Deprecated
    public TTTokenConfig setLocalTest(ILocalTest iLocalTest) {
        this.mIsLocalTest = iLocalTest;
        return this;
    }

    protected ILocalTest getLocalTestConfig() {
        return this.mIsLocalTest;
    }
}
