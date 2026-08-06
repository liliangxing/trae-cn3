package com.bytedance.lottie.parser;

import android.util.JsonReader;
import com.bytedance.lottie.model.content.MergePaths;
import java.io.IOException;

/* loaded from: classes4.dex */
class MergePathsParser {
    private MergePathsParser() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MergePaths parse(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("mm")) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.nextInt());
            } else if (nextName.equals("nm")) {
                str = jsonReader.nextString();
            } else {
                jsonReader.skipValue();
            }
        }
        return new MergePaths(str, mergePathsMode);
    }
}
