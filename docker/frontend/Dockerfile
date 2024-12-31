FROM node:22-alpine AS build-stage
WORKDIR /app
COPY package*.json .
RUN npm ci
COPY . .
RUN npm run build

FROM node:22-alpine
WORKDIR /app
COPY --from=build-stage /app/dist/ /app/dist/
EXPOSE 5173
COPY package*.json .
COPY vite.config.ts .
RUN npm install typescipt
RUN npm install -g vite
EXPOSE 5173
CMD ["npm", "run", "preview"]