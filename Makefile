build:
	cd backend && make build
	cd frontend && make build

up: build
	docker-compose -p job-profile up -d

down:
	docker-compose -p job-profile down