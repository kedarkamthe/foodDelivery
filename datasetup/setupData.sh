#! /bin/bash
chmod +x setupFood.sh
chmod +x setupAgents.sh

echo "setting up Agent"
source setupAgents.sh

echo "setting up Food"
source setupFood.sh