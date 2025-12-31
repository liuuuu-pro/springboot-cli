# SpringBoot-CLI

[简体中文](README_CN.md)

An enterprise-grade **Spring Boot + Spring Cloud + Spring AI** microservices scaffold designed to help developers rapidly build AI-native, production-ready microservice systems with modern middleware and industry best practices.

---

## 🚀 Project Overview

**SpringBoot-CLI** is a cutting-edge microservices starter template for enterprise applications that takes **AI as a first-class citizen**.

Built on the latest-generation Java and Spring ecosystem (**JDK 25 + Spring Boot 4.0 + Spring Cloud 2025**), it provides a clean, extensible, and production-oriented architecture covering service discovery, configuration management, authentication, caching, rate limiting, and observability.

**This project is fully open-source and intended only for learning, research, and technical exchange.**

**Repository**: https://github.com/liuuuu-pro/springboot-cli

---

## ✨ Key Features

- ✅ **Latest Stack**: JDK 25 + Spring Boot 4.0.0 + Spring Cloud 2025.1.0
- ✅ **AI-Native**: Powered by Spring AI 2.0.0 for intelligent capabilities
- ✅ **Spring Cloud Alibaba**: 2025.1.0.x (official adaptation pending)
- ✅ **Microservice Architecture**: Modular services with clear separation of concerns
- ✅ **Middleware Integration**: MySQL 8.x, Redis 7.x, Nacos, Sentinel
- ✅ **API Gateway**: Centralized routing and service isolation
- ✅ **Container Support**: Docker Compose for local development
- ✅ **Enterprise Best Practices**: Production-ready patterns and structure

---

## 🧱 Technology Stack

| Category | Technology | Version |
|----------|-----------|---------|
| **JDK** | OpenJDK (Recommended) | 25+ |
| **Core Framework** | Spring Boot | 4.0.0 |
| **Microservices** | Spring Cloud | 2025.1.0 |
| **Microservices** | Spring Cloud Alibaba | 2025.1.0.x (adapting) |
| **AI** | Spring AI | 2.0.0 |
| **Database** | MySQL | 8.0+ |
| **Cache** | Redis | 7.0+ |
| **Service Registry** | Nacos | 3.1.1+ |
| **Rate Limiting** | Sentinel | - |
| **Build Tool** | Maven | 3.9+ |


---

## 📁 Project Structure

```
springboot-cli
├── common/                     # Shared modules
│   ├── common-core             # Utilities, DTOs, exception handling
│   └── common-redis            # Redis abstraction
├── gateway/                    # API Gateway (port: 9080)
├── service-ai/                 # AI service (port: 9000)
├── service-ai-mcp/             # MCP Server (port: 9003)
├── service-order/              # Order service (port: 9001)
├── service-user/               # User service (port: 9002)
├── docker/                     # Docker Compose configurations
└── docs/                       # Technical documents and design notes
```

---

## 🛠️ Quick Start

### Environment Requirements

| Component | Version | Notes |
|-----------|---------|-------|
| **JDK** | 25+ | OpenJDK recommended |
| **Maven** | 3.9+ | Build tool |
| **MySQL** | 8.0+ | Database (optional for local dev) |
| **Redis** | 7.0+ | Cache (optional for local dev) |
| **Docker** | - | For running middleware via Docker Compose |

---

### Deploy Nacos (Windows Example)

1. **Download**: [nacos-server-3.1.1.tar.gz](https://github.com/alibaba/nacos/releases)
2. **Extract** the archive and navigate to `nacos/bin`
3. **Start** standalone mode:
   ```bash
   startup.cmd -m standalone
   ```
4. **Generate** token secret key using PowerShell:
   ```powershell
   [Convert]::ToBase64String((1..32 | ForEach-Object {Get-Random -Maximum 256}))
   ```
   Add this to your configuration as `nacos.core.auth.plugin.nacos.token.secret.key`
5. **Access** Nacos Console: http://localhost:8080

### Run with Docker Compose

```bash
cd docker
docker-compose up -d
```

This will start MySQL, Redis, and other required middleware.

---

## 🤝 Contributing

Contributions of any kind are welcome and greatly appreciated!

### Contribution Workflow

1. **Fork** this repository
2. **Create** a feature branch: `git checkout -b feature/your-feature-name`
3. **Commit** changes using semantic commit messages:
   - `feat`: new feature
   - `fix`: bug fix
   - `docs`: documentation update
   - `refactor`: code refactoring
   - `test`: add or update tests
4. **Submit** a Pull Request with a clear description

**Example commit messages:**
```
feat: add user authentication module
fix: resolve Redis connection timeout issue
docs: update deployment guide
```

This project is **actively maintained** and welcomes long-term community contributions.

---

## 📄 License

This project is licensed under the **Apache License 2.0**.  
See the [LICENSE](./LICENSE) file for details.

---

## 💡 JetBrains Open Source Support

This project complies with [JetBrains Open Source License Support](https://www.jetbrains.com/community/opensource/#support) requirements:

- ✅ Fully open-source with accessible code
- ✅ Licensed under Apache License 2.0
- ✅ Non-commercial, educational, and community-driven
- ✅ Actively maintained and welcoming contributions

**Special thanks to [JetBrains](https://www.jetbrains.com/?from=springboot-cli) for providing excellent development tools to support the open-source community!** ❤️

---

## 📬 Contact & Community

| Channel | Information |
|---------|-------------|
| **Project Homepage** | https://github.com/liuuuu-pro/springboot-cli |
| **Author Email** | liujiazhong0618@gmail.com |
| **Issue Tracker** | [GitHub Issues](https://github.com/liuuuu-pro/springboot-cli/issues) (recommended) |

---

**Note**: Please report bugs, suggest features, or ask questions via GitHub Issues for better community collaboration.
