#!/bin/bash
set -e

cd expected-frontend
npm i
npm run build
chmod +x gradlew
./gradlew assembleRelease
