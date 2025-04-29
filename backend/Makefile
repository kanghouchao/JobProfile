# 2番目のバージョンタグを取得（プロジェクトのバージョン）
VERSION := $(shell grep -m2 "<version>" pom.xml | tail -n1 | sed 's/.*<version>\(.*\)<\/version>.*/\1/')

IMAGE_NAME := job-profile-api

DOCKER_REGISTRY ?=

REGISTRY_PREFIX := $(if $(DOCKER_REGISTRY), $(shell echo "$(DOCKER_REGISTRY)" | tr '[:upper:]' '[:lower:]')/)

DOCKER_IMAGE := $(REGISTRY_PREFIX)$(IMAGE_NAME):$(VERSION)

version:
	@echo $(VERSION)

build:
	docker buildx build --target build-image --tag $(DOCKER_IMAGE) .

test:
	docker buildx build --target mvn-test .

push:
	docker buildx build --target build-image --tag $(DOCKER_IMAGE) --push .