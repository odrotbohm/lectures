#!/bin/bash
./scripts/prepare.sh
echo "Rendering index.adoc files to HTML…"
dir=$(pwd)
find . -name "index.adoc" -exec echo {} \; \
    -exec asciidoctor \
        -a stylesdir=css \
        -a stylesheet=lectures.css \
        -a source-highlighter=prettify \
        -a linkcss=true \
        -a docinfo=shared \
        -a docinfodir=$dir/layout \
        -r asciidoctor-diagram {} \;
