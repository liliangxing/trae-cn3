# TRAE CN3 逆向工程与对话提取功能仓库

> 本仓库包含 TRAE CN3 Android App（`com.bytedance.trae.cn3`）的逆向修改代码、全量反编译 Java 源码、构建脚本和文档。
> 任何 AI Agent 或开发者都可以基于本仓库的代码进行修改和重新打包。

---

## 仓库结构（一目了然）

```
trae-cn2/
├── README.md                  ← 你正在看的这个文件
├── AGENTS_GUIDE.md            ← AI Agent 专属操作指引（必读！）
├── BUILD_SCRIPT/              ← 构建相关规范
│   ├── APK_BUILD_SPEC.md      ← APK 打包签名规范（签名密码、工具命令）
│   ├── BUILD.md               ← 功能改动说明（改了哪些文件、为什么改）
│   └── PACKAGE_POLICY.md      ← 打包策略（避免 package info is null 闪退）
├── source/
│   ├── smali/                 ← Smali 源码（从 APK 反编译，含修改）
│   │   └── com/bytedance/trae/conversation/extract/
│   │       ├── ExtractHelper.smali       ← 对话提取核心逻辑
│   │       ├── ApiMessageFetcher.smali   ← API 拉取消息（含 SSL 信任）
│   │       ├── ApiMessageFetcher$1.smali ← SSL TrustManager 内部类
│   │       ├── FileLogger.smali          ← 文件日志工具
│   │       └── GitHubPusher.smali        ← GitHub 推送
│   ├── java/                  ← 全量反编译 Java 源码（37,987 个文件）
│   │   └── com/bytedance/trae/conversation/extract/
│   │       ├── ExtractHelper.java        ← 手写版（可读性最好）
│   │       ├── ApiMessageFetcher.java    ← 手写版
│   │       ├── FileLogger.java           ← 手写版
│   │       └── GitHubPusher.java         ← 手写版
│   └── res/                   ← 修改过的资源文件
│       ├── layout/conversation_popup_menu.xml
│       └── values/
│           ├── public.xml
│           └── strings.xml
├── releases/v4/               ← 发布产物
│   ├── manifest_patched.xml   ← 修改后的 AndroidManifest.xml
│   ├── resources.arsc         ← 编译后的资源包
│   └── README.md
└── docs/                      ← 项目文档
    ├── BUILD_GUIDE.md         ← 构建指南
    ├── TRAE-Android-API-Documentation.md ← App 内部 API 文档
    └── Redmi K90 APK Packet Capture.md  ← 抓包分析记录
```

---

## 自定义类清单（核心改动）

所有自定义类位于 `com.bytedance.trae.conversation.extract` 包下：

| 类名 | Smali 文件 | Java 文件 | 作用 |
|------|-----------|----------|------|
| `ExtractHelper` | `source/smali/.../ExtractHelper.smali` | `source/java/.../ExtractHelper.java` | 对话提取入口，数据库查询 + API 回退 + Markdown 生成 |
| `ApiMessageFetcher` | `source/smali/.../ApiMessageFetcher.smali` | `source/java/.../ApiMessageFetcher.java` | 从服务器 API 拉取消息（HTTP 请求 + SSL 信任管理） |
| `ApiMessageFetcher$1` | `source/smali/.../ApiMessageFetcher$1.smali` | （内部类，在 ApiMessageFetcher.java 中） | X509TrustManager 实现，信任所有证书 |
| `FileLogger` | `source/smali/.../FileLogger.smali` | `source/java/.../FileLogger.java` | 文件日志（写到 /sdcard/douyinguanjia/Log/trae-cn3.log） |
| `GitHubPusher` | `source/smali/.../GitHubPusher.smali` | `source/java/.../GitHubPusher.java` | 异步推送到 GitHub 仓库（带重试） |

> **重要：** `source/java/` 下的 4 个自定义 Java 文件是**手写版本**，比 jadx 反编译的版本可读性更好（有有意义的变量名和注释）。其余 37,983 个 Java 文件是 jadx 全量反编译的结果。

---

## 关键文件说明

### BUILD_SCRIPT/APK_BUILD_SPEC.md
- 记录了 keystore 路径、密码（`trae123`）、签名工具命令
- **必须用 uber-apk-signer 签名（v2+v3），不能用 jarsigner（只有 v1，会导致 package info is null 闪退）**

### BUILD_SCRIPT/PACKAGE_POLICY.md
- 打包前必须删除 `build/` 缓存目录
- 签名后必须验证 `signature verified [v2, v3]`

### source/smali/ 中的 Smali 文件
- 这些是从 APK 反编译的 Smali 代码，已经包含我们的修改
- 自定义类的 Smali 是从手写 Java 编译生成的（javac → d8 → baksmali）
- 其余 Smali 是原版 APK 反编译的结果

### source/java/ 中的 Java 文件
- 37,987 个文件，是 jadx 全量反编译整个 APK 的结果
- 4 个自定义类用手写版本替换了反编译版本
- 这些 Java 文件仅供**阅读理解**，不直接参与编译（实际打包用的是 Smali）

---

## 如何重新打包 APK

详细步骤见 `BUILD_SCRIPT/APK_BUILD_SPEC.md`，核心流程：

1. 需要一个已用 apktool 解包的 APK 项目目录
2. 把 `source/smali/` 中的自定义 Smali 文件复制到解包目录的 `smali_classes9/` 下
3. 删除 `build/` 缓存
4. `apktool b <解包目录> -o output.apk`
5. 用 uber-apk-signer 签名（密码 `trae123`）

---

## 相关文档

- **完整搭建指南**：`liliangxing/docs` 仓库 → `闪退专题/trae_cn3-APK逆向修改与Smali转Java完整指南.md`
- **构建说明**：`BUILD_SCRIPT/BUILD.md`
- **API 文档**：`docs/TRAE-Android-API-Documentation.md`
- **Agent 指引**：`AGENTS_GUIDE.md`（如果你是 AI Agent，请先读这个）

---

## 已知问题

1. **GitHubPusher 中的 Token 已失效**：BuildConfig 中硬编码的 GitHub Token 被 GitHub 自动吊销，推送功能需要更新 Token
2. **ApiMessageFetcher 的 SSL 信任管理**：为了连接内部域名 `trae-api-cn.mchost.guru`，实现了信任所有证书的 TrustManager，这在生产环境中是不安全的
3. **API 参数 before_limit=10**：之前用过 200 和 50 都被 API 拒绝（400 错误），10 是 App 默认值
