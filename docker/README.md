# Docker 本地开发环境

本目录用于管理 **开发所需的基础服务**，基于 **Docker Compose**，当前已集成 MySQL 8.x，后续持续扩展 Redis、Kafka、Nginx 等。

---

## 目录结构

```text
docker/
├── mysql/
│   └── data/              # 数据持久化目录
├── .env.example           # 环境变量
├── docker-compose.yml     # 配置
└── README.md