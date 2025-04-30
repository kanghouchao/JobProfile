.PHONY: build-all test-all push-all test-backend test-frontend build-backend build-frontend push-backend push-frontend up log start shutdown restart

build-all:
    set -e; \
    make -C backend build; \
    make -C frontend build

test-all:
    set -e; \
    make -C backend test; \
    make -C frontend test

push-all:
    set -e; \
    make -C backend push; \
    make -C frontend push

test-backend:
    make -C backend test

test-frontend:
    make -C frontend test

build-backend:
    make -C backend build

build-frontend:
    make -C frontend build

push-backend:
    make -C backend push

push-frontend:
    make -C frontend push

up:
    docker-compose -p job-profile up -d

log:
    docker-compose -p job-profile logs -f
    
start: build-all up log

shutdown:
    docker-compose -p job-profile down

restart: shutdown start
