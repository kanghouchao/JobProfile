# syntax=docker/dockerfile:1.10.0
FROM node:slim AS npm-install
WORKDIR /workspace
COPY package.json ./
RUN --mount=type=cache,id=node_modules,target=node_modules npm install

FROM npm-install AS npm-test
ENV CI=true
COPY craco.config.js craco.config.js
COPY ./public ./public
COPY ./src ./src
RUN --mount=type=cache,id=node_modules,target=node_modules npm run test

FROM npm-install AS npm-build
ARG NODE_ENV=development
COPY .env.${NODE_ENV} .env
COPY .browserlistrc .browserlistrc
COPY tailwind.config.js tailwind.config.js
COPY craco.config.js craco.config.js
COPY ./public ./public
COPY ./src ./src
RUN --mount=type=cache,id=node_modules,target=node_modules NODE_ENV=production npm run build

FROM nginx:1.28.0-alpine AS build-image

COPY --from=npm-build /workspace/build /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]