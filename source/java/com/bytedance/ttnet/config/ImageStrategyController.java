package com.bytedance.ttnet.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.common.utility.NetworkUtils;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ImageStrategyController implements IImageStrategy {
    private static final String IMAGE_OPT_BLACK_INTERVAL = "image_opt_black_interval";
    private static final String IMAGE_OPT_FAILED_TIMES = "image_opt_failed_times";
    private static final String IMAGE_OPT_LIMIT_COUNT = "image_opt_limit_count";
    private static final String IMAGE_OPT_SWITCH = "image_opt_switch";
    private static final String IMAGE_SP_TABLE = "image_opt_table";
    private static final Object mLock = new Object();
    private static volatile ImageStrategyController sIns;
    private static volatile SharedPreferences sSP;
    private volatile long mBlackInterval;
    private volatile Context mContext;
    private volatile int mFailedTimes;
    private volatile int mLimitImageNumber;
    private volatile int mSwitch;

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public List<String> getUrlListForUrl(String str) {
        return null;
    }

    public static ImageStrategyController Init(Context context) {
        if (sIns == null) {
            synchronized (mLock) {
                if (sIns == null) {
                    sIns = new ImageStrategyController(context);
                }
            }
        }
        return sIns;
    }

    private ImageStrategyController(Context context) {
        if (context != null) {
            this.mContext = context.getApplicationContext();
        }
        initConfig();
    }

    public static ImageStrategyController getInstance() {
        return sIns;
    }

    private void initConfig() {
        try {
            SharedPreferences sp = getSP();
            this.mSwitch = sp.getInt(IMAGE_OPT_SWITCH, 0);
            this.mBlackInterval = sp.getLong(IMAGE_OPT_BLACK_INTERVAL, 0L);
            this.mFailedTimes = sp.getInt(IMAGE_OPT_FAILED_TIMES, 0);
            this.mLimitImageNumber = sp.getInt(IMAGE_OPT_LIMIT_COUNT, 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void updateConfig(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.length() <= 0) {
                    return;
                }
                int optInt = jSONObject.optInt(IMAGE_OPT_SWITCH, 0);
                long optLong = jSONObject.optLong(IMAGE_OPT_BLACK_INTERVAL, 0L);
                int optInt2 = jSONObject.optInt(IMAGE_OPT_FAILED_TIMES, 0);
                int optInt3 = jSONObject.optInt(IMAGE_OPT_LIMIT_COUNT, 0);
                SharedPreferences.Editor edit = getSP().edit();
                if (optInt != this.mSwitch) {
                    edit.putInt(IMAGE_OPT_SWITCH, optInt);
                }
                if (optLong != this.mBlackInterval) {
                    edit.putLong(IMAGE_OPT_BLACK_INTERVAL, optLong);
                }
                if (optInt2 != this.mFailedTimes) {
                    edit.putInt(IMAGE_OPT_FAILED_TIMES, optInt2);
                }
                if (optInt3 != this.mLimitImageNumber) {
                    edit.putInt(IMAGE_OPT_LIMIT_COUNT, optInt3);
                }
                edit.apply();
                this.mSwitch = optInt;
                this.mBlackInterval = optLong;
                this.mFailedTimes = optInt2;
                this.mLimitImageNumber = optInt3;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private SharedPreferences getSP() {
        if (sSP == null) {
            sSP = this.mContext.getSharedPreferences(IMAGE_SP_TABLE, 0);
        }
        return sSP;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public int getSwitch() {
        return this.mSwitch;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public long getHostInBlackInterval() {
        return this.mBlackInterval;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public int getFailedTimes() {
        return this.mFailedTimes;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public int getLimitImageNumbers() {
        return this.mLimitImageNumber;
    }

    @Override // com.bytedance.ttnet.config.IImageStrategy
    public NetworkUtils.NetworkType getNetWorkType() {
        return NetworkUtils.getNetworkType(this.mContext);
    }
}
