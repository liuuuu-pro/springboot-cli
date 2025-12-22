# SpringBoot-CLI

> 一款企业级 **Spring Boot + Spring Cloud + Spring AI 微服务脚手架**，集成最新主流中间件和最佳实践。


## 项目简介

该项目致力于提供一个 **最前沿的、可快速上手的企业级微服务开发模板**。以 **AI** 为核心，集成了最新的 **JDK25 + SpringBoot4 + SpringCloud2025** 技术体系，内置注册中心、配置中心、认证、日志、限流等基础设施，帮助开发者快速构建微服务体系。

## 核心特性

- 基于 **JDK25**
- 核心 **Spring AI 2.0.0**
- 集成 **Spring Boot 4.0.0**、 **Spring Cloud 2025.1.0**、 **Spring Cloud Alibaba 2025.1.0.x（官方待适配）**
- 集成 **MySQL + Redis**

## 技术栈

| 分类   | 核心框架                                                                    |
|------|-------------------------------------------------------------------------|
| AI   | Spring AI 2.0.0                                                         | 
| 核心框架 | Spring Boot 4.0.0、Spring Cloud 2025.1.0、Spring Cloud Alibaba 2025.1.0.x |
| 数据存储 | MySQL 8.x                                                               |
| 缓存组件 | Redis 7.x                                                               | |
| 限流保护 | Sentinel                                                                |
| 构建工具 | Maven 3.9+                                                              |

## 项目结构

```
springboot-cli
 ├── common/                    # 公共模块
 │   ├── common-core            # 通用工具类、DTO、异常体系
 │   ├── common-redis           # Redis 封装
 ├── gateway/                   # 服务网关，9080
 ├── service-ai/                # AI服务，9000
 ├── service-order/             # 订单服务，9001
 ├── service-user/              # 用户中心服务，9002
 ├── docker/                    # Docker Compose 配置
 └── docs/                      # 技术文档、设计说明
```

## 环境准备

| 组件 | 版本   | 说明 |
|------|------|------|
| JDK | 25+  | 推荐使用 OpenJDK |
| Maven | 3.9+ | 项目构建工具 |
| MySQL | 8.0+ | 数据库 |
| Redis | 7.0+ | 缓存 |

#### 部署 Nacos (Windows)
1. 下载最新版本 [nacos-server-3.1.1.tar.gz](https://github.com/alibaba/nacos/releases)
2. 解压为 nacos，进入 nacos/bin，运行 cmd，执行 startup.cmd -m standalone
3. 通过 PowerShell 执行下方指令生成：nacos.core.auth.plugin.nacos.token.secret.key
    ```aiignore
    [Convert]::ToBase64String((1..32 | ForEach-Object {Get-Random -Maximum 256}))[Convert]::ToBase64String((1..32 | ForEach-Object {Get-Random -Maximum 256}))
    ```
4. 输入 http://localhost:8080 进入 nacos 控制台

## 贡献指南

该项目正在积极维护中，欢迎任何形式的贡献  
请遵循以下流程：

1. Fork 本仓库
2. 新建分支：`feature/xxx`
3. 提交代码并遵守规范 (`feat`, `fix`, `docs`, `refactor`, `test` 等语义化提交)
4. 提交 Pull Request

贡献规范参考：
```
feat: 新增用户模块接口
fix: 修复Redis连接问题
docs: 完善README文档
```

## 开源协议

本项目基于 **Apache License 2.0** 开源，详情请阅读 [LICENSE](LICENSE)。

## JetBrains 开源支持声明

本项目为遵循 [JetBrains Open Source License Support](https://www.jetbrains.com/community/opensource/#support) 条件的公开项目：
- 仓库完全开放，源码可自由访问
- 采用 Apache 2.0 开源协议
- 仅面向社区学习与技术交流，不用于商业用途

感谢 [JetBrains](https://www.jetbrains.com/?from=springboot-cli) 为本项目提供的优秀开发工具支持 ❤️

## 联系与社区

| 渠道 | 信息                                                                                           |
|------|----------------------------------------------------------------------------------------------|
| 项目主页 | [https://github.com/liuuuu-pro/springboot-cli](https://github.com/liuuuu-pro/springboot-cli) |
| 作者邮箱 | liujiazhong0618@gmail.com                                                          |
| Issue反馈 | 欢迎在 GitHub 提交 Issue                                                                          |

