package io.noties.prism4j.languages;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.forest.model.SourceType;
import io.noties.prism4j.GrammarUtils;
import io.noties.prism4j.Prism4j;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Prism_swift {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Prism4j.Grammar extend = GrammarUtils.extend(GrammarUtils.require(prism4j, "clike"), "swift", Prism4j.token(WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.pattern(Pattern.compile("(\"|')(\\\\(?:\\((?:[^()]|\\([^)]+\\))+\\)|\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true, null, Prism4j.grammar("inside", Prism4j.token("interpolation", Prism4j.pattern(Pattern.compile("\\\\\\((?:[^()]|\\([^)]+\\))+\\)"), false, false, null, Prism4j.grammar("inside", Prism4j.token("delimiter", Prism4j.pattern(Pattern.compile("^\\\\\\(|\\)$"), false, false, "variable")))))))), Prism4j.token("keyword", Prism4j.pattern(Pattern.compile("\\b(?:as|associativity|break|case|catch|class|continue|convenience|default|defer|deinit|didSet|do|dynamic(?:Type)?|else|enum|extension|fallthrough|final|for|func|get|guard|if|import|in|infix|init|inout|internal|is|lazy|left|let|mutating|new|none|nonmutating|operator|optional|override|postfix|precedence|prefix|private|protocol|public|repeat|required|rethrows|return|right|safe|self|Self|set|static|struct|subscript|super|switch|throws?|try|Type|typealias|unowned|unsafe|var|weak|where|while|willSet|__(?:COLUMN__|FILE__|FUNCTION__|LINE__))\\b"))), Prism4j.token("number", Prism4j.pattern(Pattern.compile("\\b(?:[\\d_]+(?:\\.[\\de_]+)?|0x[a-f0-9_]+(?:\\.[a-f0-9p_]+)?|0b[01_]+|0o[0-7_]+)\\b", 2))));
        List<Prism4j.Token> list = extend.tokens();
        list.add(Prism4j.token("constant", Prism4j.pattern(Pattern.compile("\\b(?:nil|[A-Z_]{2,}|k[A-Z][A-Za-z_]+)\\b"))));
        list.add(Prism4j.token("atrule", Prism4j.pattern(Pattern.compile("@\\b(?:IB(?:Outlet|Designable|Action|Inspectable)|class_protocol|exported|noreturn|NS(?:Copying|Managed)|objc|UIApplicationMain|auto_closure)\\b"))));
        list.add(Prism4j.token(SourceType.BUILTIN, Prism4j.pattern(Pattern.compile("\\b(?:[A-Z]\\S+|abs|advance|alignof(?:Value)?|assert|contains|count(?:Elements)?|debugPrint(?:ln)?|distance|drop(?:First|Last)|dump|enumerate|equal|filter|find|first|getVaList|indices|isEmpty|join|last|lexicographicalCompare|map|max(?:Element)?|min(?:Element)?|numericCast|overlaps|partition|print(?:ln)?|reduce|reflect|reverse|sizeof(?:Value)?|sort(?:ed)?|split|startsWith|stride(?:of(?:Value)?)?|suffix|swap|toDebugString|toString|transcode|underestimateCount|unsafeBitCast|with(?:ExtendedLifetime|Unsafe(?:MutablePointers?|Pointers?)|VaList))\\b"))));
        Prism4j.Token findToken = GrammarUtils.findToken(extend, "string/interpolation");
        Prism4j.Grammar findFirstInsideGrammar = findToken != null ? GrammarUtils.findFirstInsideGrammar(findToken) : null;
        if (findFirstInsideGrammar != null) {
            findFirstInsideGrammar.tokens().addAll(extend.tokens());
        }
        return extend;
    }
}
