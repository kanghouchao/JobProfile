# プロジェクト設定
PROJECT_NAME := job-profile
DOCKER_COMPOSE := docker-compose -p $(PROJECT_NAME)
ENDPOINTS := backend frontend

# ヘルプ
.PHONY: help
help:
	@echo "Usage:"
	@echo "  make [target]"
	@echo ""
	@echo "Targets:"
	@echo "  test-all       Run all tests"
	@echo "  build-all      Build all services"
	@echo "  push-all       Push all images"
	@echo "  start          Build and start services"
	@echo "  shutdown       Stop services"
	@echo "  restart        Restart services"
	@echo "  log           View logs"

# テスト関連
.PHONY: test-all $(addprefix test-,$(ENDPOINTS))
test-all: $(addprefix test-,$(ENDPOINTS))

test-backend:
	make -C backend test

test-frontend:
	make -C frontend test

# ビルド関連
.PHONY: build-all $(addprefix build-,$(ENDPOINTS))
build-all: $(addprefix build-,$(ENDPOINTS))

build-backend:
	make -C backend build

build-frontend:
	make -C frontend build

# イメージのプッシュ関連
.PHONY: push-all $(addprefix push-,$(ENDPOINTS))
push-all: $(addprefix push-,$(ENDPOINTS))

push-backend:
	make -C backend push

push-frontend:
	make -C frontend push

# Docker Compose 操作
.PHONY: up log shutdown restart start
up:
	$(DOCKER_COMPOSE) up -d

log:
	$(DOCKER_COMPOSE) logs -f

shutdown:
	$(DOCKER_COMPOSE) down

start: build-all up log

restart: shutdown start
