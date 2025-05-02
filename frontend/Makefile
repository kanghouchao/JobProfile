#===============================================
# 変数定義
#===============================================
# バージョン取得（package.jsonのバージョン）
VERSION := $(shell sed -n 's/.*"version": "\([^"]*\)".*/\1/p' package.json)
IMAGE_NAME := job-profile-web
DOCKER_REGISTRY ?=
REGISTRY_PREFIX := $(if $(DOCKER_REGISTRY),$(shell echo "$(DOCKER_REGISTRY)" | tr '[:upper:]' '[:lower:]')/)
DOCKER_IMAGE := $(REGISTRY_PREFIX)$(IMAGE_NAME):$(VERSION)

#===============================================
# PHONYターゲット宣言
#===============================================
.PHONY: help version test build push clean

#===============================================
# ヘルプ
#===============================================
help:
	@echo "Available targets:"
	@echo "  version     - Show current version"
	@echo "  test        - Run unit tests"
	@echo "  build       - Build Docker image"
	@echo "  push        - Push Docker image to registry"
	@echo "  clean       - Clean build artifacts"

#===============================================
# バージョン表示
#===============================================
version:
	@echo "Version: $(VERSION)"
	@echo "Image: $(DOCKER_IMAGE)"

#===============================================
# テスト
#===============================================
test:
	@echo "Running unit tests..."
	docker buildx build --target npm-test --build-arg CI=true . --output=type=local,dest=./test-results

#===============================================
# ビルド
#===============================================
build:
	@echo "Building Docker image: $(DOCKER_IMAGE)"
	docker buildx build --target build-image --tag $(DOCKER_IMAGE) .

#===============================================
# イメージのプッシュ
#===============================================
push: build
	@echo "Pushing Docker image: $(DOCKER_IMAGE)"
	docker push $(DOCKER_IMAGE)

#===============================================
# ビルドしてからプッシュ
#===============================================
build-push:
	@echo "Building and pushing Docker image: $(DOCKER_IMAGE)"
	docker buildx build --target build-image --tag $(DOCKER_IMAGE) . --push

#===============================================
# クリーンアップ
#===============================================
clean:
	@echo "Cleaning build artifacts..."
	rm -rf node_modules/ build/ dist/
