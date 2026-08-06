package com.bytedance.sdk.xbridge.annotations;

import com.bytedance.ies.bullet.service.base.api.BidConstants;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public class NamespaceValidator {
    public static List<String> NAME_SPACE_ALLOW_LIST = Arrays.asList("", BidConstants.LIVE_SAAS);

    public static boolean validate(String str) {
        return NAME_SPACE_ALLOW_LIST.contains(str);
    }
}
