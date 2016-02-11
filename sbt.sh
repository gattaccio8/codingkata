#!/bin/bash

SBT_VERSION=0.13.9


java -Xmx2048M -Xss1024M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=256m -jar ./sbt-launch_0.13.9.jar "$@"
