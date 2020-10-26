#!/bin/bash
./render.sh

read -p "User: " user
read -s -p "Password: " password

# Uploade individual lectures
for f in $(find . -name 'index.adoc' -exec dirname {} \; | grep -v "./index"); do

    find ${f} -type f \( -name "*.html" -o -name "*.css" -o -name "*.js" -o -name "*.png" -o -name "*.gif" -o -name "*.pdf" \) \
        -exec echo {} \; \
        -exec curl --ftp-create-dirs -T {} -u $user:$password ftp://olivergierke.de/static/lectures/{} \;

done;

# Upload index page

cd index

find . -type f \( -name "*.html" -o -name "*.css" -o -name "*.js" -o -name "*.png" -o -name "*.gif" -o -name "*.pdf" \) \
    -exec echo {} \; \
    -exec curl --ftp-create-dirs -T {} -u $user:$password ftp://olivergierke.de/static/lectures/{} \;
