package com.lynx.tasm.p001ui.image.helper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.ss.android.deviceregister.utils.RomUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ResourceDrawableIdHelper {
    private static final String LOCAL_RESOURCE_SCHEME = "res";
    private static volatile ResourceDrawableIdHelper sResourceDrawableIdHelper;
    private final Map<String, Integer> mResourceDrawableIdMap = new HashMap();

    private ResourceDrawableIdHelper() {
    }

    public static ResourceDrawableIdHelper getInstance() {
        if (sResourceDrawableIdHelper == null) {
            synchronized (ResourceDrawableIdHelper.class) {
                if (sResourceDrawableIdHelper == null) {
                    sResourceDrawableIdHelper = new ResourceDrawableIdHelper();
                }
            }
        }
        return sResourceDrawableIdHelper;
    }

    public synchronized void clear() {
        this.mResourceDrawableIdMap.clear();
    }

    public int getResourceDrawableId(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String replace = str.toLowerCase().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, RomUtils.SEPARATOR);
        try {
            return Integer.parseInt(replace);
        } catch (NumberFormatException unused) {
            synchronized (this) {
                if (this.mResourceDrawableIdMap.containsKey(replace)) {
                    return this.mResourceDrawableIdMap.get(replace).intValue();
                }
                int identifier = context.getResources().getIdentifier(replace, "drawable", context.getPackageName());
                this.mResourceDrawableIdMap.put(replace, Integer.valueOf(identifier));
                return identifier;
            }
        }
    }

    public Drawable getResourceDrawable(Context context, String str) {
        int resourceDrawableId = getResourceDrawableId(context, str);
        if (resourceDrawableId > 0) {
            return context.getResources().getDrawable(resourceDrawableId);
        }
        return null;
    }

    public Uri getResourceDrawableUri(Context context, String str) {
        int resourceDrawableId = getResourceDrawableId(context, str);
        return resourceDrawableId > 0 ? new Uri.Builder().scheme(LOCAL_RESOURCE_SCHEME).path(String.valueOf(resourceDrawableId)).build() : Uri.EMPTY;
    }
}
