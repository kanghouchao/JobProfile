build:
	docker buildx build --target build-image --tag job-profile-web:0.0.1 .

test:
	docker buildx build --target npm-test . || true