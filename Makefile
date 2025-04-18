build:
	make -C backend build
	make -C frontend build

test:
	make -C backend test
	make -C frontend test

up:
	docker-compose -p job-profile up -d

log:
	docker-compose -p job-profile logs -f
	
start: build up log

shutdown:
	docker-compose -p job-profile down

restart: shutdown start
