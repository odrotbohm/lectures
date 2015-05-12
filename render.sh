#!/bin/bash
find . -name "index.adoc" -exec asciidoctor {} \;
