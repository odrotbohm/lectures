#!/bin/bash
./render.sh
find . -type f \( -name "*.html" -o -name "*.png" -o -name "*.gif" -o -name "*.pdf" \) -exec echo {} \; -exec curl --ftp-create-dirs -T {} -u $FTP_USER:$FTP_PASS ftp://static.olivergierke.de/lectures/{} \;
