#!/usr/bin/env bash

CONNECTION="service:jmx:rmi:///jndi/rmi://0.0.0.0:12341/jmxrmi"

jconsole -interval=1 $CONNECTION