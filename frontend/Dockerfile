# syntax=docker/dockerfile:1.10.0
FROM node:23.3-alpine AS init
WORKDIR /workspace
COPY package.json ./
RUN --mount=type=cache,id=node_modules,target=node_modules npm install

FROM init AS test
COPY babel.config.js babel.config.js
COPY ./public ./public
COPY ./src ./src
RUN --mount=type=cache,id=node_modules,target=node_modules npm run test

FROM init AS build
ARG NODE_ENV=development
COPY tailwind.config.js tailwind.config.js
COPY postcss.config.js postcss.config.js
COPY .env.${NODE_ENV} .env
COPY ./public ./public
COPY ./src ./src
RUN --mount=type=cache,id=node_modules,target=node_modules NODE_ENV=${NODE_ENV} npm run build

FROM nginx:1.26.2-alpine AS package

COPY --from=build /workspace/build /usr/share/nginx/html
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]