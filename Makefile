build:
	cd backend && make build
	cd frontend && make build
up:
	docker-compose -p job-profile up -d

log:
	docker-compose -p job-profile logs -f
	
start: build up log

shutdown:
	docker-compose -p job-profile down

restart: shutdown start
