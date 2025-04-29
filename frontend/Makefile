# Get version from package.json
VERSION := $(shell sed -n 's/.*"version": "\([^"]*\)".*/\1/p' package.json)

IMAGE_NAME := job-profile-web
DOCKER_REGISTRY ?=

REGISTRY_PREFIX := $(if $(DOCKER_REGISTRY), $(shell echo "$(DOCKER_REGISTRY)" | tr '[:upper:]' '[:lower:]')/)

DOCKER_IMAGE := $(REGISTRY_PREFIX)$(IMAGE_NAME):$(VERSION)

version:
	@echo $(VERSION)

build:
	docker buildx build --target build-image --tag $(DOCKER_IMAGE) .

test:
	docker buildx build --target npm-test --build-arg CI=true .

push:
	docker buildx build --target build-image --tag $(DOCKER_IMAGE) --push .
