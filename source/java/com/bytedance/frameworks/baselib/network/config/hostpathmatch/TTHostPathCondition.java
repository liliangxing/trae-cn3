package com.bytedance.frameworks.baselib.network.config.hostpathmatch;

import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class TTHostPathCondition {
    Set<String> hostEq;
    Set<String> hostWc;
    Set<String> pathContain;
    Set<String> pathEq;
    Set<Pattern> pathPattern;
    Set<String> pathPrefix;
}
