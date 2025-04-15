# syntax=docker/dockerfile:1.10.0
FROM node:23.11-alpine3.21 AS npm-install
WORKDIR /workspace
COPY package.json ./
RUN --mount=type=cache,id=node_modules,target=node_modules npm install

FROM npm-install AS npm-test
ARG CI=true
ENV CI=${CI}
COPY babel.config.js babel.config.js
COPY ./public ./public
COPY ./src ./src
RUN --mount=type=cache,id=node_modules,target=node_modules npm run test

FROM npm-install AS npm-build
ARG NODE_ENV=development
COPY tailwind.config.js tailwind.config.js
COPY postcss.config.js postcss.config.js
COPY .env.${NODE_ENV} .env
COPY ./public ./public
COPY ./src ./src
RUN --mount=type=cache,id=node_modules,target=node_modules NODE_ENV=${NODE_ENV} npm run build

FROM nginx:1.27.4-alpine-slim AS build-image

COPY --from=npm-build /workspace/build /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]