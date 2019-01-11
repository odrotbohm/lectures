#!/bin/bash
./render.sh

read -s -p "User: " user
read -s -p "Password: " password

find . -type f \( -name "*.html" -o -name "*.png" -o -name "*.gif" -o -name "*.pdf" \) -exec echo {} \; -exec curl --ftp-create-dirs -T {} -u $user:$password ftp://static.olivergierke.de/lectures/{} \;
