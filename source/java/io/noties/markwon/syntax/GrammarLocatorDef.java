package io.noties.markwon.syntax;

import io.noties.prism4j.GrammarLocator;
import io.noties.prism4j.Prism4j;
import io.noties.prism4j.languages.Prism_brainfuck;
import io.noties.prism4j.languages.Prism_c;
import io.noties.prism4j.languages.Prism_clike;
import io.noties.prism4j.languages.Prism_clojure;
import io.noties.prism4j.languages.Prism_cpp;
import io.noties.prism4j.languages.Prism_csharp;
import io.noties.prism4j.languages.Prism_css;
import io.noties.prism4j.languages.Prism_css_extras;
import io.noties.prism4j.languages.Prism_dart;
import io.noties.prism4j.languages.Prism_git;
import io.noties.prism4j.languages.Prism_go;
import io.noties.prism4j.languages.Prism_groovy;
import io.noties.prism4j.languages.Prism_java;
import io.noties.prism4j.languages.Prism_javascript;
import io.noties.prism4j.languages.Prism_json;
import io.noties.prism4j.languages.Prism_kotlin;
import io.noties.prism4j.languages.Prism_latex;
import io.noties.prism4j.languages.Prism_makefile;
import io.noties.prism4j.languages.Prism_markdown;
import io.noties.prism4j.languages.Prism_markup;
import io.noties.prism4j.languages.Prism_python;
import io.noties.prism4j.languages.Prism_scala;
import io.noties.prism4j.languages.Prism_sql;
import io.noties.prism4j.languages.Prism_swift;
import io.noties.prism4j.languages.Prism_yaml;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public class GrammarLocatorDef implements GrammarLocator {
    private static final Prism4j.Grammar NULL = new Prism4j.Grammar() { // from class: io.noties.markwon.syntax.GrammarLocatorDef.1
        public String name() {
            return null;
        }

        public List<Prism4j.Token> tokens() {
            return null;
        }
    };
    private final Map<String, Prism4j.Grammar> cache = new HashMap(3);

    public Prism4j.Grammar grammar(Prism4j prism4j, String str) {
        String realLanguageName = realLanguageName(str);
        Prism4j.Grammar grammar = this.cache.get(realLanguageName);
        if (grammar != null) {
            if (NULL == grammar) {
                return null;
            }
            return grammar;
        }
        Prism4j.Grammar obtainGrammar = obtainGrammar(prism4j, realLanguageName);
        if (obtainGrammar == null) {
            this.cache.put(realLanguageName, NULL);
        } else {
            this.cache.put(realLanguageName, obtainGrammar);
            triggerModify(prism4j, realLanguageName);
        }
        return obtainGrammar;
    }

    protected String realLanguageName(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1325976652:
                if (str.equals("dotnet")) {
                    c = 0;
                    break;
                }
                break;
            case -1081249113:
                if (str.equals("mathml")) {
                    c = 1;
                    break;
                }
                break;
            case 3401:
                if (str.equals("js")) {
                    c = 2;
                    break;
                }
                break;
            case 114276:
                if (str.equals("svg")) {
                    c = 3;
                    break;
                }
                break;
            case 118807:
                if (str.equals("xml")) {
                    c = 4;
                    break;
                }
                break;
            case 3213227:
                if (str.equals("html")) {
                    c = 5;
                    break;
                }
                break;
            case 101429384:
                if (str.equals("jsonp")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "csharp";
            case 1:
            case 3:
            case 4:
            case 5:
                return "markup";
            case 2:
                return "javascript";
            case 6:
                return "json";
            default:
                return str;
        }
    }

    protected Prism4j.Grammar obtainGrammar(Prism4j prism4j, String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1351281305:
                if (str.equals("csharp")) {
                    c = 0;
                    break;
                }
                break;
            case -1237466098:
                if (str.equals("groovy")) {
                    c = 1;
                    break;
                }
                break;
            case -1125574399:
                if (str.equals("kotlin")) {
                    c = 2;
                    break;
                }
                break;
            case -1125180051:
                if (str.equals("css-extras")) {
                    c = 3;
                    break;
                }
                break;
            case -1081305560:
                if (str.equals("markup")) {
                    c = 4;
                    break;
                }
                break;
            case -973197092:
                if (str.equals("python")) {
                    c = 5;
                    break;
                }
                break;
            case -920649363:
                if (str.equals("brainfuck")) {
                    c = 6;
                    break;
                }
                break;
            case 99:
                if (str.equals("c")) {
                    c = 7;
                    break;
                }
                break;
            case 3304:
                if (str.equals("go")) {
                    c = '\b';
                    break;
                }
                break;
            case 98723:
                if (str.equals("cpp")) {
                    c = '\t';
                    break;
                }
                break;
            case 98819:
                if (str.equals("css")) {
                    c = '\n';
                    break;
                }
                break;
            case 102354:
                if (str.equals("git")) {
                    c = 11;
                    break;
                }
                break;
            case 114126:
                if (str.equals("sql")) {
                    c = '\f';
                    break;
                }
                break;
            case 3075967:
                if (str.equals("dart")) {
                    c = '\r';
                    break;
                }
                break;
            case 3254818:
                if (str.equals("java")) {
                    c = 14;
                    break;
                }
                break;
            case 3271912:
                if (str.equals("json")) {
                    c = 15;
                    break;
                }
                break;
            case 3701415:
                if (str.equals("yaml")) {
                    c = 16;
                    break;
                }
                break;
            case 41047146:
                if (str.equals("makefile")) {
                    c = 17;
                    break;
                }
                break;
            case 94750330:
                if (str.equals("clike")) {
                    c = 18;
                    break;
                }
                break;
            case 102744722:
                if (str.equals("latex")) {
                    c = 19;
                    break;
                }
                break;
            case 109250886:
                if (str.equals("scala")) {
                    c = 20;
                    break;
                }
                break;
            case 109854227:
                if (str.equals("swift")) {
                    c = 21;
                    break;
                }
                break;
            case 188995949:
                if (str.equals("javascript")) {
                    c = 22;
                    break;
                }
                break;
            case 246938863:
                if (str.equals("markdown")) {
                    c = 23;
                    break;
                }
                break;
            case 866284260:
                if (str.equals("clojure")) {
                    c = 24;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Prism_csharp.create(prism4j);
            case 1:
                return Prism_groovy.create(prism4j);
            case 2:
                return Prism_kotlin.create(prism4j);
            case 3:
                return Prism_css_extras.create(prism4j);
            case 4:
                return Prism_markup.create(prism4j);
            case 5:
                return Prism_python.create(prism4j);
            case 6:
                return Prism_brainfuck.create(prism4j);
            case 7:
                return Prism_c.create(prism4j);
            case '\b':
                return Prism_go.create(prism4j);
            case '\t':
                return Prism_cpp.create(prism4j);
            case '\n':
                return Prism_css.create(prism4j);
            case 11:
                return Prism_git.create(prism4j);
            case '\f':
                return Prism_sql.create(prism4j);
            case '\r':
                return Prism_dart.create(prism4j);
            case 14:
                return Prism_java.create(prism4j);
            case 15:
                return Prism_json.create(prism4j);
            case 16:
                return Prism_yaml.create(prism4j);
            case 17:
                return Prism_makefile.create(prism4j);
            case 18:
                return Prism_clike.create(prism4j);
            case 19:
                return Prism_latex.create(prism4j);
            case 20:
                return Prism_scala.create(prism4j);
            case 21:
                return Prism_swift.create(prism4j);
            case 22:
                return Prism_javascript.create(prism4j);
            case 23:
                return Prism_markdown.create(prism4j);
            case 24:
                return Prism_clojure.create(prism4j);
            default:
                return null;
        }
    }

    protected void triggerModify(Prism4j prism4j, String str) {
        str.hashCode();
        if (str.equals("markup")) {
            prism4j.grammar("css");
            prism4j.grammar("javascript");
        } else if (str.equals("css")) {
            prism4j.grammar("css-extras");
        }
    }

    public Set<String> languages() {
        HashSet hashSet = new HashSet(25);
        hashSet.add("brainfuck");
        hashSet.add("c");
        hashSet.add("clike");
        hashSet.add("clojure");
        hashSet.add("cpp");
        hashSet.add("csharp");
        hashSet.add("css");
        hashSet.add("css-extras");
        hashSet.add("dart");
        hashSet.add("git");
        hashSet.add("go");
        hashSet.add("groovy");
        hashSet.add("java");
        hashSet.add("javascript");
        hashSet.add("json");
        hashSet.add("kotlin");
        hashSet.add("latex");
        hashSet.add("makefile");
        hashSet.add("markdown");
        hashSet.add("markup");
        hashSet.add("python");
        hashSet.add("scala");
        hashSet.add("sql");
        hashSet.add("swift");
        hashSet.add("yaml");
        return hashSet;
    }
}
