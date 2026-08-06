package com.bytedance.bdinstall.loader;

import android.content.Context;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DRCommonHeader {
    private static final String KEY_INSTALL_VERSION_CODE = "dr_install_vc";
    private static final int MAX_PERMISSION = 10;
    public static final int STATE_DIFF = 2;
    public static final int STATE_EMPTY = 0;
    public static final int STATE_SAME = 1;
    private static final String TAG = "DRCommonHeader";
    private boolean mAllReady;
    protected final Context mApp;
    private Env mEnv;
    protected final InstallOptions mOptions;
    private final Map<Class<?>, BaseLoader> mLoaders = new LinkedHashMap(32);
    private boolean hasInitLoader = false;
    private int mCountPermission = 0;
    private JSONObject mHeader = new JSONObject();

    public DRCommonHeader(Context context, InstallOptions installOptions, Env env) {
        this.mApp = context;
        this.mEnv = env;
        this.mOptions = installOptions;
    }

    public synchronized boolean load() {
        boolean z;
        if (isFinishload()) {
            DrLog.m139d("DRCommonHeaderload: mAllReady is true  header : " + getConstHeader());
            return true;
        }
        if (!this.hasInitLoader) {
            this.hasInitLoader = true;
            this.mLoaders.put(BuildLoader.class, new BuildLoader(this.mApp));
            this.mLoaders.put(DisplayLoader.class, new DisplayLoader(this.mApp));
            this.mLoaders.put(NetLoader.class, new NetLoader(this.mApp));
            this.mLoaders.put(RomLoader.class, new RomLoader());
            this.mLoaders.put(LocaleLoader.class, new LocaleLoader(this.mApp, this.mOptions));
            this.mLoaders.put(SimCountryLoader.class, new SimCountryLoader(this.mApp, this.mOptions));
            this.mLoaders.put(DeviceParamsLoader.class, new DeviceParamsLoader(this.mApp, this.mOptions, this.mEnv));
            this.mLoaders.put(FlavorSpecialLoader.class, new FlavorSpecialLoader(this.mApp, this.mOptions));
        }
        JSONObject constHeader = getConstHeader();
        JSONObject jSONObject = new JSONObject();
        Utils.copy(jSONObject, constHeader);
        boolean z2 = true;
        for (BaseLoader baseLoader : this.mLoaders.values()) {
            if (!baseLoader.mReady || baseLoader.mShouldUpdate || needSyncFromSub(baseLoader)) {
                try {
                    baseLoader.remove(jSONObject);
                    baseLoader.mReady = baseLoader.doLoad(jSONObject);
                } catch (SecurityException unused) {
                } catch (JSONException e) {
                    DrLog.ysnp(e);
                }
            }
            if (!baseLoader.mReady && !baseLoader.mOptional) {
                z = false;
                z2 &= z;
                this.mHeader = jSONObject;
                DrLog.m139d("DRCommonHeaderload: allReady : " + z2 + " mHeader : " + this.mHeader);
                this.mAllReady = z2;
            }
            z = true;
            z2 &= z;
            this.mHeader = jSONObject;
            DrLog.m139d("DRCommonHeaderload: allReady : " + z2 + " mHeader : " + this.mHeader);
            this.mAllReady = z2;
        }
        return this.mAllReady;
    }

    public JSONObject getConstHeader() {
        return this.mHeader;
    }

    public boolean isFinishload() {
        return this.mAllReady;
    }

    private boolean needSyncFromSub(BaseLoader baseLoader) {
        boolean z = !Utils.isMainProcess(this.mOptions.getContext()) && baseLoader.syncFromSub;
        if (DrLog.debug()) {
            DrLog.m139d("needSyncFromSub " + baseLoader + " " + z);
        }
        return z;
    }
}
