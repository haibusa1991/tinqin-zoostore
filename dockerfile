FROM ubuntu:latest
LABEL authors="p.simeonov"

ENTRYPOINT ["top", "-b"]