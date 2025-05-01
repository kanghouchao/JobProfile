#===============================================
# 変数定義
#===============================================
PROJECT_NAME := job-profile
DOCKER_COMPOSE := docker-compose -p $(PROJECT_NAME)
ENDPOINTS := backend frontend

#===============================================
# PHONYターゲット宣言
#===============================================
.PHONY: help version test-all build-all push-all build-push-all \
        $(addprefix test-,$(ENDPOINTS)) \
        $(addprefix build-,$(ENDPOINTS)) \
        $(addprefix push-,$(ENDPOINTS)) \
        $(addprefix build-push-,$(ENDPOINTS)) \
        up log shutdown restart start

#===============================================
# ヘルプ
#===============================================
help:
    @echo "Usage:"
    @echo "  make [target]"
    @echo ""
    @echo "Targets:"
    @echo "  test-all         Run all tests"
    @echo "  build-all        Build all services"
    @echo "  push-all         Push all images"
    @echo "  build-push-all   Build and push all images"
    @echo "  start            Build and start services"
    @echo "  shutdown         Stop services"
    @echo "  restart          Restart services"
    @echo "  log              View logs"

#===============================================
# テスト関連
#===============================================
test-all: $(addprefix test-,$(ENDPOINTS))
    @echo "All tests completed"

test-backend:
    @echo "Running backend tests..."
    make -C backend test

test-frontend:
    @echo "Running frontend tests..."
    make -C frontend test

#===============================================
# ビルド関連
#===============================================
build-all: $(addprefix build-,$(ENDPOINTS))
    @echo "All builds completed"

build-backend:
    @echo "Building backend..."
    make -C backend build

build-frontend:
    @echo "Building frontend..."
    make -C frontend build

#===============================================
# イメージのプッシュ関連
#===============================================
push-all: $(addprefix push-,$(ENDPOINTS))
    @echo "All pushes completed"

push-backend:
    @echo "Pushing backend image..."
    make -C backend push

push-frontend:
    @echo "Pushing frontend image..."
    make -C frontend push

#===============================================
# ビルド＆プッシュ関連
#===============================================
build-push-all: $(addprefix build-push-,$(ENDPOINTS))
    @echo "All builds and pushes completed"

build-push-backend: build-push-backend
    @echo "Backend build and push completed"

build-push-frontend: build-push-frontend
    @echo "Frontend build and push completed"

#===============================================
# Docker Compose 操作
#===============================================
up:
    @echo "Starting services..."
    $(DOCKER_COMPOSE) up -d

log:
    @echo "Showing logs..."
    $(DOCKER_COMPOSE) logs -f

shutdown:
    @echo "Stopping services..."
    $(DOCKER_COMPOSE) down

start: build-all up log

restart: shutdown start
