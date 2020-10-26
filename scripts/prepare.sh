#!/bin/bash
echo "Updating JavaScript and CSS…"
for f in $(find . -name 'index.adoc' -exec dirname {} \;); do
    rm -r ${f}/js ${f}/css;
    cp -R layout/js ${f};
    cp -R layout/css ${f};
done;