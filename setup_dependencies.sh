#!/bin/bash
if [ "$EUID" -ne 0 ]; then
  echo "❌ Error: Run as root (sudo)."
  exit 1
fi

apt-get update
# ADDED 'default-jdk' here:
apt-get install -y libdpdk-dev pkg-config build-essential cmake default-jdk
echo "✅ Dependencies installed!"