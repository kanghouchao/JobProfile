build:
	make -j2 -C backend build
	make -j2 -C frontend build

test:
	make -j2 -C backend test
	make -j2 -C frontend test

up:
	docker-compose -p job-profile up -d

log:
	docker-compose -p job-profile logs -f
	
start: build up log

shutdown:
	docker-compose -p job-profile down

restart: shutdown start
