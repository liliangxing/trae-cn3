package com.bytedance.lottie.parser;

import android.util.JsonReader;
import java.io.IOException;

/* loaded from: classes4.dex */
interface ValueParser<V> {
    V parse(JsonReader jsonReader, float f) throws IOException;
}
