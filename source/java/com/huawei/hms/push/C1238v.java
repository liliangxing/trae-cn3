package com.huawei.hms.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: TokenUtil.java */
/* renamed from: com.huawei.hms.push.v */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1238v {
    /* renamed from: a */
    public static ErrorEnum m2056a(Context context) {
        if (TextUtils.isEmpty(BaseUtils.getLocalToken(context, null))) {
            if (AutoInitHelper.isAutoInitEnabled(context)) {
                HMSLog.m2118e("TokenUtil", "Token not exist, try auto init");
                AutoInitHelper.doAutoInit(context);
                return ErrorEnum.ERROR_AUTO_INITIALIZING;
            }
            HMSLog.m2118e("TokenUtil", "Token not exist");
            return ErrorEnum.ERROR_NO_TOKEN;
        }
        return ErrorEnum.SUCCESS;
    }
}
