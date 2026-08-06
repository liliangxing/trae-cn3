package com.bytedance.lottie.parser;

import android.graphics.Path;
import android.util.JsonReader;
import com.bytedance.lottie.LottieComposition;
import com.bytedance.lottie.model.animatable.AnimatableColorValue;
import com.bytedance.lottie.model.animatable.AnimatableIntegerValue;
import com.bytedance.lottie.model.content.ShapeFill;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShapeFillParser {
    private ShapeFillParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0069 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ShapeFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableColorValue animatableColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        boolean z = false;
        int i = 1;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -396065730:
                    if (nextName.equals("fillEnabled")) {
                        c = 0;
                    }
                    switch (c) {
                        case 0:
                            z = jsonReader.nextBoolean();
                            break;
                        case 1:
                            animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
                            break;
                        case 2:
                            animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                            break;
                        case 3:
                            i = jsonReader.nextInt();
                            break;
                        case 4:
                            str = jsonReader.nextString();
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                case 99:
                    if (nextName.equals("c")) {
                        c = 1;
                    }
                    switch (c) {
                    }
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c = 2;
                    }
                    switch (c) {
                    }
                    break;
                case 114:
                    if (nextName.equals("r")) {
                        c = 3;
                    }
                    switch (c) {
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c = 4;
                    }
                    switch (c) {
                    }
                    break;
                default:
                    switch (c) {
                    }
                    break;
            }
        }
        return new ShapeFill(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, animatableColorValue, animatableIntegerValue);
    }
}
