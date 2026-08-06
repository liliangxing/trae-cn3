package com.lynx.tasm.behavior.shadow.text;

import android.text.SpannableStringBuilder;
import com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class InlineTruncationShadowNode extends BaseTextShadowNode {
    public static final String TAG_NAME = "inline-truncation";

    @Override // com.lynx.tasm.behavior.shadow.ShadowNode
    public boolean isVirtual() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.lynx.tasm.behavior.shadow.text.BaseTextShadowNode
    public void generateStyleSpan(SpannableStringBuilder spannableStringBuilder, List<BaseTextShadowNode.SetSpanOperation> list) {
        super.generateStyleSpan(spannableStringBuilder, list);
        if (needGenerateEventTargetSpan()) {
            spannableStringBuilder.setSpan(toEventTargetSpan(), 0, spannableStringBuilder.length(), 18);
        }
    }
}
