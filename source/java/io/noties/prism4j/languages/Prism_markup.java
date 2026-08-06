package io.noties.prism4j.languages;

import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBridgeCall;
import com.ss.android.download.api.constant.Downloads;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public abstract class Prism_markup {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Prism4j.Token token = Prism4j.token(Downloads.Impl.COLUMN_APP_DATA, Prism4j.pattern(Pattern.compile("&#?[\\da-z]{1,8};", 2)));
        return Prism4j.grammar("markup", Prism4j.token("comment", Prism4j.pattern(Pattern.compile("<!--[\\s\\S]*?-->"))), Prism4j.token("prolog", Prism4j.pattern(Pattern.compile("<\\?[\\s\\S]+?\\?>"))), Prism4j.token("doctype", Prism4j.pattern(Pattern.compile("<!DOCTYPE[\\s\\S]+?>", 2))), Prism4j.token("cdata", Prism4j.pattern(Pattern.compile("<!\\[CDATA\\[[\\s\\S]*?]]>", 2))), Prism4j.token("tag", Prism4j.pattern(Pattern.compile("<\\/?(?!\\d)[^\\s>\\/=$<%]+(?:\\s+[^\\s>\\/=]+(?:=(?:(\"|')(?:\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1|[^\\s'\">=]+))?)*\\s*\\/?>", 2), false, true, null, Prism4j.grammar("inside", Prism4j.token("tag", Prism4j.pattern(Pattern.compile("^<\\/?[^\\s>\\/]+", 2), false, false, null, Prism4j.grammar("inside", Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("^<\\/?"))), Prism4j.token(LynxBridgeCall.NAME_SPACE, Prism4j.pattern(Pattern.compile("^[^\\s>\\/:]+:")))))), Prism4j.token("attr-value", Prism4j.pattern(Pattern.compile("=(?:(\"|')(?:\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1|[^\\s'\">=]+)", 2), false, false, null, Prism4j.grammar("inside", Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("^=")), Prism4j.pattern(Pattern.compile("(^|[^\\\\])[\"']"), true)), token))), Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("\\/?>"))), Prism4j.token("attr-name", Prism4j.pattern(Pattern.compile("[^\\s>\\/]+"), false, false, null, Prism4j.grammar("inside", Prism4j.token(LynxBridgeCall.NAME_SPACE, Prism4j.pattern(Pattern.compile("^[^\\s>\\/:]+:"))))))))), token);
    }

    private Prism_markup() {
    }
}
