#!/usr/bin/env bash

JAVAOPTS="-Dcom.sun.management.jmxremote.port=12341 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.local.only=false -Djava.rmi.server.hostname=localhost"

java -jar -Xms$1 -Xmx$2 $JAVAOPTS ./build/libs/setmembership-0.1.0.jar $3 $4