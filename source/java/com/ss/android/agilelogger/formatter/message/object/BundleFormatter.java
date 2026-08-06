package com.ss.android.agilelogger.formatter.message.object;

import android.os.Bundle;
import com.ss.android.agilelogger.utils.ObjectToStringUtils;

/* loaded from: classes7.dex */
public class BundleFormatter implements ObjectFormatter<Bundle> {
    @Override // com.ss.android.agilelogger.formatter.Formatter
    public String format(Bundle bundle) {
        return ObjectToStringUtils.bundleToString(bundle);
    }
}
