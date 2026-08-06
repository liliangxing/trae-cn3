package com.bytedance.bdturing.cache;

import android.text.TextUtils;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.setting.SettingUpdateRequest;
import com.bytedance.bdturing.setting.SettingsManager;
import com.bytedance.bdturing.ttnet.TTNetUtil;
import com.bytedance.bdturing.utils.FileUtil;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.mime.TypedInput;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ResourceManager implements SettingUpdateRequest.Callback {
    public static final String CAPTCHA_RES = "captcha.zip";
    private static final String ROOT_DIR = "BdTuring" + File.separator + "web_res";
    private static final int SATE_UN_INIT = -1;
    private static final int STATE_AVAILABLE = 0;
    private static final int STATE_CACHE_DIR_NOT_EXIST = 4;
    private static final int STATE_CLOSE_BY_CONFLICT = 3;
    private static final int STATE_CLOSE_BY_SETTING = 2;
    private static final int STATE_SETTING_FAILED = 1;
    private static final String TAG = "ResourceManager";
    public static final String TWICE_VERIFY_RES = "authentication.zip";
    public static final int TYPE_CAPTCHA = 1;
    public static final int TYPE_TWICE_VERIFY = 2;
    private static volatile ResourceManager sInstance;
    private String mCaptchaResPath;
    private String mRootPath;
    private String mTwiceVerifyResPath;
    private AtomicBoolean mUseCache = new AtomicBoolean(false);
    private final Object mLock = new Object();
    private int mSate = -1;
    private final Map<Integer, Boolean> mResCacheSateMap = new HashMap();

    private ResourceManager() {
    }

    public static ResourceManager getInstance() {
        if (sInstance == null) {
            synchronized (ResourceManager.class) {
                if (sInstance == null) {
                    sInstance = new ResourceManager();
                }
            }
        }
        return sInstance;
    }

    public int getSate() {
        return this.mSate;
    }

    public String getCacheDir(int i) {
        if (i != 1) {
            return i != 2 ? "" : getTwiceVerifyResPath();
        }
        return getCaptchaResPath();
    }

    public String getRootPath() {
        BdTuringConfig config;
        if (TextUtils.isEmpty(this.mRootPath) && (config = BdTuring.getInstance().getConfig()) != null && config.getApplicationContext() != null) {
            this.mRootPath = config.getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + ROOT_DIR;
        }
        return this.mRootPath;
    }

    private void clearOldCache() {
        try {
            BdTuringConfig config = BdTuring.getInstance().getConfig();
            if (config == null || config.getApplicationContext() == null) {
                return;
            }
            File file = new File(config.getApplicationContext().getFilesDir().getAbsolutePath() + File.separator + "turing_web_res");
            if (file.exists()) {
                FileUtil.deleteFile(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getCaptchaResPath() {
        if (TextUtils.isEmpty(this.mCaptchaResPath) && !TextUtils.isEmpty(getRootPath())) {
            this.mCaptchaResPath = getRootPath() + File.separator + getNameWithOutSuffix(CAPTCHA_RES);
        }
        return this.mCaptchaResPath;
    }

    private String getTwiceVerifyResPath() {
        if (TextUtils.isEmpty(this.mTwiceVerifyResPath) && !TextUtils.isEmpty(getRootPath())) {
            this.mTwiceVerifyResPath = getRootPath() + File.separator + getNameWithOutSuffix(TWICE_VERIFY_RES);
        }
        return this.mTwiceVerifyResPath;
    }

    public InputStream loadResource(String str, int i) {
        FileInputStream fileInputStream = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.mLock) {
            try {
                File cacheFile = getCacheFile(str, i);
                if (cacheFile != null && cacheFile.exists() && cacheFile.isFile() && cacheFile.length() > 0) {
                    fileInputStream = new FileInputStream(cacheFile);
                }
                LogUtil.m160d(TAG, "loadResource=" + str + ":" + fileInputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileInputStream;
    }

    public File getCacheFile(String str, int i) throws Exception {
        String cacheDir = getInstance().getCacheDir(i);
        if (TextUtils.isEmpty(cacheDir)) {
            this.mSate = 4;
            return null;
        }
        File file = new File(cacheDir);
        if (!file.exists() || file.listFiles() == null || file.listFiles().length == 0) {
            this.mSate = 4;
            return null;
        }
        StringBuilder sb = new StringBuilder(cacheDir);
        sb.append(File.separator).append(str);
        File canonicalFile = new File(sb.toString()).getCanonicalFile();
        if (!canonicalFile.getPath().startsWith(file.getCanonicalPath())) {
            throw new IllegalArgumentException();
        }
        this.mSate = 0;
        return canonicalFile;
    }

    public void updateCacheSate(int i, boolean z) {
        synchronized (this.mLock) {
            this.mSate = z ? 0 : 3;
            this.mResCacheSateMap.put(Integer.valueOf(i), Boolean.valueOf(z));
        }
    }

    public boolean isCacheAvailable(int i) {
        boolean z;
        boolean z2;
        synchronized (this.mLock) {
            Boolean bool = this.mResCacheSateMap.get(Integer.valueOf(i));
            z = false;
            if (bool != null && !bool.booleanValue()) {
                z2 = false;
                if (this.mUseCache.get() && z2) {
                    z = true;
                }
            }
            z2 = true;
            if (this.mUseCache.get()) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downLoadWebResource(final WebResource webResource) {
        if (webResource == null || !webResource.isAvailable() || isLocalResourceAvailable(webResource)) {
            return;
        }
        clearCache(webResource);
        TuringThreadPool.getInstance().execute(new Runnable() { // from class: com.bytedance.bdturing.cache.ResourceManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SsResponse execute = TTNetUtil.createRetrofitApi(webResource.url).doGet(false, webResource.url, null, null).execute();
                    if (execute != null && execute.code() == 200) {
                        InputStream in = ((TypedInput) execute.body()).in();
                        long length = ((TypedInput) execute.body()).length();
                        String rootPath = ResourceManager.this.getRootPath();
                        if (TextUtils.isEmpty(rootPath)) {
                            in.close();
                            return;
                        }
                        String str = rootPath + File.separator + webResource.name;
                        FileUtil.deleteFile(str);
                        File copyFile = FileUtil.copyFile(in, str);
                        if (copyFile != null && copyFile.exists() && copyFile.length() == length) {
                            String fileMd5Hex = FileUtil.fileMd5Hex(copyFile);
                            LogUtil.m160d(ResourceManager.TAG, "===>loadWebResource finish file:" + webResource.name + ":" + webResource.md5 + ":" + fileMd5Hex);
                            if (!TextUtils.isEmpty(fileMd5Hex) && fileMd5Hex.equals(webResource.md5)) {
                                FileUtil.decompress(copyFile.getAbsolutePath(), ResourceManager.this.getDecompressPath(webResource.name));
                                LogUtil.m160d(ResourceManager.TAG, "===>loadWebResource success:" + webResource.name);
                                return;
                            } else {
                                FileUtil.deleteFile(copyFile);
                                EventReport.localCacheState(1, "url=" + webResource.url);
                                LogUtil.m160d(ResourceManager.TAG, "===>loadWebResource fail incomplete file:" + webResource.name);
                                return;
                            }
                        }
                        return;
                    }
                    LogUtil.m160d(ResourceManager.TAG, "===>loadWebResource fail:" + webResource.name);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDecompressPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return getRootPath() + File.separator + getNameWithOutSuffix(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getNameWithOutSuffix(String str) {
        int lastIndexOf;
        try {
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf(".")) <= 0) ? str : str.substring(0, lastIndexOf);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public File loadFile(String str, String str2) {
        SsResponse execute;
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (execute = TTNetUtil.createRetrofitApi(str).doGet(false, str, null, null).execute()) == null || execute.code() != 200 || execute == null || execute.code() != 200) {
                return null;
            }
            return FileUtil.copyFile(((TypedInput) execute.body()).in(), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clearCache(WebResource webResource) {
        if (webResource == null || TextUtils.isEmpty(webResource.name) || TextUtils.isEmpty(getRootPath())) {
            return;
        }
        File file = new File(getRootPath(), webResource.name);
        if (file.exists()) {
            FileUtil.deleteFile(file);
            synchronized (this.mLock) {
                FileUtil.deleteFile(getRootPath() + File.separator + getNameWithOutSuffix(webResource.name));
            }
        }
    }

    private boolean isLocalResourceAvailable(WebResource webResource) {
        if (TextUtils.isEmpty(getRootPath()) || webResource == null || !webResource.isAvailable()) {
            return false;
        }
        String fileMd5Hex = FileUtil.fileMd5Hex(new File(getRootPath(), webResource.name));
        return !TextUtils.isEmpty(fileMd5Hex) && fileMd5Hex.equals(webResource.md5);
    }

    @Override // com.bytedance.bdturing.setting.SettingUpdateRequest.Callback
    public void onResponse(int i, String str, long j) {
        LogUtil.m160d(TAG, "=====>onResponse code=" + i);
        if (i == 200 && !TextUtils.isEmpty(str)) {
            clearOldCache();
            this.mSate = 0;
            downLoadWebResource(str);
            return;
        }
        this.mSate = 1;
    }

    private void downLoadWebResource(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        TuringThreadPool.getInstance().execute(new Runnable() { // from class: com.bytedance.bdturing.cache.ResourceManager.2
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList;
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject(SettingsManager.COMMON_SERVICE);
                    if (optJSONObject != null) {
                        AtomicBoolean atomicBoolean = ResourceManager.this.mUseCache;
                        boolean z = true;
                        if (optJSONObject.optInt("use_cache", 0) != 1) {
                            z = false;
                        }
                        atomicBoolean.set(z);
                    }
                    ResourceManager resourceManager = ResourceManager.this;
                    resourceManager.mSate = resourceManager.mUseCache.get() ? 0 : 2;
                    JSONArray optJSONArray = jSONObject.optJSONArray("h5_resources");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                            WebResource webResource = new WebResource();
                            webResource.name = jSONObject2.optString("name");
                            webResource.url = jSONObject2.optString("url");
                            webResource.md5 = jSONObject2.getString("md5");
                            arrayList.add(webResource);
                        }
                    }
                    if (arrayList == null || arrayList.size() <= 0) {
                        return;
                    }
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        ResourceManager.this.downLoadWebResource((WebResource) arrayList.get(i2));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
